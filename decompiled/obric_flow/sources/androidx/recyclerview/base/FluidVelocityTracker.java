package androidx.recyclerview.base;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J)\u0010\u0012\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0014H\u0002¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J)\u0010\u001f\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0014H\u0002¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/recyclerview/base/FluidVelocityTracker;", "Landroidx/recyclerview/base/VelocityTracker;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "calculatedVelocity", "Landroid/graphics/PointF;", "displayMetrics", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "positions", "Ljava/util/LinkedList;", "times", "", "addMovement", "", "event", "Landroid/view/MotionEvent;", "calculateRecurrenceRelationVelocity", "", "", "values", "([Ljava/lang/Float;[Ljava/lang/Float;)F", "clear", "computeCurrentVelocity", "units", "", "maxVelocity", "getXVelocity", "id", "getYVelocity", "tryCalculateRecurrenceRelationVelocity", "Companion", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidVelocityTracker implements VelocityTracker {
    public static final Companion Companion = null;
    private static final String TAG = "FluidVelocityTracker";
    private PointF calculatedVelocity;
    private final Context context;
    private final DisplayMetrics displayMetrics;
    private LinkedList<PointF> positions;
    private LinkedList<Long> times;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/recyclerview/base/FluidVelocityTracker$Companion;", "", "()V", "TAG", "", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FluidVelocityTracker(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
        this.positions = new LinkedList();
        this.times = new LinkedList();
        this.calculatedVelocity = new PointF(0.0f, 0.0f);
        this.displayMetrics = r5.getResources().getDisplayMetrics();
    }

    private final float calculateRecurrenceRelationVelocity(Float[] r10, Float[] r11) {
        if (r10.length != r11.length) goto L31;
        if (r10.length < 2) goto L29;
        List r12 = CollectionsKt.G(CollectionsKt.toMutableList(ArraysKt.zip(r11, r10)));
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L7:
        Float r5 = null;
        if (r14.hasNext() == false) goto L15;
        List r15 = (List) r14.next();
        float r16 = ((Number) ((Pair) r15.get(1)).getSecond()).floatValue() - ((Number) ((Pair) r15.get(0)).getSecond()).floatValue();
        if (r16 == 0.0f) goto L13;
        r5 = Float.valueOf((((Number) ((Pair) r15.get(1)).getFirst()).floatValue() - ((Number) ((Pair) r15.get(0)).getFirst()).floatValue()) / r16);
    L13:
        if (r5 == null) goto L7;
        r13.add(r5);
        goto L7
    L15:
        Iterator r17 = CollectionsKt.G(r13).iterator();
        Float r18 = null;
    L17:
        if (r17.hasNext() == false) goto L22;
        List r19 = (List) r17.next();
        float r20 = (((Number) r19.get(1)).floatValue() * 0.6f) + (((Number) r19.get(0)).floatValue() * 0.4f);
        if (r5 != null) goto L20;
        r5 = Float.valueOf(r20);
        goto L17
    L20:
        Float r21 = r5;
        r5 = Float.valueOf((r20 * 0.2f) + (r5.floatValue() * 0.8f));
        r18 = r21;
        goto L17
    L22:
        if (r5 == null) goto L27;
        if (r18 == null) goto L44;
        return (r5.floatValue() * 0.25f) + (r18.floatValue() * 0.75f);
    L44:
        return r5.floatValue();
    L27:
        return ((Number) CollectionsKt.first(r13)).floatValue();
    L29:
        throw new IllegalArgumentException("At least two points must be provided");
    L31:
        throw new IllegalArgumentException("The number of times and values must be equal");
    }

    private final float tryCalculateRecurrenceRelationVelocity(Float[] r5, Float[] r10) {
        return calculateRecurrenceRelationVelocity(r5, r10);
    L4:
        e = move-exception;
        Log.e(TAG, "calculateRecurrenceRelationVelocity failed", e);
        return 0.0f;
    }

    @Override // androidx.recyclerview.base.VelocityTracker
    public void addMovement(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (this.positions.size() < 4) goto L5;
        this.positions.removeFirst();
        this.times.removeFirst();
    L5:
        this.times.add(Long.valueOf(r5.getEventTime()));
        this.positions.add(new PointF(r5.getX(), r5.getY()));
    }

    @Override // androidx.recyclerview.base.VelocityTracker
    public void clear() {
        this.positions.clear();
        this.times.clear();
        this.calculatedVelocity = new PointF(0.0f, 0.0f);
    }

    @Override // androidx.recyclerview.base.VelocityTracker
    public void computeCurrentVelocity(int r10, float r11) {
        float r5 = 0.0f;
        if (this.times.isEmpty() == false) goto L6;
        this.calculatedVelocity = new PointF(0.0f, 0.0f);
        return;
    L6:
        long r12 = ((Number) CollectionsKt.first(this.times)).longValue();
        LinkedList<Long> r13 = this.times;
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator<T> r15 = r13.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        r14.add(Float.valueOf(((Number) r15.next()).longValue() - r12));
        goto L8
    L10:
        List r16 = CollectionsKt.toMutableList(r14);
        LinkedList<PointF> r17 = this.positions;
        ArrayList r18 = new ArrayList(CollectionsKt.h(r17));
        Iterator<T> r19 = r17.iterator();
    L12:
        if (r19.hasNext() == false) goto L14;
        r18.add(Float.valueOf(((PointF) r19.next()).x));
        goto L12
    L14:
        Object[] r20 = r18.toArray(new Float[0]);
        if (r20 == null) goto L39;
        Float[] r21 = (Float[]) r20;
        LinkedList<PointF> r22 = this.positions;
        ArrayList r23 = new ArrayList(CollectionsKt.h(r22));
        Iterator<T> r24 = r22.iterator();
    L18:
        if (r24.hasNext() == false) goto L20;
        r23.add(Float.valueOf(((PointF) r24.next()).y));
        goto L18
    L20:
        Object[] r25 = r23.toArray(new Float[0]);
        if (r25 == null) goto L37;
        Float[] r26 = (Float[]) r25;
        Object[] r27 = r16.toArray(new Float[0]);
        if (r27 == null) goto L35;
        float r28 = tryCalculateRecurrenceRelationVelocity((Float[]) r27, r21);
        Object[] r110 = r16.toArray(new Float[0]);
        if (r110 == null) goto L33;
        float r111 = tryCalculateRecurrenceRelationVelocity((Float[]) r110, r26);
        double r29 = 2;
        if ((((float) Math.pow(r28, r29)) + ((float) Math.pow(r111, r29))) >= (((double) ((float) Math.pow(this.displayMetrics.density, r29))) * 0.0576d)) goto L29;
        r111 = 0.0f;
    L30:
        float r112 = r10;
        this.calculatedVelocity = new PointF(r5 * r112, r111 * r112);
        return;
    L29:
        r5 = r28;
        goto L30
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L35:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L37:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L39:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // androidx.recyclerview.base.VelocityTracker
    public float getXVelocity(int r5) {
        return this.calculatedVelocity.x;
    }

    @Override // androidx.recyclerview.base.VelocityTracker
    public float getYVelocity(int r5) {
        return this.calculatedVelocity.y;
    }
}
