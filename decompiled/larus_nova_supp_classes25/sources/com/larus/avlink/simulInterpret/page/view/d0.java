package com.larus.avlink.simulInterpret.page.view;

import android.view.View;
import com.larus.avlink.simulInterpret.page.model.SliderLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ SimultaneousInterpretFragment a;

    public d0(SimultaneousInterpretFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        SimultaneousInterpretFragment r10 = this.a;
        SliderLevel r11 = SliderLevel.MIDDLE;
        int r12 = SimultaneousInterpretFragment.s;
        r10.aa0(r10.W90(r11));
    }
}
