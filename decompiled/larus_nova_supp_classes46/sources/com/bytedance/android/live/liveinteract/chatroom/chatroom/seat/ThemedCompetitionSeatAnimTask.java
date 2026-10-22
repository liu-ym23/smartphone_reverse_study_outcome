package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class ThemedCompetitionSeatAnimTask extends d {
    public final f b;
    public final HSImageView c;

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final void b(w r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof x) == false) goto L12;
        String r4 = ((x) r3).b;
        if (r4 == null) goto L16;
        this.b.a(SeatAnimTaskState.THEMED_COMPETITION_ANIM);
        HSImageView r0 = this.c;
        if (r0 == null) goto L9;
        UtilityKotlinExtentionsKt.w(r0);
    L9:
        HSImageView r1 = this.c;
        if (r1 == null) goto L17;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.f.a(r1, r4, new ThemedCompetitionSeatAnimTask$handle$$inlined$let$lambda$1(this));
        return;
    L17:
        return;
    L16:
        return;
    L12:
        d r2 = this.a;
        if (r2 == null) goto L19;
        r2.b(r3);
        return;
    }

    public ThemedCompetitionSeatAnimTask(f r2, HSImageView r3) {
        Intrinsics.checkNotNullParameter(r2, "taskStateListener");
        this.b = r2;
        this.c = r3;
    }
}
