package com.bytedance.awemeopen.infra.base.player.surface;

import android.content.Context;
import android.graphics.SurfaceTexture;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j extends AbsSurfaceSource {
    public final SurfaceTexture e;
    public final Function0<Unit> f;

    public j() {
        this(null, null, 7);
    }

    @Override // com.bytedance.awemeopen.infra.base.player.surface.AbsSurfaceSource
    public final i a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "c");
        return new i(r4, this.e, this.f);
    }

    public j(SurfaceTexture r3, Function0 r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        super(null);
        this.e = r3;
        this.f = r4;
    }
}
