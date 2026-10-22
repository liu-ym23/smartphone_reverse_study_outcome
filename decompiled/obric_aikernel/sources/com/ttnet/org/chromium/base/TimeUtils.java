package com.ttnet.org.chromium.base;

import android.os.SystemClock;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;

/* JADX INFO: loaded from: classes2.dex */
public class TimeUtils {
    public static final long NANOSECONDS_PER_MICROSECOND = 1000;
    public static final long NANOSECONDS_PER_MILLISECOND = 1000000;
    public static final long SECONDS_PER_DAY = 86400;
    public static final long SECONDS_PER_HOUR = 3600;
    public static final long SECONDS_PER_MINUTE = 60;
    static FakeClock sFakeClock;

    @CheckDiscard("Class should get inlined by R8.")
    public static class CurrentThreadTimeMillisTimer {
        private final long mStart;

        public CurrentThreadTimeMillisTimer() {
            this.mStart = TimeUtils.currentThreadTimeMillis();
        }

        public long getElapsedMillis() {
            return TimeUtils.currentThreadTimeMillis() - this.mStart;
        }
    }

    @CheckDiscard("Class should get inlined by R8.")
    public static class ElapsedRealtimeMillisTimer {
        private final long mStart;

        public ElapsedRealtimeMillisTimer() {
            this.mStart = TimeUtils.elapsedRealtimeMillis();
        }

        public long getElapsedMillis() {
            return TimeUtils.elapsedRealtimeMillis() - this.mStart;
        }
    }

    @CheckDiscard("Class should get inlined by R8.")
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

    @CheckDiscard("Class should get inlined by R8.")
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

    @CheckDiscard("Should get inlined by R8.")
    public static long currentThreadTimeMillis() {
        FakeClock r10 = sFakeClock;
        if (r10 == null) goto L7;
        return r10.currentThreadTimeMillis();
    L7:
        return SystemClock.currentThreadTimeMillis();
    }

    @CheckDiscard("Should get inlined by R8.")
    public static long currentTimeMillis() {
        FakeClock r10 = sFakeClock;
        if (r10 == null) goto L7;
        return r10.currentTimeMillis();
    L7:
        return System.currentTimeMillis();
    }

    @CheckDiscard("Should get inlined by R8.")
    public static long elapsedRealtimeMillis() {
        FakeClock r10 = sFakeClock;
        if (r10 == null) goto L7;
        return r10.elapsedRealtimeNanos() / NANOSECONDS_PER_MILLISECOND;
    L7:
        return SystemClock.elapsedRealtime();
    }

    @CheckDiscard("Should get inlined by R8.")
    public static long elapsedRealtimeNanos() {
        FakeClock r10 = sFakeClock;
        if (r10 == null) goto L7;
        return r10.elapsedRealtimeNanos();
    L7:
        return SystemClock.elapsedRealtimeNanos();
    }

    @CheckDiscard("Should get inlined by R8.")
    public static long uptimeMillis() {
        FakeClock r10 = sFakeClock;
        if (r10 == null) goto L7;
        return r10.uptimeMillis();
    L7:
        return SystemClock.uptimeMillis();
    }
}
