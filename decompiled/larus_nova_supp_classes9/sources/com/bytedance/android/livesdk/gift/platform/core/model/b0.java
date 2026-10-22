package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.k3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0 implements v {
    public final SeriesSendType A;
    public final String B;
    public final n C;
    public final Long D;
    public final String E;
    public final Map<String, String> F;
    public final Map<String, String> G;
    public final IRoom H;
    public final long I;
    public final int J;
    public final long K;
    public final Map<String, Object> L;
    public String M;
    public final String N;
    public final boolean O;
    public final k P;
    public final k Q;
    public final String R;
    public final String S;
    public final String T;
    public final String U;
    public final boolean V;
    public final String W;
    public final String X;
    public final Map<String, String> Y;
    public final com.bytedance.android.livesdk.gift.platform.core.model.a Z;
    public String a;
    public final int a0;
    public final long b;
    public final Map<String, String> b0;
    public final SendGiftSource c;
    public final Map<String, String> c0;
    public final IBaseUser d;
    public final Long d0;
    public final Long e;
    public final int f;
    public final int g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public int l;
    public final String m;
    public ArrayList<e3> n;
    public final boolean o;
    public final SendGiftStrategy p;
    public final int q;
    public final boolean r;
    public final String s;
    public final long t;
    public final ReceiverType u;
    public final boolean v;
    public final List<IBaseUser> w;
    public final boolean x;
    public final int y;
    public final List<k3> z;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b0) == false) goto L116;
        b0 r7 = (b0) r6;
        if (this.b == r7.b) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L14;
        return false;
    L14:
        if (this.f == r7.f) goto L16;
        return false;
    L16:
        if (this.g == r7.g) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L26;
        return false;
    L26:
        if (this.l == r7.l) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.m, r7.m) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.n, r7.n) == true) goto L32;
        return false;
    L32:
        if (this.o == r7.o) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.p, r7.p) == true) goto L36;
        return false;
    L36:
        if (this.q == r7.q) goto L38;
        return false;
    L38:
        if (this.r == r7.r) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.s, r7.s) == true) goto L42;
        return false;
    L42:
        if (this.t == r7.t) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.u, r7.u) == true) goto L46;
        return false;
    L46:
        if (this.v == r7.v) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.w, r7.w) == true) goto L50;
        return false;
    L50:
        if (this.x == r7.x) goto L52;
        return false;
    L52:
        if (this.y == r7.y) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.z, r7.z) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.A, r7.A) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.B, r7.B) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.C, r7.C) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.D, r7.D) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.E, r7.E) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.F, r7.F) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.G, r7.G) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.H, r7.H) == true) goto L72;
        return false;
    L72:
        if (this.I == r7.I) goto L74;
        return false;
    L74:
        if (this.J == r7.J) goto L76;
        return false;
    L76:
        if (this.K == r7.K) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.L, r7.L) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.M, r7.M) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.N, r7.N) == true) goto L84;
        return false;
    L84:
        if (this.O == r7.O) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.P, r7.P) == true) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.Q, r7.Q) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.R, r7.R) == true) goto L92;
        return false;
    L92:
        if (Intrinsics.areEqual(this.S, r7.S) == true) goto L94;
        return false;
    L94:
        if (Intrinsics.areEqual(this.T, r7.T) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.U, r7.U) == true) goto L98;
        return false;
    L98:
        if (this.V == r7.V) goto L100;
        return false;
    L100:
        if (Intrinsics.areEqual(this.W, r7.W) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.X, r7.X) == true) goto L104;
        return false;
    L104:
        if (Intrinsics.areEqual(this.Y, r7.Y) == true) goto L106;
        return false;
    L106:
        if (Intrinsics.areEqual(this.Z, r7.Z) == true) goto L108;
        return false;
    L108:
        if (this.a0 == r7.a0) goto L110;
        return false;
    L110:
        if (Intrinsics.areEqual(this.b0, r7.b0) == true) goto L112;
        return false;
    L112:
        if (Intrinsics.areEqual(this.c0, r7.c0) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.d0, r7.d0) == true) goto L175;
        return false;
    L175:
        return true;
    L116:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v147 */
    /* JADX WARN: Type inference failed for: r0v160 */
    /* JADX WARN: Type inference failed for: r0v162 */
    /* JADX WARN: Type inference failed for: r0v165 */
    /* JADX WARN: Type inference failed for: r0v167 */
    /* JADX WARN: Type inference failed for: r0v177 */
    /* JADX WARN: Type inference failed for: r0v178 */
    /* JADX WARN: Type inference failed for: r0v179 */
    /* JADX WARN: Type inference failed for: r0v180 */
    /* JADX WARN: Type inference failed for: r0v181 */
    /* JADX WARN: Type inference failed for: r0v33, types: [int] */
    /* JADX WARN: Type inference failed for: r0v39, types: [int] */
    /* JADX WARN: Type inference failed for: r0v48, types: [int] */
    /* JADX WARN: Type inference failed for: r0v53, types: [int] */
    /* JADX WARN: Type inference failed for: r0v95, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    public final int hashCode() {
        long r0 = this.b;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        SendGiftSource r2 = this.c;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        IBaseUser r6 = this.d;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        Long r9 = this.e;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (((((r8 + r10) * 31) + this.f) * 31) + this.g) * 31;
        String r13 = this.h;
        if (r13 == null) goto L17;
        int r14 = r13.hashCode();
    L18:
        int r15 = (r11 + r14) * 31;
        String r16 = this.i;
        if (r16 == null) goto L21;
        int r17 = r16.hashCode();
    L22:
        int r18 = (r15 + r17) * 31;
        String r19 = this.j;
        if (r19 == null) goto L25;
        int r20 = r19.hashCode();
    L26:
        int r21 = (r18 + r20) * 31;
        String r23 = this.k;
        if (r23 == null) goto L29;
        int r24 = r23.hashCode();
    L30:
        int r25 = (((r21 + r24) * 31) + this.l) * 31;
        String r26 = this.m;
        if (r26 == null) goto L33;
        int r27 = r26.hashCode();
    L34:
        int r28 = (r25 + r27) * 31;
        ArrayList<e3> r29 = this.n;
        if (r29 == null) goto L37;
        int r30 = r29.hashCode();
    L38:
        int r31 = (r28 + r30) * 31;
        boolean r33 = this.o;
        ?? r34 = 1;
        ?? r35 = r33;
        if (r33 == false) goto L41;
        r35 = 1;
    L41:
        int r36 = (r31 + r35) * 31;
        SendGiftStrategy r37 = this.p;
        if (r37 == null) goto L44;
        int r38 = r37.hashCode();
    L45:
        int r39 = (((r36 + r38) * 31) + this.q) * 31;
        boolean r40 = this.r;
        ?? r41 = r40;
        if (r40 == false) goto L48;
        r41 = 1;
    L48:
        int r43 = (r39 + r41) * 31;
        String r44 = this.s;
        if (r44 == null) goto L51;
        int r45 = r44.hashCode();
    L52:
        long r46 = this.t;
        int r47 = (((r43 + r45) * 31) + ((int) (r46 ^ (r46 >>> 32)))) * 31;
        ReceiverType r48 = this.u;
        if (r48 == null) goto L55;
        int r49 = r48.hashCode();
    L56:
        int r50 = (r47 + r49) * 31;
        boolean r51 = this.v;
        ?? r53 = r51;
        if (r51 == false) goto L59;
        r53 = 1;
    L59:
        int r54 = (r50 + r53) * 31;
        List<IBaseUser> r55 = this.w;
        if (r55 == null) goto L62;
        int r56 = r55.hashCode();
    L63:
        int r57 = (r54 + r56) * 31;
        boolean r58 = this.x;
        ?? r59 = r58;
        if (r58 == false) goto L66;
        r59 = 1;
    L66:
        int r60 = (((r57 + r59) * 31) + this.y) * 31;
        List<k3> r61 = this.z;
        if (r61 == null) goto L69;
        int r63 = r61.hashCode();
    L70:
        int r64 = (r60 + r63) * 31;
        SeriesSendType r65 = this.A;
        if (r65 == null) goto L73;
        int r66 = r65.hashCode();
    L74:
        int r67 = (r64 + r66) * 31;
        String r68 = this.B;
        if (r68 == null) goto L77;
        int r69 = r68.hashCode();
    L78:
        int r70 = (r67 + r69) * 31;
        n r71 = this.C;
        if (r71 == null) goto L81;
        int r73 = r71.hashCode();
    L82:
        int r74 = (r70 + r73) * 31;
        Long r75 = this.D;
        if (r75 == null) goto L85;
        int r76 = r75.hashCode();
    L86:
        int r77 = (r74 + r76) * 31;
        String r78 = this.E;
        if (r78 == null) goto L89;
        int r79 = r78.hashCode();
    L90:
        int r80 = (r77 + r79) * 31;
        Map<String, String> r81 = this.F;
        if (r81 == null) goto L93;
        int r83 = r81.hashCode();
    L94:
        int r84 = (r80 + r83) * 31;
        Map<String, String> r85 = this.G;
        if (r85 == null) goto L97;
        int r86 = r85.hashCode();
    L98:
        int r87 = (r84 + r86) * 31;
        IRoom r88 = this.H;
        if (r88 == null) goto L101;
        int r89 = r88.hashCode();
    L102:
        long r90 = this.I;
        int r91 = (((((r87 + r89) * 31) + ((int) (r90 ^ (r90 >>> 32)))) * 31) + this.J) * 31;
        long r93 = this.K;
        int r94 = (r91 + ((int) (r93 ^ (r93 >>> 32)))) * 31;
        Map<String, Object> r95 = this.L;
        if (r95 == null) goto L105;
        int r96 = r95.hashCode();
    L106:
        int r97 = (r94 + r96) * 31;
        String r98 = this.M;
        if (r98 == null) goto L109;
        int r99 = r98.hashCode();
    L110:
        int r100 = (r97 + r99) * 31;
        String r101 = this.N;
        if (r101 == null) goto L113;
        int r102 = r101.hashCode();
    L114:
        int r103 = (r100 + r102) * 31;
        boolean r104 = this.O;
        ?? r105 = r104;
        if (r104 == false) goto L117;
        r105 = 1;
    L117:
        int r106 = (r103 + r105) * 31;
        k r107 = this.P;
        if (r107 == null) goto L120;
        int r108 = r107.hashCode();
    L121:
        int r109 = (r106 + r108) * 31;
        k r110 = this.Q;
        if (r110 == null) goto L124;
        int r111 = r110.hashCode();
    L125:
        int r112 = (r109 + r111) * 31;
        String r113 = this.R;
        if (r113 == null) goto L128;
        int r114 = r113.hashCode();
    L129:
        int r115 = (r112 + r114) * 31;
        String r116 = this.S;
        if (r116 == null) goto L132;
        int r117 = r116.hashCode();
    L133:
        int r118 = (r115 + r117) * 31;
        String r119 = this.T;
        if (r119 == null) goto L136;
        int r120 = r119.hashCode();
    L137:
        int r121 = (r118 + r120) * 31;
        String r122 = this.U;
        if (r122 == null) goto L140;
        int r123 = r122.hashCode();
    L141:
        int r124 = (r121 + r123) * 31;
        boolean r125 = this.V;
        if (r125 == true) goto L145;
        r34 = r125;
    L145:
        int r126 = (r124 + r34) * 31;
        String r127 = this.W;
        if (r127 == null) goto L148;
        int r128 = r127.hashCode();
    L149:
        int r129 = (r126 + r128) * 31;
        String r130 = this.X;
        if (r130 == null) goto L152;
        int r131 = r130.hashCode();
    L153:
        int r132 = (r129 + r131) * 31;
        Map<String, String> r133 = this.Y;
        if (r133 == null) goto L156;
        int r134 = r133.hashCode();
    L157:
        int r135 = (r132 + r134) * 31;
        com.bytedance.android.livesdk.gift.platform.core.model.a r136 = this.Z;
        if (r136 == null) goto L160;
        int r137 = r136.hashCode();
    L161:
        int r138 = (((r135 + r137) * 31) + this.a0) * 31;
        Map<String, String> r139 = this.b0;
        if (r139 == null) goto L164;
        int r140 = r139.hashCode();
    L165:
        int r141 = (r138 + r140) * 31;
        Map<String, String> r142 = this.c0;
        if (r142 == null) goto L168;
        int r143 = r142.hashCode();
    L169:
        int r144 = (r141 + r143) * 31;
        Long r145 = this.d0;
        if (r145 == null) goto L173;
        r3 = r145.hashCode();
    L173:
        return r144 + r3;
    L168:
        r143 = 0;
        goto L169
    L164:
        r140 = 0;
        goto L165
    L160:
        r137 = 0;
        goto L161
    L156:
        r134 = 0;
        goto L157
    L152:
        r131 = 0;
        goto L153
    L148:
        r128 = 0;
        goto L149
    L140:
        r123 = 0;
        goto L141
    L136:
        r120 = 0;
        goto L137
    L132:
        r117 = 0;
        goto L133
    L128:
        r114 = 0;
        goto L129
    L124:
        r111 = 0;
        goto L125
    L120:
        r108 = 0;
        goto L121
    L113:
        r102 = 0;
        goto L114
    L109:
        r99 = 0;
        goto L110
    L105:
        r96 = 0;
        goto L106
    L101:
        r89 = 0;
        goto L102
    L97:
        r86 = 0;
        goto L98
    L93:
        r83 = 0;
        goto L94
    L89:
        r79 = 0;
        goto L90
    L85:
        r76 = 0;
        goto L86
    L81:
        r73 = 0;
        goto L82
    L77:
        r69 = 0;
        goto L78
    L73:
        r66 = 0;
        goto L74
    L69:
        r63 = 0;
        goto L70
    L62:
        r56 = 0;
        goto L63
    L55:
        r49 = 0;
        goto L56
    L51:
        r45 = 0;
        goto L52
    L44:
        r38 = 0;
        goto L45
    L37:
        r30 = 0;
        goto L38
    L33:
        r27 = 0;
        goto L34
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
        return "SendGiftParamsNew(id=" + this.b + ", sendGiftFrom=" + this.c + ", _toUser=" + this.d + ", _toRoomId=" + this.e + ", sendType=" + this.f + ", giftSource=" + this.g + ", giftSourceLog=" + this.h + ", requestSourceLog=" + this.i + ", triggerWord=" + this.j + ", extra=" + this.k + ", buffLevel=" + this.l + ", source=" + this.m + ", pluginInfo=" + this.n + ", isCustomizeGift=" + this.o + ", sendGiftStrategy=" + this.p + ", groupCount=" + this.q + ", isProp=" + this.r + ", refId=" + this.s + ", isAwemeFreeGift=" + this.t + ", receiverType=" + this.u + ", sendToAllMic=" + this.v + ", toUsers=" + this.w + ", sendGiftToMultiUsers=" + this.x + ", sendFromPageType=" + this.y + ", seriesGiftList=" + this.z + ", seriesSendType=" + this.A + ", seriesName=" + this.B + ", showInfo=" + this.C + ", _roomId=" + this.D + ", _anchorIdString=" + this.E + ", receiverLogExtra=" + this.F + ", fastGiftRecommendParams=" + this.G + ", room=" + this.H + ", toEpisodeId=" + this.I + ", scene=" + this.J + ", configId=" + this.K + ", extraForTrack=" + this.L + ", cardName=" + this.M + ", afterSendSchema=" + this.N + ", panelLocateRemember=" + this.O + ", defaultLocationInfo=" + this.P + ", curSendLocationInfo=" + this.Q + ", selectedTopicName=" + this.R + ", showStrategy=" + this.S + ", giftSortExtra=" + this.T + ", giftPanelSesstionId=" + this.U + ", isSearchResult=" + this.V + ", searchWord=" + this.W + ", searchId=" + this.X + ", toRechargeParams=" + this.Y + ", aiRecommedInfoModel=" + this.Z + ", groupCountLog=" + this.a0 + ", jsbLogExtra=" + this.b0 + ", tagsExtra=" + this.c0 + ", _videoLinkMicRoomId=" + this.d0 + ")";
    }

    public final String c() {
        String r0 = this.E;
        if (r0 != null) goto L8;
        IRoom r1 = this.H;
        if (r1 == null) goto L7;
        r0 = r1.getAnchorId();
        goto L8
    L7:
        r0 = null;
    L8:
        if (r0 != null) goto L11;
        return BuildConfig.FLAVOR;
    L11:
        return r0;
    }

    public final long d() {
        Long r0 = this.D;
        if (r0 != null) goto L8;
        IRoom r1 = this.H;
        if (r1 == null) goto L7;
        r0 = Long.valueOf(r1.getRoomId());
        goto L8
    L7:
        r0 = null;
    L8:
        if (r0 != null) goto L12;
        return 0;
    L12:
        return r0.longValue();
    }

    public final long e() {
        Long r0 = this.e;
        if (r0 == null) goto L6;
        return r0.longValue();
    L6:
        return d();
    }

    public final IBaseUser f() {
        IBaseUser r0 = this.d;
        if (r0 != null) goto L8;
        IRoom r1 = this.H;
        if (r1 == null) goto L7;
        r0 = r1.getOwner();
        goto L8
    L7:
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        return r0;
    L10:
        return vh7.f.c(IBaseUser.class);
    }

    public final String g() {
        IBaseUser r0 = this.d;
        if (r0 == null) goto L6;
        String r1 = r0.getIdString();
        if (r1 == null) goto L6;
    L10:
        if (r1 != null) goto L13;
        return BuildConfig.FLAVOR;
    L13:
        return r1;
    L6:
        IRoom r2 = this.H;
        if (r2 == null) goto L9;
        r1 = r2.getAnchorId();
        goto L10
    L9:
        r1 = null;
        goto L10
    }

    public static void a(Map r2, String r3, Object r4) {
        if (r4 != null) goto L5;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        Object r1 = r4;
    L14:
        if (r1 == null) goto L17;
        String r5 = (String) r2.put(r3, String.valueOf(r4));
        return;
    L17:
        return;
    L13:
        r1 = null;
        goto L14
    L5:
        if (Intrinsics.areEqual(r4.toString(), "0") == true) goto L10;
        if (StringsKt.isBlank(r4.toString()) == true) goto L10;
        r0 = false;
        goto L11
    }

    public static b0 b(b0 r66, long r67, Long r69, int r70, String r71, SendGiftStrategy r73, ReceiverType r74, Long r75, String r76, IRoom r77, long r78, int r79, Map r80, Long r81, int r83, int r84) {
        if ((r83 & 1) == 0) goto L5;
        long r6 = r66.b;
    L7:
        if ((r83 & 2) == 0) goto L9;
        SendGiftSource r8 = r66.c;
    L11:
        if ((r83 & 4) == 0) goto L13;
        IBaseUser r9 = r66.d;
    L15:
        if ((r83 & 8) == 0) goto L17;
        Long r10 = r66.e;
    L19:
        if ((r83 & 16) == 0) goto L21;
        int r11 = r66.f;
    L23:
        if ((r83 & 32) == 0) goto L25;
        int r13 = r66.g;
    L27:
        if ((r83 & 64) == 0) goto L29;
        String r14 = r66.h;
    L31:
        if ((r83 & 128) == 0) goto L33;
        String r15 = r66.i;
    L35:
        if ((r83 & 256) == 0) goto L37;
        String r16 = r66.j;
    L39:
        if ((r83 & 512) == 0) goto L41;
        String r3 = r66.k;
    L43:
        if ((r83 & 1024) == 0) goto L45;
        int r17 = r66.l;
    L47:
        if ((r83 & 2048) == 0) goto L49;
        String r4 = r66.m;
    L51:
        if ((r83 & 4096) == 0) goto L53;
        ArrayList<e3> r19 = r66.n;
    L55:
        if ((r83 & 8192) == 0) goto L57;
        boolean r20 = r66.o;
    L59:
        if ((r83 & 16384) == 0) goto L61;
        SendGiftStrategy r5 = r66.p;
    L62:
        int r610 = r13;
        if ((r83 & 32768) == 0) goto L65;
        int r23 = r66.q;
    L67:
        if ((r83 & 65536) == 0) goto L69;
        boolean r24 = r66.r;
    L71:
        if ((r83 & 131072) == 0) goto L73;
        String r18 = r66.s;
    L75:
        if ((r83 & 262144) == 0) goto L77;
        long r27 = r66.t;
    L79:
        if ((r83 & 524288) == 0) goto L81;
        ReceiverType r29 = r66.u;
    L83:
        if ((r83 & 1048576) == 0) goto L85;
        boolean r30 = r66.v;
    L87:
        if ((r83 & 2097152) == 0) goto L89;
        List<IBaseUser> r31 = r66.w;
    L91:
        if ((r83 & 4194304) == 0) goto L93;
        boolean r33 = r66.x;
    L95:
        if ((8388608 & r83) == 0) goto L97;
        int r34 = r66.y;
    L99:
        if ((16777216 & r83) == 0) goto L101;
        List<k3> r35 = r66.z;
    L103:
        if ((33554432 & r83) == 0) goto L105;
        SeriesSendType r110 = r66.A;
    L107:
        if ((r83 & 67108864) == 0) goto L109;
        String r37 = r66.B;
    L111:
        if ((134217728 & r83) == 0) goto L113;
        n r38 = r66.C;
    L115:
        if ((268435456 & r83) == 0) goto L117;
        Long r39 = r66.D;
    L119:
        if ((536870912 & r83) == 0) goto L121;
        String r40 = r66.E;
    L123:
        if ((1073741824 & r83) == 0) goto L125;
        Map<String, String> r41 = r66.F;
    L127:
        if ((r83 & Integer.MIN_VALUE) == 0) goto L129;
        Map<String, String> r1 = r66.G;
    L131:
        if ((r84 & 1) == 0) goto L133;
        IRoom r43 = r66.H;
    L134:
        IBaseUser r44 = r9;
        if ((r84 & 2) == 0) goto L137;
        long r45 = r66.I;
    L139:
        if ((r84 & 4) == 0) goto L141;
        int r46 = r66.J;
    L143:
        if ((r84 & 8) == 0) goto L145;
        long r47 = r66.K;
    L147:
        if ((r84 & 16) == 0) goto L149;
        Map r49 = r66.L;
    L151:
        if ((r84 & 32) == 0) goto L153;
        String r50 = r66.M;
    L155:
        if ((r84 & 64) == 0) goto L157;
        String r51 = r66.N;
    L159:
        if ((r84 & 128) == 0) goto L161;
        boolean r53 = r66.O;
    L163:
        if ((r84 & 256) == 0) goto L165;
        k r54 = r66.P;
    L167:
        if ((r84 & 512) == 0) goto L169;
        k r55 = r66.Q;
    L171:
        if ((r84 & 1024) == 0) goto L173;
        String r56 = r66.R;
    L175:
        if ((r84 & 2048) == 0) goto L177;
        String r57 = r66.S;
    L179:
        if ((r84 & 4096) == 0) goto L181;
        String r58 = r66.T;
    L183:
        if ((r84 & 8192) == 0) goto L185;
        String r59 = r66.U;
    L187:
        if ((r84 & 16384) == 0) goto L189;
        boolean r510 = r66.V;
    L191:
        if ((r84 & 32768) == 0) goto L193;
        String r111 = r66.W;
        int r21 = 65536;
    L195:
        if ((r21 & r84) == 0) goto L197;
        String r25 = r66.X;
    L198:
        Map<String, String> r710 = r1;
        if ((r84 & 131072) == 0) goto L201;
        Map<String, String> r2 = r66.Y;
    L202:
        Map<String, String> r711 = r2;
        if ((r84 & 262144) == 0) goto L205;
        com.bytedance.android.livesdk.gift.platform.core.model.a r60 = r66.Z;
        int r7 = 524288;
    L207:
        if ((r7 & r84) == 0) goto L209;
        int r61 = r66.a0;
        int r26 = 1048576;
    L211:
        if ((r26 & r84) == 0) goto L213;
        Map<String, String> r63 = r66.b0;
        int r28 = 2097152;
    L215:
        if ((r28 & r84) == 0) goto L217;
        Map<String, String> r64 = r66.c0;
        int r36 = 4194304;
    L219:
        if ((r36 & r84) == 0) goto L221;
        Long r65 = r66.d0;
    L222:
        r66.getClass();
        Intrinsics.checkNotNullParameter(r8, "sendGiftFrom");
        Intrinsics.checkNotNullParameter(r14, "giftSourceLog");
        Intrinsics.checkNotNullParameter(r15, "requestSourceLog");
        Intrinsics.checkNotNullParameter(r16, "triggerWord");
        Intrinsics.checkNotNullParameter(r3, "extra");
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r5, "sendGiftStrategy");
        Intrinsics.checkNotNullParameter(r18, "refId");
        Intrinsics.checkNotNullParameter(r110, "seriesSendType");
        Intrinsics.checkNotNullParameter(r111, "searchWord");
        Intrinsics.checkNotNullParameter(r25, "searchId");
        String r68 = r111;
        SeriesSendType r310 = r110;
        return new b0(r6, r8, r44, r10, r11, r610, r14, r15, r16, r3, r17, r4, r19, r20, r5, r23, r24, r18, r27, r29, r30, r31, r33, r34, r35, r310, r37, r38, r39, r40, r41, r710, r43, r45, r46, r47, r49, r50, r51, r53, r54, r55, r56, r57, r58, r59, r510, r68, r25, r711, r60, r61, r63, r64, r65);
    L221:
        r65 = r81;
        goto L222
    L217:
        r36 = 4194304;
        r64 = null;
        goto L219
    L213:
        r28 = 2097152;
        r63 = null;
        goto L215
    L209:
        r26 = 1048576;
        r61 = 0;
        goto L211
    L205:
        r7 = 524288;
        r60 = null;
        goto L207
    L201:
        r2 = null;
        goto L202
    L197:
        r25 = null;
        goto L198
    L193:
        r21 = 65536;
        r111 = null;
        goto L195
    L189:
        r510 = false;
        goto L191
    L185:
        r59 = null;
        goto L187
    L181:
        r58 = null;
        goto L183
    L177:
        r57 = null;
        goto L179
    L173:
        r56 = null;
        goto L175
    L169:
        r55 = null;
        goto L171
    L165:
        r54 = null;
        goto L167
    L161:
        r53 = false;
        goto L163
    L157:
        r51 = null;
        goto L159
    L153:
        r50 = null;
        goto L155
    L149:
        r49 = r80;
        goto L151
    L145:
        r47 = 0;
        goto L147
    L141:
        r46 = r79;
        goto L143
    L137:
        r45 = r78;
        goto L139
    L133:
        r43 = r77;
        goto L134
    L129:
        r1 = null;
        goto L131
    L125:
        r41 = null;
        goto L127
    L121:
        r40 = r76;
        goto L123
    L117:
        r39 = r75;
        goto L119
    L113:
        r38 = null;
        goto L115
    L109:
        r37 = null;
        goto L111
    L105:
        r110 = null;
        goto L107
    L101:
        r35 = null;
        goto L103
    L97:
        r34 = 0;
        goto L99
    L93:
        r33 = false;
        goto L95
    L89:
        r31 = null;
        goto L91
    L85:
        r30 = false;
        goto L87
    L81:
        r29 = r74;
        goto L83
    L77:
        r27 = 0;
        goto L79
    L73:
        r18 = null;
        goto L75
    L69:
        r24 = false;
        goto L71
    L65:
        r23 = 0;
        goto L67
    L61:
        r5 = r73;
        goto L62
    L57:
        r20 = false;
        goto L59
    L53:
        r19 = null;
        goto L55
    L49:
        r4 = null;
        goto L51
    L45:
        r17 = 0;
        goto L47
    L41:
        r3 = r71;
        goto L43
    L37:
        r16 = null;
        goto L39
    L33:
        r15 = null;
        goto L35
    L29:
        r14 = null;
        goto L31
    L25:
        r13 = 0;
        goto L27
    L21:
        r11 = r70;
        goto L23
    L17:
        r10 = r69;
        goto L19
    L13:
        r9 = null;
        goto L15
    L9:
        r8 = null;
        goto L11
    L5:
        r6 = r67;
        goto L7
    }

    public /* synthetic */ b0(long r68, SendGiftSource r70, IBaseUser r71, Long r73, int r74, int r75, String r76, String r77, String r78, String r79, int r710, String r80, ArrayList r81, boolean r83, SendGiftStrategy r84, int r85, boolean r86, String r87, long r88, ReceiverType r89, boolean r90, List r91, boolean r93, int r94, List r95, SeriesSendType r96, String r97, n r98, Long r99, String r910, Map r100, Map r101, int r102, long r103, String r105, String r106, boolean r107, k r108, k r109, String r110, String r111, String r112, String r113, boolean r114, String r115, String r116, Map r117, com.bytedance.android.livesdk.gift.platform.core.model.a r118, int r119, Map r120, Map r121, int r122, int r123) {
        if ((r122 & 4) == 0) goto L5;
        IBaseUser r8 = null;
    L7:
        if ((r122 & 8) == 0) goto L9;
        Long r9 = null;
    L11:
        if ((r122 & 16) == 0) goto L13;
        int r10 = 1;
    L15:
        if ((r122 & 32) == 0) goto L17;
        int r11 = 0;
    L19:
        if ((r122 & 64) == 0) goto L21;
        String r13 = BuildConfig.FLAVOR;
    L23:
        if ((r122 & 128) == 0) goto L25;
        String r14 = BuildConfig.FLAVOR;
    L27:
        if ((r122 & 256) == 0) goto L29;
        String r15 = BuildConfig.FLAVOR;
    L31:
        if ((r122 & 512) == 0) goto L33;
        String r16 = BuildConfig.FLAVOR;
    L35:
        if ((r122 & 1024) == 0) goto L37;
        int r17 = 0;
    L39:
        if ((r122 & 2048) == 0) goto L41;
        String r18 = com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL;
    L43:
        if ((r122 & 4096) == 0) goto L45;
        ArrayList r19 = null;
    L47:
        if ((r122 & 8192) == 0) goto L49;
        boolean r124 = false;
    L51:
        if ((r122 & 16384) == 0) goto L53;
        SendGiftStrategy r20 = SendGiftStrategy.ONE_SEND_ONE_REQUEST;
    L55:
        if ((r122 & 32768) == 0) goto L57;
        int r21 = 1;
    L59:
        if ((r122 & 65536) == 0) goto L61;
        boolean r23 = false;
    L63:
        if ((r122 & 131072) == 0) goto L65;
        String r24 = BuildConfig.FLAVOR;
    L67:
        if ((r122 & 262144) == 0) goto L69;
        long r29 = 0;
    L71:
        if ((r122 & 524288) == 0) goto L73;
        ReceiverType r31 = null;
    L75:
        if ((r122 & 1048576) == 0) goto L77;
        boolean r33 = false;
    L79:
        if ((r122 & 2097152) == 0) goto L81;
        List r35 = null;
    L83:
        if ((r122 & 4194304) == 0) goto L85;
        boolean r36 = false;
    L87:
        if ((r122 & 8388608) == 0) goto L89;
        int r37 = 0;
    L91:
        if ((r122 & 16777216) == 0) goto L93;
        List r38 = null;
    L95:
        if ((r122 & 33554432) == 0) goto L97;
        SeriesSendType r39 = SeriesSendType.NONE;
    L99:
        if ((r122 & 67108864) == 0) goto L101;
        String r40 = null;
    L103:
        if ((r122 & 134217728) == 0) goto L105;
        n r41 = null;
    L107:
        if ((r122 & 268435456) == 0) goto L109;
        Long r43 = null;
    L111:
        if ((r122 & 536870912) == 0) goto L113;
        String r44 = null;
    L115:
        if ((r122 & 1073741824) == 0) goto L117;
        Map r45 = null;
    L119:
        if ((r122 & Integer.MIN_VALUE) == 0) goto L121;
        Map r0 = null;
    L123:
        if ((r123 & 4) == 0) goto L125;
        int r48 = 0;
    L127:
        if ((r123 & 8) == 0) goto L129;
        long r49 = 0;
    L131:
        if ((r123 & 32) == 0) goto L133;
        String r53 = BuildConfig.FLAVOR;
    L135:
        if ((r123 & 64) == 0) goto L137;
        String r54 = null;
    L139:
        if ((r123 & 128) == 0) goto L141;
        boolean r3 = false;
    L143:
        if ((r123 & 256) == 0) goto L145;
        k r55 = null;
    L147:
        if ((r123 & 512) == 0) goto L149;
        k r56 = null;
    L151:
        if ((r123 & 1024) == 0) goto L153;
        String r57 = null;
    L155:
        if ((r123 & 2048) == 0) goto L157;
        String r58 = null;
    L159:
        if ((r123 & 4096) == 0) goto L161;
        String r59 = null;
    L163:
        if ((r123 & 8192) == 0) goto L165;
        String r510 = null;
    L167:
        if ((r123 & 16384) == 0) goto L169;
        boolean r60 = false;
    L171:
        if ((32768 & r123) == 0) goto L173;
        String r2 = BuildConfig.FLAVOR;
    L175:
        if ((r123 & 65536) == 0) goto L177;
        String r61 = BuildConfig.FLAVOR;
    L179:
        if ((r123 & 131072) == 0) goto L181;
        Map r63 = null;
    L183:
        if ((r123 & 262144) == 0) goto L185;
        com.bytedance.android.livesdk.gift.platform.core.model.a r64 = null;
    L187:
        if ((r123 & 524288) == 0) goto L189;
        int r65 = 1;
    L191:
        if ((r123 & 1048576) == 0) goto L193;
        Map r66 = null;
    L195:
        if ((r123 & 2097152) == 0) goto L197;
        Map r1 = null;
    L198:
        this(r68, r70, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r124, r20, r21, r23, r24, r29, r31, r33, r35, r36, r37, r38, r39, r40, r41, r43, r44, r45, r0, null, 0, r48, r49, null, r53, r54, r3, r55, r56, r57, r58, r59, r510, r60, r2, r61, r63, r64, r65, r66, r1, null);
        return;
    L197:
        r1 = r121;
        goto L198
    L193:
        r66 = r120;
        goto L195
    L189:
        r65 = r119;
        goto L191
    L185:
        r64 = r118;
        goto L187
    L181:
        r63 = r117;
        goto L183
    L177:
        r61 = r116;
        goto L179
    L173:
        r2 = r115;
        goto L175
    L169:
        r60 = r114;
        goto L171
    L165:
        r510 = r113;
        goto L167
    L161:
        r59 = r112;
        goto L163
    L157:
        r58 = r111;
        goto L159
    L153:
        r57 = r110;
        goto L155
    L149:
        r56 = r109;
        goto L151
    L145:
        r55 = r108;
        goto L147
    L141:
        r3 = r107;
        goto L143
    L137:
        r54 = r106;
        goto L139
    L133:
        r53 = r105;
        goto L135
    L129:
        r49 = r103;
        goto L131
    L125:
        r48 = r102;
        goto L127
    L121:
        r0 = r101;
        goto L123
    L117:
        r45 = r100;
        goto L119
    L113:
        r44 = r910;
        goto L115
    L109:
        r43 = r99;
        goto L111
    L105:
        r41 = r98;
        goto L107
    L101:
        r40 = r97;
        goto L103
    L97:
        r39 = r96;
        goto L99
    L93:
        r38 = r95;
        goto L95
    L89:
        r37 = r94;
        goto L91
    L85:
        r36 = r93;
        goto L87
    L81:
        r35 = r91;
        goto L83
    L77:
        r33 = r90;
        goto L79
    L73:
        r31 = r89;
        goto L75
    L69:
        r29 = r88;
        goto L71
    L65:
        r24 = r87;
        goto L67
    L61:
        r23 = r86;
        goto L63
    L57:
        r21 = r85;
        goto L59
    L53:
        r20 = r84;
        goto L55
    L49:
        r124 = r83;
        goto L51
    L45:
        r19 = r81;
        goto L47
    L41:
        r18 = r80;
        goto L43
    L37:
        r17 = r710;
        goto L39
    L33:
        r16 = r79;
        goto L35
    L29:
        r15 = r78;
        goto L31
    L25:
        r14 = r77;
        goto L27
    L21:
        r13 = r76;
        goto L23
    L17:
        r11 = r75;
        goto L19
    L13:
        r10 = r74;
        goto L15
    L9:
        r9 = r73;
        goto L11
    L5:
        r8 = r71;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b0(long r15, SendGiftSource r17, IBaseUser r18, Long r19, int r20, int r21, String r23, String r24, String r25, String r26, int r27, String r28, ArrayList<e3> r29, boolean r210, SendGiftStrategy r30, int r31, boolean r33, String r34, long r35, ReceiverType r36, boolean r37, List<? extends IBaseUser> r38, boolean r39, int r40, List<? extends k3> r41, SeriesSendType r43, String r44, n r45, Long r46, String r47, Map<String, String> r48, Map<String, String> r49, IRoom r410, long r50, int r53, long r54, Map<String, ? extends Object> r55, String r56, String r57, boolean r58, k r59, k r60, String r61, String r63, String r64, String r65, boolean r66, String r67, String r68, Map<String, String> r69, com.bytedance.android.livesdk.gift.platform.core.model.a r610, int r70, Map<String, String> r71, Map<String, String> r73, Long r74) {
        Intrinsics.checkNotNullParameter(r17, "sendGiftFrom");
        Intrinsics.checkNotNullParameter(r23, "giftSourceLog");
        Intrinsics.checkNotNullParameter(r24, "requestSourceLog");
        Intrinsics.checkNotNullParameter(r25, "triggerWord");
        Intrinsics.checkNotNullParameter(r26, "extra");
        Intrinsics.checkNotNullParameter(r28, "source");
        Intrinsics.checkNotNullParameter(r30, "sendGiftStrategy");
        Intrinsics.checkNotNullParameter(r34, "refId");
        Intrinsics.checkNotNullParameter(r43, "seriesSendType");
        Intrinsics.checkNotNullParameter(r67, "searchWord");
        Intrinsics.checkNotNullParameter(r68, "searchId");
        this.b = r15;
        this.c = r17;
        this.d = r18;
        this.e = r19;
        this.f = r20;
        this.g = r21;
        this.h = r23;
        this.i = r24;
        this.j = r25;
        this.k = r26;
        this.l = r27;
        this.m = r28;
        this.n = r29;
        this.o = r210;
        this.p = r30;
        this.q = r31;
        this.r = r33;
        this.s = r34;
        this.t = r35;
        this.u = r36;
        this.v = r37;
        this.w = r38;
        this.x = r39;
        this.y = r40;
        this.z = r41;
        this.A = r43;
        this.B = r44;
        this.C = r45;
        this.D = r46;
        this.E = r47;
        this.F = r48;
        this.G = r49;
        this.H = r410;
        this.I = r50;
        this.J = r53;
        this.K = r54;
        this.L = r55;
        this.M = r56;
        this.N = r57;
        this.O = r58;
        this.P = r59;
        this.Q = r60;
        this.R = r61;
        this.S = r63;
        this.T = r64;
        this.U = r65;
        this.V = r66;
        this.W = r67;
        this.X = r68;
        this.Y = r69;
        this.Z = r610;
        this.a0 = r70;
        this.b0 = r71;
        this.c0 = r73;
        this.d0 = r74;
    }
}
