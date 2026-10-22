package com.bytedance.android.livesdk.coupon.expandcoupon.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/coupon/expandcoupon/model/b;", "", "", "benefitType", "I", "b", "()I", "setBenefitType", "(I)V", "", "bizTag", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setBizTag", "(Ljava/lang/String;)V", "reqId", "e", "setReqId", "token", "f", "setToken", "", "cid", "J", "d", "()J", "setCid", "(J)V", "adId", "a", "setAdId", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("ad_id")
    private long adId;

    @SerializedName("benefit_type")
    private int benefitType;

    @SerializedName("biz_tag")
    private String bizTag;

    @SerializedName("cid")
    private long cid;

    @SerializedName("req_id")
    private String reqId;

    @SerializedName("ad_token")
    private String token;

    public b() {
    }

    public final long a() {
        return this.adId;
    }

    public final int b() {
        return this.benefitType;
    }

    public final String c() {
        return this.bizTag;
    }

    public final long d() {
        return this.cid;
    }

    public final String e() {
        return this.reqId;
    }

    public final String f() {
        return this.token;
    }
}
