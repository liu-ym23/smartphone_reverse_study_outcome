package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.math.MathUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface CircularRevealWidget extends CircularRevealHelper.Delegate {

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.CircularRevealWidget$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {
        public static final TypeEvaluator<RevealInfo> CIRCULAR_REVEAL = null;
        private final RevealInfo revealInfo;

        static {
            CIRCULAR_REVEAL = new CircularRevealEvaluator();
        }

        public CircularRevealEvaluator() {
            this.revealInfo = new RevealInfo(null);
        }

        @Override // android.animation.TypeEvaluator
        @NonNull
        public /* bridge */ /* synthetic */ RevealInfo evaluate(float r5, @NonNull RevealInfo r10, @NonNull RevealInfo r11) {
            return evaluate2(r5, r10, r11);
        }

        @NonNull
        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public RevealInfo evaluate2(float r5, @NonNull RevealInfo r10, @NonNull RevealInfo r11) {
            this.revealInfo.set(MathUtils.lerp(r10.centerX, r11.centerX, r5), MathUtils.lerp(r10.centerY, r11.centerY, r5), MathUtils.lerp(r10.radius, r11.radius, r5));
            return this.revealInfo;
        }
    }

    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {
        public static final Property<CircularRevealWidget, RevealInfo> CIRCULAR_REVEAL = null;

        static {
            CIRCULAR_REVEAL = new CircularRevealProperty("circularReveal");
        }

        private CircularRevealProperty(String r5) {
            super(RevealInfo.class, r5);
        }

        @Override // android.util.Property
        @Nullable
        public /* bridge */ /* synthetic */ RevealInfo get(@NonNull CircularRevealWidget r5) {
            return get2(r5);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(@NonNull CircularRevealWidget r5, @Nullable RevealInfo r10) {
            set2(r5, r10);
        }

        @Nullable
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public RevealInfo get2(@NonNull CircularRevealWidget r5) {
            return r5.getRevealInfo();
        }

        /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(@NonNull CircularRevealWidget r5, @Nullable RevealInfo r10) {
            r5.setRevealInfo(r10);
        }
    }

    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {
        public static final Property<CircularRevealWidget, Integer> CIRCULAR_REVEAL_SCRIM_COLOR = null;

        static {
            CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty("circularRevealScrimColor");
        }

        private CircularRevealScrimColorProperty(String r5) {
            super(Integer.class, r5);
        }

        @Override // android.util.Property
        @NonNull
        public /* bridge */ /* synthetic */ Integer get(@NonNull CircularRevealWidget r5) {
            return get2(r5);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(@NonNull CircularRevealWidget r5, @NonNull Integer r10) {
            set2(r5, r10);
        }

        @NonNull
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public Integer get2(@NonNull CircularRevealWidget r5) {
            return Integer.valueOf(r5.getCircularRevealScrimColor());
        }

        /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(@NonNull CircularRevealWidget r5, @NonNull Integer r10) {
            r5.setCircularRevealScrimColor(r10.intValue());
        }
    }

    public static class RevealInfo {
        public static final float INVALID_RADIUS = Float.MAX_VALUE;
        public float centerX;
        public float centerY;
        public float radius;

        public /* synthetic */ RevealInfo(AnonymousClass1 r5) {
            this();
        }

        public boolean isInvalid() {
            if (this.radius != Float.MAX_VALUE) goto L5;
            return true;
        L5:
            return false;
        }

        public void set(float r5, float r10, float r11) {
            this.centerX = r5;
            this.centerY = r10;
            this.radius = r11;
        }

        private RevealInfo() {
        }

        public RevealInfo(float r5, float r10, float r11) {
            this.centerX = r5;
            this.centerY = r10;
            this.radius = r11;
        }

        public void set(@NonNull RevealInfo r5) {
            set(r5.centerX, r5.centerY, r5.radius);
        }

        public RevealInfo(@NonNull RevealInfo r5) {
            this(r5.centerX, r5.centerY, r5.radius);
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    void draw(Canvas r5);

    @Nullable
    Drawable getCircularRevealOverlayDrawable();

    @ColorInt
    int getCircularRevealScrimColor();

    @Nullable
    RevealInfo getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(@Nullable Drawable r5);

    void setCircularRevealScrimColor(@ColorInt int r5);

    void setRevealInfo(@Nullable RevealInfo r5);
}
