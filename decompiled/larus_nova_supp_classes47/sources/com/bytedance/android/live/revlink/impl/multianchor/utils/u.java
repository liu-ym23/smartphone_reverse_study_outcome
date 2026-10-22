package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAnchorDataContext;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.b9;
import com.bytedance.android.livesdk.link.model.bridge.k2;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdk.link.model.r5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u implements n {
    public final int A;
    public final String B;
    public final List<String> C;
    public final int D;
    public final aa E;
    public final String F;
    public final boolean G;
    public final ArrayList<IBattleRivalTag> H;
    public final boolean I;
    public final PkDoubleAnchorDataContext.d J;
    public final boolean K;
    public final boolean L;
    public final IBattleConfigSetting M;
    public final String N;
    public final String O;
    public final long a;
    public final int b;
    public final String c;
    public final int d;
    public final String e;
    public final b7 f;
    public final String g;
    public final IRoom h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final int m;
    public final IBaseUser n;
    public final IRoom o;
    public final String p;
    public final String q;
    public final k2 r;
    public final String s;
    public final boolean t;
    public final String u;
    public final boolean v;
    public final Map<Long, b9> w;
    public final boolean x;
    public final boolean y;
    public final boolean z;

    public static final class a implements n {
        public String A;
        public List<String> B;
        public int C;
        public aa D;
        public String E;
        public boolean F;
        public boolean G;
        public final ArrayList<IBattleRivalTag> H;
        public boolean I;
        public PkDoubleAnchorDataContext.d J;
        public boolean K;
        public boolean L;
        public IBattleConfigSetting M;
        public String N;
        public int O;
        public String P;
        public String a;
        public long b;
        public int c;
        public String d;
        public b7 e;
        public String f;
        public int g;
        public String h;
        public String i;
        public String j;
        public IRoom k;
        public boolean l;
        public boolean m;
        public int n;
        public IBaseUser o;
        public IRoom p;
        public String q;
        public k2 r;
        public boolean s;
        public String t;
        public boolean u;
        public boolean v;
        public Map<Long, ? extends b9> w;
        public boolean x;
        public boolean y;
        public int z;

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final boolean o() {
            return false;
        }

        public final u r() {
            u r0 = new u(this);
            jy0.b.c("MultiLinkLaunchParameters", "snapshot: " + r0, null, 4);
            return r0;
        }

        public a() {
            this.a = "";
            this.h = "";
            this.i = "";
            this.m = true;
            this.t = "";
            this.A = "";
            this.H = new ArrayList();
            this.L = true;
            this.N = "";
            this.O = BizType.None.ordinal();
            this.P = "";
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final long G() {
            return this.b;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final String a() {
            return this.q;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final String c() {
            return this.i;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final boolean d() {
            return this.u;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final boolean e() {
            return this.s;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final String f() {
            return this.a;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final boolean g() {
            return this.I;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final String getActivityName() {
            return this.t;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final IBattleConfigSetting getBattleConfigSetting() {
            return this.M;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final List<String> getCannotPkAnchorIds() {
            return this.B;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final int getDuration() {
            return this.z;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final String getGameAppId() {
            return this.E;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final IRoom getGuestRoom() {
            return this.p;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final IBaseUser getGuestUser() {
            return this.o;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final int getInviteType() {
            return this.g;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final boolean getInviteeWithAudience() {
            return this.y;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final boolean getInviterWithAudience() {
            return this.x;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final Map<Long, b9> getLinkerContentMap() {
            return this.w;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final int getMatchType() {
            return this.c;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final int getPeakSwitchPlayMode() {
            return this.C;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final aa getPeakVoteSetting() {
            return this.D;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final String getRtcInfo() {
            return this.j;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final String getTheme() {
            return this.A;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final boolean h() {
            return this.v;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final boolean i() {
            return this.L;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final k2 j() {
            return this.r;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final boolean k() {
            return this.K;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final PkDoubleAnchorDataContext.d l() {
            return this.J;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final ArrayList<IBattleRivalTag> m() {
            return this.H;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final boolean n() {
            return this.G;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
        public final String y3() {
            return this.f;
        }

        public final void p(String r5) {
            Intrinsics.checkNotNullParameter(r5, "source");
            this.b = 0;
            this.c = 0;
            this.d = null;
            this.e = null;
            q(0);
            Intrinsics.checkNotNullParameter("", "<set-?>");
            this.h = "";
            this.f = null;
            Intrinsics.checkNotNullParameter("", "<set-?>");
            this.i = "";
            this.j = null;
            this.M = null;
            Intrinsics.checkNotNullParameter("", "<set-?>");
            this.N = "";
            this.c = 0;
            q(0);
            this.z = 0;
            Intrinsics.checkNotNullParameter("", "<set-?>");
            this.A = "";
            this.s = false;
            Intrinsics.checkNotNullParameter("", "<set-?>");
            this.t = "";
            this.q = null;
            this.o = null;
            this.p = null;
            this.J = null;
            this.K = false;
            this.F = false;
            this.E = null;
            this.y = false;
            this.x = false;
            this.w = null;
            this.H.clear();
            this.G = false;
            this.I = false;
            this.L = true;
            this.B = null;
            this.C = 0;
            this.D = null;
            jy0.b.c("ttlive_anchor_link", "MultiLinkLaunchParameters.Record reset from " + r5, null, 4);
        }

        public final void q(int r2) {
            this.g = r2;
            if (r2 != 1) goto L5;
        L12:
            String r3 = "mutual_follow";
        L13:
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            this.h = r3;
            return;
        L5:
            if (r2 != 2) goto L7;
        L11:
            r3 = "recommend";
            goto L13
        L7:
            if (r2 == 101) goto L12;
            if (r2 == 102) goto L11;
            r3 = UserListInviteType.a(r2, null);
            goto L13
        }

        public final void b(q5 r6, d11.a r7) {
            Intrinsics.checkNotNullParameter(r6, "replyResult");
            Intrinsics.checkNotNullParameter(r7, "replyParams");
            String r0 = r6.getLinkMicIdStr();
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L11;
            Object r2 = r6.getLinkMicId();
        L12:
            String r3 = String.valueOf(r2);
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            this.i = r3;
            this.j = r6.getRtcExtInfo();
            this.P = r6.getEventTrackingInfo();
            b7 r4 = r5.a(r6);
            Map<Long, ? extends b9> r5 = null;
            if (r4 != null) goto L15;
        L26:
            this.r = r6.getInviterVersionInfo();
            Intrinsics.checkNotNullParameter(r6, "$this$linkerContentMapEx");
            Map r8 = r6.getLinkerContentMap();
            if (r8 == null) goto L32;
            LinkedHashMap r9 = new LinkedHashMap(MapsKt.mapCapacity(r8.size()));
            Iterator r10 = r8.entrySet().iterator();
        L30:
            if (r10.hasNext() == false) goto L33;
            Map.Entry r12 = (Map.Entry) r10.next();
            r9.put(r12.getKey(), ((vh7.c) r12.getValue()).castTo(b9.class));
        L33:
            if (r9 == null) goto L39;
            LinkedHashMap r13 = new LinkedHashMap(MapsKt.mapCapacity(r9.size()));
            Iterator r14 = r9.entrySet().iterator();
        L36:
            if (r14.hasNext() == false) goto L38;
            Map.Entry r15 = (Map.Entry) r14.next();
            r13.put(Long.valueOf(((Number) r15.getKey()).longValue()), r15.getValue());
            goto L36
        L38:
            r5 = MapsKt.toMap(r13);
        L39:
            this.w = r5;
            this.L = false;
            return;
        L32:
            r9 = null;
            goto L33
        L15:
            if (r4.getUseMultiChannel() == false) goto L24;
            Map r16 = r4.getChannelMap();
            if (r16 == null) goto L24;
            Map r17 = MapsKt.toMap(r16);
            if (r17 == null) goto L24;
            if ((!r17.isEmpty()) != true) goto L24;
            this.e = r5.a(r6);
        L24:
            if (Intrinsics.areEqual(r7.j, this.d) == false) goto L26;
            this.d = null;
            goto L26
        L11:
            r2 = r6.getLinkMicIdStr();
            goto L12
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }
    }

    public u() {
        throw null;
    }

    public final int b() {
        if (this.i != BizType.PK.ordinal()) goto L5;
    L8:
        return 1;
    L5:
        if (this.i == BizType.OpenGame.ordinal()) goto L8;
        return 7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v101 */
    /* JADX WARN: Type inference failed for: r0v106 */
    /* JADX WARN: Type inference failed for: r0v107 */
    /* JADX WARN: Type inference failed for: r0v108 */
    /* JADX WARN: Type inference failed for: r0v110 */
    /* JADX WARN: Type inference failed for: r0v112 */
    /* JADX WARN: Type inference failed for: r0v119 */
    /* JADX WARN: Type inference failed for: r0v120 */
    /* JADX WARN: Type inference failed for: r0v121 */
    /* JADX WARN: Type inference failed for: r0v127 */
    /* JADX WARN: Type inference failed for: r0v128 */
    /* JADX WARN: Type inference failed for: r0v129 */
    /* JADX WARN: Type inference failed for: r0v130 */
    /* JADX WARN: Type inference failed for: r0v131 */
    /* JADX WARN: Type inference failed for: r0v132 */
    /* JADX WARN: Type inference failed for: r0v133 */
    /* JADX WARN: Type inference failed for: r0v134 */
    /* JADX WARN: Type inference failed for: r0v135 */
    /* JADX WARN: Type inference failed for: r0v136 */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r0v46, types: [int] */
    /* JADX WARN: Type inference failed for: r0v51, types: [int] */
    /* JADX WARN: Type inference failed for: r0v56, types: [int] */
    /* JADX WARN: Type inference failed for: r0v58, types: [int] */
    /* JADX WARN: Type inference failed for: r0v60, types: [int] */
    /* JADX WARN: Type inference failed for: r0v76, types: [int] */
    /* JADX WARN: Type inference failed for: r0v81, types: [int] */
    /* JADX WARN: Type inference failed for: r0v86, types: [int] */
    /* JADX WARN: Type inference failed for: r0v97 */
    /* JADX WARN: Type inference failed for: r0v99 */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
        String r2 = this.c;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (((r1 + r4) * 31) + this.d) * 31;
        String r6 = this.e;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        b7 r9 = this.f;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r12 = (r8 + r10) * 31;
        String r13 = this.g;
        if (r13 == null) goto L17;
        int r14 = r13.hashCode();
    L18:
        int r15 = (r12 + r14) * 31;
        IRoom r16 = this.h;
        if (r16 == null) goto L21;
        int r17 = r16.hashCode();
    L22:
        int r18 = (((r15 + r17) * 31) + this.i) * 31;
        boolean r19 = this.j;
        ?? r20 = 1;
        ?? r22 = r19;
        if (r19 == false) goto L25;
        r22 = 1;
    L25:
        int r23 = (r18 + r22) * 31;
        boolean r24 = this.k;
        ?? r25 = r24;
        if (r24 == false) goto L28;
        r25 = 1;
    L28:
        int r26 = (r23 + r25) * 31;
        boolean r27 = this.l;
        ?? r28 = r27;
        if (r27 == false) goto L31;
        r28 = 1;
    L31:
        int r29 = (((r26 + r28) * 31) + this.m) * 31;
        IBaseUser r30 = this.n;
        if (r30 == null) goto L34;
        int r32 = r30.hashCode();
    L35:
        int r33 = (r29 + r32) * 31;
        IRoom r34 = this.o;
        if (r34 == null) goto L38;
        int r35 = r34.hashCode();
    L39:
        int r36 = (r33 + r35) * 31;
        String r37 = this.p;
        if (r37 == null) goto L42;
        int r38 = r37.hashCode();
    L43:
        int r39 = (r36 + r38) * 31;
        String r40 = this.q;
        if (r40 == null) goto L46;
        int r42 = r40.hashCode();
    L47:
        int r43 = (r39 + r42) * 31;
        k2 r44 = this.r;
        if (r44 == null) goto L50;
        int r45 = r44.hashCode();
    L51:
        int r46 = (r43 + r45) * 31;
        String r47 = this.s;
        if (r47 == null) goto L54;
        int r48 = r47.hashCode();
    L55:
        int r49 = (r46 + r48) * 31;
        boolean r50 = this.t;
        ?? r52 = r50;
        if (r50 == false) goto L58;
        r52 = 1;
    L58:
        int r53 = (r49 + r52) * 31;
        String r54 = this.u;
        if (r54 == null) goto L61;
        int r55 = r54.hashCode();
    L62:
        int r56 = (r53 + r55) * 31;
        boolean r57 = this.v;
        ?? r58 = r57;
        if (r57 == false) goto L65;
        r58 = 1;
    L65:
        int r59 = (r56 + r58) * 31;
        Map<Long, b9> r60 = this.w;
        if (r60 == null) goto L68;
        int r62 = r60.hashCode();
    L69:
        int r63 = (r59 + r62) * 31;
        boolean r64 = this.x;
        ?? r65 = r64;
        if (r64 == false) goto L72;
        r65 = 1;
    L72:
        int r66 = (r63 + r65) * 31;
        boolean r67 = this.y;
        ?? r68 = r67;
        if (r67 == false) goto L75;
        r68 = 1;
    L75:
        int r69 = (r66 + r68) * 31;
        boolean r70 = this.z;
        ?? r72 = r70;
        if (r70 == false) goto L78;
        r72 = 1;
    L78:
        int r73 = (((r69 + r72) * 31) + this.A) * 31;
        String r74 = this.B;
        if (r74 == null) goto L81;
        int r75 = r74.hashCode();
    L82:
        int r76 = (r73 + r75) * 31;
        List<String> r77 = this.C;
        if (r77 == null) goto L85;
        int r78 = r77.hashCode();
    L86:
        int r79 = (((r76 + r78) * 31) + this.D) * 31;
        aa r80 = this.E;
        if (r80 == null) goto L89;
        int r82 = r80.hashCode();
    L90:
        int r83 = (r79 + r82) * 31;
        String r84 = this.F;
        if (r84 == null) goto L93;
        int r85 = r84.hashCode();
    L94:
        int r86 = (r83 + r85) * 31;
        boolean r87 = this.G;
        ?? r88 = r87;
        if (r87 == false) goto L97;
        r88 = 1;
    L97:
        int r89 = (r86 + r88) * 31;
        ArrayList<IBattleRivalTag> r90 = this.H;
        if (r90 == null) goto L100;
        int r92 = r90.hashCode();
    L101:
        int r93 = (r89 + r92) * 31;
        boolean r94 = this.I;
        ?? r95 = r94;
        if (r94 == false) goto L104;
        r95 = 1;
    L104:
        int r96 = (r93 + r95) * 31;
        PkDoubleAnchorDataContext.d r97 = this.J;
        if (r97 == null) goto L107;
        int r98 = r97.hashCode();
    L108:
        int r99 = (r96 + r98) * 31;
        boolean r100 = this.K;
        ?? r101 = r100;
        if (r100 == false) goto L111;
        r101 = 1;
    L111:
        int r102 = (r99 + r101) * 31;
        boolean r103 = this.L;
        if (r103 == true) goto L115;
        r20 = r103;
    L115:
        int r104 = (r102 + r20) * 31;
        IBattleConfigSetting r105 = this.M;
        if (r105 == null) goto L118;
        int r106 = r105.hashCode();
    L119:
        int r107 = (r104 + r106) * 31;
        String r108 = this.N;
        if (r108 == null) goto L122;
        int r109 = r108.hashCode();
    L123:
        int r110 = (r107 + r109) * 31;
        String r111 = this.O;
        if (r111 == null) goto L127;
        r3 = r111.hashCode();
    L127:
        return r110 + r3;
    L122:
        r109 = 0;
        goto L123
    L118:
        r106 = 0;
        goto L119
    L107:
        r98 = 0;
        goto L108
    L100:
        r92 = 0;
        goto L101
    L93:
        r85 = 0;
        goto L94
    L89:
        r82 = 0;
        goto L90
    L85:
        r78 = 0;
        goto L86
    L81:
        r75 = 0;
        goto L82
    L68:
        r62 = 0;
        goto L69
    L61:
        r55 = 0;
        goto L62
    L54:
        r48 = 0;
        goto L55
    L50:
        r45 = 0;
        goto L51
    L46:
        r42 = 0;
        goto L47
    L42:
        r38 = 0;
        goto L43
    L38:
        r35 = 0;
        goto L39
    L34:
        r32 = 0;
        goto L35
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
        return "MultiLinkLaunchParameters(channelID=" + this.a + ", matchType=" + this.b + ", linkerID='" + this.c + "', inviteType=" + this.d + ", inviteeList='" + this.e + "', multiChannelInfo=" + this.f + ", rtcInfo=" + this.g + ", room=" + this.h + ", toBizType=" + this.i + ", supportMultiInvite=" + this.j + ", linkFromPkMultiInvite=" + this.k + ", isFirstInvite=" + this.l + ", inviteMaxNum=" + this.m + ", guestUser=" + this.n + ", guestRoom=" + this.o + ", guestUserId=" + this.p + ", guestLinkerID=" + this.q + ", guestUserVersion=" + this.r + ", inviteeID=" + this.s + ", isActivityPk=" + this.t + ", activityName='" + this.u + "', isStarter=" + this.v + ", linkerContentMap=" + this.w + ", mySelfHasAudience=" + this.x + ", inviterWithAudience=" + this.y + ", inviteeWithAudience=" + this.z + ", duration=" + this.A + ", theme='" + this.B + "', cannotPkAnchorIds=" + this.C + ", peakSwitchPlayMode=" + this.D + ", peakVoteSetting=" + this.E + ", gameAppId=" + this.F + ", isRandomReMatch=" + this.G + ", pkBattleRivalTags=" + this.H + ", isInviteVote=" + this.I + ", voteOpenData=" + this.J + ", isBreakThrough=" + this.K + ", isRealOrganizer=" + this.L + ", battleConfigSetting=" + this.M + ", battleAttachedInfo='" + this.N + "', classicScene=" + b() + ')';
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final long G() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final String a() {
        return this.p;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final String c() {
        return this.c;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final boolean d() {
        return this.v;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final boolean e() {
        return this.t;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final String f() {
        return this.q;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final boolean g() {
        return this.I;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final String getActivityName() {
        return this.u;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final IBattleConfigSetting getBattleConfigSetting() {
        return this.M;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final List<String> getCannotPkAnchorIds() {
        return this.C;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final int getDuration() {
        return this.A;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final String getGameAppId() {
        return this.F;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final IRoom getGuestRoom() {
        return this.o;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final IBaseUser getGuestUser() {
        return this.n;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final int getInviteType() {
        return this.d;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final boolean getInviteeWithAudience() {
        return this.z;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final boolean getInviterWithAudience() {
        return this.y;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final Map<Long, b9> getLinkerContentMap() {
        return this.w;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final int getMatchType() {
        return this.b;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final int getPeakSwitchPlayMode() {
        return this.D;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final aa getPeakVoteSetting() {
        return this.E;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final String getRtcInfo() {
        return this.g;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final String getTheme() {
        return this.B;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final boolean h() {
        return this.x;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final boolean i() {
        return this.L;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final k2 j() {
        return this.r;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final boolean k() {
        return this.K;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final PkDoubleAnchorDataContext.d l() {
        return this.J;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final ArrayList<IBattleRivalTag> m() {
        return this.H;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final boolean n() {
        return this.G;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final boolean o() {
        return this.k;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.utils.n
    public final String y3() {
        return this.s;
    }

    public u(a r43) {
        long r2 = r43.b;
        int r4 = r43.c;
        String r5 = r43.i;
        int r6 = r43.g;
        String r7 = r43.h;
        b7 r8 = r43.e;
        String r9 = r43.j;
        IRoom r10 = r43.k;
        int r12 = r43.O;
        boolean r13 = r43.l;
        boolean r14 = r43.m;
        int r15 = r43.n;
        IBaseUser r16 = r43.o;
        IRoom r17 = r43.p;
        String r18 = r43.q;
        String r19 = r43.a;
        k2 r110 = r43.r;
        String r111 = r43.f;
        boolean r112 = r43.s;
        String r113 = r43.t;
        boolean r114 = r43.u;
        Map<Long, ? extends b9> r115 = r43.w;
        boolean r116 = r43.v;
        boolean r117 = r43.x;
        boolean r118 = r43.y;
        int r119 = r43.z;
        String r120 = r43.A;
        List<String> r121 = r43.B;
        int r122 = r43.C;
        aa r123 = r43.D;
        String r124 = r43.E;
        boolean r125 = r43.G;
        ArrayList<IBattleRivalTag> r126 = r43.H;
        boolean r127 = r43.I;
        PkDoubleAnchorDataContext.d r128 = r43.J;
        boolean r129 = r43.K;
        boolean r130 = r43.L;
        IBattleConfigSetting r131 = r43.M;
        String r132 = r43.N;
        String r1 = r43.P;
        Intrinsics.checkNotNullParameter(r5, "linkerID");
        Intrinsics.checkNotNullParameter(r7, "inviteeList");
        Intrinsics.checkNotNullParameter(r113, "activityName");
        Intrinsics.checkNotNullParameter(r120, FileUtils.PICTURE_THEME);
        Intrinsics.checkNotNullParameter(r126, "pkBattleRivalTags");
        Intrinsics.checkNotNullParameter(r132, "battleAttachedInfo");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r12;
        this.j = r13;
        this.k = false;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r110;
        this.s = r111;
        this.t = r112;
        this.u = r113;
        this.v = r114;
        this.w = r115;
        this.x = r116;
        this.y = r117;
        this.z = r118;
        this.A = r119;
        this.B = r120;
        this.C = r121;
        this.D = r122;
        this.E = r123;
        this.F = r124;
        this.G = r125;
        this.H = r126;
        this.I = r127;
        this.J = r128;
        this.K = r129;
        this.L = r130;
        this.M = r131;
        this.N = r132;
        this.O = r1;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof u) == false) goto L88;
        u r7 = (u) r6;
        if (this.a == r7.a) goto L8;
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
        if (this.i == r7.i) goto L24;
        return false;
    L24:
        if (this.j == r7.j) goto L26;
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
        if (Intrinsics.areEqual(this.q, r7.q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.r, r7.r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.s, r7.s) == true) goto L44;
        return false;
    L44:
        if (this.t == r7.t) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.u, r7.u) == true) goto L48;
        return false;
    L48:
        if (this.v == r7.v) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.w, r7.w) == true) goto L52;
        return false;
    L52:
        if (this.x == r7.x) goto L54;
        return false;
    L54:
        if (this.y == r7.y) goto L56;
        return false;
    L56:
        if (this.z == r7.z) goto L58;
        return false;
    L58:
        if (this.A == r7.A) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.B, r7.B) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.C, r7.C) == true) goto L64;
        return false;
    L64:
        if (this.D == r7.D) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.E, r7.E) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.F, r7.F) == true) goto L70;
        return false;
    L70:
        if (this.G == r7.G) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.H, r7.H) == true) goto L74;
        return false;
    L74:
        if (this.I == r7.I) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.J, r7.J) == true) goto L78;
        return false;
    L78:
        if (this.K == r7.K) goto L80;
        return false;
    L80:
        if (this.L == r7.L) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.M, r7.M) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.N, r7.N) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.O, r7.O) == true) goto L133;
        return false;
    L133:
        return true;
    L88:
        return false;
    }
}
