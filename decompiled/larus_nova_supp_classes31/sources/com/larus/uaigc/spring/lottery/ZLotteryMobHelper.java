package com.larus.uaigc.spring.lottery;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ZLotteryMobHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r14, boolean r15, long r16, String r18, int r19, String r20, Boolean r21) {
        Intrinsics.checkNotNullParameter(r14, "messageId");
        Intrinsics.checkNotNullParameter(r18, "cardType");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ZLotteryMobHelper$reportPocketMessageCardShowed$1(r14, r15, r16, r18, r19, r20, r21, null), 2, null);
    }
}
