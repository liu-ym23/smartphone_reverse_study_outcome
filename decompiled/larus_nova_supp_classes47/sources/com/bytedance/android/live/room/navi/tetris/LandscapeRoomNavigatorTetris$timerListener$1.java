package com.bytedance.android.live.room.navi.tetris;

import com.bytedance.android.livesdk.chatroom.ui.d9;
import com.bytedance.android.livesdk.common.MarqueeTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LandscapeRoomNavigatorTetris$timerListener$1 implements d9.b {
    public final /* synthetic */ LandscapeRoomNavigatorTetris a;

    public final String getTag() {
        return "MergedVsTitle";
    }

    public LandscapeRoomNavigatorTetris$timerListener$1(LandscapeRoomNavigatorTetris r1) {
        this.a = r1;
    }

    public final boolean a(long r3, long r5, int r7) {
        long r4 = r3 * r5;
        if (r4 < 3000) goto L10;
        if (r7 != 0) goto L10;
        MarqueeTextView r6 = this.a.s;
        if (r6 == null) goto L8;
        r6.startMarqueeIfNeed(new LandscapeRoomNavigatorTetris$timerListener$1$onTick$1(this));
    L8:
        return true;
    L10:
        if (r4 < 103000) goto L16;
        if (r7 != 1) goto L18;
        MarqueeTextView r8 = this.a.s;
        if (r8 == null) goto L15;
        r8.startMarqueeIfNeed(new LandscapeRoomNavigatorTetris$timerListener$1$onTick$2(this));
    L15:
        return true;
    L18:
        return false;
    L16:
        return false;
    }
}
