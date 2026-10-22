package com.ttnet.org.chromium.base;

import android.annotation.SuppressLint;
import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
public class EarlyTraceEvent {
    private static final String BACKGROUND_STARTUP_TRACING_ENABLED_KEY = "bg_startup_tracing";

    @VisibleForTesting
    static final int STATE_DISABLED = 0;

    @VisibleForTesting
    static final int STATE_ENABLED = 1;

    @VisibleForTesting
    static final int STATE_FINISHED = 3;

    @VisibleForTesting
    static final int STATE_FINISHING = 2;
    private static final String TRACE_CONFIG_FILENAME = "/data/local/chrome-trace-config.json";

    @VisibleForTesting
    @GuardedBy("sLock")
    static List<AsyncEvent> sAsyncEvents;
    private static boolean sCachedBackgroundStartupTracingFlag;

    @VisibleForTesting
    @GuardedBy("sLock")
    static List<Event> sCompletedEvents;
    private static final Object sLock = null;

    @VisibleForTesting
    @GuardedBy("sLock")
    static List<String> sPendingAsyncEvents;

    @VisibleForTesting
    @GuardedBy("sLock")
    static Map<String, Event> sPendingEventByKey;

    @VisibleForTesting
    static volatile int sState;

    @VisibleForTesting
    public static final class AsyncEvent {
        final long mId;
        final boolean mIsStart;
        final String mName;
        final long mTimestampNanos;

        public AsyncEvent(String r8, long r10, boolean r11) {
            this.mName = r8;
            this.mId = r10;
            this.mIsStart = r11;
            this.mTimestampNanos = Event.elapsedRealtimeNanos();
        }
    }

    @VisibleForTesting
    public static final class Event {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final long mBeginThreadTimeMillis;
        final long mBeginTimeNanos;
        long mEndThreadTimeMillis;
        long mEndTimeNanos;
        final String mName;
        final int mThreadId;

        public Event(String r8) {
            this.mName = r8;
            this.mThreadId = Process.myTid();
            this.mBeginTimeNanos = elapsedRealtimeNanos();
            this.mBeginThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        }

        @VisibleForTesting
        @SuppressLint({"NewApi"})
        public static long elapsedRealtimeNanos() {
            return SystemClock.elapsedRealtimeNanos();
        }

        public void end() {
            this.mEndTimeNanos = elapsedRealtimeNanos();
            this.mEndThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        }
    }

    static {
        sLock = new Object();
    }

    public EarlyTraceEvent() {
    }

    public static void begin(String r8) {
        if (enabled() == true) goto L5;
        return;
    L5:
        Event r10 = new Event(r8);
        Object r11 = sLock;
        monitor-enter(r11);
    L17:
        th = move-exception;
        throw th;
    L8:
        if (enabled() == true) goto L11;
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L11:
        Event r12 = sPendingEventByKey.put(makeEventKeyForCurrentThread(r8), r10);     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        if (r12 != null) goto L16;
        return;
    L16:
        throw new IllegalArgumentException(defpackage.b.c("Multiple pending trace events can't have the same name: ", r8));
    }

    public static void disable() {
        Object r8 = sLock;
        monitor-enter(r8);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (enabled() == true) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        sState = 2;     // Catch: Throwable -> L11
        maybeFinishLocked();     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
    }

    private static void dumpAsyncEvents(List<AsyncEvent> r8) {
        long r10 = getOffsetNanos();
        Iterator<AsyncEvent> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        AsyncEvent r12 = r11.next();
        if (r12.mIsStart == true) goto L7;
        nativeRecordEarlyFinishAsyncEvent(r12.mName, r12.mId, r12.mTimestampNanos + r10);
        goto L4
    L7:
        nativeRecordEarlyStartAsyncEvent(r12.mName, r12.mId, r12.mTimestampNanos + r10);
        goto L4
    }

    private static void dumpEvents(List<Event> r13) {
        long r8 = getOffsetNanos();
        Iterator<Event> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        Event r10 = r14.next();
        nativeRecordEarlyEvent(r10.mName, r10.mBeginTimeNanos + r8, r10.mEndTimeNanos + r8, r10.mThreadId, r10.mEndThreadTimeMillis - r10.mBeginThreadTimeMillis);
        goto L4
    }

