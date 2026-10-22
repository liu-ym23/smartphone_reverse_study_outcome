package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceBaseGuestLinkWidget a;
    public final /* synthetic */ sf0.a b;

    public i(MultiLinkVoiceBaseGuestLinkWidget r1, sf0.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.a.Wq(this.b);
    }
}
