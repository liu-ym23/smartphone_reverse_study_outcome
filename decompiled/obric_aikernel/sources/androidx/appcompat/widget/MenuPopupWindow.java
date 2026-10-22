package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
    private static final String TAG = "MenuPopupWindow";
    private static Method sSetTouchModalMethod;
    private MenuItemHoverListener mHoverListener;

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void setEnterTransition(PopupWindow r10, Transition r11) {
            r10.setEnterTransition(r11);
        }

        @DoNotInline
        static void setExitTransition(PopupWindow r10, Transition r11) {
            r10.setExitTransition(r11);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void setTouchModal(PopupWindow r10, boolean r11) {
            r10.setTouchModal(r11);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class MenuDropDownListView extends DropDownListView {
        final int mAdvanceKey;
        private MenuItemHoverListener mHoverListener;
        private MenuItem mHoveredMenuItem;
        final int mRetreatKey;

        @RequiresApi(17)
        static class Api17Impl {
            private Api17Impl() {
            }

            @DoNotInline
            static int getLayoutDirection(Configuration r10) {
                return r10.getLayoutDirection();
            }
        }

        public MenuDropDownListView(Context r10, boolean r11) {
            super(r10, r11);
            Configuration r12 = r10.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17) goto L5;
        L7:
            this.mAdvanceKey = 22;
            this.mRetreatKey = 21;
            return;
        L5:
            if (1 != Api17Impl.getLayoutDirection(r12)) goto L7;
            this.mAdvanceKey = 21;
            this.mRetreatKey = 22;
        }

        public void clearSelection() {
            setSelection(-1);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int lookForSelectablePosition(int r10, boolean r11) {
            return super.lookForSelectablePosition(r10, r11);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int measureHeightOfChildrenCompat(int r10, int r11, int r12, int r13, int r14) {
            return super.measureHeightOfChildrenCompat(r10, r11, r12, r13, r14);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent r10, int r11) {
            return super.onForwardedEvent(r10, r11);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public boolean onHoverEvent(MotionEvent r10) {
            if (this.mHoverListener == null) goto L26;
            ListAdapter r11 = getAdapter();
            if ((r11 instanceof HeaderViewListAdapter) == false) goto L7;
            HeaderViewListAdapter r12 = (HeaderViewListAdapter) r11;
            int r13 = r12.getHeadersCount();
            r11 = r12.getWrappedAdapter();
        L8:
            MenuAdapter r14 = (MenuAdapter) r11;
            MenuItemImpl r15 = null;
            if (r10.getAction() == 10) goto L17;
            int r16 = pointToPosition((int) r10.getX(), (int) r10.getY());
            if (r16 == (-1)) goto L17;
            int r17 = r16 - r13;
            if (r17 < 0) goto L17;
            if (r17 >= r14.getCount()) goto L17;
            r15 = r14.getItem(r17);
        L17:
            MenuItem r18 = this.mHoveredMenuItem;
            if (r18 == r15) goto L26;
            MenuBuilder r19 = r14.getAdapterMenu();
            if (r18 == null) goto L22;
            this.mHoverListener.onItemHoverExit(r19, r18);
        L22:
            this.mHoveredMenuItem = r15;
            if (r15 == null) goto L26;
            this.mHoverListener.onItemHoverEnter(r19, r15);
            goto L26
        L7:
            r13 = 0;
        L26:
            return super.onHoverEvent(r10);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int r10, KeyEvent r11) {
            ListMenuItemView r12 = (ListMenuItemView) getSelectedView();
            if (r12 != null) goto L5;
        L12:
            if (r12 == null) goto L21;
            if (r10 != this.mRetreatKey) goto L21;
            setSelection(-1);
            ListAdapter r13 = getAdapter();
            if ((r13 instanceof HeaderViewListAdapter) == false) goto L18;
            r13 = ((HeaderViewListAdapter) r13).getWrappedAdapter();
        L18:
            ((MenuAdapter) r13).getAdapterMenu().close(false);
            return true;
        L21:
            return super.onKeyDown(r10, r11);
        L5:
            if (r10 != this.mAdvanceKey) goto L12;
            if (r12.isEnabled() == true) goto L9;
        L11:
            return true;
        L9:
            if (r12.getItemData().hasSubMenu() == false) goto L11;
            performItemClick(r12, getSelectedItemPosition(), getSelectedItemId());
            goto L11
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent r10) {
            return super.onTouchEvent(r10);
        }

        public void setHoverListener(MenuItemHoverListener r10) {
            this.mHoverListener = r10;
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable r10) {
            super.setSelector(r10);
        }
    }

    static {
    L6:
        Log.i(TAG, "Could not find method setTouchModal() on PopupWindow. Oh well.");
        return;
    L3:
        if (Build.VERSION.SDK_INT > 28) goto L10;
        sSetTouchModalMethod = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L6
        return;
    }

    public MenuPopupWindow(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    @NonNull
    DropDownListView createDropDownListView(Context r10, boolean r11) {
        MenuDropDownListView r12 = new MenuDropDownListView(r10, r11);
        r12.setHoverListener(this);
        return r12;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverEnter(@NonNull MenuBuilder r10, @NonNull MenuItem r11) {
        MenuItemHoverListener r12 = this.mHoverListener;
        if (r12 == null) goto L6;
        r12.onItemHoverEnter(r10, r11);
        return;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverExit(@NonNull MenuBuilder r10, @NonNull MenuItem r11) {
        MenuItemHoverListener r12 = this.mHoverListener;
        if (r12 == null) goto L6;
        r12.onItemHoverExit(r10, r11);
        return;
    }

    public void setEnterTransition(Object r10) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setEnterTransition(this.mPopup, (Transition) r10);
        return;
    }

    public void setExitTransition(Object r10) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setExitTransition(this.mPopup, (Transition) r10);
        return;
    }

    public void setHoverListener(MenuItemHoverListener r10) {
        this.mHoverListener = r10;
    }

    public void setTouchModal(boolean r10) {
        if (Build.VERSION.SDK_INT > 28) goto L9;
        Method r11 = sSetTouchModalMethod;
        if (r11 == null) goto L13;
        r11.invoke(this.mPopup, new Object[]{Boolean.valueOf(r10)});     // Catch: Exception -> L8
        return;
    L8:
        Log.i(TAG, "Could not invoke setTouchModal() on PopupWindow. Oh well.");
        return;
    L13:
        return;
    L9:
        Api29Impl.setTouchModal(this.mPopup, r10);
    }
}
