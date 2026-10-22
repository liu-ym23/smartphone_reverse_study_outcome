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

    private static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder r10, boolean r11) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder r10) {
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

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.isOverflowButton = false;
        }

        LayoutParams(int r10, int r11, boolean r12) {
            super(r10, r11);
            this.isOverflowButton = r12;
        }

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
        }

        public LayoutParams(LayoutParams r10) {
            super(r10);
            this.isOverflowButton = r10.isOverflowButton;
        }
    }

    private class MenuBuilderCallback implements MenuBuilder.Callback {
        final /* synthetic */ ActionMenuView this$0;

        MenuBuilderCallback(ActionMenuView r10) {
            this.this$0 = r10;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(@NonNull MenuBuilder r10, @NonNull MenuItem r11) {
            OnMenuItemClickListener r12 = this.this$0.mOnMenuItemClickListener;
            if (r12 != null) goto L5;
        L7:
            return false;
        L5:
            if (r12.onMenuItemClick(r11) == false) goto L7;
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(@NonNull MenuBuilder r10) {
            MenuBuilder.Callback r11 = this.this$0.mMenuBuilderCallback;
            if (r11 == null) goto L6;
            r11.onMenuModeChange(r10);
            return;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r10);
    }

    public ActionMenuView(@NonNull Context r10) {
        this(r10, null);
    }

    public ActionMenuView(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        setBaselineAligned(false);
        float r12 = r10.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * r12);
        this.mGeneratedItemPadding = (int) (r12 * 4.0f);
        this.mPopupContext = r10;
        this.mPopupTheme = 0;
    }

    static int measureChildForCells(View r10, int r11, int r12, int r13, int r14) {
        LayoutParams r15 = (LayoutParams) r10.getLayoutParams();
        int r16 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r13) - r14, View.MeasureSpec.getMode(r13));
        if ((r10 instanceof ActionMenuItemView) == false) goto L5;
        ActionMenuItemView r17 = (ActionMenuItemView) r10;
    L6:
        boolean r18 = true;
        if (r17 != null) goto L9;
    L11:
        boolean r19 = false;
    L12:
        int r20 = 2;
        if (r12 <= 0) goto L23;
        if (r19 == false) goto L16;
        if (r12 < 2) goto L23;
    L16:
        r10.measure(View.MeasureSpec.makeMeasureSpec(r12 * r11, Integer.MIN_VALUE), r16);
        int r21 = r10.getMeasuredWidth();
        int r22 = r21 / r11;
        if ((r21 % r11) == 0) goto L19;
        r22 = r22 + 1;
    L19:
        if (r19 == false) goto L22;
        if (r22 >= 2) goto L22;
    L25:
        if (r15.isOverflowButton == true) goto L28;
        if (r19 == false) goto L28;
    L29:
        r15.expandable = r18;
        r15.cellsUsed = r20;
        r10.measure(View.MeasureSpec.makeMeasureSpec(r11 * r20, 1073741824), r16);
        return r20;
    L28:
        r18 = false;
    L22:
        r20 = r22;
    L23:
        r20 = 0;
        goto L25
    L9:
        if (r17.hasText() == false) goto L11;
        r19 = true;
        goto L12
    L5:
        r17 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v14 */
    private void onMeasureExactFormat(int r30, int r31) {
        int r10 = View.MeasureSpec.getMode(r31);
        int r11 = View.MeasureSpec.getSize(r30);
        int r12 = View.MeasureSpec.getSize(r31);
        int r13 = getPaddingLeft() + getPaddingRight();
        int r14 = getPaddingTop() + getPaddingBottom();
        int r15 = ViewGroup.getChildMeasureSpec(r31, r14, -2);
        int r16 = r11 - r13;
        int r17 = this.mMinCellSize;
        int r18 = r16 / r17;
        int r19 = r16 % r17;
        if (r18 != 0) goto L6;
        setMeasuredDimension(r16, 0);
        return;
    L6:
        int r20 = r17 + (r19 / r18);
        int r21 = getChildCount();
        int r110 = 0;
        int r111 = 0;
        boolean r112 = false;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
        long r116 = 0;
    L7:
        if (r111 >= r21) goto L37;
        View r117 = getChildAt(r111);
        int r118 = r12;
        if (r117.getVisibility() == 8) goto L36;
        boolean r22 = r117 instanceof ActionMenuItemView;
        int r119 = r113 + 1;
        if (r22 == false) goto L14;
        int r23 = this.mGeneratedItemPadding;
        ?? r120 = 0;
        r117.setPadding(r23, 0, r23, 0);
    L15:
        LayoutParams r24 = (LayoutParams) r117.getLayoutParams();
        r24.expanded = r120;
        r24.extraPixels = r120;
        r24.cellsUsed = r120;
        r24.expandable = r120;
        ((LinearLayout.LayoutParams) r24).leftMargin = r120;
        ((LinearLayout.LayoutParams) r24).rightMargin = r120;
        if (r22 == true) goto L18;
    L20:
        boolean r25 = false;
    L21:
        r24.preventEdgeOffset = r25;
        if (r24.isOverflowButton == false) goto L24;
        int r26 = 1;
    L25:
        int r27 = measureChildForCells(r117, r20, r26, r15, r14);
        r114 = Math.max(r114, r27);
        if (r24.expandable == false) goto L29;
        r115 = r115 + 1;
    L29:
        if (r24.isOverflowButton == false) goto L31;
        r112 = true;
    L31:
        r18 = r18 - r27;
        r110 = Math.max(r110, r117.getMeasuredHeight());
        if (r27 != 1) goto L35;
        r116 = r116 | ((long) (1 << r111));
        r110 = r110;
    L35:
        r113 = r119;
        goto L36
    L24:
        r26 = r18;
        goto L25
    L18:
        if (((ActionMenuItemView) r117).hasText() == false) goto L20;
        r25 = true;
        goto L21
    L14:
        r120 = 0;
    L36:
        r111 = r111 + 1;
        r12 = r118;
        goto L7
    L37:
        int r121 = r12;
        if (r112 == false) goto L41;
        if (r113 != 2) goto L41;
        boolean r28 = true;
    L42:
        boolean r29 = false;
    L43:
        if (r115 <= 0) goto L77;
        if (r18 <= 0) goto L77;
        int r122 = Integer.MAX_VALUE;
        int r32 = 0;
        int r123 = 0;
        long r210 = 0;
    L46:
        if (r123 >= r21) goto L56;
        boolean r211 = r29;
        LayoutParams r33 = (LayoutParams) getChildAt(r123).getLayoutParams();
        int r212 = r110;
        if (r33.expandable == false) goto L55;
        int r34 = r33.cellsUsed;
        if (r34 >= r122) goto L53;
        r210 = 1 << r123;
        r122 = r34;
        r32 = 1;
        goto L55
    L53:
        if (r34 != r122) goto L55;
        r32 = r32 + 1;
        r210 = r210 | (1 << r123);
    L55:
        r123 = r123 + 1;
        r110 = r212;
        r29 = r211;
        goto L46
    L56:
        boolean r213 = r29;
        int r214 = r110;
        r116 = r116 | r210;
        if (r32 > r18) goto L79;
        int r124 = r122 + 1;
        int r35 = 0;
    L60:
        if (r35 >= r21) goto L76;
        View r36 = getChildAt(r35);
        LayoutParams r125 = (LayoutParams) r36.getLayoutParams();
        int r215 = r16;
        int r126 = r10;
        long r37 = 1 << r35;
        if ((r210 & r37) == 0) goto L64;
        if (r28 == false) goto L74;
        if (r125.preventEdgeOffset == false) goto L74;
        if (r18 != 1) goto L74;
        int r38 = this.mGeneratedItemPadding;
        r36.setPadding(r38 + r20, 0, r38, 0);
    L74:
        r125.cellsUsed++;
        r125.expanded = true;
        r18 = r18 - 1;
    L75:
        r35 = r35 + 1;
        r10 = r126;
        r16 = r215;
        r28 = r28;
        goto L60
    L64:
        if (r125.cellsUsed != r124) goto L66;
        r116 = r116 | r37;
    L66:
        r28 = r28;
        goto L75
    L76:
        r110 = r214;
        r29 = true;
    L79:
        if (r112 == true) goto L82;
        if (r113 != 1) goto L82;
        boolean r39 = true;
    L83:
        if (r18 > 0) goto L85;
    L131:
        int r127 = 0;
        boolean r40 = r213;
    L133:
        if (r40 == false) goto L141;
        int r41 = r127;
    L135:
        if (r41 >= r21) goto L141;
        View r42 = getChildAt(r41);
        LayoutParams r43 = (LayoutParams) r42.getLayoutParams();
        if (r43.expanded == false) goto L140;
        r42.measure(View.MeasureSpec.makeMeasureSpec((r43.cellsUsed * r20) + r43.extraPixels, 1073741824), r15);
    L140:
        r41 = r41 + 1;
    L141:
        if (r10 == 1073741824) goto L143;
        int r44 = r214;
    L144:
        setMeasuredDimension(r16, r44);
        return;
    L143:
        r44 = r121;
        goto L144
    L85:
        if (r116 == 0) goto L131;
        if (r18 < (r113 - 1)) goto L90;
        if (r39 == true) goto L90;
        if (r114 <= 1) goto L131;
    L90:
        float r45 = Long.bitCount(r116);
        if (r39 == true) goto L102;
        r127 = 0;
        if ((r116 & 1) != 0) goto L95;
    L97:
        int r46 = r21 - 1;
        if ((r116 & ((long) (1 << r46))) == 0) goto L104;
        if (((LayoutParams) getChildAt(r46).getLayoutParams()).preventEdgeOffset == true) goto L104;
        r45 = r45 - 0.5f;
    L104:
        if (r45 <= 0.0f) goto L106;
        int r47 = (int) ((r18 * r20) / r45);
    L107:
        int r48 = r127;
        r40 = r213;
    L108:
        if (r48 >= r21) goto L133;
        if ((r116 & ((long) (1 << r48))) == 0) goto L130;
        View r49 = getChildAt(r48);
        LayoutParams r50 = (LayoutParams) r49.getLayoutParams();
        if ((r49 instanceof ActionMenuItemView) == false) goto L122;
        r50.extraPixels = r47;
        r50.expanded = true;
        if (r48 != 0) goto L120;
        if (r50.preventEdgeOffset == true) goto L120;
        ((LinearLayout.LayoutParams) r50).leftMargin = (-r47) / 2;
    L120:
        r40 = true;
        goto L130
    L122:
        if (r50.isOverflowButton == false) goto L125;
        r50.extraPixels = r47;
        r50.expanded = true;
        ((LinearLayout.LayoutParams) r50).rightMargin = (-r47) / 2;
        r40 = true;
        goto L130
    L125:
        if (r48 == 0) goto L128;
        ((LinearLayout.LayoutParams) r50).leftMargin = r47 / 2;
    L128:
        if (r48 == (r21 - 1)) goto L130;
        ((LinearLayout.LayoutParams) r50).rightMargin = r47 / 2;
    L130:
        r48 = r48 + 1;
        goto L108
    L106:
        r47 = r127;
        goto L107
    L95:
        if (((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset == true) goto L97;
        r45 = r45 - 0.5f;
        goto L97
    L102:
        r127 = 0;
    L82:
        r39 = false;
    L77:
        r213 = r29;
        r214 = r110;
    L41:
        r28 = false;
        goto L42
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter r10 = this.mPresenter;
        if (r10 == null) goto L6;
        r10.dismissPopupMenus();
        return;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r10) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams r10 = new LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) r10).gravity = 16;
        return r10;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateLayoutParams(r10);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        if (r10 == null) goto L12;
        if ((r10 instanceof LayoutParams) == false) goto L6;
        LayoutParams r11 = new LayoutParams((LayoutParams) r10);
    L8:
        if (((LinearLayout.LayoutParams) r11).gravity > 0) goto L10;
        ((LinearLayout.LayoutParams) r11).gravity = 16;
    L10:
        return r11;
    L6:
        r11 = new LayoutParams(r10);
        goto L8
    L12:
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateLayoutParams(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams r10 = generateDefaultLayoutParams();
        r10.isOverflowButton = true;
        return r10;
    }

    public Menu getMenu() {
        if (this.mMenu != null) goto L10;
        Context r10 = getContext();
        MenuBuilder r11 = new MenuBuilder(r10);
        this.mMenu = r11;
        r11.setCallback(new MenuBuilderCallback(this));
        ActionMenuPresenter r12 = new ActionMenuPresenter(r10);
        this.mPresenter = r12;
        r12.setReserveOverflow(true);
        ActionMenuPresenter r13 = this.mPresenter;
        MenuPresenter.Callback r14 = this.mActionMenuPresenterCallback;
        if (r14 != null) goto L8;
        r14 = new ActionMenuPresenterCallback();
    L8:
        r13.setCallback(r14);
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
    protected boolean hasSupportDividerBeforeChildAt(int r10) {
        boolean r11 = false;
        if (r10 != 0) goto L5;
        return false;
    L5:
        KeyEvent.Callback r12 = getChildAt(r10 - 1);
        KeyEvent.Callback r13 = getChildAt(r10);
        if (r10 < getChildCount()) goto L8;
    L10:
        if (r10 > 0) goto L12;
        return r11;
    L12:
        if ((r13 instanceof ActionMenuChildView) == true) goto L14;
        return r11;
    L14:
        return r11 | ((ActionMenuChildView) r13).needsDividerBefore();
    L8:
        if ((r12 instanceof ActionMenuChildView) == false) goto L10;
        r11 = false | ((ActionMenuChildView) r12).needsDividerAfter();
        goto L10
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter r10 = this.mPresenter;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.hideOverflowMenu() == false) goto L7;
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void initialize(MenuBuilder r10) {
        this.mMenu = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean invokeItem(MenuItemImpl r10) {
        return this.mMenu.performItemAction(r10, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter r10 = this.mPresenter;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isOverflowMenuShowPending() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter r10 = this.mPresenter;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isOverflowMenuShowing() == false) goto L7;
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        ActionMenuPresenter r11 = this.mPresenter;
        if (r11 == null) goto L8;
        r11.updateMenuView(false);
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
    protected void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        if (this.mFormatItems == true) goto L6;
        super.onLayout(r18, r19, r20, r21, r22);
        return;
    L6:
        int r10 = getChildCount();
        int r11 = (r22 - r20) / 2;
        int r12 = getDividerWidth();
        int r13 = r21 - r19;
        int r14 = (r13 - getPaddingRight()) - getPaddingLeft();
        boolean r15 = ViewUtils.isLayoutRtl(this);
        int r16 = 0;
        int r17 = 0;
        int r110 = 0;
    L8:
        if (r16 >= r10) goto L24;
        View r111 = getChildAt(r16);
        if (r111.getVisibility() == 8) goto L23;
        LayoutParams r112 = (LayoutParams) r111.getLayoutParams();
        if (r112.isOverflowButton == false) goto L22;
        int r23 = r111.getMeasuredWidth();
        if (hasSupportDividerBeforeChildAt(r16) == false) goto L17;
        r23 = r23 + r12;
    L17:
        int r113 = r111.getMeasuredHeight();
        if (r15 == false) goto L20;
        int r114 = getPaddingLeft() + ((LinearLayout.LayoutParams) r112).leftMargin;
        int r115 = r114 + r23;
    L21:
        int r24 = r11 - (r113 / 2);
        r111.layout(r114, r24, r115, r113 + r24);
        r14 = r14 - r23;
        r17 = 1;
        goto L23
    L20:
        r115 = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) r112).rightMargin;
        r114 = r115 - r23;
        goto L21
    L22:
        r14 = r14 - ((r111.getMeasuredWidth() + ((LinearLayout.LayoutParams) r112).leftMargin) + ((LinearLayout.LayoutParams) r112).rightMargin);
        hasSupportDividerBeforeChildAt(r16);
        r110 = r110 + 1;
    L23:
        r16 = r16 + 1;
        goto L8
    L24:
        if (r10 != 1) goto L28;
        if (r17 != 0) goto L28;
        View r25 = getChildAt(0);
        int r26 = r25.getMeasuredWidth();
        int r27 = r25.getMeasuredHeight();
        int r28 = (r13 / 2) - (r26 / 2);
        int r29 = r11 - (r27 / 2);
        r25.layout(r28, r29, r26 + r28, r27 + r29);
        return;
    L28:
        int r116 = r110 - (r17 ^ 1);
        if (r116 <= 0) goto L31;
        int r30 = r14 / r116;
    L32:
        int r31 = Math.max(0, r30);
        if (r15 == false) goto L43;
        int r32 = getWidth() - getPaddingRight();
        int r33 = 0;
    L35:
        if (r33 >= r10) goto L52;
        View r34 = getChildAt(r33);
        LayoutParams r35 = (LayoutParams) r34.getLayoutParams();
        if (r34.getVisibility() == 8) goto L42;
        if (r35.isOverflowButton == true) goto L42;
        int r36 = r32 - ((LinearLayout.LayoutParams) r35).rightMargin;
        int r37 = r34.getMeasuredWidth();
        int r38 = r34.getMeasuredHeight();
        int r117 = r11 - (r38 / 2);
        r34.layout(r36 - r37, r117, r36, r38 + r117);
        r32 = r36 - ((r37 + ((LinearLayout.LayoutParams) r35).leftMargin) + r31);
    L42:
        r33 = r33 + 1;
        goto L35
    L52:
        return;
    L43:
        int r39 = getPaddingLeft();
        int r40 = 0;
    L44:
        if (r40 >= r10) goto L65;
        View r41 = getChildAt(r40);
        LayoutParams r42 = (LayoutParams) r41.getLayoutParams();
        if (r41.getVisibility() == 8) goto L51;
        if (r42.isOverflowButton == true) goto L51;
        int r43 = r39 + ((LinearLayout.LayoutParams) r42).leftMargin;
        int r44 = r41.getMeasuredWidth();
        int r45 = r41.getMeasuredHeight();
        int r118 = r11 - (r45 / 2);
        r41.layout(r43, r118, r43 + r44, r45 + r118);
        r39 = r43 + ((r44 + ((LinearLayout.LayoutParams) r42).rightMargin) + r31);
    L51:
        r40 = r40 + 1;
        goto L44
    L65:
        return;
    L31:
        r30 = 0;
        goto L32
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int r10, int r11) {
        boolean r12 = this.mFormatItems;
        if (View.MeasureSpec.getMode(r10) != 1073741824) goto L5;
        boolean r13 = true;
    L6:
        this.mFormatItems = r13;
        if (r12 == r13) goto L9;
        this.mFormatItemsWidth = 0;
    L9:
        int r14 = View.MeasureSpec.getSize(r10);
        if (this.mFormatItems == false) goto L16;
        MenuBuilder r15 = this.mMenu;
        if (r15 == null) goto L16;
        if (r14 == this.mFormatItemsWidth) goto L16;
        this.mFormatItemsWidth = r14;
        r15.onItemsChanged(true);
    L16:
        int r16 = getChildCount();
        if (this.mFormatItems == false) goto L20;
        if (r16 <= 0) goto L20;
        onMeasureExactFormat(r10, r11);
        return;
    L20:
        int r17 = 0;
    L21:
        if (r17 >= r16) goto L23;
        LayoutParams r18 = (LayoutParams) getChildAt(r17).getLayoutParams();
        ((LinearLayout.LayoutParams) r18).rightMargin = 0;
        ((LinearLayout.LayoutParams) r18).leftMargin = 0;
        r17 = r17 + 1;
        goto L21
    L23:
        super.onMeasure(r10, r11);
        return;
    L5:
        r13 = false;
        goto L6
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExpandedActionViewsExclusive(boolean r10) {
        this.mPresenter.setExpandedActionViewsExclusive(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback r10, MenuBuilder.Callback r11) {
        this.mActionMenuPresenterCallback = r10;
        this.mMenuBuilderCallback = r11;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener r10) {
        this.mOnMenuItemClickListener = r10;
    }

    public void setOverflowIcon(@Nullable Drawable r10) {
        getMenu();
        this.mPresenter.setOverflowIcon(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverflowReserved(boolean r10) {
        this.mReserveOverflow = r10;
    }

    public void setPopupTheme(@StyleRes int r10) {
        if (this.mPopupTheme == r10) goto L9;
        this.mPopupTheme = r10;
        if (r10 != 0) goto L7;
        this.mPopupContext = getContext();
        return;
    L7:
        this.mPopupContext = new ContextThemeWrapper(getContext(), r10);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPresenter(ActionMenuPresenter r10) {
        this.mPresenter = r10;
        r10.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter r10 = this.mPresenter;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.showOverflowMenu() == false) goto L7;
        return true;
    }
}
