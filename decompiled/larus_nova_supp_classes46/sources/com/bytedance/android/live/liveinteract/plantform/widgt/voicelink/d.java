package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceAnchorContainerWidget a;

    public d(MultiLinkVoiceAnchorContainerWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        pe0.a r4 = (pe0.a) r3;
        MultiLinkVoiceAnchorContainerWidget r5 = this.a;
        com.bytedance.android.livesdk.message.linker.h r0 = r5.i;
        if (r0 == null) goto L6;
        r5.continueAnchorLinkMic(r5.c, r0);
        return;
    }
}
