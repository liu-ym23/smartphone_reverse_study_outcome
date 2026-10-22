package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d0<T> implements Observer {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    public d0(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        AppCompatTextView r0 = this.a.d.r();
        r0.setText((String) r2);
    }
}
