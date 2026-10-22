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

    public class ActionButtonSubmenu extends MenuPopupHelper {
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
        public void onDismiss() {
            ActionMenuPresenter r5 = this.this$0;
            r5.mActionButtonPopup = null;
            r5.mOpenSubMenuId = 0;
            super.onDismiss();
        }
    }

    public class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        final /* synthetic */ ActionMenuPresenter this$0;

        public ActionMenuPopupCallback(ActionMenuPresenter r5) {
            this.this$0 = r5;
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback
        public ShowableListMenu getPopup() {
            ActionButtonSubmenu r5 = this.this$0.mActionButtonPopup;
            if (r5 != null) goto L7;
            return null;
        L7:
            return r5.getPopup();
        }
    }

    public class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;
        final /* synthetic */ ActionMenuPresenter this$0;

        public OpenOverflowRunnable(ActionMenuPresenter r5, OverflowPopup r10) {
            this.this$0 = r5;
            this.mPopup = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.access$400(this.this$0) == null) goto L5;
            ActionMenuPresenter.access$500(this.this$0).changeMenuMode();
        L5:
            View r5 = (View) ActionMenuPresenter.access$600(this.this$0);
            if (r5 != null) goto L8;
        L12:
            this.this$0.mPostedOpenRunnable = null;
            return;
        L8:
            if (r5.getWindowToken() == null) goto L12;
            if (this.mPopup.tryShow() == false) goto L12;
            ActionMenuPresenter r10 = this.this$0;
            r10.mOverflowPopup = this.mPopup;
            goto L12
        }
    }

    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        final /* synthetic */ ActionMenuPresenter this$0;

        public OverflowMenuButton(final ActionMenuPresenter r5, Context r10) {
            this.this$0 = r5;
            super(r10, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new AnonymousClass1(this, this, r5));
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
        public boolean setFrame(int r5, int r10, int r11, int r12) {
            boolean r13 = super.setFrame(r5, r10, r11, r12);
            Drawable r14 = getDrawable();
            Drawable r15 = getBackground();
            if (r14 == null) goto L6;
            if (r15 == null) goto L6;
            int r16 = getWidth();
            int r17 = getHeight();
            int r18 = Math.max(r16, r17) / 2;
            int r19 = getPaddingLeft() - getPaddingRight();
            int r20 = (r16 + r19) / 2;
            int r21 = (r17 + (getPaddingTop() - getPaddingBottom())) / 2;
            DrawableCompat.setHotspotBounds(r15, r20 - r18, r21 - r18, r20 + r18, r21 + r18);
        L6:
            return r13;
        }
    }

    public class OverflowPopup extends MenuPopupHelper {
        final /* synthetic */ ActionMenuPresenter this$0;

        public OverflowPopup(ActionMenuPresenter r10, Context r11, MenuBuilder r12, View r13, boolean r14) {
            this.this$0 = r10;
            super(r11, r12, r13, r14, R.attr.actionOverflowMenuStyle);
            setGravity(GravityCompat.END);
            setPresenterCallback(r10.mPopupPresenterCallback);
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

    public class PopupPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ ActionMenuPresenter this$0;

        public PopupPresenterCallback(ActionMenuPresenter r5) {
            this.this$0 = r5;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder r5, boolean r10) {
            if ((r5 instanceof SubMenuBuilder) == false) goto L5;
            r5.getRootMenu().close(false);
        L5:
            MenuPresenter.Callback r11 = this.this$0.getCallback();
            if (r11 == null) goto L9;
            r11.onCloseMenu(r5, r10);
            return;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder r5) {
            if (r5 != ActionMenuPresenter.access$300(this.this$0)) goto L5;
            return false;
        L5:
            ActionMenuPresenter r10 = this.this$0;
            r10.mOpenSubMenuId = ((SubMenuBuilder) r5).getItem().getItemId();
            MenuPresenter.Callback r11 = this.this$0.getCallback();
            if (r11 != null) goto L8;
            return false;
        L8:
            return r11.onOpenSubMenu(r5);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int openSubMenuId;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            r5.writeInt(this.openSubMenuId);
        }

        public SavedState(Parcel r5) {
            this.openSubMenuId = r5.readInt();
        }
    }

    public ActionMenuPresenter(Context r5) {
        super(r5, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.mActionButtonGroups = new SparseBooleanArray();
        this.mPopupPresenterCallback = new PopupPresenterCallback(this);
    }

    public static /* synthetic */ MenuBuilder access$000(ActionMenuPresenter r5) {
        return r5.mMenu;
    }

    public static /* synthetic */ MenuBuilder access$100(ActionMenuPresenter r5) {
        return r5.mMenu;
    }

    public static /* synthetic */ MenuView access$200(ActionMenuPresenter r5) {
        return r5.mMenuView;
    }

    public static /* synthetic */ MenuBuilder access$300(ActionMenuPresenter r5) {
        return r5.mMenu;
    }

    public static /* synthetic */ MenuBuilder access$400(ActionMenuPresenter r5) {
        return r5.mMenu;
    }

    public static /* synthetic */ MenuBuilder access$500(ActionMenuPresenter r5) {
        return r5.mMenu;
    }

    public static /* synthetic */ MenuView access$600(ActionMenuPresenter r5) {
        return r5.mMenuView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View findViewForItem(MenuItem r10) {
        ViewGroup r5 = (ViewGroup) this.mMenuView;
        if (r5 != null) goto L5;
        return null;
    L5:
        int r11 = r5.getChildCount();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L13;
        View r13 = r5.getChildAt(r12);
        if ((r13 instanceof MenuView.ItemView) == false) goto L12;
        if (((MenuView.ItemView) r13).getItemData() != r10) goto L12;
        return r13;
    L12:
        r12 = r12 + 1;
        goto L6
    L13:
        return null;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public void bindItemView(MenuItemImpl r5, MenuView.ItemView r10) {
        r10.initialize(r5, 0);
        ActionMenuItemView r11 = (ActionMenuItemView) r10;
        r11.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.mPopupCallback != null) goto L5;
        this.mPopupCallback = new ActionMenuPopupCallback(this);
    L5:
        r11.setPopupCallback(this.mPopupCallback);
    }

    public boolean dismissPopupMenus() {
        boolean r5 = hideOverflowMenu();
        return hideSubMenus() | r5;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean filterLeftoverView(ViewGroup r5, int r10) {
        if (r5.getChildAt(r10) != this.mOverflowButton) goto L7;
        return false;
    L7:
        return super.filterLeftoverView(r5, r10);
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
        ActionMenuPresenter r5 = this;
        MenuBuilder r10 = r5.mMenu;
        View r11 = null;
        ?? r12 = 0;
        if (r10 == null) goto L5;
        ArrayList<MenuItemImpl> r13 = r10.getVisibleItems();
        int r14 = r13.size();
    L6:
        int r15 = r5.mMaxItems;
        int r16 = r5.mActionItemWidthLimit;
        int r17 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup r18 = (ViewGroup) r5.mMenuView;
        int r19 = 0;
        boolean r110 = false;
        int r111 = 0;
        int r112 = 0;
    L7:
        if (r19 >= r14) goto L22;
        MenuItemImpl r113 = r13.get(r19);
        if (r113.requiresActionButton() == false) goto L12;
        r111 = r111 + 1;
    L16:
        if (r5.mExpandedActionViewsExclusive == false) goto L20;
        if (r113.isActionViewExpanded() == false) goto L20;
        r15 = 0;
    L20:
        r19 = r19 + 1;
        goto L7
    L12:
        if (r113.requestsActionButton() == false) goto L14;
        r112 = r112 + 1;
        goto L16
    L14:
        r110 = true;
        goto L16
    L22:
        if (r5.mReserveOverflow == false) goto L27;
        if (r110 == false) goto L25;
    L26:
        r15 = r15 - 1;
        goto L27
    L25:
        if ((r112 + r111) > r15) goto L26;
    L27:
        int r20 = r15 - r111;
        SparseBooleanArray r21 = r5.mActionButtonGroups;
        r21.clear();
        if (r5.mStrictWidthLimit == false) goto L30;
        int r114 = r5.mMinCellSize;
        int r115 = r16 / r114;
        int r116 = ((r16 % r114) / r115) + r114;
    L31:
        int r117 = 0;
        int r118 = 0;
        ?? r22 = r5;
    L32:
        if (r117 >= r14) goto L96;
        MenuItemImpl r119 = r13.get(r117);
        if (r119.requiresActionButton() == false) goto L47;
        View r120 = r22.getItemView(r119, r11, r18);
        if (r22.mStrictWidthLimit == false) goto L38;
        r115 = r115 - ActionMenuView.measureChildForCells(r120, r116, r115, r17, r12);
    L39:
        int r23 = r120.getMeasuredWidth();
        r16 = r16 - r23;
        if (r118 != 0) goto L42;
        r118 = r23;
    L42:
        int r24 = r119.getGroupId();
        if (r24 == 0) goto L45;
        r21.put(r24, true);
    L45:
        r119.setIsActionButton(true);
        ?? r25 = r12;
    L95:
        r117 = r117 + 1;
        r12 = r25;
        r14 = r14;
        r11 = null;
        r22 = this;
        goto L32
    L38:
        r120.measure(r17, r17);
        goto L39
    L47:
        if (r119.requestsActionButton() == false) goto L94;
        int r26 = r119.getGroupId();
        boolean r121 = r21.get(r26);
        if (r20 > 0) goto L51;
        if (r121 == true) goto L51;
    L56:
        boolean r27 = false;
    L57:
        boolean r122 = r27;
        if (r27 == false) goto L78;
        View r28 = r22.getItemView(r119, null, r18);
        if (r22.mStrictWidthLimit == false) goto L65;
        int r123 = ActionMenuView.measureChildForCells(r28, r116, r115, r17, 0);
        r115 = r115 - r123;
        if (r123 != 0) goto L64;
        r122 = false;
    L64:
        boolean r29 = r122;
        int r30 = r28.getMeasuredWidth();
        r16 = r16 - r30;
        if (r118 != 0) goto L70;
        r118 = r30;
    L70:
        if (r22.mStrictWidthLimit == false) goto L76;
        if (r16 < 0) goto L73;
    L72:
        boolean r31 = true;
    L74:
        r27 = r29 & r31;
    L73:
        r31 = false;
        goto L74
    L76:
        if ((r16 + r118) <= 0) goto L73;
    L65:
        r28.measure(r17, r17);
    L78:
        if (r27 == false) goto L81;
        if (r26 == 0) goto L81;
        r21.put(r26, true);
    L91:
        if (r27 == false) goto L93;
        r20 = r20 - 1;
    L93:
        r119.setIsActionButton(r27);
        r25 = 0;
    L81:
        if (r121 == false) goto L91;
        r21.put(r26, false);
        int r32 = 0;
    L83:
        if (r32 >= r117) goto L91;
        MenuItemImpl r124 = r13.get(r32);
        if (r124.getGroupId() != r26) goto L90;
        if (r124.isActionButton() == false) goto L89;
        r20 = r20 + 1;
    L89:
        r124.setIsActionButton(false);
    L90:
        r32 = r32 + 1;
    L51:
        if (r16 <= 0) goto L56;
        if (r22.mStrictWidthLimit == false) goto L55;
        if (r115 <= 0) goto L56;
    L55:
        r27 = true;
        goto L57
    L94:
        r25 = r12;
        r119.setIsActionButton(r25);
        goto L95
    L96:
        return true;
    L30:
        r115 = 0;
        r116 = 0;
        goto L31
    L5:
        r13 = null;
        r14 = 0;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public View getItemView(MenuItemImpl r5, View r10, ViewGroup r11) {
        View r12 = r5.getActionView();
        if (r12 != null) goto L5;
    L6:
        r12 = super.getItemView(r5, r10, r11);
    L8:
        if (r5.isActionViewExpanded() == false) goto L10;
        int r13 = 8;
    L11:
        r12.setVisibility(r13);
        ActionMenuView r14 = (ActionMenuView) r11;
        ViewGroup.LayoutParams r15 = r12.getLayoutParams();
        if (r14.checkLayoutParams(r15) == true) goto L14;
        r12.setLayoutParams(r14.generateLayoutParams(r15));
    L14:
        return r12;
    L10:
        r13 = 0;
        goto L11
    L5:
        if (r5.hasCollapsibleActionView() == false) goto L8;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r5) {
        MenuView r10 = this.mMenuView;
        MenuView r11 = super.getMenuView(r5);
        if (r10 == r11) goto L5;
        ((ActionMenuView) r11).setPresenter(this);
    L5:
        return r11;
    }

    public Drawable getOverflowIcon() {
        OverflowMenuButton r5 = this.mOverflowButton;
        if (r5 == null) goto L7;
        return r5.getDrawable();
    L7:
        if (this.mPendingOverflowIconSet == true) goto L9;
        return null;
    L9:
        return this.mPendingOverflowIcon;
    }

    public boolean hideOverflowMenu() {
        OpenOverflowRunnable r5 = this.mPostedOpenRunnable;
        if (r5 == null) goto L8;
        Object r10 = this.mMenuView;
        if (r10 == null) goto L8;
        ((View) r10).removeCallbacks(r5);
        this.mPostedOpenRunnable = null;
        return true;
    L8:
        OverflowPopup r11 = this.mOverflowPopup;
        if (r11 == null) goto L12;
        r11.dismiss();
        return true;
    L12:
        return false;
    }

    public boolean hideSubMenus() {
        ActionButtonSubmenu r5 = this.mActionButtonPopup;
        if (r5 == null) goto L6;
        r5.dismiss();
        return true;
    L6:
        return false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context r5, @Nullable MenuBuilder r10) {
        super.initForMenu(r5, r10);
        Resources r11 = r5.getResources();
        ActionBarPolicy r12 = ActionBarPolicy.get(r5);
        if (this.mReserveOverflowSet == true) goto L6;
        this.mReserveOverflow = r12.showsOverflowMenuButton();
    L6:
        if (this.mWidthLimitSet == true) goto L9;
        this.mWidthLimit = r12.getEmbeddedMenuWidthLimit();
    L9:
        if (this.mMaxItemsSet == true) goto L11;
        this.mMaxItems = r12.getMaxActionButtons();
    L11:
        int r13 = this.mWidthLimit;
        if (this.mReserveOverflow == true) goto L14;
        this.mOverflowButton = null;
    L21:
        this.mActionItemWidthLimit = r13;
        this.mMinCellSize = (int) (r11.getDisplayMetrics().density * 56.0f);
        return;
    L14:
        if (this.mOverflowButton != null) goto L19;
        OverflowMenuButton r14 = new OverflowMenuButton(this, this.mSystemContext);
        this.mOverflowButton = r14;
        if (this.mPendingOverflowIconSet == false) goto L18;
        r14.setImageDrawable(this.mPendingOverflowIcon);
        this.mPendingOverflowIcon = null;
        this.mPendingOverflowIconSet = false;
    L18:
        int r15 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mOverflowButton.measure(r15, r15);
    L19:
        r13 = r13 - this.mOverflowButton.getMeasuredWidth();
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
        OverflowPopup r5 = this.mOverflowPopup;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isShowing() == false) goto L7;
        return true;
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r5, boolean r10) {
        dismissPopupMenus();
        super.onCloseMenu(r5, r10);
    }

    public void onConfigurationChanged(Configuration r5) {
        if (this.mMaxItemsSet == true) goto L5;
        this.mMaxItems = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
    L5:
        MenuBuilder r10 = this.mMenu;
        if (r10 == null) goto L9;
        r10.onItemsChanged(true);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L5;
        return;
    L5:
        int r10 = ((SavedState) r5).openSubMenuId;
        if (r10 <= 0) goto L11;
        MenuItem r11 = this.mMenu.findItem(r10);
        if (r11 == null) goto L12;
        onSubMenuSelected((SubMenuBuilder) r11.getSubMenu());
        return;
    L12:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState();
        r5.openSubMenuId = this.mOpenSubMenuId;
        return r5;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r10) {
        boolean r5 = false;
        if (r10.hasVisibleItems() == true) goto L5;
        return false;
    L5:
        SubMenuBuilder r11 = r10;
    L7:
        if (r11.getParentMenu() == this.mMenu) goto L9;
        r11 = (SubMenuBuilder) r11.getParentMenu();
        goto L7
    L9:
        View r12 = findViewForItem(r11.getItem());
        if (r12 != null) goto L12;
        return false;
    L12:
        this.mOpenSubMenuId = r10.getItem().getItemId();
        int r13 = r10.size();
        int r14 = 0;
    L14:
        if (r14 >= r13) goto L21;
        MenuItem r15 = r10.getItem(r14);
        if (r15.isVisible() == false) goto L20;
        if (r15.getIcon() == null) goto L20;
        r5 = true;
    L20:
        r14 = r14 + 1;
    L21:
        ActionButtonSubmenu r16 = new ActionButtonSubmenu(this, this.mContext, r10, r12);
        this.mActionButtonPopup = r16;
        r16.setForceShowIcon(r5);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(r10);
        return true;
    }

    @Override // androidx.core.view.ActionProvider.SubUiVisibilityListener
    public void onSubUiVisibilityChanged(boolean r5) {
        if (r5 == false) goto L4;
        super.onSubMenuSelected(null);
        return;
    L4:
        MenuBuilder r10 = this.mMenu;
        if (r10 == null) goto L9;
        r10.close(false);
        return;
    }

    public void setExpandedActionViewsExclusive(boolean r5) {
        this.mExpandedActionViewsExclusive = r5;
    }

    public void setItemLimit(int r5) {
        this.mMaxItems = r5;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView r5) {
        this.mMenuView = r5;
        r5.initialize(this.mMenu);
    }

    public void setOverflowIcon(Drawable r5) {
        OverflowMenuButton r10 = this.mOverflowButton;
        if (r10 == null) goto L5;
        r10.setImageDrawable(r5);
        return;
    L5:
        this.mPendingOverflowIconSet = true;
        this.mPendingOverflowIcon = r5;
    }

    public void setReserveOverflow(boolean r5) {
        this.mReserveOverflow = r5;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int r5, boolean r10) {
        this.mWidthLimit = r5;
        this.mStrictWidthLimit = r10;
        this.mWidthLimitSet = true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean shouldIncludeItem(int r5, MenuItemImpl r10) {
        return r10.isActionButton();
    }

    public boolean showOverflowMenu() {
        if (this.mReserveOverflow == true) goto L5;
        return false;
    L5:
        if (isOverflowMenuShowing() == true) goto L18;
        MenuBuilder r5 = this.mMenu;
        if (r5 != null) goto L9;
        return false;
    L9:
        if (this.mMenuView != null) goto L11;
        return false;
    L11:
        if (this.mPostedOpenRunnable == null) goto L13;
        return false;
    L13:
        if (r5.getNonActionItems().isEmpty() == true) goto L22;
        OpenOverflowRunnable r10 = new OpenOverflowRunnable(this, new OverflowPopup(this, this.mContext, this.mMenu, this.mOverflowButton, true));
        this.mPostedOpenRunnable = r10;
        ((View) this.mMenuView).post(r10);
        return true;
    L22:
        return false;
    L18:
        return false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r5) {
        super.updateMenuView(r5);
        ((View) this.mMenuView).requestLayout();
        MenuBuilder r10 = this.mMenu;
        boolean r11 = false;
        if (r10 == null) goto L10;
        ArrayList<MenuItemImpl> r12 = r10.getActionItems();
        int r13 = r12.size();
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L10;
        ActionProvider r15 = r12.get(r14).getSupportActionProvider();
        if (r15 == null) goto L9;
        r15.setSubUiVisibilityListener(this);
    L9:
        r14 = r14 + 1;
    L10:
        MenuBuilder r16 = this.mMenu;
        if (r16 == null) goto L13;
        ArrayList<MenuItemImpl> r17 = r16.getNonActionItems();
    L15:
        if (this.mReserveOverflow == false) goto L22;
        if (r17 == null) goto L22;
        int r18 = r17.size();
        if (r18 != 1) goto L20;
        r11 = !r17.get(0).isActionViewExpanded();
        goto L22
    L20:
        if (r18 <= 0) goto L22;
        r11 = true;
    L22:
        if (r11 == true) goto L24;
        OverflowMenuButton r19 = this.mOverflowButton;
        if (r19 == null) goto L36;
        Object r20 = r19.getParent();
        Object r21 = this.mMenuView;
        if (r20 != r21) goto L36;
        ((ViewGroup) r21).removeView(this.mOverflowButton);
    L36:
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
        return;
    L24:
        if (this.mOverflowButton != null) goto L26;
        this.mOverflowButton = new OverflowMenuButton(this, this.mSystemContext);
    L26:
        ViewGroup r22 = (ViewGroup) this.mOverflowButton.getParent();
        if (r22 == this.mMenuView) goto L36;
        if (r22 == null) goto L30;
        r22.removeView(this.mOverflowButton);
    L30:
        ActionMenuView r23 = (ActionMenuView) this.mMenuView;
        r23.addView(this.mOverflowButton, r23.generateOverflowButtonLayoutParams());
        goto L36
    L13:
        r17 = null;
        goto L15
    }
}
