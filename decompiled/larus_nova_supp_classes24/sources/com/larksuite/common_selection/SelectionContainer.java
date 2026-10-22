package com.larksuite.common_selection;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.ArrayMap;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.common_selection.selectionhandle.SelectionHandleType;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 t2\u00020\u0001:\u0001tB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020)H\u0002J(\u0010?\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0014J\u0010\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020=H\u0002J\u0012\u0010F\u001a\u00020\u00132\b\u0010E\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010G\u001a\u00020\u00132\u0006\u0010E\u001a\u00020=H\u0016J\u0010\u0010H\u001a\u00020\u00132\u0006\u0010I\u001a\u00020=H\u0017J0\u0010J\u001a\u00020\u00182\u0006\u0010K\u001a\u00020\u00132\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0007H\u0014J\b\u0010P\u001a\u00020\u0018H\u0002J\u0010\u0010Q\u001a\u00020\u00182\u0006\u0010R\u001a\u00020\u001eH\u0002J\u0010\u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u00020UH\u0014J\u0010\u0010V\u001a\u00020\u00182\u0006\u0010T\u001a\u00020UH\u0014J\u0010\u0010W\u001a\u00020\u00182\u0006\u0010T\u001a\u00020UH\u0002J\b\u0010X\u001a\u00020\u0018H\u0002J0\u0010Y\u001a\u00020\u00182\u0006\u0010Z\u001a\u00020\u001e2\u0006\u0010[\u001a\u00020\u00132\u0006\u0010\\\u001a\u00020\u00132\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u000fH\u0002J\u001f\u0010`\u001a\u0004\u0018\u0001022\u0006\u0010a\u001a\u00020/2\u0006\u0010b\u001a\u00020/H\u0000¢\u0006\u0002\bcJ\u0010\u0010d\u001a\u00020\u00182\u0006\u0010e\u001a\u00020\u0013H\u0016J\b\u0010f\u001a\u00020\u0018H\u0002J\u001a\u0010g\u001a\u0004\u0018\u0001022\u0006\u0010a\u001a\u00020/2\u0006\u0010b\u001a\u00020/H\u0002J\u001a\u0010h\u001a\u0004\u0018\u0001022\u0006\u0010a\u001a\u00020/2\u0006\u0010b\u001a\u00020/H\u0002J\u001a\u0010i\u001a\u0004\u0018\u0001022\u0006\u0010a\u001a\u00020/2\u0006\u0010b\u001a\u00020/H\u0002J \u0010j\u001a\u0002022\u0006\u0010Z\u001a\u00020\u001e2\u0006\u0010k\u001a\u00020/2\u0006\u0010l\u001a\u00020/H\u0002J\u0018\u0010m\u001a\u00020\r2\u0006\u0010n\u001a\u00020\u001e2\u0006\u0010o\u001a\u00020\rH\u0002J\b\u0010p\u001a\u00020\u0018H\u0016J\u001c\u0010q\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\r0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00070#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/larksuite/common_selection/SelectionContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tempRect", "Landroid/graphics/Rect;", "tempRectF", "Landroid/graphics/RectF;", "tempPath", "Landroid/graphics/Path;", "highlightPath", "touchSlop", "isInitialDragSelect", "", "skipActionUPOnTouchEvent", "isInActionDown", "externalLongClickListener", "Lkotlin/Function0;", "", "externalLongPressTimeOut", "initialSelectionGranularity", "Lcom/larksuite/common_selection/SelectionGranularity;", "flatSelectableItems", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "getFlatSelectableItems$common_selection_release", "()Ljava/util/ArrayList;", "viewBoundsCache", "Landroidx/collection/ArrayMap;", "viewIndexCache", "isBoundsCacheDirty", "isSelectableListDirty", "childCountAtLastRebuild", "selectionManager", "Lcom/larksuite/common_selection/SelectionManager;", "getSelectionManager", "()Lcom/larksuite/common_selection/SelectionManager;", "setSelectionManager", "(Lcom/larksuite/common_selection/SelectionManager;)V", "lastTouchX", "", "lastTouchY", "dragAnchorPoint", "Lcom/larksuite/common_selection/SelectionPoint;", "disallowInterceptTouchEventRequested", "externalLongPressRunnable", "Ljava/lang/Runnable;", "gestureDetector", "Landroid/view/GestureDetector;", "initialSelection", "option", "Lcom/larksuite/common_selection/SelectionOption;", "point", "e", "Landroid/view/MotionEvent;", "sm", "onSizeChanged", "w", "h", "oldw", "oldh", "isActionDownOnHandle", "ev", "dispatchTouchEvent", "onInterceptTouchEvent", "onTouchEvent", "event", "onLayout", "changed", "left", "top", "right", "bottom", "buildFlatSelectableList", "addSelectableViewRecursively", "view", "onDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchDraw", "drawSelectionHighlight", "updateViewBoundsCache", "getHighlightPathForItem", "item", "isStart", "isEnd", "range", "Lcom/larksuite/common_selection/SelectionRange;", "outPath", "findNearestSelectionPointAt", "containerX", "containerY", "findNearestSelectionPointAt$common_selection_release", "requestDisallowInterceptTouchEvent", "disallowIntercept", "updateCachesIfNeeded", "findDirectHit", "findNextPointForDrag", "findNearestPointGlobally", "getPrecisePointInItem", "localX", "localY", "getDescendantBoundsInContainer", "descendant", "outRect", "invalidate", "setExternalLongClickListener", "timeOut", "handleLongClick", "Companion", "common-selection_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class SelectionContainer extends FrameLayout {
    public final Rect a;
    public final RectF b;
    public final Path c;
    public final Path d;
    public final int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public Function0<Unit> i;
    public int j;
    public SelectionGranularity k;
    public final ArrayList<View> l;
    public final ArrayMap<View, RectF> m;
    public final ArrayMap<View, Integer> n;
    public boolean o;
    public boolean p;
    public int q;
    public i r;
    public float s;
    public float t;
    public o u;
    public boolean v;
    public final d w;
    public final GestureDetector x;

    public static final class a implements ViewGroup.OnHierarchyChangeListener {
        public final /* synthetic */ SelectionContainer a;

        public a(SelectionContainer r1) {
            this.a = r1;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View r1, View r2) {
            SelectionContainer r3 = this.a;
            r3.p = true;
            r3.o = true;
            r3.invalidate();
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View r1, View r2) {
            SelectionContainer r3 = this.a;
            r3.p = true;
            r3.o = true;
            r3.invalidate();
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SelectionInitiationMode.values().length];
            r0[SelectionInitiationMode.SELECT_ON_CONTENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SelectionInitiationMode.SELECT_ANYWHERE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ SelectionContainer b;

        public d(Context r1, SelectionContainer r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.d("SelectionContainer", "externalLongPressRunnable, execute");     // Catch: Throwable -> L14
            com.larksuite.common_selection.a.a(this.a);     // Catch: Throwable -> L14
            Function0<Unit> r0 = this.b.i;     // Catch: Throwable -> L14
            if (r0 == null) goto L5;
            r0.invoke();     // Catch: Throwable -> L14
        L5:
            i r1 = this.b.getSelectionManager();     // Catch: Throwable -> L14
            if (r1 != null) goto L9;
            return;
        L9:
            if (r1.j == null) goto L11;
        L12:
            r1.d();     // Catch: Throwable -> L14
            return;
        L11:
            if (r1.h() == true) goto L12;
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    public static final class e extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ SelectionContainer a;

        public e(SelectionContainer r1) {
            this.a = r1;
        }

        public final boolean a(i r4) {
            if (r4.h() == true) goto L5;
        L13:
            return false;
        L5:
            if (Intrinsics.areEqual(r4.k, this.a) == false) goto L13;
            if (r4.n == null) goto L9;
            boolean r0 = true;
        L10:
            if (r0 == true) goto L13;
            this.a.u = null;
            r4.d();
            return true;
        L9:
            r0 = false;
            goto L10
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r6) {
            Intrinsics.checkNotNullParameter(r6, "e");
            i r0 = this.a.getSelectionManager();
            if (r0 != null) goto L7;
            return super.onDoubleTap(r6);
        L7:
            if (Intrinsics.areEqual(r0.k, this.a) == true) goto L9;
            o r1 = this.a.e(r6.getX(), r6.getY());
            if (r1 == null) goto L13;
            n r2 = r0.h.get(TriggerMode.DoubleTap);
            if (r2 == null) goto L17;
            this.a.getParent().requestDisallowInterceptTouchEvent(true);
            SelectionContainer.a(this.a, r2, r1, r6, r0);
            return true;
        L17:
            return super.onDoubleTap(r6);
        L13:
            return super.onDoubleTap(r6);
        L9:
            return a(r0);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r6) {
            Intrinsics.checkNotNullParameter(r6, "e");
            i r0 = this.a.getSelectionManager();
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.n == null) goto L8;
            boolean r1 = true;
        L9:
            if (r1 == false) goto L11;
            return;
        L11:
            SelectionContainer r2 = this.a;
            if (r2.v == false) goto L14;
            return;
        L14:
            o r3 = r2.e(r6.getX(), r6.getY());
            if (r3 != null) goto L17;
            return;
        L17:
            n r4 = r0.h.get(TriggerMode.LongPress);
            if (r4 != null) goto L20;
            return;
        L20:
            this.a.getParent().requestDisallowInterceptTouchEvent(true);
            SelectionContainer.a(this.a, r4, r3, r6, r0);
            return;
        L8:
            r1 = false;
            goto L9
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            i r0 = this.a.getSelectionManager();
            if (r0 != null) goto L7;
            return onSingleTapConfirmed(r2);
        L7:
            if (a(r0) == false) goto L9;
        L12:
            return true;
        L9:
            if (super.onSingleTapUp(r2) == true) goto L12;
            return false;
        }
    }

    static {
    }

    public SelectionContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SelectionContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void invalidate() {
        this.o = true;
        super.invalidate();
    }

    public final void c() {
        this.l.clear();
        this.m.clear();
        this.n.clear();
        int r0 = getChildCount();
        int r2 = r0 * 2;
        this.l.ensureCapacity(r2);
        this.m.ensureCapacity(r2);
        this.n.ensureCapacity(r2);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        View r3 = getChildAt(r1);
        Intrinsics.checkNotNull(r3);
        b(r3);
        r1 = r1 + 1;
        goto L3
    }

    public final void h() {
        this.m.clear();
        Iterator<View> r0 = this.l.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        View r1 = r0.next();
        RectF r2 = this.b;
        f(r1, r2);
        this.m.put(r1, new RectF(r2));
        goto L4
    }

    public final ArrayList<View> getFlatSelectableItems$common_selection_release() {
        return this.l;
    }

    public final i getSelectionManager() {
        return this.r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(View r3) {
        if ((r3 instanceof com.larksuite.common_selection.c) == false) goto L9;
        Iterator<View> r4 = ((com.larksuite.common_selection.c) r3).a().iterator();
    L6:
        if (r4.hasNext() == false) goto L14;
        b(r4.next());
        goto L6
    L14:
        return;
    L9:
        if ((r3 instanceof com.larksuite.common_selection.d) == true) goto L13;
        this.n.put(r3, Integer.valueOf(this.l.size()));
        this.l.add(r3);
        return;
    }

    public final void d(Canvas r17) {
        i r1 = this.r;
        if (r1 != null) goto L5;
        return;
    L5:
        p r2 = r1.j;
        if (r2 != null) goto L8;
        return;
    L8:
        View r3 = r2.a.a;
        if (r3 != null) goto L11;
    L13:
        boolean r6 = false;
    L14:
        if (r6 == true) goto L16;
        return;
    L16:
        if (r3 != null) goto L18;
        return;
    L18:
        View r7 = r2.b.a;
        if (r7 != null) goto L22;
        return;
    L22:
        if (this.o == false) goto L24;
        h();
        this.o = false;
    L24:
        int r8 = this.l.size();
        int r9 = 0;
        boolean r10 = false;
    L25:
        if (r9 >= r8) goto L50;
        View r11 = (View) ListProtector.get(this.l, r9);
        if (Intrinsics.areEqual(r11, r3) == false) goto L29;
        r10 = true;
    L29:
        if (r10 == false) goto L47;
        this.d.reset();
        boolean r12 = Intrinsics.areEqual(r11, r3);
        boolean r13 = Intrinsics.areEqual(r11, r7);
        Path r14 = this.d;
        this.c.reset();
        RectF r15 = (RectF) this.m.get(r11);
        if (r15 != null) goto L33;
        r15 = this.b;
        f(r11, r15);
    L33:
        t r16 = t.a;
        s r19 = t.a(r11);
        if (r19 != null) goto L36;
        r19 = t.c;
    L36:
        if (r12 == false) goto L38;
        int r110 = r2.a.b;
    L39:
        if (r13 == false) goto L41;
        int r111 = r2.b.b;
    L42:
        if (r110 >= r111) goto L44;
        r19.e(r11, r110, r111, this.c);
        r14.addPath(this.c, r15.left, r15.top);
    L44:
        r17.drawPath(this.d, r1.i);
        goto L47
    L41:
        r111 = r19.a(r11);
        goto L42
    L38:
        r110 = 0;
    L47:
        if (Intrinsics.areEqual(r11, r7) == false) goto L49;
        r10 = false;
    L49:
        r9 = r9 + 1;
        goto L25
    L50:
        return;
    L11:
        if (r2.b.a == null) goto L13;
        r6 = true;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        super.dispatchDraw(r3);
        i r0 = this.r;
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r0.k, this) == true) goto L8;
        return;
    L8:
        if (r0.g == DrawHighlightStyle.BACKGROUND) goto L13;
        d(r3);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        if (r3 != null) goto L6;
        return super.dispatchTouchEvent(r3);
    L6:
        if (r3.getAction() != 0) goto L10;
        this.v = false;
        this.g = false;
        this.h = true;
        boolean r4 = super.dispatchTouchEvent(r3) | true;
        this.h = false;
        return r4;
    L10:
        return super.dispatchTouchEvent(r3);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        super.onDraw(r3);
        i r0 = this.r;
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r0.k, this) == true) goto L8;
        return;
    L8:
        if (r0.g == DrawHighlightStyle.FOREGROUND) goto L13;
        d(r3);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        Log.d("SelectionContainer", "onInterceptTouchEvent: action is " + r10.getAction());
        i r0 = this.r;
        if (r0 == null) goto L5;
        int r2 = r10.getAction();
        boolean r3 = false;
        if (r2 != 0) goto L44;
        this.s = r10.getX();
        this.t = r10.getY();
        i r5 = this.r;
        if (r5 == null) goto L36;
        ly7.c r6 = r5.l;
        View r7 = null;
        if (r6 == null) goto L14;
        View r8 = r6.getView();
    L15:
        ly7.c r9 = r5.m;
        if (r9 == null) goto L18;
        r7 = r9.getView();
    L18:
        if (r8 != null) goto L20;
    L27:
        if (r7 == null) goto L36;
        if (r7.getVisibility() != 0) goto L31;
        boolean r11 = true;
    L32:
        if (r11 == false) goto L36;
        r7.getHitRect(this.a);
        if (this.a.contains((int) r10.getX(), (int) r10.getY()) == false) goto L36;
    L35:
        boolean r12 = true;
    L37:
        if (r12 == false) goto L41;
        Log.d("SelectionContainer", "isActionDownOnHandle true, action is " + r2);
        return false;
    L41:
        if (this.i == null) goto L44;
        Log.d("SelectionContainer", "try to trigger long press, action is " + r2);
        getHandler().postDelayed(this.w, (long) this.j);
        goto L44
    L31:
        r11 = false;
        goto L32
    L20:
        if (r8.getVisibility() != 0) goto L22;
        boolean r13 = true;
    L23:
        if (r13 == false) goto L27;
        r8.getHitRect(this.a);
        if (this.a.contains((int) r10.getX(), (int) r10.getY()) == false) goto L27;
    L22:
        r13 = false;
        goto L23
    L14:
        r8 = null;
    L36:
        r12 = false;
    L44:
        if (r0.n == null) goto L46;
        boolean r1 = true;
    L47:
        if (r1 == false) goto L50;
        Log.d("SelectionContainer", "sm.isHandleBeingDragged, action is " + r2);
        return true;
    L50:
        i r4 = this.r;
        if (r4 != null) goto L53;
    L55:
        boolean r14 = this.x.onTouchEvent(r10);
        if (this.f == false) goto L60;
        if (r2 != 1) goto L60;
        boolean r15 = onTouchEvent(r10);
        this.g = true;
        Log.d("SelectionContainer", "skipActionUPOnTouchEvent true, action is " + r2);
        getHandler().removeCallbacks(this.w);
        return r15;
    L60:
        if (r2 != 1) goto L62;
    L64:
        getHandler().removeCallbacks(this.w);
        if (r3 == false) goto L69;
        Log.d("SelectionContainer", "isHandleShowing, action is " + r2);
        return r14;
    L69:
        if (r2 != 2) goto L76;
        float r16 = Math.abs(r10.getX() - this.s);
        float r17 = Math.abs(r10.getY() - this.t);
        float r19 = this.e;
        if (r16 <= r19) goto L73;
    L74:
        Log.d("SelectionContainer", "deltaX or deltaY > touchSlop, action is " + r2);
        getHandler().removeCallbacks(this.w);
        goto L76
    L73:
        if (r17 > r19) goto L74;
    L76:
        return this.f;
    L62:
        if (r2 == 3) goto L64;
    L53:
        if (r4.h() != true) goto L55;
        r3 = true;
        goto L55
    L46:
        r1 = false;
        goto L47
    L5:
        return super.onInterceptTouchEvent(r10);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r19) {
        Intrinsics.checkNotNullParameter(r19, "event");
        Log.d("SelectionContainer", "onTouchEvent, called");
        final boolean r4 = false;
        if (r19.getActionMasked() == 1) goto L5;
    L8:
        final i r3 = this.r;
        if (r3 != null) goto L13;
        return super.onTouchEvent(r19);
    L13:
        if (r3.n == null) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == true) goto L18;
        this.x.onTouchEvent(r19);
    L18:
        int r7 = r19.getAction();
        if (r7 != 0) goto L21;
        String r5 = "SelectionContainer";
        this.s = r19.getX();
        this.t = r19.getY();
    L179:
        Log.d(r5, "onTouchEvent, action is " + r19.getAction() + ", result is true");
        return true;
    L21:
        if (r7 == 1) goto L116;
        if (r7 != 2) goto L25;
        float r8 = Math.abs(r19.getX() - this.s);
        float r12 = Math.abs(r19.getY() - this.t);
        float r13 = this.e;
        if (r8 <= r13) goto L30;
    L31:
        this.s = r19.getX();
        this.t = r19.getY();
        if (this.f == false) goto L63;
        o r9 = this.u;
        if (r9 != null) goto L36;
        return true;
    L36:
        o r10 = e(r19.getX(), r19.getY());
        if (r10 != null) goto L39;
        return true;
    L39:
        Integer r11 = (Integer) this.n.get(r9.a);
        int r14 = -1;
        if (r11 == null) goto L42;
        int r15 = r11.intValue();
    L43:
        Integer r16 = (Integer) this.n.get(r10.a);
        if (r16 == null) goto L46;
        r14 = r16.intValue();
    L46:
        if (r15 > r14) goto L51;
        if (r15 == r14) goto L50;
    L52:
        boolean r17 = false;
    L53:
        if (r17 == false) goto L55;
        r10 = r9;
        r9 = r10;
    L55:
        r3.n(r9, r10);
        final SelectionContainer r20 = r3.k;
        if (r20 != null) goto L59;
    L62:
        r3.j(r19);
        Log.d("SelectionContainer", "MotionEvent.ACTION_MOVE, dx dy is " + r8 + ", " + r12 + ", handler.removeCallbacks(externalLongPressRunnable)");
        getHandler().removeCallbacks(this.w);
    L26:
        String r110 = "SelectionContainer";
    L114:
        r5 = r110;
        goto L179
    L59:
        if (r3.q == false) goto L61;
        r20.post(new l(r3, false));
        goto L62
    L61:
        r20.post(new SelectionManager$showHandles$2(r3, r20, r4));
        goto L62
    L50:
        if (r9.b <= r10.b) goto L52;
    L51:
        r17 = true;
        goto L53
    L42:
        r15 = -1;
        goto L43
    L63:
        if (r6 == false) goto L26;
        float r21 = r19.getRawX();
        float r22 = r19.getRawY();
        p r111 = r3.j;
        if (r111 == null) goto L84;
        SelectionContainer r112 = r3.k;
        if (r112 == null) goto L84;
        SelectionHandleType r113 = r3.n;
        if (r113 == null) goto L84;
        SelectionHandleType r23 = SelectionHandleType.START;
        if (r113 != r23) goto L77;
        ly7.c r24 = r3.l;
    L80:
        if (r24 == null) goto L84;
        Point r25 = r24.h(r21, r22);
        int r26 = r25.x;
        int r27 = r25.y;
        int[] r114 = new int[2];
        r112.getLocationOnScreen(r114);
        float r29 = r26 - r114[0];
        float r30 = r27 - r114[1];
        o r31 = r112.e(r29, r30);
        if (r31 == null) goto L84;
        r110 = "SelectionContainer";
        Log.d("SelectionManager", "handleDrag: " + r29 + ", " + r30 + ", point: " + r31);
        o r2 = r111.a;
        o r115 = r111.b;
        if (r113 == r23) goto L89;
        r115 = r31;
        r31 = r2;
    L89:
        ArrayList<View> r32 = r112.getFlatSelectableItems$common_selection_release();
        int r116 = CollectionsKt.indexOf(r32, r31.a);
        int r33 = CollectionsKt.indexOf(r32, r115.a);
        if (r116 < 0) goto L105;
        if (r33 < 0) goto L105;
        if (r116 > r33) goto L96;
        if (r116 != r33) goto L105;
        if (r31.b <= r115.b) goto L105;
    L96:
        if (r113 != r23) goto L98;
        r23 = SelectionHandleType.END;
    L98:
        r3.n = r23;
        if (r23 != null) goto L104;
        com.larksuite.common_selection.b r34 = r3.s;
        if (r34 == null) goto L103;
        r34.a.dismiss();
    L103:
        r3.s = null;
    L104:
        o r117 = r115;
        r115 = r31;
        r31 = r117;
    L105:
        r3.j = new p(r31, r115);
        r3.i();
        r112.invalidate();
        r3.m();
        if (r3.f == true) goto L108;
    L110:
        float r35 = r24.getOffsetForMagnifier();
        com.larksuite.common_selection.b r36 = r3.s;
        if (r36 == null) goto L113;
        r36.a.a(r29, r30 - r35);
    L113:
        r3.j(r19);
        goto L114
    L108:
        if (r3.s != null) goto L110;
        r3.s = new com.larksuite.common_selection.b(r112);
        goto L110
    L77:
        if (r113 != SelectionHandleType.END) goto L79;
        r24 = r3.m;
        goto L80
    L79:
        r24 = null;
    L84:
        r110 = "SelectionContainer";
        goto L113
    L30:
        if (r12 <= r13) goto L26;
    L25:
        if (r7 != 3) goto L26;
    L116:
        if (this.f == false) goto L167;
        this.f = false;
        this.u = null;
        getParent().requestDisallowInterceptTouchEvent(false);
        SelectionGranularity r37 = this.k;
        if (r37 != null) goto L120;
        r37 = SelectionGranularity.WORD;
    L120:
        Intrinsics.checkNotNullParameter(r37, "granularity");
        p r38 = r3.j;
        if (r38 != null) goto L124;
        Log.e("SelectionManager", "expandSelectionIfCollapsed: current range is null");
    L159:
        r5 = "SelectionContainer";
        Log.d(r5, "onTouchEvent, action is " + r19.getAction() + ", selectionRange is " + r3.j);
        final SelectionContainer r39 = r3.k;
        if (r39 != null) goto L163;
    L166:
        r3.j(r19);
    L177:
        Log.d(r5, "MotionEvent.ACTION_UP or MotionEvent.ACTION_CANCEL, is not isInitialDragSelect and is not handle drag, handler.removeCallbacks(externalLongPressRunnable)");
        getHandler().removeCallbacks(this.w);
        goto L179
    L163:
        if (r3.q == false) goto L165;
        r39.post(new l(r3, true));
        goto L166
    L165:
        final boolean r40 = true;
        r39.post(new SelectionManager$showHandles$2(r3, r39, r40));
        goto L166
    L124:
        if (Intrinsics.areEqual(r38.a.a, r38.b.a) == true) goto L126;
    L128:
        boolean r41 = false;
    L129:
        if (r41 == false) goto L159;
        o r42 = r38.a;
        View r43 = r42.a;
        if (r43 == null) goto L159;
        if (r37 != SelectionGranularity.ALL) goto L152;
        SelectionContainer r44 = r3.k;
        if (r44 == null) goto L139;
        ArrayList<View> r45 = r44.getFlatSelectableItems$common_selection_release();
    L140:
        if (r45 != null) goto L142;
    L145:
        boolean r46 = true;
    L146:
        if (r46 == true) goto L159;
        o r47 = new o((View) CollectionsKt.first(r45), 0);
        View r48 = (View) CollectionsKt.last(r45);
        t r49 = t.a;
        s r50 = t.a(r48);
        if (r50 != null) goto L151;
        r50 = t.c;
    L151:
        p r51 = new p(r47, new o(r48, r50.a(r48)));
    L156:
        if (r51 == null) goto L158;
        r3.n(r51.a, r51.b);
    L158:
        r3.k();
        goto L159
    L142:
        if (r45.isEmpty() == true) goto L145;
        r46 = false;
        goto L146
    L139:
        r45 = null;
        goto L140
    L152:
        t r52 = t.a;
        s r53 = t.a(r43);
        if (r53 == null) goto L159;
        r51 = r53.b(r43, r42, r37);
        goto L156
    L126:
        if (r38.a.b != r38.b.b) goto L128;
        r41 = true;
        goto L129
    L167:
        r5 = "SelectionContainer";
        if (r6 == false) goto L177;
        r3.n = null;
        com.larksuite.common_selection.b r54 = r3.s;
        if (r54 == null) goto L172;
        r54.a.dismiss();
    L172:
        r3.s = null;
        getParent().requestDisallowInterceptTouchEvent(false);
        SelectionContainer r55 = r3.k;
        if (r55 == null) goto L176;
        r55.post(new m(r3));
    L176:
        r3.j(r19);
        Log.d(r5, "onTouchEvent: isHandleDrag");
        goto L177
    L15:
        r6 = false;
        goto L16
    L5:
        if (this.g == false) goto L8;
        this.g = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r3) {
        Log.d("SelectionContainer", "requestDisallowInterceptTouchEvent called");
        getParent().requestDisallowInterceptTouchEvent(r3);
        if (this.h == true) goto L6;
        this.v = true;
        return;
    }

    public final void setSelectionManager(i r1) {
        this.r = r1;
    }

    public final o e(float r11, float r12) {
        boolean r1 = false;
        if (this.p == false) goto L6;
        c();
        this.p = false;
    L6:
        if (this.o == false) goto L8;
        h();
        this.o = false;
    L8:
        Iterator<View> r0 = this.l.iterator();
    L9:
        o r3 = null;
        if (r0.hasNext() == false) goto L16;
        View r2 = r0.next();
        RectF r4 = (RectF) this.m.get(r2);
        if (r4 == null) goto L9;
        if (r4.contains(r11, r12) == false) goto L9;
        o r5 = g(r2, r11 - r4.left, r12 - r4.top);
    L17:
        if (r5 != null) goto L96;
        i r6 = this.r;
        if (r6 == null) goto L68;
        SelectionHandleType r7 = r6.n;
        if (r7 == null) goto L24;
        boolean r8 = true;
    L25:
        if (r8 == false) goto L27;
    L28:
        r1 = true;
    L29:
        if (r1 == false) goto L68;
        if (this.f == false) goto L35;
        o r9 = this.u;
    L43:
        if (r9 == null) goto L68;
        View r10 = r9.a;
        if (r10 == null) goto L68;
        Integer r13 = (Integer) this.n.get(r10);
        if (r13 == null) goto L68;
        int r14 = r13.intValue();
        RectF r15 = (RectF) this.m.get(r10);
        if (r15 == null) goto L68;
        if (r14 <= 0) goto L61;
        View r16 = (View) ListProtector.get(this.l, r14 - 1);
        RectF r17 = (RectF) this.m.get(r16);
        if (r17 == null) goto L61;
        if (r12 >= ((r15.top + r17.bottom) / 2)) goto L61;
        o r19 = g(r16, r11 - r17.left, r12 - r17.top);
    L69:
        if (r19 != null) goto L97;
        Iterator<View> r20 = this.l.iterator();
        float r21 = Float.MAX_VALUE;
    L72:
        if (r20.hasNext() == false) goto L82;
        View r22 = r20.next();
        RectF r23 = (RectF) this.m.get(r22);
        if (r23 == null) goto L72;
        float r24 = r11 - r23.left;
        float r25 = r12 - r23.top;
        o r26 = g(r22, r24, r25);
        t r27 = t.a;
        s r29 = t.a(r22);
        if (r29 != null) goto L78;
        r29 = t.c;
    L78:
        float r30 = r29.f(r22, r24, r25, r26);
        if (r30 >= r21) goto L72;
        r21 = r30;
        r3 = r26;
        goto L72
    L82:
        return r3;
    L97:
        return r19;
    L61:
        if (r14 >= (this.l.size() - 1)) goto L67;
        View r31 = (View) ListProtector.get(this.l, r14 + 1);
        RectF r32 = (RectF) this.m.get(r31);
        if (r32 == null) goto L67;
        float r33 = r15.bottom;
        float r34 = r32.top;
        if (r12 <= ((r33 + r34) / 2)) goto L67;
        r19 = g(r31, r11 - r32.left, r12 - r34);
    L67:
        r19 = g(r10, r11 - r15.left, r12 - r15.top);
        goto L69
    L35:
        if (r7 != SelectionHandleType.START) goto L39;
        p r35 = r6.j;
        if (r35 == null) goto L42;
        r9 = r35.a;
    L42:
        r9 = null;
        goto L43
    L39:
        p r36 = r6.j;
        if (r36 == null) goto L42;
        r9 = r36.b;
        goto L43
    L27:
        if (this.f == false) goto L29;
    L24:
        r8 = false;
    L68:
        r19 = null;
        goto L69
    L96:
        return r5;
    L16:
        r5 = null;
        goto L17
    }

    public final void f(View r5, RectF r6) {
        float r0 = 0.0f;
        View r2 = r5;
        float r1 = 0.0f;
    L4:
        if (Intrinsics.areEqual(r2, this) == true) goto L8;
        if ((r2.getParent() instanceof View) == false) goto L8;
        r0 = r0 + r2.getLeft();
        r1 = r1 + r2.getTop();
        Object r3 = r2.getParent();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.View");
        r2 = (View) r3;
    L8:
        r6.set(r0, r1, r5.getWidth() + r0, r5.getHeight() + r1);
    }

    public SelectionContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new Rect();
        this.b = new RectF();
        this.c = new Path();
        this.d = new Path();
        int r5 = v.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        Resources r6 = r2.getResources();
        this.e = MathKt.roundToInt(WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).density * 2.0f);
        this.j = ViewConfiguration.getLongPressTimeout();
        this.l = new ArrayList(20);
        this.m = new ArrayMap(20);
        this.n = new ArrayMap(20);
        this.o = true;
        this.p = true;
        this.w = new d(r2, this);
        this.x = new GestureDetector(r2, new e(this));
        setWillNotDraw(false);
        setOnHierarchyChangeListener(new a(this));
    }

    public static o g(View r1, float r2, float r3) {
        t r0 = t.a;
        s r4 = t.a(r1);
        if (r4 != null) goto L6;
        r4 = t.c;
    L6:
        return r4.g(r1, r2, r3);
    }

    public /* synthetic */ SelectionContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.o = true;
    }

    public static final void a(SelectionContainer r5, n r6, o r7, MotionEvent r8, i r9) {
        r5.getClass();
        SelectionInitiationMode r0 = r6.b;
        int r1 = c.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        View r2 = r7.a;
        if (r2 == null) goto L24;
        RectF r3 = (RectF) r5.m.get(r2);
        if (r3 != null) goto L15;
        r3 = new RectF();
        r5.f(r2, r3);
    L15:
        float r4 = r8.getX() - r3.left;
        float r10 = r8.getY() - r3.top;
        t r11 = t.a;
        s r12 = t.a(r2);
        if (r12 != null) goto L19;
        r12 = t.c;
    L19:
        if (r12.i(r2, r4, r10) == false) goto L23;
        r5.f = true;
        r5.k = r6.a;
        r5.u = new o(r7.a, r7.b);
        r9.l(r5, r7);
        return;
    L23:
        return;
    L24:
        return;
    L5:
        if (r1 != 2) goto L8;
        r5.f = true;
        r5.k = r6.a;
        r5.u = new o(r7.a, r7.b);
        r9.l(r5, r7);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        this.o = true;
        int r6 = getChildCount();
        if (this.q == r6) goto L5;
    L6:
        c();
        this.q = r6;
        this.p = false;
    L7:
        i r7 = this.r;
        if (r7 == null) goto L10;
        SelectionContainer r8 = r7.k;
    L12:
        if (Intrinsics.areEqual(r8, this) == true) goto L14;
        return;
    L14:
        if (r7.p.getAndSet(true) == true) goto L21;
        SelectionContainer r9 = r7.k;
        if (r9 == null) goto L22;
        r9.post(new k(r7));
        return;
    L22:
        return;
    L21:
        return;
    L10:
        r8 = null;
        goto L12
    L5:
        if (this.p == false) goto L7;
        goto L6
    }
}
