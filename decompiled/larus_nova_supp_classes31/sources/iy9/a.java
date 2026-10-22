package iy9;

import com.larus.bmhome.bigimg.e;
import com.larus.bmhome.bigimg.l;
import com.larus.bmhome.bigimg.n1;
import com.larus.search.api.event.HybridEventParams;
import ic8.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uo8.k;
import zo8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a<DATA extends zo8.a> {
    public final Function0<Unit> A;
    public int B;
    public String C;
    public String D;
    public final List<? extends DATA> a;
    public final int b;
    public final k c;
    public final e d;
    public final String e;
    public final List<n1> f;
    public final List<String> g;
    public final boolean h;
    public final int i;
    public final int j;
    public final String k;
    public final Function0<Unit> l;
    public final Function0<Unit> m;
    public final int n;
    public final JSONObject o;
    public final HybridEventParams p;
    public final Integer q;
    public final d r;
    public final d s;
    public final d t;
    public final d u;
    public final d v;
    public final l w;
    public final boolean x;
    public final long y;
    public final boolean z;

    public a() {
        this(null, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, false, 0, false, null, 134217727);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r9.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r9.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r9.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r9.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r9.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r9.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r9.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r9.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r9.w) == true) goto L78;
        return false;
    L78:
        if (this.x == r9.x) goto L81;
        return false;
    L81:
        if (this.y == r9.y) goto L84;
        return false;
    L84:
        if (this.z == r9.z) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r9.A) == true) goto L89;
        return false;
    L89:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        k r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        e r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((r4 + r6) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        List<String> r8 = this.g;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        int r11 = 1231;
        if (this.h == false) goto L17;
        int r12 = 1231;
    L18:
        int r13 = (((((r10 + r12) * 31) + this.i) * 31) + this.j) * 31;
        String r14 = this.k;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Function0<Unit> r17 = this.l;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Function0<Unit> r20 = this.m;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (((r19 + r21) * 31) + this.n) * 31;
        JSONObject r23 = this.o;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        HybridEventParams r26 = this.p;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        Integer r29 = this.q;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (((((((((((r28 + r30) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31) + this.t.hashCode()) * 31) + this.u.hashCode()) * 31) + this.v.hashCode()) * 31;
        l r32 = this.w;
        if (r32 != null) goto L45;
        int r33 = 0;
    L46:
        int r34 = (r31 + r33) * 31;
        if (this.x == false) goto L49;
        int r35 = 1231;
    L50:
        long r36 = this.y;
        int r37 = (((r34 + r35) * 31) + ((int) (r36 ^ (r36 >>> 32)))) * 31;
        if (this.z == true) goto L54;
        r11 = 1237;
    L54:
        int r38 = (r37 + r11) * 31;
        Function0<Unit> r39 = this.A;
        if (r39 == null) goto L59;
        r2 = r39.hashCode();
    L59:
        return r38 + r2;
    L49:
        r35 = 1237;
        goto L50
    L45:
        r33 = r32.hashCode();
        goto L46
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = 1237;
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageDetailFragmentProp(initList=" + this.a + ", initPosition=" + this.b + ", initReportParams=" + this.c + ", scrollListener=" + this.d + ", initMessageId=" + this.e + ", imageUrls=" + this.f + ", thumbImageUrls=" + this.g + ", showIndicator=" + this.h + ", currentPagerPos=" + this.i + ", totalIndicator=" + this.j + ", messageId=" + this.k + ", callback=" + this.l + ", callbackByClick=" + this.m + ", direction=" + this.n + ", reportParam=" + this.o + ", hybridEventParams=" + this.p + ", currentCreationTypeFromIM=" + this.q + ", aiImageParams=" + this.r + ", aiVideoParams=" + this.s + ", aiImageExpandParams=" + this.t + ", aiImageErasePrams=" + this.u + ", aiImageSharepnessParams=" + this.v + ", imageInfo=" + this.w + ", disableCollection=" + this.x + ", entryClickTimeStamp=" + this.y + ", isCaseMode=" + this.z + ", onPagerDestroy=" + this.A + ')';
    }

    public a(List r34, int r35, k r36, e r37, String r38, List r39, List r40, int r41, String r42, pz9.d r43, pz9.e r44, int r45, JSONObject r46, Integer r47, d r48, d r49, d r50, d r51, d r52, boolean r53, long r54, boolean r56, Function0 r57, int r58) {
        if ((r58 & 1) == 0) goto L5;
        List r2 = new ArrayList();
    L7:
        if ((r58 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r58 & 4) == 0) goto L13;
        k r5 = null;
    L15:
        if ((r58 & 8) == 0) goto L17;
        e r7 = null;
    L19:
        if ((r58 & 16) == 0) goto L21;
        String r8 = "";
    L23:
        if ((r58 & 32) == 0) goto L25;
        List r10 = CollectionsKt.emptyList();
    L27:
        if ((r58 & 64) == 0) goto L29;
        List r11 = null;
    L31:
        if ((r58 & 256) == 0) goto L33;
        int r12 = 0;
    L35:
        if ((r58 & 1024) == 0) goto L37;
        String r13 = null;
    L39:
        if ((r58 & 2048) == 0) goto L41;
        pz9.d r14 = null;
    L43:
        if ((r58 & 4096) == 0) goto L45;
        pz9.e r15 = null;
    L47:
        if ((r58 & 8192) == 0) goto L49;
        int r6 = 0;
    L51:
        if ((r58 & 16384) == 0) goto L53;
        JSONObject r4 = null;
    L55:
        if ((r58 & 65536) == 0) goto L57;
        Integer r9 = null;
    L59:
        if ((r58 & 131072) == 0) goto L61;
        d r16 = new d(false, null, null, false, null, null, 63);
    L63:
        if ((r58 & 262144) == 0) goto L65;
        d r17 = new d(false, null, null, false, null, null, 63);
    L67:
        if ((r58 & 524288) == 0) goto L69;
        d r18 = new d(false, null, null, false, null, null, 63);
    L71:
        if ((r58 & 1048576) == 0) goto L73;
        d r19 = new d(false, null, null, false, null, null, 63);
    L75:
        if ((r58 & 2097152) == 0) goto L77;
        d r110 = new d(false, null, null, false, null, null, 63);
    L79:
        if ((r58 & 8388608) == 0) goto L81;
        boolean r28 = false;
    L83:
        if ((r58 & 16777216) == 0) goto L85;
        long r29 = 0;
    L87:
        if ((r58 & 33554432) == 0) goto L89;
        boolean r31 = false;
    L91:
        if ((r58 & 67108864) == 0) goto L93;
        Function0 r21 = null;
    L94:
        Intrinsics.checkNotNullParameter(r2, "initList");
        Intrinsics.checkNotNullParameter(r8, "initMessageId");
        Intrinsics.checkNotNullParameter(r10, "imageUrls");
        Intrinsics.checkNotNullParameter(r16, "aiImageParams");
        Intrinsics.checkNotNullParameter(r17, "aiVideoParams");
        Intrinsics.checkNotNullParameter(r18, "aiImageExpandParams");
        Intrinsics.checkNotNullParameter(r19, "aiImageErasePrams");
        Intrinsics.checkNotNullParameter(r110, "aiImageSharepnessParams");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r10;
        this.g = r11;
        this.h = false;
        this.i = r12;
        this.j = 0;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r6;
        this.o = r4;
        this.p = null;
        this.q = r9;
        this.r = r16;
        this.s = r17;
        this.t = r18;
        this.u = r19;
        this.v = r110;
        this.w = null;
        this.x = r28;
        this.y = r29;
        this.z = r31;
        this.A = r21;
        this.C = "";
        return;
    L93:
        r21 = r57;
        goto L94
    L89:
        r31 = r56;
        goto L91
    L85:
        r29 = r54;
        goto L87
    L81:
        r28 = r53;
        goto L83
    L77:
        r110 = r52;
        goto L79
    L73:
        r19 = r51;
        goto L75
    L69:
        r18 = r50;
        goto L71
    L65:
        r17 = r49;
        goto L67
    L61:
        r16 = r48;
        goto L63
    L57:
        r9 = r47;
        goto L59
    L53:
        r4 = r46;
        goto L55
    L49:
        r6 = r45;
        goto L51
    L45:
        r15 = r44;
        goto L47
    L41:
        r14 = r43;
        goto L43
    L37:
        r13 = r42;
        goto L39
    L33:
        r12 = r41;
        goto L35
    L29:
        r11 = r40;
        goto L31
    L25:
        r10 = r39;
        goto L27
    L21:
        r8 = r38;
        goto L23
    L17:
        r7 = r37;
        goto L19
    L13:
        r5 = r36;
        goto L15
    L9:
        r3 = r35;
        goto L11
    L5:
        r2 = r34;
        goto L7
    }
}
