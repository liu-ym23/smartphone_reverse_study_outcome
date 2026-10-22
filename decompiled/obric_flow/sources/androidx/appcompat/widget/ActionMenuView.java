package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        public ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder r5, boolean r10) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder r5) {
            return false;
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        @ViewDebug.ExportedProperty
        public int cellsUsed;

        @ViewDebug.ExportedProperty
        public boolean expandable;
        boolean expanded;

        @ViewDebug.ExportedProperty
        public int extraPixels;

        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;

        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(Context r5, AttributeSet r10) {
            super(r5, r10);
        }

        public LayoutParams(ViewGroup.LayoutParams r5) {
            super(r5);
        }

        public LayoutParams(LayoutParams r5) {
            super(r5);
            this.isOverflowButton = r5.isOverflowButton;
        }

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
            this.isOverflowButton = false;
        }

        public LayoutParams(int r5, int r10, boolean r11) {
            super(r5, r10);
            this.isOverflowButton = r11;
        }
    }

    public class MenuBuilderCallback implements MenuBuilder.Callback {
        final /* synthetic */ ActionMenuView this$0;

        public MenuBuilderCallback(ActionMenuView r5) {
            this.this$0 = r5;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(@NonNull MenuBuilder r5, @NonNull MenuItem r10) {
            OnMenuItemClickListener r11 = this.this$0.mOnMenuItemClickListener;
            if (r11 != null) goto L5;
        L7:
            return false;
        L5:
            if (r11.onMenuItemClick(r10) == false) goto L7;
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(@NonNull MenuBuilder r5) {
            MenuBuilder.Callback r10 = this.this$0.mMenuBuilderCallback;
            if (r10 == null) goto L6;
            r10.onMenuModeChange(r5);
            return;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r5);
    }

    public ActionMenuView(@NonNull Context r5) {
        this(r5, null);
    }

    public static int measureChildForCells(View r5, int r10, int r11, int r12, int r13) {
        LayoutParams r14 = (LayoutParams) r5.getLayoutParams();
        int r15 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r12) - r13, View.MeasureSpec.getMode(r12));
        if ((r5 instanceof ActionMenuItemView) == false) goto L5;
        ActionMenuItemView r16 = (ActionMenuItemView) r5;
    L6:
        boolean r17 = false;
        if (r16 != null) goto L9;
    L11:
        boolean r18 = false;
    L12:
        if (r11 <= 0) goto L23;
        int r19 = 2;
        if (r18 == false) goto L16;
        if (r11 < 2) goto L23;
    L16:
        r5.measure(View.MeasureSpec.makeMeasureSpec(r11 * r10, Integer.MIN_VALUE), r15);
        int r20 = r5.getMeasuredWidth();
        int r21 = r20 / r10;
        if ((r20 % r10) == 0) goto L19;
        r21 = r21 + 1;
    L19:
        if (r18 == false) goto L22;
        if (r21 >= 2) goto L22;
    L25:
        if (r14.isOverflowButton == true) goto L28;
        if (r18 == false) goto L28;
        r17 = true;
    L28:
        r14.expandable = r17;
        r14.cellsUsed = r19;
        r5.measure(View.MeasureSpec.makeMeasureSpec(r10 * r19, BasicMeasure.EXACTLY), r15);
        return r19;
    L22:
        r19 = r21;
    L23:
        r19 = 0;
        goto L25
    L9:
        if (r16.hasText() == false) goto L11;
        r18 = true;
        goto L12
    L5:
        r16 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r14v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v9 */
    private void onMeasureExactFormat(int r30, int r31) {
        int r5 = View.MeasureSpec.getMode(r31);
        int r10 = View.MeasureSpec.getSize(r30);
        int r11 = View.MeasureSpec.getSize(r31);
        int r12 = getPaddingRight() + getPaddingLeft();
        int r13 = getPaddingBottom() + getPaddingTop();
        int r14 = ViewGroup.getChildMeasureSpec(r31, r13, -2);
        int r15 = r10 - r12;
        int r16 = this.mMinCellSize;
        int r17 = r15 / r16;
        int r18 = r15 % r16;
        if (r17 != 0) goto L6;
        setMeasuredDimension(r15, 0);
        return;
    L6:
        int r19 = (r18 / r17) + r16;
        int r20 = getChildCount();
        int r110 = 0;
        int r111 = 0;
        boolean r112 = false;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
        long r116 = 0;
    L7:
        if (r111 >= r20) goto L37;
        View r117 = getChildAt(r111);
        int r118 = r11;
        if (r117.getVisibility() != 8) goto L11;
        r13 = r13;
    L36:
        r111 = r111 + 1;
        r13 = r13;
        r11 = r118;
        goto L7
    L11:
        boolean r21 = r117 instanceof ActionMenuItemView;
        int r119 = r113 + 1;
        if (r21 == false) goto L14;
        int r22 = this.mGeneratedItemPadding;
        ?? r120 = 0;
        r117.setPadding(r22, 0, r22, 0);
    L15:
        LayoutParams r23 = (LayoutParams) r117.getLayoutParams();
        r23.expanded = r120;
        r23.extraPixels = r120;
        r23.cellsUsed = r120;
        r23.expandable = r120;
        ((LinearLayout.LayoutParams) r23).leftMargin = r120;
        ((LinearLayout.LayoutParams) r23).rightMargin = r120;
        if (r21 == true) goto L18;
    L20:
        boolean r24 = false;
    L21:
        r23.preventEdgeOffset = r24;
        if (r23.isOverflowButton == false) goto L24;
        int r25 = 1;
    L25:
        int r26 = measureChildForCells(r117, r19, r25, r14, r13);
        r114 = Math.max(r114, r26);
        if (r23.expandable == false) goto L29;
        r115 = r115 + 1;
    L29:
        if (r23.isOverflowButton == false) goto L31;
        r112 = true;
    L31:
        r17 = r17 - r26;
        r110 = Math.max(r110, r117.getMeasuredHeight());
        if (r26 != 1) goto L34;
        r116 = r116 | ((long) (1 << r111));
        r17 = r17;
    L34:
        r113 = r119;
        goto L36
    L24:
        r25 = r17;
        goto L25
    L18:
        if (((ActionMenuItemView) r117).hasText() == false) goto L20;
        r24 = true;
        goto L21
    L14:
        r120 = 0;
        goto L15
    L37:
        int r121 = r11;
        if (r112 == false) goto L41;
        if (r113 != 2) goto L41;
        boolean r27 = true;
    L42:
        boolean r28 = false;
    L43:
        if (r115 <= 0) goto L78;
        if (r17 <= 0) goto L78;
        int r122 = Integer.MAX_VALUE;
        int r29 = 0;
        int r123 = 0;
        long r210 = 0;
    L46:
        if (r123 >= r20) goto L57;
        boolean r211 = r28;
        LayoutParams r32 = (LayoutParams) getChildAt(r123).getLayoutParams();
        int r212 = r110;
        if (r32.expandable == false) goto L56;
        int r33 = r32.cellsUsed;
        if (r33 >= r122) goto L54;
        r210 = 1 << r123;
        r122 = r33;
        r29 = 1;
        goto L56
    L54:
        if (r33 != r122) goto L56;
        r29 = r29 + 1;
        r210 = r210 | (1 << r123);
    L56:
        r123 = r123 + 1;
        r110 = r212;
        r28 = r211;
        goto L46
    L57:
        boolean r213 = r28;
        int r214 = r110;
        r116 = r116 | r210;
        if (r29 > r17) goto L80;
        int r124 = r122 + 1;
        int r34 = 0;
    L61:
        if (r34 >= r20) goto L77;
        View r35 = getChildAt(r34);
        LayoutParams r125 = (LayoutParams) r35.getLayoutParams();
        int r215 = r15;
        int r126 = r5;
        long r36 = 1 << r34;
        if ((r210 & r36) == 0) goto L65;
        if (r27 == false) goto L75;
        if (r125.preventEdgeOffset == false) goto L75;
        if (r17 != 1) goto L75;
        int r37 = this.mGeneratedItemPadding;
        r35.setPadding(r37 + r19, 0, r37, 0);
    L75:
        r125.cellsUsed++;
        r125.expanded = true;
        r17 = r17 - 1;
    L76:
        r34 = r34 + 1;
        r5 = r126;
        r15 = r215;
        r27 = r27;
        goto L61
    L65:
        if (r125.cellsUsed != r124) goto L67;
        r116 = r116 | r36;
    L67:
        r27 = r27;
        goto L76
    L77:
        r110 = r214;
        r28 = true;
    L80:
        if (r112 == true) goto L83;
        if (r113 != 1) goto L83;
        boolean r38 = true;
    L84:
        if (r17 > 0) goto L86;
    L92:
        int r127 = 0;
        boolean r39 = r213;
    L136:
        if (r39 == false) goto L144;
        int r40 = r127;
    L138:
        if (r40 >= r20) goto L144;
        View r41 = getChildAt(r40);
        LayoutParams r42 = (LayoutParams) r41.getLayoutParams();
        if (r42.expanded == false) goto L143;
        r41.measure(View.MeasureSpec.makeMeasureSpec((r42.cellsUsed * r19) + r42.extraPixels, BasicMeasure.EXACTLY), r14);
    L143:
        r40 = r40 + 1;
    L144:
        if (r5 == 1073741824) goto L147;
        int r43 = r214;
    L148:
        setMeasuredDimension(r15, r43);
        return;
    L147:
        r43 = r121;
        goto L148
    L86:
        if (r116 == 0) goto L92;
        if (r17 < (r113 - 1)) goto L93;
        if (r38 == true) goto L93;
        if (r114 <= 1) goto L92;
    L93:
        float r44 = Long.bitCount(r116);
        if (r38 == true) goto L105;
        r127 = 0;
        if ((r116 & 1) != 0) goto L98;
    L100:
        int r45 = r20 - 1;
        if ((r116 & ((long) (1 << r45))) == 0) goto L107;
        if (((LayoutParams) getChildAt(r45).getLayoutParams()).preventEdgeOffset == true) goto L107;
        r44 = r44 - 0.5f;
    L107:
        if (r44 <= 0.0f) goto L109;
        int r46 = (int) ((r17 * r19) / r44);
    L110:
        int r47 = r127;
        r39 = r213;
    L111:
        if (r47 >= r20) goto L136;
        if ((r116 & ((long) (1 << r47))) == 0) goto L133;
        View r48 = getChildAt(r47);
        LayoutParams r49 = (LayoutParams) r48.getLayoutParams();
        if ((r48 instanceof ActionMenuItemView) == false) goto L125;
        r49.extraPixels = r46;
        r49.expanded = true;
        if (r47 != 0) goto L123;
        if (r49.preventEdgeOffset == true) goto L123;
        ((LinearLayout.LayoutParams) r49).leftMargin = (-r46) / 2;
    L123:
        r39 = true;
        goto L133
    L125:
        if (r49.isOverflowButton == false) goto L128;
        r49.extraPixels = r46;
        r49.expanded = true;
        ((LinearLayout.LayoutParams) r49).rightMargin = (-r46) / 2;
        r39 = true;
        goto L133
    L128:
        if (r47 == 0) goto L131;
        ((LinearLayout.LayoutParams) r49).leftMargin = r46 / 2;
    L131:
        if (r47 == (r20 - 1)) goto L133;
        ((LinearLayout.LayoutParams) r49).rightMargin = r46 / 2;
    L133:
        r47 = r47 + 1;
        goto L111
    L109:
        r46 = r127;
        goto L110
    L98:
        if (((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset == true) goto L100;
        r44 = r44 - 0.5f;
        goto L100
    L105:
        r127 = 0;
    L83:
        r38 = false;
    L78:
        r213 = r28;
        r214 = r110;
    L41:
        r27 = false;
        goto L42
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        return r5 instanceof LayoutParams;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter r5 = this.mPresenter;
        if (r5 == null) goto L6;
        r5.dismissPopupMenus();
        return;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r5) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return generateLayoutParams(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams r5 = generateDefaultLayoutParams();
        r5.isOverflowButton = true;
        return r5;
    }

    public Menu getMenu() {
        if (this.mMenu != null) goto L10;
        Context r5 = getContext();
        MenuBuilder r10 = new MenuBuilder(r5);
        this.mMenu = r10;
        r10.setCallback(new MenuBuilderCallback(this));
        ActionMenuPresenter r11 = new ActionMenuPresenter(r5);
        this.mPresenter = r11;
        r11.setReserveOverflow(true);
        ActionMenuPresenter r12 = this.mPresenter;
        MenuPresenter.Callback r13 = this.mActionMenuPresenterCallback;
        if (r13 != null) goto L8;
        r13 = new ActionMenuPresenterCallback();
    L8:
        r12.setCallback(r13);
        this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
        this.mPresenter.setMenuView(this);
    L10:
        return this.mMenu;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getWindowAnimations() {
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean hasSupportDividerBeforeChildAt(int r5) {
        boolean r10 = false;
        if (r5 != 0) goto L5;
        return false;
    L5:
        KeyEvent.Callback r11 = getChildAt(r5 - 1);
        KeyEvent.Callback r12 = getChildAt(r5);
        if (r5 < getChildCount()) goto L8;
    L10:
        if (r5 > 0) goto L12;
        return r10;
    L12:
        if ((r12 instanceof ActionMenuChildView) == true) goto L14;
        return r10;
    L14:
        return r10 | ((ActionMenuChildView) r12).needsDividerBefore();
    L8:
        if ((r11 instanceof ActionMenuChildView) == false) goto L10;
        r10 = ((ActionMenuChildView) r11).needsDividerAfter();
        goto L10
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter r5 = this.mPresenter;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.hideOverflowMenu() == false) goto L7;
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void initialize(MenuBuilder r5) {
        this.mMenu = r5;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean invokeItem(MenuItemImpl r5) {
        return this.mMenu.performItemAction(r5, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter r5 = this.mPresenter;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isOverflowMenuShowPending() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter r5 = this.mPresenter;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isOverflowMenuShowing() == false) goto L7;
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        ActionMenuPresenter r10 = this.mPresenter;
        if (r10 == null) goto L8;
        r10.updateMenuView(false);
        if (this.mPresenter.isOverflowMenuShowing() == false) goto L9;
        this.mPresenter.hideOverflowMenu();
        this.mPresenter.showOverflowMenu();
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        if (this.mFormatItems == true) goto L6;
        super.onLayout(r18, r19, r20, r21, r22);
        return;
    L6:
        int r5 = getChildCount();
        int r10 = (r22 - r20) / 2;
        int r11 = getDividerWidth();
        int r12 = r21 - r19;
        int r13 = (r12 - getPaddingRight()) - getPaddingLeft();
        boolean r14 = ViewUtils.isLayoutRtl(this);
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
    L8:
        if (r15 >= r5) goto L24;
        View r110 = getChildAt(r15);
        if (r110.getVisibility() == 8) goto L23;
        LayoutParams r111 = (LayoutParams) r110.getLayoutParams();
        if (r111.isOverflowButton == false) goto L22;
        int r23 = r110.getMeasuredWidth();
        if (hasSupportDividerBeforeChildAt(r15) == false) goto L17;
        r23 = r23 + r11;
    L17:
        int r112 = r110.getMeasuredHeight();
        if (r14 == false) goto L20;
        int r113 = getPaddingLeft() + ((LinearLayout.LayoutParams) r111).leftMargin;
        int r114 = r113 + r23;
    L21:
        int r24 = r10 - (r112 / 2);
        r110.layout(r113, r24, r114, r112 + r24);
        r13 = r13 - r23;
        r16 = 1;
        goto L23
    L20:
        r114 = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) r111).rightMargin;
        r113 = r114 - r23;
        goto L21
    L22:
        r13 = r13 - ((r110.getMeasuredWidth() + ((LinearLayout.LayoutParams) r111).leftMargin) + ((LinearLayout.LayoutParams) r111).rightMargin);
        hasSupportDividerBeforeChildAt(r15);
        r17 = r17 + 1;
    L23:
        r15 = r15 + 1;
        goto L8
    L24:
        if (r5 != 1) goto L28;
        if (r16 != 0) goto L28;
        View r25 = getChildAt(0);
        int r26 = r25.getMeasuredWidth();
        int r27 = r25.getMeasuredHeight();
        int r28 = (r12 / 2) - (r26 / 2);
        int r29 = r10 - (r27 / 2);
        r25.layout(r28, r29, r26 + r28, r27 + r29);
        return;
    L28:
        int r115 = r17 - (r16 ^ 1);
        if (r115 <= 0) goto L32;
        int r30 = r13 / r115;
    L33:
        int r31 = Math.max(0, r30);
        if (r14 == false) goto L44;
        int r32 = getWidth() - getPaddingRight();
        int r33 = 0;
    L36:
        if (r33 >= r5) goto L53;
        View r34 = getChildAt(r33);
        LayoutParams r35 = (LayoutParams) r34.getLayoutParams();
        if (r34.getVisibility() == 8) goto L43;
        if (r35.isOverflowButton == true) goto L43;
        int r36 = r32 - ((LinearLayout.LayoutParams) r35).rightMargin;
        int r37 = r34.getMeasuredWidth();
        int r38 = r34.getMeasuredHeight();
        int r116 = r10 - (r38 / 2);
        r34.layout(r36 - r37, r116, r36, r38 + r116);
        r32 = r36 - ((r37 + ((LinearLayout.LayoutParams) r35).leftMargin) + r31);
    L43:
        r33 = r33 + 1;
        goto L36
    L53:
        return;
    L44:
        int r39 = getPaddingLeft();
        int r40 = 0;
    L45:
        if (r40 >= r5) goto L66;
        View r41 = getChildAt(r40);
        LayoutParams r42 = (LayoutParams) r41.getLayoutParams();
        if (r41.getVisibility() == 8) goto L52;
        if (r42.isOverflowButton == true) goto L52;
        int r43 = r39 + ((LinearLayout.LayoutParams) r42).leftMargin;
        int r44 = r41.getMeasuredWidth();
        int r45 = r41.getMeasuredHeight();
        int r117 = r10 - (r45 / 2);
        r41.layout(r43, r117, r43 + r44, r45 + r117);
        r39 = ((r44 + ((LinearLayout.LayoutParams) r42).rightMargin) + r31) + r43;
    L52:
        r40 = r40 + 1;
        goto L45
    L66:
        return;
    L32:
        r30 = 0;
        goto L33
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int r10, int r11) {
        boolean r5 = this.mFormatItems;
        if (View.MeasureSpec.getMode(r10) != 1073741824) goto L5;
        boolean r12 = true;
    L6:
        this.mFormatItems = r12;
        if (r5 == r12) goto L9;
        this.mFormatItemsWidth = 0;
    L9:
        int r13 = View.MeasureSpec.getSize(r10);
        if (this.mFormatItems == false) goto L16;
        MenuBuilder r14 = this.mMenu;
        if (r14 == null) goto L16;
        if (r13 == this.mFormatItemsWidth) goto L16;
        this.mFormatItemsWidth = r13;
        r14.onItemsChanged(true);
    L16:
        int r15 = getChildCount();
        if (this.mFormatItems == false) goto L20;
        if (r15 <= 0) goto L20;
        onMeasureExactFormat(r10, r11);
        return;
    L20:
        int r16 = 0;
    L21:
        if (r16 >= r15) goto L23;
        LayoutParams r17 = (LayoutParams) getChildAt(r16).getLayoutParams();
        ((LinearLayout.LayoutParams) r17).rightMargin = 0;
        ((LinearLayout.LayoutParams) r17).leftMargin = 0;
        r16 = r16 + 1;
        goto L21
    L23:
        super.onMeasure(r10, r11);
        return;
    L5:
        r12 = false;
        goto L6
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExpandedActionViewsExclusive(boolean r5) {
        this.mPresenter.setExpandedActionViewsExclusive(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback r5, MenuBuilder.Callback r10) {
        this.mActionMenuPresenterCallback = r5;
        this.mMenuBuilderCallback = r10;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener r5) {
        this.mOnMenuItemClickListener = r5;
    }

    public void setOverflowIcon(@Nullable Drawable r5) {
        getMenu();
        this.mPresenter.setOverflowIcon(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverflowReserved(boolean r5) {
        this.mReserveOverflow = r5;
    }

    public void setPopupTheme(@StyleRes int r5) {
        if (this.mPopupTheme == r5) goto L9;
        this.mPopupTheme = r5;
        if (r5 != 0) goto L7;
        this.mPopupContext = getContext();
        return;
    L7:
        this.mPopupContext = new ContextThemeWrapper(getContext(), r5);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPresenter(ActionMenuPresenter r5) {
        this.mPresenter = r5;
        r5.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter r5 = this.mPresenter;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.showOverflowMenu() == false) goto L7;
        return true;
    }

    public ActionMenuView(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
        setBaselineAligned(false);
        float r11 = r5.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * r11);
        this.mGeneratedItemPadding = (int) (r11 * 4.0f);
        this.mPopupContext = r5;
        this.mPopupTheme = 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return generateLayoutParams(r5);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams r5 = new LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) r5).gravity = 16;
        return r5;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet r5) {
        return generateLayoutParams(r5);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return generateLayoutParams(r5);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r5) {
        return new LayoutParams(getContext(), r5);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        if (r5 == null) goto L12;
        if ((r5 instanceof LayoutParams) == false) goto L6;
        LayoutParams r10 = new LayoutParams((LayoutParams) r5);
    L8:
        if (((LinearLayout.LayoutParams) r10).gravity > 0) goto L10;
        ((LinearLayout.LayoutParams) r10).gravity = 16;
    L10:
        return r10;
    L6:
        r10 = new LayoutParams(r5);
        goto L8
    L12:
        return generateDefaultLayoutParams();
    }
}
