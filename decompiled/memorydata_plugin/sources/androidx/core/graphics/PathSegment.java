package androidx.core.graphics;

import android.graphics.PointF;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class PathSegment {
    private final PointF mEnd;
    private final float mEndFraction;
    private final PointF mStart;
    private final float mStartFraction;

    public PathSegment(PointF r3, float r4, PointF r5, float r6) {
        this.mStart = (PointF) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r3, "start == null"), PointF.class, "com.obric.memorydata.plugin");
        this.mStartFraction = r4;
        this.mEnd = (PointF) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r5, "end == null"), PointF.class, "com.obric.memorydata.plugin");
        this.mEndFraction = r6;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PathSegment.class) == true) goto L8;
        return false;
    L8:
        PathSegment r6 = (PathSegment) ZeusTransformUtils.preCheckCast(r5, PathSegment.class, "com.obric.memorydata.plugin");
        if (Float.compare(this.mStartFraction, r6.mStartFraction) != 0) goto L18;
        if (Float.compare(this.mEndFraction, r6.mEndFraction) != 0) goto L18;
        if (this.mStart.equals(r6.mStart) == false) goto L18;
        if (this.mEnd.equals(r6.mEnd) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public PointF getEnd() {
        return this.mEnd;
    }

    public float getEndFraction() {
        return this.mEndFraction;
    }

    public PointF getStart() {
        return this.mStart;
    }

    public float getStartFraction() {
        return this.mStartFraction;
    }

    public int hashCode() {
        int r0 = this.mStart.hashCode() * 31;
        float r1 = this.mStartFraction;
        int r4 = 0;
        if (r1 == 0.0f) goto L5;
        int r2 = Float.floatToIntBits(r1);
    L6:
        int r3 = (((r0 + r2) * 31) + this.mEnd.hashCode()) * 31;
        float r5 = this.mEndFraction;
        if (r5 == 0.0f) goto L10;
        r4 = Float.floatToIntBits(r5);
    L10:
        return r3 + r4;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "PathSegment{start=" + this.mStart + ", startFraction=" + this.mStartFraction + ", end=" + this.mEnd + ", endFraction=" + this.mEndFraction + '}';
    }
}
