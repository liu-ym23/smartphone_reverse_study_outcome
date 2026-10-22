package com.bytedance.android.live.profit.lottery;

import android.text.TextUtils;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import w20.r8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o2<T> implements Consumer {
    public final /* synthetic */ m2 a;

    public o2(m2 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        LotteryRepository r0 = this.a.g;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "params");
        if ((r4 instanceof r8) == false) goto L19;
        Lottery r1 = (Lottery) com.bytedance.android.live.core.arch.mvvm.f.a(r0.d);
        r8 r5 = (r8) r4;
        if (TextUtils.isEmpty(r5.a()) == true) goto L20;
        String r6 = r5.a();
        if (r1 == null) goto L13;
        LotteryState r2 = r1.getState();
        if (r2 == null) goto L13;
        t r3 = l.a(r2);
        if (r3 == null) goto L13;
        long r7 = r3.a;
    L15:
        if (Intrinsics.areEqual(r6, String.valueOf(r7)) == false) goto L21;
        if (r1 == null) goto L22;
        r1.b(LotteryAction.c.a);
        return;
    L22:
        return;
    L21:
        return;
    L13:
        r7 = 0;
        goto L15
    L20:
        return;
    }
}
