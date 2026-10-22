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
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
    private static final String TAG = "MenuPopupWindow";
    private static Method sSetTouchModalMethod;
    private MenuItemHoverListener mHoverListener;

    static class Api23Impl {
        private Api23Impl() {
        }

        static void setEnterTransition(PopupWindow r0, Transition r1) {
            r0.setEnterTransition(r1);
        }

        static void setExitTransition(PopupWindow r0, Transition r1) {
            r0.setExitTransition(r1);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setTouchModal(PopupWindow r0, boolean r1) {
            r0.setTouchModal(r1);
        }
    }

    public static class MenuDropDownListView extends DropDownListView {
        final int mAdvanceKey;
        private MenuItemHoverListener mHoverListener;
        private MenuItem mHoveredMenuItem;
        final int mRetreatKey;

        static class Api17Impl {
            private Api17Impl() {
            }

            static int getLayoutDirection(Configuration r0) {
                return r0.getLayoutDirection();
            }
        }

        public MenuDropDownListView(Context r4, boolean r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            super(r6, r5);
            Configuration r7 = ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getConfiguration();
            if (Build.VERSION.SDK_INT >= 17) goto L5;
        L7:
            this.mAdvanceKey = 22;
            this.mRetreatKey = 21;
            return;
        L5:
            if (1 != Api17Impl.getLayoutDirection(r7)) goto L7;
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
        public /* bridge */ /* synthetic */ int lookForSelectablePosition(int r1, boolean r2) {
            return super.lookForSelectablePosition(r1, r2);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int measureHeightOfChildrenCompat(int r1, int r2, int r3, int r4, int r5) {
            return super.measureHeightOfChildrenCompat(r1, r2, r3, r4, r5);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent r1, int r2) {
            return super.onForwardedEvent(r1, r2);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public boolean onHoverEvent(MotionEvent r6) {
            if (this.mHoverListener == null) goto L26;
            ListAdapter r0 = getAdapter();
            if (ZeusTransformUtils.instanceOf(r0, HeaderViewListAdapter.class) == false) goto L7;
            HeaderViewListAdapter r1 = (HeaderViewListAdapter) ZeusTransformUtils.preCheckCast(r0, HeaderViewListAdapter.class, "com.obric.memorydata.plugin");
            int r2 = r1.getHeadersCount();
            r0 = r1.getWrappedAdapter();
        L8:
            MenuAdapter r3 = (MenuAdapter) ZeusTransformUtils.preCheckCast(r0, MenuAdapter.class, "com.obric.memorydata.plugin");
            MenuItemImpl r4 = null;
            if (r6.getAction() == 10) goto L17;
            int r5 = pointToPosition((int) r6.getX(), (int) r6.getY());
            if (r5 == (-1)) goto L17;
            int r7 = r5 - r2;
            if (r7 < 0) goto L17;
            if (r7 >= r3.getCount()) goto L17;
            r4 = r3.getItem(r7);
        L17:
            MenuItem r8 = this.mHoveredMenuItem;
            if (r8 == r4) goto L26;
            MenuBuilder r9 = r3.getAdapterMenu();
            if (r8 == null) goto L22;
            this.mHoverListener.onItemHoverExit(r9, r8);
        L22:
            this.mHoveredMenuItem = r4;
            if (r4 == null) goto L26;
            this.mHoverListener.onItemHoverEnter(r9, r4);
            goto L26
        L7:
            r2 = 0;
        L26:
            return super.onHoverEvent(r6);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int r5, KeyEvent r6) {
            ListMenuItemView r0 = (ListMenuItemView) ZeusTransformUtils.preCheckCast(getSelectedView(), ListMenuItemView.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
        L12:
            if (r0 == null) goto L21;
            if (r5 != this.mRetreatKey) goto L21;
            setSelection(-1);
            ListAdapter r4 = getAdapter();
            if (ZeusTransformUtils.instanceOf(r4, HeaderViewListAdapter.class) == false) goto L18;
            r4 = ((HeaderViewListAdapter) ZeusTransformUtils.preCheckCast(r4, HeaderViewListAdapter.class, "com.obric.memorydata.plugin")).getWrappedAdapter();
        L18:
            ((MenuAdapter) ZeusTransformUtils.preCheckCast(r4, MenuAdapter.class, "com.obric.memorydata.plugin")).getAdapterMenu().close(false);
            return true;
        L21:
            return super.onKeyDown(r5, r6);
        L5:
            if (r5 != this.mAdvanceKey) goto L12;
            if (r0.isEnabled() == true) goto L9;
        L11:
            return true;
        L9:
            if (r0.getItemData().hasSubMenu() == false) goto L11;
            performItemClick(r0, getSelectedItemPosition(), getSelectedItemId());
            goto L11
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent r1) {
            return super.onTouchEvent(r1);
        }

        public void setHoverListener(MenuItemHoverListener r3) {
            this.mHoverListener = (MenuItemHoverListener) ZeusTransformUtils.wrapperContextForParams(r3, MenuItemHoverListener.class, "com.obric.memorydata.plugin");
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable r1) {
            super.setSelector(r1);
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

    public MenuPopupWindow(Context r3, AttributeSet r4, int r5, int r6) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5, r6);
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    DropDownListView createDropDownListView(Context r3, boolean r4) {
        MenuDropDownListView r0 = new MenuDropDownListView((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
        r0.setHoverListener(this);
        return r0;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverEnter(MenuBuilder r3, MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.memorydata.plugin");
        MenuItemHoverListener r2 = this.mHoverListener;
        if (r2 == null) goto L6;
        r2.onItemHoverEnter(r3, r5);
        return;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverExit(MenuBuilder r3, MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.memorydata.plugin");
        MenuItemHoverListener r2 = this.mHoverListener;
        if (r2 == null) goto L6;
        r2.onItemHoverExit(r3, r5);
        return;
    }

    public void setEnterTransition(Object r3) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setEnterTransition(this.mPopup, (Transition) ZeusTransformUtils.preCheckCast(r3, Transition.class, "com.obric.memorydata.plugin"));
        return;
    }

    public void setExitTransition(Object r3) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setExitTransition(this.mPopup, (Transition) ZeusTransformUtils.preCheckCast(r3, Transition.class, "com.obric.memorydata.plugin"));
        return;
    }

    public void setHoverListener(MenuItemHoverListener r3) {
        this.mHoverListener = (MenuItemHoverListener) ZeusTransformUtils.wrapperContextForParams(r3, MenuItemHoverListener.class, "com.obric.memorydata.plugin");
    }

    public void setTouchModal(boolean r4) {
        if (Build.VERSION.SDK_INT > 28) goto L9;
        Method r0 = sSetTouchModalMethod;
        if (r0 == null) goto L13;
        r0.invoke(this.mPopup, new Object[]{Boolean.valueOf(r4)});     // Catch: Exception -> L8
        return;
    L8:
        Log.i(TAG, "Could not invoke setTouchModal() on PopupWindow. Oh well.");
        return;
    L13:
        return;
    L9:
        Api29Impl.setTouchModal(this.mPopup, r4);
    }
}
