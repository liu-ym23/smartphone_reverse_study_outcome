package rx1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.android.livesdk.floatwindow.FloatWindowLifecycle;
import com.bytedance.bmmt.base.DeviceInfoAndroid;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g extends rx1.b {
    public final f a;
    public final l.a b;
    public ValueAnimator c;
    public TimeInterpolator d;
    public float e;
    public float f;
    public float g;
    public float h;
    public boolean i;
    public int j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;

    public class a implements d {
        public final /* synthetic */ g a;

        public final void a() {
            g r0 = this.a;
            if (r0.b.r == true) goto L5;
            r0.c();
        L5:
            e r1 = this.a.b.s;
            if (r1 == null) goto L9;
            r1.b();
            return;
        }

        public a(g r1) {
            this.a = r1;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ g a;

        public b(g r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.c.removeAllUpdateListeners();
            this.a.c.removeAllListeners();
            g r3 = this.a;
            r3.c = null;
            e r4 = r3.b.s;
            if (r4 == null) goto L6;
            r4.a();
            return;
        }
    }

    public final void a() {
        String r0 = this.b.q;
        ((HashMap) l.a).remove(r0);
        f r1 = this.a;
        if (r1.f == true) goto L6;
        r1.f = true;
        r1.a.removeView(r1.c);
    L6:
        this.l = false;
        e r2 = this.b.s;
        if (r2 == null) goto L10;
        r2.onDismiss();
        return;
    }

    public final View b() {
        this.j = ViewConfiguration.get(this.b.a).getScaledTouchSlop();
        return this.b.b;
    }

    public final void c() {
        if (this.k == false) goto L5;
        return;
    L5:
        if (this.l == false) goto L13;
        b().setVisibility(4);
        this.l = false;
        e r0 = this.b.s;
        if (r0 == null) goto L12;
        r0.onHide();
        return;
    L12:
        return;
    }

    public final void e() {
        if (this.k == false) goto L20;
        f r0 = this.a;
        if (Build.VERSION.SDK_INT < 26) goto L7;
        r0.b.type = 2038;
    L8:
        LocalTestManager.a(new Class[]{wy.a.class});
        WindowManager r3 = r0.a;     // Catch: IllegalStateException -> L11
        View r4 = r0.c;     // Catch: IllegalStateException -> L11
        WindowManager.LayoutParams r5 = r0.b;     // Catch: IllegalStateException -> L11
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r4, r5);     // Catch: IllegalStateException -> L11
        r3.addView(r4, r5);     // Catch: IllegalStateException -> L11
    L17:
        r0.f = false;
        this.k = false;
        this.l = true;
    L23:
        e r1 = this.b.s;
        if (r1 == null) goto L26;
        r1.onShow();
    L26:
        this.b.getClass();
        return;
    L11:
        e = move-exception;
        String r6 = e.getMessage();
        if (r6 != null) goto L15;
    L18:
        throw e;
    L15:
        if (r6.contains("has already been added to the window manager") == false) goto L18;
        r0.a.removeView(r0.c);
        WindowManager r7 = r0.a;
        View r8 = r0.c;
        WindowManager.LayoutParams r9 = r0.b;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r8, r9);
        r7.addView(r8, r9);
        goto L17
    L7:
        r0.b.type = 2002;
        goto L8
    L20:
        if (this.l == false) goto L22;
        return;
    L22:
        b().setVisibility(0);
        this.l = true;
        goto L23
    }

    public final void f() {
        if (this.b.p == null) goto L5;
    L8:
        this.c.setInterpolator(this.b.p);
        this.c.addListener(new b(this));
        this.c.setDuration(this.b.o).start();
        e r0 = this.b.s;
        if (r0 == null) goto L12;
        r0.c();
        return;
    L12:
        return;
    L5:
        if (this.d != null) goto L7;
        this.d = new DecelerateInterpolator();
    L7:
        l.a r1 = this.b;
        r1.p = this.d;
        goto L8
    }

    public g() {
        this.i = false;
        this.k = true;
    }

    public g(l.a r6) {
        this.i = false;
        this.k = true;
        this.b = r6;
        f r1 = new f(r6.a);
        this.a = r1;
        b().setOnTouchListener(new h(this));
        int r2 = r6.c;
        int r3 = r6.d;
        WindowManager.LayoutParams r4 = r1.b;
        r4.width = r2;
        r4.height = r3;
        r4.gravity = 8388659;
        r4.x = 0;
        r1.d = 0;
        r4.y = 0;
        r1.e = 0;
        r1.c = r6.b;
        if (r6.u == false) goto L6;
        r4.flags |= DeviceInfoAndroid.BUFFER_SIZE;
    L6:
        if (r6.v.isEmpty() == true) goto L11;
        String r0 = r6.v;
        if (r0.isEmpty() == true) goto L11;
        r1.b.setTitle(r0);
    L11:
        int r5 = r6.w;
        if (r5 == (-1)) goto L16;
        if (r5 == (-1)) goto L16;
        r1.b.flags = r5;
    L16:
        new FloatWindowLifecycle(r6.a, new a(this));
        boolean r7 = r6.n;
        if (r7 == false) goto L19;
        int r8 = r6.i;
    L20:
        this.r = r8;
        if (r7 == false) goto L23;
        int r9 = r6.h;
    L24:
        this.q = r9;
        if (r7 == false) goto L27;
        int r10 = r6.f;
    L28:
        this.o = r10;
        if (r7 == false) goto L31;
        int r11 = r6.g;
    L32:
        this.p = r11;
        return;
    L31:
        r11 = r6.k;
        goto L32
    L27:
        r10 = r6.j;
        goto L28
    L23:
        r9 = r6.l;
        goto L24
    L19:
        r8 = r6.m;
        goto L20
    }

    public final void d(Configuration r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (b() == null) goto L25;
        f r12 = this.a;
        if (r12 == null) goto L27;
        int r0 = r12.d;
        int r13 = r12.e;
        int r1 = b().getWidth();
        int r2 = b().getHeight();
        int r3 = UIUtils.getScreenWidth(this.b.a);
        int r4 = UIUtils.getScreenHeight(this.b.a);
        int r5 = this.o;
        boolean r7 = true;
        if (r0 >= r5) goto L11;
        r0 = r5;
        boolean r6 = true;
    L12:
        int r9 = this.p;
        if (r0 <= ((r3 - r1) - r9)) goto L15;
        r0 = (r3 - r9) - r1;
        r6 = true;
    L15:
        if (r13 >= 0) goto L17;
        r13 = 0;
        r6 = true;
    L17:
        int r8 = r4 - r2;
        if (r13 <= r8) goto L20;
        r13 = r8;
    L21:
        if (r7 == false) goto L26;
        this.a.a(r0, r13);
        return;
    L26:
        return;
    L20:
        r7 = r6;
        goto L21
    L11:
        r6 = false;
        goto L12
    L27:
        return;
    }
}
