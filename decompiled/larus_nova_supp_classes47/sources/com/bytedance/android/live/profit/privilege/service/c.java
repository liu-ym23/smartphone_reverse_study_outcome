package com.bytedance.android.live.profit.privilege.service;

import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ HashMap a;
    public final /* synthetic */ String b;

    public c(HashMap r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        int r6 = ToastUtil.a;
        ToastUtil.b((String) this.a.get(this.b), 0);
        this.a.put(this.b, "");
        HashMap r7 = this.a;
        KProperty[] r1 = com.bytedance.android.live.profit.privilege.datalayer.c.a;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        com.bytedance.android.live.profit.privilege.datalayer.c.b.setValue(null, com.bytedance.android.live.profit.privilege.datalayer.c.a[0], r7);
    }
}
