package t3a;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public final Context a;
    public final View b;
    public final e c;
    public final int d;
    public final int e;
    public int f;
    public int g;
    public int h;
    public final WindowManager.LayoutParams i;
    public WindowManager j;
    public final int k;
    public int l;
    public final Handler m;
    public float n;
    public float o;
    public float p;
    public float q;
    public long r;
    public long s;
    public boolean t;
    public boolean u;
    public int v;
    public final long w;
    public final long x;
    public final long y;
    public a z;

    public interface a {
        void a(View r1);

        void onClick(View r1);

        void onLongClick(View r1);
    }

    /* JADX INFO: renamed from: t3a.b$b, reason: collision with other inner class name */
    public static final class ViewOnTouchListenerC0110b implements View.OnTouchListener {
        public final /* synthetic */ b a;

        public ViewOnTouchListenerC0110b(b r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r10, MotionEvent r11) {
            Intrinsics.checkNotNullParameter(r10, "view");
            Intrinsics.checkNotNullParameter(r11, "motionEvent");
            int r12 = r11.getAction();
            if (r12 != 0) goto L5;
            b r13 = this.a;
            r13.t = true;
            r13.n = r11.getRawX();
            this.a.o = r11.getRawY();
            this.a.r = System.currentTimeMillis();
            final b r14 = this.a;
            r14.m.postDelayed(new c(r14), r14.w);
            final b r15 = this.a;
            if (r15.u == false) goto L48;
            r15.u = false;
            r15.m.postDelayed(new d(r15), r15.x);
        L48:
            return false;
        L5:
            if (r12 == 1) goto L24;
            if (r12 != 2) goto L48;
            b r16 = this.a;
            float r0 = r11.getRawX();
            float r2 = r11.getRawY();
            WindowManager.LayoutParams r3 = r16.i;
            int r4 = r3.x;
            float r5 = r16.p;
            if (r5 >= 0.0f) goto L11;
            int r1 = 0;
        L12:
            r3.x = r4 + r1;
            int r6 = r3.y;
            float r7 = r16.q;
            if (r7 >= 0.0f) goto L15;
            int r8 = 0;
        L16:
            r3.y = r6 + r8;
            WindowManager r9 = r16.j;
            if (r9 == null) goto L19;
            r9.updateViewLayout(r16.b, r3);
        L19:
            this.a.p = r11.getRawX();
            this.a.q = r11.getRawY();
            b r17 = this.a;
            float r18 = Math.abs(r17.n - r17.p);
            b r19 = this.a;
            if (r18 <= r19.k) goto L22;
        L23:
            this.a.t = false;
            goto L48
        L22:
            if (Math.abs(r19.o - r19.q) <= this.a.k) goto L48;
        L15:
            r8 = (int) (r2 - r7);
            goto L16
        L11:
            r1 = (int) (r0 - r5);
            goto L12
        L24:
            b r110 = this.a;
            r110.t = false;
            r110.p = r11.getRawX();
            this.a.q = r11.getRawY();
            this.a.s = System.currentTimeMillis();
            b r111 = this.a;
            float r112 = Math.abs(r111.n - r111.p);
            b r113 = this.a;
            if (r112 >= r113.k) goto L31;
            float r114 = Math.abs(r113.o - r113.q);
            b r115 = this.a;
            if (r114 >= r115.k) goto L31;
            if ((r115.s - r115.r) >= r115.y) goto L31;
            r115.v++;
        L31:
            final b r20 = this.a;
            if (r20.l == 0) goto L44;
            final int r21 = r20.i.x;
            int r116 = r20.d;
            int r117 = (r20.g - r20.b.getMeasuredWidth()) - r20.d;
            if (r20.i.x <= ((r20.g - r20.b.getMeasuredWidth()) / 2)) goto L36;
            final int r22 = r117;
        L37:
            final int r23 = r20.i.y;
            int r118 = r20.e;
            int r119 = ((r20.f - r20.h) - r20.b.getMeasuredHeight()) - r20.e;
            int r24 = r20.i.y;
            if (r24 <= r119) goto L40;
            final int r25 = r119;
        L43:
            ValueAnimator r120 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r120.setDuration(300);
            r120.addUpdateListener(new t3a.a(r20, r21, r22, r23, r25));
            r120.setInterpolator(new AccelerateDecelerateInterpolator());
            r120.start();
            goto L44
        L40:
            if (r24 >= r118) goto L42;
            r25 = r118;
            goto L43
        L42:
            r25 = r24;
            goto L43
        L36:
            r22 = r116;
        L44:
            b r121 = this.a;
            r121.p = -1.0f;
            r121.q = -1.0f;
            goto L48
        }
    }

    public final void b() {
        WindowManager.LayoutParams r0 = this.i;
        r0.x = (this.g - this.d) - r0.width;
        e r1 = this.c;
        r0.y = r1.d;
        if ((!r1.e) == false) goto L6;
        r0.flags |= 16;
        return;
    }

    public final void a(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Object r6 = r5.getSystemService("window");
        if ((r6 instanceof WindowManager) == false) goto L5;
        WindowManager r7 = (WindowManager) r6;
    L6:
        this.j = r7;
        this.i.token = null;
        if ((!this.c.e) == false) goto L9;
        b();
    L13:
        if (this.j == null) goto L31;
        int r8 = hashCode();
        if (r8 != this.l) goto L18;
        return;
    L18:
        if (this.b.getParent() == null) goto L20;
        c(this.b);
    L20:
        View r0 = this.b;
        WindowManager.LayoutParams r1 = this.i;
        WindowManager r2 = this.j;     // Catch: Exception -> L25
        if (r2 == null) goto L27;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r0, r1);     // Catch: Exception -> L25
        r2.addView(r0, r1);     // Catch: Exception -> L25
    L27:
        this.l = r8;
        return;
    L25:
        e = move-exception;
        FLogger.a.i("FloatingWindow", "addWindowView error " + e.getMessage());
        goto L27
    L31:
        return;
    L9:
        int r9 = com.larus.utils.i.c(this.a);
        if (r9 == this.f) goto L13;
        this.f = r9;
        this.g = com.larus.utils.i.d(this.a);
        this.h = com.larus.utils.i.e(this.a);
        b();
        goto L13
    L5:
        r7 = null;
        goto L6
    }

    public final void c(View r4) {
        WindowManager r0 = this.j;     // Catch: Exception -> L6
        if (r0 == null) goto L11;
        r0.removeViewImmediate(r4);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        FLogger.a.i("FloatingWindow", "removeWindowView error " + e.getMessage());
    }

    public b(Context r4, View r5, e r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "floatingView");
        Intrinsics.checkNotNullParameter(r6, "config");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = 32;
        this.e = 32;
        this.f = com.larus.utils.i.c(r4);
        this.g = com.larus.utils.i.d(r4);
        this.h = com.larus.utils.i.e(r4);
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams();
        this.i = r0;
        this.k = ViewConfiguration.get(r4).getScaledTouchSlop();
        this.m = new Handler(Looper.getMainLooper());
        this.n = -1.0f;
        this.o = -1.0f;
        this.p = -1.0f;
        this.q = -1.0f;
        this.u = true;
        this.w = 500;
        this.x = 300;
        this.y = 200;
        r0.type = 2;
        r0.flags = 552;
        r0.format = 1;
        r0.gravity = 8388659;
        r0.width = r6.a;
        r0.height = r6.b;
        if ((true ^ r6.e) == false) goto L5;
        ViewOnTouchListenerC0110b r7 = null;
    L6:
        if (r7 == null) goto L8;
        r5.setOnTouchListener(r7);
    L8:
        b();
        return;
    L5:
        r7 = new ViewOnTouchListenerC0110b(this);
        goto L6
    }
}
