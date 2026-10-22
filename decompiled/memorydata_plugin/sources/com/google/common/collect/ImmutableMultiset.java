package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements an<E> {
    private transient ImmutableList<E> asList;
    private transient ImmutableSet<an.a<E>> entrySet;

    static final class ElementSet<E> extends ImmutableSet.Indexed<E> {
        private final an<E> delegate;
        private final List<an.a<E>> entries;

        ElementSet(List<an.a<E>> r3, an<E> r4) {
            List<an.a<E>> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            an<E> r6 = (an) ZeusTransformUtils.wrapperContextForParams(r4, an.class, "com.obric.memorydata.plugin");
            this.entries = r5;
            this.delegate = r6;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.delegate.contains(r1);
        }

        @Override // com.google.common.collect.ImmutableSet.Indexed
        E get(int r2) {
            return (E) ((an.a) ZeusTransformUtils.preCheckCast(this.entries.get(r2), an.a.class, "com.obric.memorydata.plugin")).getElement();
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.entries.size();
        }
    }

    private final class EntrySet extends IndexedImmutableSet<an.a<E>> {
        private static final long serialVersionUID = 0;
        final /* synthetic */ ImmutableMultiset this$0;

        private EntrySet(ImmutableMultiset r1) {
            this.this$0 = r1;
        }

        /* synthetic */ EntrySet(ImmutableMultiset r1, AnonymousClass1 r2) {
            this(r1);
        }

        private void readObject(ObjectInputStream r1) {
            throw new InvalidObjectException("Use EntrySetSerializedForm");
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, an.a.class) == false) goto L11;
            an.a r5 = (an.a) ZeusTransformUtils.preCheckCast(r4, an.a.class, "com.obric.memorydata.plugin");
            if (r5.getCount() > 0) goto L8;
            return false;
        L8:
            if (this.this$0.count(r5.getElement()) != r5.getCount()) goto L12;
            return true;
        L12:
            return false;
        L11:
            return false;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        an.a<E> get(int r1) {
            return this.this$0.getEntry(r1);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return this.this$0.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new EntrySetSerializedForm(this.this$0);
        }
    }

    static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        EntrySetSerializedForm(ImmutableMultiset<E> r1) {
            this.multiset = r1;
        }

        Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        SerializedForm(an<? extends Object> r6) {
            an r7 = (an) ZeusTransformUtils.wrapperContextForParams(r6, an.class, "com.obric.memorydata.plugin");
            int r0 = r7.entrySet().size();
            this.elements = new Object[r0];
            this.counts = new int[r0];
            Iterator<an.a<E>> r8 = r7.entrySet().iterator();
            int r1 = 0;
        L4:
            if (r8.hasNext() == false) goto L6;
            an.a r2 = (an.a) ZeusTransformUtils.preCheckCast(r8.next(), an.a.class, "com.obric.memorydata.plugin");
            this.elements[r1] = r2.getElement();
            this.counts[r1] = r2.getCount();
            r1 = r1 + 1;
            goto L4
        }

        Object readResolve() {
            LinkedHashMultiset r0 = LinkedHashMultiset.create(this.elements.length);
            int r1 = 0;
        L3:
            Object[] r2 = this.elements;
            if (r1 >= r2.length) goto L7;
            r0.add(r2[r1], this.counts[r1]);
            r1 = r1 + 1;
            goto L3
        L7:
            return ImmutableMultiset.copyOf(r0);
        }
    }

    public static class a<E> extends ImmutableCollection.a<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final an<E> f4463a;

        public a() {
            this(LinkedHashMultiset.create());
        }

        a(an<E> r3) {
            this.f4463a = (an) ZeusTransformUtils.wrapperContextForParams(r3, an.class, "com.obric.memorydata.plugin");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.a
        public /* synthetic */ ImmutableCollection.a a(Object r1) {
            return b(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.a
        public /* synthetic */ ImmutableCollection.a a(Iterator r3) {
            return b((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.a
        public /* synthetic */ ImmutableCollection.a a(Object[] r1) {
            return b(r1);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public a<E> a(E r2, int r3) {
            this.f4463a.add((E) com.google.common.base.n.a(r2), r3);
            return this;
        }

        public ImmutableMultiset<E> a() {
            return ImmutableMultiset.copyOf(this.f4463a);
        }

        public a<E> b(E r2) {
            this.f4463a.add((E) com.google.common.base.n.a(r2));
            return this;
        }

        public a<E> b(Iterator<? extends E> r3) {
            super.a((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public a<E> b(E... r1) {
            super.a(r1);
            return this;
        }
    }

    ImmutableMultiset() {
    }

    public static <E> a<E> builder() {
        return new a();
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... r1) {
        LinkedHashMultiset r0 = LinkedHashMultiset.create();
        Collections.addAll(r0, r1);
        return copyFromEntries(r0.entrySet());
    }

    static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends an.a<? extends E>> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == false) goto L7;
        return of();
    L7:
        return RegularImmutableMultiset.create(r3);
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ImmutableMultiset.class) == false) goto L8;
        ImmutableMultiset<E> r0 = (ImmutableMultiset) ZeusTransformUtils.preCheckCast(r4, ImmutableMultiset.class, "com.obric.memorydata.plugin");
        if (r0.isPartialView() == true) goto L8;
        return r0;
    L8:
        if (ZeusTransformUtils.instanceOf(r4, an.class) == false) goto L10;
        an r5 = Multisets.b(r4);
    L12:
        return copyFromEntries(r5.entrySet());
    L10:
        r5 = LinkedHashMultiset.create(r4);
        goto L12
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> r2) {
        Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        LinkedHashMultiset r0 = LinkedHashMultiset.create();
        Iterators.a(r0, r3);
        return copyFromEntries(r0.entrySet());
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] r0) {
        return copyFromElements(r0);
    }

    private ImmutableSet<an.a<E>> createEntrySet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new EntrySet(this, null);
    }

    static /* synthetic */ int lambda$toImmutableMultiset$0(Object r0) {
        return 1;
    }

    public static <E> ImmutableMultiset<E> of() {
        return (ImmutableMultiset<E>) RegularImmutableMultiset.EMPTY;
    }

    public static <E> ImmutableMultiset<E> of(E r2) {
        return copyFromElements(new Object[]{r2});
    }

    public static <E> ImmutableMultiset<E> of(E r2, E r3) {
        return copyFromElements(new Object[]{r2, r3});
    }

    public static <E> ImmutableMultiset<E> of(E r2, E r3, E r4) {
        return copyFromElements(new Object[]{r2, r3, r4});
    }

    public static <E> ImmutableMultiset<E> of(E r2, E r3, E r4, E r5) {
        return copyFromElements(new Object[]{r2, r3, r4, r5});
    }

    public static <E> ImmutableMultiset<E> of(E r2, E r3, E r4, E r5, E r6) {
        return copyFromElements(new Object[]{r2, r3, r4, r5, r6});
    }

    public static <E> ImmutableMultiset<E> of(E r1, E r2, E r3, E r4, E r5, E r6, E... r7) {
        return new a().b(r1).b(r2).b(r3).b(r4).b(r5).b(r6).b(r7).a();
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> Collector<E, ?, ImmutableMultiset<E>> toImmutableMultiset() {
        return n.a(Function.identity(), $$Lambda$ImmutableMultiset$nRr72WLeb7qI48k7MjN3TxRaBo.INSTANCE);
    }

    public static <T, E> Collector<T, ?, ImmutableMultiset<E>> toImmutableMultiset(Function<? super T, ? extends E> r2, ToIntFunction<? super T> r3) {
        return n.a((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin"), (ToIntFunction) ZeusTransformUtils.wrapperContextForParams(r3, ToIntFunction.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.an
    @Deprecated
    public final int add(E r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> r0 = this.asList;
        if (r0 != null) goto L6;
        ImmutableList<E> r1 = super.asList();
        this.asList = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r1) {
        if (count(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r4, int r5) {
        bj<an.a<E>> r3 = entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        an.a r0 = (an.a) ZeusTransformUtils.preCheckCast(r3.next(), an.a.class, "com.obric.memorydata.plugin");
        Arrays.fill(r4, r5, r0.getCount() + r5, r0.getElement());
        r5 = r5 + r0.getCount();
        goto L4
    L6:
        return r5;
    }

    public abstract ImmutableSet<E> elementSet();

    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.an
    public ImmutableSet<an.a<E>> entrySet() {
        ImmutableSet<an.a<E>> r0 = this.entrySet;
        if (r0 != null) goto L6;
        ImmutableSet<an.a<E>> r1 = createEntrySet();
        this.entrySet = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.an
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // java.util.Collection, com.google.common.collect.an
    public boolean equals(Object r1) {
        return Multisets.a(this, r1);
    }

    abstract an.a<E> getEntry(int r1);

    @Override // java.util.Collection, com.google.common.collect.an
    public int hashCode() {
        return Sets.a(entrySet());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public bj<E> iterator() {
        final bj<an.a<E>> r0 = entrySet().iterator();
        return new AnonymousClass1(this, r0);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.an
    @Deprecated
    public final int remove(Object r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.an
    @Deprecated
    public final int setCount(E r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.an
    @Deprecated
    public final boolean setCount(E r1, int r2, int r3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this);
    }
}
