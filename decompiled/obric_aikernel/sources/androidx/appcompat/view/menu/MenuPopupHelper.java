package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
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
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static void getRealSize(Display r10, Point r11) {
            r10.getRealSize(r11);
        }
    }

    public MenuPopupHelper(@NonNull Context r10, @NonNull MenuBuilder r11) {
        this(r10, r11, null, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(@NonNull Context r10, @NonNull MenuBuilder r11, @NonNull View r12) {
        this(r10, r11, r12, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(@NonNull Context r10, @NonNull MenuBuilder r11, @NonNull View r12, boolean r13, @AttrRes int r14) {
        this(r10, r11, r12, r13, r14, 0);
    }

    public MenuPopupHelper(@NonNull Context r10, @NonNull MenuBuilder r11, @NonNull View r12, boolean r13, @AttrRes int r14, @StyleRes int r15) {
        this.mDropDownGravity = GravityCompat.START;
        this.mInternalOnDismissListener = new AnonymousClass1(this);
        this.mContext = r10;
        this.mMenu = r11;
        this.mAnchorView = r12;
        this.mOverflowOnly = r13;
        this.mPopupStyleAttr = r14;
        this.mPopupStyleRes = r15;
    }

    @NonNull
    private MenuPopup createPopup() {
        Display r10 = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        Point r11 = new Point();
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.getRealSize(r10, r11);
    L7:
        if (Math.min(r11.x, r11.y) < this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) goto L9;
        boolean r12 = true;
    L10:
        if (r12 == false) goto L12;
        MenuPopup r13 = new CascadingMenuPopup(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
    L13:
        r13.addMenu(this.mMenu);
        r13.setOnDismissListener(this.mInternalOnDismissListener);
        r13.setAnchorView(this.mAnchorView);
        r13.setCallback(this.mPresenterCallback);
        r13.setForceShowIcon(this.mForceShowIcon);
        r13.setGravity(this.mDropDownGravity);
        return r13;
    L12:
        r13 = new StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
        goto L13
    L9:
        r12 = false;
        goto L10
    L5:
        r10.getSize(r11);
        goto L7
    }

    private void showPopup(int r10, int r11, boolean r12, boolean r13) {
        MenuPopup r14 = getPopup();
        r14.setShowTitle(r13);
        if (r12 == true) goto L5;
    L8:
        r14.show();
        return;
    L5:
        if ((GravityCompat.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) != 5) goto L7;
        r10 = r10 - this.mAnchorView.getWidth();
    L7:
        r14.setHorizontalOffset(r10);
        r14.setVerticalOffset(r11);
        int r15 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
        r14.setEpicenterBounds(new Rect(r10 - r15, r11 - r15, r10 + r15, r11 + r15));
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
        MenuPopup r10 = this.mPopup;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isShowing() == false) goto L7;
        return true;
    }

    protected void onDismiss() {
        this.mPopup = null;
        PopupWindow.OnDismissListener r10 = this.mOnDismissListener;
        if (r10 == null) goto L6;
        r10.onDismiss();
        return;
    }

    public void setAnchorView(@NonNull View r10) {
        this.mAnchorView = r10;
    }

    public void setForceShowIcon(boolean r10) {
        this.mForceShowIcon = r10;
        MenuPopup r11 = this.mPopup;
        if (r11 == null) goto L6;
        r11.setForceShowIcon(r10);
        return;
    }

    public void setGravity(int r10) {
        this.mDropDownGravity = r10;
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener r10) {
        this.mOnDismissListener = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void setPresenterCallback(@Nullable MenuPresenter.Callback r10) {
        this.mPresenterCallback = r10;
        MenuPopup r11 = this.mPopup;
        if (r11 == null) goto L6;
        r11.setCallback(r10);
        return;
    }

    public void show() {
        if (tryShow() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public void show(int r10, int r11) {
        if (tryShow(r10, r11) == false) goto L6;
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

    public boolean tryShow(int r10, int r11) {
        if (isShowing() == false) goto L6;
        return true;
    L6:
        if (this.mAnchorView != null) goto L9;
        return false;
    L9:
        showPopup(r10, r11, true, true);
        return true;
    }
}
