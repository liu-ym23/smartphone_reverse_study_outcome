package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ VoiceActionAreaUseCase a;

    public a(VoiceActionAreaUseCase r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l r4 = (com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l) this.a.e().getImmersiveVoiceState().getValue();
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == false) goto L10;
        this.a.e().dismissPopupWindow();
        return;
    L10:
        return;
    L5:
        if (r4.getState() != 5) goto L7;
        r0 = true;
        goto L7
    }
}
