package fx0;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.livesdkapi.depend.model.CustomChargeDeal;
import com.bytedance.android.livesdkapi.depend.model.IChargeDeal;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R(\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011R\u001a\u0010\"\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R\u001a\u0010$\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u000f\u001a\u0004\b%\u0010\u0011R\u001a\u0010&\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u000f\u001a\u0004\b'\u0010\u0011R\u001a\u0010(\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0014\u001a\u0004\b)\u0010\u0016R\u001a\u0010+\u001a\u00020*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001a\u00100\u001a\u00020/8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u0014\u001a\u0004\b5\u0010\u0016¨\u00066"}, d2 = {"Lfx0/f$a;", "", "Lcom/bytedance/android/livesdkapi/depend/model/IChargeDeal;", "diamondData", "Lcom/bytedance/android/livesdkapi/depend/model/IChargeDeal;", "d", "()Lcom/bytedance/android/livesdkapi/depend/model/IChargeDeal;", "", "Lcom/bytedance/android/livesdkapi/depend/model/CustomChargeDeal;", "customizedDiamonds", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "roomId", "J", "getRoomId", "()J", "", "requestPage", "Ljava/lang/String;", "m", "()Ljava/lang/String;", "chargeReason", "a", "chargeScene", "b", "", "extra", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "previousGiftId", "h", "previousGiftMoney", "i", "previousPayMoney", "k", "moneyDiff", "g", "previousGiftType", "j", "", "recommendPackage", "I", "l", "()I", "", "isRecommendPackage", "Z", "n", "()Z", "eventModule", "e", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("charge_reason")
        private final String chargeReason;

        @SerializedName("charge_scene")
        private final String chargeScene;

        @SerializedName("customized_diamonds")
        private final List<CustomChargeDeal> customizedDiamonds;

        @SerializedName("diamond_data")
        private final IChargeDeal diamondData;

        @SerializedName("event_module")
        private final String eventModule;

        @SerializedName("extra")
        private final Map<String, String> extra;

        @SerializedName("is_recommend_package")
        private final boolean isRecommendPackage;

        @SerializedName("money_diff")
        private final long moneyDiff;

        @SerializedName("previous_gift_id")
        private final long previousGiftId;

        @SerializedName("previous_gift_money")
        private final long previousGiftMoney;

        @SerializedName("previous_gift_type")
        private final String previousGiftType;

        @SerializedName("previous_pay_money")
        private final long previousPayMoney;

        @SerializedName("recommend_package")
        private final int recommendPackage;

        @SerializedName("request_page")
        private final String requestPage;

        @SerializedName("room_id")
        private final long roomId;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof a) == false) goto L36;
            a r7 = (a) r6;
            if (Intrinsics.areEqual(this.diamondData, r7.diamondData) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.customizedDiamonds, r7.customizedDiamonds) == true) goto L10;
            return false;
        L10:
            if (this.roomId == r7.roomId) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.requestPage, r7.requestPage) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.chargeReason, r7.chargeReason) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.chargeScene, r7.chargeScene) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.extra, r7.extra) == true) goto L20;
            return false;
        L20:
            if (this.previousGiftId == r7.previousGiftId) goto L22;
            return false;
        L22:
            if (this.previousGiftMoney == r7.previousGiftMoney) goto L24;
            return false;
        L24:
            if (this.previousPayMoney == r7.previousPayMoney) goto L26;
            return false;
        L26:
            if (this.moneyDiff == r7.moneyDiff) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.previousGiftType, r7.previousGiftType) == true) goto L30;
            return false;
        L30:
            if (this.recommendPackage == r7.recommendPackage) goto L32;
            return false;
        L32:
            if (this.isRecommendPackage == r7.isRecommendPackage) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.eventModule, r7.eventModule) == true) goto L55;
            return false;
        L55:
            return true;
        L36:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v28, types: [int] */
        /* JADX WARN: Type inference failed for: r2v30, types: [int] */
        /* JADX WARN: Type inference failed for: r2v32 */
        /* JADX WARN: Type inference failed for: r2v39 */
        public final int hashCode() {
            IChargeDeal r0 = this.diamondData;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            List<CustomChargeDeal> r4 = this.customizedDiamonds;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            long r7 = this.roomId;
            int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
            String r9 = this.requestPage;
            if (r9 == null) goto L13;
            int r10 = r9.hashCode();
        L14:
            int r12 = (r8 + r10) * 31;
            String r13 = this.chargeReason;
            if (r13 == null) goto L17;
            int r14 = r13.hashCode();
        L18:
            int r15 = (r12 + r14) * 31;
            String r16 = this.chargeScene;
            if (r16 == null) goto L21;
            int r17 = r16.hashCode();
        L22:
            int r18 = (r15 + r17) * 31;
            Map<String, String> r19 = this.extra;
            if (r19 == null) goto L25;
            int r20 = r19.hashCode();
        L26:
            int r22 = (r18 + r20) * 31;
            long r23 = this.previousGiftId;
            int r24 = (r22 + ((int) (r23 ^ (r23 >>> 32)))) * 31;
            long r25 = this.previousGiftMoney;
            int r26 = (r24 + ((int) (r25 ^ (r25 >>> 32)))) * 31;
            long r27 = this.previousPayMoney;
            int r28 = (r26 + ((int) (r27 ^ (r27 >>> 32)))) * 31;
            long r29 = this.moneyDiff;
            int r30 = (r28 + ((int) (r29 ^ (r29 >>> 32)))) * 31;
            String r32 = this.previousGiftType;
            if (r32 == null) goto L29;
            int r33 = r32.hashCode();
        L30:
            int r34 = (((r30 + r33) * 31) + this.recommendPackage) * 31;
            boolean r35 = this.isRecommendPackage;
            ?? r36 = r35;
            if (r35 == false) goto L33;
            r36 = 1;
        L33:
            int r37 = (r34 + r36) * 31;
            String r38 = this.eventModule;
            if (r38 == null) goto L37;
            r1 = r38.hashCode();
        L37:
            return r37 + r1;
        L29:
            r33 = 0;
            goto L30
        L25:
            r20 = 0;
            goto L26
        L21:
            r17 = 0;
            goto L22
        L17:
            r14 = 0;
            goto L18
        L13:
            r10 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Param(diamondData=" + this.diamondData + ", customizedDiamonds=" + this.customizedDiamonds + ", roomId=" + this.roomId + ", requestPage=" + this.requestPage + ", chargeReason=" + this.chargeReason + ", chargeScene=" + this.chargeScene + ", extra=" + this.extra + ", previousGiftId=" + this.previousGiftId + ", previousGiftMoney=" + this.previousGiftMoney + ", previousPayMoney=" + this.previousPayMoney + ", moneyDiff=" + this.moneyDiff + ", previousGiftType=" + this.previousGiftType + ", recommendPackage=" + this.recommendPackage + ", isRecommendPackage=" + this.isRecommendPackage + ", eventModule=" + this.eventModule + ")";
        }

        public a() {
            Intrinsics.checkNotNullParameter("", "requestPage");
            Intrinsics.checkNotNullParameter("", "chargeReason");
            Intrinsics.checkNotNullParameter("", "chargeScene");
            Intrinsics.checkNotNullParameter("", "previousGiftType");
            Intrinsics.checkNotNullParameter("recommend", "eventModule");
            this.diamondData = null;
            this.customizedDiamonds = null;
            this.roomId = 0;
            this.requestPage = "";
            this.chargeReason = "";
            this.chargeScene = "";
            this.extra = null;
            this.previousGiftId = 0;
            this.previousGiftMoney = 0;
            this.previousPayMoney = 0;
            this.moneyDiff = 0;
            this.previousGiftType = "";
            this.recommendPackage = 0;
            this.isRecommendPackage = true;
            this.eventModule = "recommend";
        }

        public final String a() {
            return this.chargeReason;
        }

        public final String b() {
            return this.chargeScene;
        }

        public final List<CustomChargeDeal> c() {
            return this.customizedDiamonds;
        }

        public final IChargeDeal d() {
            return this.diamondData;
        }

        public final String e() {
            return this.eventModule;
        }

        public final Map<String, String> f() {
            return this.extra;
        }

        public final long g() {
            return this.moneyDiff;
        }

        public final long h() {
            return this.previousGiftId;
        }

        public final long i() {
            return this.previousGiftMoney;
        }

        public final String j() {
            return this.previousGiftType;
        }

        public final long k() {
            return this.previousPayMoney;
        }

        public final int l() {
            return this.recommendPackage;
        }

        public final String m() {
            return this.requestPage;
        }

        public final boolean n() {
            return this.isRecommendPackage;
        }
    }

    public final void onTerminate() {
    }

    public f() {
    }

    public final void invoke(Object r26, CallContext r27) {
        a r0 = (a) r26;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r27, "context");
        HashMap r1 = new HashMap();
        r1.put("previous_gift_id", String.valueOf(r0.h()));
        r1.put("previous_gift_money", String.valueOf(r0.i()));
        r1.put("previous_pay_money", String.valueOf(r0.k()));
        r1.put("money_diff", String.valueOf(r0.g()));
        r1.put("previous_gift_type", r0.j());
        r1.put("recommend_package", String.valueOf(r0.l()));
        r1.put("is_recommend_package", String.valueOf(r0.n()));
        r1.put("event_module", r0.e());
        Map<String, String> r3 = r0.f();
        if (r3 == null) goto L8;
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        Map.Entry<String, String> r5 = r4.next();
        r1.put(r5.getKey(), r5.getValue());
    L8:
        IChargeDeal r6 = r0.d();
        if (r6 == null) goto L11;
        int r7 = r6.getPrice();
    L12:
        List<CustomChargeDeal> r8 = r0.c();
        if (r8 == null) goto L27;
        List<CustomChargeDeal> r9 = r8;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r12 = r9.iterator();
    L16:
        if (r12.hasNext() == false) goto L26;
        CustomChargeDeal r13 = (CustomChargeDeal) r12.next();
        Intrinsics.checkNotNullParameter(r13, "$this$toCustomDeal");
        long r14 = r13.getId();
        long r15 = r13.getMinPrice();
        Iterator r24 = r12;
        long r16 = r13.getMaxPrice();
        String r17 = r13.getDescribe();
        if (r17 != null) goto L20;
        String r18 = "";
    L21:
        float r22 = r13.getDiamondCountRate();
        int r19 = r13.getRewardDiamondCount();
        String r20 = r13.getCouponId();
        if (r20 != null) goto L24;
        String r23 = "";
    L25:
        r10.add(new com.bytedance.android.live.recharge.deal.d(r14, 0, r19, r18, "", r15, r16, r22, r23, false));
        r12 = r24;
        goto L16
    L24:
        r23 = r20;
        goto L25
    L20:
        r18 = r17;
        goto L21
    L26:
        com.bytedance.android.live.recharge.deal.f r25 = com.bytedance.android.live.recharge.deal.e.a(r10, r7, false, false);
    L28:
        if (r25 != null) goto L35;
        IChargeDeal r28 = r0.d();
        if (r28 != null) goto L33;
    L39:
        finishWithFailure();
        return;
    L33:
        if (r28.isCustomizedDiamond() == true) goto L39;
        r25 = com.bytedance.android.live.recharge.deal.dto.a.c(r0.d());
    L35:
        com.bytedance.android.live.recharge.order.j r29 = new com.bytedance.android.live.recharge.order.j(r1);
        r29.e(r0.m());
        r29.d(r0.b());
        r29.c(r0.a());
        com.bytedance.android.live.recharge.order.k r2 = new com.bytedance.android.live.recharge.order.k(r29, null, false, 0, false, false, 0, 0, null, null, null, 8190);
        Context r30 = r27.getContext();
        com.bytedance.android.live.recharge.order.a r32 = com.bytedance.android.live.recharge.core.f.i(RechargeServices.b());
        if ((r30 instanceof Activity) == false) goto L38;
        Order r33 = com.bytedance.android.live.recharge.order.a.C0066a.a(r32, r25, r2);
        com.bytedance.android.live.revenue.common.reactive.j.a(((com.bytedance.android.live.recharge.order.f.b) r33).c, true).filter(com.bytedance.android.live.recharge.order.d.a).take(1).subscribe(new g(r33, this, r25));
        return;
    L38:
        finishWithFailure();
        return;
    L27:
        r25 = null;
        goto L28
    L11:
        r7 = 0;
        goto L12
    }
}
