package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ VoiceActionAreaUseCase a;

    public f(VoiceActionAreaUseCase r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (((Boolean) r2).booleanValue() == false) goto L6;
        this.a.g = true;
        return;
    }
}
