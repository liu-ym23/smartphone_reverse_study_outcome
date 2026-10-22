package com.lynx.tasm.behavior.ui.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.voice_setting.voice.base.VoiceDisplayScene;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.accessibility.LynxNodeProvider;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;
import com.lynx.tasm.behavior.ui.utils.h;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.i;
import com.lynx.tasm.utils.n;
import com.lynx.xelement.webview.LynxUIWebView;
import com.obric.aivoice.core.data.NameKeys;
import e7a.g;
import e7a.j;
import e7a.k;
import e7a.l;
import e7a.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIList extends AbsLynxList<RecyclerView> {
    public static final /* synthetic */ int L0 = 0;
    public ReadableMap A;
    public final ArrayList<String> B;
    public final HashMap<String, ArrayList<LynxNodeProvider.b>> C;
    public ReadableMap D;
    public boolean E;
    public boolean F;
    public boolean G;
    public int H;
    public boolean H0;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public com.lynx.tasm.behavior.ui.list.a P;
    public int Q;
    public boolean R;
    public GapItemDecoration S;
    public int T;
    public float U;
    public m V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;
    public UIListAdapter c;
    public int d;
    public int e;
    public int f;
    public String g;
    public boolean h;
    public ListEventManager i;
    public com.lynx.tasm.behavior.ui.list.b j;
    public boolean k;
    public l k0;
    public boolean l;
    public PagerSnapHelper m;
    public FactoredPagerSnapHelper n;
    public boolean o;
    public boolean p;
    public int p0;
    public ListStickyManager.b q;
    public ListStickyManager r;
    public e7a.a s;
    public int t;
    public int u;
    public boolean v;
    public boolean w;
    public boolean x;
    public final Map<String, Object> y;
    public final Map<String, HashSet<String>> z;

    public class a implements Runnable {
        public final /* synthetic */ View a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(View r1) {
            this.a = r1;
        }
    }

    public class b {
        public final /* synthetic */ UIList a;

        public b(UIList r1) {
            this.a = r1;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ UIList a;

        public final void a() {
            ListStickyManager r0 = this.a.r;
            int r1 = 0;
            if (r0 != null) goto L5;
        L35:
            UIList r2 = this.a;
            if (r2.w == false) goto L139;
            ListEventManager r3 = r2.i;
            UIListAdapter r4 = r2.c;
            RecyclerView.LayoutManager r5 = ((RecyclerView) r4.c.getView()).getLayoutManager();
            if (r4.B.isEmpty() == false) goto L41;
        L108:
            r3.l = r1;
            ListEventManager r6 = this.a.i;
            int r7 = r6.l;
            r6.n("scroll", 1, r7, r7, 0, 0);
            return;
        L41:
            if ((r5 instanceof ListLayoutManager.ListLinearLayoutManager) == false) goto L55;
            ListLayoutManager.ListLinearLayoutManager r8 = (ListLayoutManager.ListLinearLayoutManager) r5;
            int r9 = r8.findFirstVisibleItemPosition();
            View r10 = r8.findViewByPosition(r9);
            if (r10 == null) goto L45;
            int r11 = -((int) r10.getY());
        L46:
            HashMap r12 = (HashMap) ListProtector.get(r4.B, 0);
            int r13 = 0;
        L47:
            if (r13 >= r9) goto L53;
            if (r12.get(Integer.valueOf(r13)) != null) goto L51;
            int r14 = 0;
        L52:
            r11 = r11 + r14;
            r13 = r13 + 1;
            goto L47
        L51:
            r14 = ((Integer) r12.get(Integer.valueOf(r13))).intValue();
            goto L52
        L53:
            r1 = r11;
            goto L108
        L45:
            r11 = 0;
            goto L46
        L55:
            if ((r5 instanceof ListLayoutManager.ListGridLayoutManager) == true) goto L110;
            int r15 = r4.c.d;
            int[] r16 = new int[r15];
            View[] r17 = new View[r15];
            ((ListLayoutManager.b) r5).findFirstVisibleItemPositions(r16);
            int r18 = 0;
        L75:
            if (r18 >= r15) goto L90;
            int r19 = 0;
        L78:
            if (r19 >= ((RecyclerView) r4.c.getView()).getChildCount()) goto L89;
            View r20 = ((RecyclerView) r4.c.getView()).getChildAt(r19);
            if (r20 == null) goto L88;
            ListViewHolder r21 = (ListViewHolder) ((RecyclerView) r4.c.getView()).getChildViewHolder(r20);
            if (r21 == null) goto L88;
            if (r16[r18] != r21.getAdapterPosition()) goto L88;
            r17[r18] = r20;
        L88:
            r19 = r19 + 1;
        L89:
            r18 = r18 + 1;
            goto L75
        L90:
            int r22 = 0;
            int r23 = 0;
        L91:
            if (r22 >= r15) goto L107;
            if (r22 >= r4.B.size()) goto L107;
            View r24 = r17[r22];
            if (r24 == null) goto L106;
            int r25 = -((int) r24.getY());
            HashMap r26 = (HashMap) ListProtector.get(r4.B, r22);
            int r110 = 0;
        L99:
            if (r110 >= r16[r22]) goto L105;
            if (r26.get(Integer.valueOf(r110)) != null) goto L103;
            int r111 = 0;
        L104:
            r25 = r25 + r111;
            r110 = r110 + 1;
            goto L99
        L103:
            r111 = ((Integer) r26.get(Integer.valueOf(r110))).intValue();
            goto L104
        L105:
            r23 = Math.max(r23, r25);
        L106:
            r22 = r22 + 1;
        L107:
            r1 = r23;
            goto L108
        L110:
            ListLayoutManager.ListGridLayoutManager r27 = (ListLayoutManager.ListGridLayoutManager) r5;     // Catch: Exception -> L72
            int r28 = 0;
            int r29 = 0;
        L57:
            if (r28 >= r4.B.size()) goto L71;
            View r30 = r27.getChildAt(r28);     // Catch: Exception -> L72
            if (r30 == null) goto L70;
            int r31 = r27.getPosition(r30);     // Catch: Exception -> L72
            int r32 = -((int) r30.getY());
            HashMap r33 = (HashMap) ListProtector.get(r4.B, r28);     // Catch: Exception -> L72
            int r34 = 0;
        L63:
            if (r34 >= r31) goto L69;
            if (r33.get(Integer.valueOf(r34)) != null) goto L67;
            int r112 = 0;
        L68:
            r32 = r32 + r112;     // Catch: Exception -> L72
            r34 = r34 + 1;     // Catch: Exception -> L72
            goto L63
        L67:
            r112 = ((Integer) r33.get(Integer.valueOf(r34))).intValue();     // Catch: Exception -> L72
            goto L68
        L69:
            r29 = Math.max(r29, r32);     // Catch: Exception -> L72
        L70:
            r28 = r28 + 1;
            goto L57
        L71:
            r1 = r29;
        L72:
            e = move-exception;
            e.printStackTrace();
            goto L108
        L139:
            return;
        L5:
            if (r0.h == true) goto L35;
            UIListAdapter r35 = r0.a.c;
            int r36 = r0.g.b;
            if (r36 != (-1)) goto L10;
        L13:
            int r37 = r0.f.b;
            if (r37 == (-1)) goto L35;
            if (r35.j.contains(Integer.valueOf(r37)) == false) goto L34;
            RecyclerView r38 = (RecyclerView) r0.a.getView();
            int r39 = Integer.MAX_VALUE;
            int r40 = Integer.MIN_VALUE;
            int r41 = 0;
        L19:
            if (r41 >= r38.getChildCount()) goto L31;
            View r42 = r38.getChildAt(r41);
            if (r42.getTop() > r0.d) goto L26;
            if (r42.getBottom() <= r0.d) goto L26;
            r39 = ((ListViewHolder) r38.getChildViewHolder(r42)).getAdapterPosition();
        L26:
            if (r42.getTop() >= (r38.getHeight() - r0.d)) goto L30;
            if (r42.getBottom() < (r38.getHeight() - r0.d)) goto L30;
            r40 = ((ListViewHolder) r38.getChildViewHolder(r42)).getAdapterPosition();
        L30:
            r41 = r41 + 1;
            goto L19
        L31:
            int r43 = r35.D2(r39);
            r35.C2(r40);
            ListStickyManager.c r44 = r0.f;
            if (r43 == r44.b) goto L35;
            r0.l(r44, true, false);
            r0.q(r0.a.getView(), 0);
            goto L35
        L34:
            r0.l(r0.f, true, false);
            goto L35
        L10:
            if (r35.k.contains(Integer.valueOf(r36)) == false) goto L12;
            r0.k(r0.g);
            goto L13
        L12:
            r0.l(r0.g, false, false);
            r0.q(r0.a.getView(), 0);
            goto L13
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

        public c(UIList r1) {
            this.a = r1;
        }
    }

    public static class d extends RecyclerView {
        public final WeakReference<LynxContext> a;
        public final WeakReference<UIList> b;
        public boolean c;
        public boolean d;
        public boolean e;
        public final g f;
        public Boolean g;
        public Boolean h;
        public boolean i;
        public boolean j;
        public boolean k;

        public final void onAttachedToWindow() {
            LLog.i("UIList", "PrivateRecyclerView onAttachedToWindow");
            super.onAttachedToWindow();
        }

        public final void onDetachedFromWindow() {
            LLog.i("UIList", "PrivateRecyclerView onDetachedFromWindow");
            super.onDetachedFromWindow();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void computeScroll() {
            super/*android.view.ViewGroup*/.computeScroll();
            UIList r0 = this.b.get();
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.isEnableNewGesture() == true) goto L8;
            return;
        L8:
            q7a.b r1 = r0.getGestureArenaManager();
            if (r1 == null) goto L12;
            r1.b();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean canScrollHorizontally(int r4) {
            UIList r0 = this.b.get();
            if (r0 == null) goto L20;
            if (r0.W == false) goto L20;
            if (r4 < 0) goto L9;
            if (r4 <= 0) goto L20;
            if (UIList.Q(r0) < (getAdapter().getItemCount() - 1)) goto L18;
            return false;
        L18:
            return super/*android.view.ViewGroup*/.canScrollHorizontally(r4);
        L9:
            if (UIList.P(r0) != 0) goto L12;
            return false;
        L12:
            return super/*android.view.ViewGroup*/.canScrollHorizontally(r4);
        L20:
            return super/*android.view.ViewGroup*/.canScrollHorizontally(r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean canScrollVertically(int r4) {
            UIList r0 = this.b.get();
            if (r0 == null) goto L22;
            if (r0.W == false) goto L22;
            if (r4 < 0) goto L9;
            if (r4 <= 0) goto L22;
            int r1 = UIList.Q(r0);
            if (getAdapter() == null) goto L22;
            if (r1 < (getAdapter().getItemCount() - 1)) goto L20;
            return false;
        L20:
            return super/*android.view.ViewGroup*/.canScrollVertically(r4);
        L9:
            if (UIList.P(r0) != 0) goto L12;
            return false;
        L12:
            return super/*android.view.ViewGroup*/.canScrollVertically(r4);
        L22:
            return super/*android.view.ViewGroup*/.canScrollVertically(r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void dispatchDraw(Canvas r11) {
            if (this.e == true) goto L6;
            super/*android.view.ViewGroup*/.dispatchDraw(r11);
            return;
        L6:
            g r0 = this.f;
            r0.getClass();
            Path r1 = new Path();
            Drawable r2 = getBackground();
            int r3 = getScrollX();
            int r4 = getScrollY();
            int r5 = getWidth();
            int r6 = getHeight();
            if ((r2 instanceof BackgroundDrawable) == false) goto L15;
            BackgroundDrawable r7 = (BackgroundDrawable) r2;
            RectF r8 = r7.b();
            BorderRadius r9 = r7.A;
            Rect r10 = r0.a;
            if (r10 != null) goto L11;
            r10 = r2.getBounds();
        L11:
            RectF r12 = new RectF((r10.left + r3) + r8.left, (r10.top + r4) + r8.top, (r3 + r10.right) - r8.right, (r4 + r10.bottom) - r8.bottom);
            if (r9 != null) goto L14;
            r1.addRect(r12, Path.Direction.CW);
        L20:
            int r13 = r11.save();
            r11.clipPath(r1);
            super/*android.view.ViewGroup*/.dispatchDraw(r11);
            r11.restoreToCount(r13);
            return;
        L14:
            r1.addRoundRect(r12, BackgroundDrawable.RoundRectPath.c(r9.a(), r8, 1.0f), Path.Direction.CW);
            goto L20
        L15:
            Rect r14 = r0.a;
            if (r14 != null) goto L19;
            r14 = new Rect(0, 0, r5, r6);
        L19:
            r1.addRect(new RectF(r14.left + r3, r14.top + r4, r3 + r14.right, r4 + r14.bottom), Path.Direction.CW);
            goto L20
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean dispatchTouchEvent(MotionEvent r4) {
            UIList r0 = this.b.get();
            if (r0 != null) goto L7;
            return super/*android.view.ViewGroup*/.dispatchTouchEvent(r4);
        L7:
            if (r0.isEnableNewGesture() == false) goto L19;
            if (Boolean.FALSE.equals(this.g) == false) goto L12;
            return true;
        L12:
            if (r4.getActionMasked() != 2) goto L19;
            if (this.g == null) goto L19;
            if (this.i == true) goto L19;
            r4.setAction(0);
            this.i = true;
        L19:
            return super/*android.view.ViewGroup*/.dispatchTouchEvent(r4);
        }

        public final boolean onInterceptTouchEvent(MotionEvent r5) {
            boolean r1 = true;
            if (this.k == false) goto L6;
            return true;
        L6:
            if (this.d == false) goto L8;
            requestDisallowInterceptTouchEvent(true);
        L8:
            UIList r0 = this.b.get();
            if (r0 != null) goto L13;
            return super.onInterceptTouchEvent(r5);
        L13:
            if (r0.isEnableNewGesture() == true) goto L15;
        L17:
            boolean r2 = false;
        L18:
            if (r2 == false) goto L21;
            return false;
        L21:
            if (r0.isEnableNewGesture() == false) goto L29;
            Boolean r3 = this.g;
            if (r3 == null) goto L29;
            if (r3.booleanValue() == true) goto L29;
            if (r5.getActionMasked() == 0) goto L29;
            boolean r4 = true;
        L30:
            if (r4 == false) goto L33;
            return false;
        L33:
            if (r0.isEnableNewGesture() == true) goto L35;
        L37:
            boolean r6 = false;
        L38:
            if (r6 == true) goto L40;
        L42:
            r1 = false;
        L43:
            if (r1 == false) goto L47;
            return this.h.booleanValue();
        L47:
            return super.onInterceptTouchEvent(r5);
        L40:
            if (this.h.booleanValue() == false) goto L42;
        L35:
            if (this.h == null) goto L37;
            r6 = true;
        L29:
            r4 = false;
            goto L30
        L15:
            if (r0.getIncludeNativeGesture() == true) goto L17;
            r2 = true;
            goto L18
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean onTouchEvent(MotionEvent r5) {
            UIList r0 = this.b.get();
            if (r0 == null) goto L5;
            boolean r2 = false;
            if (this.j == false) goto L10;
            return false;
        L10:
            if (r0.isEnableNewGesture() == true) goto L12;
        L14:
            boolean r1 = false;
        L15:
            if (r1 == false) goto L18;
            return false;
        L18:
            if (r0.isEnableNewGesture() == false) goto L26;
            Boolean r3 = this.g;
            if (r3 == null) goto L26;
            if (r3.booleanValue() == true) goto L26;
            if (r5.getActionMasked() == 0) goto L26;
            boolean r4 = true;
        L27:
            if (r4 == false) goto L30;
            return false;
        L30:
            if (r0.isEnableNewGesture() == true) goto L32;
        L34:
            if (r2 == false) goto L50;
            if (r5.getAction() != 0) goto L39;
            getParent().requestDisallowInterceptTouchEvent(true);
            goto L50
        L39:
            if (r5.getAction() != 2) goto L45;
            getParent().requestDisallowInterceptTouchEvent(this.h.booleanValue());
            boolean r6 = this.h.booleanValue();
            if (this.h.booleanValue() == false) goto L43;
            return r6;
        L43:
            return super.onTouchEvent(r5);
        L45:
            if (r5.getAction() != 1) goto L47;
        L48:
            this.h = null;
            goto L50
        L47:
            if (r5.getAction() == 3) goto L48;
        L50:
            if (this.c == true) goto L52;
            return true;
        L52:
            return super.onTouchEvent(r5);
        L32:
            if (this.h == null) goto L34;
            r2 = true;
        L26:
            r4 = false;
            goto L27
        L12:
            if (r0.getIncludeNativeGesture() == true) goto L14;
            r1 = true;
            goto L15
        L5:
            return super.onTouchEvent(r5);
        }

        public final void r(boolean r3) {
            WeakReference<LynxContext> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (this.b == null) goto L17;
            LynxContext r1 = r0.get();
            UIList r2 = this.b.get();
            if (r3 == false) goto L14;
            if (r1 == null) goto L15;
            if (r2 == null) goto L16;
            r1.onGestureRecognized(r2);
            return;
        L16:
            return;
        L15:
            return;
        L14:
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void setClipBounds(Rect r2) {
            if (this.e == true) goto L6;
            super/*android.view.ViewGroup*/.setClipBounds(r2);
            return;
        L6:
            this.f.a = r2;
        }

        public d(Context r5, UIList r6) {
            super(r5);
            this.a = null;
            this.b = null;
            this.c = true;
            this.d = false;
            this.e = false;
            this.f = new g();
            this.g = null;
            this.h = null;
            this.i = true;
            this.j = false;
            this.k = false;
            if (r5 != null) goto L5;
            return;
        L5:
            if ((r5 instanceof LynxContext) == false) goto L9;
            this.a = new WeakReference((LynxContext) r5);
            this.b = new WeakReference(r6);
            return;
        }

        public final boolean fling(int r4, int r5) {
            UIList r0 = this.b.get();
            if (r0 != null) goto L5;
            super.fling(r4, r5);
        L5:
            float r1 = r0.U;
            if (r1 <= 0.0f) goto L14;
            if (r1 >= 1.0f) goto L14;
            if (r0.x == false) goto L12;
            r5 = (int) MathUtils.clamp(r5, (-getMaxFlingVelocity()) * r0.U, getMaxFlingVelocity() * r0.U);
            goto L14
        L12:
            r4 = (int) MathUtils.clamp(r4, (-getMaxFlingVelocity()) * r0.U, getMaxFlingVelocity() * r0.U);
        L14:
            return super.fling(r4, r5);
        }

        public final View focusSearch(View r2, int r3) {
            WeakReference<UIList> r0 = this.b;
            if (r0 == null) goto L14;
            if (r0.get() == null) goto L14;
            if (this.b.get().X == true) goto L14;
            if (r3 != 130) goto L11;
        L12:
            return r2;
        L11:
            if (r3 == 33) goto L12;
        L14:
            return super.focusSearch(r2, r3);
        }

        public final boolean requestChildRectangleOnScreen(View r2, Rect r3, boolean r4) {
            WeakReference<LynxContext> r0 = this.a;
            if (r0 == null) goto L13;
            if (r0.get() == null) goto L13;
            com.lynx.tasm.behavior.ui.accessibility.d r1 = this.a.get().getLynxAccessibilityWrapper();
            if (r1 == null) goto L13;
            if (r1.e() == false) goto L13;
            return super.requestChildRectangleOnScreen(r2, r3, false);
        L13:
            return super.requestChildRectangleOnScreen(r2, r3, r4);
        }

        public final boolean dispatchNestedPreScroll(int r1, int r2, int[] r3, int[] r4) {
            boolean r5 = super.dispatchNestedPreScroll(r1, r2, r3, r4);
            r(r5);
            return r5;
        }

        public final boolean dispatchNestedPreScroll(int r1, int r2, int[] r3, int[] r4, int r5) {
            boolean r6 = super.dispatchNestedPreScroll(r1, r2, r3, r4, r5);
            r(r6);
            return r6;
        }
    }

    public UIList() {
        throw null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList, com.lynx.tasm.behavior.ui.UIGroup
    public final void onInsertChild(LynxBaseUI r1, int r2) {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setCacheQueueRatio(f6a.a r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setScrollStateChangeEventThrottle(String r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setScrollX(f6a.a r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setScrollY(f6a.a r1) {
    }

    public final boolean W() {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getLynxView() == null) goto L15;
        ThreadStrategyForRendering r1 = this.mContext.getLynxView().getThreadStrategyForRendering();
        if (r1 != ThreadStrategyForRendering.MOST_ON_TASM) goto L10;
    L11:
        return true;
    L10:
        if (r1 == ThreadStrategyForRendering.MULTI_THREADS) goto L11;
        return false;
    L15:
        return false;
    }

    public final boolean X() {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getLynxView() != null) goto L8;
        return false;
    L8:
        if (this.mContext.getLynxView().getThreadStrategyForRendering() != ThreadStrategyForRendering.PART_ON_LAYOUT) goto L12;
        return true;
    L12:
        return false;
    }

    public final void Y() {
        LLog.i("UIList", "onLayoutCompleted " + this.c.h.size());
        if (this.l == true) goto L5;
        return;
    L5:
        if (this.mView.getChildCount() <= 0) goto L16;
        ListEventManager r0 = this.i;
        JavaOnlyArray r1 = this.c.h;
        if ((r0.c & 16) == 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        m7a.a r3 = new m7a.a(r0.j.getSign(), "layoutcomplete");
        r3.a("timestamp", Long.valueOf(new Date().getTime()));
        r3.a("cells", r1);
        r0.a.sendCustomEvent(r3);
    L13:
        this.l = false;
        return;
    L9:
        r2 = false;
        goto L10
    }

    public final void Z() {
        if (this.k0 == null) goto L6;
        Choreographer.getInstance().removeFrameCallback(this.k0);
        this.k0 = null;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        if (this.V == null) goto L5;
        ((RecyclerView) getView()).removeOnScrollListener(this.V);
    L5:
        com.lynx.tasm.behavior.ui.list.a r0 = this.P;
        if (r0 == null) goto L12;
        r0.c.clear();
        r0.d.clear();
        UIList r1 = r0.a;
        if (r1 == null) goto L12;
        if (r1.getView() == 0) goto L12;
        ((RecyclerView) r0.a.getView()).removeOnScrollListener(r0.e);
    L12:
        super.destroy();
        Z();
        ((HashMap) this.y).clear();
        e7a.a r2 = this.s;
        if (r2 == null) goto L16;
        r2.dispose();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Rect getBoundRectForOverflow() {
        if (this.H0 == true) goto L7;
        return super.getBoundRectForOverflow();
    L7:
        return super.getClipBounds();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getMemberScrollX() {
        if (this.x == false) goto L7;
        return 0;
    L7:
        return this.i.l;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getMemberScrollY() {
        if (this.x == true) goto L5;
        return 0;
    L5:
        return this.i.l;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getScrollContainerDirection() {
        if (this.x == false) goto L5;
        return 1;
    L5:
        return -1;
    }

    @LynxUIMethod
    public void initCache() {
        com.lynx.tasm.behavior.ui.list.a r0 = this.P;
        if (r0 == null) goto L6;
        r0.c.clear();
        r0.d.clear();
        this.P.c();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        TraceEvent.beginSection("UIList.layout");
        RecyclerView r1 = this.q;
        if (r1 != null) goto L7;
        r1 = this.mView;
    L7:
        if (r1.isLayoutRequested() == true) goto L10;
        TraceEvent.endSection("UIList.layout");
        return;
    L10:
        layoutChildren();
        ListStickyManager.b r2 = this.q;
        if (r2 == null) goto L13;
        r2.layout(getLeft(), getTop(), getLeft() + getWidth(), getTop() + getHeight());
    L15:
        if (this.H0 == false) goto L36;
        RecyclerView r3 = this.q;
        if (r3 != null) goto L21;
        r3 = this.mView;
    L21:
        ViewParent r4 = r3.getParent();
        if (getOverflow() == 0) goto L24;
        boolean r5 = true;
    L25:
        if (r5 == true) goto L27;
    L29:
        if (r5 == false) goto L34;
        ListStickyManager.b r6 = this.q;
        if (r6 == null) goto L34;
        r6.setClipChildren(false);
    L34:
        if (this.mOverflow == 0) goto L36;
        this.mView.setOverScrollMode(2);
        goto L36
    L27:
        if ((r4 instanceof ViewGroup) == false) goto L29;
        ((ViewGroup) r4).setClipChildren(false);
        goto L29
    L24:
        r5 = false;
    L36:
        ViewCompat.setClipBounds(this.mView, getBoundRectForOverflow());
        this.s.b();
        TraceEvent.endSection("UIList.layout");
        return;
    L13:
        this.mView.layout(getLeft(), getTop(), getLeft() + getWidth(), getTop() + getHeight());
        goto L15
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void layoutChildren() {
        if (this.J == true) goto L5;
    L12:
        super.layoutChildren();
        return;
    L5:
        if (this.q == null) goto L12;
        UIComponent r0 = this.r.f.a;
        if (r0 == null) goto L9;
        r0.performLayoutChildrenUI();
    L9:
        UIComponent r1 = this.r.g.a;
        if (r1 == null) goto L12;
        r1.performLayoutChildrenUI();
        goto L12
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        TraceEvent.beginSection("UIList.measure");
        RecyclerView r1 = this.q;
        if (r1 != null) goto L7;
        r1 = this.mView;
    L7:
        if (r1.isLayoutRequested() == true) goto L10;
        TraceEvent.endSection("UIList.measure");
        return;
    L10:
        measureChildren();
        setLayoutParamsInternal();
        int r2 = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
        if (this.k == false) goto L13;
        int r3 = View.MeasureSpec.makeMeasureSpec((int) this.mMaxHeight, Integer.MIN_VALUE);
    L14:
        ListStickyManager.b r4 = this.q;
        if (r4 == null) goto L17;
        r4.measure(r2, r3);
    L17:
        this.mView.measure(r2, r3);
        this.c.e = true;
        TraceEvent.endSection("UIList.measure");
        return;
    L13:
        r3 = View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824);
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onPropsUpdated() {
        UIList r0 = this;
        super.onPropsUpdated();
        if (r0.p == false) goto L7;
        r0.p = false;
        return;
    L7:
        if (r0.mView.getAdapter() != null) goto L10;
        r0.mView.setAdapter(r0.c);
    L10:
        if (W() == true) goto L12;
    L17:
        boolean r1 = true;
    L18:
        if (r1 == true) goto L31;
        if (r0.A == null) goto L22;
    L23:
        LynxContext r2 = r0.mContext;
        if (r2 != null) goto L26;
        return;
    L26:
        if (r2.getLynxView() == null) goto L327;
        r0.mContext.handleLynxError(new LynxError(220207, "Multi thread strategy can not be used by default.", "Please set the attribute of enable-async-list to true at LynxSDK 2.10+ .", "error"));
        return;
    L327:
        return;
    L22:
        if (r0.D != null) goto L23;
        return;
    L31:
        if (r0.E == false) goto L182;
        r0.c.g = W();
        int r3 = r0.p0;
        if (r3 >= 0) goto L35;
    L37:
        ReadableMap r4 = r0.D;
        if (r4 == null) goto L165;
        UIListAdapter r6 = r0.c;
        r6.d = true;
        ReadableArray r7 = r4.getArray("updateAction");
        ReadableArray r8 = r4.getArray("insertAction");
        ReadableArray r9 = r4.getArray("removeAction");
        if (r7 != null) goto L45;
        if (r8 != null) goto L45;
        if (r9 != null) goto L45;
        ReadableMap r5 = null;
    L163:
        r0.D = r5;
    L184:
        if (r0.h == false) goto L228;
        UIListAdapter r10 = r0.c;
        r10.B.clear();
        int r11 = 0;
    L187:
        if (r11 >= r10.c.d) goto L189;
        r10.B.add(new HashMap());
        r11 = r11 + 1;
        goto L187
    L189:
        new WeakReference(r0);
        if (TextUtils.equals(r0.g, "single") == false) goto L195;
        RecyclerView.LayoutManager r12 = new ListLayoutManager.ListLinearLayoutManager(r0.mContext, r0);
        r12.setOrientation(r0.x ? 1 : 0);
        if (r0.K == true) goto L211;
        r12.setInitialPrefetchItemCount(0);
    L211:
        ListStickyManager r13 = r0.r;
        if (r13 == null) goto L220;
        ListStickyManager.c r14 = r13.f;
        if (r14.b == (-1)) goto L216;
        r13.j(r14);
    L216:
        ListStickyManager.c r15 = r13.g;
        if (r15.b == (-1)) goto L220;
        r13.j(r15);
    L220:
        if (r0.K == true) goto L223;
        if (r12 == null) goto L223;
        boolean r16 = false;
        r12.setItemPrefetchEnabled(false);
    L225:
        if (r0.P == null) goto L227;
        r0.mView.setItemViewCacheSize(r16 ? 1 : 0);
    L227:
        r0.mView.setLayoutManager(r12);
    L229:
        r0.h = r16;
        if ((r0.mView.getLayoutManager() instanceof ListLayoutManager.ListLinearLayoutManager) == false) goto L235;
        ListLayoutManager.ListLinearLayoutManager r17 = r0.mView.getLayoutManager();
        boolean r18 = r17.getStackFromEnd();
        boolean r19 = r0.Y;
        if (r18 == r19) goto L235;
        r17.setStackFromEnd(r19);
    L235:
        if ((r0.mView.getLayoutManager() instanceof GridLayoutManager) == false) goto L238;
        GridLayoutManager r20 = r0.mView.getLayoutManager();
        r20.setSpanSizeLookup(new k(r0, r20));
    L238:
        if (r0.N == true) goto L240;
    L242:
        int r21 = 0;
    L243:
        r0.mView.setLayoutDirection(r21);
        JavaOnlyArray r22 = r0.c.h;
        if (r22 != null) goto L246;
        int r23 = 0;
    L247:
        int r24 = r0.t;
        if (r23 > r24) goto L250;
    L252:
        LLog.i("UIList", "onPropsUpdated viewNames " + r23);
        if ((r0.i.c & 16) == 0) goto L255;
        boolean r25 = true;
    L256:
        if (r25 == true) goto L258;
    L265:
        ListStickyManager r26 = r0.r;
        if (r26 == null) goto L268;
        r26.k(r26.g);
        r26.k(r26.f);
        r0.r.h = r0.v;
    L268:
        r0.j.b.j = r0.x;
        if (r0.F == false) goto L274;
        ListEventManager r27 = r0.i;
        if (r27 == null) goto L274;
        r27.m = 0;
    L274:
        RecyclerView r28 = r0.mView;
        if (r28 != null) goto L277;
    L294:
        LLog.e("UIList", "Fail to update gap item decoration because mView == null or LayoutManager == null");
        return;
    L277:
        if (r28.getLayoutManager() == null) goto L294;
        if (r0.R == true) goto L282;
        GapItemDecoration r29 = r0.S;
        if (r29 == null) goto L329;
        r0.mView.removeItemDecoration(r29);
        return;
    L329:
        return;
    L282:
        if (r0.S != null) goto L284;
        GapItemDecoration r30 = new GapItemDecoration();
        r0.S = r30;
        r0.mView.addItemDecoration(r30);
    L284:
        GapItemDecoration r31 = r0.S;
        r31.a = r0.x;
        if (r0.N == true) goto L287;
    L289:
        boolean r32 = false;
    L290:
        r31.b = r32;
        GapItemDecoration r33 = r0.S;
        r33.c = r0.d;
        r33.d = r0.e;
        r33.e = r0.f;
        r0.mView.invalidateItemDecorations();
        return;
    L287:
        if (isRtl() == false) goto L289;
        r32 = true;
        goto L290
    L258:
        if (r0.Z == true) goto L260;
    L263:
        boolean r34 = true;
    L264:
        r0.l = r34;
        goto L265
    L260:
        if (r0.mView.isLayoutRequested() == true) goto L263;
        r34 = false;
        goto L264
    L255:
        r25 = false;
        goto L256
    L250:
        if (r24 <= (-1)) goto L252;
        r0.j.a(r24, 0, null);
        r0.t = -1;
        goto L252
    L246:
        r23 = r22.size();
        goto L247
    L240:
        if (isRtl() == false) goto L242;
        r21 = 1;
    L223:
        r16 = false;
        goto L225
    L195:
        if (TextUtils.equals(r0.g, "flow") == false) goto L204;
        LynxContext r35 = r0.mContext;
        int r36 = r0.d;
        if (r0.R == false) goto L199;
        int r37 = 0;
    L200:
        r12 = new ListLayoutManager.ListGridLayoutManager(r35, r36, r37, r0);
        r12.setOrientation(r0.x ? 1 : 0);
        if (r0.K == true) goto L211;
        r12.setInitialPrefetchItemCount(0);
        goto L211
    L199:
        r37 = r0.f;
        goto L200
    L204:
        if (TextUtils.equals(r0.g, "waterfall") == false) goto L210;
        int r38 = r0.d;
        if (r0.R == false) goto L208;
        int r39 = 0;
    L209:
        r12 = new ListLayoutManager.b(r38, r39, r0);
        r12.setOrientation(r0.x ? 1 : 0);
        goto L211
    L208:
        r39 = r0.f;
        goto L209
    L210:
        r12 = null;
        goto L211
    L228:
        r16 = false;
    L45:
        if (r6.t != null) goto L48;
        r6.t = new JavaOnlyArray();
    L48:
        if (r6.h != null) goto L51;
        r6.h = new JavaOnlyArray();
    L51:
        if (r6.i != null) goto L54;
        r6.i = new JavaOnlyArray();
    L54:
        if (r6.n != null) goto L57;
        r6.n = new JavaOnlyArray();
    L57:
        if (r6.o != null) goto L60;
        r6.o = new JavaOnlyArray();
    L60:
        if (r6.j != null) goto L63;
        r6.j = new JavaOnlyArray();
    L63:
        if (r6.p != null) goto L66;
        r6.p = new JavaOnlyArray();
    L66:
        if (r6.k != null) goto L69;
        r6.k = new JavaOnlyArray();
    L69:
        if (r6.m != null) goto L71;
        r6.m = new JavaOnlyArray();
    L71:
        UIListAdapter.d r110 = r6.q;
        r110.getClass();
        if (r9 == null) goto L80;
        int r111 = r9.size() - 1;
    L74:
        if (r111 < 0) goto L80;
        int r112 = r9.getInt(r111);
        if (r112 < 0) goto L79;
        r110.g.t.remove(r112);
        r110.g.h.remove(r112);
        r110.g.m.remove(r112);
        r110.g.n.remove(r112);
        r110.g.o.remove(r112);
        r110.g.p.remove(r112);
    L79:
        r111 = r111 - 1;
    L80:
        String r113 = "position";
        String r40 = "type";
        String r41 = "item-key";
        if (r8 == null) goto L93;
        int r42 = 0;
    L84:
        if (r42 >= r8.size()) goto L93;
        ReadableMap r43 = r8.getMap(r42);
        if (r43 == null) goto L92;
        int r44 = r43.getInt(r113);
        String r114 = r43.getString("item-key");
        String r45 = r43.getString("type");
        boolean r115 = r43.getBoolean("full-span", false);
        boolean r210 = r43.getBoolean("sticky-top", false);
        boolean r211 = r43.getBoolean("sticky-bottom", false);
        int r46 = r43.getInt("estimated-height-px", -1);
        r110.g.t.add(r44, r114);
        r110.g.h.add(r44, r45);
        if (r110.g.a.containsKey(r45) == true) goto L91;
        HashMap<String, Integer> r47 = r110.g.a;
        r47.put(r45, Integer.valueOf(r47.size()));
    L91:
        r110.g.n.add(r44, Boolean.valueOf(r115));
        r110.g.o.add(r44, Boolean.valueOf(r210));
        r110.g.p.add(r44, Boolean.valueOf(r211));
        r110.g.m.add(r44, Integer.valueOf(r46));
    L92:
        r42 = r42 + 1;
        r113 = r113;
        r8 = r8;
        r9 = r9;
    L93:
        ReadableArray r116 = r8;
        ReadableArray r117 = r9;
        String r118 = r113;
        if (r7 == null) goto L106;
        int r48 = 0;
    L97:
        if (r48 >= r7.size()) goto L106;
        ReadableMap r49 = r7.getMap(r48);
        if (r49 == null) goto L105;
        int r50 = r49.getInt("from");
        r49.getInt("to");
        String r119 = r49.getString(r41);
        String r51 = r49.getString(r40);
        boolean r212 = r49.getBoolean("full-span", false);
        boolean r213 = r49.getBoolean("sticky-top", false);
        boolean r214 = r49.getBoolean("sticky-bottom", false);
        int r52 = r49.getInt("estimated-height-px", -1);
        r110.g.t.set(r50, r119);
        r110.g.h.set(r50, r51);
        if (r110.g.a.containsKey(r51) == true) goto L104;
        HashMap<String, Integer> r53 = r110.g.a;
        r53.put(r51, Integer.valueOf(r53.size()));
    L104:
        r110.g.n.set(r50, Boolean.valueOf(r212));
        r110.g.o.set(r50, Boolean.valueOf(r213));
        r110.g.p.set(r50, Boolean.valueOf(r214));
        r110.g.m.set(r50, Integer.valueOf(r52));
    L105:
        r48 = r48 + 1;
        r41 = r41;
        r40 = r40;
    L106:
        UIListAdapter.d r54 = r6.q;
        r54.g.i.clear();
        int r55 = 0;
    L108:
        if (r55 >= r54.g.n.size()) goto L113;
        if (r54.g.n.getBoolean(r55) == false) goto L112;
        r54.g.i.add(Integer.valueOf(r55));
    L112:
        r55 = r55 + 1;
        goto L108
    L113:
        r54.g.j.clear();
        int r56 = 0;
    L115:
        if (r56 >= r54.g.o.size()) goto L120;
        if (r54.g.o.getBoolean(r56) == false) goto L119;
        r54.g.j.add(Integer.valueOf(r56));
    L119:
        r56 = r56 + 1;
        goto L115
    L120:
        r54.g.k.clear();
        int r57 = 0;
    L122:
        if (r57 >= r54.g.p.size()) goto L128;
        if (r54.g.p.getBoolean(r57) == false) goto L126;
        r54.g.k.add(Integer.valueOf(r57));
    L126:
        r57 = r57 + 1;
        goto L122
    L128:
        if (r4.getBoolean("reloadAll", false) == true) goto L130;
        UIListAdapter.d r58 = r6.q;
        r58.getClass();
        if (r117 == null) goto L143;
        int r59 = r117.size() - 1;
    L137:
        if (r59 < 0) goto L143;
        ReadableArray r60 = r117;
        int r61 = r60.getInt(r59);
        if (r61 < 0) goto L142;
        r58.g.notifyItemRemoved(r61);
    L142:
        r59 = r59 - 1;
        r117 = r60;
    L143:
        if (r116 == null) goto L152;
        int r62 = 0;
    L146:
        if (r62 >= r116.size()) goto L152;
        ReadableArray r63 = r116;
        ReadableMap r64 = r63.getMap(r62);
        if (r64 != null) goto L150;
        String r65 = r118;
    L151:
        r62 = r62 + 1;
        r116 = r63;
        r118 = r65;
        goto L146
    L150:
        r65 = r118;
        r58.g.notifyItemInserted(r64.getInt(r65));
    L152:
        if (r7 != null) goto L153;
    L133:
        r5 = null;
        r0 = this;
        goto L163
    L153:
        int r66 = 0;
    L155:
        if (r66 >= r7.size()) goto L133;
        ReadableMap r67 = r7.getMap(r66);
        if (r67 == null) goto L162;
        int r68 = r67.getInt("from");
        int r69 = r67.getInt("to");
        if (r67.getBoolean("flush", false) == false) goto L162;
        r58.g.notifyItemChanged(r68, Integer.valueOf(r69));
    L162:
        r66 = r66 + 1;
        goto L155
    L130:
        if (r6.L2() == false) goto L132;
        UIThreadUtils.runOnUiThread(r6.A);
        goto L133
    L132:
        r6.A.run();
        goto L133
    L165:
        if ((r0.A instanceof ReadableMap) == false) goto L184;
        if (r0.Q > 0) goto L169;
    L181:
        r0.c.M2((JavaOnlyMap) r0.A);
        r0.A = null;
        goto L184
    L169:
        if (W() == false) goto L181;
        if (r0.P != null) goto L174;
        r0.P = new com.lynx.tasm.behavior.ui.list.a(r0, r0.Q);
    L174:
        if (r0.Q > 0) goto L176;
        com.lynx.tasm.behavior.ui.list.a r70 = r0.P;
        if (r70 == null) goto L181;
        r70.c.clear();
        r70.d.clear();
        goto L181
    L176:
        if (r0.V != null) goto L181;
        r0.V = new m(r0);
        ((RecyclerView) getView()).addOnScrollListener(r0.V);
        goto L181
    L35:
        if (r3 >= r0.c.getItemCount()) goto L37;
        ((RecyclerView) getView()).scrollToPosition(r0.p0);
        r0.p0 = -1;
        goto L37
    L182:
        r0.c.M2(((com.lynx.tasm.l) r0.a).b(getSign()));
        goto L184
    L12:
        if (r0.E == true) goto L14;
    L16:
        r1 = false;
        goto L18
    L14:
        if (r0.M == false) goto L16;
        goto L16
    }

    @LynxUIMethod
    public void removeStickyView() {
        ListStickyManager r0 = this.r;
        if (r0 == null) goto L6;
        r0.l(r0.f, true, true);
        r0.l(r0.g, false, true);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.k
    public final void requestLayout() {
        this.mView.requestLayout();
        if (this.mView.isLayoutRequested() == true) goto L6;
        RecyclerView r0 = this.mView;
        r0.post(new a(r0));
        return;
    }

    public final int T() {
        LinearLayoutManager r0 = ((RecyclerView) getView()).getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L6;
        return r0.findFirstVisibleItemPosition();
    L6:
        if ((r0 instanceof StaggeredGridLayoutManager) == false) goto L13;
        int r1 = this.d;
        if (r1 <= 0) goto L13;
        int[] r2 = new int[r1];
        ((StaggeredGridLayoutManager) r0).findFirstVisibleItemPositions(r2);
        int r3 = r2[0];
        int r4 = 1;
    L11:
        if (r4 >= this.d) goto L17;
        r3 = Math.min(r3, r2[r4]);
        r4 = r4 + 1;
        goto L11
    L17:
        return r3;
    L13:
        return -1;
    }

    public final int U() {
        LinearLayoutManager r0 = ((RecyclerView) getView()).getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == true) goto L17;
        int r2 = -1;
        if ((r0 instanceof StaggeredGridLayoutManager) == false) goto L14;
        int r1 = this.d;
        if (r1 <= 0) goto L14;
        int[] r3 = new int[r1];
        ((StaggeredGridLayoutManager) r0).findLastVisibleItemPositions(r3);
        int r4 = 0;
    L11:
        if (r4 >= this.d) goto L18;
        r2 = Math.max(r2, r3[r4]);
        r4 = r4 + 1;
        goto L11
    L18:
        return r2;
    L14:
        return -1;
    L17:
        return r0.findLastVisibleItemPosition();
    }

    public final RecyclerView V() {
        return (RecyclerView) getView();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final Map<Integer, t7a.a> getGestureHandlers() {
        return super.getGestureHandlers();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final void onInvalidate() {
        if (isEnableNewGesture() == false) goto L9;
        T r0 = this.mView;
        if (r0 == 0) goto L10;
        ViewCompat.postInvalidateOnAnimation(r0);
        return;
    L10:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r0 = this.mPaddingTop + this.mBorderTopWidth;
        int r1 = this.mPaddingBottom + this.mBorderBottomWidth;
        int r2 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r3 = this.mPaddingRight + this.mBorderRightWidth;
        if (1 != this.mView.getLayoutDirection()) goto L5;
        this.mView.setPadding(r3, r0, r2, r1);
        return;
    L5:
        this.mView.setPadding(r2, r0, r3, r1);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityDirectionVertical() {
        return this.x;
    }

    public static int P(UIList r4) {
        if (r4.getView() == 0) goto L17;
        LinearLayoutManager r0 = ((RecyclerView) r4.getView()).getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L8;
        return r0.findFirstCompletelyVisibleItemPosition();
    L8:
        if ((r0 instanceof StaggeredGridLayoutManager) == false) goto L17;
        int r1 = r4.d;
        if (r1 <= 0) goto L17;
        int[] r2 = new int[r1];
        ((StaggeredGridLayoutManager) r0).findFirstCompletelyVisibleItemPositions(r2);
        int r3 = r2[0];
        int r5 = 1;
    L14:
        if (r5 >= r4.d) goto L21;
        r3 = Math.min(r3, r2[r5]);
        r5 = r5 + 1;
        goto L14
    L21:
        return r3;
    L17:
        return -1;
    }

    public static int Q(UIList r4) {
        int r1 = -1;
        if (r4.getView() == 0) goto L16;
        LinearLayoutManager r0 = ((RecyclerView) r4.getView()).getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L8;
        return r0.findLastCompletelyVisibleItemPosition();
    L8:
        if ((r0 instanceof StaggeredGridLayoutManager) == false) goto L19;
        int r2 = r4.d;
        if (r2 <= 0) goto L20;
        int[] r3 = new int[r2];
        ((StaggeredGridLayoutManager) r0).findLastCompletelyVisibleItemPositions(r3);
        int r5 = 0;
    L14:
        if (r5 >= r4.d) goto L21;
        r1 = Math.max(r1, r3[r5]);
        r5 = r5 + 1;
        goto L14
    L21:
        return r1;
    L20:
        return -1;
    L19:
        return -1;
    L16:
        return -1;
    }

    public final boolean R(int r2) {
        if (this.x == false) goto L7;
        return ((RecyclerView) getView()).canScrollVertically(r2);
    L7:
        return ((RecyclerView) getView()).canScrollHorizontally(r2);
    }

    public RecyclerView S(Context r2) {
        return new d(r2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void consumeGesture(boolean r3) {
        T r0 = this.mView;
        if ((r0 instanceof d) == false) goto L8;
        d r1 = (d) r0;
        r1.g = Boolean.valueOf(r3);
        if (r3 == false) goto L9;
        r1.i = false;
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r4) {
        RecyclerView r0 = S(r4);
        r0.setClipToPadding(false);
        r0.setRecycledViewPool(new j(this));
        this.i = new ListEventManager(getLynxContext().getEventEmitter(), r0, this);
        this.s = new e7a.a(getLynxContext().getEventEmitter(), r0);
        r0.setItemAnimator(null);
        this.c = new UIListAdapter(this, this.s);
        this.j = new com.lynx.tasm.behavior.ui.list.b(r4, r0);
        r0.setOverScrollMode(2);
        if (W() == false) goto L5;
        LynxFeatureCounter.a(88, this.mContext.getInstanceId());
    L5:
        return r0;
    }

    @LynxProp(defaultBoolean = true, name = "enable-nested-scroll")
    public void enableNestedScroll(boolean r2) {
        RecyclerView r0 = this.mView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setNestedScrollingEnabled(r2);
    }

    @LynxProp(defaultBoolean = false, name = "enable-rtl")
    public void enableRtl(boolean r1) {
        this.N = r1;
    }

    @LynxUIMethod
    public void getScrollInfo(Callback r5) {
        int r0 = getMemberScrollX();
        int r1 = getMemberScrollY();
        JavaOnlyMap r2 = new JavaOnlyMap();
        r2.putInt("scrollX", h.h(this.mContext, r0));
        r2.putInt("scrollY", h.h(this.mContext, r1));
        r5.invoke(new Object[]{0, r2});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Object getValueFromNativeStorage(String r2) {
        Map<String, Object> r0 = this.y;
        if (r0 != null) goto L5;
        return null;
    L5:
        return ((HashMap) r0).get(r2);
    }

    @LynxUIMethod
    public void getVisibleCells(Callback r4) {
        if (r4 != null) goto L5;
        LLog.i("UIList", "getVisibleCells with null callback");
        return;
    L5:
        r4.invoke(new Object[]{0, this.i.l()});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void interceptGesture(boolean r3) {
        T r0 = this.mView;
        if ((r0 instanceof d) == false) goto L6;
        Boolean r4 = Boolean.valueOf(r3);
        ((d) r0).h = r4;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final boolean isAtBorder(boolean r2) {
        if (isEnableNewGesture() == true) goto L7;
        return false;
    L7:
        if (r2 == false) goto L11;
        return !R(-1);
    L11:
        return !R(1);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeKeyFromNativeStorage(String r2) {
        Map<String, Object> r0 = this.y;
        if (r0 == null) goto L6;
        ((HashMap) r0).remove(r2);
        return;
    }

    @LynxProp(defaultBoolean = false, name = "android-ignore-attach-for-binding")
    public void setAndroidIgnoreAttachForBinding(boolean r1) {
        this.L = r1;
    }

    @LynxProp(customType = "false", name = "auto-measure")
    public void setAutoMeasure(f6a.a r2) {
        this.k = ListEventManager.j(r2, false);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setColumnCount(int r2) {
        if (this.d != r2) goto L5;
        return;
    L5:
        this.d = r2;
        GridLayoutManager r3 = this.mView.getLayoutManager();
        if ((r3 instanceof GridLayoutManager) == false) goto L9;
        r3.setSpanCount(this.d);
        return;
    L9:
        if ((r3 instanceof StaggeredGridLayoutManager) == false) goto L13;
        ((StaggeredGridLayoutManager) r3).setSpanCount(this.d);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setComponentInitMeasure(boolean r2) {
        UIListAdapter r0 = this.c;
        if (r0 == null) goto L6;
        r0.f = r2;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setCrossAxisGap(float r3) {
        this.f = Math.round(r3);
        RecyclerView.LayoutManager r4 = this.mView.getLayoutManager();
        int r1 = 0;
        if ((r4 instanceof ListLayoutManager.ListGridLayoutManager) == false) goto L10;
        ListLayoutManager.ListGridLayoutManager r5 = (ListLayoutManager.ListGridLayoutManager) r4;
        if (this.R == true) goto L8;
        r1 = this.f;
    L8:
        r5.b = r1;
        return;
    L10:
        if ((r4 instanceof ListLayoutManager.b) == false) goto L18;
        ListLayoutManager.b r6 = (ListLayoutManager.b) r4;
        if (this.R == true) goto L15;
        r1 = this.f;
    L15:
        r6.b = r1;
        return;
    }

    @LynxProp(customType = "true", name = "android-diffable")
    public void setDiffable(f6a.a r3) {
        if (this.mView.getAdapter() != null) goto L6;
        this.c.setHasStableIds(!ListEventManager.j(r3, true));
        return;
    }

    @LynxProp(defaultBoolean = false, name = "enable-async-list")
    public void setEnableAsyncList(boolean r1) {
        this.M = r1;
    }

    @LynxProp(defaultBoolean = false, name = "enable-disappear")
    public void setEnableDisappear(boolean r3) {
        e7a.d r0 = this.s.c;
        if ((r0 instanceof e7a.b) == false) goto L6;
        ((e7a.b) r0).f = r3;
        return;
    }

    @LynxProp(defaultBoolean = true, name = "android-enable-focus-search")
    public void setEnableFocusSearch(boolean r1) {
        this.X = r1;
    }

    @LynxProp(defaultBoolean = false, name = "android-enable-gap-item-decoration")
    public void setEnableGapItemDecoration(boolean r1) {
        this.R = r1;
    }

    @LynxProp(defaultBoolean = true, name = "android-enable-item-prefetch")
    public void setEnableItemPrefetch(boolean r1) {
        this.K = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "android-enable-overflow")
    public void setEnableOverflow(boolean r3) {
        this.H0 = r3;
        T r0 = this.mView;
        if ((r0 instanceof d) == false) goto L6;
        ((d) r0).e = r3;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setEnablePagerSnap(f6a.a r2) {
        if (ListEventManager.j(r2, false) == true) goto L5;
    L10:
        PagerSnapHelper r3 = this.m;
        if (r3 == null) goto L15;
        r3.attachToRecyclerView(null);
        this.m = null;
        return;
    L15:
        return;
    L5:
        if (this.n != null) goto L10;
        if (this.m != null) goto L9;
        this.m = new PagerSnapHelper();
    L9:
        this.m.attachToRecyclerView(this.mView);
    }

    @LynxProp(defaultBoolean = false, name = "enable-size-cache")
    public void setEnableSizeCache(boolean r1) {
        this.O = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setEnableSticky(f6a.a r2) {
        if (ListEventManager.j(r2, false) == true) goto L5;
        return;
    L5:
        if (this.q != null) goto L9;
        ListStickyManager r3 = new ListStickyManager(this);
        this.r = r3;
        this.q = r3.b;
        r3.d = this.u;
        return;
    }

    @LynxProp(defaultBoolean = false, name = "android-enable-strict-scrollable")
    public void setEnableStrictScrollable(boolean r1) {
        this.W = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r3) {
        super.setEvents(r3);
        ListEventManager r0 = this.i;
        r0.c = 0;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.containsKey("scroll") == false) goto L8;
        int r1 = r0.c | 1;
    L9:
        r0.c = r1;
        if (r3.containsKey("scrolltoupper") == false) goto L12;
        int r2 = r0.c | 2;
    L13:
        r0.c = r2;
        if (r3.containsKey("scrolltolower") == false) goto L16;
        int r4 = r0.c | 4;
    L17:
        r0.c = r4;
        if (r3.containsKey("scrollstatechange") == false) goto L20;
        int r5 = r0.c | 8;
    L21:
        r0.c = r5;
        if (r3.containsKey("layoutcomplete") == false) goto L24;
        int r6 = r0.c | 16;
    L25:
        r0.c = r6;
        return;
    L24:
        r6 = r0.c;
        goto L25
    L20:
        r5 = r0.c;
        goto L21
    L16:
        r4 = r0.c;
        goto L17
    L12:
        r2 = r0.c;
        goto L13
    L8:
        r1 = r0.c;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setGestureDetectors(Map<Integer, s7a.a> r1) {
        super.setGestureDetectors(r1);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setInitialScrollIndex(f6a.a r2) {
        this.t = ListEventManager.k(r2, -1);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setInternalCellAppearNotification(boolean r2) {
        super.setInternalCellAppearNotification(r2);
        UIListAdapter r0 = this.c;
        if (r0 == null) goto L6;
        r0.v = r2;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setInternalCellDisappearNotification(boolean r2) {
        super.setInternalCellDisappearNotification(r2);
        UIListAdapter r0 = this.c;
        if (r0 == null) goto L6;
        r0.w = r2;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setInternalCellPrepareForReuseNotification(boolean r2) {
        super.setInternalCellPrepareForReuseNotification(r2);
        UIListAdapter r0 = this.c;
        if (r0 == null) goto L6;
        r0.x = r2;
        return;
    }

    @LynxProp(defaultInt = 0, name = "item-holder-type")
    public void setItemHolderType(f6a.a r2) {
        this.T = ListEventManager.k(r2, 0);
    }

    @LynxProp(defaultBoolean = false, name = "android-new-scroll-top")
    public void setListNewScrollTopSwitch(boolean r1) {
        this.w = r1;
    }

    @LynxProp(defaultBoolean = true, name = "use-old-sticky")
    public void setListOldStickySwitch(boolean r1) {
        this.v = r1;
    }

    @LynxProp(name = "list-platform-info")
    public void setListPlatformInfo(ReadableMap r2) {
        this.E = true;
        this.A = r2;
        this.D = null;
        this.Z = false;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setListType(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        r2 = "single";
    L6:
        if (TextUtils.equals(r2, this.g) == true) goto L9;
        this.h = true;
        this.g = r2;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setLowerThreshold(f6a.a r3) {
        ListEventManager r0 = this.i;
        r0.getClass();
        r0.f = ListEventManager.k(r3, 50);
        r0.h = 0;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setLowerThresholdItemCount(f6a.a r3) {
        ListEventManager r0 = this.i;
        r0.getClass();
        r0.h = ListEventManager.k(r3, 0);
        r0.f = 0;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setMainAxisGap(float r1) {
        this.e = Math.round(r1);
    }

    @LynxProp(defaultDouble = 1.0d, name = "max-fling-velocity-percent")
    public void setMaxFlingVelocityPercent(float r1) {
        this.U = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setNeedVisibleCells(boolean r2) {
        this.i.n = r2;
    }

    @LynxProp(defaultBoolean = false, name = "enable-new-exposure-strategy")
    public void setNewAppear(boolean r4) {
        e7a.a r0 = this.s;
        if (r4 == r0.d) goto L14;
        e7a.d r1 = r0.c;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        r0.d = r4;
        if (r4 == false) goto L11;
        r0.c = new e7a.c(r0.a, r0.b);
        return;
    L11:
        r0.c = new e7a.b(r0.a);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setNoInvalidate(boolean r1) {
        this.p = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setPagingAlignment(ReadableMap r9) {
        if ((r9 instanceof JavaOnlyMap) == true) goto L5;
    L16:
        FactoredPagerSnapHelper r10 = this.n;
        if (r10 == null) goto L20;
        r10.attachToRecyclerView(null);
        this.n = null;
        return;
    L20:
        return;
    L5:
        if (((JavaOnlyMap) r9).size() == 0) goto L16;
        double r0 = r9.getDouble("factor");
        if (r0 >= 0.0d) goto L9;
    L10:
        getLynxContext().handleLynxError(new LynxError(220205, "item-snap invalid!", "The factor should be constrained to the range of [0,1].", LynxError.LEVEL_WARN));
        r0 = 0.0d;
    L11:
        int r11 = r9.getInt("offset", 0);
        if (this.n != null) goto L14;
        FactoredPagerSnapHelper r2 = new FactoredPagerSnapHelper();
        this.n = r2;
        r2.attachToRecyclerView(this.mView);
        this.n.a = new b(this);
    L14:
        FactoredPagerSnapHelper r3 = this.n;
        r3.c = r0;
        r3.d = r11;
        return;
    L9:
        if (r0 <= 1.0d) goto L11;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptAncestors(boolean r2) {
        T r3 = this.mView;
        if ((r3 instanceof d) == false) goto L6;
        ((d) r3).getClass();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptDescendants(boolean r3) {
        T r0 = this.mView;
        if ((r0 instanceof d) == false) goto L6;
        ((d) r0).k = r3;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptSelf(boolean r3) {
        T r0 = this.mView;
        if ((r0 instanceof d) == false) goto L6;
        ((d) r0).j = r3;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "android-preference-consume-gesture")
    public void setPreferenceConsumeGesture(boolean r3) {
        T r0 = this.mView;
        if ((r0 instanceof d) == false) goto L6;
        ((d) r0).d = r3;
        return;
    }

    @LynxProp(defaultInt = 0, name = "preload-buffer-count")
    public void setPreloadBufferCount(f6a.a r2) {
        this.Q = ListEventManager.k(r2, 0);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setScrollEnable(f6a.a r2) {
        this.o = ListEventManager.j(r2, true);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setScrollEventThrottle(f6a.a r3) {
        ListEventManager r0 = this.i;
        r0.getClass();
        r0.d = ListEventManager.k(r3, 200);
    }

    @LynxProp(defaultInt = -1, name = "scroll-index")
    public void setScrollIndex(int r1) {
        this.p0 = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setShouldRequestStateRestore(boolean r2) {
        super.setInternalCellAppearNotification(r2);
        UIListAdapter r0 = this.c;
        if (r0 == null) goto L6;
        r0.v = r2;
        r0.w = r2;
        r0.x = r2;
        return;
    }

    @LynxProp(defaultBoolean = false, name = "android-stack-from-end")
    public void setStackFromEnd(boolean r1) {
        this.Y = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setStickyOffset(f6a.a r2) {
        int r3 = (int) i.b(ListEventManager.k(r2, 0), 0.0f);
        ListStickyManager r0 = this.r;
        if (r0 != null) goto L5;
        this.u = r3;
        return;
    L5:
        r0.d = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setTouchScroll(f6a.a r3) {
        T r0 = this.mView;
        if ((r0 instanceof d) == false) goto L6;
        boolean r4 = ListEventManager.j(r3, true);
        ((d) r0).c = r4;
        return;
    }

    @LynxProp(defaultBoolean = false, name = "android-trigger-sticky-layout")
    public void setTriggerStickyLayout(boolean r1) {
        this.J = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setUpdateAnimation(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L6:
        this.mView.setItemAnimator(null);
    L8:
        if (TextUtils.equals(r3, LynxUIWebView.DEFAULT) == false) goto L11;
        this.mView.setItemAnimator(new DefaultItemAnimator());
        return;
    L11:
        return;
    L5:
        if (TextUtils.equals(r3, VoiceDisplayScene.NONE) == false) goto L8;
        goto L6
    }

    @LynxProp(defaultBoolean = false, name = "scroll-upper-lower-switch")
    public void setUpperLowerSwitch(boolean r1) {
        this.F = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setUpperThreshold(f6a.a r3) {
        ListEventManager r0 = this.i;
        r0.getClass();
        r0.e = ListEventManager.k(r3, 50);
        r0.g = 0;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setUpperThresholdItemCount(f6a.a r3) {
        ListEventManager r0 = this.i;
        r0.getClass();
        r0.g = ListEventManager.k(r3, 0);
        r0.e = 0;
    }

    @LynxProp(defaultBoolean = true, name = "vertical-orientation")
    public void setVerticalOrientation(boolean r1) {
        this.x = r1;
    }

    @LynxProp(name = "update-list-info")
    public void updateListActionInfo(ReadableMap r2) {
        this.E = true;
        this.D = r2;
        this.A = null;
        this.Z = true;
    }

    public UIList(LynxContext r4, Object r5) {
        super(r4, r5);
        this.d = 1;
        this.e = 0;
        this.f = 0;
        this.g = "single";
        this.h = true;
        this.k = false;
        this.l = false;
        this.o = true;
        this.p = false;
        this.t = -1;
        this.u = 0;
        this.v = true;
        this.w = false;
        this.x = true;
        this.y = new HashMap();
        this.z = new HashMap();
        this.B = new ArrayList();
        this.C = new HashMap();
        this.F = false;
        this.G = false;
        this.H = 0;
        this.I = true;
        this.J = false;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.Q = 0;
        this.R = false;
        this.S = null;
        this.T = 0;
        this.U = 1.0f;
        this.V = null;
        this.W = false;
        this.X = true;
        this.Y = false;
        this.Z = false;
        this.k0 = null;
        this.p0 = -1;
        this.H0 = false;
    }

    @LynxUIMethod
    public void autoScroll(ReadableMap r5, Callback r6) {
        String r0 = r5.getString("rate", NameKeys.UnloadStrategy_No_Strategy);
        this.G = r5.getBoolean("start", true);
        this.I = r5.getBoolean("autoStop", true);
        if (this.G == false) goto L19;
        int r7 = (int) n.d(r0, 0.0f, 0.0f, this.mContext.getScreenMetrics());
        if (r7 != 0) goto L8;
        r6.invoke(new Object[]{1, "rate is not right"});
        return;
    L8:
        LynxContext r1 = getLynxContext();
        if (r1 != null) goto L11;
        float r2 = 60.0f;
    L12:
        int r3 = (int) r2;
        if (r3 > 0) goto L15;
        r3 = 60;
    L15:
        if (r7 <= 0) goto L17;
        int r8 = Math.max(r7 / r3, 1);
    L18:
        this.H = r8;
        Z();
        this.k0 = new l(this);
        Choreographer.getInstance().postFrameCallback(this.k0);
    L20:
        r6.invoke(new Object[]{0});
        return;
    L17:
        r8 = Math.min(r7 / r3, -1);
        goto L18
    L11:
        r2 = DeviceUtils.c(r1.getContext());
        goto L12
    L19:
        Z();
        goto L20
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final boolean canConsumeGesture(float r5, float r6) {
        if (isEnableNewGesture() == true) goto L6;
        return false;
    L6:
        if (this.x == false) goto L18;
        if (isAtBorder(true) == false) goto L12;
        if (r6 >= 0.0f) goto L12;
        return false;
    L12:
        if (isAtBorder(false) == true) goto L14;
    L15:
        return true;
    L14:
        if (r6 <= 0.0f) goto L15;
        return false;
    L18:
        if (isAtBorder(true) == false) goto L22;
        if (r5 >= 0.0f) goto L22;
        return false;
    L22:
        if (isAtBorder(false) == true) goto L24;
    L25:
        return true;
    L24:
        if (r5 <= 0.0f) goto L25;
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget hitTest(float r2, float r3) {
        return hitTest(r2, r3, false);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean initialPropsFlushed(String r1, String r2) {
        if (this.y == null) goto L10;
        HashSet r3 = (HashSet) ((HashMap) this.z).get(r1);
        if (r3 != null) goto L7;
        return false;
    L7:
        if (r3.contains(r1) == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final void onGestureScrollBy(final float r2, final float r3) {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        UIThreadUtils.runOnUiThreadImmediately(new e7a.h(this, r2, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v9, types: [android.view.View] */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutFinish(long r9, LynxBaseUI r11) {
        boolean r2 = true;
        if (W() == true) goto L5;
        UIListAdapter r12 = this.c;
        r12.getClass();
        if (r12.g == true) goto L102;
        ListViewHolder r10 = r12.b.remove(Long.valueOf(r9));
        if (r10 == null) goto L103;
        UIComponent r13 = r10.a.b;
        if (r13 == null) goto L87;
        r13.setTop(0);
        r13.setLeft(0);
        r13.requestLayout();
        if (r13.getWidth() == ((RecyclerView.ViewHolder) r10).itemView.getWidth()) goto L74;
        boolean r0 = true;
    L76:
        if (r13.getHeight() != ((RecyclerView.ViewHolder) r10).itemView.getHeight()) goto L79;
        r2 = false;
    L79:
        if (r0 == true) goto L81;
        if (r2 == true) goto L81;
    L82:
        UIList r1 = r12.c;
        if (r1.O == false) goto L87;
        if (r1.X() == false) goto L87;
        r12.O2(r13);
    L81:
        ((RecyclerView.ViewHolder) r10).itemView.requestLayout();
        goto L82
    L74:
        r0 = false;
    L87:
        r10.a.a = 2;
        return;
    L103:
        return;
    L102:
        return;
    L5:
        if ((r11 instanceof UIComponent) == false) goto L62;
        UIListAdapter r3 = this.c;
        UIComponent r14 = (UIComponent) r11;
        ListViewHolder r4 = r3.b.get(Long.valueOf(r9));
        r3.O2(r14);
        if (r4 != null) goto L9;
    L31:
        UIList r15 = r3.c;
        if (r15.P == null) goto L61;
        int r16 = r15.T();
        int r17 = r3.c.U();
        HashMap<String, Integer> r5 = r3.u;
        if (r5 != null) goto L36;
    L60:
        r3.I2(r14);
        return;
    L36:
        if (r5.containsKey(r14.b) == false) goto L60;
        int r6 = r3.u.get(r14.b).intValue();
        if (r16 == (-1)) goto L42;
        if (r6 > r16) goto L42;
        boolean r7 = true;
    L43:
        if (r7 == true) goto L47;
        if (r17 == (-1)) goto L47;
        if (r6 < r17) goto L47;
        boolean r8 = true;
    L48:
        UIList r18 = r3.c;
        int r19 = r18.Q;
        if (r6 >= (r16 - r19)) goto L51;
        return;
    L51:
        if (r6 > (r17 + r19)) goto L93;
        if (r7 == true) goto L54;
        if (r8 == true) goto L58;
        return;
    L58:
        if (r18.P.b(r14.b) == true) goto L97;
        r3.c.P.a(r14, false);
        return;
    L97:
        return;
    L54:
        if (r18.P.b(r14.b) == true) goto L94;
        r3.c.P.a(r14, true);
        return;
    L94:
        return;
    L93:
        return;
    L47:
        r8 = false;
    L42:
        r7 = false;
        goto L43
    L61:
        r3.I2(r14);
        return;
    L9:
        if (r4.b != r9) goto L31;
        r3.b.remove(Long.valueOf(r9));
        if (r3.c.P == null) goto L21;
        if (r4.a.b != r14) goto L24;
        if (r14.getView() == 0) goto L24;
        if (((RecyclerView.ViewHolder) r4).itemView != ((com.lynx.tasm.behavior.ui.view.a) r14.getView()).getParent()) goto L24;
        r3.s.c(r4);
        r4.a.a = 2;
        ((RecyclerView.ViewHolder) r4).itemView.requestLayout();
        return;
    L24:
        if (r4.a.b == null) goto L26;
        r3.H2(r4);
    L26:
        if (r14 != null) goto L28;
    L30:
        r4.a.a = 2;
        r4.U3(r14);
        r3.s.c(r4);
        r14.setTop(0);
        r14.setLeft(0);
        r14.requestLayout();
        r3.O2(r14);
        ((RecyclerView.ViewHolder) r4).itemView.requestLayout();
        return;
    L28:
        if (((com.lynx.tasm.behavior.ui.view.a) r14.getView()).getParent() == null) goto L30;
        ((ViewGroup) ((com.lynx.tasm.behavior.ui.view.a) r14.getView()).getParent()).removeView(r14.getView());
        goto L30
    L21:
        if (r4.a.b != r14) goto L24;
        r3.s.c(r4);
        r4.a.a = 2;
        ((RecyclerView.ViewHolder) r4).itemView.requestLayout();
        return;
    L62:
        LLog.e("UIList", "component is null! the operationId is " + r9);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float[] scrollBy(float r8, float r9) {
        float[] r0 = new float[4];
        this.mView.scrollBy((int) r8, (int) r9);
        if (Math.abs(r8) <= Float.MIN_VALUE) goto L5;
    L6:
        recognizeGesturere();
    L8:
        if ((this.mView.getLayoutManager() instanceof ListLayoutManager.a) == true) goto L10;
        r0[0] = 0.0f;
        r0[1] = 0.0f;
        r0[2] = r8;
        r0[3] = r9;
    L14:
        return r0;
    L10:
        if (this.x == false) goto L12;
        r0[0] = 0.0f;
        float r1 = this.mView.getLayoutManager().g();
        r0[1] = r1;
        r0[2] = r8;
        r0[3] = r9 - r1;
        goto L14
    L12:
        float r2 = this.mView.getLayoutManager().f();
        r0[0] = r2;
        r0[1] = 0.0f;
        r0[2] = r8 - r2;
        r0[3] = r9;
        goto L14
    L5:
        if (Math.abs(r9) <= Float.MIN_VALUE) goto L8;
        goto L6
    }

    @LynxUIMethod
    public void scrollToPosition(ReadableMap r11, Callback r12) {
        if (this.c != null) goto L6;
        r12.invoke(new Object[]{1, "scrollToPosition before init"});
        return;
    L6:
        int r0 = r11.getInt("index", r11.getInt("position", 0));
        int r4 = (int) i.a(r11.getDouble("offset", 0.0d));
        boolean r7 = r11.getBoolean("smooth", false);
        int r5 = (int) i.a(r11.getDouble("itemHeight", 0.0d));
        String r8 = VoiceDisplayScene.NONE;
        String r13 = r11.getString("alignTo", VoiceDisplayScene.NONE);
        if (r0 >= 0) goto L9;
    L39:
        r12.invoke(new Object[]{4, "position < 0 or position >= data count"});
        return;
    L9:
        if (r0 > this.c.getItemCount()) goto L39;
        if (r7 == false) goto L31;
        com.lynx.tasm.behavior.ui.list.b r6 = this.j;
        r6.getClass();
        StringBuilder r9 = new StringBuilder("ListScroller scrollToPositionSmoothly: position=");
        r9.append(r0);
        r9.append(", offset=");
        r9.append(r4);
        r9.append(", alignTo: ");
        if (r13 == null) goto L15;
        r8 = r13;
    L15:
        r9.append(r8);
        LLog.i("UIList", r9.toString());
        com.lynx.tasm.behavior.ui.list.b.a r10 = r6.b;
        RecyclerView r14 = r10.a.get();
        if (r14 != null) goto L18;
    L28:
        r10.i = false;
        r12.invoke(new Object[]{4, "can not scroll before init"});
        return;
    L18:
        if (r14.getLayoutManager() == null) goto L28;
        if (r14.getChildCount() == 0) goto L28;
        if (r14.isAttachedToWindow() == true) goto L25;
        r10.i = false;
        LLog.e("UIList", "ListScroller start: early return due to view is not attached to window.");
        r12.invoke(new Object[]{7, "can not invoke scroll when the view is not attached to window."});
        return;
    L25:
        r10.b = r12;
        r10.c = r0;
        r10.d = r13;
        r10.e = r4;
        r10.h = null;
        if (r10.i == true) goto L42;
        r10.i = true;
        r14.stopScroll();
        r14.stopNestedScroll();
        r14.addOnItemTouchListener(r10.k);
        r14.post(r10);
        return;
    L42:
        return;
    L31:
        if (TextUtils.equals(r13, "middle") == false) goto L34;
        int r15 = (((RecyclerView) getView()).getHeight() - r5) / 2;
    L36:
        r4 = r4 + r15;
    L37:
        this.j.a(r0, r4, r12);
        this.mView.post(new c(this));
        return;
    L34:
        if (TextUtils.equals(r13, "bottom") == false) goto L37;
        r15 = ((RecyclerView) getView()).getHeight() - r5;
        goto L36
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setInitialPropsHasFlushed(String r2, String r3) {
        if (this.y != null) goto L5;
        return;
    L5:
        if (((HashMap) this.z).containsKey(r3) == false) goto L7;
        HashSet r0 = (HashSet) ((HashMap) this.z).get(r3);
    L8:
        r0.add(r2);
        ((HashMap) this.y).put(r3, r0);
        return;
    L7:
        r0 = new HashSet();
        goto L8
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void storeKeyToNativeStorage(String r2, Object r3) {
        Map<String, Object> r0 = this.y;
        if (r0 == null) goto L6;
        ((HashMap) r0).put(r2, r3);
        return;
    }

    @LynxUIMethod
    public void scrollBy(ReadableMap r4, final Callback r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r4 != null) goto L6;
    L10:
        r5.invoke(new Object[]{4, "Invoke scrollBy failed due to index param is null"});
        return;
    L6:
        if (r4.hasKey("offset") == false) goto L10;
        final double r0 = i.a(r4.getDouble("offset", 0.0d));
        UIThreadUtils.runOnUiThreadImmediately(new e7a.i(this, r0, r5));
    }

    public static /* synthetic */ void O(UIList r0, float r1, float r2) {
        RecyclerView r3 = r0.mView;
        if (r3 == null) goto L7;
        r3.scrollBy((int) r1, (int) r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget hitTest(float r7, float r8, boolean r9) {
        if (this.c != null) goto L5;
        return this;
    L5:
        ListStickyManager r0 = this.r;
        EventTarget r1 = null;
        if (r0 == null) goto L18;
        int r2 = (int) r7;
        int r3 = (int) r8;
        if (r0.f.a == null) goto L14;
        Rect r4 = new Rect();
        ((com.lynx.tasm.behavior.ui.view.a) r0.f.a.getView()).getHitRect(r4);
        if (r4.contains(r2, r3) == false) goto L14;
        UIComponent r5 = r0.f.a;
        EventTarget r6 = r5.hitTest(r2 - ((com.lynx.tasm.behavior.ui.view.a) r5.getView()).getLeft(), r3 - ((com.lynx.tasm.behavior.ui.view.a) r0.f.a.getView()).getTop(), r9);
    L12:
        r1 = r6;
    L14:
        if (r0.g.a == null) goto L18;
        Rect r10 = new Rect();
        ((com.lynx.tasm.behavior.ui.view.a) r0.g.a.getView()).getHitRect(r10);
        if (r10.contains(r2, r3) == false) goto L18;
        UIComponent r11 = r0.g.a;
        r6 = r11.hitTest(r2 - ((com.lynx.tasm.behavior.ui.view.a) r11.getView()).getLeft(), r3 - ((com.lynx.tasm.behavior.ui.view.a) r0.g.a.getView()).getTop(), r9);
    L18:
        if (r1 == null) goto L20;
        return r1;
    L20:
        int r12 = this.mView.getChildCount() - 1;
    L21:
        if (r12 < 0) goto L33;
        View r13 = this.mView.getChildAt(r12);
        RecyclerView.ViewHolder r14 = this.mView.getChildViewHolder(r13);
        if ((r14 instanceof ListViewHolder) == false) goto L32;
        ListViewHolder r15 = (ListViewHolder) r14;
        if (r15 == null) goto L32;
        UIComponent r16 = r15.a.b;
        if (r16 == null) goto L32;
        if (r16.containsPoint(r7 - r13.getLeft(), r8 - r13.getTop(), r9) == false) goto L32;
        return r16.hitTest(r7 - r13.getLeft(), r8 - r13.getTop(), r9);
    L32:
        r12 = r12 - 1;
        goto L21
    L33:
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean requestChildUIRectangleOnScreen(LynxBaseUI r8, Rect r9, boolean r10) {
        if (this.o == true) goto L5;
    L14:
        return false;
    L5:
        if ((r8 instanceof UIComponent) == false) goto L14;
        UIComponent r11 = (UIComponent) r8;
        if (r11.getView() == 0) goto L14;
        Object r12 = ((com.lynx.tasm.behavior.ui.view.a) r11.getView()).getParent();
        if ((r12 instanceof ListViewHolder.b) == true) goto L12;
        return false;
    L12:
        View r3 = (View) r12;
        return this.mView.getLayoutManager().requestChildRectangleOnScreen(this.mView, r3, r9, false, false);
    }

    public final void a0(int r4, int r5, int r6, int r7, int r8) {
        boolean r0 = this.x;
        if (r0 == true) goto L6;
        r5 = this.i.l;
    L6:
        if (r0 == false) goto L8;
        r6 = this.i.l;
    L8:
        int r9 = r7 + r5;
        int r10 = r8 + r6;
        if (r5 != r9) goto L11;
        if (r6 != r10) goto L11;
        return;
    L11:
        m7a.a r1 = new m7a.a(getSign(), "snap");
        r1.a("position", Integer.valueOf(r4));
        r1.a("currentScrollLeft", Float.valueOf(i.c(r5)));
        r1.a("currentScrollTop", Float.valueOf(i.c(r6)));
        r1.a("targetScrollLeft", Float.valueOf(i.c(r9)));
        r1.a("targetScrollTop", Float.valueOf(i.c(r10)));
        this.mContext.getEventEmitter().sendCustomEvent(r1);
    }
}
