package com.ss.android.lark.coremd.impl.parse;

import android.text.Spannable;
import android.text.style.ClickableSpan;
import com.ss.android.lark.coremd.base.parse.p;
import com.ss.android.lark.coremd.base.parse.w;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MarkdownSpanSetterImpl implements w {
    public final d a;
    public final p b;
    public final g c;

    public static final class a {
    }

    static {
    }

    public MarkdownSpanSetterImpl(d r2) {
        Intrinsics.checkNotNullParameter(r2, "parseContext");
        this.a = r2;
        this.b = r2.e;
        this.c = r2.f;
    }

    @Override // com.ss.android.lark.coremd.base.parse.w
    public final void c(Spannable r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        x9b.e.B2.getClass();
        r3.setSpan(new x9b.d(), r4, r5, 33);
    }

    @Override // com.ss.android.lark.coremd.base.parse.w
    public final void a(Spannable r2, Object r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r3, "span");
        if ((r3 instanceof com.ss.android.lark.coremd.ext.a) == false) goto L8;
        Iterator<T> r7 = ((com.ss.android.lark.coremd.ext.a) r3).a.iterator();
    L6:
        if (r7.hasNext() == false) goto L11;
        r2.setSpan(r7.next(), r4, r5, 33);
        goto L6
    L11:
        return;
    L8:
        r2.setSpan(r3, r4, r5, r6);
    }

    @Override // com.ss.android.lark.coremd.base.parse.w
    public final void b(Spannable r6, final s r7, int r8, int r9, final int r10) {
        Intrinsics.checkNotNullParameter(r6, "builder");
        Intrinsics.checkNotNullParameter(r7, "node");
        Object[] r0 = r6.getSpans(r8, r9, ClickableSpan.class);
        Intrinsics.checkNotNull(r0);
        if (r0.length != 0) goto L5;
        boolean r1 = true;
    L7:
        if ((!r1) == false) goto L10;
        Log.d("MarkdownSpanSetterImpl", "bindNodeClick: alreadyHasClickableSpan for interval , start " + r8 + ", end " + r9);
        return;
    L10:
        final com.ss.android.lark.coremd.base.parse.n.b r2 = this.c.b(r7.getClass());
        if (r2 != null) goto L13;
        return;
    L13:
        r6.setSpan(new h(r7.getClass(), new MarkdownSpanSetterImpl$bindNodeClick$span$1(this.c), new MarkdownSpanSetterImpl$bindNodeClick$span$2(this, r7, r10, r2)), r8, r9, 33);
        return;
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.ss.android.lark.coremd.base.parse.w
    public final void d(Spannable r8, s r9, int r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "builder");
        Intrinsics.checkNotNullParameter(r9, "node");
        a(r8, new com.ss.android.lark.coremd.impl.buildnode.a(r9, r8.subSequence(r10, r11).toString(), r12), r10, r11, 33);
    }

    @Override // com.ss.android.lark.coremd.base.parse.w
    public final void e(Spannable r9, s r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r9, "builder");
        Intrinsics.checkNotNullParameter(r10, "node");
        Object r4 = this.b.a(this.a, r10);
        if (r4 != null) goto L5;
        return;
    L5:
        a(r9, r4, r11, r12, r13);
    }
}
