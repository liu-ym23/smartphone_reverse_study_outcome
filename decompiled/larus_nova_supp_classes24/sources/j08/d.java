package j08;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public static c c(Context r2) {
        Display r3 = ((WindowManager) r2.getSystemService("window")).getDefaultDisplay();
        Point r0 = new Point();
        r3.getSize(r0);
        return new c(r0.x, r0.y);
    }

    public static float a(Context r1, float r2) {
        Resources r3 = r1.getResources();
        return TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
    }

    public static Drawable b(Context r0, int r1) {
        if (r1 != 0) goto L5;
        return null;
    L5:
        return r0.getResources().getDrawable(r1);
    }
}
