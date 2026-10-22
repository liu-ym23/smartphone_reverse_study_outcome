package h18;

import android.content.Context;
import android.graphics.Point;
import android.util.Size;
import android.view.Display;
import android.view.WindowManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final Size a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Object r3 = r2.getSystemService("window");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.WindowManager");
        Display r4 = ((WindowManager) r3).getDefaultDisplay();
        Point r0 = new Point();
        r4.getSize(r0);
        return new Size(r0.x, r0.y);
    }
}
