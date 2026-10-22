package vz1;

import android.text.TextUtils;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.r0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.CardType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.GiftPanelIconSource;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public final h1 a;
    public final long b;
    public final Pair<Integer, i> c;
    public final long d;
    public final boolean e;
    public final boolean f;
    public final h g;
    public final Long h;
    public final int i;
    public final int j;
    public final String k;
    public final String l;
    public final String m;
    public final Boolean n;
    public final k o;
    public final String p;
    public final GiftPanelIconSource q;
    public Long r;
    public final f s;
    public final d t;
    public final a u;
    public final CardType v;
    public final boolean w;
    public com.bytedance.android.livesdk.gift.platform.core.model.k x;
    public final boolean y;
    public final com.bytedance.android.livesdk.gift.platform.core.model.a z;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e) == false) goto L58;
        e r7 = (e) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
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
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L24;
        return false;
    L24:
        if (this.j == r7.j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r7.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r7.m) == true) goto L32;
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
        if (Intrinsics.areEqual(this.q, r7.q) == true) goto L40;
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
        if (Intrinsics.areEqual(this.x, r7.x) == true) goto L54;
        return false;
    L54:
        if (this.y == r7.y) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.z, r7.z) == true) goto L88;
        return false;
    L88:
        return true;
    L58:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v56, types: [int] */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final int hashCode() {
        h1 r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        Pair<Integer, i> r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        long r8 = this.d;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        boolean r10 = this.e;
        ?? r11 = 1;
        ?? r13 = r10;
        if (r10 == false) goto L13;
        r13 = 1;
    L13:
        int r14 = (r9 + r13) * 31;
        boolean r15 = this.f;
        ?? r16 = r15;
        if (r15 == false) goto L16;
        r16 = 1;
    L16:
        int r17 = (r14 + r16) * 31;
        h r18 = this.g;
        if (r18 == null) goto L19;
        int r19 = r18.hashCode();
    L20:
        int r20 = (r17 + r19) * 31;
        Long r21 = this.h;
        if (r21 == null) goto L23;
        int r23 = r21.hashCode();
    L24:
        int r24 = (((((r20 + r23) * 31) + this.i) * 31) + this.j) * 31;
        String r25 = this.k;
        if (r25 == null) goto L27;
        int r26 = r25.hashCode();
    L28:
        int r27 = (r24 + r26) * 31;
        String r28 = this.l;
        if (r28 == null) goto L31;
        int r29 = r28.hashCode();
    L32:
        int r30 = (r27 + r29) * 31;
        String r31 = this.m;
        if (r31 == null) goto L35;
        int r33 = r31.hashCode();
    L36:
        int r34 = (r30 + r33) * 31;
        Boolean r35 = this.n;
        if (r35 == null) goto L39;
        int r36 = r35.hashCode();
    L40:
        int r37 = (r34 + r36) * 31;
        k r38 = this.o;
        if (r38 == null) goto L43;
        int r39 = r38.hashCode();
    L44:
        int r40 = (r37 + r39) * 31;
        String r41 = this.p;
        if (r41 == null) goto L47;
        int r43 = r41.hashCode();
    L48:
        int r44 = (r40 + r43) * 31;
        GiftPanelIconSource r45 = this.q;
        if (r45 == null) goto L51;
        int r46 = r45.hashCode();
    L52:
        int r47 = (r44 + r46) * 31;
        Long r48 = this.r;
        if (r48 == null) goto L55;
        int r49 = r48.hashCode();
    L56:
        int r50 = (r47 + r49) * 31;
        f r51 = this.s;
        if (r51 == null) goto L59;
        int r53 = r51.hashCode();
    L60:
        int r54 = (r50 + r53) * 31;
        d r55 = this.t;
        if (r55 == null) goto L63;
        int r56 = r55.hashCode();
    L64:
        int r57 = (r54 + r56) * 31;
        a r58 = this.u;
        if (r58 == null) goto L67;
        int r59 = r58.hashCode();
    L68:
        int r60 = (r57 + r59) * 31;
        CardType r61 = this.v;
        if (r61 == null) goto L71;
        int r63 = r61.hashCode();
    L72:
        int r64 = (r60 + r63) * 31;
        boolean r65 = this.w;
        ?? r66 = r65;
        if (r65 == false) goto L75;
        r66 = 1;
    L75:
        int r67 = (r64 + r66) * 31;
        com.bytedance.android.livesdk.gift.platform.core.model.k r68 = this.x;
        if (r68 == null) goto L78;
        int r69 = r68.hashCode();
    L79:
        int r70 = (r67 + r69) * 31;
        boolean r71 = this.y;
        if (r71 == true) goto L83;
        r11 = r71;
    L83:
        int r73 = (r70 + r11) * 31;
        com.bytedance.android.livesdk.gift.platform.core.model.a r74 = this.z;
        if (r74 == null) goto L87;
        r1 = r74.hashCode();
    L87:
        return r73 + r1;
    L78:
        r69 = 0;
        goto L79
    L71:
        r63 = 0;
        goto L72
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
    L47:
        r43 = 0;
        goto L48
    L43:
        r39 = 0;
        goto L44
    L39:
        r36 = 0;
        goto L40
    L35:
        r33 = 0;
        goto L36
    L31:
        r29 = 0;
        goto L32
    L27:
        r26 = 0;
        goto L28
    L23:
        r23 = 0;
        goto L24
    L19:
        r19 = 0;
        goto L20
    L9:
        r6 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DialogIconModel(gift=" + this.a + ", id=" + this.b + ", image=" + this.c + ", expireTimeIntervalSeconds=" + this.d + ", isProp=" + this.e + ", isPropDummy=" + this.f + ", propInfo=" + this.g + ", diamondCount=" + this.h + ", groupCount=" + this.i + ", groupIndex=" + this.j + ", bottomInfo=" + this.k + ", unselectedMainText=" + this.l + ", unselectedSubText=" + this.m + ", unselectedLocked=" + this.n + ", giftIconImage=" + this.o + ", giftPanelName=" + this.p + ", giftPanelIconSource=" + this.q + ", giftRealDiamond=" + this.r + ", giftBottomLabelInfo=" + this.s + ", diyShowIconInfo=" + this.t + ", cardInfo=" + this.u + ", giftIconBuffType=" + this.v + ", shouldTouch=" + this.w + ", panelLocationInfo=" + this.x + ", forceInsertFromAi=" + this.y + ", aiRecommendInfoModel=" + this.z + ")";
    }

    public final boolean b() {
        return this.y;
    }

    public final h1 c() {
        return this.a;
    }

    public final long d() {
        return this.b;
    }

    public final h e() {
        return this.g;
    }

    public final boolean f() {
        return this.e;
    }

    public final void g(com.bytedance.android.livesdk.gift.platform.core.model.k r1) {
        this.x = r1;
    }

    public static e a(e r33, Pair r34, long r35, int r37, int r38, a r39, int r40) {
        if ((r40 & 1) == 0) goto L5;
        h1 r5 = r33.a;
    L7:
        if ((r40 & 2) == 0) goto L9;
        long r6 = r33.b;
    L11:
        if ((r40 & 4) == 0) goto L13;
        Pair r8 = r33.c;
    L15:
        if ((r40 & 8) == 0) goto L17;
        long r9 = r33.d;
    L19:
        if ((r40 & 16) == 0) goto L21;
        boolean r11 = r33.e;
    L23:
        if ((r40 & 32) == 0) goto L25;
        boolean r13 = r33.f;
    L27:
        if ((r40 & 64) == 0) goto L29;
        h r14 = r33.g;
    L31:
        if ((r40 & 128) == 0) goto L33;
        Long r15 = r33.h;
    L35:
        if ((r40 & 256) == 0) goto L37;
        int r16 = r33.i;
    L39:
        if ((r40 & 512) == 0) goto L41;
        int r17 = r33.j;
    L43:
        if ((r40 & 1024) == 0) goto L45;
        String r18 = r33.k;
    L47:
        if ((r40 & 2048) == 0) goto L49;
        String r19 = r33.l;
    L51:
        if ((r40 & 4096) == 0) goto L53;
        String r110 = r33.m;
    L55:
        if ((r40 & 8192) == 0) goto L57;
        Boolean r20 = r33.n;
    L59:
        if ((r40 & 16384) == 0) goto L61;
        k r21 = r33.o;
    L63:
        if ((32768 & r40) == 0) goto L65;
        String r2 = r33.p;
    L67:
        if ((r40 & 65536) == 0) goto L69;
        GiftPanelIconSource r3 = r33.q;
    L71:
        if ((r40 & 131072) == 0) goto L73;
        Long r24 = r33.r;
    L75:
        if ((262144 & r40) == 0) goto L77;
        f r25 = r33.s;
    L79:
        if ((524288 & r40) == 0) goto L81;
        d r4 = r33.t;
    L82:
        int r36 = r16;
        if ((r40 & 1048576) == 0) goto L85;
        a r111 = r33.u;
    L86:
        Long r310 = r15;
        if ((r40 & 2097152) == 0) goto L89;
        CardType r112 = r33.v;
    L91:
        if ((r40 & 4194304) == 0) goto L93;
        boolean r29 = r33.w;
    L95:
        if ((8388608 & r40) == 0) goto L97;
        com.bytedance.android.livesdk.gift.platform.core.model.k r30 = r33.x;
    L99:
        if ((16777216 & r40) == 0) goto L101;
        boolean r31 = r33.y;
    L103:
        if ((r40 & 33554432) == 0) goto L105;
        com.bytedance.android.livesdk.gift.platform.core.model.a r311 = r33.z;
    L106:
        Intrinsics.checkNotNullParameter(r5, "gift");
        Intrinsics.checkNotNullParameter(r8, "image");
        Intrinsics.checkNotNullParameter(r14, "propInfo");
        Intrinsics.checkNotNullParameter(r2, "giftPanelName");
        Intrinsics.checkNotNullParameter(r3, "giftPanelIconSource");
        Intrinsics.checkNotNullParameter(r4, "diyShowIconInfo");
        Intrinsics.checkNotNullParameter(r111, "cardInfo");
        Intrinsics.checkNotNullParameter(r112, "giftIconBuffType");
        boolean r113 = r13;
        a r27 = r111;
        String r23 = r2;
        GiftPanelIconSource r26 = r3;
        return new e(r5, r6, r8, r9, r11, r113, r14, r310, r36, r17, r18, r19, r110, r20, r21, r23, r26, r24, r25, r4, r27, r112, r29, r30, r31, r311);
    L105:
        r311 = null;
        goto L106
    L101:
        r31 = false;
        goto L103
    L97:
        r30 = null;
        goto L99
    L93:
        r29 = false;
        goto L95
    L89:
        r112 = null;
        goto L91
    L85:
        r111 = r39;
        goto L86
    L81:
        r4 = null;
        goto L82
    L77:
        r25 = null;
        goto L79
    L73:
        r24 = null;
        goto L75
    L69:
        r3 = null;
        goto L71
    L65:
        r2 = null;
        goto L67
    L61:
        r21 = null;
        goto L63
    L57:
        r20 = null;
        goto L59
    L53:
        r110 = null;
        goto L55
    L49:
        r19 = null;
        goto L51
    L45:
        r18 = null;
        goto L47
    L41:
        r17 = r38;
        goto L43
    L37:
        r16 = r37;
        goto L39
    L33:
        r15 = null;
        goto L35
    L29:
        r14 = null;
        goto L31
    L25:
        r13 = false;
        goto L27
    L21:
        r11 = false;
        goto L23
    L17:
        r9 = r35;
        goto L19
    L13:
        r8 = r34;
        goto L15
    L9:
        r6 = 0;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public e(h1 r35, long r36, Pair r38, long r39, boolean r41, boolean r43, h r44, Long r45, String r46, String r47, Boolean r48, k r49, String r410, GiftPanelIconSource r50, f r51, d r53, a r54, CardType r55, boolean r56, com.bytedance.android.livesdk.gift.platform.core.model.k r57, com.bytedance.android.livesdk.gift.platform.core.model.a r58, int r59) {
        if ((r59 & 2) == 0) goto L5;
        long r5 = r35.getId();
    L7:
        if ((r59 & 4) == 0) goto L9;
        Pair r7 = TuplesKt.to(-1, new i(null, r35.getImage(), null, null, 13));
    L11:
        if ((r59 & 8) == 0) goto L13;
        long r8 = r35.getGiftEndingTime() - ((System.currentTimeMillis() / 1000) - r35.getNowTimeDiffSeconds());
    L15:
        if ((r59 & 16) == 0) goto L17;
        boolean r10 = false;
    L19:
        if ((r59 & 32) == 0) goto L21;
        boolean r11 = false;
    L23:
        if ((r59 & 64) == 0) goto L25;
        h r13 = new h(0);
    L27:
        if ((r59 & 128) != 0) goto L29;
        Long r14 = r45;
    L38:
        if ((r59 & 256) == 0) goto L40;
        int r1 = 1;
    L42:
        if ((r59 & 512) == 0) goto L44;
        int r15 = -1;
    L46:
        if ((r59 & 1024) == 0) goto L50;
        r0 r2 = r35.getGiftUnselectedBottomInfo();
        if (r2 == null) goto L50;
        String r16 = r2.a();
    L52:
        if ((r59 & 2048) == 0) goto L54;
        String r17 = null;
    L56:
        if ((r59 & 4096) == 0) goto L58;
        String r18 = null;
    L60:
        if ((r59 & 8192) == 0) goto L62;
        Boolean r19 = Boolean.FALSE;
    L64:
        if ((r59 & 16384) == 0) goto L66;
        k r20 = r35.getImage();
    L68:
        if ((32768 & r59) == 0) goto L78;
        String r3 = r35.getName();
        if ((!TextUtils.isEmpty(r3)) == true) goto L73;
        r3 = null;
    L73:
        if (r3 != null) goto L75;
        r3 = r35.getDescribe();
    L75:
        if (r3 != null) goto L77;
        r3 = BuildConfig.FLAVOR;
    L77:
        String r21 = r3;
    L80:
        if ((65536 & r59) == 0) goto L82;
        GiftPanelIconSource r23 = GiftPanelIconSource.GIFT_LIST;
    L84:
        if ((131072 & r59) == 0) goto L86;
        Long r24 = r14;
    L88:
        if ((262144 & r59) == 0) goto L90;
        f r25 = null;
    L92:
        if ((524288 & r59) == 0) goto L94;
        d r26 = new d(null, null);
    L96:
        if ((1048576 & r59) == 0) goto L98;
        a r27 = new a(0, null, 0, null, false, null, null, 0, 255);
    L100:
        if ((2097152 & r59) == 0) goto L102;
        CardType r28 = CardType.None;
    L104:
        if ((4194304 & r59) == 0) goto L106;
        boolean r29 = false;
    L108:
        if ((8388608 & r59) == 0) goto L110;
        com.bytedance.android.livesdk.gift.platform.core.model.k r210 = null;
    L112:
        if ((r59 & 33554432) == 0) goto L114;
        com.bytedance.android.livesdk.gift.platform.core.model.a r31 = null;
    L115:
        this(r35, r5, r7, r8, r10, r11, r13, r14, r1, r15, r16, r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r29, r210, false, r31);
        return;
    L114:
        r31 = r58;
        goto L115
    L110:
        r210 = r57;
        goto L112
    L106:
        r29 = r56;
        goto L108
    L102:
        r28 = r55;
        goto L104
    L98:
        r27 = r54;
        goto L100
    L94:
        r26 = r53;
        goto L96
    L90:
        r25 = r51;
        goto L92
    L86:
        r24 = null;
        goto L88
    L82:
        r23 = r50;
        goto L84
    L78:
        r21 = r410;
        goto L80
    L66:
        r20 = r49;
        goto L68
    L62:
        r19 = r48;
        goto L64
    L58:
        r18 = r47;
        goto L60
    L54:
        r17 = r46;
    L50:
        r16 = null;
        goto L52
    L44:
        r15 = 0;
        goto L46
    L40:
        r1 = 0;
        goto L42
    L29:
        if (r35.getType() != 3) goto L31;
        r14 = null;
        goto L38
    L31:
        if (r10 == false) goto L34;
        if (r13 == null) goto L34;
        long r110 = r13.g;
    L35:
        r14 = Long.valueOf(r110);
    L34:
        r110 = r35.getDiamondCount();
        goto L35
    L25:
        r13 = r44;
        goto L27
    L21:
        r11 = r43;
        goto L23
    L17:
        r10 = r41;
        goto L19
    L13:
        r8 = r39;
        goto L15
    L9:
        r7 = r38;
        goto L11
    L5:
        r5 = r36;
        goto L7
    }

    public e(h1 r13, long r14, Pair<Integer, i> r15, long r16, boolean r18, boolean r19, h r20, Long r21, int r23, int r24, String r25, String r26, String r27, Boolean r28, k r29, String r210, GiftPanelIconSource r30, Long r31, f r33, d r34, a r35, CardType r36, boolean r37, com.bytedance.android.livesdk.gift.platform.core.model.k r38, boolean r39, com.bytedance.android.livesdk.gift.platform.core.model.a r310) {
        Intrinsics.checkNotNullParameter(r13, "gift");
        Intrinsics.checkNotNullParameter(r15, "image");
        Intrinsics.checkNotNullParameter(r20, "propInfo");
        Intrinsics.checkNotNullParameter(r210, "giftPanelName");
        Intrinsics.checkNotNullParameter(r30, "giftPanelIconSource");
        Intrinsics.checkNotNullParameter(r34, "diyShowIconInfo");
        Intrinsics.checkNotNullParameter(r35, "cardInfo");
        Intrinsics.checkNotNullParameter(r36, "giftIconBuffType");
        this.a = r13;
        this.b = r14;
        this.c = r15;
        this.d = r16;
        this.e = r18;
        this.f = r19;
        this.g = r20;
        this.h = r21;
        this.i = r23;
        this.j = r24;
        this.k = r25;
        this.l = r26;
        this.m = r27;
        this.n = r28;
        this.o = r29;
        this.p = r210;
        this.q = r30;
        this.r = r31;
        this.s = r33;
        this.t = r34;
        this.u = r35;
        this.v = r36;
        this.w = r37;
        this.x = r38;
        this.y = r39;
        this.z = r310;
    }
}
