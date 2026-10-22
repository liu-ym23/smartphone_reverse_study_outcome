package com.bytedance.android.live.liveinteract.videotalk;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;

    public k(MultiLinkVideoTalkRoomAnchorWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Boolean r5 = (Boolean) r4;
        jy0.b.d("ttlive_link_video", "isXplayRunning onValueChanged: " + r5);
        yj0.a r0 = this.a.H;
        if (r0 != null) goto L5;
    L31:
        jy0.b.d("ttlive_link_video", "isXplayRunning onValueChanged return");
        return;
    L5:
        if (r0.e0() != 1) goto L31;
        if (r5.booleanValue() == false) goto L20;
        jg6.a r6 = this.a.Bq();
        if (r6 == null) goto L33;
        kg6.e r7 = r6.b();
        if (r7 != null) goto L14;
        return;
    L14:
        if (r7.q() != true) goto L35;
        jy0.b.d("ttlive_link_video", "linkMicGameStart -> muteLocalAudioStream false");
        jg6.a r8 = this.a.Bq();
        if (r8 == null) goto L36;
        kg6.e r9 = r8.b();
        if (r9 == null) goto L37;
        r9.u(false, "linkMicGameStart");
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L33:
        return;
    L20:
        jg6.a r10 = this.a.Bq();
        if (r10 == null) goto L39;
        kg6.e r11 = r10.b();
        if (r11 != null) goto L25;
        return;
    L25:
        if (r11.q() == true) goto L41;
        jy0.b.d("ttlive_link_video", "linkMicGameStop -> muteLocalAudioStream true");
        jg6.a r12 = this.a.Bq();
        if (r12 == null) goto L42;
        kg6.e r13 = r12.b();
        if (r13 == null) goto L43;
        r13.u(true, "linkMicGameStop");
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    }
}
