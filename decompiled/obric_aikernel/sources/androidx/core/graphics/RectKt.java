package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nRect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Rect.kt\nandroidx/core/graphics/RectKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,365:1\n344#1,3:366\n344#1,3:369\n257#1,6:372\n122#1,3:378\n132#1,3:381\n344#1,3:384\n344#1,3:387\n344#1,3:390\n1#2:393\n*S KotlinDebug\n*F\n+ 1 Rect.kt\nandroidx/core/graphics/RectKt\n*L\n191#1:366,3\n192#1:369,3\n251#1:372,6\n268#1:378,3\n273#1:381,3\n313#1:384,3\n314#1:387,3\n358#1:390,3\n*E\n"})
public final class RectKt {
    @SuppressLint({"CheckResult"})
    public static final Rect and(Rect r10, Rect r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Rect r12 = new Rect(r10);
        r12.intersect(r11);
        return r12;
    }

    @SuppressLint({"CheckResult"})
    public static final RectF and(RectF r10, RectF r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        RectF r12 = new RectF(r10);
        r12.intersect(r11);
        return r12;
    }

    public static final float component1(RectF r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.left;
    }

    public static final int component1(Rect r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.left;
    }

    public static final float component2(RectF r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.top;
    }

    public static final int component2(Rect r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.top;
    }

    public static final float component3(RectF r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.right;
    }

    public static final int component3(Rect r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.right;
    }

    public static final float component4(RectF r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.bottom;
    }

    public static final int component4(Rect r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.bottom;
    }

    public static final boolean contains(Rect r10, Point r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "p");
        return r10.contains(r11.x, r11.y);
    }

    public static final boolean contains(RectF r10, PointF r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "p");
        return r10.contains(r11.x, r11.y);
    }

    public static final Rect minus(Rect r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Rect r12 = new Rect(r10);
        int r13 = -r11;
        r12.offset(r13, r13);
        return r12;
    }

    public static final Rect minus(Rect r10, Point r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "xy");
        Rect r12 = new Rect(r10);
        r12.offset(-r11.x, -r11.y);
        return r12;
    }

    public static final RectF minus(RectF r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        RectF r12 = new RectF(r10);
        float r13 = -r11;
        r12.offset(r13, r13);
        return r12;
    }

    public static final RectF minus(RectF r10, PointF r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "xy");
        RectF r12 = new RectF(r10);
        r12.offset(-r11.x, -r11.y);
        return r12;
    }

    public static final Region minus(Rect r10, Rect r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Region r12 = new Region(r10);
        r12.op(r11, Region.Op.DIFFERENCE);
        return r12;
    }

    public static final Region minus(RectF r10, RectF r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Rect r12 = new Rect();
        r10.roundOut(r12);
        Region r13 = new Region(r12);
        Rect r14 = new Rect();
        r11.roundOut(r14);
        r13.op(r14, Region.Op.DIFFERENCE);
        return r13;
    }

    public static final Rect or(Rect r10, Rect r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Rect r12 = new Rect(r10);
        r12.union(r11);
        return r12;
    }

    public static final RectF or(RectF r10, RectF r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        RectF r12 = new RectF(r10);
        r12.union(r11);
        return r12;
    }

    public static final Rect plus(Rect r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Rect r12 = new Rect(r10);
        r12.offset(r11, r11);
        return r12;
    }

    public static final Rect plus(Rect r10, Point r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "xy");
        Rect r12 = new Rect(r10);
        r12.offset(r11.x, r11.y);
        return r12;
    }

    public static final Rect plus(Rect r10, Rect r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Rect r12 = new Rect(r10);
        r12.union(r11);
        return r12;
    }

    public static final RectF plus(RectF r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        RectF r12 = new RectF(r10);
        r12.offset(r11, r11);
        return r12;
    }

    public static final RectF plus(RectF r10, PointF r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "xy");
        RectF r12 = new RectF(r10);
        r12.offset(r11.x, r11.y);
        return r12;
    }

    public static final RectF plus(RectF r10, RectF r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        RectF r12 = new RectF(r10);
        r12.union(r11);
        return r12;
    }

    public static final Rect times(Rect r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Rect r12 = new Rect(r10);
        r12.top *= r11;
        r12.left *= r11;
        r12.right *= r11;
        r12.bottom *= r11;
        return r12;
    }

    public static final RectF times(RectF r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        RectF r12 = new RectF(r10);
        r12.top *= r11;
        r12.left *= r11;
        r12.right *= r11;
        r12.bottom *= r11;
        return r12;
    }

    public static final RectF times(RectF r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        float r12 = r11;
        RectF r13 = new RectF(r10);
        r13.top *= r12;
        r13.left *= r12;
        r13.right *= r12;
        r13.bottom *= r12;
        return r13;
    }

    public static final Rect toRect(RectF r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Rect r11 = new Rect();
        r10.roundOut(r11);
        return r11;
    }

    public static final RectF toRectF(Rect r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new RectF(r10);
    }

    public static final Region toRegion(Rect r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new Region(r10);
    }

    public static final Region toRegion(RectF r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Rect r11 = new Rect();
        r10.roundOut(r11);
        return new Region(r11);
    }

    public static final RectF transform(RectF r10, Matrix r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "m");
        r11.mapRect(r10);
        return r10;
    }

    public static final Region xor(Rect r10, Rect r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Region r12 = new Region(r10);
        r12.op(r11, Region.Op.XOR);
        return r12;
    }

    public static final Region xor(RectF r10, RectF r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Rect r12 = new Rect();
        r10.roundOut(r12);
        Region r13 = new Region(r12);
        Rect r14 = new Rect();
        r11.roundOut(r14);
        r13.op(r14, Region.Op.XOR);
        return r13;
    }
}
