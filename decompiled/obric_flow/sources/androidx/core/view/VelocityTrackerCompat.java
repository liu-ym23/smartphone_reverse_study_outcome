package androidx.core.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class VelocityTrackerCompat {
    private static Map<VelocityTracker, VelocityTrackerFallback> sFallbackTrackers;

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static float getAxisVelocity(VelocityTracker r5, int r10, int r11) {
            return r5.getAxisVelocity(r10, r11);
        }

        @DoNotInline
        public static boolean isAxisSupported(VelocityTracker r5, int r10) {
            return r5.isAxisSupported(r10);
        }

        @DoNotInline
        public static float getAxisVelocity(VelocityTracker r5, int r10) {
            return r5.getAxisVelocity(r10);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface VelocityTrackableMotionEventAxis {
    }

    static {
        sFallbackTrackers = Collections.synchronizedMap(new WeakHashMap());
    }

    private VelocityTrackerCompat() {
    }

    public static void addMovement(@NonNull VelocityTracker r5, @NonNull MotionEvent r10) {
        r5.addMovement(r10);
        if (Build.VERSION.SDK_INT < 34) goto L6;
        return;
    L6:
        if (r10.getSource() == 4194304) goto L8;
        return;
    L8:
        if (sFallbackTrackers.containsKey(r5) == true) goto L10;
        sFallbackTrackers.put(r5, new VelocityTrackerFallback());
    L10:
        sFallbackTrackers.get(r5).addMovement(r10);
    }

    public static void clear(@NonNull VelocityTracker r5) {
        r5.clear();
        removeFallbackForTracker(r5);
    }

    public static void computeCurrentVelocity(@NonNull VelocityTracker r5, int r10, float r11) {
        r5.computeCurrentVelocity(r10, r11);
        VelocityTrackerFallback r12 = getFallbackTrackerOrNull(r5);
        if (r12 == null) goto L6;
        r12.computeCurrentVelocity(r10, r11);
        return;
    }

    public static float getAxisVelocity(@NonNull VelocityTracker r5, int r10) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        if (r10 != 0) goto L10;
        return r5.getXVelocity();
    L10:
        if (r10 == 1) goto L12;
        VelocityTrackerFallback r11 = getFallbackTrackerOrNull(r5);
        if (r11 != null) goto L16;
        return 0.0f;
    L16:
        return r11.getAxisVelocity(r10);
    L12:
        return r5.getYVelocity();
    L5:
        return Api34Impl.getAxisVelocity(r5, r10);
    }

    @Nullable
    private static VelocityTrackerFallback getFallbackTrackerOrNull(VelocityTracker r5) {
        return sFallbackTrackers.get(r5);
    }

    @Deprecated
    public static float getXVelocity(VelocityTracker r5, int r10) {
        return r5.getXVelocity(r10);
    }

    @Deprecated
    public static float getYVelocity(VelocityTracker r5, int r10) {
        return r5.getYVelocity(r10);
    }

    public static boolean isAxisSupported(@NonNull VelocityTracker r5, int r10) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.isAxisSupported(r5, r10);
    L7:
        if (r10 == 26) goto L13;
        if (r10 == 0) goto L14;
        if (r10 == 1) goto L15;
        return false;
    L15:
        return true;
    L14:
        return true;
    L13:
        return true;
    }

    public static void recycle(@NonNull VelocityTracker r5) {
        r5.recycle();
        removeFallbackForTracker(r5);
    }

    private static void removeFallbackForTracker(VelocityTracker r5) {
        sFallbackTrackers.remove(r5);
    }

    public static void computeCurrentVelocity(@NonNull VelocityTracker r5, int r10) {
        computeCurrentVelocity(r5, r10, Float.MAX_VALUE);
    }

    public static float getAxisVelocity(@NonNull VelocityTracker r5, int r10, int r11) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        if (r10 != 0) goto L10;
        return r5.getXVelocity(r11);
    L10:
        if (r10 == 1) goto L12;
        return 0.0f;
    L12:
        return r5.getYVelocity(r11);
    L5:
        return Api34Impl.getAxisVelocity(r5, r10, r11);
    }
}
