package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.live.artist.render.RenderEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v implements tc2.k {
    public final /* synthetic */ RenderEntity a;
    public final /* synthetic */ Function1 b;

    @Override // tc2.k
    public final void a(RenderEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Function1 r3 = this.b;
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r3.invoke(this.a);
        return;
    }

    public v(RenderEntity r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
