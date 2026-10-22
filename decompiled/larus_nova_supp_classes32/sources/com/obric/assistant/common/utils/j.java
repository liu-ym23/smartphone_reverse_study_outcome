package com.obric.assistant.common.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(ConstraintLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        WindowInsetsCompat r4 = ViewCompat.getRootWindowInsets(r3);
        if (r4 == null) goto L5;
        Insets r5 = r4.getInsets(WindowInsetsCompat.Type.navigationBars());
    L6:
        if (r5 == null) goto L8;
        int r6 = r5.bottom;
    L9:
        FLogger.a.d("ObricNavigationBarUtils", "getNavigationBarHeightPx() navBarHeight=" + r6);
        return r6;
    L8:
        r6 = 0;
        goto L9
    L5:
        r5 = null;
        goto L6
    }
}
