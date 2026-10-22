package com.bytedance.android.live.liveinteract.linkpanel.util;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.l0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w {
    public static final long a() {
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.k().c == false) goto L6;
        int r0 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.k().a;
    L14:
        return r0;
    L6:
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.h().c == false) goto L9;
        r0 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.h().a;
        goto L14
    L9:
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L12;
        r0 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().a;
        goto L14
    L12:
        return 0;
    }

    public static final long b() {
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.k().c == false) goto L6;
        int r0 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.k().b;
    L14:
        return r0;
    L6:
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.h().c == false) goto L9;
        r0 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.h().b;
        goto L14
    L9:
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L12;
        r0 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().b;
        goto L14
    L12:
        return 0;
    }

    public static final String c() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        boolean r1 = false;
        if (r0 == null) goto L9;
        rj0.m r2 = r0.getVideoTalkService();
        if (r2 == null) goto L9;
        com.bytedance.android.live.liveinteract.api.data.a r3 = r2.j();
        if (r3 == null) goto L9;
        boolean r4 = r3.c;
    L10:
        if (r4 == true) goto L21;
        IInteractService r5 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r5 != null) goto L14;
    L16:
        if (r1 == true) goto L21;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == true) goto L21;
        return "";
    L14:
        if (r5.getInteractAudienceService() == null) goto L16;
        r1 = com.bytedance.android.live.liveinteract.api.data.a.a().c;
    L21:
        return "rechargeable_normal";
    L9:
        r4 = false;
        goto L10
    }

    public static final void d() {
        LinkedHashMap r0 = new LinkedHashMap();
        m.G(r0);
        m.B(r0, null, 6);
        l0.e(r0);
        r0.put("function_type2", "live");
        j0.l().sendLog("livesdk_anchor_priority_queue_open_success", r0, new Object[]{IRoom.class});
    }

    public static final void e(boolean r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        m.G(r0);
        m.B(r0, null, 6);
        if (r4 == false) goto L5;
        String r5 = "on";
    L6:
        r0.put("action_type", r5);
        l0.e(r0);
        r0.put("function_type2", "live");
        j0.l().sendLog("livesdk_anchor_priority_queue_switch", r0, new Object[]{IRoom.class});
        return;
    L5:
        r5 = "off";
        goto L6
    }
}
