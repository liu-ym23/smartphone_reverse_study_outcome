package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import android.text.style.ClickableSpan;
import android.view.View;
import io.noties.markwon.core.spans.CustomCitationSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f extends ClickableSpan {
    public final CustomCitationSpan a;
    public final lw8.b b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        CustomCitationSpan r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "view");
        r0.b.d(r3, r0.e);
        lw8.b r4 = this.b;
        if (r4 == null) goto L6;
        r4.a(this.a);
        return;
    }

    public f(CustomCitationSpan r2, lw8.b r3) {
        Intrinsics.checkNotNullParameter(r2, "span");
        this.a = r2;
        this.b = r3;
    }
}
