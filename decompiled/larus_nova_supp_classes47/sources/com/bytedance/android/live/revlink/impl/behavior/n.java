package com.bytedance.android.live.revlink.impl.behavior;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.utils.p0;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements p0 {
    public final /* synthetic */ m0 a;
    public final /* synthetic */ f b;

    public final /* synthetic */ void b(py.k r1, Exception r2) {
    }

    public final void c(py.k r1, int r2, int r3, boolean r4) {
    }

    public final /* synthetic */ void d(ImageInfo r1) {
    }

    public final /* synthetic */ void e(py.k r1) {
    }

    public n(m0 r1, f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(ImageInfo r5, Animatable r6) {
        if ((r6 instanceof AnimatedDrawable2) == true) goto L5;
        r6 = null;
    L5:
        AnimatedDrawable2 r7 = (AnimatedDrawable2) r6;
        this.a.a();
        if (r7 == null) goto L11;
        AnimationBackend r8 = r7.getAnimationBackend();
        if (r8 == null) goto L11;
        r7.setAnimationBackend(new g(r8));
    L11:
        if (r7 == null) goto L13;
        int r1 = r7.getFrameCount();
    L14:
        if (r7 == null) goto L16;
        r7.setAnimationListener(new l(this, r1, r7));
    L16:
        f r2 = this.b;
        r2.sendMessageDelayed(r2.obtainMessage(1, new m(this, r7)), ((Number) o.b.getValue(null, o.a[0])).longValue());
        return;
    L13:
        r1 = 0;
        goto L14
    }
}
