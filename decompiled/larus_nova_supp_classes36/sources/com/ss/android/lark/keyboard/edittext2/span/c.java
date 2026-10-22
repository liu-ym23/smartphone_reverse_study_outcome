package com.ss.android.lark.keyboard.edittext2.span;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.codeblock.preview.CodeBlockV2Span;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends CodeBlockV2Span implements f {
    public c(Context r2, List<LineContent> r3, CodeBlockV2ProcessParams r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lineContents");
        Intrinsics.checkNotNullParameter(r4, "params");
        super(r2, r3, r4, 0);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.k
    public final k.a e(int r3, int r4, Editable r5) {
        Intrinsics.checkNotNullParameter(r5, "text");
        int r0 = r5.getSpanStart(this);
        int r1 = r5.getSpanEnd(this);
        if (r4 <= r0) goto L6;
        if (r1 < r3) goto L6;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L10;
        return null;
    L10:
        if (r3 < 0) goto L22;
        if (r4 < 0) goto L22;
        if (r3 != r4) goto L22;
        int r6 = r5.getSpanEnd(this);
        if (r3 != r6) goto L19;
        if (r4 != r6) goto L19;
        return null;
    L19:
        Selection.setSelection(r5, r6, r6);
        return new k.a(r6, r6);
    L22:
        return new k.a(r3, r4);
    L6:
        r2 = false;
        goto L8
    }
}
