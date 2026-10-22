package androidx.core.view;

import android.os.Build;
import android.view.VelocityTracker;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class VelocityTrackerCompat {

    private static class Api34Impl {
        private Api34Impl() {
        }

        static float getAxisVelocity(VelocityTracker r0, int r1) {
            return r0.getAxisVelocity(r1);
        }

        static float getAxisVelocity(VelocityTracker r0, int r1, int r2) {
            return r0.getAxisVelocity(r1, r2);
        }

        static boolean isAxisSupported(VelocityTracker r0, int r1) {
            return r0.isAxisSupported(r1);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VelocityTrackableMotionEventAxis {
    }

    private VelocityTrackerCompat() {
    }

    public static float getAxisVelocity(VelocityTracker r2, int r3) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        if (r3 != 0) goto L10;
        return r2.getXVelocity();
    L10:
        if (r3 == 1) goto L12;
        return 0.0f;
    L12:
        return r2.getYVelocity();
    L5:
        return Api34Impl.getAxisVelocity(r2, r3);
    }

    public static float getAxisVelocity(VelocityTracker r2, int r3, int r4) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        if (r3 != 0) goto L10;
        return r2.getXVelocity(r4);
    L10:
        if (r3 == 1) goto L12;
        return 0.0f;
    L12:
        return r2.getYVelocity(r4);
    L5:
        return Api34Impl.getAxisVelocity(r2, r3, r4);
    }

    @Deprecated
    public static float getXVelocity(VelocityTracker r0, int r1) {
        return r0.getXVelocity(r1);
    }

    @Deprecated
    public static float getYVelocity(VelocityTracker r0, int r1) {
        return r0.getYVelocity(r1);
    }

    public static boolean isAxisSupported(VelocityTracker r2, int r3) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.isAxisSupported(r2, r3);
    L7:
        if (r3 == 0) goto L12;
        if (r3 == 1) goto L13;
        return false;
    L13:
        return true;
    L12:
        return true;
    }
}
