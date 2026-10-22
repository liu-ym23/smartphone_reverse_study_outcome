package kotlin.reflect.jvm.internal.impl.utils;

import ai.j0;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public class SmartList<E> extends AbstractList<E> implements RandomAccess {
    private Object myElem;
    private int mySize;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.utils.SmartList$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class EmptyIterator<T> implements Iterator<T> {
        private static final EmptyIterator INSTANCE = null;

        static {
            INSTANCE = new EmptyIterator();
        }

        private EmptyIterator() {
        }

        public static <T> EmptyIterator<T> getInstance() {
            return INSTANCE;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    public class SingletonIterator extends SingletonIteratorBase<E> {
        private final int myInitialModCount;
        final /* synthetic */ SmartList this$0;

        public SingletonIterator(SmartList r5) {
            this.this$0 = r5;
            super(null);
            this.myInitialModCount = SmartList.access$100(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        public void checkCoModification() {
            if (SmartList.access$300(this.this$0) != this.myInitialModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException("ModCount: " + SmartList.access$400(this.this$0) + "; expected: " + this.myInitialModCount);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        public E getElement() {
            return (E) SmartList.access$200(this.this$0);
        }

        @Override // java.util.Iterator
        public void remove() {
            checkCoModification();
            this.this$0.clear();
        }
    }

    public static abstract class SingletonIteratorBase<T> implements Iterator<T> {
        private boolean myVisited;

        private SingletonIteratorBase() {
        }

        public abstract void checkCoModification();

        public abstract T getElement();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.myVisited;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.myVisited == true) goto L7;
            this.myVisited = true;
            checkCoModification();
            return getElement();
        L7:
            throw new NoSuchElementException();
        }

        public /* synthetic */ SingletonIteratorBase(AnonymousClass1 r5) {
            this();
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 2) goto L9;
        if (r10 == 3) goto L9;
        if (r10 == 5) goto L9;
        if (r10 == 6) goto L9;
        if (r10 == 7) goto L9;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L10:
        if (r10 == 2) goto L16;
        if (r10 == 3) goto L16;
        if (r10 == 5) goto L16;
        if (r10 == 6) goto L16;
        if (r10 == 7) goto L16;
        int r11 = 3;
    L17:
        Object[] r12 = new Object[r11];
        switch(r10) {
            case 2: goto L21;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L21;
            case 6: goto L21;
            case 7: goto L21;
            default: goto L19;
        };
    L19:
        r12[0] = "elements";
    L23:
        if (r10 == 2) goto L30;
        if (r10 == 3) goto L30;
        if (r10 == 5) goto L29;
        if (r10 == 6) goto L29;
        if (r10 == 7) goto L29;
        r12[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
    L31:
        switch(r10) {
            case 2: goto L34;
            case 3: goto L34;
            case 4: goto L33;
            case 5: goto L34;
            case 6: goto L34;
            case 7: goto L34;
            default: goto L32;
        };
    L32:
        r12[2] = "<init>";
        goto L34
    L33:
        r12[2] = "toArray";
    L34:
        String r13 = String.format(r5, r12);
        if (r10 == 2) goto L42;
        if (r10 == 3) goto L42;
        if (r10 == 5) goto L42;
        if (r10 == 6) goto L42;
        if (r10 == 7) goto L42;
        throw new IllegalArgumentException(r13);
    L42:
        throw new IllegalStateException(r13);
    L29:
        r12[1] = "toArray";
    L30:
        r12[1] = "iterator";
        goto L31
    L20:
        r12[0] = "a";
        goto L23
    L21:
        r12[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
    L16:
        r11 = 2;
    L9:
        r5 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    public SmartList() {
    }

    public static /* synthetic */ int access$100(SmartList r5) {
        return ((AbstractList) r5).modCount;
    }

    public static /* synthetic */ Object access$200(SmartList r5) {
        return r5.myElem;
    }

    public static /* synthetic */ int access$300(SmartList r5) {
        return ((AbstractList) r5).modCount;
    }

    public static /* synthetic */ int access$400(SmartList r5) {
        return ((AbstractList) r5).modCount;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r10) {
        int r5 = this.mySize;
        if (r5 != 0) goto L5;
        this.myElem = r10;
    L14:
        this.mySize++;
        ((AbstractList) this).modCount++;
        return true;
    L5:
        if (r5 != 1) goto L7;
        this.myElem = new Object[]{this.myElem, r10};
        goto L14
    L7:
        Object[] r11 = (Object[]) this.myElem;
        int r12 = r11.length;
        if (r5 < r12) goto L13;
        int r13 = ((r12 * 3) / 2) + 1;
        int r14 = r5 + 1;
        if (r13 >= r14) goto L12;
        r13 = r14;
    L12:
        Object[] r15 = new Object[r13];
        this.myElem = r15;
        System.arraycopy(r11, 0, r15, 0, r12);
        r11 = r15;
    L13:
        r11[this.mySize] = r10;
        goto L14
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.myElem = null;
        this.mySize = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r5) {
        if (r5 < 0) goto L11;
        int r10 = this.mySize;
        if (r5 >= r10) goto L11;
        if (r10 != 1) goto L10;
        return (E) this.myElem;
    L10:
        return (E) ((Object[]) this.myElem)[r5];
    L11:
        StringBuilder r11 = j0.s(r5, "Index: ", ", Size: ");
        r11.append(this.mySize);
        throw new IndexOutOfBoundsException(r11.toString());
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        int r5 = this.mySize;
        if (r5 != 0) goto L9;
        EmptyIterator r10 = EmptyIterator.getInstance();
        if (r10 != null) goto L7;
        $$$reportNull$$$0(2);
    L7:
        return r10;
    L9:
        if (r5 == 1) goto L11;
        Iterator<E> r11 = super.iterator();
        if (r11 != null) goto L15;
        $$$reportNull$$$0(3);
    L15:
        return r11;
    L11:
        return new SingletonIterator(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int r10) {
        if (r10 < 0) goto L18;
        int r5 = this.mySize;
        if (r10 >= r5) goto L18;
        if (r5 != 1) goto L8;
        E r11 = (E) this.myElem;
        this.myElem = null;
    L16:
        this.mySize--;
        ((AbstractList) this).modCount++;
        return r11;
    L8:
        Object[] r12 = (Object[]) this.myElem;
        Object r13 = r12[r10];
        if (r5 != 2) goto L11;
        this.myElem = r12[1 - r10];
    L15:
        r11 = (E) r13;
        goto L16
    L11:
        int r14 = (r5 - r10) - 1;
        if (r14 <= 0) goto L14;
        System.arraycopy(r12, r10 + 1, r12, r10, r14);
    L14:
        r12[this.mySize - 1] = null;
    L18:
        StringBuilder r15 = j0.s(r10, "Index: ", ", Size: ");
        r15.append(this.mySize);
        throw new IndexOutOfBoundsException(r15.toString());
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r5, E r10) {
        if (r5 < 0) goto L10;
        int r11 = this.mySize;
        if (r5 >= r11) goto L10;
        if (r11 != 1) goto L8;
        E r12 = (E) this.myElem;
        this.myElem = r10;
        return r12;
    L8:
        Object[] r13 = (Object[]) this.myElem;
        E r14 = (E) r13[r5];
        r13[r5] = r10;
        return r14;
    L10:
        StringBuilder r15 = j0.s(r5, "Index: ", ", Size: ");
        r15.append(this.mySize);
        throw new IndexOutOfBoundsException(r15.toString());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mySize;
    }

    @Override // java.util.List
    public void sort(Comparator<? super E> r5) {
        int r10 = this.mySize;
        if (r10 < 2) goto L6;
        Arrays.sort((Object[]) this.myElem, 0, r10, r5);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r5) {
        if (r5 != 0) goto L4;
        $$$reportNull$$$0(4);
    L4:
        int r10 = r5.length;
        int r11 = this.mySize;
        if (r11 != 1) goto L10;
        if (r10 == 0) goto L8;
        r5[0] = this.myElem;
    L17:
        int r12 = this.mySize;
        if (r10 <= r12) goto L20;
        r5[r12] = 0;
    L20:
        return r5;
    L8:
        T[] r13 = (T[]) ((Object[]) Array.newInstance(r5.getClass().getComponentType(), 1));
        r13[0] = this.myElem;
        return r13;
    L10:
        if (r10 >= r11) goto L15;
        T[] r14 = (T[]) Arrays.copyOf((Object[]) this.myElem, r11, r5.getClass());
        if (r14 != null) goto L14;
        $$$reportNull$$$0(6);
    L14:
        return r14;
    L15:
        if (r11 == 0) goto L17;
        System.arraycopy(this.myElem, 0, r5, 0, r11);
        goto L17
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r10, E r11) {
        if (r10 < 0) goto L18;
        int r5 = this.mySize;
        if (r10 > r5) goto L18;
        if (r5 != 0) goto L8;
        this.myElem = r11;
    L16:
        this.mySize++;
        ((AbstractList) this).modCount++;
        return;
    L8:
        if (r5 != 1) goto L11;
        if (r10 != 0) goto L11;
        this.myElem = new Object[]{r11, this.myElem};
    L11:
        Object[] r12 = new Object[r5 + 1];
        if (r5 != 1) goto L14;
        r12[0] = this.myElem;
    L15:
        r12[r10] = r11;
        this.myElem = r12;
        goto L16
    L14:
        Object[] r13 = (Object[]) this.myElem;
        System.arraycopy(r13, 0, r12, 0, r10);
        System.arraycopy(r13, r10, r12, r10 + 1, this.mySize - r10);
    L18:
        StringBuilder r14 = j0.s(r10, "Index: ", ", Size: ");
        r14.append(this.mySize);
        throw new IndexOutOfBoundsException(r14.toString());
    }
}
