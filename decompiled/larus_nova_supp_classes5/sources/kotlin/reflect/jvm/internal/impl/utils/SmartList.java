package kotlin.reflect.jvm.internal.impl.utils;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class SmartList<E> extends AbstractList<E> implements RandomAccess {
    private Object myElem;
    private int mySize;

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
        int r6 = 3;
    L17:
        Object[] r7 = new Object[r6];
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
        r7[0] = "elements";
    L23:
        if (r10 == 2) goto L30;
        if (r10 == 3) goto L30;
        if (r10 == 5) goto L29;
        if (r10 == 6) goto L29;
        if (r10 == 7) goto L29;
        r7[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
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
        r7[2] = "<init>";
        goto L34
    L33:
        r7[2] = "toArray";
    L34:
        String r8 = String.format(r5, r7);
        if (r10 == 2) goto L42;
        if (r10 == 3) goto L42;
        if (r10 == 5) goto L42;
        if (r10 == 6) goto L42;
        if (r10 == 7) goto L42;
        throw new IllegalArgumentException(r8);
    L42:
        throw new IllegalStateException(r8);
    L29:
        r7[1] = "toArray";
    L30:
        r7[1] = "iterator";
        goto L31
    L20:
        r7[0] = "a";
        goto L23
    L21:
        r7[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
    L16:
        r6 = 2;
    L9:
        r5 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.myElem = null;
        this.mySize = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        int r0 = this.mySize;
        if (r0 != 0) goto L9;
        EmptyIterator r1 = EmptyIterator.getInstance();
        if (r1 != null) goto L7;
        $$$reportNull$$$0(2);
    L7:
        return r1;
    L9:
        if (r0 == 1) goto L11;
        Iterator<E> r2 = super.iterator();
        if (r2 != null) goto L15;
        $$$reportNull$$$0(3);
    L15:
        return r2;
    L11:
        return new SingletonIterator(this);
    }

    public SmartList() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mySize;
    }

    public static /* synthetic */ int access$100(SmartList r0) {
        return ((AbstractList) r0).modCount;
    }

    public static /* synthetic */ Object access$200(SmartList r0) {
        return r0.myElem;
    }

    public static /* synthetic */ int access$300(SmartList r0) {
        return ((AbstractList) r0).modCount;
    }

    public static /* synthetic */ int access$400(SmartList r0) {
        return ((AbstractList) r0).modCount;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r8) {
        int r0 = this.mySize;
        if (r0 != 0) goto L6;
        this.myElem = r8;
    L15:
        this.mySize++;
        ((AbstractList) this).modCount++;
        return true;
    L6:
        if (r0 != 1) goto L8;
        this.myElem = new Object[]{this.myElem, r8};
        goto L15
    L8:
        Object[] r4 = (Object[]) this.myElem;
        int r5 = r4.length;
        if (r0 < r5) goto L14;
        int r6 = ((r5 * 3) / 2) + 1;
        int r1 = r0 + 1;
        if (r6 >= r1) goto L13;
        r6 = r1;
    L13:
        Object[] r2 = new Object[r6];
        this.myElem = r2;
        System.arraycopy(r4, 0, r2, 0, r5);
        r4 = r2;
    L14:
        r4[this.mySize] = r8;
        goto L15
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r4) {
        if (r4 < 0) goto L12;
        int r0 = this.mySize;
        if (r4 >= r0) goto L12;
        if (r0 != 1) goto L10;
        return (E) this.myElem;
    L10:
        return (E) ((Object[]) this.myElem)[r4];
    L12:
        throw new IndexOutOfBoundsException("Index: " + r4 + ", Size: " + this.mySize);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int r7) {
        if (r7 < 0) goto L19;
        int r0 = this.mySize;
        if (r7 >= r0) goto L19;
        if (r0 != 1) goto L8;
        E r8 = (E) this.myElem;
        this.myElem = null;
    L16:
        this.mySize--;
        ((AbstractList) this).modCount++;
        return r8;
    L8:
        Object[] r3 = (Object[]) this.myElem;
        Object r4 = r3[r7];
        if (r0 != 2) goto L11;
        this.myElem = r3[1 - r7];
    L15:
        r8 = (E) r4;
        goto L16
    L11:
        int r1 = (r0 - r7) - 1;
        if (r1 <= 0) goto L14;
        System.arraycopy(r3, r7 + 1, r3, r7, r1);
    L14:
        r3[this.mySize - 1] = null;
    L19:
        throw new IndexOutOfBoundsException("Index: " + r7 + ", Size: " + this.mySize);
    }

    @Override // java.util.List
    public void sort(Comparator<? super E> r4) {
        int r0 = this.mySize;
        if (r0 < 2) goto L6;
        Arrays.sort((Object[]) this.myElem, 0, r0, r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r5) {
        if (r5 != 0) goto L4;
        $$$reportNull$$$0(4);
    L4:
        int r0 = r5.length;
        int r1 = this.mySize;
        if (r1 != 1) goto L10;
        if (r0 == 0) goto L8;
        r5[0] = this.myElem;
    L17:
        int r2 = this.mySize;
        if (r0 <= r2) goto L20;
        r5[r2] = 0;
    L20:
        return r5;
    L8:
        T[] r6 = (T[]) ((Object[]) Array.newInstance(r5.getClass().getComponentType(), 1));
        r6[0] = this.myElem;
        return r6;
    L10:
        if (r0 >= r1) goto L15;
        T[] r7 = (T[]) Arrays.copyOf((Object[]) this.myElem, r1, r5.getClass());
        if (r7 != null) goto L14;
        $$$reportNull$$$0(6);
    L14:
        return r7;
    L15:
        if (r1 == 0) goto L17;
        System.arraycopy(this.myElem, 0, r5, 0, r1);
        goto L17
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r6, E r7) {
        if (r6 < 0) goto L20;
        int r0 = this.mySize;
        if (r6 > r0) goto L20;
        if (r0 != 0) goto L9;
        this.myElem = r7;
    L17:
        this.mySize++;
        ((AbstractList) this).modCount++;
        return;
    L9:
        if (r0 != 1) goto L12;
        if (r6 != 0) goto L12;
        this.myElem = new Object[]{r7, this.myElem};
    L12:
        Object[] r3 = new Object[r0 + 1];
        if (r0 != 1) goto L15;
        r3[0] = this.myElem;
    L16:
        r3[r6] = r7;
        this.myElem = r3;
        goto L17
    L15:
        Object[] r1 = (Object[]) this.myElem;
        System.arraycopy(r1, 0, r3, 0, r6);
        System.arraycopy(r1, r6, r3, r6 + 1, this.mySize - r6);
    L20:
        throw new IndexOutOfBoundsException("Index: " + r6 + ", Size: " + this.mySize);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r3, E r4) {
        if (r3 < 0) goto L11;
        int r0 = this.mySize;
        if (r3 >= r0) goto L11;
        if (r0 != 1) goto L8;
        E r5 = (E) this.myElem;
        this.myElem = r4;
        return r5;
    L8:
        Object[] r1 = (Object[]) this.myElem;
        E r2 = (E) r1[r3];
        r1[r3] = r4;
        return r2;
    L11:
        throw new IndexOutOfBoundsException("Index: " + r3 + ", Size: " + this.mySize);
    }
}
