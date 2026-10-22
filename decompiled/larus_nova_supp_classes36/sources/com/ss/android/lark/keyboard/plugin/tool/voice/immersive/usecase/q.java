package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.lifecycle.Observer;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q<T> implements Observer {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    public q(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        if (((Boolean) r4).booleanValue() == false) goto L6;
        VoiceBubbleAreaUseCase r5 = this.a;
        VoiceImeWrapperUseCase.f(r5.c, r5.d.f().getHeight(), false, 6);
        ImmersiveVoiceViewModel r6 = this.a.f();
        int r0 = com.ss.android.lark.keyboard.plugin.tool.voice.utils.c.a;
        r6.reportAsrEndEditContent(com.ss.android.lark.keyboard.plugin.tool.voice.utils.c.a(this.a.d.a()));
        this.a.f().setProgrammaticUpdate(false);
        return;
    }
}
