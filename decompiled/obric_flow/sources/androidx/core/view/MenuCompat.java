package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: loaded from: classes.dex */
public final class MenuCompat {

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static void setGroupDividerEnabled(Menu r5, boolean r10) {
            r5.setGroupDividerEnabled(r10);
        }
    }

    private MenuCompat() {
    }

    public static void setGroupDividerEnabled(@NonNull Menu r5, boolean r10) {
        if ((r5 instanceof SupportMenu) == false) goto L5;
        ((SupportMenu) r5).setGroupDividerEnabled(r10);
        return;
    L5:
        Api28Impl.setGroupDividerEnabled(r5, r10);
    }

    @Deprecated
    public static void setShowAsAction(MenuItem r5, int r10) {
        r5.setShowAsAction(r10);
    }
}
