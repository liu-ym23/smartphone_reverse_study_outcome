package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import com.bytedance.android.live.profit.scoreboard.EventName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class j {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[EventName.values().length];
        a = r0;
        r0[EventName.ON_ROUND_MESSAGE_START.ordinal()] = 1;
        r0[EventName.ON_ROUND_MESSAGE_FINISH.ordinal()] = 2;
        r0[EventName.ON_ROUND_MESSAGE_SCORE_CHANGE.ordinal()] = 3;
    }
}
