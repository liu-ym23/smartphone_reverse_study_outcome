package com.larus.dora.impl;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.model.FlowDoraGlassOpenState;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import g49.d;
import kotlin.collections.MapsKt;
import yj4.a;
import yj4.b;
import yj4.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraBuryPointManager$a implements i {
    public final /* synthetic */ DoraBuryPointManager a;

    public final /* synthetic */ void a() {
    }

    public final /* synthetic */ void c() {
    }

    public final /* synthetic */ void d(b r1) {
    }

    public final /* synthetic */ void e() {
    }

    public final /* synthetic */ void f(int r1) {
    }

    public final /* synthetic */ void g(a r1) {
    }

    public final /* synthetic */ void h(int r1) {
    }

    public final /* synthetic */ void i(String r1, long r2, int r4) {
    }

    public DoraBuryPointManager$a(DoraBuryPointManager r1) {
        this.a = r1;
    }

    public final void b(int r6) {
        FlowDoraGlassOpenState.Companion.getClass();
        FlowDoraGlassOpenState r7 = FlowDoraGlassOpenState.a.a(r6);
        DoraDevice r0 = DoraAdapterExtKt.i(kj4.a.g(), false);
        if (r0 != null) goto L5;
    L12:
        d.d(DoraBuryPointManager.b, "onGlassOpenStateChange. is not G device.");
        return;
    L5:
        if (o59.a.l(r0) == false) goto L12;
        d.d(DoraBuryPointManager.b, "onGlassOpenStateChange " + r7);
        if (r7 != FlowDoraGlassOpenState.OPEN) goto L10;
        DoraBuryPointManager.l = System.currentTimeMillis();
        this.a.L("dora_fold_out", MapsKt.emptyMap());
        return;
    L10:
        this.a.R(r0, false, "from:foldClose");
        this.a.L("dora_fold_in", MapsKt.emptyMap());
    }
}
