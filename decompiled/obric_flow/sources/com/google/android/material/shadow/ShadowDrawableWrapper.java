package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.constraintlayout.motion.widget.a;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class ShadowDrawableWrapper extends DrawableWrapperCompat {
    static final double COS_45 = 0.0d;
    static final float SHADOW_BOTTOM_SCALE = 1.0f;
    static final float SHADOW_HORIZ_SCALE = 0.5f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean addPaddingForCorners;

    @NonNull
    final RectF contentBounds;
    float cornerRadius;

    @NonNull
    final Paint cornerShadowPaint;
    Path cornerShadowPath;
    private boolean dirty;

    @NonNull
    final Paint edgeShadowPaint;
    float maxShadowSize;
    private boolean printedShadowClipWarning;
    float rawMaxShadowSize;
    float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    float shadowSize;
    private final int shadowStartColor;

    static {
        COS_45 = Math.cos(Math.toRadians(45.0d));
    }

    public ShadowDrawableWrapper(Context r5, Drawable r10, float r11, float r12, float r13) {
        super(r10);
        this.dirty = true;
        this.addPaddingForCorners = true;
        this.printedShadowClipWarning = false;
        this.shadowStartColor = ContextCompat.getColor(r5, R.color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.getColor(r5, R.color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.getColor(r5, R.color.design_fab_shadow_end_color);
        Paint r14 = new Paint(5);
        this.cornerShadowPaint = r14;
        r14.setStyle(Paint.Style.FILL);
        this.cornerRadius = Math.round(r11);
        this.contentBounds = new RectF();
        Paint r15 = new Paint(r14);
        this.edgeShadowPaint = r15;
        r15.setAntiAlias(false);
        setShadowSize(r12, r13);
    }

    private void buildComponents(@NonNull Rect r10) {
        float r5 = this.rawMaxShadowSize;
        float r11 = SHADOW_MULTIPLIER * r5;
        this.contentBounds.set(r10.left + r5, r10.top + r11, r10.right - r5, r10.bottom - r11);
        Drawable r12 = getDrawable();
        RectF r13 = this.contentBounds;
        r12.setBounds((int) r13.left, (int) r13.top, (int) r13.right, (int) r13.bottom);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float r5 = this.cornerRadius;
        RectF r10 = new RectF(-r5, -r5, r5, r5);
        RectF r11 = new RectF(r10);
        float r12 = this.shadowSize;
        r11.inset(-r12, -r12);
        Path r13 = this.cornerShadowPath;
        if (r13 != null) goto L5;
        this.cornerShadowPath = new Path();
    L6:
        this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
        this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
        this.cornerShadowPath.arcTo(r11, 180.0f, 90.0f, false);
        this.cornerShadowPath.arcTo(r10, 270.0f, -90.0f, false);
        this.cornerShadowPath.close();
        float r14 = -r11.top;
        if (r14 <= 0.0f) goto L9;
        float r15 = this.cornerRadius / r14;
        float r16 = a.a(1.0f, r15, 2.0f, r15);
        this.cornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, r14, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, r15, r16, 1.0f}, Shader.TileMode.CLAMP));
    L9:
        this.edgeShadowPaint.setShader(new LinearGradient(0.0f, r10.top, 0.0f, r11.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.edgeShadowPaint.setAntiAlias(false);
        return;
    L5:
        r13.reset();
        goto L6
    }

    public static float calculateHorizontalPadding(float r10, float r11, boolean r12) {
        if (r12 == true) goto L4;
        return r10;
    L4:
        return (float) (((1.0d - COS_45) * ((double) r11)) + r10);
    }

    public static float calculateVerticalPadding(float r10, float r11, boolean r12) {
        if (r12 == false) goto L7;
        return (float) (((1.0d - COS_45) * ((double) r11)) + (r10 * SHADOW_MULTIPLIER));
    L7:
        return r10 * SHADOW_MULTIPLIER;
    }

    private void drawShadow(@NonNull Canvas r21) {
        int r10 = r21.save();
        r21.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
        float r11 = this.cornerRadius;
        float r12 = (-r11) - this.shadowSize;
        float r13 = r11 * 2.0f;
        if ((this.contentBounds.width() - r13) <= 0.0f) goto L5;
        boolean r14 = true;
    L7:
        if ((this.contentBounds.height() - r13) <= 0.0f) goto L9;
        boolean r15 = true;
    L10:
        float r5 = this.rawShadowSize;
        float r16 = r11 / ((r5 - (0.5f * r5)) + r11);
        float r17 = r11 / ((r5 - (SHADOW_TOP_SCALE * r5)) + r11);
        float r18 = r11 / ((r5 - (r5 * 1.0f)) + r11);
        int r19 = r21.save();
        RectF r20 = this.contentBounds;
        r21.translate(r20.left + r11, r20.top + r11);
        r21.scale(r16, r17);
        r21.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r14 == false) goto L14;
        r21.scale(1.0f / r16, 1.0f);
        r21.drawRect(0.0f, r12, this.contentBounds.width() - r13, -this.cornerRadius, this.edgeShadowPaint);
    L14:
        r21.restoreToCount(r19);
        int r110 = r21.save();
        RectF r22 = this.contentBounds;
        r21.translate(r22.right - r11, r22.bottom - r11);
        r21.scale(r16, r18);
        r21.rotate(180.0f);
        r21.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r14 == false) goto L18;
        r21.scale(1.0f / r16, 1.0f);
        r21.drawRect(0.0f, r12, this.contentBounds.width() - r13, (-this.cornerRadius) + this.shadowSize, this.edgeShadowPaint);
    L18:
        r21.restoreToCount(r110);
        int r111 = r21.save();
        RectF r23 = this.contentBounds;
        r21.translate(r23.left + r11, r23.bottom - r11);
        r21.scale(r16, r6);
        r21.rotate(270.0f);
        r21.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r15 == false) goto L21;
        r21.scale(1.0f / r18, 1.0f);
        r21.drawRect(0.0f, r12, this.contentBounds.height() - r13, -this.cornerRadius, this.edgeShadowPaint);
    L21:
        r21.restoreToCount(r111);
        int r24 = r21.save();
        RectF r25 = this.contentBounds;
        r21.translate(r25.right - r11, r25.top + r11);
        r21.scale(r16, r17);
        r21.rotate(90.0f);
        r21.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r15 == false) goto L24;
        r21.scale(1.0f / r17, 1.0f);
        r21.drawRect(0.0f, r12, this.contentBounds.height() - r13, -this.cornerRadius, this.edgeShadowPaint);
    L24:
        r21.restoreToCount(r24);
        r21.restoreToCount(r10);
        return;
    L9:
        r15 = false;
        goto L10
    L5:
        r14 = false;
        goto L7
    }

    private static int toEven(float r5) {
        int r10 = Math.round(r5);
        if ((r10 % 2) == 1) goto L5;
        return r10;
    L5:
        return r10 - 1;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r5) {
        if (this.dirty == false) goto L5;
        buildComponents(getBounds());
        this.dirty = false;
    L5:
        drawShadow(r5);
        super.draw(r5);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getMinHeight() {
        float r5 = this.rawMaxShadowSize;
        float r10 = this.cornerRadius;
        float r11 = Math.max(r5, ((r5 * SHADOW_MULTIPLIER) / 2.0f) + r10) * 2.0f;
        return ((this.rawMaxShadowSize * SHADOW_MULTIPLIER) * 2.0f) + r11;
    }

    public float getMinWidth() {
        float r5 = this.rawMaxShadowSize;
        float r10 = r5 / 2.0f;
        float r11 = Math.max(r5, r10 + this.cornerRadius) * 2.0f;
        return (this.rawMaxShadowSize * 2.0f) + r11;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect r5) {
        int r10 = (int) Math.ceil(calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        int r11 = (int) Math.ceil(calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        r5.set(r11, r10, r11, r10);
        return true;
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r5) {
        this.dirty = true;
    }

    public void setAddPaddingForCorners(boolean r5) {
        this.addPaddingForCorners = r5;
        invalidateSelf();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public void setAlpha(int r5) {
        super.setAlpha(r5);
        this.cornerShadowPaint.setAlpha(r5);
        this.edgeShadowPaint.setAlpha(r5);
    }

    public void setCornerRadius(float r5) {
        float r10 = Math.round(r5);
        if (this.cornerRadius != r10) goto L5;
        return;
    L5:
        this.cornerRadius = r10;
        this.dirty = true;
        invalidateSelf();
    }

    public void setMaxShadowSize(float r5) {
        setShadowSize(this.rawShadowSize, r5);
    }

    public final void setRotation(float r5) {
        if (this.rotation == r5) goto L6;
        this.rotation = r5;
        invalidateSelf();
        return;
    }

    public void setShadowSize(float r5, float r10) {
        if (r5 < 0.0f) goto L20;
        if (r10 < 0.0f) goto L20;
        float r11 = toEven(r5);
        float r12 = toEven(r10);
        if (r11 <= r12) goto L13;
        if (this.printedShadowClipWarning == true) goto L11;
        this.printedShadowClipWarning = true;
    L11:
        r11 = r12;
    L13:
        if (this.rawShadowSize == r11) goto L15;
    L17:
        this.rawShadowSize = r11;
        this.rawMaxShadowSize = r12;
        this.shadowSize = Math.round(r11 * SHADOW_MULTIPLIER);
        this.maxShadowSize = r12;
        this.dirty = true;
        invalidateSelf();
        return;
    L15:
        if (this.rawMaxShadowSize != r12) goto L17;
        return;
    L20:
        throw new IllegalArgumentException("invalid shadow size");
    }

    public void setShadowSize(float r5) {
        setShadowSize(r5, this.rawMaxShadowSize);
    }
}
