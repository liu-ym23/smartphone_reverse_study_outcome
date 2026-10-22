package xfb;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public static g e;
    public WeakReference<View> a;
    public WindowManager b;
    public final Application c;
    public final Handler d;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Log.i("ScreenSizeManager", "initView");
        View r0 = new View(this.c);
        this.b = (WindowManager) this.c.getSystemService("window");
        if (Build.VERSION.SDK_INT < 26) goto L5;
        int r2 = 2038;
    L6:
        WindowManager.LayoutParams r3 = new WindowManager.LayoutParams(r2, 568, -2);
        r3.alpha = 0.0f;
        WindowManager r4 = this.b;     // Catch: Exception -> L12
        if (r4 == null) goto L10;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r0, r3);     // Catch: Exception -> L12
        r4.addView(r0, r3);     // Catch: Exception -> L12
    L10:
        this.a = new WeakReference(r0);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Log.e("ScreenSizeManager", "permission denied: " + e.getMessage(), e, true);
        return;
    L5:
        r2 = 2002;
        goto L6
    }

    public g() {
        this.c = LarkContext.getApplication();
        this.d = new Handler(Looper.getMainLooper());
    }
}
