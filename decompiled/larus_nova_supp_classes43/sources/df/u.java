package df;

import com.bytedance.android.ec.model.BuyNowPreloadParams;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u {
    public static final /* synthetic */ int d0 = 0;
    public final String A;
    public final String B;
    public final String C;
    public final String D;
    public final String E;
    public final boolean F;
    public final String G;
    public final String H;
    public final String I;
    public final String J;
    public final String K;
    public final String L;
    public final JSONObject M;
    public final JSONObject N;
    public final int O;
    public final BuyNowPreloadParams P;
    public final String Q;
    public final String R;
    public final String S;
    public final String T;
    public final String U;
    public final String V;
    public final boolean W;
    public final String X;
    public final String Y;
    public final Integer Z;
    public final boolean a;
    public final String a0;
    public final String[] b;
    public final Integer b0;
    public final String c;
    public final String c0;
    public final long d;
    public final String e;
    public final Integer f;
    public final boolean g;
    public final List<PromotionBenefitLabel> h;
    public final boolean i;
    public final String j;
    public final JSONObject k;
    public final JSONObject l;
    public final JSONObject m;
    public final JSONObject n;
    public final JSONObject o;
    public final Integer p;
    public final JSONObject q;
    public final JSONObject r;
    public final JSONObject s;
    public final int t;
    public final String u;
    public final int v;
    public final String w;
    public final String x;
    public final String y;
    public final String z;

    public static final class a {
    }

    static {
    }

    public u() {
        throw null;
    }

    public final String toString() {
        return "SKUOptional(addShopCart=" + this.a + ", defaultSelectedSpecId=" + Arrays.toString(this.b) + ", defaultSelectedSkuId=" + this.c + ", defaultBuyCount=" + this.d + ", hotSaleSkuId=" + this.e + ", hotSaleType=" + this.f + ", scrollToDouInstallment=" + this.g + ", benefitLabels=" + this.h + ", showSoldOutNotice=" + this.i + ", selectCarId=" + this.j + ", eventParams=" + this.k + ", logData=" + this.l + ", entranceInfo=" + this.m + ", detailEventAdditions=" + this.n + ", transmissibleFeedJson=" + this.o + ", eventPrefixType=" + this.p + ", transmissibleLiveJson=" + this.q + ", skuLogExtra=" + this.r + ", liveEventParams=" + this.s + ", sceneType=" + this.t + ", enterMethod=" + this.u + ", addToastType=" + this.v + ", enterFrom=" + this.w + ", productId=" + this.x + ", authorId=" + this.y + ", secAuthorId=" + this.z + ", marketChannel=" + this.A + ", promotionSource=" + this.B + ", roomId=" + this.C + ", shopId=" + this.D + ", itemId=" + this.E + ", isGroupingBuy=" + this.F + ", spellGroupId=" + this.G + ", detailUrl=" + this.H + ", orderUrl=" + this.I + ", combinationId=" + this.J + ", receiveAddressId=" + this.K + ", extraParams=" + this.L + ", addCartExtra=" + this.M + ", addCartEntranceInfo=" + this.N + ", applyCoupon=" + this.O + ", buyNowPreloadParams=" + this.P + ", activityId=" + this.Q + ", newSourceId=" + this.R + ", creativeId=" + this.S + ", logExtra=" + this.T + ", adExtraData=" + this.U + ", groupId=" + this.V + ", usePrerenderSku=" + this.W + ", skuPrerenderId=" + this.X + ", channelId=" + this.Y + ", channelType=" + this.Z + ", cpsTrack=" + this.a0 + ", forceYataSku=" + this.b0 + ", bizIdentifier=" + this.c0 + ")";
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r10 = r0 * 31;
        String[] r11 = this.b;
        int r12 = 0;
        if (r11 == null) goto L9;
        int r13 = Arrays.hashCode(r11);
    L10:
        int r14 = (r10 + r13) * 31;
        String r15 = this.c;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        long r17 = this.d;
        int r18 = (((r14 + r16) * 31) + ((int) (r17 ^ (r17 >>> 32)))) * 31;
        String r19 = this.e;
        if (r19 == null) goto L17;
        int r20 = r19.hashCode();
    L18:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.f;
        if (r22 == null) goto L21;
        int r23 = r22.intValue();
    L22:
        int r24 = (r21 + r23) * 31;
        if (this.g == false) goto L25;
        int r25 = 1231;
    L26:
        int r26 = (r24 + r25) * 31;
        List<PromotionBenefitLabel> r27 = this.h;
        if (r27 == null) goto L29;
        int r28 = r27.hashCode();
    L30:
        int r29 = (r26 + r28) * 31;
        if (this.i == false) goto L33;
        int r30 = 1231;
    L34:
        int r31 = (r29 + r30) * 31;
        String r32 = this.j;
        if (r32 == null) goto L37;
        int r33 = r32.hashCode();
    L38:
        int r34 = (r31 + r33) * 31;
        JSONObject r35 = this.k;
        if (r35 == null) goto L41;
        int r36 = r35.hashCode();
    L42:
        int r37 = (r34 + r36) * 31;
        JSONObject r38 = this.l;
        if (r38 == null) goto L45;
        int r39 = r38.hashCode();
    L46:
        int r40 = (r37 + r39) * 31;
        JSONObject r41 = this.m;
        if (r41 == null) goto L49;
        int r42 = r41.hashCode();
    L50:
        int r43 = (r40 + r42) * 31;
        JSONObject r44 = this.n;
        if (r44 == null) goto L53;
        int r45 = r44.hashCode();
    L54:
        int r46 = (r43 + r45) * 31;
        JSONObject r47 = this.o;
        if (r47 == null) goto L57;
        int r48 = r47.hashCode();
    L58:
        int r49 = (r46 + r48) * 31;
        Integer r50 = this.p;
        if (r50 == null) goto L61;
        int r51 = r50.intValue();
    L62:
        int r52 = (r49 + r51) * 31;
        JSONObject r53 = this.q;
        if (r53 == null) goto L65;
        int r54 = r53.hashCode();
    L66:
        int r55 = (r52 + r54) * 31;
        JSONObject r56 = this.r;
        if (r56 == null) goto L69;
        int r57 = r56.hashCode();
    L70:
        int r58 = (r55 + r57) * 31;
        JSONObject r59 = this.s;
        if (r59 == null) goto L73;
        int r60 = r59.hashCode();
    L74:
        int r61 = (((((((r58 + r60) * 31) + this.t) * 31) + this.u.hashCode()) * 31) + this.v) * 31;
        String r62 = this.w;
        if (r62 == null) goto L77;
        int r63 = r62.hashCode();
    L78:
        int r64 = (r61 + r63) * 31;
        String r65 = this.x;
        if (r65 == null) goto L81;
        int r66 = r65.hashCode();
    L82:
        int r67 = (((((r64 + r66) * 31) + this.y.hashCode()) * 31) + this.z.hashCode()) * 31;
        String r68 = this.A;
        if (r68 == null) goto L85;
        int r69 = r68.hashCode();
    L86:
        int r70 = (r67 + r69) * 31;
        String r71 = this.B;
        if (r71 == null) goto L89;
        int r72 = r71.hashCode();
    L90:
        int r73 = (r70 + r72) * 31;
        String r74 = this.C;
        if (r74 == null) goto L93;
        int r75 = r74.hashCode();
    L94:
        int r76 = (r73 + r75) * 31;
        String r77 = this.D;
        if (r77 == null) goto L97;
        int r78 = r77.hashCode();
    L98:
        int r79 = (r76 + r78) * 31;
        String r80 = this.E;
        if (r80 == null) goto L101;
        int r81 = r80.hashCode();
    L102:
        int r82 = (r79 + r81) * 31;
        if (this.F == false) goto L105;
        int r83 = 1231;
    L106:
        int r84 = (r82 + r83) * 31;
        String r85 = this.G;
        if (r85 == null) goto L109;
        int r86 = r85.hashCode();
    L110:
        int r87 = (r84 + r86) * 31;
        String r88 = this.H;
        if (r88 == null) goto L113;
        int r89 = r88.hashCode();
    L114:
        int r90 = (r87 + r89) * 31;
        String r91 = this.I;
        if (r91 == null) goto L117;
        int r92 = r91.hashCode();
    L118:
        int r93 = (r90 + r92) * 31;
        String r94 = this.J;
        if (r94 == null) goto L121;
        int r95 = r94.hashCode();
    L122:
        int r96 = (r93 + r95) * 31;
        String r97 = this.K;
        if (r97 == null) goto L125;
        int r98 = r97.hashCode();
    L126:
        int r99 = (r96 + r98) * 31;
        String r100 = this.L;
        if (r100 == null) goto L129;
        int r101 = r100.hashCode();
    L130:
        int r102 = (r99 + r101) * 31;
        JSONObject r103 = this.M;
        if (r103 == null) goto L133;
        int r104 = r103.hashCode();
    L134:
        int r105 = (r102 + r104) * 31;
        JSONObject r106 = this.N;
        if (r106 == null) goto L137;
        int r107 = r106.hashCode();
    L138:
        int r108 = (((r105 + r107) * 31) + this.O) * 31;
        BuyNowPreloadParams r109 = this.P;
        if (r109 == null) goto L141;
        int r110 = r109.hashCode();
    L142:
        int r111 = (r108 + r110) * 31;
        String r112 = this.Q;
        if (r112 == null) goto L145;
        int r113 = r112.hashCode();
    L146:
        int r114 = (r111 + r113) * 31;
        String r115 = this.R;
        if (r115 == null) goto L149;
        int r116 = r115.hashCode();
    L150:
        int r117 = (r114 + r116) * 31;
        String r118 = this.S;
        if (r118 == null) goto L153;
        int r119 = r118.hashCode();
    L154:
        int r120 = (r117 + r119) * 31;
        String r121 = this.T;
        if (r121 == null) goto L157;
        int r122 = r121.hashCode();
    L158:
        int r123 = (r120 + r122) * 31;
        String r124 = this.U;
        if (r124 == null) goto L161;
        int r125 = r124.hashCode();
    L162:
        int r126 = (r123 + r125) * 31;
        String r127 = this.V;
        if (r127 == null) goto L165;
        int r128 = r127.hashCode();
    L166:
        int r129 = (r126 + r128) * 31;
        if (this.W == true) goto L170;
        r1 = 1237;
    L170:
        int r130 = (((r129 + r1) * 31) + this.X.hashCode()) * 31;
        String r131 = this.Y;
        if (r131 == null) goto L173;
        int r132 = r131.hashCode();
    L174:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.Z;
        if (r134 == null) goto L177;
        int r135 = r134.intValue();
    L178:
        int r136 = (r133 + r135) * 31;
        String r137 = this.a0;
        if (r137 == null) goto L181;
        int r138 = r137.hashCode();
    L182:
        int r139 = (r136 + r138) * 31;
        String r140 = this.c0;
        if (r140 == null) goto L185;
        int r141 = r140.hashCode();
    L186:
        int r142 = (r139 + r141) * 31;
        Integer r143 = this.b0;
        if (r143 == null) goto L190;
        r12 = r143.intValue();
    L190:
        return r142 + r12;
    L185:
        r141 = 0;
        goto L186
    L181:
        r138 = 0;
        goto L182
    L177:
        r135 = 0;
        goto L178
    L173:
        r132 = 0;
        goto L174
    L165:
        r128 = 0;
        goto L166
    L161:
        r125 = 0;
        goto L162
    L157:
        r122 = 0;
        goto L158
    L153:
        r119 = 0;
        goto L154
    L149:
        r116 = 0;
        goto L150
    L145:
        r113 = 0;
        goto L146
    L141:
        r110 = 0;
        goto L142
    L137:
        r107 = 0;
        goto L138
    L133:
        r104 = 0;
        goto L134
    L129:
        r101 = 0;
        goto L130
    L125:
        r98 = 0;
        goto L126
    L121:
        r95 = 0;
        goto L122
    L117:
        r92 = 0;
        goto L118
    L113:
        r89 = 0;
        goto L114
    L109:
        r86 = 0;
        goto L110
    L105:
        r83 = 1237;
        goto L106
    L101:
        r81 = 0;
        goto L102
    L97:
        r78 = 0;
        goto L98
    L93:
        r75 = 0;
        goto L94
    L89:
        r72 = 0;
        goto L90
    L85:
        r69 = 0;
        goto L86
    L81:
        r66 = 0;
        goto L82
    L77:
        r63 = 0;
        goto L78
    L73:
        r60 = 0;
        goto L74
    L69:
        r57 = 0;
        goto L70
    L65:
        r54 = 0;
        goto L66
    L61:
        r51 = 0;
        goto L62
    L57:
        r48 = 0;
        goto L58
    L53:
        r45 = 0;
        goto L54
    L49:
        r42 = 0;
        goto L50
    L45:
        r39 = 0;
        goto L46
    L41:
        r36 = 0;
        goto L42
    L37:
        r33 = 0;
        goto L38
    L33:
        r30 = 1237;
        goto L34
    L29:
        r28 = 0;
        goto L30
    L25:
        r25 = 1237;
        goto L26
    L21:
        r23 = 0;
        goto L22
    L17:
        r20 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 == null) goto L8;
        Class<?> r11 = r10.getClass();
    L10:
        if ((!Intrinsics.areEqual(u.class, r11)) == false) goto L12;
        return false;
    L12:
        if (r10 == null) goto L188;
        u r12 = (u) r10;
        if (this.a == r12.a) goto L16;
        return false;
    L16:
        String[] r1 = this.b;
        if (r1 == null) goto L25;
        String[] r13 = r12.b;
        if (r13 != null) goto L22;
        return false;
    L22:
        if (Arrays.equals(r1, r13) == true) goto L28;
        return false;
    L28:
        if ((!Intrinsics.areEqual(this.c, r12.c)) == false) goto L31;
        return false;
    L31:
        if (this.d == r12.d) goto L34;
        return false;
    L34:
        if ((!Intrinsics.areEqual(this.e, r12.e)) == false) goto L37;
        return false;
    L37:
        if ((!Intrinsics.areEqual(this.f, r12.f)) == false) goto L40;
        return false;
    L40:
        if (this.g == r12.g) goto L43;
        return false;
    L43:
        if ((!Intrinsics.areEqual(this.h, r12.h)) == false) goto L46;
        return false;
    L46:
        if (this.i == r12.i) goto L49;
        return false;
    L49:
        if ((!Intrinsics.areEqual(this.j, r12.j)) == false) goto L52;
        return false;
    L52:
        if ((!Intrinsics.areEqual(this.k, r12.k)) == false) goto L55;
        return false;
    L55:
        if ((!Intrinsics.areEqual(this.l, r12.l)) == false) goto L58;
        return false;
    L58:
        if ((!Intrinsics.areEqual(this.m, r12.m)) == false) goto L61;
        return false;
    L61:
        if ((!Intrinsics.areEqual(this.n, r12.n)) == false) goto L64;
        return false;
    L64:
        if ((!Intrinsics.areEqual(this.o, r12.o)) == false) goto L67;
        return false;
    L67:
        if ((!Intrinsics.areEqual(this.p, r12.p)) == false) goto L70;
        return false;
    L70:
        if ((!Intrinsics.areEqual(this.q, r12.q)) == false) goto L73;
        return false;
    L73:
        if ((!Intrinsics.areEqual(this.r, r12.r)) == false) goto L76;
        return false;
    L76:
        if ((!Intrinsics.areEqual(this.s, r12.s)) == false) goto L79;
        return false;
    L79:
        if (this.t == r12.t) goto L82;
        return false;
    L82:
        if ((!Intrinsics.areEqual(this.u, r12.u)) == false) goto L85;
        return false;
    L85:
        if (this.v == r12.v) goto L88;
        return false;
    L88:
        if ((!Intrinsics.areEqual(this.w, r12.w)) == false) goto L91;
        return false;
    L91:
        if ((!Intrinsics.areEqual(this.x, r12.x)) == false) goto L94;
        return false;
    L94:
        if ((!Intrinsics.areEqual(this.y, r12.y)) == false) goto L97;
        return false;
    L97:
        if ((!Intrinsics.areEqual(this.z, r12.z)) == false) goto L100;
        return false;
    L100:
        if ((!Intrinsics.areEqual(this.A, r12.A)) == false) goto L103;
        return false;
    L103:
        if ((!Intrinsics.areEqual(this.B, r12.B)) == false) goto L106;
        return false;
    L106:
        if ((!Intrinsics.areEqual(this.C, r12.C)) == false) goto L109;
        return false;
    L109:
        if ((!Intrinsics.areEqual(this.D, r12.D)) == false) goto L112;
        return false;
    L112:
        if ((!Intrinsics.areEqual(this.E, r12.E)) == false) goto L115;
        return false;
    L115:
        if (this.F == r12.F) goto L118;
        return false;
    L118:
        if ((!Intrinsics.areEqual(this.G, r12.G)) == false) goto L121;
        return false;
    L121:
        if ((!Intrinsics.areEqual(this.H, r12.H)) == false) goto L124;
        return false;
    L124:
        if ((!Intrinsics.areEqual(this.I, r12.I)) == false) goto L127;
        return false;
    L127:
        if ((!Intrinsics.areEqual(this.J, r12.J)) == false) goto L130;
        return false;
    L130:
        if ((!Intrinsics.areEqual(this.K, r12.K)) == false) goto L133;
        return false;
    L133:
        if ((!Intrinsics.areEqual(this.L, r12.L)) == false) goto L136;
        return false;
    L136:
        if ((!Intrinsics.areEqual(this.M, r12.M)) == false) goto L139;
        return false;
    L139:
        if ((!Intrinsics.areEqual(this.N, r12.N)) == false) goto L142;
        return false;
    L142:
        if (this.O == r12.O) goto L145;
        return false;
    L145:
        if ((!Intrinsics.areEqual(this.P, r12.P)) == false) goto L148;
        return false;
    L148:
        if ((!Intrinsics.areEqual(this.Q, r12.Q)) == false) goto L151;
        return false;
    L151:
        if ((!Intrinsics.areEqual(this.R, r12.R)) == false) goto L154;
        return false;
    L154:
        if ((!Intrinsics.areEqual(this.S, r12.S)) == false) goto L157;
        return false;
    L157:
        if ((!Intrinsics.areEqual(this.T, r12.T)) == false) goto L160;
        return false;
    L160:
        if ((!Intrinsics.areEqual(this.U, r12.U)) == false) goto L163;
        return false;
    L163:
        if ((!Intrinsics.areEqual(this.V, r12.V)) == false) goto L166;
        return false;
    L166:
        if (this.W == r12.W) goto L169;
        return false;
    L169:
        if ((!Intrinsics.areEqual(this.X, r12.X)) == false) goto L172;
        return false;
    L172:
        if ((!Intrinsics.areEqual(this.Y, r12.Y)) == false) goto L175;
        return false;
    L175:
        if ((!Intrinsics.areEqual(this.Z, r12.Z)) == false) goto L178;
        return false;
    L178:
        if ((!Intrinsics.areEqual(this.a0, r12.a0)) == false) goto L181;
        return false;
    L181:
        if ((!Intrinsics.areEqual(this.b0, r12.b0)) == false) goto L184;
        return false;
    L184:
        if ((!Intrinsics.areEqual(this.c0, r12.c0)) == false) goto L186;
        return false;
    L186:
        return true;
    L25:
        if (r12.b == null) goto L28;
        return false;
    L188:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.common.api.abilities.SKUOptional");
    L8:
        r11 = null;
        goto L10
    }

    public u(boolean r10, String[] r11, String r12, long r13, String r14, Integer r15, boolean r16, String r17, JSONObject r18, JSONObject r19, JSONObject r110, JSONObject r20, JSONObject r21, JSONObject r22, int r23, String r24, int r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, boolean r35, String r36, String r37, String r38, JSONObject r39, int r40, BuyNowPreloadParams r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, Integer r50, String r51, Integer r52, String r53) {
        Intrinsics.checkNotNullParameter(r24, "enterMethod");
        Intrinsics.checkNotNullParameter(r28, "authorId");
        Intrinsics.checkNotNullParameter(r29, "secAuthorId");
        Intrinsics.checkNotNullParameter(r48, "skuPrerenderId");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = null;
        this.i = false;
        this.j = r17;
        this.k = r18;
        this.l = r19;
        this.m = r110;
        this.n = r20;
        this.o = r21;
        this.p = null;
        this.q = r22;
        this.r = null;
        this.s = null;
        this.t = r23;
        this.u = r24;
        this.v = r25;
        this.w = r26;
        this.x = r27;
        this.y = r28;
        this.z = r29;
        this.A = r30;
        this.B = r31;
        this.C = r32;
        this.D = r33;
        this.E = r34;
        this.F = r35;
        this.G = r36;
        this.H = null;
        this.I = r37;
        this.J = null;
        this.K = r38;
        this.L = null;
        this.M = r39;
        this.N = null;
        this.O = r40;
        this.P = r41;
        this.Q = r42;
        this.R = r43;
        this.S = r44;
        this.T = r45;
        this.U = r46;
        this.V = r47;
        this.W = true;
        this.X = r48;
        this.Y = r49;
        this.Z = r50;
        this.a0 = r51;
        this.b0 = r52;
        this.c0 = r53;
    }
}
