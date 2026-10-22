package com.bytedance.android.live.recharge.order;

import com.bytedance.android.live.recharge.platform.model.NoPasswordPayType;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    public final j a;
    public final String b;
    public final boolean c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final long g;
    public final int h;
    public final int i;
    public final JSONObject j;
    public final NoPasswordPayType k;
    public final Map<String, String> l;
    public final Map<String, String> m;

    public k() {
        this(null, null, false, 0, false, false, 0, 0, null, null, null, 8191);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof k) == false) goto L32;
        k r7 = (k) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (this.h == r7.h) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r7.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r7.m) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final int hashCode() {
        j r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = 1;
        ?? r9 = r7;
        if (r7 == false) goto L13;
        r9 = 1;
    L13:
        int r10 = (((r6 + r9) * 31) + this.d) * 31;
        boolean r12 = this.e;
        ?? r13 = r12;
        if (r12 == false) goto L16;
        r13 = 1;
    L16:
        int r14 = (r10 + r13) * 31;
        boolean r15 = this.f;
        if (r15 == true) goto L20;
        r8 = r15;
    L20:
        long r16 = this.g;
        int r17 = (((((((r14 + r8) * 31) + ((int) (r16 ^ (r16 >>> 32)))) * 31) + this.h) * 31) + this.i) * 31;
        JSONObject r18 = this.j;
        if (r18 == null) goto L23;
        int r19 = r18.hashCode();
    L24:
        int r20 = (r17 + r19) * 31;
        NoPasswordPayType r22 = this.k;
        if (r22 == null) goto L27;
        int r23 = r22.hashCode();
    L28:
        int r24 = (r20 + r23) * 31;
        Map<String, String> r25 = this.l;
        if (r25 == null) goto L31;
        int r26 = r25.hashCode();
    L32:
        int r27 = (r24 + r26) * 31;
        Map<String, String> r28 = this.m;
        if (r28 == null) goto L36;
        r1 = r28.hashCode();
    L36:
        return r27 + r1;
    L31:
        r26 = 0;
        goto L32
    L27:
        r23 = 0;
        goto L28
    L23:
        r19 = 0;
        goto L24
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RechargeOrderOptions(eventProperties=" + this.a + ", oneStepPayScene=" + this.b + ", isFastPay=" + this.c + ", rechargeDialogHeight=" + this.d + ", supportCombinedPay=" + this.e + ", useCombinedPay=" + this.f + ", combinedPayIncomeAmount=" + this.g + ", orderSource=" + this.h + ", businessScene=" + this.i + ", bizExtra=" + this.j + ", noPasswordPayType=" + this.k + ", queriesMap=" + this.l + ", extraMap=" + this.m + ")";
    }

    public static k a(k r18, j r19, String r20, JSONObject r22, NoPasswordPayType r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        j r4 = r18.a;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r5 = r18.b;
    L11:
        if ((r24 & 4) == 0) goto L13;
        boolean r6 = r18.c;
    L15:
        if ((r24 & 8) == 0) goto L17;
        int r7 = r18.d;
    L19:
        if ((r24 & 16) == 0) goto L21;
        boolean r8 = r18.e;
    L23:
        if ((r24 & 32) == 0) goto L25;
        boolean r9 = r18.f;
    L27:
        if ((r24 & 64) == 0) goto L29;
        long r10 = r18.g;
    L31:
        if ((r24 & 128) == 0) goto L33;
        int r12 = r18.h;
    L35:
        if ((r24 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L37;
        int r13 = r18.i;
    L39:
        if ((r24 & 512) == 0) goto L41;
        JSONObject r14 = r18.j;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        NoPasswordPayType r15 = r18.k;
    L47:
        if ((r24 & 2048) == 0) goto L49;
        Map<String, String> r2 = r18.l;
    L51:
        if ((r24 & 4096) == 0) goto L53;
        Map<String, String> r1 = r18.m;
    L54:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r4, "eventProperties");
        Intrinsics.checkNotNullParameter(r5, "oneStepPayScene");
        Intrinsics.checkNotNullParameter(r14, "bizExtra");
        Intrinsics.checkNotNullParameter(r15, "noPasswordPayType");
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        Intrinsics.checkNotNullParameter(r1, "extraMap");
        return new k(r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r2, r1);
    L53:
        r1 = null;
        goto L54
    L49:
        r2 = null;
        goto L51
    L45:
        r15 = r23;
        goto L47
    L41:
        r14 = r22;
        goto L43
    L37:
        r13 = 0;
        goto L39
    L33:
        r12 = 0;
        goto L35
    L29:
        r10 = 0;
        goto L31
    L25:
        r9 = false;
        goto L27
    L21:
        r8 = false;
        goto L23
    L17:
        r7 = 0;
        goto L19
    L13:
        r6 = false;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }

    public /* synthetic */ k(j r18, String r19, boolean r20, int r22, boolean r23, boolean r24, int r25, int r26, JSONObject r27, NoPasswordPayType r28, Map r29, int r210) {
        if ((r210 & 1) == 0) goto L5;
        j r3 = new j();
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r210 & 4) == 0) goto L13;
        boolean r5 = false;
    L15:
        if ((r210 & 8) == 0) goto L17;
        int r6 = 0;
    L19:
        if ((r210 & 16) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r210 & 32) == 0) goto L25;
        boolean r8 = false;
    L27:
        if ((r210 & 128) == 0) goto L29;
        int r12 = -1;
    L31:
        if ((r210 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L33;
        int r13 = -1;
    L35:
        if ((r210 & 512) == 0) goto L37;
        JSONObject r14 = new JSONObject();
    L39:
        if ((r210 & 1024) == 0) goto L41;
        NoPasswordPayType r15 = NoPasswordPayType.NOT_USE_NO_PASSWORD;
    L43:
        if ((r210 & 2048) == 0) goto L45;
        Map r16 = new LinkedHashMap();
    L47:
        if ((r210 & 4096) == 0) goto L49;
        LinkedHashMap r0 = new LinkedHashMap();
    L50:
        this(r3, r4, r5, r6, r7, r8, 0, r12, r13, r14, r15, r16, r0);
        return;
    L49:
        r0 = null;
        goto L50
    L45:
        r16 = r29;
        goto L47
    L41:
        r15 = r28;
        goto L43
    L37:
        r14 = r27;
        goto L39
    L33:
        r13 = r26;
        goto L35
    L29:
        r12 = r25;
        goto L31
    L25:
        r8 = r24;
        goto L27
    L21:
        r7 = r23;
        goto L23
    L17:
        r6 = r22;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r3 = r18;
        goto L7
    }

    public k(j r2, String r3, boolean r4, int r5, boolean r6, boolean r7, long r8, int r10, int r12, JSONObject r13, NoPasswordPayType r14, Map<String, String> r15, Map<String, String> r16) {
        Intrinsics.checkNotNullParameter(r2, "eventProperties");
        Intrinsics.checkNotNullParameter(r3, "oneStepPayScene");
        Intrinsics.checkNotNullParameter(r13, "bizExtra");
        Intrinsics.checkNotNullParameter(r14, "noPasswordPayType");
        Intrinsics.checkNotNullParameter(r15, "queriesMap");
        Intrinsics.checkNotNullParameter(r16, "extraMap");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r10;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
    }
}
