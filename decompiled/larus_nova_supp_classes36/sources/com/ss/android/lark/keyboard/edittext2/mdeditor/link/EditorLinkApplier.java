package com.ss.android.lark.keyboard.edittext2.mdeditor.link;

import android.text.InputFilter;
import android.text.NoCopySpan;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import com.ss.android.lark.keyboard.edittext2.widget.f;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EditorLinkApplier implements InputFilter {
    public final Function1<n, CharSequence> a;
    public final List<b> b;

    public static final class a {
    }

    static {
    }

    public final void a(TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "textView");
        List r0 = ArraysKt.toMutableList(r3.getFilters());
        r0.add(this);
        CollectionsKt.removeAll(r0, EditorLinkApplier$attach$1.INSTANCE);
        r3.setFilters((InputFilter[]) r0.toArray(new InputFilter[0]));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EditorLinkApplier(Function1<? super n, ? extends CharSequence> r2, List<? extends b> r3) {
        Intrinsics.checkNotNullParameter(r2, "linkParser");
        Intrinsics.checkNotNullParameter(r3, "regexResolvers");
        this.a = r2;
        this.b = r3;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r17, int r18, int r19, Spanned r20, int r21, int r22) {
        Intrinsics.checkNotNullParameter(r17, "source");
        if (r17.length() >= 10) goto L5;
        return r17;
    L5:
        long r7 = System.currentTimeMillis();
        ArrayList r4 = new ArrayList();
        boolean r5 = r17 instanceof Spanned;
        if (r5 == true) goto L8;
        r4.add(new IntRange(r18, r19));
    L18:
        if (r4.isEmpty() == false) goto L20;
        return r17;
    L20:
        ArrayList r11 = new ArrayList();
        Iterator r6 = r4.iterator();
    L22:
        if (r6.hasNext() == false) goto L30;
        IntRange r8 = (IntRange) r6.next();
        int r12 = r8.getFirst();
        int r9 = r8.getLast();
        Iterator<T> r13 = this.b.iterator();
    L25:
        if (r13.hasNext() == false) goto L22;
        List<b.a> r14 = ((b) r13.next()).a(r12, r9, r17);
        if (r14.isEmpty() == true) goto L25;
        r11.addAll(r14);
        goto L22
    L30:
        if (r11.isEmpty() == false) goto L32;
        return r17;
    L32:
        SpannableStringBuilder r15 = new SpannableStringBuilder(r17, r18, r19);
        if (r5 == false) goto L35;
        TextUtils.copySpansFrom(r15, r18, r19, NoCopySpan.class, r15, 0);
    L35:
        Iterator r1 = r11.iterator();
        int r2 = 0;
    L37:
        if (r1.hasNext() == false) goto L47;
        b.a r3 = (b.a) r1.next();
        int r10 = r3.b + r2;
        int r16 = r3.c + r2;
        CharSequence r23 = (CharSequence) this.a.invoke(r3.a);
        if (r10 < 0) goto L42;
        if (r10 >= r16) goto L42;
        boolean r24 = true;
    L43:
        if (r24 == false) goto L37;
        if (r16 > r15.length()) goto L37;
        r15.replace(r10, r16, r23);
        r2 = r2 + (r23.length() - (r16 - r10));
    L42:
        r24 = false;
        goto L43
    L47:
        Log.i("EditorLinkApplier", "regex find url count " + r11.size() + ", cost: " + (System.currentTimeMillis() - r7));
        return r15;
    L8:
        int r25 = r18;
    L9:
        if (r25 >= r19) goto L18;
        Spanned r110 = (Spanned) r17;
        int r111 = r110.nextSpanTransition(r25, r19, f.class);
        if (((f[]) r110.getSpans(r25, r111, f.class)).length != 0) goto L13;
        boolean r112 = true;
    L14:
        if (r112 == false) goto L16;
        r4.add(new IntRange(r25, r111));
    L16:
        r25 = r111;
        goto L9
    L13:
        r112 = false;
        goto L14
    }
}
