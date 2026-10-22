package com.bytedance.android.live.liveinteract.voicechat.util;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public List<? extends ILinkPlayerInfoBridge> a;
    public boolean b;
    public final boolean c;
    public boolean d;

    public final void b() {
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(null, 0, 7) == false) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        HashMap r3 = new HashMap();
        TalkRoomLogUtils.B0(r3, null, null, 6);
        if (r0 != null) goto L8;
    L18:
        j0.l().sendLog("livesdk_anchor_audience_connection_rechargeable_seat_show", r3, new Object[]{IRoom.class, am2.x.class});
        return;
    L8:
        if (this.c == false) goto L10;
        String r1 = "anchor";
    L17:
        r3.put("user_type", r1);
        goto L18
    L10:
        Integer r2 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r2 != null) goto L14;
    L15:
        r1 = "guest";
        goto L17
    L14:
        if (r2.intValue() != 0) goto L15;
        r1 = "user";
        goto L17
    }

    public final boolean a() {
        String r0 = jc1.k.n(IMiddlewareUserService.class).user().n();
        Iterator<? extends ILinkPlayerInfoBridge> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        ILinkPlayerInfoBridge r2 = r1.next();
        if (r2.getUser() == null) goto L4;
        IBaseUser r3 = r2.getUser();
        if (r3 == null) goto L10;
        String r4 = r3.getIdString();
    L12:
        if (Intrinsics.areEqual(r4, r0) == false) goto L4;
        return !r2.isSelfPreOn();
    L10:
        r4 = null;
        goto L12
    L15:
        return false;
    }

    public final void c() {
        if (this.d == true) goto L22;
        boolean r0 = true;
        this.d = true;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if ((r1 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L7;
        r1 = null;
    L7:
        com.bytedance.android.live.liveinteract.plantform.core.y r2 = (com.bytedance.android.live.liveinteract.plantform.core.y) r1;
        if (r2 != null) goto L10;
    L12:
        r0 = false;
    L14:
        if (a() == false) goto L16;
        return;
    L16:
        if (this.c == true) goto L24;
        if (r0 == true) goto L19;
        return;
    L19:
        if (this.b == true) goto L26;
        b();
        this.b = r0;
        return;
    L26:
        return;
    L24:
        return;
    L10:
        if (r2.u() == true) goto L12;
    }

    public a(boolean r1, boolean r2) {
        this.c = r1;
        this.d = r2;
        this.a = new ArrayList();
    }
}
