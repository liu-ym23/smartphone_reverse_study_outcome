package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface MenuProvider {
    void onCreateMenu(Menu r1, MenuInflater r2);

    default void onMenuClosed(Menu r2) {
        Menu r1 = (Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.memorydata.plugin");
    }

    boolean onMenuItemSelected(MenuItem r1);

    default void onPrepareMenu(Menu r2) {
        Menu r1 = (Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.memorydata.plugin");
    }
}
