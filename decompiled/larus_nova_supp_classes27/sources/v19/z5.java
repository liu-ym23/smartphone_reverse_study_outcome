package v19;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.larus.utils.w0;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z5 {
    public static boolean a;

    public static final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ b b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            View r4 = this.a;
            b r0 = this.b;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
            if (r4.getViewTreeObserver().isAlive() == false) goto L6;
            r4.getViewTreeObserver().removeOnGlobalLayoutListener(r0);     // Catch: Throwable -> L8
        L6:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        public a(View r1, b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ Lifecycle a;
        public final /* synthetic */ View b;
        public final /* synthetic */ View c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ Ref.ObjectRef<Boolean> e;
        public final /* synthetic */ Function1<Boolean, Unit> f;
        public final /* synthetic */ Function2<Insets, Boolean, Unit> g;
        public final /* synthetic */ Function1<Boolean, Unit> h;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            Lifecycle r0 = this.a;
            FragmentActivity r1 = null;
            if (r0 == null) goto L5;
            Lifecycle.State r2 = r0.getCurrentState();
        L7:
            if (r2 == Lifecycle.State.DESTROYED) goto L9;
            boolean r3 = z5.a;
            View r4 = this.c;
            Rect r5 = new Rect();
            if (z5.c(r4, r5) == true) goto L16;
            r5 = null;
        L16:
            if (r5 != null) goto L18;
            return;
        L18:
            int r6 = w0.a;
            int r7 = w0.c(this.d);
            int r8 = RangesKt.coerceAtLeast(r7 - r5.bottom, 0);
            int r9 = r5.bottom;
            Activity r10 = this.d;
            if ((r10 instanceof FragmentActivity) == false) goto L21;
            r1 = (FragmentActivity) r10;
        L21:
            int r11 = (r7 - r9) - u.b(r1);
            if (r11 >= 150) goto L24;
            r11 = 0;
        L24:
            if (r11 <= 0) goto L26;
            boolean r12 = true;
        L27:
            Insets r13 = Insets.of(0, 0, 0, r8);
            if (this.e.element != null) goto L30;
        L34:
            Function2<Insets, Boolean, Unit> r14 = this.g;
            if (r14 == null) goto L38;
            r14.invoke(r13, Boolean.valueOf(r12));
        L38:
            if (this.e.element != null) goto L40;
        L44:
            this.e.element = Boolean.valueOf(r12);
            return;
        L40:
            if (Intrinsics.areEqual(Boolean.valueOf(r12), this.e.element) == true) goto L44;
            Function1<Boolean, Unit> r15 = this.h;
            if (r15 == null) goto L44;
            r15.invoke(Boolean.valueOf(r12));
            goto L44
        L30:
            if (Intrinsics.areEqual(Boolean.valueOf(r12), this.e.element) == true) goto L34;
            Function1<Boolean, Unit> r16 = this.f;
            if (r16 == null) goto L34;
            r16.invoke(Boolean.valueOf(r12));
            goto L34
        L26:
            r12 = false;
            goto L27
        L9:
            if (this.b.getViewTreeObserver().isAlive() == false) goto L46;
            this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        L46:
            return;
        L5:
            r2 = null;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Lifecycle r1, View r2, View r3, Activity r4, Ref.ObjectRef<Boolean> r5, Function1<? super Boolean, Unit> r6, Function2<? super Insets, ? super Boolean, Unit> r7, Function1<? super Boolean, Unit> r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }
    }

    static {
    }

    public static boolean d() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
    L7:
        return false;
    L5:
        if (z2.a.getBasicExperienceBugFixConfig().c == false) goto L7;
        return true;
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static boolean b(View r1) {
        WindowInsetsCompat r2 = ViewCompat.getRootWindowInsets(r1);
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.isVisible(WindowInsetsCompat.Type.ime());
    }

    public static boolean c(View r2, Rect r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "rect");
        r2.getWindowVisibleDisplayFrame(r3);     // Catch: SecurityException -> L5
        return true;
    L5:
        e = move-exception;
        if (a == true) goto L9;
        a = true;
        FLogger.a.e("LowVersionImeInsetsCompat", "getWindowVisibleDisplayFrame failed", e);
    L9:
        return false;
    }

    public static void e(View r12, Function1 r13, Function2 r14, Function1 r15) {
        Intrinsics.checkNotNullParameter(r12, "view");
        Context r0 = r12.getContext();
    L3:
        boolean r1 = r0 instanceof Activity;
        if (r1 == true) goto L8;
        if ((r0 instanceof ContextWrapper) == false) goto L8;
        r0 = ((ContextWrapper) r0).getBaseContext();
    L8:
        Lifecycle r2 = null;
        if (r1 == false) goto L11;
        Activity r7 = (Activity) r0;
    L12:
        if (r7 != null) goto L14;
        return;
    L14:
        Window r3 = r7.getWindow();
        if (r3 == null) goto L29;
        View r6 = a(r3);
        if (r6 == null) goto L30;
        View r4 = r7.findViewById(R.id.content);
        if (r4 != null) goto L22;
        r4 = r6;
    L22:
        LifecycleOwner r5 = ViewTreeLifecycleOwner.get(r12);
        if (r5 == null) goto L25;
        r2 = r5.getLifecycle();
    L25:
        b r8 = new b(r2, r4, r6, r7, new Ref.ObjectRef(), r13, r14, r15);
        r4.getViewTreeObserver().addOnGlobalLayoutListener(r8);
        r12.addOnAttachStateChangeListener(new a(r4, r8));
        return;
    L30:
        return;
    L29:
        return;
    L11:
        r7 = null;
        goto L12
    }
}
