package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
class ViewBoundsCheck {
    static final int CVE_PVE_POS = 12;
    static final int CVE_PVS_POS = 8;
    static final int CVS_PVE_POS = 4;
    static final int CVS_PVS_POS = 0;
    static final int EQ = 2;
    static final int FLAG_CVE_EQ_PVE = 8192;
    static final int FLAG_CVE_EQ_PVS = 512;
    static final int FLAG_CVE_GT_PVE = 4096;
    static final int FLAG_CVE_GT_PVS = 256;
    static final int FLAG_CVE_LT_PVE = 16384;
    static final int FLAG_CVE_LT_PVS = 1024;
    static final int FLAG_CVS_EQ_PVE = 32;
    static final int FLAG_CVS_EQ_PVS = 2;
    static final int FLAG_CVS_GT_PVE = 16;
    static final int FLAG_CVS_GT_PVS = 1;
    static final int FLAG_CVS_LT_PVE = 64;
    static final int FLAG_CVS_LT_PVS = 4;
    static final int GT = 1;
    static final int LT = 4;
    static final int MASK = 7;
    BoundFlags mBoundFlags;
    final Callback mCallback;

    static class BoundFlags {
        int mBoundFlags;
        int mChildEnd;
        int mChildStart;
        int mRvEnd;
        int mRvStart;

        BoundFlags() {
            this.mBoundFlags = 0;
        }

        void addFlags(int r10) {
            this.mBoundFlags = r10 | this.mBoundFlags;
        }

        boolean boundsMatch() {
            int r10 = this.mBoundFlags;
            if ((r10 & 7) != 0) goto L5;
        L7:
            int r11 = this.mBoundFlags;
            if ((r11 & 112) != 0) goto L10;
        L12:
            int r12 = this.mBoundFlags;
            if ((r12 & 1792) != 0) goto L15;
        L17:
            int r13 = this.mBoundFlags;
            if ((r13 & 28672) != 0) goto L20;
            return true;
        L20:
            if (((compare(this.mChildEnd, this.mRvEnd) << 12) & r13) != 0) goto L24;
            return false;
        L24:
            return true;
        L15:
            if ((r12 & (compare(this.mChildEnd, this.mRvStart) << 8)) != 0) goto L17;
            return false;
        L10:
            if ((r11 & (compare(this.mChildStart, this.mRvEnd) << 4)) != 0) goto L12;
            return false;
        L5:
            if ((r10 & (compare(this.mChildStart, this.mRvStart) << 0)) != 0) goto L7;
            return false;
        }

        int compare(int r10, int r11) {
            if (r10 <= r11) goto L5;
            return 1;
        L5:
            if (r10 != r11) goto L8;
            return 2;
        L8:
            return 4;
        }

        void resetFlags() {
            this.mBoundFlags = 0;
        }

        void setBounds(int r10, int r11, int r12, int r13) {
            this.mRvStart = r10;
            this.mRvEnd = r11;
            this.mChildStart = r12;
            this.mChildEnd = r13;
        }
    }

    interface Callback {
        View getChildAt(int r10);

        int getChildEnd(View r10);

        int getChildStart(View r10);

        int getParentEnd();

        int getParentStart();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    ViewBoundsCheck(Callback r10) {
        this.mCallback = r10;
        this.mBoundFlags = new BoundFlags();
    }

    View findOneViewWithinBoundFlags(int r10, int r11, int r12, int r13) {
        int r14 = this.mCallback.getParentStart();
        int r15 = this.mCallback.getParentEnd();
        if (r11 <= r10) goto L5;
        int r16 = 1;
    L6:
        View r17 = null;
    L7:
        if (r10 == r11) goto L18;
        View r18 = this.mCallback.getChildAt(r10);
        int r19 = this.mCallback.getChildStart(r18);
        int r20 = this.mCallback.getChildEnd(r18);
        this.mBoundFlags.setBounds(r14, r15, r19, r20);
        if (r12 == 0) goto L13;
        this.mBoundFlags.resetFlags();
        this.mBoundFlags.addFlags(r12);
        if (this.mBoundFlags.boundsMatch() == false) goto L13;
        return r18;
    L13:
        if (r13 == 0) goto L17;
        this.mBoundFlags.resetFlags();
        this.mBoundFlags.addFlags(r13);
        if (this.mBoundFlags.boundsMatch() == false) goto L17;
        r17 = r18;
    L17:
        r10 = r10 + r16;
        goto L7
    L18:
        return r17;
    L5:
        r16 = -1;
        goto L6
    }

    boolean isViewWithinBoundFlags(View r10, int r11) {
        this.mBoundFlags.setBounds(this.mCallback.getParentStart(), this.mCallback.getParentEnd(), this.mCallback.getChildStart(r10), this.mCallback.getChildEnd(r10));
        if (r11 == 0) goto L6;
        this.mBoundFlags.resetFlags();
        this.mBoundFlags.addFlags(r11);
        return this.mBoundFlags.boundsMatch();
    L6:
        return false;
    }
}
