package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.Window;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuPresenter;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface DecorContentParent {
    boolean canShowOverflowMenu();

    void dismissPopups();

    CharSequence getTitle();

    boolean hasIcon();

    boolean hasLogo();

    boolean hideOverflowMenu();

    void initFeature(int r5);

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    void restoreToolbarHierarchyState(SparseArray<Parcelable> r5);

    void saveToolbarHierarchyState(SparseArray<Parcelable> r5);

    void setIcon(int r5);

    void setIcon(Drawable r5);

    void setLogo(int r5);

    void setMenu(Menu r5, MenuPresenter.Callback r10);

    void setMenuPrepared();

    void setUiOptions(int r5);

    void setWindowCallback(Window.Callback r5);

    void setWindowTitle(CharSequence r5);

    boolean showOverflowMenu();
}
