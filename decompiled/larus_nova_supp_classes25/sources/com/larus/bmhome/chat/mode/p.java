package com.larus.bmhome.chat.mode;

import android.view.View;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p implements View.OnLayoutChangeListener {
    public final /* synthetic */ ModeSwitchComponent a;
    public final /* synthetic */ l0 b;

    public /* synthetic */ p(ModeSwitchComponent r1, l0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12) {
        ModeSwitchComponent r13 = this.a;
        l0 r14 = this.b;
        if (r13.P == false) goto L5;
    L7:
        boolean r15 = false;
        if ((r8 - r6) >= (r12 - r10)) goto L10;
        boolean r16 = true;
    L12:
        if (r13.x == false) goto L14;
        return;
    L14:
        if (r13.y == false) goto L16;
        return;
    L16:
        if (r13.z == true) goto L36;
        ICoreInputAbility r17 = (ICoreInputAbility) r13.r.getValue();
        if (r17 != null) goto L20;
    L22:
        if (r15 == true) goto L37;
        if (r16 == true) goto L25;
    L27:
        if (r6 != r10) goto L30;
        if (r8 != r12) goto L30;
        return;
    L30:
        if (r13.z == false) goto L32;
        r14.removeCallbacks(r13.U);
        r14.postDelayed(r13.U, 100);
    L32:
        q r18 = r13.W;
        String r19 = r13.M;
        int r20 = r13.N;
        r18.a(r19, r20, r20);
        return;
    L25:
        if (com.larus.platform.exp.o.a() == true) goto L27;
        return;
    L37:
        return;
    L20:
        if (r17.c2() != true) goto L22;
        r15 = true;
        goto L22
    L36:
        return;
    L10:
        r16 = false;
        goto L12
    L5:
        if (com.larus.platform.exp.o.a() == false) goto L7;
        r14.removeCallbacks(r13.X);
        r14.postDelayed(r13.X, 100);
        goto L7
    }
}
