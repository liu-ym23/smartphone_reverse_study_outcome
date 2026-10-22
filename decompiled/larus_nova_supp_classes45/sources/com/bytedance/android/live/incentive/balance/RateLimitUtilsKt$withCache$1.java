package com.bytedance.android.live.incentive.balance;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/incentive/balance/e;", "it", "", "invoke", "(Lcom/bytedance/android/live/incentive/balance/e;)Z", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class RateLimitUtilsKt$withCache$1 extends Lambda implements Function1<e, Boolean> {
    final /* synthetic */ UpdateReason $reason;

    public RateLimitUtilsKt$withCache$1(UpdateReason r1) {
        this.$reason = r1;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((e) r1));
    }

    public final boolean invoke(e r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        if (r2.a != this.$reason) goto L5;
        return true;
    L5:
        return false;
    }
}
