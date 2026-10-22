package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.k3;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.SeriesSendType;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e0 {
    public final String A;
    public final boolean B;
    public final String C;
    public final String D;
    public final Map<String, String> E;
    public final Map<String, String> F;
    public final Map<String, String> G;
    public final Function1<Integer, Unit> H;
    public final long a;
    public final int b;
    public final int c;
    public final String d;
    public final String e;
    public final SendGiftSource f;
    public final String g;
    public final IBaseUser h;
    public final String i;
    public final ArrayList<e3> j;
    public final boolean k;
    public final long l;
    public final int m;
    public final ReceiverType n;
    public final Long o;
    public final String p;
    public final boolean q;
    public final List<IBaseUser> r;
    public final List<k3> s;
    public final SeriesSendType t;
    public final String u;
    public final String v;
    public final boolean w;
    public final boolean x;
    public final com.bytedance.android.livesdk.gift.platform.core.model.k y;
    public final com.bytedance.android.livesdk.gift.platform.core.model.k z;

    public e0() {
        throw null;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e0) == false) goto L74;
        e0 r7 = (e0) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L26;
        return false;
    L26:
        if (this.k == r7.k) goto L28;
        return false;
    L28:
        if (this.l == r7.l) goto L30;
        return false;
    L30:
        if (this.m == r7.m) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r7.n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r7.o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r7.p) == true) goto L38;
        return false;
    L38:
        if (this.q == r7.q) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.r, r7.r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.s, r7.s) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.t, r7.t) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.u, r7.u) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.v, r7.v) == true) goto L50;
        return false;
    L50:
        if (this.w == r7.w) goto L52;
        return false;
    L52:
        if (this.x == r7.x) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.y, r7.y) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.z, r7.z) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.A, r7.A) == true) goto L60;
        return false;
    L60:
        if (this.B == r7.B) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.C, r7.C) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.D, r7.D) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.E, r7.E) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.F, r7.F) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.G, r7.G) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.H, r7.H) == true) goto L112;
        return false;
    L112:
        return true;
    L74:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v100 */
    /* JADX WARN: Type inference failed for: r0v104 */
    /* JADX WARN: Type inference failed for: r0v112 */
    /* JADX WARN: Type inference failed for: r0v113 */
    /* JADX WARN: Type inference failed for: r0v114 */
    /* JADX WARN: Type inference failed for: r0v115 */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v39, types: [int] */
    /* JADX WARN: Type inference failed for: r0v56, types: [int] */
    /* JADX WARN: Type inference failed for: r0v58, types: [int] */
    /* JADX WARN: Type inference failed for: r0v93 */
    /* JADX WARN: Type inference failed for: r0v94 */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c) * 31;
        String r2 = this.d;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.e;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        SendGiftSource r9 = this.f;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (r8 + r10) * 31;
        String r13 = this.g;
        if (r13 == null) goto L17;
        int r14 = r13.hashCode();
    L18:
        int r15 = (r11 + r14) * 31;
        IBaseUser r16 = this.h;
        if (r16 == null) goto L21;
        int r17 = r16.hashCode();
    L22:
        int r18 = (r15 + r17) * 31;
        String r19 = this.i;
        if (r19 == null) goto L25;
        int r20 = r19.hashCode();
    L26:
        int r21 = (r18 + r20) * 31;
        ArrayList<e3> r23 = this.j;
        if (r23 == null) goto L29;
        int r24 = r23.hashCode();
    L30:
        int r25 = (r21 + r24) * 31;
        boolean r26 = this.k;
        ?? r27 = 1;
        ?? r28 = r26;
        if (r26 == false) goto L33;
        r28 = 1;
    L33:
        long r29 = this.l;
        int r30 = (((((r25 + r28) * 31) + ((int) (r29 ^ (r29 >>> 32)))) * 31) + this.m) * 31;
        ReceiverType r31 = this.n;
        if (r31 == null) goto L36;
        int r33 = r31.hashCode();
    L37:
        int r34 = (r30 + r33) * 31;
        Long r35 = this.o;
        if (r35 == null) goto L40;
        int r36 = r35.hashCode();
    L41:
        int r37 = (r34 + r36) * 31;
        String r38 = this.p;
        if (r38 == null) goto L44;
        int r39 = r38.hashCode();
    L45:
        int r40 = (r37 + r39) * 31;
        boolean r41 = this.q;
        ?? r43 = r41;
        if (r41 == false) goto L48;
        r43 = 1;
    L48:
        int r44 = (r40 + r43) * 31;
        List<IBaseUser> r45 = this.r;
        if (r45 == null) goto L51;
        int r46 = r45.hashCode();
    L52:
        int r47 = (r44 + r46) * 31;
        List<k3> r48 = this.s;
        if (r48 == null) goto L55;
        int r49 = r48.hashCode();
    L56:
        int r50 = (r47 + r49) * 31;
        SeriesSendType r51 = this.t;
        if (r51 == null) goto L59;
        int r53 = r51.hashCode();
    L60:
        int r54 = (r50 + r53) * 31;
        String r55 = this.u;
        if (r55 == null) goto L63;
        int r56 = r55.hashCode();
    L64:
        int r57 = (r54 + r56) * 31;
        String r58 = this.v;
        if (r58 == null) goto L67;
        int r59 = r58.hashCode();
    L68:
        int r60 = (r57 + r59) * 31;
        boolean r61 = this.w;
        ?? r63 = r61;
        if (r61 == false) goto L71;
        r63 = 1;
    L71:
        int r64 = (r60 + r63) * 31;
        boolean r65 = this.x;
        ?? r66 = r65;
        if (r65 == false) goto L74;
        r66 = 1;
    L74:
        int r67 = (r64 + r66) * 31;
        com.bytedance.android.livesdk.gift.platform.core.model.k r68 = this.y;
        if (r68 == null) goto L77;
        int r69 = r68.hashCode();
    L78:
        int r70 = (r67 + r69) * 31;
        com.bytedance.android.livesdk.gift.platform.core.model.k r71 = this.z;
        if (r71 == null) goto L81;
        int r73 = r71.hashCode();
    L82:
        int r74 = (r70 + r73) * 31;
        String r75 = this.A;
        if (r75 == null) goto L85;
        int r76 = r75.hashCode();
    L86:
        int r77 = (r74 + r76) * 31;
        boolean r78 = this.B;
        if (r78 == true) goto L90;
        r27 = r78;
    L90:
        int r79 = (r77 + r27) * 31;
        String r80 = this.C;
        if (r80 == null) goto L93;
        int r81 = r80.hashCode();
    L94:
        int r83 = (r79 + r81) * 31;
        String r84 = this.D;
        if (r84 == null) goto L97;
        int r85 = r84.hashCode();
    L98:
        int r86 = (r83 + r85) * 31;
        Map<String, String> r87 = this.E;
        if (r87 == null) goto L101;
        int r88 = r87.hashCode();
    L102:
        int r89 = (r86 + r88) * 31;
        Map<String, String> r90 = this.F;
        if (r90 == null) goto L105;
        int r91 = r90.hashCode();
    L106:
        int r93 = (r89 + r91) * 31;
        Map<String, String> r94 = this.G;
        if (r94 == null) goto L109;
        int r95 = r94.hashCode();
    L110:
        int r96 = (r93 + r95) * 31;
        Function1<Integer, Unit> r97 = this.H;
        if (r97 == null) goto L114;
        r3 = r97.hashCode();
    L114:
        return r96 + r3;
    L109:
        r95 = 0;
        goto L110
    L105:
        r91 = 0;
        goto L106
    L101:
        r88 = 0;
        goto L102
    L97:
        r85 = 0;
        goto L98
    L93:
        r81 = 0;
        goto L94
    L85:
        r76 = 0;
        goto L86
    L81:
        r73 = 0;
        goto L82
    L77:
        r69 = 0;
        goto L78
    L67:
        r59 = 0;
        goto L68
    L63:
        r56 = 0;
        goto L64
    L59:
        r53 = 0;
        goto L60
    L55:
        r49 = 0;
        goto L56
    L51:
        r46 = 0;
        goto L52
    L44:
        r39 = 0;
        goto L45
    L40:
        r36 = 0;
        goto L41
    L36:
        r33 = 0;
        goto L37
    L29:
        r24 = 0;
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
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenBigGiftInfo(giftId=" + this.a + ", buffLevel=" + this.b + ", count=" + this.c + ", giftType=" + this.d + ", extra=" + this.e + ", source=" + this.f + ", vsSource=" + this.g + ", user=" + this.h + ", giftSourceLog=" + this.i + ", pluginInfo=" + this.j + ", isCustomizeGift=" + this.k + ", configId=" + this.l + ", sendScene=" + this.m + ", receiverType=" + this.n + ", roomId=" + this.o + ", anchorId=" + this.p + ", sendGiftToMultiUsers=" + this.q + ", toUsers=" + this.r + ", seriesGiftsInfo=" + this.s + ", seriesSendType=" + this.t + ", seriesName=" + this.u + ", afterSendSchema=" + this.v + ", panelLocateRemember=" + this.w + ", disableDisableGiftCombo=" + this.x + ", defaultGiftInfo=" + this.y + ", curSendGiftInfo=" + this.z + ", giftSortExtra=" + this.A + ", isSearchResult=" + this.B + ", searchWord=" + this.C + ", searchId=" + this.D + ", toRechargeParams=" + this.E + ", jsbLogExtra=" + this.F + ", tagsExtra=" + this.G + ", callback=" + this.H + ")";
    }

    public e0(long r35, int r37, int r38, String r39, String r40, SendGiftSource r41, String r43, IBaseUser r44, String r45, ArrayList r46, boolean r47, long r48, int r49, ReceiverType r50, Long r51, boolean r53, List r54, List r55, SeriesSendType r56, String r57, String r58, boolean r59, boolean r510, com.bytedance.android.livesdk.gift.platform.core.model.k r60, com.bytedance.android.livesdk.gift.platform.core.model.k r61, String r63, boolean r64, String r65, String r66, Map r67, Map r68, Map r69, Function1 r610, int r70, int r71) {
        if ((r70 & 8) == 0) goto L5;
        String r4 = BuildConfig.FLAVOR;
    L7:
        if ((r70 & 16) == 0) goto L9;
        String r6 = BuildConfig.FLAVOR;
    L11:
        if ((r70 & 32) == 0) goto L13;
        SendGiftSource r7 = SendGiftSource.GiftDialog;
    L15:
        if ((r70 & 128) == 0) goto L17;
        IBaseUser r8 = null;
    L19:
        if ((r70 & 256) == 0) goto L21;
        String r10 = BuildConfig.FLAVOR;
    L23:
        if ((r70 & 512) == 0) goto L25;
        ArrayList r11 = null;
    L27:
        if ((r70 & 1024) == 0) goto L29;
        boolean r13 = false;
    L31:
        if ((r70 & 2048) == 0) goto L33;
        long r14 = 0;
    L35:
        if ((r70 & 4096) == 0) goto L37;
        int r15 = 0;
    L39:
        if ((r70 & 8192) == 0) goto L41;
        ReceiverType r9 = null;
    L43:
        if ((r70 & 16384) == 0) goto L45;
        Long r5 = null;
    L47:
        if ((r70 & 65536) == 0) goto L49;
        boolean r18 = false;
    L51:
        if ((r70 & 131072) == 0) goto L53;
        List r19 = null;
    L55:
        if ((r70 & 262144) == 0) goto L57;
        List r20 = null;
    L59:
        if ((r70 & 524288) == 0) goto L61;
        SeriesSendType r16 = SeriesSendType.NONE;
    L63:
        if ((r70 & 1048576) == 0) goto L65;
        String r23 = null;
    L67:
        if ((r70 & 2097152) == 0) goto L69;
        String r24 = null;
    L71:
        if ((r70 & 4194304) == 0) goto L73;
        boolean r25 = false;
    L75:
        if ((r70 & 8388608) == 0) goto L77;
        boolean r26 = false;
    L79:
        if ((r70 & 16777216) == 0) goto L81;
        com.bytedance.android.livesdk.gift.platform.core.model.k r27 = null;
    L83:
        if ((r70 & 33554432) == 0) goto L85;
        com.bytedance.android.livesdk.gift.platform.core.model.k r28 = null;
    L87:
        if ((r70 & 67108864) == 0) goto L89;
        String r29 = null;
    L91:
        if ((r70 & 134217728) == 0) goto L93;
        boolean r210 = false;
    L95:
        if ((r70 & 268435456) == 0) goto L97;
        String r17 = BuildConfig.FLAVOR;
    L99:
        if ((r70 & 536870912) == 0) goto L101;
        String r110 = BuildConfig.FLAVOR;
    L103:
        if ((r70 & 1073741824) == 0) goto L105;
        Map r31 = null;
    L107:
        if ((r70 & Integer.MIN_VALUE) == 0) goto L109;
        Map r3 = null;
    L111:
        if ((r71 & 1) == 0) goto L113;
        Map r33 = null;
    L114:
        Intrinsics.checkNotNullParameter(r4, "giftType");
        Intrinsics.checkNotNullParameter(r6, "extra");
        Intrinsics.checkNotNullParameter(r7, "source");
        Intrinsics.checkNotNullParameter(r43, "vsSource");
        Intrinsics.checkNotNullParameter(r10, "giftSourceLog");
        Intrinsics.checkNotNullParameter(r16, "seriesSendType");
        Intrinsics.checkNotNullParameter(r17, "searchWord");
        Intrinsics.checkNotNullParameter(r110, "searchId");
        Intrinsics.checkNotNullParameter(r610, "callback");
        this.a = r35;
        this.b = r37;
        this.c = r38;
        this.d = r4;
        this.e = r6;
        this.f = r7;
        this.g = r43;
        this.h = r8;
        this.i = r10;
        this.j = r11;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r9;
        this.o = r5;
        this.p = null;
        this.q = r18;
        this.r = r19;
        this.s = r20;
        this.t = r16;
        this.u = r23;
        this.v = r24;
        this.w = r25;
        this.x = r26;
        this.y = r27;
        this.z = r28;
        this.A = r29;
        this.B = r210;
        this.C = r17;
        this.D = r110;
        this.E = r31;
        this.F = r3;
        this.G = r33;
        this.H = r610;
        return;
    L113:
        r33 = r69;
        goto L114
    L109:
        r3 = r68;
        goto L111
    L105:
        r31 = r67;
        goto L107
    L101:
        r110 = r66;
        goto L103
    L97:
        r17 = r65;
        goto L99
    L93:
        r210 = r64;
        goto L95
    L89:
        r29 = r63;
        goto L91
    L85:
        r28 = r61;
        goto L87
    L81:
        r27 = r60;
        goto L83
    L77:
        r26 = r510;
        goto L79
    L73:
        r25 = r59;
        goto L75
    L69:
        r24 = r58;
        goto L71
    L65:
        r23 = r57;
        goto L67
    L61:
        r16 = r56;
        goto L63
    L57:
        r20 = r55;
        goto L59
    L53:
        r19 = r54;
        goto L55
    L49:
        r18 = r53;
        goto L51
    L45:
        r5 = r51;
        goto L47
    L41:
        r9 = r50;
        goto L43
    L37:
        r15 = r49;
        goto L39
    L33:
        r14 = r48;
        goto L35
    L29:
        r13 = r47;
        goto L31
    L25:
        r11 = r46;
        goto L27
    L21:
        r10 = r45;
        goto L23
    L17:
        r8 = r44;
        goto L19
    L13:
        r7 = r41;
        goto L15
    L9:
        r6 = r40;
        goto L11
    L5:
        r4 = r39;
        goto L7
    }
}
