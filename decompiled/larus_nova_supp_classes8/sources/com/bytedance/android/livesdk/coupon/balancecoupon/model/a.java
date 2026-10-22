package com.bytedance.android.livesdk.coupon.balancecoupon.model;

import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0005\u0013\u0005\u0018\u001d\fB\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a;", "", "", "benefitType", "I", "b", "()I", "g", "(I)V", "Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$e;", "ugIdentity", "Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$e;", "e", "()Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$e;", "j", "(Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$e;)V", "", "activityId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "category", "c", "h", "Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$c;", "exchangeInfo", "Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$c;", "d", "()Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$c;", "i", "(Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$c;)V", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("activity_id")
    private String activityId;

    @SerializedName("benefit_type")
    private int benefitType;

    @SerializedName("category")
    private String category;

    @SerializedName("exchange_info")
    private c exchangeInfo;

    @SerializedName("identity")
    private e ugIdentity;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.coupon.balancecoupon.model.a$a, reason: collision with other inner class name */
    public static final class C0115a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$b;", "", "", "amount", "J", "a", "()J", "b", "(J)V", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("amount")
        private long amount;

        public b() {
        }

        public final void b() {
            this.amount = 100;
        }

        public final long a() {
            return this.amount;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$c;", "", "Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$b;", "cost", "Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$b;", "a", "()Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$b;", "d", "(Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$b;)V", "", "prizeId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$d;", "marketCouponInfo", "Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$d;", "b", "()Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$d;", "e", "(Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$d;)V", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("cost")
        private b cost;

        @SerializedName("ecom_marketing_prize_detail")
        private d marketCouponInfo;

        @SerializedName("prize_id")
        private String prizeId;

        public final void f() {
            Intrinsics.checkNotNullParameter("12312451514515", "<set-?>");
            this.prizeId = "12312451514515";
        }

        public c() {
            this.prizeId = "";
        }

        public final b a() {
            return this.cost;
        }

        public final d b() {
            return this.marketCouponInfo;
        }

        public final String c() {
            return this.prizeId;
        }

        public final void d(b r1) {
            this.cost = r1;
        }

        public final void e(d r1) {
            this.marketCouponInfo = r1;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$d;", "", "", "couponType", "I", "c", "()I", "i", "(I)V", "couponSubType", "b", "h", "", "couponName", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "", "credit", "J", "d", "()J", "j", "(J)V", "threshold", "e", "k", "validPeriod", "f", "l", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("coupon_name")
        private String couponName;

        @SerializedName("coupon_sub_type")
        private int couponSubType;

        @SerializedName("coupon_type")
        private int couponType;

        @SerializedName("credit")
        private long credit;

        @SerializedName("threshold")
        private long threshold;

        @SerializedName("valid_period")
        private long validPeriod;

        public final void h() {
            this.couponSubType = 1;
        }

        public final void i() {
            this.couponType = 1;
        }

        public final void g() {
            Intrinsics.checkNotNullParameter("余额兑换优惠券", "<set-?>");
            this.couponName = "余额兑换优惠券";
        }

        public final void j() {
            this.credit = 100;
        }

        public final void k() {
            this.threshold = AppointmentService.SOURCE_UNDEFINED;
        }

        public d() {
            this.couponType = 1;
            this.couponSubType = 1;
            this.couponName = "";
        }

        public final void l() {
            this.validPeriod = 1209600;
        }

        public final String a() {
            return this.couponName;
        }

        public final int b() {
            return this.couponSubType;
        }

        public final int c() {
            return this.couponType;
        }

        public final long d() {
            return this.credit;
        }

        public final long e() {
            return this.threshold;
        }

        public final long f() {
            return this.validPeriod;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/a$e;", "", "", "domain", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "scene", "b", "f", "", "tokenType", "J", "d", "()J", "h", "(J)V", "token", "c", "g", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
    public static final class e {

        @SerializedName("domain")
        private String domain;

        @SerializedName("scene")
        private String scene;

        @SerializedName("token")
        private String token;

        @SerializedName("token_type")
        private long tokenType;

        public final void e() {
            Intrinsics.checkNotNullParameter("2329", "<set-?>");
            this.domain = "2329";
        }

        public final void f() {
            Intrinsics.checkNotNullParameter("normal_incentive", "<set-?>");
            this.scene = "normal_incentive";
        }

        public final void g() {
            Intrinsics.checkNotNullParameter("1231415123151", "<set-?>");
            this.token = "1231415123151";
        }

        public final void h() {
            this.tokenType = 10012;
        }

        public e() {
            this.domain = "";
            this.scene = "";
            this.token = "";
        }

        public final String a() {
            return this.domain;
        }

        public final String b() {
            return this.scene;
        }

        public final String c() {
            return this.token;
        }

        public final long d() {
            return this.tokenType;
        }
    }

    static {
    }

    public final void g() {
        this.benefitType = 1;
    }

    public final void f() {
        Intrinsics.checkNotNullParameter("balance_exc_coupon", "<set-?>");
        this.activityId = "balance_exc_coupon";
    }

    public final void h() {
        Intrinsics.checkNotNullParameter("2001", "<set-?>");
        this.category = "2001";
    }

    public a() {
        this.benefitType = 1;
        this.activityId = "";
        this.category = "";
    }

    public final String a() {
        return this.activityId;
    }

    public final int b() {
        return this.benefitType;
    }

    public final String c() {
        return this.category;
    }

    public final c d() {
        return this.exchangeInfo;
    }

    public final e e() {
        return this.ugIdentity;
    }

    public final void i(c r1) {
        this.exchangeInfo = r1;
    }

    public final void j(e r1) {
        this.ugIdentity = r1;
    }
}
