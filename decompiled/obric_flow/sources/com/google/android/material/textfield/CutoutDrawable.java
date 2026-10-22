package com.google.android.material.textfield;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes2.dex */
class CutoutDrawable extends MaterialShapeDrawable {

    @NonNull
    CutoutDrawableState drawableState;

    /* JADX INFO: renamed from: com.google.android.material.textfield.CutoutDrawable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class CutoutDrawableState extends MaterialShapeDrawable.MaterialShapeDrawableState {

        @NonNull
        private final RectF cutoutBounds;

        public /* synthetic */ CutoutDrawableState(ShapeAppearanceModel r5, RectF r10, AnonymousClass1 r11) {
            this(r5, r10);
        }

        public static /* synthetic */ RectF access$200(CutoutDrawableState r5) {
            return r5.cutoutBounds;
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            CutoutDrawable r5 = CutoutDrawable.access$400(this);
            r5.invalidateSelf();
            return r5;
        }

        public /* synthetic */ CutoutDrawableState(CutoutDrawableState r5, AnonymousClass1 r10) {
            this(r5);
        }

        private CutoutDrawableState(@NonNull ShapeAppearanceModel r5, @NonNull RectF r10) {
            super(r5, null);
            this.cutoutBounds = r10;
        }

        private CutoutDrawableState(@NonNull CutoutDrawableState r5) {
            super(r5);
            this.cutoutBounds = r5.cutoutBounds;
        }
    }

    public static class ImplApi14 extends CutoutDrawable {
        private Paint cutoutPaint;
        private int savedLayer;

        public ImplApi14(@NonNull CutoutDrawableState r5) {
            super(r5, null);
        }

        private Paint getCutoutPaint() {
            if (this.cutoutPaint != null) goto L6;
            Paint r5 = new Paint(1);
            this.cutoutPaint = r5;
            r5.setStyle(Paint.Style.FILL_AND_STROKE);
            this.cutoutPaint.setColor(-1);
            this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        L6:
            return this.cutoutPaint;
        }

        private void postDraw(@NonNull Canvas r5) {
            if (useHardwareLayer(getCallback()) == true) goto L6;
            r5.restoreToCount(this.savedLayer);
            return;
        }

        private void preDraw(@NonNull Canvas r5) {
            Drawable.Callback r10 = getCallback();
            if (useHardwareLayer(r10) == false) goto L7;
            View r11 = (View) r10;
            if (r11.getLayerType() == 2) goto L9;
            r11.setLayerType(2, null);
            return;
        L9:
            return;
        L7:
            saveCanvasLayer(r5);
        }

        private void saveCanvasLayer(@NonNull Canvas r10) {
            this.savedLayer = r10.saveLayer(0.0f, 0.0f, r10.getWidth(), r10.getHeight(), null);
        }

        private boolean useHardwareLayer(Drawable.Callback r5) {
            return r5 instanceof View;
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas r5) {
            preDraw(r5);
            super.draw(r5);
            postDraw(r5);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable
        public void drawStrokeShape(@NonNull Canvas r5) {
            super.drawStrokeShape(r5);
            r5.drawRect(CutoutDrawableState.access$200(this.drawableState), getCutoutPaint());
        }
    }

    @TargetApi(18)
    public static class ImplApi18 extends CutoutDrawable {
        public ImplApi18(@NonNull CutoutDrawableState r5) {
            super(r5, null);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable
        public void drawStrokeShape(@NonNull Canvas r5) {
            if (CutoutDrawableState.access$200(this.drawableState).isEmpty() == false) goto L5;
            super.drawStrokeShape(r5);
            return;
        L5:
            r5.save();
            r5.clipOutRect(CutoutDrawableState.access$200(this.drawableState));
            super.drawStrokeShape(r5);
            r5.restore();
        }
    }

    public /* synthetic */ CutoutDrawable(CutoutDrawableState r5, AnonymousClass1 r10) {
        this(r5);
    }

    public static /* synthetic */ CutoutDrawable access$400(CutoutDrawableState r5) {
        return create(r5);
    }

    public static CutoutDrawable create(@Nullable ShapeAppearanceModel r5) {
        if (r5 != null) goto L7;
        r5 = new ShapeAppearanceModel();
    L7:
        return create(new CutoutDrawableState(r5, new RectF(), null));
    }

    public boolean hasCutout() {
        return !CutoutDrawableState.access$200(this.drawableState).isEmpty();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.drawableState = new CutoutDrawableState(this.drawableState, null);
        return this;
    }

    public void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void setCutout(float r5, float r10, float r11, float r12) {
        if (r5 == CutoutDrawableState.access$200(this.drawableState).left) goto L5;
    L10:
        CutoutDrawableState.access$200(this.drawableState).set(r5, r10, r11, r12);
        invalidateSelf();
        return;
    L5:
        if (r10 != CutoutDrawableState.access$200(this.drawableState).top) goto L10;
        if (r11 != CutoutDrawableState.access$200(this.drawableState).right) goto L10;
        if (r12 != CutoutDrawableState.access$200(this.drawableState).bottom) goto L10;
    }

    private CutoutDrawable(@NonNull CutoutDrawableState r5) {
        super(r5);
        this.drawableState = r5;
    }

    private static CutoutDrawable create(@NonNull CutoutDrawableState r5) {
        return new ImplApi18(r5);
    }

    public void setCutout(@NonNull RectF r5) {
        setCutout(r5.left, r5.top, r5.right, r5.bottom);
    }
}
