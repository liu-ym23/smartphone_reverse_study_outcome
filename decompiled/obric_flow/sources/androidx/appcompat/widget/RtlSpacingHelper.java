package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mEnd;
    private int mExplicitLeft;
    private int mExplicitRight;
    private boolean mIsRelative;
    private boolean mIsRtl;
    private int mLeft;
    private int mRight;
    private int mStart;

    public RtlSpacingHelper() {
        this.mLeft = 0;
        this.mRight = 0;
        this.mStart = Integer.MIN_VALUE;
        this.mEnd = Integer.MIN_VALUE;
        this.mExplicitLeft = 0;
        this.mExplicitRight = 0;
        this.mIsRtl = false;
        this.mIsRelative = false;
    }

    public int getEnd() {
        if (this.mIsRtl == false) goto L6;
        return this.mLeft;
    L6:
        return this.mRight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        if (this.mIsRtl == false) goto L6;
        return this.mRight;
    L6:
        return this.mLeft;
    }

    public void setAbsolute(int r5, int r10) {
        this.mIsRelative = false;
        if (r5 == Integer.MIN_VALUE) goto L5;
        this.mExplicitLeft = r5;
        this.mLeft = r5;
    L5:
        if (r10 == Integer.MIN_VALUE) goto L8;
        this.mExplicitRight = r10;
        this.mRight = r10;
        return;
    }

    public void setDirection(boolean r5) {
        if (r5 != this.mIsRtl) goto L5;
        return;
    L5:
        this.mIsRtl = r5;
        if (this.mIsRelative == true) goto L8;
        this.mLeft = this.mExplicitLeft;
        this.mRight = this.mExplicitRight;
        return;
    L8:
        if (r5 == false) goto L18;
        int r10 = this.mEnd;
        if (r10 != Integer.MIN_VALUE) goto L13;
        r10 = this.mExplicitLeft;
    L13:
        this.mLeft = r10;
        int r11 = this.mStart;
        if (r11 != Integer.MIN_VALUE) goto L17;
        r11 = this.mExplicitRight;
    L17:
        this.mRight = r11;
        return;
    L18:
        int r12 = this.mStart;
        if (r12 != Integer.MIN_VALUE) goto L22;
        r12 = this.mExplicitLeft;
    L22:
        this.mLeft = r12;
        int r13 = this.mEnd;
        if (r13 != Integer.MIN_VALUE) goto L26;
        r13 = this.mExplicitRight;
    L26:
        this.mRight = r13;
    }

    public void setRelative(int r5, int r10) {
        this.mStart = r5;
        this.mEnd = r10;
        this.mIsRelative = true;
        if (this.mIsRtl == false) goto L8;
        if (r10 == Integer.MIN_VALUE) goto L6;
        this.mLeft = r10;
    L6:
        if (r5 == Integer.MIN_VALUE) goto L13;
        this.mRight = r5;
        return;
    L13:
        return;
    L8:
        if (r5 == Integer.MIN_VALUE) goto L10;
        this.mLeft = r5;
    L10:
        if (r10 == Integer.MIN_VALUE) goto L15;
        this.mRight = r10;
        return;
    }
}
