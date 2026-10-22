package com.bytedance.android.live.effect.beauty;

import com.bytedance.android.live.effect.template.BeautifyTemplate;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements com.bytedance.android.live.effect.api.k.i {
    public final /* synthetic */ LiveBeautifyFragmentNew a;

    @Override // com.bytedance.android.live.effect.api.k.i
    public final void b() {
        LiveBeautifyFragmentNew r0 = this.a;
        if (r0.f == false) goto L8;
        BeautifyTabItemView r1 = r0.Y90(BeautifyTemplate.BeautifyContentType.MAKEUPS);
        if (r1 == null) goto L9;
        r1.setDotVisibility(false);
        return;
    L9:
        return;
    }

    public g(LiveBeautifyFragmentNew r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.api.k.i
    public final void a(EffectChannelResponse r3) {
        LiveBeautifyFragmentNew r0 = this.a;
        if (r0.f == false) goto L7;
        if (r3 == null) goto L8;
        LiveBeautifyFragmentNew.T90(r0, r3, 0);
        return;
    L8:
        return;
    }
}
