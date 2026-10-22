package com.bytedance.android.live.room.navi.tetris;

import com.bytedance.android.livesdk.chatroom.ui.d9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AudienceRoomNavigatorTetris$timerListener$1 implements d9.b {
    public final /* synthetic */ AudienceRoomNavigatorTetris a;

    public final String getTag() {
        return "MergedVsTitle";
    }

    public AudienceRoomNavigatorTetris$timerListener$1(AudienceRoomNavigatorTetris r1) {
        this.a = r1;
    }

    public final boolean a(long r3, long r5, int r7) {
        long r4 = r3 * r5;
        if (r4 < 3000) goto L10;
        if (r7 != 0) goto L10;
        com.bytedance.android.livesdk.common.j r6 = this.a.F;
        if (r6 == null) goto L8;
        r6.startMarqueeIfNeed(new AudienceRoomNavigatorTetris$timerListener$1$onTick$1(this));
    L8:
        return true;
    L10:
        if (r4 < 103000) goto L16;
        if (r7 != 1) goto L18;
        com.bytedance.android.livesdk.common.j r8 = this.a.F;
        if (r8 == null) goto L15;
        r8.startMarqueeIfNeed(new AudienceRoomNavigatorTetris$timerListener$1$onTick$2(this));
    L15:
        return true;
    L18:
        return false;
    L16:
        return false;
    }
}
