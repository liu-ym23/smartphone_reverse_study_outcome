package com.bytedance.android.live.recharge.exchange.service;

import android.content.Context;
import com.bytedance.android.live.recharge.model.ExchangeType;
import io.reactivex.functions.Consumer;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ h a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ExchangeType c;
    public final /* synthetic */ py.k d;
    public final /* synthetic */ long e;
    public final /* synthetic */ zv0.e f;

    public g(h r1, Context r2, ExchangeType r3, py.k r4, long r5, zv0.e r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
    }

    public final void accept(Object r10) {
        h.a(this.a, this.b, this.c, this.d, this.e, ((Boolean) r10).booleanValue(), MapsKt.emptyMap(), this.f);
    }
}
