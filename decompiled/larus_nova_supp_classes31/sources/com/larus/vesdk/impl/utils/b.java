package com.larus.vesdk.impl.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final Activity a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public b(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        this.b = LazyKt.lazy(new com.larus.vesdk.impl.utils.a(this));
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

    public final void b(boolean r4) {
        Window r0 = this.a.getWindow();
        WindowManager.LayoutParams r1 = r0.getAttributes();
        if (r4 == false) goto L5;
        float r2 = 1.0f;
    L6:
        r1.screenBrightness = r2;
        r0.setAttributes(r1);
        if (r4 == false) goto L15;
        ViewParent r5 = ((View) this.b.getValue()).getParent();
        if ((r5 instanceof ViewGroup) == false) goto L11;
        ViewGroup r6 = (ViewGroup) r5;
    L12:
        if (r6 == null) goto L14;
        r6.removeView((View) this.b.getValue());
    L14:
        View r7 = a(this.a.getWindow());
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r7).addView((View) this.b.getValue());
        return;
    L11:
        r6 = null;
        goto L12
    L15:
        View r8 = a(this.a.getWindow());
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r8).removeView((View) this.b.getValue());
        return;
    L5:
        r2 = -1.0f;
        goto L6
    }
}
