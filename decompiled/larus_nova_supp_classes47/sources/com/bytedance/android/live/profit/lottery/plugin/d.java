package com.bytedance.android.live.profit.lottery.plugin;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profit.lottery.LotteryContext;
import com.bytedance.android.live.profit.lottery.g;
import com.bytedance.android.live.profit.lottery.n;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements n {
    public static final d a = null;

    public d() {
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void onUnload() {
    }

    static {
        a = new d();
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void a(LotteryContext r2) {
        Intrinsics.checkNotNullParameter(r2, "lotteryContext");
        Intrinsics.checkNotNullParameter(r2, "lotteryContext");
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void b(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "extra");
        com.bytedance.android.livesdk.revenue.service.user.c r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).Tk();
        if (r0 != null) goto L5;
    L7:
        String r1 = DataType.FALSE;
    L8:
        r3.put("hide_nickname", r1);
        return;
    L5:
        if (r0.a() != true) goto L7;
        r1 = DataType.TRUE;
        goto L8
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final boolean c(g r2) {
        Intrinsics.checkNotNullParameter(r2, "lottery");
        Intrinsics.checkNotNullParameter(r2, "lottery");
        return false;
    }
}
