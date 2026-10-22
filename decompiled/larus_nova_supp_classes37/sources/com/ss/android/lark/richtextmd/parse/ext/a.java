package com.ss.android.lark.richtextmd.parse.ext;

import android.content.Context;
import b3c.d;
import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final com.ss.android.lark.richtextmd.parse.impl.b b(Context r2) {
        Intrinsics.checkNotNullParameter(t9b.a.a, "<this>");
        Intrinsics.checkNotNullParameter(r2, "context");
        com.ss.android.lark.richtextmd.parse.impl.b r0 = new com.ss.android.lark.richtextmd.parse.impl.b(r2);
        a(r0, ExtRichTextMarkdownKt$fromRichText$1.INSTANCE);
        return r0;
    }

    public static final void a(com.ss.android.lark.richtextmd.parse.impl.b r1, Function1 r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "config");
        ((b) r2.invoke(com.ss.android.lark.richtextmd.parse.a.a)).a(r1);
    }

    public static final void c(d r1, RichTextElement.RichTextTag r2, b3c.a r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "handler");
        r1.a(r2, r3);
    }
}
