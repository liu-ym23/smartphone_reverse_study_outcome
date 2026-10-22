package com.squareup.kotlinpoet;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.StandardLocation;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f15153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f15154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15155c;
    public final String d;
    public final List e;
    public final Set f;
    public final LinkedHashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f15156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f15157i;

    public i(com.bytedance.ies.bullet.service.base.x r5) {
        com.lynx.tasm.p.g(r5);
        this.f15153a = f0.i((ArrayList) r5.f6026i);
        this.f15154b = ((d) r5.d).d();
        this.f15155c = r5.f6022a;
        this.d = r5.f6023b;
        this.e = CollectionsKt.toList((ArrayList) r5.f6025h);
        this.f = CollectionsKt.toSet((LinkedHashSet) r5.g);
        ((d) r5.f6027j).d();
        TreeSet r10 = (TreeSet) r5.e;
        LinkedHashMap r11 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r10)), 16));
        Iterator r12 = r10.iterator();
        if (r12.hasNext() == true) goto L7;
        this.g = r11;
        this.f15156h = r5.f6024c;
        this.f15157i = "kt";
        return;
    L7:
        throw androidx.constraintlayout.motion.widget.a.g(r12);
    }

    public final void a(f r11, boolean r12) {
        e r5 = this.f15154b;
        if (r5.a() == false) goto L10;
        Intrinsics.checkNotNullParameter(r5, "codeBlock");
        r11.f15146o = true;
        r11.f15139h = true;
        f.g(r11, r5, false, false, 6);     // Catch: Throwable -> L7
        r11.b("\n", false);     // Catch: Throwable -> L7
        r11.f15139h = false;
    L7:
        th = move-exception;
        r11.f15139h = false;
        throw th;
    L10:
        List r10 = this.f15153a;
        if (r10.isEmpty() == true) goto L13;
        r11.d(r10, false);
        r11.b("\n", false);
    L13:
        String r13 = this.f15155c;
        Intrinsics.checkNotNullParameter(r13, "packageName");
        if (r11.f15140i != g.f15151a) goto L77;
        r11.f15140i = r13;
        String r14 = f0.f(r13);
        if (r14.length() <= 0) goto L18;
        r11.e("package·%L\n", new Object[]{r14});
        r11.b("\n", false);
    L18:
        Collection r15 = r11.f15138c.values();
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator r17 = r15.iterator();
    L20:
        if (r17.hasNext() == false) goto L22;
        r16.add(((c) r17.next()).f);
        goto L20
    L22:
        Collection r18 = r11.d.values();
        ArrayList r19 = new ArrayList(CollectionsKt.h(r18));
        Iterator r20 = r18.iterator();
        if (r20.hasNext() == true) goto L75;
        Function1<String, Boolean> r21 = FileSpec$emit$isDefaultImport$1.INSTANCE;
        if (r12 == true) goto L33;
        Set r110 = this.f;
        if (r110.isEmpty() == true) goto L33;
        Set r111 = r110;
        final ArrayList r22 = new ArrayList(CollectionsKt.h(r111));
        Iterator r112 = r111.iterator();
    L30:
        if (r112.hasNext() == false) goto L32;
        r22.add(f0.f((String) r112.next()));
        goto L30
    L32:
        r21 = new FileSpec$emit$1(r22);
    L33:
        Collection r113 = this.g.values();
        ArrayList r23 = new ArrayList();
        ArrayList r24 = new ArrayList();
        Iterator r114 = r113.iterator();
        if (r114.hasNext() == true) goto L73;
        Pair r115 = new Pair(r23, r24);
        List r25 = (List) r115.component1();
        SortedSet r116 = SequencesKt.toSortedSet(SequencesKt.filterNot(SequencesKt.plus(SequencesKt.map(SequencesKt.filterNot(CollectionsKt.asSequence(CollectionsKt.plus(r16, r19)), new FileSpec$emit$imports$1(this)), FileSpec$emit$imports$2.INSTANCE), SequencesKt.map(CollectionsKt.asSequence((List) r115.component2()), FileSpec$emit$imports$3.INSTANCE)), r21));
        ArrayList r26 = new ArrayList(CollectionsKt.h(r25));
        Iterator r27 = r25.iterator();
        if (r27.hasNext() == true) goto L71;
        Set r117 = SetsKt.plus(r116, CollectionsKt.toSortedSet(r26));
        if (r117.isEmpty() == true) goto L44;
        Iterator r118 = r117.iterator();
    L41:
        if (r118.hasNext() == false) goto L43;
        r11.e("import·%L", new Object[]{(String) r118.next()});
        r11.b("\n", false);
        goto L41
    L43:
        r11.b("\n", false);
    L44:
        Iterator r119 = this.e.iterator();
        int r120 = 0;
    L46:
        if (r119.hasNext() == false) goto L64;
        Object r28 = r119.next();
        int r29 = r120 + 1;
        if (r120 >= 0) goto L50;
        CollectionsKt.throwIndexOverflow();
    L50:
        if (r120 <= 0) goto L53;
        r11.b("\n", false);
    L53:
        if ((r28 instanceof d0) == false) goto L56;
        d0.c((d0) r28, r11, null);
    L61:
        r120 = r29;
        goto L46
    L56:
        if ((r28 instanceof k) == false) goto L59;
        ((k) r28).c(r11, null, SetsKt.setOf(KModifier.PUBLIC), true);
        goto L61
    L59:
        if ((r28 instanceof w) == false) goto L63;
        w.b((w) r28, r11, SetsKt.setOf(KModifier.PUBLIC), false, 60);
        goto L61
    L63:
        throw new AssertionError();
    L64:
        String r121 = r11.f15140i;
        String r122 = g.f15151a;
        if (r121 == r122) goto L69;
        r11.f15140i = r122;
        return;
    L69:
        throw new IllegalStateException(("package already set: " + r11.f15140i).toString());
    L71:
        throw androidx.constraintlayout.motion.widget.a.g(r27);
    L73:
        throw androidx.constraintlayout.motion.widget.a.g(r114);
    L75:
        throw androidx.constraintlayout.motion.widget.a.g(r20);
    L77:
        throw new IllegalStateException(("package already set: " + r11.f15140i).toString());
    }

    public final void b(Appendable r12) {
        Intrinsics.checkNotNullParameter(r12, "out");
        o r5 = o.f15190a;
        LinkedHashMap r10 = this.g;
        f r11 = new f(r5, this.f15156h, r10, null, null, Integer.MAX_VALUE, 24);
        a(r11, true);
        LinkedHashMap r13 = r11.f15143l;
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator r15 = r13.entrySet().iterator();
    L3:
        boolean r16 = r15.hasNext();
        LinkedHashSet r17 = r11.f15145n;
        if (r16 == false) goto L8;
        Map.Entry r18 = (Map.Entry) r15.next();
        if (r17.contains((String) r18.getKey()) == true) goto L3;
        r14.put(r18.getKey(), r18.getValue());
        goto L3
    L8:
        LinkedHashMap r19 = r11.f15144m;
        LinkedHashMap r20 = new LinkedHashMap();
        Iterator r21 = r19.entrySet().iterator();
    L10:
        if (r21.hasNext() == false) goto L14;
        Map.Entry r22 = (Map.Entry) r21.next();
        if (r17.contains((String) r22.getKey()) == true) goto L10;
        r20.put(r22.getKey(), r22.getValue());
        goto L10
    L14:
        r11.close();
        f r23 = new f(r12, this.f15156h, r10, r14, r20, 0, 32);
        a(r23, false);
        r23.close();
    }

    public final void c(Filer r10) {
        Intrinsics.checkNotNullParameter(r10, "filer");
        Sequence r5 = SequencesKt.filter(CollectionsKt.asSequence(this.e), FileSpec$writeTo$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Set r11 = SequencesKt.toSet(SequencesKt.flatMap(r5, FileSpec$writeTo$originatingElements$1.INSTANCE));
        JavaFileManager.Location r12 = StandardLocation.SOURCE_OUTPUT;
        String r13 = this.f15155c;
        String r14 = this.d + '.' + this.f15157i;
        Object[] r15 = r11.toArray(new Element[0]);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Element[] r16 = (Element[]) r15;
        FileObject r17 = r10.createResource(r12, r13, r14, (Element[]) Arrays.copyOf(r16, r16.length));
        Writer r18 = r17.openWriter();     // Catch: Exception -> L8
        b(r18);     // Catch: Throwable -> L10
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L6:
        CloseableKt.closeFinally(r18, null);     // Catch: Exception -> L8
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);     // Catch: Exception -> L8
        throw th;     // Catch: Exception -> L8
    L8:
        e = move-exception;
        r17.delete();     // Catch: Exception -> L17
    L16:
        throw e;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(i.class, r5.getClass()) == true) goto L12;
        return false;
    L12:
        return Intrinsics.areEqual(toString(), r5.toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        b(r5);
        return r5.toString();
    }
}
