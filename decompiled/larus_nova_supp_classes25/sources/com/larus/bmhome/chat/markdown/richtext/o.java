package com.larus.bmhome.chat.markdown.richtext;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o {
    public static final boolean a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.d != MessageMarkdownLinkSource.MARKDOWN_LINK) goto L7;
        Regex r0 = n.a;
        if (n.h(r2.c) == false) goto L7;
        return true;
    L7:
        return false;
    }
}
