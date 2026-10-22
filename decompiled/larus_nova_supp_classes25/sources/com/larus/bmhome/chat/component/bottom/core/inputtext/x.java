package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x implements TextWatcher {
    public final /* synthetic */ ChatInputWithMentionDelegate a;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((Integer) ((Pair) r2).getFirst(), (Integer) ((Pair) r1).getFirst());
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public x(ChatInputWithMentionDelegate r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r5) {
        this.a.h(r5);
        ChatInputWithMentionDelegate r0 = this.a;
        if (r0.i == false) goto L5;
        return;
    L5:
        if (r0.j.isEmpty() == true) goto L34;
        if (r5 == null) goto L35;
        List<l0> r1 = this.a.j;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L10:
        if (r3.hasNext() == false) goto L18;
        l0 r4 = (l0) r3.next();
        int r6 = r5.getSpanStart(r4);
        int r7 = r5.getSpanEnd(r4);
        if (r6 < 0) goto L15;
        if (r7 <= r6) goto L15;
        Pair r8 = TuplesKt.to(Integer.valueOf(r6), Integer.valueOf(r7));
    L16:
        if (r8 == null) goto L10;
        r2.add(r8);
    L15:
        r8 = null;
        goto L16
    L18:
        List r9 = CollectionsKt.sortedWith(CollectionsKt.distinct(r2), new a());
        ChatInputWithMentionDelegate r10 = this.a;
        r10.j = CollectionsKt.emptyList();
        if (r9.isEmpty() == false) goto L21;
        return;
    L21:
        this.a.i = true;
        Iterator r11 = r9.iterator();
    L23:
        if (r11.hasNext() == false) goto L25;
        Pair r12 = (Pair) r11.next();
        r5.delete(((Number) r12.component1()).intValue(), ((Number) r12.component2()).intValue());
        goto L23
    L25:
        this.a.i = false;
        return;
    L35:
        return;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        ChatInputWithMentionDelegate r14 = this.a;
        if (r14.i == true) goto L27;
        if (r12 > 0) goto L7;
        return;
    L7:
        if ((r10 instanceof Editable) == false) goto L9;
        Editable r15 = (Editable) r10;
    L10:
        if (r15 != null) goto L12;
        return;
    L12:
        Object[] r0 = r15.getSpans(0, r15.length(), l0.class);
        ArrayList r1 = new ArrayList();
        int r3 = r0.length;
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L22;
        Object r5 = r0[r4];
        l0 r6 = (l0) r5;
        int r7 = r15.getSpanStart(r6);
        int r8 = r15.getSpanEnd(r6);
        if (r7 >= (r11 + r12)) goto L18;
        if (r8 <= r11) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == false) goto L21;
        r1.add(r5);
    L21:
        r4 = r4 + 1;
    L18:
        r9 = false;
        goto L19
    L22:
        r14.j = r1;
        return;
    L9:
        r15 = null;
        goto L10
    }
}
