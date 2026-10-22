package com.bytedance.android.live.liveinteract.plantform.spatial;

import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.model.u0;
import com.bytedance.android.livesdk.model.y0;
import java.util.HashMap;
import jc1.k;
import py.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements a {
    public j() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final String c() {
        return "voice_ktv_spatial_enable";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final y0 a() {
        y0 r0 = com.bytedance.android.live.liveinteract.spatial.a.b(9);
        String r1 = k.n(IKtvService.class).getKtvRoomCurrentSingerIdStr();
        y0 r2 = new y0(r0.a(), r0.b(), r0.c());
        if (v.a(r1) == false) goto L5;
        r2.e((int) ((u0) vm2.d.F4.getValue(null, vm2.d.a[289(0x121, float:4.05E-43)])).a());
    L5:
        return r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final aj6.b b() {
        return com.bytedance.android.live.liveinteract.spatial.a.a(9);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final y0 d(int r3, int r4) {
        HashMap r5 = (HashMap) com.bytedance.android.live.liveinteract.spatial.a.c(9);
        int r0 = vm2.d.Y0();
        if (r5 == null) goto L5;
        y0 r6 = (y0) r5.get(Integer.valueOf(r3));
    L6:
        if (r6 == null) goto L12;
        y0 r7 = new y0(r6.a(), r6.b(), r6.c());
        if (v.a(k.n(IKtvService.class).getKtvRoomCurrentSingerIdStr()) == true) goto L10;
        r7.d();
    L10:
        return r7;
    L12:
        switch(r3) {
            case 0: goto L23;
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            case 8: goto L25;
            default: goto L24;
        };
    L24:
        return new y0(0, 0, 0);
    L25:
        return new y0(0, r0 * 6, 0);
    L26:
        return new y0(0, r0 * 5, 0);
    L27:
        return new y0(0, r0 * 4, 0);
    L28:
        return new y0(0, r0 * 3, 0);
    L29:
        return new y0(0, r0 * 2, 0);
    L30:
        return new y0(0, r0, 0);
    L31:
        return new y0(0, 0 - r0, 0);
    L32:
        return new y0(0, 0 - (r0 * 2), 0);
    L23:
        return new y0(0, 0 - (r0 * 3), 0);
    L5:
        r6 = null;
        goto L6
    }
}
