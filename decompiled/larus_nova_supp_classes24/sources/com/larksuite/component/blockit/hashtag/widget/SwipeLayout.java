package com.larksuite.component.blockit.hashtag.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class SwipeLayout extends FrameLayout {
    public static final DragEdge B = null;
    public final GestureDetector A;
    public View.OnClickListener a;
    public View.OnLongClickListener b;
    public final int c;
    public DragEdge d;
    public final ViewDragHelper e;
    public int f;
    public final LinkedHashMap<DragEdge, View> g;
    public ShowMode h;
    public final float[] i;
    public final List<j> j;
    public final List<h> k;
    public final Map<View, ArrayList<g>> l;
    public final Map<View, Boolean> m;
    public final Map<View, Rect> n;
    public boolean o;
    public final boolean[] p;
    public boolean q;
    public float r;
    public float s;
    public int t;
    public boolean u;
    public List<f> v;
    public boolean w;
    public float x;
    public float y;
    public Rect z;

    public static final enum DragEdge extends Enum<DragEdge> {
        public static final DragEdge Bottom = null;
        public static final DragEdge Left = null;
        public static final DragEdge Right = null;
        public static final DragEdge Top = null;
        public static final /* synthetic */ DragEdge[] a = null;

        static {
            DragEdge r0 = new DragEdge("Left", 0);
            Left = r0;
            DragEdge r1 = new DragEdge("Top", 1);
            Top = r1;
            DragEdge r3 = new DragEdge("Right", 2);
            Right = r3;
            DragEdge r5 = new DragEdge("Bottom", 3);
            Bottom = r5;
            a = new DragEdge[]{r0, r1, r3, r5};
        }

        public static DragEdge[] values() {
            return (DragEdge[]) a.clone();
        }

        public static DragEdge valueOf(String r1) {
            return (DragEdge) r27.a.a(DragEdge.class, r1);
        }

        public DragEdge(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum ShowMode extends Enum<ShowMode> {
        public static final ShowMode LayDown = null;
        public static final ShowMode PullOut = null;
        public static final /* synthetic */ ShowMode[] a = null;

        static {
            ShowMode r0 = new ShowMode("LayDown", 0);
            LayDown = r0;
            ShowMode r1 = new ShowMode("PullOut", 1);
            PullOut = r1;
            a = new ShowMode[]{r0, r1};
        }

        public static ShowMode[] values() {
            return (ShowMode[]) a.clone();
        }

        public static ShowMode valueOf(String r1) {
            return (ShowMode) r27.a.a(ShowMode.class, r1);
        }

        public ShowMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum Status extends Enum<Status> {
        public static final Status Close = null;
        public static final Status Middle = null;
        public static final Status Open = null;
        public static final /* synthetic */ Status[] a = null;

        static {
            Status r0 = new Status("Middle", 0);
            Middle = r0;
            Status r1 = new Status("Open", 1);
            Open = r1;
            Status r3 = new Status("Close", 2);
            Close = r3;
            a = new Status[]{r0, r1, r3};
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a extends ViewDragHelper.Callback {
        public boolean a;
        public final /* synthetic */ SwipeLayout b;

        public a(SwipeLayout r1) {
            this.b = r1;
            this.a = true;
        }

        public final int getViewHorizontalDragRange(View r2) {
            Log.d("SwipeLayout", "getViewHorizontalDragRange  mDragDistance=" + this.b.f);
            return this.b.f;
        }

        public final int getViewVerticalDragRange(View r1) {
            return this.b.f;
        }

        public final boolean tryCaptureView(View r4, int r5) {
            boolean r0 = false;
            if (r4 != this.b.getSurfaceView()) goto L5;
        L8:
            boolean r6 = true;
        L9:
            if (r6 == true) goto L11;
        L14:
            return r6;
        L11:
            if (this.b.getOpenStatus() != Status.Close) goto L13;
            r0 = true;
        L13:
            this.a = r0;
            goto L14
        L5:
            if (this.b.getBottomViews().contains(r4) == true) goto L8;
            r6 = false;
            goto L9
        }

        public final int clampViewPositionHorizontal(View r6, int r7, int r8) {
            if (r6 != this.b.getSurfaceView()) goto L30;
            Log.d("SwipeLayout", "clampViewPositionHorizontal child == getSurfaceView()");
            int r9 = d.a[this.b.d.ordinal()];
            if (r9 == 1) goto L28;
            if (r9 == 2) goto L28;
            if (r9 == 3) goto L19;
            if (r9 != 4) goto L51;
            Log.d("SwipeLayout", "clampViewPositionHorizontal Left: left=" + r7);
            Log.d("SwipeLayout", "clampViewPositionHorizontal Right: getPaddingLeft()=" + this.b.getPaddingLeft());
            Log.d("SwipeLayout", "clampViewPositionHorizontal Right: mDragDistance=" + this.b.f);
            Log.d("SwipeLayout", "clampViewPositionHorizontal Right: getPaddingLeft() - mDragDistance=" + (this.b.getPaddingLeft() - this.b.f));
            if (r7 > this.b.getPaddingLeft()) goto L14;
            int r10 = this.b.getPaddingLeft();
            SwipeLayout r11 = this.b;
            if (r7 >= (r10 - r11.f)) goto L51;
            return r11.getPaddingLeft() - this.b.f;
        L14:
            return this.b.getPaddingLeft();
        L51:
            return r7;
        L19:
            Log.d("SwipeLayout", "clampViewPositionHorizontal Left: left=" + r7);
            Log.d("SwipeLayout", "clampViewPositionHorizontal Left: mDragDistance=" + this.b.f);
            Log.d("SwipeLayout", "clampViewPositionHorizontal Left: getPaddingLeft()=" + this.b.getPaddingLeft());
            if (r7 < this.b.getPaddingLeft()) goto L22;
            int r12 = this.b.getPaddingLeft();
            SwipeLayout r13 = this.b;
            if (r7 <= (r12 + r13.f)) goto L51;
            return r13.getPaddingLeft() + this.b.f;
        L22:
            return this.b.getPaddingLeft();
        L28:
            return this.b.getPaddingLeft();
        L30:
            if (this.b.getCurrentBottomView() != r6) goto L51;
            Log.d("SwipeLayout", "clampViewPositionHorizontal  getCurrentBottomView() == child");
            int r14 = d.a[this.b.d.ordinal()];
            if (r14 == 1) goto L50;
            if (r14 == 2) goto L50;
            if (r14 == 3) goto L43;
            if (r14 != 4) goto L51;
            SwipeLayout r15 = this.b;
            if (r15.h != ShowMode.PullOut) goto L51;
            int r16 = r15.getMeasuredWidth();
            SwipeLayout r17 = this.b;
            if (r7 >= (r16 - r17.f)) goto L51;
            return r17.getMeasuredWidth() - this.b.f;
        L43:
            SwipeLayout r19 = this.b;
            if (r19.h != ShowMode.PullOut) goto L51;
            if (r7 <= r19.getPaddingLeft()) goto L51;
            return this.b.getPaddingLeft();
        L50:
            return this.b.getPaddingLeft();
        }

        public final int clampViewPositionVertical(View r7, int r8, int r9) {
            if (r7 != this.b.getSurfaceView()) goto L28;
            int r10 = d.a[this.b.d.ordinal()];
            if (r10 == 1) goto L21;
            if (r10 == 2) goto L12;
            if (r10 == 3) goto L11;
            if (r10 == 4) goto L11;
        L68:
            return r8;
        L11:
            return this.b.getPaddingTop();
        L12:
            int r11 = this.b.getPaddingTop();
            SwipeLayout r12 = this.b;
            if (r8 >= (r11 - r12.f)) goto L17;
            return r12.getPaddingTop() - this.b.f;
        L17:
            if (r8 <= r12.getPaddingTop()) goto L68;
            return this.b.getPaddingTop();
        L21:
            if (r8 < this.b.getPaddingTop()) goto L23;
            int r13 = this.b.getPaddingTop();
            SwipeLayout r14 = this.b;
            if (r8 <= (r13 + r14.f)) goto L68;
            return r14.getPaddingTop() + this.b.f;
        L23:
            return this.b.getPaddingTop();
        L28:
            View r15 = this.b.getSurfaceView();
            if (r15 != null) goto L31;
            int r16 = 0;
        L32:
            int r0 = d.a[this.b.d.ordinal()];
            if (r0 == 1) goto L54;
            if (r0 == 2) goto L40;
            if (r0 == 3) goto L39;
            if (r0 != 4) goto L68;
        L39:
            return this.b.getPaddingTop();
        L40:
            SwipeLayout r1 = this.b;
            if (r1.h != ShowMode.PullOut) goto L46;
            int r17 = r1.getMeasuredHeight();
            SwipeLayout r19 = this.b;
            if (r8 >= (r17 - r19.f)) goto L68;
            return r19.getMeasuredHeight() - this.b.f;
        L46:
            int r20 = r16 + r9;
            if (r20 >= r1.getPaddingTop()) goto L49;
            int r21 = this.b.getPaddingTop();
            SwipeLayout r2 = this.b;
            if (r20 > (r21 - r2.f)) goto L68;
            return r2.getPaddingTop() - this.b.f;
        L49:
            return this.b.getPaddingTop();
        L54:
            SwipeLayout r3 = this.b;
            if (r3.h == ShowMode.PullOut) goto L57;
            int r22 = r16 + r9;
            if (r22 < r3.getPaddingTop()) goto L63;
            int r23 = this.b.getPaddingTop();
            SwipeLayout r4 = this.b;
            if (r22 <= (r23 + r4.f)) goto L68;
            return r4.getPaddingTop() + this.b.f;
        L63:
            return this.b.getPaddingTop();
        L57:
            if (r8 <= r3.getPaddingTop()) goto L68;
            return this.b.getPaddingTop();
        L31:
            r16 = r15.getTop();
            goto L32
        }

        public final void onViewReleased(View r7, float r8, float r9) {
            super.onViewReleased(r7, r8, r9);
            SwipeLayout r10 = this.b;
            boolean r0 = this.a;
            float r1 = r10.e.getMinVelocity();
            View r2 = r10.getSurfaceView();
            DragEdge r3 = r10.d;
            if (r3 == null) goto L57;
            if (r2 == null) goto L57;
            if (r0 == false) goto L8;
            float r4 = r10.s;
        L10:
            if (r3 != DragEdge.Left) goto L22;
            if (r8 <= r1) goto L15;
            r10.i(true, true);
            goto L57
        L15:
            if (r8 >= (-r1)) goto L18;
            r10.b(true, true);
            goto L57
        L18:
            if (((r10.getSurfaceView().getLeft() * 1.0f) / r10.f) <= r4) goto L20;
            r10.i(true, true);
            goto L57
        L20:
            r10.b(true, true);
            goto L57
        L22:
            if (r3 != DragEdge.Right) goto L34;
            if (r8 <= r1) goto L27;
            r10.b(true, true);
            goto L57
        L27:
            if (r8 >= (-r1)) goto L30;
            r10.i(true, true);
            goto L57
        L30:
            if ((((-r10.getSurfaceView().getLeft()) * 1.0f) / r10.f) <= r4) goto L32;
            r10.i(true, true);
            goto L57
        L32:
            r10.b(true, true);
            goto L57
        L34:
            if (r3 != DragEdge.Top) goto L46;
            if (r9 <= r1) goto L39;
            r10.i(true, true);
            goto L57
        L39:
            if (r9 >= (-r1)) goto L42;
            r10.b(true, true);
            goto L57
        L42:
            if (((r10.getSurfaceView().getTop() * 1.0f) / r10.f) <= r4) goto L44;
            r10.i(true, true);
            goto L57
        L44:
            r10.b(true, true);
            goto L57
        L46:
            if (r3 != DragEdge.Bottom) goto L57;
            if (r9 <= r1) goto L51;
            r10.b(true, true);
            goto L57
        L51:
            if (r9 >= (-r1)) goto L54;
            r10.i(true, true);
            goto L57
        L54:
            if ((((-r10.getSurfaceView().getTop()) * 1.0f) / r10.f) <= r4) goto L56;
            r10.i(true, true);
            goto L57
        L56:
            r10.b(true, true);
            goto L57
        L8:
            r4 = r10.r;
        L57:
            Iterator r11 = ((ArrayList) this.b.j).iterator();
        L59:
            if (r11.hasNext() == false) goto L61;
            ((j) r11.next()).b();
            goto L59
        L61:
            this.b.invalidate();
        }

        public final void onViewPositionChanged(View r17, int r19, int r110, int r20, int r21) {
            View r4 = this.b.getSurfaceView();
            if (r4 != null) goto L5;
            return;
        L5:
            View r5 = this.b.getCurrentBottomView();
            int r6 = r4.getLeft();
            int r7 = r4.getRight();
            int r8 = r4.getTop();
            int r9 = r4.getBottom();
            if (r17 != r4) goto L18;
            SwipeLayout r1 = this.b;
            if (r1.h != ShowMode.PullOut) goto L59;
            if (r5 == null) goto L59;
            DragEdge r2 = r1.d;
            if (r2 != DragEdge.Left) goto L13;
        L16:
            r5.offsetLeftAndRight(r20);
            goto L59
        L13:
            if (r2 == DragEdge.Right) goto L16;
            r5.offsetTopAndBottom(r21);
        L59:
            this.b.e(r6, r8, r7, r9);
            this.b.f(r6, r8, r20, r21);
            this.b.invalidate();
            SwipeLayout r3 = this.b;
            if (r3.u == false) goto L75;
            View r10 = r3.getCurrentBottomView();
            if (r3.getOpenStatus() != Status.Close) goto L65;
            ((HashMap) r3.n).remove(r10);
            return;
        L65:
            int r11 = 0;
            View[] r12 = {r3.getSurfaceView(), r10};
        L66:
            if (r11 >= 2) goto L76;
            View r13 = r12[r11];
            Rect r14 = (Rect) ((HashMap) r3.n).get(r13);
            if (r14 != null) goto L70;
            r14 = new Rect();
            ((HashMap) r3.n).put(r13, r14);
        L70:
            r14.left = r13.getLeft();
            r14.top = r13.getTop();
            r14.right = r13.getRight();
            r14.bottom = r13.getBottom();
            r11 = r11 + 1;
            goto L66
        L76:
            return;
        L75:
            return;
        L18:
            if (this.b.getBottomViews().contains(r17) == false) goto L59;
            SwipeLayout r15 = this.b;
            if (r15.h != ShowMode.PullOut) goto L22;
            r4.offsetLeftAndRight(r20);
            r4.offsetTopAndBottom(r21);
            goto L59
        L22:
            DragEdge r16 = r15.d;
            int r111 = r15.getPaddingLeft();
            int r112 = r15.getPaddingTop();
            DragEdge r113 = DragEdge.Right;
            if (r16 != r113) goto L26;
            r111 = r15.getMeasuredWidth() - r15.f;
        L28:
            DragEdge r114 = DragEdge.Left;
            if (r16 == r114) goto L33;
            if (r16 == r113) goto L33;
            int r115 = r15.getMeasuredWidth() + r111;
            int r22 = r15.f;
        L34:
            Log.d("SwipeLayout", "computeBottomLayDown bl=" + r111 + ";br=" + r115);
            Rect r23 = new Rect(r111, r112, r115, r22 + r112);
            if (r5 == null) goto L37;
            r5.layout(r23.left, r23.top, r23.right, r23.bottom);
        L37:
            int r24 = r4.getLeft() + r20;
            int r25 = r4.getTop() + r21;
            SwipeLayout r26 = this.b;
            if (r26.d == r114) goto L40;
        L42:
            SwipeLayout r27 = this.b;
            if (r27.d == r113) goto L45;
        L47:
            SwipeLayout r29 = this.b;
            if (r29.d == DragEdge.Top) goto L50;
        L52:
            SwipeLayout r30 = this.b;
            if (r30.d == DragEdge.Bottom) goto L55;
        L57:
            r4.layout(r24, r25, this.b.getMeasuredWidth() + r24, this.b.getMeasuredHeight() + r25);
            goto L59
        L55:
            if (r25 <= r30.getPaddingTop()) goto L57;
            r25 = this.b.getPaddingTop();
            goto L57
        L50:
            if (r25 >= r29.getPaddingTop()) goto L52;
            r25 = this.b.getPaddingTop();
            goto L57
        L45:
            if (r24 <= r27.getPaddingLeft()) goto L47;
            r24 = this.b.getPaddingLeft();
            goto L57
        L40:
            if (r24 >= r26.getPaddingLeft()) goto L42;
            r24 = this.b.getPaddingLeft();
        L33:
            r115 = r15.f + r111;
            r22 = r15.getMeasuredHeight();
            goto L34
        L26:
            if (r16 != DragEdge.Bottom) goto L28;
            r112 = r15.getMeasuredHeight() - r15.f;
            goto L28
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ SwipeLayout a;

        public b(SwipeLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            SwipeLayout r6 = this.a;
            DragEdge r0 = SwipeLayout.B;
            if (r6.getOpenStatus() != Status.Close) goto L13;
            ViewParent r1 = r6.getParent();
            if ((r1 instanceof AdapterView) == false) goto L11;
            AdapterView r2 = (AdapterView) r1;
            int r7 = r2.getPositionForView(r6);
            if (r7 == (-1)) goto L12;
            r2.performItemClick(r2.getChildAt(r7 - r2.getFirstVisiblePosition()), r7, r2.getAdapter().getItemId(r7));
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public class c implements View.OnLongClickListener {
        public final /* synthetic */ SwipeLayout a;

        public c(SwipeLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r13) {
            SwipeLayout r2 = this.a;
            DragEdge r14 = SwipeLayout.B;
            if (r2.getOpenStatus() != Status.Close) goto L20;
            ViewParent r15 = r2.getParent();
            if ((r15 instanceof AdapterView) == false) goto L20;
            AdapterView<?> r16 = (AdapterView) r15;
            int r3 = r16.getPositionForView(r2);
            if (r3 == (-1)) goto L20;
            long r4 = r16.getItemIdAtPosition(r3);
            Method r0 = AbsListView.class.getDeclaredMethod("performLongPress", new Class[]{View.class, Integer.TYPE, Long.TYPE});     // Catch: Exception -> L13
            r0.setAccessible(true);     // Catch: Exception -> L13
            ((Boolean) r0.invoke(r16, new Object[]{r2, Integer.valueOf(r3), Long.valueOf(r4)})).booleanValue();     // Catch: Exception -> L13
        L13:
            e = move-exception;
            e.printStackTrace();
            if (r16.getOnItemLongClickListener() == null) goto L17;
            boolean r1 = r16.getOnItemLongClickListener().onItemLongClick(r16, r2, r3, r4);
        L18:
            if (r1 == false) goto L20;
            r16.performHapticFeedback(0);
            goto L20
        L17:
            r1 = false;
        L20:
            return true;
        }
    }

    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DragEdge.values().length];
            a = r0;
            r0[DragEdge.Top.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[DragEdge.Bottom.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[DragEdge.Left.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[DragEdge.Right.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public interface e {
    }

    public interface f {
        void a(SwipeLayout r1);
    }

    public interface g {
        void a();
    }

    public interface h {
        boolean a();
    }

    public class i extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ SwipeLayout a;

        public i(SwipeLayout r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r2) {
            SwipeLayout r3 = this.a;
            DragEdge r0 = SwipeLayout.B;
            r3.getClass();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r3) {
            SwipeLayout r0 = this.a;
            if (r0.q == false) goto L8;
            if (r0.h(r3) == false) goto L8;
            this.a.b(true, true);
        L8:
            return super.onSingleTapUp(r3);
        }
    }

    public interface j {
        void a();

        void b();

        void c(SwipeLayout r1);

        void d(SwipeLayout r1);

        void onClose();

        void onUpdate(int r1);
    }

    public void setOnDoubleClickListener(e r1) {
    }

    static {
        B = DragEdge.Right;
    }

    private float getCurrentOffset() {
        DragEdge r0 = this.d;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return this.i[r0.ordinal()];
    }

    public List<View> getBottomViews() {
        ArrayList r0 = new ArrayList();
        DragEdge[] r1 = DragEdge.values();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        DragEdge r4 = r1[r3];
        r0.add(this.g.get(r4));
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    public List<DragEdge> getDragEdges() {
        return new ArrayList(this.g.keySet());
    }

    private AdapterView getAdapterView() {
        ViewParent r0 = getParent();
        if ((r0 instanceof AdapterView) == true) goto L5;
        return null;
    L5:
        return (AdapterView) r0;
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.e.continueSettling(true) == false) goto L6;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public View getCurrentBottomView() {
        List<View> r0 = getBottomViews();
        if (this.d.ordinal() < r0.size()) goto L5;
        return null;
    L5:
        return (View) ListProtector.get(r0, this.d.ordinal());
    }

    public Status getOpenStatus() {
        View r0 = getSurfaceView();
        if (r0 == null) goto L5;
        int r1 = r0.getLeft();
        int r2 = r0.getTop();
        if (r1 != getPaddingLeft()) goto L13;
        if (r2 != getPaddingTop()) goto L13;
        return Status.Close;
    L13:
        if (r1 == (getPaddingLeft() - this.f)) goto L24;
        if (r1 == (getPaddingLeft() + this.f)) goto L24;
        if (r2 == (getPaddingTop() - this.f)) goto L24;
        if (r2 == (getPaddingTop() + this.f)) goto L24;
        return Status.Middle;
    L24:
        return Status.Open;
    L5:
        return Status.Close;
    }

    public View getSurfaceView() {
        if (getChildCount() != 0) goto L7;
        return null;
    L7:
        return getChildAt(getChildCount() - 1);
    }

    public final void j() {
        Status r0 = getOpenStatus();
        List<View> r1 = getBottomViews();
        if (r0 != Status.Close) goto L12;
        Iterator<View> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L27;
        View r3 = r2.next();
        if (r3 == null) goto L6;
        if (r3.getVisibility() == 4) goto L6;
        r3.setVisibility(4);
        goto L6
    L27:
        return;
    L12:
        View r4 = getCurrentBottomView();
        if (r4 != null) goto L15;
        return;
    L15:
        if (r4.getVisibility() == 0) goto L26;
        r4.setVisibility(0);
        return;
    }

    public final void k() {
        View r0 = getCurrentBottomView();
        if (r0 == null) goto L12;
        DragEdge r2 = this.d;
        if (r2 != DragEdge.Left) goto L7;
    L10:
        this.f = r0.getMeasuredWidth() - g(getCurrentOffset());
    L11:
        Log.d("SwipeLayout", "mDragDistance = " + this.f);
        goto L12
    L7:
        if (r2 == DragEdge.Right) goto L10;
        this.f = r0.getMeasuredHeight() - g(getCurrentOffset());
    L12:
        ShowMode r1 = this.h;
        ShowMode r3 = ShowMode.PullOut;
        Rect r4 = null;
        if (r1 != r3) goto L29;
        View r5 = getSurfaceView();
        if (this.u == false) goto L17;
        Rect r6 = (Rect) ((HashMap) this.n).get(r5);
    L18:
        if (r6 != null) goto L20;
        r6 = d(false);
    L20:
        if (r5 == null) goto L22;
        r5.layout(r6.left, r6.top, r6.right, r6.bottom);
        bringChildToFront(r5);
    L22:
        View r7 = getCurrentBottomView();
        if (this.u == false) goto L25;
        r4 = (Rect) ((HashMap) this.n).get(r7);
    L25:
        if (r4 != null) goto L27;
        r4 = c(r3, r6);
    L27:
        if (r7 == null) goto L49;
        r7.layout(r4.left, r4.top, r4.right, r4.bottom);
    L49:
        j();
        return;
    L17:
        r6 = null;
        goto L18
    L29:
        ShowMode r8 = ShowMode.LayDown;
        if (r1 != r8) goto L49;
        View r9 = getSurfaceView();
        if (this.u == false) goto L34;
        Rect r10 = (Rect) ((HashMap) this.n).get(r9);
    L35:
        if (r10 != null) goto L37;
        r10 = d(false);
    L37:
        if (r9 != null) goto L39;
    L42:
        View r11 = getCurrentBottomView();
        if (this.u == false) goto L45;
        r4 = (Rect) ((HashMap) this.n).get(r11);
    L45:
        if (r4 != null) goto L47;
        r4 = c(r8, r10);
    L47:
        if (r11 == null) goto L49;
        r11.layout(r4.left, r4.top, r4.right, r4.bottom);
        Log.d("SwipeLayout", "currentBottomView  bottomViewRect.left= " + r4.left + ";bottomViewRect.right=" + r4.right);
        goto L49
    L39:
        if (r10.left >= 0) goto L41;
        r10.left = 0;
        r10.right = getMeasuredWidth() + 0;
    L41:
        r9.layout(r10.left, r10.top, r10.right, r10.bottom);
        bringChildToFront(r9);
        Log.d("SwipeLayout", "surfaceView  surfaceRect.left= " + r10.left + ";surfaceRect.right=" + r10.right);
        goto L42
    L34:
        r10 = null;
        goto L35
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getAdapterView() == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        if (this.a != null) goto L11;
        setOnClickListener(new b(this));
    L11:
        if (this.b != null) goto L15;
        setOnLongClickListener(new c(this));
        return;
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public int getDragDistance() {
        return this.f;
    }

    public DragEdge getDragEdge() {
        return this.d;
    }

    public Map<DragEdge, View> getDragEdgeMap() {
        return this.g;
    }

    public ShowMode getShowMode() {
        return this.h;
    }

    public float getWillOpenPercentAfterClose() {
        return this.s;
    }

    public float getWillOpenPercentAfterOpen() {
        return this.r;
    }

    public SwipeLayout(Context r2) {
        this(r2, null);
    }

    private void setCurrentDragEdge(DragEdge r1) {
        this.d = r1;
        k();
    }

    public final void a(MotionEvent r13) {
        if (this.w == false) goto L5;
        return;
    L5:
        Status r0 = getOpenStatus();
        Status r1 = Status.Middle;
        if (r0 != r1) goto L9;
        this.w = true;
        return;
    L9:
        Status r2 = getOpenStatus();
        float r3 = r13.getRawX() - this.x;
        float r14 = r13.getRawY() - this.y;
        float r4 = (float) Math.toDegrees(Math.atan(Math.abs(r14 / r3)));
        Log.d("SwipeLayout", "checkCanDrag  angle =" + r4);
        Status r5 = getOpenStatus();
        Status r7 = Status.Close;
        boolean r8 = false;
        if (r5 != r7) goto L72;
        if (r4 >= 45.0f) goto L43;
        if (r3 <= 0.0f) goto L28;
        LinkedHashMap<DragEdge, View> r6 = this.g;
        DragEdge r10 = DragEdge.Left;
        View r9 = r6.get(r10);
        if (r9 != null) goto L18;
    L24:
        boolean r11 = false;
    L25:
        if (r11 == false) goto L28;
    L69:
        setCurrentDragEdge(r10);
        goto L72
    L18:
        if (r9.getParent() != this) goto L24;
        if (r9 == getSurfaceView()) goto L24;
        if (this.p[r10.ordinal()] == false) goto L24;
        r11 = true;
    L28:
        if (r3 >= 0.0f) goto L41;
        LinkedHashMap<DragEdge, View> r12 = this.g;
        r10 = DragEdge.Right;
        View r15 = r12.get(r10);
        if (r15 != null) goto L32;
    L38:
        boolean r16 = false;
    L39:
        if (r16 == true) goto L69;
        return;
    L32:
        if (r15.getParent() != this) goto L38;
        if (r15 == getSurfaceView()) goto L38;
        if (this.p[r10.ordinal()] == false) goto L38;
        r16 = true;
        goto L39
    L41:
        return;
    L43:
        if (r14 <= 0.0f) goto L57;
        LinkedHashMap<DragEdge, View> r17 = this.g;
        r10 = DragEdge.Top;
        View r19 = r17.get(r10);
        if (r19 != null) goto L47;
    L53:
        boolean r20 = false;
    L54:
        if (r20 == false) goto L57;
    L47:
        if (r19.getParent() != this) goto L53;
        if (r19 == getSurfaceView()) goto L53;
        if (this.p[r10.ordinal()] == false) goto L53;
        r20 = true;
    L57:
        if (r14 >= 0.0f) goto L70;
        LinkedHashMap<DragEdge, View> r21 = this.g;
        r10 = DragEdge.Bottom;
        View r22 = r21.get(r10);
        if (r22 != null) goto L61;
    L67:
        boolean r23 = false;
    L68:
        if (r23 == true) goto L69;
        return;
    L61:
        if (r22.getParent() != this) goto L67;
        if (r22 == getSurfaceView()) goto L67;
        if (this.p[r10.ordinal()] == false) goto L67;
        r23 = true;
        goto L68
    L70:
        return;
    L72:
        if (this.d == DragEdge.Right) goto L74;
    L92:
        boolean r24 = false;
    L94:
        if (this.d == DragEdge.Left) goto L96;
    L114:
        DragEdge r25 = this.d;
        if (r25 != DragEdge.Top) goto L135;
        if (r2 == Status.Open) goto L119;
    L120:
        if (r2 == r7) goto L122;
    L124:
        boolean r26 = false;
    L125:
        if (r26 == true) goto L129;
        if (r2 == r1) goto L129;
        boolean r27 = false;
    L131:
        if (r4 < 60.0f) goto L133;
        if (r27 == true) goto L135;
    L133:
        r24 = true;
    L129:
        r27 = true;
        goto L131
    L122:
        if (r14 <= this.c) goto L124;
    L123:
        r26 = true;
        goto L125
    L119:
        if (r14 < (-this.c)) goto L123;
    L135:
        if (r25 == DragEdge.Bottom) goto L137;
    L152:
        this.w = !r24;
        Log.d("SwipeLayout", "checkCanDrag  mIsBeingDragged= " + this.w);
        return;
    L137:
        if (r2 == Status.Open) goto L139;
    L140:
        if (r2 == r7) goto L142;
    L144:
        boolean r110 = false;
    L145:
        if (r110 == true) goto L147;
        if (r2 == r1) goto L147;
    L149:
        if (r4 < 60.0f) goto L151;
        if (r8 == true) goto L152;
    L151:
        r24 = true;
    L147:
        r8 = true;
        goto L149
    L142:
        if (r14 >= (-this.c)) goto L144;
    L143:
        r110 = true;
        goto L145
    L139:
        if (r14 > this.c) goto L143;
    L96:
        if (r2 == Status.Open) goto L98;
    L99:
        if (r2 == r7) goto L101;
    L103:
        boolean r29 = false;
    L104:
        Log.d("SwipeLayout", "checkCanDrag  mCurrentDragEdge == DragEdge.Left suitable1 =" + r29);
        if (r29 == true) goto L109;
        if (r2 == r1) goto L109;
        boolean r30 = false;
    L110:
        Log.d("SwipeLayout", "checkCanDrag  mCurrentDragEdge == DragEdge.Left suitable2 =" + r30);
        if (r4 > 30.0f) goto L113;
        if (r30 == true) goto L114;
    L113:
        Log.d("SwipeLayout", "checkCanDrag  mCurrentDragEdge == DragEdge.Left doNothing = true");
        r24 = true;
    L109:
        r30 = true;
        goto L110
    L101:
        if (r3 <= this.c) goto L103;
    L102:
        r29 = true;
        goto L104
    L98:
        if (r3 < (-this.c)) goto L102;
    L74:
        if (r2 == Status.Open) goto L76;
    L77:
        if (r2 == r7) goto L79;
    L81:
        boolean r31 = false;
    L82:
        Log.d("SwipeLayout", "checkCanDrag  mCurrentDragEdge == DragEdge.Right suitable1 =" + r31);
        if (r31 == true) goto L87;
        if (r2 == r1) goto L87;
        boolean r32 = false;
    L88:
        Log.d("SwipeLayout", "checkCanDrag  mCurrentDragEdge == DragEdge.Right suitable2 =" + r32);
        if (r4 > 30.0f) goto L91;
        if (r32 == true) goto L92;
    L91:
        Log.d("SwipeLayout", "checkCanDrag  mCurrentDragEdge == DragEdge.Right doNothing = true");
        r24 = true;
    L87:
        r32 = true;
        goto L88
    L79:
        if (r3 >= (-this.c)) goto L81;
    L80:
        r31 = true;
        goto L82
    L76:
        if (r3 > this.c) goto L80;
        goto L77
    }

    public final Rect d(boolean r5) {
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop();
        if (r5 == false) goto L14;
        DragEdge r6 = this.d;
        if (r6 != DragEdge.Left) goto L8;
        r0 = this.f + getPaddingLeft();
        goto L14
    L8:
        if (r6 != DragEdge.Right) goto L11;
        r0 = getPaddingLeft() - this.f;
        goto L14
    L11:
        if (r6 != DragEdge.Top) goto L13;
        r1 = this.f + getPaddingTop();
        goto L14
    L13:
        r1 = getPaddingTop() - this.f;
    L14:
        Log.d("SwipeLayout", "computeSurfaceLayoutArea l=" + r0 + ";l + getMeasuredWidth()=" + (getMeasuredWidth() + r0));
        return new Rect(r0, r1, getMeasuredWidth() + r0, getMeasuredHeight() + r1);
    }

    public final int g(float r3) {
        Resources r0 = getContext().getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final boolean h(MotionEvent r3) {
        View r0 = getSurfaceView();
        if (r0 != null) goto L7;
        return false;
    L7:
        if (this.z != null) goto L9;
        this.z = new Rect();
    L9:
        r0.getHitRect(this.z);
        return this.z.contains((int) r3.getX(), (int) r3.getY());
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r7) {
        if (this.o == true) goto L6;
        return false;
    L6:
        if (this.q == true) goto L8;
    L12:
        Iterator r0 = ((ArrayList) this.k).iterator();
    L14:
        if (r0.hasNext() == false) goto L20;
        h r3 = (h) r0.next();
        if (r3 == null) goto L14;
        if (r3.a() == false) goto L14;
        return false;
    L20:
        Log.d("SwipeLayout", "onInterceptTouchEvent ev.getAction() =" + r7.getAction());
        int r1 = r7.getAction();
        if (r1 == 0) goto L39;
        if (r1 != 1) goto L24;
    L38:
        this.w = false;
        this.e.processTouchEvent(r7);
    L44:
        return this.w;
    L24:
        if (r1 != 2) goto L26;
        Log.d("SwipeLayout", "onInterceptTouchEvent MotionEvent.ACTION_MOVE  mIsBeingDragged= " + this.w);
        boolean r2 = this.w;
        Log.d("SwipeLayout", "onInterceptTouchEvent MotionEvent.ACTION_MOVE  beforeCheck=" + r2);
        a(r7);
        if (this.w == false) goto L33;
        ViewParent r8 = getParent();
        if (r8 == null) goto L33;
        r8.requestDisallowInterceptTouchEvent(true);
    L33:
        if (r2 == true) goto L44;
        if (this.w == false) goto L44;
        Log.d("SwipeLayout", "onInterceptTouchEvent MotionEvent.ACTION_MOVE  return false");
        return false;
    L26:
        if (r1 == 3) goto L38;
        this.e.processTouchEvent(r7);
        goto L44
    L39:
        this.e.processTouchEvent(r7);
        this.w = false;
        this.x = r7.getRawX();
        this.y = r7.getRawY();
        if (getOpenStatus() != Status.Middle) goto L42;
        this.w = true;
    L42:
        Log.d("SwipeLayout", "onInterceptTouchEvent MotionEvent.ACTION_DOWN  mIsBeingDragged= " + this.w);
        goto L44
    L8:
        if (getOpenStatus() != Status.Open) goto L12;
        if (h(r7) == false) goto L12;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        if (this.o == false) goto L5;
        int r0 = r6.getActionMasked();
        this.A.onTouchEvent(r6);
        if (r0 == 0) goto L18;
        if (r0 != 1) goto L10;
    L17:
        this.w = false;
        this.e.processTouchEvent(r6);
    L20:
        if (super.onTouchEvent(r6) == false) goto L22;
    L24:
        return true;
    L22:
        if (this.w == true) goto L24;
        if (r0 == 0) goto L24;
        return false;
    L10:
        if (r0 != 2) goto L12;
        a(r6);
        if (this.w == false) goto L20;
        Log.d("SwipeLayout", "onTouchEvent getParent().requestDisallowInterceptTouchEvent(true);");
        getParent().requestDisallowInterceptTouchEvent(true);
        this.e.processTouchEvent(r6);
        goto L20
    L12:
        if (r0 == 3) goto L17;
        this.e.processTouchEvent(r6);
        goto L20
    L18:
        this.e.processTouchEvent(r6);
        this.x = r6.getRawX();
        this.y = r6.getRawY();
        goto L20
    L5:
        return super.onTouchEvent(r6);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r4) {
        Iterator r0 = new HashMap(this.g).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) r0.next();
        if (r1.getValue() != r4) goto L4;
        this.g.remove(r1.getKey());
        goto L4
    }

    public void setBottomSwipeEnabled(boolean r3) {
        this.p[DragEdge.Bottom.ordinal()] = r3;
    }

    public void setClickToClose(boolean r1) {
        this.q = r1;
    }

    public void setDragDistance(int r1) {
        if (r1 >= 0) goto L4;
        r1 = 0;
    L4:
        this.f = g(r1);
        requestLayout();
    }

    public void setDragEdge(DragEdge r4) {
        this.g.clear();
        if (getChildCount() < 2) goto L5;
        this.g.put(r4, getChildAt(getChildCount() - 2));
    L5:
        setCurrentDragEdge(r4);
    }

    public void setDragEdges(List<DragEdge> r7) {
        this.g.clear();
        int r0 = Math.min(r7.size(), getChildCount() - 1);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        this.g.put((DragEdge) ListProtector.get(r7, r2), getChildAt(r2));
        r2 = r2 + 1;
        goto L3
    L6:
        if (r7.size() != 0) goto L8;
    L11:
        setCurrentDragEdge(B);
        return;
    L8:
        if (r7.contains(B) == true) goto L11;
        setCurrentDragEdge((DragEdge) ListProtector.get(r7, 0));
    }

    public void setIsUseBoundCache(boolean r1) {
        this.u = r1;
    }

    public void setLeftSwipeEnabled(boolean r3) {
        this.p[DragEdge.Left.ordinal()] = r3;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r1) {
        super.setOnClickListener(r1);
        this.a = r1;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r1) {
        super.setOnLongClickListener(r1);
        this.b = r1;
    }

    public void setRightSwipeEnabled(boolean r3) {
        this.p[DragEdge.Right.ordinal()] = r3;
    }

    public void setShowMode(ShowMode r1) {
        this.h = r1;
        requestLayout();
    }

    public void setSwipeEnabled(boolean r1) {
        this.o = r1;
    }

    public void setTopSwipeEnabled(boolean r3) {
        this.p[DragEdge.Top.ordinal()] = r3;
    }

    public void setWillOpenPercentAfterClose(float r1) {
        this.s = r1;
    }

    public void setWillOpenPercentAfterOpen(float r1) {
        this.r = r1;
    }

    public void setDragEdges(DragEdge... r2) {
        this.g.clear();
        setDragEdges(Arrays.asList(r2));
    }

    public SwipeLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void b(boolean r8, boolean r9) {
        View r0 = getSurfaceView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r8 == false) goto L7;
        this.e.smoothSlideViewTo(getSurfaceView(), getPaddingLeft(), getPaddingTop());
    L11:
        invalidate();
        return;
    L7:
        Rect r10 = d(false);
        int r1 = r10.left - r0.getLeft();
        int r2 = r10.top - r0.getTop();
        r0.layout(r10.left, r10.top, r10.right, r10.bottom);
        if (r9 == false) goto L10;
        e(r10.left, r10.top, r10.right, r10.bottom);
        f(r10.left, r10.top, r1, r2);
        goto L11
    L10:
        j();
        goto L11
    }

    public final Rect c(ShowMode r8, Rect r9) {
        View r0 = getCurrentBottomView();
        int r1 = r9.left;
        int r2 = r9.top;
        int r3 = r9.right;
        int r4 = r9.bottom;
        if (r8 != ShowMode.PullOut) goto L28;
        DragEdge r10 = this.d;
        DragEdge r5 = DragEdge.Left;
        if (r10 != r5) goto L8;
        r1 = r1 - this.f;
    L14:
        int r6 = 0;
        if (r10 != r5) goto L17;
    L23:
        if (r0 == null) goto L26;
        r6 = r0.getMeasuredWidth();
    L26:
        r3 = r6 + r1;
    L39:
        Log.d("SwipeLayout", "computeBottomLayoutAreaViaSurface bl=" + r1 + ";br=" + r3);
        return new Rect(r1, r2, r3, r4);
    L17:
        if (r10 == DragEdge.Right) goto L23;
        if (r0 == null) goto L22;
        r6 = r0.getMeasuredHeight();
    L22:
        r4 = r2 + r6;
        r3 = r9.right;
        goto L39
    L8:
        if (r10 != DragEdge.Right) goto L11;
        r1 = r3;
        goto L14
    L11:
        if (r10 != DragEdge.Top) goto L13;
        r2 = r2 - this.f;
        goto L14
    L13:
        r2 = r4;
        goto L14
    L28:
        if (r8 != ShowMode.LayDown) goto L39;
        DragEdge r11 = this.d;
        if (r11 != DragEdge.Left) goto L33;
        r3 = r1 + this.f;
        goto L39
    L33:
        if (r11 != DragEdge.Right) goto L36;
        r1 = r3 - this.f;
        goto L39
    L36:
        if (r11 != DragEdge.Top) goto L38;
        r4 = r2 + this.f;
        goto L39
    L38:
        r2 = r4 - this.f;
        goto L39
    }

    public final void i(boolean r9, boolean r10) {
        View r0 = getSurfaceView();
        View r1 = getCurrentBottomView();
        if (r0 != null) goto L5;
        return;
    L5:
        Rect r2 = d(true);
        if (r9 == false) goto L8;
        this.e.smoothSlideViewTo(r0, r2.left, r2.top);
    L16:
        invalidate();
        return;
    L8:
        int r11 = r2.left - r0.getLeft();
        int r3 = r2.top - r0.getTop();
        r0.layout(r2.left, r2.top, r2.right, r2.bottom);
        ShowMode r4 = getShowMode();
        ShowMode r5 = ShowMode.PullOut;
        if (r4 != r5) goto L13;
        Rect r6 = c(r5, r2);
        if (r1 == null) goto L13;
        r1.layout(r6.left, r6.top, r6.right, r6.bottom);
    L13:
        if (r10 == false) goto L15;
        e(r2.left, r2.top, r2.right, r2.bottom);
        f(r2.left, r2.top, r11, r3);
        goto L16
    L15:
        j();
        goto L16
    }

    public SwipeLayout(Context r12, AttributeSet r13, int r14) {
        super(r12, r13, r14);
        this.d = B;
        this.f = 0;
        LinkedHashMap<DragEdge, View> r0 = new LinkedHashMap();
        this.g = r0;
        float[] r2 = new float[4];
        this.i = r2;
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new HashMap();
        this.m = new HashMap();
        this.n = new HashMap();
        this.o = true;
        this.p = new boolean[]{true, true, true, true};
        this.q = false;
        this.r = 0.75f;
        this.s = 0.25f;
        this.t = 0;
        this.u = true;
        a r4 = new a(this);
        this.x = -1.0f;
        this.y = -1.0f;
        this.A = new GestureDetector(getContext(), new i(this));
        this.e = ViewDragHelper.create(this, r4);
        this.c = ViewConfiguration.get(r12).getScaledTouchSlop();
        TypedArray r15 = r12.obtainStyledAttributes(r13, new int[]{2130969043, 2130969504, 2130969819, 2130972499, 2130973780, 2130974083, 2130974618});
        int r5 = r15.getInt(2, 2);
        DragEdge r6 = DragEdge.Left;
        r2[r6.ordinal()] = r15.getDimension(3, 0.0f);
        DragEdge r7 = DragEdge.Right;
        r2[r7.ordinal()] = r15.getDimension(4, 0.0f);
        DragEdge r8 = DragEdge.Top;
        r2[r8.ordinal()] = r15.getDimension(6, 0.0f);
        DragEdge r9 = DragEdge.Bottom;
        r2[r9.ordinal()] = r15.getDimension(0, 0.0f);
        setClickToClose(r15.getBoolean(1, this.q));
        if ((r5 & 1) != 1) goto L6;
        r0.put(r6, null);
    L6:
        if ((r5 & 4) != 4) goto L9;
        r0.put(r8, null);
    L9:
        if ((r5 & 2) != 2) goto L12;
        r0.put(r7, null);
    L12:
        if ((r5 & 8) != 8) goto L14;
        r0.put(r9, null);
    L14:
        int r16 = r15.getInt(5, ShowMode.PullOut.ordinal());
        this.h = ShowMode.values()[r16];
        r15.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r4, int r5, ViewGroup.LayoutParams r6) {
        if (r4 != null) goto L32;
        return;
    L32:
        int r0 = ((Integer) r6.getClass().getField("gravity").get(r6)).intValue();     // Catch: Exception -> L6
    L8:
        if (r0 <= 0) goto L21;
        int r1 = GravityCompat.getAbsoluteGravity(r0, ViewCompat.getLayoutDirection(this));
        if ((r1 & 3) != 3) goto L13;
        this.g.put(DragEdge.Left, r4);
    L13:
        if ((r1 & 5) != 5) goto L16;
        this.g.put(DragEdge.Right, r4);
    L16:
        if ((r1 & 48) != 48) goto L19;
        this.g.put(DragEdge.Top, r4);
    L19:
        if ((r1 & 80) != 80) goto L28;
        this.g.put(DragEdge.Bottom, r4);
    L28:
        if (r4.getParent() != this) goto L30;
        return;
    L30:
        super.addView(r4, r5, r6);
        return;
    L21:
        Iterator<Map.Entry<DragEdge, View>> r2 = this.g.entrySet().iterator();
    L23:
        if (r2.hasNext() == false) goto L28;
        Map.Entry<DragEdge, View> r3 = r2.next();
        if (r3.getValue() != null) goto L23;
        this.g.put(r3.getKey(), r4);
    L6:
        e = move-exception;
        e.printStackTrace();
        r0 = 0;
        goto L8
    }

    public final void e(int r19, int r110, int r20, int r21) {
        if (((HashMap) this.l).isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r5 = ((HashMap) this.l).entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L163;
        Map.Entry r6 = (Map.Entry) r5.next();
        View r7 = (View) r6.getKey();
        Rect r8 = new Rect(r7.getLeft(), r7.getTop(), 0, 0);
        View r9 = r7;
    L10:
        if (r9.getParent() == null) goto L17;
        if (r9 == getRootView()) goto L17;
        r9 = (View) r9.getParent();
        if (r9 == this) goto L17;
        r8.left += r9.getLeft();
        r8.top += r9.getTop();
    L17:
        r8.right = r8.left + r7.getMeasuredWidth();
        int r10 = r8.top + r7.getMeasuredHeight();
        r8.bottom = r10;
        DragEdge r11 = this.d;
        int r12 = r8.left;
        int r13 = r8.right;
        int r14 = r8.top;
        ShowMode r15 = getShowMode();
        ShowMode r16 = ShowMode.LayDown;
        Iterator r17 = r5;
        boolean r22 = true;
        if (r15 != r16) goto L41;
        int r111 = d.a[r11.ordinal()];
        if (r111 != 1) goto L22;
        if (r110 < r14) goto L71;
        if (r110 >= r10) goto L71;
    L72:
        if (r22 == false) goto L113;
        ((HashMap) this.m).put(r7, Boolean.FALSE);
        float r23 = 0.0f;
        if (getShowMode() != r16) goto L91;
        int r24 = d.a[this.d.ordinal()];
        if (r24 != 1) goto L78;
        float r25 = r8.top - r110;
        int r26 = r7.getHeight();
    L88:
        r23 = r25 / r26;
    L106:
        Iterator r27 = ((ArrayList) r6.getValue()).iterator();
    L108:
        if (r27.hasNext() == false) goto L113;
        g r112 = (g) r27.next();
        Math.abs(r23);
        r112.a();
        if (Math.abs(r23) != 1.0f) goto L108;
        ((HashMap) this.m).put(r7, Boolean.TRUE);
        goto L108
    L78:
        if (r24 != 2) goto L80;
        r25 = r8.bottom - r21;
        r26 = r7.getHeight();
        goto L88
    L80:
        if (r24 != 3) goto L82;
        r25 = r8.left - r19;
        r26 = r7.getWidth();
        goto L88
    L82:
        if (r24 != 4) goto L106;
        r25 = r8.right - r20;
        r26 = r7.getWidth();
        goto L88
    L91:
        if (getShowMode() != ShowMode.PullOut) goto L106;
        int r29 = d.a[this.d.ordinal()];
        if (r29 != 1) goto L95;
        float r30 = r8.bottom - getPaddingTop();
        int r31 = r7.getHeight();
    L105:
        r23 = r30 / r31;
        goto L106
    L95:
        if (r29 != 2) goto L97;
        r30 = r8.top - getHeight();
        r31 = r7.getHeight();
        goto L105
    L97:
        if (r29 != 3) goto L99;
        r30 = r8.right - getPaddingLeft();
        r31 = r7.getWidth();
        goto L105
    L99:
        if (r29 != 4) goto L106;
        r30 = r8.left - getWidth();
        r31 = r7.getWidth();
    L113:
        DragEdge r32 = this.d;
        if (((Boolean) ((HashMap) this.m).get(r7)).booleanValue() == true) goto L150;
        int r33 = r8.left;
        int r113 = r8.right;
        int r114 = r8.top;
        int r34 = r8.bottom;
        if (getShowMode() != ShowMode.LayDown) goto L132;
        if (r32 != DragEdge.Right) goto L122;
        if (r20 > r33) goto L122;
    L149:
        boolean r115 = true;
    L151:
        if (r115 == false) goto L162;
        ((HashMap) this.m).put(r7, Boolean.TRUE);
        Iterator r35 = ((ArrayList) r6.getValue()).iterator();
    L154:
        if (r35.hasNext() == false) goto L162;
        g r36 = (g) r35.next();
        DragEdge r37 = this.d;
        if (r37 == DragEdge.Left) goto L161;
        if (r37 == DragEdge.Right) goto L161;
        r7.getHeight();
        r36.a();
    L161:
        r7.getWidth();
        r36.a();
    L162:
        r5 = r17;
    L122:
        if (r32 != DragEdge.Left) goto L125;
        if (r19 >= r113) goto L149;
    L125:
        if (r32 != DragEdge.Top) goto L128;
        if (r110 >= r34) goto L149;
    L128:
        if (r32 != DragEdge.Bottom) goto L150;
        if (r21 > r114) goto L150;
    L132:
        if (getShowMode() != ShowMode.PullOut) goto L150;
        if (r32 != DragEdge.Right) goto L138;
        if (r113 <= getWidth()) goto L149;
    L138:
        if (r32 != DragEdge.Left) goto L142;
        if (r33 >= getPaddingLeft()) goto L149;
    L142:
        if (r32 != DragEdge.Top) goto L146;
        if (r114 >= getPaddingTop()) goto L149;
    L146:
        if (r32 != DragEdge.Bottom) goto L150;
        if (r34 <= getHeight()) goto L149;
    L150:
        r115 = false;
    L71:
        r22 = false;
        goto L72
    L22:
        if (r111 != 2) goto L24;
        if (r21 <= r14) goto L71;
        if (r21 > r10) goto L71;
    L24:
        if (r111 != 3) goto L26;
        if (r19 >= r13) goto L71;
        if (r19 < r12) goto L71;
    L26:
        if (r111 != 4) goto L71;
        if (r20 <= r12) goto L71;
        if (r20 > r13) goto L71;
    L41:
        if (getShowMode() != ShowMode.PullOut) goto L71;
        int r38 = d.a[r11.ordinal()];
        if (r38 == 1) goto L67;
        if (r38 == 2) goto L62;
        if (r38 == 3) goto L57;
        if (r38 != 4) goto L71;
        if (r12 > getWidth()) goto L71;
        if (r13 <= getWidth()) goto L71;
    L70:
        r22 = true;
        goto L72
    L57:
        if (r13 < getPaddingLeft()) goto L71;
        if (r12 >= getPaddingLeft()) goto L71;
    L62:
        if (r14 >= getHeight()) goto L71;
        if (r14 < getPaddingTop()) goto L71;
    L67:
        if (r14 >= getPaddingTop()) goto L71;
        if (r10 < getPaddingTop()) goto L71;
    }

    public final void f(int r5, int r6, int r7, int r8) {
        DragEdge r9 = getDragEdge();
        if (r9 != DragEdge.Left) goto L7;
        if (r7 < 0) goto L17;
    L18:
        boolean r10 = true;
    L19:
        j();
        Status r11 = getOpenStatus();
        if (((ArrayList) this.j).isEmpty() == true) goto L54;
        this.t++;
        Iterator r12 = ((ArrayList) this.j).iterator();
    L23:
        if (r12.hasNext() == false) goto L31;
        j r0 = (j) r12.next();
        if (this.t != 1) goto L29;
        if (r10 == false) goto L28;
        r0.d(this);
        goto L29
    L28:
        r0.a();
    L29:
        int r3 = r5 - getPaddingLeft();
        getPaddingTop();
        r0.onUpdate(r3);
        goto L23
    L31:
        if (r11 != Status.Close) goto L38;
        Iterator r13 = ((ArrayList) this.j).iterator();
    L34:
        if (r13.hasNext() == false) goto L36;
        ((j) r13.next()).onClose();
        goto L34
    L36:
        this.t = 0;
    L38:
        if (r11 != Status.Open) goto L55;
        View r14 = getCurrentBottomView();
        if (r14 == null) goto L42;
        r14.setEnabled(true);
    L42:
        Iterator r15 = ((ArrayList) this.j).iterator();
    L44:
        if (r15.hasNext() == false) goto L46;
        ((j) r15.next()).c(this);
        goto L44
    L46:
        this.t = 0;
        return;
    L55:
        return;
    L54:
        return;
    L17:
        r10 = false;
        goto L19
    L7:
        if (r9 != DragEdge.Right) goto L11;
        if (r7 <= 0) goto L18;
    L11:
        if (r9 != DragEdge.Top) goto L15;
        if (r8 >= 0) goto L18;
    L15:
        if (r9 != DragEdge.Bottom) goto L18;
        if (r8 <= 0) goto L18;
        goto L17
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        k();
        if (this.v == null) goto L8;
        int r6 = 0;
    L6:
        if (r6 >= ((ArrayList) this.v).size()) goto L10;
        ((f) ListProtector.get(this.v, r6)).a(this);
        r6 = r6 + 1;
        goto L6
    L10:
        return;
    }
}
