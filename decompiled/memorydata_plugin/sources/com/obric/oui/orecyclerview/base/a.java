package com.obric.oui.orecyclerview.base;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012J\u001e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\u001bJ\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0012J\f\u0010$\u001a\u00020\t*\u00020\tH\u0002J\f\u0010#\u001a\u00020\t*\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/oui/orecyclerview/base/EdgeEffectAdapter;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animationElapsedTime", "", "animationStartTime", "currentDistance", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "<set-?>", "", "isFinished", "()Z", "mode", "", "pullDistanceSign", "springBack", "Lcom/obric/oui/orecyclerview/base/FluidSpringBack;", "totalPullDistance", "viewportRange", "computeScrollOffset", "getDistance", "onAbsorb", "", "velocity", "onPullDistance", "deltaDistance", "forReleasing", "fromAnim", "onRelease", "updateViewportRange", "px", "dp", "Companion", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0755a f14032a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f14033b;
    private float c;
    private long d;
    private long e;
    private d f;
    private float g;
    private float h;
    private float i;
    private int j;
    private boolean k;
    private final DisplayMetrics l;

    /* JADX INFO: renamed from: com.obric.oui.orecyclerview.base.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/orecyclerview/base/EdgeEffectAdapter$Companion;", "", "()V", "MODE_IDLE", "", "MODE_PULLING", "MODE_SPRING_BACK", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0755a {
        private C0755a() {
        }

        public /* synthetic */ C0755a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14032a = new C0755a(null);
    }

    public a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Context r7 = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.f14033b = r7;
        this.d = -1;
        this.e = -1;
        this.f = new d();
        this.k = true;
        this.l = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDisplayMetrics();
    }

    private final float a(float r2) {
        return TypedValue.applyDimension(1, r2, this.l);
    }

    private final float b(float r1) {
        return r1 / this.l.density;
    }

    public final float a(float r8, boolean r9, boolean r10) {
        boolean r1 = false;
        if (Math.signum(r8) != Math.signum(this.g)) goto L5;
        boolean r0 = true;
    L7:
        if (r0 != r9) goto L59;
        if (r10 == true) goto L59;
        float r11 = b(r8);
        if (this.j == 1) goto L20;
        float r4 = b.f14034a.b(Math.abs(b(this.g)), this.c) * (-Math.signum(this.g));
        this.h = r4;
        if (r4 != 0.0f) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L24;
        float r6 = Math.signum(r4);
    L25:
        this.i = r6;
    L26:
        float r7 = this.h;
        float r12 = r11 + r7;
        this.h = r12;
        float r13 = Math.signum(r12);
        float r14 = this.i;
        if (r13 != r14) goto L29;
        boolean r15 = true;
    L30:
        if (r15 == true) goto L40;
        if (r14 != 0.0f) goto L34;
        boolean r16 = true;
    L35:
        if (r16 == true) goto L40;
        if (r9 == false) goto L38;
        this.h = 0.0f;
        this.i = 0.0f;
        r12 = 0.0f;
    L45:
        this.g = a((-b.f14034a.a(Math.abs(r12), this.c)) * Math.signum(r12));
        this.j = 1;
        this.k = false;
        if (r0 == false) goto L58;
        if (r12 != 0.0f) goto L50;
        boolean r17 = true;
    L51:
        if (r17 == true) goto L53;
        return r8;
    L53:
        if (r7 != 0.0f) goto L55;
        r1 = true;
    L55:
        if (r1 == false) goto L62;
        return r8;
    L62:
        return -a(r7);
    L50:
        r17 = false;
        goto L51
    L58:
        return 0.0f;
    L38:
        this.i = Math.signum(r12);
        goto L45
    L34:
        r16 = false;
    L40:
        if (this.h != 0.0f) goto L42;
        boolean r18 = true;
    L43:
        if (r18 == false) goto L45;
        this.i = 0.0f;
        goto L45
    L42:
        r18 = false;
        goto L43
    L29:
        r15 = false;
    L24:
        r6 = Math.signum(r11);
        goto L25
    L15:
        r5 = false;
        goto L16
    L20:
        if (this.i != 0.0f) goto L22;
        boolean r19 = true;
    L23:
        if (r19 == false) goto L26;
    L22:
        r19 = false;
    L59:
        return 0.0f;
    L5:
        r0 = false;
        goto L7
    }

    public final void a(int r3) {
        float r4 = b(r3 / 1000.0f);
        this.d = AnimationUtils.currentAnimationTimeMillis();
        this.f.a(r4, 0.0f);
        this.j = 2;
        this.k = false;
    }

    public final boolean a() {
        return this.k;
    }

    public final float b() {
        return this.g;
    }

    public final void b(int r1) {
        this.c = b(r1);
    }

    public final void c() {
        float r0 = b(this.g);
        this.d = AnimationUtils.currentAnimationTimeMillis();
        this.f.a((-r0) / 100.0f, r0);
        this.j = 2;
        this.k = false;
    }

    public final boolean d() {
        if (this.d != (-1)) goto L6;
        return false;
    L6:
        if (this.j != 1) goto L8;
        return true;
    L8:
        long r3 = AnimationUtils.currentAnimationTimeMillis() - this.d;
        this.e = r3;
        d.a r0 = this.f.a(r3);
        this.g = a(r0.a());
        boolean r1 = r0.b();
        this.k = r1;
        if (r1 == false) goto L12;
        this.j = 0;
    L12:
        return !r1;
    }
}
