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
    void animateToVisibility(int r5);

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

    void restoreHierarchyState(SparseArray<Parcelable> r5);

    void saveHierarchyState(SparseArray<Parcelable> r5);

    void setBackgroundDrawable(Drawable r5);

    void setCollapsible(boolean r5);

    void setCustomView(View r5);

    void setDefaultNavigationContentDescription(int r5);

    void setDefaultNavigationIcon(Drawable r5);

    void setDisplayOptions(int r5);

    void setDropdownParams(SpinnerAdapter r5, AdapterView.OnItemSelectedListener r10);

    void setDropdownSelectedPosition(int r5);

    void setEmbeddedTabView(ScrollingTabContainerView r5);

    void setHomeButtonEnabled(boolean r5);

    void setIcon(int r5);

    void setIcon(Drawable r5);

    void setLogo(int r5);

    void setLogo(Drawable r5);

    void setMenu(Menu r5, MenuPresenter.Callback r10);

    void setMenuCallbacks(MenuPresenter.Callback r5, MenuBuilder.Callback r10);

    void setMenuPrepared();

    void setNavigationContentDescription(int r5);

    void setNavigationContentDescription(CharSequence r5);

    void setNavigationIcon(int r5);

    void setNavigationIcon(Drawable r5);

    void setNavigationMode(int r5);

    void setSubtitle(CharSequence r5);

    void setTitle(CharSequence r5);

    void setVisibility(int r5);

    void setWindowCallback(Window.Callback r5);

    void setWindowTitle(CharSequence r5);

    ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r5, long r10);

    boolean showOverflowMenu();
}
