package com.ttnet.org.chromium.base;

import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
public class EarlyTraceEvent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String BACKGROUND_STARTUP_TRACING_ENABLED_KEY = "bg_startup_tracing";

    @VisibleForTesting
    static final int STATE_DISABLED = 0;

    @VisibleForTesting
    static final int STATE_ENABLED = 1;

    @VisibleForTesting
    static final int STATE_FINISHED = 2;
    private static final String TRACE_CONFIG_FILENAME = "/data/local/chrome-trace-config.json";
    public static final String TRACE_EARLY_JAVA_IN_CHILD_SWITCH = "trace-early-java-in-child";
    private static final String TRACE_STARTUP_SWITCH = "trace-startup";

    @VisibleForTesting
    static List<AsyncEvent> sAsyncEvents;
    private static boolean sCachedBackgroundStartupTracingFlag;
    private static volatile boolean sEnabledInChildProcessBeforeCommandLine;

    @VisibleForTesting
    static List<Event> sEvents;

    @VisibleForTesting
    static final Object sLock = null;

    @VisibleForTesting
    static volatile int sState;

    @VisibleForTesting
    static final class AsyncEvent {
        final long mId;
        final boolean mIsStart;
        final String mName;
        final long mTimeNanos;

        AsyncEvent(String r10, long r11, boolean r12) {
            this.mName = r10;
            this.mId = r11;
            this.mIsStart = r12;
            this.mTimeNanos = System.nanoTime();
        }
    }

    @VisibleForTesting
    static final class Event {
        final boolean mIsStart;
        final boolean mIsToplevel;
        final String mName;
        final int mThreadId;
        final long mThreadTimeMillis;
        final long mTimeNanos;

        Event(String r10, boolean r11, boolean r12) {
            this.mIsStart = r11;
            this.mIsToplevel = r12;
            this.mName = r10;
            this.mThreadId = Process.myTid();
            this.mTimeNanos = System.nanoTime();
            this.mThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        }
    }

    interface Natives {
        void recordEarlyAsyncBeginEvent(String r10, long r11, long r12);

        void recordEarlyAsyncEndEvent(String r10, long r11, long r12);

        void recordEarlyBeginEvent(String r10, long r11, int r12, long r13);

        void recordEarlyEndEvent(String r10, long r11, int r12, long r13);

        void recordEarlyToplevelBeginEvent(String r10, long r11, int r12, long r13);

        void recordEarlyToplevelEndEvent(String r10, long r11, int r12, long r13);
    }

    static {
        sLock = new Object();
    }

    public EarlyTraceEvent() {
    }

    public static void begin(String r10, boolean r11) {
        if (enabled() == true) goto L5;
        return;
    L5:
        Event r12 = new Event(r10, true, r11);
        Object r13 = sLock;
        monitor-enter(r13);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (enabled() == true) goto L11;
        monitor-exit(r13);     // Catch: Throwable -> L14
        return;
    L11:
        sEvents.add(r12);     // Catch: Throwable -> L14
        monitor-exit(r13);     // Catch: Throwable -> L14
    }

    static void disable() {
        Object r10 = sLock;
        monitor-enter(r10);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (enabled() == true) goto L9;
        monitor-exit(r10);     // Catch: Throwable -> L17
        return;
    L9:
        if (sEvents.isEmpty() == true) goto L12;
        dumpEvents(sEvents);     // Catch: Throwable -> L17
        sEvents.clear();     // Catch: Throwable -> L17
    L12:
        if (sAsyncEvents.isEmpty() == true) goto L14;
        dumpAsyncEvents(sAsyncEvents);     // Catch: Throwable -> L17
        sAsyncEvents.clear();     // Catch: Throwable -> L17
    L14:
        sState = 2;     // Catch: Throwable -> L17
        sEvents = null;     // Catch: Throwable -> L17
        sAsyncEvents = null;     // Catch: Throwable -> L17
        monitor-exit(r10);     // Catch: Throwable -> L17
    }

    private static void dumpAsyncEvents(List<AsyncEvent> r14) {
        Iterator<AsyncEvent> r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L9;
        AsyncEvent r10 = r15.next();
        if (r10.mIsStart == true) goto L7;
        EarlyTraceEventJni.get().recordEarlyAsyncEndEvent(r10.mName, r10.mId, r10.mTimeNanos);
        goto L4
    L7:
        EarlyTraceEventJni.get().recordEarlyAsyncBeginEvent(r10.mName, r10.mId, r10.mTimeNanos);
        goto L4
    }

    private static void dumpEvents(List<Event> r17) {
        Iterator<Event> r10 = r17.iterator();
    L4:
        if (r10.hasNext() == false) goto L15;
        Event r11 = r10.next();
        if (r11.mIsStart == true) goto L8;
        if (r11.mIsToplevel == true) goto L13;
        EarlyTraceEventJni.get().recordEarlyEndEvent(r11.mName, r11.mTimeNanos, r11.mThreadId, r11.mThreadTimeMillis);
        goto L4
    L13:
        EarlyTraceEventJni.get().recordEarlyToplevelEndEvent(r11.mName, r11.mTimeNanos, r11.mThreadId, r11.mThreadTimeMillis);
        goto L4
    L8:
        if (r11.mIsToplevel == true) goto L9;
        EarlyTraceEventJni.get().recordEarlyBeginEvent(r11.mName, r11.mTimeNanos, r11.mThreadId, r11.mThreadTimeMillis);
        goto L4
    L9:
        EarlyTraceEventJni.get().recordEarlyToplevelBeginEvent(r11.mName, r11.mTimeNanos, r11.mThreadId, r11.mThreadTimeMillis);
        goto L4
    }

    public static void earlyEnableInChildWithoutCommandLine() {
        sEnabledInChildProcessBeforeCommandLine = true;
        enable();
    }

    static void enable() {
        Object r10 = sLock;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sState == 0) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        sEvents = new ArrayList();     // Catch: Throwable -> L11
        sAsyncEvents = new ArrayList();     // Catch: Throwable -> L11
        sState = 1;     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
    }

    static boolean enabled() {
        if (sState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void end(String r10, boolean r11) {
        if (enabled() == true) goto L5;
        return;
    L5:
        Event r12 = new Event(r10, false, r11);
        Object r13 = sLock;
        monitor-enter(r13);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (enabled() == true) goto L11;
        monitor-exit(r13);     // Catch: Throwable -> L14
        return;
    L11:
        sEvents.add(r12);     // Catch: Throwable -> L14
        monitor-exit(r13);     // Catch: Throwable -> L14
    }

    public static void finishAsync(String r10, long r11) {
        if (enabled() == true) goto L5;
        return;
    L5:
        AsyncEvent r12 = new AsyncEvent(r10, r11, false);
        Object r13 = sLock;
        monitor-enter(r13);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (enabled() == true) goto L11;
        monitor-exit(r13);     // Catch: Throwable -> L14
        return;
    L11:
        sAsyncEvents.add(r12);     // Catch: Throwable -> L14
        monitor-exit(r13);     // Catch: Throwable -> L14
    }

    @CalledByNative
    public static boolean getBackgroundStartupTracingFlag() {
        return sCachedBackgroundStartupTracingFlag;
    }

    @VisibleForTesting
    static List<Event> getMatchingCompletedEventsForTesting(String r10) {
        Object r11 = sLock;
        monitor-enter(r11);
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L12
        Iterator<Event> r13 = sEvents.iterator();     // Catch: Throwable -> L12
    L6:
        if (r13.hasNext() == false) goto L10;
        Event r14 = r13.next();     // Catch: Throwable -> L12
        if (r14.mName.equals(r10) == false) goto L6;
        r12.add(r14);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r12;
    L12:
        th = move-exception;
        throw th;
    }

    static void maybeEnableInBrowserProcess() {
        ThreadUtils.assertOnUiThread();
        if (sState == 0) goto L5;
        return;
    L5:
        StrictMode.ThreadPolicy r10 = StrictMode.allowThreadDiskReads();
    L24:
        th = move-exception;
        StrictMode.setThreadPolicy(r10);
        throw th;
    L7:
        boolean r11 = true;
        if (CommandLine.getInstance().hasSwitch(TRACE_STARTUP_SWITCH) == false) goto L27;
        boolean r12 = true;
    L14:
        if (ContextUtils.getAppSharedPreferences().getBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, false) == false) goto L19;
        if (r12 == false) goto L17;
        setBackgroundStartupTracingFlag(false);     // Catch: Throwable -> L24
        sCachedBackgroundStartupTracingFlag = false;     // Catch: Throwable -> L24
        goto L19
    L17:
        sCachedBackgroundStartupTracingFlag = true;     // Catch: Throwable -> L24
    L20:
        StrictMode.setThreadPolicy(r10);
        if (r11 == false) goto L30;
        enable();
        return;
    L30:
        return;
    L19:
        r11 = r12;
        goto L20
    L27:
        r12 = new File(TRACE_CONFIG_FILENAME).exists();     // Catch: SecurityException -> L12 Throwable -> L24
    L12:
        r12 = false;
        goto L14
    }

    public static void onCommandLineAvailableInChildProcess() {
        if (sEnabledInChildProcessBeforeCommandLine == true) goto L5;
        return;
    L5:
        Object r10 = sLock;
        monitor-enter(r10);
    L17:
        th = move-exception;
        throw th;
    L8:
        if (CommandLine.getInstance().hasSwitch(TRACE_EARLY_JAVA_IN_CHILD_SWITCH) == true) goto L13;
        reset();     // Catch: Throwable -> L17
        monitor-exit(r10);     // Catch: Throwable -> L17
        return;
    L13:
        if (sState != 0) goto L15;
        enable();     // Catch: Throwable -> L17
    L15:
        monitor-exit(r10);     // Catch: Throwable -> L17
    }

    @VisibleForTesting
    static void reset() {
        Object r10 = sLock;
        monitor-enter(r10);
        sState = 0;     // Catch: Throwable -> L8
        sEvents = null;     // Catch: Throwable -> L8
        sAsyncEvents = null;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    static void setBackgroundStartupTracingFlag(boolean r10) {
        ContextUtils.getAppSharedPreferences().edit().putBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, r10).apply();
    }

    public static void startAsync(String r10, long r11) {
        if (enabled() == true) goto L5;
        return;
    L5:
        AsyncEvent r12 = new AsyncEvent(r10, r11, true);
        Object r13 = sLock;
        monitor-enter(r13);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (enabled() == true) goto L11;
        monitor-exit(r13);     // Catch: Throwable -> L14
        return;
    L11:
        sAsyncEvents.add(r12);     // Catch: Throwable -> L14
        monitor-exit(r13);     // Catch: Throwable -> L14
    }
}
