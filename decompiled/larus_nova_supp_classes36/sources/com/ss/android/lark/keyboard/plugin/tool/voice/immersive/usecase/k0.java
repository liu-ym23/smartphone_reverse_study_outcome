package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k0 implements View.OnClickListener {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    public k0(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.c.a.z();
        this.a.d.a().requestFocus();
    }
}
