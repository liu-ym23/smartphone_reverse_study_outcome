package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
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

    public BaseMenuPresenter(Context r3, int r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mSystemContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.mSystemInflater = LayoutInflater.from(r6);
        this.mMenuLayoutRes = r4;
        this.mItemLayoutRes = r5;
    }

    public void addItemView(View r4, int r5) {
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4.getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.removeView(r4);
    L5:
        ((ViewGroup) ZeusTransformUtils.preCheckCast(this.mMenuView, ViewGroup.class, "com.obric.memorydata.plugin")).addView(r4, r5);
    }

    public abstract void bindItemView(MenuItemImpl r1, MenuView.ItemView r2);

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    public MenuView.ItemView createItemView(ViewGroup r4) {
        return (MenuView.ItemView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(this.mSystemInflater, this.mItemLayoutRes, r4, false, "com.obric.memorydata.plugin"), MenuView.ItemView.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    public boolean filterLeftoverView(ViewGroup r1, int r2) {
        r1.removeViewAt(r2);
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

    public View getItemView(MenuItemImpl r3, View r4, ViewGroup r5) {
        if (ZeusTransformUtils.instanceOf(r4, MenuView.ItemView.class) == false) goto L5;
        MenuView.ItemView r6 = (MenuView.ItemView) ZeusTransformUtils.preCheckCast(r4, MenuView.ItemView.class, "com.obric.memorydata.plugin");
    L6:
        bindItemView(r3, r6);
        return (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin");
    L5:
        r6 = createItemView(r5);
        goto L6
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r5) {
        if (this.mMenuView != null) goto L6;
        MenuView r6 = (MenuView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(this.mSystemInflater, this.mMenuLayoutRes, r5, false, "com.obric.memorydata.plugin"), MenuView.class, "com.obric.memorydata.plugin");
        this.mMenuView = r6;
        r6.initialize(this.mMenu);
        updateMenuView(true);
    L6:
        return this.mMenuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r3, MenuBuilder r4) {
        Context r5 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mContext = r5;
        this.mInflater = LayoutInflater.from(r5);
        this.mMenu = r4;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r1, boolean r2) {
        MenuPresenter.Callback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onCloseMenu(r1, r2);
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
    public boolean onSubMenuSelected(SubMenuBuilder r2) {
        MenuPresenter.Callback r0 = this.mCallback;
        MenuBuilder r3 = r2;
        if (r0 == null) goto L9;
        if (r2 != null) goto L8;
        r3 = this.mMenu;
    L8:
        return r0.onOpenSubMenu(r3);
    L9:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r3) {
        this.mCallback = (MenuPresenter.Callback) ZeusTransformUtils.wrapperContextForParams(r3, MenuPresenter.Callback.class, "com.obric.memorydata.plugin");
    }

    public void setId(int r1) {
        this.mId = r1;
    }

    public boolean shouldIncludeItem(int r1, MenuItemImpl r2) {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r11) {
        ViewGroup r12 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.mMenuView, ViewGroup.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L5;
        return;
    L5:
        MenuBuilder r0 = this.mMenu;
        int r2 = 0;
        if (r0 == null) goto L24;
        r0.flagActionItems();
        ArrayList<MenuItemImpl> r1 = this.mMenu.getVisibleItems();
        int r3 = r1.size();
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r4 >= r3) goto L22;
        MenuItemImpl r6 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(r1.get(r4), MenuItemImpl.class, "com.obric.memorydata.plugin");
        if (shouldIncludeItem(r5, r6) == false) goto L21;
        View r7 = r12.getChildAt(r5);
        if (ZeusTransformUtils.instanceOf(r7, MenuView.ItemView.class) == false) goto L14;
        MenuItemImpl r8 = ((MenuView.ItemView) ZeusTransformUtils.preCheckCast(r7, MenuView.ItemView.class, "com.obric.memorydata.plugin")).getItemData();
    L15:
        View r9 = getItemView(r6, r7, r12);
        if (r6 == r8) goto L18;
        r9.setPressed(false);
        r9.jumpDrawablesToCurrentState();
    L18:
        if (r9 == r7) goto L20;
        addItemView(r9, r5);
    L20:
        r5 = r5 + 1;
        goto L21
    L14:
        r8 = null;
    L21:
        r4 = r4 + 1;
        goto L8
    L22:
        r2 = r5;
    L24:
        if (r2 >= r12.getChildCount()) goto L28;
        if (filterLeftoverView(r12, r2) == true) goto L24;
        r2 = r2 + 1;
        goto L24
    }
}
