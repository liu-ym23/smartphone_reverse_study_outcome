package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k0<T> implements Consumer {
    public final /* synthetic */ j0 a;

    public k0(j0 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        dh0.a r5 = (dh0.a) r4;
        j0 r6 = this.a;
        r6.getClass();
        gh0.b.a("AudioAnchorGuide", "onMultiLinkAudioAnchorGuideAnimEvent", false);
        r6.a().k1(new ch0.l(0, null));
    }
}
