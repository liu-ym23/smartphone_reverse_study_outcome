package up9;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class w implements y {
    public w() {
    }

    @Override // up9.y
    public void o(FragmentActivity r1, Configuration r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
    }

    @Override // up9.y
    public void a(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "designBottomSheet");
        w0.e(r2, i5.r0());
    }

    public static void p(Dialog r1, float r2) {
        if (r1 == null) goto L7;
        Window r3 = r1.getWindow();
        if (r3 == null) goto L8;
        r3.setDimAmount(r2 * 1.0f);
        return;
    L8:
        return;
    }

    public static void q(Dialog r4, float r5) {
        boolean r0 = v19.h.a;
        if (v19.h.a(null) == false) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L8;
        return;
    L8:
        if (r5 >= 0.8d) goto L10;
        boolean r6 = true;
    L11:
        if (r4 == null) goto L27;
        Window r7 = r4.getWindow();
        if (r7 == null) goto L28;
        View r8 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L19;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L19;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L19:
        if (r8 == null) goto L29;
        int r2 = r8.getSystemUiVisibility();
        if (r6 == false) goto L23;
        int r9 = r2 | 8192;
    L24:
        r8.setSystemUiVisibility(r9);
        return;
    L23:
        r9 = r2 & (-8193);
        goto L24
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L10:
        r6 = false;
        goto L11
    }
}
