package com.larksuite.common_selection;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.common_selection.selectionhandle.CursorHandle;
import com.larksuite.common_selection.selectionhandle.SelectionHandleType;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i {
    public final g a;
    public final ly7.b.a b;
    public final t c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final DrawHighlightStyle g;
    public final Map<TriggerMode, n> h;
    public final Paint i;
    public p j;
    public SelectionContainer k;
    public ly7.c l;
    public ly7.c m;
    public SelectionHandleType n;
    public p o;
    public final AtomicBoolean p;
    public boolean q;
    public r r;
    public com.larksuite.common_selection.b s;
    public h t;
    public boolean u;

    public static final class a {
        public g a;
        public final ly7.b.a b;
        public final t c;
        public final int d;
        public boolean e;
        public final boolean f;
        public final boolean g;
        public final DrawHighlightStyle h;
        public final Map<TriggerMode, n> i;

        public a() {
            this.a = new ly7.a();
            this.b = ly7.b.a;
            this.c = t.a;
            this.d = Color.argb(60, 52, 152, 219);
            this.f = true;
            this.g = true;
            this.h = DrawHighlightStyle.FOREGROUND;
            this.i = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(TriggerMode.LongPress, new n(SelectionGranularity.WORD, SelectionInitiationMode.SELECT_ANYWHERE))});
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {
        public final /* synthetic */ i a;

        public c(i r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i.a(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final Pair<Rect, Rect> c() {
        ly7.c r0 = this.l;
        if (r0 == null) goto L17;
        View r1 = r0.getView();
        if (r1 == null) goto L17;
        ly7.c r2 = this.m;
        if (r2 == null) goto L17;
        View r3 = r2.getView();
        if (r3 == null) goto L17;
        if (this.k != null) goto L15;
        return null;
    L15:
        int[] r4 = new int[2];
        r1.getLocationOnScreen(r4);
        int[] r5 = new int[2];
        r3.getLocationOnScreen(r5);
        int r7 = r4[0];
        Rect r6 = new Rect(r7, r4[1], r1.getWidth() + r7, r4[1] + r1.getHeight());
        int r8 = r5[0];
        return new Pair(r6, new Rect(r8, r5[1], r3.getWidth() + r8, r5[1] + r3.getHeight()));
    L17:
        return null;
    }

    public final void d() {
        if (this.u == false) goto L22;
        return;
    L22:
        this.u = true;     // Catch: Throwable -> L19
        if (this.k == null) goto L11;
        h r0 = this.t;     // Catch: Throwable -> L19
        if (r0 == null) goto L11;
        r0.d();     // Catch: Throwable -> L19
    L11:
        this.o = null;     // Catch: Throwable -> L19
        g();     // Catch: Throwable -> L19
        com.larksuite.common_selection.b r2 = this.s;     // Catch: Throwable -> L19
        if (r2 == null) goto L14;
        r2.a.dismiss();     // Catch: Throwable -> L19
    L14:
        this.s = null;     // Catch: Throwable -> L19
        SelectionContainer r3 = this.k;     // Catch: Throwable -> L19
        this.k = null;     // Catch: Throwable -> L19
        Log.d("SelectionManager", "clearSelection called");     // Catch: Throwable -> L19
        this.j = null;     // Catch: Throwable -> L19
        if (r3 == null) goto L17;
        r3.invalidate();     // Catch: Throwable -> L19
    L17:
        this.u = false;
        return;
    L19:
        th = move-exception;
        this.u = false;
        throw th;
    }

    public final List<e> f() {
        p r0 = this.j;
        if (r0 == null) goto L5;
        SelectionContainer r1 = this.k;
        if (r1 != null) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if (r0.a.a != null) goto L13;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == false) goto L18;
        ArrayList<View> r3 = r1.getFlatSelectableItems$common_selection_release();
        int r4 = CollectionsKt.indexOf(r3, r0.a.a);
        int r5 = CollectionsKt.indexOf(r3, r0.b.a);
        if (r4 < 0) goto L43;
        if (r5 < 0) goto L43;
        ArrayList r6 = new ArrayList((r5 - r4) + 1);
        if (r4 > r5) goto L41;
        int r7 = r4;
    L26:
        View r8 = (View) ListProtector.get(r3, r7);
        t r9 = t.a;
        s r10 = t.a(r8);
        if (r10 != null) goto L29;
        r10 = t.c;
    L29:
        if (r7 != r4) goto L31;
        int r11 = r0.a.b;
    L32:
        if (r7 != r5) goto L34;
        int r12 = r0.b.b;
    L35:
        if (r11 >= r12) goto L39;
        e r13 = r10.c(r8, r11, r12);
        if (r13 == null) goto L39;
        r6.add(r13);
    L39:
        if (r7 == r5) goto L41;
        r7 = r7 + 1;
        goto L26
    L34:
        r12 = r10.a(r8);
        goto L35
    L31:
        r11 = 0;
    L41:
        return r6;
    L43:
        return CollectionsKt.emptyList();
    L18:
        return CollectionsKt.emptyList();
    L13:
        if (r0.b.a == null) goto L15;
        r2 = true;
        goto L16
    L5:
        return CollectionsKt.emptyList();
    }

    public final void g() {
        SelectionContainer r0 = this.k;
        if (r0 == null) goto L14;
        ly7.c r1 = this.l;
        if (r1 == null) goto L9;
        View r2 = r1.getView();
        if (r2 == null) goto L9;
        r0.removeView(r2);
    L9:
        ly7.c r3 = this.m;
        if (r3 == null) goto L14;
        View r4 = r3.getView();
        if (r4 == null) goto L14;
        r0.removeView(r4);
    L14:
        this.b.getClass();
        r r5 = this.r;
        if (r5 == null) goto L20;
        View r6 = r5.c.findViewById(r5.e);
        if (r6 == null) goto L19;
        r5.c.removeView(r6);
    L19:
        r5.b.invoke();
    L20:
        this.r = null;
        this.l = null;
        this.m = null;
        this.q = false;
    }

    public final boolean h() {
        if (this.q == true) goto L5;
    L9:
        return false;
    L5:
        if (this.l == null) goto L9;
        if (this.m == null) goto L9;
        return true;
    }

    public final void i() {
        p r0 = this.j;
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r0, this.o) == true) goto L12;
        h r1 = this.t;
        if (r1 == null) goto L10;
        r1.e(r0);
    L10:
        this.o = p.a(r0);
        return;
    }

    public final void k() {
        SelectionContainer r0 = this.k;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.post(new c(this));
    }

    public final void m() {
        SelectionContainer r0 = this.k;
        if (r0 != null) goto L5;
        return;
    L5:
        p r1 = this.j;
        if (r1 != null) goto L8;
        return;
    L8:
        Pair r2 = e(r1.a, false);
        if (r2 == null) goto L13;
        Point r3 = (Point) r2.component1();
        float r4 = ((Number) r2.component2()).floatValue();
        ly7.c r5 = this.l;
        if (r5 == null) goto L13;
        r5.e(r1.a, this.c);
        r5.k(r0, r3, r4);
    L13:
        Pair r6 = e(r1.b, true);
        if (r6 == null) goto L18;
        Point r7 = (Point) r6.component1();
        float r8 = ((Number) r6.component2()).floatValue();
        ly7.c r9 = this.m;
        if (r9 == null) goto L18;
        r9.e(r1.b, this.c);
        r9.k(r0, r7, r8);
    L18:
        this.b.getClass();
    }

    public i(a r4) {
        Paint r0 = new Paint();
        this.i = r0;
        this.p = new AtomicBoolean(false);
        this.a = r4.a;
        this.b = r4.b;
        this.c = r4.c;
        this.d = r4.e;
        this.e = r4.f;
        this.f = r4.g;
        this.g = r4.h;
        this.h = MapsKt.toMutableMap(r4.i);
        r0.setColor(r4.d);
        r0.setStyle(Paint.Style.FILL);
    }

    public static final void a(i r3) {
        SelectionContainer r0 = r3.k;
        if (r0 == null) goto L13;
        Pair<Rect, Rect> r1 = r3.c();
        if (r1 == null) goto L11;
        h r4 = r3.t;
        if (r4 == null) goto L12;
        r4.c(r0, (Rect) r1.getFirst(), (Rect) r1.getSecond());
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void j(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        h r0 = this.t;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public static Pair e(o r2, boolean r3) {
        View r0 = r2.a;
        if (r0 != null) goto L6;
        return null;
    L6:
        t r1 = t.a;
        s r4 = t.a(r0);
        if (r4 != null) goto L10;
        r4 = t.c;
    L10:
        return TuplesKt.to(r4.d(r2, r3), Float.valueOf(r4.j(r2)));
    }

    public final void l(SelectionContainer r3, o r4) {
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "point");
        if (Intrinsics.areEqual(this.k, r3) == false) goto L17;
        p r0 = this.j;
        o r1 = null;
        if (r0 == null) goto L7;
        o r2 = r0.a;
    L9:
        if (Intrinsics.areEqual(r2, r4) == false) goto L17;
        p r5 = this.j;
        if (r5 == null) goto L14;
        r1 = r5.b;
    L14:
        if (Intrinsics.areEqual(r1, r4) == false) goto L17;
        return;
    L7:
        r2 = null;
    L17:
        if (this.k == null) goto L19;
        d();
    L19:
        this.k = r3;
        o r6 = new o(r4.a, r4.b);
        p r7 = new p(r6, r6);
        this.j = r7;
        h r8 = this.t;
        if (r8 == null) goto L22;
        r8.b(r7);
    L22:
        this.o = p.a(r7);
        r3.invalidate();
        Context r9 = r3.getContext();
        if (this.e == false) goto L26;
        com.larksuite.common_selection.a.a(r9);
        return;
    }

    public final void n(o r3, o r4) {
        p r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        r3 = r0.a;
    L7:
        if (r4 != null) goto L10;
        r4 = r0.b;
    L10:
        if (Intrinsics.areEqual(r3, r0.a) == true) goto L12;
    L14:
        this.j = new p(r3, r4);
        i();
        SelectionContainer r5 = this.k;
        if (r5 == null) goto L18;
        r5.invalidate();
    L18:
        if (this.q == true) goto L20;
        return;
    L20:
        if (this.p.getAndSet(true) == true) goto L27;
        SelectionContainer r6 = this.k;
        if (r6 == null) goto L28;
        r6.post(new k(this));
        return;
    L28:
        return;
    L27:
        return;
    L12:
        if (Intrinsics.areEqual(r4, r0.b) == false) goto L14;
    }

    public static final ly7.c b(i r3, SelectionContainer r4, SelectionHandleType r5) {
        CursorHandle r0 = r3.a.a(r4.getContext(), r5);
        View r1 = r0.getView();
        r1.setOnTouchListener(new j(r3, r5, r4));
        r4.addView(r1, new FrameLayout.LayoutParams(-2, -2));
        return r0;
    }
}
