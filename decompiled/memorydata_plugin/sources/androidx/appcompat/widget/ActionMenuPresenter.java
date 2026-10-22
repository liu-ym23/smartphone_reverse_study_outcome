package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import androidx.core.view.GravityCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups;
    ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    OverflowMenuButton mOverflowButton;
    OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback;
    OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    private class ActionButtonSubmenu extends MenuPopupHelper {
        final /* synthetic */ ActionMenuPresenter this$0;

        public ActionButtonSubmenu(ActionMenuPresenter r9, Context r10, SubMenuBuilder r11, View r12) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
            this.this$0 = r9;
            super(r3, r11, r12, false, ZeusTransformUtils.mapRes(R.attr.actionOverflowMenuStyle, "attr", "actionOverflowMenuStyle"));
            if (((MenuItemImpl) ZeusTransformUtils.preCheckCast(r11.getItem(), MenuItemImpl.class, "com.obric.memorydata.plugin")).isActionButton() == false) goto L5;
        L9:
            setPresenterCallback(r9.mPopupPresenterCallback);
            return;
        L5:
            if (r9.mOverflowButton != null) goto L7;
            View r13 = (View) ZeusTransformUtils.preCheckCast(ActionMenuPresenter.access$200(r9), View.class, "com.obric.memorydata.plugin");
        L8:
            setAnchorView(r13);
            goto L9
        L7:
            r13 = r9.mOverflowButton;
            goto L8
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public void onDismiss() {
            this.this$0.mActionButtonPopup = null;
            this.this$0.mOpenSubMenuId = 0;
            super.onDismiss();
        }
    }

    private class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        final /* synthetic */ ActionMenuPresenter this$0;

        ActionMenuPopupCallback(ActionMenuPresenter r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback
        public ShowableListMenu getPopup() {
            if (this.this$0.mActionButtonPopup != null) goto L7;
            return null;
        L7:
            return this.this$0.mActionButtonPopup.getPopup();
        }
    }

    private class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;
        final /* synthetic */ ActionMenuPresenter this$0;

        public OpenOverflowRunnable(ActionMenuPresenter r1, OverflowPopup r2) {
            this.this$0 = r1;
            this.mPopup = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.access$400(this.this$0) == null) goto L5;
            ActionMenuPresenter.access$500(this.this$0).changeMenuMode();
        L5:
            View r0 = (View) ZeusTransformUtils.preCheckCast(ActionMenuPresenter.access$600(this.this$0), View.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L8;
        L12:
            this.this$0.mPostedOpenRunnable = null;
            return;
        L8:
            if (r0.getWindowToken() == null) goto L12;
            if (this.mPopup.tryShow() == false) goto L12;
            ActionMenuPresenter r1 = this.this$0;
            r1.mOverflowPopup = this.mPopup;
            goto L12
        }
    }

    private class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        final /* synthetic */ ActionMenuPresenter this$0;

        public OverflowMenuButton(final ActionMenuPresenter r4, Context r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            this.this$0 = r4;
            super(r6, null, ZeusTransformUtils.mapRes(R.attr.actionOverflowButtonStyle, "attr", "actionOverflowButtonStyle"));
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new AnonymousClass1(this, this, r4));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick() == false) goto L5;
            return true;
        L5:
            playSoundEffect(0);
            this.this$0.showOverflowMenu();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int r4, int r5, int r6, int r7) {
            boolean r8 = super.setFrame(r4, r5, r6, r7);
            Drawable r9 = getDrawable();
            Drawable r10 = getBackground();
            if (r9 == null) goto L6;
            if (r10 == null) goto L6;
            int r11 = getWidth();
            int r12 = getHeight();
            int r0 = Math.max(r11, r12) / 2;
            int r1 = getPaddingLeft() - getPaddingRight();
            int r13 = (r11 + r1) / 2;
            int r14 = (r12 + (getPaddingTop() - getPaddingBottom())) / 2;
            DrawableCompat.setHotspotBounds(r10, r13 - r0, r14 - r0, r13 + r0, r14 + r0);
        L6:
            return r8;
        }
    }

    private class OverflowPopup extends MenuPopupHelper {
        final /* synthetic */ ActionMenuPresenter this$0;

        public OverflowPopup(ActionMenuPresenter r7, Context r8, MenuBuilder r9, View r10, boolean r11) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            this.this$0 = r7;
            super(r1, r9, r10, r11, ZeusTransformUtils.mapRes(R.attr.actionOverflowMenuStyle, "attr", "actionOverflowMenuStyle"));
            setGravity(GravityCompat.END);
            setPresenterCallback(r7.mPopupPresenterCallback);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public void onDismiss() {
            if (ActionMenuPresenter.access$000(this.this$0) == null) goto L5;
            ActionMenuPresenter.access$100(this.this$0).close();
        L5:
            this.this$0.mOverflowPopup = null;
            super.onDismiss();
        }
    }

    private class PopupPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ ActionMenuPresenter this$0;

        PopupPresenterCallback(ActionMenuPresenter r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder r3, boolean r4) {
            if (ZeusTransformUtils.instanceOf(r3, SubMenuBuilder.class) == false) goto L5;
            r3.getRootMenu().close(false);
        L5:
            MenuPresenter.Callback r2 = this.this$0.getCallback();
            if (r2 == null) goto L9;
            r2.onCloseMenu(r3, r4);
            return;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder r5) {
            if (r5 != ActionMenuPresenter.access$300(this.this$0)) goto L5;
            return false;
        L5:
            ActionMenuPresenter r0 = this.this$0;
            r0.mOpenSubMenuId = ((SubMenuBuilder) ZeusTransformUtils.preCheckCast(r5, SubMenuBuilder.class, "com.obric.memorydata.plugin")).getItem().getItemId();
            MenuPresenter.Callback r4 = this.this$0.getCallback();
            if (r4 != null) goto L8;
            return false;
        L8:
            return r4.onOpenSubMenu(r5);
        }
    }

    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int openSubMenuId;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState() {
        }

        SavedState(Parcel r1) {
            this.openSubMenuId = r1.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.openSubMenuId);
        }
    }

    public ActionMenuPresenter(Context r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.abc_action_menu_layout, "layout", "abc_action_menu_layout"), ZeusTransformUtils.mapRes(R.layout.abc_action_menu_item_layout, "layout", "abc_action_menu_item_layout"));
        this.mActionButtonGroups = new SparseBooleanArray();
        this.mPopupPresenterCallback = new PopupPresenterCallback(this);
    }

    static /* synthetic */ MenuBuilder access$000(ActionMenuPresenter r0) {
        return r0.mMenu;
    }

    static /* synthetic */ MenuBuilder access$100(ActionMenuPresenter r0) {
        return r0.mMenu;
    }

    static /* synthetic */ MenuView access$200(ActionMenuPresenter r0) {
        return r0.mMenuView;
    }

    static /* synthetic */ MenuBuilder access$300(ActionMenuPresenter r0) {
        return r0.mMenu;
    }

    static /* synthetic */ MenuBuilder access$400(ActionMenuPresenter r0) {
        return r0.mMenu;
    }

    static /* synthetic */ MenuBuilder access$500(ActionMenuPresenter r0) {
        return r0.mMenu;
    }

    static /* synthetic */ MenuView access$600(ActionMenuPresenter r0) {
        return r0.mMenuView;
    }

    private View findViewForItem(MenuItem r7) {
        MenuItem r8 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r7, MenuItem.class, "com.obric.memorydata.plugin");
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.mMenuView, ViewGroup.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return null;
    L5:
        int r2 = r6.getChildCount();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L13;
        View r4 = r6.getChildAt(r3);
        if (ZeusTransformUtils.instanceOf(r4, MenuView.ItemView.class) == false) goto L12;
        if (((MenuView.ItemView) ZeusTransformUtils.preCheckCast(r4, MenuView.ItemView.class, "com.obric.memorydata.plugin")).getItemData() != r8) goto L12;
        return r4;
    L12:
        r3 = r3 + 1;
        goto L6
    L13:
        return null;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public void bindItemView(MenuItemImpl r3, MenuView.ItemView r4) {
        MenuView.ItemView r5 = (MenuView.ItemView) ZeusTransformUtils.wrapperContextForParams(r4, MenuView.ItemView.class, "com.obric.memorydata.plugin");
        r5.initialize(r3, 0);
        ActionMenuView r6 = (ActionMenuView) ZeusTransformUtils.preCheckCast(this.mMenuView, ActionMenuView.class, "com.obric.memorydata.plugin");
        ActionMenuItemView r7 = (ActionMenuItemView) ZeusTransformUtils.preCheckCast(r5, ActionMenuItemView.class, "com.obric.memorydata.plugin");
        r7.setItemInvoker(r6);
        if (this.mPopupCallback != null) goto L5;
        this.mPopupCallback = new ActionMenuPopupCallback(this);
    L5:
        r7.setPopupCallback(this.mPopupCallback);
    }

    public boolean dismissPopupMenus() {
        boolean r0 = hideOverflowMenu();
        return hideSubMenus() | r0;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean filterLeftoverView(ViewGroup r3, int r4) {
        if (r3.getChildAt(r4) != this.mOverflowButton) goto L7;
        return false;
    L7:
        return super.filterLeftoverView(r3, r4);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        ActionMenuPresenter r0 = this;
        View r2 = null;
        if (r0.mMenu == null) goto L5;
        ArrayList<MenuItemImpl> r1 = r0.mMenu.getVisibleItems();
        int r4 = r1.size();
    L6:
        int r5 = r0.mMaxItems;
        int r6 = r0.mActionItemWidthLimit;
        int r7 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup r8 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0.mMenuView, ViewGroup.class, "com.obric.memorydata.plugin");
        int r9 = 0;
        boolean r11 = false;
        int r12 = 0;
        int r13 = 0;
    L7:
        if (r9 >= r4) goto L22;
        MenuItemImpl r14 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(r1.get(r9), MenuItemImpl.class, "com.obric.memorydata.plugin");
        if (r14.requiresActionButton() == false) goto L12;
        r12 = r12 + 1;
    L16:
        if (r0.mExpandedActionViewsExclusive == false) goto L20;
        if (r14.isActionViewExpanded() == false) goto L20;
        r5 = 0;
    L20:
        r9 = r9 + 1;
        goto L7
    L12:
        if (r14.requestsActionButton() == false) goto L14;
        r13 = r13 + 1;
        goto L16
    L14:
        r11 = true;
        goto L16
    L22:
        if (r0.mReserveOverflow == false) goto L27;
        if (r11 == false) goto L25;
    L26:
        r5 = r5 - 1;
        goto L27
    L25:
        if ((r13 + r12) > r5) goto L26;
    L27:
        int r10 = r5 - r12;
        SparseBooleanArray r15 = r0.mActionButtonGroups;
        r15.clear();
        if (r0.mStrictWidthLimit == false) goto L30;
        int r16 = r0.mMinCellSize;
        int r17 = r6 / r16;
        int r18 = r16 + ((r6 % r16) / r17);
    L31:
        int r19 = 0;
        int r110 = 0;
    L32:
        if (r19 >= r4) goto L98;
        MenuItemImpl r3 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(r1.get(r19), MenuItemImpl.class, "com.obric.memorydata.plugin");
        if (r3.requiresActionButton() == false) goto L48;
        View r111 = r0.getItemView(r3, r2, r8);
        if (r0.mStrictWidthLimit == false) goto L38;
        r17 = r17 - ActionMenuView.measureChildForCells(r111, r18, r17, r7, 0);
    L39:
        int r20 = r111.getMeasuredWidth();
        r6 = r6 - r20;
        if (r110 != 0) goto L42;
        r110 = r20;
    L42:
        int r21 = r3.getGroupId();
        if (r21 == 0) goto L45;
        r15.put(r21, true);
    L45:
        r3.setIsActionButton(true);
        int r112 = r4;
    L46:
        boolean r22 = false;
    L97:
        r19 = r19 + 1;
        r4 = r112;
        r2 = null;
        r0 = this;
        goto L32
    L38:
        r111.measure(r7, r7);
        goto L39
    L48:
        if (r3.requestsActionButton() == false) goto L96;
        int r23 = r3.getGroupId();
        boolean r113 = r15.get(r23);
        if (r10 > 0) goto L52;
        if (r113 == true) goto L52;
    L57:
        r112 = r4;
    L58:
        boolean r24 = false;
    L59:
        boolean r114 = r24;
        int r115 = r10;
        if (r24 == false) goto L79;
        View r25 = r0.getItemView(r3, null, r8);
        if (r0.mStrictWidthLimit == false) goto L66;
        int r116 = ActionMenuView.measureChildForCells(r25, r18, r17, r7, 0);
        r17 = r17 - r116;
        if (r116 != 0) goto L67;
        r114 = false;
    L67:
        boolean r26 = r114;
        int r27 = r25.getMeasuredWidth();
        r6 = r6 - r27;
        if (r110 != 0) goto L71;
        r110 = r27;
    L71:
        if (r0.mStrictWidthLimit == false) goto L75;
        if (r6 >= 0) goto L76;
    L77:
        boolean r28 = false;
    L78:
        r24 = r26 & r28;
    L76:
        r28 = true;
        goto L78
    L75:
        if ((r6 + r110) <= 0) goto L77;
    L66:
        r25.measure(r7, r7);
    L79:
        if (r24 == false) goto L82;
        if (r23 == 0) goto L82;
        r15.put(r23, true);
    L92:
        r10 = r115;
        if (r24 == false) goto L95;
        r10 = r10 - 1;
    L95:
        r3.setIsActionButton(r24);
    L82:
        if (r113 == false) goto L92;
        r15.put(r23, false);
        int r29 = 0;
    L84:
        if (r29 >= r19) goto L92;
        MenuItemImpl r30 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(r1.get(r29), MenuItemImpl.class, "com.obric.memorydata.plugin");
        if (r30.getGroupId() != r23) goto L91;
        if (r30.isActionButton() == false) goto L90;
        r115 = r115 + 1;
    L90:
        r30.setIsActionButton(false);
    L91:
        r29 = r29 + 1;
    L52:
        if (r6 <= 0) goto L57;
        r112 = r4;
        if (r0.mStrictWidthLimit == false) goto L56;
        if (r17 <= 0) goto L58;
    L56:
        r24 = true;
        goto L59
    L96:
        r112 = r4;
        r22 = false;
        r3.setIsActionButton(false);
        goto L97
    L98:
        return true;
    L30:
        r18 = 0;
        r17 = 0;
        goto L31
    L5:
        r1 = null;
        r4 = 0;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public View getItemView(MenuItemImpl r3, View r4, ViewGroup r5) {
        View r0 = r3.getActionView();
        if (r0 != null) goto L5;
    L6:
        r0 = super.getItemView(r3, r4, r5);
    L8:
        if (r3.isActionViewExpanded() == false) goto L10;
        int r2 = 8;
    L11:
        r0.setVisibility(r2);
        ActionMenuView r6 = (ActionMenuView) ZeusTransformUtils.preCheckCast(r5, ActionMenuView.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r7 = r0.getLayoutParams();
        if (r6.checkLayoutParams(r7) == true) goto L14;
        r0.setLayoutParams(r6.generateLayoutParams(r7));
    L14:
        return r0;
    L10:
        r2 = 0;
        goto L11
    L5:
        if (r3.hasCollapsibleActionView() == false) goto L8;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r3) {
        MenuView r0 = this.mMenuView;
        MenuView r4 = super.getMenuView(r3);
        if (r0 == r4) goto L5;
        ((ActionMenuView) ZeusTransformUtils.preCheckCast(r4, ActionMenuView.class, "com.obric.memorydata.plugin")).setPresenter(this);
    L5:
        return r4;
    }

    public Drawable getOverflowIcon() {
        OverflowMenuButton r0 = this.mOverflowButton;
        if (r0 == null) goto L7;
        return r0.getDrawable();
    L7:
        if (this.mPendingOverflowIconSet == true) goto L9;
        return null;
    L9:
        return this.mPendingOverflowIcon;
    }

    public boolean hideOverflowMenu() {
        if (this.mPostedOpenRunnable != null) goto L5;
    L8:
        OverflowPopup r4 = this.mOverflowPopup;
        if (r4 == null) goto L12;
        r4.dismiss();
        return true;
    L12:
        return false;
    L5:
        if (this.mMenuView == null) goto L8;
        ((View) ZeusTransformUtils.preCheckCast(this.mMenuView, View.class, "com.obric.memorydata.plugin")).removeCallbacks(this.mPostedOpenRunnable);
        this.mPostedOpenRunnable = null;
        return true;
    }

    public boolean hideSubMenus() {
        ActionButtonSubmenu r0 = this.mActionButtonPopup;
        if (r0 == null) goto L6;
        r0.dismiss();
        return true;
    L6:
        return false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r5, MenuBuilder r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        super.initForMenu(r7, r6);
        Resources r8 = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin");
        ActionBarPolicy r9 = ActionBarPolicy.get(r7);
        if (this.mReserveOverflowSet == true) goto L6;
        this.mReserveOverflow = r9.showsOverflowMenuButton();
    L6:
        if (this.mWidthLimitSet == true) goto L9;
        this.mWidthLimit = r9.getEmbeddedMenuWidthLimit();
    L9:
        if (this.mMaxItemsSet == true) goto L11;
        this.mMaxItems = r9.getMaxActionButtons();
    L11:
        int r10 = this.mWidthLimit;
        if (this.mReserveOverflow == true) goto L14;
        this.mOverflowButton = null;
    L21:
        this.mActionItemWidthLimit = r10;
        this.mMinCellSize = (int) (r8.getDisplayMetrics().density * 56.0f);
        return;
    L14:
        if (this.mOverflowButton != null) goto L19;
        OverflowMenuButton r0 = new OverflowMenuButton(this, this.mSystemContext);
        this.mOverflowButton = r0;
        if (this.mPendingOverflowIconSet == false) goto L18;
        r0.setImageDrawable(this.mPendingOverflowIcon);
        this.mPendingOverflowIcon = null;
        this.mPendingOverflowIconSet = false;
    L18:
        int r1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mOverflowButton.measure(r1, r1);
    L19:
        r10 = r10 - this.mOverflowButton.getMeasuredWidth();
        goto L21
    }

    public boolean isOverflowMenuShowPending() {
        if (this.mPostedOpenRunnable == null) goto L5;
    L8:
        return true;
    L5:
        if (isOverflowMenuShowing() == true) goto L8;
        return false;
    }

    public boolean isOverflowMenuShowing() {
        OverflowPopup r0 = this.mOverflowPopup;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() == false) goto L7;
        return true;
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r1, boolean r2) {
        dismissPopupMenus();
        super.onCloseMenu(r1, r2);
    }

    public void onConfigurationChanged(Configuration r1) {
        if (this.mMaxItemsSet == true) goto L6;
        this.mMaxItems = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
    L6:
        if (this.mMenu == null) goto L9;
        this.mMenu.onItemsChanged(true);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L5;
        return;
    L5:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.memorydata.plugin");
        if (r5.openSubMenuId <= 0) goto L11;
        MenuItem r6 = this.mMenu.findItem(r5.openSubMenuId);
        if (r6 == null) goto L12;
        onSubMenuSelected((SubMenuBuilder) ZeusTransformUtils.preCheckCast(r6.getSubMenu(), SubMenuBuilder.class, "com.obric.memorydata.plugin"));
        return;
    L12:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState();
        r0.openSubMenuId = this.mOpenSubMenuId;
        return r0;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r8) {
        boolean r1 = false;
        if (r8.hasVisibleItems() == true) goto L5;
        return false;
    L5:
        SubMenuBuilder r0 = r8;
    L7:
        if (r0.getParentMenu() == this.mMenu) goto L9;
        r0 = (SubMenuBuilder) ZeusTransformUtils.preCheckCast(r0.getParentMenu(), SubMenuBuilder.class, "com.obric.memorydata.plugin");
        goto L7
    L9:
        View r2 = findViewForItem(r0.getItem());
        if (r2 != null) goto L12;
        return false;
    L12:
        this.mOpenSubMenuId = r8.getItem().getItemId();
        int r3 = r8.size();
        int r4 = 0;
    L14:
        if (r4 >= r3) goto L21;
        MenuItem r5 = r8.getItem(r4);
        if (r5.isVisible() == false) goto L20;
        if (r5.getIcon() == null) goto L20;
        r1 = true;
    L20:
        r4 = r4 + 1;
    L21:
        ActionButtonSubmenu r6 = new ActionButtonSubmenu(this, this.mContext, r8, r2);
        this.mActionButtonPopup = r6;
        r6.setForceShowIcon(r1);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(r8);
        return true;
    }

    @Override // androidx.core.view.ActionProvider.SubUiVisibilityListener
    public void onSubUiVisibilityChanged(boolean r1) {
        if (r1 == false) goto L5;
        super.onSubMenuSelected(null);
        return;
    L5:
        if (this.mMenu == null) goto L9;
        this.mMenu.close(false);
        return;
    }

    public void setExpandedActionViewsExclusive(boolean r1) {
        this.mExpandedActionViewsExclusive = r1;
    }

    public void setItemLimit(int r1) {
        this.mMaxItems = r1;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView r1) {
        this.mMenuView = r1;
        r1.initialize(this.mMenu);
    }

    public void setOverflowIcon(Drawable r2) {
        OverflowMenuButton r0 = this.mOverflowButton;
        if (r0 == null) goto L5;
        r0.setImageDrawable(r2);
        return;
    L5:
        this.mPendingOverflowIconSet = true;
        this.mPendingOverflowIcon = r2;
    }

    public void setReserveOverflow(boolean r1) {
        this.mReserveOverflow = r1;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int r1, boolean r2) {
        this.mWidthLimit = r1;
        this.mStrictWidthLimit = r2;
        this.mWidthLimitSet = true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean shouldIncludeItem(int r1, MenuItemImpl r2) {
        return r2.isActionButton();
    }

    public boolean showOverflowMenu() {
        if (this.mReserveOverflow == true) goto L5;
        return false;
    L5:
        if (isOverflowMenuShowing() == false) goto L7;
        return false;
    L7:
        if (this.mMenu != null) goto L9;
        return false;
    L9:
        if (this.mMenuView != null) goto L11;
        return false;
    L11:
        if (this.mPostedOpenRunnable == null) goto L13;
        return false;
    L13:
        if (this.mMenu.getNonActionItems().isEmpty() == true) goto L22;
        this.mPostedOpenRunnable = new OpenOverflowRunnable(this, new OverflowPopup(this, this.mContext, this.mMenu, this.mOverflowButton, true));
        ((View) ZeusTransformUtils.preCheckCast(this.mMenuView, View.class, "com.obric.memorydata.plugin")).post(this.mPostedOpenRunnable);
        return true;
    L22:
        return false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r7) {
        super.updateMenuView(r7);
        ((View) ZeusTransformUtils.preCheckCast(this.mMenuView, View.class, "com.obric.memorydata.plugin")).requestLayout();
        boolean r0 = false;
        if (this.mMenu == null) goto L11;
        ArrayList<MenuItemImpl> r8 = this.mMenu.getActionItems();
        int r2 = r8.size();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        ActionProvider r4 = ((MenuItemImpl) ZeusTransformUtils.preCheckCast(r8.get(r3), MenuItemImpl.class, "com.obric.memorydata.plugin")).getSupportActionProvider();
        if (r4 == null) goto L9;
        r4.setSubUiVisibilityListener(this);
    L9:
        r3 = r3 + 1;
    L11:
        if (this.mMenu == null) goto L13;
        ArrayList<MenuItemImpl> r9 = this.mMenu.getNonActionItems();
    L15:
        if (this.mReserveOverflow == false) goto L22;
        if (r9 == null) goto L22;
        int r5 = r9.size();
        if (r5 != 1) goto L20;
        r0 = !((MenuItemImpl) ZeusTransformUtils.preCheckCast(r9.get(0), MenuItemImpl.class, "com.obric.memorydata.plugin")).isActionViewExpanded();
        goto L22
    L20:
        if (r5 <= 0) goto L22;
        r0 = true;
    L22:
        OverflowMenuButton r10 = this.mOverflowButton;
        if (r0 == false) goto L31;
        if (r10 != null) goto L26;
        this.mOverflowButton = new OverflowMenuButton(this, this.mSystemContext);
    L26:
        ViewGroup r11 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.mOverflowButton.getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
        if (r11 == this.mMenuView) goto L35;
        if (r11 == null) goto L30;
        r11.removeView(this.mOverflowButton);
    L30:
        ActionMenuView r12 = (ActionMenuView) ZeusTransformUtils.preCheckCast(this.mMenuView, ActionMenuView.class, "com.obric.memorydata.plugin");
        r12.addView(this.mOverflowButton, r12.generateOverflowButtonLayoutParams());
    L35:
        ((ActionMenuView) ZeusTransformUtils.preCheckCast(this.mMenuView, ActionMenuView.class, "com.obric.memorydata.plugin")).setOverflowReserved(this.mReserveOverflow);
        return;
    L31:
        if (r10 == null) goto L35;
        if (r10.getParent() != this.mMenuView) goto L35;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(this.mMenuView, ViewGroup.class, "com.obric.memorydata.plugin")).removeView(this.mOverflowButton);
        goto L35
    L13:
        r9 = null;
        goto L15
    }
}
