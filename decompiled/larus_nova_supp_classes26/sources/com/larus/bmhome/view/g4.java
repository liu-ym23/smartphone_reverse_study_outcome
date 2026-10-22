package com.larus.bmhome.view;

import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g4<T> implements SpanWatcher {
    public final KClass<T> a;
    public int b;
    public int c;

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable r1, Object r2, int r3, int r4) {
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable r1, Object r2, int r3, int r4) {
    }

    public g4(KClass<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "kClass");
        this.a = r2;
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable r3, Object r4, int r5, int r6, int r7, int r8) {
        if (r4 != Selection.SELECTION_END) goto L18;
        if (this.c == r7) goto L18;
        this.c = r7;
        if (r3 == null) goto L18;
        Object[] r9 = r3.getSpans(r7, r8, JvmClassMappingKt.getJavaClass(this.a));
        if (r9 == null) goto L18;
        Object r10 = ArraysKt.firstOrNull(r9);
        if (r10 == null) goto L18;
        int r11 = r3.getSpanStart(r10);
        int r12 = r3.getSpanEnd(r10);
        if (Math.abs(this.c - r12) > Math.abs(this.c - r11)) goto L16;
        r11 = r12;
    L16:
        Selection.setSelection(r3, Selection.getSelectionStart(r3), r11);
    L18:
        if (r4 == Selection.SELECTION_START) goto L20;
        return;
    L20:
        if (this.b == r7) goto L34;
        this.b = r7;
        if (r3 == null) goto L35;
        Object[] r13 = r3.getSpans(r7, r8, JvmClassMappingKt.getJavaClass(this.a));
        if (r13 == null) goto L36;
        Object r14 = ArraysKt.firstOrNull(r13);
        if (r14 == null) goto L37;
        int r15 = r3.getSpanStart(r14);
        int r16 = r3.getSpanEnd(r14);
        if (Math.abs(this.b - r16) > Math.abs(this.b - r15)) goto L31;
        r15 = r16;
    L31:
        Selection.setSelection(r3, r15, Selection.getSelectionEnd(r3));
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    }
}
