package com.larus.audio.call.plugins;

import com.larus.audio.call.mgr.AVKitDuplexState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i0 extends com.larus.audio.call.play.e {
    public final /* synthetic */ CommonUIStatePlugin<com.larus.audio.call.arch.c> a;
    public final /* synthetic */ u68.a b;

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void onPlayComplete() {
        CommonUIStatePlugin<com.larus.audio.call.arch.c> r0 = this.a;
        if (r0.g == this.b) goto L5;
        return;
    L5:
        final AVKitDuplexState r1 = (AVKitDuplexState) r0.getContext().a().y().getValue();
        if (m0.a(r1) == true) goto L8;
        return;
    L8:
        final CommonUIStatePlugin<com.larus.audio.call.arch.c> r2 = this.a;
        final u68.a r3 = this.b;
        Function0<Unit> r4 = new g0(r2, r3, r1);
        String r5 = r2.getContext().params().e;
        final CommonUIStatePlugin<com.larus.audio.call.arch.c> r6 = this.a;
        final u68.a r7 = this.b;
        r2.n3(r5, r4, r4, new h0(r6, r7, r1));
    }

    public i0(CommonUIStatePlugin<com.larus.audio.call.arch.c> r1, u68.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
