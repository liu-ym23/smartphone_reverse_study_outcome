package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m extends RichTextEditor {
    public m() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void t(RichTextElement.AtProperty r3, Map<String, String> r4) {
        if (r3 == null) goto L8;
        com.ss.android.lark.keyboard.edittext2.edittors.a r5 = (com.ss.android.lark.keyboard.edittext2.edittors.a) q(com.ss.android.lark.keyboard.edittext2.edittors.a.e);
        SpannableStringBuilder r0 = this.p;
        if (r0 != null) goto L6;
        return;
    L6:
        int r1 = hob.c.k;
        r5.R(hob.c.a.a(r3), r0);
        return;
    }
}
