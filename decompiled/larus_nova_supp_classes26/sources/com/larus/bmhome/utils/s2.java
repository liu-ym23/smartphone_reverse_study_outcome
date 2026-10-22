package com.larus.bmhome.utils;

import android.text.SpannableStringBuilder;
import android.text.style.LeadingMarginSpan;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.business.markdown.impl.markwon.MarkwonContent;
import io.noties.markwon.core.spans.CustomCitationSpan;
import io.noties.markwon.ext.onetex.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s2 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public s2() {
    }

    public static String a(lw8.l r9, FormatSource r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, MusicAppletPage.KEY_SOURCE);
        if (r9 != null) goto L6;
        return "";
    L6:
        SpannableStringBuilder r12 = r9.e();
        int r0 = r12.length();
        StringBuilder r1 = new StringBuilder(r12.subSequence(0, r0));
        if (r11 == true) goto L78;
        if ((r9 instanceof MarkwonContent) == false) goto L11;
        MarkwonContent r13 = (MarkwonContent) r9;
    L12:
        if (r13 == null) goto L78;
        ArrayList r14 = new ArrayList();
        List r15 = ArraysKt.toList(r13.a.getSpans(0, r0, c.class));
        ArrayList r3 = new ArrayList();
        Iterator r16 = r15.iterator();
    L14:
        boolean r5 = true;
        if (r16.hasNext() == false) goto L23;
        Object r4 = r16.next();
        SpannableStringBuilder r7 = r13.a;
        int r6 = r7.getSpanStart((c) r4);
        if (r6 < 0) goto L20;
        if (r6 >= r0) goto L20;
    L21:
        if (r5 == false) goto L14;
        r3.add(r4);
    L20:
        r5 = false;
        goto L21
    L23:
        List r17 = ArraysKt.toList(r13.a.getSpans(0, r0, LeadingMarginSpan.class));
        List r8 = ArraysKt.toList(r13.a.getSpans(0, r0, CustomCitationSpan.class));
        r14.addAll(r3);
        r14.addAll(r17);
        r14.addAll(r8);
        List r18 = CollectionsKt.toMutableList(CollectionsKt.sortedWith(r14, new r2(r13)));
        c r19 = (c) CollectionsKt.lastOrNull(r3);
        Iterator r110 = r18.iterator();
    L24:
        int r20 = 0;
    L26:
        if (r110.hasNext() == false) goto L78;
        Object r21 = r110.next();
        if ((r21 instanceof io.noties.markwon.core.spans.q) == true) goto L29;
        if ((r21 instanceof io.noties.markwon.core.spans.c) == true) goto L38;
        if ((r21 instanceof c) == true) goto L47;
        if ((r21 instanceof CustomCitationSpan) == false) goto L26;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L72
        int r23 = r13.a.getSpanStart(r21);     // Catch: Throwable -> L72
        int r24 = r13.a.getSpanEnd(r21);     // Catch: Throwable -> L72
        if (r23 < 0) goto L66;
        if (r23 >= r0) goto L66;
        boolean r25 = true;
    L67:
        if (r25 == false) goto L70;
        if (r24 > r0) goto L70;
        r1.replace(r23 + 0, r24 + 0, " ");     // Catch: Throwable -> L72
    L70:
        Object r26 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L72
    L74:
        Throwable r27 = Result.exceptionOrNull-impl(r26);
        if (r27 == null) goto L26;
        com.larus.platform.service.g.a.ensureNotReachHere(r27);
    L66:
        r25 = false;
    L72:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L74
    L47:
        int r29 = r13.a.getSpanStart(r21);
        r20 = r20 + (r13.a.getSpanEnd(r21) - r29);
        c r30 = (c) r21;
        Integer r31 = r30.e.o;
        if (r31 == null) goto L53;
        if (r31.intValue() != 0) goto L53;
    L54:
        if (r29 < 0) goto L57;
        if (r29 >= r0) goto L57;
        boolean r32 = true;
    L58:
        if (r32 == false) goto L26;
        int r33 = r29 + 0;
        r1.delete(r33, r20 + r33);
        r1.insert(r33, ((wsc.a) r30.e).a);
    L57:
        r32 = false;
    L53:
        if (Intrinsics.areEqual(r19, r21) == false) goto L26;
    L38:
        int r34 = r13.a.getSpanStart(r21);
        if (r34 < 0) goto L42;
        if (r34 >= r0) goto L42;
        boolean r35 = true;
    L43:
        if (r35 == false) goto L26;
        r1.insert(r34 + 0, "- ");
    L42:
        r35 = false;
        goto L43
    L29:
        int r36 = r13.a.getSpanStart(r21);
        if (r36 < 0) goto L33;
        if (r36 >= r0) goto L33;
        boolean r37 = true;
    L34:
        if (r37 == false) goto L26;
        int r38 = r36 + 0;
        r1.insert(r38, ((io.noties.markwon.core.spans.q) r21).i);
    L33:
        r37 = false;
        goto L34
    L11:
        r13 = null;
    L78:
        return StringsKt.trim(r1.toString()).toString();
    }

    public static /* synthetic */ String b(lw8.l r0, FormatSource r1, int r2) {
        if ((r2 & 2) == 0) goto L6;
        r1 = FormatSource.UNKNOWN;
    L6:
        return a(r0, r1, false);
    }
}
