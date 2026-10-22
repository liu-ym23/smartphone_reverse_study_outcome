package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o implements ComponentSchedulingManager.a {
    public final /* synthetic */ ComponentSchedulingManager a;
    public final /* synthetic */ ComponentSchedulingManager.b b;

    public o(ComponentSchedulingManager r1, com.bytedance.android.live.core.tetris.componentx.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentSchedulingManager.a
    public final void a(f70.b r3, int r4, m r5) {
        ComponentSchedulingManager r6 = this.a;
        ComponentSchedulingManager.b r0 = this.b;
        r6.getClass();
        if (r5 == null) goto L5;
        LayerDescriptorList r1 = r5.b;
    L6:
        if (r1 == null) goto L12;
        if (r0 == null) goto L11;
        r0.a(r4, r5, r6.j);
        return;
    L11:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
