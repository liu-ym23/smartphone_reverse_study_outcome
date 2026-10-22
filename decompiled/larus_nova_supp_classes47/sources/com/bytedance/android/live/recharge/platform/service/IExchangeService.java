package com.bytedance.android.live.recharge.platform.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface IExchangeService extends com.bytedance.android.live.recharge.core.c {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/service/IExchangeService$ExchangeApiType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "CASH", "GOLD_BALANCE", "HUOSHAN_FLAME", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum ExchangeApiType extends Enum<ExchangeApiType> {
        public static final ExchangeApiType CASH = null;
        public static final ExchangeApiType GOLD_BALANCE = null;
        public static final ExchangeApiType HUOSHAN_FLAME = null;
        public static final ExchangeApiType UNKNOWN = null;
        public static final /* synthetic */ ExchangeApiType[] a = null;
        private final int value;

        static {
            ExchangeApiType r1 = new ExchangeApiType("UNKNOWN", 0, -1);
            UNKNOWN = r1;
            ExchangeApiType r2 = new ExchangeApiType("CASH", 1, 0);
            CASH = r2;
            ExchangeApiType r3 = new ExchangeApiType("GOLD_BALANCE", 2, 1);
            GOLD_BALANCE = r3;
            ExchangeApiType r4 = new ExchangeApiType("HUOSHAN_FLAME", 3, 2);
            HUOSHAN_FLAME = r4;
            a = new ExchangeApiType[]{r1, r2, r3, r4};
        }

        public static ExchangeApiType valueOf(String r1) {
            return (ExchangeApiType) r27.a.a(ExchangeApiType.class, r1);
        }

        public static ExchangeApiType[] values() {
            return (ExchangeApiType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public ExchangeApiType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/service/IExchangeService$ExchangeProgress;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "START", "SUCCESS", "FAIL", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum ExchangeProgress extends Enum<ExchangeProgress> {
        public static final ExchangeProgress FAIL = null;
        public static final ExchangeProgress START = null;
        public static final ExchangeProgress SUCCESS = null;
        public static final ExchangeProgress UNKNOWN = null;
        public static final /* synthetic */ ExchangeProgress[] a = null;
        private final int value;

        static {
            ExchangeProgress r1 = new ExchangeProgress("UNKNOWN", 0, -1);
            UNKNOWN = r1;
            ExchangeProgress r2 = new ExchangeProgress("START", 1, 0);
            START = r2;
            ExchangeProgress r3 = new ExchangeProgress("SUCCESS", 2, 1);
            SUCCESS = r3;
            ExchangeProgress r4 = new ExchangeProgress("FAIL", 3, 2);
            FAIL = r4;
            a = new ExchangeProgress[]{r1, r2, r3, r4};
        }

        public static ExchangeProgress valueOf(String r1) {
            return (ExchangeProgress) r27.a.a(ExchangeProgress.class, r1);
        }

        public static ExchangeProgress[] values() {
            return (ExchangeProgress[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public ExchangeProgress(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public interface a {
        void a(c r1);

        void onFailure(Throwable r1);
    }

    public static final class b {
        public final com.bytedance.android.live.recharge.deal.f a;
        public final int b;
        public final int c;
        public final int d;
        public final ExchangeApiType e;
        public final String f;
        public final boolean g;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L20;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
            return false;
        L18:
            if (this.g == r4.g) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            com.bytedance.android.live.recharge.deal.f r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = ((((((r2 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
            ExchangeApiType r4 = this.e;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.f;
            if (r7 == null) goto L13;
            r1 = r7.hashCode();
        L13:
            int r8 = (r6 + r1) * 31;
            boolean r9 = this.g;
            ?? r10 = r9;
            if (r9 == false) goto L17;
            r10 = 1;
        L17:
            return r8 + r10;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ExchangeParams(deal=" + this.a + ", source=" + this.b + ", currency=" + this.c + ", accountType=" + this.d + ", exchangeType=" + this.e + ", ugExchangeVersion=" + this.f + ", allowEquivalentCash=" + this.g + ")";
        }

        public b(com.bytedance.android.live.recharge.deal.f r2, ExchangeApiType r3, String r4, boolean r5, int r6) {
            if ((r6 & 32) == 0) goto L6;
            r4 = "";
        L6:
            if ((r6 & 64) == 0) goto L8;
            r5 = true;
        L8:
            Intrinsics.checkNotNullParameter(r2, "deal");
            Intrinsics.checkNotNullParameter(r3, "exchangeType");
            Intrinsics.checkNotNullParameter(r4, "ugExchangeVersion");
            this.a = r2;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = r3;
            this.f = r4;
            this.g = r5;
        }
    }

    public static final class c {
        public final String a;
        public final int b;
        public final String c;
        public final String d;
        public final int e;
        public final String f;
        public final String g;
        public final com.bytedance.android.live.recharge.platform.business.model.exchange.b h;

        public c() {
            this(null, 0, null, null, 0, null, null, null, 255);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L22;
            c r4 = (c) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.h, r4.h) == true) goto L34;
            return false;
        L34:
            return true;
        L22:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = ((r2 * 31) + this.b) * 31;
            String r4 = this.c;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.d;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (((r6 + r8) * 31) + this.e) * 31;
            String r10 = this.f;
            if (r10 == null) goto L17;
            int r12 = r10.hashCode();
        L18:
            int r13 = (r9 + r12) * 31;
            String r14 = this.g;
            if (r14 == null) goto L21;
            int r15 = r14.hashCode();
        L22:
            int r16 = (r13 + r15) * 31;
            com.bytedance.android.live.recharge.platform.business.model.exchange.b r17 = this.h;
            if (r17 == null) goto L26;
            r1 = r17.hashCode();
        L26:
            return r16 + r1;
        L21:
            r15 = 0;
            goto L22
        L17:
            r12 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ExchangeResult(orderId=" + this.a + ", userType=" + this.b + ", prompt=" + this.c + ", promptBody=" + this.d + ", rebateAmount=" + this.e + ", rebateMessage=" + this.f + ", source=" + this.g + ", exchangeMarketData=" + this.h + ")";
        }

        public c(String r4, int r5, String r6, String r7, int r8, String r9, String r10, com.bytedance.android.live.recharge.platform.business.model.exchange.b r12, int r13) {
            if ((r13 & 1) == 0) goto L6;
            r4 = "";
        L6:
            if ((r13 & 2) == 0) goto L9;
            r5 = 0;
        L9:
            if ((r13 & 4) == 0) goto L12;
            r6 = "";
        L12:
            if ((r13 & 8) == 0) goto L15;
            r7 = "";
        L15:
            if ((r13 & 16) == 0) goto L18;
            r8 = 0;
        L18:
            if ((r13 & 32) == 0) goto L21;
            r9 = "";
        L21:
            if ((r13 & 64) == 0) goto L24;
            r10 = "";
        L24:
            if ((r13 & 128) == 0) goto L26;
            r12 = null;
        L26:
            Intrinsics.checkNotNullParameter(r4, "orderId");
            Intrinsics.checkNotNullParameter(r6, "prompt");
            Intrinsics.checkNotNullParameter(r7, "promptBody");
            Intrinsics.checkNotNullParameter(r9, "rebateMessage");
            Intrinsics.checkNotNullParameter(r10, "source");
            this.a = r4;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = r8;
            this.f = r9;
            this.g = r10;
            this.h = r12;
        }
    }

    void t1(b r1, com.bytedance.android.live.recharge.order.k r2, a r3);
}
