package com.bytedance.android.live.livepkaudience.seat;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PkDynamicEmojiTask extends a {
    public final b b;
    public final DynamicEmojiView c;
    public final HSImageView d;

    @Override // com.bytedance.android.live.livepkaudience.seat.a
    public final void a(final h r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if ((r4 instanceof c) == false) goto L10;
        this.b.a(SeatAnimTaskState.DYNAMIC_EMOJI);
        HSImageView r0 = this.d;
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L7:
        DynamicEmojiView r1 = this.c;
        if (r1 == null) goto L14;
        r1.b(((c) r4).a, new PkDynamicEmojiTask$handle$1(this, r4));
        return;
    L14:
        return;
    L10:
        a r2 = this.a;
        if (r2 == null) goto L16;
        r2.a(r4);
        return;
    }

    public PkDynamicEmojiTask(g r2, DynamicEmojiView r3, HSImageView r4) {
        Intrinsics.checkNotNullParameter(r2, "taskStateListener");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
