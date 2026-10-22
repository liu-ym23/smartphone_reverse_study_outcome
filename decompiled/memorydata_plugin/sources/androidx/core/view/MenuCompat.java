package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.internal.view.SupportMenu;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class MenuCompat {

    static class Api28Impl {
        private Api28Impl() {
        }

        static void setGroupDividerEnabled(Menu r2, boolean r3) {
            ((Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.memorydata.plugin")).setGroupDividerEnabled(r3);
        }
    }

    private MenuCompat() {
    }

    public static void setGroupDividerEnabled(Menu r2, boolean r3) {
        Menu r4 = (Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SupportMenu.class) == false) goto L6;
        ((SupportMenu) ZeusTransformUtils.preCheckCast(r4, SupportMenu.class, "com.obric.memorydata.plugin")).setGroupDividerEnabled(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L10;
        Api28Impl.setGroupDividerEnabled(r4, r3);
        return;
    }

    @Deprecated
    public static void setShowAsAction(MenuItem r2, int r3) {
        ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.memorydata.plugin")).setShowAsAction(r3);
    }
}
