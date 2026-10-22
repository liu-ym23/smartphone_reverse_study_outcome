package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;

/* JADX INFO: loaded from: classes2.dex */
public final class ea extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NavigableMap f8961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Range f8962b;

    public ea(NavigableMap r5) {
        this.f8961a = r5;
        this.f8962b = Range.all();
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
    @Override // com.google.common.collect.l0
    public final Iterator a() {
        Range r5 = this.f8962b;
        boolean r10 = r5.hasUpperBound();
        NavigableMap r11 = this.f8961a;
        if (r10 == false) goto L5;
        Collection r12 = r11.headMap((Cut) r5.upperEndpoint(), false).descendingMap().values();
    L6:
        j5 r13 = p7.b0(r12.iterator());
        if (r13.hasNext() == false) goto L12;
        if (r5.upperBound.isLessThan(((Range) r13.a()).upperBound) == false) goto L12;
        r13.next();
    L12:
        return new e5(this, r13, 3);
    L5:
        r12 = r11.descendingMap().values();
        goto L6
    }

    public final Range b(Object r5) {
        if ((r5 instanceof Cut) == true) goto L15;
    L13:
        return null;
    L15:
        Cut r10 = (Cut) r5;     // Catch: ClassCastException -> L14
        if (this.f8962b.contains(r10) == true) goto L7;
        return null;
    L7:
        Map.Entry r11 = this.f8961a.lowerEntry(r10);     // Catch: ClassCastException -> L14
        if (r11 == null) goto L13;
        if (((Range) r11.getValue()).upperBound.equals(r10) == false) goto L13;
        return (Range) r11.getValue();
    }

    public final NavigableMap c(Range r5) {
        Range r10 = this.f8962b;
        if (r5.isConnected(r10) == false) goto L7;
        return new ea(this.f8961a, r5.intersection(r10));
    L7:
        return ImmutableSortedMap.of();
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
        Range r5 = this.f8962b;
        boolean r10 = r5.hasLowerBound();
        NavigableMap r11 = this.f8961a;
        if (r10 == true) goto L5;
        Iterator r12 = r11.values().iterator();
    L13:
        return new e5(this, r12, 2);
    L5:
        Map.Entry r13 = r11.lowerEntry((Cut) r5.lowerEndpoint());
        if (r13 != null) goto L9;
        r12 = r11.values().iterator();
        goto L13
    L9:
        if (r5.lowerBound.isLessThan(((Range) r13.getValue()).upperBound) == false) goto L11;
        r12 = r11.tailMap((Cut) r13.getKey(), true).values().iterator();
        goto L13
    L11:
        r12 = r11.tailMap((Cut) r5.lowerEndpoint(), true).values().iterator();
        goto L13
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r5) {
        return b(r5);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object r5, boolean r10) {
        return c(Range.upTo((Cut) r5, BoundType.forBoolean(r10)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        if (this.f8962b.equals(Range.all()) == false) goto L6;
        return this.f8961a.isEmpty();
    L6:
        if (((g) entryIterator()).hasNext() == true) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // com.google.common.collect.h7, java.util.AbstractMap, java.util.Map
    public final int size() {
        if (this.f8962b.equals(Range.all()) == false) goto L7;
        return this.f8961a.size();
    L7:
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

    public ea(NavigableMap r5, Range r10) {
        this.f8961a = r5;
        this.f8962b = r10;
    }
}
