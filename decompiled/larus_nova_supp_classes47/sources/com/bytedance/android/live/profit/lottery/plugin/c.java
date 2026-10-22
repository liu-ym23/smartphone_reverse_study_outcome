package com.bytedance.android.live.profit.lottery.plugin;

import android.content.Context;
import com.bytedance.android.live.profit.lottery.LotteryContext;
import com.bytedance.android.live.profit.lottery.g;
import com.bytedance.android.live.profit.lottery.n;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements n {
    public final Context a;

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void onUnload() {
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void a(LotteryContext r2) {
        Intrinsics.checkNotNullParameter(r2, "lotteryContext");
        r2.getOnIconClick().b().b(new LoginLotteryPlugin$onLoad$1(this));
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
