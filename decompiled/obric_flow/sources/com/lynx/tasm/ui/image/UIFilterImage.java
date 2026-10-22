package com.lynx.tasm.ui.image;

import android.content.Context;
import android.view.View;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.utils.ColorUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UIFilterImage extends UIImage<FrescoFilterImageView> {
    public static /* synthetic */ Map b(UIFilterImage r5) {
        return r5.mEvents;
    }

    public static /* synthetic */ Map c(UIFilterImage r5) {
        return r5.mEvents;
    }

    @Override // com.lynx.tasm.ui.image.UIImage, com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r10) {
        this.mDraweeControllerBuilder = ((PipelineDraweeControllerBuilderSupplier) Fresco.f7726a.a()).a();
        AbstractDraweeControllerBuilder r5 = this.mDraweeControllerBuilder;
        getLynxContext().getClass();
        FrescoFilterImageView r11 = new FrescoFilterImageView(r10, r5, null, null, this);
        r11.setImageLoaderCallback(new c(this, 1));
        return r11;
    }

    @Override // com.lynx.tasm.ui.image.UIImage, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        ((FrescoFilterImageView) this.mView).markShadowDirty();
    }

    @com.lynx.tasm.behavior.c0(name = "drop-shadow")
    public void setDropShadow(String r12) {
        if (r12 != null) goto L6;
        ((FrescoFilterImageView) this.mView).setShadowOffsetX(0);
        ((FrescoFilterImageView) this.mView).setShadowOffsetY(0);
        ((FrescoFilterImageView) this.mView).setShadowColor(0);
        ((FrescoFilterImageView) this.mView).setShadowRadius(0);
        return;
    L6:
        String[] r13 = r12.split(" +");
        if (r13.length != 4) goto L11;
        UIBody r5 = this.mContext.f10145m;     // Catch: Exception -> L13
        ((FrescoFilterImageView) this.mView).setShadowOffsetX(Math.round(com.lynx.tasm.utils.k.c(r13[0], r5.getFontSize(), this.mFontSize, r5.getWidth(), r5.getHeight(), 0.0f, this.mContext.f10152u)));     // Catch: Exception -> L13
        ((FrescoFilterImageView) this.mView).setShadowOffsetY(Math.round(com.lynx.tasm.utils.k.c(r13[1], r5.getFontSize(), this.mFontSize, r5.getWidth(), r5.getHeight(), 0.0f, this.mContext.f10152u)));     // Catch: Exception -> L13
        ((FrescoFilterImageView) this.mView).setShadowRadius(Math.round(com.lynx.tasm.utils.k.c(r13[2], r5.getFontSize(), this.mFontSize, r5.getWidth(), r5.getHeight(), 0.0f, this.mContext.f10152u)));     // Catch: Exception -> L13
        ((FrescoFilterImageView) this.mView).setShadowColor(ColorUtils.b(r13[3]));     // Catch: Exception -> L13
        return;
    L11:
        LynxLog.b(3, "UIShadowImage", "Parse error for drop-shadow!");
    }

    @Override // com.lynx.tasm.ui.image.UIImage, com.lynx.tasm.behavior.ui.LynxUI
    public final FrescoImageView createView(Context r10) {
        this.mDraweeControllerBuilder = ((PipelineDraweeControllerBuilderSupplier) Fresco.f7726a.a()).a();
        AbstractDraweeControllerBuilder r5 = this.mDraweeControllerBuilder;
        getLynxContext().getClass();
        FrescoFilterImageView r11 = new FrescoFilterImageView(r10, r5, null, null, this);
        r11.setImageLoaderCallback(new c(this, 1));
        return r11;
    }
}
