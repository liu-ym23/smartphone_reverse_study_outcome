package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class BaseMenuPresenter implements MenuPresenter {
    private MenuPresenter.Callback mCallback;
    protected Context mContext;
    private int mId;
    protected LayoutInflater mInflater;
    private int mItemLayoutRes;
    protected MenuBuilder mMenu;
    private int mMenuLayoutRes;
    protected MenuView mMenuView;
    protected Context mSystemContext;
    protected LayoutInflater mSystemInflater;

    public BaseMenuPresenter(Context r5, int r10, int r11) {
        this.mSystemContext = r5;
        this.mSystemInflater = LayoutInflater.from(r5);
        this.mMenuLayoutRes = r10;
        this.mItemLayoutRes = r11;
    }

    public void addItemView(View r5, int r10) {
        ViewGroup r11 = (ViewGroup) r5.getParent();
        if (r11 == null) goto L5;
        r11.removeView(r5);
    L5:
        ((ViewGroup) this.mMenuView).addView(r5, r10);
    }

    public abstract void bindItemView(MenuItemImpl r5, MenuView.ItemView r10);

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r5, MenuItemImpl r10) {
        return false;
    }

    public MenuView.ItemView createItemView(ViewGroup r5) {
        return (MenuView.ItemView) this.mSystemInflater.inflate(this.mItemLayoutRes, r5, false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r5, MenuItemImpl r10) {
        return false;
    }

    public boolean filterLeftoverView(ViewGroup r5, int r10) {
        r5.removeViewAt(r10);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    public MenuPresenter.Callback getCallback() {
        return this.mCallback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.mId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View getItemView(MenuItemImpl r5, View r10, ViewGroup r11) {
        if ((r10 instanceof MenuView.ItemView) == false) goto L5;
        MenuView.ItemView r12 = (MenuView.ItemView) r10;
    L6:
        bindItemView(r5, r12);
        return (View) r12;
    L5:
        r12 = createItemView(r11);
        goto L6
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r5) {
        if (this.mMenuView != null) goto L6;
        MenuView r10 = (MenuView) this.mSystemInflater.inflate(this.mMenuLayoutRes, r5, false);
        this.mMenuView = r10;
        r10.initialize(this.mMenu);
        updateMenuView(true);
    L6:
        return this.mMenuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r5, MenuBuilder r10) {
        this.mContext = r5;
        this.mInflater = LayoutInflater.from(r5);
        this.mMenu = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r5, boolean r10) {
        MenuPresenter.Callback r11 = this.mCallback;
        if (r11 == null) goto L6;
        r11.onCloseMenu(r5, r10);
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r5) {
        MenuPresenter.Callback r10 = this.mCallback;
        MenuBuilder r11 = r5;
        if (r10 == null) goto L9;
        if (r5 != null) goto L8;
        r11 = this.mMenu;
    L8:
        return r10.onOpenSubMenu(r11);
    L9:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r5) {
        this.mCallback = r5;
    }

    public void setId(int r5) {
        this.mId = r5;
    }

    public boolean shouldIncludeItem(int r5, MenuItemImpl r10) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r10) {
        ViewGroup r11 = (ViewGroup) this.mMenuView;
        if (r11 != null) goto L5;
        return;
    L5:
        MenuBuilder r5 = this.mMenu;
        int r12 = 0;
        if (r5 == null) goto L24;
        r5.flagActionItems();
        ArrayList<MenuItemImpl> r13 = this.mMenu.getVisibleItems();
        int r14 = r13.size();
        int r15 = 0;
        int r16 = 0;
    L8:
        if (r15 >= r14) goto L22;
        MenuItemImpl r17 = r13.get(r15);
        if (shouldIncludeItem(r16, r17) == false) goto L21;
        View r18 = r11.getChildAt(r16);
        if ((r18 instanceof MenuView.ItemView) == false) goto L14;
        MenuItemImpl r19 = ((MenuView.ItemView) r18).getItemData();
    L15:
        View r20 = getItemView(r17, r18, r11);
        if (r17 == r19) goto L18;
        r20.setPressed(false);
        r20.jumpDrawablesToCurrentState();
    L18:
        if (r20 == r18) goto L20;
        addItemView(r20, r16);
    L20:
        r16 = r16 + 1;
        goto L21
    L14:
        r19 = null;
    L21:
        r15 = r15 + 1;
        goto L8
    L22:
        r12 = r16;
    L24:
        if (r12 >= r11.getChildCount()) goto L28;
        if (filterLeftoverView(r11, r12) == true) goto L24;
        r12 = r12 + 1;
        goto L24
    }
}
