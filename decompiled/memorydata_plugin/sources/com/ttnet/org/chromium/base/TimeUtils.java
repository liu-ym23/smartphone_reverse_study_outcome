package com.ttnet.org.chromium.base;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes6.dex */
public class TimeUtils {
    public static final long NANOSECONDS_PER_MICROSECOND = 1000;
    public static final long NANOSECONDS_PER_MILLISECOND = 1000000;
    public static final long SECONDS_PER_DAY = 86400;
    public static final long SECONDS_PER_HOUR = 3600;
    public static final long SECONDS_PER_MINUTE = 60;
    static FakeClock sFakeClock;

    public static class CurrentThreadTimeMillisTimer {
        private final long mStart;

        public CurrentThreadTimeMillisTimer() {
            this.mStart = TimeUtils.currentThreadTimeMillis();
        }

        public long getElapsedMillis() {
            return TimeUtils.currentThreadTimeMillis() - this.mStart;
        }
    }

    public static class ElapsedRealtimeMillisTimer {
        private final long mStart;

        public ElapsedRealtimeMillisTimer() {
            this.mStart = TimeUtils.elapsedRealtimeMillis();
        }

        public long getElapsedMillis() {
            return TimeUtils.elapsedRealtimeMillis() - this.mStart;
        }
    }

    public static class ElapsedRealtimeNanosTimer {
        private final long mStart;

        public ElapsedRealtimeNanosTimer() {
            this.mStart = TimeUtils.elapsedRealtimeNanos();
        }

        public long getElapsedNanos() {
            return TimeUtils.elapsedRealtimeNanos() - this.mStart;
        }
    }

    interface FakeClock {
        long currentThreadTimeMillis();

        long currentTimeMillis();

        long elapsedRealtimeNanos();

        long uptimeMillis();
    }

    public static class UptimeMillisTimer {
        private final long mStart;

        public UptimeMillisTimer() {
            this.mStart = TimeUtils.uptimeMillis();
        }

        public long getElapsedMillis() {
            return TimeUtils.uptimeMillis() - this.mStart;
        }
    }

    private TimeUtils() {
    }

    public static long currentThreadTimeMillis() {
        FakeClock r0 = sFakeClock;
        if (r0 == null) goto L7;
        return r0.currentThreadTimeMillis();
    L7:
        return SystemClock.currentThreadTimeMillis();
    }

    public static long currentTimeMillis() {
        FakeClock r0 = sFakeClock;
        if (r0 == null) goto L7;
        return r0.currentTimeMillis();
    L7:
        return System.currentTimeMillis();
    }

    public static long elapsedRealtimeMillis() {
        FakeClock r0 = sFakeClock;
        if (r0 == null) goto L7;
        return r0.elapsedRealtimeNanos() / NANOSECONDS_PER_MILLISECOND;
    L7:
        return SystemClock.elapsedRealtime();
    }

    public static long elapsedRealtimeNanos() {
        FakeClock r0 = sFakeClock;
        if (r0 == null) goto L7;
        return r0.elapsedRealtimeNanos();
    L7:
        return SystemClock.elapsedRealtimeNanos();
    }

    public static long uptimeMillis() {
        FakeClock r0 = sFakeClock;
        if (r0 == null) goto L7;
        return r0.uptimeMillis();
    L7:
        return SystemClock.uptimeMillis();
    }
}
