package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ AsrInputVoiceView a;

    public k(AsrInputVoiceView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (((Boolean) r2).booleanValue() == false) goto L6;
        AsrInputVoiceView r3 = this.a;
        AsrInputVoiceView.C6(r3, AsrInputVoiceView.n6(r3));
        return;
    }
}
