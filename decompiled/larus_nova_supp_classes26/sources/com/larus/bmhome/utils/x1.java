package com.larus.bmhome.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x1 {
    public static final Set<String> d = null;
    public final EditText a;
    public Function0<Boolean> b;
    public final Lazy c;

    public static final class a {
    }

    static {
        d = SetsKt.setOf("REDMI_M2012K11AC");
    }

    public final boolean b() {
        WindowInsetsCompat r0 = ViewCompat.getRootWindowInsets(this.a);
        if (r0 == null) goto L5;
        boolean r1 = r0.isVisible(WindowInsetsCompat.Type.ime());
    L6:
        if (r1 == true) goto L12;
        Function0<Boolean> r2 = this.b;
        if (r2 == null) goto L10;
        boolean r3 = ((Boolean) r2.invoke()).booleanValue();
    L11:
        if (r3 == true) goto L12;
        return false;
    L10:
        r3 = false;
    L12:
        return true;
    L5:
        r1 = false;
        goto L6
    }

    public x1(EditText r2) {
        Intrinsics.checkNotNullParameter(r2, "targetView");
        this.a = r2;
        this.c = LazyKt.lazy(new r1());
    }

    public final void a(boolean r5) {
        boolean r0 = b();
        FLogger.a.d("ImeManager", "hideIme(), isShowing:" + r0);
        if (r0 == true) goto L6;
        if (r5 == true) goto L6;
        return;
    L6:
        Context r6 = this.a.getContext();
    L7:
        boolean r1 = r6 instanceof Activity;
        if (r1 == true) goto L12;
        if ((r6 instanceof ContextWrapper) == false) goto L12;
        r6 = ((ContextWrapper) r6).getBaseContext();
    L12:
        InputMethodManager r2 = null;
        if (r1 == false) goto L15;
        Activity r7 = (Activity) r6;
    L16:
        if (r7 == null) goto L18;
        Window r8 = r7.getWindow();
    L19:
        if (r8 == null) goto L39;
        Context r9 = this.a.getContext();
        if ((r9 instanceof Activity) == false) goto L23;
        Activity r10 = (Activity) r9;
    L24:
        if (r10 == null) goto L33;
        View r3 = r10.getCurrentFocus();
        if (r3 == null) goto L33;
        Object r11 = r10.getSystemService("input_method");
        if ((r11 instanceof InputMethodManager) == false) goto L31;
        r2 = (InputMethodManager) r11;
    L31:
        if (r2 == null) goto L33;
        r2.hideSoftInputFromWindow(r3.getWindowToken(), 0);
    L33:
        WindowInsetsControllerCompat r12 = ViewCompat.getWindowInsetsController(this.a);
        if (r12 == null) goto L40;
        r12.hide(WindowInsetsCompat.Type.ime());
        return;
    L40:
        return;
    L23:
        r10 = null;
        goto L24
    L39:
        return;
    L18:
        r8 = null;
        goto L19
    L15:
        r7 = null;
        goto L16
    }

    public static /* synthetic */ void d(x1 r1, int r2) {
        if ((r2 & 2) == 0) goto L5;
        boolean r3 = true;
    L6:
        r1.c(null, r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.bmhome.utils.s1] */
    public final void c(final Function0<Unit> r17, final boolean r18) {
        final ?? r6 = new s1(this, r18, r17);
        FLogger.a.d("ImeManager", "innerTrickShowIme()");
        final float r3 = this.a.getWidth();
        final float r4 = this.a.getHeight();
        final long r1 = SystemClock.uptimeMillis();
        if (b() == true) goto L7;
        final MotionEvent r0 = MotionEvent.obtain(r1, SystemClock.uptimeMillis(), 0, r3, r4, 0);
        com.larus.utils.l0.b(new t1(this, r0));
        this.a.post(new u1(r1, r3, r4, this, r6));
        return;
    }
}
