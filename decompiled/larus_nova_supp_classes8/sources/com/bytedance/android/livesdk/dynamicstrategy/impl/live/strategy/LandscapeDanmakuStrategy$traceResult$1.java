package com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import ju1.n;
import ju1.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LandscapeDanmakuStrategy$traceResult$1 extends Lambda implements Function0<String> {
    final /* synthetic */ n $result;

    public LandscapeDanmakuStrategy$traceResult$1(n r1) {
        this.$result = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m1196invoke() {
        return "current state is " + Integer.valueOf(((r) this.$result).c).intValue() + ", factor state is: " + ((r) this.$result).d + ", hit rules is: " + GsonProtectorUtils.toJson(GsonHelper.get(), ((r) this.$result).e);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1196invoke();
    }
}
