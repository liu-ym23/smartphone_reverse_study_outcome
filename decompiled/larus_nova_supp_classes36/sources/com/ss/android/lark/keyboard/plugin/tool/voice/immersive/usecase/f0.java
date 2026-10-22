package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    public f0(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        AppCompatTextView r10 = this.a.d.l();
        int r11 = this.a.j;
        com.larksuite.framework.utils.g0.a(r10, r11, r11, r11, r11);
    }
}
