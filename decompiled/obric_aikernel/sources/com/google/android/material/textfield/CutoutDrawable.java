package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;

/* JADX INFO: loaded from: classes.dex */
class CutoutDrawable extends MaterialShapeDrawable {

    @NonNull
    private final RectF cutoutBounds;

    @NonNull
    private final Paint cutoutPaint;

    CutoutDrawable() {
        this(null);
    }

    CutoutDrawable(@Nullable l r10) {
        if (r10 != null) goto L5;
        r10 = new l();
    L5:
        super(r10);
        this.cutoutPaint = new Paint(1);
        setPaintStyles();
        this.cutoutBounds = new RectF();
    }

    private void setPaintStyles() {
        this.cutoutPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.cutoutPaint.setColor(-1);
        this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable
    protected void drawStrokeShape(@NonNull Canvas r10) {
        if (this.cutoutBounds.isEmpty() == false) goto L5;
        super.drawStrokeShape(r10);
        return;
    L5:
        r10.save();
        if (Build.VERSION.SDK_INT < 26) goto L8;
        r10.clipOutRect(this.cutoutBounds);
    L9:
        super.drawStrokeShape(r10);
        r10.restore();
        return;
    L8:
        r10.clipRect(this.cutoutBounds, Region.Op.DIFFERENCE);
        goto L9
    }

    boolean hasCutout() {
        return !this.cutoutBounds.isEmpty();
    }

    void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void setCutout(float r10, float r11, float r12, float r13) {
        RectF r14 = this.cutoutBounds;
        if (r10 == r14.left) goto L5;
    L10:
        r14.set(r10, r11, r12, r13);
        invalidateSelf();
        return;
    L5:
        if (r11 != r14.top) goto L10;
        if (r12 != r14.right) goto L10;
        if (r13 != r14.bottom) goto L10;
    }

    void setCutout(@NonNull RectF r10) {
        setCutout(r10.left, r10.top, r10.right, r10.bottom);
    }
}
