package com.lynx.tasm.ui.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends BaseControllerListener {
    public final /* synthetic */ WeakReference d;
    public final /* synthetic */ String e;
    public final /* synthetic */ FrescoImageView f;

    public l(FrescoImageView r5, WeakReference r10, String r11) {
        this.f = r5;
        this.d = r10;
        this.e = r11;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void a(String r5, Object r10) {
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void b(String r17, Throwable r18) {
        FrescoImageView r5 = this.f;
        a0 r10 = FrescoImageView.access$1100(r5);
        String r11 = this.e;
        if (r11 != null) goto L5;
        r10.getClass();
    L13:
        r5.mIsDirty = true;
        int r12 = mh.e.b(r18);
        int r13 = mh.e.a(r12);
        if (FrescoImageView.access$500(r5) == null) goto L23;
        LynxError r14 = new LynxError(r13, "Android FrescoImageView loading image failed", "", "error");
        if (r18 == null) goto L19;
        String r15 = r18.getMessage();
        r14.g = null;
        r14.f10000o = r15;
    L19:
        if (FrescoImageView.access$1200(r5) == null) goto L21;
        int r16 = FrescoImageView.access$1200(r5).getNodeIndex();
    L22:
        r14.b("node_index", Integer.toString(r16));
        FrescoImageView.access$500(r5).b(r14, r13, r12);
        goto L23
    L21:
        r16 = 0;
    L23:
        FrescoImageView.access$002(r5, -1);
        long r19 = System.currentTimeMillis();
        FrescoImageView.access$1100(r5).p(FrescoImageView.access$1100(r5).f11017u, false, FrescoImageView.access$1000(r5), r19, 0, null);
        a0 r20 = FrescoImageView.access$1100(r5);
        String r110 = FrescoImageView.access$1100(r5).f11017u;
        long r21 = FrescoImageView.access$1000(r5);
        LynxContext r22 = kk.a.i(r20.A);
        if (r20.G == false) goto L26;
        td.c.b(0, r12, r21, r19, r22, r110, false, false);
    L26:
        FrescoImageView.access$1100(r5).m(FrescoImageView.access$1100(r5).f11017u, r12, false, FrescoImageView.access$000(r5), FrescoImageView.access$1000(r5), r19, false, 0, 0);
        LynxLog.b(4, "FrescoImageView", "onFailed src:" + r11 + "with reason" + r18.getMessage());
        return;
    L5:
        if (r11.equals(r10.f11017u) == false) goto L13;
        if (r11.startsWith("http") == false) goto L13;
        int r23 = r10.f11018v;
        r10.f11018v = r23 - 1;
        if (r23 <= 0) goto L13;
        r10.r(r11);
        y r24 = r10.f11022z;
        r24.c();
        r24.e();
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void a(String r11, ImageInfo r12, Animatable r13) {
        if (this.d.get() == null) goto L6;
        ((FrescoImageView) this.d.get()).onImageRequestLoaded();
    L6:
        if (FrescoImageView.access$700(this.f) == false) goto L26;
        if ((r12 instanceof CloseableStaticBitmap) == false) goto L26;
        if (FrescoImageView.access$300(this.f) == null) goto L12;
        FrescoImageView.access$300(this.f).close();
        FrescoImageView.access$302(this.f, null);
    L12:
        FrescoImageView.access$302(this.f, ((CloseableStaticBitmap) r12).e());
        GenericDraweeHierarchy r14 = this.f.getHierarchy();
        if (r14 == null) goto L26;
        if (FrescoImageView.access$300(this.f) == null) goto L26;
        CloseableReference r5 = FrescoImageView.access$300(this.f);
        monitor-enter(r5);
        Object r10 = r5.f7671b.d();     // Catch: Throwable -> L22
        monitor-exit(r5);     // Catch: Throwable -> L22
        if (r10 == null) goto L26;
        r14.a(1, new ScaleTypeDrawable(new BitmapDrawable(this.f.getResources(), (Bitmap) FrescoImageView.access$300(this.f).c()), FrescoImageView.access$800(this.f)));
    L22:
        th = move-exception;
        throw th;
    L26:
        if (FrescoImageView.access$900(this.f) == true) goto L28;
    L30:
        FrescoImageView.access$1100(this.f).h(this.f.getWidth(), this.f.getHeight(), r12, r13, FrescoImageView.access$1000(this.f), false, FrescoImageView.access$000(this.f), FrescoImageView.access$500(this.f));
        return;
    L28:
        if (this.f.getTopLevelDrawable() == null) goto L30;
        this.f.getTopLevelDrawable().setFilterBitmap(false);
        goto L30
    }
}
