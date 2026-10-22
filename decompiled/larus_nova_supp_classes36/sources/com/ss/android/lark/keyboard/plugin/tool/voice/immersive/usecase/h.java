package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.ss.android.lark.audio.voiceinput.AsrSessionState;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.CircleIconWithTitle;
import com.ss.android.lark.widget.richtext.RichText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ VoiceActionAreaUseCase a;
    public final /* synthetic */ ImmersiveVoiceViewModel b;
    public final /* synthetic */ LifecycleOwner c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AsrSessionState.values().length];
            r0[AsrSessionState.AsrSessionWaitRecognizing.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[AsrSessionState.AsrSessionSwitchLanguage.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[AsrSessionState.AsrSessionEndWithText.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[AsrSessionState.AsrSessionEndWithTextTimeout.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[AsrSessionState.AsrSessionEndNoText.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[AsrSessionState.AsrSessionEndNoTextTimeout.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public h(VoiceActionAreaUseCase r1, ImmersiveVoiceViewModel r2, LifecycleOwner r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r8) {
        AsrSessionState r9 = (AsrSessionState) r8;
        if (r9 != null) goto L5;
        int r0 = -1;
    L7:
        switch(r0) {
            case 1: goto L49;
            case 2: goto L49;
            case 3: goto L31;
            case 4: goto L31;
            case 5: goto L10;
            case 6: goto L10;
            default: goto L56;
        };
    L49:
        CircleIconWithTitle.S5(this.a.b.j());
        this.a.b.k().setVisibility(4);
        return;
    L56:
        return;
    L10:
        if (this.b.isSecondVoiceInput() == false) goto L16;
        VoiceActionAreaUseCase.c(this.a);
        VoiceActionAreaUseCase r1 = this.a;
        if (r1.b.a().getEditableText().length() <= 0) goto L14;
        boolean r4 = true;
    L15:
        VoiceActionAreaUseCase.d(r1, r4);
    L18:
        if (this.a.e().isBackgroundAsrKeepSessionMode() == true) goto L20;
        return;
    L20:
        if (this.a.g == false) goto L22;
    L29:
        VoiceActionAreaUseCase r10 = this.a;
        r10.e().dismissPopupWindow();
        ImmersiveVoiceViewModel.resetLiveData$default(r10.e(), false, 1, null);
        return;
    L22:
        if (this.c.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L29;
        VoiceActionAreaUseCase r2 = this.a;
        if (r2.f == true) goto L29;
        r2.f = true;
        if (r9 != AsrSessionState.AsrSessionEndNoTextTimeout) goto L28;
        VoiceActionAreaUseCase.b(r2, 2131890966);
        goto L29
    L28:
        VoiceActionAreaUseCase.b(r2, 2131890968);
        goto L29
    L14:
        r4 = false;
        goto L15
    L16:
        VoiceActionAreaUseCase.d(this.a, false);
        goto L18
    L31:
        if (this.b.isSecondVoiceInput() == false) goto L34;
        VoiceActionAreaUseCase.c(this.a);
    L34:
        if (r9 == AsrSessionState.AsrSessionEndWithText) goto L36;
    L44:
        VoiceActionAreaUseCase.d(this.a, true);
        if (r9 == AsrSessionState.AsrSessionEndWithTextTimeout) goto L47;
        return;
    L47:
        if (this.a.e().isBackgroundAsrKeepSessionMode() == false) goto L54;
        VoiceActionAreaUseCase r11 = this.a;
        r11.e().dismissPopupWindow();
        ImmersiveVoiceViewModel.resetLiveData$default(r11.e(), false, 1, null);
        return;
    L54:
        return;
    L36:
        if (this.a.e().getAutoSendOnRecognizeFinish() == false) goto L44;
        if (this.a.e().getImmersiveVoiceMode().b() == false) goto L44;
        VoiceActionAreaUseCase r3 = this.a;
        if (r3.e == true) goto L44;
        r3.e = true;
        RichText r5 = ExtensionEditTextCompatKt.b(r3.b.a());
        this.a.e().onlySendTextMsg(((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) this.a.b.a().q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g)).m(0, this.a.b.a().length()), r5);
        if (this.a.e().isBackgroundAsrKeepSessionMode() == false) goto L44;
        ImmersiveVoiceViewModel.resetLiveData$default(this.a.e(), false, 1, null);
        goto L44
    L5:
        r0 = a.a[r9.ordinal()];
        goto L7
    }
}
