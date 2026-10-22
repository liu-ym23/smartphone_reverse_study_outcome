package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class EdgeEffectCompat {
    private final EdgeEffect mEdgeEffect;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static void onPull(EdgeEffect r5, float r10, float r11) {
            r5.onPull(r10, r11);
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static EdgeEffect create(Context r5, AttributeSet r10) {
            return new EdgeEffect(r5, r10);
        L5:
            return new EdgeEffect(r5);
        }

        @DoNotInline
        public static float getDistance(EdgeEffect r5) {
            return r5.getDistance();
        L4:
            return 0.0f;
        }

        @DoNotInline
        public static float onPullDistance(EdgeEffect r5, float r10, float r11) {
            return r5.onPullDistance(r10, r11);
        L4:
            r5.onPull(r10, r11);
            return 0.0f;
        }
    }

    @Deprecated
    public EdgeEffectCompat(Context r5) {
        this.mEdgeEffect = new EdgeEffect(r5);
    }

    @NonNull
    public static EdgeEffect create(@NonNull Context r5, @Nullable AttributeSet r10) {
        return Api31Impl.create(r5, r10);
    }

    public static float getDistance(@NonNull EdgeEffect r5) {
        return Api31Impl.getDistance(r5);
    }

    public static float onPullDistance(@NonNull EdgeEffect r5, float r10, float r11) {
        return Api31Impl.onPullDistance(r5, r10, r11);
    }

    @Deprecated
    public boolean draw(Canvas r5) {
        return this.mEdgeEffect.draw(r5);
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
    public boolean onAbsorb(int r5) {
        this.mEdgeEffect.onAbsorb(r5);
        return true;
    }

    @Deprecated
    public boolean onPull(float r5) {
        this.mEdgeEffect.onPull(r5);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int r5, int r10) {
        this.mEdgeEffect.setSize(r5, r10);
    }

    @Deprecated
    public boolean onPull(float r5, float r10) {
        onPull(this.mEdgeEffect, r5, r10);
        return true;
    }

    public static void onPull(@NonNull EdgeEffect r5, float r10, float r11) {
        Api21Impl.onPull(r5, r10, r11);
    }
}
