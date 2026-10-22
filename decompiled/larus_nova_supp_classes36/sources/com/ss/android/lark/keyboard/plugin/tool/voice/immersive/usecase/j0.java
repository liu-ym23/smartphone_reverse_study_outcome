package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j0 implements View.OnFocusChangeListener {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    public j0(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r4, boolean r5) {
        if (r5 == false) goto L4;
        this.a.f().whenClickAsrResultEditText(((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) this.a.d.a().q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g)).m(0, this.a.d.a().length()));
    L4:
        sob.c.e(this.a.f().getAsrResultFocused(), Boolean.valueOf(r5));
    }
}
