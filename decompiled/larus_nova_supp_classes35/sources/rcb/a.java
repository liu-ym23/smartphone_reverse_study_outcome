package rcb;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static int a;

    static {
        a = -1;
    }

    @JvmStatic
    public static final int a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Object r2 = r1.getSystemService("window");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.WindowManager");
        Display r3 = ((WindowManager) r2).getDefaultDisplay();
        DisplayMetrics r0 = new DisplayMetrics();
        r3.getRealMetrics(r0);
        return r0.heightPixels;
    }
}
