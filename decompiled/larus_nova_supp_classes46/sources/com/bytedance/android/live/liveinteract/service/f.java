package com.bytedance.android.live.liveinteract.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.common.utility.Lists;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements qd0.b {
    public f() {
    }

    public final boolean P() {
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a() != null) goto L5;
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.e.a.a() == null) goto L17;
        if (com.bytedance.android.live.liveinteract.plantform.base.e.a.a().H() != 0) goto L22;
        return false;
    L22:
        return true;
    L17:
        if (jc1.k.f(IPkAudienceLinkOutService.class) != null) goto L19;
        return false;
    L19:
        return ((IPkAudienceLinkOutService) jc1.k.f(IPkAudienceLinkOutService.class)).isLinkAudience();
    L5:
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a().H() != 0) goto L21;
        return false;
    L21:
        return true;
    }

    @Override // rj0.d
    public final com.bytedance.android.live.pushstream.d getLiveStream() {
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r0 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r0 != null) goto L5;
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r1 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getLiveStream();
    L5:
        return r0.xd();
    }

    public static List<ILinkPlayerInfoBridge> O(boolean r2) {
        if (r2 == false) goto L7;
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r3 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r3 == null) goto L10;
        y r4 = r3.getLinkUserCenter();
    L11:
        if (r4 != null) goto L13;
    L16:
        return null;
    L13:
        if (Lists.isEmpty(r4.c) == true) goto L16;
        return r4.c;
    L10:
        r4 = null;
        goto L11
    L7:
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.c r5 = com.bytedance.android.live.liveinteract.plantform.base.c.a.a();
        if (r5 == null) goto L10;
        r4 = r5.getLinkUserCenter();
        goto L11
    }

    public final boolean R(boolean r4, IBaseUser r5) {
        List<ILinkPlayerInfoBridge> r6 = O(r4);
        if (r5 != null) goto L5;
    L18:
        return false;
    L5:
        if (Lists.isEmpty(r6) == true) goto L18;
        Iterator<ILinkPlayerInfoBridge> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L18;
        ILinkPlayerInfoBridge r1 = r7.next();
        if (r1 == null) goto L9;
        if (r1.getUser() == null) goto L9;
        if (r1.getUser().getIdString().equals(r5.getIdString()) == false) goto L9;
        return true;
    }

    public final boolean S(boolean r2, IBaseUser r3) {
        if (R(r2, r3) == true) goto L5;
        return false;
    L5:
        if (r2 == false) goto L8;
        return true;
    L8:
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r4 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r4 != null) goto L15;
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r5 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r5 != null) goto L14;
        return false;
    L14:
        return r5.isEngineOn();
    L15:
        return r4.isEngineOn();
    }
}
