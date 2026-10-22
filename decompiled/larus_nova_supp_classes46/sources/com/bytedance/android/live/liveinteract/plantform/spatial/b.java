package com.bytedance.android.live.liveinteract.plantform.spatial;

import com.bytedance.android.livesdk.model.y0;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements a {
    public b() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final y0 a() {
        return com.bytedance.android.live.liveinteract.spatial.a.b(6);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final aj6.b b() {
        return com.bytedance.android.live.liveinteract.spatial.a.a(6);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final String c() {
        return "video_dynamic_1v6_spatial_enable";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final y0 d(int r3, int r4) {
        HashMap r0 = (HashMap) com.bytedance.android.live.liveinteract.spatial.a.c(6);
        if (r0 == null) goto L7;
        HashMap r5 = (HashMap) r0.get(Integer.valueOf(r4));
        if (r5 == null) goto L7;
        y0 r6 = (y0) r5.get(Integer.valueOf(r3));
    L8:
        if (r6 == null) goto L10;
        return r6;
    L10:
        int r7 = vm2.d.W0();
        switch(r3) {
            case 0: goto L20;
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            default: goto L21;
        };
    L21:
        return new y0(0, 0, 0);
    L22:
        return new y0(r7 * 3, r7, 0);
    L23:
        return new y0(r7 * 2, r7, 0);
    L24:
        return new y0(r7, r7, 0);
    L25:
        return new y0(0 - r7, r7, 0);
    L26:
        return new y0(0 - (r7 * 2), r7, 0);
    L27:
        return new y0(0 - (r7 * 3), r7, 0);
    L20:
        return new y0(0, 0 - r7, 0);
    L7:
        r6 = null;
        goto L8
    }
}
