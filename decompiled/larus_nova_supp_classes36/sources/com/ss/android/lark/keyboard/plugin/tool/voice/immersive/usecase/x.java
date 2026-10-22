package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.lifecycle.Observer;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class x<T> implements Observer {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    public x(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (((Boolean) r2).booleanValue() == true) goto L5;
    L7:
        this.a.d.i().setVisibility(4);
        return;
    L5:
        if (((Boolean) KeyboardVoiceFGUtils.d.getValue()).booleanValue() == false) goto L7;
        this.a.d.i().setVisibility(0);
    }
}
