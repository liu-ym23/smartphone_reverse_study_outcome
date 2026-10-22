package com.bytedance.android.live.profit.lottery.plugin;

import com.bytedance.android.live.profit.lottery.LotteryContext;
import com.bytedance.android.live.profit.lottery.g;
import com.bytedance.android.live.profit.lottery.n;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements n {
    public Disposable a;

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void onUnload() {
        this.a.dispose();
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r0 = ((mz0.c) f.a(mz0.c.class)).W2(LogCommon.ROOM);
        if (r0 == null) goto L6;
        r0.n();
        return;
    }

    public b() {
        this.a = Disposables.disposed();
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void a(LotteryContext r2) {
        Intrinsics.checkNotNullParameter(r2, "lotteryContext");
        this.a = r2.getCurrentLottery().a().subscribe(new a(this));
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
