package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g0 implements View.OnClickListener {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;
    public final /* synthetic */ AppCompatImageView b;

    public g0(VoiceBubbleAreaUseCase r1, AppCompatImageView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        this.a.c.a.g();
        AudioAsrLanguageSwitcher r6 = this.a.v;
        Context r0 = this.b.getContext();
        boolean r1 = !this.a.f().isDisableVoiceWithAsr();
        if (this.a.f().isEnterpriseAnswerScene() == false) goto L5;
    L7:
        boolean r3 = false;
    L8:
        r6.i(r0, true, r1, r3);
        this.a.f().whenClickLanguageSwitcher();
        return;
    L5:
        if (this.a.f().isCcmCommentScene() == true) goto L7;
        r3 = true;
        goto L8
    }
}
