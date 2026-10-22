package com.bytedance.android.live.broadcastgame.opengame.debug;

import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class k {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[PluginType.values().length];
        a = r0;
        PluginType r1 = PluginType.LYNX;
        r0[r1.ordinal()] = 1;
        PluginType r2 = PluginType.SONIC_GAME;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[PluginType.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[PluginType.MINI_APP.ordinal()] = 3;
    }
}
