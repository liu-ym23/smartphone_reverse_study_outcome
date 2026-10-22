package xfb;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.ss.android.lark.utils.i0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Object r0 = r2.getSystemService("window");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r1 = (WindowManager) r0;
        if (i0.a(r2) == true) goto L5;
    L7:
        DisplayMetrics r3 = new DisplayMetrics();
        r1.getDefaultDisplay().getRealMetrics(r3);
        return r3.heightPixels;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L7;
        Display r4 = r1.getDefaultDisplay();
        return RangesKt.coerceAtMost(r4.getMode().getPhysicalHeight(), r4.getMode().getPhysicalWidth());
    }

    public static int b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Object r0 = r2.getSystemService("window");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r1 = (WindowManager) r0;
        if (i0.a(r2) == true) goto L5;
    L7:
        DisplayMetrics r3 = new DisplayMetrics();
        r1.getDefaultDisplay().getMetrics(r3);
        return r3.widthPixels;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L7;
        Display r4 = r1.getDefaultDisplay();
        return RangesKt.coerceAtLeast(r4.getMode().getPhysicalWidth(), r4.getMode().getPhysicalHeight());
    }

    public static Rect c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Rect r0 = new Rect();
        r0.left = 0;
        r0.top = 0;
        r0.right = b(r2);
        r0.bottom = a(r2) - e.a(r2);
        return r0;
    }
}
