package com.bytedance.awemeopen.infra.base.player;

import android.view.Surface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements com.bytedance.awemeopen.infra.base.player.surface.c {
    public final /* synthetic */ Function1<Surface, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super Surface, Unit> r1) {
        this.a = r1;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.surface.c
    public final void a(Surface r2) {
        Intrinsics.checkNotNullParameter(r2, "surface");
        this.a.invoke(r2);
    }
}
