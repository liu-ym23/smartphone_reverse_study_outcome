package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.os.SystemClock;
import android.view.View;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ VoiceActionAreaUseCase a;
    public final /* synthetic */ com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a b;

    public c(VoiceActionAreaUseCase r1, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        int r9 = sob.e.b;
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - sob.e.a) > AudioViewModel.ASR_SESSION_IDLE) goto L5;
        boolean r2 = true;
    L6:
        sob.e.a = r0;
        if (r2 == true) goto L12;
        this.a.e().onlySendAudioMsg(ExtensionEditTextCompatKt.f(this.b.a()), ((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) this.b.a().q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g)).m(0, this.b.a().length()));
        if (KeyboardVoiceFGUtils.c() == false) goto L13;
        this.a.e().finishReplyMode();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r2 = false;
        goto L6
    }
}
