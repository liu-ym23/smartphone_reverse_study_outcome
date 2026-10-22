package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.view.View;
import android.view.animation.Animation;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o implements View.OnLayoutChangeListener {
    public final /* synthetic */ AppCompatImageView a;
    public final /* synthetic */ VoiceBubbleAreaUseCase b;

    public o(AppCompatImageView r1, VoiceBubbleAreaUseCase r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        this.a.startAnimation((Animation) this.b.f.getValue());
    }
}
