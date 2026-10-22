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

    public static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData;
        Bucket mNext;

        public Bucket() {
            this.mData = 0;
        }

        private void ensureNext() {
            if (this.mNext != null) goto L6;
            this.mNext = new Bucket();
            return;
        }

        public void clear(int r5) {
            if (r5 < 64) goto L7;
            Bucket r10 = this.mNext;
            if (r10 == null) goto L9;
            r10.clear(r5 - 64);
            return;
        L9:
            return;
        L7:
            this.mData &= ~(1 << r5);
        }

        public int countOnesBefore(int r5) {
            Bucket r10 = this.mNext;
            if (r10 != null) goto L9;
            if (r5 >= 64) goto L6;
            long r11 = this.mData;
            return Long.bitCount(((1 << r5) - 1) & r11);
        L6:
            return Long.bitCount(this.mData);
        L9:
            if (r5 >= 64) goto L12;
            long r12 = this.mData;
            return Long.bitCount(((1 << r5) - 1) & r12);
        L12:
            int r13 = r10.countOnesBefore(r5 - 64);
            return Long.bitCount(this.mData) + r13;
        }

        public boolean get(int r5) {
            if (r5 < 64) goto L6;
            ensureNext();
            return this.mNext.get(r5 - 64);
        L6:
            long r10 = this.mData;
            if (((1 << r5) & r10) == 0) goto L9;
            return true;
        L9:
            return false;
        }

        public void insert(int r10, boolean r11) {
            if (r10 < 64) goto L5;
            ensureNext();
            this.mNext.insert(r10 - 64, r11);
            return;
        L5:
            long r5 = this.mData;
            if ((Long.MIN_VALUE & r5) == 0) goto L8;
            boolean r12 = true;
        L9:
            long r13 = (1 << r10) - 1;
            this.mData = ((r5 & (~r13)) << 1) | (r5 & r13);
            if (r11 == false) goto L12;
            set(r10);
        L13:
            if (r12 == false) goto L15;
        L16:
            ensureNext();
            this.mNext.insert(0, r12);
            return;
        L15:
            if (this.mNext != null) goto L16;
            return;
        L12:
            clear(r10);
            goto L13
        L8:
            r12 = false;
            goto L9
        }

        public boolean remove(int r11) {
            if (r11 < 64) goto L6;
            ensureNext();
            return this.mNext.remove(r11 - 64);
        L6:
            long r5 = 1 << r11;
            long r10 = this.mData;
            if ((r10 & r5) == 0) goto L9;
            boolean r12 = true;
        L10:
            long r13 = r10 & (~r5);
            this.mData = r13;
            long r14 = r5 - 1;
            this.mData = (r13 & r14) | Long.rotateRight((~r14) & r13, 1);
            Bucket r15 = this.mNext;
            if (r15 != null) goto L13;
        L16:
            return r12;
        L13:
            if (r15.get(0) == false) goto L15;
            set(63);
        L15:
            this.mNext.remove(0);
            goto L16
        L9:
            r12 = false;
            goto L10
        }

        public void reset() {
            this.mData = 0;
            Bucket r5 = this.mNext;
            if (r5 == null) goto L6;
            r5.reset();
            return;
        }

        public void set(int r5) {
            if (r5 < 64) goto L5;
            ensureNext();
            this.mNext.set(r5 - 64);
            return;
        L5:
            this.mData |= 1 << r5;
        }

        public String toString() {
            if (this.mNext != null) goto L6;
            return Long.toBinaryString(this.mData);
        L6:
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    public interface Callback {
        void addView(View r5, int r10);

        void attachViewToParent(View r5, int r10, ViewGroup.LayoutParams r11);

        void detachViewFromParent(int r5);

        View getChildAt(int r5);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View r5);

        int indexOfChild(View r5);

        void onEnteredHiddenState(View r5);

        void onLeftHiddenState(View r5);

        void removeAllViews();

        void removeViewAt(int r5);
    }

    public ChildHelper(Callback r5) {
        this.mCallback = r5;
        this.mBucket = new Bucket();
        this.mHiddenViews = new ArrayList();
    }

    private int getOffset(int r5) {
        if (r5 >= 0) goto L5;
        return -1;
    L5:
        int r10 = this.mCallback.getChildCount();
        int r11 = r5;
    L6:
        if (r11 >= r10) goto L14;
        int r12 = r5 - (r11 - this.mBucket.countOnesBefore(r11));
        if (r12 == 0) goto L10;
        r11 = r11 + r12;
    L10:
        if (this.mBucket.get(r11) == false) goto L12;
        r11 = r11 + 1;
        goto L10
    L12:
        return r11;
    L14:
        return -1;
    }

    private void hideViewInternal(View r5) {
        this.mHiddenViews.add(r5);
        this.mCallback.onEnteredHiddenState(r5);
    }

    private boolean unhideViewInternal(View r5) {
        if (this.mHiddenViews.remove(r5) == false) goto L6;
        this.mCallback.onLeftHiddenState(r5);
        return true;
    L6:
        return false;
    }

    public void addView(View r5, boolean r10) {
        addView(r5, -1, r10);
    }

    public void attachViewToParent(View r5, int r10, ViewGroup.LayoutParams r11, boolean r12) {
        if (r10 >= 0) goto L4;
        int r13 = this.mCallback.getChildCount();
    L5:
        this.mBucket.insert(r13, r12);
        if (r12 == false) goto L8;
        hideViewInternal(r5);
    L8:
        this.mCallback.attachViewToParent(r5, r13, r11);
        return;
    L4:
        r13 = getOffset(r10);
        goto L5
    }

    public void detachViewFromParent(int r5) {
        int r10 = getOffset(r5);
        this.mBucket.remove(r10);
        this.mCallback.detachViewFromParent(r10);
    }

    public View findHiddenNonRemovedView(int r10) {
        int r5 = this.mHiddenViews.size();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L12;
        View r12 = this.mHiddenViews.get(r11);
        RecyclerView.ViewHolder r13 = this.mCallback.getChildViewHolder(r12);
        if (r13.getLayoutPosition() != r10) goto L11;
        if (r13.isInvalid() == true) goto L11;
        if (r13.isRemoved() == true) goto L11;
        return r12;
    L11:
        r11 = r11 + 1;
        goto L3
    L12:
        return null;
    }

    public View getChildAt(int r5) {
        int r10 = getOffset(r5);
        return this.mCallback.getChildAt(r10);
    }

    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    public View getUnfilteredChildAt(int r5) {
        return this.mCallback.getChildAt(r5);
    }

    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    public void hide(View r5) {
        int r10 = this.mCallback.indexOfChild(r5);
        if (r10 < 0) goto L7;
        this.mBucket.set(r10);
        hideViewInternal(r5);
        return;
    L7:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r5);
    }

    public int indexOfChild(View r5) {
        int r10 = this.mCallback.indexOfChild(r5);
        if (r10 != (-1)) goto L6;
        return -1;
    L6:
        if (this.mBucket.get(r10) == false) goto L9;
        return -1;
    L9:
        return r10 - this.mBucket.countOnesBefore(r10);
    }

    public boolean isHidden(View r5) {
        return this.mHiddenViews.contains(r5);
    }

    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        int r5 = this.mHiddenViews.size() - 1;
    L3:
        if (r5 < 0) goto L5;
        this.mCallback.onLeftHiddenState(this.mHiddenViews.get(r5));
        this.mHiddenViews.remove(r5);
        r5 = r5 - 1;
        goto L3
    L5:
        this.mCallback.removeAllViews();
    }

    public void removeView(View r5) {
        int r10 = this.mCallback.indexOfChild(r5);
        if (r10 >= 0) goto L6;
        return;
    L6:
        if (this.mBucket.remove(r10) == false) goto L8;
        unhideViewInternal(r5);
    L8:
        this.mCallback.removeViewAt(r10);
    }

    public void removeViewAt(int r5) {
        int r10 = getOffset(r5);
        View r11 = this.mCallback.getChildAt(r10);
        if (r11 != null) goto L6;
        return;
    L6:
        if (this.mBucket.remove(r10) == false) goto L8;
        unhideViewInternal(r11);
    L8:
        this.mCallback.removeViewAt(r10);
    }

    public boolean removeViewIfHidden(View r5) {
        int r10 = this.mCallback.indexOfChild(r5);
        if (r10 != (-1)) goto L7;
        unhideViewInternal(r5);
        return true;
    L7:
        if (this.mBucket.get(r10) == false) goto L10;
        this.mBucket.remove(r10);
        unhideViewInternal(r5);
        this.mCallback.removeViewAt(r10);
        return true;
    L10:
        return false;
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    public void unhide(View r5) {
        int r10 = this.mCallback.indexOfChild(r5);
        if (r10 < 0) goto L11;
        if (this.mBucket.get(r10) == false) goto L9;
        this.mBucket.clear(r10);
        unhideViewInternal(r5);
        return;
    L9:
        throw new RuntimeException("trying to unhide a view that was not hidden" + r5);
    L11:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r5);
    }

    public void addView(View r5, int r10, boolean r11) {
        if (r10 >= 0) goto L4;
        int r12 = this.mCallback.getChildCount();
    L5:
        this.mBucket.insert(r12, r11);
        if (r11 == false) goto L8;
        hideViewInternal(r5);
    L8:
        this.mCallback.addView(r5, r12);
        return;
    L4:
        r12 = getOffset(r10);
        goto L5
    }
}
