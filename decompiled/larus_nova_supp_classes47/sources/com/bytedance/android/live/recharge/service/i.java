package com.bytedance.android.live.recharge.service;

import com.bytedance.android.live.recharge.r0;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ HashMap a;
    public final /* synthetic */ String b;

    public i(HashMap r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        com.bytedance.android.live.recharge.deal.i r5 = (com.bytedance.android.live.recharge.deal.i) r4;
        HashMap r6 = this.a;
        r6.put(this.b, Long.valueOf(System.currentTimeMillis()));
        KProperty[] r0 = r0.a;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r0.e.setValue(null, r0.a[3], r6);
    }
}
