package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {
    private Entry<K, V> mEnd;
    private final WeakHashMap<SupportRemove<K, V>, Boolean> mIterators;
    private int mSize;
    Entry<K, V> mStart;

    static class AscendingIterator<K, V> extends ListIterator<K, V> {
        AscendingIterator(Entry<K, V> r10, Entry<K, V> r11) {
            super(r10, r11);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> backward(Entry<K, V> r10) {
            return r10.mPrevious;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> forward(Entry<K, V> r10) {
            return r10.mNext;
        }
    }

    private static class DescendingIterator<K, V> extends ListIterator<K, V> {
        DescendingIterator(Entry<K, V> r10, Entry<K, V> r11) {
            super(r10, r11);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> backward(Entry<K, V> r10) {
            return r10.mNext;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> forward(Entry<K, V> r10) {
            return r10.mPrevious;
        }
    }

    static class Entry<K, V> implements Map.Entry<K, V> {

        @NonNull
        final K mKey;
        Entry<K, V> mNext;
        Entry<K, V> mPrevious;

        @NonNull
        final V mValue;

        Entry(@NonNull K r10, @NonNull V r11) {
            this.mKey = r10;
            this.mValue = r11;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof Entry) == true) goto L8;
            return false;
        L8:
            Entry r11 = (Entry) r10;
            if (this.mKey.equals(r11.mKey) == false) goto L14;
            if (this.mValue.equals(r11.mValue) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.mKey;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public V getValue() {
            return this.mValue;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int r10 = this.mKey.hashCode();
            return this.mValue.hashCode() ^ r10;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r10) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.mKey + "=" + this.mValue;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class IteratorWithAdditions extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        private boolean mBeforeStart;
        private Entry<K, V> mCurrent;
        final /* synthetic */ SafeIterableMap this$0;

        IteratorWithAdditions(SafeIterableMap r10) {
            this.this$0 = r10;
            this.mBeforeStart = true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mBeforeStart == true) goto L5;
            Entry<K, V> r10 = this.mCurrent;
            if (r10 == null) goto L15;
            if (r10.mNext == null) goto L15;
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
            Entry<K, V> r10 = this.this$0.mStart;
        L5:
            this.mCurrent = r10;
            return this.mCurrent;
        L6:
            Entry<K, V> r11 = this.mCurrent;
            if (r11 == null) goto L9;
            r10 = r11.mNext;
            goto L5
        L9:
            r10 = null;
            goto L5
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        void supportRemove(@NonNull Entry<K, V> r10) {
            Entry<K, V> r11 = this.mCurrent;
            if (r10 != r11) goto L10;
            Entry<K, V> r12 = r11.mPrevious;
            this.mCurrent = r12;
            if (r12 != null) goto L7;
            boolean r13 = true;
        L8:
            this.mBeforeStart = r13;
            return;
        L7:
            r13 = false;
            goto L8
        }
    }

    private static abstract class ListIterator<K, V> extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        Entry<K, V> mExpectedEnd;
        Entry<K, V> mNext;

        ListIterator(Entry<K, V> r10, Entry<K, V> r11) {
            this.mExpectedEnd = r11;
            this.mNext = r10;
        }

        private Entry<K, V> nextNode() {
            Entry<K, V> r10 = this.mNext;
            Entry<K, V> r11 = this.mExpectedEnd;
            if (r10 == r11) goto L8;
            if (r11 != null) goto L7;
            return null;
        L7:
            return forward(r10);
        L8:
            return null;
        }

        abstract Entry<K, V> backward(Entry<K, V> r10);

        abstract Entry<K, V> forward(Entry<K, V> r10);

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
            Entry<K, V> r10 = this.mNext;
            this.mNext = nextNode();
            return r10;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(@NonNull Entry<K, V> r10) {
            if (this.mExpectedEnd == r10) goto L5;
        L7:
            Entry<K, V> r11 = this.mExpectedEnd;
            if (r11 != r10) goto L11;
            this.mExpectedEnd = backward(r11);
        L11:
            if (this.mNext != r10) goto L14;
            this.mNext = nextNode();
            return;
        L14:
            return;
        L5:
            if (r10 != this.mNext) goto L7;
            this.mNext = null;
            this.mExpectedEnd = null;
            goto L7
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class SupportRemove<K, V> {
        public SupportRemove() {
        }

        abstract void supportRemove(@NonNull Entry<K, V> r10);
    }

    public SafeIterableMap() {
        this.mIterators = new WeakHashMap();
        this.mSize = 0;
    }

    @NonNull
    public Iterator<Map.Entry<K, V>> descendingIterator() {
        DescendingIterator r10 = new DescendingIterator(this.mEnd, this.mStart);
        this.mIterators.put(r10, Boolean.FALSE);
        return r10;
    }

    @Nullable
    public Map.Entry<K, V> eldest() {
        return this.mStart;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof SafeIterableMap) == true) goto L8;
        return false;
    L8:
        SafeIterableMap r11 = (SafeIterableMap) r10;
        if (size() == r11.size()) goto L11;
        return false;
    L11:
        Iterator<Map.Entry<K, V>> r12 = iterator();
        Iterator<Map.Entry<K, V>> r13 = r11.iterator();
    L13:
        if (r12.hasNext() == false) goto L24;
        if (r13.hasNext() == false) goto L24;
        Map.Entry<K, V> r14 = r12.next();
        Map.Entry<K, V> r15 = r13.next();
        if (r14 != null) goto L19;
        if (r15 == null) goto L19;
    L22:
        return false;
    L19:
        if (r14 == null) goto L13;
        if (r14.equals(r15) == true) goto L13;
    L24:
        if (r12.hasNext() == true) goto L29;
        if (r13.hasNext() == true) goto L29;
        return true;
    L29:
        return false;
    }

    @Nullable
    protected Entry<K, V> get(K r10) {
        Entry<K, V> r11 = this.mStart;
    L3:
        if (r11 == null) goto L8;
        if (r11.mKey.equals(r10) == true) goto L8;
        r11 = r11.mNext;
    L8:
        return r11;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> r10 = iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 + r10.next().hashCode();
        goto L4
    L6:
        return r11;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator r10 = new AscendingIterator(this.mStart, this.mEnd);
        this.mIterators.put(r10, Boolean.FALSE);
        return r10;
    }

    @NonNull
    public SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions() {
        SafeIterableMap<K, V>.IteratorWithAdditions r10 = new IteratorWithAdditions(this);
        this.mIterators.put(r10, Boolean.FALSE);
        return r10;
    }

    @Nullable
    public Map.Entry<K, V> newest() {
        return this.mEnd;
    }

    Entry<K, V> put(@NonNull K r10, @NonNull V r11) {
        Entry<K, V> r12 = new Entry(r10, r11);
        this.mSize++;
        Entry<K, V> r13 = this.mEnd;
        if (r13 != null) goto L7;
        this.mStart = r12;
    L5:
        this.mEnd = r12;
        return r12;
    L7:
        r13.mNext = r12;
        r12.mPrevious = r13;
        goto L5
    }

    public V putIfAbsent(@NonNull K r10, @NonNull V r11) {
        Entry<K, V> r12 = get(r10);
        if (r12 != null) goto L5;
        put(r10, r11);
        return null;
    L5:
        return r12.mValue;
    }

    public V remove(@NonNull K r10) {
        Entry<K, V> r11 = get(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        this.mSize--;
        if (this.mIterators.isEmpty() == true) goto L11;
        Iterator<SupportRemove<K, V>> r12 = this.mIterators.keySet().iterator();
    L9:
        if (r12.hasNext() == false) goto L11;
        r12.next().supportRemove(r11);
    L11:
        Entry<K, V> r13 = r11.mPrevious;
        Entry<K, V> r14 = r11.mNext;
        if (r13 == null) goto L14;
        r13.mNext = r14;
    L15:
        Entry<K, V> r15 = r11.mNext;
        if (r15 == null) goto L18;
        r15.mPrevious = r13;
    L19:
        r11.mNext = null;
        r11.mPrevious = null;
        return r11.mValue;
    L18:
        this.mEnd = r13;
        goto L19
    L14:
        this.mStart = r14;
        goto L15
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("[");
        Iterator<Map.Entry<K, V>> r11 = iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        r10.append(r11.next().toString());
        if (r11.hasNext() == false) goto L4;
        r10.append(", ");
        goto L4
    L8:
        r10.append("]");
        return r10.toString();
    }
}
