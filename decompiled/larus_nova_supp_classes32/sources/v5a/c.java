package v5a;

import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import n5a.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends Presentation {
    public final View.OnFocusChangeListener a;
    public final int b;
    public a c;
    public FrameLayout d;
    public final e e;
    public final boolean f;
    public final Context g;

    public static class a extends FrameLayout {
        public final View a;

        @Override // android.view.ViewGroup, android.view.ViewParent
        public final boolean requestSendAccessibilityEvent(View r1, AccessibilityEvent r2) {
            return false;
        }

        public a(Context r1, View r2) {
            super(r1);
            this.a = r2;
        }
    }

    public static class b extends ViewGroup {
        public final Rect a;
        public final Rect b;

        public b(Context r1) {
            super(r1);
            this.a = new Rect();
            this.b = new Rect();
        }

        @Override // android.view.View
        public final void onMeasure(int r6, int r7) {
            int r0 = 0;
        L4:
            if (r0 >= getChildCount()) goto L6;
            getChildAt(r0).measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r6), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r7), Integer.MIN_VALUE));
            r0 = r0 + 1;
            goto L4
        L6:
            super.onMeasure(r6, r7);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
            int r16 = 0;
        L4:
            if (r16 >= getChildCount()) goto L6;
            View r0 = getChildAt(r16);
            WindowManager.LayoutParams r1 = (WindowManager.LayoutParams) r0.getLayoutParams();
            this.a.set(r12, r13, r14, r15);
            Gravity.apply(r1.gravity, r0.getMeasuredWidth(), r0.getMeasuredHeight(), this.a, r1.x, r1.y, this.b);
            Rect r2 = this.b;
            r0.layout(r2.left, r2.top, r2.right, r2.bottom);
            r16 = r16 + 1;
            goto L4
        }
    }

    /* JADX INFO: renamed from: v5a.c$c, reason: collision with other inner class name */
    public static class C0117c extends ContextWrapper {
        public final InputMethodManager a;

        @Override // android.content.ContextWrapper, android.content.Context
        public final Context createDisplayContext(Display r3) {
            return new C0117c(super.createDisplayContext(r3), this.a);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final Object getSystemService(String r2) {
            if ("input_method".equals(r2) == false) goto L7;
            return this.a;
        L7:
            return super.getSystemService(r2);
        }

        public C0117c(Context r1, InputMethodManager r2) {
            super(r1);
            if (r2 != null) goto L6;
            r2 = (InputMethodManager) r1.getSystemService("input_method");
        L6:
            this.a = r2;
        }
    }

    public static class d extends ContextWrapper {
        public final f a;
        public WindowManager b;
        public final Context c;

        @Override // android.content.ContextWrapper, android.content.Context
        public final Object getSystemService(String r7) {
            if ("window".equals(r7) == false) goto L25;
            StackTraceElement[] r0 = ThreadMethodProxy.currentThread().getStackTrace();
            int r2 = 0;
        L6:
            if (r2 >= r0.length) goto L15;
            if (r2 >= 11) goto L15;
            if (r0[r2].getClassName().equals(AlertDialog.class.getCanonicalName()) == false) goto L14;
            if (r0[r2].getMethodName().equals("<init>") == false) goto L14;
            boolean r1 = true;
        L16:
            if (r1 == false) goto L20;
            return this.c.getSystemService(r7);
        L20:
            if (this.b != null) goto L23;
            f r8 = this.a;
            r8.getClass();
            this.b = (WindowManager) Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[]{WindowManager.class}, r8);
        L23:
            return this.b;
        L14:
            r2 = r2 + 1;
        L15:
            r1 = false;
            goto L16
        L25:
            return super.getSystemService(r7);
        }

        public d(Context r1, f r2, Context r3) {
            super(r1);
            this.a = r2;
            this.c = r3;
        }
    }

    public static class e {
        public v5a.a a;
        public f b;
        public b c;

        public e() {
        }
    }

    public static class f implements InvocationHandler {
        public final WindowManager a;
        public final b b;

        public f(WindowManager r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r6, Method r7, Object[] r8) throws Throwable {
            String r9 = r7.getName();
            r9.getClass();
            byte r3 = -1;
            switch(r9.hashCode()) {
                case -1148522778: goto L18;
                case 542766184: goto L14;
                case 931413976: goto L10;
                case 1098630473: goto L6;
                default: goto L22;
            };
        L6:
            if (r9.equals("removeView") == false) goto L22;
            r3 = 3;
            goto L22
        L10:
            if (r9.equals("updateViewLayout") == false) goto L22;
            r3 = 2;
            goto L22
        L14:
            if (r9.equals("removeViewImmediate") == false) goto L22;
            r3 = 1;
            goto L22
        L18:
            if (r9.equals("addView") == false) goto L22;
            r3 = 0;
        L22:
            switch(r3) {
                case 0: goto L43;
                case 1: goto L39;
                case 2: goto L33;
                case 3: goto L28;
                default: goto L48;
            };
        L28:
            b r10 = this.b;
            if (r10 != null) goto L31;
            c5a.c.d(5, "PlatformViewsController", "Embedded view called removeView while detached from presentation");
        L32:
            return null;
        L31:
            r10.removeView((View) r8[0]);
            goto L32
        L33:
            b r11 = this.b;
            if (r11 != null) goto L36;
            c5a.c.d(5, "PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
        L37:
            return null;
        L36:
            r11.updateViewLayout((View) r8[0], (WindowManager.LayoutParams) r8[1]);
            goto L37
        L43:
            b r12 = this.b;
            if (r12 != null) goto L46;
            c5a.c.d(5, "PlatformViewsController", "Embedded view called addView while detached from presentation");
        L47:
            return null;
        L46:
            r12.addView((View) r8[0], (WindowManager.LayoutParams) r8[1]);
            goto L47
        L48:
            return r7.invoke(this.a, r8);
        L25:
            e = move-exception;
            throw e.getCause();
        L39:
            if (this.b != null) goto L41;
            c5a.c.d(5, "PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
        L42:
            return null;
        L41:
            View r13 = (View) r8[0];
            r13.clearAnimation();
            this.b.removeView(r13);
            goto L42
        }
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        e r5 = this.e;
        if (r5.c != null) goto L6;
        r5.c = new b(getContext());
    L6:
        if (this.e.b != null) goto L8;
        WindowManager r6 = (WindowManager) getContext().getSystemService("window");
        e r0 = this.e;
        r0.b = new f(r6, r0.c);
    L8:
        this.d = new FrameLayout(getContext());
        d r7 = new d(getContext(), this.e.b, this.g);
        View r1 = ((o.a) this.e.a).a;
        if ((r1.getContext() instanceof MutableContextWrapper) == false) goto L11;
        ((MutableContextWrapper) r1.getContext()).setBaseContext(r7);
    L12:
        this.d.addView(r1);
        a r8 = new a(getContext(), r1);
        this.c = r8;
        r8.addView(this.d);
        this.c.addView(this.e.c);
        r1.setOnFocusChangeListener(this.a);
        this.c.setFocusableInTouchMode(true);
        if (this.f == false) goto L15;
        r1.requestFocus();
    L16:
        setContentView(this.c);
        return;
    L15:
        this.c.requestFocus();
        goto L16
    L11:
        c5a.c.d(5, "PlatformViewsController", "Unexpected platform view context for view ID " + this.b + "; some functionality may not work correctly. When constructing a platform view in the factory, ensure that the view returned from PlatformViewFactory#create returns the provided context from getContext(). If you are unable to associate the view with that context, consider using Hybrid Composition instead.");
        goto L12
    }

    public c(Context r3, Display r4, o.a r5, int r6, o.b r7) {
        super(new C0117c(r3, null), r4);
        this.f = false;
        this.b = r6;
        this.a = r7;
        this.g = r3;
        e r8 = new e();
        this.e = r8;
        r8.a = r5;
        getWindow().setFlags(8, 8);
        getWindow().setType(2030);
    }

    public c(Context r3, Display r4, e r5, View.OnFocusChangeListener r6, boolean r7) {
        super(new C0117c(r3, null), r4);
        this.f = false;
        this.e = r5;
        this.a = r6;
        this.g = r3;
        getWindow().setFlags(8, 8);
        this.f = r7;
    }
}
