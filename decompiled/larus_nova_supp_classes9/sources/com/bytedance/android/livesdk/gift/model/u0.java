package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/u0;", BuildConfig.FLAVOR, "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class u0 implements vh7.h {

    @SerializedName("name")
    protected String _$$goodsName;

    @SerializedName("goods_type")
    protected long _$$goodsType;

    @SerializedName("goods_id")
    protected long _$$id;

    public u0() {
        this._$$id = 0;
        this._$$goodsType = 0;
        this._$$goodsName = BuildConfig.FLAVOR;
    }

    public final long a() {
        return this._$$goodsType;
    }

    public final long b() {
        return this._$$id;
    }

    public u0(am3.g r7) {
        long r0 = r7.c();
        int r2 = 0;
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L14;
        if (r3 != 1) goto L7;
        this._$$id = r7.j();
        r2 = r2 | 1;
        goto L3
    L7:
        if (r3 != 2) goto L9;
        this._$$goodsType = r7.j();
        r2 = r2 | 2;
        goto L3
    L9:
        if (r3 != 3) goto L10;
        this._$$goodsName = am3.h.c(r7);
        goto L3
    L10:
        am3.h.e(r7);
        goto L3
    L14:
        r7.d(r0);
        if ((r2 & 1) != 0) goto L18;
        this._$$id = 0;
    L18:
        if ((r2 & 2) != 0) goto L21;
        this._$$goodsType = 0;
    L21:
        if (this._$$goodsName != null) goto L36;
        this._$$goodsName = BuildConfig.FLAVOR;
        return;
    }
}
