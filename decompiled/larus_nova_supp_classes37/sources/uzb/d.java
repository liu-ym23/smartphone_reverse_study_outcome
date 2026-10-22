package uzb;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d extends e {
    public static final d b = null;

    static {
        b = new d();
    }

    public d() {
    }

    public static View c(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // uzb.e
    public final boolean b(Activity r2) {
        if (c(r2.getWindow()).isAttachedToWindow() == false) goto L5;
        WindowInsetsCompat r0 = ViewCompat.getRootWindowInsets(c(r2.getWindow()));
        if (r0 != null) goto L11;
        return super.b(r2);
    L11:
        if (r0.getSystemWindowInsetBottom() <= r0.getStableInsetBottom()) goto L13;
        return true;
    L13:
        return false;
    L5:
        return super.b(r2);
    }
}
