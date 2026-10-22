package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.os.SystemClock;
import android.view.View;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.widget.richtext.RichText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a a;
    public final /* synthetic */ VoiceActionAreaUseCase b;

    public e(com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r1, VoiceActionAreaUseCase r2) {
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
        if (r2 == false) goto L9;
        return;
    L9:
        RichText r1 = ExtensionEditTextCompatKt.b(this.a.a());
        if (this.b.e().isSupportVoiceWithAsr() == false) goto L12;
        this.b.e().sendAudionWithTextMsg(((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) this.a.a().q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g)).m(0, this.a.a().length()), r1);
    L14:
        if (KeyboardVoiceFGUtils.c() == false) goto L17;
        this.b.e().finishReplyMode();
        return;
    L17:
        return;
    L12:
        this.b.e().onlySendTextMsg(((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) this.a.a().q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g)).m(0, this.a.a().length()), r1);
        goto L14
    L5:
        r2 = false;
        goto L6
    }
}
