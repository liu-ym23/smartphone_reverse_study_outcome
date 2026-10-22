package com.bytedance.android.live.revlink.impl;

import com.bytedance.android.live.revenuelink.connect.g;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.service.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mz0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LinkCrossRoomDataHolder {
    public static final a c = null;
    public x11.a a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    public static final class a {
        public a() {
        }
    }

    static {
        c = new a();
    }

    public final g b() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAnchorConnectUtils();
    }

    public final IPKLinkBizDataService j() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mk();
    }

    public final w31.c k() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkLinkUtils();
    }

    public final String l() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        com.bytedance.android.live.revlink.impl.control.d r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.control.d r2 = r0.Rc();
    L6:
        if (r2 == null) goto L13;
        com.bytedance.android.live.revlink.impl.global.c r3 = this.b;
        if (r3 == null) goto L10;
        r1 = r3.Rc();
    L10:
        if (r1 == null) goto L13;
        String r4 = r1.getRequestId();
        if (r4 == null) goto L13;
        return r4;
    L13:
        return "";
    L5:
        r2 = null;
        goto L6
    }

    public final long c() {
        w31.c r0 = k();
        if (r0 != null) goto L5;
    L9:
        com.bytedance.android.live.revlink.impl.global.c r1 = this.b;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r2 = null;
        f r3 = null;
        if (r1 == null) goto L12;
        w r4 = r1.getMultiLinkUtil();
    L13:
        if (r4 != null) goto L15;
    L21:
        com.bytedance.android.live.revlink.impl.global.c r5 = this.b;
        if (r5 == null) goto L24;
        w r6 = r5.getMultiLinkUtil();
    L25:
        if (r6 != null) goto L27;
    L33:
        return 0;
    L27:
        if (r6.d() != true) goto L33;
        com.bytedance.android.live.revlink.impl.global.c r7 = this.b;
        if (r7 == null) goto L31;
        r2 = r7.getMultiAnchorLinkContextObj();
    L31:
        if (r2 == null) goto L33;
        return r2.a();
    L24:
        r6 = null;
        goto L25
    L15:
        if (r4.e() != true) goto L21;
        com.bytedance.android.live.revlink.impl.global.c r8 = this.b;
        if (r8 == null) goto L19;
        r3 = r8.Aa();
    L19:
        if (r3 == null) goto L33;
        return r3.channelId();
    L12:
        r4 = null;
        goto L13
    L5:
        if (r0.n() != true) goto L9;
        g r9 = b();
        if (r9 == null) goto L33;
        return r9.getChannelId();
    }

    public final String d() {
        w31.c r0 = k();
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.a();
    L6:
        String r3 = "random_pk";
        if (r2 <= 0) goto L51;
        x11.a r4 = this.a;
        if (r4 == null) goto L13;
        y11.d r5 = r4.getPkService();
        if (r5 == null) goto L13;
        q11.b r6 = r5.e();
    L14:
        IPKLinkBizDataService r7 = j();
        if (r7 == null) goto L35;
        IPKLinkBizDataService.d r8 = r7.getLinkTypeParams();
        if (r8.e.length() <= 0) goto L19;
        r1 = true;
    L19:
        if (r1 == true) goto L55;
        int r9 = r8.a;
        if (r9 != 0) goto L24;
        r3 = "manual_pk";
    L33:
        return r3;
    L24:
        if (r9 == 1) goto L33;
        if (r9 == 3) goto L33;
        if (r9 != 12) goto L31;
        r3 = "game_matching";
        goto L33
    L31:
        r3 = "";
        goto L33
    L55:
        return r8.e;
    L35:
        if (i() != 0) goto L38;
        r3 = "manual_pk";
    L48:
        if ((r6 instanceof q11.b.C0295b) == false) goto L56;
    L53:
        return "manual_link";
    L56:
        return r3;
    L38:
        if (i() == 1) goto L48;
        if (i() == 3) goto L48;
        if (i() != 100) goto L46;
        r3 = "npk";
        goto L48
    L46:
        r3 = "";
    L13:
        r6 = q11.b.a.b;
        goto L14
    L51:
        if (i() != 1) goto L53;
        return "random_pk";
    L5:
        r2 = 0;
        goto L6
    }

    public final String e() {
        w31.c r0 = k();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.n() != true) goto L14;
        g r1 = b();
        if (r1 == null) goto L15;
        String r2 = r1.getLinkMicId();
        if (r2 != null) goto L12;
        return "";
    L12:
        return r2;
    L15:
        return "";
    L14:
        return "";
    }

    public final int f() {
        w31.c r0 = k();
        if (r0 != null) goto L5;
    L23:
        return 0;
    L5:
        if (r0.n() != true) goto L23;
        g r1 = b();
        if (r1 != null) goto L9;
    L13:
        g r2 = b();
        if (r2 == null) goto L23;
        if (r2.w1() != true) goto L23;
        com.bytedance.android.live.revlink.impl.global.c r3 = this.b;
        if (r3 == null) goto L20;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r4 = r3.u5();
    L21:
        if (r4 == null) goto L23;
        return r4.getInviteType();
    L20:
        r4 = null;
        goto L21
    L9:
        if (r1.v1() != true) goto L13;
        IPKLinkBizDataService r5 = j();
        if (r5 == null) goto L23;
        Intrinsics.checkNotNullParameter(r5, "$this$getInviteType");
        return r5.getLinkTypeParams().b;
    }

    public final String g() {
        w31.c r0 = k();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.n() != true) goto L27;
        g r1 = b();
        if (r1 != null) goto L9;
    L15:
        g r2 = b();
        if (r2 != null) goto L18;
        return null;
    L18:
        if (r2.w1() != true) goto L31;
        com.bytedance.android.live.revlink.impl.global.c r3 = this.b;
        if (r3 == null) goto L22;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r4 = r3.u5();
    L23:
        if (r4 != null) goto L25;
        return null;
    L25:
        return r4.y3();
    L22:
        r4 = null;
        goto L23
    L31:
        return null;
    L9:
        if (r1.v1() != true) goto L15;
        IPKLinkBizDataService r5 = j();
        if (r5 == null) goto L14;
        Intrinsics.checkNotNullParameter(r5, "$this$getInviteeID");
        String r6 = r5.getGuestInfo().e;
        if (r6 == null) goto L14;
        return r6;
    L14:
        return "";
    L27:
        return null;
    }

    public final String h() {
        w31.c r0 = k();
        if (r0 != null) goto L5;
    L17:
        return "";
    L5:
        if (r0.n() != true) goto L17;
        g r1 = b();
        if (r1 == null) goto L17;
        if (r1.w1() != true) goto L17;
        com.bytedance.android.live.revlink.impl.global.c r2 = this.b;
        if (r2 == null) goto L13;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r3 = r2.u5();
    L14:
        if (r3 == null) goto L17;
        String r4 = r3.getInviteeList();
        if (r4 == null) goto L17;
        return r4;
    L13:
        r3 = null;
        goto L14
    }

    public final int i() {
        w31.c r0 = k();
        f r1 = null;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r2 = null;
        if (r0 != null) goto L5;
    L22:
        w31.c r3 = k();
        if (r3 == null) goto L52;
        com.bytedance.android.live.revlink.impl.global.c r4 = r3.c;
        if (r4 == null) goto L27;
        ox0.a r5 = r4.getModeMerge();
    L28:
        if (r5 == null) goto L30;
        int r6 = r5.a();
    L31:
        boolean r7 = com.bytedance.android.live.utils.c.a(r6, 4);
        com.bytedance.android.livesdk.revenue.room.a r8 = r3.a;
        if (r8 == null) goto L34;
        boolean r9 = r8.getCommonIsAnchor();
    L35:
        if (r9 == true) goto L38;
        if (r7 == false) goto L38;
        boolean r10 = true;
    L39:
        if (r10 != true) goto L53;
        com.bytedance.android.live.revlink.impl.global.c r12 = this.b;
        if (r12 == null) goto L43;
        r1 = r12.Aa();
    L43:
        if (r1 != null) goto L45;
        return 0;
    L45:
        return r1.matchType();
    L53:
        return 0;
    L38:
        r10 = false;
        goto L39
    L34:
        r9 = false;
        goto L35
    L30:
        r6 = 0;
        goto L31
    L27:
        r5 = null;
        goto L28
    L52:
        return 0;
    L5:
        if (r0.n() != true) goto L22;
        g r13 = b();
        if (r13 != null) goto L9;
    L13:
        g r14 = b();
        if (r14 != null) goto L16;
        return 0;
    L16:
        if (r14.w1() != true) goto L49;
        com.bytedance.android.live.revlink.impl.global.c r15 = this.b;
        if (r15 == null) goto L20;
        r2 = r15.u5();
    L20:
        if (r2 != null) goto L51;
        return 0;
    L51:
        return r2.getMatchType();
    L49:
        return 0;
    L9:
        if (r13.v1() != true) goto L13;
        IPKLinkBizDataService r16 = j();
        if (r16 == null) goto L46;
        Intrinsics.checkNotNullParameter(r16, "$this$getMatchType");
        return r16.getLinkTypeParams().a;
    L46:
        return 0;
    }

    public LinkCrossRoomDataHolder(LinkFakeGlobalService r1) {
        this.b = r1;
    }

    public final void a(m r4) {
        Intrinsics.checkNotNullParameter(r4, "logFilterBuilder");
        Function1<mz0.a, Unit> r0 = new LinkCrossRoomDataHolder$anchorLinkLog$1(this);
        Intrinsics.checkNotNullParameter(r0, "builder");
        com.bytedance.android.livesdk.revenue.log.f r1 = vh6.c.b(kr2.a.class).Q8();
        r0.invoke(new mz0.b(r1));
        List<Object> r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(r1.a);
    }

    public final void m(m r2) {
        Intrinsics.checkNotNullParameter(r2, "logFilterBuilder");
        r2.a(new LinkCrossRoomDataHolder$linkCrossRoomLog$1(this));
    }
}
