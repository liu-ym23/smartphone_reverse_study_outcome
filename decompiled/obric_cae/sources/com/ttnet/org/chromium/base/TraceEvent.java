package com.ttnet.org.chromium.base;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Printer;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
public class TraceEvent implements AutoCloseable {
    private static volatile boolean sATraceEnabled;
    private static volatile boolean sEnabled;
    private final String mName;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.TraceEvent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BasicLooperMonitor implements Printer {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final String LOOPER_TASK_PREFIX = "Looper.dispatch: ";
        private static final int SHORTEST_LOG_PREFIX_LENGTH = 18;
        private String mCurrentTarget;

        private BasicLooperMonitor() {
        }

        public /* synthetic */ BasicLooperMonitor(AnonymousClass1 r8) {
            this();
        }

        private static String getTarget(String r8) {
            int r10 = r8.indexOf(40, SHORTEST_LOG_PREFIX_LENGTH);
            if (r10 != (-1)) goto L5;
            int r11 = -1;
        L6:
            if (r11 != (-1)) goto L10;
            return "";
        L10:
            return r8.substring(r10 + 1, r11);
        L5:
            r11 = r8.indexOf(41, r10);
            goto L6
        }

        private static String getTargetName(String r8) {
            int r10 = r8.indexOf(125, SHORTEST_LOG_PREFIX_LENGTH);
            if (r10 != (-1)) goto L5;
            int r11 = -1;
        L6:
            if (r11 != (-1)) goto L8;
            r11 = r8.length();
        L8:
            if (r10 != (-1)) goto L12;
            return "";
        L12:
            return r8.substring(r10 + 2, r11);
        L5:
            r11 = r8.indexOf(58, r10);
            goto L6
        }

        private static String getTraceEventName(String r8) {
            StringBuilder r10 = new StringBuilder(LOOPER_TASK_PREFIX);
            r10.append(getTarget(r8));
            r10.append("(");
            return android.aimedia.a.i(r10, getTargetName(r8), ")");
        }

        public void beginHandling(String r8) {
            boolean r10 = EarlyTraceEvent.isActive();
            if (TraceEvent.access$000() == true) goto L5;
            if (r10 == true) goto L5;
            return;
        L5:
            this.mCurrentTarget = getTraceEventName(r8);
            boolean r11 = TraceEvent.access$000();
            String r12 = this.mCurrentTarget;
            if (r11 == false) goto L8;
            TraceEvent.access$100(r12);
            return;
        L8:
            EarlyTraceEvent.begin(r12);
        }

        public void endHandling(String r8) {
            boolean r10 = EarlyTraceEvent.isActive();
            if (TraceEvent.access$000() == true) goto L6;
            if (r10 == true) goto L6;
        L11:
            this.mCurrentTarget = null;
            return;
        L6:
            if (this.mCurrentTarget == null) goto L11;
            if (TraceEvent.access$000() == false) goto L10;
            TraceEvent.access$200(this.mCurrentTarget);
            goto L11
        L10:
            EarlyTraceEvent.end(this.mCurrentTarget);
            goto L11
        }

        @Override // android.util.Printer
        public void println(String r8) {
            if (r8.startsWith(">") == false) goto L5;
            beginHandling(r8);
            return;
        L5:
            endHandling(r8);
        }
    }

    public static final class IdleTracingLooperMonitor extends BasicLooperMonitor implements MessageQueue.IdleHandler {
        private static final long FRAME_DURATION_MILLIS = 16;
        private static final String IDLE_EVENT_NAME = "Looper.queueIdle";
        private static final long MIN_INTERESTING_BURST_DURATION_MILLIS = 48;
        private static final long MIN_INTERESTING_DURATION_MILLIS = 16;
        private static final String TAG = "TraceEvent.LooperMonitor";
        private boolean mIdleMonitorAttached;
        private long mLastIdleStartedAt;
        private long mLastWorkStartedAt;
        private int mNumIdlesSeen;
        private int mNumTasksSeen;
        private int mNumTasksSinceLastIdle;

        private IdleTracingLooperMonitor() {
            super(null);
        }

        private final void syncIdleMonitoring() {
            if (TraceEvent.access$000() == false) goto L9;
            if (this.mIdleMonitorAttached == true) goto L9;
            this.mLastIdleStartedAt = SystemClock.elapsedRealtime();
            Looper.myQueue().addIdleHandler(this);
            this.mIdleMonitorAttached = true;
            String r8 = "attached idle handler";
        L7:
            android.util.Log.v(TAG, r8);
            return;
        L9:
            if (this.mIdleMonitorAttached == true) goto L11;
            return;
        L11:
            if (TraceEvent.access$000() == true) goto L15;
            Looper.myQueue().removeIdleHandler(this);
            this.mIdleMonitorAttached = false;
            r8 = "detached idle handler";
            goto L7
        }

