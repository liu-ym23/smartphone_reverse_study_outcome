package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.livesdk.chatroom.model.ApplyResult;
import com.bytedance.android.livesdk.chatroom.model.JoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.interact.AudienceLinkReplyResult;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdkapi.message.Text;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface h {
    void Bg(xe r1);

    void D0(String r1, Throwable r2);

    void Ea(if r1);

    void Ee(ApplyResult r1);

    void Hl(if r1);

    void I3();

    void Ke();

    void Of(if r1);

    void Pb(String r1);

    void Q2(Throwable r1);

    void Yn(xe r1);

    void b1(Throwable r1);

    void b2(com.bytedance.android.live.network.response.e<JoinChannelResult> r1);

    void bn(xe r1);

    void c0(Throwable r1);

    /* JADX INFO: renamed from: do */
    void mo464do(AudienceLinkReplyResult r1, int r2);

    void m0(Throwable r1);

    void xn(Text r1);
}
