package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.KtvSeatAnimationView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView;
import com.bytedance.android.live.liveinteract.view.MicSeatSponsorView;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v implements f {
    public SeatAnimTaskState a;
    public o b;

    public v() {
        this.a = SeatAnimTaskState.IDLE;
        this.b = new o();
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.f
    public final void a(SeatAnimTaskState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a = r2;
    }

    public final void c(w r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.b.b(r2);
    }

    public final void b(HSImageView r2, MicSeatSponsorView r3, HSImageView r4, LinkSucAnimationView r5, DynamicEmojiView r6, HSImageView r7, KtvSeatAnimationView r8) {
        GuestBattleSeatAnimTask r0 = new GuestBattleSeatAnimTask(this, r2, r3);
        ThemedCompetitionSeatAnimTask r9 = new ThemedCompetitionSeatAnimTask(this, r4);
        LinkSucAnimTask r10 = new LinkSucAnimTask(this, r5);
        DynamicEmojiTask r11 = new DynamicEmojiTask(this, r6, r7);
        m r12 = new m(this, r6);
        g r13 = new g(this, r8);
        o r14 = this.b;
        r14.d(r0);
        r14.d(r9);
        r14.d(r10);
        r14.d(r11);
        r14.d(r13);
        r14.d(r12);
    }
}
