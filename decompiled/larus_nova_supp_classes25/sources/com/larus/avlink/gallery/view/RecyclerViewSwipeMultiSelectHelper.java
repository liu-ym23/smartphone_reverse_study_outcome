package com.larus.avlink.gallery.view;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001-\b\u0001\u0018\u00002\u00020\u0001:\u0001JB¨\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\b\u00126\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\r0\u000f\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0005\u0012\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010/\u001a\u00020\rJ\u001e\u00100\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u0014J\u0018\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u00020\r2\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u000206H\u0016J\u0010\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020\u0006H\u0016J\u0010\u0010:\u001a\u00020\r2\u0006\u00105\u001a\u000206H\u0002J\u0018\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u0014H\u0002J\b\u0010>\u001a\u00020\rH\u0002J\u0018\u0010?\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u0014H\u0002J\u0010\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020\tH\u0002J\u0018\u0010B\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u0014H\u0002J \u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u00020E2\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u0014H\u0002J\u0010\u0010F\u001a\u00020\r2\u0006\u00102\u001a\u00020\u0014H\u0002J\b\u0010G\u001a\u00020\rH\u0002J\b\u0010H\u001a\u00020\rH\u0002J\b\u0010I\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.¨\u0006K"}, d2 = {"Lcom/larus/avlink/gallery/view/RecyclerViewSwipeMultiSelectHelper;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isEnabled", "Lkotlin/Function0;", "", "onSelectionStart", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "onSelectionRangeChanged", "Lkotlin/Function2;", "anchorPosition", "currentPosition", "onSelectionFinished", "bottomAutoScrollBoundaryProvider", "", "bottomEdgeTriggerDistanceOverridePx", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/Float;)V", "Ljava/lang/Float;", "touchSlop", "topEdgeTriggerDistancePx", "bottomEdgeTriggerDistancePx", "fastEdgeDistancePx", "normalSpeedPxPerSecond", "fastSpeedPxPerSecond", "downX", "downY", "lastTouchX", "lastTouchY", "axisLock", "Lcom/larus/avlink/gallery/view/RecyclerViewSwipeMultiSelectHelper$AxisLock;", "isTracking", "isSelecting", "autoScrollSpeedPxPerSecond", "lastAutoScrollFrameTimeMs", "", "pendingScrollOffsetPx", "isAutoScrollNestedActive", "autoScrollRunnable", "com/larus/avlink/gallery/view/RecyclerViewSwipeMultiSelectHelper$autoScrollRunnable$1", "Lcom/larus/avlink/gallery/view/RecyclerViewSwipeMultiSelectHelper$autoScrollRunnable$1;", "detach", "prepareForLongPressSelection", "touchX", "touchY", "onInterceptTouchEvent", "rv", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "handleActionDown", "hasCrossedTouchSlop", "x", "y", "beginSelection", "updateSelectionForPoint", "scrollByParentFirst", "scrollDelta", "findClosestAdapterPosition", "calculateDistanceToViewBounds", "view", "Landroid/view/View;", "updateAutoScrollSpeed", "stopAutoScroll", "finishSelection", "resetGestureState", "AxisLock", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RecyclerViewSwipeMultiSelectHelper implements RecyclerView.OnItemTouchListener {
    public final RecyclerView a;
    public final Function0<Boolean> b;
    public final Function1<Integer, Unit> c;
    public final Function2<Integer, Integer, Unit> d;
    public final Function0<Unit> e;
    public final Function0<Float> f;
    public final float g;
    public final float h;
    public final float i;
    public final float j;
    public final float k;
    public final float l;
    public int m;
    public int n;
    public float o;
    public float p;
    public float q;
    public float r;
    public AxisLock s;
    public boolean t;
    public boolean u;
    public float v;
    public long w;
    public float x;
    public boolean y;
    public final a z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/gallery/view/RecyclerViewSwipeMultiSelectHelper$AxisLock;", "", "<init>", "(Ljava/lang/String;I)V", "UNDECIDED", "X", "Y", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum AxisLock extends Enum<AxisLock> {
        public static final AxisLock UNDECIDED = null;
        public static final AxisLock X = null;
        public static final AxisLock Y = null;
        public static final /* synthetic */ AxisLock[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<AxisLock> getEntries() {
            return b;
        }

        static {
            AxisLock r0 = new AxisLock("UNDECIDED", 0);
            UNDECIDED = r0;
            AxisLock r1 = new AxisLock("X", 1);
            X = r1;
            AxisLock r3 = new AxisLock("Y", 2);
            Y = r3;
            AxisLock[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static AxisLock[] values() {
            return (AxisLock[]) a.clone();
        }

        public static AxisLock valueOf(String r1) {
            return (AxisLock) r27.a.a(AxisLock.class, r1);
        }

        public AxisLock(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ RecyclerViewSwipeMultiSelectHelper a;

        public final void a() {
            RecyclerViewSwipeMultiSelectHelper r0 = this.a;
            if (r0.u == false) goto L30;
            boolean r2 = true;
            if (r0.v != 0.0f) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == true) goto L32;
            long r4 = SystemClock.uptimeMillis();
            RecyclerViewSwipeMultiSelectHelper r3 = this.a;
            long r6 = r3.w;
            if (r6 != 0) goto L13;
            long r7 = 16;
        L14:
            r3.w = r4;
            float r5 = r3.x + ((r3.v * r7) / 1000.0f);
            r3.x = r5;
            int r8 = (int) r5;
            if (r8 == 0) goto L23;
            int[] r11 = new int[2];
            if (r3.a.dispatchNestedPreScroll(0, r8, r11, null, 1) == false) goto L19;
            int r9 = r8 - r11[1];
        L20:
            if (r9 == 0) goto L22;
            r3.a.scrollBy(0, r9);
        L22:
            this.a.x -= r8;
            goto L23
        L19:
            r9 = r8;
        L23:
            RecyclerViewSwipeMultiSelectHelper r10 = this.a;
            r10.d(r10.q, r10.r);
            RecyclerViewSwipeMultiSelectHelper r12 = this.a;
            r12.c(r12.r);
            RecyclerViewSwipeMultiSelectHelper r13 = this.a;
            if (r13.v == 0.0f) goto L27;
            r2 = false;
        L27:
            if (r2 == true) goto L31;
            r13.a.postOnAnimation(this);
            return;
        L31:
            return;
        L13:
            r7 = r4 - r6;
            goto L14
        L32:
            return;
        L7:
            r1 = false;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(RecyclerViewSwipeMultiSelectHelper r1) {
            this.a = r1;
        }
    }

    public final void a() {
        this.m = -1;
        this.n = -1;
        this.s = AxisLock.UNDECIDED;
        this.t = false;
        this.u = false;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 0.0f;
        this.r = 0.0f;
    }

    public final void b() {
        this.v = 0.0f;
        this.x = 0.0f;
        this.w = 0;
        if (this.y == false) goto L5;
        this.a.stopNestedScroll(1);
        this.y = false;
    L5:
        this.a.removeCallbacks(this.z);
    }

    public final void onRequestDisallowInterceptTouchEvent(boolean r1) {
    }

    public final void c(float r7) {
        if (this.u == true) goto L6;
        b();
        return;
    L6:
        Rect r0 = new Rect();
        boolean r1 = this.a.getLocalVisibleRect(r0);
        int r2 = this.a.getPaddingTop();
        boolean r3 = false;
        if (r1 == false) goto L9;
        int r4 = r0.top;
    L10:
        float r5 = Math.max(r2, r4);
        int r6 = this.a.getHeight() - this.a.getPaddingBottom();
        if (r1 == false) goto L13;
        int r8 = r0.bottom;
    L14:
        float r9 = Math.min(r6, r8);
        Function0<Float> r10 = this.f;
        if (r10 == null) goto L19;
        Float r11 = (Float) r10.invoke();
        if (r11 == null) goto L19;
        float r12 = RangesKt.coerceIn(r11.floatValue(), r5, r9);
    L20:
        float r13 = Math.min(r9, r12);
        if (r13 > r5) goto L25;
        b();
        return;
    L25:
        if (r7 > (this.h + r5)) goto L35;
        float r14 = RangesKt.coerceAtLeast(r7 - r5, 0.0f);
        if (this.a.canScrollVertically(-1) == true) goto L30;
    L43:
        float r15 = 0.0f;
    L45:
        if (r15 != this.v) goto L47;
        boolean r16 = true;
    L48:
        if (r16 == false) goto L51;
        return;
    L51:
        if (r15 != 0.0f) goto L53;
        boolean r17 = true;
    L54:
        if (r17 == false) goto L56;
    L58:
        if (r15 != 0.0f) goto L60;
        boolean r18 = true;
    L61:
        if (r18 == true) goto L63;
    L65:
        this.v = r15;
        this.x = 0.0f;
        this.w = 0;
        if (r15 != 0.0f) goto L68;
        r3 = true;
    L68:
        if (r3 == false) goto L70;
        this.a.removeCallbacks(this.z);
        return;
    L70:
        this.a.removeCallbacks(this.z);
        this.a.postOnAnimation(this.z);
        return;
    L63:
        if (this.y == false) goto L65;
        this.a.stopNestedScroll(1);
        this.y = false;
        goto L65
    L60:
        r18 = false;
        goto L61
    L56:
        if (this.y == true) goto L58;
        this.y = this.a.startNestedScroll(2, 1);
        goto L65
    L53:
        r17 = false;
        goto L54
    L47:
        r16 = false;
        goto L48
    L30:
        if (r14 > this.j) goto L32;
        float r19 = this.l;
    L33:
        r15 = -r19;
        goto L45
    L32:
        r19 = this.k;
        goto L33
    L35:
        if (r7 < (r13 - this.i)) goto L43;
        float r20 = RangesKt.coerceAtLeast(r13 - r7, 0.0f);
        if (this.a.canScrollVertically(1) == false) goto L43;
        if (r20 > this.j) goto L42;
        r15 = this.l;
        goto L45
    L42:
        r15 = this.k;
    L19:
        r12 = r9;
        goto L20
    L13:
        r8 = this.a.getHeight();
        goto L14
    L9:
        r4 = 0;
        goto L10
    }

    public final void d(float r10, float r11) {
        if (this.u == true) goto L5;
        return;
    L5:
        if (this.m == (-1)) goto L47;
        View r0 = this.a.findChildViewUnder(r10, r11);
        if (r0 == null) goto L10;
        int r12 = this.a.getChildAdapterPosition(r0);
    L35:
        if (r12 != (-1)) goto L37;
        return;
    L37:
        if (r12 == this.n) goto L48;
        this.n = r12;
        this.d.invoke(Integer.valueOf(this.m), Integer.valueOf(r12));
        return;
    L48:
        return;
    L10:
        int r1 = this.a.getChildCount();
        View r2 = null;
        float r3 = Float.MAX_VALUE;
        int r4 = 0;
    L11:
        if (r4 >= r1) goto L32;
        View r5 = this.a.getChildAt(r4);
        if (r5 == null) goto L31;
        float r7 = 0.0f;
        if (r10 >= r5.getLeft()) goto L19;
        float r6 = r5.getLeft() - r10;
    L23:
        if (r11 >= r5.getTop()) goto L26;
        r7 = r5.getTop() - r11;
    L28:
        float r8 = (r6 * r6) + (r7 * r7);
        if (r8 >= r3) goto L31;
        r2 = r5;
        r3 = r8;
        goto L31
    L26:
        if (r11 <= r5.getBottom()) goto L28;
        r7 = r11 - r5.getBottom();
        goto L28
    L19:
        if (r10 <= r5.getRight()) goto L21;
        r6 = r10 - r5.getRight();
        goto L23
    L21:
        r6 = 0.0f;
    L31:
        r4 = r4 + 1;
        goto L11
    L32:
        if (r2 == null) goto L34;
        r12 = this.a.getChildAdapterPosition(r2);
        goto L35
    L34:
        r12 = -1;
        goto L35
    }

    public final boolean onInterceptTouchEvent(RecyclerView r10, MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r10, "rv");
        Intrinsics.checkNotNullParameter(r11, "event");
        int r0 = r11.getActionMasked();
        if (r0 == 0) goto L43;
        if (r0 != 1) goto L6;
    L40:
        boolean r12 = this.u;
        b();
        a();
        if (r12 == false) goto L56;
        this.e.invoke();
    L56:
        return false;
    L6:
        if (r0 == 2) goto L11;
        if (r0 == 3) goto L40;
    L11:
        if (this.t == true) goto L13;
        return false;
    L13:
        this.q = r11.getX();
        this.r = r11.getY();
        if (this.s != AxisLock.UNDECIDED) goto L39;
        if (Math.hypot(r11.getX() - this.o, r11.getY() - this.p) < this.g) goto L18;
        boolean r1 = true;
    L19:
        if (r1 == false) goto L39;
        if (Math.abs(r11.getX() - this.o) <= Math.abs(r11.getY() - this.p)) goto L23;
        AxisLock r2 = AxisLock.X;
    L24:
        this.s = r2;
        if (r2 != AxisLock.X) goto L34;
        int r3 = this.m;
        if (r3 == (-1)) goto L30;
        this.u = true;
        this.c.invoke(Integer.valueOf(r3));
    L30:
        d(r11.getX(), r11.getY());
        c(r11.getY());
        ViewParent r13 = r10.getParent();
        if (r13 == null) goto L33;
        r13.requestDisallowInterceptTouchEvent(true);
    L33:
        return true;
    L34:
        b();
        ViewParent r14 = r10.getParent();
        if (r14 == null) goto L37;
        r14.requestDisallowInterceptTouchEvent(false);
    L37:
        this.t = false;
        goto L39
    L23:
        r2 = AxisLock.Y;
        goto L24
    L18:
        r1 = false;
    L39:
        return this.u;
    L43:
        boolean r15 = this.u;
        b();
        a();
        if (r15 == false) goto L47;
        this.e.invoke();
    L47:
        if (((Boolean) this.b.invoke()).booleanValue() == false) goto L56;
        View r16 = this.a.findChildViewUnder(r11.getX(), r11.getY());
        if (r16 == null) goto L56;
        int r17 = this.a.getChildAdapterPosition(r16);
        if (r17 == (-1)) goto L56;
        this.m = r17;
        this.n = r17;
        this.o = r11.getX();
        this.p = r11.getY();
        this.q = r11.getX();
        this.r = r11.getY();
        this.s = AxisLock.UNDECIDED;
        this.t = true;
        this.u = false;
        goto L56
    }

    public final void onTouchEvent(RecyclerView r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "rv");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (this.u == true) goto L5;
        return;
    L5:
        int r4 = r3.getActionMasked();
        if (r4 != 1) goto L8;
    L13:
        boolean r5 = this.u;
        b();
        a();
        if (r5 == false) goto L18;
        this.e.invoke();
        return;
    L18:
        return;
    L8:
        if (r4 != 2) goto L10;
        this.q = r3.getX();
        this.r = r3.getY();
        d(r3.getX(), r3.getY());
        c(r3.getY());
        return;
    L10:
        if (r4 == 3) goto L13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecyclerViewSwipeMultiSelectHelper(RecyclerView r2, Function0<Boolean> r3, Function1<? super Integer, Unit> r4, Function2<? super Integer, ? super Integer, Unit> r5, Function0<Unit> r6, Function0<Float> r7, Float r8) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "isEnabled");
        Intrinsics.checkNotNullParameter(r4, "onSelectionStart");
        Intrinsics.checkNotNullParameter(r5, "onSelectionRangeChanged");
        Intrinsics.checkNotNullParameter(r6, "onSelectionFinished");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = ViewConfiguration.get(r2.getContext()).getScaledTouchSlop();
        this.h = t1.a(r2.getContext(), 64.0f);
        if (r8 == null) goto L5;
        float r9 = r8.floatValue();
    L6:
        this.i = r9;
        this.j = t1.a(r2.getContext(), 32.0f);
        this.k = t1.a(r2.getContext(), 256.0f);
        this.l = t1.a(r2.getContext(), 512.0f);
        this.m = -1;
        this.n = -1;
        this.s = AxisLock.UNDECIDED;
        this.z = new a(this);
        r2.addOnItemTouchListener(this);
        return;
    L5:
        r9 = t1.a(r2.getContext(), 64.0f);
        goto L6
    }
}
