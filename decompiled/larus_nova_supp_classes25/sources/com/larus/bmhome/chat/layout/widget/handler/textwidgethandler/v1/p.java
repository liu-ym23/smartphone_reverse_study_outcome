package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1;

import io.noties.markwon.core.spans.CustomCitationSpan;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p implements lw8.b {
    public final /* synthetic */ l a;

    public p(l r1) {
        this.a = r1;
    }

    public final void a(CustomCitationSpan r3) {
        Intrinsics.checkNotNullParameter(r3, "span");
        l r0 = this.a;
        fh8.r r1 = r0.d;
        if (r1 == null) goto L7;
        Function1<lw8.g, Unit> r2 = r1.f;
        if (r2 == null) goto L7;
        r2.invoke(r3);
        return;
    L7:
        r0.h().d(r3);
    }
}
