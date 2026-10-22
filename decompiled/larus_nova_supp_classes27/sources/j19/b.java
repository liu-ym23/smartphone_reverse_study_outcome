package j19;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final Context a;
    public final k19.e b;
    public final int c;
    public float d;

    public final float a() {
        float r0 = 1 - (this.b.f / this.c);
        if (r0 <= 1.0f) goto L6;
        return 1.0f;
    L6:
        if (r0 >= 0.3f) goto L8;
        return 0.3f;
    L8:
        return r0;
    }

    public final Context getContext() {
        return this.a;
    }

    public b(Context r6, k19.e r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "detector");
        this.a = r6;
        this.b = r7;
        Resources r8 = r6.getResources();
        int r0 = 0;
        if (r8 == null) goto L7;
        DisplayMetrics r9 = WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics());
        if (r9 == null) goto L7;
        int r10 = r9.heightPixels;
    L8:
        int r1 = r6.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r1 <= 0) goto L11;
        r0 = r6.getResources().getDimensionPixelSize(r1);
    L11:
        this.c = (r10 + r0) / 2;
        this.d = 0.4f;
        return;
    L7:
        r10 = 0;
        goto L8
    }
}
