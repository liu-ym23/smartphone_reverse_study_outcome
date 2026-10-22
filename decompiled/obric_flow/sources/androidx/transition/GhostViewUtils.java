package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class GhostViewUtils {
    private GhostViewUtils() {
    }

    @Nullable
    public static GhostView addGhost(@NonNull View r5, @NonNull ViewGroup r10, @Nullable Matrix r11) {
        return GhostViewPort.addGhost(r5, r10, r11);
    }

    public static void removeGhost(View r5) {
        GhostViewPort.removeGhost(r5);
    }
}
