package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class s implements View.OnLayoutChangeListener {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    public s(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        VoiceBubbleAreaUseCase r10 = this.a;
        VoiceImeWrapperUseCase.f(r10.c, r10.d.f().getHeight(), false, 6);
        AppCompatImageView r11 = this.a.d.m();
        int r12 = this.a.j;
        com.larksuite.framework.utils.g0.a(r11, r12, r12, r12, r12);
    }
}
