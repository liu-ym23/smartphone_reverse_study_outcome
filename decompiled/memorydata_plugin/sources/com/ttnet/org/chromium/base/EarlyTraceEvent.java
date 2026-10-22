package com.ttnet.org.chromium.base;

import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("base::android")
@MainDex
public class EarlyTraceEvent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String BACKGROUND_STARTUP_TRACING_ENABLED_KEY = "bg_startup_tracing";
    static final int STATE_DISABLED = 0;
    static final int STATE_ENABLED = 1;
    static final int STATE_FINISHED = 2;
    private static final String TRACE_CONFIG_FILENAME = "/data/local/chrome-trace-config.json";
    public static final String TRACE_EARLY_JAVA_IN_CHILD_SWITCH = "trace-early-java-in-child";
    private static final String TRACE_STARTUP_SWITCH = "trace-startup";
    static List<AsyncEvent> sAsyncEvents;
    private static boolean sCachedBackgroundStartupTracingFlag;
    private static volatile boolean sEnabledInChildProcessBeforeCommandLine;
    static List<Event> sEvents;
    static final Object sLock = null;
    static volatile int sState;

    static final class AsyncEvent {
        final long mId;
        final boolean mIsStart;
        final String mName;
        final long mTimeNanos;

        AsyncEvent(String r1, long r2, boolean r4) {
            this.mName = r1;
            this.mId = r2;
            this.mIsStart = r4;
            this.mTimeNanos = System.nanoTime();
        }
    }

    static final class Event {
        final boolean mIsStart;
        final boolean mIsToplevel;
        final String mName;
        final int mThreadId;
        final long mThreadTimeMillis;
        final long mTimeNanos;

        Event(String r1, boolean r2, boolean r3) {
            this.mIsStart = r2;
            this.mIsToplevel = r3;
            this.mName = r1;
            this.mThreadId = Process.myTid();
            this.mTimeNanos = System.nanoTime();
            this.mThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        }
    }

    interface Natives {
        void recordEarlyAsyncBeginEvent(String r1, long r2, long r4);

        void recordEarlyAsyncEndEvent(String r1, long r2, long r4);

        void recordEarlyBeginEvent(String r1, long r2, int r4, long r5);

        void recordEarlyEndEvent(String r1, long r2, int r4, long r5);

        void recordEarlyToplevelBeginEvent(String r1, long r2, int r4, long r5);

        void recordEarlyToplevelEndEvent(String r1, long r2, int r4, long r5);
    }

    static {
        sLock = new Object();
    }

    public EarlyTraceEvent() {
    }

    public static void begin(String r2, boolean r3) {
        if (enabled() == true) goto L5;
        return;
    L5:
        Event r0 = new Event(r2, true, r3);
        Object r4 = sLock;
        monitor-enter(r4);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (enabled() == true) goto L11;
        monitor-exit(r4);     // Catch: Throwable -> L14
        return;
    L11:
        sEvents.add(r0);     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
    }

    static void disable() {
        Object r0 = sLock;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (enabled() == true) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L17
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
        monitor-exit(r0);     // Catch: Throwable -> L17
    }

    private static void dumpAsyncEvents(List<AsyncEvent> r15) {
        Iterator r16 = ((List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r16.hasNext() == false) goto L9;
        AsyncEvent r0 = (AsyncEvent) ZeusTransformUtils.preCheckCast(r16.next(), AsyncEvent.class, "com.obric.memorydata.plugin");
        if (r0.mIsStart == true) goto L7;
        EarlyTraceEventJni.get().recordEarlyAsyncEndEvent(r0.mName, r0.mId, r0.mTimeNanos);
        goto L4
    L7:
        EarlyTraceEventJni.get().recordEarlyAsyncBeginEvent(r0.mName, r0.mId, r0.mTimeNanos);
        goto L4
    }

    private static void dumpEvents(List<Event> r18) {
        Iterator r0 = ((List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        Event r2 = (Event) ZeusTransformUtils.preCheckCast(r0.next(), Event.class, "com.obric.memorydata.plugin");
        if (r2.mIsStart == true) goto L8;
        if (r2.mIsToplevel == true) goto L13;
        EarlyTraceEventJni.get().recordEarlyEndEvent(r2.mName, r2.mTimeNanos, r2.mThreadId, r2.mThreadTimeMillis);
        goto L4
    L13:
        EarlyTraceEventJni.get().recordEarlyToplevelEndEvent(r2.mName, r2.mTimeNanos, r2.mThreadId, r2.mThreadTimeMillis);
        goto L4
    L8:
        if (r2.mIsToplevel == true) goto L9;
        EarlyTraceEventJni.get().recordEarlyBeginEvent(r2.mName, r2.mTimeNanos, r2.mThreadId, r2.mThreadTimeMillis);
        goto L4
    L9:
        EarlyTraceEventJni.get().recordEarlyToplevelBeginEvent(r2.mName, r2.mTimeNanos, r2.mThreadId, r2.mThreadTimeMillis);
        goto L4
    }

    public static void earlyEnableInChildWithoutCommandLine() {
        sEnabledInChildProcessBeforeCommandLine = true;
        enable();
    }

    static void enable() {
        Object r0 = sLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sState == 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        sEvents = new ArrayList();     // Catch: Throwable -> L11
        sAsyncEvents = new ArrayList();     // Catch: Throwable -> L11
        sState = 1;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    static boolean enabled() {
        if (sState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void end(String r2, boolean r3) {
        if (enabled() == true) goto L5;
        return;
    L5:
        Event r0 = new Event(r2, false, r3);
        Object r4 = sLock;
        monitor-enter(r4);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (enabled() == true) goto L11;
        monitor-exit(r4);     // Catch: Throwable -> L14
        return;
    L11:
        sEvents.add(r0);     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
    }

    public static void finishAsync(String r2, long r3) {
        if (enabled() == true) goto L5;
        return;
    L5:
        AsyncEvent r0 = new AsyncEvent(r2, r3, false);
        Object r4 = sLock;
        monitor-enter(r4);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (enabled() == true) goto L11;
        monitor-exit(r4);     // Catch: Throwable -> L14
        return;
    L11:
        sAsyncEvents.add(r0);     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
    }

    public static boolean getBackgroundStartupTracingFlag() {
        return sCachedBackgroundStartupTracingFlag;
    }

    static List<Event> getMatchingCompletedEventsForTesting(String r6) {
        Object r0 = sLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L12
        Iterator<Event> r2 = sEvents.iterator();     // Catch: Throwable -> L12
    L6:
        if (r2.hasNext() == false) goto L10;
        Event r3 = (Event) ZeusTransformUtils.preCheckCast(r2.next(), Event.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r3.mName.equals(r6) == false) goto L6;
        r1.add(r3);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L12:
        th = move-exception;
        throw th;
    }

    static void maybeEnableInBrowserProcess() {
        ThreadUtils.assertOnUiThread();
        if (sState == 0) goto L5;
        return;
    L5:
        StrictMode.ThreadPolicy r0 = StrictMode.allowThreadDiskReads();
    L24:
        th = move-exception;
        StrictMode.setThreadPolicy(r0);
        throw th;
    L7:
        boolean r2 = true;
        if (CommandLine.getInstance().hasSwitch(TRACE_STARTUP_SWITCH) == false) goto L27;
        boolean r1 = true;
    L14:
        if (ContextUtils.getAppSharedPreferences().getBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, false) == false) goto L19;
        if (r1 == false) goto L17;
        setBackgroundStartupTracingFlag(false);     // Catch: Throwable -> L24
        sCachedBackgroundStartupTracingFlag = false;     // Catch: Throwable -> L24
        goto L19
    L17:
        sCachedBackgroundStartupTracingFlag = true;     // Catch: Throwable -> L24
    L20:
        StrictMode.setThreadPolicy(r0);
        if (r2 == false) goto L30;
        enable();
        return;
    L30:
        return;
    L19:
        r2 = r1;
        goto L20
    L27:
        r1 = new File(TRACE_CONFIG_FILENAME).exists();     // Catch: SecurityException -> L12 Throwable -> L24
    L12:
        r1 = false;
        goto L14
    }

    public static void onCommandLineAvailableInChildProcess() {
        if (sEnabledInChildProcessBeforeCommandLine == true) goto L5;
        return;
    L5:
        Object r0 = sLock;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L8:
        if (CommandLine.getInstance().hasSwitch(TRACE_EARLY_JAVA_IN_CHILD_SWITCH) == true) goto L13;
        reset();     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L13:
        if (sState != 0) goto L15;
        enable();     // Catch: Throwable -> L17
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
    }

    static void reset() {
        Object r0 = sLock;
        monitor-enter(r0);
        sState = 0;     // Catch: Throwable -> L8
        sEvents = null;     // Catch: Throwable -> L8
        sAsyncEvents = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    static void setBackgroundStartupTracingFlag(boolean r2) {
        ContextUtils.getAppSharedPreferences().edit().putBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, r2).apply();
    }

    public static void startAsync(String r2, long r3) {
        if (enabled() == true) goto L5;
        return;
    L5:
        AsyncEvent r0 = new AsyncEvent(r2, r3, true);
        Object r4 = sLock;
        monitor-enter(r4);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (enabled() == true) goto L11;
        monitor-exit(r4);     // Catch: Throwable -> L14
        return;
    L11:
        sAsyncEvents.add(r0);     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
    }
}
