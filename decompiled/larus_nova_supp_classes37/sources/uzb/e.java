package uzb;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class e {
    public static final e a = null;

    public e() {
    }

    static {
        a = new e();
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

    public boolean b(Activity r3) {
        int r0 = a(r3.getWindow()).getHeight();
        Rect r1 = new Rect();
        a(r3.getWindow()).getWindowVisibleDisplayFrame(r1);
        if ((r0 - r1.bottom) < 400) goto L5;
        return true;
    L5:
        return false;
    }
}
