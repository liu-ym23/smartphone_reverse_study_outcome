package com.ss.android.lark.richtextmd.parse.plugins;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.lark.coremd.base.parse.s;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RichTextDigestParsePlugin$configure$1 implements com.ss.android.lark.coremd.base.parse.f, com.ss.android.lark.coremd.ext.f {
    public static final /* synthetic */ KProperty<Object>[] f = null;
    public final com.ss.android.lark.coremd.ext.c c;
    public final com.ss.android.lark.coremd.ext.c d;
    public final /* synthetic */ a e;

    static {
        f = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(RichTextDigestParsePlugin$configure$1.class, "prevEnd", "getPrevEnd(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)I", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(RichTextDigestParsePlugin$configure$1.class, "curCountLen", "getCurCountLen(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)I", 0))};
    }

    public RichTextDigestParsePlugin$configure$1(a r10) {
        this.e = r10;
        final int r0 = 0;
        Function1<com.ss.android.lark.coremd.ext.j, Integer> r1 = new RichTextDigestParsePlugin$configure$1$special$$inlined$extend$1(r0);
        Intrinsics.checkNotNullParameter(r1, "defaultProvider");
        KProperty<Object>[] r3 = f;
        KProperty<Object> r11 = r3[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r11, "property");
        ConcurrentHashMap r6 = com.ss.android.lark.coremd.ext.d.a;
        Intrinsics.checkNotNullParameter(r11, "kProperty");
        Intrinsics.checkNotNullParameter(r1, "value");
        ConcurrentHashMap r8 = com.ss.android.lark.coremd.ext.d.a;
        r8.put(com.ss.android.lark.coremd.ext.e.a(r11), r1);
        this.c = new com.ss.android.lark.coremd.ext.c();
        Function1<com.ss.android.lark.coremd.ext.j, Integer> r12 = new RichTextDigestParsePlugin$configure$1$special$$inlined$extend$2(r0);
        Intrinsics.checkNotNullParameter(r12, "defaultProvider");
        KProperty<Object> r2 = r3[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r2, "property");
        Intrinsics.checkNotNullParameter(r2, "kProperty");
        Intrinsics.checkNotNullParameter(r12, "value");
        r8.put(com.ss.android.lark.coremd.ext.e.a(r2), r12);
        this.d = new com.ss.android.lark.coremd.ext.c();
    }

    public final void d(com.ss.android.lark.coremd.impl.parse.k r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        com.ss.android.lark.coremd.ext.c r1 = this.c;
        KProperty<Object>[] r2 = f;
        int r3 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(((Number) r1.getValue(r8, r2[0])).intValue(), 0), r8.g.length());
        s r4 = r8.g;
        String r5 = r4.c(r3, r4.length());
        Intrinsics.checkNotNullParameter(r8, "<this>");
        int r6 = ((Number) this.d.getValue(r8, r2[1])).intValue() + com.ss.android.lark.widget.richtext.i.b(r5, this.e.a);
        Intrinsics.checkNotNullParameter(r8, "<this>");
        this.d.setValue(r8, r2[1], Integer.valueOf(r6));
        if (this.e.a.a == false) goto L7;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (((Number) this.d.getValue(r8, r2[1])).intValue() <= this.e.b) goto L7;
        r8.f.b();
    L7:
        int r7 = r8.g.length();
        Intrinsics.checkNotNullParameter(r8, "<this>");
        this.c.setValue(r8, r2[0], Integer.valueOf(r7));
    }

    public final void f(com.ss.android.lark.coremd.impl.parse.k r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void a(v7b.s r1, Spannable r2) {
        com.ss.android.lark.coremd.base.parse.f.a.b(r1, r2);
    }

    public final void b(com.ss.android.lark.coremd.impl.parse.d r6, v7b.s r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "node");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        com.ss.android.lark.coremd.ext.c r0 = this.c;
        KProperty<Object>[] r1 = f;
        r0.setValue(r6, r1[0], 0);
        Intrinsics.checkNotNullParameter(r6, "<this>");
        this.d.setValue(r6, r1[1], 0);
    }

    public final void g(com.ss.android.lark.coremd.impl.parse.d r6, SpannableStringBuilder r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "charSequence");
        iec.g r8 = this.e.a;
        int r2 = 1;
        if (r8.b == false) goto L5;
    L24:
        int r9 = r7.length();
    L25:
        if (r9 < r2) goto L29;
        int r0 = r9 - r2;
        if (r7.charAt(r0) != '\n') goto L38;
        r7.replace(r0, r0 + 1, " ");
        r2 = r2 + 1;
        goto L25
    L38:
        return;
    L29:
        return;
    L5:
        if (r8.e.a == false) goto L10;
        Pattern r10 = PatternProtector.compile("  +");
        Matcher r1 = r10.matcher(r7);
    L8:
        if (r1.find() == false) goto L24;
        r7.replace(r1.start(), r1.end(), " ");
        r1 = r10.matcher(r7);
        goto L8
    L10:
        int r11 = 0;
    L12:
        if (r11 >= r7.length()) goto L24;
        int r3 = r11;
    L15:
        if (r3 >= r7.length()) goto L20;
        if (r7.charAt(r3) != ' ') goto L20;
        r3 = r3 + 1;
    L20:
        if ((r3 - r11) <= 1) goto L22;
        r7.replace(r11, r3, " ");
    L23:
        r11 = r11 + 1;
        goto L12
    L22:
        r11 = r3;
        goto L23
    }
}
