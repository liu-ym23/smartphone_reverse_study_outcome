package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ScalingUtils {

    public static abstract class AbstractScaleType implements ScaleType {
        public AbstractScaleType() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public final Matrix a(Matrix r11, Rect r12, int r13, int r14, float r15, float r16) {
            a(r11, r12, r13, r14, r15, r16, r12.width() / r13, r12.height() / r14);
            return r11;
        }

        public abstract void a(Matrix r5, Rect r10, int r11, int r12, float r13, float r14, float r15, float r16);
    }

    public interface ScaleType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ScaleType f7893a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ScaleType f7894b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final ScaleType f7895c = null;
        public static final ScaleType d = null;
        public static final ScaleType e = null;
        public static final ScaleType f = null;
        public static final ScaleType g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final ScaleType f7896h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final ScaleType f7897i = null;

        static {
            f7893a = ScaleTypeFitXY.f7905j;
            f7894b = ScaleTypeFitStart.f7904j;
            f7895c = ScaleTypeFitCenter.f7902j;
            d = ScaleTypeFitEnd.f7903j;
            e = ScaleTypeCenter.f7898j;
            f = ScaleTypeCenterInside.f7900j;
            g = ScaleTypeCenterCrop.f7899j;
            f7896h = ScaleTypeFocusCrop.f7906j;
            f7897i = ScaleTypeFitBottomStart.f7901j;
        }

        Matrix a(Matrix r5, Rect r10, int r11, int r12, float r13, float r14);
    }

    public static class ScaleTypeCenter extends AbstractScaleType {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final ScaleType f7898j = null;

        static {
            f7898j = new ScaleTypeCenter();
        }

        public ScaleTypeCenter() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void a(Matrix r5, Rect r10, int r11, int r12, float r13, float r14, float r15, float r16) {
            r5.setTranslate((int) ((((r10.width() - r11) * 0.5f) + r10.left) + 0.5f), (int) ((((r10.height() - r12) * 0.5f) + r10.top) + 0.5f));
        }

        public final String toString() {
            return "center";
        }
    }

    public static class ScaleTypeCenterCrop extends AbstractScaleType {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final ScaleType f7899j = null;

        static {
            f7899j = new ScaleTypeCenterCrop();
        }

        public ScaleTypeCenterCrop() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void a(Matrix r5, Rect r10, int r11, int r12, float r13, float r14, float r15, float r16) {
            if (r16 <= r15) goto L5;
            float r17 = ((r10.width() - (r11 * r16)) * 0.5f) + r10.left;
            float r18 = r10.top;
            r15 = r16;
        L6:
            r5.setScale(r15, r15);
            r5.postTranslate((int) (r17 + 0.5f), (int) (r18 + 0.5f));
            return;
        L5:
            float r19 = r10.left;
            float r20 = ((r10.height() - (r12 * r15)) * 0.5f) + r10.top;
            r17 = r19;
            r18 = r20;
            goto L6
        }

        public final String toString() {
            return "center_crop";
        }
    }

    public static class ScaleTypeCenterInside extends AbstractScaleType {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final ScaleType f7900j = null;

        static {
            f7900j = new ScaleTypeCenterInside();
        }

        public ScaleTypeCenterInside() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void a(Matrix r5, Rect r10, int r11, int r12, float r13, float r14, float r15, float r16) {
            float r17 = Math.min(Math.min(r15, r16), 1.0f);
            float r18 = ((r10.width() - (r11 * r17)) * 0.5f) + r10.left;
            float r19 = ((r10.height() - (r12 * r17)) * 0.5f) + r10.top;
            r5.setScale(r17, r17);
            r5.postTranslate((int) (r18 + 0.5f), (int) (r19 + 0.5f));
        }

        public final String toString() {
            return "center_inside";
        }
    }

    public static class ScaleTypeFitBottomStart extends AbstractScaleType {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final ScaleType f7901j = null;

        static {
            f7901j = new ScaleTypeFitBottomStart();
        }

        public ScaleTypeFitBottomStart() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void a(Matrix r5, Rect r10, int r11, int r12, float r13, float r14, float r15, float r16) {
            float r17 = Math.min(r15, r16);
            float r18 = r10.left;
            float r19 = (r10.height() - (r12 * r17)) + r10.top;
            r5.setScale(r17, r17);
            r5.postTranslate((int) (r18 + 0.5f), (int) (r19 + 0.5f));
        }

        public final String toString() {
            return "fit_bottom_start";
        }
    }

    public static class ScaleTypeFitCenter extends AbstractScaleType {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final ScaleType f7902j = null;

        static {
            f7902j = new ScaleTypeFitCenter();
        }

        public ScaleTypeFitCenter() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void a(Matrix r5, Rect r10, int r11, int r12, float r13, float r14, float r15, float r16) {
            float r17 = Math.min(r15, r16);
            float r18 = ((r10.width() - (r11 * r17)) * 0.5f) + r10.left;
            float r19 = ((r10.height() - (r12 * r17)) * 0.5f) + r10.top;
            r5.setScale(r17, r17);
            r5.postTranslate((int) (r18 + 0.5f), (int) (r19 + 0.5f));
        }

        public final String toString() {
            return "fit_center";
        }
    }

    public static class ScaleTypeFitEnd extends AbstractScaleType {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final ScaleType f7903j = null;

        static {
            f7903j = new ScaleTypeFitEnd();
        }

        public ScaleTypeFitEnd() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void a(Matrix r5, Rect r10, int r11, int r12, float r13, float r14, float r15, float r16) {
            float r17 = Math.min(r15, r16);
            float r18 = (r10.width() - (r11 * r17)) + r10.left;
            float r19 = (r10.height() - (r12 * r17)) + r10.top;
            r5.setScale(r17, r17);
            r5.postTranslate((int) (r18 + 0.5f), (int) (r19 + 0.5f));
        }

        public final String toString() {
            return "fit_end";
        }
    }

    public static class ScaleTypeFitStart extends AbstractScaleType {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final ScaleType f7904j = null;

        static {
            f7904j = new ScaleTypeFitStart();
        }

        public ScaleTypeFitStart() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void a(Matrix r5, Rect r10, int r11, int r12, float r13, float r14, float r15, float r16) {
            float r17 = Math.min(r15, r16);
            float r18 = r10.left;
            float r19 = r10.top;
            r5.setScale(r17, r17);
            r5.postTranslate((int) (r18 + 0.5f), (int) (r19 + 0.5f));
        }

        public final String toString() {
            return "fit_start";
        }
    }

    public static class ScaleTypeFitXY extends AbstractScaleType {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final ScaleType f7905j = null;

        static {
            f7905j = new ScaleTypeFitXY();
        }

        public ScaleTypeFitXY() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void a(Matrix r5, Rect r10, int r11, int r12, float r13, float r14, float r15, float r16) {
            float r17 = r10.left;
            float r18 = r10.top;
            r5.setScale(r15, r16);
            r5.postTranslate((int) (r17 + 0.5f), (int) (r18 + 0.5f));
        }

        public final String toString() {
            return "fit_xy";
        }
    }

    public static class ScaleTypeFocusCrop extends AbstractScaleType {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final ScaleType f7906j = null;

        static {
            f7906j = new ScaleTypeFocusCrop();
        }

        public ScaleTypeFocusCrop() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void a(Matrix r5, Rect r10, int r11, int r12, float r13, float r14, float r15, float r16) {
            if (r16 <= r15) goto L5;
            float r17 = r11 * r16;
            float r18 = (r10.width() * 0.5f) - (r13 * r17);
            float r19 = Math.max(Math.min(r18, 0.0f), r10.width() - r17) + r10.left;
            float r20 = r10.top;
            r15 = r16;
        L6:
            r5.setScale(r15, r15);
            r5.postTranslate((int) (r19 + 0.5f), (int) (r20 + 0.5f));
            return;
        L5:
            r19 = r10.left;
            float r21 = r12 * r15;
            float r22 = (r10.height() * 0.5f) - (r14 * r21);
            r20 = Math.max(Math.min(r22, 0.0f), r10.height() - r21) + r10.top;
            goto L6
        }

        public final String toString() {
            return "focus_crop";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ScaleTypeDrawable a(Drawable r5) {
        if (r5 != 0) goto L6;
        return null;
    L6:
        if ((r5 instanceof ScaleTypeDrawable) == false) goto L10;
        return (ScaleTypeDrawable) r5;
    L10:
        if ((r5 instanceof DrawableParent) == false) goto L14;
        return a(((DrawableParent) r5).c());
    L14:
        if ((r5 instanceof ArrayDrawable) == false) goto L21;
        ArrayDrawable r10 = (ArrayDrawable) r5;
        int r11 = r10.f7831c.length;
        int r12 = 0;
    L16:
        if (r12 >= r11) goto L21;
        ScaleTypeDrawable r13 = a(r10.a(r12));
        if (r13 != null) goto L19;
        r12 = r12 + 1;
        goto L16
    L19:
        return r13;
    L21:
        return null;
    }
}
