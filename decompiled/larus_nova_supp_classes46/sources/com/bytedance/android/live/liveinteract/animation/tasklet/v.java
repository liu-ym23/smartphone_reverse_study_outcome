package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v implements Runnable {
    public final /* synthetic */ PathEffectAnimationTasklet a;
    public final /* synthetic */ py.k b;
    public final /* synthetic */ HSImageView c;
    public final /* synthetic */ FrameLayout d;
    public final /* synthetic */ EPointF e;

    public v(PathEffectAnimationTasklet r1, py.k r2, HSImageView r3, FrameLayout r4, EPointF r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        PathEffectAnimationTasklet r1 = this.a;
        py.k r3 = this.b;
        HSImageView r7 = this.c;
        FrameLayout r6 = this.d;
        EPointF r4 = r1.e;
        EPointF r5 = this.e;
        boolean r0 = true;
        ImageRequest[] r8 = a1.b(r3, 1);
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.length == 0) goto L8;
        r0 = false;
    L8:
        if (r0 == false) goto L11;
        return;
    L11:
        if (r1.l != null) goto L13;
        r1.l = r8[0];
    L13:
        PipelineDraweeController r2 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r8).setAutoPlayAnimations(false).setControllerListener(new u(r1, r7, r3, r4, r5, r6)).build();
        if (vm2.d.G() == true) goto L16;
    L18:
        r7.setController(r2);
        return;
    L16:
        if ((r2 instanceof PipelineDraweeController) == false) goto L18;
        com.bytedance.android.live.core.utils.fresco.c.a(r2, r7.getContext(), r8[0].getSourceUri().toString());
        goto L18
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
