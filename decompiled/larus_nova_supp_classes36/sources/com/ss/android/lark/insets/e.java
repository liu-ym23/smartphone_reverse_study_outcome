package com.ss.android.lark.insets;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.WindowInsetsCompat;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.image.api.Target;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends h {
    public static final Map<Integer, WeakReference<j>> r = null;

    public static final class a {
        public static void a(Window r4) {
            View r0 = r4.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L7;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r1 = ThreadMethodProxy.currentThread();
            if (r1 == com.larus.home.impl.utils.c.a) goto L7;
            com.larus.home.impl.utils.c.a(r1, "getDecorView");
        L7:
            r0.setSystemUiVisibility(1280);
            r4.addFlags(Target.SIZE_ORIGINAL);
            r4.setStatusBarColor(0);
            r4.addFlags(-2147483392);
            WindowManager.LayoutParams r2 = r4.getAttributes();
            if (r2 == null) goto L18;
            int r3 = Build.VERSION.SDK_INT;
            if (r3 < 28) goto L15;
            WindowManager.LayoutParams r5 = r4.getAttributes();
            if (r5 == null) goto L15;
            r5.layoutInDisplayCutoutMode = 1;
        L15:
            if (r3 < 30) goto L19;
            r2.setFitInsetsTypes(r2.getFitInsetsTypes() & (~WindowInsetsCompat.Type.systemBars()));
            return;
        L19:
            return;
        }
    }

    static {
        r = new LinkedHashMap();
    }
}
