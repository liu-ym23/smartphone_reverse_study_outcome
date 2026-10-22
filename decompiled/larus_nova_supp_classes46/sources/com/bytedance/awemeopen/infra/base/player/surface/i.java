package com.bytedance.awemeopen.infra.base.player.surface;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements com.bytedance.awemeopen.infra.base.player.surface.a {
    public final TextureView a;
    public final boolean b;
    public final SurfaceTexture c;
    public final Function0<Unit> d;
    public SurfaceTexture e;
    public com.bytedance.awemeopen.infra.base.player.surface.a.InterfaceC0192a f;
    public volatile Surface g;

    public static final class a {
    }

    static {
    }

    public i() {
        throw null;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.surface.a
    public final void release() {
        boolean r0 = !Intrinsics.areEqual(this.e, this.c);
        AoLogger.g("TextureViewHolder", new Object[]{"release: Surface:" + this.g + ", SurfaceTexture:" + this.e + ", release texture: " + r0});
        if (r0 == false) goto L8;
        SurfaceTexture r1 = this.e;
        if (r1 == null) goto L7;
        r1.release();
    L7:
        this.e = null;
    L8:
        Surface r2 = this.g;
        if (r2 == null) goto L11;
        r2.release();
    L11:
        this.g = null;
        this.a.setSurfaceTextureListener(null);
    }

    @Override // com.bytedance.awemeopen.infra.base.player.surface.a
    public final Surface getSurface() {
        return this.g;
    }

    public i(Context r2, SurfaceTexture r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        TextureView r0 = new TextureView(r2);
        Intrinsics.checkNotNullParameter(r0, "mTextureView");
        this.a = r0;
        this.b = true;
        this.c = r3;
        this.d = r4;
        r0.addOnAttachStateChangeListener(new f(this));
        r0.setSurfaceTextureListener(new h(this));
    }
}
