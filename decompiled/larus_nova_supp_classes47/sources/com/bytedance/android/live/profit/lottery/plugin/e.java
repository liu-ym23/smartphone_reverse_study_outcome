package com.bytedance.android.live.profit.lottery.plugin;

import com.bytedance.android.live.profit.lottery.LotteryContext;
import com.bytedance.android.live.profit.lottery.g;
import com.bytedance.android.live.profit.lottery.n;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements n {
    @Override // com.bytedance.android.live.profit.lottery.n
    public final void onUnload() {
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void a(LotteryContext r3) {
        Intrinsics.checkNotNullParameter(r3, "lotteryContext");
        r3.getOnToolbarButtonClick().b().d(new VCDLotteryPlugin$onLoad$1(this));
        r3.getOnIconClick().b().d(new VCDLotteryPlugin$onLoad$2(this));
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void b(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "extra");
        Intrinsics.checkNotNullParameter(r2, "extra");
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final boolean c(g r2) {
        Intrinsics.checkNotNullParameter(r2, "lottery");
        Intrinsics.checkNotNullParameter(r2, "lottery");
        return false;
    }
}
