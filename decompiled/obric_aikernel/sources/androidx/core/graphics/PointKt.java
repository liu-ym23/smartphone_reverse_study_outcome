package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class PointKt {
    public static final float component1(PointF r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.x;
    }

    public static final int component1(Point r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.x;
    }

    public static final float component2(PointF r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.y;
    }

    public static final int component2(Point r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.y;
    }

    public static final Point div(Point r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new Point(Math.round(r10.x / r11), Math.round(r10.y / r11));
    }

    public static final PointF div(PointF r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new PointF(r10.x / r11, r10.y / r11);
    }

    public static final Point minus(Point r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Point r12 = new Point(r10.x, r10.y);
        int r13 = -r11;
        r12.offset(r13, r13);
        return r12;
    }

    public static final Point minus(Point r10, Point r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "p");
        Point r12 = new Point(r10.x, r10.y);
        r12.offset(-r11.x, -r11.y);
        return r12;
    }

    public static final PointF minus(PointF r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        PointF r12 = new PointF(r10.x, r10.y);
        float r13 = -r11;
        r12.offset(r13, r13);
        return r12;
    }

    public static final PointF minus(PointF r10, PointF r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "p");
        PointF r12 = new PointF(r10.x, r10.y);
        r12.offset(-r11.x, -r11.y);
        return r12;
    }

    public static final Point plus(Point r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Point r12 = new Point(r10.x, r10.y);
        r12.offset(r11, r11);
        return r12;
    }

    public static final Point plus(Point r10, Point r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "p");
        Point r12 = new Point(r10.x, r10.y);
        r12.offset(r11.x, r11.y);
        return r12;
    }

    public static final PointF plus(PointF r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        PointF r12 = new PointF(r10.x, r10.y);
        r12.offset(r11, r11);
        return r12;
    }

    public static final PointF plus(PointF r10, PointF r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "p");
        PointF r12 = new PointF(r10.x, r10.y);
        r12.offset(r11.x, r11.y);
        return r12;
    }

    public static final Point times(Point r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new Point(Math.round(r10.x * r11), Math.round(r10.y * r11));
    }

    public static final PointF times(PointF r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new PointF(r10.x * r11, r10.y * r11);
    }

    public static final Point toPoint(PointF r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new Point((int) r10.x, (int) r10.y);
    }

    public static final PointF toPointF(Point r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new PointF(r10);
    }

    public static final Point unaryMinus(Point r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new Point(-r10.x, -r10.y);
    }

    public static final PointF unaryMinus(PointF r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new PointF(-r10.x, -r10.y);
    }
}
