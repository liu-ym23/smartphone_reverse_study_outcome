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
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes3.dex */
public final class SmartSet<T> extends AbstractSet<T> {
    public static final Companion Companion = null;
    private Object data;
    private int size;

    private static final class ArrayIterator<T> implements Iterator<T>, KMutableIterator {
        private final Iterator<T> arrayIterator;

        public ArrayIterator(T[] r10) {
            Intrinsics.checkNotNullParameter(r10, "array");
            this.arrayIterator = ArrayIteratorKt.iterator(r10);
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
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            remove();
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        public final <T> SmartSet<T> create() {
            return new SmartSet(null);
        }

        @JvmStatic
        public final <T> SmartSet<T> create(Collection<? extends T> r10) {
            Intrinsics.checkNotNullParameter(r10, "set");
            SmartSet<T> r11 = new SmartSet(null);
            r11.addAll(r10);
            return r11;
        }
    }

    private static final class SingletonIterator<T> implements Iterator<T>, KMutableIterator {
        private final T element;
        private boolean hasNext;

        public SingletonIterator(T r10) {
            this.element = r10;
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
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            remove();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private SmartSet() {
    }

    public /* synthetic */ SmartSet(DefaultConstructorMarker r10) {
        this();
    }

    @JvmStatic
    public static final <T> SmartSet<T> create() {
        return Companion.create();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T r10) {
        if (size() != 0) goto L6;
        this.data = r10;
    L24:
        setSize(size() + 1);
        return true;
    L6:
        if (size() != 1) goto L12;
        if (Intrinsics.areEqual(this.data, r10) == false) goto L10;
        return false;
    L10:
        this.data = new Object[]{this.data, r10};
        goto L24
    L12:
        if (size() >= 5) goto L21;
        Object r11 = this.data;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        Object[] r12 = (Object[]) r11;
        if (ArraysKt.contains(r12, r10) == false) goto L17;
        return false;
    L17:
        if (size() != 4) goto L19;
        LinkedHashSet r13 = SetsKt.linkedSetOf(Arrays.copyOf(r12, r12.length));
        r13.add(r10);
        Object r14 = r13;
    L20:
        this.data = r14;
        goto L24
    L19:
        Object[] r15 = Arrays.copyOf(r12, size() + 1);
        Intrinsics.checkNotNullExpressionValue(r15, "copyOf(this, newSize)");
        r15[r15.length - 1] = r10;
        r14 = r15;
        goto L20
    L21:
        Object r16 = this.data;
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        if (TypeIntrinsics.asMutableSet(r16).add(r10) == true) goto L24;
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.data = null;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r10) {
        if (size() != 0) goto L6;
        return false;
    L6:
        if (size() == 1) goto L14;
        int r11 = size();
        Object r12 = this.data;
        if (r11 >= 5) goto L11;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ArraysKt.contains((Object[]) r12, r10);
    L11:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) r12).contains(r10);
    L14:
        return Intrinsics.areEqual(this.data, r10);
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() != 0) goto L7;
        Set r10 = Collections.emptySet();
    L14:
        return r10.iterator();
    L7:
        if (size() != 1) goto L11;
        Iterator<T> r11 = new SingletonIterator(this.data);
    L15:
        return r11;
    L11:
        if (size() >= 5) goto L13;
        Object r12 = this.data;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        r11 = new ArrayIterator((Object[]) r12);
        goto L15
    L13:
        Object r13 = this.data;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        r10 = TypeIntrinsics.asMutableSet(r13);
        goto L14
    }

    public void setSize(int r10) {
        this.size = r10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
