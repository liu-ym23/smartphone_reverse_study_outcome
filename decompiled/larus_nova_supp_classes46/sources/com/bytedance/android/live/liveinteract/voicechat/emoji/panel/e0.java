package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.livesdk.message.model.w8;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e0<T> implements Consumer {
    public final /* synthetic */ s a;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.j b;
    public final /* synthetic */ long c;

    public e0(s r1, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r9) {
        com.bytedance.android.live.network.response.e r10 = (com.bytedance.android.live.network.response.e) r9;
        this.a.b = false;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r2 = this.b.getEmojiId();
        int r4 = this.b.getEmojiType();
        long r5 = this.c;
        String r7 = r10.logId;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.u0(r2, r4, r5, r7);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r1 = this.b;
        if (r1 == null) goto L13;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.h r3 = r1.getDigitAvatarEmojiData();
        if (r3 == null) goto L13;
        if (r3.actionID <= 0) goto L13;
        DigitAvatarContext r6 = DigitAvatarContext.Companion.getContext();
        if (r6 == null) goto L13;
        com.bytedance.live.datacontext.k<com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r8 = r6.getSendAvatarEmoji();
        if (r8 == null) goto L13;
        r8.post(this.b);
    L13:
        w8 r11 = ((com.bytedance.android.live.liveinteract.voicechat.model.a) r10.data).a();
        if (r11 == null) goto L16;
        Long r12 = Long.valueOf(r11.getMessageId());
    L17:
        com.bytedance.android.live.liveinteract.plantform.utils.x.s0(r12.longValue(), this.b);
        s.a r13 = (s.a) ((q46.b) this.a).a;
        if (r13 == null) goto L21;
        r13.q4((com.bytedance.android.live.liveinteract.voicechat.model.a) r10.data);
        return;
    L21:
        return;
    L16:
        r12 = null;
        goto L17
    }
}
