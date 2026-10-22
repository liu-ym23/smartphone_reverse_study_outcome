package com.ss.android.lark.keyboard.edittext2.mdeditor.bizeditors;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.keyboard.edittext2.base.c;
import com.ss.android.lark.keyboard.edittext2.mdeditor.MarkdownNodeEditor;
import com.ss.android.lark.keyboard.edittext2.utils.e;
import hob.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends com.ss.android.lark.keyboard.edittext2.edittors.b {
    public a() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.b, com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final /* bridge */ /* synthetic */ void S(SpannableStringBuilder r1, d r2, int r3) {
        U(r1, r2, r3);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.b
    public final void U(SpannableStringBuilder r4, d r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "data");
        eab.b r7 = new eab.b(r5.a, r5.b, r5.c);
        ((MarkdownNodeEditor) q(MarkdownNodeEditor.g)).R(r7, r4);
        r4.append(" ");
        int r8 = e.c(c.a.a(this));
        if (r8 < 0) goto L6;
        c.a.a(this).getEditableText().delete(r8, r8 + 1);
        return;
    }
}
