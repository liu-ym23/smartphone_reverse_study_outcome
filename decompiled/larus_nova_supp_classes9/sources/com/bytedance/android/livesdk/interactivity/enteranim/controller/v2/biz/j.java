package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T, R> implements Function {
    public final /* synthetic */ RevenueUtils a;
    public final /* synthetic */ long b;
    public final /* synthetic */ boolean c;

    public j(RevenueUtils r1, long r2, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final Object apply(Object r11) {
        Pair r13 = (Pair) r11;
        Intrinsics.checkNotNullParameter(r13, "<name for destructuring parameter 0>");
        com.bytedance.android.live.core.resources.e r3 = (com.bytedance.android.live.core.resources.e) r13.component1();
        boolean r8 = ((Boolean) r13.component2()).booleanValue();
        String r2 = this.a.c().gn(this.b, false);
        long r4 = System.currentTimeMillis();
        if (r2 == null) goto L6;
        return Single.just(new RevenueUtils.a(r2, r3, r4, 0, r8, false));
    L6:
        return Single.create(new i(this, r3, r8));
    }
}
