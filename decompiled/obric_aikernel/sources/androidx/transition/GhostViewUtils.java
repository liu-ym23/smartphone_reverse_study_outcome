package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class GhostViewUtils {
    private GhostViewUtils() {
    }

    @Nullable
    static GhostView addGhost(@NonNull View r10, @NonNull ViewGroup r11, @Nullable Matrix r12) {
        if (Build.VERSION.SDK_INT != 28) goto L7;
        return GhostViewPlatform.addGhost(r10, r11, r12);
    L7:
        return GhostViewPort.addGhost(r10, r11, r12);
    }

    static void removeGhost(View r10) {
        if (Build.VERSION.SDK_INT != 28) goto L5;
        GhostViewPlatform.removeGhost(r10);
        return;
    L5:
        GhostViewPort.removeGhost(r10);
    }
}
