package androidx.appcompat.widget;

import android.annotation.SuppressLint;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
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

        public ActionButtonSubmenu(ActionMenuPresenter r10, Context r11, SubMenuBuilder r12, View r13) {
            this.this$0 = r10;
            super(r11, r12, r13, false, R.attr.actionOverflowMenuStyle);
            if (((MenuItemImpl) r12.getItem()).isActionButton() == true) goto L8;
            View r14 = r10.mOverflowButton;
            if (r14 != null) goto L7;
            r14 = (View) ActionMenuPresenter.access$200(r10);
        L7:
            setAnchorView(r14);
        L8:
            setPresenterCallback(r10.mPopupPresenterCallback);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        protected void onDismiss() {
            ActionMenuPresenter r10 = this.this$0;
            r10.mActionButtonPopup = null;
            r10.mOpenSubMenuId = 0;
            super.onDismiss();
        }
    }

    private class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        final /* synthetic */ ActionMenuPresenter this$0;

        ActionMenuPopupCallback(ActionMenuPresenter r10) {
            this.this$0 = r10;
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback
        public ShowableListMenu getPopup() {
            ActionButtonSubmenu r10 = this.this$0.mActionButtonPopup;
            if (r10 != null) goto L7;
            return null;
        L7:
            return r10.getPopup();
        }
    }

    private class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;
        final /* synthetic */ ActionMenuPresenter this$0;

        public OpenOverflowRunnable(ActionMenuPresenter r10, OverflowPopup r11) {
            this.this$0 = r10;
            this.mPopup = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.access$400(this.this$0) == null) goto L5;
            ActionMenuPresenter.access$500(this.this$0).changeMenuMode();
        L5:
            View r10 = (View) ActionMenuPresenter.access$600(this.this$0);
            if (r10 != null) goto L8;
        L12:
            this.this$0.mPostedOpenRunnable = null;
            return;
        L8:
            if (r10.getWindowToken() == null) goto L12;
            if (this.mPopup.tryShow() == false) goto L12;
            ActionMenuPresenter r11 = this.this$0;
            r11.mOverflowPopup = this.mPopup;
            goto L12
        }
    }

    private class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        final /* synthetic */ ActionMenuPresenter this$0;

        public OverflowMenuButton(final ActionMenuPresenter r10, Context r11) {
            this.this$0 = r10;
            super(r11, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new AnonymousClass1(this, this, r10));
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
        protected boolean setFrame(int r10, int r11, int r12, int r13) {
            boolean r14 = super.setFrame(r10, r11, r12, r13);
            Drawable r15 = getDrawable();
            Drawable r16 = getBackground();
            if (r15 == null) goto L6;
            if (r16 == null) goto L6;
            int r17 = getWidth();
            int r18 = getHeight();
            int r19 = Math.max(r17, r18) / 2;
            int r20 = getPaddingLeft() - getPaddingRight();
            int r21 = (r17 + r20) / 2;
            int r22 = (r18 + (getPaddingTop() - getPaddingBottom())) / 2;
            DrawableCompat.setHotspotBounds(r16, r21 - r19, r22 - r19, r21 + r19, r22 + r19);
        L6:
            return r14;
        }
    }

    private class OverflowPopup extends MenuPopupHelper {
        final /* synthetic */ ActionMenuPresenter this$0;

        public OverflowPopup(ActionMenuPresenter r10, Context r11, MenuBuilder r12, View r13, boolean r14) {
            this.this$0 = r10;
            super(r11, r12, r13, r14, R.attr.actionOverflowMenuStyle);
            setGravity(GravityCompat.END);
            setPresenterCallback(r10.mPopupPresenterCallback);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        protected void onDismiss() {
            if (ActionMenuPresenter.access$000(this.this$0) == null) goto L5;
            ActionMenuPresenter.access$100(this.this$0).close();
        L5:
            this.this$0.mOverflowPopup = null;
            super.onDismiss();
        }
    }

    private class PopupPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ ActionMenuPresenter this$0;

        PopupPresenterCallback(ActionMenuPresenter r10) {
            this.this$0 = r10;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder r10, boolean r11) {
            if ((r10 instanceof SubMenuBuilder) == false) goto L5;
            r10.getRootMenu().close(false);
        L5:
            MenuPresenter.Callback r12 = this.this$0.getCallback();
            if (r12 == null) goto L9;
            r12.onCloseMenu(r10, r11);
            return;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder r10) {
            if (r10 != ActionMenuPresenter.access$300(this.this$0)) goto L5;
            return false;
        L5:
            ActionMenuPresenter r11 = this.this$0;
            r11.mOpenSubMenuId = ((SubMenuBuilder) r10).getItem().getItemId();
            MenuPresenter.Callback r12 = this.this$0.getCallback();
            if (r12 != null) goto L8;
            return false;
        L8:
            return r12.onOpenSubMenu(r10);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int openSubMenuId;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState() {
        }

        SavedState(Parcel r10) {
            this.openSubMenuId = r10.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeInt(this.openSubMenuId);
        }
    }

    public ActionMenuPresenter(Context r10) {
        super(r10, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.mActionButtonGroups = new SparseBooleanArray();
        this.mPopupPresenterCallback = new PopupPresenterCallback(this);
    }

    static /* synthetic */ MenuBuilder access$000(ActionMenuPresenter r10) {
        return r10.mMenu;
    }

    static /* synthetic */ MenuBuilder access$100(ActionMenuPresenter r10) {
        return r10.mMenu;
    }

    static /* synthetic */ MenuView access$200(ActionMenuPresenter r10) {
        return r10.mMenuView;
    }

    static /* synthetic */ MenuBuilder access$300(ActionMenuPresenter r10) {
        return r10.mMenu;
    }

    static /* synthetic */ MenuBuilder access$400(ActionMenuPresenter r10) {
        return r10.mMenu;
    }

    static /* synthetic */ MenuBuilder access$500(ActionMenuPresenter r10) {
        return r10.mMenu;
    }

    static /* synthetic */ MenuView access$600(ActionMenuPresenter r10) {
        return r10.mMenuView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View findViewForItem(MenuItem r10) {
        ViewGroup r11 = (ViewGroup) this.mMenuView;
        if (r11 != null) goto L5;
        return null;
    L5:
        int r12 = r11.getChildCount();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L13;
        View r14 = r11.getChildAt(r13);
        if ((r14 instanceof MenuView.ItemView) == false) goto L12;
        if (((MenuView.ItemView) r14).getItemData() != r10) goto L12;
        return r14;
    L12:
        r13 = r13 + 1;
        goto L6
    L13:
        return null;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public void bindItemView(MenuItemImpl r10, MenuView.ItemView r11) {
        r11.initialize(r10, 0);
        ActionMenuItemView r12 = (ActionMenuItemView) r11;
        r12.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.mPopupCallback != null) goto L5;
        this.mPopupCallback = new ActionMenuPopupCallback(this);
    L5:
        r12.setPopupCallback(this.mPopupCallback);
    }

    public boolean dismissPopupMenus() {
        boolean r10 = hideOverflowMenu();
        return hideSubMenus() | r10;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean filterLeftoverView(ViewGroup r10, int r11) {
        if (r10.getChildAt(r11) != this.mOverflowButton) goto L7;
        return false;
    L7:
        return super.filterLeftoverView(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.ActionMenuPresenter] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r15v1, types: [androidx.appcompat.view.menu.MenuItemImpl] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        ActionMenuPresenter r10 = this;
        MenuBuilder r11 = r10.mMenu;
        View r12 = null;
        ?? r13 = 0;
        if (r11 == null) goto L5;
        ArrayList<MenuItemImpl> r14 = r11.getVisibleItems();
        int r15 = r14.size();
    L6:
        int r16 = r10.mMaxItems;
        int r17 = r10.mActionItemWidthLimit;
        int r18 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup r19 = (ViewGroup) r10.mMenuView;
        int r20 = 0;
        boolean r110 = false;
        int r111 = 0;
        int r112 = 0;
    L7:
        if (r20 >= r15) goto L22;
        MenuItemImpl r113 = r14.get(r20);
        if (r113.requiresActionButton() == false) goto L12;
        r111 = r111 + 1;
    L16:
        if (r10.mExpandedActionViewsExclusive == false) goto L20;
        if (r113.isActionViewExpanded() == false) goto L20;
        r16 = 0;
    L20:
        r20 = r20 + 1;
        goto L7
    L12:
        if (r113.requestsActionButton() == false) goto L14;
        r112 = r112 + 1;
        goto L16
    L14:
        r110 = true;
        goto L16
    L22:
        if (r10.mReserveOverflow == false) goto L27;
        if (r110 == false) goto L25;
    L26:
        r16 = r16 - 1;
        goto L27
    L25:
        if ((r112 + r111) > r16) goto L26;
    L27:
        int r21 = r16 - r111;
        SparseBooleanArray r22 = r10.mActionButtonGroups;
        r22.clear();
        if (r10.mStrictWidthLimit == false) goto L30;
        int r114 = r10.mMinCellSize;
        int r115 = r17 / r114;
        int r116 = r114 + ((r17 % r114) / r115);
    L31:
        int r117 = 0;
        int r118 = 0;
        ?? r23 = r10;
    L32:
        if (r117 >= r15) goto L95;
        MenuItemImpl r119 = r14.get(r117);
        if (r119.requiresActionButton() == false) goto L47;
        View r120 = r23.getItemView(r119, r12, r19);
        if (r23.mStrictWidthLimit == false) goto L38;
        r115 = r115 - ActionMenuView.measureChildForCells(r120, r116, r115, r18, r13);
    L39:
        int r24 = r120.getMeasuredWidth();
        r17 = r17 - r24;
        if (r118 != 0) goto L42;
        r118 = r24;
    L42:
        int r25 = r119.getGroupId();
        if (r25 == 0) goto L45;
        r22.put(r25, true);
    L45:
        r119.setIsActionButton(true);
        ?? r26 = r13;
    L94:
        r117 = r117 + 1;
        r13 = r26;
        r15 = r15;
        r12 = null;
        r23 = this;
        goto L32
    L38:
        r120.measure(r18, r18);
        goto L39
    L47:
        if (r119.requestsActionButton() == false) goto L93;
        int r27 = r119.getGroupId();
        boolean r121 = r22.get(r27);
        if (r21 > 0) goto L51;
        if (r121 == true) goto L51;
    L56:
        boolean r28 = false;
    L57:
        boolean r122 = r28;
        if (r28 == false) goto L77;
        View r29 = r23.getItemView(r119, null, r19);
        if (r23.mStrictWidthLimit == false) goto L64;
        int r123 = ActionMenuView.measureChildForCells(r29, r116, r115, r18, 0);
        r115 = r115 - r123;
        if (r123 != 0) goto L65;
        r122 = false;
    L65:
        boolean r30 = r122;
        int r31 = r29.getMeasuredWidth();
        r17 = r17 - r31;
        if (r118 != 0) goto L69;
        r118 = r31;
    L69:
        if (r23.mStrictWidthLimit == false) goto L73;
        if (r17 >= 0) goto L74;
    L75:
        boolean r32 = false;
    L76:
        r28 = r30 & r32;
    L74:
        r32 = true;
        goto L76
    L73:
        if ((r17 + r118) <= 0) goto L75;
    L64:
        r29.measure(r18, r18);
    L77:
        if (r28 == false) goto L80;
        if (r27 == 0) goto L80;
        r22.put(r27, true);
    L90:
        if (r28 == false) goto L92;
        r21 = r21 - 1;
    L92:
        r119.setIsActionButton(r28);
        r26 = 0;
    L80:
        if (r121 == false) goto L90;
        r22.put(r27, false);
        int r33 = 0;
    L82:
        if (r33 >= r117) goto L90;
        MenuItemImpl r124 = r14.get(r33);
        if (r124.getGroupId() != r27) goto L89;
        if (r124.isActionButton() == false) goto L88;
        r21 = r21 + 1;
    L88:
        r124.setIsActionButton(false);
    L89:
        r33 = r33 + 1;
    L51:
        if (r17 <= 0) goto L56;
        if (r23.mStrictWidthLimit == false) goto L55;
        if (r115 <= 0) goto L56;
    L55:
        r28 = true;
        goto L57
    L93:
        r26 = r13;
        r119.setIsActionButton(r26);
        goto L94
    L95:
        return true;
    L30:
        r116 = 0;
        r115 = 0;
        goto L31
    L5:
        r14 = null;
        r15 = 0;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public View getItemView(MenuItemImpl r10, View r11, ViewGroup r12) {
        View r13 = r10.getActionView();
        if (r13 != null) goto L5;
    L6:
        r13 = super.getItemView(r10, r11, r12);
    L8:
        if (r10.isActionViewExpanded() == false) goto L10;
        int r14 = 8;
    L11:
        r13.setVisibility(r14);
        ActionMenuView r15 = (ActionMenuView) r12;
        ViewGroup.LayoutParams r16 = r13.getLayoutParams();
        if (r15.checkLayoutParams(r16) == true) goto L14;
        r13.setLayoutParams(r15.generateLayoutParams(r16));
    L14:
        return r13;
    L10:
        r14 = 0;
        goto L11
    L5:
        if (r10.hasCollapsibleActionView() == false) goto L8;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r10) {
        MenuView r11 = this.mMenuView;
        MenuView r12 = super.getMenuView(r10);
        if (r11 == r12) goto L5;
        ((ActionMenuView) r12).setPresenter(this);
    L5:
        return r12;
    }

    public Drawable getOverflowIcon() {
        OverflowMenuButton r10 = this.mOverflowButton;
        if (r10 == null) goto L7;
        return r10.getDrawable();
    L7:
        if (this.mPendingOverflowIconSet == true) goto L9;
        return null;
    L9:
        return this.mPendingOverflowIcon;
    }

    public boolean hideOverflowMenu() {
        OpenOverflowRunnable r10 = this.mPostedOpenRunnable;
        if (r10 == null) goto L8;
        Object r11 = this.mMenuView;
        if (r11 == null) goto L8;
        ((View) r11).removeCallbacks(r10);
        this.mPostedOpenRunnable = null;
        return true;
    L8:
        OverflowPopup r12 = this.mOverflowPopup;
        if (r12 == null) goto L12;
        r12.dismiss();
        return true;
    L12:
        return false;
    }

    public boolean hideSubMenus() {
        ActionButtonSubmenu r10 = this.mActionButtonPopup;
        if (r10 == null) goto L6;
        r10.dismiss();
        return true;
    L6:
        return false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context r10, @Nullable MenuBuilder r11) {
        super.initForMenu(r10, r11);
        Resources r12 = r10.getResources();
        ActionBarPolicy r13 = ActionBarPolicy.get(r10);
        if (this.mReserveOverflowSet == true) goto L6;
        this.mReserveOverflow = r13.showsOverflowMenuButton();
    L6:
        if (this.mWidthLimitSet == true) goto L9;
        this.mWidthLimit = r13.getEmbeddedMenuWidthLimit();
    L9:
        if (this.mMaxItemsSet == true) goto L11;
        this.mMaxItems = r13.getMaxActionButtons();
    L11:
        int r14 = this.mWidthLimit;
        if (this.mReserveOverflow == true) goto L14;
        this.mOverflowButton = null;
    L21:
        this.mActionItemWidthLimit = r14;
        this.mMinCellSize = (int) (r12.getDisplayMetrics().density * 56.0f);
        return;
    L14:
        if (this.mOverflowButton != null) goto L19;
        OverflowMenuButton r15 = new OverflowMenuButton(this, this.mSystemContext);
        this.mOverflowButton = r15;
        if (this.mPendingOverflowIconSet == false) goto L18;
        r15.setImageDrawable(this.mPendingOverflowIcon);
        this.mPendingOverflowIcon = null;
        this.mPendingOverflowIconSet = false;
    L18:
        int r16 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mOverflowButton.measure(r16, r16);
    L19:
        r14 = r14 - this.mOverflowButton.getMeasuredWidth();
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
        OverflowPopup r10 = this.mOverflowPopup;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isShowing() == false) goto L7;
        return true;
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r10, boolean r11) {
        dismissPopupMenus();
        super.onCloseMenu(r10, r11);
    }

    public void onConfigurationChanged(Configuration r10) {
        if (this.mMaxItemsSet == true) goto L5;
        this.mMaxItems = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
    L5:
        MenuBuilder r11 = this.mMenu;
        if (r11 == null) goto L9;
        r11.onItemsChanged(true);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L5;
        return;
    L5:
        int r11 = ((SavedState) r10).openSubMenuId;
        if (r11 <= 0) goto L11;
        MenuItem r12 = this.mMenu.findItem(r11);
        if (r12 == null) goto L12;
        onSubMenuSelected((SubMenuBuilder) r12.getSubMenu());
        return;
    L12:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState();
        r10.openSubMenuId = this.mOpenSubMenuId;
        return r10;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r10) {
        boolean r11 = false;
        if (r10.hasVisibleItems() == true) goto L5;
        return false;
    L5:
        SubMenuBuilder r12 = r10;
    L7:
        if (r12.getParentMenu() == this.mMenu) goto L9;
        r12 = (SubMenuBuilder) r12.getParentMenu();
        goto L7
    L9:
        View r13 = findViewForItem(r12.getItem());
        if (r13 != null) goto L12;
        return false;
    L12:
        this.mOpenSubMenuId = r10.getItem().getItemId();
        int r14 = r10.size();
        int r15 = 0;
    L14:
        if (r15 >= r14) goto L21;
        MenuItem r16 = r10.getItem(r15);
        if (r16.isVisible() == false) goto L20;
        if (r16.getIcon() == null) goto L20;
        r11 = true;
    L20:
        r15 = r15 + 1;
    L21:
        ActionButtonSubmenu r17 = new ActionButtonSubmenu(this, this.mContext, r10, r13);
        this.mActionButtonPopup = r17;
        r17.setForceShowIcon(r11);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(r10);
        return true;
    }

    @Override // androidx.core.view.ActionProvider.SubUiVisibilityListener
    public void onSubUiVisibilityChanged(boolean r10) {
        if (r10 == false) goto L4;
        super.onSubMenuSelected(null);
        return;
    L4:
        MenuBuilder r11 = this.mMenu;
        if (r11 == null) goto L9;
        r11.close(false);
        return;
    }

    public void setExpandedActionViewsExclusive(boolean r10) {
        this.mExpandedActionViewsExclusive = r10;
    }

    public void setItemLimit(int r10) {
        this.mMaxItems = r10;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView r10) {
        this.mMenuView = r10;
        r10.initialize(this.mMenu);
    }

    public void setOverflowIcon(Drawable r10) {
        OverflowMenuButton r11 = this.mOverflowButton;
        if (r11 == null) goto L5;
        r11.setImageDrawable(r10);
        return;
    L5:
        this.mPendingOverflowIconSet = true;
        this.mPendingOverflowIcon = r10;
    }

    public void setReserveOverflow(boolean r10) {
        this.mReserveOverflow = r10;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int r10, boolean r11) {
        this.mWidthLimit = r10;
        this.mStrictWidthLimit = r11;
        this.mWidthLimitSet = true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean shouldIncludeItem(int r10, MenuItemImpl r11) {
        return r11.isActionButton();
    }

    public boolean showOverflowMenu() {
        if (this.mReserveOverflow == true) goto L5;
        return false;
    L5:
        if (isOverflowMenuShowing() == true) goto L18;
        MenuBuilder r10 = this.mMenu;
        if (r10 != null) goto L9;
        return false;
    L9:
        if (this.mMenuView != null) goto L11;
        return false;
    L11:
        if (this.mPostedOpenRunnable == null) goto L13;
        return false;
    L13:
        if (r10.getNonActionItems().isEmpty() == true) goto L22;
        OpenOverflowRunnable r11 = new OpenOverflowRunnable(this, new OverflowPopup(this, this.mContext, this.mMenu, this.mOverflowButton, true));
        this.mPostedOpenRunnable = r11;
        ((View) this.mMenuView).post(r11);
        return true;
    L22:
        return false;
    L18:
        return false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r10) {
        super.updateMenuView(r10);
        ((View) this.mMenuView).requestLayout();
        MenuBuilder r11 = this.mMenu;
        boolean r12 = false;
        if (r11 == null) goto L10;
        ArrayList<MenuItemImpl> r13 = r11.getActionItems();
        int r14 = r13.size();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L10;
        ActionProvider r16 = r13.get(r15).getSupportActionProvider();
        if (r16 == null) goto L9;
        r16.setSubUiVisibilityListener(this);
    L9:
        r15 = r15 + 1;
    L10:
        MenuBuilder r17 = this.mMenu;
        if (r17 == null) goto L13;
        ArrayList<MenuItemImpl> r18 = r17.getNonActionItems();
    L15:
        if (this.mReserveOverflow == false) goto L22;
        if (r18 == null) goto L22;
        int r19 = r18.size();
        if (r19 != 1) goto L20;
        r12 = !r18.get(0).isActionViewExpanded();
        goto L22
    L20:
        if (r19 <= 0) goto L22;
        r12 = true;
    L22:
        OverflowMenuButton r20 = this.mOverflowButton;
        if (r12 == false) goto L31;
        if (r20 != null) goto L26;
        this.mOverflowButton = new OverflowMenuButton(this, this.mSystemContext);
    L26:
        ViewGroup r21 = (ViewGroup) this.mOverflowButton.getParent();
        if (r21 == this.mMenuView) goto L35;
        if (r21 == null) goto L30;
        r21.removeView(this.mOverflowButton);
    L30:
        ActionMenuView r22 = (ActionMenuView) this.mMenuView;
        r22.addView(this.mOverflowButton, r22.generateOverflowButtonLayoutParams());
    L35:
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
        return;
    L31:
        if (r20 == null) goto L35;
        Object r23 = r20.getParent();
        Object r24 = this.mMenuView;
        if (r23 != r24) goto L35;
        ((ViewGroup) r24).removeView(this.mOverflowButton);
        goto L35
    L13:
        r18 = null;
        goto L15
    }
}
