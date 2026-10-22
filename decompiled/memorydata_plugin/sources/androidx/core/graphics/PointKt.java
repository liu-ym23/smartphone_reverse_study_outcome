package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n\u001a\r\u0010\r\u001a\u00020\u0002*\u00020\u0004H\u0086\b\u001a\r\u0010\u000e\u001a\u00020\u0004*\u00020\u0002H\u0086\b\u001a\r\u0010\u000f\u001a\u00020\u0002*\u00020\u0002H\u0086\n\u001a\r\u0010\u000f\u001a\u00020\u0004*\u00020\u0004H\u0086\n¨\u0006\u0010"}, d2 = {"component1", "", "Landroid/graphics/Point;", "", "Landroid/graphics/PointF;", "component2", "div", "scalar", "minus", "p", "xy", "plus", "times", "toPoint", "toPointF", "unaryMinus", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PointKt {
    public static final float component1(PointF r0) {
        return r0.x;
    }

    public static final int component1(Point r0) {
        return r0.x;
    }

    public static final float component2(PointF r0) {
        return r0.y;
    }

    public static final int component2(Point r0) {
        return r0.y;
    }

    public static final Point div(Point r2, float r3) {
        return new Point(Math.round(r2.x / r3), Math.round(r2.y / r3));
    }

    public static final PointF div(PointF r2, float r3) {
        return new PointF(r2.x / r3, r2.y / r3);
    }

    public static final Point minus(Point r2, int r3) {
        Point r0 = new Point(r2.x, r2.y);
        int r4 = -r3;
        r0.offset(r4, r4);
        return r0;
    }

    public static final Point minus(Point r2, Point r3) {
        Point r0 = new Point(r2.x, r2.y);
        r0.offset(-r3.x, -r3.y);
        return r0;
    }

    public static final PointF minus(PointF r2, float r3) {
        PointF r0 = new PointF(r2.x, r2.y);
        float r4 = -r3;
        r0.offset(r4, r4);
        return r0;
    }

    public static final PointF minus(PointF r2, PointF r3) {
        PointF r0 = new PointF(r2.x, r2.y);
        r0.offset(-r3.x, -r3.y);
        return r0;
    }

    public static final Point plus(Point r2, int r3) {
        Point r0 = new Point(r2.x, r2.y);
        r0.offset(r3, r3);
        return r0;
    }

    public static final Point plus(Point r2, Point r3) {
        Point r0 = new Point(r2.x, r2.y);
        r0.offset(r3.x, r3.y);
        return r0;
    }

    public static final PointF plus(PointF r2, float r3) {
        PointF r0 = new PointF(r2.x, r2.y);
        r0.offset(r3, r3);
        return r0;
    }

    public static final PointF plus(PointF r2, PointF r3) {
        PointF r0 = new PointF(r2.x, r2.y);
        r0.offset(r3.x, r3.y);
        return r0;
    }

    public static final Point times(Point r2, float r3) {
        return new Point(Math.round(r2.x * r3), Math.round(r2.y * r3));
    }

    public static final PointF times(PointF r2, float r3) {
        return new PointF(r2.x * r3, r2.y * r3);
    }

    public static final Point toPoint(PointF r2) {
        return new Point((int) r2.x, (int) r2.y);
    }

    public static final PointF toPointF(Point r1) {
        return new PointF(r1);
    }

    public static final Point unaryMinus(Point r2) {
        return new Point(-r2.x, -r2.y);
    }

    public static final PointF unaryMinus(PointF r2) {
        return new PointF(-r2.x, -r2.y);
    }
}
