package androidx.core.view;

import android.view.VelocityTracker;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class VelocityTrackerCompat {
    private VelocityTrackerCompat() {
    }

    @Deprecated
    public static float getXVelocity(VelocityTracker r10, int r11) {
        return r10.getXVelocity(r11);
    }

    @Deprecated
    public static float getYVelocity(VelocityTracker r10, int r11) {
        return r10.getYVelocity(r11);
    }
}
