package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ AsrInputVoiceView a;

    public l(AsrInputVoiceView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r11) {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.f r12 = (com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.f) r11;
        TextView r0 = this.a.z;
        TextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("overtimePrompt");
        r0 = null;
    L5:
        r0.setText(StringsKt.replace$default(AsrInputVoiceView.Y5(this.a), "{num}", String.valueOf(r12.a), false, 4, null));
        TextView r2 = this.a.z;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("overtimePrompt");
        r2 = null;
    L8:
        boolean r3 = false;
        if (r2.getVisibility() == 0) goto L15;
        TextView r4 = this.a.z;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("overtimePrompt");
        r4 = null;
    L13:
        r4.setVisibility(0);
    L15:
        if (r12.a > 1) goto L29;
        TextView r13 = this.a.z;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("overtimePrompt");
        r13 = null;
    L20:
        if (r13.getVisibility() != 0) goto L22;
        r3 = true;
    L22:
        if (r3 == false) goto L30;
        Log.i("AsrInputVoiceView", "countDown finished, cancel asr and hide button");
        TextView r14 = this.a.z;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("overtimePrompt");
    L27:
        r1.setVisibility(8);
        AsrInputVoiceView.R5(this.a);
        AsrInputVoiceView.S5(this.a);
        return;
    L26:
        r1 = r14;
        goto L27
    L30:
        return;
    }
}
