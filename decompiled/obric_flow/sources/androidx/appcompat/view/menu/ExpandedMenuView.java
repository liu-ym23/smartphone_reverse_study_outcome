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

    public ExpandedMenuView(Context r5, AttributeSet r10) {
        this(r5, r10, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return this.mAnimations;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder r5) {
        this.mMenu = r5;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public boolean invokeItem(MenuItemImpl r5) {
        return this.mMenu.performItemAction(r5, 0);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView r5, View r10, int r11, long r12) {
        invokeItem((MenuItemImpl) getAdapter().getItem(r11));
    }

    public ExpandedMenuView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10);
        setOnItemClickListener(this);
        TintTypedArray r12 = TintTypedArray.obtainStyledAttributes(r5, r10, TINT_ATTRS, r11, 0);
        if (r12.hasValue(0) == false) goto L6;
        setBackgroundDrawable(r12.getDrawable(0));
    L6:
        if (r12.hasValue(1) == false) goto L8;
        setDivider(r12.getDrawable(1));
    L8:
        r12.recycle();
    }
}
