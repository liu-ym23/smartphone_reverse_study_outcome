package o82;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static final ValueAnimator e = null;
    public static int f;
    public static int g;
    public static int h;

    public f() {
    }

    static {
        e = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(160);
    }

    public static final boolean a(Window r3) {
        if (r3 == null) goto L21;
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L8;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L8;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L8:
        if (r4 == null) goto L21;
        if (r4.getWindowToken() == null) goto L21;
        Context r5 = r4.getContext();
        if ((r5 instanceof ContextThemeWrapper) == false) goto L18;
        Context r6 = ((ContextThemeWrapper) r5).getBaseContext();
        if ((r6 instanceof Activity) == false) goto L23;
        boolean r7 = ((Activity) r6).isFinishing();
    L25:
        return true ^ r7;
    L23:
        return true;
    L18:
        if ((r5 instanceof Activity) == false) goto L24;
        r7 = ((Activity) r5).isFinishing();
        goto L25
    L24:
        return true;
    L21:
        return false;
    }
}
