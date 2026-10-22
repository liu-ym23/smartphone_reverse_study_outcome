package kotlin.reflect.jvm.internal.impl.utils;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSmartSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmartSet.kt\norg/jetbrains/kotlin/utils/SmartSet\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n1#2:111\n*E\n"})
public final class SmartSet<T> extends AbstractSet<T> {
    public static final Companion Companion = null;
    private Object data;
    private int size;

    public static final class ArrayIterator<T> implements Iterator<T>, KMutableIterator {
        private final Iterator<T> arrayIterator;

        public ArrayIterator(T[] r5) {
            Intrinsics.checkNotNullParameter(r5, "array");
            this.arrayIterator = ArrayIteratorKt.iterator(r5);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.arrayIterator.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.arrayIterator.next();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            remove();
        }

        @Override // java.util.Iterator
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @SourceDebugExtension({"SMAP\nSmartSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmartSet.kt\norg/jetbrains/kotlin/utils/SmartSet$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n1#2:111\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        public final <T> SmartSet<T> create() {
            return new SmartSet(null);
        }

        private Companion() {
        }

        @JvmStatic
        public final <T> SmartSet<T> create(Collection<? extends T> r5) {
            Intrinsics.checkNotNullParameter(r5, "set");
            SmartSet<T> r10 = new SmartSet(null);
            r10.addAll(r5);
            return r10;
        }
    }

    public static final class SingletonIterator<T> implements Iterator<T>, KMutableIterator {
        private final T element;
        private boolean hasNext;

        public SingletonIterator(T r5) {
            this.element = r5;
            this.hasNext = true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.hasNext == false) goto L7;
            this.hasNext = false;
            return this.element;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            remove();
        }

        @Override // java.util.Iterator
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ SmartSet(DefaultConstructorMarker r5) {
        this();
    }

    @JvmStatic
    public static final <T> SmartSet<T> create() {
        return Companion.create();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T r5) {
        if (size() != 0) goto L6;
        this.data = r5;
    L24:
        setSize(size() + 1);
        return true;
    L6:
        if (size() != 1) goto L12;
        if (Intrinsics.areEqual(this.data, r5) == false) goto L10;
        return false;
    L10:
        this.data = new Object[]{this.data, r5};
        goto L24
    L12:
        if (size() >= 5) goto L21;
        Object r10 = this.data;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        Object[] r11 = (Object[]) r10;
        if (ArraysKt.contains(r11, r5) == false) goto L17;
        return false;
    L17:
        if (size() != 4) goto L19;
        LinkedHashSet r12 = SetsKt.linkedSetOf(Arrays.copyOf(r11, r11.length));
        r12.add(r5);
        Object r13 = r12;
    L20:
        this.data = r13;
        goto L24
    L19:
        Object[] r14 = Arrays.copyOf(r11, size() + 1);
        r14[r14.length - 1] = r5;
        r13 = r14;
        goto L20
    L21:
        Object r15 = this.data;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        if (TypeIntrinsics.asMutableSet(r15).add(r5) == true) goto L24;
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.data = null;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        if (size() != 0) goto L6;
        return false;
    L6:
        if (size() != 1) goto L9;
        return Intrinsics.areEqual(this.data, r5);
    L9:
        if (size() >= 5) goto L11;
        Object r10 = this.data;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ArraysKt.contains((Object[]) r10, r5);
    L11:
        Object r11 = this.data;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) r11).contains(r5);
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() != 0) goto L6;
        return Collections.emptySet().iterator();
    L6:
        if (size() != 1) goto L10;
        Iterator<T> r5 = new SingletonIterator(this.data);
    L15:
        return r5;
    L10:
        if (size() >= 5) goto L12;
        Object r10 = this.data;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        r5 = new ArrayIterator((Object[]) r10);
        goto L15
    L12:
        Object r11 = this.data;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return TypeIntrinsics.asMutableSet(r11).iterator();
    }

    public void setSize(int r5) {
        this.size = r5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    private SmartSet() {
    }
}
