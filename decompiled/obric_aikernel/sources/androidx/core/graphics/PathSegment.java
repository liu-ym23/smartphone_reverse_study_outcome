package androidx.core.graphics;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class PathSegment {
    private final PointF mEnd;
    private final float mEndFraction;
    private final PointF mStart;
    private final float mStartFraction;

    public PathSegment(@NonNull PointF r10, float r11, @NonNull PointF r12, float r13) {
        this.mStart = (PointF) Preconditions.checkNotNull(r10, "start == null");
        this.mStartFraction = r11;
        this.mEnd = (PointF) Preconditions.checkNotNull(r12, "end == null");
        this.mEndFraction = r13;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PathSegment) == true) goto L8;
        return false;
    L8:
        PathSegment r11 = (PathSegment) r10;
        if (Float.compare(this.mStartFraction, r11.mStartFraction) != 0) goto L18;
        if (Float.compare(this.mEndFraction, r11.mEndFraction) != 0) goto L18;
        if (this.mStart.equals(r11.mStart) == false) goto L18;
        if (this.mEnd.equals(r11.mEnd) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @NonNull
    public PointF getEnd() {
        return this.mEnd;
    }

    public float getEndFraction() {
        return this.mEndFraction;
    }

    @NonNull
    public PointF getStart() {
        return this.mStart;
    }

    public float getStartFraction() {
        return this.mStartFraction;
    }

    public int hashCode() {
        int r10 = this.mStart.hashCode() * 31;
        float r11 = this.mStartFraction;
        int r12 = 0;
        if (r11 == 0.0f) goto L5;
        int r13 = Float.floatToIntBits(r11);
    L6:
        int r14 = (((r10 + r13) * 31) + this.mEnd.hashCode()) * 31;
        float r15 = this.mEndFraction;
        if (r15 == 0.0f) goto L10;
        r12 = Float.floatToIntBits(r15);
    L10:
        return r14 + r12;
    L5:
        r13 = 0;
        goto L6
    }

    public String toString() {
        return "PathSegment{start=" + this.mStart + ", startFraction=" + this.mStartFraction + ", end=" + this.mEnd + ", endFraction=" + this.mEndFraction + '}';
    }
}
