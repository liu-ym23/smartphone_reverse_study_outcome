package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
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
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void onPull(EdgeEffect r10, float r11, float r12) {
            r10.onPull(r11, r12);
        }
    }

    @RequiresApi(31)
    private static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static EdgeEffect create(Context r10, AttributeSet r11) {
            return new EdgeEffect(r10, r11);
        L5:
            return new EdgeEffect(r10);
        }

        @DoNotInline
        public static float getDistance(EdgeEffect r10) {
            return r10.getDistance();
        L4:
            return 0.0f;
        }

        @DoNotInline
        public static float onPullDistance(EdgeEffect r10, float r11, float r12) {
            return r10.onPullDistance(r11, r12);
        L4:
            r10.onPull(r11, r12);
            return 0.0f;
        }
    }

    @Deprecated
    public EdgeEffectCompat(Context r10) {
        this.mEdgeEffect = new EdgeEffect(r10);
    }

    @NonNull
    public static EdgeEffect create(@NonNull Context r10, @Nullable AttributeSet r11) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return Api31Impl.create(r10, r11);
    L7:
        return new EdgeEffect(r10);
    }

    public static float getDistance(@NonNull EdgeEffect r10) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return 0.0f;
    L5:
        return Api31Impl.getDistance(r10);
    }

    public static void onPull(@NonNull EdgeEffect r10, float r11, float r12) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Api21Impl.onPull(r10, r11, r12);
        return;
    L5:
        r10.onPull(r11);
    }

    public static float onPullDistance(@NonNull EdgeEffect r10, float r11, float r12) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        onPull(r10, r11, r12);
        return r11;
    L5:
        return Api31Impl.onPullDistance(r10, r11, r12);
    }

    @Deprecated
    public boolean draw(Canvas r10) {
        return this.mEdgeEffect.draw(r10);
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
    public boolean onAbsorb(int r10) {
        this.mEdgeEffect.onAbsorb(r10);
        return true;
    }

    @Deprecated
    public boolean onPull(float r10) {
        this.mEdgeEffect.onPull(r10);
        return true;
    }

    @Deprecated
    public boolean onPull(float r10, float r11) {
        onPull(this.mEdgeEffect, r10, r11);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int r10, int r11) {
        this.mEdgeEffect.setSize(r10, r11);
    }
}
