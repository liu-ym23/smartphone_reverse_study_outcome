package com.bytedance.android.live.liveinteract.plantform.datamerge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ String a;

    public m(String r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Integer r4 = (Integer) r3;
        int r5 = cj0.e.h;
        rj0.h r6 = cj0.e.a.a();
        if (r6 == null) goto L5;
        r6.d();
    L5:
        xs2.b.a().post(new dh0.b(this.a));
    }
}
