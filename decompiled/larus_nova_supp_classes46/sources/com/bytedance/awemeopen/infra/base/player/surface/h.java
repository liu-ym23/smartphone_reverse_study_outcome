package com.bytedance.awemeopen.infra.base.player.surface;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements TextureView.SurfaceTextureListener {
    public boolean a;
    public final /* synthetic */ i b;

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "surfaceTexture");
    }

    public h(i r1) {
        this.b = r1;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r7) {
        Intrinsics.checkNotNullParameter(r7, "surfaceTexture");
        AoLogger.g("TextureViewHolder", new Object[]{"onSurfaceTextureDestroyed:" + r7 + ", reuse surface: " + this.b.b});
        a.InterfaceC0192a r1 = this.b.f;
        if (r1 == null) goto L6;
        r1.onSurfaceDestroyed();
    L6:
        if (this.b.b == true) goto L8;
        AoLogger.g("TextureViewHolder", new Object[]{"onSurfaceTextureDestroyed: Surface:" + this.b.g + ", SurfaceTexture:" + r7});
        this.b.g = null;
    L8:
        final i r8 = this.b;
        r8.a.post(new g(r8));
        return !this.b.b;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
        Intrinsics.checkNotNullParameter(r2, "surface");
        if (this.a == true) goto L8;
        this.a = true;
        Function0<Unit> r3 = this.b.d;
        if (r3 == null) goto L9;
        r3.invoke();
        return;
    L9:
        return;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "surfaceTexture");
        AoLogger.g("TextureViewHolder", new Object[]{"onSurfaceTextureAvailable: " + this.b.g + ", reuse surface: " + this.b.b});
        if (this.b.g != null) goto L5;
        this.b.g = new Surface(r4);
        AoLogger.g("TextureViewHolder", new Object[]{"onSurfaceTextureAvailable: Surface:" + this.b.g + ", SurfaceTexture:" + r4});
    L5:
        i r7 = this.b;
        if (r7.b == false) goto L8;
        r7.e = r4;
    L8:
        a.InterfaceC0192a r8 = r7.f;
        if (r8 == null) goto L12;
        r8.onSurfaceAvailable();
        return;
    }
}
