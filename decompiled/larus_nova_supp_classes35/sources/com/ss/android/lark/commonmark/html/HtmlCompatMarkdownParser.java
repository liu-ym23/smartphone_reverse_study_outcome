package com.ss.android.lark.commonmark.html;

import com.ss.android.lark.conditional.access.display.DisplayUtilsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import v7b.s;
import w7b.d;
import w7b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class HtmlCompatMarkdownParser {
    public boolean a;
    public Lambda b;
    public final a c;
    public d d;

    public static final class a implements e {
        public final /* synthetic */ HtmlCompatMarkdownParser a;

        public a(HtmlCompatMarkdownParser r1) {
            this.a = r1;
        }

        @Override // w7b.e
        public final s a(s r2) {
            return (s) this.a.b.invoke(r2);
        }
    }

    public HtmlCompatMarkdownParser() {
        this.b = HtmlCompatMarkdownParser$processorDelegate$1.INSTANCE;
        this.c = new a(this);
    }

    public final HtmlCompatMarkdownParser a(final DisplayUtilsKt.d r2) {
        Intrinsics.checkNotNullParameter(r2, "factory");
        this.b = new HtmlCompatMarkdownParser$handleHtml$1$1(r2);
        return this;
    }

    public final s b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "markdownString");
        d r0 = this.d;
        if (r0 != null) goto L7;
        d.a r1 = new d.a();
        r1.a(this.c);
        r1.a(new c(this.a));
        d r2 = new d(r1);
        this.d = r2;
        Intrinsics.checkNotNull(r2);
        r0 = r2;
    L7:
        return r0.a(r4);
    }
}
