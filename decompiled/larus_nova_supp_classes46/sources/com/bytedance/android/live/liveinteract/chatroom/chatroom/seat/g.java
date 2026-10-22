package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.KtvSeatAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends d {
    public final f b;
    public final KtvSeatAnimationView c;

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final void b(w r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if ((r2 instanceof h) == true) goto L5;
        d r0 = this.a;
        if (r0 == null) goto L25;
        r0.b(r2);
        return;
    L25:
        return;
    L5:
        if (((h) r2).a == false) goto L13;
        this.b.a(SeatAnimTaskState.KTV_SINGER_ANIMA);
        KtvSeatAnimationView r3 = this.c;
        if (r3 != null) goto L9;
    L10:
        KtvSeatAnimationView r4 = this.c;
        if (r4 == null) goto L22;
        r4.setVisibility(0);
        return;
    L22:
        return;
    L9:
        if (r3.getVisibility() != 0) goto L10;
        return;
    L13:
        KtvSeatAnimationView r5 = this.c;
        if (r5 == null) goto L16;
        r5.setVisibility(8);
    L16:
        this.b.a(SeatAnimTaskState.IDLE);
    }

    public g(f r2, KtvSeatAnimationView r3) {
        Intrinsics.checkNotNullParameter(r2, "taskStateListener");
        this.b = r2;
        this.c = r3;
    }
}
