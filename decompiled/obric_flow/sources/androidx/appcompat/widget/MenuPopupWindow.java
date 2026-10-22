package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.util.AttributeSet;
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
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static void setEnterTransition(PopupWindow r5, Transition r10) {
            r5.setEnterTransition(r10);
        }

        @DoNotInline
        public static void setExitTransition(PopupWindow r5, Transition r10) {
            r5.setExitTransition(r10);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void setTouchModal(PopupWindow r5, boolean r10) {
            r5.setTouchModal(r10);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class MenuDropDownListView extends DropDownListView {
        final int mAdvanceKey;
        private MenuItemHoverListener mHoverListener;
        private MenuItem mHoveredMenuItem;
        final int mRetreatKey;

        @RequiresApi(17)
        public static class Api17Impl {
            private Api17Impl() {
            }

            @DoNotInline
            public static int getLayoutDirection(Configuration r5) {
                return r5.getLayoutDirection();
            }
        }

        public MenuDropDownListView(Context r5, boolean r10) {
            super(r5, r10);
            if (1 != Api17Impl.getLayoutDirection(r5.getResources().getConfiguration())) goto L5;
            this.mAdvanceKey = 21;
            this.mRetreatKey = 22;
            return;
        L5:
            this.mAdvanceKey = 22;
            this.mRetreatKey = 21;
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
        public /* bridge */ /* synthetic */ int lookForSelectablePosition(int r5, boolean r10) {
            return super.lookForSelectablePosition(r5, r10);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int measureHeightOfChildrenCompat(int r5, int r10, int r11, int r12, int r13) {
            return super.measureHeightOfChildrenCompat(r5, r10, r11, r12, r13);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent r5, int r10) {
            return super.onForwardedEvent(r5, r10);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public boolean onHoverEvent(MotionEvent r5) {
            if (this.mHoverListener == null) goto L27;
            ListAdapter r10 = getAdapter();
            if ((r10 instanceof HeaderViewListAdapter) == false) goto L7;
            HeaderViewListAdapter r11 = (HeaderViewListAdapter) r10;
            int r12 = r11.getHeadersCount();
            MenuAdapter r13 = (MenuAdapter) r11.getWrappedAdapter();
        L9:
            if (r5.getAction() == 10) goto L17;
            int r14 = pointToPosition((int) r5.getX(), (int) r5.getY());
            if (r14 == (-1)) goto L17;
            int r15 = r14 - r12;
            if (r15 < 0) goto L17;
            if (r15 >= r13.getCount()) goto L17;
            MenuItemImpl r16 = r13.getItem(r15);
        L18:
            MenuItem r17 = this.mHoveredMenuItem;
            if (r17 == r16) goto L27;
            MenuBuilder r18 = r13.getAdapterMenu();
            if (r17 == null) goto L23;
            this.mHoverListener.onItemHoverExit(r18, r17);
        L23:
            this.mHoveredMenuItem = r16;
            if (r16 == null) goto L27;
            this.mHoverListener.onItemHoverEnter(r18, r16);
        L17:
            r16 = null;
            goto L18
        L7:
            r13 = (MenuAdapter) r10;
            r12 = 0;
        L27:
            return super.onHoverEvent(r5);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int r5, KeyEvent r10) {
            ListMenuItemView r11 = (ListMenuItemView) getSelectedView();
            if (r11 != null) goto L5;
        L12:
            if (r11 == null) goto L22;
            if (r5 != this.mRetreatKey) goto L22;
            setSelection(-1);
            ListAdapter r12 = getAdapter();
            if ((r12 instanceof HeaderViewListAdapter) == false) goto L18;
            MenuAdapter r13 = (MenuAdapter) ((HeaderViewListAdapter) r12).getWrappedAdapter();
        L19:
            r13.getAdapterMenu().close(false);
            return true;
        L18:
            r13 = (MenuAdapter) r12;
        L22:
            return super.onKeyDown(r5, r10);
        L5:
            if (r5 != this.mAdvanceKey) goto L12;
            if (r11.isEnabled() == true) goto L9;
        L11:
            return true;
        L9:
            if (r11.getItemData().hasSubMenu() == false) goto L11;
            performItemClick(r11, getSelectedItemPosition(), getSelectedItemId());
            goto L11
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent r5) {
            return super.onTouchEvent(r5);
        }

        public void setHoverListener(MenuItemHoverListener r5) {
            this.mHoverListener = r5;
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable r5) {
            super.setSelector(r5);
        }
    }

    public MenuPopupWindow(@NonNull Context r5, @Nullable AttributeSet r10, int r11, int r12) {
        super(r5, r10, r11, r12);
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    @NonNull
    public DropDownListView createDropDownListView(Context r5, boolean r10) {
        MenuDropDownListView r11 = new MenuDropDownListView(r5, r10);
        r11.setHoverListener(this);
        return r11;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverEnter(@NonNull MenuBuilder r5, @NonNull MenuItem r10) {
        MenuItemHoverListener r11 = this.mHoverListener;
        if (r11 == null) goto L6;
        r11.onItemHoverEnter(r5, r10);
        return;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverExit(@NonNull MenuBuilder r5, @NonNull MenuItem r10) {
        MenuItemHoverListener r11 = this.mHoverListener;
        if (r11 == null) goto L6;
        r11.onItemHoverExit(r5, r10);
        return;
    }

    public void setEnterTransition(Object r5) {
        Api23Impl.setEnterTransition(this.mPopup, (Transition) r5);
    }

    public void setExitTransition(Object r5) {
        Api23Impl.setExitTransition(this.mPopup, (Transition) r5);
    }

    public void setHoverListener(MenuItemHoverListener r5) {
        this.mHoverListener = r5;
    }

    public void setTouchModal(boolean r5) {
        Api29Impl.setTouchModal(this.mPopup, r5);
    }
}
