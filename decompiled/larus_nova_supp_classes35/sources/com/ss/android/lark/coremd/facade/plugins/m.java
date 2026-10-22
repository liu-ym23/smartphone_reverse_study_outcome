package com.ss.android.lark.coremd.facade.plugins;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.coremd.span.BlockQuoteSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m implements com.ss.android.lark.coremd.base.parse.f {
    public m() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void d(com.ss.android.lark.coremd.impl.parse.k r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void f(com.ss.android.lark.coremd.impl.parse.k r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void a(v7b.s r1, Spannable r2) {
        com.ss.android.lark.coremd.base.parse.f.a.b(r1, r2);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void b(com.ss.android.lark.coremd.impl.parse.d r1, v7b.s r2) {
        com.ss.android.lark.coremd.base.parse.f.a.a(r1, r2);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void g(com.ss.android.lark.coremd.impl.parse.d r10, SpannableStringBuilder r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "charSequence");
        Object[] r12 = r11.getSpans(0, r11.length(), BlockQuoteSpan.class);
        int r0 = r12.length;
        int r2 = -1;
        BlockQuoteSpan r3 = null;
        int r4 = 0;
    L4:
        if (r4 >= r0) goto L10;
        BlockQuoteSpan r6 = (BlockQuoteSpan) r12[r4];
        int r7 = r11.getSpanStart(r6);
        int r8 = r11.getSpanEnd(r6);
        if (r7 != (r2 + 1)) goto L9;
        if (r3 == null) goto L9;
        r6.c = false;
        r3.d = false;
    L9:
        r4 = r4 + 1;
        r3 = r6;
        r2 = r8;
        goto L4
    L10:
        if (r3 == null) goto L17;
        r3.d = true;
        return;
    }
}
