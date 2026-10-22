package com.bytedance.android.livesdk.gift.platform.business.tray2;

import com.bytedance.android.livesdk.gift.configmodel.o1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        com.bytedance.android.live.revenue.core.util.j.a r0 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r1 = com.bytedance.android.live.revenue.core.util.f.d(r0.a(), yz0.k.class);
        if (r1 == null) goto L31;
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L31;
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentScene() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        int r3 = 1;
    L32:
        if (r3 != 0) goto L34;
        return false;
    L34:
        if ((((o1) com.bytedance.android.livesdk.gift.platform.business.e.e.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[3])).a() & r3) != r3) goto L38;
        return true;
    L38:
        return false;
    L13:
        IRoomAuthStatus r5 = r2.getRoomAuthStatus();
        if (r5 != null) goto L16;
    L18:
        boolean r6 = false;
    L19:
        if (r6 == false) goto L21;
        r3 = 2;
        goto L32
    L21:
        n01.a r7 = com.bytedance.android.live.revenue.core.util.f.d(r0.a(), n01.a.class);
        if (r7 == null) goto L24;
        boolean r8 = r7.i3();
    L25:
        if (r8 == false) goto L28;
        r3 = 8;
        goto L32
    L28:
        if (r2.isMediaRoom() == false) goto L30;
        r3 = 4;
        goto L32
    L30:
        r3 = 16;
        goto L32
    L24:
        r8 = false;
        goto L25
    L16:
        if (r5.getGamePointsPlaying() != 1) goto L18;
        r6 = true;
        goto L19
    L10:
        r4 = false;
    L31:
        r3 = 0;
        goto L32
    }

    static {
    }
}
