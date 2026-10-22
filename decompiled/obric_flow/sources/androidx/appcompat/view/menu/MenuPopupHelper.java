package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuPopupHelper implements MenuHelper {
    private static final int TOUCH_EPICENTER_SIZE_DP = 48;
    private View mAnchorView;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    private final PopupWindow.OnDismissListener mInternalOnDismissListener;
    private final MenuBuilder mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private MenuPopup mPopup;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;

    @RequiresApi(17)
    public static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        public static void getRealSize(Display r5, Point r10) {
            r5.getRealSize(r10);
        }
    }

    public MenuPopupHelper(@NonNull Context r10, @NonNull MenuBuilder r11) {
        this(r10, r11, null, false, R.attr.popupMenuStyle, 0);
    }

    @NonNull
    private MenuPopup createPopup() {
        Display r5 = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        Point r10 = new Point();
        Api17Impl.getRealSize(r5, r10);
        if (Math.min(r10.x, r10.y) < this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) goto L5;
        MenuPopup r11 = new CascadingMenuPopup(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
    L6:
        r11.addMenu(this.mMenu);
        r11.setOnDismissListener(this.mInternalOnDismissListener);
        r11.setAnchorView(this.mAnchorView);
        r11.setCallback(this.mPresenterCallback);
        r11.setForceShowIcon(this.mForceShowIcon);
        r11.setGravity(this.mDropDownGravity);
        return r11;
    L5:
        r11 = new StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
        goto L6
    }

    private void showPopup(int r5, int r10, boolean r11, boolean r12) {
        MenuPopup r13 = getPopup();
        r13.setShowTitle(r12);
        if (r11 == true) goto L5;
    L8:
        r13.show();
        return;
    L5:
        if ((GravityCompat.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) != 5) goto L7;
        r5 = r5 - this.mAnchorView.getWidth();
    L7:
        r13.setHorizontalOffset(r5);
        r13.setVerticalOffset(r10);
        int r14 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
        r13.setEpicenterBounds(new Rect(r5 - r14, r10 - r14, r5 + r14, r10 + r14));
        goto L8
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void dismiss() {
        if (isShowing() == false) goto L6;
        this.mPopup.dismiss();
        return;
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    public ListView getListView() {
        return getPopup().getListView();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public MenuPopup getPopup() {
        if (this.mPopup != null) goto L6;
        this.mPopup = createPopup();
    L6:
        return this.mPopup;
    }

    public boolean isShowing() {
        MenuPopup r5 = this.mPopup;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isShowing() == false) goto L7;
        return true;
    }

    public void onDismiss() {
        this.mPopup = null;
        PopupWindow.OnDismissListener r5 = this.mOnDismissListener;
        if (r5 == null) goto L6;
        r5.onDismiss();
        return;
    }

    public void setAnchorView(@NonNull View r5) {
        this.mAnchorView = r5;
    }

    public void setForceShowIcon(boolean r5) {
        this.mForceShowIcon = r5;
        MenuPopup r10 = this.mPopup;
        if (r10 == null) goto L6;
        r10.setForceShowIcon(r5);
        return;
    }

    public void setGravity(int r5) {
        this.mDropDownGravity = r5;
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener r5) {
        this.mOnDismissListener = r5;
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void setPresenterCallback(@Nullable MenuPresenter.Callback r5) {
        this.mPresenterCallback = r5;
        MenuPopup r10 = this.mPopup;
        if (r10 == null) goto L6;
        r10.setCallback(r5);
        return;
    }

    public void show() {
        if (tryShow() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public boolean tryShow() {
        if (isShowing() == false) goto L6;
        return true;
    L6:
        if (this.mAnchorView != null) goto L8;
        return false;
    L8:
        showPopup(0, 0, false, false);
        return true;
    }

    public MenuPopupHelper(@NonNull Context r10, @NonNull MenuBuilder r11, @NonNull View r12) {
        this(r10, r11, r12, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(@NonNull Context r10, @NonNull MenuBuilder r11, @NonNull View r12, boolean r13, @AttrRes int r14) {
        this(r10, r11, r12, r13, r14, 0);
    }

    public void show(int r5, int r10) {
        if (tryShow(r5, r10) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public MenuPopupHelper(@NonNull Context r5, @NonNull MenuBuilder r10, @NonNull View r11, boolean r12, @AttrRes int r13, @StyleRes int r14) {
        this.mDropDownGravity = GravityCompat.START;
        this.mInternalOnDismissListener = new AnonymousClass1(this);
        this.mContext = r5;
        this.mMenu = r10;
        this.mAnchorView = r11;
        this.mOverflowOnly = r12;
        this.mPopupStyleAttr = r13;
        this.mPopupStyleRes = r14;
    }

    public boolean tryShow(int r5, int r10) {
        if (isShowing() == false) goto L6;
        return true;
    L6:
        if (this.mAnchorView != null) goto L9;
        return false;
    L9:
        showPopup(r5, r10, true, true);
        return true;
    }
}
