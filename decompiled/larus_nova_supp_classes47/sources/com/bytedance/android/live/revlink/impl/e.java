package com.bytedance.android.live.revlink.impl;

import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import java.util.List;
import kc0.o;
import kotlin.collections.CollectionsKt;
import p11.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements j, o {
    public e() {
    }

    public final String A() {
        LinkCrossRoomDataHolder r0 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r0 == null) goto L6;
        String r1 = r0.d();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final int B() {
        LinkCrossRoomDataHolder r0 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.j() == null) goto L11;
        IPKLinkBizDataService r1 = r0.j();
        if (r1 != null) goto L9;
        return 0;
    L9:
        return r1.getIsRandomReMatch() ? 1 : 0;
    L11:
        return 0;
    }

    public final String a() {
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    @Override // p11.j
    public final List<String> b() {
        return CollectionsKt.emptyList();
    }

    public final long getChannelId() {
        LinkCrossRoomDataHolder r0 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c();
    }

    public final long getDuration() {
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.a();
    }

    public final int getInviteType() {
        LinkCrossRoomDataHolder r0 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.f();
    }

    public final int getMatchType() {
        LinkCrossRoomDataHolder r0 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.i();
    }

    public final long getPkId() {
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.i();
    }

    public final String getRequestId() {
        LinkCrossRoomDataHolder r0 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.l();
    }

    public final String getTheme() {
        LinkCrossRoomDataHolder r0 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r0 == null) goto L8;
        w31.c r1 = r0.k();
        if (r1 != null) goto L7;
        return "";
    L7:
        return r1.l();
    L8:
        return "";
    }

    public final boolean isOnceMore() {
        LinkCrossRoomDataHolder r0 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r0 == null) goto L14;
        com.bytedance.android.live.revlink.impl.global.c r1 = r0.b;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r2 = null;
        if (r1 == null) goto L7;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r3 = r1.Ig();
    L8:
        if (r3 == null) goto L14;
        com.bytedance.android.live.revlink.impl.global.c r4 = r0.b;
        if (r4 == null) goto L12;
        r2 = r4.Ig();
    L12:
        if (r2 == null) goto L14;
        return r2.isOnceMoreBattle();
    L7:
        r3 = null;
    L14:
        return false;
    }

    public final String u() {
        LinkCrossRoomDataHolder r0 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.e();
    }

    public final String w() {
        IPKLinkBizDataService r0 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r0 == null) goto L17;
        int r1 = r0.getPeakSwitchPlayMode();
        int r2 = com.bytedance.android.live.revlink.impl.mergepk.pkdouble.d.a;
        if (r1 != 1) goto L14;
        LinkCrossRoomDataHolder r3 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r3 != null) goto L9;
    L11:
        return "manual_link";
    L9:
        if (r3.i() != 1) goto L11;
        return "random_link";
    L14:
        if (r1 != 2) goto L20;
        return "manual_pk";
    L20:
        return "";
    L17:
        return "";
    }

    public final String x() {
        d31.d r0 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.s();
    }

    public final String y() {
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 == null) goto L6;
        String r1 = r0.b();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final String z() {
        LinkCrossRoomDataHolder r0 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.i() != 4) goto L7;
        return "random_link";
    L7:
        return "manual_link";
    }
}
