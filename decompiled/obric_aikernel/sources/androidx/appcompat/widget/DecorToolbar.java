package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface DecorToolbar {
    void animateToVisibility(int r10);

    boolean canShowOverflowMenu();

    void collapseActionView();

    void dismissPopupMenus();

    Context getContext();

    View getCustomView();

    int getDisplayOptions();

    int getDropdownItemCount();

    int getDropdownSelectedPosition();

    int getHeight();

    Menu getMenu();

    int getNavigationMode();

    CharSequence getSubtitle();

    CharSequence getTitle();

    ViewGroup getViewGroup();

    int getVisibility();

    boolean hasEmbeddedTabs();

    boolean hasExpandedActionView();

    boolean hasIcon();

    boolean hasLogo();

    boolean hideOverflowMenu();

    void initIndeterminateProgress();

    void initProgress();

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    boolean isTitleTruncated();

    void restoreHierarchyState(SparseArray<Parcelable> r10);

    void saveHierarchyState(SparseArray<Parcelable> r10);

    void setBackgroundDrawable(Drawable r10);

    void setCollapsible(boolean r10);

    void setCustomView(View r10);

    void setDefaultNavigationContentDescription(int r10);

    void setDefaultNavigationIcon(Drawable r10);

    void setDisplayOptions(int r10);

    void setDropdownParams(SpinnerAdapter r10, AdapterView.OnItemSelectedListener r11);

    void setDropdownSelectedPosition(int r10);

    void setEmbeddedTabView(ScrollingTabContainerView r10);

    void setHomeButtonEnabled(boolean r10);

    void setIcon(int r10);

    void setIcon(Drawable r10);

    void setLogo(int r10);

    void setLogo(Drawable r10);

    void setMenu(Menu r10, MenuPresenter.Callback r11);

    void setMenuCallbacks(MenuPresenter.Callback r10, MenuBuilder.Callback r11);

    void setMenuPrepared();

    void setNavigationContentDescription(int r10);

    void setNavigationContentDescription(CharSequence r10);

    void setNavigationIcon(int r10);

    void setNavigationIcon(Drawable r10);

    void setNavigationMode(int r10);

    void setSubtitle(CharSequence r10);

    void setTitle(CharSequence r10);

    void setVisibility(int r10);

    void setWindowCallback(Window.Callback r10);

    void setWindowTitle(CharSequence r10);

    ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r10, long r11);

    boolean showOverflowMenu();
}
