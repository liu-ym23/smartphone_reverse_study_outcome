package com.bytedance.android.live.liveinteract.plantform.spatial;

import com.bytedance.android.livesdk.model.y0;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements a {
    public d() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final y0 a() {
        return com.bytedance.android.live.liveinteract.spatial.a.b(5);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final aj6.b b() {
        return com.bytedance.android.live.liveinteract.spatial.a.a(5);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final String c() {
        return "video_equal_window_3v3_spatial_enable";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final y0 d(int r3, int r4) {
        int r5 = vm2.d.W0();
        HashMap r0 = (HashMap) com.bytedance.android.live.liveinteract.spatial.a.c(5);
        if (r0 == null) goto L5;
        y0 r1 = (y0) r0.get(Integer.valueOf(r3));
    L6:
        if (r1 == null) goto L9;
        return r1;
    L9:
        switch(r3) {
            case 0: goto L20;
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L13;
            case 7: goto L23;
            case 8: goto L22;
            default: goto L21;
        };
    L13:
        int r6 = 0 - r5;
        return new y0(r6, r6, 0);
    L21:
        return new y0(0, 0, 0);
    L22:
        return new y0(0 - r5, r5, 0);
    L23:
        return new y0(0 - r5, 0, 0);
    L25:
        return new y0(0, r5, 0);
    L26:
        return new y0(0, 0, 0);
    L27:
        return new y0(0, 0 - r5, 0);
    L28:
        return new y0(r5, r5, 0);
    L29:
        return new y0(r5, 0, 0);
    L20:
        return new y0(r5, 0 - r5, 0);
    L5:
        r1 = null;
        goto L6
    }
}
