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

    public PathSegment(@NonNull PointF r5, float r10, @NonNull PointF r11, float r12) {
        this.mStart = (PointF) Preconditions.checkNotNull(r5, "start == null");
        this.mStartFraction = r10;
        this.mEnd = (PointF) Preconditions.checkNotNull(r11, "end == null");
        this.mEndFraction = r12;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PathSegment) == true) goto L8;
        return false;
    L8:
        PathSegment r10 = (PathSegment) r5;
        if (Float.compare(this.mStartFraction, r10.mStartFraction) != 0) goto L18;
        if (Float.compare(this.mEndFraction, r10.mEndFraction) != 0) goto L18;
        if (this.mStart.equals(r10.mStart) == false) goto L18;
        if (this.mEnd.equals(r10.mEnd) == false) goto L18;
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
        int r5 = this.mStart.hashCode() * 31;
        float r10 = this.mStartFraction;
        int r11 = 0;
        if (r10 == 0.0f) goto L5;
        int r12 = Float.floatToIntBits(r10);
    L6:
        int r13 = (this.mEnd.hashCode() + ((r5 + r12) * 31)) * 31;
        float r14 = this.mEndFraction;
        if (r14 == 0.0f) goto L10;
        r11 = Float.floatToIntBits(r14);
    L10:
        return r13 + r11;
    L5:
        r12 = 0;
        goto L6
    }

    public String toString() {
        return "PathSegment{start=" + this.mStart + ", startFraction=" + this.mStartFraction + ", end=" + this.mEnd + ", endFraction=" + this.mEndFraction + '}';
    }
}
