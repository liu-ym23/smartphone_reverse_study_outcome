package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import android.widget.SeekBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ gc0.c a;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r1) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r1) {
    }

    public i(gc0.c r1) {
        this.a = r1;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
        this.a.onProgressChanged(r2);
    }
}
