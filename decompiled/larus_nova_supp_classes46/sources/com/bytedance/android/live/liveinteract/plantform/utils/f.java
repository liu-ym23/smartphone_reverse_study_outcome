package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(LiveMode r5) {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L5;
        IRoom r1 = (IRoom) r0.getValue();
    L7:
        if (((Boolean) vm2.e.I.getValue(null, vm2.e.a[33])).booleanValue() == true) goto L9;
        return;
    L9:
        if (r5 != LiveMode.VIDEO) goto L31;
        if (r1 == null) goto L15;
        IRoomSpecificSceneTypeInfo r6 = r1.getSceneTypeInfo();
        if (r6 == null) goto L15;
        if (r6.isLandscapeVerticalRoom() != 1) goto L15;
        return;
    L15:
        com.bytedance.live.datacontext.j r7 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveStream();
        if (r7 == null) goto L33;
        com.bytedance.android.live.pushstream.d r8 = (com.bytedance.android.live.pushstream.d) r7.getValue();
        if (r8 == null) goto L34;
        uf2.d0 r2 = r8.getLiveCore();
        if (r2 == null) goto L24;
        uf2.d0.a r3 = r2.getBuilder();
        if (r3 == null) goto L24;
        int r4 = r3.getVideoHeight();
    L25:
        int r9 = d5.b((String) vm2.e.k().get(String.valueOf(r4)));
        if (r9 <= 0) goto L35;
        if (r4 <= 0) goto L36;
        r8.z0(r9, r4);
        return;
    L36:
        return;
    L35:
        return;
    L24:
        r4 = 0;
        goto L25
    L34:
        return;
    L33:
        return;
    L31:
        return;
    L5:
        r1 = null;
        goto L7
    }
}
