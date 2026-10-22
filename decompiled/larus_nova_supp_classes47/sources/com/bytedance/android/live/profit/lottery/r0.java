package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.message.model.na;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r0<T> implements Consumer {
    public final /* synthetic */ LotteryIMDataSource a;
    public final /* synthetic */ na b;
    public final /* synthetic */ Ref.LongRef c;

    public r0(LotteryIMDataSource r1, na r2, Ref.LongRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        ALogger.i("HOT_LOTTERY", "time 2 = " + System.currentTimeMillis());
        this.a.b(this.b, this.c.element);
    }
}
