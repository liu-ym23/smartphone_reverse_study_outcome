package kotlin.reflect.jvm.internal.impl.utils;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public class SmartList<E> extends AbstractList<E> implements RandomAccess {
    private Object myElem;
    private int mySize;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.utils.SmartList$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class EmptyIterator<T> implements Iterator<T> {
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

    private class SingletonIterator extends SingletonIteratorBase<E> {
        private final int myInitialModCount;
        final /* synthetic */ SmartList this$0;

        public SingletonIterator(SmartList r10) {
            this.this$0 = r10;
            super(null);
            this.myInitialModCount = SmartList.access$100(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        protected void checkCoModification() {
            if (SmartList.access$300(this.this$0) != this.myInitialModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException("ModCount: " + SmartList.access$400(this.this$0) + "; expected: " + this.myInitialModCount);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        protected E getElement() {
            return (E) SmartList.access$200(this.this$0);
        }

        @Override // java.util.Iterator
        public void remove() {
            checkCoModification();
            this.this$0.clear();
        }
    }

    private static abstract class SingletonIteratorBase<T> implements Iterator<T> {
        private boolean myVisited;

        private SingletonIteratorBase() {
        }

        /* synthetic */ SingletonIteratorBase(AnonymousClass1 r10) {
            this();
        }

        protected abstract void checkCoModification();

        protected abstract T getElement();

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
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 2) goto L9;
        if (r10 == 3) goto L9;
        if (r10 == 5) goto L9;
        if (r10 == 6) goto L9;
        if (r10 == 7) goto L9;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L10:
        if (r10 == 2) goto L16;
        if (r10 == 3) goto L16;
        if (r10 == 5) goto L16;
        if (r10 == 6) goto L16;
        if (r10 == 7) goto L16;
        int r12 = 3;
    L17:
        Object[] r13 = new Object[r12];
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
        r13[0] = "elements";
    L23:
        if (r10 == 2) goto L30;
        if (r10 == 3) goto L30;
        if (r10 == 5) goto L29;
        if (r10 == 6) goto L29;
        if (r10 == 7) goto L29;
        r13[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
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
        r13[2] = "<init>";
        goto L34
    L33:
        r13[2] = "toArray";
    L34:
        String r14 = String.format(r11, r13);
        if (r10 == 2) goto L42;
        if (r10 == 3) goto L42;
        if (r10 == 5) goto L42;
        if (r10 == 6) goto L42;
        if (r10 == 7) goto L42;
        throw new IllegalArgumentException(r14);
    L42:
        throw new IllegalStateException(r14);
    L29:
        r13[1] = "toArray";
    L30:
        r13[1] = "iterator";
        goto L31
    L20:
        r13[0] = "a";
        goto L23
    L21:
        r13[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
    L16:
        r12 = 2;
    L9:
        r11 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    public SmartList() {
    }

    static /* synthetic */ int access$100(SmartList r10) {
        return ((AbstractList) r10).modCount;
    }

    static /* synthetic */ Object access$200(SmartList r10) {
        return r10.myElem;
    }

    static /* synthetic */ int access$300(SmartList r10) {
        return ((AbstractList) r10).modCount;
    }

    static /* synthetic */ int access$400(SmartList r10) {
        return ((AbstractList) r10).modCount;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r10, E r11) {
        if (r10 < 0) goto L20;
        int r12 = this.mySize;
        if (r10 > r12) goto L20;
        if (r12 != 0) goto L9;
        this.myElem = r11;
    L17:
        this.mySize++;
        ((AbstractList) this).modCount++;
        return;
    L9:
        if (r12 != 1) goto L12;
        if (r10 != 0) goto L12;
        this.myElem = new Object[]{r11, this.myElem};
    L12:
        Object[] r13 = new Object[r12 + 1];
        if (r12 != 1) goto L15;
        r13[0] = this.myElem;
    L16:
        r13[r10] = r11;
        this.myElem = r13;
        goto L17
    L15:
        Object[] r14 = (Object[]) this.myElem;
        System.arraycopy(r14, 0, r13, 0, r10);
        System.arraycopy(r14, r10, r13, r10 + 1, this.mySize - r10);
    L20:
        throw new IndexOutOfBoundsException("Index: " + r10 + ", Size: " + this.mySize);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r10) {
        int r11 = this.mySize;
        if (r11 != 0) goto L6;
        this.myElem = r10;
    L15:
        this.mySize++;
        ((AbstractList) this).modCount++;
        return true;
    L6:
        if (r11 != 1) goto L8;
        this.myElem = new Object[]{this.myElem, r10};
        goto L15
    L8:
        Object[] r12 = (Object[]) this.myElem;
        int r13 = r12.length;
        if (r11 < r13) goto L14;
        int r14 = ((r13 * 3) / 2) + 1;
        int r15 = r11 + 1;
        if (r14 >= r15) goto L13;
        r14 = r15;
    L13:
        Object[] r16 = new Object[r14];
        this.myElem = r16;
        System.arraycopy(r12, 0, r16, 0, r13);
        r12 = r16;
    L14:
        r12[this.mySize] = r10;
        goto L15
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.myElem = null;
        this.mySize = 0;
        ((AbstractList) this).modCount++;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractList, java.util.List
    public E get(int r10) {
        if (r10 < 0) goto L11;
        int r11 = this.mySize;
        if (r10 >= r11) goto L11;
        E r12 = (E) this.myElem;
        if (r11 != 1) goto L9;
        return r12;
    L9:
        return (E) ((Object[]) r12)[r10];
    L11:
        throw new IndexOutOfBoundsException("Index: " + r10 + ", Size: " + this.mySize);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        int r10 = this.mySize;
        if (r10 != 0) goto L9;
        EmptyIterator r11 = EmptyIterator.getInstance();
        if (r11 != null) goto L7;
        $$$reportNull$$$0(2);
    L7:
        return r11;
    L9:
        if (r10 == 1) goto L11;
        Iterator<E> r12 = super.iterator();
        if (r12 != null) goto L15;
        $$$reportNull$$$0(3);
    L15:
        return r12;
    L11:
        return new SingletonIterator(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int r10) {
        if (r10 < 0) goto L19;
        int r11 = this.mySize;
        if (r10 >= r11) goto L19;
        if (r11 != 1) goto L8;
        E r12 = (E) this.myElem;
        this.myElem = null;
    L16:
        this.mySize--;
        ((AbstractList) this).modCount++;
        return r12;
    L8:
        Object[] r13 = (Object[]) this.myElem;
        Object r14 = r13[r10];
        if (r11 != 2) goto L11;
        this.myElem = r13[1 - r10];
    L15:
        r12 = (E) r14;
        goto L16
    L11:
        int r15 = (r11 - r10) - 1;
        if (r15 <= 0) goto L14;
        System.arraycopy(r13, r10 + 1, r13, r10, r15);
    L14:
        r13[this.mySize - 1] = null;
    L19:
        throw new IndexOutOfBoundsException("Index: " + r10 + ", Size: " + this.mySize);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r10, E r11) {
        if (r10 < 0) goto L11;
        int r12 = this.mySize;
        if (r10 >= r12) goto L11;
        if (r12 != 1) goto L8;
        E r13 = (E) this.myElem;
        this.myElem = r11;
        return r13;
    L8:
        Object[] r14 = (Object[]) this.myElem;
        E r15 = (E) r14[r10];
        r14[r10] = r11;
        return r15;
    L11:
        throw new IndexOutOfBoundsException("Index: " + r10 + ", Size: " + this.mySize);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mySize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r10) {
        if (r10 != 0) goto L4;
        $$$reportNull$$$0(4);
    L4:
        int r11 = r10.length;
        int r12 = this.mySize;
        if (r12 != 1) goto L10;
        if (r11 == 0) goto L8;
        r10[0] = this.myElem;
    L17:
        int r13 = this.mySize;
        if (r11 <= r13) goto L20;
        r10[r13] = 0;
    L20:
        return r10;
    L8:
        T[] r14 = (T[]) ((Object[]) Array.newInstance(r10.getClass().getComponentType(), 1));
        r14[0] = this.myElem;
        return r14;
    L10:
        if (r11 >= r12) goto L15;
        T[] r15 = (T[]) Arrays.copyOf((Object[]) this.myElem, r12, r10.getClass());
        if (r15 != null) goto L14;
        $$$reportNull$$$0(6);
    L14:
        return r15;
    L15:
        if (r12 == 0) goto L17;
        System.arraycopy(this.myElem, 0, r10, 0, r12);
        goto L17
    }
}
