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
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
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
    private int id;
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
    ColorStateList textColor;

    private static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View r10) {
            super(r10);
        }
    }

    private class NavigationMenuAdapter extends RecyclerView.Adapter<ViewHolder> {
        private static final String STATE_ACTION_VIEWS = "android:menu:action_views";
        private static final String STATE_CHECKED_ITEM = "android:menu:checked";
        private static final int VIEW_TYPE_HEADER = 3;
        private static final int VIEW_TYPE_NORMAL = 0;
        private static final int VIEW_TYPE_SEPARATOR = 2;
        private static final int VIEW_TYPE_SUBHEADER = 1;
        private MenuItemImpl checkedItem;
        private final ArrayList<c> items;
        final /* synthetic */ NavigationMenuPresenter this$0;
        private boolean updateSuspended;

        NavigationMenuAdapter(NavigationMenuPresenter r10) {
            this.this$0 = r10;
            this.items = new ArrayList();
            prepareMenuItems();
        }

        private void appendTransparentIconIfMissing(int r10, int r11) {
        L2:
            if (r10 >= r11) goto L4;
            ((e) this.items.get(r10)).f3344b = true;
            r10 = r10 + 1;
            goto L2
        }

        private void prepareMenuItems() {
            if (this.updateSuspended == false) goto L5;
            return;
        L5:
            boolean r10 = true;
            this.updateSuspended = true;
            this.items.clear();
            this.items.add(new b());
            int r11 = -1;
            int r12 = this.this$0.menu.getVisibleItems().size();
            int r13 = 0;
            boolean r14 = false;
            int r15 = 0;
        L6:
            if (r13 >= r12) goto L51;
            MenuItemImpl r16 = this.this$0.menu.getVisibleItems().get(r13);
            if (r16.isChecked() == false) goto L11;
            setCheckedItem(r16);
        L11:
            if (r16.isCheckable() == false) goto L14;
            r16.setExclusiveCheckable(false);
        L14:
            if (r16.hasSubMenu() == false) goto L37;
            SubMenu r17 = r16.getSubMenu();
            if (r17.hasVisibleItems() == false) goto L50;
            if (r13 == 0) goto L19;
            this.items.add(new d(this.this$0.paddingSeparator, 0));
        L19:
            this.items.add(new e(r16));
            int r18 = this.items.size();
            int r19 = r17.size();
            int r110 = 0;
            boolean r111 = false;
        L20:
            if (r110 >= r19) goto L35;
            MenuItemImpl r112 = (MenuItemImpl) r17.getItem(r110);
            if (r112.isVisible() == false) goto L34;
            if (r111 == true) goto L28;
            if (r112.getIcon() == null) goto L28;
            r111 = r10;
        L28:
            if (r112.isCheckable() == false) goto L31;
            r112.setExclusiveCheckable(false);
        L31:
            if (r16.isChecked() == false) goto L33;
            setCheckedItem(r16);
        L33:
            this.items.add(new e(r112));
        L34:
            r110 = r110 + 1;
            r10 = true;
            goto L20
        L35:
            if (r111 == false) goto L50;
            appendTransparentIconIfMissing(r18, this.items.size());
        L50:
            r13 = r13 + 1;
            r10 = true;
            goto L6
        L37:
            int r20 = r16.getGroupId();
            if (r20 == r11) goto L45;
            r15 = this.items.size();
            if (r16.getIcon() == null) goto L42;
            r14 = true;
        L43:
            if (r13 == 0) goto L49;
            r15 = r15 + 1;
            ArrayList<c> r21 = this.items;
            int r113 = this.this$0.paddingSeparator;
            r21.add(new d(r113, r113));
        L49:
            e r22 = new e(r16);
            r22.f3344b = r14;
            this.items.add(r22);
            r11 = r20;
            goto L50
        L42:
            r14 = false;
            goto L43
        L45:
            if (r14 == true) goto L49;
            if (r16.getIcon() == null) goto L49;
            appendTransparentIconIfMissing(r15, this.items.size());
            r14 = true;
            goto L49
        L51:
            this.updateSuspended = false;
        }

        @NonNull
        public Bundle createInstanceState() {
            Bundle r10 = new Bundle();
            MenuItemImpl r11 = this.checkedItem;
            if (r11 == null) goto L5;
            r10.putInt(STATE_CHECKED_ITEM, r11.getItemId());
        L5:
            SparseArray<? extends Parcelable> r12 = new SparseArray();
            int r13 = 0;
            int r14 = this.items.size();
        L6:
            if (r13 >= r14) goto L16;
            c r15 = this.items.get(r13);
            if ((r15 instanceof e) == false) goto L15;
            MenuItemImpl r16 = ((e) r15).a();
            if (r16 == null) goto L12;
            View r17 = r16.getActionView();
        L13:
            if (r17 == null) goto L15;
            ParcelableSparseArray r18 = new ParcelableSparseArray();
            r17.saveHierarchyState(r18);
            r12.put(r16.getItemId(), r18);
            goto L15
        L12:
            r17 = null;
        L15:
            r13 = r13 + 1;
            goto L6
        L16:
            r10.putSparseParcelableArray(STATE_ACTION_VIEWS, r12);
            return r10;
        }

        public MenuItemImpl getCheckedItem() {
            return this.checkedItem;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int r10) {
            return r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int r10) {
            c r11 = this.items.get(r10);
            if ((r11 instanceof d) == false) goto L7;
            return 2;
        L7:
            if ((r11 instanceof b) == false) goto L11;
            return 3;
        L11:
            if ((r11 instanceof e) == false) goto L19;
            if (((e) r11).a().hasSubMenu() == false) goto L16;
            return 1;
        L16:
            return 0;
        L19:
            throw new RuntimeException("Unknown item type.");
        }

        int getRowCount() {
            int r10 = 0;
            if (this.this$0.headerLayout.getChildCount() != 0) goto L5;
            int r11 = 0;
        L7:
            if (r10 >= this.this$0.adapter.getItemCount()) goto L12;
            if (this.this$0.adapter.getItemViewType(r10) != 0) goto L11;
            r11 = r11 + 1;
        L11:
            r10 = r10 + 1;
            goto L7
        L12:
            return r11;
        L5:
            r11 = 1;
            goto L7
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r10, int r11) {
            onBindViewHolder((ViewHolder) r10, r11);
        }

        public void onBindViewHolder(@NonNull ViewHolder r10, int r11) {
            int r12 = getItemViewType(r11);
            if (r12 != 0) goto L5;
            NavigationMenuItemView r13 = (NavigationMenuItemView) r10.itemView;
            r13.setIconTintList(this.this$0.iconTintList);
            int r14 = this.this$0.textAppearance;
            if (r14 == 0) goto L19;
            r13.setTextAppearance(r14);
        L19:
            ColorStateList r15 = this.this$0.textColor;
            if (r15 == null) goto L22;
            r13.setTextColor(r15);
        L22:
            Drawable r16 = this.this$0.itemBackground;
            if (r16 == null) goto L25;
            Drawable r17 = r16.getConstantState().newDrawable();
        L26:
            ViewCompat.setBackground(r13, r17);
            RippleDrawable r18 = this.this$0.itemForeground;
            if (r18 == null) goto L29;
            r13.setForeground(r18.getConstantState().newDrawable());
        L29:
            e r19 = (e) this.items.get(r11);
            r13.setNeedsEmptyIcon(r19.f3344b);
            NavigationMenuPresenter r20 = this.this$0;
            int r21 = r20.itemHorizontalPadding;
            int r22 = r20.itemVerticalPadding;
            r13.setPadding(r21, r22, r21, r22);
            r13.setIconPadding(this.this$0.itemIconPadding);
            NavigationMenuPresenter r23 = this.this$0;
            if (r23.hasCustomItemIconSize == false) goto L32;
            r13.setIconSize(r23.itemIconSize);
        L32:
            r13.setMaxLines(NavigationMenuPresenter.access$000(this.this$0));
            r13.initialize(r19.a(), 0);
            return;
        L25:
            r17 = null;
            goto L26
        L5:
            if (r12 != 1) goto L7;
            TextView r24 = (TextView) r10.itemView;
            r24.setText(((e) this.items.get(r11)).a().getTitle());
            int r25 = this.this$0.subheaderTextAppearance;
            if (r25 == 0) goto L13;
            TextViewCompat.setTextAppearance(r24, r25);
        L13:
            r24.setPadding(this.this$0.subheaderInsetStart, r24.getPaddingTop(), this.this$0.subheaderInsetEnd, r24.getPaddingBottom());
            ColorStateList r26 = this.this$0.subheaderColor;
            if (r26 == null) goto L35;
            r24.setTextColor(r26);
            return;
        L35:
            return;
        L7:
            if (r12 != 2) goto L37;
            d r27 = (d) this.items.get(r11);
            r10.itemView.setPadding(this.this$0.dividerInsetStart, r27.b(), this.this$0.dividerInsetEnd, r27.a());
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
            return onCreateViewHolder(r10, r11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        public ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
            if (r11 != 0) goto L4;
            NavigationMenuPresenter r12 = this.this$0;
            return new NormalViewHolder(r12.layoutInflater, r10, r12.onClickListener);
        L4:
            if (r11 == 1) goto L16;
            if (r11 == 2) goto L14;
            if (r11 == 3) goto L12;
            return null;
        L12:
            return new HeaderViewHolder(this.this$0.headerLayout);
        L14:
            return new SeparatorViewHolder(this.this$0.layoutInflater, r10);
        L16:
            return new SubheaderViewHolder(this.this$0.layoutInflater, r10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r10) {
            onViewRecycled((ViewHolder) r10);
        }

        public void onViewRecycled(ViewHolder r10) {
            if ((r10 instanceof NormalViewHolder) == false) goto L6;
            ((NavigationMenuItemView) r10.itemView).recycle();
            return;
        }

        public void restoreInstanceState(@NonNull Bundle r10) {
            int r11 = 0;
            int r12 = r10.getInt(STATE_CHECKED_ITEM, 0);
            if (r12 == 0) goto L15;
            this.updateSuspended = true;
            int r13 = this.items.size();
            int r14 = 0;
        L5:
            if (r14 >= r13) goto L14;
            c r15 = this.items.get(r14);
            if ((r15 instanceof e) == false) goto L13;
            MenuItemImpl r16 = ((e) r15).a();
            if (r16 == null) goto L13;
            if (r16.getItemId() != r12) goto L13;
            setCheckedItem(r16);
        L13:
            r14 = r14 + 1;
        L14:
            this.updateSuspended = false;
            prepareMenuItems();
        L15:
            SparseArray r17 = r10.getSparseParcelableArray(STATE_ACTION_VIEWS);
            if (r17 == null) goto L33;
            int r18 = this.items.size();
        L18:
            if (r11 >= r18) goto L45;
            c r19 = this.items.get(r11);
            if ((r19 instanceof e) == false) goto L32;
            MenuItemImpl r20 = ((e) r19).a();
            if (r20 == null) goto L32;
            View r21 = r20.getActionView();
            if (r21 == null) goto L32;
            ParcelableSparseArray r22 = (ParcelableSparseArray) r17.get(r20.getItemId());
            if (r22 == null) goto L32;
            r21.restoreHierarchyState(r22);
        L32:
            r11 = r11 + 1;
            goto L18
        L45:
            return;
        }

        public void setCheckedItem(@NonNull MenuItemImpl r10) {
            if (this.checkedItem != r10) goto L5;
            return;
        L5:
            if (r10.isCheckable() == false) goto L13;
            MenuItemImpl r11 = this.checkedItem;
            if (r11 == null) goto L10;
            r11.setChecked(false);
        L10:
            this.checkedItem = r10;
            r10.setChecked(true);
            return;
        }

        public void setUpdateSuspended(boolean r10) {
            this.updateSuspended = r10;
        }

        public void update() {
            prepareMenuItems();
            notifyDataSetChanged();
        }
    }

    private class NavigationMenuViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {
        final /* synthetic */ NavigationMenuPresenter this$0;

        NavigationMenuViewAccessibilityDelegate(@NonNull NavigationMenuPresenter r10, RecyclerView r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r10, @NonNull AccessibilityNodeInfoCompat r11) {
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            r11.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(this.this$0.adapter.getRowCount(), 0, false));
        }
    }

    private static class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(@NonNull LayoutInflater r10, ViewGroup r11, View.OnClickListener r12) {
            super(r10.inflate(q5.h.design_navigation_item, r11, false));
            this.itemView.setOnClickListener(r12);
        }
    }

    private static class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(@NonNull LayoutInflater r10, ViewGroup r11) {
            super(r10.inflate(q5.h.design_navigation_item_separator, r11, false));
        }
    }

    private static class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(@NonNull LayoutInflater r10, ViewGroup r11) {
            super(r10.inflate(q5.h.design_navigation_item_subheader, r11, false));
        }
    }

    private static abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View r10) {
            super(r10);
        }
    }

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ NavigationMenuPresenter f3340c;

        a(NavigationMenuPresenter r10) {
            this.f3340c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            boolean r11 = true;
            this.f3340c.setUpdateSuspended(true);
            MenuItemImpl r12 = ((NavigationMenuItemView) r10).getItemData();
            NavigationMenuPresenter r13 = this.f3340c;
            boolean r14 = r13.menu.performItemAction(r12, r13, 0);
            if (r12 != null) goto L5;
        L8:
            r11 = false;
        L9:
            this.f3340c.setUpdateSuspended(false);
            if (r11 == false) goto L13;
            this.f3340c.updateMenuView(false);
            return;
        L13:
            return;
        L5:
            if (r12.isCheckable() == false) goto L8;
            if (r14 == false) goto L8;
            this.f3340c.adapter.setCheckedItem(r12);
            goto L9
        }
    }

    private static class b implements c {
        b() {
        }
    }

    private interface c {
    }

    private static class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f3341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f3342b;

        public d(int r10, int r11) {
            this.f3341a = r10;
            this.f3342b = r11;
        }

        public int a() {
            return this.f3342b;
        }

        public int b() {
            return this.f3341a;
        }
    }

    private static class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MenuItemImpl f3343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f3344b;

        e(MenuItemImpl r10) {
            this.f3343a = r10;
        }

        public MenuItemImpl a() {
            return this.f3343a;
        }
    }

    public NavigationMenuPresenter() {
        this.subheaderTextAppearance = 0;
        this.textAppearance = 0;
        this.isBehindStatusBar = true;
        this.overScrollMode = -1;
        this.onClickListener = new a(this);
    }

    static /* synthetic */ int access$000(NavigationMenuPresenter r10) {
        return r10.itemMaxLines;
    }

    private void updateTopPadding() {
        if (this.headerLayout.getChildCount() == 0) goto L5;
    L7:
        int r10 = 0;
    L8:
        NavigationMenuView r11 = this.menuView;
        r11.setPadding(0, r10, 0, r11.getPaddingBottom());
        return;
    L5:
        if (this.isBehindStatusBar == false) goto L7;
        r10 = this.paddingTopDefault;
        goto L8
    }

    public void addHeaderView(@NonNull View r10) {
        this.headerLayout.addView(r10);
        NavigationMenuView r11 = this.menuView;
        r11.setPadding(0, 0, 0, r11.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r10, MenuItemImpl r11) {
        return false;
    }

    public void dispatchApplyWindowInsets(@NonNull WindowInsetsCompat r10) {
        int r11 = r10.getSystemWindowInsetTop();
        if (this.paddingTopDefault == r11) goto L5;
        this.paddingTopDefault = r11;
        updateTopPadding();
    L5:
        NavigationMenuView r12 = this.menuView;
        r12.setPadding(0, r12.getPaddingTop(), 0, r10.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.headerLayout, r10);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r10, MenuItemImpl r11) {
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

    public View getHeaderView(int r10) {
        return this.headerLayout.getChildAt(r10);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.id;
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
    public MenuView getMenuView(ViewGroup r10) {
        if (this.menuView != null) goto L12;
        NavigationMenuView r11 = (NavigationMenuView) this.layoutInflater.inflate(q5.h.design_navigation_menu, r10, false);
        this.menuView = r11;
        r11.setAccessibilityDelegateCompat(new NavigationMenuViewAccessibilityDelegate(this, this.menuView));
        if (this.adapter != null) goto L7;
        this.adapter = new NavigationMenuAdapter(this);
    L7:
        int r12 = this.overScrollMode;
        if (r12 == (-1)) goto L10;
        this.menuView.setOverScrollMode(r12);
    L10:
        this.headerLayout = (LinearLayout) this.layoutInflater.inflate(q5.h.design_navigation_item_header, this.menuView, false);
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

    public View inflateHeaderView(@LayoutRes int r10) {
        View r11 = this.layoutInflater.inflate(r10, this.headerLayout, false);
        addHeaderView(r11);
        return r11;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context r10, @NonNull MenuBuilder r11) {
        this.layoutInflater = LayoutInflater.from(r10);
        this.menu = r11;
        this.paddingSeparator = r10.getResources().getDimensionPixelOffset(q5.d.design_navigation_separator_vertical_padding);
    }

    public boolean isBehindStatusBar() {
        return this.isBehindStatusBar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r10, boolean r11) {
        MenuPresenter.Callback r12 = this.callback;
        if (r12 == null) goto L6;
        r12.onCloseMenu(r10, r11);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof Bundle) == false) goto L14;
        Bundle r11 = (Bundle) r10;
        SparseArray<Parcelable> r12 = r11.getSparseParcelableArray("android:menu:list");
        if (r12 == null) goto L7;
        this.menuView.restoreHierarchyState(r12);
    L7:
        Bundle r13 = r11.getBundle(STATE_ADAPTER);
        if (r13 == null) goto L10;
        this.adapter.restoreInstanceState(r13);
    L10:
        SparseArray r14 = r11.getSparseParcelableArray(STATE_HEADER);
        if (r14 == null) goto L15;
        this.headerLayout.restoreHierarchyState(r14);
        return;
    L15:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle r10 = new Bundle();
        if (this.menuView == null) goto L5;
        SparseArray<Parcelable> r11 = new SparseArray();
        this.menuView.saveHierarchyState(r11);
        r10.putSparseParcelableArray("android:menu:list", r11);
    L5:
        NavigationMenuAdapter r12 = this.adapter;
        if (r12 == null) goto L9;
        r10.putBundle(STATE_ADAPTER, r12.createInstanceState());
    L9:
        if (this.headerLayout == null) goto L11;
        SparseArray<? extends Parcelable> r13 = new SparseArray();
        this.headerLayout.saveHierarchyState(r13);
        r10.putSparseParcelableArray(STATE_HEADER, r13);
    L11:
        return r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r10) {
        return false;
    }

    public void removeHeaderView(@NonNull View r10) {
        this.headerLayout.removeView(r10);
        if (this.headerLayout.getChildCount() != 0) goto L6;
        NavigationMenuView r11 = this.menuView;
        r11.setPadding(0, this.paddingTopDefault, 0, r11.getPaddingBottom());
        return;
    }

    public void setBehindStatusBar(boolean r10) {
        if (this.isBehindStatusBar == r10) goto L6;
        this.isBehindStatusBar = r10;
        updateTopPadding();
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r10) {
        this.callback = r10;
    }

    public void setCheckedItem(@NonNull MenuItemImpl r10) {
        this.adapter.setCheckedItem(r10);
    }

    public void setDividerInsetEnd(@Px int r10) {
        this.dividerInsetEnd = r10;
        updateMenuView(false);
    }

    public void setDividerInsetStart(@Px int r10) {
        this.dividerInsetStart = r10;
        updateMenuView(false);
    }

    public void setId(int r10) {
        this.id = r10;
    }

    public void setItemBackground(@Nullable Drawable r10) {
        this.itemBackground = r10;
        updateMenuView(false);
    }

    public void setItemForeground(@Nullable RippleDrawable r10) {
        this.itemForeground = r10;
        updateMenuView(false);
    }

    public void setItemHorizontalPadding(int r10) {
        this.itemHorizontalPadding = r10;
        updateMenuView(false);
    }

    public void setItemIconPadding(int r10) {
        this.itemIconPadding = r10;
        updateMenuView(false);
    }

    public void setItemIconSize(@Dimension int r10) {
        if (this.itemIconSize == r10) goto L6;
        this.itemIconSize = r10;
        this.hasCustomItemIconSize = true;
        updateMenuView(false);
        return;
    }

    public void setItemIconTintList(@Nullable ColorStateList r10) {
        this.iconTintList = r10;
        updateMenuView(false);
    }

    public void setItemMaxLines(int r10) {
        this.itemMaxLines = r10;
        updateMenuView(false);
    }

    public void setItemTextAppearance(@StyleRes int r10) {
        this.textAppearance = r10;
        updateMenuView(false);
    }

    public void setItemTextColor(@Nullable ColorStateList r10) {
        this.textColor = r10;
        updateMenuView(false);
    }

    public void setItemVerticalPadding(@Px int r10) {
        this.itemVerticalPadding = r10;
        updateMenuView(false);
    }

    public void setOverScrollMode(int r10) {
        this.overScrollMode = r10;
        NavigationMenuView r11 = this.menuView;
        if (r11 == null) goto L6;
        r11.setOverScrollMode(r10);
        return;
    }

    public void setSubheaderColor(@Nullable ColorStateList r10) {
        this.subheaderColor = r10;
        updateMenuView(false);
    }

    public void setSubheaderInsetEnd(@Px int r10) {
        this.subheaderInsetEnd = r10;
        updateMenuView(false);
    }

    public void setSubheaderInsetStart(@Px int r10) {
        this.subheaderInsetStart = r10;
        updateMenuView(false);
    }

    public void setSubheaderTextAppearance(@StyleRes int r10) {
        this.subheaderTextAppearance = r10;
        updateMenuView(false);
    }

    public void setUpdateSuspended(boolean r10) {
        NavigationMenuAdapter r11 = this.adapter;
        if (r11 == null) goto L6;
        r11.setUpdateSuspended(r10);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r10) {
        NavigationMenuAdapter r11 = this.adapter;
        if (r11 == null) goto L6;
        r11.update();
        return;
    }
}
