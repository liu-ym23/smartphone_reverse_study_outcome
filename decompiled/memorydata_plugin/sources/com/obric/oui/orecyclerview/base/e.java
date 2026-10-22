package com.obric.oui.orecyclerview.base;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J)\u0010\u0012\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0014H\u0002¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J)\u0010\u001f\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0014H\u0002¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/oui/orecyclerview/base/FluidVelocityTracker;", "Lcom/obric/oui/orecyclerview/base/VelocityTracker;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "calculatedVelocity", "Landroid/graphics/PointF;", "displayMetrics", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "positions", "Ljava/util/LinkedList;", "times", "", "addMovement", "", "event", "Landroid/view/MotionEvent;", "calculateRecurrenceRelationVelocity", "", "", "values", "([Ljava/lang/Float;[Ljava/lang/Float;)F", "clear", "computeCurrentVelocity", "units", "", "maxVelocity", "getXVelocity", OaidModel.KEY_ID, "getYVelocity", "tryCalculateRecurrenceRelationVelocity", "Companion", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14043a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f14044b;
    private LinkedList<PointF> c;
    private LinkedList<Long> d;
    private PointF e;
    private final DisplayMetrics f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/orecyclerview/base/FluidVelocityTracker$Companion;", "", "()V", "TAG", "", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14043a = new a(null);
    }

    public e(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Context r6 = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.f14044b = r6;
        this.c = new LinkedList();
        this.d = new LinkedList();
        this.e = new PointF(0.0f, 0.0f);
        this.f = ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getDisplayMetrics();
    }

    private final float a(Float[] r1, Float[] r2) {
        return b(r1, r2);
    L4:
        e = move-exception;
        Log.e("FluidVelocityTracker", "calculateRecurrenceRelationVelocity failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return 0.0f;
    }

    private final float b(Float[] r12, Float[] r13) {
        if (r12.length != r13.length) goto L36;
        if (r12.length < 2) goto L34;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.windowed$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(ArraysKt.zip(r13, r12), Collection.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), 2, 0, false, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r11.iterator();
    L7:
        Float r1 = null;
        if (r15.hasNext() == false) goto L18;
        List r0 = (List) ZeusTransformUtils.preCheckCast(r15.next(), List.class, "com.obric.memorydata.plugin");
        float r4 = ((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r0.get(1), Pair.class, "com.obric.memorydata.plugin")).getSecond(), Number.class, "com.obric.memorydata.plugin")).floatValue() - ((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r0.get(0), Pair.class, "com.obric.memorydata.plugin")).getSecond(), Number.class, "com.obric.memorydata.plugin")).floatValue();
        if (r4 != 0.0f) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        Float r2 = (Float) ZeusTransformUtils.preCheckCast(null, Float.class, "com.obric.memorydata.plugin");
    L16:
        if (r2 == null) goto L7;
        r14.add(r2);
        goto L7
    L15:
        r2 = Float.valueOf((((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r0.get(1), Pair.class, "com.obric.memorydata.plugin")).getFirst(), Number.class, "com.obric.memorydata.plugin")).floatValue() - ((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r0.get(0), Pair.class, "com.obric.memorydata.plugin")).getFirst(), Number.class, "com.obric.memorydata.plugin")).floatValue()) / r4);
        goto L16
    L12:
        r5 = false;
        goto L13
    L18:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.windowed$default((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"), 2, 0, false, 6, null), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        Float r3 = null;
    L20:
        if (r17.hasNext() == false) goto L25;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r17.next(), List.class, "com.obric.memorydata.plugin");
        float r7 = (((Number) ZeusTransformUtils.preCheckCast(r6.get(0), Number.class, "com.obric.memorydata.plugin")).floatValue() * 0.4f) + (((Number) ZeusTransformUtils.preCheckCast(r6.get(1), Number.class, "com.obric.memorydata.plugin")).floatValue() * 0.6f);
        if (r1 != null) goto L23;
        r1 = Float.valueOf(r7);
        goto L20
    L23:
        Float r10 = r1;
        r1 = Float.valueOf((((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).floatValue() * 0.8f) + (r7 * 0.2f));
        r3 = r10;
        goto L20
    L25:
        if (r1 != null) goto L27;
        Object r18 = ZeusTransformUtils.preCheckCast(CollectionsKt.first(r16), Number.class, "com.obric.memorydata.plugin");
    L32:
        return ((Number) r18).floatValue();
    L27:
        if (r3 != null) goto L48;
        r18 = ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin");
        goto L32
    L48:
        return (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).floatValue() * 0.75f) + (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).floatValue() * 0.25f);
    L34:
        throw new IllegalArgumentException("At least two points must be provided");
    L36:
        throw new IllegalArgumentException("The number of times and values must be equal");
    }

    @Override // com.obric.oui.orecyclerview.base.i
    public float a(int r1) {
        return this.e.x;
    }

    @Override // com.obric.oui.orecyclerview.base.i
    public void a() {
        this.c.clear();
        this.d.clear();
        this.e = new PointF(0.0f, 0.0f);
    }

    @Override // com.obric.oui.orecyclerview.base.i
    public void a(int r11, float r12) {
        float r0 = 0.0f;
        if (this.d.isEmpty() == false) goto L6;
        this.e = new PointF(0.0f, 0.0f);
        return;
    L6:
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(CollectionsKt.first((List) ZeusTransformUtils.preCheckCast(this.d, List.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).longValue();
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(this.d, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r1.add(Float.valueOf(((Number) ZeusTransformUtils.preCheckCast(r14.next(), Number.class, "com.obric.memorydata.plugin")).longValue() - r3));
        goto L8
    L10:
        List r15 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r2.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        r4.add(Float.valueOf(((PointF) ZeusTransformUtils.preCheckCast(r5.next(), PointF.class, "com.obric.memorydata.plugin")).x));
        goto L12
    L14:
        Object[] r6 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new Float[0]);
        Objects.requireNonNull(r6, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Float[] r7 = (Float[]) ZeusTransformUtils.preCheckCast(r6, Float[].class, "com.obric.memorydata.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L16:
        if (r10.hasNext() == false) goto L18;
        r9.add(Float.valueOf(((PointF) ZeusTransformUtils.preCheckCast(r10.next(), PointF.class, "com.obric.memorydata.plugin")).y));
        goto L16
    L18:
        Object[] r16 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new Float[0]);
        Objects.requireNonNull(r16, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Float[] r17 = (Float[]) ZeusTransformUtils.preCheckCast(r16, Float[].class, "com.obric.memorydata.plugin");
        Object[] r18 = ((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).toArray(new Float[0]);
        Objects.requireNonNull(r18, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        float r19 = a((Float[]) ZeusTransformUtils.preCheckCast(r18, Float[].class, "com.obric.memorydata.plugin"), r7);
        Object[] r110 = ((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).toArray(new Float[0]);
        Objects.requireNonNull(r110, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        float r111 = a((Float[]) ZeusTransformUtils.preCheckCast(r110, Float[].class, "com.obric.memorydata.plugin"), r17);
        double r20 = 2;
        if ((((float) Math.pow(r19, r20)) + ((float) Math.pow(r111, r20))) >= (((double) ((float) Math.pow(this.f.density, r20))) * 0.0576d)) goto L21;
        r111 = 0.0f;
    L22:
        float r112 = r11;
        this.e = new PointF(r0 * r112, r111 * r112);
        return;
    L21:
        r0 = r19;
        goto L22
    }

    @Override // com.obric.oui.orecyclerview.base.i
    public void a(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (this.c.size() < 4) goto L5;
        this.c.removeFirst();
        this.d.removeFirst();
    L5:
        this.d.add(Long.valueOf(r4.getEventTime()));
        this.c.add(new PointF(r4.getX(), r4.getY()));
    }

    @Override // com.obric.oui.orecyclerview.base.i
    public float b(int r1) {
        return this.e.y;
    }
}
