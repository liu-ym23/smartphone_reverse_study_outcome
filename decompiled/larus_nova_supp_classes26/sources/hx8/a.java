package hx8;

import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultRoute;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final String A;
    public final List<String> B;
    public final CameraResultRoute C;
    public final CameraOutputContext D;
    public final String a;
    public final String b;
    public final List<Pair<String, String>> c;
    public final HashMap<String, Object> d;
    public final Map<String, String> e;
    public final List<String> f;
    public final String g;
    public final String h;
    public final Integer i;
    public final List<String> j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final String n;
    public final boolean o;
    public final int p;
    public final boolean q;
    public final Integer r;
    public final Integer s;
    public final boolean t;
    public final int u;
    public final String v;
    public final boolean w;
    public final boolean x;
    public final boolean y;
    public final boolean z;

    public a() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
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
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (this.q == r6.q) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (this.t == r6.t) goto L69;
        return false;
    L69:
        if (this.u == r6.u) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L75;
        return false;
    L75:
        if (this.w == r6.w) goto L78;
        return false;
    L78:
        if (this.x == r6.x) goto L81;
        return false;
    L81:
        if (this.y == r6.y) goto L84;
        return false;
    L84:
        if (this.z == r6.z) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r6.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r6.B) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.C, r6.C) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.D, r6.D) == true) goto L98;
        return false;
    L98:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        List<Pair<String, String>> r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        HashMap<String, Object> r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.e.hashCode()) * 31;
        List<String> r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.h;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.i;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        List<String> r20 = this.j;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        int r23 = 1231;
        if (this.k == false) goto L33;
        int r24 = 1231;
    L34:
        int r25 = (r22 + r24) * 31;
        if (this.l == false) goto L37;
        int r26 = 1231;
    L38:
        int r27 = (r25 + r26) * 31;
        if (this.m == false) goto L41;
        int r28 = 1231;
    L42:
        int r29 = (r27 + r28) * 31;
        String r30 = this.n;
        if (r30 != null) goto L45;
        int r31 = 0;
    L46:
        int r32 = (r29 + r31) * 31;
        if (this.o == false) goto L49;
        int r33 = 1231;
    L50:
        int r34 = (((r32 + r33) * 31) + this.p) * 31;
        if (this.q == false) goto L53;
        int r35 = 1231;
    L54:
        int r36 = (r34 + r35) * 31;
        Integer r37 = this.r;
        if (r37 != null) goto L57;
        int r38 = 0;
    L58:
        int r39 = (r36 + r38) * 31;
        Integer r40 = this.s;
        if (r40 != null) goto L61;
        int r41 = 0;
    L62:
        int r42 = (r39 + r41) * 31;
        if (this.t == false) goto L65;
        int r43 = 1231;
    L66:
        int r44 = (((r42 + r43) * 31) + this.u) * 31;
        String r45 = this.v;
        if (r45 != null) goto L69;
        int r46 = 0;
    L70:
        int r47 = (r44 + r46) * 31;
        if (this.w == false) goto L73;
        int r48 = 1231;
    L74:
        int r49 = (r47 + r48) * 31;
        if (this.x == false) goto L77;
        int r50 = 1231;
    L78:
        int r51 = (r49 + r50) * 31;
        if (this.y == false) goto L81;
        int r52 = 1231;
    L82:
        int r53 = (r51 + r52) * 31;
        if (this.z == true) goto L86;
        r23 = 1237;
    L86:
        int r54 = (((((r53 + r23) * 31) + this.A.hashCode()) * 31) + this.B.hashCode()) * 31;
        CameraResultRoute r55 = this.C;
        if (r55 != null) goto L89;
        int r56 = 0;
    L90:
        int r57 = (r54 + r56) * 31;
        CameraOutputContext r58 = this.D;
        if (r58 == null) goto L95;
        r2 = r58.hashCode();
    L95:
        return r57 + r2;
    L89:
        r56 = r55.hashCode();
        goto L90
    L81:
        r52 = 1237;
        goto L82
    L77:
        r50 = 1237;
        goto L78
    L73:
        r48 = 1237;
        goto L74
    L69:
        r46 = r45.hashCode();
        goto L70
    L65:
        r43 = 1237;
        goto L66
    L61:
        r41 = r40.hashCode();
        goto L62
    L57:
        r38 = r37.hashCode();
        goto L58
    L53:
        r35 = 1237;
        goto L54
    L49:
        r33 = 1237;
        goto L50
    L45:
        r31 = r30.hashCode();
        goto L46
    L41:
        r28 = 1237;
        goto L42
    L37:
        r26 = 1237;
        goto L38
    L33:
        r24 = 1237;
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
        r12 = r11.hashCode();
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
        return "CameraConfig(scene=" + this.a + ", mode=" + this.b + ", modeList=" + this.c + ", eventExt=" + this.d + ", extra=" + this.e + ", enableCaptureDetectModeList=" + this.f + ", cameraNameUrl=" + this.g + ", cameraName=" + this.h + ", tipsShowOrder=" + this.i + ", tips=" + this.j + ", supportMark=" + this.k + ", supportCrop=" + this.l + ", supportMultiImages=" + this.m + ", botId=" + this.n + ", enableFocusFrame=" + this.o + ", inputStyle=" + this.p + ", supportRecord=" + this.q + ", albumLandingTabIndex=" + this.r + ", addedAttachmentCount=" + this.s + ", supportAlbumMultiTake=" + this.t + ", albumMultiTakeMaxCount=" + this.u + ", suggestionPrefix=" + this.v + ", showBottomAlbum=" + this.w + ", albumSupportOriginalImage=" + this.x + ", enableOriginalImageDeferredEdit=" + this.y + ", enableCaptureAlbum=" + this.z + ", albumInputText=" + this.A + ", albumAttachmentUris=" + this.B + ", resultRoute=" + this.C + ", initialOutputContext=" + this.D + ')';
    }

    public a(String r34, String r35, List r36, HashMap r37, Map r38, List r39, String r40, String r41, Integer r42, List r43, boolean r44, boolean r45, boolean r46, String r47, boolean r48, int r49, boolean r50, Integer r51, Integer r52, boolean r53, int r54, String r55, boolean r56, boolean r57, boolean r58, String r59, List r60, CameraResultRoute r61, CameraOutputContext r62, int r63) {
        if ((r63 & 4) == 0) goto L5;
        List r4 = null;
    L7:
        if ((r63 & 8) == 0) goto L9;
        HashMap r6 = null;
    L11:
        if ((r63 & 16) == 0) goto L13;
        Map r7 = MapsKt.emptyMap();
    L15:
        if ((r63 & 32) == 0) goto L17;
        List r8 = null;
    L19:
        if ((r63 & 64) == 0) goto L21;
        String r9 = null;
    L23:
        if ((r63 & 128) == 0) goto L25;
        String r10 = null;
    L27:
        if ((r63 & 256) == 0) goto L29;
        Integer r11 = null;
    L31:
        if ((r63 & 512) == 0) goto L33;
        List r12 = null;
    L35:
        if ((r63 & 1024) == 0) goto L37;
        boolean r13 = false;
    L39:
        if ((r63 & 2048) == 0) goto L41;
        boolean r15 = false;
    L43:
        if ((r63 & 4096) == 0) goto L45;
        boolean r5 = false;
    L47:
        if ((r63 & 8192) == 0) goto L49;
        String r14 = null;
    L50:
        String r310 = r14;
        if ((r63 & 16384) == 0) goto L53;
        boolean r16 = false;
    L55:
        if ((r63 & 32768) == 0) goto L57;
        int r18 = 0;
    L59:
        if ((r63 & 65536) == 0) goto L61;
        boolean r19 = false;
    L63:
        if ((r63 & 131072) == 0) goto L65;
        int r17 = 0;
        Integer r21 = 0;
    L67:
        if ((r63 & 262144) == 0) goto L69;
        Integer r22 = Integer.valueOf(r17);
    L71:
        if ((r63 & 524288) == 0) goto L73;
        boolean r23 = false;
    L75:
        if ((r63 & 1048576) == 0) goto L77;
        int r24 = 0;
    L79:
        if ((r63 & 2097152) == 0) goto L81;
        String r25 = null;
    L83:
        if ((r63 & 4194304) == 0) goto L85;
        boolean r26 = false;
    L87:
        if ((r63 & 8388608) == 0) goto L89;
        boolean r27 = false;
    L91:
        if ((r63 & 16777216) == 0) goto L93;
        boolean r28 = false;
    L95:
        if ((r63 & 33554432) == 0) goto L97;
        boolean r29 = true;
    L99:
        if ((r63 & 67108864) == 0) goto L101;
        String r110 = "";
    L103:
        if ((r63 & 134217728) == 0) goto L105;
        List r20 = CollectionsKt.emptyList();
    L107:
        if ((r63 & 268435456) == 0) goto L109;
        CameraResultRoute r31 = null;
    L111:
        if ((r63 & 536870912) == 0) goto L113;
        CameraOutputContext r111 = null;
    L114:
        Intrinsics.checkNotNullParameter(r34, "scene");
        Intrinsics.checkNotNullParameter(r35, "mode");
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r110, "albumInputText");
        Intrinsics.checkNotNullParameter(r20, "albumAttachmentUris");
        this.a = r34;
        this.b = r35;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r15;
        this.m = r5;
        this.n = r310;
        this.o = r16;
        this.p = r18;
        this.q = r19;
        this.r = r21;
        this.s = r22;
        this.t = r23;
        this.u = r24;
        this.v = r25;
        this.w = r26;
        this.x = r27;
        this.y = r28;
        this.z = r29;
        this.A = r110;
        this.B = r20;
        this.C = r31;
        this.D = r111;
        return;
    L113:
        r111 = r62;
        goto L114
    L109:
        r31 = r61;
        goto L111
    L105:
        r20 = r60;
        goto L107
    L101:
        r110 = r59;
        goto L103
    L97:
        r29 = false;
        goto L99
    L93:
        r28 = r58;
        goto L95
    L89:
        r27 = r57;
        goto L91
    L85:
        r26 = r56;
        goto L87
    L81:
        r25 = r55;
        goto L83
    L77:
        r24 = r54;
        goto L79
    L73:
        r23 = r53;
        goto L75
    L69:
        r22 = r52;
        goto L71
    L65:
        r17 = 0;
        r21 = r51;
        goto L67
    L61:
        r19 = r50;
        goto L63
    L57:
        r18 = r49;
        goto L59
    L53:
        r16 = r48;
        goto L55
    L49:
        r14 = r47;
        goto L50
    L45:
        r5 = r46;
        goto L47
    L41:
        r15 = r45;
        goto L43
    L37:
        r13 = r44;
        goto L39
    L33:
        r12 = r43;
        goto L35
    L29:
        r11 = r42;
        goto L31
    L25:
        r10 = r41;
        goto L27
    L21:
        r9 = r40;
        goto L23
    L17:
        r8 = r39;
        goto L19
    L13:
        r7 = r38;
        goto L15
    L9:
        r6 = r37;
        goto L11
    L5:
        r4 = r36;
        goto L7
    }
}
