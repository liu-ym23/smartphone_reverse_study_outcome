package com.bytedance.android.live.profit.redpacket;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final boolean a(RedPacketState r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isTerminalState");
        if ((r1 instanceof RedPacketState.Rushed) == false) goto L5;
    L12:
        return true;
    L5:
        if ((r1 instanceof RedPacketState.Empty) == true) goto L12;
        if ((r1 instanceof RedPacketState.Expired) == true) goto L12;
        if ((r1 instanceof RedPacketState.Disposed) == true) goto L12;
        return false;
    }
}
