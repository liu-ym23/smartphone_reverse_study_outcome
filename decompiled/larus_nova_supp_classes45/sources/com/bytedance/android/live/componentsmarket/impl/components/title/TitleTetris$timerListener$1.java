package com.bytedance.android.live.componentsmarket.impl.components.title;

import com.bytedance.android.livesdk.chatroom.ui.d9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class TitleTetris$timerListener$1 implements d9.b {
    public final /* synthetic */ TitleTetris a;

    public final String getTag() {
        return "MergedTitle";
    }

    public TitleTetris$timerListener$1(TitleTetris r1) {
        this.a = r1;
    }

    public final boolean a(long r3, long r5, int r7) {
        long r4 = r3 * r5;
        if (r4 < 3000) goto L12;
        if (r7 != 0) goto L12;
        if (this.a.isScreenPortrait() == false) goto L12;
        com.bytedance.android.livesdk.common.j r6 = this.a.A;
        if (r6 == null) goto L10;
        r6.startMarqueeIfNeed(new TitleTetris$timerListener$1$onTick$1(this));
    L10:
        return true;
    L12:
        if (r4 < 103000) goto L20;
        if (r7 == 1) goto L15;
        return false;
    L15:
        if (this.a.isScreenPortrait() == false) goto L23;
        com.bytedance.android.livesdk.common.j r8 = this.a.A;
        if (r8 == null) goto L19;
        r8.startMarqueeIfNeed(new TitleTetris$timerListener$1$onTick$2(this));
    L19:
        return true;
    L23:
        return false;
    L20:
        return false;
    }
}
