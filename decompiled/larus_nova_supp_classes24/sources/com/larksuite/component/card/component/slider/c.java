package com.larksuite.component.card.component.slider;

import android.widget.SeekBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ UniversalCardLynxSliderUI a;

    public c(UniversalCardLynxSliderUI r1) {
        this.a = r1;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r3) {
        UniversalCardLynxSliderUI r0 = this.a;
        if (r3 == null) goto L5;
        int r4 = r3.getProgress();
    L6:
        UniversalCardLynxSliderUI.M(r0, r4, "start");
        return;
    L5:
        r4 = 0;
        goto L6
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r3) {
        if (r3 == null) goto L4;
        int r4 = r3.getProgress();
    L5:
        UniversalCardLynxSliderUI.M(this.a, r4, "end");
        return;
    L4:
        r4 = 0;
        goto L5
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
        if (r3 == false) goto L5;
        UniversalCardLynxSliderUI.M(this.a, r2, "moving");
        return;
    }
}
