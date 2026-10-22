package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
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

            /* synthetic */ CategoryConfig(AnonymousClass1 r10) {
                this();
            }
        }

        static {
        }

        public ATrace(long r11) {
            this.mNativeTracingReady = new AtomicBoolean();
            this.mUiThreadReady = new AtomicBoolean();
            this.mTraceTagActive = new AtomicBoolean();
            Class<?> r10 = Class.forName("android.os.Trace");     // Catch: Exception -> L5
            this.mTraceClass = r10;     // Catch: Exception -> L5
            Class<?> r12 = Long.TYPE;     // Catch: Exception -> L5
            this.mIsTraceTagEnabledMethod = r10.getMethod("isTagEnabled", new Class[]{r12});     // Catch: Exception -> L5
            this.mTraceBeginMethod = this.mTraceClass.getMethod("traceBegin", new Class[]{r12, String.class});     // Catch: Exception -> L5
            this.mTraceEndMethod = this.mTraceClass.getMethod("traceEnd", new Class[]{r12});     // Catch: Exception -> L5
            Class<?> r13 = this.mTraceClass;     // Catch: Exception -> L5
            Class<?> r14 = Integer.TYPE;     // Catch: Exception -> L5
            this.mAsyncTraceBeginMethod = r13.getMethod("asyncTraceBegin", new Class[]{r12, String.class, r14});     // Catch: Exception -> L5
            this.mAsyncTraceEndMethod = this.mTraceClass.getMethod("asyncTraceEnd", new Class[]{r12, String.class, r14});     // Catch: Exception -> L5
            Class<?> r15 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L5
            this.mSystemPropertiesClass = r15;     // Catch: Exception -> L5
            this.mGetSystemPropertyMethod = r15.getMethod("get", new Class[]{String.class});     // Catch: Exception -> L5
        L7:
            this.mTraceTag = r11;
            pollConfig();
            return;
        L5:
            e = move-exception;
            Log.w(TAG, "Reflection error", new Object[]{e});
            this.mIsTraceTagEnabledMethod = null;
            goto L7
        }

        public static /* synthetic */ void a(ATrace r10) {
            r10.lambda$onNativeTracingReady$0();
        }

        public static /* synthetic */ void b(ATrace r10) {
            r10.lambda$onUiThreadReady$1();
        }

        private void disableNativeATrace() {
            TraceEventJni.get().stopATrace();
        }

        private void enableNativeATrace(String r10) {
            TraceEventJni.get().startATrace(r10);
        }

        private CategoryConfig getCategoryConfigFromATrace() {
            CategoryConfig r10 = new CategoryConfig(null);
            Integer r11 = getIntegerSystemProperty("debug.atrace.app_number");
            if (r11 != null) goto L5;
        L30:
            return r10;
        L5:
            if (r11.intValue() <= 0) goto L30;
            if (ContextUtils.getApplicationContext() == null) goto L30;
            String r12 = ContextUtils.getApplicationContext().getPackageName();
            int r13 = 0;
        L10:
            if (r13 >= r11.intValue()) goto L30;
            String r14 = getSystemProperty("debug.atrace.app_" + r13);
            if (r14 == null) goto L29;
            if (r14.startsWith(r12) == false) goto L29;
            String r15 = r14.substring(r12.length());
            if (r15.startsWith("/") == false) goto L29;
            String[] r16 = r15.substring(1).split(":");
            int r17 = r16.length;
            int r18 = 0;
        L20:
            if (r18 >= r17) goto L29;
            String r19 = r16[r18];
            if (r19.equals("-atrace") == false) goto L25;
            r10.shouldWriteToATrace = false;
        L28:
            r18 = r18 + 1;
            goto L20
        L25:
            if (r10.filter.length() <= 0) goto L27;
            r10.filter += ",";
        L27:
            r10.filter += r19;
        L29:
            r13 = r13 + 1;
            goto L10
        }

        private Integer getIntegerSystemProperty(String r10) {
            String r11 = getSystemProperty(r10);
            if (r11 != null) goto L8;
            return null;
        L8:
            return Integer.decode(r11);
        L7:
            return null;
        }

        @Nullable
        private String getSystemProperty(String r10) {
            return (String) this.mGetSystemPropertyMethod.invoke(this.mSystemPropertiesClass, new Object[]{r10});
        L4:
            return null;
        }

        private boolean isTraceTagEnabled(long r10) {
            return ((Boolean) this.mIsTraceTagEnabledMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(r10)})).booleanValue();
        L5:
            return false;
        }

        private /* synthetic */ void lambda$onNativeTracingReady$0() {
            pollConfig();
        }

        private /* synthetic */ void lambda$onUiThreadReady$1() {
            startPolling();
        }

        @UiThread
        private boolean pollConfig() {
            boolean r10 = this.mTraceTagActive.get();
            boolean r11 = isTraceTagEnabled(this.mTraceTag);
            if (r10 != r11) goto L5;
            return false;
        L5:
            this.mTraceTagActive.set(r11);
            if (r11 == true) goto L9;
            EarlyTraceEvent.disable();
            disableNativeATrace();
            this.mShouldWriteToSystemTrace = false;
            ThreadUtils.getUiThreadLooper().setMessageLogging(null);
            return true;
        L9:
            CategoryConfig r12 = getCategoryConfigFromATrace();
            this.mShouldWriteToSystemTrace = false;
            if (this.mNativeTracingReady.get() == false) goto L16;
            if (r12.shouldWriteToATrace == false) goto L14;
            enableNativeATrace(r12.filter);
        L20:
            if (r12.shouldWriteToATrace == true) goto L22;
            ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.access$000());
        L22:
            return true;
        L14:
            setupATraceStartupTrace(r12.filter);
            goto L20
        L16:
            if (r12.shouldWriteToATrace == false) goto L18;
            this.mShouldWriteToSystemTrace = true;
            goto L20
        L18:
            EarlyTraceEvent.enable();
            goto L20
        }

        private void setupATraceStartupTrace(String r10) {
            TraceEventJni.get().setupATraceStartupTrace(r10);
        }

        private void startPolling() {
            ThreadUtils.assertOnUiThread();
            if (this.mIdleHandlerRegistered == true) goto L5;
            Looper.myQueue().addIdleHandler(this);
            this.mIdleHandlerRegistered = true;
        L5:
            pollConfig();
        }

        public void asyncTraceBegin(String r10, int r11) {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mAsyncTraceBeginMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r10, Integer.valueOf(r11)});     // Catch: Exception -> L7
            return;
        }

        public void asyncTraceEnd(String r10, int r11) {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mAsyncTraceEndMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r10, Integer.valueOf(r11)});     // Catch: Exception -> L7
            return;
        }

        public boolean hasActiveSession() {
            return this.mTraceTagActive.get();
        }

        @AnyThread
        public void onNativeTracingReady() {
            this.mNativeTracingReady.set(true);
            this.mTraceTagActive.set(false);
            if (this.mUiThreadReady.get() == false) goto L6;
            ThreadUtils.postOnUiThread(new j(this));
            return;
        }

        @AnyThread
        public void onUiThreadReady() {
            this.mUiThreadReady.set(true);
            if (ThreadUtils.runningOnUiThread() == true) goto L6;
            ThreadUtils.postOnUiThread(new k(this));
            return;
        L6:
            startPolling();
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            pollConfig();
            return true;
        }

        public void traceBegin(String r10) {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mTraceBeginMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r10});     // Catch: Exception -> L7
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

    @VisibleForTesting(otherwise = 2)
    static class BasicLooperMonitor implements Printer {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @VisibleForTesting(otherwise = 2)
        static final String FILTERED_EVENT_NAME = "Looper.dispatch: EVENT_NAME_FILTERED";

        @VisibleForTesting(otherwise = 2)
        static final String LOOPER_TASK_PREFIX = "Looper.dispatch: ";
        private static final int SHORTEST_LOG_PREFIX_LENGTH = 0;
        private String mCurrentTarget;

        static {
            SHORTEST_LOG_PREFIX_LENGTH = 18;
        }

        BasicLooperMonitor() {
        }

        private static String getTarget(String r10) {
            int r11 = r10.indexOf(40, SHORTEST_LOG_PREFIX_LENGTH);
            if (r11 != (-1)) goto L5;
            int r12 = -1;
        L6:
            if (r12 != (-1)) goto L10;
            return "";
        L10:
            return r10.substring(r11 + 1, r12);
        L5:
            r12 = r10.indexOf(41, r11);
            goto L6
        }

        private static String getTargetName(String r10) {
            int r11 = r10.indexOf(125, SHORTEST_LOG_PREFIX_LENGTH);
            if (r11 != (-1)) goto L5;
            int r12 = -1;
        L6:
            if (r12 != (-1)) goto L8;
            r12 = r10.length();
        L8:
            if (r11 != (-1)) goto L12;
            return "";
        L12:
            return r10.substring(r11 + 2, r12);
        L5:
            r12 = r10.indexOf(58, r11);
            goto L6
        }

        @VisibleForTesting(otherwise = 2)
        static String getTraceEventName(String r10) {
            if (TraceEvent.access$300() == false) goto L7;
            return FILTERED_EVENT_NAME;
        L7:
            return LOOPER_TASK_PREFIX + getTarget(r10) + "(" + getTargetName(r10) + ")";
        }

        void beginHandling(String r10) {
            boolean r11 = EarlyTraceEvent.enabled();
            if (TraceEvent.access$200() == true) goto L5;
            if (r11 == true) goto L5;
            return;
        L5:
            this.mCurrentTarget = getTraceEventName(r10);
            if (TraceEvent.access$200() == false) goto L8;
            TraceEventJni.get().beginToplevel(this.mCurrentTarget);
            return;
        L8:
            EarlyTraceEvent.begin(this.mCurrentTarget, true);
        }

        void endHandling(String r10) {
            boolean r11 = EarlyTraceEvent.enabled();
            if (TraceEvent.access$200() == true) goto L6;
            if (r11 == true) goto L6;
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
        public void println(String r10) {
            if (r10.startsWith(">") == false) goto L5;
            beginHandling(r10);
            return;
        L5:
            endHandling(r10);
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

        /* synthetic */ IdleTracingLooperMonitor(AnonymousClass1 r10) {
            this();
        }

        private final void syncIdleMonitoring() {
            if (TraceEvent.access$200() == false) goto L9;
            if (this.mIdleMonitorAttached == true) goto L9;
            this.mLastIdleStartedAt = TimeUtils.elapsedRealtimeMillis();
            Looper.myQueue().addIdleHandler(this);
            this.mIdleMonitorAttached = true;
            String r10 = "attached idle handler";
        L7:
            android.util.Log.v(TAG, r10);
            return;
        L9:
            if (this.mIdleMonitorAttached == true) goto L11;
            return;
        L11:
            if (TraceEvent.access$200() == true) goto L15;
            Looper.myQueue().removeIdleHandler(this);
            this.mIdleMonitorAttached = false;
            r10 = "detached idle handler";
            goto L7
        }

        private static void traceAndLog(int r10, String r11) {
            TraceEvent.instant("TraceEvent.LooperMonitor:IdleStats", r11);
            android.util.Log.println(r10, TAG, r11);
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.BasicLooperMonitor
        final void beginHandling(String r10) {
            if (this.mNumTasksSinceLastIdle != 0) goto L5;
            TraceEvent.end(IDLE_EVENT_NAME);
        L5:
            this.mLastWorkStartedAt = TimeUtils.elapsedRealtimeMillis();
            syncIdleMonitoring();
            super.beginHandling(r10);
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.BasicLooperMonitor
        final void endHandling(String r10) {
            long r11 = TimeUtils.elapsedRealtimeMillis() - this.mLastWorkStartedAt;
            if (r11 <= 16) goto L5;
            traceAndLog(5, "observed a task that took " + r11 + "ms: " + r10);
        L5:
            super.endHandling(r10);
            syncIdleMonitoring();
            this.mNumTasksSeen++;
            this.mNumTasksSinceLastIdle++;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long r10 = TimeUtils.elapsedRealtimeMillis();
            if (this.mLastIdleStartedAt != 0) goto L5;
            this.mLastIdleStartedAt = r10;
        L5:
            long r11 = r10 - this.mLastIdleStartedAt;
            this.mNumIdlesSeen++;
            TraceEvent.begin(IDLE_EVENT_NAME, this.mNumTasksSinceLastIdle + " tasks since last idle.");
            if (r11 <= MIN_INTERESTING_BURST_DURATION_MILLIS) goto L8;
            traceAndLog(3, this.mNumTasksSeen + " tasks and " + this.mNumIdlesSeen + " idles processed so far, " + this.mNumTasksSinceLastIdle + " tasks bursted and " + r11 + "ms elapsed since last idle");
        L8:
            this.mLastIdleStartedAt = r10;
            this.mNumTasksSinceLastIdle = 0;
            return true;
        }
    }

    private static final class LooperMonitorHolder {
        private static final BasicLooperMonitor sInstance = null;

        static {
            if (CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_IDLE_TRACING) == false) goto L5;
            BasicLooperMonitor r10 = new IdleTracingLooperMonitor(null);
        L6:
            sInstance = r10;
            return;
        L5:
            r10 = new BasicLooperMonitor();
            goto L6
        }

        private LooperMonitorHolder() {
        }

        static /* synthetic */ BasicLooperMonitor access$000() {
            return sInstance;
        }
    }

    interface Natives {
        void addViewDump(int r10, int r11, boolean r12, boolean r13, String r14, String r15, long r16);

        void begin(String r10, String r11);

        void beginToplevel(String r10);

        void end(String r10, String r11);

        void endToplevel(String r10);

        void finishAsync(String r10, long r11);

        void initViewHierarchyDump();

        void instant(String r10, String r11);

        void instantAndroidIPC(String r10, long r11);

        void registerEnabledObserver();

        void setupATraceStartupTrace(String r10);

        void startATrace(String r10);

        long startActivityDump(String r10, long r11);

        void startAsync(String r10, long r11);

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

        public static /* synthetic */ void a() {
            lambda$updateEnabledState$0();
        }

        static /* synthetic */ void access$500(int r10, View r11, long r12) {
            dumpView(r10, r11, r12);
        }

        private static void disable() {
            ThreadUtils.assertOnUiThread();
            if (sEnabled == false) goto L6;
            Looper.myQueue().removeIdleHandler(sInstance);
            sEnabled = false;
            return;
        }

        private static void dumpView(int r10, View r11, long r12) {
            ThreadUtils.assertOnUiThread();
            int r13 = r11.getId();
        L10:
            String r14 = "__name_not_found__";
        L11:
            String r15 = r14;
            TraceEventJni.get().addViewDump(r13, r10, r11.isShown(), r11.isDirty(), r11.getClass().getSimpleName(), r15, r12);
            if ((r11 instanceof ViewGroup) == false) goto L17;
            ViewGroup r16 = (ViewGroup) r11;
            int r17 = 0;
        L15:
            if (r17 >= r16.getChildCount()) goto L21;
            dumpView(r13, r16.getChildAt(r17), r12);
            r17 = r17 + 1;
            goto L15
        L21:
            return;
        L17:
            return;
        L4:
            if (r11.getResources() == null) goto L8;
            if (r13 == 0) goto L7;
            r14 = r11.getResources().getResourceName(r13);     // Catch: Resources.NotFoundException -> L10
            goto L11
        L7:
            r14 = "__no_id__";
            goto L11
        L8:
            r14 = "__no_resources__";
            goto L11
        }

        private static void enable() {
            ThreadUtils.assertOnUiThread();
            if (sEnabled == true) goto L6;
            Looper.myQueue().addIdleHandler(sInstance);
            sEnabled = true;
            return;
        }

        private static /* synthetic */ void lambda$updateEnabledState$0() {
            updateEnabledState();
        }

        public static void updateEnabledState() {
            if (ThreadUtils.runningOnUiThread() == true) goto L7;
            ThreadUtils.postOnUiThread(l.f8417c);
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
            long r10 = TimeUtils.elapsedRealtimeMillis();
            long r11 = this.mLastDumpTs;
            if (r11 != 0) goto L5;
        L6:
            this.mLastDumpTs = r10;
            TraceEventJni.get().initViewHierarchyDump();
            return true;
        L5:
            if ((r10 - r11) > 1000) goto L6;
            return true;
        }
    }

    static {
        sNativeTracingReady = new AtomicBoolean();
        sUiThreadReady = new AtomicBoolean();
    }

    private TraceEvent(String r10, String r11) {
        this.mName = r10;
        begin(r10, r11);
    }

    static /* synthetic */ boolean access$200() {
        return sEnabled;
    }

    static /* synthetic */ boolean access$300() {
        return sEventNameFilteringEnabled;
    }

    public static void begin(String r10) {
        begin(r10, null);
    }

    public static void begin(String r10, String r11) {
        EarlyTraceEvent.begin(r10, false);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().begin(r10, r11);
        return;
    L5:
        ATrace r12 = sATrace;
        if (r12 == null) goto L10;
        r12.traceBegin(r10);
        return;
    }

    @CalledByNative
    public static void dumpViewHierarchy(long r10) {
        if (ApplicationStatus.isInitialized() == true) goto L5;
        return;
    L5:
        Iterator<Activity> r11 = ApplicationStatus.getRunningActivities().iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Activity r12 = r11.next();
        long r13 = TraceEventJni.get().startActivityDump(r12.getClass().getName(), r10);
        ViewHierarchyDumper.access$500(0, r12.getWindow().getDecorView().getRootView(), r13);
        goto L7
    }

    public static boolean enabled() {
        return sEnabled;
    }

    public static void end(String r10) {
        end(r10, null);
    }

    public static void end(String r10, String r11) {
        EarlyTraceEvent.end(r10, false);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().end(r10, r11);
        return;
    L5:
        ATrace r12 = sATrace;
        if (r12 == null) goto L10;
        r12.traceEnd();
        return;
    }

    public static boolean eventNameFilteringEnabled() {
        return sEventNameFilteringEnabled;
    }

    public static void finishAsync(String r10, long r11) {
        EarlyTraceEvent.finishAsync(r10, r11);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().finishAsync(r10, r11);
        return;
    L5:
        ATrace r12 = sATrace;
        if (r12 == null) goto L10;
        r12.asyncTraceEnd(r10, (int) r11);
        return;
    }

    public static void instant(String r10) {
        if (sEnabled == false) goto L6;
        TraceEventJni.get().instant(r10, null);
        return;
    }

    public static void instant(String r10, String r11) {
        if (sEnabled == false) goto L6;
        TraceEventJni.get().instant(r10, r11);
        return;
    }

    public static void instantAndroidIPC(String r10, long r11) {
        if (sEnabled == false) goto L6;
        TraceEventJni.get().instantAndroidIPC(r10, r11);
        return;
    }

    public static void maybeEnableEarlyTracing(long r10, boolean r11) {
        if (r11 == false) goto L5;
        EarlyTraceEvent.maybeEnableInBrowserProcess();
    L5:
        if (r10 == 0) goto L13;
        sATrace = new ATrace(r10);
        if (sNativeTracingReady.get() == false) goto L10;
        sATrace.onNativeTracingReady();
    L10:
        if (sUiThreadReady.get() == false) goto L13;
        sATrace.onUiThreadReady();
    L13:
        if (EarlyTraceEvent.enabled() == false) goto L20;
        ATrace r12 = sATrace;
        if (r12 != null) goto L17;
    L18:
        ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.access$000());
        return;
    L17:
        if (r12.hasActiveSession() == false) goto L18;
        return;
    }

    public static void onNativeTracingReady() {
        sNativeTracingReady.set(true);
        TraceEventJni.get().registerEnabledObserver();
        ATrace r10 = sATrace;
        if (r10 == null) goto L6;
        r10.onNativeTracingReady();
        return;
    }

    static void onUiThreadReady() {
        sUiThreadReady.set(true);
        ATrace r10 = sATrace;
        if (r10 == null) goto L6;
        r10.onUiThreadReady();
    L6:
        if (sEnabled == false) goto L9;
        ViewHierarchyDumper.updateEnabledState();
        return;
    }

    public static TraceEvent scoped(String r10) {
        return scoped(r10, null);
    }

    public static TraceEvent scoped(String r10, String r11) {
        if (EarlyTraceEvent.enabled() == true) goto L9;
        if (enabled() == true) goto L9;
        return null;
    L9:
        return new TraceEvent(r10, r11);
    }

    @CalledByNative
    public static void setEnabled(boolean r10) {
        if (r10 == false) goto L5;
        EarlyTraceEvent.disable();
    L5:
        if (sEnabled == r10) goto L16;
        sEnabled = r10;
        ATrace r11 = sATrace;
        if (r11 != null) goto L9;
    L10:
        Looper r12 = ThreadUtils.getUiThreadLooper();
        if (r10 == false) goto L13;
        BasicLooperMonitor r13 = LooperMonitorHolder.access$000();
    L14:
        r12.setMessageLogging(r13);
        goto L16
    L13:
        r13 = null;
        goto L14
    L9:
        if (r11.hasActiveSession() == false) goto L10;
    L16:
        if (sUiThreadReady.get() == false) goto L19;
        ViewHierarchyDumper.updateEnabledState();
        return;
    }

    @CalledByNative
    public static void setEventNameFilteringEnabled(boolean r10) {
        sEventNameFilteringEnabled = r10;
    }

    public static void startAsync(String r10, long r11) {
        EarlyTraceEvent.startAsync(r10, r11);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().startAsync(r10, r11);
        return;
    L5:
        ATrace r12 = sATrace;
        if (r12 == null) goto L10;
        r12.asyncTraceBegin(r10, (int) r11);
        return;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end(this.mName);
    }
}
