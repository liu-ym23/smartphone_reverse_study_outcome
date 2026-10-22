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

    public static class ActivityOptionsCompatImpl extends ActivityOptionsCompat {
        private final ActivityOptions mActivityOptions;

        public ActivityOptionsCompatImpl(ActivityOptions r5) {
            this.mActivityOptions = r5;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Rect getLaunchBounds() {
            return Api24Impl.getLaunchBounds(this.mActivityOptions);
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void requestUsageTimeReport(@NonNull PendingIntent r5) {
            Api23Impl.requestUsageTimeReport(this.mActivityOptions, r5);
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        @NonNull
        public ActivityOptionsCompat setLaunchBounds(@Nullable Rect r5) {
            return new ActivityOptionsCompatImpl(Api24Impl.setLaunchBounds(this.mActivityOptions, r5));
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public ActivityOptionsCompat setShareIdentityEnabled(boolean r5) {
            if (Build.VERSION.SDK_INT >= 34) goto L6;
            return this;
        L6:
            return new ActivityOptionsCompatImpl(Api34Impl.setShareIdentityEnabled(this.mActivityOptions, r5));
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mActivityOptions.toBundle();
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void update(@NonNull ActivityOptionsCompat r5) {
            if ((r5 instanceof ActivityOptionsCompatImpl) == false) goto L6;
            this.mActivityOptions.update(((ActivityOptionsCompatImpl) r5).mActivityOptions);
            return;
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static ActivityOptions makeSceneTransitionAnimation(Activity r5, View r10, String r11) {
            return ActivityOptions.makeSceneTransitionAnimation(r5, r10, r11);
        }

        @DoNotInline
        public static ActivityOptions makeTaskLaunchBehind() {
            return ActivityOptions.makeTaskLaunchBehind();
        }

        @SafeVarargs
        @DoNotInline
        public static ActivityOptions makeSceneTransitionAnimation(Activity r5, Pair<View, String>... r10) {
            return ActivityOptions.makeSceneTransitionAnimation(r5, r10);
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static ActivityOptions makeBasic() {
            return ActivityOptions.makeBasic();
        }

        @DoNotInline
        public static ActivityOptions makeClipRevealAnimation(View r5, int r10, int r11, int r12, int r13) {
            return ActivityOptions.makeClipRevealAnimation(r5, r10, r11, r12, r13);
        }

        @DoNotInline
        public static void requestUsageTimeReport(ActivityOptions r5, PendingIntent r10) {
            r5.requestUsageTimeReport(r10);
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static Rect getLaunchBounds(ActivityOptions r5) {
            return r5.getLaunchBounds();
        }

        @DoNotInline
        public static ActivityOptions setLaunchBounds(ActivityOptions r5, Rect r10) {
            return r5.setLaunchBounds(r10);
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static ActivityOptions setShareIdentityEnabled(ActivityOptions r5, boolean r10) {
            return r5.setShareIdentityEnabled(r10);
        }
    }

    public ActivityOptionsCompat() {
    }

    @NonNull
    public static ActivityOptionsCompat makeBasic() {
        return new ActivityOptionsCompatImpl(Api23Impl.makeBasic());
    }

    @NonNull
    public static ActivityOptionsCompat makeClipRevealAnimation(@NonNull View r5, int r10, int r11, int r12, int r13) {
        return new ActivityOptionsCompatImpl(Api23Impl.makeClipRevealAnimation(r5, r10, r11, r12, r13));
    }

    @NonNull
    public static ActivityOptionsCompat makeCustomAnimation(@NonNull Context r5, int r10, int r11) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeCustomAnimation(r5, r10, r11));
    }

    @NonNull
    public static ActivityOptionsCompat makeScaleUpAnimation(@NonNull View r5, int r10, int r11, int r12, int r13) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeScaleUpAnimation(r5, r10, r11, r12, r13));
    }

    @NonNull
    public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity r5, @NonNull View r10, @NonNull String r11) {
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(r5, r10, r11));
    }

    @NonNull
    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        return new ActivityOptionsCompatImpl(Api21Impl.makeTaskLaunchBehind());
    }

    @NonNull
    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(@NonNull View r5, @NonNull Bitmap r10, int r11, int r12) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeThumbnailScaleUpAnimation(r5, r10, r11, r12));
    }

    @Nullable
    public Rect getLaunchBounds() {
        return null;
    }

    public void requestUsageTimeReport(@NonNull PendingIntent r5) {
    }

    @NonNull
    public ActivityOptionsCompat setLaunchBounds(@Nullable Rect r5) {
        return this;
    }

    @NonNull
    public ActivityOptionsCompat setShareIdentityEnabled(boolean r5) {
        return this;
    }

    @Nullable
    public Bundle toBundle() {
        return null;
    }

    public void update(@NonNull ActivityOptionsCompat r5) {
    }

    @NonNull
    public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity r5, @Nullable androidx.core.util.Pair<View, String>... r10) {
        if (r10 == null) goto L7;
        Pair[] r11 = new Pair[r10.length];
        int r12 = 0;
    L5:
        if (r12 >= r10.length) goto L9;
        androidx.core.util.Pair<View, String> r13 = r10[r12];
        r11[r12] = Pair.create(r13.first, r13.second);
        r12 = r12 + 1;
    L9:
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(r5, r11));
    L7:
        r11 = null;
        goto L9
    }
}
