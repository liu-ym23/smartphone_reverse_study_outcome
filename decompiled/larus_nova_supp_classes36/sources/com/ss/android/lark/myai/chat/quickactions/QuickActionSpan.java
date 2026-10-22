package com.ss.android.lark.myai.chat.quickactions;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.keyboard.edittext2.span.l;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class QuickActionSpan implements l {
    public static final /* synthetic */ int c = 0;
    public boolean a;
    public Lambda b;

    public static final class a {
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((com.ss.android.lark.myai.chat.quickactions.b.a) r1).b), Integer.valueOf(((com.ss.android.lark.myai.chat.quickactions.b.a) r2).b));
        }
    }

    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((IntRange) r1).getFirst()), Integer.valueOf(((IntRange) r2).getFirst()));
        }
    }

    static {
    }

    public QuickActionSpan() {
        this.b = QuickActionSpan$actionOnTextChange$1.INSTANCE;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.l
    public final void b(CharSequence r11) {
        Intrinsics.checkNotNullParameter(r11, "text");
        if (this.a == false) goto L6;
        return;
    L6:
        if ((r11 instanceof SpannableStringBuilder) == true) goto L8;
        return;
    L8:
        this.a = true;
        this.b.invoke(r11);
        this.b = QuickActionSpan$afterTextChange$1.INSTANCE;
        Spanned r1 = (Spanned) r11;
        Object[] r2 = r1.getSpans(0, r1.length(), QuickActionParamPlaceholderSpan.class);
        int r3 = r2.length;
        int r5 = 0;
    L9:
        if (r5 >= r3) goto L15;
        QuickActionParamPlaceholderSpan r6 = (QuickActionParamPlaceholderSpan) r2[r5];
        SpannableStringBuilder r7 = (SpannableStringBuilder) r11;
        int r8 = r7.getSpanStart(r6);
        int r9 = r7.getSpanEnd(r6);
        if (r8 != 0) goto L14;
        if (r9 <= 0) goto L14;
        r7.replace(0, r9, "");
    L14:
        r5 = r5 + 1;
        goto L9
    L15:
        Object[] r4 = r1.getSpans(0, r1.length(), QuickActionParamSpan.class);
        ArrayList r10 = new ArrayList(r4.length);
        int r12 = r4.length;
        int r13 = 0;
    L16:
        if (r13 >= r12) goto L18;
        QuickActionParamSpan r14 = (QuickActionParamSpan) r4[r13];
        SpannableStringBuilder r15 = (SpannableStringBuilder) r11;
        r10.add(new com.ss.android.lark.myai.chat.quickactions.b.a(r14, r15.getSpanStart(r14), r15.getSpanEnd(r14)));
        r13 = r13 + 1;
        goto L16
    L18:
        ArrayList r16 = new ArrayList();
        Iterator r17 = r10.iterator();
    L20:
        if (r17.hasNext() == false) goto L30;
        Object r18 = r17.next();
        com.ss.android.lark.myai.chat.quickactions.b.a r19 = (com.ss.android.lark.myai.chat.quickactions.b.a) r18;
        int r20 = r19.b;
        if (r20 < 0) goto L27;
        int r21 = r19.c;
        if (r21 < 0) goto L27;
        if (r21 < r20) goto L27;
        boolean r22 = true;
    L28:
        if (r22 == false) goto L20;
        r16.add(r18);
    L27:
        r22 = false;
        goto L28
    L30:
        List r0 = CollectionsKt.sortedWith(r16, new c());
        final SpannableStringBuilder r110 = (SpannableStringBuilder) r11;
        ArrayList r23 = new ArrayList();
        int r24 = r0.size();
        int r25 = 0;
        int r26 = 0;
    L31:
        if (r25 >= r24) goto L45;
        final com.ss.android.lark.myai.chat.quickactions.b.a r27 = (com.ss.android.lark.myai.chat.quickactions.b.a) ListProtector.get(r0, r25);
        r25 = r25 + 1;
        com.ss.android.lark.myai.chat.quickactions.b.a r28 = (com.ss.android.lark.myai.chat.quickactions.b.a) CollectionsKt.getOrNull(r0, r25);
        if (r28 == null) goto L35;
        int r29 = r28.b;
    L37:
        if (r27.c == r29) goto L38;
        IntRange r30 = new IntRange(r27.c, r29);
        QuickActionParamPlaceholderSpan r31 = (QuickActionParamPlaceholderSpan) ArraysKt.getOrNull(r110.getSpans(r30.getFirst(), r30.getLast(), QuickActionParamPlaceholderSpan.class), 0);
        if (r31 == null) goto L31;
        IntRange r32 = new IntRange(r110.getSpanStart(r31), r110.getSpanEnd(r31));
        if (Intrinsics.areEqual(r30, r32) == true) goto L31;
        final IntRange r33 = new IntRange(r32.getFirst() + r26, r32.getLast() + r26);
        r23.add(new QuickActionSpan$getSpanIndexActions$2(this, r110, r33));
        r26 = r26 - (r32.getLast() - r32.getFirst());
        goto L31
    L38:
        r27.a.getClass();
        final int r34 = r27.c + r26;
        r23.add(new QuickActionSpan$getSpanIndexActions$1(this, r110, r34, r27));
        r26 = r26 + r27.a.d.length();
        goto L31
    L35:
        r29 = r110.length();
        goto L37
    L45:
        Iterator r111 = r23.iterator();
    L47:
        if (r111.hasNext() == false) goto L49;
        ((Function0) r111.next()).invoke();
        goto L47
    L49:
        this.a = false;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.l
    public final void c(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.l
    public final void a(CharSequence r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "text");
        Intrinsics.checkNotNullParameter(r10, "text");
        if (this.a == false) goto L6;
        return;
    L6:
        if ((r10 instanceof SpannableStringBuilder) == true) goto L8;
        return;
    L8:
        if (r12 > r13) goto L10;
        return;
    L10:
        this.a = true;
        Spanned r14 = (Spanned) r10;
        Object[] r0 = r14.getSpans(0, r14.length(), QuickActionParamSpan.class);
        ArrayList r1 = new ArrayList(r0.length);
        int r3 = r0.length;
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L13;
        QuickActionParamSpan r5 = (QuickActionParamSpan) r0[r4];
        SpannableStringBuilder r7 = (SpannableStringBuilder) r10;
        r1.add(new IntRange(r7.getSpanStart(r5), r7.getSpanEnd(r5)));
        r4 = r4 + 1;
        goto L11
    L13:
        List r2 = CollectionsKt.sortedWith(r1, new d());
        Iterator r6 = r2.iterator();
        int r8 = 0;
    L15:
        if (r6.hasNext() == false) goto L28;
        Object r9 = r6.next();
        int r15 = r8 + 1;
        if (r8 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        IntRange r16 = (IntRange) r9;
        IntRange r17 = (IntRange) CollectionsKt.getOrNull(r2, r15);
        if (r17 == null) goto L22;
        int r18 = r17.getFirst();
    L23:
        int r19 = r16.getFirst();
        int r20 = r16.getLast();
        int r21 = r11 + r12;
        if (Math.max(r19, r11) >= Math.min(r20, r21)) goto L27;
        if (r21 >= r18) goto L27;
        ((SpannableStringBuilder) r10).setSpan(new b(), r20, r18, 33);
        this.b = new QuickActionSpan$beforeTextChange$1$1(this);
    L27:
        r8 = r15;
        goto L15
    L22:
        r18 = ((SpannableStringBuilder) r10).length();
        goto L23
    L28:
        int r110 = r12 + r11;
        Object[] r111 = r14.getSpans(r11, r110, com.ss.android.lark.myai.chat.quickactions.a.class);
        int r22 = r111.length;
        int r23 = 0;
    L29:
        if (r23 >= r22) goto L34;
        com.ss.android.lark.myai.chat.quickactions.a r24 = (com.ss.android.lark.myai.chat.quickactions.a) r111[r23];
        SpannableStringBuilder r25 = (SpannableStringBuilder) r10;
        int r26 = r25.getSpanStart(r24);
        int r27 = r25.getSpanEnd(r24);
        if (Math.max(r26, r11) >= Math.min(r27, r110)) goto L33;
        r25.removeSpan(r24);
    L33:
        r23 = r23 + 1;
        goto L29
    L34:
        this.a = false;
    }
}
