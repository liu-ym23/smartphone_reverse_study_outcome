package m0a;

import com.larus.ugc.feed.api.model.CommunityCreateLaunchModeKmp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public final CommunityCreateLaunchModeKmp a;
    public final int b;
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final int n;
    public final String o;

    public e() {
        this(null, 0, false, null, null, null, null, null, null, 0, null, 32767);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        String r3 = this.d;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        String r7 = this.e;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.g;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.h;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.i;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.j;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.k;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.l;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.m;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (((r30 + r32) * 31) + this.n) * 31;
        String r34 = this.o;
        if (r34 == null) goto L51;
        r4 = r34.hashCode();
    L51:
        return r33 + r4;
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "CommunityCreateInitParamsKmp(launchMode=" + this.a + ", recommendType=" + this.b + ", isMultiTab=" + this.c + ", previousPage=" + this.d + ", enterMethod=" + this.e + ", enterFrom=" + this.f + ", botId=" + this.g + ", conversationId=" + this.h + ", initRecommendation=" + this.i + ", initRecommendCreationId=" + this.j + ", defaultLandingTabId=" + this.k + ", templatePageType=" + this.l + ", multiTabTitleName=" + this.m + ", topPadding=" + this.n + ", overrideCurrentPage=" + this.o + ')';
    }

    public e(CommunityCreateLaunchModeKmp r3, int r4, boolean r5, String r6, String r7, String r8, String r9, String r10, String r11, int r12, String r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r3 = CommunityCreateLaunchModeKmp.STANDALONE;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r4 = 1;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r5 = false;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r14 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r14 & 64) == 0) goto L21;
        r8 = null;
    L21:
        if ((r14 & 1024) == 0) goto L24;
        r9 = null;
    L24:
        if ((r14 & 2048) == 0) goto L27;
        r10 = null;
    L27:
        if ((r14 & 4096) == 0) goto L30;
        r11 = null;
    L30:
        if ((r14 & 8192) == 0) goto L33;
        r12 = -1;
    L33:
        if ((r14 & 16384) == 0) goto L35;
        r13 = null;
    L35:
        Intrinsics.checkNotNullParameter(r3, "launchMode");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = null;
        this.g = r8;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = r9;
        this.l = r10;
        this.m = r11;
        this.n = r12;
        this.o = r13;
    }
}
