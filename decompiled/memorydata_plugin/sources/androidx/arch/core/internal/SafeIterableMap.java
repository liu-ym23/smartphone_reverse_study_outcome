package androidx.arch.core.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {
    private Entry<K, V> mEnd;
    private final WeakHashMap<SupportRemove<K, V>, Boolean> mIterators;
    private int mSize;
    Entry<K, V> mStart;

    static class AscendingIterator<K, V> extends ListIterator<K, V> {
        AscendingIterator(Entry<K, V> r1, Entry<K, V> r2) {
            super(r1, r2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> backward(Entry<K, V> r1) {
            return r1.mPrevious;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> forward(Entry<K, V> r1) {
            return r1.mNext;
        }
    }

    private static class DescendingIterator<K, V> extends ListIterator<K, V> {
        DescendingIterator(Entry<K, V> r1, Entry<K, V> r2) {
            super(r1, r2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> backward(Entry<K, V> r1) {
            return r1.mNext;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> forward(Entry<K, V> r1) {
            return r1.mPrevious;
        }
    }

    static class Entry<K, V> implements Map.Entry<K, V> {
        final K mKey;
        Entry<K, V> mNext;
        Entry<K, V> mPrevious;
        final V mValue;

        Entry(K r1, V r2) {
            this.mKey = r1;
            this.mValue = r2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Entry.class) == true) goto L8;
            return false;
        L8:
            Entry r6 = (Entry) ZeusTransformUtils.preCheckCast(r5, Entry.class, "com.obric.memorydata.plugin");
            if (this.mKey.equals(r6.mKey) == false) goto L14;
            if (this.mValue.equals(r6.mValue) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.mKey;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.mValue;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int r0 = this.mKey.hashCode();
            return this.mValue.hashCode() ^ r0;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r1) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.mKey + "=" + this.mValue;
        }
    }

    public class IteratorWithAdditions extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        private boolean mBeforeStart;
        private Entry<K, V> mCurrent;
        final /* synthetic */ SafeIterableMap this$0;

        IteratorWithAdditions(SafeIterableMap r1) {
            this.this$0 = r1;
            this.mBeforeStart = true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mBeforeStart == true) goto L5;
            Entry<K, V> r3 = this.mCurrent;
            if (r3 == null) goto L15;
            if (r3.mNext == null) goto L15;
            return true;
        L15:
            return false;
        L5:
            if (this.this$0.mStart == null) goto L8;
            return true;
        L8:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.mBeforeStart == false) goto L6;
            this.mBeforeStart = false;
            Entry<K, V> r0 = this.this$0.mStart;
        L5:
            this.mCurrent = r0;
            return this.mCurrent;
        L6:
            Entry<K, V> r1 = this.mCurrent;
            if (r1 == null) goto L9;
            r0 = r1.mNext;
            goto L5
        L9:
            r0 = null;
            goto L5
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        void supportRemove(Entry<K, V> r2) {
            Entry<K, V> r0 = this.mCurrent;
            if (r2 != r0) goto L10;
            Entry<K, V> r3 = r0.mPrevious;
            this.mCurrent = r3;
            if (r3 != null) goto L7;
            boolean r4 = true;
        L8:
            this.mBeforeStart = r4;
            return;
        L7:
            r4 = false;
            goto L8
        }
    }

    private static abstract class ListIterator<K, V> extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        Entry<K, V> mExpectedEnd;
        Entry<K, V> mNext;

        ListIterator(Entry<K, V> r1, Entry<K, V> r2) {
            this.mExpectedEnd = r2;
            this.mNext = r1;
        }

        private Entry<K, V> nextNode() {
            Entry<K, V> r0 = this.mNext;
            Entry<K, V> r1 = this.mExpectedEnd;
            if (r0 == r1) goto L8;
            if (r1 != null) goto L7;
            return null;
        L7:
            return forward(r0);
        L8:
            return null;
        }

        abstract Entry<K, V> backward(Entry<K, V> r1);

        abstract Entry<K, V> forward(Entry<K, V> r1);

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mNext == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            Entry<K, V> r0 = this.mNext;
            this.mNext = nextNode();
            return r0;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(Entry<K, V> r2) {
            if (this.mExpectedEnd == r2) goto L5;
        L7:
            Entry<K, V> r0 = this.mExpectedEnd;
            if (r0 != r2) goto L11;
            this.mExpectedEnd = backward(r0);
        L11:
            if (this.mNext != r2) goto L14;
            this.mNext = nextNode();
            return;
        L14:
            return;
        L5:
            if (r2 != this.mNext) goto L7;
            this.mNext = null;
            this.mExpectedEnd = null;
            goto L7
        }
    }

    public static abstract class SupportRemove<K, V> {
        public SupportRemove() {
        }

        abstract void supportRemove(Entry<K, V> r1);
    }

    public SafeIterableMap() {
        this.mIterators = new WeakHashMap();
        this.mSize = 0;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        DescendingIterator r0 = new DescendingIterator(this.mEnd, this.mStart);
        this.mIterators.put(r0, false);
        return r0;
    }

    public Map.Entry<K, V> eldest() {
        return this.mStart;
    }

    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, SafeIterableMap.class) == true) goto L8;
        return false;
    L8:
        SafeIterableMap r7 = (SafeIterableMap) ZeusTransformUtils.preCheckCast(r6, SafeIterableMap.class, "com.obric.memorydata.plugin");
        if (size() == r7.size()) goto L11;
        return false;
    L11:
        Iterator<Map.Entry<K, V>> r5 = iterator();
        Iterator<Map.Entry<K, V>> r8 = r7.iterator();
    L13:
        if (r5.hasNext() == false) goto L24;
        if (r8.hasNext() == false) goto L24;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Map.Entry<K, V> r4 = r8.next();
        if (r0 != null) goto L19;
        if (r4 == null) goto L19;
    L22:
        return false;
    L19:
        if (r0 == null) goto L13;
        if (r0.equals(r4) == true) goto L13;
    L24:
        if (r5.hasNext() == true) goto L29;
        if (r8.hasNext() == true) goto L29;
        return true;
    L29:
        return false;
    }

    public Entry<K, V> get(K r2) {
        Entry<K, V> r1 = this.mStart;
    L3:
        if (r1 == null) goto L8;
        if (r1.mKey.equals(r2) == true) goto L8;
        r1 = r1.mNext;
    L8:
        return r1;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> r4 = iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin")).hashCode();
        goto L4
    L6:
        return r0;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator r0 = new AscendingIterator(this.mStart, this.mEnd);
        this.mIterators.put(r0, false);
        return r0;
    }

    public SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions() {
        SafeIterableMap<K, V>.IteratorWithAdditions r0 = new IteratorWithAdditions(this);
        this.mIterators.put(r0, false);
        return r0;
    }

    public Map.Entry<K, V> newest() {
        return this.mEnd;
    }

    Entry<K, V> put(K r2, V r3) {
        Entry<K, V> r0 = new Entry(r2, r3);
        this.mSize++;
        Entry<K, V> r4 = this.mEnd;
        if (r4 != null) goto L7;
        this.mStart = r0;
    L5:
        this.mEnd = r0;
        return r0;
    L7:
        r4.mNext = r0;
        r0.mPrevious = this.mEnd;
        goto L5
    }

    public V putIfAbsent(K r2, V r3) {
        Entry<K, V> r0 = get(r2);
        if (r0 != null) goto L5;
        put(r2, r3);
        return null;
    L5:
        return r0.mValue;
    }

    public V remove(K r6) {
        Entry<K, V> r7 = get(r6);
        if (r7 != null) goto L5;
        return null;
    L5:
        this.mSize--;
        if (this.mIterators.isEmpty() == true) goto L12;
        Iterator<SupportRemove<K, V>> r1 = this.mIterators.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L12;
        ((SupportRemove) ZeusTransformUtils.preCheckCast(r1.next(), SupportRemove.class, "com.obric.memorydata.plugin")).supportRemove(r7);
    L12:
        if (r7.mPrevious == null) goto L14;
        r7.mPrevious.mNext = r7.mNext;
    L16:
        if (r7.mNext == null) goto L18;
        r7.mNext.mPrevious = r7.mPrevious;
    L19:
        r7.mNext = null;
        r7.mPrevious = null;
        return r7.mValue;
    L18:
        this.mEnd = r7.mPrevious;
        goto L19
    L14:
        this.mStart = r7.mNext;
        goto L16
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[");
        Iterator<Map.Entry<K, V>> r4 = iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        r0.append(((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin")).toString());
        if (r4.hasNext() == false) goto L4;
        r0.append(", ");
        goto L4
    L8:
        r0.append("]");
        return r0.toString();
    }
}
