package com.ss.android.lark.keyboard.edittext2.mdeditor.bizeditors;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.keyboard.edittext2.edittors.d;
import com.ss.android.lark.keyboard.edittext2.mdeditor.MarkdownNodeEditor;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import eab.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends d {
    public b() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.d, com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final /* bridge */ /* synthetic */ void S(SpannableStringBuilder r1, String r2, int r3) {
        U(r1, r2, r3);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.d
    public final void U(SpannableStringBuilder r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "emojiKey");
        c r0 = new c(EmojiHandler.e(r3), r3);
        ((MarkdownNodeEditor) q(MarkdownNodeEditor.g)).R(r0, r2);
    }
}
