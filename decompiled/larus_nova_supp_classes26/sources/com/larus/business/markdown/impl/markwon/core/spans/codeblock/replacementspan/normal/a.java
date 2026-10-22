package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal;

import android.content.Context;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.larus.bmhome.share.panel.ShareType;
import java.util.Map;
import jw8.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements c {
    public DefaultMarkdownCodeView a;

    public a() {
    }

    @Override // jw8.c
    public final void f() {
    }

    @Override // jw8.c
    public final View a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        DefaultMarkdownCodeView r0 = this.a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new DefaultMarkdownCodeView(r5, null, 6, 0);
    }

    @Override // jw8.c
    public final Size b(TextView r2, Spanned r3, jw8.b r4, Map r5, int r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        Intrinsics.checkNotNullParameter(r3, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r4, "span");
        int r8 = 0;
        if (this.a != null) goto L5;
        this.a = new DefaultMarkdownCodeView(r2.getContext(), null, 6, 0);
    L5:
        DefaultMarkdownCodeView r9 = this.a;
        if (r9 == null) goto L14;
        String r10 = r4.getCode();
        if (r10 != null) goto L10;
        r10 = "";
    L10:
        String r11 = r4.getLanguage();
        if (r11 != null) goto L13;
        r11 = "c";
    L13:
        r9.b(r10, r11);
    L14:
        DefaultMarkdownCodeView r12 = this.a;
        if (r12 == null) goto L17;
        r12.measure(0, 0);
    L17:
        DefaultMarkdownCodeView r13 = this.a;
        if (r13 == null) goto L21;
        r8 = r13.getMeasuredHeight();
    L21:
        return new Size(r6, r8);
    }
}
