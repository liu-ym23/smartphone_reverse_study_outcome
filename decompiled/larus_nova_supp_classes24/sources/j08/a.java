package j08;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.graphics.ColorUtils;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final Window a;
    public int b;

    public final void a() {
        int r0 = Build.VERSION.SDK_INT;
        Window r1 = this.a;
        if (r0 < 28) goto L5;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.layoutInDisplayCutoutMode = 1;
        r1.setAttributes(r2);
    L5:
        Window r3 = this.a;
        r3.clearFlags(67108864);
        r3.addFlags(LKBaseResponseModel.DEFAULT_ERROR_CODE);
        r3.setStatusBarColor(ColorUtils.blendARGB(this.b, -16777216, 0.0f));
        r3.setNavigationBarColor(ColorUtils.blendARGB(this.b, -16777216, 0.0f));
        if (r0 < 23) goto L8;
        int r4 = 9472;
    L9:
        int r5 = (r4 | 0) | 4096;
        View r6 = this.a.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L14;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r7 = ThreadMethodProxy.currentThread();
        if (r7 == com.larus.home.impl.utils.c.a) goto L14;
        com.larus.home.impl.utils.c.a(r7, "getDecorView");
    L14:
        r6.setSystemUiVisibility(r5);
        return;
    L8:
        r4 = 1280;
        goto L9
    }

    public a(Window r2) {
        this.b = 0;
        this.a = r2;
    }
}
