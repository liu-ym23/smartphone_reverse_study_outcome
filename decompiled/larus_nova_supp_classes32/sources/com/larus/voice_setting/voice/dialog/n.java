package com.larus.voice_setting.voice.dialog;

import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.asr.view.ChatSpeaker;
import com.larus.audio.quality.AudioCheckerResult;
import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.impl.databinding.LarusDialogCreateUgcVoiceBinding;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n implements p78.a {
    public final /* synthetic */ CreateUgcVoiceDialog a;

    public n(CreateUgcVoiceDialog r1) {
        this.a = r1;
    }

    public final void a(final String r4) {
        FLogger.a.i("CreateUgcVoiceDialog", "fileSaveSuccess filePath = " + r4);
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L20;
        Handler r1 = com.larus.utils.t0.a;
        final CreateUgcVoiceDialog r2 = this.a;
        r1.post(new m(r2, r4));
        return;
    L20:
        this.a.dismiss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L22;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L22:
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public final void b(p78.b r7) {
        Intrinsics.checkNotNullParameter(r7, "checkAudioQualityResult");
        FLogger r0 = FLogger.a;
        r0.i("CreateUgcVoiceDialog", "VoiceQualityChecker onResult = " + r7);
        CreateUgcVoiceDialog r1 = this.a;
        AudioCheckerResult r8 = r7.a;
        int r3 = CreateUgcVoiceDialog.u;
        final Context r4 = r1.getContext();
        if (r4 == null) goto L10;
        r0.i("CreateUgcVoiceDialog", "checkResult result = " + r8);
        if (r8 == AudioCheckerResult.PASSED) goto L9;
        r1.V90(CreateUgcVoiceDialog.PageStatus.NORMAL_STATUS);
        com.larus.utils.t0.a.post(new b(r4));
        Lazy r9 = MediaResourceManager.a;
        MediaResourceManager.a(r1.t);
        return;
    L9:
        return;
    }

    public final void c(byte[] r3) {
        CreateUgcVoiceDialog r0 = this.a;
        LarusDialogCreateUgcVoiceBinding r1 = r0.e;
        if (r1 == null) goto L8;
        ChatSpeaker r2 = r1.g;
        if (r2 == null) goto L9;
        r2.d8(LifecycleOwnerKt.getLifecycleScope(r0), r3);
        return;
    L9:
        return;
    }
}
