package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.lifecycle.Observer;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.ImeWrapperMotionScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l0<T> implements Observer {
    public final /* synthetic */ VoiceImeWrapperUseCase a;

    public l0(VoiceImeWrapperUseCase r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        Boolean r10 = (Boolean) r9;
        if (Intrinsics.areEqual(this.a.a().isKeyboardShowing().getValue(), Boolean.FALSE) == false) goto L9;
        ImeWrapperMotionScene r1 = this.a.e;
        Intrinsics.checkNotNull(r10);
        boolean r7 = r10.booleanValue();
        VoiceInputScene r6 = this.a.a().getImmersiveVoiceMode().b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "scene");
        KeyboardVoiceFGUtils r11 = KeyboardVoiceFGUtils.a;
        if (KeyboardVoiceFGUtils.b() == false) goto L10;
        r1.c(false, null, false, null, r6, r7);
        return;
    L10:
        return;
    }
}
