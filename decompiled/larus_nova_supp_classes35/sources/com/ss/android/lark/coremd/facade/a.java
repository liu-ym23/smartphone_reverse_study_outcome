package com.ss.android.lark.coremd.facade;

import b3c.d;
import com.ss.android.lark.coremd.facade.richtext.IMRichTextTagHandlers;
import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends IMRichTextToMarkdownConfig {
    public static final a b = null;

    static {
        b = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.coremd.facade.IMRichTextToMarkdownConfig
    public final void a(d r3) {
        Intrinsics.checkNotNullParameter(r3, "generator");
        super.a(r3);
        Lazy r0 = IMRichTextTagHandlers.a;
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.TEXT, (com.ss.android.lark.coremd.facade.richtext.c) IMRichTextTagHandlers.d.getValue());
    }
}
