package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(long r7, int r9) {
        StringBuilder r0 = new StringBuilder("gameId = ");
        r0.append(r7);
        r0.append(" gameKind = ");
        r0.append(r9);
        r0.append(", 主播游戏状态为 ");
        if (r7 <= 0) goto L9;
        if (r9 == 6) goto L6;
        boolean r8 = true;
    L7:
        if (r8 == false) goto L9;
        boolean r11 = true;
    L10:
        r0.append(r11);
        ALogger.d("AnchorGameState", r0.toString());
        if (r7 <= 0) goto L17;
        if (r9 == 6) goto L14;
        boolean r12 = true;
    L15:
        if (r12 == false) goto L17;
        return true;
    L14:
        r12 = false;
    L17:
        return false;
    L6:
        r8 = false;
    L9:
        r11 = false;
        goto L10
    }
}
