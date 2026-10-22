package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class FrescoFilterImageView extends FrescoImageView {
    private int mBlurRadius;
    private int mShadowColor;
    private int mShadowOffsetX;
    private int mShadowOffsetY;
    private int mShadowRadius;

    @Keep
    public FrescoFilterImageView(Context r5, AbstractDraweeControllerBuilder r10, @Nullable q r11, @Nullable Object r12, LynxBaseUI r13) {
        super(r5, r10, r11, r12, r13);
    }

    private void configureBounds() {
        if (getTopLevelDrawable() != null) goto L5;
        return;
    L5:
        if (isUseShadowProcessor() == false) goto L9;
        getTopLevelDrawable().setBounds(new Rect(0, 0, getWidth(), getHeight()));
        return;
    }

    private boolean isUseShadowProcessor() {
        if (getWidth() != 0) goto L5;
        return false;
    L5:
        if (getHeight() != 0) goto L7;
        return false;
    L7:
        if (this.mShadowRadius == 0) goto L9;
        return true;
    L9:
        if (this.mShadowColor == 0) goto L11;
        return true;
    L11:
        if (this.mBlurRadius == 0) goto L19;
        return true;
    L19:
        return false;
    }

    public void markShadowDirty() {
        this.mIsDirty = true;
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView
    public void maybeUpdateView() {
        super.maybeUpdateView();
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, android.widget.ImageView, android.view.View
    @Keep
    public void onDraw(Canvas r5) {
        if (getTopLevelDrawable() != null) goto L5;
    L8:
        super.onDraw(r5);
        return;
    L5:
        if (isUseShadowProcessor() == false) goto L8;
        getTopLevelDrawable().draw(r5);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView
    public void onImageRequestLoaded() {
        configureBounds();
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView
    public void onPostprocessorPreparing(List<Postprocessor> r17) {
        if (isUseShadowProcessor() == false) goto L6;
        r17.add(new k(getWidth(), getHeight(), getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), getFrescoScaleType(), this.mShadowOffsetX, this.mShadowOffsetY, this.mShadowColor, this.mShadowRadius, this.mBlurRadius, getContext()));
        return;
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView
    public void setBlurRadius(int r5) {
        if (this.mBlurRadius == r5) goto L6;
        this.mBlurRadius = r5;
        markShadowDirty();
        return;
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView
    public void setBorderRadius(com.lynx.tasm.behavior.ui.utils.d r5) {
        super.setBorderRadius(r5);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int r5, int r10, int r11, int r12) {
        boolean r13 = super.setFrame(r5, r10, r11, r12);
        configureBounds();
        return r13;
    }

    public void setShadowColor(int r5) {
        if (this.mShadowColor == r5) goto L6;
        this.mShadowColor = r5;
        markShadowDirty();
        return;
    }

    public void setShadowOffsetX(int r5) {
        if (this.mShadowOffsetX == r5) goto L6;
        this.mShadowOffsetX = r5;
        markShadowDirty();
        return;
    }

    public void setShadowOffsetY(int r5) {
        if (this.mShadowOffsetY == r5) goto L6;
        this.mShadowOffsetY = r5;
        markShadowDirty();
        return;
    }

    public void setShadowRadius(int r5) {
        if (this.mShadowRadius == r5) goto L6;
        this.mShadowRadius = r5;
        markShadowDirty();
        return;
    }
}
