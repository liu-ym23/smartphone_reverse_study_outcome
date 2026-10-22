package com.lynx.tasm.ui.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FrescoInlineImageShadowNode extends AbsInlineImageShadowNode {
    public Uri Q;
    public ScalingUtils.ScaleType R;
    public final PipelineDraweeControllerBuilder S;
    public String T;
    public boolean U;
    public boolean V;
    public final a W;
    public int X;
    public CloseableReference<?> Y;
    public boolean Z;

    public class a extends BaseControllerListener {
        public final /* synthetic */ FrescoInlineImageShadowNode a;

        public a(FrescoInlineImageShadowNode r1) {
            this.a = r1;
        }

        public final void onFailure(String r5, Throwable r6) {
            super.onFailure(r5, r6);
            if (r6 != null) goto L5;
            String r7 = "unknown";
        L6:
            this.a.Q(r7);
            LynxError r0 = new LynxError(u7a.b.b(u7a.b.a(r6)), "Failed to load image", NameKeys.UnloadStrategy_No_Strategy, "error");
            r0.setRootCause(r7);
            this.a.getContext().reportResourceError(this.a.T, "image", r0);
            return;
        L5:
            r7 = r6.getMessage();
            goto L6
        }

        public final void onFinalImageSet(String r4, Object r5, Animatable r6) {
            super.onFinalImageSet(r4, r5, r6);
            if ((r5 instanceof CloseableStaticBitmap) == false) goto L17;
            CloseableReference<?> r7 = ((CloseableStaticBitmap) r5).cloneUnderlyingBitmapReference();
            if (r7 != null) goto L8;
            this.a.Q("reference null");
            this.a.getContext().reportResourceError(this.a.T, "image", new LynxError(30102, "Failed to load image，the reason is get null bitmap reference from response", NameKeys.UnloadStrategy_No_Strategy, "error"));
            return;
        L8:
            Bitmap r2 = (Bitmap) r7.get();
            if (r2 != null) goto L12;
            this.a.Q("bitmap null");
            this.a.getContext().reportResourceError(this.a.T, "image", new LynxError(30102, "Failed to load image，the reason is get null bitmap from response", NameKeys.UnloadStrategy_No_Strategy, "error"));
            return;
        L12:
            FrescoInlineImageShadowNode r8 = this.a;
            if (r8.Z == false) goto L15;
            FrescoInlineImageShadowNode.T(r8);
            this.a.Y = r7;
            LLog.i("FrescoInlineImageShadowNode", "clone reference mRef = " + this.a.Y.hashCode());
        L15:
            this.a.R(r2.getWidth(), r2.getHeight());
            return;
        L17:
            if ((r6 instanceof AnimatedDrawable2) == false) goto L21;
            AnimatedDrawable2 r9 = (AnimatedDrawable2) r6;
            int r10 = r9.getIntrinsicWidth();
            int r11 = r9.getIntrinsicHeight();
            r9.setAnimationBackend(new l8a.b(r9.getAnimationBackend(), this.a.X));
            this.a.R(r10, r11);
            m8a.e.c(r9);
            return;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ FrescoInlineImageShadowNode a;

        @Override // java.lang.Runnable
        public final void run() {
            FrescoInlineImageShadowNode.T(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(FrescoInlineImageShadowNode r1) {
            this.a = r1;
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void s() {
        if (this.U == false) goto L14;
        Uri r2 = null;
        if (this.T != null) goto L7;
    L13:
        this.Q = r2;
        this.U = false;
        goto L14
    L7:
        if (this.V == true) goto L9;
        this.T = d7a.a.b(getContext(), this.T, false);
    L9:
        Uri r0 = UriProtector.parse(this.T);
        if (r0.getScheme() != null) goto L12;
        LLog.e("Lynx", "Image src should not be relative url : " + this.T);
        goto L13
    L12:
        r2 = r0;
    L14:
        q();
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void t() {
        if (this.Z == false) goto L6;
        UIThreadUtils.runOnUiThreadImmediately(new b(this));
        return;
    }

    public FrescoInlineImageShadowNode() {
        this.T = null;
        this.U = false;
        this.V = false;
        this.X = 0;
        this.Y = null;
        this.S = Fresco.newDraweeControllerBuilder();
        this.R = ScalingUtils.ScaleType.FIT_XY;
        this.W = new a(this);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final com.lynx.tasm.behavior.ui.text.a O() {
        Resources r2 = getContext().getResources();
        float r0 = this.h.c();
        float r1 = this.h.a();
        return new d(r2, (int) Math.ceil(r0), (int) Math.ceil(r1), this.h.b(), this.Q, this.R, this.S, getContext().getFrescoCallerContext(), this.W);
    }

    public static void T(FrescoInlineImageShadowNode r2) {
        if (r2.Y == null) goto L6;
        LLog.i("FrescoInlineImageShadowNode", "close reference mRef = " + r2.Y.hashCode());
        r2.Y.close();
        r2.Y = null;
        return;
    }

    @LynxProp(name = "loop-count")
    public void setLoopCount(int r1) {
        if (r1 > 0) goto L4;
        r1 = 0;
    L4:
        this.X = r1;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void setMode(String r1) {
        this.R = o.b(r1);
    }

    @LynxProp(defaultBoolean = false, name = "skip-redirection")
    public void setSkipRedirection(boolean r1) {
        this.V = r1;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void setSource(String r1) {
        this.T = r1;
        this.U = true;
        q();
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode, com.lynx.tasm.behavior.shadow.ShadowNode
    public final void w(LynxContext r1) {
        super.w(r1);
        this.Z = r1.getEnableVSyncAligned();
    }
}
