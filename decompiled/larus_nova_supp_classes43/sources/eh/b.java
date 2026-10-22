package eh;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static View a(Window r10) {
        View r11 = r10.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    public static int b(Context r10) {
        int r0 = r10.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return r10.getResources().getDimensionPixelSize(r0);
    }

    public static void c(Activity r10) {
        Window r11 = r10.getWindow();
        r11.clearFlags(201326592);
        int r0 = (a(r11).getSystemUiVisibility() | 1024) | 256;
        a(r11).setSystemUiVisibility(r0);
        r11.addFlags(Integer.MIN_VALUE);
        r11.setStatusBarColor(0);
    }
}
