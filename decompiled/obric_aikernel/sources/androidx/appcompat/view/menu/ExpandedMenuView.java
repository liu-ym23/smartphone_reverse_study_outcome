package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ExpandedMenuView extends ListView implements MenuBuilder.ItemInvoker, MenuView, AdapterView.OnItemClickListener {
    private static final int[] TINT_ATTRS = null;
    private int mAnimations;
    private MenuBuilder mMenu;

    static {
        TINT_ATTRS = new int[]{R.attr.background, R.attr.divider};
    }

    public ExpandedMenuView(Context r10, AttributeSet r11) {
        this(r10, r11, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11);
        setOnItemClickListener(this);
        TintTypedArray r13 = TintTypedArray.obtainStyledAttributes(r10, r11, TINT_ATTRS, r12, 0);
        if (r13.hasValue(0) == false) goto L6;
        setBackgroundDrawable(r13.getDrawable(0));
    L6:
        if (r13.hasValue(1) == false) goto L8;
        setDivider(r13.getDrawable(1));
    L8:
        r13.recycle();
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return this.mAnimations;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder r10) {
        this.mMenu = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public boolean invokeItem(MenuItemImpl r10) {
        return this.mMenu.performItemAction(r10, 0);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView r10, View r11, int r12, long r13) {
        invokeItem((MenuItemImpl) getAdapter().getItem(r12));
    }
}
