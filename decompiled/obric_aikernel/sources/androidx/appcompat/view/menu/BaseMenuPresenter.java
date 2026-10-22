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

    public BaseMenuPresenter(Context r10, int r11, int r12) {
        this.mSystemContext = r10;
        this.mSystemInflater = LayoutInflater.from(r10);
        this.mMenuLayoutRes = r11;
        this.mItemLayoutRes = r12;
    }

    protected void addItemView(View r10, int r11) {
        ViewGroup r12 = (ViewGroup) r10.getParent();
        if (r12 == null) goto L5;
        r12.removeView(r10);
    L5:
        ((ViewGroup) this.mMenuView).addView(r10, r11);
    }

    public abstract void bindItemView(MenuItemImpl r10, MenuView.ItemView r11);

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r10, MenuItemImpl r11) {
        return false;
    }

    public MenuView.ItemView createItemView(ViewGroup r10) {
        return (MenuView.ItemView) this.mSystemInflater.inflate(this.mItemLayoutRes, r10, false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r10, MenuItemImpl r11) {
        return false;
    }

    protected boolean filterLeftoverView(ViewGroup r10, int r11) {
        r10.removeViewAt(r11);
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
    public View getItemView(MenuItemImpl r10, View r11, ViewGroup r12) {
        if ((r11 instanceof MenuView.ItemView) == false) goto L5;
        MenuView.ItemView r13 = (MenuView.ItemView) r11;
    L6:
        bindItemView(r10, r13);
        return (View) r13;
    L5:
        r13 = createItemView(r12);
        goto L6
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r10) {
        if (this.mMenuView != null) goto L6;
        MenuView r11 = (MenuView) this.mSystemInflater.inflate(this.mMenuLayoutRes, r10, false);
        this.mMenuView = r11;
        r11.initialize(this.mMenu);
        updateMenuView(true);
    L6:
        return this.mMenuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r10, MenuBuilder r11) {
        this.mContext = r10;
        this.mInflater = LayoutInflater.from(r10);
        this.mMenu = r11;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r10, boolean r11) {
        MenuPresenter.Callback r12 = this.mCallback;
        if (r12 == null) goto L6;
        r12.onCloseMenu(r10, r11);
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
    public boolean onSubMenuSelected(SubMenuBuilder r10) {
        MenuPresenter.Callback r11 = this.mCallback;
        MenuBuilder r12 = r10;
        if (r11 == null) goto L9;
        if (r10 != null) goto L8;
        r12 = this.mMenu;
    L8:
        return r11.onOpenSubMenu(r12);
    L9:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r10) {
        this.mCallback = r10;
    }

    public void setId(int r10) {
        this.mId = r10;
    }

    public boolean shouldIncludeItem(int r10, MenuItemImpl r11) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r10) {
        ViewGroup r11 = (ViewGroup) this.mMenuView;
        if (r11 != null) goto L5;
        return;
    L5:
        MenuBuilder r12 = this.mMenu;
        int r13 = 0;
        if (r12 == null) goto L24;
        r12.flagActionItems();
        ArrayList<MenuItemImpl> r14 = this.mMenu.getVisibleItems();
        int r15 = r14.size();
        int r16 = 0;
        int r17 = 0;
    L8:
        if (r16 >= r15) goto L22;
        MenuItemImpl r18 = r14.get(r16);
        if (shouldIncludeItem(r17, r18) == false) goto L21;
        View r19 = r11.getChildAt(r17);
        if ((r19 instanceof MenuView.ItemView) == false) goto L14;
        MenuItemImpl r20 = ((MenuView.ItemView) r19).getItemData();
    L15:
        View r21 = getItemView(r18, r19, r11);
        if (r18 == r20) goto L18;
        r21.setPressed(false);
        r21.jumpDrawablesToCurrentState();
    L18:
        if (r21 == r19) goto L20;
        addItemView(r21, r17);
    L20:
        r17 = r17 + 1;
        goto L21
    L14:
        r20 = null;
    L21:
        r16 = r16 + 1;
        goto L8
    L22:
        r13 = r17;
    L24:
        if (r13 >= r11.getChildCount()) goto L28;
        if (filterLeftoverView(r11, r13) == true) goto L24;
        r13 = r13 + 1;
        goto L24
    }
}
