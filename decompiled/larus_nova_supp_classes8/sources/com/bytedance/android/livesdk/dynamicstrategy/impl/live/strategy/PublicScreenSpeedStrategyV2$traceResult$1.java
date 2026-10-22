package com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import ju1.n;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class PublicScreenSpeedStrategyV2$traceResult$1 extends Lambda implements Function0<String> {
    final /* synthetic */ n $result;

    public PublicScreenSpeedStrategyV2$traceResult$1(n r1) {
        this.$result = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m1197invoke() {
        return "current state is " + this.$result.c() + ", factor state is: " + ((ju1.g) this.$result).c + ", factors value is: " + GsonProtectorUtils.toJson(GsonHelper.get(), ((ju1.g) this.$result).d);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1197invoke();
    }
}
