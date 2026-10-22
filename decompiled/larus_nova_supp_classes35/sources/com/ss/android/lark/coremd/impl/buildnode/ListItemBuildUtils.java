package com.ss.android.lark.coremd.impl.buildnode;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.coremd.ext.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v7b.q;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ListItemBuildUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List a(s r1) {
        ArrayList r0 = new ArrayList();
        s r2 = r1.e;
    L3:
        if (r2 == null) goto L5;
        r0.add(r2);
        r2 = r2.h;
        goto L3
    L5:
        return r0;
    }

    public static s d(final s r2) {
        if ((r2 instanceof q) == true) goto L7;
        return null;
    L7:
        return (s) i.a(ListItemBuildExtend.class, new ListItemBuildUtils$containerNode$1(r2));
    }

    public static int f(final s r2) {
        if ((r2 instanceof q) == true) goto L7;
        return 0;
    L7:
        return ((Number) i.a(ListItemBuildExtend.class, new ListItemBuildUtils$floor$floor$1(r2))).intValue();
    }

    public static List g(List r6) {
        Intrinsics.checkNotNullParameter(r6, "elements");
        if (((ArrayList) r6).isEmpty() == true) goto L5;
        ArrayList r0 = new ArrayList();
        LinkedList r1 = new LinkedList();
        LinkedList r2 = new LinkedList();
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L29;
        s r3 = (s) r7.next();
        if ((r3 instanceof q) == false) goto L11;
        int r4 = f(r3);
        if (r1.isEmpty() == true) goto L27;
        if (f((s) r1.getLast()) <= r4) goto L27;
        c(r4, r1, r2, r0);
        r1.add(r3);
    L27:
        r1.add(r3);
        goto L8
    L11:
        c(-1, r1, r2, r0);
        if (r3.f == null) goto L20;
        List r5 = a(r3);
        s r8 = r3.e;
    L14:
        if (r8 == null) goto L16;
        r8.p();
        r8 = r8.h;
        goto L14
    L16:
        Iterator r9 = g(r5).iterator();
    L18:
        if (r9.hasNext() == false) goto L20;
        r3.e((s) r9.next());
    L20:
        r0.add(r3);
        goto L8
    L29:
        if ((!r1.isEmpty()) == false) goto L31;
        c(-1, r1, r2, r0);
    L31:
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    public static s b(final s r3, final List r4) {
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = r3;
        i.a(ListItemBuildExtend.class, new ListItemBuildUtils$commitListRecursive$1(r3, r4, r0));
        return (s) r0.element;
    }

    public static s e(final s r4, final int r5) {
        if ((r4 instanceof q) == true) goto L5;
        return r4;
    L5:
        final Ref.IntRef r0 = new Ref.IntRef();
        r0.element = f(r4);
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = r4;
        i.a(ListItemBuildExtend.class, new ListItemBuildUtils$floatUpToTargetFloor$1(r4, r0, r5, r1));
        return (s) r1.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.util.ArrayList] */
    public static void c(int r8, LinkedList r9, LinkedList r10, List r11) {
        if (r9.isEmpty() == false) goto L5;
        return;
    L5:
        r10.clear();
    L6:
        int r1 = 1;
        if ((!r9.isEmpty()) == false) goto L20;
        if (f((s) r9.getLast()) <= r8) goto L20;
        s r0 = (s) r9.remove(CollectionsKt.getLastIndex(r9));
        r10.addFirst(r0);
        if ((true ^ r9.isEmpty()) == false) goto L6;
        if (f((s) r9.getLast()) >= f(r0)) goto L6;
        s r2 = (s) r9.getLast();
        Iterator r3 = r10.iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        r2.e((s) r3.next());
        goto L16
    L18:
        r10.clear();
    L20:
        if ((!r10.isEmpty()) == true) goto L22;
    L74:
        r10.clear();
        return;
    L22:
        if (r10.isEmpty() == false) goto L25;
        ?? r12 = CollectionsKt.emptyList();
    L73:
        ((ArrayList) r11).addAll((Collection) r12);
        goto L74
    L25:
        if (r10.isEmpty() == true) goto L33;
        Iterator r13 = r10.iterator();
    L29:
        if (r13.hasNext() == false) goto L33;
        if ((((s) r13.next()) instanceof q) == true) goto L29;
        boolean r14 = false;
    L34:
        if (r14 == true) goto L36;
    L69:
        r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r4 = r10.iterator();
    L71:
        if (r4.hasNext() == false) goto L73;
        s r5 = e((s) r4.next(), 0);
        r12.add(b(r5, a(r5)));
        goto L71
    L36:
        if (r10.size() <= 1) goto L69;
        Object r15 = CollectionsKt.first(r10);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.ss.android.lark.commonmark.node.ListItem");
        q r16 = (q) r15;
        int r6 = f(r16);
        s r7 = d(r16);
        if (r7 == null) goto L40;
        Class<?> r17 = r7.getClass();
    L42:
        if (r10.isEmpty() == true) goto L59;
        Iterator r18 = r10.iterator();
    L46:
        if (r18.hasNext() == false) goto L59;
        s r19 = (s) r18.next();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type com.ss.android.lark.commonmark.node.ListItem");
        q r20 = (q) r19;
        if (f(r20) != r6) goto L56;
        s r21 = d(r20);
        if (r21 == null) goto L52;
        Class<?> r22 = r21.getClass();
    L54:
        if (Intrinsics.areEqual(r22, r17) == false) goto L56;
        boolean r23 = true;
    L57:
        if (r23 == true) goto L46;
        boolean r24 = false;
    L60:
        if (r24 == false) goto L69;
        s r25 = e(r16, 0);
        s r26 = b(r25, a(r25));
        int r27 = r10.size();
    L62:
        if (r1 >= r27) goto L68;
        Object r28 = ListProtector.get(r10, r1);
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type com.ss.android.lark.commonmark.node.ListItem");
        s r29 = e((q) r28, 0);
        Iterator r30 = ((ArrayList) a(b(r29, a(r29)))).iterator();
    L65:
        if (r30.hasNext() == false) goto L67;
        r26.e((s) r30.next());
        goto L65
    L67:
        r1 = r1 + 1;
        goto L62
    L68:
        r12 = CollectionsKt.listOf(r26);
        goto L73
    L52:
        r22 = null;
    L56:
        r23 = false;
    L59:
        r24 = true;
        goto L60
    L40:
        r17 = null;
    L33:
        r14 = true;
        goto L34
    }
}
