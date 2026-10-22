package b3a;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SceneModel;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;
import z2a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public final String A;
    public final String B;
    public final String C;
    public final String D;
    public final String E;
    public final Context F;
    public final Integer G;
    public final Bundle H;
    public final String I;
    public final String J;
    public final String K;
    public final String L;
    public final String M;
    public SceneModel N;
    public String O;
    public final Fragment a;
    public final String b;
    public final String c;
    public final Long d;
    public final BotModel e;
    public final RecommendFrom f;
    public final String g;
    public final String h;
    public final String i;
    public final e j;
    public final boolean k;
    public final SearchMobParam l;
    public final String m;
    public final by7.e n;
    public final String o;
    public final String p;
    public final int q;
    public final SceneModel r;
    public final String s;
    public final String t;
    public final String u;
    public final String v;
    public final String w;
    public final String x;
    public final String y;
    public final String z;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
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
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
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
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r6.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r6.y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r6.z) == true) goto L87;
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
        if (Intrinsics.areEqual(this.D, r6.D) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.E, r6.E) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.F, r6.F) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.G, r6.G) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.H, r6.H) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.I, r6.I) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.J, r6.J) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.K, r6.K) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.L, r6.L) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.M, r6.M) == true) goto L125;
        return false;
    L125:
        return true;
    }

    public final int hashCode() {
        Fragment r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        BotModel r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        RecommendFrom r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (((((((r15 + r17) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        e r19 = this.j;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        if (this.k == false) goto L33;
        int r22 = 1231;
    L34:
        int r23 = (r21 + r22) * 31;
        SearchMobParam r24 = this.l;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        String r27 = this.m;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        int r29 = (r26 + r28) * 31;
        by7.e r30 = this.n;
        if (r30 != null) goto L45;
        int r31 = 0;
    L46:
        int r32 = (r29 + r31) * 31;
        String r33 = this.o;
        if (r33 != null) goto L49;
        int r34 = 0;
    L50:
        int r35 = (r32 + r34) * 31;
        String r36 = this.p;
        if (r36 != null) goto L53;
        int r37 = 0;
    L54:
        int r38 = (((r35 + r37) * 31) + this.q) * 31;
        SceneModel r39 = this.r;
        if (r39 != null) goto L57;
        int r40 = 0;
    L58:
        int r41 = (((((r38 + r40) * 31) + this.s.hashCode()) * 31) + this.t.hashCode()) * 31;
        String r42 = this.u;
        if (r42 != null) goto L61;
        int r43 = 0;
    L62:
        int r44 = (r41 + r43) * 31;
        String r45 = this.v;
        if (r45 != null) goto L65;
        int r46 = 0;
    L66:
        int r47 = (r44 + r46) * 31;
        String r48 = this.w;
        if (r48 != null) goto L69;
        int r49 = 0;
    L70:
        int r50 = (r47 + r49) * 31;
        String r51 = this.x;
        if (r51 != null) goto L73;
        int r52 = 0;
    L74:
        int r53 = (r50 + r52) * 31;
        String r54 = this.y;
        if (r54 != null) goto L77;
        int r55 = 0;
    L78:
        int r56 = (r53 + r55) * 31;
        String r57 = this.z;
        if (r57 != null) goto L81;
        int r58 = 0;
    L82:
        int r59 = (r56 + r58) * 31;
        String r60 = this.A;
        if (r60 != null) goto L85;
        int r61 = 0;
    L86:
        int r62 = (r59 + r61) * 31;
        String r63 = this.B;
        if (r63 != null) goto L89;
        int r64 = 0;
    L90:
        int r65 = (r62 + r64) * 31;
        String r66 = this.C;
        if (r66 != null) goto L93;
        int r67 = 0;
    L94:
        int r68 = (r65 + r67) * 31;
        String r69 = this.D;
        if (r69 != null) goto L97;
        int r70 = 0;
    L98:
        int r71 = (r68 + r70) * 31;
        String r72 = this.E;
        if (r72 != null) goto L101;
        int r73 = 0;
    L102:
        int r74 = (r71 + r73) * 31;
        Context r75 = this.F;
        if (r75 != null) goto L105;
        int r76 = 0;
    L106:
        int r77 = (r74 + r76) * 31;
        Integer r78 = this.G;
        if (r78 != null) goto L109;
        int r79 = 0;
    L110:
        int r80 = (r77 + r79) * 31;
        Bundle r81 = this.H;
        if (r81 != null) goto L113;
        int r82 = 0;
    L114:
        int r83 = (r80 + r82) * 31;
        String r84 = this.I;
        if (r84 != null) goto L117;
        int r85 = 0;
    L118:
        int r86 = (r83 + r85) * 31;
        String r87 = this.J;
        if (r87 != null) goto L121;
        int r88 = 0;
    L122:
        int r89 = (r86 + r88) * 31;
        String r90 = this.K;
        if (r90 != null) goto L125;
        int r91 = 0;
    L126:
        int r92 = (r89 + r91) * 31;
        String r93 = this.L;
        if (r93 != null) goto L129;
        int r94 = 0;
    L130:
        int r95 = (r92 + r94) * 31;
        String r96 = this.M;
        if (r96 == null) goto L135;
        r1 = r96.hashCode();
    L135:
        return r95 + r1;
    L129:
        r94 = r93.hashCode();
        goto L130
    L125:
        r91 = r90.hashCode();
        goto L126
    L121:
        r88 = r87.hashCode();
        goto L122
    L117:
        r85 = r84.hashCode();
        goto L118
    L113:
        r82 = r81.hashCode();
        goto L114
    L109:
        r79 = r78.hashCode();
        goto L110
    L105:
        r76 = r75.hashCode();
        goto L106
    L101:
        r73 = r72.hashCode();
        goto L102
    L97:
        r70 = r69.hashCode();
        goto L98
    L93:
        r67 = r66.hashCode();
        goto L94
    L89:
        r64 = r63.hashCode();
        goto L90
    L85:
        r61 = r60.hashCode();
        goto L86
    L81:
        r58 = r57.hashCode();
        goto L82
    L77:
        r55 = r54.hashCode();
        goto L78
    L73:
        r52 = r51.hashCode();
        goto L74
    L69:
        r49 = r48.hashCode();
        goto L70
    L65:
        r46 = r45.hashCode();
        goto L66
    L61:
        r43 = r42.hashCode();
        goto L62
    L57:
        r40 = r39.hashCode();
        goto L58
    L53:
        r37 = r36.hashCode();
        goto L54
    L49:
        r34 = r33.hashCode();
        goto L50
    L45:
        r31 = r30.hashCode();
        goto L46
    L41:
        r28 = r27.hashCode();
        goto L42
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = 1237;
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
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "StartCallPayLoadBean(sourceFragment=" + this.a + ", conversationId=" + this.b + ", convLastSectionId=" + this.c + ", convLastMessageIndex=" + this.d + ", currentBot=" + this.e + ", recommendFrom=" + this.f + ", chatType=" + this.g + ", enterFrom=" + this.h + ", enterMethod=" + this.i + ", onJumpAction=" + this.j + ", hasRedDot=" + this.k + ", searchMobParam=" + this.l + ", secScene=" + this.m + ", trackNode=" + this.n + ", fromActivityName=" + this.o + ", fromActivityModule=" + this.p + ", targetSceneId=" + this.q + ", targetSceneModel=" + this.r + ", subCoCoConvFirstMetType=" + this.s + ", subCoCoConvSourceMsgInfo=" + this.t + ", actionBarRecommendFrom=" + this.u + ", actionBarRecommendReqId=" + this.v + ", actionBarItemId=" + this.w + ", actionBarKey=" + this.x + ", botSayHelloTextKey=" + this.y + ", triggerHello=" + this.z + ", openVlm=" + this.A + ", caseId=" + this.B + ", caseRequestId=" + this.C + ", caseRecommendFrom=" + this.D + ", videoCallEnterMethod=" + this.E + ", context=" + this.F + ", extraOpenFlags=" + this.G + ", extraBundle=" + this.H + ", trackParams=" + this.I + ", callId=" + this.J + ", downgradeEntrance=" + this.K + ", sessionExtraJsonStr=" + this.L + ", conversationProjectId=" + this.M + ')';
    }

    public final Context getContext() {
        return this.F;
    }

    public static c a(c r44, String r45, int r46, SceneModel r47, String r48, String r49, String r50, String r51, int r52, int r53) {
        if ((r52 & 1) == 0) goto L5;
        Fragment r5 = r44.a;
    L7:
        if ((r52 & 2) == 0) goto L9;
        String r6 = r44.b;
    L11:
        if ((r52 & 4) == 0) goto L13;
        String r7 = r44.c;
    L15:
        if ((r52 & 8) == 0) goto L17;
        Long r8 = r44.d;
    L19:
        if ((r52 & 16) == 0) goto L21;
        BotModel r9 = r44.e;
    L23:
        if ((r52 & 32) == 0) goto L25;
        RecommendFrom r10 = r44.f;
    L27:
        if ((r52 & 64) == 0) goto L29;
        String r11 = r44.g;
    L31:
        if ((r52 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L33;
        String r12 = r44.h;
    L35:
        if ((r52 & 256) == 0) goto L37;
        String r13 = r44.i;
    L39:
        if ((r52 & 512) == 0) goto L41;
        e r14 = r44.j;
    L43:
        if ((r52 & 1024) == 0) goto L45;
        boolean r15 = r44.k;
    L47:
        if ((r52 & 2048) == 0) goto L49;
        SearchMobParam r16 = r44.l;
    L51:
        if ((r52 & 4096) == 0) goto L53;
        String r17 = r44.m;
    L55:
        if ((r52 & 8192) == 0) goto L57;
        by7.e r18 = r44.n;
    L59:
        if ((r52 & 16384) == 0) goto L61;
        String r19 = r44.o;
    L63:
        if ((32768 & r52) == 0) goto L65;
        String r20 = r44.p;
    L67:
        if ((65536 & r52) == 0) goto L69;
        int r21 = r44.q;
    L71:
        if ((131072 & r52) == 0) goto L73;
        SceneModel r22 = r44.r;
    L75:
        if ((262144 & r52) == 0) goto L77;
        String r2 = r44.s;
    L79:
        if ((524288 & r52) == 0) goto L81;
        String r4 = r44.t;
    L83:
        if ((r52 & 1048576) == 0) goto L85;
        String r25 = r44.u;
    L87:
        if ((2097152 & r52) == 0) goto L89;
        String r26 = r44.v;
    L91:
        if ((4194304 & r52) == 0) goto L93;
        String r27 = r44.w;
    L95:
        if ((8388608 & r52) == 0) goto L97;
        String r28 = r44.x;
    L99:
        if ((16777216 & r52) == 0) goto L101;
        String r29 = r44.y;
    L103:
        if ((33554432 & r52) == 0) goto L105;
        String r30 = r44.z;
    L107:
        if ((67108864 & r52) == 0) goto L109;
        String r31 = r44.A;
    L111:
        if ((134217728 & r52) == 0) goto L113;
        String r32 = r44.B;
    L115:
        if ((268435456 & r52) == 0) goto L117;
        String r33 = r44.C;
    L119:
        if ((536870912 & r52) == 0) goto L121;
        String r34 = r44.D;
    L123:
        if ((1073741824 & r52) == 0) goto L125;
        String r35 = r44.E;
    L127:
        if ((r52 & Integer.MIN_VALUE) == 0) goto L129;
        Context r36 = r44.F;
    L131:
        if ((r53 & 1) == 0) goto L133;
        Integer r37 = r44.G;
    L135:
        if ((r53 & 2) == 0) goto L137;
        Bundle r38 = r44.H;
    L139:
        if ((r53 & 4) == 0) goto L141;
        String r39 = r44.I;
    L143:
        if ((r53 & 8) == 0) goto L145;
        String r40 = r44.J;
    L147:
        if ((r53 & 16) == 0) goto L149;
        String r41 = r44.K;
    L151:
        if ((r53 & 32) == 0) goto L153;
        String r42 = r44.L;
    L155:
        if ((r53 & 64) == 0) goto L157;
        String r43 = r44.M;
    L158:
        r44.getClass();
        Intrinsics.checkNotNullParameter(r11, "chatType");
        Intrinsics.checkNotNullParameter(r12, "enterFrom");
        Intrinsics.checkNotNullParameter(r13, "enterMethod");
        Intrinsics.checkNotNullParameter(r2, "subCoCoConvFirstMetType");
        Intrinsics.checkNotNullParameter(r4, "subCoCoConvSourceMsgInfo");
        String r23 = r2;
        return new c(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r4, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43);
    L157:
        r43 = null;
        goto L158
    L153:
        r42 = null;
        goto L155
    L149:
        r41 = r51;
        goto L151
    L145:
        r40 = r50;
        goto L147
    L141:
        r39 = null;
        goto L143
    L137:
        r38 = null;
        goto L139
    L133:
        r37 = null;
        goto L135
    L129:
        r36 = null;
        goto L131
    L125:
        r35 = r49;
        goto L127
    L121:
        r34 = null;
        goto L123
    L117:
        r33 = null;
        goto L119
    L113:
        r32 = null;
        goto L115
    L109:
        r31 = r48;
        goto L111
    L105:
        r30 = null;
        goto L107
    L101:
        r29 = null;
        goto L103
    L97:
        r28 = null;
        goto L99
    L93:
        r27 = null;
        goto L95
    L89:
        r26 = null;
        goto L91
    L85:
        r25 = null;
        goto L87
    L81:
        r4 = null;
        goto L83
    L77:
        r2 = null;
        goto L79
    L73:
        r22 = r47;
        goto L75
    L69:
        r21 = r46;
        goto L71
    L65:
        r20 = null;
        goto L67
    L61:
        r19 = null;
        goto L63
    L57:
        r18 = null;
        goto L59
    L53:
        r17 = null;
        goto L55
    L49:
        r16 = null;
        goto L51
    L45:
        r15 = false;
        goto L47
    L41:
        r14 = null;
        goto L43
    L37:
        r13 = r45;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = null;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = null;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = null;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public /* synthetic */ c(Fragment r44, String r45, String r46, Long r47, BotModel r48, RecommendFrom r49, String r50, String r51, String r52, e r53, boolean r54, SearchMobParam r55, String r56, by7.e r57, String r58, String r59, int r60, SceneModel r61, String r62, String r63, String r64, String r65, String r66, String r67, String r68, String r69, String r70, String r71, String r72, String r73, Context r74, Integer r75, Bundle r76, String r77, String r78, String r79, int r80, int r81) {
        if ((r80 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L5;
        String r11 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        if ((r80 & 256) == 0) goto L9;
        String r12 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        if ((r80 & 512) == 0) goto L13;
        e r13 = null;
    L15:
        if ((r80 & 1024) == 0) goto L17;
        boolean r14 = false;
    L19:
        if ((r80 & 2048) == 0) goto L21;
        SearchMobParam r15 = null;
    L23:
        if ((r80 & 4096) == 0) goto L25;
        String r16 = null;
    L27:
        if ((r80 & 8192) == 0) goto L29;
        by7.e r17 = null;
    L31:
        if ((r80 & 16384) == 0) goto L33;
        String r18 = null;
    L35:
        if ((32768 & r80) == 0) goto L37;
        String r19 = null;
    L39:
        if ((65536 & r80) == 0) goto L41;
        int r20 = -1;
    L43:
        if ((131072 & r80) == 0) goto L45;
        SceneModel r21 = null;
    L47:
        if ((262144 & r80) == 0) goto L49;
        String r22 = NameKeys.UnloadStrategy_No_Strategy;
    L51:
        if ((524288 & r80) == 0) goto L53;
        String r23 = NameKeys.UnloadStrategy_No_Strategy;
    L55:
        if ((1048576 & r80) == 0) goto L57;
        String r24 = null;
    L59:
        if ((2097152 & r80) == 0) goto L61;
        String r25 = null;
    L63:
        if ((4194304 & r80) == 0) goto L65;
        String r26 = null;
    L67:
        if ((8388608 & r80) == 0) goto L69;
        String r27 = null;
    L71:
        if ((16777216 & r80) == 0) goto L73;
        String r28 = null;
    L75:
        if ((33554432 & r80) == 0) goto L77;
        String r29 = null;
    L79:
        if ((67108864 & r80) == 0) goto L81;
        String r30 = null;
    L83:
        if ((134217728 & r80) == 0) goto L85;
        String r31 = null;
    L87:
        if ((268435456 & r80) == 0) goto L89;
        String r32 = null;
    L91:
        if ((536870912 & r80) == 0) goto L93;
        String r33 = null;
    L95:
        if ((r80 & Integer.MIN_VALUE) == 0) goto L97;
        Context r35 = null;
    L99:
        if ((r81 & 1) == 0) goto L101;
        Integer r36 = null;
    L103:
        if ((r81 & 2) == 0) goto L105;
        Bundle r37 = null;
    L107:
        if ((r81 & 4) == 0) goto L109;
        String r38 = null;
    L111:
        if ((r81 & 32) == 0) goto L113;
        String r41 = null;
    L115:
        if ((r81 & 64) == 0) goto L117;
        String r42 = null;
    L118:
        this(r44, r45, r46, r47, r48, r49, r50, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, null, r35, r36, r37, r38, null, null, r41, r42);
        return;
    L117:
        r42 = r79;
        goto L118
    L113:
        r41 = r78;
        goto L115
    L109:
        r38 = r77;
        goto L111
    L105:
        r37 = r76;
        goto L107
    L101:
        r36 = r75;
        goto L103
    L97:
        r35 = r74;
        goto L99
    L93:
        r33 = r73;
        goto L95
    L89:
        r32 = r72;
        goto L91
    L85:
        r31 = r71;
        goto L87
    L81:
        r30 = r70;
        goto L83
    L77:
        r29 = r69;
        goto L79
    L73:
        r28 = r68;
        goto L75
    L69:
        r27 = r67;
        goto L71
    L65:
        r26 = r66;
        goto L67
    L61:
        r25 = r65;
        goto L63
    L57:
        r24 = r64;
        goto L59
    L53:
        r23 = r63;
        goto L55
    L49:
        r22 = r62;
        goto L51
    L45:
        r21 = r61;
        goto L47
    L41:
        r20 = r60;
        goto L43
    L37:
        r19 = r59;
        goto L39
    L33:
        r18 = r58;
        goto L35
    L29:
        r17 = r57;
        goto L31
    L25:
        r16 = r56;
        goto L27
    L21:
        r15 = r55;
        goto L23
    L17:
        r14 = r54;
        goto L19
    L13:
        r13 = r53;
        goto L15
    L9:
        r12 = r52;
        goto L11
    L5:
        r11 = r51;
        goto L7
    }

    public c(Fragment r8, String r9, String r10, Long r11, BotModel r12, RecommendFrom r13, String r14, String r15, String r16, e r17, boolean r18, SearchMobParam r19, String r20, by7.e r21, String r22, String r23, int r24, SceneModel r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, Context r39, Integer r40, Bundle r41, String r42, String r43, String r44, String r45, String r46) {
        Intrinsics.checkNotNullParameter(r14, "chatType");
        Intrinsics.checkNotNullParameter(r15, "enterFrom");
        Intrinsics.checkNotNullParameter(r16, "enterMethod");
        Intrinsics.checkNotNullParameter(r26, "subCoCoConvFirstMetType");
        Intrinsics.checkNotNullParameter(r27, "subCoCoConvSourceMsgInfo");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r19;
        this.m = r20;
        this.n = r21;
        this.o = r22;
        this.p = r23;
        this.q = r24;
        this.r = r25;
        this.s = r26;
        this.t = r27;
        this.u = r28;
        this.v = r29;
        this.w = r30;
        this.x = r31;
        this.y = r32;
        this.z = r33;
        this.A = r34;
        this.B = r35;
        this.C = r36;
        this.D = r37;
        this.E = r38;
        this.F = r39;
        this.G = r40;
        this.H = r41;
        this.I = r42;
        this.J = r43;
        this.K = r44;
        this.L = r45;
        this.M = r46;
    }
}
