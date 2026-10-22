package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        void clear(int r5) {
            if (r5 < 64) goto L7;
            Bucket r4 = this.mNext;
            if (r4 == null) goto L9;
            r4.clear(r5 - 64);
            return;
        L9:
            return;
        L7:
            this.mData &= ~(1 << r5);
        }

        int countOnesBefore(int r5) {
            Bucket r0 = this.mNext;
            if (r0 != null) goto L9;
            if (r5 < 64) goto L8;
            long r4 = this.mData;
        L7:
            return Long.bitCount(r4);
        L8:
            long r1 = this.mData;
            r4 = ((1 << r5) - 1) & r1;
            goto L7
        L9:
            if (r5 < 64) goto L8;
            return r0.countOnesBefore(r5 - 64) + Long.bitCount(this.mData);
        }

        boolean get(int r5) {
            if (r5 < 64) goto L6;
            ensureNext();
            return this.mNext.get(r5 - 64);
        L6:
            long r0 = this.mData;
            if (((1 << r5) & r0) == 0) goto L9;
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
            long r0 = this.mData;
            if ((Long.MIN_VALUE & r0) == 0) goto L8;
            boolean r2 = true;
        L9:
            long r7 = (1 << r10) - 1;
            this.mData = ((r0 & (~r7)) << 1) | (r0 & r7);
            if (r11 == false) goto L12;
            set(r10);
        L13:
            if (r2 == false) goto L15;
        L16:
            ensureNext();
            this.mNext.insert(0, r2);
            return;
        L15:
            if (this.mNext != null) goto L16;
            return;
        L12:
            clear(r10);
            goto L13
        L8:
            r2 = false;
            goto L9
        }

        boolean remove(int r11) {
            if (r11 < 64) goto L6;
            ensureNext();
            return this.mNext.remove(r11 - 64);
        L6:
            long r2 = 1 << r11;
            long r4 = this.mData;
            if ((r4 & r2) == 0) goto L9;
            boolean r12 = true;
        L10:
            long r5 = r4 & (~r2);
            this.mData = r5;
            long r3 = r2 - 1;
            this.mData = (r5 & r3) | Long.rotateRight((~r3) & r5, 1);
            Bucket r0 = this.mNext;
            if (r0 != null) goto L13;
        L16:
            return r12;
        L13:
            if (r0.get(0) == false) goto L15;
            set(63);
        L15:
            this.mNext.remove(0);
            goto L16
        L9:
            r12 = false;
            goto L10
        }

        void reset() {
            this.mData = 0;
            Bucket r2 = this.mNext;
            if (r2 == null) goto L6;
            r2.reset();
            return;
        }

        void set(int r5) {
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

    interface Callback {
        void addView(View r1, int r2);

        void attachViewToParent(View r1, int r2, ViewGroup.LayoutParams r3);

        void detachViewFromParent(int r1);

        View getChildAt(int r1);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View r1);

        int indexOfChild(View r1);

        void onEnteredHiddenState(View r1);

        void onLeftHiddenState(View r1);

        void removeAllViews();

        void removeViewAt(int r1);
    }

    ChildHelper(Callback r3) {
        this.mCallback = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
        this.mBucket = new Bucket();
        this.mHiddenViews = new ArrayList();
    }

    private int getOffset(int r5) {
        if (r5 >= 0) goto L5;
        return -1;
    L5:
        int r1 = this.mCallback.getChildCount();
        int r2 = r5;
    L6:
        if (r2 >= r1) goto L14;
        int r3 = r5 - (r2 - this.mBucket.countOnesBefore(r2));
        if (r3 == 0) goto L10;
        r2 = r2 + r3;
    L10:
        if (this.mBucket.get(r2) == false) goto L12;
        r2 = r2 + 1;
        goto L10
    L12:
        return r2;
    L14:
        return -1;
    }

    private void hideViewInternal(View r2) {
        this.mHiddenViews.add(r2);
        this.mCallback.onEnteredHiddenState(r2);
    }

    private boolean unhideViewInternal(View r2) {
        if (this.mHiddenViews.remove(r2) == false) goto L6;
        this.mCallback.onLeftHiddenState(r2);
        return true;
    L6:
        return false;
    }

    void addView(View r2, int r3, boolean r4) {
        if (r3 >= 0) goto L4;
        int r5 = this.mCallback.getChildCount();
    L5:
        this.mBucket.insert(r5, r4);
        if (r4 == false) goto L8;
        hideViewInternal(r2);
    L8:
        this.mCallback.addView(r2, r5);
        return;
    L4:
        r5 = getOffset(r3);
        goto L5
    }

    void addView(View r2, boolean r3) {
        addView(r2, -1, r3);
    }

    void attachViewToParent(View r2, int r3, ViewGroup.LayoutParams r4, boolean r5) {
        if (r3 >= 0) goto L4;
        int r6 = this.mCallback.getChildCount();
    L5:
        this.mBucket.insert(r6, r5);
        if (r5 == false) goto L8;
        hideViewInternal(r2);
    L8:
        this.mCallback.attachViewToParent(r2, r6, r4);
        return;
    L4:
        r6 = getOffset(r3);
        goto L5
    }

    void detachViewFromParent(int r2) {
        int r3 = getOffset(r2);
        this.mBucket.remove(r3);
        this.mCallback.detachViewFromParent(r3);
    }

    View findHiddenNonRemovedView(int r6) {
        int r0 = this.mHiddenViews.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.mHiddenViews.get(r1), View.class, "com.obric.memorydata.plugin");
        RecyclerView.ViewHolder r3 = this.mCallback.getChildViewHolder(r2);
        if (r3.getLayoutPosition() != r6) goto L11;
        if (r3.isInvalid() == true) goto L11;
        if (r3.isRemoved() == true) goto L11;
        return r2;
    L11:
        r1 = r1 + 1;
        goto L3
    L12:
        return null;
    }

    View getChildAt(int r1) {
        int r2 = getOffset(r1);
        return this.mCallback.getChildAt(r2);
    }

    int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    View getUnfilteredChildAt(int r1) {
        return this.mCallback.getChildAt(r1);
    }

    int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    void hide(View r3) {
        int r0 = this.mCallback.indexOfChild(r3);
        if (r0 < 0) goto L7;
        this.mBucket.set(r0);
        hideViewInternal(r3);
        return;
    L7:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r3);
    }

    int indexOfChild(View r3) {
        int r4 = this.mCallback.indexOfChild(r3);
        if (r4 != (-1)) goto L6;
        return -1;
    L6:
        if (this.mBucket.get(r4) == false) goto L9;
        return -1;
    L9:
        return r4 - this.mBucket.countOnesBefore(r4);
    }

    boolean isHidden(View r1) {
        return this.mHiddenViews.contains(r1);
    }

    void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        int r0 = this.mHiddenViews.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.mCallback.onLeftHiddenState((View) ZeusTransformUtils.preCheckCast(this.mHiddenViews.get(r0), View.class, "com.obric.memorydata.plugin"));
        this.mHiddenViews.remove(r0);
        r0 = r0 - 1;
        goto L3
    L5:
        this.mCallback.removeAllViews();
    }

    void removeView(View r3) {
        int r0 = this.mCallback.indexOfChild(r3);
        if (r0 >= 0) goto L6;
        return;
    L6:
        if (this.mBucket.remove(r0) == false) goto L8;
        unhideViewInternal(r3);
    L8:
        this.mCallback.removeViewAt(r0);
    }

    void removeViewAt(int r3) {
        int r4 = getOffset(r3);
        View r0 = this.mCallback.getChildAt(r4);
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.mBucket.remove(r4) == false) goto L8;
        unhideViewInternal(r0);
    L8:
        this.mCallback.removeViewAt(r4);
    }

    boolean removeViewIfHidden(View r4) {
        int r0 = this.mCallback.indexOfChild(r4);
        if (r0 != (-1)) goto L7;
        unhideViewInternal(r4);
        return true;
    L7:
        if (this.mBucket.get(r0) == false) goto L10;
        this.mBucket.remove(r0);
        unhideViewInternal(r4);
        this.mCallback.removeViewAt(r0);
        return true;
    L10:
        return false;
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    void unhide(View r3) {
        int r0 = this.mCallback.indexOfChild(r3);
        if (r0 < 0) goto L11;
        if (this.mBucket.get(r0) == false) goto L9;
        this.mBucket.clear(r0);
        unhideViewInternal(r3);
        return;
    L9:
        throw new RuntimeException("trying to unhide a view that was not hidden" + r3);
    L11:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r3);
    }
}
