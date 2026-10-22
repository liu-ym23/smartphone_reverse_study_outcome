package com.larus.dora.impl.nl;

import android.widget.SeekBar;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m0 implements SeekBar.OnSeekBarChangeListener {
    public m0() {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r1) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r7) {
        DoraUserSettingsManager r0 = DoraUserSettingsManager.a;
        if (r7 == null) goto L5;
        int r8 = r7.getProgress();
    L6:
        BuildersKt.launch$default(DoraUserSettingsManager.b, null, null, new DoraUserSettingsManager$updateProactiveFreq$1(r8, null), 3, null);
        return;
    L5:
        r8 = 3;
        goto L6
    }
}
