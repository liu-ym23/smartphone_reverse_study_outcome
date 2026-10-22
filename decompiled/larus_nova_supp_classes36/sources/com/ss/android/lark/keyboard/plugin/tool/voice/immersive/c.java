package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.appcompat.widget.AppCompatEditText;
import com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SpannableStringUtils;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.i {
    public final /* synthetic */ Context a;
    public final /* synthetic */ AsrInputVoiceView b;

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.i
    public final void b() {
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.i
    public final boolean c() {
        return false;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.i
    public final void d() {
        AppCompatEditText r0 = this.b.e.L().c();
        if ((r0 instanceof RichTextFunctionEditText) == false) goto L5;
        AppCompatEditText r1 = (RichTextFunctionEditText) r0;
    L6:
        if (r1 == null) goto L9;
        Lazy r2 = SpannableStringUtils.a;
        SpannableStringUtils.c(r1.getEditableText());
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public c(Context r1, AsrInputVoiceView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.i
    public final SpannableStringBuilder a(String r2, int r3) {
        Lazy r0 = SpannableStringUtils.a;
        return SpannableStringUtils.b(this.a, r2, r3);
    }
}
