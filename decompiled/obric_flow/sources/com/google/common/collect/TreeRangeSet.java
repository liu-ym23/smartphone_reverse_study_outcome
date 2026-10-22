package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class TreeRangeSet<C extends Comparable<?>> extends m0 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient ba f8874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient ba f8875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient l8 f8876c;
    final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    public final class Complement extends TreeRangeSet<C> {
        final /* synthetic */ TreeRangeSet this$0;

        public Complement(TreeRangeSet r5) {
            this.this$0 = r5;
            super(new da(r5.rangesByLowerBound, Range.all()), null);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.l8
        public void add(Range<C> r5) {
            this.this$0.remove(r5);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.l8
        public /* bridge */ /* synthetic */ void addAll(Iterable r5) {
            super.addAll(r5);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.l8
        public l8 complement() {
            return this.this$0;
        }

        @Override // com.google.common.collect.TreeRangeSet
        public boolean contains(C r5) {
            return !this.this$0.contains(r5);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.l8
        public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable r5) {
            return super.enclosesAll(r5);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.l8
        public void remove(Range<C> r5) {
            this.this$0.add(r5);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.l8
        public /* bridge */ /* synthetic */ void removeAll(Iterable r5) {
            super.removeAll(r5);
        }
    }

    public final class SubRangeSet extends TreeRangeSet<C> {
        private final Range<C> restriction;
        final /* synthetic */ TreeRangeSet this$0;

        public SubRangeSet(TreeRangeSet r5, Range<C> r10) {
            this.this$0 = r5;
            super(new fa(Range.all(), r10, r5.rangesByLowerBound), null);
            this.restriction = r10;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.l8
        public void add(Range<C> r5) {
            com.google.common.base.b0.k(this.restriction.encloses(r5), "Cannot add range %s to subRangeSet(%s)", r5, this.restriction);
            this.this$0.add(r5);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.l8
        public /* bridge */ /* synthetic */ void addAll(Iterable r5) {
            super.addAll(r5);
        }

        @Override // com.google.common.collect.TreeRangeSet
        public void clear() {
            this.this$0.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet
        public boolean contains(C r5) {
            if (this.restriction.contains(r5) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.this$0.contains(r5) == false) goto L7;
            return true;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.l8
        public boolean encloses(Range<C> r5) {
            if (this.restriction.isEmpty() == false) goto L5;
            return false;
        L5:
            if (this.restriction.encloses(r5) == false) goto L13;
            Range r10 = TreeRangeSet.access$600(this.this$0, r5);
            if (r10 != null) goto L9;
            return false;
        L9:
            if (r10.intersection(this.restriction).isEmpty() == true) goto L15;
            return true;
        L15:
            return false;
        L13:
            return false;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.l8
        public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable r5) {
            return super.enclosesAll(r5);
        }

        @Override // com.google.common.collect.TreeRangeSet
        public Range<C> rangeContaining(C r5) {
            if (this.restriction.contains(r5) == true) goto L5;
            return null;
        L5:
            Range<C> r10 = this.this$0.rangeContaining(r5);
            if (r10 != null) goto L9;
            return null;
        L9:
            return r10.intersection(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.l8
        public void remove(Range<C> r5) {
            if (r5.isConnected(this.restriction) == false) goto L6;
            this.this$0.remove(r5.intersection(this.restriction));
            return;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.l8
        public /* bridge */ /* synthetic */ void removeAll(Iterable r5) {
            super.removeAll(r5);
        }

        @Override // com.google.common.collect.TreeRangeSet
        public l8 subRangeSet(Range<C> r5) {
            if (r5.encloses(this.restriction) == false) goto L6;
            return this;
        L6:
            if (r5.isConnected(this.restriction) == false) goto L10;
            return new SubRangeSet(this, this.restriction.intersection(r5));
        L10:
            return ImmutableRangeSet.of();
        }
    }

    public /* synthetic */ TreeRangeSet(NavigableMap r5, aa r10) {
        this(r5);
    }

    public static Range access$600(TreeRangeSet r5, Range r10) {
        r5.getClass();
        r10.getClass();
        Map.Entry<Cut<C>, Range<C>> r11 = r5.rangesByLowerBound.floorEntry(r10.lowerBound);
        if (r11 != null) goto L5;
    L7:
        return null;
    L5:
        if (r11.getValue().encloses(r10) == false) goto L7;
        return r11.getValue();
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet(new TreeMap());
    }

    public final void a(Range r5) {
        if (r5.isEmpty() == false) goto L5;
        this.rangesByLowerBound.remove(r5.lowerBound);
        return;
    L5:
        this.rangesByLowerBound.put(r5.lowerBound, r5);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.common.collect.l8
    public void add(Range<C> r5) {
        r5.getClass();
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        Cut<C> r10 = r5.lowerBound;
        Cut<C> r11 = r5.upperBound;
        Map.Entry<Cut<C>, Range<C>> r12 = this.rangesByLowerBound.lowerEntry(r10);
        if (r12 == null) goto L13;
        Range<C> r13 = r12.getValue();
        if (r13.upperBound.compareTo(r10) < 0) goto L13;
        if (r13.upperBound.compareTo(r11) < 0) goto L12;
        r11 = r13.upperBound;
    L12:
        r10 = r13.lowerBound;
    L13:
        Map.Entry<Cut<C>, Range<C>> r14 = this.rangesByLowerBound.floorEntry(r11);
        if (r14 == null) goto L18;
        Range<C> r15 = r14.getValue();
        if (r15.upperBound.compareTo(r11) < 0) goto L18;
        r11 = r15.upperBound;
    L18:
        this.rangesByLowerBound.subMap(r10, r11).clear();
        a(Range.create(r10, r11));
    }

    @Override // com.google.common.collect.l8
    public /* bridge */ /* synthetic */ void addAll(Iterable r5) {
        super.addAll(r5);
    }

    public Set<Range<C>> asDescendingSetOfRanges() {
        ba r5 = this.f8875b;
        if (r5 != null) goto L6;
        ba r10 = new ba(this.rangesByLowerBound.descendingMap().values());
        this.f8875b = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.l8
    public Set<Range<C>> asRanges() {
        ba r5 = this.f8874a;
        if (r5 != null) goto L6;
        ba r10 = new ba(this.rangesByLowerBound.values());
        this.f8874a = r10;
        return r10;
    L6:
        return r5;
    }

    public void clear() {
        remove(Range.all());
    }

    @Override // com.google.common.collect.l8
    public l8 complement() {
        l8 r5 = this.f8876c;
        if (r5 != null) goto L6;
        Complement r10 = new Complement(this);
        this.f8876c = r10;
        return r10;
    L6:
        return r5;
    }

    public boolean contains(Comparable r5) {
        if (rangeContaining(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.l8
    public boolean encloses(Range<C> r5) {
        r5.getClass();
        Map.Entry<Cut<C>, Range<C>> r10 = this.rangesByLowerBound.floorEntry(r5.lowerBound);
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getValue().encloses(r5) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.l8
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable r5) {
        return super.enclosesAll(r5);
    }

    @Override // com.google.common.collect.m0
    public /* bridge */ /* synthetic */ boolean equals(Object r5) {
        return super.equals(r5);
    }

    public boolean intersects(Range<C> r5) {
        r5.getClass();
        Map.Entry<Cut<C>, Range<C>> r10 = this.rangesByLowerBound.ceilingEntry(r5.lowerBound);
        if (r10 != null) goto L5;
    L9:
        Map.Entry<Cut<C>, Range<C>> r11 = this.rangesByLowerBound.lowerEntry(r5.lowerBound);
        if (r11 != null) goto L12;
    L16:
        return false;
    L12:
        if (r11.getValue().isConnected(r5) == false) goto L16;
        if (r11.getValue().intersection(r5).isEmpty() == true) goto L16;
        return true;
    L5:
        if (r10.getValue().isConnected(r5) == false) goto L9;
        if (r10.getValue().intersection(r5).isEmpty() == true) goto L9;
        return true;
    }

    @Override // com.google.common.collect.l8
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    public Range<C> rangeContaining(C r5) {
        r5.getClass();
        Map.Entry<Cut<C>, Range<C>> r10 = this.rangesByLowerBound.floorEntry(Cut.belowValue(r5));
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.getValue().contains(r5) == true) goto L7;
        return null;
    L7:
        return r10.getValue();
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
    @Override // com.google.common.collect.l8
    public void remove(Range<C> r5) {
        r5.getClass();
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        Map.Entry<Cut<C>, Range<C>> r10 = this.rangesByLowerBound.lowerEntry(r5.lowerBound);
        if (r10 == null) goto L15;
        Range<C> r11 = r10.getValue();
        if (r11.upperBound.compareTo(r5.lowerBound) < 0) goto L15;
        if (r5.hasUpperBound() == true) goto L12;
    L14:
        a(Range.create(r11.lowerBound, r5.lowerBound));
        goto L15
    L12:
        if (r11.upperBound.compareTo(r5.upperBound) < 0) goto L14;
        a(Range.create(r5.upperBound, r11.upperBound));
    L15:
        Map.Entry<Cut<C>, Range<C>> r12 = this.rangesByLowerBound.floorEntry(r5.upperBound);
        if (r12 == null) goto L22;
        Range<C> r13 = r12.getValue();
        if (r5.hasUpperBound() == false) goto L22;
        if (r13.upperBound.compareTo(r5.upperBound) < 0) goto L22;
        a(Range.create(r5.upperBound, r13.upperBound));
    L22:
        this.rangesByLowerBound.subMap(r5.lowerBound, r5.upperBound).clear();
    }

    @Override // com.google.common.collect.l8
    public /* bridge */ /* synthetic */ void removeAll(Iterable r5) {
        super.removeAll(r5);
    }

    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> r5 = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> r10 = this.rangesByLowerBound.lastEntry();
        if (r5 == null) goto L8;
        if (r10 == null) goto L8;
        return Range.create(r5.getValue().lowerBound, r10.getValue().upperBound);
    L8:
        throw new NoSuchElementException();
    }

    public l8 subRangeSet(Range<C> r5) {
        if (r5.equals(Range.all()) == false) goto L6;
        return this;
    L6:
        return new SubRangeSet(this, r5);
    }

    public TreeRangeSet(NavigableMap r5) {
        this.rangesByLowerBound = r5;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(l8 r5) {
        TreeRangeSet<C> r10 = create();
        r10.addAll(r5);
        return r10;
    }

    public void addAll(l8 r5) {
        addAll(r5.asRanges());
    }

    public boolean enclosesAll(l8 r5) {
        return enclosesAll(r5.asRanges());
    }

    @Override // com.google.common.collect.l8
    public void removeAll(l8 r5) {
        removeAll(r5.asRanges());
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> r5) {
        TreeRangeSet<C> r10 = create();
        r10.addAll(r5);
        return r10;
    }
}
