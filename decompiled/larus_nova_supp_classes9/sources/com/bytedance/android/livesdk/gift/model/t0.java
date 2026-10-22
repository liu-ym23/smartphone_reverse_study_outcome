package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/t0;", BuildConfig.FLAVOR, "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class t0 implements vh7.h {

    @SerializedName("goods")
    protected h _$$bizGoods;

    @SerializedName("entrance")
    protected g _$$entrance;

    public t0() {
        this._$$bizGoods = null;
        this._$$entrance = new g();
    }

    public t0(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this._$$bizGoods = new h(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$entrance = new g(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
        if (this._$$bizGoods != null) goto L16;
        this._$$bizGoods = null;
    L16:
        if (this._$$entrance != null) goto L28;
        this._$$entrance = new g();
        return;
    }

    public final h a() {
        return this._$$bizGoods;
    }

    public final g b() {
        return this._$$entrance;
    }
}
