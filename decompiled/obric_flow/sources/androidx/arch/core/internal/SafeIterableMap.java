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

    public static class AscendingIterator<K, V> extends ListIterator<K, V> {
        public AscendingIterator(Entry<K, V> r5, Entry<K, V> r10) {
            super(r5, r10);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> backward(Entry<K, V> r5) {
            return r5.mPrevious;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> forward(Entry<K, V> r5) {
            return r5.mNext;
        }
    }

    public static class DescendingIterator<K, V> extends ListIterator<K, V> {
        public DescendingIterator(Entry<K, V> r5, Entry<K, V> r10) {
            super(r5, r10);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> backward(Entry<K, V> r5) {
            return r5.mNext;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> forward(Entry<K, V> r5) {
            return r5.mPrevious;
        }
    }

    public static class Entry<K, V> implements Map.Entry<K, V> {

        @NonNull
        final K mKey;
        Entry<K, V> mNext;
        Entry<K, V> mPrevious;

        @NonNull
        final V mValue;

        public Entry(@NonNull K r5, @NonNull V r10) {
            this.mKey = r5;
            this.mValue = r10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof Entry) == true) goto L8;
            return false;
        L8:
            Entry r10 = (Entry) r5;
            if (this.mKey.equals(r10.mKey) == false) goto L14;
            if (this.mValue.equals(r10.mValue) == false) goto L14;
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
            int r5 = this.mKey.hashCode();
            return this.mValue.hashCode() ^ r5;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r5) {
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

        public IteratorWithAdditions(SafeIterableMap r5) {
            this.this$0 = r5;
            this.mBeforeStart = true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mBeforeStart == true) goto L5;
            Entry<K, V> r5 = this.mCurrent;
            if (r5 != null) goto L11;
            return false;
        L11:
            if (r5.mNext != null) goto L13;
            return false;
        L13:
            return true;
        L5:
            if (this.this$0.mStart != null) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(@NonNull Entry<K, V> r5) {
            Entry<K, V> r10 = this.mCurrent;
            if (r5 != r10) goto L10;
            Entry<K, V> r11 = r10.mPrevious;
            this.mCurrent = r11;
            if (r11 != null) goto L7;
            boolean r12 = true;
        L8:
            this.mBeforeStart = r12;
            return;
        L7:
            r12 = false;
            goto L8
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.mBeforeStart == false) goto L5;
            this.mBeforeStart = false;
            this.mCurrent = this.this$0.mStart;
        L11:
            return this.mCurrent;
        L5:
            Entry<K, V> r5 = this.mCurrent;
            if (r5 == null) goto L8;
            Entry<K, V> r10 = r5.mNext;
        L9:
            this.mCurrent = r10;
            goto L11
        L8:
            r10 = null;
            goto L9
        }
    }

    public static abstract class ListIterator<K, V> extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        Entry<K, V> mExpectedEnd;
        Entry<K, V> mNext;

        public ListIterator(Entry<K, V> r5, Entry<K, V> r10) {
            this.mExpectedEnd = r10;
            this.mNext = r5;
        }

        private Entry<K, V> nextNode() {
            Entry<K, V> r5 = this.mNext;
            Entry<K, V> r10 = this.mExpectedEnd;
            if (r5 == r10) goto L8;
            if (r10 != null) goto L7;
            return null;
        L7:
            return forward(r5);
        L8:
            return null;
        }

        public abstract Entry<K, V> backward(Entry<K, V> r5);

        public abstract Entry<K, V> forward(Entry<K, V> r5);

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

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(@NonNull Entry<K, V> r5) {
            if (this.mExpectedEnd == r5) goto L5;
        L7:
            Entry<K, V> r10 = this.mExpectedEnd;
            if (r10 != r5) goto L11;
            this.mExpectedEnd = backward(r10);
        L11:
            if (this.mNext != r5) goto L14;
            this.mNext = nextNode();
            return;
        L14:
            return;
        L5:
            if (r5 != this.mNext) goto L7;
            this.mNext = null;
            this.mExpectedEnd = null;
            goto L7
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            Entry<K, V> r5 = this.mNext;
            this.mNext = nextNode();
            return r5;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class SupportRemove<K, V> {
        public SupportRemove() {
        }

        public abstract void supportRemove(@NonNull Entry<K, V> r5);
    }

    public SafeIterableMap() {
        this.mIterators = new WeakHashMap();
        this.mSize = 0;
    }

    @NonNull
    public Iterator<Map.Entry<K, V>> descendingIterator() {
        DescendingIterator r5 = new DescendingIterator(this.mEnd, this.mStart);
        this.mIterators.put(r5, Boolean.FALSE);
        return r5;
    }

    @Nullable
    public Map.Entry<K, V> eldest() {
        return this.mStart;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SafeIterableMap) == true) goto L8;
        return false;
    L8:
        SafeIterableMap r10 = (SafeIterableMap) r5;
        if (size() == r10.size()) goto L11;
        return false;
    L11:
        Iterator<Map.Entry<K, V>> r11 = iterator();
        Iterator<Map.Entry<K, V>> r12 = r10.iterator();
    L13:
        if (r11.hasNext() == false) goto L24;
        if (r12.hasNext() == false) goto L24;
        Map.Entry<K, V> r13 = r11.next();
        Map.Entry<K, V> r14 = r12.next();
        if (r13 != null) goto L19;
        if (r14 == null) goto L19;
    L22:
        return false;
    L19:
        if (r13 == null) goto L13;
        if (r13.equals(r14) == true) goto L13;
    L24:
        if (r11.hasNext() == true) goto L29;
        if (r12.hasNext() == true) goto L29;
        return true;
    L29:
        return false;
    }

    @Nullable
    public Entry<K, V> get(K r5) {
        Entry<K, V> r10 = this.mStart;
    L3:
        if (r10 == null) goto L8;
        if (r10.mKey.equals(r5) == true) goto L8;
        r10 = r10.mNext;
    L8:
        return r10;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> r5 = iterator();
        int r10 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r10 = r10 + r5.next().hashCode();
        goto L4
    L6:
        return r10;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator r5 = new AscendingIterator(this.mStart, this.mEnd);
        this.mIterators.put(r5, Boolean.FALSE);
        return r5;
    }

    @NonNull
    public SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions() {
        SafeIterableMap<K, V>.IteratorWithAdditions r5 = new IteratorWithAdditions(this);
        this.mIterators.put(r5, Boolean.FALSE);
        return r5;
    }

    @Nullable
    public Map.Entry<K, V> newest() {
        return this.mEnd;
    }

    public Entry<K, V> put(@NonNull K r5, @NonNull V r10) {
        Entry<K, V> r11 = new Entry(r5, r10);
        this.mSize++;
        Entry<K, V> r12 = this.mEnd;
        if (r12 != null) goto L6;
        this.mStart = r11;
        this.mEnd = r11;
        return r11;
    L6:
        r12.mNext = r11;
        r11.mPrevious = r12;
        this.mEnd = r11;
        return r11;
    }

    public V putIfAbsent(@NonNull K r5, @NonNull V r10) {
        Entry<K, V> r11 = get(r5);
        if (r11 != null) goto L5;
        put(r5, r10);
        return null;
    L5:
        return r11.mValue;
    }

    public V remove(@NonNull K r5) {
        Entry<K, V> r10 = get(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        this.mSize--;
        if (this.mIterators.isEmpty() == true) goto L11;
        Iterator<SupportRemove<K, V>> r11 = this.mIterators.keySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        r11.next().supportRemove(r10);
    L11:
        Entry<K, V> r12 = r10.mPrevious;
        if (r12 == null) goto L14;
        r12.mNext = r10.mNext;
    L15:
        Entry<K, V> r13 = r10.mNext;
        if (r13 == null) goto L18;
        r13.mPrevious = r12;
    L19:
        r10.mNext = null;
        r10.mPrevious = null;
        return r10.mValue;
    L18:
        this.mEnd = r12;
        goto L19
    L14:
        this.mStart = r10.mNext;
        goto L15
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("[");
        Iterator<Map.Entry<K, V>> r10 = iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        r5.append(r10.next().toString());
        if (r10.hasNext() == false) goto L4;
        r5.append(", ");
        goto L4
    L8:
        r5.append("]");
        return r5.toString();
    }
}
