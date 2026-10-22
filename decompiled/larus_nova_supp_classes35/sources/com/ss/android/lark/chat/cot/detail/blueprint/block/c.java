package com.ss.android.lark.chat.cot.detail.blueprint.block;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.movable.MarkdownMovableView;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final MarkdownMovableView a;
    public final CotMovableRenderState b;
    public final Function0<Boolean> c;
    public final Function2<String, Float, Unit> d;
    public Pair<String, Float> e;
    public String f;
    public final b g;

    public c() {
        throw null;
    }

    public final void a() {
        this.f = null;
        this.e = null;
        CotMovableRenderState r1 = this.b;
        r1.a.incrementAndGet();
        r1.b = null;
        r1.c = CotMovableRenderState.Status.IDLE;
    }

    public final void b() {
        this.a.removeOnLayoutChangeListener(this.g);
        a();
        this.a.d();
        this.a.setTag(2131367989, null);
    }

    public c(final MarkdownMovableView r4, CotMovableRenderState r5) {
        Function0<Boolean> r0 = new CotMovableRenderDelegate$1(r4);
        CotMovableRenderDelegate$2 r1 = new CotMovableRenderDelegate$2(r4);
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "renderState");
        Intrinsics.checkNotNullParameter(r0, "isCurrentRenderValid");
        Intrinsics.checkNotNullParameter(r1, "submitRender");
        this.a = r4;
        this.b = r5;
        this.c = r0;
        this.d = r1;
        b r6 = new b(this);
        this.g = r6;
        r4.addOnLayoutChangeListener(r6);
    }

    public final void c(String r5, float r6) {
        Intrinsics.checkNotNullParameter(r5, "markdown");
        Float r7 = Float.valueOf(r6);
        boolean r2 = true;
        if (r7.floatValue() <= 0.0f) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r7 = null;
    L10:
        if (r7 != null) goto L21;
        Integer r8 = Integer.valueOf(this.a.getWidth());
        if (r8.intValue() > 0) goto L15;
        r2 = false;
    L15:
        if (r2 == true) goto L18;
        r8 = null;
    L18:
        if (r8 == null) goto L20;
        r7 = Float.valueOf(com.ss.android.lark.movable.utils.b.f(r8.intValue(), this.a.getContext()));
        goto L21
    L20:
        r7 = null;
    L21:
        if (r7 != null) goto L23;
        this.f = r5;
        return;
    L23:
        this.f = null;
        d(r5, r7.floatValue());
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final void d(String r7, float r8) {
        Pair<String, Float> r0 = TuplesKt.to(r7, Float.valueOf(r8));
        if (Intrinsics.areEqual(r0, this.e) == false) goto L23;
        CotMovableRenderState r1 = this.b;
        boolean r3 = ((Boolean) this.c.invoke()).booleanValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, ChameleonOpenTracker.Stage.RENDER);
        boolean r5 = true;
        if (Intrinsics.areEqual(r0, r1.b) == false) goto L21;
        CotMovableRenderState.Status r2 = r1.c;
        int r4 = CotMovableRenderState.a.a[r2.ordinal()];
        if (r4 != 1) goto L10;
    L20:
        r5 = false;
        goto L21
    L10:
        if (r4 != 2) goto L12;
        if (r3 == true) goto L20;
    L12:
        if (r4 == 3) goto L21;
        if (r4 == 4) goto L21;
        throw new NoWhenBranchMatchedException();
    L21:
        if (r5 == true) goto L23;
        return;
    L23:
        CotMovableRenderState r6 = this.b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, ChameleonOpenTracker.Stage.RENDER);
        r6.a.incrementAndGet();
        r6.b = r0;
        r6.c = CotMovableRenderState.Status.PENDING;
        this.d.invoke(r7, Float.valueOf(r8));
        this.e = r0;
    }
}
