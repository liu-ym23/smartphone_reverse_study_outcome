package com.ss.android.lark.coremd.facade.listeners;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.ss.android.lark.coremd.span.BlockQuoteSpan;
import com.ss.android.lark.widget.codeblock.preview.CodeBlockV2Span;
import com.ss.android.lark.widget.span.e0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public static final Set<Class<? extends Object>> a = null;

    static {
        a = SetsKt.setOf(new Class[]{ImageSpan.class, CodeBlockV2Span.class, y9b.a.class, BlockQuoteSpan.class});
    }

    public static int a(SpannableStringBuilder r6, Class r7) {
        Object[] r8 = r6.getSpans(0, r6.length(), r7);
        Intrinsics.checkNotNull(r8);
        int r2 = 1;
        if (r8.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return -1;
    L10:
        if (r8.length != 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L27;
        Object r3 = r8[0];
        int r4 = ArraysKt.getLastIndex(r8);
        if (r4 == 0) goto L25;
        int r5 = r6.getSpanEnd(r3);
        if (1 > r4) goto L25;
    L19:
        Object r9 = r8[r2];
        int r10 = r6.getSpanEnd(r9);
        if (r5 >= r10) goto L22;
        r3 = r9;
        r5 = r10;
    L22:
        if (r2 == r4) goto L25;
        r2 = r2 + 1;
    L25:
        return r6.getSpanEnd(r3);
    L27:
        throw new NoSuchElementException();
    L12:
        r1 = false;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public static void b(SpannableStringBuilder r9, Context r10) {
        Intrinsics.checkNotNullParameter(r9, "builder");
        Intrinsics.checkNotNullParameter(r10, "context");
        Iterator<T> r0 = a.iterator();
        if (r0.hasNext() == false) goto L39;
        int r1 = a(r9, (Class) r0.next());
    L6:
        if (r0.hasNext() == false) goto L10;
        int r2 = a(r9, (Class) r0.next());
        if (r1 >= r2) goto L6;
        r1 = r2;
        goto L6
    L10:
        boolean r3 = false;
        if (r1 != (-1)) goto L14;
    L35:
        if (r3 == false) goto L48;
        r9.append("\n\n");
        e0.a r4 = new e0.a();
        r4.a = zz7.b.g(r10, 5);
        r9.setSpan(new e0(r4), r9.length() - 1, r9.length(), 33);
        return;
    L48:
        return;
    L14:
        if (r1 == r9.length()) goto L34;
        x9b.e[] r5 = (x9b.e[]) r9.getSpans(r1, r9.length(), x9b.e.class);
        if (r5.length != 0) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == true) goto L35;
        ArrayList r7 = new ArrayList(r5.length);
        int r8 = r5.length;
        int r11 = 0;
    L23:
        if (r11 >= r8) goto L25;
        x9b.e r12 = r5[r11];
        r7.add(TuplesKt.to(Integer.valueOf(r9.getSpanStart(r12)), Integer.valueOf(r9.getSpanEnd(r12))));
        r11 = r11 + 1;
        goto L23
    L25:
        Iterator r13 = CollectionsKt.sortedWith(r7, new e()).iterator();
    L27:
        if (r13.hasNext() == false) goto L33;
        Pair r14 = (Pair) r13.next();
        if (((Number) r14.getFirst()).intValue() > r1) goto L35;
        r1 = Math.max(r1, ((Number) r14.getSecond()).intValue());
        goto L27
    L33:
        if (r1 < r9.length()) goto L35;
    L19:
        r6 = false;
    L34:
        r3 = true;
        goto L35
    L39:
        throw new NoSuchElementException();
    }
}
