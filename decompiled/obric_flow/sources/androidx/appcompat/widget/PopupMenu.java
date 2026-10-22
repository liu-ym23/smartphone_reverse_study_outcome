package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import androidx.annotation.AttrRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;

/* JADX INFO: loaded from: classes.dex */
public class PopupMenu {
    private final View mAnchor;
    private final Context mContext;
    private View.OnTouchListener mDragListener;
    private final MenuBuilder mMenu;
    OnMenuItemClickListener mMenuItemClickListener;
    OnDismissListener mOnDismissListener;
    final MenuPopupHelper mPopup;

    public interface OnDismissListener {
        void onDismiss(PopupMenu r5);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r5);
    }

    public PopupMenu(@NonNull Context r5, @NonNull View r10) {
        this(r5, r10, 0);
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    @NonNull
    public View.OnTouchListener getDragToOpenListener() {
        if (this.mDragListener != null) goto L6;
        final View r5 = this.mAnchor;
        this.mDragListener = new AnonymousClass3(this, r5);
    L6:
        return this.mDragListener;
    }

    public int getGravity() {
        return this.mPopup.getGravity();
    }

    @NonNull
    public Menu getMenu() {
        return this.mMenu;
    }

    @NonNull
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContext);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ListView getMenuListView() {
        if (this.mPopup.isShowing() == true) goto L7;
        return null;
    L7:
        return this.mPopup.getListView();
    }

    public void inflate(@MenuRes int r5) {
        getMenuInflater().inflate(r5, this.mMenu);
    }

    public void setForceShowIcon(boolean r5) {
        this.mPopup.setForceShowIcon(r5);
    }

    public void setGravity(int r5) {
        this.mPopup.setGravity(r5);
    }

    public void setOnDismissListener(@Nullable OnDismissListener r5) {
        this.mOnDismissListener = r5;
    }

    public void setOnMenuItemClickListener(@Nullable OnMenuItemClickListener r5) {
        this.mMenuItemClickListener = r5;
    }

    public void show() {
        this.mPopup.show();
    }

    public PopupMenu(@NonNull Context r10, @NonNull View r11, int r12) {
        this(r10, r11, r12, R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(@NonNull Context r10, @NonNull View r11, int r12, @AttrRes int r13, @StyleRes int r14) {
        this.mContext = r10;
        this.mAnchor = r11;
        MenuBuilder r5 = new MenuBuilder(r10);
        this.mMenu = r5;
        r5.setCallback(new AnonymousClass1(this));
        MenuPopupHelper r15 = new MenuPopupHelper(r10, r5, r11, false, r13, r14);
        this.mPopup = r15;
        r15.setGravity(r12);
        r15.setOnDismissListener(new AnonymousClass2(this));
    }
}
