package com.larus.avlink.simulInterpret.page.view;

import android.view.View;
import com.larus.avlink.simulInterpret.page.model.SliderLevel;
import com.larus.dora.api.DoraConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ SimultaneousInterpretFragment a;

    public e0(SimultaneousInterpretFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        SimultaneousInterpretFragment r10 = this.a;
        SliderLevel r11 = (SliderLevel) SliderLevel.getEntries().get(DoraConfig.a.getInt("key_si_slider_level", 0));
        int r12 = SimultaneousInterpretFragment.s;
        r10.aa0(r10.W90(r11));
    }
}
