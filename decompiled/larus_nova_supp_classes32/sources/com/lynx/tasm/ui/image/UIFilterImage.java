package com.lynx.tasm.ui.image;

import android.content.Context;
import android.view.View;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.utils.ColorUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIFilterImage extends UIImage<FrescoFilterImageView> {

    public class a extends l {
        public final /* synthetic */ UIFilterImage a;

        public a(UIFilterImage r1) {
            this.a = r1;
        }

        @Override // com.lynx.tasm.ui.image.l
        public final void onImageLoadSuccess(int r4, int r5) {
            if (UIFilterImage.M(this.a) != null) goto L5;
            return;
        L5:
            if (UIFilterImage.N(this.a).containsKey("load") == false) goto L9;
            m7a.a r0 = new m7a.a(this.a.getSign(), "load");
            r0.a("height", Integer.valueOf(r5));
            r0.a("width", Integer.valueOf(r4));
            this.a.getLynxContext().getEventEmitter().sendCustomEvent(r0);
            return;
        }

        @Override // com.lynx.tasm.ui.image.l
        public final void onImageLoadFailed(LynxError r4, int r5, int r6) {
            if (r4 != null) goto L4;
            return;
        L4:
            m7a.a r0 = new m7a.a(this.a.getSign(), "error");
            r0.a("errMsg", r4.getSummaryMessage() + ": " + r4.getRootCause());
            r0.a("lynx_categorized_code", Integer.valueOf(r5));
            r0.a("error_code", Integer.valueOf(r6));
            this.a.getLynxContext().getEventEmitter().sendCustomEvent(r0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.ui.image.UIImage, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        ((FrescoFilterImageView) this.mView).markShadowDirty();
    }

    public UIFilterImage(LynxContext r2) {
        super(r2, null);
    }

    public static /* synthetic */ Map M(UIFilterImage r0) {
        return r0.mEvents;
    }

    public static /* synthetic */ Map N(UIFilterImage r0) {
        return r0.mEvents;
    }

    public final FrescoFilterImageView O(Context r8) {
        this.mDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        FrescoFilterImageView r0 = new FrescoFilterImageView(r8, this.mDraweeControllerBuilder, null, getLynxContext().getFrescoCallerContext(), this);
        r0.setImageLoaderCallback(new a(this));
        return r0;
    }

    @Override // com.lynx.tasm.ui.image.UIImage, com.lynx.tasm.behavior.ui.LynxUI
    public final /* bridge */ /* synthetic */ View createView(Context r1) {
        return O(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "drop-shadow")
    public void setDropShadow(String r13) {
        boolean r0 = false;
        if (r13 != null) goto L5;
        ((FrescoFilterImageView) this.mView).setShadowOffsetX(0);
        ((FrescoFilterImageView) this.mView).setShadowOffsetY(0);
        ((FrescoFilterImageView) this.mView).setShadowColor(0);
        ((FrescoFilterImageView) this.mView).setShadowRadius(0);
        return;
    L5:
        String[] r14 = r13.split(" +");
        boolean r1 = true;
        if (r14.length != 4) goto L10;
        UIBody r2 = this.mContext.getUIBody();     // Catch: Exception -> L12
        ((FrescoFilterImageView) this.mView).setShadowOffsetX(Math.round(com.lynx.tasm.utils.n.b(r14[0], r2.getFontSize(), this.mFontSize, r2.getWidth(), r2.getHeight(), 0.0f, this.mContext.getScreenMetrics())));     // Catch: Exception -> L12
        ((FrescoFilterImageView) this.mView).setShadowOffsetY(Math.round(com.lynx.tasm.utils.n.b(r14[1], r2.getFontSize(), this.mFontSize, r2.getWidth(), r2.getHeight(), 0.0f, this.mContext.getScreenMetrics())));     // Catch: Exception -> L12
        ((FrescoFilterImageView) this.mView).setShadowRadius(Math.round(com.lynx.tasm.utils.n.b(r14[2], r2.getFontSize(), this.mFontSize, r2.getWidth(), r2.getHeight(), 0.0f, this.mContext.getScreenMetrics())));     // Catch: Exception -> L12
        ((FrescoFilterImageView) this.mView).setShadowColor(ColorUtils.b(r14[3]));     // Catch: Exception -> L12
    L11:
        r1 = r0;
        goto L13
    L10:
        r0 = true;
    L13:
        if (r1 == false) goto L19;
        LLog.w("UIShadowImage", "Parse error for drop-shadow!");
        return;
    }

    @Override // com.lynx.tasm.ui.image.UIImage
    /* JADX INFO: renamed from: createView, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ FrescoImageView mo28createView(Context r1) {
        return O(r1);
    }

    public UIFilterImage(LynxContext r1, Object r2) {
        super(r1, r2);
    }
}
