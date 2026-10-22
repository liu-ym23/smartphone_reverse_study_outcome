package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.xplay.basic.api.XplayBasicState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[XplayBasicState.values().length];
        a = r0;
        r0[XplayBasicState.Loading.ordinal()] = 1;
        r0[XplayBasicState.Loaded.ordinal()] = 2;
        r0[XplayBasicState.Running.ordinal()] = 3;
        r0[XplayBasicState.Stopped.ordinal()] = 4;
    }
}
