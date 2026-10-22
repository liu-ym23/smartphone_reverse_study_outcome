package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static EdgeEffect a(Context r8, AttributeSet r10) {
        return new EdgeEffect(r8, r10);
    L5:
        return new EdgeEffect(r8);
    }

    public static float b(EdgeEffect r8) {
        return r8.getDistance();
    L4:
        return 0.0f;
    }

    public static float c(EdgeEffect r8, float r10, float r11) {
        return r8.onPullDistance(r10, r11);
    L4:
        r8.onPull(r10, r11);
        return 0.0f;
    }
}
