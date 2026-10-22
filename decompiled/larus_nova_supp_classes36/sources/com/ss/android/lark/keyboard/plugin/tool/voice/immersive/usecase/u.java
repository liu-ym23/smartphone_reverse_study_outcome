package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.lifecycle.Observer;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.VoiceWaveBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class u<T> implements Observer {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    public u(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Double r3 = (Double) r2;
        VoiceWaveBar r0 = this.a.d.s();
        Intrinsics.checkNotNull(r3);
        r0.a(r3);
    }
}
