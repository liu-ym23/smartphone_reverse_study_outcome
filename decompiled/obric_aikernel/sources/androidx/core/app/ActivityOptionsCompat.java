package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class ActivityOptionsCompat {
    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    @RequiresApi(16)
    private static class ActivityOptionsCompatImpl extends ActivityOptionsCompat {
        private final ActivityOptions mActivityOptions;

        ActivityOptionsCompatImpl(ActivityOptions r10) {
            this.mActivityOptions = r10;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Rect getLaunchBounds() {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return null;
        L7:
            return Api24Impl.getLaunchBounds(this.mActivityOptions);
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void requestUsageTimeReport(@NonNull PendingIntent r10) {
            if (Build.VERSION.SDK_INT < 23) goto L6;
            Api23Impl.requestUsageTimeReport(this.mActivityOptions, r10);
            return;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        @NonNull
        public ActivityOptionsCompat setLaunchBounds(@Nullable Rect r10) {
            if (Build.VERSION.SDK_INT >= 24) goto L6;
            return this;
        L6:
            return new ActivityOptionsCompatImpl(Api24Impl.setLaunchBounds(this.mActivityOptions, r10));
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mActivityOptions.toBundle();
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void update(@NonNull ActivityOptionsCompat r10) {
            if ((r10 instanceof ActivityOptionsCompatImpl) == false) goto L6;
            this.mActivityOptions.update(((ActivityOptionsCompatImpl) r10).mActivityOptions);
            return;
        }
    }

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static ActivityOptions makeCustomAnimation(Context r10, int r11, int r12) {
            return ActivityOptions.makeCustomAnimation(r10, r11, r12);
        }

        @DoNotInline
        static ActivityOptions makeScaleUpAnimation(View r10, int r11, int r12, int r13, int r14) {
            return ActivityOptions.makeScaleUpAnimation(r10, r11, r12, r13, r14);
        }

        @DoNotInline
        static ActivityOptions makeThumbnailScaleUpAnimation(View r10, Bitmap r11, int r12, int r13) {
            return ActivityOptions.makeThumbnailScaleUpAnimation(r10, r11, r12, r13);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ActivityOptions makeSceneTransitionAnimation(Activity r10, View r11, String r12) {
            return ActivityOptions.makeSceneTransitionAnimation(r10, r11, r12);
        }

        @SafeVarargs
        @DoNotInline
        static ActivityOptions makeSceneTransitionAnimation(Activity r10, Pair<View, String>... r11) {
            return ActivityOptions.makeSceneTransitionAnimation(r10, r11);
        }

        @DoNotInline
        static ActivityOptions makeTaskLaunchBehind() {
            return ActivityOptions.makeTaskLaunchBehind();
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static ActivityOptions makeBasic() {
            return ActivityOptions.makeBasic();
        }

        @DoNotInline
        static ActivityOptions makeClipRevealAnimation(View r10, int r11, int r12, int r13, int r14) {
            return ActivityOptions.makeClipRevealAnimation(r10, r11, r12, r13, r14);
        }

        @DoNotInline
        static void requestUsageTimeReport(ActivityOptions r10, PendingIntent r11) {
            r10.requestUsageTimeReport(r11);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static Rect getLaunchBounds(ActivityOptions r10) {
            return r10.getLaunchBounds();
        }

        @DoNotInline
        static ActivityOptions setLaunchBounds(ActivityOptions r10, Rect r11) {
            return r10.setLaunchBounds(r11);
        }
    }

    protected ActivityOptionsCompat() {
    }

    @NonNull
    public static ActivityOptionsCompat makeBasic() {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return new ActivityOptionsCompatImpl(Api23Impl.makeBasic());
    L7:
        return new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat makeClipRevealAnimation(@NonNull View r10, int r11, int r12, int r13, int r14) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return new ActivityOptionsCompatImpl(Api23Impl.makeClipRevealAnimation(r10, r11, r12, r13, r14));
    L7:
        return new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat makeCustomAnimation(@NonNull Context r10, int r11, int r12) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return new ActivityOptionsCompatImpl(Api16Impl.makeCustomAnimation(r10, r11, r12));
    L7:
        return new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat makeScaleUpAnimation(@NonNull View r10, int r11, int r12, int r13, int r14) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return new ActivityOptionsCompatImpl(Api16Impl.makeScaleUpAnimation(r10, r11, r12, r13, r14));
    L7:
        return new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity r10, @NonNull View r11, @NonNull String r12) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(r10, r11, r12));
    L7:
        return new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity r10, @Nullable androidx.core.util.Pair<View, String>... r11) {
        if (Build.VERSION.SDK_INT < 21) goto L13;
        Pair[] r12 = null;
        if (r11 == null) goto L11;
        r12 = new Pair[r11.length];
        int r13 = 0;
    L8:
        if (r13 >= r11.length) goto L11;
        r12[r13] = Pair.create(r11[r13].first, r11[r13].second);
        r13 = r13 + 1;
    L11:
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(r10, r12));
    L13:
        return new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return new ActivityOptionsCompatImpl(Api21Impl.makeTaskLaunchBehind());
    L7:
        return new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(@NonNull View r10, @NonNull Bitmap r11, int r12, int r13) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return new ActivityOptionsCompatImpl(Api16Impl.makeThumbnailScaleUpAnimation(r10, r11, r12, r13));
    L7:
        return new ActivityOptionsCompat();
    }

    @Nullable
    public Rect getLaunchBounds() {
        return null;
    }

    public void requestUsageTimeReport(@NonNull PendingIntent r10) {
    }

    @NonNull
    public ActivityOptionsCompat setLaunchBounds(@Nullable Rect r10) {
        return this;
    }

    @Nullable
    public Bundle toBundle() {
        return null;
    }

    public void update(@NonNull ActivityOptionsCompat r10) {
    }
}
