package com.bytedance.android.live.recharge.platform.service;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.wallet.DetailChargeDeal;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PayService implements com.bytedance.android.scope.o {
    public final y a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/service/PayService$PayProgress;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "START", "SHOW_CASHIER", "QUERY_ORDER", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum PayProgress extends Enum<PayProgress> {
        public static final PayProgress QUERY_ORDER = null;
        public static final PayProgress SHOW_CASHIER = null;
        public static final PayProgress START = null;
        public static final PayProgress UNKNOWN = null;
        public static final /* synthetic */ PayProgress[] a = null;
        private final int value;

        static {
            PayProgress r1 = new PayProgress("UNKNOWN", 0, -1);
            UNKNOWN = r1;
            PayProgress r2 = new PayProgress("START", 1, 0);
            START = r2;
            PayProgress r3 = new PayProgress("SHOW_CASHIER", 2, 2);
            SHOW_CASHIER = r3;
            PayProgress r4 = new PayProgress("QUERY_ORDER", 3, 1);
            QUERY_ORDER = r4;
            a = new PayProgress[]{r1, r2, r3, r4};
        }

        public static PayProgress valueOf(String r1) {
            return (PayProgress) r27.a.a(PayProgress.class, r1);
        }

        public static PayProgress[] values() {
            return (PayProgress[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public PayProgress(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public interface a {
        void a(b r1);

        void b(PayProgress r1);
    }

    public static final class b {
        public final int a;
        public final String b;
        public final a c;
        public final boolean d;

        public static final class a {
            public final long a;
            public final long b;
            public final String c;
            public final String d;
            public final Map<String, String> e;
            public final String f;

            public final boolean equals(Object r6) {
                if (this != r6) goto L4;
                return true;
            L4:
                if ((r6 instanceof a) == false) goto L18;
                a r7 = (a) r6;
                if (this.a == r7.a) goto L8;
                return false;
            L8:
                if (this.b == r7.b) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.f, r7.f) == true) goto L28;
                return false;
            L28:
                return true;
            L18:
                return false;
            }

            public final int hashCode() {
                long r0 = this.a;
                int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
                long r3 = this.b;
                int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
                String r4 = this.c;
                int r5 = 0;
                if (r4 == null) goto L5;
                int r6 = r4.hashCode();
            L6:
                int r7 = (r2 + r6) * 31;
                String r8 = this.d;
                if (r8 == null) goto L9;
                int r9 = r8.hashCode();
            L10:
                int r10 = (r7 + r9) * 31;
                Map<String, String> r12 = this.e;
                if (r12 == null) goto L13;
                int r13 = r12.hashCode();
            L14:
                int r14 = (r10 + r13) * 31;
                String r15 = this.f;
                if (r15 == null) goto L18;
                r5 = r15.hashCode();
            L18:
                return r14 + r5;
            L13:
                r13 = 0;
                goto L14
            L9:
                r9 = 0;
                goto L10
            L5:
                r6 = 0;
                goto L6
            }

            public final String toString() {
                return "Extra(rebateAmount=" + this.a + ", deductAmount=" + this.b + ", rebateMessage=" + this.c + ", cjParams=" + this.d + ", extra=" + this.e + ", oneStepScene=" + this.f + ")";
            }

            public a(long r2, long r4, String r6, String r7, Map<String, String> r8, String r9) {
                Intrinsics.checkNotNullParameter(r6, "rebateMessage");
                Intrinsics.checkNotNullParameter(r7, "cjParams");
                Intrinsics.checkNotNullParameter(r8, "extra");
                Intrinsics.checkNotNullParameter(r9, "oneStepScene");
                this.a = r2;
                this.b = r4;
                this.c = r6;
                this.d = r7;
                this.e = r8;
                this.f = r9;
            }
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L14;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v8 */
        public final int hashCode() {
            int r0 = this.a * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            a r5 = this.c;
            if (r5 == null) goto L9;
            r2 = r5.hashCode();
        L9:
            int r6 = (r4 + r2) * 31;
            boolean r7 = this.d;
            ?? r8 = r7;
            if (r7 == false) goto L13;
            r8 = 1;
        L13:
            return r6 + r8;
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "PayResult(statusCode=" + this.a + ", message=" + this.b + ", extra=" + this.c + ", isNoPasswordPay=" + this.d + ")";
        }

        public /* synthetic */ b(String r4) {
            this(-60001, r4, null, false);
        }

        public b(int r2, String r3, a r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "message");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public PayService(y r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.a = r2;
    }

    public static b.a c(com.bytedance.android.live.wallet.e.a r10) {
        long r1 = r10.a;
        long r3 = r10.b;
        String r0 = r10.c;
        if (r0 != null) goto L5;
        String r6 = "";
    L6:
        String r2 = r10.d;
        if (r2 != null) goto L9;
        String r7 = "";
    L10:
        HashMap r4 = r10.f;
        if (r4 != null) goto L14;
        r4 = new HashMap();
    L14:
        HashMap r8 = r4;
        String r12 = r10.e;
        if (r12 != null) goto L18;
        r12 = "";
    L18:
        return new b.a(r1, r3, r6, r7, r8, r12);
    L9:
        r7 = r2;
        goto L10
    L5:
        r6 = r0;
        goto L6
    }

    public final void a(com.bytedance.android.live.recharge.deal.f r7, com.bytedance.android.live.recharge.order.k r8, com.bytedance.android.live.recharge.utils.h r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "deal");
        Intrinsics.checkNotNullParameter(r8, "entranceParams");
        Intrinsics.checkNotNullParameter(r9, "callback");
        DetailChargeDeal.Builder r0 = new DetailChargeDeal.Builder();
        r0.diamondId(r7.b());
        r0.price((int) r7.g());
        if ((r7 instanceof com.bytedance.android.live.recharge.deal.d) == false) goto L5;
    L8:
        r0.customPrice(r7.g());
    L9:
        boolean r1 = false;
        r0.tradeType(0);
        this.a.getClass();
        yz0.k r2 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r2 == null) goto L14;
        IRoom r3 = r2.getRoom();
        if (r3 == null) goto L14;
        long r4 = r3.getRoomId();
    L15:
        r0.roomId(r4);
        r0.totalDiamond(r7.i());
        r0.requestPage(r8.a.b());
        com.bytedance.android.live.recharge.order.j r5 = r8.a;
        r0.chargeScene((String) r5.b.a(r5, com.bytedance.android.live.recharge.order.j.i[1]));
        String r6 = r8.a.a();
        if (r6.length() <= 0) goto L18;
        boolean r12 = true;
    L19:
        if (r12 == true) goto L22;
        r6 = null;
    L22:
        if (r6 == null) goto L24;
        r0.chargeReason(r6);
    L24:
        r0.openCombinePay(r7.c().b());
        r0.selectCombinePay(r8.f);
        r0.showFastPay(r8.c);
        r0.rechargeDialogHeight(r8.d);
        r0.extra(new HashMap(r8.a));
        r0.bizExtra(r8.j);
        com.bytedance.android.livesdk.revenue.service.interact.d r13 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        r0.liveType(r13.getLiveTypeForLog());
        r0.functionType(r13.getFunctionTypeForLog());
        int r14 = r8.h;
        if (r14 != (-1)) goto L28;
        r14 = 0;
    L28:
        r0.chargeOrderSource(r14);
        r0.chargeOrderBusinessScene(r8.i);
        String r15 = r8.a.b();
        if (TextUtils.equals("my_profile", r15) == false) goto L32;
        r0.chargeOrderSource(1);
    L41:
        if (com.bytedance.android.live.recharge.core.f.f(RechargeServices.b()).h() != true) goto L43;
        boolean r16 = true;
    L44:
        r0.isFirstCharge(r16);
        this.a.getClass();
        r0.ownerUserId(y.E1());
        r0.iapProductId(r7.f());
        if (com.bytedance.android.live.wallet.pay.iap.f.a() == true) goto L47;
    L49:
        r0.isIapPay(r1);
        r0.oneStepScene(r8.b);
        r0.noPasswordOrderType(r8.k.getValue());
        r0.queriesMap(r8.l);
        r0.extraMap(r8.m);
        r0.combineAmount(r10);
        DetailChargeDeal r17 = r0.build();
        com.bytedance.android.live.recharge.core.d r18 = RechargeServices.b();
        Intrinsics.checkNotNullParameter(r18, "$this$walletService");
        com.bytedance.android.live.wallet.e r19 = r18.f(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.wallet.e.class));
        Activity r110 = this.a.getActivity();
        if (r110 == null) goto L54;
        r19.Y(r110, r17, new w(this, r9));
        return;
    L54:
        throw new IllegalStateException("activity is null".toString());
    L47:
        if (r2.a(r7.f()) == false) goto L49;
        r1 = true;
        goto L49
    L43:
        r16 = false;
        goto L44
    L32:
        if (TextUtils.equals("fire", r15) == false) goto L35;
        r0.chargeOrderSource(7);
        goto L41
    L35:
        if (TextUtils.equals("renqibao", r15) == false) goto L38;
        r0.chargeOrderSource(16);
        goto L41
    L38:
        if (TextUtils.equals("videopay", r15) == false) goto L41;
        r0.chargeOrderSource(17);
        goto L41
    L18:
        r12 = false;
    L14:
        r4 = 0;
        goto L15
    L5:
        if ((r7 instanceof com.bytedance.android.live.recharge.deal.u) == false) goto L9;
        if (((com.bytedance.android.live.recharge.deal.u) r7).h == false) goto L9;
        goto L8
    }
}
