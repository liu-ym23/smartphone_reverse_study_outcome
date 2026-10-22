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
        void onDismiss(PopupMenu r10);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r10);
    }

    public PopupMenu(@NonNull Context r10, @NonNull View r11) {
        this(r10, r11, 0);
    }

    public PopupMenu(@NonNull Context r10, @NonNull View r11, int r12) {
        this(r10, r11, r12, R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(@NonNull Context r10, @NonNull View r11, int r12, @AttrRes int r13, @StyleRes int r14) {
        this.mContext = r10;
        this.mAnchor = r11;
        MenuBuilder r15 = new MenuBuilder(r10);
        this.mMenu = r15;
        r15.setCallback(new AnonymousClass1(this));
        MenuPopupHelper r16 = new MenuPopupHelper(r10, r15, r11, false, r13, r14);
        this.mPopup = r16;
        r16.setGravity(r12);
        r16.setOnDismissListener(new AnonymousClass2(this));
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    @NonNull
    public View.OnTouchListener getDragToOpenListener() {
        if (this.mDragListener != null) goto L6;
        final View r10 = this.mAnchor;
        this.mDragListener = new AnonymousClass3(this, r10);
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
    ListView getMenuListView() {
        if (this.mPopup.isShowing() == true) goto L7;
        return null;
    L7:
        return this.mPopup.getListView();
    }

    public void inflate(@MenuRes int r10) {
        getMenuInflater().inflate(r10, this.mMenu);
    }

    public void setForceShowIcon(boolean r10) {
        this.mPopup.setForceShowIcon(r10);
    }

    public void setGravity(int r10) {
        this.mPopup.setGravity(r10);
    }

    public void setOnDismissListener(@Nullable OnDismissListener r10) {
        this.mOnDismissListener = r10;
    }

    public void setOnMenuItemClickListener(@Nullable OnMenuItemClickListener r10) {
        this.mMenuItemClickListener = r10;
    }

    public void show() {
        this.mPopup.show();
    }
}
