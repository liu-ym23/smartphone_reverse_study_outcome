package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;

/* JADX INFO: loaded from: classes2.dex */
public final class fa extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Range f8978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Range f8979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NavigableMap f8980c;
    public final ea d;

    public fa(Range r5, Range r10, NavigableMap r11) {
        r5.getClass();
        this.f8978a = r5;
        r10.getClass();
        this.f8979b = r10;
        r11.getClass();
        this.f8980c = r11;
        this.d = new ea(r11);
    }

    @Override // com.google.common.collect.l0
    public final Iterator a() {
        Range r5 = this.f8979b;
        if (r5.isEmpty() == true) goto L5;
        Cut r10 = (Cut) g8.natural().min(this.f8978a.upperBound, Cut.belowValue(r5.upperBound));
        Cut r11 = (Cut) r10.endpoint();
        if (r10.typeAsUpperBound() != BoundType.CLOSED) goto L9;
        boolean r12 = true;
    L11:
        return new e5(this, this.f8980c.headMap(r11, r12).descendingMap().values().iterator(), 4);
    L9:
        r12 = false;
        goto L11
    L5:
        return g5.d;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Range b(Object r5) {
        Range r10 = this.f8979b;
        if ((r5 instanceof Cut) == true) goto L30;
    L28:
        return null;
    L30:
        Cut r11 = (Cut) r5;     // Catch: ClassCastException -> L29
        if (this.f8978a.contains(r11) == false) goto L28;
        if (r11.compareTo(r10.lowerBound) < 0) goto L28;
        if (r11.compareTo(r10.upperBound) >= 0) goto L28;
        boolean r12 = r11.equals(r10.lowerBound);     // Catch: ClassCastException -> L29
        NavigableMap r13 = this.f8980c;
        if (r12 == false) goto L24;
        Map.Entry r14 = r13.floorEntry(r11);     // Catch: ClassCastException -> L29
        if (r14 != null) goto L17;
        Object r15 = null;
    L18:
        Range r16 = (Range) r15;     // Catch: ClassCastException -> L29
        if (r16 == null) goto L28;
        if (r16.upperBound.compareTo(r10.lowerBound) <= 0) goto L28;
        return r16.intersection(r10);
    L17:
        r15 = r14.getValue();     // Catch: ClassCastException -> L29
        goto L18
    L24:
        Range r17 = (Range) r13.get(r11);     // Catch: ClassCastException -> L29
        if (r17 == null) goto L28;
        return r17.intersection(r10);
    }

    public final NavigableMap c(Range r5) {
        Range r10 = this.f8978a;
        if (r5.isConnected(r10) == true) goto L7;
        return ImmutableSortedMap.of();
    L7:
        return new fa(r10.intersection(r5), this.f8979b, this.f8980c);
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return g8.natural();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object r5) {
        if (b(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.common.collect.h7
    public final Iterator entryIterator() {
        Range r5 = this.f8979b;
        if (r5.isEmpty() == true) goto L5;
        Range r10 = this.f8978a;
        if (r10.upperBound.isLessThan(r5.lowerBound) == true) goto L9;
        boolean r11 = false;
        if (r10.lowerBound.isLessThan(r5.lowerBound) == false) goto L13;
        Iterator r12 = this.d.tailMap(r5.lowerBound, false).values().iterator();
    L18:
        return new c9(this, r12, (Cut) g8.natural().min(r10.upperBound, Cut.belowValue(r5.upperBound)));
    L13:
        Cut r13 = (Cut) r10.lowerBound.endpoint();
        if (r10.lowerBoundType() != BoundType.CLOSED) goto L16;
        r11 = true;
    L16:
        r12 = this.f8980c.tailMap(r13, r11).values().iterator();
        goto L18
    L9:
        return g5.d;
    L5:
        return g5.d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r5) {
        return b(r5);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object r5, boolean r10) {
        return c(Range.upTo((Cut) r5, BoundType.forBoolean(r10)));
    }

    @Override // com.google.common.collect.h7, java.util.AbstractMap, java.util.Map
    public final int size() {
        return p7.m0(entryIterator());
    }

    @Override // java.util.NavigableMap
    public final NavigableMap subMap(Object r5, boolean r10, Object r11, boolean r12) {
        BoundType r13 = BoundType.forBoolean(r10);
        return c(Range.range((Cut) r5, r13, (Cut) r11, BoundType.forBoolean(r12)));
    }

    @Override // java.util.NavigableMap
    public final NavigableMap tailMap(Object r5, boolean r10) {
        return c(Range.downTo((Cut) r5, BoundType.forBoolean(r10)));
    }
}
