package com.ss.android.lark.coremd.facade.mdeditor;

import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.ext.g;
import com.ss.android.lark.coremd.facade.mdeditor.theme.IMEditorThemeExtend;
import com.ss.android.lark.keyboard.edittext2.mdeditor.RichTextMarkdownEditor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMRichTextMarkdownEditor extends RichTextMarkdownEditor {
    public final j Y(j r3) {
        Intrinsics.checkNotNullParameter(r3, "theme");
        j r4 = super.Y(r3);
        g.a(r4, IMEditorThemeExtend.p, new IMRichTextMarkdownEditor$interceptTheme$1(this));
        return r4;
    }
}
