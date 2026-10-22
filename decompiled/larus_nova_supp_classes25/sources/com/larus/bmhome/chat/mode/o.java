package com.larus.bmhome.chat.mode;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o implements View.OnLayoutChangeListener {
    public final /* synthetic */ ModeSwitchComponent a;

    public /* synthetic */ o(ModeSwitchComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        ModeSwitchComponent r10 = this.a;
        if ((r5 - r3) > 0) goto L5;
        int r11 = ModeSwitchComponent.k0;
        return;
    L5:
        if (r10.x == false) goto L7;
        return;
    L7:
        if (r10.y == false) goto L9;
        return;
    L9:
        if (r10.z == true) goto L15;
        q r12 = r10.W;
        String r13 = r10.M;
        int r14 = r10.N;
        r12.a(r13, r14, r14);
        return;
    }
}
