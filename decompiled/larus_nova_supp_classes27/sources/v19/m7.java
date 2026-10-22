package v19;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m7 {
    public static final void a(Window r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        View r0 = r4.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == c.a) goto L7;
        c.a(r1, "getDecorView");
    L7:
        WindowCompat.setDecorFitsSystemWindows(r4, false);
        r4.clearFlags(134217728);
        r4.addFlags(Integer.MIN_VALUE);
        r4.setNavigationBarColor(0);
        int r2 = Build.VERSION.SDK_INT;
        if (r2 < 28) goto L11;
        r4.setNavigationBarDividerColor(0);
    L11:
        if (r2 < 29) goto L13;
        r4.setNavigationBarContrastEnforced(false);
    L13:
        r0.setSystemUiVisibility((r0.getSystemUiVisibility() | 512) | 256);
        View r5 = r0.findViewById(2131367728);
        if (r5 != null) goto L16;
        return;
    L16:
        ViewCompat.setOnApplyWindowInsetsListener(r5, new l7());
        ViewCompat.requestApplyInsets(r5);
    }
}
