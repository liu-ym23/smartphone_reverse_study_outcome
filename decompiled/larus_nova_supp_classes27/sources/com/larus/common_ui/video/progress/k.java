package com.larus.common_ui.video.progress;

import android.widget.SeekBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ PlayerProgressView a;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r1) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r1) {
    }

    public k(PlayerProgressView r1) {
        this.a = r1;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "seekBar");
        PlayerProgressView.a r4 = this.a.e;
        if (r4 == null) goto L6;
        r4.onProgressChanged(r2 / r1.getMax());
        return;
    }
}
