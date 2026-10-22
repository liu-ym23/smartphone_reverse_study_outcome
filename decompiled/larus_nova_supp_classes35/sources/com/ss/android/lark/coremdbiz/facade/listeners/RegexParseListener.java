package com.ss.android.lark.coremdbiz.facade.listeners;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import androidx.core.text.util.LinkifyCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.coremd.base.parse.f;
import com.ss.android.lark.coremd.impl.parse.d;
import com.ss.android.lark.coremd.impl.parse.k;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.span.g0;
import eab.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.b0;
import v7b.n;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class RegexParseListener implements f {
    public static final Lazy<Boolean> c = null;

    public static final class a {
    }

    public static final class b {
        public final s a;
        public final int b;
        public final int c;

        public b(s r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "node");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public boolean e(d r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return true;
    }

    public boolean h(d r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return true;
    }

    public boolean i(d r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return true;
    }

    public boolean j() {
        return false;
    }

    static {
        c = LazyKt.lazy(RegexParseListener$Companion$sCanSystemRecognizePhone$2.INSTANCE);
    }

    public RegexParseListener() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void d(k r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void f(k r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public static void c(s r1, List r2) {
        if ((r1 instanceof b0) == false) goto L6;
        ((ArrayList) r2).add(r1);
        return;
    L6:
        s r3 = r1.e;
    L7:
        if (r3 == null) goto L9;
        c(r3, r2);
        r3 = r3.h;
        goto L7
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void a(s r1, Spannable r2) {
        f.a.b(r1, r2);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void b(d r17, s r18) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "node");
        f.a.a(r17, r18);
        long r3 = System.currentTimeMillis();
        ArrayList r1 = new ArrayList();
        c(r18, r1);
        Iterator r0 = r1.iterator();
    L4:
        if (r0.hasNext() == false) goto L65;
        b0 r2 = (b0) r0.next();
        String r6 = r2.j;
        ArrayList r7 = new ArrayList();
        int r9 = 1;
        if (e(r17) == false) goto L16;
        Intrinsics.checkNotNull(r6);
        Matcher r8 = g0.e.matcher(r6);
    L9:
        if (r8.find() == false) goto L16;
        String r11 = r8.group(2);
        String r12 = r8.group(1);
        if (r11 == null) goto L9;
        if (r12 == null) goto L9;
        r7.add(new b(new eab.a(r11, r12), r8.start(), r8.end()));
    L16:
        if (h(r17) == false) goto L21;
        Intrinsics.checkNotNull(r6);
        Matcher r10 = g0.d.matcher(r6);
    L19:
        if (r10.find() == false) goto L21;
        String r13 = r10.group();
        r7.add(new b(new n(r13, r13), r10.start(), r10.end()));
    L21:
        int r14 = 0;
        if (i(r17) == false) goto L42;
        Intrinsics.checkNotNull(r6);
        Matcher r15 = g0.f.matcher(r6);
    L25:
        if (r15.find() == false) goto L28;
        r7.add(new b(new g(r15.group()), r15.start(), r15.end()));
        goto L25
    L28:
        if (((Boolean) c.getValue()).booleanValue() == false) goto L37;
        Log.i("PhoneNumberParseListener", "parsePhoneSpan: use system phone parse");
        SpannableString r5 = new SpannableString(r6);
        if (j() == false) goto L32;
        LinkifyCompat.addLinks(r5, com.ss.android.lark.widget.utils.a.a(j()), "tel:");
    L33:
        Iterator r16 = ArrayIteratorKt.iterator((ClickableSpan[]) r5.getSpans(0, r5.length(), ClickableSpan.class));
    L35:
        if (r16.hasNext() == false) goto L42;
        ClickableSpan r19 = (ClickableSpan) r16.next();
        int r110 = r5.getSpanStart(r19);
        int r111 = r5.getSpanEnd(r19);
        r7.add(new b(new g(r6.substring(r110, r111)), r110, r111));
        goto L35
    L32:
        LinkifyCompat.addLinks(r5, 4);
        goto L33
    L37:
        Log.i("PhoneNumberParseListener", "parsePhoneSpan: use regex phone parse");
        Matcher r20 = com.ss.android.lark.widget.utils.a.a(false).matcher(r6);
    L39:
        if (r20.find() == false) goto L42;
        r7.add(new b(new g(r20.group()), r20.start(), r20.end()));
    L42:
        if (r7.isEmpty() == false) goto L44;
        List r21 = CollectionsKt.emptyList();
    L52:
        if (r21.isEmpty() == true) goto L4;
        Iterator r22 = r21.iterator();
        s r23 = r2;
    L56:
        if (r22.hasNext() == false) goto L62;
        b r24 = (b) r22.next();
        if (r24.b <= r14) goto L60;
        Intrinsics.checkNotNull(r6);
        b0 r112 = new b0(r6.substring(r14, r24.b));
        r23.k(r112);
        r23 = r112;
    L60:
        s r25 = r24.a;
        r23.k(r25);
        r14 = r24.c;
        r23 = r25;
        goto L56
    L62:
        if (r6.length() <= r14) goto L64;
        Intrinsics.checkNotNull(r6);
        r23.k(new b0(r6.substring(r14, r6.length())));
    L64:
        r2.p();
        goto L4
    L44:
        CollectionsKt.sortWith(r7, ComparisonsKt.compareBy(new Function1[]{RegexParseListener$removeOverlappingIntervals$1.INSTANCE, RegexParseListener$removeOverlappingIntervals$2.INSTANCE}));
        ArrayList r26 = new ArrayList();
        b r27 = (b) ListProtector.get(r7, 0);
        int r113 = r7.size();
    L45:
        if (r9 >= r113) goto L50;
        b r114 = (b) ListProtector.get(r7, r9);
        if (r114.b < r27.c) goto L49;
        r26.add(r27);
        r27 = r114;
    L49:
        r9 = r9 + 1;
        goto L45
    L50:
        r26.add(r27);
        r21 = r26;
        goto L52
    L65:
        Log.i("PhoneNumberParseListener", "RegexParseListener regex parse cost " + (System.currentTimeMillis() - r3) + " mills");
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void g(d r2, SpannableStringBuilder r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "charSequence");
    }
}
