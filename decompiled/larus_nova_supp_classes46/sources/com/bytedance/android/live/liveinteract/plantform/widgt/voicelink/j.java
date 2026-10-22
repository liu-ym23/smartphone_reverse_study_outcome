package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import com.bytedance.live.bizlink.impl.platform.manager.MultiLinkGuestManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements tf0.q {
    public final /* synthetic */ MultiLinkVoiceBaseGuestLinkWidget a;
    public final /* synthetic */ sf0.a b;

    @Override // tf0.q
    public final void a() {
    }

    @Override // tf0.q
    public final void b() {
        MultiLinkVoiceBaseGuestLinkWidget r0 = this.a;
        r0.A = true;
        this.b.q = true;
        cg6.a r1 = r0.Bq();
        if (r1 == null) goto L8;
        MultiLinkGuestManager r2 = r1.W4();
        if (r2 == null) goto L9;
        r2.d(this.b);
        return;
    L9:
        return;
    }

    public j(MultiLinkVoiceBaseGuestLinkWidget r1, sf0.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
