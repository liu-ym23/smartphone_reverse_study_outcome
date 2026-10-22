package com.bytedance.android.live.profit.lottery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public static final t a(LotteryState r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$info");
        if ((r1 instanceof LotteryState.g) == false) goto L6;
        return ((LotteryState.g) r1).a;
    L6:
        if ((r1 instanceof LotteryState.a) == false) goto L9;
        return ((LotteryState.a) r1).a;
    L9:
        if ((r1 instanceof LotteryState.b) == false) goto L12;
        return ((LotteryState.b) r1).a;
    L12:
        if ((r1 instanceof LotteryState.e) == false) goto L15;
        return ((LotteryState.e) r1).b;
    L15:
        if ((r1 instanceof LotteryState.d) == true) goto L23;
        return null;
    L23:
        return ((LotteryState.d) r1).a;
    }

    public static final boolean b(LotteryState r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isTerminalState");
        if ((r1 instanceof LotteryState.b) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r1 instanceof LotteryState.e) == true) goto L10;
        if ((r1 instanceof LotteryState.c) == true) goto L10;
        return false;
    }
}
