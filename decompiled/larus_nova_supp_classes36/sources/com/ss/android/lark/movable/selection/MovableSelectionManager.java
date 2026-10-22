package com.ss.android.lark.movable.selection;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.lark.lark_markdown_render_android.FfiCaret;
import com.bytedance.lark.lark_markdown_render_android.Lark_markdown_renderKt;
import com.bytedance.lark.lark_markdown_render_android.MovableDocumentInfo;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.MovableGlobalManager;
import com.ss.android.lark.movable.MovableView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MovableSelectionManager {
    public static final /* synthetic */ int B = 0;
    public final Lazy A;
    public final MovableView a;
    public final Lifecycle b;
    public final h c;
    public final ViewGroup d;
    public final ViewGroup e;
    public final g f;
    public final boolean g;
    public final boolean h;
    public final MovableLongPressBehavior i;
    public final HandleStyle j;
    public final int k;
    public final Function0<Unit> l;
    public final Function0<Unit> m;
    public final Context n;
    public final ksb.b o;
    public GestureDetector p;
    public boolean q;
    public boolean r;
    public boolean s;
    public float t;
    public float u;
    public j v;
    public com.ss.android.lark.movable.selection.d w;
    public final com.ss.android.lark.movable.selection.c x;
    public final com.ss.android.lark.movable.selection.d y;
    public final com.ss.android.lark.movable.selection.d z;

    public static final class a {
        public h a;
        public g b;
        public boolean c;
        public boolean d;
        public MovableLongPressBehavior e;
        public HandleStyle f;
        public Integer g;
        public Function0<Unit> h;
        public Function0<Unit> i;

        public a() {
            this.a = new com.ss.android.lark.movable.selection.a();
            this.b = new n();
            this.e = MovableLongPressBehavior.PARTIAL_SELECTION;
            this.f = HandleStyle.LINE;
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[HandleStyle.values().length];
            r0[HandleStyle.LINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[HandleStyle.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class d implements View.OnTouchListener {
        public final /* synthetic */ MovableSelectionManager a;
        public final /* synthetic */ com.ss.android.lark.movable.selection.d b;

        public d(MovableSelectionManager r1, com.ss.android.lark.movable.selection.d r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r5, MotionEvent r6) {
            if (r6.getAction() != 0) goto L16;
            MovableSelectionManager r0 = this.a;
            r0.w = this.b;
            MovableSelectionManager r1 = r0.j();
            if (r1 == null) goto L7;
            r1.s = true;
        L7:
            MovableSelectionManager r2 = this.a.j();
            if (r2 == null) goto L12;
            Function0<Unit> r3 = r2.l;
            if (r3 == null) goto L12;
            r3.invoke();
        L12:
            ViewParent r4 = this.a.a.getParent();
            if (r4 == null) goto L15;
            r4.requestDisallowInterceptTouchEvent(true);
        L15:
            Lark_markdown_renderKt.ffiMovableCallPickCaret-zly0blg(this.b.mo1477getCaretIdpVg5ArA(), this.a.g(), this.a.h());
        L16:
            MovableSelectionManager r7 = this.a;
            Intrinsics.checkNotNull(r6);
            Intrinsics.checkNotNull(r5);
            r7.getClass();
            int[] r8 = new int[2];
            int[] r9 = new int[2];
            r5.getLocationOnScreen(r8);
            r7.a.getLocationOnScreen(r9);
            MotionEvent r10 = MotionEvent.obtain(r6);
            r10.offsetLocation(r8[0] - r9[0], r8[1] - r9[1]);
            this.a.k(r10);     // Catch: Throwable -> L20
            r10.recycle();
            return true;
        L20:
            th = move-exception;
            r10.recycle();
            throw th;
        }
    }

    static {
    }

    public MovableSelectionManager() {
        throw null;
    }

    public final void c() {
        com.ss.android.lark.movable.selection.c r0 = this.x;
        Iterator r1 = CollectionsKt.toList(((LinkedHashMap) r0.b).keySet()).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.a((com.ss.android.lark.movable.selection.d) r1.next());
        goto L4
    L6:
        m(this.y);
        this.y.onCleared();
        m(this.z);
        this.z.onCleared();
    }

    public final int g() {
        MovableDocumentInfo r0 = this.a.getMovableDocumentInfo();
        if (r0 != null) goto L7;
        return 1;
    L7:
        return r0.getDocumentId-pVg5ArA();
    }

    public final int h() {
        MovableDocumentInfo r0 = this.a.getMovableDocumentInfo();
        if (r0 != null) goto L7;
        return 1;
    L7:
        return r0.getDocumentVersion-pVg5ArA();
    }

    public final int i() {
        return UInt.constructor-impl(this.a.getMovableInstanceId$movable_release());
    }

    public final MovableSelectionManager j() {
        return this.a.getRootMovableView().getSelectionManager$movable_release();
    }

    public final void d() {
        Lark_markdown_renderKt.ffiMovableCallTouchCancelled-zly0blg(i(), g(), h());
        this.q = false;
        this.r = false;
        this.s = false;
        this.w = null;
        c();
        if (Intrinsics.areEqual(this, j()) == false) goto L29;
        Iterator<T> r1 = this.a.getInnerMovableViews().iterator();
    L6:
        if (r1.hasNext() == false) goto L29;
        MovableSelectionManager r2 = ((MovableView) r1.next()).getSelectionManager$movable_release();
        if (r2 == null) goto L6;
        r2.c();
    L29:
        ViewParent r3 = this.a.getParent();     // Catch: Exception -> L14
        if (r3 == null) goto L16;
        r3.requestDisallowInterceptTouchEvent(false);     // Catch: Exception -> L14
    L16:
        if (Build.VERSION.SDK_INT < 28) goto L20;
        f r0 = (f) this.A.getValue();
        if (r0 == null) goto L20;
        r0.b.dismiss();
    L20:
        MovableSelectionManager r4 = j();
        if (r4 == null) goto L25;
        j r5 = r4.v;
        if (r5 == null) goto L25;
        r5.a();
    L25:
        Function0<Unit> r6 = this.m;
        if (r6 == null) goto L35;
        r6.invoke();
        return;
    }

    public final void n() {
        if (Intrinsics.areEqual(this, j()) == true) goto L9;
        MovableSelectionManager r0 = j();
        if (r0 == null) goto L21;
        r0.n();
        return;
    L21:
        return;
    L9:
        if (this.i != MovableLongPressBehavior.SELECT_ALL_AND_DISPATCH) goto L14;
        if (this.s == true) goto L14;
        return;
    L14:
        if (this.v != null) goto L19;
        j r1 = new j(this.n);
        Lifecycle r2 = this.b;
        if (r2 == null) goto L18;
        r2.addObserver(new MovableSelectionManager$initDialog$1$1(this));
    L18:
        this.v = r1;
    L19:
        final List r3 = CollectionsKt.listOf(new o[]{new o(UIUtils.getString(this.n, 2131891639), UIUtils.getDrawable(this.n, 2131254165), new MovableSelectionManager$showMenu$menuItems$1(this)), new o(UIUtils.getString(this.n, 2131892182), UIUtils.getDrawable(this.n, 2131254803), new MovableSelectionManager$showMenu$menuItems$2(this))});
        this.a.post(new MovableSelectionManager$showMenu$1(this, r3));
    }

    public static final void a(MovableSelectionManager r2) {
        r2.getClass();
        MovableGlobalManager r0 = MovableGlobalManager.d.a();
        MovableView r3 = r2.a;
        Intrinsics.checkNotNullParameter(r3, "activeMovableView");
        MovableGlobalManager.d(new com.ss.android.lark.movable.e(r3, r0));
    }

    public static void m(com.ss.android.lark.movable.selection.d r2) {
        ViewParent r0 = r2.getView().getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L9;
        r1.removeView(r2.getView());
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final Pair<Rect, Rect> b(boolean r13) {
        com.ss.android.lark.movable.selection.d r1 = e(true);
        if (r1 != null) goto L5;
        return null;
    L5:
        com.ss.android.lark.movable.selection.d r4 = e(false);
        if (r4 != null) goto L8;
        return null;
    L8:
        int[] r5 = new int[2];
        r1.getView().getLocationOnScreen(r5);
        int[] r2 = new int[2];
        r4.getView().getLocationOnScreen(r2);
        int r6 = r5[0];
        int r7 = r5[1];
        int r3 = r2[0];
        int r0 = r2[1];
        Rect r8 = r1.getVisibleInsets();
        Rect r9 = r4.getVisibleInsets();
        if (r13 == false) goto L11;
        Rect r10 = new Rect(r6, r7, r1.getView().getWidth() + r6, r1.getView().getHeight() + r7);
    L12:
        if (r13 == false) goto L14;
        Rect r14 = new Rect(r3, r0, r4.getView().getWidth() + r3, r4.getView().getHeight() + r0);
    L16:
        return new Pair(r10, r14);
    L14:
        r14 = new Rect(r9.left + r3, r9.top + r0, (r3 + r4.getView().getWidth()) - r9.right, (r0 + r4.getView().getHeight()) - r9.bottom);
        goto L16
    L11:
        r10 = new Rect(r8.left + r6, r8.top + r7, (r6 + r1.getView().getWidth()) - r8.right, (r7 + r1.getView().getHeight()) - r8.bottom);
        goto L12
    }

    public final com.ss.android.lark.movable.selection.d e(boolean r5) {
        MovableView r0 = this.a.getRootMovableView();
        List r1 = CollectionsKt.plus(r0.getInnerMovableViews(), r0);
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L3:
        Object r4 = null;
        if (r3.hasNext() == false) goto L12;
        MovableSelectionManager r6 = ((MovableView) r3.next()).getSelectionManager$movable_release();
        if (r5 == false) goto L9;
        if (r6 == null) goto L11;
        r4 = r6.y;
    L11:
        r2.add(r4);
        goto L3
    L9:
        if (r6 == null) goto L11;
        r4 = r6.z;
        goto L11
    L12:
        Iterator r7 = r2.iterator();
    L14:
        if (r7.hasNext() == false) goto L27;
        Object r8 = r7.next();
        com.ss.android.lark.movable.selection.d r9 = (com.ss.android.lark.movable.selection.d) r8;
        if (r9 == null) goto L20;
        View r10 = r9.getView();
        if (r10 == null) goto L20;
        ViewParent r11 = r10.getParent();
    L21:
        if (r11 == null) goto L23;
        boolean r12 = true;
    L24:
        if (r12 == false) goto L14;
        r4 = r8;
        goto L27
    L23:
        r12 = false;
    L20:
        r11 = null;
    L27:
        return (com.ss.android.lark.movable.selection.d) r4;
    }

    public final com.ss.android.lark.movable.selection.d f(HandleType r4) {
        HandleStyle r0 = this.j;
        int r1 = c.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        AppCompatImageView r2 = new e(this.n, r4);
        int r5 = com.ss.android.lark.movable.utils.b.e(11, r2.getContext());
        int r3 = com.ss.android.lark.movable.utils.b.e(5, r2.getContext());
        r2.setPadding(r5, r3, r5, r3);
    L10:
        r2.getView().setOnTouchListener(new d(this, r2));
        return r2;
    L5:
        if (r1 != 2) goto L8;
        r2 = new CursorHandle(this.n, r4, this.k);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void k(MotionEvent r8) {
        int r0 = r8.getAction();
        if (r0 == 0) goto L77;
        ViewParent r1 = null;
        boolean r2 = false;
        boolean r3 = true;
        if (r0 == 1) goto L57;
        if (r0 != 2) goto L9;
        float r4 = Math.abs(r8.getX() - this.t);
        float r5 = Math.abs(r8.getY() - this.u);
        if (r4 > 2.0f) goto L16;
        if (r5 > 2.0f) goto L16;
        return;
    L16:
        if (this.q == true) goto L23;
        if (this.w == null) goto L20;
        boolean r6 = true;
    L21:
        if (r6 == true) goto L23;
        return;
    L20:
        r6 = false;
    L23:
        if (Build.VERSION.SDK_INT < 28) goto L28;
        f r7 = (f) this.A.getValue();
        if (r7 == null) goto L28;
        r7.b.a(r8.getX(), r8.getY());
    L28:
        if (this.q == false) goto L44;
        if (this.r == true) goto L44;
        com.ss.android.lark.movable.selection.d r9 = this.z;
        if (r9 == null) goto L36;
        View r10 = r9.getView();
        if (r10 == null) goto L36;
        r1 = r10.getParent();
    L36:
        if (r1 == null) goto L38;
        r2 = true;
    L38:
        if (r2 == false) goto L44;
        this.r = true;
        this.w = this.z;
        ViewParent r11 = this.a.getParent();
        if (r11 == null) goto L42;
        r11.requestDisallowInterceptTouchEvent(true);
    L42:
        Lark_markdown_renderKt.ffiMovableCallPickCaret-zly0blg(this.z.mo1477getCaretIdpVg5ArA(), g(), h());
    L44:
        if (this.w == null) goto L46;
        Point r12 = com.ss.android.lark.movable.utils.e.b(this.a);
        Lark_markdown_renderKt.ffiMovableCallTouchMove-6Thg8X8(i(), g(), h(), com.ss.android.lark.movable.utils.b.f((r8.getX() + r12.x) - com.ss.android.lark.movable.utils.e.c(this.a), this.n), com.ss.android.lark.movable.utils.b.f(r8.getY() + r12.y, this.n));
    L46:
        MovableSelectionManager r13 = j();
        if (r13 == null) goto L51;
        g r14 = r13.f;
        if (r14 == null) goto L51;
        r14.a(r8);
    L51:
        MovableSelectionManager r15 = j();
        if (r15 == null) goto L81;
        j r16 = r15.v;
        if (r16 == null) goto L82;
        r16.a();
        return;
    L82:
        return;
    L81:
        return;
    L9:
        if (r0 == 3) goto L57;
        return;
    L57:
        if (Build.VERSION.SDK_INT < 28) goto L62;
        f r17 = (f) this.A.getValue();
        if (r17 == null) goto L62;
        r17.b.dismiss();
    L62:
        if (this.w != null) goto L65;
        r3 = false;
    L65:
        if (r3 == false) goto L67;
    L68:
        this.q = false;
        this.r = false;
        this.w = null;
        ViewParent r18 = this.a.getParent();
        if (r18 == null) goto L71;
        r18.requestDisallowInterceptTouchEvent(false);
    L71:
        MovableSelectionManager r19 = j();
        if (r19 == null) goto L76;
        g r20 = r19.f;
        if (r20 == null) goto L76;
        r20.a(r8);
    L76:
        n();
        return;
    L67:
        if (this.q == true) goto L68;
        return;
    L77:
        this.t = r8.getX();
        this.u = r8.getY();
    }

    public final void l(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Log.d("MovableSelectionManager", "onTouchEvent, action: " + r3.getAction() + ", x: " + r3.getX() + ", y: " + r3.getY());
        GestureDetector r0 = this.p;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
        r0 = null;
    L5:
        r0.onTouchEvent(r3);
        k(r3);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void o(boolean r9, FfiCaret r10) {
        if (r9 == false) goto L4;
        com.ss.android.lark.movable.selection.d r11 = this.y;
    L5:
        if (r10 != null) goto L9;
        this.x.a(r11);
        m(r11);
        r11.onCleared();
        return;
    L9:
        if (r11.getView().getParent() == this.a) goto L11;
        this.x.a(r11);
        m(r11);
        this.a.addView(r11.getView());
    L11:
        r11.g(r10, com.ss.android.lark.movable.utils.e.b(this.a), new Point(0, 0));
        com.ss.android.lark.movable.selection.c r12 = this.x;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, "origin");
        ViewGroup r0 = (ViewGroup) r12.a.invoke();
        Object r1 = r11.getView().getParent();
        if ((r1 instanceof View) == false) goto L14;
        View r2 = (View) r1;
    L15:
        if (r2 == null) goto L31;
        if (r2 != r0) goto L19;
        r12.a(r11);
        r11.setIsGhost(false);
        return;
    L19:
        LinkedHashMap r3 = (LinkedHashMap) r12.b;
        Object r4 = r3.get(r11);
        Object r5 = r4;
        if (r4 != null) goto L22;
        r11.setIsGhost(true);
        com.ss.android.lark.movable.selection.b r6 = new com.ss.android.lark.movable.selection.b(r0.getContext(), r11);
        r0.addView(r6, new FrameLayout.LayoutParams(r11.getView().getWidth(), r11.getView().getHeight()));
        r3.put(r11, r6);
        r5 = r6;
    L22:
        com.ss.android.lark.movable.selection.b r7 = (com.ss.android.lark.movable.selection.b) r5;
        if (r12.e == r2) goto L25;
    L27:
        r12.b();
        r12.e = r2;
        r12.f = true;
        r2.getViewTreeObserver().addOnPreDrawListener(r12.g);
        r2.getViewTreeObserver().addOnGlobalLayoutListener(r12.h);
        r2.getViewTreeObserver().addOnScrollChangedListener(r12.i);
    L28:
        r12.d(r11, r7, r0);
        return;
    L25:
        if (r12.f == false) goto L27;
    L31:
        return;
    L14:
        r2 = null;
        goto L15
    L4:
        r11 = this.z;
        goto L5
    }

    public MovableSelectionManager(MovableView r2, h r3, g r4, boolean r5, boolean r6, MovableLongPressBehavior r7, HandleStyle r8, int r9, Function0 r10, Function0 r11) {
        this.a = r2;
        this.b = null;
        this.c = r3;
        this.d = null;
        this.e = null;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.l = r10;
        this.m = r11;
        Context r12 = r2.getContext();
        this.n = r12;
        ksb.b r13 = new ksb.b(r12);
        this.o = r13;
        r2.addView(r13, new FrameLayout.LayoutParams(-1, -1));
        r13.setElevation(10.0f);
        this.p = new GestureDetector(r12, new m(this));
        r4.b(this, r2);
        this.x = new com.ss.android.lark.movable.selection.c(new MovableSelectionManager$caretMirrorController$1(this));
        this.y = f(HandleType.START);
        this.z = f(HandleType.END);
        this.A = LazyKt.lazy(new MovableSelectionManager$magnifier$2(this));
    }
}
