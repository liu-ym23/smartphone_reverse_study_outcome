package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Bucket mBucket;
    final Callback mCallback;
    final List<View> mHiddenViews;

    static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData;
        Bucket mNext;

        Bucket() {
            this.mData = 0;
        }

        private void ensureNext() {
            if (this.mNext != null) goto L6;
            this.mNext = new Bucket();
            return;
        }

        void clear(int r10) {
            if (r10 < 64) goto L7;
            Bucket r11 = this.mNext;
            if (r11 == null) goto L9;
            r11.clear(r10 - 64);
            return;
        L9:
            return;
        L7:
            this.mData &= ~(1 << r10);
        }

        int countOnesBefore(int r10) {
            Bucket r11 = this.mNext;
            if (r11 != null) goto L9;
            if (r10 < 64) goto L8;
            long r12 = this.mData;
        L7:
            return Long.bitCount(r12);
        L8:
            long r13 = this.mData;
            r12 = ((1 << r10) - 1) & r13;
            goto L7
        L9:
            if (r10 < 64) goto L8;
            return r11.countOnesBefore(r10 - 64) + Long.bitCount(this.mData);
        }

        boolean get(int r10) {
            if (r10 < 64) goto L6;
            ensureNext();
            return this.mNext.get(r10 - 64);
        L6:
            long r11 = this.mData;
            if (((1 << r10) & r11) == 0) goto L9;
            return true;
        L9:
            return false;
        }

        void insert(int r10, boolean r11) {
            if (r10 < 64) goto L5;
            ensureNext();
            this.mNext.insert(r10 - 64, r11);
            return;
        L5:
            long r12 = this.mData;
            if ((Long.MIN_VALUE & r12) == 0) goto L8;
            boolean r13 = true;
        L9:
            long r14 = (1 << r10) - 1;
            this.mData = ((r12 & (~r14)) << 1) | (r12 & r14);
            if (r11 == false) goto L12;
            set(r10);
        L13:
            if (r13 == false) goto L15;
        L16:
            ensureNext();
            this.mNext.insert(0, r13);
            return;
        L15:
            if (this.mNext != null) goto L16;
            return;
        L12:
            clear(r10);
            goto L13
        L8:
            r13 = false;
            goto L9
        }

        boolean remove(int r11) {
            if (r11 < 64) goto L6;
            ensureNext();
            return this.mNext.remove(r11 - 64);
        L6:
            long r10 = 1 << r11;
            long r12 = this.mData;
            if ((r12 & r10) == 0) goto L9;
            boolean r13 = true;
        L10:
            long r14 = r12 & (~r10);
            this.mData = r14;
            long r15 = r10 - 1;
            this.mData = (r14 & r15) | Long.rotateRight((~r15) & r14, 1);
            Bucket r16 = this.mNext;
            if (r16 != null) goto L13;
        L16:
            return r13;
        L13:
            if (r16.get(0) == false) goto L15;
            set(63);
        L15:
            this.mNext.remove(0);
            goto L16
        L9:
            r13 = false;
            goto L10
        }

        void reset() {
            this.mData = 0;
            Bucket r10 = this.mNext;
            if (r10 == null) goto L6;
            r10.reset();
            return;
        }

        void set(int r10) {
            if (r10 < 64) goto L5;
            ensureNext();
            this.mNext.set(r10 - 64);
            return;
        L5:
            this.mData |= 1 << r10;
        }

        public String toString() {
            if (this.mNext != null) goto L6;
            return Long.toBinaryString(this.mData);
        L6:
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    interface Callback {
        void addView(View r10, int r11);

        void attachViewToParent(View r10, int r11, ViewGroup.LayoutParams r12);

        void detachViewFromParent(int r10);

        View getChildAt(int r10);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View r10);

        int indexOfChild(View r10);

        void onEnteredHiddenState(View r10);

        void onLeftHiddenState(View r10);

        void removeAllViews();

        void removeViewAt(int r10);
    }

    ChildHelper(Callback r10) {
        this.mCallback = r10;
        this.mBucket = new Bucket();
        this.mHiddenViews = new ArrayList();
    }

    private int getOffset(int r10) {
        if (r10 >= 0) goto L5;
        return -1;
    L5:
        int r11 = this.mCallback.getChildCount();
        int r12 = r10;
    L6:
        if (r12 >= r11) goto L14;
        int r13 = r10 - (r12 - this.mBucket.countOnesBefore(r12));
        if (r13 == 0) goto L10;
        r12 = r12 + r13;
    L10:
        if (this.mBucket.get(r12) == false) goto L12;
        r12 = r12 + 1;
        goto L10
    L12:
        return r12;
    L14:
        return -1;
    }

    private void hideViewInternal(View r10) {
        this.mHiddenViews.add(r10);
        this.mCallback.onEnteredHiddenState(r10);
    }

    private boolean unhideViewInternal(View r10) {
        if (this.mHiddenViews.remove(r10) == false) goto L6;
        this.mCallback.onLeftHiddenState(r10);
        return true;
    L6:
        return false;
    }

    void addView(View r10, int r11, boolean r12) {
        if (r11 >= 0) goto L4;
        int r13 = this.mCallback.getChildCount();
    L5:
        this.mBucket.insert(r13, r12);
        if (r12 == false) goto L8;
        hideViewInternal(r10);
    L8:
        this.mCallback.addView(r10, r13);
        return;
    L4:
        r13 = getOffset(r11);
        goto L5
    }

    void addView(View r10, boolean r11) {
        addView(r10, -1, r11);
    }

    void attachViewToParent(View r10, int r11, ViewGroup.LayoutParams r12, boolean r13) {
        if (r11 >= 0) goto L4;
        int r14 = this.mCallback.getChildCount();
    L5:
        this.mBucket.insert(r14, r13);
        if (r13 == false) goto L8;
        hideViewInternal(r10);
    L8:
        this.mCallback.attachViewToParent(r10, r14, r12);
        return;
    L4:
        r14 = getOffset(r11);
        goto L5
    }

    void detachViewFromParent(int r10) {
        int r11 = getOffset(r10);
        this.mBucket.remove(r11);
        this.mCallback.detachViewFromParent(r11);
    }

    View findHiddenNonRemovedView(int r10) {
        int r11 = this.mHiddenViews.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L12;
        View r13 = this.mHiddenViews.get(r12);
        RecyclerView.ViewHolder r14 = this.mCallback.getChildViewHolder(r13);
        if (r14.getLayoutPosition() != r10) goto L11;
        if (r14.isInvalid() == true) goto L11;
        if (r14.isRemoved() == true) goto L11;
        return r13;
    L11:
        r12 = r12 + 1;
        goto L3
    L12:
        return null;
    }

    View getChildAt(int r10) {
        int r11 = getOffset(r10);
        return this.mCallback.getChildAt(r11);
    }

    int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    View getUnfilteredChildAt(int r10) {
        return this.mCallback.getChildAt(r10);
    }

    int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    void hide(View r10) {
        int r11 = this.mCallback.indexOfChild(r10);
        if (r11 < 0) goto L7;
        this.mBucket.set(r11);
        hideViewInternal(r10);
        return;
    L7:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r10);
    }

    int indexOfChild(View r10) {
        int r11 = this.mCallback.indexOfChild(r10);
        if (r11 != (-1)) goto L6;
        return -1;
    L6:
        if (this.mBucket.get(r11) == false) goto L9;
        return -1;
    L9:
        return r11 - this.mBucket.countOnesBefore(r11);
    }

    boolean isHidden(View r10) {
        return this.mHiddenViews.contains(r10);
    }

    void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        int r10 = this.mHiddenViews.size() - 1;
    L3:
        if (r10 < 0) goto L5;
        this.mCallback.onLeftHiddenState(this.mHiddenViews.get(r10));
        this.mHiddenViews.remove(r10);
        r10 = r10 - 1;
        goto L3
    L5:
        this.mCallback.removeAllViews();
    }

    void removeView(View r10) {
        int r11 = this.mCallback.indexOfChild(r10);
        if (r11 >= 0) goto L6;
        return;
    L6:
        if (this.mBucket.remove(r11) == false) goto L8;
        unhideViewInternal(r10);
    L8:
        this.mCallback.removeViewAt(r11);
    }

    void removeViewAt(int r10) {
        int r11 = getOffset(r10);
        View r12 = this.mCallback.getChildAt(r11);
        if (r12 != null) goto L6;
        return;
    L6:
        if (this.mBucket.remove(r11) == false) goto L8;
        unhideViewInternal(r12);
    L8:
        this.mCallback.removeViewAt(r11);
    }

    boolean removeViewIfHidden(View r10) {
        int r11 = this.mCallback.indexOfChild(r10);
        if (r11 != (-1)) goto L7;
        unhideViewInternal(r10);
        return true;
    L7:
        if (this.mBucket.get(r11) == false) goto L10;
        this.mBucket.remove(r11);
        unhideViewInternal(r10);
        this.mCallback.removeViewAt(r11);
        return true;
    L10:
        return false;
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    void unhide(View r10) {
        int r11 = this.mCallback.indexOfChild(r10);
        if (r11 < 0) goto L11;
        if (this.mBucket.get(r11) == false) goto L9;
        this.mBucket.clear(r11);
        unhideViewInternal(r10);
        return;
    L9:
        throw new RuntimeException("trying to unhide a view that was not hidden" + r10);
    L11:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r10);
    }
}