        private static void traceAndLog(int r8, String r10) {
            TraceEvent.instant("TraceEvent.LooperMonitor:IdleStats", r10);
            android.util.Log.println(r8, TAG, r10);
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.BasicLooperMonitor
        public final void beginHandling(String r8) {
            if (this.mNumTasksSinceLastIdle != 0) goto L5;
            TraceEvent.end(IDLE_EVENT_NAME);
        L5:
            this.mLastWorkStartedAt = SystemClock.elapsedRealtime();
            syncIdleMonitoring();
            super.beginHandling(r8);
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.BasicLooperMonitor
        public final void endHandling(String r8) {
            long r10 = SystemClock.elapsedRealtime() - this.mLastWorkStartedAt;
            if (r10 <= 16) goto L5;
            traceAndLog(5, "observed a task that took " + r10 + "ms: " + r8);
        L5:
            super.endHandling(r8);
            syncIdleMonitoring();
            this.mNumTasksSeen++;
            this.mNumTasksSinceLastIdle++;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long r8 = SystemClock.elapsedRealtime();
            if (this.mLastIdleStartedAt != 0) goto L5;
            this.mLastIdleStartedAt = r8;
        L5:
            long r10 = r8 - this.mLastIdleStartedAt;
            this.mNumIdlesSeen++;
            TraceEvent.begin(IDLE_EVENT_NAME, this.mNumTasksSinceLastIdle + " tasks since last idle.");
            if (r10 <= MIN_INTERESTING_BURST_DURATION_MILLIS) goto L8;
            traceAndLog(3, this.mNumTasksSeen + " tasks and " + this.mNumIdlesSeen + " idles processed so far, " + this.mNumTasksSinceLastIdle + " tasks bursted and " + r10 + "ms elapsed since last idle");
        L8:
            this.mLastIdleStartedAt = r8;
            this.mNumTasksSinceLastIdle = 0;
            return true;
        }

        public /* synthetic */ IdleTracingLooperMonitor(AnonymousClass1 r8) {
            this();
        }
    }

    public static final class LooperMonitorHolder {
        private static final BasicLooperMonitor sInstance = null;

        static {
            AnonymousClass1 r8 = null;
            if (CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_IDLE_TRACING) == false) goto L5;
            BasicLooperMonitor r10 = new IdleTracingLooperMonitor(r8);
        L6:
            sInstance = r10;
            return;
        L5:
            r10 = new BasicLooperMonitor(r8);
            goto L6
        }

        private LooperMonitorHolder() {
        }

        public static /* synthetic */ BasicLooperMonitor access$500() {
            return sInstance;
        }
    }

    private TraceEvent(String r8, String r10) {
        this.mName = r8;
        begin(r8, r10);
    }

    public static /* synthetic */ boolean access$000() {
        return sEnabled;
    }

    public static /* synthetic */ void access$100(String r8) {
        nativeBeginToplevel(r8);
    }

    public static /* synthetic */ void access$200(String r8) {
        nativeEndToplevel(r8);
    }

    public static void begin(String r8) {
        begin(r8, null);
    }

    public static boolean enabled() {
        return sEnabled;
    }

    public static void end(String r8) {
        end(r8, null);
    }

    public static void finishAsync(String r8, long r10) {
        EarlyTraceEvent.finishAsync(r8, r10);
        if (sEnabled == false) goto L6;
        nativeFinishAsync(r8, r10);
        return;
    }

    public static void instant(String r8) {
        if (sEnabled == false) goto L6;
        nativeInstant(r8, null);
        return;
    }

    public static void maybeEnableEarlyTracing() {
        EarlyTraceEvent.maybeEnable();
        if (EarlyTraceEvent.isActive() == false) goto L6;
        ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.access$500());
        return;
    }

    private static native void nativeBegin(String r8, String r10);

    private static native void nativeBeginToplevel(String r8);

    private static native void nativeEnd(String r8, String r10);

    private static native void nativeEndToplevel(String r8);

    private static native void nativeFinishAsync(String r8, long r10);

    private static native void nativeInstant(String r8, String r10);

    private static native void nativeRegisterEnabledObserver();

    private static native void nativeStartATrace();

    private static native void nativeStartAsync(String r8, long r10);

    private static native void nativeStopATrace();

    public static void registerNativeEnabledObserver() {
        nativeRegisterEnabledObserver();
    }

    public static TraceEvent scoped(String r8) {
        return scoped(r8, null);
    }

    public static void setATraceEnabled(boolean r8) {
        if (sATraceEnabled != r8) goto L5;
        return;
    L5:
        sATraceEnabled = r8;
        if (r8 == false) goto L8;
        nativeStartATrace();
        return;
    L8:
        nativeStopATrace();
    }

    @CalledByNative
    public static void setEnabled(boolean r8) {
        if (r8 == false) goto L5;
        EarlyTraceEvent.disable();
    L5:
        if (sEnabled == r8) goto L15;
        sEnabled = r8;
        if (sATraceEnabled == false) goto L9;
        return;
    L9:
        Looper r10 = ThreadUtils.getUiThreadLooper();
        if (r8 == false) goto L12;
        BasicLooperMonitor r11 = LooperMonitorHolder.access$500();
    L13:
        r10.setMessageLogging(r11);
        return;
    L12:
        r11 = null;
        goto L13
    }

    public static void startAsync(String r8, long r10) {
        EarlyTraceEvent.startAsync(r8, r10);
        if (sEnabled == false) goto L6;
        nativeStartAsync(r8, r10);
        return;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end(this.mName);
    }

    public static void begin(String r8, String r10) {
        EarlyTraceEvent.begin(r8);
        if (sEnabled == false) goto L6;
        nativeBegin(r8, r10);
        return;
    }

    public static void end(String r8, String r10) {
        EarlyTraceEvent.end(r8);
        if (sEnabled == false) goto L6;
        nativeEnd(r8, r10);
        return;
    }

    public static void instant(String r8, String r10) {
        if (sEnabled == false) goto L6;
        nativeInstant(r8, r10);
        return;
    }

    public static TraceEvent scoped(String r8, String r10) {
        if (EarlyTraceEvent.enabled() == true) goto L9;
        if (enabled() == true) goto L9;
        return null;
    L9:
        return new TraceEvent(r8, r10);
    }
}
