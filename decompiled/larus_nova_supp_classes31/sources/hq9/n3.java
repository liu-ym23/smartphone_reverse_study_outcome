package hq9;

import android.app.Activity;
import com.larus.platform.model.NotificationType;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n3 {
    public final String a;
    public final String b;
    public final boolean c;
    public final String d;
    public final String e;
    public final NotificationType f;
    public final long g;
    public final String h;
    public final List<String> i;
    public final q3 j;
    public final e4 k;
    public final String l;
    public final String m;
    public final List<Integer> n;
    public final r3 o;
    public final Activity p;
    public final boolean q;
    public final Function0<Unit> r;
    public final boolean s;
    public final Function0<Unit> t;

    public n3() {
        throw null;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof n3) == true) goto L8;
        return false;
    L8:
        n3 r9 = (n3) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
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
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r9.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r9.p) == true) goto L57;
        return false;
    L57:
        if (this.q == r9.q) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r9.r) == true) goto L63;
        return false;
    L63:
        if (this.s == r9.s) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r9.t) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        int r4 = 1231;
        if (this.c == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (((((((r3 + r5) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        long r7 = this.g;
        int r8 = (((r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31) + this.h.hashCode()) * 31;
        List<String> r9 = this.i;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        q3 r12 = this.j;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        e4 r15 = this.k;
        if (r15 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (((((((r14 + r16) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31;
        r3 r18 = this.o;
        if (r18 != null) goto L25;
        int r19 = 0;
    L26:
        int r20 = (r17 + r19) * 31;
        Activity r21 = this.p;
        if (r21 != null) goto L29;
        int r22 = 0;
    L30:
        int r23 = (r20 + r22) * 31;
        if (this.q == false) goto L33;
        int r24 = 1231;
    L34:
        int r25 = (r23 + r24) * 31;
        Function0<Unit> r26 = this.r;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        if (this.s == true) goto L42;
        r4 = 1237;
    L42:
        int r29 = (r28 + r4) * 31;
        Function0<Unit> r30 = this.t;
        if (r30 == null) goto L47;
        r1 = r30.hashCode();
    L47:
        return r29 + r1;
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = 1237;
        goto L34
    L29:
        r22 = r21.hashCode();
        goto L30
    L25:
        r19 = r18.hashCode();
        goto L26
    L21:
        r16 = r15.hashCode();
        goto L22
    L17:
        r13 = r12.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "NotificationRequest(identity=" + this.a + ", avatarUrl=" + this.b + ", avatarRoundAsCircle=" + this.c + ", title=" + this.d + ", content=" + this.e + ", type=" + this.f + ", displayDuration=" + this.g + ", business=" + this.h + ", displayPageName=" + this.i + ", clickCallBack=" + this.j + ", rightTextAction=" + this.k + ", leftImageLocalPath=" + this.l + ", leftImageUrl=" + this.m + ", rightImageResIdList=" + this.n + ", clickImageCallBack=" + this.o + ", targetActivity=" + this.p + ", skipDisplayNameCheck=" + this.q + ", cardClickAction=" + this.r + ", enableSystemWindowFallback=" + this.s + ", dismissCallback=" + this.t + ')';
    }

    public final NotificationType getType() {
        return this.f;
    }

    public n3(String r24, String r25, String r26, String r27, NotificationType r28, long r29, String r31, List r32, q3 r33, e4 r34, String r35, List r36, r3 r37, Activity r38, boolean r39, Function0 r40, boolean r41, Function0 r42, int r43) {
        if ((r43 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r43 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r43 & 4) == 0) goto L13;
        boolean r7 = true;
    L15:
        if ((r43 & 8) == 0) goto L17;
        String r9 = "";
    L19:
        if ((r43 & 16) == 0) goto L21;
        String r10 = "";
    L23:
        if ((r43 & 32) == 0) goto L25;
        NotificationType r11 = NotificationType.DEFAULT;
    L27:
        if ((r43 & 64) == 0) goto L29;
        long r12 = 5000;
    L31:
        if ((r43 & 256) == 0) goto L33;
        List r14 = null;
    L35:
        if ((r43 & 512) == 0) goto L37;
        q3 r15 = null;
    L39:
        if ((r43 & 1024) == 0) goto L41;
        e4 r4 = null;
    L43:
        if ((r43 & 2048) == 0) goto L45;
        String r8 = "";
    L47:
        if ((r43 & 4096) == 0) goto L49;
        String r6 = "";
    L50:
        e4 r17 = r4;
        if ((r43 & 8192) == 0) goto L53;
        List r13 = CollectionsKt.emptyList();
    L54:
        q3 r210 = r15;
        if ((r43 & 16384) == 0) goto L57;
        r3 r16 = null;
    L59:
        if ((r43 & 32768) == 0) goto L61;
        Activity r19 = null;
    L63:
        if ((r43 & 65536) == 0) goto L65;
        boolean r20 = false;
    L67:
        if ((r43 & 131072) == 0) goto L69;
        Function0 r21 = null;
    L71:
        if ((r43 & 262144) == 0) goto L73;
        boolean r22 = false;
    L75:
        if ((r43 & 524288) == 0) goto L77;
        Function0 r18 = null;
    L78:
        Intrinsics.checkNotNullParameter(r5, "avatarUrl");
        Intrinsics.checkNotNullParameter(r9, "title");
        Intrinsics.checkNotNullParameter(r10, "content");
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r31, "business");
        Intrinsics.checkNotNullParameter(r8, "leftImageLocalPath");
        Intrinsics.checkNotNullParameter(r6, "leftImageUrl");
        Intrinsics.checkNotNullParameter(r13, "rightImageResIdList");
        this.a = r3;
        this.b = r5;
        this.c = r7;
        this.d = r9;
        this.e = r10;
        this.f = r11;
        this.g = r12;
        this.h = r31;
        this.i = r14;
        this.j = r210;
        this.k = r17;
        this.l = r8;
        this.m = r6;
        this.n = r13;
        this.o = r16;
        this.p = r19;
        this.q = r20;
        this.r = r21;
        this.s = r22;
        this.t = r18;
        return;
    L77:
        r18 = r42;
        goto L78
    L73:
        r22 = r41;
        goto L75
    L69:
        r21 = r40;
        goto L71
    L65:
        r20 = r39;
        goto L67
    L61:
        r19 = r38;
        goto L63
    L57:
        r16 = r37;
        goto L59
    L53:
        r13 = r36;
        goto L54
    L49:
        r6 = r35;
        goto L50
    L45:
        r8 = null;
        goto L47
    L41:
        r4 = r34;
        goto L43
    L37:
        r15 = r33;
        goto L39
    L33:
        r14 = r32;
        goto L35
    L29:
        r12 = r29;
        goto L31
    L25:
        r11 = r28;
        goto L27
    L21:
        r10 = r27;
        goto L23
    L17:
        r9 = r26;
        goto L19
    L13:
        r7 = false;
        goto L15
    L9:
        r5 = r25;
        goto L11
    L5:
        r3 = r24;
        goto L7
    }
}
