package com.obric.memorydata.memory.ui.a;

import android.content.res.Resources;
import android.util.TypedValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cJ\"\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0018J\"\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0018J\"\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0018J\u000e\u0010%\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0018J\u001c\u0010&\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cJ\u0006\u0010'\u001a\u00020\u0018J\u0006\u0010(\u001a\u00020\u0018J\u0006\u0010)\u001a\u00020\u0018J\u0006\u0010*\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/memorydata/memory/ui/animation/CommonProcessingAnimatorHelper;", "", "<init>", "()V", "mEdgeEffectAlphaValue", "Lcom/obric/memorydata/memory/ui/animation/FloatValueHolder;", "mEdgeEffectAlphaSpec", "Lcom/obric/memorydata/memory/ui/animation/SpringForce;", "mEdgeEffectAlphaAnimation", "Lcom/obric/memorydata/memory/ui/animation/SpringAnimation;", "mEdgeWidthValue", "mEdgeWidthSpec", "mEdgeWidthAnimation", "mMaskEnterSizeValue", "mMaskEnterSizeSpec", "mMaskEnterSizeAnimation", "mMaskExitSizeValue", "mMaskExitSizeSpec", "mMaskExitSizeAnimation", "onEndListener", "Lcom/obric/memorydata/memory/ui/animation/DynamicAnimation$OnAnimationEndListener;", "playEdgeEffectAlphaAnim", "", "finalPosition", "", "ratio", "stiffness", "onEnd", "Lkotlin/Function0;", "playEdgeWidthAnim", "playMaskEnterSizeAnim", "playMaskExitSizeAnim", "maskSize", "alpha", "edgeWidth", "enterSize", "exitSize", "show", "hide", "getEdgeEffectAlphaSize", "getEdgeWidthSize", "getMaskEnterSize", "getMaskExitSize", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f10561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f10562b;
    private g c;
    private f d;
    private h e;
    private g f;
    private f g;
    private h h;
    private g i;
    private f j;
    private h k;
    private g l;
    private d.b m;

    public b() {
        this.f10561a = new f();
        h r0 = new h();
        r0.b(1.0f);
        r0.a(120.0f);
        this.f10562b = r0;
        g r1 = new g(this.f10561a);
        r1.a(this.f10562b);
        this.c = r1;
        this.d = new f();
        h r2 = new h();
        r2.b(1.0f);
        r2.a(120.0f);
        this.e = r2;
        g r3 = new g(this.d);
        r3.a(this.e);
        this.f = r3;
        this.g = new f();
        h r4 = new h();
        r4.b(1.0f);
        r4.a(120.0f);
        this.h = r4;
        g r5 = new g(this.g);
        r5.a(this.h);
        this.i = r5;
        this.j = new f();
        h r6 = new h();
        r6.b(1.0f);
        r6.a(120.0f);
        this.k = r6;
        g r7 = new g(this.j);
        r7.a(this.k);
        this.l = r7;
    }

    public static /* synthetic */ void a(b r0, float r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 1.0f;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 120.0f;
    L8:
        r0.a(r1, r2, r3);
    }

    public static /* synthetic */ void a(b r1, float r2, float r3, float r4, Function0 r5, int r6, Object r7) {
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = 1.0f;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 120.0f;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r8 = $$Lambda$b$JPxfHfL1eZn5CSnzmT7Ps6fqKGw.INSTANCE;
    L11:
        r1.a(r2, r3, r4, r8);
    }

    private static final void a(Function0 r0, d r1, boolean r2, float r3, float r4) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r0, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    public static /* synthetic */ void b(b r0, float r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 1.0f;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 120.0f;
    L8:
        r0.b(r1, r2, r3);
    }

    public static /* synthetic */ void c(b r0, float r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 1.0f;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 120.0f;
    L8:
        r0.c(r1, r2, r3);
    }

    private static final Unit e() {
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$JPxfHfL1eZn5CSnzmT7Ps6fqKGw() {
        return e();
    }

    public static /* synthetic */ void lambda$lrjtAb0UZgbjc3KyIiSeB1vhrRk(Function0 r0, d r1, boolean r2, float r3, float r4) {
        a(r0, r1, r2, r3, r4);
    }

    public final float a() {
        return this.f10561a.a() / 1000.0f;
    }

    public final void a(float r16) {
        a(this, 1000.0f, 0.0f, 0.0f, null, 14, null);
        a(this, TypedValue.applyDimension(1, 80, Resources.getSystem().getDisplayMetrics()), 0.0f, 0.0f, 6, null);
        b(this, r16, 0.0f, 0.0f, 6, null);
        c(this, 0.0f, 0.0f, 240.0f, 2, null);
    }

    public final void a(float r2, float r3, float r4) {
        h r0 = this.e;
        r0.c(r2);
        r0.b(r3);
        r0.a(r4);
        boolean r5 = this.f.b();
        g r1 = this.f;
        if (r5 == false) goto L5;
        r1.b(r2);
        return;
    L5:
        r1.a();
    }

    public final void a(float r3, float r4, float r5, Function0<Unit> r6) {
        final Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "onEnd");
        h r0 = this.f10562b;
        r0.c(r3);
        r0.b(r4);
        r0.a(r5);
        if (this.c.b() == false) goto L5;
        this.c.b(r3);
    L6:
        d.b r8 = this.m;
        if (r8 == null) goto L9;
        this.c.b(r8);
    L9:
        d.b r9 = new $$Lambda$b$lrjtAb0UZgbjc3KyIiSeB1vhrRk(r7);
        this.m = r9;
        this.c.a(r9);
        return;
    L5:
        this.c.a();
        goto L6
    }

    public final void a(float r14, Function0<Unit> r15) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r15, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onEnd");
        a(this, 0.0f, 0.0f, 240.0f, r4, 2, null);
        a(this, 0.0f, 0.0f, 240.0f, 2, null);
        b(this, 0.0f, 0.0f, 240.0f, 2, null);
        c(this, r14, 0.0f, 240.0f, 2, null);
    }

    public final float b() {
        return this.d.a();
    }

    public final void b(float r2, float r3, float r4) {
        h r0 = this.h;
        r0.c(r2);
        r0.b(r3);
        r0.a(r4);
        boolean r5 = this.i.b();
        g r1 = this.i;
        if (r5 == false) goto L5;
        r1.b(r2);
        return;
    L5:
        r1.a();
    }

    public final float c() {
        return this.g.a();
    }

    public final void c(float r2, float r3, float r4) {
        h r0 = this.k;
        r0.c(r2);
        r0.b(r3);
        r0.a(r4);
        boolean r5 = this.l.b();
        g r1 = this.l;
        if (r5 == false) goto L5;
        r1.b(r2);
        return;
    L5:
        r1.a();
    }

    public final float d() {
        return this.j.a();
    }
}
