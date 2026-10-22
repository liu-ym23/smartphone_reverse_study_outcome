package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.text.Editable;
import android.text.TextWatcher;
import com.ss.android.lark.audio.voiceinput.AsrSessionState;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements TextWatcher {
    public final /* synthetic */ VoiceActionAreaUseCase a;
    public final /* synthetic */ com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r5) {
        if (this.a.e().getAsrSessionState().getValue() != AsrSessionState.AsrSessionWaitRecognizing) goto L5;
        return;
    L5:
        if (this.a.e().getAsrSessionState().getValue() != AsrSessionState.AsrSessionSwitchLanguage) goto L8;
        return;
    L8:
        if (r5 != null) goto L10;
    L13:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L17;
    L30:
        this.b.j().setIsEnabled(false);
        if (this.a.e().isVoiceSecondInputV2() == false) goto L37;
        this.b.k().setVisibility(4);
        return;
    L37:
        return;
    L17:
        if (StringsKt.trim(r5).length() != 0) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == true) goto L30;
        this.b.j().setIsEnabled(true);
        if (this.a.e().isVoiceSecondInputV2() == true) goto L25;
    L29:
        this.b.k().setVisibility(4);
        return;
    L25:
        if (Intrinsics.areEqual(this.a.e().isKeyboardShowing().getValue(), Boolean.TRUE) == true) goto L29;
        if (this.b.j().R5() == true) goto L29;
        this.b.k().setVisibility(0);
        return;
    L19:
        r6 = false;
        goto L20
    L10:
        if (r5.length() == 0) goto L13;
        r2 = false;
        goto L15
    }

    public i(VoiceActionAreaUseCase r1, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
