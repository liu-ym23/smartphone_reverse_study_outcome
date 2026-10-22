package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.text.SpannableStringBuilder;
import androidx.lifecycle.Observer;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ AsrInputVoiceView a;
    public final /* synthetic */ m b;

    public f(AsrInputVoiceView r1, m r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r5) {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c r6 = (com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c) r5;
        RichText r0 = r6.a;
        SpannableStringBuilder r1 = r6.b;
        Log.i("AsrInputVoiceView", "asrRichResult: rich text");
        if (this.a.u == 0) goto L5;
    L12:
        KeyboardVoiceFGUtils r2 = KeyboardVoiceFGUtils.a;
        if (KeyboardVoiceFGUtils.i() == false) goto L15;
        AsrInputVoiceView r3 = this.a;
        Intrinsics.checkNotNull(r6);
        AsrInputVoiceView.T5(r3, r6, this.b);
        return;
    L15:
        AsrInputVoiceView r4 = this.a;
        Intrinsics.checkNotNull(r6);
        AsrInputVoiceView.U5(r4, r6, this.b);
        return;
    L5:
        if (AsrInputVoiceView.W6(r0) == false) goto L12;
        if (StringsKt.trim(r1).length() != 0) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == false) goto L12;
        return;
    L9:
        r7 = false;
        goto L10
    }
}
