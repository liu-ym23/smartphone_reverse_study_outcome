package com.larus.video.impl.widget;

import android.widget.SeekBar;
import com.larus.video.impl.TikTokVideoViewHolder;
import com.ss.ttvideoengine.TTVideoEngine;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a0 implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ VideoViewHolder a;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r1) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r1) {
    }

    public a0(TikTokVideoViewHolder r1) {
        this.a = r1;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r3, int r4, boolean r5) {
        VideoView r6 = this.a.T3();
        if (r5 == false) goto L18;
        if (r6 == null) goto L19;
        int r7 = (int) ((r6.getDuration() * ((long) r4)) / 100.0f);
        TTVideoEngine r8 = r6.t;
        if (r8 != null) goto L8;
        return;
    L8:
        if (r8.getPlaybackState() != 1) goto L10;
    L14:
        TTVideoEngine r9 = r6.t;
        if (r9 == null) goto L21;
        r9.seekTo(r7, null);
        return;
    L21:
        return;
    L10:
        if (r8.getPlaybackState() == 2) goto L14;
        TTVideoEngine r10 = r6.t;
        if (r10 == null) goto L14;
        r10.play();
        goto L14
    L19:
        return;
    }
}
