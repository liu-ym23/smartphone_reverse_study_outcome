package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\r\u0010\u0004\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0004\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0012\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u0003H\u0086\b\u001a\r\u0010\u0017\u001a\u00020\u0003*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\u0015\u0010\u0019\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f¨\u0006\u001d"}, d2 = {"and", "Landroid/graphics/Rect;", "r", "Landroid/graphics/RectF;", "component1", "", "", "component2", "component3", "component4", "contains", "", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "minus", "xy", "Landroid/graphics/Region;", "or", "plus", "times", "factor", "toRect", "toRectF", "toRegion", "transform", "m", "Landroid/graphics/Matrix;", "xor", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Rect.kt\nandroidx/core/graphics/RectKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,365:1\n344#1,3:366\n344#1,3:369\n257#1,6:372\n122#1,3:378\n132#1,3:381\n344#1,3:384\n344#1,3:387\n344#1,3:390\n1#2:393\n*S KotlinDebug\n*F\n+ 1 Rect.kt\nandroidx/core/graphics/RectKt\n*L\n191#1:366,3\n192#1:369,3\n251#1:372,6\n268#1:378,3\n273#1:381,3\n313#1:384,3\n314#1:387,3\n358#1:390,3\n*E\n"})
public final class RectKt {
    @SuppressLint({"CheckResult"})
    public static final Rect and(Rect r5, Rect r10) {
        Rect r11 = new Rect(r5);
        r11.intersect(r10);
        return r11;
    }

    public static final int component1(Rect r5) {
        return r5.left;
    }

    public static final int component2(Rect r5) {
        return r5.top;
    }

    public static final int component3(Rect r5) {
        return r5.right;
    }

    public static final int component4(Rect r5) {
        return r5.bottom;
    }

    public static final boolean contains(Rect r5, Point r10) {
        return r5.contains(r10.x, r10.y);
    }

    public static final Region minus(Rect r5, Rect r10) {
        Region r11 = new Region(r5);
        r11.op(r10, Region.Op.DIFFERENCE);
        return r11;
    }

    public static final Rect or(Rect r5, Rect r10) {
        Rect r11 = new Rect(r5);
        r11.union(r10);
        return r11;
    }

    public static final Rect plus(Rect r5, Rect r10) {
        Rect r11 = new Rect(r5);
        r11.union(r10);
        return r11;
    }

    public static final Rect times(Rect r5, int r10) {
        Rect r11 = new Rect(r5);
        r11.top *= r10;
        r11.left *= r10;
        r11.right *= r10;
        r11.bottom *= r10;
        return r11;
    }

    public static final Rect toRect(RectF r5) {
        Rect r10 = new Rect();
        r5.roundOut(r10);
        return r10;
    }

    public static final RectF toRectF(Rect r5) {
        return new RectF(r5);
    }

    public static final Region toRegion(Rect r5) {
        return new Region(r5);
    }

    public static final RectF transform(RectF r5, Matrix r10) {
        r10.mapRect(r5);
        return r5;
    }

    public static final Region xor(Rect r5, Rect r10) {
        Region r11 = new Region(r5);
        r11.op(r10, Region.Op.XOR);
        return r11;
    }

    public static final float component1(RectF r5) {
        return r5.left;
    }

    public static final float component2(RectF r5) {
        return r5.top;
    }

    public static final float component3(RectF r5) {
        return r5.right;
    }

    public static final float component4(RectF r5) {
        return r5.bottom;
    }

    public static final boolean contains(RectF r5, PointF r10) {
        return r5.contains(r10.x, r10.y);
    }

    public static final Region toRegion(RectF r5) {
        Rect r10 = new Rect();
        r5.roundOut(r10);
        return new Region(r10);
    }

    @SuppressLint({"CheckResult"})
    public static final RectF and(RectF r5, RectF r10) {
        RectF r11 = new RectF(r5);
        r11.intersect(r10);
        return r11;
    }

    public static final Region minus(RectF r5, RectF r10) {
        Rect r11 = new Rect();
        r5.roundOut(r11);
        Region r12 = new Region(r11);
        Rect r13 = new Rect();
        r10.roundOut(r13);
        r12.op(r13, Region.Op.DIFFERENCE);
        return r12;
    }

    public static final RectF or(RectF r5, RectF r10) {
        RectF r11 = new RectF(r5);
        r11.union(r10);
        return r11;
    }

    public static final RectF plus(RectF r5, RectF r10) {
        RectF r11 = new RectF(r5);
        r11.union(r10);
        return r11;
    }

    public static final Region xor(RectF r5, RectF r10) {
        Rect r11 = new Rect();
        r5.roundOut(r11);
        Region r12 = new Region(r11);
        Rect r13 = new Rect();
        r10.roundOut(r13);
        r12.op(r13, Region.Op.XOR);
        return r12;
    }

    public static final Rect plus(Rect r5, int r10) {
        Rect r11 = new Rect(r5);
        r11.offset(r10, r10);
        return r11;
    }

    public static final RectF times(RectF r5, float r10) {
        RectF r11 = new RectF(r5);
        r11.top *= r10;
        r11.left *= r10;
        r11.right *= r10;
        r11.bottom *= r10;
        return r11;
    }

    public static final RectF plus(RectF r5, float r10) {
        RectF r11 = new RectF(r5);
        r11.offset(r10, r10);
        return r11;
    }

    public static final Rect plus(Rect r5, Point r10) {
        Rect r11 = new Rect(r5);
        r11.offset(r10.x, r10.y);
        return r11;
    }

    public static final Rect minus(Rect r5, int r10) {
        Rect r11 = new Rect(r5);
        int r12 = -r10;
        r11.offset(r12, r12);
        return r11;
    }

    public static final RectF plus(RectF r5, PointF r10) {
        RectF r11 = new RectF(r5);
        r11.offset(r10.x, r10.y);
        return r11;
    }

    public static final RectF times(RectF r5, int r10) {
        float r11 = r10;
        RectF r12 = new RectF(r5);
        r12.top *= r11;
        r12.left *= r11;
        r12.right *= r11;
        r12.bottom *= r11;
        return r12;
    }

    public static final RectF minus(RectF r5, float r10) {
        RectF r11 = new RectF(r5);
        float r12 = -r10;
        r11.offset(r12, r12);
        return r11;
    }

    public static final Rect minus(Rect r5, Point r10) {
        Rect r11 = new Rect(r5);
        r11.offset(-r10.x, -r10.y);
        return r11;
    }

    public static final RectF minus(RectF r5, PointF r10) {
        RectF r11 = new RectF(r5);
        r11.offset(-r10.x, -r10.y);
        return r11;
    }
}
