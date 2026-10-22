package com.bytedance.android.livesdk.dslservice.slice;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.dsl.api.DSLType;
import com.bytedance.android.livesdk.dslservice.slice.action.EmptyActionHandler;
import com.bytedance.android.livesdk.dslservice.slice.cache.GlobalExprParseContext;
import com.bytedance.android.livesdk.dslservice.slice.cache.f;
import com.bytedance.android.livesdk.dslservice.slice.process.LiveSliceTemplateProvider;
import com.bytedance.android.livesdk.dslservice.util.o;
import com.bytedance.live.datacontext.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import yt1.h;
import yt1.k;
import yt1.l;
import yt1.m;
import yt1.n;
import yt1.p;
import yt1.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class SliceDSLProcess implements n {
    public static final /* synthetic */ int h = 0;
    public SlcRenderContext a;
    public final LiveSliceTemplateProvider b;
    public final com.bytedance.android.livesdk.dslservice.util.b<b> c;
    public ArrayList<h> d;
    public final ArrayList<com.bytedance.android.ecom.arch.slice.render.d> e;
    public final et2.b f;
    public l g;

    public static final class a {
    }

    static {
    }

    @Override // yt1.n
    public final boolean b(String r1, q r2) {
        return false;
    }

    @Override // yt1.n
    public final void release() {
        o.f.d(AnonymousClass1.INSTANCE);
        this.e.clear();
        this.c.a.clear();
        if (this.f.a() == true) goto L9;
        SlcRenderContext r0 = this.a;
        if (r0 == null) goto L7;
        r0.d();
    L7:
        this.a = null;
        return;
    }

    public SliceDSLProcess() {
        com.bytedance.android.livesdk.dslservice.slice.cache.e r1 = f.a;
        this.b = new LiveSliceTemplateProvider();
        this.c = new com.bytedance.android.livesdk.dslservice.util.b(o.f);
        this.e = new ArrayList();
        this.f = (et2.b) dt2.d.a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void k(View r3) {
        if ((r3 instanceof com.bytedance.android.livesdk.dslservice.view.a) == false) goto L6;
        ((com.bytedance.android.livesdk.dslservice.view.a) r3).reset();
    L6:
        if ((r3 instanceof ViewGroup) == false) goto L10;
        ViewGroup r4 = (ViewGroup) r3;
        int r0 = r4.getChildCount();
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L12;
        k(r4.getChildAt(r1));
        r1 = r1 + 1;
        goto L8
    L12:
        return;
    }

    @Override // yt1.n
    public final void g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        i(r2);
    }

    public final SlcRenderContext i(Context r4) {
        SlcRenderContext r0 = this.a;
        if (r0 == null) goto L8;
        if (Intrinsics.areEqual(r0.getContext(), r4) == false) goto L8;
        return r0;
    L8:
        if (this.f.a() == false) goto L19;
        SlcRenderContext r1 = com.bytedance.android.livesdk.dslservice.slice.cache.b.a;
        if (r1 == null) goto L12;
        Context r2 = r1.getContext();
    L14:
        if (Intrinsics.areEqual(r2, r4) == false) goto L19;
        o.f.d(SliceDSLProcess$acquireRenderContext$2.INSTANCE);
        SlcRenderContext r3 = com.bytedance.android.livesdk.dslservice.slice.cache.b.a;
        if (r3 == null) goto L19;
        this.a = r3;
        return r3;
    L12:
        r2 = null;
    L19:
        o.f.d(SliceDSLProcess$acquireRenderContext$4.INSTANCE);
        SlcRenderContext r5 = new SlcRenderContext(r4, "Live", (SlcExprContext) GlobalExprParseContext.b.getValue());
        r5.a0 = this.b;
        this.a = r5;
        com.bytedance.android.livesdk.dslservice.slice.cache.b.a = r5;
        boolean r6 = false;
        if (this.f.c() == false) goto L22;
        r5.g = false;
    L22:
        com.bytedance.android.ecom.arch.slice.render.context.b.f.getClass();
        r5.f = com.bytedance.android.ecom.arch.slice.render.context.b.a.c(false);
        r5.w = false;
        if (this.f.d() != 1) goto L26;
        r6 = true;
    L26:
        if (r5.u == r6) goto L31;
        r5.u = r6;
        if (r6 == false) goto L30;
        r5.a.c();
        goto L31
    L30:
        r5.a.a();
    L31:
        return r5;
    }

    @Override // yt1.n
    public final void a(final q r6, k r7) {
        Intrinsics.checkNotNullParameter(r6, "key");
        if ((r7 instanceof b) == false) goto L26;
        o r1 = o.f;
        r1.d(new SliceDSLProcess$recycleTemplate$1(r6));
        l(r6, r7);
        b r2 = (b) r7;
        boolean r4 = true;
        if (r2.b == 1) goto L8;
        r2.b = 3;
        r1.d(SliceDSLProcess$recycleTemplate$2.INSTANCE);
        return;
    L8:
        k(r7.getView());
        com.bytedance.android.livesdk.dslservice.slice.cache.e r3 = f.a;
        r r8 = ((b) r7).e;
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r8, "data");
        if (r6.b.length() != 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == true) goto L14;
    L19:
        com.bytedance.android.livesdk.dslservice.slice.cache.c r9 = f.b;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r8, "value");
        if (r9.a(r6) != null) goto L22;
        LinkedList<r> r0 = new LinkedList();
        r9.b().put(r6, r0);
    L22:
        LinkedList<r> r10 = r9.a(r6);
        if (r10 == null) goto L27;
        r10.offer(r8);
        return;
    L27:
        return;
    L14:
        if (r6.c.length() == 0) goto L17;
        r4 = false;
    L17:
        if (r4 == false) goto L19;
        return;
    L11:
        r5 = false;
        goto L12
    }

    @Override // yt1.n
    public final void e(final q r5, final Map r6) {
        Intrinsics.checkNotNullParameter(r5, "key");
        final String r1 = "";
        Intrinsics.checkNotNullParameter("", "data");
        final int r3 = 1;
        this.c.d(r5, new SliceDSLProcess$refreshTemplate$1(r5, r1, r6, r3));
    }

    public final void l(q r2, k r3) {
        if ((r3 instanceof b) == false) goto L6;
        this.c.b(r2, r3);
        r3.b(au1.a.C0001a.b, false);
        r r4 = ((b) r3).e;
        Intrinsics.checkNotNullParameter(r4, "$this$release");
        int r5 = com.bytedance.android.livesdk.dslservice.util.r.a;
        com.bytedance.android.livesdk.dslservice.util.r.a(r4.c);
        r4.b.t(EmptyActionHandler.a);
        return;
    }

    @Override // yt1.n
    public final void f(Context r2, l r3, ArrayList<h> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.g = r3;
        this.d = r4;
    }

    public static final void h(SliceDSLProcess r5, b r6, r r7, yt1.r r8) {
        r5.getClass();
        com.bytedance.android.livesdk.dslservice.slice.action.a r0 = new com.bytedance.android.livesdk.dslservice.slice.action.a(null);
        if (r8 == null) goto L13;
        ArrayList<h> r9 = r8.a;
        if (r9 == null) goto L13;
        Iterator<h> r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L13;
        h r2 = r10.next();
        Intrinsics.checkNotNullParameter(r2, "actionInterface");
        String r3 = r2.a();
        if (r3 != null) goto L12;
        r3 = r2.getName().getText();
    L12:
        r0.a.put(r3, r2);
    L13:
        ArrayList<h> r11 = r5.d;
        if (r11 == null) goto L22;
        Iterator<T> r12 = r11.iterator();
    L17:
        if (r12.hasNext() == false) goto L22;
        h r4 = (h) r12.next();
        Intrinsics.checkNotNullParameter(r4, "actionInterface");
        String r13 = r4.a();
        if (r13 != null) goto L21;
        r13 = r4.getName().getText();
    L21:
        r0.a.put(r13, r4);
    L22:
        c r14 = new c(r5, r7, r0);
        r7.b.t(r14);
        Intrinsics.checkNotNullParameter(r0, "actionContext");
        r6.d = r0;
    }

    @Override // yt1.n
    public final k c(yt1.o r2, String r3, Context r4, yt1.r r5, m r6) {
        Intrinsics.checkNotNullParameter(r2, "template");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "context");
        return j(this, r2, r3, r4, r5, r6);
    }

    @Override // yt1.n
    public final k d(yt1.o r8, String r9, ViewGroup r10, yt1.r r11, m r12) {
        Intrinsics.checkNotNullParameter(r8, "template");
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r10, "viewGroup");
        b r13 = j(this, r8, r9, r10.getContext(), r11, r12);
        View r14 = r13.e.c;
        com.bytedance.android.livesdk.dslservice.util.r.a(r14);
        r10.addView(r14);
        return r13;
    }

    public static b j(final SliceDSLProcess r16, final yt1.o r17, String r18, Context r19, yt1.r r20, m r21) {
        r16.getClass();
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        if (v.a() == false) goto L61;
        com.bytedance.android.livesdk.chatroom.q r0 = iv1.a.a(null, 3);
        if (r0 == null) goto L61;
        j r1 = r0.G1();
        if (r1 == null) goto L61;
        zt1.c r2 = (zt1.c) r1.getValue();
        if (r2 == null) goto L61;
        com.bytedance.android.livesdk.dsl.util.d r3 = r2.c(r17.b);
        if (r3 == null) goto L61;
        yt1.o r4 = r3.a;
        boolean r5 = false;
        if (r4 == null) goto L31;
        p r6 = r4.c;
        if (r6 == null) goto L31;
        String r8 = r6.b;
        if (r8 == null) goto L31;
        if (r8.length() <= 0) goto L22;
        boolean r9 = true;
    L23:
        if (r9 != true) goto L31;
        p r10 = r17.c;
        yt1.o r11 = r3.a;
        if (r11 == null) goto L29;
        p r12 = r11.c;
        if (r12 == null) goto L29;
        String r13 = r12.b;
    L30:
        r10.b = r13;
    L29:
        r13 = null;
        goto L30
    L22:
        r9 = false;
    L31:
        yt1.o r14 = r3.a;
        if (r14 == null) goto L49;
        p r15 = r14.c;
        if (r15 == null) goto L49;
        String r22 = r15.a;
        if (r22 == null) goto L49;
        if (r22.length() <= 0) goto L40;
        boolean r23 = true;
    L41:
        if (r23 != true) goto L49;
        p r24 = r17.c;
        yt1.o r25 = r3.a;
        if (r25 == null) goto L47;
        p r26 = r25.c;
        if (r26 == null) goto L47;
        String r27 = r26.a;
    L48:
        r24.a = r27;
    L47:
        r27 = null;
        goto L48
    L40:
        r23 = false;
    L49:
        q r28 = r17.b;
        yt1.o r29 = r3.a;
        if (r29 == null) goto L55;
        q r30 = r29.b;
        if (r30 == null) goto L55;
        String r31 = r30.b;
        if (r31 == null) goto L55;
    L56:
        r28.getClass();
        Intrinsics.checkNotNullParameter(r31, "<set-?>");
        r28.b = r31;
        if (r3.b.length() <= 0) goto L59;
        r5 = true;
    L59:
        if (r5 == false) goto L61;
        String r32 = r3.b;
    L62:
        if (r32 != null) goto L64;
        r32 = r18;
    L64:
        r7.element = r32;
        o r110 = o.f;
        r110.d(new SliceDSLProcess$realLoad$1(r17));
        if ((!Intrinsics.areEqual(null, "PreLoad")) == false) goto L67;
        com.bytedance.android.livesdk.dslservice.util.p r33 = new com.bytedance.android.livesdk.dslservice.util.p();
    L68:
        SliceDSLProcess$wrapInnerCallback$1 r34 = new SliceDSLProcess$wrapInnerCallback$1(r17.b, r33, r21);
        SlcRenderContext r111 = r16.i(r19);
        com.bytedance.android.livesdk.dslservice.slice.a r112 = new com.bytedance.android.livesdk.dslservice.slice.a();
        Ref.ObjectRef r35 = new Ref.ObjectRef();
        r35.element = null;
        SliceDSLProcess$realLoad$createViewCallback$1 r36 = new SliceDSLProcess$realLoad$createViewCallback$1(r16, r35, r34, r112, r17, r20, r7);
        if (r16.f.b() == false) goto L71;
        r16.e.add(r36);
    L71:
        p r37 = r17.c;
        String r38 = r37.b;
        if (r38 != null) goto L74;
        r38 = "";
    L74:
        q r39 = r17.b;
        r r40 = r111.c(new com.bytedance.android.livesdk.dslservice.slice.process.a(r38, r39.a, r39.c, r39, r37.a, new WeakReference(r19)), r36);
        b r41 = r112.a(r17.b, r40, r20, new SliceDSLProcess$realLoad$component$1(r16));
        r16.c.a(r17.b, r41);
        int r42 = com.bytedance.android.livesdk.dslservice.util.r.a;
        com.bytedance.android.livesdk.dslservice.util.r.a(r40.c);
        View r43 = r40.c;
        if ((r43 instanceof ViewGroup) == true) goto L77;
        View r113 = null;
    L78:
        com.bytedance.android.livesdk.dslservice.view.c.a(DSLType.Slice, (ViewGroup) r113, r40, r17, r18);
        r110.d(new SliceDSLProcess$realLoad$2(r17));
        return r41;
    L77:
        r113 = r43;
        goto L78
    L67:
        r33 = null;
    L55:
        r31 = "";
    L61:
        r32 = null;
        goto L62
    }
}
