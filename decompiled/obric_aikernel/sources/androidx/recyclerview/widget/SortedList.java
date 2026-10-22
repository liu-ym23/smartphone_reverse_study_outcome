package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mNewDataStart;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback<T2> mWrappedCallback;

        public BatchedCallback(Callback<T2> r10) {
            this.mWrappedCallback = r10;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(r10);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 r10, T2 r11) {
            return this.mWrappedCallback.areContentsTheSame(r10, r11);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 r10, T2 r11) {
            return this.mWrappedCallback.areItemsTheSame(r10, r11);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 r10, T2 r11) {
            return this.mWrappedCallback.compare(r10, r11);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        @Nullable
        public Object getChangePayload(T2 r10, T2 r11) {
            return this.mWrappedCallback.getChangePayload(r10, r11);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int r10, int r11) {
            this.mBatchingListUpdateCallback.onChanged(r10, r11, null);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int r10, int r11, Object r12) {
            this.mBatchingListUpdateCallback.onChanged(r10, r11, r12);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int r10, int r11) {
            this.mBatchingListUpdateCallback.onInserted(r10, r11);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int r10, int r11) {
            this.mBatchingListUpdateCallback.onMoved(r10, r11);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int r10, int r11) {
            this.mBatchingListUpdateCallback.onRemoved(r10, r11);
        }
    }

    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public Callback() {
        }

        public abstract boolean areContentsTheSame(T2 r10, T2 r11);

        public abstract boolean areItemsTheSame(T2 r10, T2 r11);

        @Override // java.util.Comparator
        public abstract int compare(T2 r10, T2 r11);

        @Nullable
        public Object getChangePayload(T2 r10, T2 r11) {
            return null;
        }

        public abstract void onChanged(int r10, int r11);

        public void onChanged(int r10, int r11, Object r12) {
            onChanged(r10, r11);
        }
    }

    public SortedList(@NonNull Class<T> r10, @NonNull Callback<T> r11) {
        this(r10, r11, 10);
    }

    public SortedList(@NonNull Class<T> r10, @NonNull Callback<T> r11, int r12) {
        this.mTClass = r10;
        this.mData = (T[]) ((Object[]) Array.newInstance(r10, r12));
        this.mCallback = r11;
        this.mSize = 0;
    }

    private int add(T r10, boolean r11) {
        int r12 = findIndexOf(r10, this.mData, 0, this.mSize, 1);
        if (r12 != (-1)) goto L6;
        r12 = 0;
    L15:
        addToData(r12, r10);
        if (r11 == false) goto L18;
        this.mCallback.onInserted(r12, 1);
    L18:
        return r12;
    L6:
        if (r12 >= this.mSize) goto L15;
        T r13 = this.mData[r12];
        if (this.mCallback.areItemsTheSame(r13, r10) == false) goto L15;
        if (this.mCallback.areContentsTheSame(r13, r10) == false) goto L13;
        this.mData[r12] = r10;
        return r12;
    L13:
        this.mData[r12] = r10;
        Callback r14 = this.mCallback;
        r14.onChanged(r12, 1, r14.getChangePayload(r13, r10));
        return r12;
    }

    private void addAllInternal(T[] r10) {
        if (r10.length >= 1) goto L5;
        return;
    L5:
        int r11 = sortAndDedup(r10);
        if (this.mSize != 0) goto L8;
        this.mData = r10;
        this.mSize = r11;
        this.mCallback.onInserted(0, r11);
        return;
    L8:
        merge(r10, r11);
    }

    private void addToData(int r10, T r11) {
        int r12 = this.mSize;
        if (r10 > r12) goto L11;
        T[] r13 = this.mData;
        if (r12 != r13.length) goto L7;
        T[] r14 = (T[]) ((Object[]) Array.newInstance(this.mTClass, r13.length + 10));
        System.arraycopy(this.mData, 0, r14, 0, r10);
        r14[r10] = r11;
        System.arraycopy(this.mData, r10, r14, r10 + 1, this.mSize - r10);
        this.mData = r14;
    L8:
        this.mSize++;
        return;
    L7:
        System.arraycopy(r13, r10, r13, r10 + 1, r12 - r10);
        this.mData[r10] = r11;
        goto L8
    L11:
        throw new IndexOutOfBoundsException("cannot add item to " + r10 + " because size is " + this.mSize);
    }

    private T[] copyArray(T[] r10) {
        T[] r11 = (T[]) ((Object[]) Array.newInstance(this.mTClass, r10.length));
        System.arraycopy(r10, 0, r11, 0, r10.length);
        return r11;
    }

    private int findIndexOf(T r10, T[] r11, int r12, int r13, int r14) {
    L3:
        if (r12 >= r13) goto L19;
        int r15 = (r12 + r13) / 2;
        T r16 = r11[r15];
        int r17 = this.mCallback.compare(r16, r10);
        if (r17 < 0) goto L6;
        if (r17 == 0) goto L9;
        r13 = r15;
        goto L3
    L9:
        if (this.mCallback.areItemsTheSame(r16, r10) == false) goto L11;
        return r15;
    L11:
        int r18 = linearEqualitySearch(r10, r15, r12, r13);
        if (r14 != 1) goto L17;
        if (r18 != (-1)) goto L16;
        return r15;
    L16:
        return r18;
    L17:
        return r18;
    L6:
        r12 = r15 + 1;
        goto L3
    L19:
        if (r14 != 1) goto L22;
        return r12;
    L22:
        return -1;
    }

    private int findSameItem(T r10, T[] r11, int r12, int r13) {
    L2:
        if (r12 >= r13) goto L7;
        if (this.mCallback.areItemsTheSame(r11[r12], r10) == true) goto L5;
        r12 = r12 + 1;
        goto L2
    L5:
        return r12;
    L7:
        return -1;
    }

    private int linearEqualitySearch(T r10, int r11, int r12, int r13) {
        int r14 = r11 - 1;
    L3:
        if (r14 < r12) goto L11;
        T r15 = this.mData[r14];
        if (this.mCallback.compare(r15, r10) != 0) goto L11;
        if (this.mCallback.areItemsTheSame(r15, r10) == true) goto L9;
        r14 = r14 - 1;
        goto L3
    L9:
        return r14;
    L11:
        r11 = r11 + 1;
        if (r11 >= r13) goto L19;
        T r16 = this.mData[r11];
        if (this.mCallback.compare(r16, r10) != 0) goto L29;
        if (this.mCallback.areItemsTheSame(r16, r10) == false) goto L11;
        return r11;
    L29:
        return -1;
    L19:
        return -1;
    }

    private void merge(T[] r10, int r11) {
        boolean r12 = !(this.mCallback instanceof BatchedCallback);
        if (r12 == false) goto L5;
        beginBatchedUpdates();
    L5:
        this.mOldData = this.mData;
        int r13 = 0;
        this.mOldDataStart = 0;
        int r14 = this.mSize;
        this.mOldDataSize = r14;
        this.mData = (T[]) ((Object[]) Array.newInstance(this.mTClass, (r14 + r11) + 10));
        this.mNewDataStart = 0;
    L6:
        int r15 = this.mOldDataStart;
        int r16 = this.mOldDataSize;
        if (r15 < r16) goto L9;
        if (r13 < r11) goto L9;
    L13:
        this.mOldData = null;
        if (r12 == false) goto L41;
        endBatchedUpdates();
        return;
    L41:
        return;
    L9:
        if (r15 == r16) goto L10;
        if (r13 == r11) goto L12;
        T r17 = this.mOldData[r15];
        T r18 = r10[r13];
        int r19 = this.mCallback.compare(r17, r18);
        if (r19 > 0) goto L19;
        if (r19 != 0) goto L26;
        if (this.mCallback.areItemsTheSame(r17, r18) == false) goto L26;
        T[] r20 = this.mData;
        int r21 = this.mNewDataStart;
        this.mNewDataStart = r21 + 1;
        r20[r21] = r18;
        r13 = r13 + 1;
        this.mOldDataStart++;
        if (this.mCallback.areContentsTheSame(r17, r18) == true) goto L6;
        Callback r22 = this.mCallback;
        r22.onChanged(this.mNewDataStart - 1, 1, r22.getChangePayload(r17, r18));
    L26:
        T[] r23 = this.mData;
        int r24 = this.mNewDataStart;
        this.mNewDataStart = r24 + 1;
        r23[r24] = r17;
        this.mOldDataStart++;
        goto L6
    L19:
        T[] r25 = this.mData;
        int r26 = this.mNewDataStart;
        int r27 = r26 + 1;
        this.mNewDataStart = r27;
        r25[r26] = r18;
        this.mSize++;
        r13 = r13 + 1;
        this.mCallback.onInserted(r27 - 1, 1);
        goto L6
    L12:
        int r28 = r16 - r15;
        System.arraycopy(this.mOldData, r15, this.mData, this.mNewDataStart, r28);
        this.mNewDataStart += r28;
        goto L13
    L10:
        int r110 = r11 - r13;
        System.arraycopy(r10, r13, this.mData, this.mNewDataStart, r110);
        int r29 = this.mNewDataStart + r110;
        this.mNewDataStart = r29;
        this.mSize += r110;
        this.mCallback.onInserted(r29 - r110, r110);
        goto L13
    }

    private boolean remove(T r10, boolean r11) {
        int r12 = findIndexOf(r10, this.mData, 0, this.mSize, 2);
        if (r12 != (-1)) goto L6;
        return false;
    L6:
        removeItemAtIndex(r12, r11);
        return true;
    }

    private void removeItemAtIndex(int r10, boolean r11) {
        T[] r12 = this.mData;
        System.arraycopy(r12, r10 + 1, r12, r10, (this.mSize - r10) - 1);
        int r13 = this.mSize - 1;
        this.mSize = r13;
        this.mData[r13] = null;
        if (r11 == false) goto L6;
        this.mCallback.onRemoved(r10, 1);
        return;
    }

    private void replaceAllInsert(T r10) {
        T[] r11 = this.mData;
        int r12 = this.mNewDataStart;
        r11[r12] = r10;
        int r13 = r12 + 1;
        this.mNewDataStart = r13;
        this.mSize++;
        this.mCallback.onInserted(r13 - 1, 1);
    }

    private void replaceAllInternal(@NonNull T[] r10) {
        boolean r11 = !(this.mCallback instanceof BatchedCallback);
        if (r11 == false) goto L5;
        beginBatchedUpdates();
    L5:
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int r12 = sortAndDedup(r10);
        this.mData = (T[]) ((Object[]) Array.newInstance(this.mTClass, r12));
    L6:
        int r13 = this.mNewDataStart;
        if (r13 >= r12) goto L9;
    L10:
        int r14 = this.mOldDataStart;
        int r15 = this.mOldDataSize;
        if (r14 >= r15) goto L12;
        if (r13 >= r12) goto L14;
        T r16 = this.mOldData[r14];
        T r17 = r10[r13];
        int r18 = this.mCallback.compare(r16, r17);
        if (r18 < 0) goto L21;
        if (r18 > 0) goto L23;
        if (this.mCallback.areItemsTheSame(r16, r17) == false) goto L26;
        T[] r19 = this.mData;
        int r20 = this.mNewDataStart;
        r19[r20] = r17;
        this.mOldDataStart++;
        this.mNewDataStart = r20 + 1;
        if (this.mCallback.areContentsTheSame(r16, r17) == true) goto L6;
        Callback r21 = this.mCallback;
        r21.onChanged(this.mNewDataStart - 1, 1, r21.getChangePayload(r16, r17));
        goto L6
    L26:
        replaceAllRemove();
    L23:
        replaceAllInsert(r17);
        goto L6
    L21:
        replaceAllRemove();
        goto L6
    L14:
        int r22 = r15 - r14;
        this.mSize -= r22;
        this.mCallback.onRemoved(r13, r22);
    L15:
        this.mOldData = null;
        if (r11 == false) goto L44;
        endBatchedUpdates();
        return;
    L44:
        return;
    L12:
        int r23 = r12 - r13;
        System.arraycopy(r10, r13, this.mData, r13, r23);
        this.mNewDataStart += r23;
        this.mSize += r23;
        this.mCallback.onInserted(r13, r23);
        goto L15
    L9:
        if (this.mOldDataStart >= this.mOldDataSize) goto L15;
        goto L10
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(@NonNull T[] r10) {
        if (r10.length != 0) goto L5;
        return 0;
    L5:
        Arrays.sort(r10, this.mCallback);
        int r11 = 1;
        int r12 = 0;
        int r13 = 1;
    L7:
        if (r11 >= r10.length) goto L20;
        T r14 = r10[r11];
        if (this.mCallback.compare(r10[r12], r14) != 0) goto L16;
        int r15 = findSameItem(r14, r10, r12, r13);
        if (r15 == (-1)) goto L13;
        r10[r15] = r14;
    L19:
        r11 = r11 + 1;
        goto L7
    L13:
        if (r13 == r11) goto L15;
        r10[r13] = r14;
    L15:
        r13 = r13 + 1;
        goto L19
    L16:
        if (r13 == r11) goto L18;
        r10[r13] = r14;
    L18:
        r12 = r13;
        r13 = r13 + 1;
        goto L19
    L20:
        return r13;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
    }

    public int add(T r10) {
        throwIfInMutationOperation();
        return add(r10, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> r10) {
        addAll(r10.toArray((Object[]) Array.newInstance(this.mTClass, r10.size())), true);
    }

    public void addAll(@NonNull T... r10) {
        addAll(r10, false);
    }

    public void addAll(@NonNull T[] r10, boolean r11) {
        throwIfInMutationOperation();
        if (r10.length != 0) goto L5;
        return;
    L5:
        if (r11 == false) goto L7;
        addAllInternal(r10);
        return;
    L7:
        addAllInternal(copyArray(r10));
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback r10 = this.mCallback;
        if ((r10 instanceof BatchedCallback) == false) goto L6;
        return;
    L6:
        if (this.mBatchedCallback != null) goto L8;
        this.mBatchedCallback = new BatchedCallback(r10);
    L8:
        this.mCallback = this.mBatchedCallback;
    }

    public void clear() {
        throwIfInMutationOperation();
        int r10 = this.mSize;
        if (r10 != 0) goto L5;
        return;
    L5:
        Arrays.fill(this.mData, 0, r10, null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, r10);
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback r10 = this.mCallback;
        if ((r10 instanceof BatchedCallback) == false) goto L5;
        ((BatchedCallback) r10).dispatchLastEvent();
    L5:
        Callback r11 = this.mCallback;
        BatchedCallback r12 = this.mBatchedCallback;
        if (r11 != r12) goto L9;
        this.mCallback = r12.mWrappedCallback;
        return;
    }

    public T get(int r10) {
        if (r10 >= this.mSize) goto L14;
        if (r10 < 0) goto L14;
        T[] r11 = this.mOldData;
        if (r11 == null) goto L12;
        int r12 = this.mNewDataStart;
        if (r10 < r12) goto L12;
        return r11[(r10 - r12) + this.mOldDataStart];
    L12:
        return this.mData[r10];
    L14:
        throw new IndexOutOfBoundsException("Asked to get item at " + r10 + " but size is " + this.mSize);
    }

    public int indexOf(T r10) {
        if (this.mOldData == null) goto L13;
        int r11 = findIndexOf(r10, this.mData, 0, this.mNewDataStart, 4);
        if (r11 == (-1)) goto L7;
        return r11;
    L7:
        int r12 = findIndexOf(r10, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
        if (r12 != (-1)) goto L10;
        return -1;
    L10:
        return (r12 - this.mOldDataStart) + this.mNewDataStart;
    L13:
        return findIndexOf(r10, this.mData, 0, this.mSize, 4);
    }

    public void recalculatePositionOfItemAt(int r10) {
        throwIfInMutationOperation();
        T r11 = get(r10);
        removeItemAtIndex(r10, false);
        int r12 = add(r11, false);
        if (r10 == r12) goto L6;
        this.mCallback.onMoved(r10, r12);
        return;
    }

    public boolean remove(T r10) {
        throwIfInMutationOperation();
        return remove(r10, true);
    }

    public T removeItemAt(int r10) {
        throwIfInMutationOperation();
        T r11 = get(r10);
        removeItemAtIndex(r10, true);
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> r10) {
        replaceAll(r10.toArray((Object[]) Array.newInstance(this.mTClass, r10.size())), true);
    }

    public void replaceAll(@NonNull T... r10) {
        replaceAll(r10, false);
    }

    public void replaceAll(@NonNull T[] r10, boolean r11) {
        throwIfInMutationOperation();
        if (r11 == false) goto L5;
        replaceAllInternal(r10);
        return;
    L5:
        replaceAllInternal(copyArray(r10));
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int r10, T r11) {
        throwIfInMutationOperation();
        T r12 = get(r10);
        if (r12 != r11) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r12 != r11) goto L11;
    L16:
        if (r13 == false) goto L18;
        Callback r14 = this.mCallback;
        r14.onChanged(r10, 1, r14.getChangePayload(r12, r11));
    L18:
        removeItemAtIndex(r10, false);
        int r15 = add(r11, false);
        if (r10 == r15) goto L23;
        this.mCallback.onMoved(r10, r15);
        return;
    L23:
        return;
    L11:
        if (this.mCallback.compare(r12, r11) != 0) goto L16;
        this.mData[r10] = r11;
        if (r13 == false) goto L22;
        Callback r16 = this.mCallback;
        r16.onChanged(r10, 1, r16.getChangePayload(r12, r11));
        return;
    L22:
        return;
    L5:
        if (this.mCallback.areContentsTheSame(r12, r11) == false) goto L8;
        r13 = false;
        goto L9
    }
}
