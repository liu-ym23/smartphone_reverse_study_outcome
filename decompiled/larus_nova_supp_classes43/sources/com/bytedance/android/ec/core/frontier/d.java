package com.bytedance.android.ec.core.frontier;

import com.bytedance.common.wschannel.event.ConnectionState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ConnectionState.values().length];
        a = r0;
        r0[ConnectionState.CONNECTING.ordinal()] = 1;
        r0[ConnectionState.CONNECTED.ordinal()] = 2;
        r0[ConnectionState.CONNECT_FAILED.ordinal()] = 3;
        r0[ConnectionState.CONNECT_CLOSED.ordinal()] = 4;
    }
}
