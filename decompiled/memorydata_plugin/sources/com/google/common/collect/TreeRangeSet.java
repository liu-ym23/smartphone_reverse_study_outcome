package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class TreeRangeSet<C extends Comparable<?>> extends f<C> implements Serializable {
    private transient Set<Range<C>> asDescendingSetOfRanges;
    private transient Set<Range<C>> asRanges;
    private transient at<C> complement;
    final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* JADX INFO: renamed from: com.google.common.collect.TreeRangeSet$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class Complement extends TreeRangeSet<C> {
        final /* synthetic */ TreeRangeSet this$0;

        Complement(TreeRangeSet r2) {
            this.this$0 = r2;
            super(new b(r2.rangesByLowerBound), null);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f, com.google.common.collect.at
        public void add(Range<C> r1) {
            this.this$0.remove(r1);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.at
        public at<C> complement() {
            return this.this$0;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public boolean contains(C r3) {
            return !this.this$0.contains((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f, com.google.common.collect.at
        public void remove(Range<C> r1) {
            this.this$0.add(r1);
        }
    }

    private final class SubRangeSet extends TreeRangeSet<C> {
        private final Range<C> restriction;
        final /* synthetic */ TreeRangeSet this$0;

        SubRangeSet(TreeRangeSet r4, Range<C> r5) {
            this.this$0 = r4;
            AnonymousClass1 r2 = null;
            super(new d(Range.all(), r5, r4.rangesByLowerBound, r2), r2);
            this.restriction = r5;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f, com.google.common.collect.at
        public void add(Range<C> r4) {
            com.google.common.base.n.a(this.restriction.encloses(r4), "Cannot add range %s to subRangeSet(%s)", r4, this.restriction);
            this.this$0.add(r4);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void clear() {
            this.this$0.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public boolean contains(C r3) {
            Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            if (this.restriction.contains(r4) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.this$0.contains(r4) == false) goto L7;
            return true;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f, com.google.common.collect.at
        public boolean encloses(Range<C> r3) {
            if (this.restriction.isEmpty() == false) goto L5;
            return false;
        L5:
            if (this.restriction.encloses(r3) == false) goto L13;
            Range r4 = TreeRangeSet.access$600(this.this$0, r3);
            if (r4 != null) goto L9;
            return false;
        L9:
            if (r4.intersection(this.restriction).isEmpty() == true) goto L15;
            return true;
        L15:
            return false;
        L13:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public Range<C> rangeContaining(C r3) {
            Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            if (this.restriction.contains(r4) == true) goto L5;
            return null;
        L5:
            Range r5 = this.this$0.rangeContaining(r4);
            if (r5 != null) goto L9;
            return null;
        L9:
            return r5.intersection(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f, com.google.common.collect.at
        public void remove(Range<C> r2) {
            if (r2.isConnected(this.restriction) == false) goto L6;
            this.this$0.remove(r2.intersection(this.restriction));
            return;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.at
        public at<C> subRangeSet(Range<C> r3) {
            if (r3.encloses(this.restriction) == false) goto L6;
            return this;
        L6:
            if (r3.isConnected(this.restriction) == false) goto L10;
            return new SubRangeSet(this, this.restriction.intersection(r3));
        L10:
            return ImmutableRangeSet.of();
        }
    }

    final class a extends v<Range<C>> implements Set<Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Collection<Range<C>> f4635a;

        a(TreeRangeSet r2, Collection<Range<C>> r3) {
            this.f4635a = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.v, com.google.common.collect.ac
        public Collection<Range<C>> delegate() {
            return this.f4635a;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object r1) {
            return Sets.a(this, r1);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.a(this);
        }
    }

    private static final class b<C extends Comparable<?>> extends e<Cut<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableMap<Cut<C>, Range<C>> f4636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final NavigableMap<Cut<C>, Range<C>> f4637b;
        private final Range<Cut<C>> c;

        b(NavigableMap<Cut<C>, Range<C>> r3) {
            this((NavigableMap) ZeusTransformUtils.wrapperContextForParams(r3, NavigableMap.class, "com.obric.memorydata.plugin"), Range.all());
        }

        private b(NavigableMap<Cut<C>, Range<C>> r3, Range<Cut<C>> r4) {
            NavigableMap<Cut<C>, Range<C>> r5 = (NavigableMap) ZeusTransformUtils.wrapperContextForParams(r3, NavigableMap.class, "com.obric.memorydata.plugin");
            this.f4636a = r5;
            this.f4637b = new c(r5);
            this.c = r4;
        }

        static /* synthetic */ Range a(b r0) {
            return r0.c;
        }

        private NavigableMap<Cut<C>, Range<C>> a(Range<Cut<C>> r2) {
            if (this.c.isConnected(r2) == false) goto L5;
            Range<C> r3 = r2.intersection(this.c);
            return new b(this.f4636a, r3);
        L5:
            return ImmutableSortedMap.of();
        }

        public Range<C> a(Object r5) {
            if (ZeusTransformUtils.instanceOf(r5, Cut.class) == true) goto L12;
        L10:
            return null;
        L12:
            Cut<C> r6 = (Cut) ZeusTransformUtils.preCheckCast(r5, Cut.class, "com.obric.memorydata.plugin");     // Catch: ClassCastException -> L11
            Map.Entry<Cut<C>, Range<C>> r4 = b(r6, true).firstEntry();     // Catch: ClassCastException -> L11
            if (r4 == null) goto L10;
            if (((Cut) ZeusTransformUtils.preCheckCast(r4.getKey(), Cut.class, "com.obric.memorydata.plugin")).equals(r6) == false) goto L10;
            return (Range) ZeusTransformUtils.preCheckCast(r4.getValue(), Range.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.e
        Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            if (this.c.hasUpperBound() == false) goto L5;
            Cut<C> r0 = (Cut) ZeusTransformUtils.preCheckCast(this.c.upperEndpoint(), Cut.class, "com.obric.memorydata.plugin");
        L7:
            if (this.c.hasUpperBound() == true) goto L9;
        L11:
            boolean r2 = false;
        L12:
            final aq r1 = Iterators.i(this.f4637b.headMap(r0, r2).descendingMap().values().iterator());
            if (r1.hasNext() == false) goto L19;
            if (((Range) ZeusTransformUtils.preCheckCast(r1.a(), Range.class, "com.obric.memorydata.plugin")).upperBound != Cut.aboveAll()) goto L17;
            Object r3 = ((Range) ZeusTransformUtils.preCheckCast(r1.next(), Range.class, "com.obric.memorydata.plugin")).lowerBound;
        L25:
            final Cut r4 = (Cut) ZeusTransformUtils.preCheckCast(com.google.common.base.i.a(r3, Cut.aboveAll()), Cut.class, "com.obric.memorydata.plugin");
            return new AnonymousClass2(this, r4, r1);
        L17:
            NavigableMap<Cut<C>, Range<C>> r5 = this.f4636a;
            Cut<C> r6 = ((Range) ZeusTransformUtils.preCheckCast(r1.a(), Range.class, "com.obric.memorydata.plugin")).upperBound;
        L24:
            r3 = (Cut) ZeusTransformUtils.preCheckCast(r5.higherKey(r6), Cut.class, "com.obric.memorydata.plugin");
            goto L25
        L19:
            if (this.c.contains(Cut.belowAll()) == false) goto L28;
            if (this.f4636a.containsKey(Cut.belowAll()) == true) goto L28;
            r5 = this.f4636a;
            r6 = Cut.belowAll();
        L28:
            return Iterators.a();
        L9:
            if (this.c.upperBoundType() != BoundType.CLOSED) goto L11;
            r2 = true;
            goto L12
        L5:
            r0 = Cut.aboveAll();
            goto L7
        }

        public NavigableMap<Cut<C>, Range<C>> a(Cut<C> r1, boolean r2) {
            return a(Range.upTo(r1, BoundType.forBoolean(r2)));
        }

        public NavigableMap<Cut<C>, Range<C>> a(Cut<C> r1, boolean r2, Cut<C> r3, boolean r4) {
            return a(Range.range(r1, BoundType.forBoolean(r2), r3, BoundType.forBoolean(r4)));
        }

        public NavigableMap<Cut<C>, Range<C>> b(Cut<C> r1, boolean r2) {
            return a(Range.downTo(r1, BoundType.forBoolean(r2)));
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r1) {
            if (a(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.Maps.d
        Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
            if (this.c.hasLowerBound() == false) goto L9;
            NavigableMap<Cut<C>, Range<C>> r0 = this.f4637b;
            Cut<C> r2 = (Cut) ZeusTransformUtils.preCheckCast(this.c.lowerEndpoint(), Cut.class, "com.obric.memorydata.plugin");
            if (this.c.lowerBoundType() != BoundType.CLOSED) goto L7;
            boolean r3 = true;
        L8:
            NavigableMap<Cut<C>, Range<C>> r1 = r0.tailMap(r2, r3);
        L10:
            final aq r4 = Iterators.i(r1.values().iterator());
            if (this.c.contains(Cut.belowAll()) == false) goto L18;
            if (r4.hasNext() == true) goto L15;
        L16:
            final Cut r5 = Cut.belowAll();
        L21:
            return new AnonymousClass1(this, r5, r4);
        L15:
            if (((Range) ZeusTransformUtils.preCheckCast(r4.a(), Range.class, "com.obric.memorydata.plugin")).lowerBound != Cut.belowAll()) goto L16;
        L18:
            if (r4.hasNext() == false) goto L23;
            r5 = ((Range) ZeusTransformUtils.preCheckCast(r4.next(), Range.class, "com.obric.memorydata.plugin")).upperBound;
            goto L21
        L23:
            return Iterators.a();
        L7:
            r3 = false;
            goto L8
        L9:
            r1 = this.f4637b;
            goto L10
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object get(Object r1) {
            return a(r1);
        }

        @Override // java.util.NavigableMap
        public /* synthetic */ NavigableMap headMap(Object r3, boolean r4) {
            return a((Cut) ZeusTransformUtils.preCheckCast(r3, Cut.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.b(entryIterator());
        }

        @Override // java.util.NavigableMap
        public /* synthetic */ NavigableMap subMap(Object r3, boolean r4, Object r5, boolean r6) {
            return a((Cut) ZeusTransformUtils.preCheckCast(r3, Cut.class, "com.obric.memorydata.plugin"), r4, (Cut) ZeusTransformUtils.preCheckCast(r5, Cut.class, "com.obric.memorydata.plugin"), r6);
        }

        @Override // java.util.NavigableMap
        public /* synthetic */ NavigableMap tailMap(Object r3, boolean r4) {
            return b((Cut) ZeusTransformUtils.preCheckCast(r3, Cut.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    static final class c<C extends Comparable<?>> extends e<Cut<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableMap<Cut<C>, Range<C>> f4642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Range<Cut<C>> f4643b;

        c(NavigableMap<Cut<C>, Range<C>> r3) {
            this.f4642a = (NavigableMap) ZeusTransformUtils.wrapperContextForParams(r3, NavigableMap.class, "com.obric.memorydata.plugin");
            this.f4643b = Range.all();
        }

        private c(NavigableMap<Cut<C>, Range<C>> r3, Range<Cut<C>> r4) {
            this.f4642a = (NavigableMap) ZeusTransformUtils.wrapperContextForParams(r3, NavigableMap.class, "com.obric.memorydata.plugin");
            this.f4643b = r4;
        }

        static /* synthetic */ Range a(c r0) {
            return r0.f4643b;
        }

        private NavigableMap<Cut<C>, Range<C>> a(Range<Cut<C>> r3) {
            if (r3.isConnected(this.f4643b) == false) goto L7;
            return new c(this.f4642a, r3.intersection(this.f4643b));
        L7:
            return ImmutableSortedMap.of();
        }

        public Range<C> a(Object r5) {
            if (ZeusTransformUtils.instanceOf(r5, Cut.class) == true) goto L15;
        L13:
            return null;
        L15:
            Cut<C> r6 = (Cut) ZeusTransformUtils.preCheckCast(r5, Cut.class, "com.obric.memorydata.plugin");     // Catch: ClassCastException -> L14
            if (this.f4643b.contains(r6) == true) goto L7;
            return null;
        L7:
            Map.Entry<Cut<C>, Range<C>> r4 = this.f4642a.lowerEntry(r6);     // Catch: ClassCastException -> L14
            if (r4 == null) goto L13;
            if (((Range) ZeusTransformUtils.preCheckCast(r4.getValue(), Range.class, "com.obric.memorydata.plugin")).upperBound.equals(r6) == false) goto L13;
            return (Range) ZeusTransformUtils.preCheckCast(r4.getValue(), Range.class, "com.obric.memorydata.plugin");
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
        @Override // com.google.common.collect.e
        Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            if (this.f4643b.hasUpperBound() == false) goto L5;
            NavigableMap<Cut<C>, Range<C>> r0 = this.f4642a.headMap((Cut) ZeusTransformUtils.preCheckCast(this.f4643b.upperEndpoint(), Cut.class, "com.obric.memorydata.plugin"), false);
        L6:
            final aq r1 = Iterators.i(r0.descendingMap().values().iterator());
            if (r1.hasNext() == false) goto L12;
            if (this.f4643b.upperBound.isLessThan(((Range) ZeusTransformUtils.preCheckCast(r1.a(), Range.class, "com.obric.memorydata.plugin")).upperBound) == false) goto L12;
            r1.next();
        L12:
            return new AnonymousClass2(this, r1);
        L5:
            r0 = this.f4642a;
            goto L6
        }

        public NavigableMap<Cut<C>, Range<C>> a(Cut<C> r1, boolean r2) {
            return a(Range.upTo(r1, BoundType.forBoolean(r2)));
        }

        public NavigableMap<Cut<C>, Range<C>> a(Cut<C> r1, boolean r2, Cut<C> r3, boolean r4) {
            return a(Range.range(r1, BoundType.forBoolean(r2), r3, BoundType.forBoolean(r4)));
        }

        public NavigableMap<Cut<C>, Range<C>> b(Cut<C> r1, boolean r2) {
            return a(Range.downTo(r1, BoundType.forBoolean(r2)));
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r1) {
            if (a(r1) == null) goto L5;
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
        @Override // com.google.common.collect.Maps.d
        Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
            if (this.f4643b.hasLowerBound() == true) goto L6;
        L4:
            NavigableMap<Cut<C>, Range<C>> r0 = this.f4642a;
        L5:
            final Iterator<Range<C>> r1 = r0.values().iterator();
            return new AnonymousClass1(this, r1);
        L6:
            Map.Entry<Cut<C>, Range<C>> r2 = this.f4642a.lowerEntry((Cut) ZeusTransformUtils.preCheckCast(this.f4643b.lowerEndpoint(), Cut.class, "com.obric.memorydata.plugin"));
            if (r2 == null) goto L4;
            if (this.f4643b.lowerBound.isLessThan(((Range) ZeusTransformUtils.preCheckCast(r2.getValue(), Range.class, "com.obric.memorydata.plugin")).upperBound) == false) goto L12;
            r0 = this.f4642a.tailMap((Cut) ZeusTransformUtils.preCheckCast(r2.getKey(), Cut.class, "com.obric.memorydata.plugin"), true);
            goto L5
        L12:
            r0 = this.f4642a.tailMap((Cut) ZeusTransformUtils.preCheckCast(this.f4643b.lowerEndpoint(), Cut.class, "com.obric.memorydata.plugin"), true);
            goto L5
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object get(Object r1) {
            return a(r1);
        }

        @Override // java.util.NavigableMap
        public /* synthetic */ NavigableMap headMap(Object r3, boolean r4) {
            return a((Cut) ZeusTransformUtils.preCheckCast(r3, Cut.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.f4643b.equals(Range.all()) == false) goto L6;
            return this.f4642a.isEmpty();
        L6:
            if (entryIterator().hasNext() == true) goto L8;
            return true;
        L8:
            return false;
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public int size() {
            if (this.f4643b.equals(Range.all()) == false) goto L7;
            return this.f4642a.size();
        L7:
            return Iterators.b(entryIterator());
        }

        @Override // java.util.NavigableMap
        public /* synthetic */ NavigableMap subMap(Object r3, boolean r4, Object r5, boolean r6) {
            return a((Cut) ZeusTransformUtils.preCheckCast(r3, Cut.class, "com.obric.memorydata.plugin"), r4, (Cut) ZeusTransformUtils.preCheckCast(r5, Cut.class, "com.obric.memorydata.plugin"), r6);
        }

        @Override // java.util.NavigableMap
        public /* synthetic */ NavigableMap tailMap(Object r3, boolean r4) {
            return b((Cut) ZeusTransformUtils.preCheckCast(r3, Cut.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    private static final class d<C extends Comparable<?>> extends e<Cut<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Range<Cut<C>> f4648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Range<C> f4649b;
        private final NavigableMap<Cut<C>, Range<C>> c;
        private final NavigableMap<Cut<C>, Range<C>> d;

        private d(Range<Cut<C>> r3, Range<C> r4, NavigableMap<Cut<C>, Range<C>> r5) {
            NavigableMap r6 = (NavigableMap) ZeusTransformUtils.wrapperContextForParams(r5, NavigableMap.class, "com.obric.memorydata.plugin");
            this.f4648a = (Range) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r3), Range.class, "com.obric.memorydata.plugin");
            this.f4649b = (Range) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r4), Range.class, "com.obric.memorydata.plugin");
            this.c = (NavigableMap) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r6), NavigableMap.class, "com.obric.memorydata.plugin");
            this.d = new c(r6);
        }

        /* synthetic */ d(Range r2, Range r3, NavigableMap r4, AnonymousClass1 r5) {
            this(r2, r3, (NavigableMap) ZeusTransformUtils.wrapperContextForParams(r4, NavigableMap.class, "com.obric.memorydata.plugin"));
        }

        static /* synthetic */ Range a(d r0) {
            return r0.f4649b;
        }

        private NavigableMap<Cut<C>, Range<C>> a(Range<Cut<C>> r3) {
            if (r3.isConnected(this.f4648a) == true) goto L7;
            return ImmutableSortedMap.of();
        L7:
            return new d(this.f4648a.intersection(r3), this.f4649b, this.c);
        }

        static /* synthetic */ Range b(d r0) {
            return r0.f4648a;
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
        public Range<C> a(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Cut.class) == true) goto L25;
        L23:
            return null;
        L25:
            Cut<C> r5 = (Cut) ZeusTransformUtils.preCheckCast(r4, Cut.class, "com.obric.memorydata.plugin");     // Catch: ClassCastException -> L24
            if (this.f4648a.contains(r5) == false) goto L23;
            if (r5.compareTo(this.f4649b.lowerBound) < 0) goto L23;
            if (r5.compareTo(this.f4649b.upperBound) >= 0) goto L23;
            if (r5.equals(this.f4649b.lowerBound) == false) goto L19;
            Range r6 = (Range) ZeusTransformUtils.preCheckCast(Maps.c(this.c.floorEntry(r5)), Range.class, "com.obric.memorydata.plugin");     // Catch: ClassCastException -> L24
            if (r6 == null) goto L23;
            if (r6.upperBound.compareTo(this.f4649b.lowerBound) <= 0) goto L23;
            return r6.intersection(this.f4649b);
        L19:
            Range r7 = (Range) ZeusTransformUtils.preCheckCast(this.c.get(r5), Range.class, "com.obric.memorydata.plugin");     // Catch: ClassCastException -> L24
            if (r7 == null) goto L23;
            return r7.intersection(this.f4649b);
        }

        @Override // com.google.common.collect.e
        Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            if (this.f4649b.isEmpty() == true) goto L5;
            Cut r0 = (Cut) ZeusTransformUtils.preCheckCast(Ordering.natural().min(this.f4648a.upperBound, Cut.belowValue(this.f4649b.upperBound)), Cut.class, "com.obric.memorydata.plugin");
            NavigableMap<Cut<C>, Range<C>> r1 = this.c;
            Cut<C> r2 = (Cut) ZeusTransformUtils.preCheckCast(r0.endpoint(), Cut.class, "com.obric.memorydata.plugin");
            if (r0.typeAsUpperBound() != BoundType.CLOSED) goto L9;
            boolean r3 = true;
        L10:
            final Iterator<Range<C>> r4 = r1.headMap(r2, r3).descendingMap().values().iterator();
            return new AnonymousClass2(this, r4);
        L9:
            r3 = false;
            goto L10
        L5:
            return Iterators.a();
        }

        public NavigableMap<Cut<C>, Range<C>> a(Cut<C> r1, boolean r2) {
            return a(Range.upTo(r1, BoundType.forBoolean(r2)));
        }

        public NavigableMap<Cut<C>, Range<C>> a(Cut<C> r1, boolean r2, Cut<C> r3, boolean r4) {
            return a(Range.range(r1, BoundType.forBoolean(r2), r3, BoundType.forBoolean(r4)));
        }

        public NavigableMap<Cut<C>, Range<C>> b(Cut<C> r1, boolean r2) {
            return a(Range.downTo(r1, BoundType.forBoolean(r2)));
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r1) {
            if (a(r1) == null) goto L5;
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
        @Override // com.google.common.collect.Maps.d
        Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
            if (this.f4649b.isEmpty() == false) goto L7;
            return Iterators.a();
        L7:
            if (this.f4648a.upperBound.isLessThan(this.f4649b.lowerBound) == true) goto L9;
            boolean r1 = false;
            if (this.f4648a.lowerBound.isLessThan(this.f4649b.lowerBound) == false) goto L14;
            NavigableMap<Cut<C>, Range<C>> r0 = this.d;
            Cut<C> r3 = this.f4649b.lowerBound;
        L13:
            final Iterator<Range<C>> r2 = r0.tailMap(r3, r1).values().iterator();
            final Cut r4 = (Cut) ZeusTransformUtils.preCheckCast(Ordering.natural().min(this.f4648a.upperBound, Cut.belowValue(this.f4649b.upperBound)), Cut.class, "com.obric.memorydata.plugin");
            return new AnonymousClass1(this, r2, r4);
        L14:
            r0 = this.c;
            r3 = (Cut) ZeusTransformUtils.preCheckCast(this.f4648a.lowerBound.endpoint(), Cut.class, "com.obric.memorydata.plugin");
            if (this.f4648a.lowerBoundType() != BoundType.CLOSED) goto L13;
            r1 = true;
            goto L13
        L9:
            return Iterators.a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object get(Object r1) {
            return a(r1);
        }

        @Override // java.util.NavigableMap
        public /* synthetic */ NavigableMap headMap(Object r3, boolean r4) {
            return a((Cut) ZeusTransformUtils.preCheckCast(r3, Cut.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.b(entryIterator());
        }

        @Override // java.util.NavigableMap
        public /* synthetic */ NavigableMap subMap(Object r3, boolean r4, Object r5, boolean r6) {
            return a((Cut) ZeusTransformUtils.preCheckCast(r3, Cut.class, "com.obric.memorydata.plugin"), r4, (Cut) ZeusTransformUtils.preCheckCast(r5, Cut.class, "com.obric.memorydata.plugin"), r6);
        }

        @Override // java.util.NavigableMap
        public /* synthetic */ NavigableMap tailMap(Object r3, boolean r4) {
            return b((Cut) ZeusTransformUtils.preCheckCast(r3, Cut.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> r3) {
        this.rangesByLowerBound = (NavigableMap) ZeusTransformUtils.wrapperContextForParams(r3, NavigableMap.class, "com.obric.memorydata.plugin");
    }

    /* synthetic */ TreeRangeSet(NavigableMap r2, AnonymousClass1 r3) {
        this((NavigableMap) ZeusTransformUtils.wrapperContextForParams(r2, NavigableMap.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Range access$600(TreeRangeSet r0, Range r1) {
        return r0.rangeEnclosing(r1);
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet(new TreeMap());
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(at<C> r2) {
        at r3 = (at) ZeusTransformUtils.wrapperContextForParams(r2, at.class, "com.obric.memorydata.plugin");
        TreeRangeSet<C> r0 = create();
        r0.addAll(r3);
        return r0;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        TreeRangeSet<C> r0 = create();
        r0.addAll(r3);
        return r0;
    }

    private Range<C> rangeEnclosing(Range<C> r4) {
        com.google.common.base.n.a(r4);
        Map.Entry<Cut<C>, Range<C>> r3 = this.rangesByLowerBound.floorEntry(r4.lowerBound);
        if (r3 != null) goto L5;
    L7:
        return null;
    L5:
        if (((Range) ZeusTransformUtils.preCheckCast(r3.getValue(), Range.class, "com.obric.memorydata.plugin")).encloses(r4) == false) goto L7;
        return (Range) ZeusTransformUtils.preCheckCast(r3.getValue(), Range.class, "com.obric.memorydata.plugin");
    }

    private void replaceRangeWithSameLowerBound(Range<C> r2) {
        boolean r0 = r2.isEmpty();
        NavigableMap<Cut<C>, Range<C>> r1 = this.rangesByLowerBound;
        if (r0 == false) goto L5;
        r1.remove(r2.lowerBound);
        return;
    L5:
        r1.put(r2.lowerBound, r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.common.collect.f, com.google.common.collect.at
    public void add(Range<C> r5) {
        com.google.common.base.n.a(r5);
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        Cut<C> r0 = r5.lowerBound;
        Cut<C> r6 = r5.upperBound;
        Map.Entry<Cut<C>, Range<C>> r1 = this.rangesByLowerBound.lowerEntry(r0);
        if (r1 == null) goto L13;
        Range r2 = (Range) ZeusTransformUtils.preCheckCast(r1.getValue(), Range.class, "com.obric.memorydata.plugin");
        if (r2.upperBound.compareTo(r0) < 0) goto L13;
        if (r2.upperBound.compareTo(r6) < 0) goto L12;
        r6 = r2.upperBound;
    L12:
        r0 = r2.lowerBound;
    L13:
        Map.Entry<Cut<C>, Range<C>> r3 = this.rangesByLowerBound.floorEntry(r6);
        if (r3 == null) goto L18;
        Range r4 = (Range) ZeusTransformUtils.preCheckCast(r3.getValue(), Range.class, "com.obric.memorydata.plugin");
        if (r4.upperBound.compareTo(r6) < 0) goto L18;
        r6 = r4.upperBound;
    L18:
        this.rangesByLowerBound.subMap(r0, r6).clear();
        replaceRangeWithSameLowerBound(Range.create(r0, r6));
    }

    @Override // com.google.common.collect.f
    public /* synthetic */ void addAll(at r3) {
        super.addAll((at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin"));
    }

    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> r0 = this.asDescendingSetOfRanges;
        if (r0 != null) goto L6;
        a r1 = new a(this, this.rangesByLowerBound.descendingMap().values());
        this.asDescendingSetOfRanges = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.at
    public Set<Range<C>> asRanges() {
        Set<Range<C>> r0 = this.asRanges;
        if (r0 != null) goto L6;
        a r1 = new a(this, this.rangesByLowerBound.values());
        this.asRanges = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.at
    public at<C> complement() {
        at<C> r0 = this.complement;
        if (r0 != null) goto L6;
        Complement r1 = new Complement(this);
        this.complement = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.f
    public /* synthetic */ boolean contains(Comparable r3) {
        return super.contains((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.f, com.google.common.collect.at
    public boolean encloses(Range<C> r3) {
        com.google.common.base.n.a(r3);
        Map.Entry<Cut<C>, Range<C>> r2 = this.rangesByLowerBound.floorEntry(r3.lowerBound);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (((Range) ZeusTransformUtils.preCheckCast(r2.getValue(), Range.class, "com.obric.memorydata.plugin")).encloses(r3) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.f
    public /* synthetic */ boolean enclosesAll(at r3) {
        return super.enclosesAll((at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean equals(Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.collect.f
    public boolean intersects(Range<C> r6) {
        com.google.common.base.n.a(r6);
        Map.Entry<Cut<C>, Range<C>> r0 = this.rangesByLowerBound.ceilingEntry(r6.lowerBound);
        if (r0 != null) goto L5;
    L9:
        Map.Entry<Cut<C>, Range<C>> r5 = this.rangesByLowerBound.lowerEntry(r6.lowerBound);
        if (r5 != null) goto L12;
    L16:
        return false;
    L12:
        if (((Range) ZeusTransformUtils.preCheckCast(r5.getValue(), Range.class, "com.obric.memorydata.plugin")).isConnected(r6) == false) goto L16;
        if (((Range) ZeusTransformUtils.preCheckCast(r5.getValue(), Range.class, "com.obric.memorydata.plugin")).intersection(r6).isEmpty() == true) goto L16;
        return true;
    L5:
        if (((Range) ZeusTransformUtils.preCheckCast(r0.getValue(), Range.class, "com.obric.memorydata.plugin")).isConnected(r6) == false) goto L9;
        if (((Range) ZeusTransformUtils.preCheckCast(r0.getValue(), Range.class, "com.obric.memorydata.plugin")).intersection(r6).isEmpty() == true) goto L9;
        return true;
    }

    @Override // com.google.common.collect.f, com.google.common.collect.at
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.f
    public Range<C> rangeContaining(C r4) {
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        Map.Entry<Cut<C>, Range<C>> r3 = this.rangesByLowerBound.floorEntry(Cut.belowValue(r5));
        if (r3 != null) goto L5;
        return null;
    L5:
        if (((Range) ZeusTransformUtils.preCheckCast(r3.getValue(), Range.class, "com.obric.memorydata.plugin")).contains(r5) == true) goto L7;
        return null;
    L7:
        return (Range) ZeusTransformUtils.preCheckCast(r3.getValue(), Range.class, "com.obric.memorydata.plugin");
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
    @Override // com.google.common.collect.f, com.google.common.collect.at
    public void remove(Range<C> r5) {
        com.google.common.base.n.a(r5);
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        Map.Entry<Cut<C>, Range<C>> r0 = this.rangesByLowerBound.lowerEntry(r5.lowerBound);
        if (r0 == null) goto L15;
        Range r1 = (Range) ZeusTransformUtils.preCheckCast(r0.getValue(), Range.class, "com.obric.memorydata.plugin");
        if (r1.upperBound.compareTo(r5.lowerBound) < 0) goto L15;
        if (r5.hasUpperBound() == true) goto L12;
    L14:
        replaceRangeWithSameLowerBound(Range.create(r1.lowerBound, r5.lowerBound));
        goto L15
    L12:
        if (r1.upperBound.compareTo(r5.upperBound) < 0) goto L14;
        replaceRangeWithSameLowerBound(Range.create(r5.upperBound, r1.upperBound));
    L15:
        Map.Entry<Cut<C>, Range<C>> r2 = this.rangesByLowerBound.floorEntry(r5.upperBound);
        if (r2 == null) goto L22;
        Range r3 = (Range) ZeusTransformUtils.preCheckCast(r2.getValue(), Range.class, "com.obric.memorydata.plugin");
        if (r5.hasUpperBound() == false) goto L22;
        if (r3.upperBound.compareTo(r5.upperBound) < 0) goto L22;
        replaceRangeWithSameLowerBound(Range.create(r5.upperBound, r3.upperBound));
    L22:
        this.rangesByLowerBound.subMap(r5.lowerBound, r5.upperBound).clear();
    }

    @Override // com.google.common.collect.f, com.google.common.collect.at
    public /* synthetic */ void removeAll(at r3) {
        super.removeAll((at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin"));
    }

    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> r0 = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> r3 = this.rangesByLowerBound.lastEntry();
        if (r0 == null) goto L8;
        if (r3 == null) goto L8;
        return Range.create(((Range) ZeusTransformUtils.preCheckCast(r0.getValue(), Range.class, "com.obric.memorydata.plugin")).lowerBound, ((Range) ZeusTransformUtils.preCheckCast(r3.getValue(), Range.class, "com.obric.memorydata.plugin")).upperBound);
    L8:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.at
    public at<C> subRangeSet(Range<C> r2) {
        if (r2.equals(Range.all()) == false) goto L6;
        return this;
    L6:
        return new SubRangeSet(this, r2);
    }
}
