package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ListViewCompat {
    private ListViewCompat() {
    }

    @Deprecated
    public static boolean canScrollList(@NonNull ListView r5, int r10) {
        return r5.canScrollList(r10);
    }

    @Deprecated
    public static void scrollListBy(@NonNull ListView r5, int r10) {
        r5.scrollListBy(r10);
    }
}
