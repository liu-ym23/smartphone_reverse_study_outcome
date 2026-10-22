package com.larus.business.markdown.impl.widget;

import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.depend.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class MarkdownMultiWidgetHelper {
    public static final CoroutineScope a = null;

    public MarkdownMultiWidgetHelper() {
    }

    static {
        a = CoroutineScopeKt.MainScope();
    }

    public static List a(b r16) {
        CutStrategy r1 = CutStrategy.DoubleCut;
        Intrinsics.checkNotNullParameter(r16, "currentNode");
        Intrinsics.checkNotNullParameter(r1, "cutStrategy");
        LinkedHashSet r2 = new LinkedHashSet();
        f.f(r16, r2);
        Iterator r3 = r2.iterator();
    L3:
        int r6 = 0;
        if (r3.hasNext() == false) goto L73;
        b r4 = (b) r3.next();
        ArrayList r7 = new ArrayList();
        b r8 = null;
        b r9 = null;
    L6:
        Intrinsics.checkNotNull(r4);
        r7.add(r4);
        if (r4.d == null) goto L11;
        if (r8 != null) goto L11;
        r8 = r4.a;
    L11:
        if (r4.e == null) goto L14;
        if (r9 != null) goto L14;
        r9 = r4.a;
    L14:
        r4 = r4.a;
        if (r4 != null) goto L6;
        Iterator r5 = CollectionsKt.toMutableList(CollectionsKt.reversed(r7)).iterator();
        b r10 = null;
        b r11 = null;
    L18:
        if (r5.hasNext() == false) goto L3;
        Object r12 = r5.next();
        int r13 = r6 + 1;
        if (r6 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        b r14 = (b) r12;
        CutStrategy r15 = CutStrategy.LeftCut;
        if (r1 != r15) goto L25;
    L26:
        if (r8 == null) goto L30;
        b r17 = f.c(r14);
        if (r17 == null) goto L30;
        ((HashMap) r17.g).put("start_self", ((HashMap) r14.g).get("start_self"));
        ((HashMap) r14.g).put("start_self", r17);
    L32:
        if (r1 != CutStrategy.RightCut) goto L34;
    L35:
        if (r9 == null) goto L39;
        b r18 = f.c(r14);
        if (r18 == null) goto L39;
        ((HashMap) r18.g).put("start_self", r14);
    L41:
        if (Intrinsics.areEqual(r8, r14) == false) goto L44;
        r8 = null;
    L44:
        if (Intrinsics.areEqual(r9, r14) == false) goto L46;
        r9 = null;
    L46:
        if (r17 == null) goto L48;
        f.e(r14, r17);
    L48:
        if (r18 == null) goto L50;
        f.d(r14, r18);
    L50:
        if (r1 != r15) goto L52;
    L53:
        b r19 = r14.d;
    L54:
        if (r19 == null) goto L63;
        b r110 = r19.d;
        if (r10 == null) goto L61;
        int r111 = f.a;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r19, "child");
        f.h(r19);
        r19.a = r10;
        b r112 = r10.b;
        if (r112 == null) goto L60;
        r112.d = r19;
        r19.e = r112;
        r10.b = r19;
        goto L61
    L60:
        r10.b = r19;
        r10.c = r19;
    L61:
        r19 = r110;
    L63:
        if (r1 != CutStrategy.RightCut) goto L65;
    L66:
        b r20 = r14.e;
    L67:
        if (r20 == null) goto L72;
        b r21 = r20.e;
        if (r11 == null) goto L71;
        f.a(r11, r20);
    L71:
        r20 = r21;
    L72:
        r11 = r18;
        r6 = r13;
        r10 = r17;
        goto L18
    L65:
        if (r1 != CutStrategy.DoubleCut) goto L72;
    L52:
        if (r1 != CutStrategy.DoubleCut) goto L63;
    L39:
        r18 = null;
        goto L41
    L34:
        if (r1 != CutStrategy.DoubleCut) goto L39;
    L30:
        r17 = null;
        goto L32
    L25:
        if (r1 != CutStrategy.DoubleCut) goto L30;
    L73:
        ArrayList r22 = new ArrayList();
        r22.add(r16);
        b r23 = r16.d;
    L74:
        if (r23 == null) goto L76;
        ListProtector.add(r22, 0, r23);
        r23 = r23.d;
        goto L74
    L76:
        b r0 = r16.e;
    L77:
        if (r0 == null) goto L79;
        r22.add(r0);
        r0 = r0.e;
        goto L77
    L79:
        Iterator r24 = r22.iterator();
    L81:
        if (r24.hasNext() == false) goto L83;
        b r25 = (b) r24.next();
        r25.d = null;
        r25.e = null;
        goto L81
    L83:
        Iterator r26 = r2.iterator();
    L85:
        if (r26.hasNext() == false) goto L102;
        WidgetNode r27 = (b) r26.next();
        boolean r28 = r27 instanceof WidgetNode;
        if (r28 == false) goto L89;
        WidgetNode r29 = r27;
    L90:
        if (r29 == null) goto L97;
        List r30 = r29.h;
        if (r30 == null) goto L97;
        Iterator r31 = ((ArrayList) r30).iterator();
    L95:
        if (r31.hasNext() == false) goto L97;
        f.e(r27, (b) r31.next());
    L97:
        if (r28 == false) goto L99;
        WidgetNode r32 = r27;
    L100:
        if (r32 == null) goto L85;
        r32.g();
        goto L85
    L99:
        r32 = null;
        goto L100
    L89:
        r29 = null;
        goto L90
    L102:
        return r22;
    }

    public static void b(Context r12, int r13, boolean r14, b r15, final ViewGroup r16, b r17, List r18) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r15, "rootNode");
        Intrinsics.checkNotNullParameter(r16, "currentParentViewGroup");
        Job r11 = null;
        if (r17 != null) goto L29;
        final generateMarkdownWidget.1 r1 = new generateMarkdownWidget.1(r16);
        if (r18 == null) goto L25;
        List r2 = CollectionsKt.sortedWith(r18, new b());
        if (r2 == null) goto L25;
        List r3 = CollectionsKt.reversed(r2);
        if (r3 == null) goto L25;
        Iterator r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        Object r5 = r4.next();
        if (((pw8.b) r5).c(r15) == false) goto L12;
    L17:
        pw8.b r6 = (pw8.b) r5;
        if (r6 == null) goto L25;
        final pw8.a r0 = pw8.b.a.a(r6, r12, r13, r15, Boolean.valueOf(r14));
        if (r0 == null) goto L25;
        Runnable r7 = new a(r1, r0, r16);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L24;
        BuildersKt.launch$default(a, null, null, new generateWidgetFromNode.1(r7, null), 3, null);
        goto L25
    L24:
        r7.run();
        goto L25
    L16:
        r5 = null;
    L25:
        d r8 = IMarkdownLoggerKt.a();
        if (r8 == null) goto L73;
        r8.d("MarkdownMultiWidgetHelper", "lastNodeList == null , generateAllWidgets!!");
        return;
    L73:
        return;
    L29:
        Boolean r9 = Boolean.valueOf(r14);
        if (r16.getChildCount() < 1) goto L76;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L57
        if (r18 == null) goto L46;
        List r19 = CollectionsKt.sortedWith(r18, new c());     // Catch: Throwable -> L57
        if (r19 == null) goto L46;
        List r20 = CollectionsKt.reversed(r19);     // Catch: Throwable -> L57
        if (r20 == null) goto L46;
        Iterator r21 = r20.iterator();     // Catch: Throwable -> L57
    L40:
        if (r21.hasNext() == false) goto L44;
        Object r22 = r21.next();     // Catch: Throwable -> L57
        if (((pw8.b) r22).c(r15) == false) goto L40;
    L45:
        pw8.b r23 = (pw8.b) r22;     // Catch: Throwable -> L57
    L47:
        if (r23 == null) goto L49;
        pw8.a r24 = r23.b(r12, r13, 0, r16, r15, r9, null);     // Catch: Throwable -> L57
    L51:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L53;
        r11 = BuildersKt.launch$default(a, null, null, new updateWidgetFromNode.1.1(r24, r16, null), 3, null);     // Catch: Throwable -> L57
    L55:
        Object r25 = Result.constructor-impl(r11);     // Catch: Throwable -> L57
    L59:
        Throwable r26 = Result.exceptionOrNull-impl(r25);
        if (r26 == null) goto L74;
        d r27 = IMarkdownLoggerKt.a();
        if (r27 == null) goto L75;
        r27.i("MarkdownMultiWidgetHelper", r26.toString());
        return;
    L75:
        return;
    L74:
        return;
    L53:
        if (r24 == null) goto L55;
        r24.b(0, r16);     // Catch: Throwable -> L57
        r11 = Unit.INSTANCE;     // Catch: Throwable -> L57
        goto L55
    L49:
        r24 = null;
        goto L51
    L44:
        r22 = null;
    L46:
        r23 = null;
    L57:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L59
    }
}
