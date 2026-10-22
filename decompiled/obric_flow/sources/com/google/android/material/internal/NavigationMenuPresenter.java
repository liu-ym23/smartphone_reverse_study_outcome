package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuPresenter implements MenuPresenter {
    public static final int NO_TEXT_APPEARANCE_SET = 0;
    private static final String STATE_ADAPTER = "android:menu:adapter";
    private static final String STATE_HEADER = "android:menu:header";
    private static final String STATE_HIERARCHY = "android:menu:list";
    NavigationMenuAdapter adapter;
    private MenuPresenter.Callback callback;

    @Px
    int dividerInsetEnd;

    @Px
    int dividerInsetStart;
    boolean hasCustomItemIconSize;
    LinearLayout headerLayout;
    ColorStateList iconTintList;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f8553id;
    boolean isBehindStatusBar;
    Drawable itemBackground;
    RippleDrawable itemForeground;
    int itemHorizontalPadding;
    int itemIconPadding;
    int itemIconSize;
    private int itemMaxLines;

    @Px
    int itemVerticalPadding;
    LayoutInflater layoutInflater;
    MenuBuilder menu;
    private NavigationMenuView menuView;
    final View.OnClickListener onClickListener;
    private int overScrollMode;
    int paddingSeparator;
    private int paddingTopDefault;

    @Nullable
    ColorStateList subheaderColor;

    @Px
    int subheaderInsetEnd;

    @Px
    int subheaderInsetStart;
    int subheaderTextAppearance;
    int textAppearance;
    boolean textAppearanceActiveBoldEnabled;
    ColorStateList textColor;

    public static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View r5) {
            super(r5);
        }
    }

    public class NavigationMenuAdapter extends RecyclerView.Adapter<ViewHolder> {
        private static final String STATE_ACTION_VIEWS = "android:menu:action_views";
        private static final String STATE_CHECKED_ITEM = "android:menu:checked";
        private static final int VIEW_TYPE_HEADER = 3;
        private static final int VIEW_TYPE_NORMAL = 0;
        private static final int VIEW_TYPE_SEPARATOR = 2;
        private static final int VIEW_TYPE_SUBHEADER = 1;
        private MenuItemImpl checkedItem;
        private final ArrayList<NavigationMenuItem> items;
        final /* synthetic */ NavigationMenuPresenter this$0;
        private boolean updateSuspended;

        public NavigationMenuAdapter(NavigationMenuPresenter r5) {
            this.this$0 = r5;
            this.items = new ArrayList();
            prepareMenuItems();
        }

        public static /* synthetic */ int access$100(NavigationMenuAdapter r5, int r10) {
            return r5.adjustItemPositionForA11yDelegate(r10);
        }

        private int adjustItemPositionForA11yDelegate(int r5) {
            int r10 = 0;
            int r11 = r5;
        L3:
            if (r10 >= r5) goto L10;
            if (this.this$0.adapter.getItemViewType(r10) != 2) goto L7;
        L8:
            r11 = r11 - 1;
        L9:
            r10 = r10 + 1;
            goto L3
        L7:
            if (this.this$0.adapter.getItemViewType(r10) != 3) goto L9;
        L10:
            return r11;
        }

        private void appendTransparentIconIfMissing(int r5, int r10) {
        L2:
            if (r5 >= r10) goto L4;
            ((NavigationMenuTextItem) this.items.get(r5)).needsEmptyIcon = true;
            r5 = r5 + 1;
            goto L2
        }

        private void prepareMenuItems() {
            if (this.updateSuspended == false) goto L5;
            return;
        L5:
            boolean r5 = true;
            this.updateSuspended = true;
            this.items.clear();
            this.items.add(new NavigationMenuHeaderItem());
            int r10 = this.this$0.menu.getVisibleItems().size();
            int r11 = -1;
            int r12 = 0;
            boolean r13 = false;
            int r14 = 0;
        L6:
            if (r12 >= r10) goto L51;
            MenuItemImpl r15 = this.this$0.menu.getVisibleItems().get(r12);
            if (r15.isChecked() == false) goto L11;
            setCheckedItem(r15);
        L11:
            if (r15.isCheckable() == false) goto L14;
            r15.setExclusiveCheckable(false);
        L14:
            if (r15.hasSubMenu() == false) goto L37;
            SubMenu r16 = r15.getSubMenu();
            if (r16.hasVisibleItems() == false) goto L50;
            if (r12 == 0) goto L19;
            this.items.add(new NavigationMenuSeparatorItem(this.this$0.paddingSeparator, 0));
        L19:
            this.items.add(new NavigationMenuTextItem(r15));
            int r17 = this.items.size();
            int r18 = r16.size();
            int r19 = 0;
            boolean r110 = false;
        L20:
            if (r19 >= r18) goto L35;
            MenuItemImpl r111 = (MenuItemImpl) r16.getItem(r19);
            if (r111.isVisible() == false) goto L34;
            if (r110 == true) goto L28;
            if (r111.getIcon() == null) goto L28;
            r110 = r5;
        L28:
            if (r111.isCheckable() == false) goto L31;
            r111.setExclusiveCheckable(false);
        L31:
            if (r15.isChecked() == false) goto L33;
            setCheckedItem(r15);
        L33:
            this.items.add(new NavigationMenuTextItem(r111));
        L34:
            r19 = r19 + 1;
            r5 = true;
            goto L20
        L35:
            if (r110 == false) goto L50;
            appendTransparentIconIfMissing(r17, this.items.size());
        L50:
            r12 = r12 + 1;
            r5 = true;
            goto L6
        L37:
            int r20 = r15.getGroupId();
            if (r20 == r11) goto L45;
            r14 = this.items.size();
            if (r15.getIcon() == null) goto L42;
            r13 = true;
        L43:
            if (r12 == 0) goto L49;
            r14 = r14 + 1;
            ArrayList<NavigationMenuItem> r21 = this.items;
            int r112 = this.this$0.paddingSeparator;
            r21.add(new NavigationMenuSeparatorItem(r112, r112));
        L49:
            NavigationMenuTextItem r22 = new NavigationMenuTextItem(r15);
            r22.needsEmptyIcon = r13;
            this.items.add(r22);
            r11 = r20;
            goto L50
        L42:
            r13 = false;
            goto L43
        L45:
            if (r13 == true) goto L49;
            if (r15.getIcon() == null) goto L49;
            appendTransparentIconIfMissing(r14, this.items.size());
            r13 = true;
            goto L49
        L51:
            this.updateSuspended = false;
        }

        private void setAccessibilityDelegate(View r5, final int r10, final boolean r11) {
            ViewCompat.setAccessibilityDelegate(r5, new AnonymousClass1(this, r10, r11));
        }

        @NonNull
        public Bundle createInstanceState() {
            Bundle r5 = new Bundle();
            MenuItemImpl r10 = this.checkedItem;
            if (r10 == null) goto L5;
            r5.putInt(STATE_CHECKED_ITEM, r10.getItemId());
        L5:
            SparseArray<? extends Parcelable> r11 = new SparseArray();
            int r12 = this.items.size();
            int r13 = 0;
        L6:
            if (r13 >= r12) goto L16;
            NavigationMenuItem r14 = this.items.get(r13);
            if ((r14 instanceof NavigationMenuTextItem) == false) goto L15;
            MenuItemImpl r15 = ((NavigationMenuTextItem) r14).getMenuItem();
            if (r15 == null) goto L12;
            View r16 = r15.getActionView();
        L13:
            if (r16 == null) goto L15;
            ParcelableSparseArray r17 = new ParcelableSparseArray();
            r16.saveHierarchyState(r17);
            r11.put(r15.getItemId(), r17);
            goto L15
        L12:
            r16 = null;
        L15:
            r13 = r13 + 1;
            goto L6
        L16:
            r5.putSparseParcelableArray(STATE_ACTION_VIEWS, r11);
            return r5;
        }

        public MenuItemImpl getCheckedItem() {
            return this.checkedItem;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int r5) {
            return r5;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int r5) {
            NavigationMenuItem r10 = this.items.get(r5);
            if ((r10 instanceof NavigationMenuSeparatorItem) == false) goto L7;
            return 2;
        L7:
            if ((r10 instanceof NavigationMenuHeaderItem) == false) goto L11;
            return 3;
        L11:
            if ((r10 instanceof NavigationMenuTextItem) == false) goto L19;
            if (((NavigationMenuTextItem) r10).getMenuItem().hasSubMenu() == false) goto L16;
            return 1;
        L16:
            return 0;
        L19:
            throw new RuntimeException("Unknown item type.");
        }

        public int getRowCount() {
            int r5 = 0;
            int r10 = 0;
        L4:
            if (r5 >= this.this$0.adapter.getItemCount()) goto L11;
            int r11 = this.this$0.adapter.getItemViewType(r5);
            if (r11 != 0) goto L8;
        L9:
            r10 = r10 + 1;
        L10:
            r5 = r5 + 1;
            goto L4
        L8:
            if (r11 != 1) goto L10;
        L11:
            return r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r5, int r10) {
            onBindViewHolder((ViewHolder) r5, r10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r10) {
            return onCreateViewHolder(r5, r10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r5) {
            onViewRecycled((ViewHolder) r5);
        }

        public void restoreInstanceState(@NonNull Bundle r10) {
            int r5 = 0;
            int r11 = r10.getInt(STATE_CHECKED_ITEM, 0);
            if (r11 == 0) goto L15;
            this.updateSuspended = true;
            int r12 = this.items.size();
            int r13 = 0;
        L5:
            if (r13 >= r12) goto L14;
            NavigationMenuItem r14 = this.items.get(r13);
            if ((r14 instanceof NavigationMenuTextItem) == false) goto L13;
            MenuItemImpl r15 = ((NavigationMenuTextItem) r14).getMenuItem();
            if (r15 == null) goto L13;
            if (r15.getItemId() != r11) goto L13;
            setCheckedItem(r15);
        L13:
            r13 = r13 + 1;
        L14:
            this.updateSuspended = false;
            prepareMenuItems();
        L15:
            SparseArray r16 = r10.getSparseParcelableArray(STATE_ACTION_VIEWS);
            if (r16 == null) goto L33;
            int r17 = this.items.size();
        L18:
            if (r5 >= r17) goto L45;
            NavigationMenuItem r18 = this.items.get(r5);
            if ((r18 instanceof NavigationMenuTextItem) == false) goto L32;
            MenuItemImpl r19 = ((NavigationMenuTextItem) r18).getMenuItem();
            if (r19 == null) goto L32;
            View r20 = r19.getActionView();
            if (r20 == null) goto L32;
            ParcelableSparseArray r21 = (ParcelableSparseArray) r16.get(r19.getItemId());
            if (r21 == null) goto L32;
            r20.restoreHierarchyState(r21);
        L32:
            r5 = r5 + 1;
            goto L18
        L45:
            return;
        }

        public void setCheckedItem(@NonNull MenuItemImpl r5) {
            if (this.checkedItem != r5) goto L5;
            return;
        L5:
            if (r5.isCheckable() == false) goto L13;
            MenuItemImpl r10 = this.checkedItem;
            if (r10 == null) goto L10;
            r10.setChecked(false);
        L10:
            this.checkedItem = r5;
            r5.setChecked(true);
            return;
        }

        public void setUpdateSuspended(boolean r5) {
            this.updateSuspended = r5;
        }

        public void update() {
            prepareMenuItems();
            notifyDataSetChanged();
        }

        public void onBindViewHolder(@NonNull ViewHolder r10, int r11) {
            int r5 = getItemViewType(r11);
            if (r5 != 0) goto L5;
            NavigationMenuItemView r12 = (NavigationMenuItemView) r10.itemView;
            r12.setIconTintList(this.this$0.iconTintList);
            r12.setTextAppearance(this.this$0.textAppearance);
            ColorStateList r13 = this.this$0.textColor;
            if (r13 == null) goto L17;
            r12.setTextColor(r13);
        L17:
            Drawable r14 = this.this$0.itemBackground;
            if (r14 == null) goto L20;
            Drawable r15 = r14.getConstantState().newDrawable();
        L21:
            ViewCompat.setBackground(r12, r15);
            RippleDrawable r16 = this.this$0.itemForeground;
            if (r16 == null) goto L24;
            r12.setForeground(r16.getConstantState().newDrawable());
        L24:
            NavigationMenuTextItem r17 = (NavigationMenuTextItem) this.items.get(r11);
            r12.setNeedsEmptyIcon(r17.needsEmptyIcon);
            NavigationMenuPresenter r18 = this.this$0;
            int r19 = r18.itemHorizontalPadding;
            int r20 = r18.itemVerticalPadding;
            r12.setPadding(r19, r20, r19, r20);
            r12.setIconPadding(this.this$0.itemIconPadding);
            NavigationMenuPresenter r21 = this.this$0;
            if (r21.hasCustomItemIconSize == false) goto L27;
            r12.setIconSize(r21.itemIconSize);
        L27:
            r12.setMaxLines(NavigationMenuPresenter.access$000(this.this$0));
            r12.initialize(r17.getMenuItem(), this.this$0.textAppearanceActiveBoldEnabled);
            setAccessibilityDelegate(r12, r11, false);
            return;
        L20:
            r15 = null;
            goto L21
        L5:
            if (r5 != 1) goto L7;
            TextView r22 = (TextView) r10.itemView;
            r22.setText(((NavigationMenuTextItem) this.items.get(r11)).getMenuItem().getTitle());
            TextViewCompat.setTextAppearance(r22, this.this$0.subheaderTextAppearance);
            r22.setPadding(this.this$0.subheaderInsetStart, r22.getPaddingTop(), this.this$0.subheaderInsetEnd, r22.getPaddingBottom());
            ColorStateList r23 = this.this$0.subheaderColor;
            if (r23 == null) goto L13;
            r22.setTextColor(r23);
        L13:
            setAccessibilityDelegate(r22, r11, true);
            return;
        L7:
            if (r5 != 2) goto L31;
            NavigationMenuSeparatorItem r24 = (NavigationMenuSeparatorItem) this.items.get(r11);
            r10.itemView.setPadding(this.this$0.dividerInsetStart, r24.getPaddingTop(), this.this$0.dividerInsetEnd, r24.getPaddingBottom());
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        public ViewHolder onCreateViewHolder(ViewGroup r5, int r10) {
            if (r10 != 0) goto L4;
            NavigationMenuPresenter r11 = this.this$0;
            return new NormalViewHolder(r11.layoutInflater, r5, r11.onClickListener);
        L4:
            if (r10 == 1) goto L16;
            if (r10 == 2) goto L14;
            if (r10 == 3) goto L12;
            return null;
        L12:
            return new HeaderViewHolder(this.this$0.headerLayout);
        L14:
            return new SeparatorViewHolder(this.this$0.layoutInflater, r5);
        L16:
            return new SubheaderViewHolder(this.this$0.layoutInflater, r5);
        }

        public void onViewRecycled(ViewHolder r5) {
            if ((r5 instanceof NormalViewHolder) == false) goto L6;
            ((NavigationMenuItemView) r5.itemView).recycle();
            return;
        }
    }

    public static class NavigationMenuHeaderItem implements NavigationMenuItem {
        public NavigationMenuHeaderItem() {
        }
    }

    public interface NavigationMenuItem {
    }

    public static class NavigationMenuSeparatorItem implements NavigationMenuItem {
        private final int paddingBottom;
        private final int paddingTop;

        public NavigationMenuSeparatorItem(int r5, int r10) {
            this.paddingTop = r5;
            this.paddingBottom = r10;
        }

        public int getPaddingBottom() {
            return this.paddingBottom;
        }

        public int getPaddingTop() {
            return this.paddingTop;
        }
    }

    public static class NavigationMenuTextItem implements NavigationMenuItem {
        private final MenuItemImpl menuItem;
        boolean needsEmptyIcon;

        public NavigationMenuTextItem(MenuItemImpl r5) {
            this.menuItem = r5;
        }

        public MenuItemImpl getMenuItem() {
            return this.menuItem;
        }
    }

    public class NavigationMenuViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {
        final /* synthetic */ NavigationMenuPresenter this$0;

        public NavigationMenuViewAccessibilityDelegate(@NonNull NavigationMenuPresenter r5, RecyclerView r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r5, @NonNull AccessibilityNodeInfoCompat r10) {
            super.onInitializeAccessibilityNodeInfo(r5, r10);
            r10.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(this.this$0.adapter.getRowCount(), 1, false));
        }
    }

    public static class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(@NonNull LayoutInflater r5, ViewGroup r10, View.OnClickListener r11) {
            super(r5.inflate(R.layout.design_navigation_item, r10, false));
            this.itemView.setOnClickListener(r11);
        }
    }

    public static class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(@NonNull LayoutInflater r5, ViewGroup r10) {
            super(r5.inflate(R.layout.design_navigation_item_separator, r10, false));
        }
    }

    public static class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(@NonNull LayoutInflater r5, ViewGroup r10) {
            super(r5.inflate(R.layout.design_navigation_item_subheader, r10, false));
        }
    }

    public static abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View r5) {
            super(r5);
        }
    }

    public NavigationMenuPresenter() {
        this.subheaderTextAppearance = 0;
        this.textAppearance = 0;
        this.textAppearanceActiveBoldEnabled = true;
        this.isBehindStatusBar = true;
        this.overScrollMode = -1;
        this.onClickListener = new AnonymousClass1(this);
    }

    public static /* synthetic */ int access$000(NavigationMenuPresenter r5) {
        return r5.itemMaxLines;
    }

    private boolean hasHeader() {
        if (getHeaderCount() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateTopPadding() {
        if (hasHeader() == false) goto L5;
    L7:
        int r5 = 0;
    L8:
        NavigationMenuView r10 = this.menuView;
        r10.setPadding(0, r5, 0, r10.getPaddingBottom());
        return;
    L5:
        if (this.isBehindStatusBar == false) goto L7;
        r5 = this.paddingTopDefault;
        goto L8
    }

    public void addHeaderView(@NonNull View r5) {
        this.headerLayout.addView(r5);
        NavigationMenuView r10 = this.menuView;
        r10.setPadding(0, 0, 0, r10.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r5, MenuItemImpl r10) {
        return false;
    }

    public void dispatchApplyWindowInsets(@NonNull WindowInsetsCompat r5) {
        int r10 = r5.getSystemWindowInsetTop();
        if (this.paddingTopDefault == r10) goto L5;
        this.paddingTopDefault = r10;
        updateTopPadding();
    L5:
        NavigationMenuView r11 = this.menuView;
        r11.setPadding(0, r11.getPaddingTop(), 0, r5.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.headerLayout, r5);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r5, MenuItemImpl r10) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Nullable
    public MenuItemImpl getCheckedItem() {
        return this.adapter.getCheckedItem();
    }

    @Px
    public int getDividerInsetEnd() {
        return this.dividerInsetEnd;
    }

    @Px
    public int getDividerInsetStart() {
        return this.dividerInsetStart;
    }

    public int getHeaderCount() {
        return this.headerLayout.getChildCount();
    }

    public View getHeaderView(int r5) {
        return this.headerLayout.getChildAt(r5);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f8553id;
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.itemBackground;
    }

    public int getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    public int getItemIconPadding() {
        return this.itemIconPadding;
    }

    public int getItemMaxLines() {
        return this.itemMaxLines;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.textColor;
    }

    @Nullable
    public ColorStateList getItemTintList() {
        return this.iconTintList;
    }

    @Px
    public int getItemVerticalPadding() {
        return this.itemVerticalPadding;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r5) {
        if (this.menuView != null) goto L12;
        NavigationMenuView r10 = (NavigationMenuView) this.layoutInflater.inflate(R.layout.design_navigation_menu, r5, false);
        this.menuView = r10;
        r10.setAccessibilityDelegateCompat(new NavigationMenuViewAccessibilityDelegate(this, this.menuView));
        if (this.adapter != null) goto L7;
        NavigationMenuAdapter r11 = new NavigationMenuAdapter(this);
        this.adapter = r11;
        r11.setHasStableIds(true);
    L7:
        int r12 = this.overScrollMode;
        if (r12 == (-1)) goto L10;
        this.menuView.setOverScrollMode(r12);
    L10:
        LinearLayout r13 = (LinearLayout) this.layoutInflater.inflate(R.layout.design_navigation_item_header, this.menuView, false);
        this.headerLayout = r13;
        ViewCompat.setImportantForAccessibility(r13, 2);
        this.menuView.setAdapter(this.adapter);
    L12:
        return this.menuView;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.subheaderInsetEnd;
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.subheaderInsetStart;
    }

    public View inflateHeaderView(@LayoutRes int r5) {
        View r10 = this.layoutInflater.inflate(r5, this.headerLayout, false);
        addHeaderView(r10);
        return r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context r5, @NonNull MenuBuilder r10) {
        this.layoutInflater = LayoutInflater.from(r5);
        this.menu = r10;
        this.paddingSeparator = r5.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public boolean isBehindStatusBar() {
        return this.isBehindStatusBar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r5, boolean r10) {
        MenuPresenter.Callback r11 = this.callback;
        if (r11 == null) goto L6;
        r11.onCloseMenu(r5, r10);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof Bundle) == false) goto L14;
        Bundle r10 = (Bundle) r5;
        SparseArray<Parcelable> r11 = r10.getSparseParcelableArray("android:menu:list");
        if (r11 == null) goto L7;
        this.menuView.restoreHierarchyState(r11);
    L7:
        Bundle r12 = r10.getBundle(STATE_ADAPTER);
        if (r12 == null) goto L10;
        this.adapter.restoreInstanceState(r12);
    L10:
        SparseArray<Parcelable> r13 = r10.getSparseParcelableArray(STATE_HEADER);
        if (r13 == null) goto L15;
        this.headerLayout.restoreHierarchyState(r13);
        return;
    L15:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle r5 = new Bundle();
        if (this.menuView == null) goto L5;
        SparseArray<Parcelable> r10 = new SparseArray();
        this.menuView.saveHierarchyState(r10);
        r5.putSparseParcelableArray("android:menu:list", r10);
    L5:
        NavigationMenuAdapter r11 = this.adapter;
        if (r11 == null) goto L9;
        r5.putBundle(STATE_ADAPTER, r11.createInstanceState());
    L9:
        if (this.headerLayout == null) goto L11;
        SparseArray<Parcelable> r12 = new SparseArray();
        this.headerLayout.saveHierarchyState(r12);
        r5.putSparseParcelableArray(STATE_HEADER, r12);
    L11:
        return r5;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r5) {
        return false;
    }

    public void removeHeaderView(@NonNull View r5) {
        this.headerLayout.removeView(r5);
        if (hasHeader() == true) goto L6;
        NavigationMenuView r10 = this.menuView;
        r10.setPadding(0, this.paddingTopDefault, 0, r10.getPaddingBottom());
        return;
    }

    public void setBehindStatusBar(boolean r5) {
        if (this.isBehindStatusBar == r5) goto L6;
        this.isBehindStatusBar = r5;
        updateTopPadding();
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r5) {
        this.callback = r5;
    }

    public void setCheckedItem(@NonNull MenuItemImpl r5) {
        this.adapter.setCheckedItem(r5);
    }

    public void setDividerInsetEnd(@Px int r5) {
        this.dividerInsetEnd = r5;
        updateMenuView(false);
    }

    public void setDividerInsetStart(@Px int r5) {
        this.dividerInsetStart = r5;
        updateMenuView(false);
    }

    public void setId(int r5) {
        this.f8553id = r5;
    }

    public void setItemBackground(@Nullable Drawable r5) {
        this.itemBackground = r5;
        updateMenuView(false);
    }

    public void setItemForeground(@Nullable RippleDrawable r5) {
        this.itemForeground = r5;
        updateMenuView(false);
    }

    public void setItemHorizontalPadding(int r5) {
        this.itemHorizontalPadding = r5;
        updateMenuView(false);
    }

    public void setItemIconPadding(int r5) {
        this.itemIconPadding = r5;
        updateMenuView(false);
    }

    public void setItemIconSize(@Dimension int r5) {
        if (this.itemIconSize == r5) goto L6;
        this.itemIconSize = r5;
        this.hasCustomItemIconSize = true;
        updateMenuView(false);
        return;
    }

    public void setItemIconTintList(@Nullable ColorStateList r5) {
        this.iconTintList = r5;
        updateMenuView(false);
    }

    public void setItemMaxLines(int r5) {
        this.itemMaxLines = r5;
        updateMenuView(false);
    }

    public void setItemTextAppearance(@StyleRes int r5) {
        this.textAppearance = r5;
        updateMenuView(false);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean r5) {
        this.textAppearanceActiveBoldEnabled = r5;
        updateMenuView(false);
    }

    public void setItemTextColor(@Nullable ColorStateList r5) {
        this.textColor = r5;
        updateMenuView(false);
    }

    public void setItemVerticalPadding(@Px int r5) {
        this.itemVerticalPadding = r5;
        updateMenuView(false);
    }

    public void setOverScrollMode(int r5) {
        this.overScrollMode = r5;
        NavigationMenuView r10 = this.menuView;
        if (r10 == null) goto L6;
        r10.setOverScrollMode(r5);
        return;
    }

    public void setSubheaderColor(@Nullable ColorStateList r5) {
        this.subheaderColor = r5;
        updateMenuView(false);
    }

    public void setSubheaderInsetEnd(@Px int r5) {
        this.subheaderInsetEnd = r5;
        updateMenuView(false);
    }

    public void setSubheaderInsetStart(@Px int r5) {
        this.subheaderInsetStart = r5;
        updateMenuView(false);
    }

    public void setSubheaderTextAppearance(@StyleRes int r5) {
        this.subheaderTextAppearance = r5;
        updateMenuView(false);
    }

    public void setUpdateSuspended(boolean r5) {
        NavigationMenuAdapter r10 = this.adapter;
        if (r10 == null) goto L6;
        r10.setUpdateSuspended(r5);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r5) {
        NavigationMenuAdapter r10 = this.adapter;
        if (r10 == null) goto L6;
        r10.update();
        return;
    }
}
