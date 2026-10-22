package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class v<T> implements Observer {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    public v(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        int r0 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        AppCompatEditText r1 = this.a.d.a();
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.k(r1, (CharSequence) r3, -1);
    }
}
