package l0;

import android.graphics.Path;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static PathInterpolator a(float r8, float r10) {
        return new PathInterpolator(r8, r10);
    }

    public static PathInterpolator b(float r8, float r10, float r11, float r12) {
        return new PathInterpolator(r8, r10, r11, r12);
    }

    public static PathInterpolator c(Path r8) {
        return new PathInterpolator(r8);
    }
}
