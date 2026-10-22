package com.ss.android.lark.chat.message.menu.v2;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b0 implements f {
    public final View a;
    public final int b;
    public final RecyclerView c;
    public final h d;
    public final com.ss.android.lark.chat.message.menu.v2.c e;
    public int f;
    public float g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public final int[] m;
    public final float n;
    public final int o;
    public boolean p;
    public final int q;
    public float r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Function2<Boolean, int[], Unit> w;
    public final Function1<Boolean, Unit> x;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ b0 b;

        public b(RecyclerView r1, b0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            b0 r0 = this.b;
            int r1 = r0.b;
            if (r1 != 0) goto L5;
            return;
        L5:
            if (r0.e.a() == false) goto L11;
            r0.a.getLocationOnScreen(r0.m);
            int r2 = r0.m[1];
            int r3 = r0.q;
            if (r2 == r3) goto L11;
            r1 = Math.max(r1 - (r2 - r3), 0);
        L11:
            b0 r4 = this.b;
            int r5 = r4.b - r1;
            if (r5 == 0) goto L16;
            float r6 = r4.g + r5;
            r4.g = r6;
            r4.c.setTranslationY(r4.n - r6);
            this.b.h = r5;
            return;
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
    }

    public static final class c implements Runnable {
        public final /* synthetic */ b0 a;
        public final /* synthetic */ float b;

        public c(b0 r1, float r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b0 r0 = this.a;     // Catch: Throwable -> L6
            h r1 = r0.d;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            int r2 = r0.l;     // Catch: Throwable -> L6
            r1.b(new int[]{(int) (r2 - this.b), r2});     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void c() {
        this.i = false;
        this.x.invoke(Boolean.TRUE);
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void a() {
        if (this.c.getTranslationY() != this.n) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        i(this.c.getTranslationY(), this.n, new MessageListAndPanelScrollCoordinator$onPanelDismiss$1(this), new MessageListAndPanelScrollCoordinator$onPanelDismiss$2(this));
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void b() {
        RecyclerView r0 = this.c;
        OneShotPreDrawListener.add(r0, new b(r0, this));
        this.x.invoke(Boolean.TRUE);
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void f() {
        float r0 = this.c.getTranslationY();
        float r1 = this.n;
        if (r0 != r1) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        this.c.setTranslationY(r1);
        this.f = 0;
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void h() {
        if (this.c.getTranslationY() != this.n) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        float r1 = this.c.getTranslationY();
        float r2 = this.n;
        Function0<Unit> r3 = new MessageListAndPanelScrollCoordinator$onPanelTempDismiss$1(this);
        i(r1, r2, MessageListAndPanelScrollCoordinator$startTranslationAnim$1.INSTANCE, r3);
        this.i = false;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void g(final float r8) {
        float r1 = 0.0f;
        if (this.k == false) goto L6;
        float r0 = 0.0f;
    L9:
        MessageListAndPanelScrollCoordinator$onPanelFirstShow$1 r2 = MessageListAndPanelScrollCoordinator$onPanelFirstShow$1.INSTANCE;
        Function0<Unit> r3 = new MessageListAndPanelScrollCoordinator$onPanelFirstShow$2(this, r8);
        if (r0 != 0.0f) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L16;
        r1 = ((r0 + this.h) - this.f) - this.g;
    L16:
        int r4 = (int) r1;
        ValueAnimator r9 = ValueAnimator.ofInt(new int[]{0, r4});
        Ref.IntRef r6 = new Ref.IntRef();
        r9.setInterpolator(new AccelerateDecelerateInterpolator());
        r9.setDuration(250);
        r9.addUpdateListener(new e0(r6, this));
        Intrinsics.checkNotNull(r9);
        r9.addListener(new d0(r2));
        r9.addListener(new c0(r3, this, r1, r4));
        r9.start();
        return;
    L12:
        r5 = false;
        goto L13
    L6:
        if (this.j == false) goto L8;
        r0 = (this.q - (this.o + this.e.w3())) - ((Number) this.t.getValue()).intValue();
        goto L9
    L8:
        r0 = Math.max(0.0f, r8 - this.r);
        goto L9
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void e(int r4, float r5) {
        this.l = r4;
        boolean r1 = true;
        if (this.a.getMeasuredHeight() < (((r4 - r5) - ((Number) this.u.getValue()).intValue()) - ((Number) this.v.getValue()).intValue())) goto L5;
        boolean r6 = true;
    L6:
        this.j = r6;
        if (r6 == false) goto L13;
        this.i = false;
        if ((this.q - (this.o + this.e.w3())) < ((Number) this.t.getValue()).intValue()) goto L12;
        r1 = false;
    L12:
        this.k = r1;
        return;
    L13:
        this.r = (r4 - (this.q + this.a.getMeasuredHeight())) - ((Number) this.s.getValue()).intValue();
        return;
    L5:
        r6 = false;
        goto L6
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void d(float r2, float r3, long r4) {
        if (r2 != r3) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L9;
        return;
    L9:
        if (this.i == true) goto L12;
        this.a.postDelayed(new c(this, r3), r4);
        return;
    L12:
        return;
    L5:
        r5 = false;
        goto L6
    }

    public final void i(float r4, float r5, Function0 r6, Function0 r7) {
        if (r4 != r5) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{r4, r5});
        r8.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        r8.setDuration(200);
        r8.addUpdateListener(new h0(this));
        Intrinsics.checkNotNull(r8);
        r8.addListener(new g0(r6));
        r8.addListener(new f0(r7));
        r8.start();
        return;
    L5:
        r2 = false;
        goto L6
    }

    public b0(View r2, int r3, RecyclerView r4, MessageActionPanelManager$showOverlayMessageMenu$1.b r5, MessageActionPanelManager$showOverlayMessageMenu$1.a r6) {
        Intrinsics.checkNotNullParameter(r2, "anchorView");
        Intrinsics.checkNotNullParameter(r4, "listView");
        Intrinsics.checkNotNullParameter(r6, "dependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.i = true;
        int[] r7 = new int[2];
        this.m = r7;
        this.n = r4.getTranslationY();
        r4.getLocationOnScreen(r7);
        this.o = r7[1];
        this.p = true;
        r2.getLocationOnScreen(r7);
        this.q = r7[1];
        this.s = LazyKt.lazy(new MessageListAndPanelScrollCoordinator$minBottomOffset$2(this));
        this.t = LazyKt.lazy(new MessageListAndPanelScrollCoordinator$minTopOffset$2(this));
        this.u = LazyKt.lazy(new MessageListAndPanelScrollCoordinator$titleHeightToCheckLong$2(this));
        this.v = LazyKt.lazy(new MessageListAndPanelScrollCoordinator$statusHeight$2(this));
        this.w = new MessageListAndPanelScrollCoordinator$showSelectedWindowAction$1(this);
        this.x = new MessageListAndPanelScrollCoordinator$hideSelectedWindowAction$1(this);
    }
}
