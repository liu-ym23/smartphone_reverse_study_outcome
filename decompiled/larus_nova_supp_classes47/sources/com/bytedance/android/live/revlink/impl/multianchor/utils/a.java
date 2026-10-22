package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final com.bytedance.android.livesdk.revenue.service.room.c a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    public final boolean a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        IRoomBase r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r2 = r0.Ig();
    L6:
        boolean r3 = false;
        if (r2 == null) goto L45;
        PkBaseStateMachine.c r4 = r2.getCurPKBaseState();
        if (r4 != null) goto L11;
        return false;
    L11:
        if (r4.b() != true) goto L47;
        com.bytedance.android.live.revlink.impl.global.c r5 = this.b;
        if (r5 == null) goto L16;
        w r6 = r5.getMultiLinkUtil();
    L17:
        if (r6 != null) goto L19;
    L24:
        com.bytedance.android.live.revlink.impl.global.c r7 = this.b;
        if (r7 == null) goto L27;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r8 = r7.Ig();
    L28:
        if (r8 != null) goto L30;
    L32:
        y41.d r9 = y41.d.j;
        com.bytedance.android.livesdk.revenue.service.room.c r10 = this.a;
        if (r10 == null) goto L37;
        com.bytedance.android.livesdk.revenue.room.a r12 = r10.getRoomContext();
        if (r12 == null) goto L37;
        r1 = r12.getCommonRoom();
    L37:
        if (r1 == null) goto L44;
        IRoomSpecificSceneTypeInfo r13 = r1.getSceneTypeInfo();
        if (r13 == null) goto L44;
        if (r13.isLandscapeVerticalRoom() != 1) goto L44;
        r3 = true;
    L44:
        return r9.a(r3);
    L30:
        if (r8.isInCloudCollaborate() != true) goto L32;
        return false;
    L27:
        r8 = null;
        goto L28
    L19:
        if (r6.i() <= 4) goto L21;
        boolean r14 = true;
    L22:
        if (r14 != true) goto L24;
        return false;
    L21:
        r14 = false;
        goto L22
    L16:
        r6 = null;
        goto L17
    L47:
        return false;
    L45:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    public a(com.bytedance.android.livesdk.revenue.service.room.c r1, LinkFakeGlobalService r2) {
        this.a = r1;
        this.b = r2;
    }
}
