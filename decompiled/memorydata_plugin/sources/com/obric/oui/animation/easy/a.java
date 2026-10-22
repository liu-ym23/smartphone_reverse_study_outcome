package com.obric.oui.animation.easy;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.oui.animation.a.d;
import com.obric.oui.animation.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ?2\u00020\u0001:\u0001?B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\b4Jh\u00105\u001a\u0002012`\u00106\u001a\\\u0012\u0013\u0012\u001103¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020107JS\u0010=\u001a\u0002012K\u00106\u001aG\u0012\u0013\u0012\u001103¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u0002010>R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0004R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\nR$\u0010\"\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0004R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010&\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0004R\u000e\u0010)\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010*\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0004R\u000e\u0010-\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/oui/animation/easy/SpringAnimationConfig;", "", "finalValue", "", "(F)V", "cancelIfRunning", "", "getCancelIfRunning", "()Z", "setCancelIfRunning", "(Z)V", EventBody.KEY_VALUE, "dampingRatio", "getDampingRatio", "()F", "setDampingRatio", "dampingRatioIsSet", "defaultDampingRatio", "getDefaultDampingRatio$OUIAnimation_release", "setDefaultDampingRatio$OUIAnimation_release", "defaultStiffness", "getDefaultStiffness$OUIAnimation_release", "setDefaultStiffness$OUIAnimation_release", "endListener", "Lcom/obric/oui/animation/engine/DynamicAnimation$OnAnimationEndListener;", "maxValue", "getMaxValue", "setMaxValue", "minValue", "getMinValue", "setMinValue", "skipToEndIfRunning", "getSkipToEndIfRunning", "setSkipToEndIfRunning", "startValue", "getStartValue", "setStartValue", "startValueIsSet", "startVelocity", "getStartVelocity", "setStartVelocity", "startVelocityIsSet", "stiffness", "getStiffness", "setStiffness", "stiffnessIsSet", "updateListener", "Lcom/obric/oui/animation/engine/DynamicAnimation$OnAnimationUpdateListener;", "applyTo", "", "animation", "Lcom/obric/oui/animation/engine/SpringAnimation;", "applyTo$OUIAnimation_release", "onEnd", "function", "Lkotlin/Function4;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "spring", "canceled", "velocity", "onUpdate", "Lkotlin/Function3;", "Companion", "OUIAnimation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0727a f13299a = null;
    private static final float s = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f13300b;
    private boolean c;
    private float d;
    private boolean e;
    private float f;
    private float g;
    private float h;
    private boolean i;
    private float j;
    private float k;
    private boolean l;
    private float m;
    private float n;
    private com.obric.oui.animation.a.b.c o;
    private com.obric.oui.animation.a.b.InterfaceC0726b p;
    private boolean q;
    private boolean r;

    /* JADX INFO: renamed from: com.obric.oui.animation.easy.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/animation/easy/SpringAnimationConfig$Companion;", "", "()V", "NOT_SET", "", "getNOT_SET", "()F", "OUIAnimation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0727a {
        private C0727a() {
        }

        public /* synthetic */ C0727a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13299a = new C0727a(null);
        s = Float.MAX_VALUE;
    }

    public a(float r1) {
        this.f13300b = r1;
        float r2 = s;
        this.d = r2;
        this.f = r2;
        this.g = Float.MAX_VALUE;
        this.h = -Float.MAX_VALUE;
        this.j = 0.5f;
        this.k = 0.5f;
        this.m = 1500.0f;
        this.n = 1500.0f;
    }

    public final float a() {
        if (this.i == false) goto L6;
        return this.k;
    L6:
        return this.j;
    }

    public final void a(float r2) {
        this.c = true;
        this.d = r2;
    }

    public final void a(d r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        if (this.q == false) goto L6;
        r3.f();
    L8:
        r3.d(this.h);
        r3.c(this.g);
        if (this.c == false) goto L12;
        r3.a(this.d);
    L12:
        if (this.e == false) goto L15;
        r3.b(this.f);
    L15:
        if (r3.e() != null) goto L17;
        r3.a(new e());
    L17:
        r3.e().b(a());
        r3.e().a(b());
        r3.e().c(this.f13300b);
        if (r3.c() == true) goto L23;
        com.obric.oui.animation.a.b.c r0 = this.o;
        if (r0 == null) goto L23;
        r3.a(r0);
    L23:
        if (r3.c() == true) goto L28;
        com.obric.oui.animation.a.b.InterfaceC0726b r2 = this.p;
        if (r2 == null) goto L29;
        r3.a(r2);
        return;
    L29:
        return;
    L28:
        return;
    L6:
        if (this.r == false) goto L8;
        r3.b();
        goto L8
    }

    public final float b() {
        if (this.l == false) goto L6;
        return this.n;
    L6:
        return this.m;
    }

    public final void b(float r1) {
        this.j = r1;
    }

    public final void c(float r2) {
        this.i = true;
        this.k = r2;
    }

    public final void d(float r1) {
        this.m = r1;
    }

    public final void e(float r2) {
        this.l = true;
        this.n = r2;
    }
}
