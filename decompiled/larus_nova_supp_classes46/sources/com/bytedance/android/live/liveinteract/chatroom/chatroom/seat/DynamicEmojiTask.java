package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class DynamicEmojiTask extends d {
    public final f b;
    public final DynamicEmojiView c;
    public final HSImageView d;

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final void b(final w r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if ((r4 instanceof a) == false) goto L17;
        a r0 = (a) r4;
        wj0.b r1 = r0.a;
        if (r1 == null) goto L11;
        TalkRoomBaseDynamicEmoji r2 = r1.b;
        if (r2 == null) goto L11;
        if (r2.isNewRandomEmoji() != true) goto L11;
        return;
    L11:
        this.b.a(SeatAnimTaskState.DYNAMIC_EMOJI);
        HSImageView r3 = this.d;
        if (r3 == null) goto L14;
        r3.setVisibility(8);
    L14:
        DynamicEmojiView r5 = this.c;
        if (r5 == null) goto L21;
        r5.b(r0.a, new DynamicEmojiTask$handle$1(this, r4));
        return;
    L21:
        return;
    L17:
        d r6 = this.a;
        if (r6 == null) goto L23;
        r6.b(r4);
        return;
    }

    public DynamicEmojiTask(f r2, DynamicEmojiView r3, HSImageView r4) {
        Intrinsics.checkNotNullParameter(r2, "taskStateListener");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
