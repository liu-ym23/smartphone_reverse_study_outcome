package com.ss.ugc.live.barrage.barrage;

import com.ss.ugc.live.barrage.controller.ScrollBarrageController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends e implements ScrollBarrageController.e, ScrollBarrageController.d {
    public int[] v;

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController.e
    public final void e() {
    }

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController.d
    public final boolean a() {
        float r2 = 0;
        if ((this.f.right + r2) <= r2) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController.e
    public final int[] b() {
        int[] r0 = this.v;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new int[0];
    }
}
