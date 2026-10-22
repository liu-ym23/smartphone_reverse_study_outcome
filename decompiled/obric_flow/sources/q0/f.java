package q0;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f21453a = 0.0d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f21454b = 0;

    static {
        f21453a = 1.0d / Math.pow(10.0d, 6.0d);
    }

    public static double a(long r5) {
        return (SystemClock.elapsedRealtimeNanos() - r5) * f21453a;
    }
}
