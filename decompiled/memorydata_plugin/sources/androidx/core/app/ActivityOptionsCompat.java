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
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ActivityOptionsCompat {
    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    private static class ActivityOptionsCompatImpl extends ActivityOptionsCompat {
        private final ActivityOptions mActivityOptions;

        ActivityOptionsCompatImpl(ActivityOptions r1) {
            this.mActivityOptions = r1;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Rect getLaunchBounds() {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return null;
        L7:
            return Api24Impl.getLaunchBounds(this.mActivityOptions);
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void requestUsageTimeReport(PendingIntent r3) {
            if (Build.VERSION.SDK_INT < 23) goto L6;
            Api23Impl.requestUsageTimeReport(this.mActivityOptions, r3);
            return;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public ActivityOptionsCompat setLaunchBounds(Rect r3) {
            if (Build.VERSION.SDK_INT >= 24) goto L6;
            return this;
        L6:
            return new ActivityOptionsCompatImpl(Api24Impl.setLaunchBounds(this.mActivityOptions, r3));
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mActivityOptions.toBundle();
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void update(ActivityOptionsCompat r3) {
            if (ZeusTransformUtils.instanceOf(r3, ActivityOptionsCompatImpl.class) == false) goto L6;
            ActivityOptionsCompatImpl r4 = (ActivityOptionsCompatImpl) ZeusTransformUtils.preCheckCast(r3, ActivityOptionsCompatImpl.class, "com.obric.memorydata.plugin");
            this.mActivityOptions.update(r4.mActivityOptions);
            return;
        }
    }

    static class Api16Impl {
        private Api16Impl() {
        }

        static ActivityOptions makeCustomAnimation(Context r2, int r3, int r4) {
            return ActivityOptions.makeCustomAnimation((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        static ActivityOptions makeScaleUpAnimation(View r0, int r1, int r2, int r3, int r4) {
            return ActivityOptions.makeScaleUpAnimation(r0, r1, r2, r3, r4);
        }

        static ActivityOptions makeThumbnailScaleUpAnimation(View r0, Bitmap r1, int r2, int r3) {
            return ActivityOptions.makeThumbnailScaleUpAnimation(r0, r1, r2, r3);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static ActivityOptions makeSceneTransitionAnimation(Activity r2, View r3, String r4) {
            return ActivityOptions.makeSceneTransitionAnimation((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @SafeVarargs
        static ActivityOptions makeSceneTransitionAnimation(Activity r2, Pair<View, String>... r3) {
            return ActivityOptions.makeSceneTransitionAnimation((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), r3);
        }

        static ActivityOptions makeTaskLaunchBehind() {
            return ActivityOptions.makeTaskLaunchBehind();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static ActivityOptions makeBasic() {
            return ActivityOptions.makeBasic();
        }

        static ActivityOptions makeClipRevealAnimation(View r0, int r1, int r2, int r3, int r4) {
            return ActivityOptions.makeClipRevealAnimation(r0, r1, r2, r3, r4);
        }

        static void requestUsageTimeReport(ActivityOptions r0, PendingIntent r1) {
            r0.requestUsageTimeReport(r1);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static Rect getLaunchBounds(ActivityOptions r0) {
            return r0.getLaunchBounds();
        }

        static ActivityOptions setLaunchBounds(ActivityOptions r0, Rect r1) {
            return r0.setLaunchBounds(r1);
        }
    }

    public ActivityOptionsCompat() {
    }

    public static ActivityOptionsCompat makeBasic() {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return new ActivityOptionsCompatImpl(Api23Impl.makeBasic());
    L7:
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeClipRevealAnimation(View r2, int r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return new ActivityOptionsCompatImpl(Api23Impl.makeClipRevealAnimation(r2, r3, r4, r5, r6));
    L7:
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeCustomAnimation(Context r2, int r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return new ActivityOptionsCompatImpl(Api16Impl.makeCustomAnimation(r5, r3, r4));
    L7:
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View r2, int r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return new ActivityOptionsCompatImpl(Api16Impl.makeScaleUpAnimation(r2, r3, r4, r5, r6));
    L7:
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity r2, View r3, String r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(r5, r3, r4));
    L7:
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity r6, androidx.core.util.Pair<View, String>... r7) {
        Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L13;
        Pair[] r0 = null;
        if (r7 == null) goto L11;
        r0 = new Pair[r7.length];
        int r2 = 0;
    L8:
        if (r2 >= r7.length) goto L11;
        r0[r2] = Pair.create((View) ZeusTransformUtils.preCheckCast(r7[r2].first, View.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r7[r2].second, String.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
    L11:
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(r8, r0));
    L13:
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return new ActivityOptionsCompatImpl(Api21Impl.makeTaskLaunchBehind());
    L7:
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View r2, Bitmap r3, int r4, int r5) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return new ActivityOptionsCompatImpl(Api16Impl.makeThumbnailScaleUpAnimation(r2, r3, r4, r5));
    L7:
        return new ActivityOptionsCompat();
    }

    public Rect getLaunchBounds() {
        return null;
    }

    public void requestUsageTimeReport(PendingIntent r1) {
    }

    public ActivityOptionsCompat setLaunchBounds(Rect r1) {
        return this;
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat r1) {
    }
}
