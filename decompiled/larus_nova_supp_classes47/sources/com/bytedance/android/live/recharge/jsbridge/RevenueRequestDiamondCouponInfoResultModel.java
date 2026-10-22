package com.bytedance.android.live.recharge.jsbridge;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import w20.aa;
import w20.z9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0003\u0019\u0007\u000eB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/recharge/jsbridge/RevenueRequestDiamondCouponInfoResultModel;", "Lw20/aa;", "Lcom/bytedance/android/live/recharge/jsbridge/RevenueRequestDiamondCouponInfoResultModel$Code;", Constants.OperatorKey.CODE, "Lcom/bytedance/android/live/recharge/jsbridge/RevenueRequestDiamondCouponInfoResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/recharge/jsbridge/RevenueRequestDiamondCouponInfoResultModel$Code;", "a", "(Lcom/bytedance/android/live/recharge/jsbridge/RevenueRequestDiamondCouponInfoResultModel$Code;)V", "Lcom/bytedance/android/live/recharge/jsbridge/RevenueRequestDiamondCouponInfoResultModel$b;", Constants.Keys.DATA, "Lcom/bytedance/android/live/recharge/jsbridge/RevenueRequestDiamondCouponInfoResultModel$b;", "getData", "()Lcom/bytedance/android/live/recharge/jsbridge/RevenueRequestDiamondCouponInfoResultModel$b;", "b", "(Lcom/bytedance/android/live/recharge/jsbridge/RevenueRequestDiamondCouponInfoResultModel$b;)V", "", Constants.OperatorKey.MSG, "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevenueRequestDiamondCouponInfoResultModel implements aa {

    @SerializedName(Constants.OperatorKey.CODE)
    private Code code;

    @SerializedName(Constants.Keys.DATA)
    private b data;

    @SerializedName(Constants.OperatorKey.MSG)
    private String msg;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/recharge/jsbridge/RevenueRequestDiamondCouponInfoResultModel$Code;", "", "Lw20/z9;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Code extends Enum<Code> implements z9 {
        public static final Code Failed = null;
        public static final Code NOT_REGISTER = null;
        public static final Code NO_PERMISSION = null;
        public static final Code Success = null;
        public static final /* synthetic */ Code[] a = null;
        private final int value;

        static {
            Code r1 = new Code("Success", 0, 1);
            Success = r1;
            Code r2 = new Code("Failed", 1, 0);
            Failed = r2;
            Code r3 = new Code("NO_PERMISSION", 2, -1);
            NO_PERMISSION = r3;
            Code r4 = new Code("NOT_REGISTER", 3, -2);
            NOT_REGISTER = r4;
            a = new Code[]{r1, r2, r3, r4};
        }

        public static Code valueOf(String r1) {
            return (Code) r27.a.a(Code.class, r1);
        }

        public static Code[] values() {
            return (Code[]) a.clone();
        }

        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"¨\u0006("}, d2 = {"Lcom/bytedance/android/live/recharge/jsbridge/RevenueRequestDiamondCouponInfoResultModel$a;", "", "", "couponId", "Ljava/lang/String;", "getCouponId", "()Ljava/lang/String;", "a", "(Ljava/lang/String;)V", "", "expireTimestamp", "Ljava/lang/Number;", "getExpireTimestamp", "()Ljava/lang/Number;", "e", "(Ljava/lang/Number;)V", "title", "getTitle", "h", "subTitle", "getSubTitle", "g", "discountAmount", "getDiscountAmount", "b", "discountCondition", "getDiscountCondition", "c", "", "enable", "Ljava/lang/Boolean;", "getEnable", "()Ljava/lang/Boolean;", "d", "(Ljava/lang/Boolean;)V", "select", "getSelect", "f", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("couponId")
        private String couponId;

        @SerializedName("discountAmount")
        private String discountAmount;

        @SerializedName("discountCondition")
        private String discountCondition;

        @SerializedName("enable")
        private Boolean enable;

        @SerializedName("expireTimestamp")
        private Number expireTimestamp;

        @SerializedName("select")
        private Boolean select;

        @SerializedName("subTitle")
        private String subTitle;

        @SerializedName("title")
        private String title;

        public a() {
        }

        public final void a(String r1) {
            this.couponId = r1;
        }

        public final void b(String r1) {
            this.discountAmount = r1;
        }

        public final void c(String r1) {
            this.discountCondition = r1;
        }

        public final void d(Boolean r1) {
            this.enable = r1;
        }

        public final void e(Number r1) {
            this.expireTimestamp = r1;
        }

        public final void f(Boolean r1) {
            this.select = r1;
        }

        public final void g(String r1) {
            this.subTitle = r1;
        }

        public final void h(String r1) {
            this.title = r1;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/recharge/jsbridge/RevenueRequestDiamondCouponInfoResultModel$b;", "", "", "dealId", "Ljava/lang/Number;", "getDealId", "()Ljava/lang/Number;", "b", "(Ljava/lang/Number;)V", "price", "getPrice", "c", "", "preCalcInfo", "Ljava/lang/String;", "getPreCalcInfo", "()Ljava/lang/String;", "setPreCalcInfo", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/live/recharge/jsbridge/RevenueRequestDiamondCouponInfoResultModel$a;", "coupons", "Ljava/util/List;", "getCoupons", "()Ljava/util/List;", "a", "(Ljava/util/List;)V", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        @SerializedName("coupons")
        private List<a> coupons;

        @SerializedName("dealId")
        private Number dealId;

        @SerializedName("preCalcInfo")
        private String preCalcInfo;

        @SerializedName("price")
        private Number price;

        public b() {
        }

        public final void a(List<a> r1) {
            this.coupons = r1;
        }

        public final void b(Number r1) {
            this.dealId = r1;
        }

        public final void c(Number r1) {
            this.price = r1;
        }
    }

    public RevenueRequestDiamondCouponInfoResultModel() {
    }

    public final void a(Code r1) {
        this.code = r1;
    }

    public final void b(b r1) {
        this.data = r1;
    }
}
