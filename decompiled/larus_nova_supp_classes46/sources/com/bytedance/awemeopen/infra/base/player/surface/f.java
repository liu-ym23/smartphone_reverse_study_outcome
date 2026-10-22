package com.bytedance.awemeopen.infra.base.player.surface;

import android.graphics.SurfaceTexture;
import android.view.View;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements View.OnAttachStateChangeListener {
    public final /* synthetic */ i a;

    public f(i r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        i r0 = this.a;
        if (Intrinsics.areEqual(r0.e, r0.c) == true) goto L7;
        i r1 = this.a;
        SurfaceTexture r2 = r1.c;
        if (r2 == null) goto L7;
        r1.a.setSurfaceTexture(r2);
        r1.e = r2;
    L7:
        AoLogger.g("TextureViewHolder", new Object[]{"onViewAttachedToWindow:" + r4 + ", preset texture: " + this.a.c});
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        AoLogger.g("TextureViewHolder", new Object[]{"onViewDetachedFromWindow:" + r4});
        i r5 = this.a;
        SurfaceTexture r0 = r5.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r5.b == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r5.a.getSurfaceTexture(), r0) == true) goto L12;
        r5.a.setSurfaceTexture(r0);
        return;
    }
}
