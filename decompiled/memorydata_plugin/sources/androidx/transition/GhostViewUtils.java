package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
class GhostViewUtils {
    private GhostViewUtils() {
    }

    static GhostView addGhost(View r2, ViewGroup r3, Matrix r4) {
        if (Build.VERSION.SDK_INT != 28) goto L7;
        return GhostViewPlatform.addGhost(r2, r3, r4);
    L7:
        return GhostViewPort.addGhost(r2, r3, r4);
    }

    static void removeGhost(View r2) {
        if (Build.VERSION.SDK_INT != 28) goto L5;
        GhostViewPlatform.removeGhost(r2);
        return;
    L5:
        GhostViewPort.removeGhost(r2);
    }
}
