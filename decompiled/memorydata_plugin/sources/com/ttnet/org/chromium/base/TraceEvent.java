package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("base::android")
@MainDex
public class TraceEvent implements AutoCloseable {
    public static final long ATRACE_TAG_APP = 4096;
    public static final long ATRACE_TAG_WEBVIEW = 16;
    private static ATrace sATrace;
    private static volatile boolean sEnabled;
    private static boolean sEventNameFilteringEnabled;
    private static AtomicBoolean sNativeTracingReady;
    private static AtomicBoolean sUiThreadReady;
    private final String mName;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.TraceEvent$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ATrace implements MessageQueue.IdleHandler {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final String TAG = "ATrace";
        private Method mAsyncTraceBeginMethod;
        private Method mAsyncTraceEndMethod;
        private Method mGetSystemPropertyMethod;
        private boolean mIdleHandlerRegistered;
        private Method mIsTraceTagEnabledMethod;
        private final AtomicBoolean mNativeTracingReady;
        private boolean mShouldWriteToSystemTrace;
        private Class<?> mSystemPropertiesClass;
        private Method mTraceBeginMethod;
        private Class<?> mTraceClass;
        private Method mTraceEndMethod;
        private final long mTraceTag;
        private final AtomicBoolean mTraceTagActive;
        private final AtomicBoolean mUiThreadReady;

        private static class CategoryConfig {
            public String filter;
            public boolean shouldWriteToATrace;

            private CategoryConfig() {
                this.filter = "";
                this.shouldWriteToATrace = true;
            }

            /* synthetic */ CategoryConfig(AnonymousClass1 r1) {
                this();
            }
        }

        static {
        }

        public ATrace(long r10) {
            this.mNativeTracingReady = new AtomicBoolean();
            this.mUiThreadReady = new AtomicBoolean();
            this.mTraceTagActive = new AtomicBoolean();
            Class<?> r3 = ZeusTransformUtils.forName("android.os.Trace", "com.obric.memorydata.plugin");     // Catch: Exception -> L5
            this.mTraceClass = r3;     // Catch: Exception -> L5
            this.mIsTraceTagEnabledMethod = r3.getMethod("isTagEnabled", new Class[]{Long.TYPE});     // Catch: Exception -> L5
            this.mTraceBeginMethod = this.mTraceClass.getMethod("traceBegin", new Class[]{Long.TYPE, String.class});     // Catch: Exception -> L5
            this.mTraceEndMethod = this.mTraceClass.getMethod("traceEnd", new Class[]{Long.TYPE});     // Catch: Exception -> L5
            this.mAsyncTraceBeginMethod = this.mTraceClass.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L5
            this.mAsyncTraceEndMethod = this.mTraceClass.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});     // Catch: Exception -> L5
            Class<?> r0 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin");     // Catch: Exception -> L5
            this.mSystemPropertiesClass = r0;     // Catch: Exception -> L5
            this.mGetSystemPropertyMethod = r0.getMethod("get", new Class[]{String.class});     // Catch: Exception -> L5
        L7:
            this.mTraceTag = r10;
            pollConfig();
            return;
        L5:
            e = move-exception;
            Log.w(TAG, "Reflection error", new Object[]{e});
            this.mIsTraceTagEnabledMethod = null;
            goto L7
        }

        private void disableNativeATrace() {
            TraceEventJni.get().stopATrace();
        }

        private void enableNativeATrace(String r1) {
            TraceEventJni.get().startATrace(r1);
        }

        private CategoryConfig getCategoryConfigFromATrace() {
            CategoryConfig r0 = new CategoryConfig(null);
            Integer r1 = getIntegerSystemProperty("debug.atrace.app_number");
            if (r1 != null) goto L5;
        L30:
            return r0;
        L5:
            if (r1.intValue() <= 0) goto L30;
            if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L30;
            String r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName();
            int r4 = 0;
        L10:
            if (r4 >= r1.intValue()) goto L30;
            String r5 = getSystemProperty("debug.atrace.app_" + r4);
            if (r5 == null) goto L29;
            if (r5.startsWith(r2) == false) goto L29;
            String r6 = r5.substring(r2.length());
            if (r6.startsWith("/") == false) goto L29;
            String[] r7 = r6.substring(1).split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            int r8 = r7.length;
            int r9 = 0;
        L20:
            if (r9 >= r8) goto L29;
            String r10 = r7[r9];
            if (r10.equals("-atrace") == false) goto L25;
            r0.shouldWriteToATrace = false;
        L28:
            r9 = r9 + 1;
            goto L20
        L25:
            if (r0.filter.length() <= 0) goto L27;
            r0.filter += ",";
        L27:
            r0.filter += r10;
        L29:
            r4 = r4 + 1;
            goto L10
        }

        private Integer getIntegerSystemProperty(String r1) {
            String r0 = getSystemProperty(r1);
            if (r0 != null) goto L8;
            return null;
        L8:
            return Integer.decode(r0);
        L7:
            return null;
        }

        private String getSystemProperty(String r4) {
            return (String) ZeusTransformUtils.preCheckCast(this.mGetSystemPropertyMethod.invoke(this.mSystemPropertiesClass, new Object[]{r4}), String.class, "com.obric.memorydata.plugin");
        L4:
            return null;
        }

        private boolean isTraceTagEnabled(long r4) {
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.mIsTraceTagEnabledMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(r4)}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        L5:
            return false;
        }

        private boolean pollConfig() {
            boolean r0 = this.mTraceTagActive.get();
            boolean r1 = isTraceTagEnabled(this.mTraceTag);
            if (r0 != r1) goto L5;
            return false;
        L5:
            this.mTraceTagActive.set(r1);
            if (r1 == true) goto L9;
            EarlyTraceEvent.disable();
            disableNativeATrace();
            this.mShouldWriteToSystemTrace = false;
            ThreadUtils.getUiThreadLooper().setMessageLogging(null);
            return true;
        L9:
            CategoryConfig r2 = getCategoryConfigFromATrace();
            this.mShouldWriteToSystemTrace = false;
            if (this.mNativeTracingReady.get() == false) goto L16;
            if (r2.shouldWriteToATrace == false) goto L14;
            enableNativeATrace(r2.filter);
        L20:
            if (r2.shouldWriteToATrace == true) goto L22;
            ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.access$000());
        L22:
            return true;
        L14:
            setupATraceStartupTrace(r2.filter);
            goto L20
        L16:
            if (r2.shouldWriteToATrace == false) goto L18;
            this.mShouldWriteToSystemTrace = true;
            goto L20
        L18:
            EarlyTraceEvent.enable();
            goto L20
        }

        private void setupATraceStartupTrace(String r1) {
            TraceEventJni.get().setupATraceStartupTrace(r1);
        }

        private void startPolling() {
            ThreadUtils.assertOnUiThread();
            if (this.mIdleHandlerRegistered == true) goto L5;
            Looper.myQueue().addIdleHandler(this);
            this.mIdleHandlerRegistered = true;
        L5:
            pollConfig();
        }

        public void asyncTraceBegin(String r7, int r8) {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mAsyncTraceBeginMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r7, Integer.valueOf(r8)});     // Catch: Exception -> L7
            return;
        }

        public void asyncTraceEnd(String r7, int r8) {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mAsyncTraceEndMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r7, Integer.valueOf(r8)});     // Catch: Exception -> L7
            return;
        }

        public boolean hasActiveSession() {
            return this.mTraceTagActive.get();
        }

        public /* synthetic */ void lambda$onNativeTracingReady$0$TraceEvent$ATrace() {
            pollConfig();
        }

        public /* synthetic */ void lambda$onUiThreadReady$1$TraceEvent$ATrace() {
            startPolling();
        }

        public void onNativeTracingReady() {
            this.mNativeTracingReady.set(true);
            this.mTraceTagActive.set(false);
            if (this.mUiThreadReady.get() == false) goto L6;
            ThreadUtils.postOnUiThread(new $$Lambda$TraceEvent$ATrace$4DuWoc4Q084rsdEHxWV0pFWbiHE(this));
            return;
        }

        public void onUiThreadReady() {
            this.mUiThreadReady.set(true);
            if (ThreadUtils.runningOnUiThread() == true) goto L6;
            ThreadUtils.postOnUiThread(new $$Lambda$TraceEvent$ATrace$KycSHB56BRcah8i9gdOSAWj31k(this));
            return;
        L6:
            startPolling();
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            pollConfig();
            return true;
        }

        public void traceBegin(String r7) {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mTraceBeginMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r7});     // Catch: Exception -> L7
            return;
        }

        public void traceEnd() {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mTraceEndMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag)});     // Catch: Exception -> L7
            return;
        }
    }

    static class BasicLooperMonitor implements Printer {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final String FILTERED_EVENT_NAME = "Looper.dispatch: EVENT_NAME_FILTERED";
        static final String LOOPER_TASK_PREFIX = "Looper.dispatch: ";
        private static final int SHORTEST_LOG_PREFIX_LENGTH = 0;
        private String mCurrentTarget;

        static {
            SHORTEST_LOG_PREFIX_LENGTH = 18;
        }

        BasicLooperMonitor() {
        }

        private static String getTarget(String r3) {
            int r0 = r3.indexOf(40, SHORTEST_LOG_PREFIX_LENGTH);
            if (r0 != (-1)) goto L5;
            int r2 = -1;
        L6:
            if (r2 != (-1)) goto L10;
            return "";
        L10:
            return r3.substring(r0 + 1, r2);
        L5:
            r2 = r3.indexOf(41, r0);
            goto L6
        }

        private static String getTargetName(String r3) {
            int r0 = r3.indexOf(125, SHORTEST_LOG_PREFIX_LENGTH);
            if (r0 != (-1)) goto L5;
            int r2 = -1;
        L6:
            if (r2 != (-1)) goto L8;
            r2 = r3.length();
        L8:
            if (r0 != (-1)) goto L12;
            return "";
        L12:
            return r3.substring(r0 + 2, r2);
        L5:
            r2 = r3.indexOf(58, r0);
            goto L6
        }

        static String getTraceEventName(String r2) {
            if (TraceEvent.access$300() == false) goto L7;
            return FILTERED_EVENT_NAME;
        L7:
            return LOOPER_TASK_PREFIX + getTarget(r2) + "(" + getTargetName(r2) + ")";
        }

        void beginHandling(String r3) {
            boolean r0 = EarlyTraceEvent.enabled();
            if (TraceEvent.access$200() == true) goto L5;
            if (r0 == true) goto L5;
            return;
        L5:
            this.mCurrentTarget = getTraceEventName(r3);
            if (TraceEvent.access$200() == false) goto L8;
            TraceEventJni.get().beginToplevel(this.mCurrentTarget);
            return;
        L8:
            EarlyTraceEvent.begin(this.mCurrentTarget, true);
        }

        void endHandling(String r2) {
            boolean r3 = EarlyTraceEvent.enabled();
            if (TraceEvent.access$200() == true) goto L6;
            if (r3 == true) goto L6;
        L11:
            this.mCurrentTarget = null;
            return;
        L6:
            if (this.mCurrentTarget == null) goto L11;
            if (TraceEvent.access$200() == false) goto L10;
            TraceEventJni.get().endToplevel(this.mCurrentTarget);
            goto L11
        L10:
            EarlyTraceEvent.end(this.mCurrentTarget, true);
            goto L11
        }

        @Override // android.util.Printer
        public void println(String r2) {
            if (r2.startsWith(">") == false) goto L5;
            beginHandling(r2);
            return;
        L5:
            endHandling(r2);
        }
    }

    private static final class IdleTracingLooperMonitor extends BasicLooperMonitor implements MessageQueue.IdleHandler {
        private static final long FRAME_DURATION_MILLIS = 16;
        private static final String IDLE_EVENT_NAME = "Looper.queueIdle";
        private static final long MIN_INTERESTING_BURST_DURATION_MILLIS = 48;
        private static final long MIN_INTERESTING_DURATION_MILLIS = 16;
        private static final String TAG = "TraceEvent_LooperMonitor";
        private boolean mIdleMonitorAttached;
        private long mLastIdleStartedAt;
        private long mLastWorkStartedAt;
        private int mNumIdlesSeen;
        private int mNumTasksSeen;
        private int mNumTasksSinceLastIdle;

        private IdleTracingLooperMonitor() {
        }

        /* synthetic */ IdleTracingLooperMonitor(AnonymousClass1 r1) {
            this();
        }

        private final void syncIdleMonitoring() {
            if (TraceEvent.access$200() == false) goto L9;
            if (this.mIdleMonitorAttached == true) goto L9;
            this.mLastIdleStartedAt = TimeUtils.elapsedRealtimeMillis();
            Looper.myQueue().addIdleHandler(this);
            this.mIdleMonitorAttached = true;
            String r4 = "attached idle handler";
        L7:
            android.util.Log.v(TAG, r4);
            return;
        L9:
            if (this.mIdleMonitorAttached == true) goto L11;
            return;
        L11:
            if (TraceEvent.access$200() == true) goto L15;
            Looper.myQueue().removeIdleHandler(this);
            this.mIdleMonitorAttached = false;
            r4 = "detached idle handler";
            goto L7
        }

        private static void traceAndLog(int r1, String r2) {
            TraceEvent.instant("TraceEvent.LooperMonitor:IdleStats", r2);
            android.util.Log.println(r1, TAG, r2);
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.BasicLooperMonitor
        final void beginHandling(String r3) {
            if (this.mNumTasksSinceLastIdle != 0) goto L5;
            TraceEvent.end(IDLE_EVENT_NAME);
        L5:
            this.mLastWorkStartedAt = TimeUtils.elapsedRealtimeMillis();
            syncIdleMonitoring();
            super.beginHandling(r3);
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.BasicLooperMonitor
        final void endHandling(String r6) {
            long r0 = TimeUtils.elapsedRealtimeMillis() - this.mLastWorkStartedAt;
            if (r0 <= 16) goto L5;
            traceAndLog(5, "observed a task that took " + r0 + "ms: " + r6);
        L5:
            super.endHandling(r6);
            syncIdleMonitoring();
            this.mNumTasksSeen++;
            this.mNumTasksSinceLastIdle++;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long r0 = TimeUtils.elapsedRealtimeMillis();
            if (this.mLastIdleStartedAt != 0) goto L5;
            this.mLastIdleStartedAt = r0;
        L5:
            long r2 = r0 - this.mLastIdleStartedAt;
            this.mNumIdlesSeen++;
            TraceEvent.begin(IDLE_EVENT_NAME, this.mNumTasksSinceLastIdle + " tasks since last idle.");
            if (r2 <= MIN_INTERESTING_BURST_DURATION_MILLIS) goto L8;
            traceAndLog(3, this.mNumTasksSeen + " tasks and " + this.mNumIdlesSeen + " idles processed so far, " + this.mNumTasksSinceLastIdle + " tasks bursted and " + r2 + "ms elapsed since last idle");
        L8:
            this.mLastIdleStartedAt = r0;
            this.mNumTasksSinceLastIdle = 0;
            return true;
        }
    }

    private static final class LooperMonitorHolder {
        private static final BasicLooperMonitor sInstance = null;

        static {
            if (CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_IDLE_TRACING) == false) goto L5;
            BasicLooperMonitor r0 = new IdleTracingLooperMonitor(null);
        L6:
            sInstance = r0;
            return;
        L5:
            r0 = new BasicLooperMonitor();
            goto L6
        }

        private LooperMonitorHolder() {
        }

        static /* synthetic */ BasicLooperMonitor access$000() {
            return sInstance;
        }
    }

    interface Natives {
        void addViewDump(int r1, int r2, boolean r3, boolean r4, String r5, String r6, long r7);

        void begin(String r1, String r2);

        void beginToplevel(String r1);

        void end(String r1, String r2);

        void endToplevel(String r1);

        void finishAsync(String r1, long r2);

        void initViewHierarchyDump();

        void instant(String r1, String r2);

        void instantAndroidIPC(String r1, long r2);

        void registerEnabledObserver();

        void setupATraceStartupTrace(String r1);

        void startATrace(String r1);

        long startActivityDump(String r1, long r2);

        void startAsync(String r1, long r2);

        void stopATrace();

        boolean viewHierarchyDumpEnabled();
    }

    private static final class ViewHierarchyDumper implements MessageQueue.IdleHandler {
        private static final String EVENT_NAME = "TraceEvent.ViewHierarchyDumper";
        private static final long MIN_VIEW_DUMP_INTERVAL_MILLIS = 1000;
        private static boolean sEnabled;
        private static ViewHierarchyDumper sInstance;
        private long mLastDumpTs;

        private ViewHierarchyDumper() {
        }

        static /* synthetic */ void access$500(int r0, View r1, long r2) {
            dumpView(r0, r1, r2);
        }

        private static void disable() {
            ThreadUtils.assertOnUiThread();
            if (sEnabled == false) goto L6;
            Looper.myQueue().removeIdleHandler(sInstance);
            sEnabled = false;
            return;
        }

        private static void dumpView(int r11, View r12, long r13) {
            ThreadUtils.assertOnUiThread();
            int r10 = r12.getId();
        L10:
            String r1 = "__name_not_found__";
        L11:
            String r7 = r1;
            TraceEventJni.get().addViewDump(r10, r11, r12.isShown(), r12.isDirty(), r12.getClass().getSimpleName(), r7, r13);
            if (ZeusTransformUtils.instanceOf(r12, ViewGroup.class) == false) goto L17;
            ViewGroup r14 = (ViewGroup) ZeusTransformUtils.preCheckCast(r12, ViewGroup.class, "com.obric.memorydata.plugin");
            int r15 = 0;
        L15:
            if (r15 >= r14.getChildCount()) goto L21;
            dumpView(r10, r14.getChildAt(r15), r13);
            r15 = r15 + 1;
            goto L15
        L21:
            return;
        L17:
            return;
        L4:
            if (ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin") == null) goto L8;
            if (r10 == 0) goto L7;
            r1 = ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r10);     // Catch: Resources.NotFoundException -> L10
            goto L11
        L7:
            r1 = "__no_id__";
            goto L11
        L8:
            r1 = "__no_resources__";
            goto L11
        }

        private static void enable() {
            ThreadUtils.assertOnUiThread();
            if (sEnabled == true) goto L6;
            Looper.myQueue().addIdleHandler(sInstance);
            sEnabled = true;
            return;
        }

        static /* synthetic */ void lambda$updateEnabledState$0() {
            updateEnabledState();
        }

        public static void updateEnabledState() {
            if (ThreadUtils.runningOnUiThread() == true) goto L7;
            ThreadUtils.postOnUiThread($$Lambda$TraceEvent$ViewHierarchyDumper$YLNfRrh2TZfapUEf1cVVped3ic.INSTANCE);
            return;
        L7:
            if (TraceEventJni.get().viewHierarchyDumpEnabled() == false) goto L13;
            if (sInstance != null) goto L11;
            sInstance = new ViewHierarchyDumper();
        L11:
            enable();
            return;
        L13:
            if (sInstance == null) goto L17;
            disable();
            return;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long r0 = TimeUtils.elapsedRealtimeMillis();
            long r2 = this.mLastDumpTs;
            if (r2 != 0) goto L5;
        L6:
            this.mLastDumpTs = r0;
            TraceEventJni.get().initViewHierarchyDump();
            return true;
        L5:
            if ((r0 - r2) > 1000) goto L6;
            return true;
        }
    }

    static {
        sNativeTracingReady = new AtomicBoolean();
        sUiThreadReady = new AtomicBoolean();
    }

    private TraceEvent(String r1, String r2) {
        this.mName = r1;
        begin(r1, r2);
    }

    static /* synthetic */ boolean access$200() {
        return sEnabled;
    }

    static /* synthetic */ boolean access$300() {
        return sEventNameFilteringEnabled;
    }

    public static void begin(String r1) {
        begin(r1, null);
    }

    public static void begin(String r1, String r2) {
        EarlyTraceEvent.begin(r1, false);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().begin(r1, r2);
        return;
    L5:
        ATrace r3 = sATrace;
        if (r3 == null) goto L10;
        r3.traceBegin(r1);
        return;
    }

    public static void dumpViewHierarchy(long r6) {
        if (ApplicationStatus.isInitialized() == true) goto L5;
        return;
    L5:
        Iterator<Activity> r0 = ApplicationStatus.getRunningActivities().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(r0.next(), Activity.class, "com.obric.memorydata.plugin");
        long r4 = TraceEventJni.get().startActivityDump(r1.getClass().getName(), r6);
        ViewHierarchyDumper.access$500(0, ZeusTransformUtils.getWindow(r1, "com.obric.memorydata.plugin").getDecorView().getRootView(), r4);
        goto L7
    }

    public static boolean enabled() {
        return sEnabled;
    }

    public static void end(String r1) {
        end(r1, null);
    }

    public static void end(String r1, String r2) {
        EarlyTraceEvent.end(r1, false);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().end(r1, r2);
        return;
    L5:
        ATrace r3 = sATrace;
        if (r3 == null) goto L10;
        r3.traceEnd();
        return;
    }

    public static boolean eventNameFilteringEnabled() {
        return sEventNameFilteringEnabled;
    }

    public static void finishAsync(String r1, long r2) {
        EarlyTraceEvent.finishAsync(r1, r2);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().finishAsync(r1, r2);
        return;
    L5:
        ATrace r0 = sATrace;
        if (r0 == null) goto L10;
        r0.asyncTraceEnd(r1, (int) r2);
        return;
    }

    public static void instant(String r2) {
        if (sEnabled == false) goto L6;
        TraceEventJni.get().instant(r2, null);
        return;
    }

    public static void instant(String r1, String r2) {
        if (sEnabled == false) goto L6;
        TraceEventJni.get().instant(r1, r2);
        return;
    }

    public static void instantAndroidIPC(String r1, long r2) {
        if (sEnabled == false) goto L6;
        TraceEventJni.get().instantAndroidIPC(r1, r2);
        return;
    }

    public static void maybeEnableEarlyTracing(long r2, boolean r4) {
        if (r4 == false) goto L5;
        EarlyTraceEvent.maybeEnableInBrowserProcess();
    L5:
        if (r2 == 0) goto L13;
        sATrace = new ATrace(r2);
        if (sNativeTracingReady.get() == false) goto L10;
        sATrace.onNativeTracingReady();
    L10:
        if (sUiThreadReady.get() == false) goto L13;
        sATrace.onUiThreadReady();
    L13:
        if (EarlyTraceEvent.enabled() == false) goto L20;
        ATrace r3 = sATrace;
        if (r3 != null) goto L17;
    L18:
        ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.access$000());
        return;
    L17:
        if (r3.hasActiveSession() == false) goto L18;
        return;
    }

    public static void onNativeTracingReady() {
        sNativeTracingReady.set(true);
        TraceEventJni.get().registerEnabledObserver();
        ATrace r0 = sATrace;
        if (r0 == null) goto L6;
        r0.onNativeTracingReady();
        return;
    }

    static void onUiThreadReady() {
        sUiThreadReady.set(true);
        ATrace r0 = sATrace;
        if (r0 == null) goto L6;
        r0.onUiThreadReady();
    L6:
        if (sEnabled == false) goto L9;
        ViewHierarchyDumper.updateEnabledState();
        return;
    }

    public static TraceEvent scoped(String r1) {
        return scoped(r1, null);
    }

    public static TraceEvent scoped(String r1, String r2) {
        if (EarlyTraceEvent.enabled() == true) goto L9;
        if (enabled() == true) goto L9;
        return null;
    L9:
        return new TraceEvent(r1, r2);
    }

    public static void setEnabled(boolean r1) {
        if (r1 == false) goto L5;
        EarlyTraceEvent.disable();
    L5:
        if (sEnabled == r1) goto L16;
        sEnabled = r1;
        ATrace r0 = sATrace;
        if (r0 != null) goto L9;
    L10:
        Looper r2 = ThreadUtils.getUiThreadLooper();
        if (r1 == false) goto L13;
        BasicLooperMonitor r3 = LooperMonitorHolder.access$000();
    L14:
        r2.setMessageLogging(r3);
        goto L16
    L13:
        r3 = null;
        goto L14
    L9:
        if (r0.hasActiveSession() == false) goto L10;
    L16:
        if (sUiThreadReady.get() == false) goto L19;
        ViewHierarchyDumper.updateEnabledState();
        return;
    }

    public static void setEventNameFilteringEnabled(boolean r0) {
        sEventNameFilteringEnabled = r0;
    }

    public static void startAsync(String r1, long r2) {
        EarlyTraceEvent.startAsync(r1, r2);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().startAsync(r1, r2);
        return;
    L5:
        ATrace r0 = sATrace;
        if (r0 == null) goto L10;
        r0.asyncTraceBegin(r1, (int) r2);
        return;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end(this.mName);
    }
}
