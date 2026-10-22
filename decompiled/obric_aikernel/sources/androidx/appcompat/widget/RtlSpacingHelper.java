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

    RtlSpacingHelper() {
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

    public void setAbsolute(int r10, int r11) {
        this.mIsRelative = false;
        if (r10 == Integer.MIN_VALUE) goto L5;
        this.mExplicitLeft = r10;
        this.mLeft = r10;
    L5:
        if (r11 == Integer.MIN_VALUE) goto L8;
        this.mExplicitRight = r11;
        this.mRight = r11;
        return;
    }

    public void setDirection(boolean r10) {
        if (r10 != this.mIsRtl) goto L5;
        return;
    L5:
        this.mIsRtl = r10;
        if (this.mIsRelative == true) goto L8;
        this.mLeft = this.mExplicitLeft;
    L24:
        int r11 = this.mExplicitRight;
    L25:
        this.mRight = r11;
        return;
    L8:
        if (r10 == false) goto L16;
        int r12 = this.mEnd;
        if (r12 != Integer.MIN_VALUE) goto L13;
        r12 = this.mExplicitLeft;
    L13:
        this.mLeft = r12;
        r11 = this.mStart;
        if (r11 == Integer.MIN_VALUE) goto L24;
    L16:
        int r13 = this.mStart;
        if (r13 != Integer.MIN_VALUE) goto L20;
        r13 = this.mExplicitLeft;
    L20:
        this.mLeft = r13;
        r11 = this.mEnd;
        if (r11 == Integer.MIN_VALUE) goto L24;
        goto L24
    }

    public void setRelative(int r10, int r11) {
        this.mStart = r10;
        this.mEnd = r11;
        this.mIsRelative = true;
        if (this.mIsRtl == false) goto L8;
        if (r11 == Integer.MIN_VALUE) goto L6;
        this.mLeft = r11;
    L6:
        if (r10 == Integer.MIN_VALUE) goto L13;
        this.mRight = r10;
        return;
    L13:
        return;
    L8:
        if (r10 == Integer.MIN_VALUE) goto L10;
        this.mLeft = r10;
    L10:
        if (r11 == Integer.MIN_VALUE) goto L15;
        this.mRight = r11;
        return;
    }
}
