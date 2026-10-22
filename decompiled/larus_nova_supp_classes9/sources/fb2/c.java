package fb2;

import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static float a;
    public static float b;

    public static float a(float r3, boolean r4) {
        if (r4 == true) goto L4;
        return r3;
    L4:
        if (b != 0.0f) goto L6;
        b = (int) ((23.0f * s1.u()) + 0.5f);
    L6:
        float r5 = b;
        if (a != 0.0f) goto L10;
        a = (int) ((16.0f * s1.u()) + 0.5f);
    L10:
        return r5 + (r3 - a);
    }

    public static float b(float r2, Drawable r3, boolean r4) {
        return (r3.getIntrinsicWidth() / (r3.getIntrinsicHeight() + 0.0f)) * a(r2, r4);
    }
}
