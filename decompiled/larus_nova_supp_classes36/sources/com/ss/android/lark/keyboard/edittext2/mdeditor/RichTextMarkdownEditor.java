package com.ss.android.lark.keyboard.edittext2.mdeditor;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.ext.g;
import com.ss.android.lark.coremd.impl.parse.MarkdownThemeImpl;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor;
import com.ss.android.lark.keyboard.edittext2.utils.e;
import com.ss.android.lark.richtextmd.parse.ext.b;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class RichTextMarkdownEditor extends RichTextEditor {
    public b u;

    public RichTextMarkdownEditor() {
        com.ss.android.lark.richtextmd.parse.a.a.getClass();
        this.u = com.ss.android.lark.richtextmd.parse.a.b;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor, com.ss.android.lark.keyboard.edittext2.base.a
    public final void G(com.ss.android.lark.keyboard.edittext2.base.a r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        this.u = ((RichTextMarkdownEditor) r2).u;
    }

    public j Y(j r3) {
        Intrinsics.checkNotNullParameter(r3, "theme");
        MarkdownThemeImpl r4 = r3.clone();
        g.a(r4, LarkThemeExtend.m, new RichTextMarkdownEditor$interceptTheme$1(this));
        return r4;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void X(SpannableStringBuilder r4, RichText r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "data");
        t9b.a r0 = t9b.a.a;
        com.ss.android.lark.richtextmd.parse.impl.b r1 = com.ss.android.lark.richtextmd.parse.ext.a.b(context());
        com.ss.android.lark.richtextmd.parse.ext.a.a(r1, new RichTextMarkdownEditor$onInsert$node$1(this));
        s r6 = r1.b(r5);
        MarkdownNodeEditor r2 = (MarkdownNodeEditor) e.b(q(MarkdownNodeEditor.g));
        j r3 = Y(r2.f);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.f = r3;
        r2.R(r6, r4);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor, com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final /* bridge */ /* synthetic */ void S(SpannableStringBuilder r1, RichText r2, int r3) {
        X(r1, r2);
    }
}
