package d11;

import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.livesdk.link.model.bridge.g1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final int a;
    public final int b;
    public final int c;
    public final com.bytedance.android.livesdk.link.model.bridge.p d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final String h;
    public int i;
    public final String j;
    public final g1 k;
    public final String l;

    public a() {
        this(0, 0, 0, null, false, false, false, null, 0, null, null, null, 4095);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L30;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (this.i == r4.i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
        com.bytedance.android.livesdk.link.model.bridge.p r1 = this.d;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.e;
        ?? r6 = 1;
        ?? r7 = r5;
        if (r5 == false) goto L9;
        r7 = 1;
    L9:
        int r8 = (r4 + r7) * 31;
        boolean r9 = this.f;
        ?? r10 = r9;
        if (r9 == false) goto L12;
        r10 = 1;
    L12:
        int r12 = (r8 + r10) * 31;
        boolean r13 = this.g;
        if (r13 == true) goto L16;
        r6 = r13;
    L16:
        int r14 = (r12 + r6) * 31;
        String r15 = this.h;
        if (r15 == null) goto L19;
        int r16 = r15.hashCode();
    L20:
        int r17 = (((r14 + r16) * 31) + this.i) * 31;
        String r18 = this.j;
        if (r18 == null) goto L23;
        int r19 = r18.hashCode();
    L24:
        int r20 = (r17 + r19) * 31;
        g1 r22 = this.k;
        if (r22 == null) goto L27;
        int r23 = r22.hashCode();
    L28:
        int r24 = (r20 + r23) * 31;
        String r25 = this.l;
        if (r25 == null) goto L32;
        r2 = r25.hashCode();
    L32:
        return r24 + r2;
    L27:
        r23 = 0;
        goto L28
    L23:
        r19 = 0;
        goto L24
    L19:
        r16 = 0;
        goto L20
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorReplyParams{matchType=" + this.a + ", inviteType=" + this.b + ", inviteSource=" + this.c + ", isMultiReply=" + this.f + ", reqSrc=" + this.h + ", pkSwitchMode=" + this.i + '}';
    }

    public a(int r15, int r16, int r17, com.bytedance.android.livesdk.link.model.bridge.p r18, boolean r19, boolean r20, boolean r22, String r23, int r24, String r25, g1 r26, String r27, int r28) {
        int r3 = 0;
        if ((r28 & 1) == 0) goto L5;
        int r2 = 0;
    L7:
        if ((r28 & 2) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r28 & 4) == 0) goto L13;
        int r5 = 0;
    L14:
        String r7 = null;
        if ((r28 & 8) == 0) goto L17;
        com.bytedance.android.livesdk.link.model.bridge.p r6 = null;
    L19:
        if ((r28 & 16) == 0) goto L21;
        boolean r8 = false;
    L23:
        if ((r28 & 32) == 0) goto L25;
        boolean r9 = false;
    L27:
        if ((r28 & 64) == 0) goto L29;
        boolean r10 = false;
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r12 = "";
    L35:
        if ((r28 & DefaultConfig.MAX_CACHE_ENTRIES) != 0) goto L39;
        r3 = r24;
    L39:
        if ((r28 & 512) == 0) goto L41;
        String r13 = null;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        g1 r14 = null;
    L47:
        if ((r28 & 2048) != 0) goto L50;
        r7 = r27;
    L50:
        Intrinsics.checkNotNullParameter(r12, "reqSrc");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r12;
        this.i = r3;
        this.j = r13;
        this.k = r14;
        this.l = r7;
        return;
    L45:
        r14 = r26;
        goto L47
    L41:
        r13 = r25;
        goto L43
    L33:
        r12 = r23;
        goto L35
    L29:
        r10 = r22;
        goto L31
    L25:
        r9 = r20;
        goto L27
    L21:
        r8 = r19;
        goto L23
    L17:
        r6 = r18;
        goto L19
    L13:
        r5 = r17;
        goto L14
    L9:
        r4 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }
}
