package gh7;

import dh7.b;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class j implements b {
    public final String a;
    public final int b;
    public final String c;
    public final Set<String> d;
    public final boolean e;
    public final boolean f;
    public final String g;
    public final String h;
    public final String i;
    public final Set<Map<String, ?>> j;

    public final Map<String, ?> a() {
        Map<String, ?> r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("source", this.a), TuplesKt.to("api_id", Integer.valueOf(this.b)), TuplesKt.to("data_types", this.d), TuplesKt.to("permission_type", this.c), TuplesKt.to("is_pair_not_close", Boolean.valueOf(this.e)), TuplesKt.to("is_pair_delay_close", Boolean.valueOf(this.f))});
        String r1 = this.g;
        if (r1 == null) goto L5;
        r0.put("cert_token", r1);
    L5:
        String r2 = this.h;
        if (r2 == null) goto L8;
        r0.put("context_page", r2);
    L8:
        return r0;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L26;
        j r4 = (j) r3;
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
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
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
        Set<String> r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.e;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L17;
        r12 = 1;
    L17:
        int r13 = (r9 + r12) * 31;
        boolean r14 = this.f;
        if (r14 == true) goto L21;
        r11 = r14;
    L21:
        int r15 = (r13 + r11) * 31;
        String r16 = this.g;
        if (r16 == null) goto L24;
        int r17 = r16.hashCode();
    L25:
        int r18 = (r15 + r17) * 31;
        String r19 = this.h;
        if (r19 == null) goto L28;
        int r20 = r19.hashCode();
    L29:
        int r21 = (r18 + r20) * 31;
        String r22 = this.i;
        if (r22 == null) goto L32;
        int r23 = r22.hashCode();
    L33:
        int r24 = (r21 + r23) * 31;
        Set<Map<String, ?>> r25 = this.j;
        if (r25 == null) goto L37;
        r1 = r25.hashCode();
    L37:
        return r24 + r1;
    L32:
        r23 = 0;
        goto L33
    L28:
        r20 = 0;
        goto L29
    L24:
        r17 = 0;
        goto L25
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
        return "RuleValidateParams(source=" + this.a + ", apiId=" + this.b + ", permissionType=" + this.c + ", dataTypes=" + this.d + ", isPairNotClose=" + this.e + ", isPairDelayClose=" + this.f + ", certToken=" + this.g + ", contextPage=" + this.h + ", returnType=" + this.i + ", extraParams=" + this.j + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(String r1, int r2, String r3, Set<String> r4, boolean r5, boolean r6, String r7, String r8, String r9, Set<? extends Map<String, ?>> r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
