package n8;

import android.view.Choreographer;
import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f11266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f11267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function3<? super String, Object, ? super Float, Unit> f11268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function2<? super Boolean, ? super Throwable, Unit> f11269d;

    /* JADX INFO: renamed from: n8.a$a, reason: collision with other inner class name */
    public static final class C0247a {
        private C0247a() {
        }

        public /* synthetic */ C0247a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f11270c;

        b(a r10) {
            this.f11270c = r10;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long r10) {
            if (a.b(this.f11270c).n() == false) goto L9;
            if (a.b(this.f11270c).k() != null) goto L9;
            t8.b.f12973c.e("AnimatableRunner", "doFrame, view is null");
            return;
        L9:
            if (a.b(this.f11270c).j() != 0) goto L12;
            a.b(this.f11270c).w(r10);
        L12:
            if (a.b(this.f11270c).e() == 0) goto L14;
            a.b(this.f11270c).e();
        L14:
            a.b(this.f11270c).r(r10);
            if (a.b(this.f11270c).m() == false) goto L20;
            if (a.b(this.f11270c).f() != 0) goto L40;
            a.b(this.f11270c).s(r10);
            return;
        L40:
            return;
        L20:
            if (a.b(this.f11270c).f() <= 0) goto L22;
            long r11 = r10 - a.b(this.f11270c).f();
            a.b(this.f11270c).o(a.b(this.f11270c).b() + r11);
            a.b(this.f11270c).s(0);
        L22:
            long r12 = (r10 - a.b(this.f11270c).j()) - a.b(this.f11270c).b();
            RunMode r13 = a.b(this.f11270c).h();
            int r14 = n8.b.f11271a[r13.ordinal()];
            if (r14 == 1) goto L27;
            if (r14 != 2) goto L29;
            a.e(this.f11270c, r12, r10);
        L29:
            if (a.b(this.f11270c).l() == false) goto L31;
        L30:
            Choreographer.getInstance().postFrameCallback(this);
            return;
        L31:
            Choreographer.getInstance().removeFrameCallback(this);
            RepeatMode r15 = a.b(this.f11270c).g();
            int r16 = n8.b.f11272b[r15.ordinal()];
            if (r16 == 1) goto L39;
            if (r16 != 2) goto L35;
            t8.b.f12973c.e("AnimatableRunner", "doFrame, 触发 reverse");
            a.b(this.f11270c).p(CollectionsKt.reversed(a.b(this.f11270c).c()));
            a.c(this.f11270c, true);
            goto L30
        L35:
            if (r16 != 3) goto L44;
            a.a(this.f11270c, true);
            return;
        L44:
            return;
        L39:
            t8.b.f12973c.e("AnimatableRunner", "doFrame, 触发 loop");
            a.c(this.f11270c, false);
            goto L30
        L27:
            a.d(this.f11270c, r12, r10);
            goto L29
        }
    }

    static {
        new C0247a(null);
    }

    public a(c r10, Function3<? super String, Object, ? super Float, Unit> r11, Function2<? super Boolean, ? super Throwable, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "stateManager");
        this.f11267b = r10;
        this.f11268c = r11;
        this.f11269d = r12;
        this.f11266a = new b(this);
    }

    public static final /* synthetic */ void a(a r10, boolean r11) {
        r10.g(r11);
    }

    public static final /* synthetic */ c b(a r10) {
        return r10.f11267b;
    }

    public static final /* synthetic */ void c(a r10, boolean r11) {
        r10.k(r11);
    }

    public static final /* synthetic */ void d(a r10, long r11, long r12) {
        r10.l(r11, r12);
    }

    public static final /* synthetic */ void e(a r10, long r11, long r12) {
        r10.m(r11, r12);
    }

    private final void g(boolean r10) {
        t8.b.f12973c.e("AnimatableRunner", "endAnimationInternal, clearVelocity: " + r10);
        Choreographer.getInstance().removeFrameCallback(this.f11266a);
        this.f11267b.a(r10);
        j("endAnimationInternal");
    }

    private final boolean h(String r10, long r11, j8.a<?> r12, long r13, boolean r14) {
        long r15 = (long) (r11 * this.f11267b.i());
        Object r16 = r12.i(r15);
        View r17 = this.f11267b.k();
        if (r12.c() != (-1)) goto L5;
        r12.n(r13);
    L5:
        boolean r18 = r12.k(r15);
        if (r17 == null) goto L12;
        String r19 = r12.f();
        if (r18 == false) goto L10;
        Object r20 = r12.h();
    L11:
        defpackage.b.d(r17, r19, r20);
        goto L12
    L10:
        r20 = r16;
    L12:
        r12.p(r13);
        r12.q(!r18);
        float r21 = r12.j(r15);
        if (r18 == true) goto L15;
        Function3<? super String, Object, ? super Float, Unit> r22 = this.f11268c;
        if (r22 == null) goto L24;
        Unit r23 = r22.invoke(r12.f(), r16, Float.valueOf(r21));
    L24:
        return r18;
    L15:
        if (r14 == false) goto L19;
        t8.b.f12973c.e("AnimatableRunner", "executeAnimation, " + r10 + ", return case 1, property: " + r12.f() + ", targetValue: " + r12.h());
        Function2<? super Boolean, ? super Throwable, Unit> r24 = this.f11269d;
        if (r24 == null) goto L24;
        r23 = r24.invoke(Boolean.TRUE, null);
        goto L24
    L19:
        t8.b.f12973c.e("AnimatableRunner", "executeAnimation, " + r10 + ", return case 2, property: " + r12.f() + ", targetValue: " + r12.h());
        goto L24
    }

    static /* synthetic */ boolean i(a r10, String r11, long r12, j8.a r13, long r14, boolean r16, int r17, Object r18) {
        if ((r17 & 16) == 0) goto L5;
        boolean r15 = true;
    L7:
        return r10.h(r11, r12, r13, r14, r15);
    L5:
        r15 = r16;
        goto L7
    }

    private final void j(String r10) {
        t8.b.f12973c.a("AnimatableRunner", "releaseCallbacks, scene: " + r10);
        this.f11268c = null;
        this.f11269d = null;
    }

    private final void k(boolean r10) {
        View r11 = this.f11267b.k();
        Iterator<T> r12 = this.f11267b.c().iterator();
    L4:
        if (r12.hasNext() == false) goto L13;
        j8.a r13 = (j8.a) r12.next();
        if (r11 == null) goto L12;
        String r14 = r13.f();
        if (r10 == false) goto L10;
        Object r15 = r13.h();
    L11:
        defpackage.b.d(r11, r14, r15);
        goto L12
    L10:
        r15 = r13.d();
    L12:
        r13.m(true, r10, true);
        goto L4
    L13:
        this.f11267b.w(0);
        this.f11267b.s(0);
        this.f11267b.o(0);
        this.f11267b.r(0);
        this.f11267b.q(-1);
    }

    private final void l(long r15, long r17) {
        List<j8.a<?>> r10 = this.f11267b.c();
        int r11 = 0;
        if (r10.size() <= 1) goto L14;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r10.iterator();
    L6:
        if (r13.hasNext() == false) goto L11;
        Object r14 = r13.next();
        if (((j8.a) r14).l() == false) goto L6;
        r12.add(r14);
        goto L6
    L11:
        if (r12.size() == 1) goto L14;
        boolean r16 = false;
    L15:
        Iterator<T> r18 = r10.iterator();
        int r19 = 0;
    L17:
        if (r18.hasNext() == false) goto L27;
        Object r20 = r18.next();
        int r110 = r11 + 1;
        if (r11 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        j8.a<?> r21 = (j8.a) r20;
        if (r21.l() == true) goto L24;
    L25:
        r19 = r19 + 1;
    L26:
        r11 = r110;
        goto L17
    L24:
        if (h("runParallelAnimations", r15, r21, r17, r16) == false) goto L26;
    L27:
        if (r16 == false) goto L29;
        return;
    L29:
        if (r19 != r10.size()) goto L43;
        t8.b.f12973c.a("AnimatableRunner", "runParallelAnimations, all finished");
        Function2<? super Boolean, ? super Throwable, Unit> r22 = this.f11269d;
        if (r22 == null) goto L44;
        Unit r23 = r22.invoke(Boolean.TRUE, null);
        return;
    L44:
        return;
    L43:
        return;
    L14:
        r16 = true;
        goto L15
    }

    private final void m(long r12, long r14) {
        if (this.f11267b.d() != (-1)) goto L6;
        this.f11267b.q(0);
    L6:
        if (this.f11267b.d() < this.f11267b.c().size()) goto L9;
        t8.b.f12973c.a("AnimatableRunner", "runSequentialAnimations, return case 1");
        return;
    L9:
        long r10 = (long) (r12 * this.f11267b.i());
        j8.a<?> r11 = this.f11267b.c().get(this.f11267b.d());
        boolean r13 = r11.k(r10);
        r11.q(!r13);
        boolean r15 = false;
        if (r13 == false) goto L18;
        h("runSequentialAnimations 1", r12, r11, r14, false);
        c r16 = this.f11267b;
        r16.q(r16.d() + 1);
        if (this.f11267b.d() < this.f11267b.c().size()) goto L17;
        t8.b.f12973c.a("AnimatableRunner", "runSequentialAnimations, return case 2");
        Function2<? super Boolean, ? super Throwable, Unit> r17 = this.f11269d;
        if (r17 == null) goto L21;
        Unit r18 = r17.invoke(Boolean.TRUE, null);
        return;
    L21:
        return;
    L17:
        this.f11267b.w(0);
        this.f11267b.s(0);
        this.f11267b.o(0);
        this.f11267b.r(0);
        long r19 = 0;
        r11 = this.f11267b.c().get(this.f11267b.d());
        r15 = false;
        int r20 = 16;
        Object r110 = null;
        String r21 = "runSequentialAnimations 2";
    L19:
        i(this, r21, r19, r11, r14, r15, r20, r110);
        return;
    L18:
        r20 = 16;
        r110 = null;
        r21 = "runSequentialAnimations 3";
        r19 = r12;
        goto L19
    }

    public final void f(boolean r10) {
        t8.b.f12973c.e("AnimatableRunner", "cancelAnimation, clearVelocity: " + r10);
        Choreographer.getInstance().removeFrameCallback(this.f11266a);
        this.f11267b.a(r10);
        Function2<? super Boolean, ? super Throwable, Unit> r11 = this.f11269d;
        if (r11 == null) goto L5;
        Unit r12 = r11.invoke(Boolean.FALSE, null);
    L5:
        j("cancelAnimation");
    }

    public final void n() {
        Choreographer.getInstance().postFrameCallback(this.f11266a);
    }
}