    @VisibleForTesting
    public static void enable() {
        Object r8 = sLock;
        monitor-enter(r8);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sState == 0) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        sCompletedEvents = new ArrayList();     // Catch: Throwable -> L11
        sPendingEventByKey = new HashMap();     // Catch: Throwable -> L11
        sAsyncEvents = new ArrayList();     // Catch: Throwable -> L11
        sPendingAsyncEvents = new ArrayList();     // Catch: Throwable -> L11
        sState = 1;     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
    }

    public static boolean enabled() {
        if (sState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void end(String r8) {
        if (isActive() == true) goto L5;
        return;
    L5:
        Object r10 = sLock;
        monitor-enter(r10);
    L20:
        th = move-exception;
        throw th;
    L8:
        if (isActive() == true) goto L11;
        monitor-exit(r10);     // Catch: Throwable -> L20
        return;
    L11:
        Event r11 = sPendingEventByKey.remove(makeEventKeyForCurrentThread(r8));     // Catch: Throwable -> L20
        if (r11 != null) goto L15;
        monitor-exit(r10);     // Catch: Throwable -> L20
        return;
    L15:
        r11.end();     // Catch: Throwable -> L20
        sCompletedEvents.add(r11);     // Catch: Throwable -> L20
        if (sState != 2) goto L18;
        maybeFinishLocked();     // Catch: Throwable -> L20
    L18:
        monitor-exit(r10);     // Catch: Throwable -> L20
    }

    public static void finishAsync(String r8, long r10) {
        if (isActive() == true) goto L5;
        return;
    L5:
        AsyncEvent r11 = new AsyncEvent(r8, r10, false);
        Object r12 = sLock;
        monitor-enter(r12);
    L20:
        th = move-exception;
        throw th;
    L8:
        if (isActive() == true) goto L12;
        monitor-exit(r12);     // Catch: Throwable -> L20
        return;
    L12:
        if (sPendingAsyncEvents.remove(r8) == true) goto L15;
        monitor-exit(r12);     // Catch: Throwable -> L20
        return;
    L15:
        sAsyncEvents.add(r11);     // Catch: Throwable -> L20
        if (sState != 2) goto L18;
        maybeFinishLocked();     // Catch: Throwable -> L20
    L18:
        monitor-exit(r12);     // Catch: Throwable -> L20
    }

    @CalledByNative
    public static boolean getBackgroundStartupTracingFlag() {
        return sCachedBackgroundStartupTracingFlag;
    }

    private static long getOffsetNanos() {
        return (TimeUtils.nativeGetTimeTicksNowUs() * 1000) - Event.elapsedRealtimeNanos();
    }

    public static boolean isActive() {
        int r8 = sState;
        if (r8 != 1) goto L5;
        return true;
    L5:
        if (r8 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    @VisibleForTesting
    public static String makeEventKeyForCurrentThread(String r8) {
        StringBuilder r10 = android.aimedia.a.k(r8, "@");
        r10.append(Process.myTid());
        return r10.toString();
    }

    public static void maybeEnable() {
        ThreadUtils.assertOnUiThread();
        if (sState == 0) goto L5;
        return;
    L5:
        StrictMode.ThreadPolicy r8 = StrictMode.allowThreadDiskReads();
    L24:
        th = move-exception;
        StrictMode.setThreadPolicy(r8);
        throw th;
    L7:
        boolean r10 = true;
        if (CommandLine.getInstance().hasSwitch("trace-startup") == false) goto L27;
        boolean r11 = true;
    L14:
        if (ContextUtils.getAppSharedPreferences().getBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, false) == false) goto L19;
        if (r11 == false) goto L17;
        setBackgroundStartupTracingFlag(false);     // Catch: Throwable -> L24
        sCachedBackgroundStartupTracingFlag = false;     // Catch: Throwable -> L24
        goto L19
    L17:
        sCachedBackgroundStartupTracingFlag = true;     // Catch: Throwable -> L24
    L20:
        StrictMode.setThreadPolicy(r8);
        if (r10 == false) goto L30;
        enable();
        return;
    L30:
        return;
    L19:
        r10 = r11;
        goto L20
    L27:
        r11 = new File(TRACE_CONFIG_FILENAME).exists();     // Catch: SecurityException -> L12 Throwable -> L24
    L12:
        r11 = false;
        goto L14
    }

    @GuardedBy("sLock")
    private static void maybeFinishLocked() {
        if (sCompletedEvents.isEmpty() == true) goto L6;
        dumpEvents(sCompletedEvents);
        sCompletedEvents.clear();
    L6:
        if (sAsyncEvents.isEmpty() == true) goto L9;
        dumpAsyncEvents(sAsyncEvents);
        sAsyncEvents.clear();
    L9:
        if (sPendingEventByKey.isEmpty() == true) goto L11;
        return;
    L11:
        if (sPendingAsyncEvents.isEmpty() == false) goto L15;
        sState = 3;
        sPendingEventByKey = null;
        sCompletedEvents = null;
        sPendingAsyncEvents = null;
        sAsyncEvents = null;
        return;
    }

    private static native void nativeRecordEarlyEvent(String r8, long r10, long r11, int r12, long r13);

    private static native void nativeRecordEarlyFinishAsyncEvent(String r8, long r10, long r11);

    private static native void nativeRecordEarlyStartAsyncEvent(String r8, long r10, long r11);

    @VisibleForTesting
    public static void resetForTesting() {
        Object r8 = sLock;
        monitor-enter(r8);
        sState = 0;     // Catch: Throwable -> L8
        sCompletedEvents = null;     // Catch: Throwable -> L8
        sPendingEventByKey = null;     // Catch: Throwable -> L8
        sAsyncEvents = null;     // Catch: Throwable -> L8
        sPendingAsyncEvents = null;     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    public static void setBackgroundStartupTracingFlag(boolean r8) {
        ContextUtils.getAppSharedPreferences().edit().putBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, r8).apply();
    }

    public static void startAsync(String r8, long r10) {
        if (enabled() == true) goto L5;
        return;
    L5:
        AsyncEvent r11 = new AsyncEvent(r8, r10, true);
        Object r12 = sLock;
        monitor-enter(r12);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (enabled() == true) goto L11;
        monitor-exit(r12);     // Catch: Throwable -> L14
        return;
    L11:
        sAsyncEvents.add(r11);     // Catch: Throwable -> L14
        sPendingAsyncEvents.add(r8);     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
    }
}
