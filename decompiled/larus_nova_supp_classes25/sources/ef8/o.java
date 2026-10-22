package ef8;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.PopupWindow;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.api.b0;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.interaction.ObricMessagePopupServiceDelegate;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o {
    public static WeakReference<o> v;
    public static final CopyOnWriteArraySet<WeakReference<Balloon>> w = null;
    public final Fragment a;
    public final b0 b;
    public final st8.a c;
    public final View d;
    public Balloon e;
    public final int[] f;
    public CommonMenu g;
    public View h;
    public ji8.f i;
    public b j;
    public View k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public final d s;
    public final e t;
    public final f u;

    public static final class a {
        public static void a() {
            l0.b(new n());
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;
        public final int l;
        public final int m;
        public final int n;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (this.n == r6.n) goto L50;
            return false;
        L50:
            return true;
        }

        public final int hashCode() {
            return (((((((((((((((((((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31) + this.n;
        }

        public final String toString() {
            return "MenuGeometry(decorLeft=" + this.a + ", decorTop=" + this.b + ", decorWidth=" + this.c + ", decorHeight=" + this.d + ", hostLeft=" + this.e + ", hostTop=" + this.f + ", hostRight=" + this.g + ", hostBottom=" + this.h + ", anchorLeft=" + this.i + ", anchorTop=" + this.j + ", anchorWidth=" + this.k + ", anchorHeight=" + this.l + ", menuWidth=" + this.m + ", menuHeight=" + this.n + ')';
        }

        public b(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
            this.l = r12;
            this.m = r13;
            this.n = r14;
        }
    }

    static {
        w = new CopyOnWriteArraySet();
    }

    public final b b() {
        View r1 = this.d;
        if (r1 != null) goto L5;
        return null;
    L5:
        FragmentActivity r3 = this.a.getActivity();
        if (r3 == null) goto L58;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L58;
        View r5 = a(r4);
        if (r5 == null) goto L58;
        RecyclerView r6 = this.b.m();
        if (r1.isShown() == false) goto L58;
        if (r6.isShown() == false) goto L58;
        if (r5.isShown() == false) goto L58;
        if (r1.isAttachedToWindow() == false) goto L58;
        if (r6.isAttachedToWindow() == false) goto L58;
        if (r5.isAttachedToWindow() == false) goto L58;
        if (r1.getWidth() <= 0) goto L58;
        if (r1.getHeight() <= 0) goto L58;
        if (r6.getWidth() <= 0) goto L58;
        if (r5.getWidth() <= 0) goto L58;
        CommonMenu r7 = this.h;
        if (r7 != null) goto L41;
        r7 = this.g;
        if (r7 != null) goto L41;
        return null;
    L41:
        r7.measure(0, 0);
        CommonMenu r8 = this.g;
        if (r8 == null) goto L44;
        r8.measure(0, 0);
    L44:
        int r9 = r7.getMeasuredWidth();
        CommonMenu r10 = this.g;
        if (r10 == null) goto L47;
        int r11 = r10.getMeasuredWidth();
    L48:
        int r22 = Math.max(r9, r11);
        int r12 = r7.getMeasuredHeight();
        CommonMenu r13 = this.g;
        if (r13 == null) goto L51;
        int r14 = r13.getMeasuredHeight();
    L52:
        int r23 = Math.max(r12, r14);
        if (r22 <= 0) goto L58;
        if (r23 <= 0) goto L58;
        int[] r15 = new int[2];
        int[] r16 = new int[2];
        int[] r2 = new int[2];
        r5.getLocationInWindow(r15);
        r6.getLocationInWindow(r16);
        r1.getLocationInWindow(r2);
        int r17 = r15[0];
        int r18 = r15[1];
        int r19 = r5.getWidth();
        int r110 = r5.getHeight();
        int r111 = r16[0];
        return new b(r17, r18, r19, r110, r111, r16[1], r111 + r6.getWidth(), r16[1] + r6.getHeight(), r2[0], r2[1], r1.getWidth(), r1.getHeight(), r22, r23);
    L51:
        r14 = 0;
        goto L52
    L47:
        r11 = 0;
    L58:
        return null;
    }

    public final void c() {
        View r0 = this.d;
        if (r0 == null) goto L5;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
    L7:
        if (this.l == false) goto L15;
        if (r1 == null) goto L12;
        boolean r4 = true;
        if (r1.isAlive() != true) goto L12;
    L13:
        if (r4 == false) goto L15;
        r1.removeOnScrollChangedListener(this.s);
    L12:
        r4 = false;
    L15:
        this.l = false;
        f();
        ji8.f r2 = this.i;
        if (r2 == null) goto L18;
        AudioServiceDelegate.a.r0().k(r2);
    L18:
        this.b.m().requestDisallowInterceptTouchEvent(false);
        final Balloon r3 = this.e;
        l0.b(new l(r3));
        WeakReference<o> r5 = v;
        if (r5 == null) goto L21;
        o r6 = r5.get();
    L23:
        if (Intrinsics.areEqual(r6, this) == false) goto L25;
        v = null;
    L25:
        CommonMenu r7 = this.g;
        if (r7 == null) goto L28;
        com.larus.utils.l.d(r7, "message_menu_dismiss_second_menu_only");
    L28:
        this.e = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.o = 0;
        this.p = false;
        this.r = false;
        return;
    L21:
        r6 = null;
        goto L23
    L5:
        r1 = null;
        goto L7
    }

    public final void d() {
        if (this.r == true) goto L13;
        Balloon r0 = this.e;
        if (r0 == null) goto L7;
        r0.h();
    L7:
        View r1 = this.d;
        if (r1 == null) goto L22;
        ViewTreeObserver r2 = r1.getViewTreeObserver();
        if (r2 == null) goto L23;
        r2.removeOnScrollChangedListener(this.t);
        return;
    L23:
        return;
    L22:
        return;
    L13:
        boolean r3 = false;
        this.q = false;
        Balloon r4 = this.e;
        if (r4 != null) goto L16;
    L18:
        if (r3 == false) goto L20;
        r4.h();
        return;
    L20:
        c();
        return;
    L16:
        if (r4.g != true) goto L18;
        r3 = true;
        goto L18
    }

    public final void f() {
        View r0 = this.k;
        if (r0 == null) goto L5;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
    L7:
        if (this.m == false) goto L15;
        if (r1 == null) goto L12;
        boolean r4 = true;
        if (r1.isAlive() != true) goto L12;
    L13:
        if (r4 == false) goto L15;
        r1.removeOnGlobalLayoutListener(this.u);
    L12:
        r4 = false;
    L15:
        this.k = null;
        this.m = false;
        this.n = false;
        return;
    L5:
        r1 = null;
        goto L7
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void g(final boolean r5) {
        RecyclerView r0 = this.b.m();
        int r1 = this.o;
        if (r1 < 6) goto L7;
        d();
        return;
    L7:
        if (this.p == false) goto L9;
        return;
    L9:
        this.o = r1 + 1;
        this.p = true;
        if (r0.postDelayed(new j(this, r5), 80) == true) goto L13;
        this.p = false;
        d();
        return;
    }

    public final void e(b r7, boolean r8) {
        this.o = 0;
        b r1 = this.j;
        if (r1 != null) goto L7;
        this.j = r7;
        return;
    L7:
        if (Intrinsics.areEqual(r7, r1) == false) goto L9;
        return;
    L9:
        CommonMenu r2 = this.g;
        if (r2 != null) goto L13;
        return;
    L13:
        if (r7.j == r1.j) goto L45;
        Intrinsics.checkNotNullParameter(r1, "previous");
        if (r7.a == r1.a) goto L17;
    L42:
        boolean r3 = true;
    L43:
        if (r3 == true) goto L45;
        boolean r4 = true;
    L46:
        if (r4 == false) goto L54;
        if (r8 == false) goto L54;
        if (this.b.m().getScrollState() == 0) goto L51;
        boolean r9 = true;
    L52:
        if (r9 == false) goto L54;
        d();
        return;
    L51:
        r9 = false;
    L54:
        Balloon r10 = this.e;
        if (r10 == null) goto L67;
        com.larus.bmhome.view.screenmenu.d r5 = com.larus.bmhome.view.screenmenu.d.a;
        if (com.larus.bmhome.view.screenmenu.d.e(r2) == false) goto L60;
        com.larus.utils.l.c(r2, "message_menu_dismiss_second_menu_only", Boolean.TRUE);
        com.larus.bmhome.view.screenmenu.d.b(r2);
    L61:
        this.q = true;
        r10.h();
        this.q = false;
        if (i(r2, r7) == true) goto L66;
        d();
        return;
    L66:
        return;
    L60:
        com.larus.utils.l.d(r2, "message_menu_dismiss_second_menu_only");
        goto L61
    L67:
        return;
    L17:
        if (r7.b != r1.b) goto L42;
        if (r7.c != r1.c) goto L42;
        if (r7.d != r1.d) goto L42;
        if (r7.e != r1.e) goto L42;
        if (r7.f != r1.f) goto L42;
        if (r7.g != r1.g) goto L42;
        if (r7.h != r1.h) goto L42;
        if (r7.i != r1.i) goto L42;
        if (r7.k != r1.k) goto L42;
        if (r7.l != r1.l) goto L42;
        if (r7.m != r1.m) goto L42;
        if (r7.n != r1.n) goto L42;
        r3 = false;
    L45:
        r4 = false;
        goto L46
    }

    public final void h(int r5, int r6) {
        Balloon r0 = this.e;
        if (r0 == null) goto L5;
        r0.h();
    L5:
        View r1 = this.d;
        if (r1 == null) goto L10;
        ViewTreeObserver r2 = r1.getViewTreeObserver();
        if (r2 == null) goto L10;
        r2.removeOnScrollChangedListener(this.t);
    L10:
        View r3 = this.d;
        if (r3 != null) goto L13;
        return;
    L13:
        ViewTreeObserver r4 = r3.getViewTreeObserver();
        if (r4 == null) goto L16;
        r4.addOnScrollChangedListener(this.t);
    L16:
        Fragment r7 = this.a;
    L17:
        PopupWindow r8 = null;
        if (r7 == null) goto L33;
        if ((r7 instanceof DialogFragment) == false) goto L22;
        DialogFragment r9 = (DialogFragment) r7;
    L23:
        if (r9 == null) goto L29;
        Dialog r10 = r9.getDialog();
        if (r10 == null) goto L29;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L29;
        View r12 = a(r11);
    L30:
        if (r12 != null) goto L49;
        r7 = r7.getParentFragment();
    L49:
        if (r12 != null) goto L51;
        return;
    L51:
        ObricMessagePopupServiceDelegate r13 = ObricMessagePopupServiceDelegate.b;
        Balloon r14 = this.e;
        if (r14 == null) goto L54;
        r8 = r14.e;
    L54:
        r13.markNextDropdownRewriteIfNeeded(r12, r8);
        Balloon r15 = this.e;
        if (r15 == null) goto L62;
        r15.v(r12, r5, r6);
        return;
    L62:
        return;
    L29:
        r12 = null;
        goto L30
    L22:
        r9 = null;
        goto L23
    L33:
        View r16 = this.d;
        if (r16 == null) goto L48;
        Context r17 = r16.getContext();
        if (r17 == null) goto L48;
    L38:
        if ((r17 instanceof Activity) == true) goto L39;
        if ((r17 instanceof ContextWrapper) == false) goto L43;
        r17 = ((ContextWrapper) r17).getBaseContext();
        goto L38
    L43:
        Activity r18 = null;
    L44:
        if (r18 == null) goto L48;
        Window r19 = r18.getWindow();
        if (r19 == null) goto L48;
        r12 = a(r19);
        goto L49
    L39:
        r18 = (Activity) r17;
    L48:
        r12 = null;
        goto L49
    }

    public final boolean i(CommonMenu r8, b r9) {
        if (this.e != null) goto L5;
        return false;
    L5:
        if (r9 != null) goto L9;
        r9 = b();
        if (r9 != null) goto L9;
        return false;
    L9:
        FragmentActivity r0 = this.a.getActivity();
        if (r0 == null) goto L56;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L56;
        View r2 = a(r1);
        if (r2 == null) goto L56;
        int r3 = r9.m;
        int r4 = r9.n;
        int r5 = r9.i + ((int) this.c.getClickX());
        int r6 = r3 / 2;
        int r7 = r9.e + r6;
        int r10 = r9.g - r6;
        if (r7 > r10) goto L19;
        int r11 = RangesKt.coerceIn(r5, r7, r10);
    L20:
        int r12 = (r11 - r9.a) - (r9.c / 2);
        int r13 = (r9.j + ((int) this.c.getClickY())) - (r4 / 2);
        int r14 = r9.f;
        int r15 = r9.h - r4;
        if (r14 > r15) goto L23;
        int r16 = RangesKt.coerceIn(r13, r14, r15);
    L24:
        int r17 = (r16 - r9.b) + r4;
        if (Build.VERSION.SDK_INT >= 26) goto L27;
        r8.measure(0, 0);
        r17 = Math.max(r8.getMeasuredHeight() + i5.l0(), r17);
    L27:
        View r18 = this.d;
        if (r18 == null) goto L38;
        ViewTreeObserver r19 = r18.getViewTreeObserver();
        if (r19 == null) goto L38;
        if (this.l == true) goto L38;
        if (r19.isAlive() == false) goto L38;
        r19.addOnScrollChangedListener(this.s);
        this.l = true;
    L38:
        if (this.m == true) goto L40;
    L42:
        f();
        ViewTreeObserver r20 = r2.getViewTreeObserver();
        if (r20.isAlive() == false) goto L45;
        r20.addOnGlobalLayoutListener(this.u);
        this.k = r2;
        this.m = true;
    L45:
        this.j = r9;
        this.o = 0;
        ObricMessagePopupServiceDelegate r21 = ObricMessagePopupServiceDelegate.b;
        Balloon r22 = this.e;
        if (r22 == null) goto L48;
        PopupWindow r23 = r22.e;
    L49:
        r21.markNextDropdownRewriteIfNeeded(r2, r23);
        Balloon r24 = this.e;
        if (r24 == null) goto L52;
        r24.v(r2, r12, r17);
    L52:
        Balloon r25 = this.e;
        if (r25 == null) goto L55;
        com.larus.bmhome.view.screenmenu.d r26 = com.larus.bmhome.view.screenmenu.d.a;
        RecyclerView r27 = this.b.m();
        Intrinsics.checkNotNullParameter(r27, "host");
        Intrinsics.checkNotNullParameter(r25, "balloon");
        com.larus.utils.l.c(r27, "ext_balloon_pop", new WeakReference(r25));
    L55:
        return true;
    L48:
        r23 = null;
        goto L49
    L40:
        if (Intrinsics.areEqual(this.k, r2) == false) goto L42;
    L23:
        r16 = (r14 + r15) / 2;
        goto L24
    L19:
        r11 = (r7 + r10) / 2;
    L56:
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [ef8.d] */
    /* JADX WARN: Type inference failed for: r2v8, types: [ef8.e] */
    /* JADX WARN: Type inference failed for: r2v9, types: [ef8.f] */
    public o(Fragment r2, b0 r3, st8.a r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        Intrinsics.checkNotNullParameter(r4, "menuAnchor");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        if ((r4 instanceof View) == false) goto L5;
        View r5 = (View) r4;
    L6:
        if (r5 != null) goto L8;
        r5 = r4.l5();
    L8:
        this.d = r5;
        this.f = new int[2];
        this.s = new d(this);
        this.t = new e(this);
        this.u = new f(this);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
