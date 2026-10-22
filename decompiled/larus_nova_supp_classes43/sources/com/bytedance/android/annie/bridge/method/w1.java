package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.RequestResultModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w1<T> implements Consumer {
    public final /* synthetic */ u1.b a;

    public w1(u1.b r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        u1.c r0 = this.a.c;
        r0.a((RequestResultModel) r10);
    }
}
