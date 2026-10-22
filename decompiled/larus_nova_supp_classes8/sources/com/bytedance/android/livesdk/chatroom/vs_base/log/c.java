package com.bytedance.android.livesdk.chatroom.vs_base.log;

import nic.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends com.bytedance.android.livesdk.chatroom.vs_base.player.d {
    public final /* synthetic */ ReplayDurationLogger a;

    public c(ReplayDurationLogger r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
    public final void o0(p r3, tic.a r4, long r5, long r7) {
        ReplayDurationLogger r6 = this.a;
        if (r6.b != (-1)) goto L6;
        r6.b = r7;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
    public final void q0(oic.f r3, tic.a r4, long r5, long r7) {
        ReplayDurationLogger r6 = this.a;
        if (r6.b != (-1)) goto L6;
        r6.b = r7;
        return;
    }
}
