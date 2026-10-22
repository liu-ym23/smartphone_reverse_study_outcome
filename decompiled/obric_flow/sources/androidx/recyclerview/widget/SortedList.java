package androidx.recyclerview.widget;

import ai.j0;
import android.annotation.SuppressLint;
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

        @SuppressLint({"UnknownNullness"})
        public BatchedCallback(Callback<T2> r5) {
            this.mWrappedCallback = r5;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(r5);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 r5, T2 r10) {
            return this.mWrappedCallback.areContentsTheSame(r5, r10);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 r5, T2 r10) {
            return this.mWrappedCallback.areItemsTheSame(r5, r10);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 r5, T2 r10) {
            return this.mWrappedCallback.compare(r5, r10);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        @Nullable
        public Object getChangePayload(T2 r5, T2 r10) {
            return this.mWrappedCallback.getChangePayload(r5, r10);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int r5, int r10) {
            this.mBatchingListUpdateCallback.onChanged(r5, r10, null);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int r5, int r10) {
            this.mBatchingListUpdateCallback.onInserted(r5, r10);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int r5, int r10) {
            this.mBatchingListUpdateCallback.onMoved(r5, r10);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int r5, int r10) {
            this.mBatchingListUpdateCallback.onRemoved(r5, r10);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        @SuppressLint({"UnknownNullness"})
        public void onChanged(int r5, int r10, Object r11) {
            this.mBatchingListUpdateCallback.onChanged(r5, r10, r11);
        }
    }

    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public Callback() {
        }

        public abstract boolean areContentsTheSame(T2 r5, T2 r10);

        public abstract boolean areItemsTheSame(T2 r5, T2 r10);

        @Override // java.util.Comparator
        public abstract int compare(T2 r5, T2 r10);

        @Nullable
        public Object getChangePayload(T2 r5, T2 r10) {
            return null;
        }

        public abstract void onChanged(int r5, int r10);

        @SuppressLint({"UnknownNullness"})
        public void onChanged(int r5, int r10, Object r11) {
            onChanged(r5, r10);
        }
    }

    public SortedList(@NonNull Class<T> r5, @NonNull Callback<T> r10) {
        this(r5, r10, 10);
    }

    private void addAllInternal(T[] r5) {
        if (r5.length >= 1) goto L5;
        return;
    L5:
        int r10 = sortAndDedup(r5);
        if (this.mSize != 0) goto L8;
        this.mData = r5;
        this.mSize = r10;
        this.mCallback.onInserted(0, r10);
        return;
    L8:
        merge(r5, r10);
    }

    private void addToData(int r5, T r10) {
        int r11 = this.mSize;
        if (r5 > r11) goto L10;
        T[] r12 = this.mData;
        if (r11 != r12.length) goto L7;
        T[] r13 = (T[]) ((Object[]) Array.newInstance(this.mTClass, r12.length + 10));
        System.arraycopy(this.mData, 0, r13, 0, r5);
        r13[r5] = r10;
        System.arraycopy(this.mData, r5, r13, r5 + 1, this.mSize - r5);
        this.mData = r13;
    L8:
        this.mSize++;
        return;
    L7:
        System.arraycopy(r12, r5, r12, r5 + 1, r11 - r5);
        this.mData[r5] = r10;
        goto L8
    L10:
        StringBuilder r14 = j0.s(r5, "cannot add item to ", " because size is ");
        r14.append(this.mSize);
        throw new IndexOutOfBoundsException(r14.toString());
    }

    private T[] copyArray(T[] r5) {
        T[] r10 = (T[]) ((Object[]) Array.newInstance(this.mTClass, r5.length));
        System.arraycopy(r5, 0, r10, 0, r5.length);
        return r10;
    }

    private int findIndexOf(T r10, T[] r11, int r12, int r13, int r14) {
    L3:
        if (r12 >= r13) goto L19;
        int r5 = (r12 + r13) / 2;
        T r15 = r11[r5];
        int r16 = this.mCallback.compare(r15, r10);
        if (r16 < 0) goto L6;
        if (r16 == 0) goto L9;
        r13 = r5;
        goto L3
    L9:
        if (this.mCallback.areItemsTheSame(r15, r10) == false) goto L11;
        return r5;
    L11:
        int r17 = linearEqualitySearch(r10, r5, r12, r13);
        if (r14 != 1) goto L17;
        if (r17 != (-1)) goto L16;
        return r5;
    L16:
        return r17;
    L17:
        return r17;
    L6:
        r12 = r5 + 1;
        goto L3
    L19:
        if (r14 != 1) goto L22;
        return r12;
    L22:
        return -1;
    }

    private int findSameItem(T r5, T[] r10, int r11, int r12) {
    L2:
        if (r11 >= r12) goto L7;
        if (this.mCallback.areItemsTheSame(r10[r11], r5) == true) goto L5;
        r11 = r11 + 1;
        goto L2
    L5:
        return r11;
    L7:
        return -1;
    }

    private int linearEqualitySearch(T r5, int r10, int r11, int r12) {
        int r13 = r10 - 1;
    L3:
        if (r13 < r11) goto L11;
        T r14 = this.mData[r13];
        if (this.mCallback.compare(r14, r5) != 0) goto L11;
        if (this.mCallback.areItemsTheSame(r14, r5) == true) goto L9;
        r13 = r13 - 1;
        goto L3
    L9:
        return r13;
    L11:
        r10 = r10 + 1;
        if (r10 >= r12) goto L19;
        T r15 = this.mData[r10];
        if (this.mCallback.compare(r15, r5) != 0) goto L29;
        if (this.mCallback.areItemsTheSame(r15, r5) == false) goto L11;
        return r10;
    L29:
        return -1;
    L19:
        return -1;
    }

    private void merge(T[] r10, int r11) {
        boolean r5 = this.mCallback instanceof BatchedCallback;
        if (r5 == true) goto L5;
        beginBatchedUpdates();
    L5:
        this.mOldData = this.mData;
        int r12 = 0;
        this.mOldDataStart = 0;
        int r13 = this.mSize;
        this.mOldDataSize = r13;
        this.mData = (T[]) ((Object[]) Array.newInstance(this.mTClass, (r13 + r11) + 10));
        this.mNewDataStart = 0;
    L6:
        int r14 = this.mOldDataStart;
        int r15 = this.mOldDataSize;
        if (r14 < r15) goto L9;
        if (r12 < r11) goto L9;
    L13:
        this.mOldData = null;
        if (r5 == true) goto L41;
        endBatchedUpdates();
        return;
    L41:
        return;
    L9:
        if (r14 == r15) goto L10;
        if (r12 == r11) goto L12;
        T r16 = this.mOldData[r14];
        T r17 = r10[r12];
        int r18 = this.mCallback.compare(r16, r17);
        if (r18 > 0) goto L19;
        if (r18 != 0) goto L26;
        if (this.mCallback.areItemsTheSame(r16, r17) == false) goto L26;
        T[] r19 = this.mData;
        int r20 = this.mNewDataStart;
        this.mNewDataStart = r20 + 1;
        r19[r20] = r17;
        r12 = r12 + 1;
        this.mOldDataStart++;
        if (this.mCallback.areContentsTheSame(r16, r17) == true) goto L6;
        Callback r21 = this.mCallback;
        r21.onChanged(this.mNewDataStart - 1, 1, r21.getChangePayload(r16, r17));
    L26:
        T[] r22 = this.mData;
        int r23 = this.mNewDataStart;
        this.mNewDataStart = r23 + 1;
        r22[r23] = r16;
        this.mOldDataStart++;
        goto L6
    L19:
        T[] r24 = this.mData;
        int r25 = this.mNewDataStart;
        this.mNewDataStart = r25 + 1;
        r24[r25] = r17;
        this.mSize++;
        r12 = r12 + 1;
        this.mCallback.onInserted(r25, 1);
        goto L6
    L12:
        int r26 = r15 - r14;
        System.arraycopy(this.mOldData, r14, this.mData, this.mNewDataStart, r26);
        this.mNewDataStart += r26;
        goto L13
    L10:
        int r110 = r11 - r12;
        System.arraycopy(r10, r12, this.mData, this.mNewDataStart, r110);
        int r27 = this.mNewDataStart + r110;
        this.mNewDataStart = r27;
        this.mSize += r110;
        this.mCallback.onInserted(r27 - r110, r110);
        goto L13
    }

    private void removeItemAtIndex(int r5, boolean r10) {
        T[] r11 = this.mData;
        System.arraycopy(r11, r5 + 1, r11, r5, (this.mSize - r5) - 1);
        int r12 = this.mSize - 1;
        this.mSize = r12;
        this.mData[r12] = null;
        if (r10 == false) goto L6;
        this.mCallback.onRemoved(r5, 1);
        return;
    }

    private void replaceAllInsert(T r5) {
        T[] r10 = this.mData;
        int r11 = this.mNewDataStart;
        r10[r11] = r5;
        this.mNewDataStart = r11 + 1;
        this.mSize++;
        this.mCallback.onInserted(r11, 1);
    }

    private void replaceAllInternal(@NonNull T[] r10) {
        boolean r5 = this.mCallback instanceof BatchedCallback;
        if (r5 == true) goto L5;
        beginBatchedUpdates();
    L5:
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int r11 = sortAndDedup(r10);
        this.mData = (T[]) ((Object[]) Array.newInstance(this.mTClass, r11));
    L6:
        int r12 = this.mNewDataStart;
        if (r12 >= r11) goto L9;
    L10:
        int r13 = this.mOldDataStart;
        int r14 = this.mOldDataSize;
        if (r13 >= r14) goto L12;
        if (r12 >= r11) goto L14;
        T r15 = this.mOldData[r13];
        T r16 = r10[r12];
        int r17 = this.mCallback.compare(r15, r16);
        if (r17 < 0) goto L21;
        if (r17 > 0) goto L23;
        if (this.mCallback.areItemsTheSame(r15, r16) == false) goto L26;
        T[] r18 = this.mData;
        int r19 = this.mNewDataStart;
        r18[r19] = r16;
        this.mOldDataStart++;
        this.mNewDataStart = r19 + 1;
        if (this.mCallback.areContentsTheSame(r15, r16) == true) goto L6;
        Callback r20 = this.mCallback;
        r20.onChanged(this.mNewDataStart - 1, 1, r20.getChangePayload(r15, r16));
        goto L6
    L26:
        replaceAllRemove();
        replaceAllInsert(r16);
        goto L6
    L23:
        replaceAllInsert(r16);
        goto L6
    L21:
        replaceAllRemove();
        goto L6
    L14:
        int r21 = r14 - r13;
        this.mSize -= r21;
        this.mCallback.onRemoved(r12, r21);
    L15:
        this.mOldData = null;
        if (r5 == true) goto L46;
        endBatchedUpdates();
        return;
    L46:
        return;
    L12:
        int r22 = r11 - r12;
        System.arraycopy(r10, r12, this.mData, r12, r22);
        this.mNewDataStart += r22;
        this.mSize += r22;
        this.mCallback.onInserted(r12, r22);
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
        int r5 = 1;
        int r11 = 0;
        int r12 = 1;
    L7:
        if (r5 >= r10.length) goto L20;
        T r13 = r10[r5];
        if (this.mCallback.compare(r10[r11], r13) != 0) goto L16;
        int r14 = findSameItem(r13, r10, r11, r12);
        if (r14 == (-1)) goto L13;
        r10[r14] = r13;
    L19:
        r5 = r5 + 1;
        goto L7
    L13:
        if (r12 == r5) goto L15;
        r10[r12] = r13;
    L15:
        r12 = r12 + 1;
        goto L19
    L16:
        if (r12 == r5) goto L18;
        r10[r12] = r13;
    L18:
        r11 = r12;
        r12 = r12 + 1;
        goto L19
    L20:
        return r12;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
    }

    public int add(T r5) {
        throwIfInMutationOperation();
        return add(r5, true);
    }

    public void addAll(@NonNull T[] r5, boolean r10) {
        throwIfInMutationOperation();
        if (r5.length != 0) goto L5;
        return;
    L5:
        if (r10 == false) goto L7;
        addAllInternal(r5);
        return;
    L7:
        addAllInternal(copyArray(r5));
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback r5 = this.mCallback;
        if ((r5 instanceof BatchedCallback) == false) goto L6;
        return;
    L6:
        if (this.mBatchedCallback != null) goto L8;
        this.mBatchedCallback = new BatchedCallback(r5);
    L8:
        this.mCallback = this.mBatchedCallback;
    }

    public void clear() {
        throwIfInMutationOperation();
        int r5 = this.mSize;
        if (r5 != 0) goto L5;
        return;
    L5:
        Arrays.fill(this.mData, 0, r5, null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, r5);
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback r5 = this.mCallback;
        if ((r5 instanceof BatchedCallback) == false) goto L5;
        ((BatchedCallback) r5).dispatchLastEvent();
    L5:
        Callback r10 = this.mCallback;
        BatchedCallback r11 = this.mBatchedCallback;
        if (r10 != r11) goto L9;
        this.mCallback = r11.mWrappedCallback;
        return;
    }

    public T get(int r5) throws IndexOutOfBoundsException {
        if (r5 >= this.mSize) goto L13;
        if (r5 < 0) goto L13;
        T[] r10 = this.mOldData;
        if (r10 == null) goto L12;
        int r11 = this.mNewDataStart;
        if (r5 < r11) goto L12;
        return r10[(r5 - r11) + this.mOldDataStart];
    L12:
        return this.mData[r5];
    L13:
        StringBuilder r12 = j0.s(r5, "Asked to get item at ", " but size is ");
        r12.append(this.mSize);
        throw new IndexOutOfBoundsException(r12.toString());
    }

    public int indexOf(T r10) {
        if (this.mOldData == null) goto L13;
        int r5 = findIndexOf(r10, this.mData, 0, this.mNewDataStart, 4);
        if (r5 == (-1)) goto L7;
        return r5;
    L7:
        int r11 = findIndexOf(r10, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
        if (r11 != (-1)) goto L10;
        return -1;
    L10:
        return (r11 - this.mOldDataStart) + this.mNewDataStart;
    L13:
        return findIndexOf(r10, this.mData, 0, this.mSize, 4);
    }

    public void recalculatePositionOfItemAt(int r5) {
        throwIfInMutationOperation();
        T r10 = get(r5);
        removeItemAtIndex(r5, false);
        int r11 = add(r10, false);
        if (r5 == r11) goto L6;
        this.mCallback.onMoved(r5, r11);
        return;
    }

    public boolean remove(T r5) {
        throwIfInMutationOperation();
        return remove(r5, true);
    }

    public T removeItemAt(int r5) {
        throwIfInMutationOperation();
        T r10 = get(r5);
        removeItemAtIndex(r5, true);
        return r10;
    }

    public void replaceAll(@NonNull T[] r5, boolean r10) {
        throwIfInMutationOperation();
        if (r10 == false) goto L5;
        replaceAllInternal(r5);
        return;
    L5:
        replaceAllInternal(copyArray(r5));
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int r10, T r11) {
        throwIfInMutationOperation();
        T r5 = get(r10);
        if (r5 != r11) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r5 != r11) goto L11;
    L16:
        if (r12 == false) goto L18;
        Callback r13 = this.mCallback;
        r13.onChanged(r10, 1, r13.getChangePayload(r5, r11));
    L18:
        removeItemAtIndex(r10, false);
        int r14 = add(r11, false);
        if (r10 == r14) goto L23;
        this.mCallback.onMoved(r10, r14);
        return;
    L23:
        return;
    L11:
        if (this.mCallback.compare(r5, r11) != 0) goto L16;
        this.mData[r10] = r11;
        if (r12 == false) goto L22;
        Callback r15 = this.mCallback;
        r15.onChanged(r10, 1, r15.getChangePayload(r5, r11));
        return;
    L22:
        return;
    L5:
        if (this.mCallback.areContentsTheSame(r5, r11) == false) goto L8;
        r12 = false;
        goto L9
    }

    public SortedList(@NonNull Class<T> r5, @NonNull Callback<T> r10, int r11) {
        this.mTClass = r5;
        this.mData = (T[]) ((Object[]) Array.newInstance(r5, r11));
        this.mCallback = r10;
        this.mSize = 0;
    }

    private int add(T r10, boolean r11) {
        int r5 = findIndexOf(r10, this.mData, 0, this.mSize, 1);
        if (r5 != (-1)) goto L6;
        r5 = 0;
    L15:
        addToData(r5, r10);
        if (r11 == false) goto L18;
        this.mCallback.onInserted(r5, 1);
    L18:
        return r5;
    L6:
        if (r5 >= this.mSize) goto L15;
        T r12 = this.mData[r5];
        if (this.mCallback.areItemsTheSame(r12, r10) == false) goto L15;
        if (this.mCallback.areContentsTheSame(r12, r10) == false) goto L13;
        this.mData[r5] = r10;
        return r5;
    L13:
        this.mData[r5] = r10;
        Callback r13 = this.mCallback;
        r13.onChanged(r5, 1, r13.getChangePayload(r12, r10));
        return r5;
    }

    private boolean remove(T r10, boolean r11) {
        int r12 = findIndexOf(r10, this.mData, 0, this.mSize, 2);
        if (r12 != (-1)) goto L6;
        return false;
    L6:
        removeItemAtIndex(r12, r11);
        return true;
    }

    public void replaceAll(@NonNull T... r5) {
        replaceAll(r5, false);
    }

    public void addAll(@NonNull T... r5) {
        addAll(r5, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> r5) {
        replaceAll(r5.toArray((Object[]) Array.newInstance(this.mTClass, r5.size())), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> r5) {
        addAll(r5.toArray((Object[]) Array.newInstance(this.mTClass, r5.size())), true);
    }
}
