package com.larus.business.markdown.impl.widget;

import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.impl.common.MarkdownConfigManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import lsc.i;
import lsc.y;
import lw8.h;
import org.commonmark.node.Document;
import org.commonmark.node.HtmlBlock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class MarkdownWidgetHelper {
    public static final CoroutineScope a = null;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((pw8.b) r1).priority()), Integer.valueOf(((pw8.b) r2).priority()));
        }
    }

    static {
        a = CoroutineScopeKt.MainScope();
    }

    public static Document a(List r2) {
        Document r0 = new Document();
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.b((uvc.b) r3.next());
        goto L4
    L6:
        return r0;
    }

    public static boolean b(List r16, List r17, lsc.f r18, boolean r19) {
        com.larus.business.markdown.api.depend.d r2 = IMarkdownLoggerKt.a();
        if (r2 == null) goto L14;
        StringBuilder r5 = new StringBuilder("currentNodeListContainsAllLastNodeList \n lastNodeList size ");
        if (r16 == null) goto L7;
        Integer r6 = Integer.valueOf(r16.size());
    L8:
        r5.append(r6);
        r5.append(", currentNodeList size ");
        if (r17 == null) goto L11;
        Integer r7 = Integer.valueOf(r17.size());
    L12:
        r5.append(r7);
        r2.d("MarkdownWidgetHelper", r5.toString());
        goto L14
    L11:
        r7 = null;
        goto L12
    L7:
        r6 = null;
    L14:
        if (r16 == null) goto L86;
        if (r17 == null) goto L86;
        Iterator r8 = r16.iterator();
    L18:
        boolean r9 = true;
        if (r8.hasNext() == false) goto L82;
        int r10 = r16.indexOf((uvc.b) r8.next());
        if (r19 == false) goto L23;
        int r11 = f.a;
        boolean r12 = f.b((uvc.b) ListProtector.get(r16, r10), (uvc.b) ListProtector.get(r17, r10));
    L44:
        if (Intrinsics.areEqual(ListProtector.get(r16, r10).getClass(), ListProtector.get(r17, r10).getClass()) == false) goto L78;
        if (r12 == false) goto L78;
        HtmlBlock r13 = (uvc.b) ListProtector.get(r16, r10);
        HtmlBlock r14 = (uvc.b) ListProtector.get(r17, r10);
        if ((r13 instanceof HtmlBlock) == true) goto L50;
    L54:
        boolean r15 = true;
    L55:
        if (r15 == false) goto L56;
        uvc.b r20 = (uvc.b) ListProtector.get(r16, r10);
        if (r20 == null) goto L62;
        uvc.b r21 = r20.b;
        if (r21 == null) goto L62;
        uvc.b r22 = r21.b;
    L63:
        uvc.b r23 = (uvc.b) ListProtector.get(r17, r10);
        if (r23 == null) goto L68;
        uvc.b r24 = r23.b;
        if (r24 == null) goto L68;
        uvc.b r25 = r24.b;
    L70:
        if ((r22 instanceof HtmlBlock) == false) goto L76;
        if ((r25 instanceof HtmlBlock) == false) goto L76;
        if (Intrinsics.areEqual(((HtmlBlock) r22).h, ((HtmlBlock) r25).h) == true) goto L76;
        r9 = false;
    L76:
        if (r9 == true) goto L18;
        return false;
    L68:
        r25 = null;
    L62:
        r22 = null;
        goto L63
    L56:
        return false;
    L50:
        if ((r14 instanceof HtmlBlock) == false) goto L54;
        if (Intrinsics.areEqual(r13.h, r14.h) == true) goto L54;
        r15 = false;
    L78:
        com.larus.business.markdown.api.depend.d r4 = IMarkdownLoggerKt.a();
        if (r4 == null) goto L81;
        r4.d("MarkdownWidgetHelper", "not equal node with : lastNodeList[index].javaClass = " + ListProtector.get(r16, r10).getClass() + " , currentNodeList[index].javaClass = " + ListProtector.get(r17, r10).getClass());
    L81:
        return false;
    L23:
        i r26 = (i) r18;
        y.b r27 = r26.b((uvc.b) ListProtector.get(r16, r10), null, null);
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        y.b r28 = r26.b((uvc.b) ListProtector.get(r17, r10), null, null);
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        if (Intrinsics.areEqual(r27.toString(), r28.toString()) == false) goto L42;
        Object[] r110 = r27.getSpans(0, r27.length(), Object.class);
        Object[] r111 = r28.getSpans(0, r28.length(), Object.class);
        com.larus.business.markdown.api.depend.d r112 = IMarkdownLoggerKt.a();
        if (r112 == null) goto L30;
        r112.d("MarkdownWidgetHelper", "lastSpanCount = " + r110.length + " , currentSpanCount = " + r111.length);
    L30:
        if (r110.length != r111.length) goto L42;
        int r113 = r110.length;
        int r114 = 0;
    L32:
        if (r114 >= r113) goto L41;
        if (r27.getSpanStart(r110[r114]) != r28.getSpanStart(r111[r114])) goto L42;
        if (r27.getSpanEnd(r110[r114]) != r28.getSpanEnd(r111[r114])) goto L42;
        if (r27.getSpanFlags(r110[r114]) != r28.getSpanFlags(r111[r114])) goto L42;
        r114 = r114 + 1;
        goto L32
    L41:
        r12 = true;
    L42:
        r12 = false;
        goto L44
    L82:
        com.larus.business.markdown.api.depend.d r1 = IMarkdownLoggerKt.a();
        if (r1 == null) goto L85;
        r1.d("MarkdownWidgetHelper", "size =  " + r16.size() + " contains all node list");
    L85:
        return true;
    L86:
        return false;
    }

    public static void d(Context r14, int r15, List r16, uvc.b r17, List r18, final ViewGroup r19, h r20, final Function0 r21) {
        List r1 = r16;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
        int r4 = 0;
    L3:
        pw8.a r6 = null;
        if (r3.hasNext() == false) goto L29;
        Object r5 = r3.next();
        int r7 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        uvc.b r11 = (uvc.b) r5;
        boolean r8 = true;
        if (r16.indexOf(r11) == (r16.size() - 1)) goto L12;
        r8 = false;
    L12:
        Boolean r12 = Boolean.valueOf(r8);
        if (r18 == null) goto L28;
        List r9 = CollectionsKt.sortedWith(r18, new e());
        if (r9 == null) goto L28;
        List r10 = CollectionsKt.reversed(r9);
        if (r10 == null) goto L28;
        Iterator r13 = r10.iterator();
    L20:
        if (r13.hasNext() == false) goto L24;
        Object r22 = r13.next();
        if (((pw8.b) r22).c(r11) == false) goto L20;
    L25:
        pw8.b r23 = (pw8.b) r22;
        if (r23 == null) goto L28;
        r6 = r23.a(r14, r15, r11, r12, r20);
        goto L28
    L24:
        r22 = null;
    L28:
        r2.add(r6);
        r4 = r7;
        goto L3
    L29:
        final List r0 = CollectionsKt.filterNotNull(r2);
        Runnable r24 = new d(r21, r0, r19);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L32;
        BuildersKt.launch$default(a, null, null, new MarkdownWidgetHelper$generateWidgetFromNodeList$1(r24, null), 3, null);
        return;
    L32:
        r24.run();
    }

    public static void e(Context r11, int r12, uvc.b r13, List r14, ViewGroup r15, int r16, Boolean r17, h r18) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L28
        Job r10 = null;
        if (r14 == null) goto L17;
        List r2 = CollectionsKt.sortedWith(r14, new a());     // Catch: Throwable -> L28
        if (r2 == null) goto L17;
        List r3 = CollectionsKt.reversed(r2);     // Catch: Throwable -> L28
        if (r3 == null) goto L17;
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L28
    L11:
        if (r4.hasNext() == false) goto L15;
        Object r5 = r4.next();     // Catch: Throwable -> L28
        if (((pw8.b) r5).c(r13) == false) goto L11;
    L16:
        pw8.b r6 = (pw8.b) r5;     // Catch: Throwable -> L28
    L18:
        if (r6 == null) goto L20;
        pw8.a r7 = r6.b(r11, r12, r16, r15, r13, r17, r18);     // Catch: Throwable -> L28
    L22:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L24;
        r10 = BuildersKt.launch$default(a, null, null, new MarkdownWidgetHelper$updateWidgetFromNode$1$1(r7, r16, r15, null), 3, null);     // Catch: Throwable -> L28
    L26:
        Object r0 = Result.constructor-impl(r10);     // Catch: Throwable -> L28
    L30:
        Throwable r8 = Result.exceptionOrNull-impl(r0);
        if (r8 == null) goto L41;
        com.larus.business.markdown.api.depend.d r9 = IMarkdownLoggerKt.a();
        if (r9 == null) goto L42;
        r9.i("MarkdownWidgetHelper", r8.toString());
        return;
    L42:
        return;
    L41:
        return;
    L24:
        if (r7 == null) goto L26;
        r7.b(r16, r15);     // Catch: Throwable -> L28
        r10 = Unit.INSTANCE;     // Catch: Throwable -> L28
        goto L26
    L20:
        r7 = null;
        goto L22
    L15:
        r5 = null;
    L17:
        r6 = null;
    L28:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    }

    public static void c(MarkdownConfigManager r15, Context r16, int r17, List r18, List r19, boolean r20, boolean r21, lw8.d r22, final ViewGroup r23, List r24, boolean r25, h r26, String r27) {
        Intrinsics.checkNotNullParameter(r15, "markdownConfigManager");
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r18, "currentNodeList");
        Intrinsics.checkNotNullParameter(r22, "customMarkDownInfo");
        Intrinsics.checkNotNullParameter(r23, "currentParentViewGroup");
        Object r3 = null;
        if (r26 != null) goto L7;
        if (r20 == false) goto L6;
        h r2 = com.larus.business.markdown.impl.markwon.e.a(r16, r15, null, r22, null);
    L8:
        if (r19 == null) goto L10;
        final ArrayList r4 = new ArrayList(r19);
    L11:
        ArrayList r10 = new ArrayList(r18);
        boolean r11 = true;
        if ((!r10.isEmpty()) == false) goto L14;
        ((uvc.b) ListProtector.get(r10, 0)).f = r27;
    L14:
        if (r4 != null) goto L16;
    L19:
        boolean r1 = true;
    L20:
        if (r1 == false) goto L25;
        d(r16, r17, r10, null, r24, r23, r26, new MarkdownWidgetHelper$generateMarkdownWidgets$1(r23));
        com.larus.business.markdown.api.depend.d r0 = IMarkdownLoggerKt.a();
        if (r0 == null) goto L79;
        r0.d("MarkdownWidgetHelper", "lastNodeList == null , generateAllWidgets!!");
        return;
    L79:
        return;
    L25:
        if (r25 == false) goto L42;
        Iterator r13 = r10.iterator();
        int r5 = 0;
    L28:
        if (r13.hasNext() == false) goto L40;
        Object r6 = r13.next();
        int r14 = r5 + 1;
        if (r5 >= 0) goto L32;
        CollectionsKt.throwIndexOverflow();
    L32:
        uvc.b r7 = (uvc.b) r6;
        if (r5 >= r23.getChildCount()) goto L39;
        if (r5 != (r10.size() - 1)) goto L37;
        boolean r8 = true;
    L38:
        e(r16, r17, r7, r24, r23, r5, Boolean.valueOf(r8), r26);
        goto L39
    L37:
        r8 = false;
    L39:
        r5 = r14;
        goto L28
    L40:
        return;
    L42:
        if (r10.size() != r4.size()) goto L53;
        if (r20 == false) goto L53;
        if (r21 == false) goto L53;
        if ((!r10.isEmpty()) == false) goto L53;
        if ((!r4.isEmpty()) == false) goto L53;
        if (b(r4.subList(0, RangesKt.coerceAtLeast(r4.size(), 0)), r10.subList(0, RangesKt.coerceAtLeast(r10.size(), 0)), r2.a(), r15.b().n()) == false) goto L53;
        return;
    L53:
        if (r10.size() != r4.size()) goto L63;
        if ((!r10.isEmpty()) == false) goto L63;
        if ((!r4.isEmpty()) == false) goto L63;
        if (b(r4.subList(0, RangesKt.coerceAtLeast(r4.size() - 1, 0)), r10.subList(0, RangesKt.coerceAtLeast(r10.size() - 1, 0)), r2.a(), r15.b().n()) == false) goto L63;
        e(r16, r17, (uvc.b) CollectionsKt.last(r10), r24, r23, r10.size() - 1, Boolean.TRUE, r26);
        return;
    L63:
        if (r10.size() > r4.size()) goto L65;
    L74:
        d(r16, r17, r10, null, r24, r23, r26, new MarkdownWidgetHelper$generateMarkdownWidgets$4(r23));
        return;
    L65:
        if (b(r4.subList(0, RangesKt.coerceAtLeast(r4.size() - 1, 0)), r10, r2.a(), r15.b().n()) == false) goto L74;
        List r9 = r10.subList(r4.size() - 1, r10.size());
        Object r12 = CollectionsKt.getOrNull(r10, r4.size() - 2);
        uvc.b r28 = (uvc.b) r12;
        if (r4.size() > 1) goto L70;
        r11 = false;
    L70:
        if (r11 == false) goto L72;
        r3 = r12;
    L72:
        d(r16, r17, r9, (uvc.b) r3, r24, r23, r26, new MarkdownWidgetHelper$generateMarkdownWidgets$3(r23, r4));
        return;
    L16:
        if (r4.isEmpty() == true) goto L19;
        r1 = false;
        goto L20
    L10:
        r4 = null;
        goto L11
    L6:
        r2 = com.larus.business.markdown.impl.markwon.e.b(r16, r15, null, r22, null);
        goto L8
    L7:
        r2 = r26;
        goto L8
    }
}
