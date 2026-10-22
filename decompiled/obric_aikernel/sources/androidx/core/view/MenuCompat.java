package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: loaded from: classes.dex */
public final class MenuCompat {

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static void setGroupDividerEnabled(Menu r10, boolean r11) {
            r10.setGroupDividerEnabled(r11);
        }
    }

    private MenuCompat() {
    }

    public static void setGroupDividerEnabled(@NonNull Menu r10, boolean r11) {
        if ((r10 instanceof SupportMenu) == false) goto L6;
        ((SupportMenu) r10).setGroupDividerEnabled(r11);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L10;
        Api28Impl.setGroupDividerEnabled(r10, r11);
        return;
    }

    @Deprecated
    public static void setShowAsAction(MenuItem r10, int r11) {
        r10.setShowAsAction(r11);
    }
}
