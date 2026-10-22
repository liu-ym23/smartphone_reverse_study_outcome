package f21;

import com.bytedance.android.live.revlink.impl.global.c;
import com.bytedance.android.live.revlink.impl.multianchor.AnchorLinkInitType;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e;
import com.bytedance.android.live.revlink.impl.multianchor.utils.g;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.d7;
import com.bytedance.android.livesdk.link.model.m;
import com.bytedance.android.livesdk.link.model.o9;
import com.bytedance.android.livesdk.link.model.x6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final boolean a;
    public final c b;
    public final AnchorLinkInitType c;
    public final int d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final int l;
    public final String m;
    public final String n;
    public final C0236a o;
    public final d7 p;
    public final v1 q;
    public final g r;
    public final long s;
    public final m t;

    /* JADX INFO: renamed from: f21.a$a, reason: collision with other inner class name */
    public static final class C0236a {
        public final int a;
        public final boolean b;
        public final IBattleConfigSetting c;
        public final int d;
        public final x6 e;
        public final o9 f;

        public C0236a() {
            this(0, false, null, 0, null, 63);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0236a) == false) goto L18;
            C0236a r4 = (C0236a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        public final int hashCode() {
            int r0 = this.a * 31;
            boolean r1 = this.b;
            ?? r2 = r1;
            if (r1 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = (r0 + r2) * 31;
            IBattleConfigSetting r4 = this.c;
            int r5 = 0;
            if (r4 == null) goto L8;
            int r6 = r4.hashCode();
        L9:
            int r7 = (((r3 + r6) * 31) + this.d) * 31;
            x6 r8 = this.e;
            if (r8 == null) goto L12;
            int r9 = r8.hashCode();
        L13:
            int r10 = (r7 + r9) * 31;
            o9 r12 = this.f;
            if (r12 == null) goto L17;
            r5 = r12.hashCode();
        L17:
            return r10 + r5;
        L12:
            r9 = 0;
            goto L13
        L8:
            r6 = 0;
            goto L9
        }

        public final String toString() {
            return "Extra(multiPkMode=" + this.a + ", firstFrameOpt=" + this.b + ", battleConfigSetting=" + this.c + ", inviterFromScene=" + this.d + ", multiAnchorExtra=" + this.e + ", switchSceneData=" + this.f + ")";
        }

        public C0236a(int r4, boolean r5, IBattleConfigSetting r6, int r7, o9 r8, int r9) {
            if ((r9 & 1) == 0) goto L6;
            r4 = 0;
        L6:
            if ((r9 & 2) == 0) goto L9;
            r5 = false;
        L9:
            if ((r9 & 4) == 0) goto L12;
            r6 = null;
        L12:
            if ((r9 & 8) == 0) goto L15;
            r7 = 0;
        L15:
            if ((r9 & 32) == 0) goto L17;
            r8 = null;
        L17:
            this.a = r4;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = null;
            this.f = r8;
        }
    }

    public final boolean a() {
        AnchorLinkInitType r0 = this.c;
        if (r0 != AnchorLinkInitType.REPLY_AGREE_API) goto L5;
    L10:
        return true;
    L5:
        if (r0 == AnchorLinkInitType.REPLY_AGREE_MSG) goto L10;
        if (r0 == AnchorLinkInitType.PERMIT_AGREE_MSG) goto L10;
        return false;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("AnchorConnectionContext{Type=");
        r0.append(this.c);
        r0.append(", connectionRoleType=");
        r0.append(this.l);
        r0.append(", matchType=");
        r0.append(this.d);
        r0.append(", inviteeList=");
        r0.append(this.e);
        r0.append(", pkSwitchToLink=");
        r0.append(this.f);
        r0.append(", switchChannel=");
        r0.append(this.j);
        r0.append(", multiToMulti=");
        r0.append(this.k);
        r0.append(", linkFromPkMultiInvite=");
        r0.append(this.h);
        r0.append(", connectionType=");
        r0.append(this.m);
        r0.append(", uiLayout=");
        m r2 = this.t;
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = ef2.a.c(r2);
    L6:
        r0.append(r4);
        r0.append(", extra={, multiPkMode=");
        r0.append(this.o.a);
        r0.append(", multiAnchorExtra=");
        x6 r5 = this.o.e;
        if (r5 == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, "$this$toSimpleString");
        String r1 = "MultiAnchorExtra{inviteRole=" + r5.getInviteRole() + ", matchType=" + r5.getMatchType() + ", roleMap=" + r5.getRoleLinkMicMap() + '}';
    L10:
        r0.append(r1);
        r0.append(", inviterFromScene=");
        r0.append(this.o.d);
        r0.append(", battleSetting=");
        IBattleConfigSetting r6 = this.o.c;
        if (r6 == null) goto L13;
        r3 = ef2.a.c(r6);
    L13:
        r0.append(r3);
        r0.append("}}");
        return r0.toString();
    L9:
        r1 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final boolean b() {
        if (c() == true) goto L5;
        return true;
    L5:
        if (this.h == false) goto L13;
        c r0 = this.b;
        if (r0 == null) goto L16;
        AnchorRtcConnectModel r1 = r0.Hb();
        if (r1 != null) goto L11;
        return true;
    L11:
        if (r1.enableFirstFrameOpt() == true) goto L13;
        return true;
    L16:
        return true;
    L13:
        return false;
    }

    public final boolean c() {
        if (a() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.o.b == false) goto L7;
        return true;
    }

    public a(c r28, AnchorLinkInitType r29, int r30, boolean r32, String r33, boolean r34, boolean r35, boolean r36, boolean r37, int r38, String r39, String r310, C0236a r40, d7 r42, v1 r43, g r44, long r45, m r46, int r47) {
        if ((r47 & 2) == 0) goto L5;
        AnchorLinkInitType r3 = AnchorLinkInitType.NONE;
    L7:
        if ((r47 & 4) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r47 & 8) == 0) goto L13;
        boolean r6 = true;
    L15:
        if ((r47 & 16) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r47 & 128) == 0) goto L21;
        boolean r9 = false;
    L23:
        if ((r47 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L25;
        boolean r10 = false;
    L27:
        if ((r47 & 512) == 0) goto L29;
        boolean r12 = false;
    L31:
        if ((r47 & 1024) == 0) goto L33;
        boolean r13 = false;
    L35:
        if ((r47 & 2048) == 0) goto L37;
        int r14 = 0;
    L39:
        if ((r47 & 4096) == 0) goto L41;
        String r15 = "manual_link";
    L43:
        if ((r47 & 8192) == 0) goto L50;
        if (r28 == null) goto L49;
        e r16 = r28.getLinkOptLogContext();
        if (r16 == null) goto L49;
        String r17 = r16.a;
        if (r17 == null) goto L49;
    L52:
        if ((r47 & 16384) == 0) goto L54;
        C0236a r8 = new C0236a(0, false, null, 0, null, 63);
    L56:
        if ((r47 & 32768) == 0) goto L58;
        d7 r22 = null;
    L60:
        if ((r47 & 65536) == 0) goto L62;
        v1 r23 = null;
    L64:
        if ((r47 & 131072) == 0) goto L66;
        g r24 = null;
    L68:
        if ((r47 & 262144) == 0) goto L70;
        long r25 = 0;
    L72:
        if ((r47 & 524288) == 0) goto L74;
        m r2 = null;
    L75:
        Intrinsics.checkNotNullParameter(r3, "initType");
        Intrinsics.checkNotNullParameter(r7, "inviteeList");
        Intrinsics.checkNotNullParameter(r15, "linkConnectionType");
        Intrinsics.checkNotNullParameter(r17, "panelSource");
        Intrinsics.checkNotNullParameter(r8, "extra");
        this.b = r28;
        this.c = r3;
        this.d = r4;
        this.e = r7;
        this.f = false;
        this.g = false;
        this.h = r9;
        this.i = r10;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r17;
        this.o = r8;
        this.p = r22;
        this.q = r23;
        this.r = r24;
        this.s = r25;
        this.t = r2;
        this.a = r6;
        return;
    L74:
        r2 = r46;
        goto L75
    L70:
        r25 = r45;
        goto L72
    L66:
        r24 = r44;
        goto L68
    L62:
        r23 = r43;
        goto L64
    L58:
        r22 = r42;
        goto L60
    L54:
        r8 = r40;
    L49:
        r17 = "";
        goto L52
    L50:
        r17 = r310;
        goto L52
    L41:
        r15 = r39;
        goto L43
    L37:
        r14 = r38;
        goto L39
    L33:
        r13 = r37;
        goto L35
    L29:
        r12 = r36;
        goto L31
    L25:
        r10 = r35;
        goto L27
    L21:
        r9 = r34;
        goto L23
    L17:
        r7 = r33;
        goto L19
    L13:
        r6 = r32;
        goto L15
    L9:
        r4 = r30;
        goto L11
    L5:
        r3 = r29;
        goto L7
    }
}
