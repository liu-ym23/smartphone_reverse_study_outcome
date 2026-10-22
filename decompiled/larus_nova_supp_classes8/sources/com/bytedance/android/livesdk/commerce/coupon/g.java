package com.bytedance.android.livesdk.commerce.coupon;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010!\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR$\u0010$\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000f¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/commerce/coupon/g;", "", "", "statusCode", "I", "f", "()I", "setStatusCode", "(I)V", "", "statusMessage", "Ljava/lang/String;", "getStatusMessage", "()Ljava/lang/String;", "setStatusMessage", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/commerce/coupon/d;", "couponMeta", "Lcom/bytedance/android/livesdk/commerce/coupon/d;", "c", "()Lcom/bytedance/android/livesdk/commerce/coupon/d;", "setCouponMeta", "(Lcom/bytedance/android/livesdk/commerce/coupon/d;)V", "", "setCouponTime", "J", "e", "()J", "setSetCouponTime", "(J)V", "serverTime", "d", "setServerTime", "countdown", "b", "setCountdown", "activityData", "a", "setActivityData", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("activity_json_str")
    private String activityData;

    @SerializedName("countdown")
    private long countdown;

    @SerializedName("coupon_meta")
    private d couponMeta;

    @SerializedName("server_time")
    private long serverTime;

    @SerializedName("set_coupon_time")
    private long setCouponTime;

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("status_msg")
    private String statusMessage;

    public g() {
    }

    public final String a() {
        return this.activityData;
    }

    public final long b() {
        return this.countdown;
    }

    public final d c() {
        return this.couponMeta;
    }

    public final long d() {
        return this.serverTime;
    }

    public final long e() {
        return this.setCouponTime;
    }

    public final int f() {
        return this.statusCode;
    }
}
