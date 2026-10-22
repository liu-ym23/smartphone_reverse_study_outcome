package com.suite.lark.platform.component.widget_biz_chatkeyboard.widget;

import android.widget.SeekBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ PlayControlBar a;

    public b(PlayControlBar r1) {
        this.a = r1;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r1) {
        PlayControlBar.a r2 = this.a.h;
        if (r2 == null) goto L6;
        r2.a();
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r1) {
        PlayControlBar.a r2 = this.a.h;
        if (r2 == null) goto L6;
        r2.b();
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r2, int r3, boolean r4) {
        float r5 = r3;
        this.a.f = (1.0f * r5) / r2.getMax();
        PlayControlBar r6 = this.a;
        PlayControlBar.b(r6, r6.f);
        PlayControlBar.a r7 = this.a.h;
        if (r7 == null) goto L6;
        r7.onProgressChanged((int) (r5 * 0.1f));
        return;
    }
}
