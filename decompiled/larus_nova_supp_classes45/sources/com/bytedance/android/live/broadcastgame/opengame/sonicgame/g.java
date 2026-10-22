package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[SonicGamePlugin.SonicState.values().length];
        a = r0;
        r0[SonicGamePlugin.SonicState.RESUME.ordinal()] = 1;
        r0[SonicGamePlugin.SonicState.PAUSE.ordinal()] = 2;
        r0[SonicGamePlugin.SonicState.DESTROY.ordinal()] = 3;
        int[] r1 = new int[GameCastStrategy.values().length];
        b = r1;
        r1[GameCastStrategy.VIDEO_CHATROOM.ordinal()] = 1;
        r1[GameCastStrategy.VIDEO_SINGLE.ordinal()] = 2;
    }
}
