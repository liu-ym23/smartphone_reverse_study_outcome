package com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy;

import android.text.TextUtils;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.settings.config.x0;
import ju1.m;
import ju1.n;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import r52.e4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements iu1.b {
    public final PropertyOwner<n> a;

    @Override // iu1.b
    public final void onDestroy() {
    }

    @Override // iu1.b
    public final ju1.h getStrategy() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        String r2 = ((x0) e4.a.getValue()).shortTouchTempstateLotteryInterest;     // Catch: Throwable -> L15
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        ju1.h r3 = mu1.b.d(r2);     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        Unit r4 = null;
    L13:
        Result.constructor-impl(r4);     // Catch: Throwable -> L15
    L18:
        return new m("short_touch_tempstate_lottery_interest", 0);
    L9:
        if (TextUtils.equals(r3.b(), "short_touch_tempstate_lottery_interest") == false) goto L11;
        return r3;
    L11:
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public i() {
        this.a = new PropertyOwner(new n(0, true));
    }

    @Override // iu1.b
    public final void a(n r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        StringBuilder r0 = new StringBuilder("result = ");
        Object r1 = r3.c();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.append(r1);
        ALogger.d("LotteryTermStateInterestStrategy", r0.toString());
        this.a.a(r3);
    }

    @Override // iu1.b
    public final void b(n r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a.a(r2);
    }
}
