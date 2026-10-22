package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class EdgeEffectCompat {
    private final EdgeEffect mEdgeEffect;

    static class Api21Impl {
        private Api21Impl() {
        }

        static void onPull(EdgeEffect r0, float r1, float r2) {
            r0.onPull(r1, r2);
        }
    }

    private static class Api31Impl {
        private Api31Impl() {
        }

        public static EdgeEffect create(Context r2, AttributeSet r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            return new EdgeEffect(r4, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
        L6:
            return new EdgeEffect(r4);
        }

        public static float getDistance(EdgeEffect r0) {
            return r0.getDistance();
        L4:
            return 0.0f;
        }

        public static float onPullDistance(EdgeEffect r0, float r1, float r2) {
            return r0.onPullDistance(r1, r2);
        L4:
            r0.onPull(r1, r2);
            return 0.0f;
        }
    }

    @Deprecated
    public EdgeEffectCompat(Context r3) {
        this.mEdgeEffect = new EdgeEffect((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    public static EdgeEffect create(Context r2, AttributeSet r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return Api31Impl.create(r4, r5);
    L7:
        return new EdgeEffect(r4);
    }

    public static float getDistance(EdgeEffect r2) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return 0.0f;
    L5:
        return Api31Impl.getDistance(r2);
    }

    public static void onPull(EdgeEffect r2, float r3, float r4) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Api21Impl.onPull(r2, r3, r4);
        return;
    L5:
        r2.onPull(r3);
    }

    public static float onPullDistance(EdgeEffect r2, float r3, float r4) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        onPull(r2, r3, r4);
        return r3;
    L5:
        return Api31Impl.onPullDistance(r2, r3, r4);
    }

    @Deprecated
    public boolean draw(Canvas r1) {
        return this.mEdgeEffect.draw(r1);
    }

    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int r1) {
        this.mEdgeEffect.onAbsorb(r1);
        return true;
    }

    @Deprecated
    public boolean onPull(float r1) {
        this.mEdgeEffect.onPull(r1);
        return true;
    }

    @Deprecated
    public boolean onPull(float r1, float r2) {
        onPull(this.mEdgeEffect, r1, r2);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int r1, int r2) {
        this.mEdgeEffect.setSize(r1, r2);
    }
}
