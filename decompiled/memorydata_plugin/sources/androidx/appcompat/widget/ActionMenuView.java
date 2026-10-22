package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    private static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder r1, boolean r2) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder r1) {
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

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.isOverflowButton = false;
        }

        LayoutParams(int r1, int r2, boolean r3) {
            super(r1, r2);
            this.isOverflowButton = r3;
        }

        public LayoutParams(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(LayoutParams r1) {
            super(r1);
            this.isOverflowButton = r1.isOverflowButton;
        }
    }

    private class MenuBuilderCallback implements MenuBuilder.Callback {
        final /* synthetic */ ActionMenuView this$0;

        MenuBuilderCallback(ActionMenuView r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder r2, MenuItem r3) {
            MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
            if (this.this$0.mOnMenuItemClickListener != null) goto L5;
        L7:
            return false;
        L5:
            if (this.this$0.mOnMenuItemClickListener.onMenuItemClick(r4) == false) goto L7;
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder r2) {
            if (this.this$0.mMenuBuilderCallback == null) goto L6;
            this.this$0.mMenuBuilderCallback.onMenuModeChange(r2);
            return;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r1);
    }

    public ActionMenuView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public ActionMenuView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(r6, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"));
        setBaselineAligned(false);
        float r0 = ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * r0);
        this.mGeneratedItemPadding = (int) (r0 * 4.0f);
        this.mPopupContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.mPopupTheme = 0;
    }

    static int measureChildForCells(View r5, int r6, int r7, int r8, int r9) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r10 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r8) - r9, View.MeasureSpec.getMode(r8));
        if (ZeusTransformUtils.instanceOf(r5, ActionMenuItemView.class) == false) goto L5;
        ActionMenuItemView r11 = (ActionMenuItemView) ZeusTransformUtils.preCheckCast(r5, ActionMenuItemView.class, "com.obric.memorydata.plugin");
    L6:
        boolean r1 = true;
        if (r11 != null) goto L9;
    L11:
        boolean r12 = false;
    L12:
        int r3 = 2;
        if (r7 <= 0) goto L23;
        if (r12 == false) goto L16;
        if (r7 < 2) goto L23;
    L16:
        r5.measure(View.MeasureSpec.makeMeasureSpec(r7 * r6, Integer.MIN_VALUE), r10);
        int r13 = r5.getMeasuredWidth();
        int r4 = r13 / r6;
        if ((r13 % r6) == 0) goto L19;
        r4 = r4 + 1;
    L19:
        if (r12 == false) goto L22;
        if (r4 >= 2) goto L22;
    L25:
        if (r0.isOverflowButton == true) goto L28;
        if (r12 == false) goto L28;
    L29:
        r0.expandable = r1;
        r0.cellsUsed = r3;
        r5.measure(View.MeasureSpec.makeMeasureSpec(r6 * r3, 1073741824), r10);
        return r3;
    L28:
        r1 = false;
    L22:
        r3 = r4;
    L23:
        r3 = 0;
        goto L25
    L9:
        if (r11.hasText() == false) goto L11;
        r12 = true;
        goto L12
    L5:
        r11 = null;
        goto L6
    }

    private void onMeasureExactFormat(int r32, int r33) {
        int r1 = View.MeasureSpec.getMode(r33);
        int r2 = View.MeasureSpec.getSize(r32);
        int r3 = View.MeasureSpec.getSize(r33);
        int r4 = getPaddingLeft() + getPaddingRight();
        int r5 = getPaddingTop() + getPaddingBottom();
        int r6 = getChildMeasureSpec(r33, r5, -2);
        int r7 = r2 - r4;
        int r8 = this.mMinCellSize;
        int r9 = r7 / r8;
        int r10 = r7 % r8;
        if (r9 != 0) goto L6;
        setMeasuredDimension(r7, 0);
        return;
    L6:
        int r11 = r8 + (r10 / r9);
        int r12 = getChildCount();
        int r13 = 0;
        int r14 = 0;
        boolean r15 = false;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        long r19 = 0;
    L7:
        String r110 = "com.obric.memorydata.plugin";
        if (r14 >= r12) goto L37;
        View r20 = getChildAt(r14);
        int r111 = r3;
        int r21 = r7;
        if (r20.getVisibility() == 8) goto L36;
        boolean r22 = ZeusTransformUtils.instanceOf(r20, ActionMenuItemView.class);
        int r112 = r16 + 1;
        if (r22 == false) goto L16;
        int r23 = this.mGeneratedItemPadding;
        r20.setPadding(r23, 0, r23, 0);
    L16:
        LayoutParams r24 = (LayoutParams) ZeusTransformUtils.preCheckCast(r20.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        r24.expanded = false;
        r24.extraPixels = 0;
        r24.cellsUsed = 0;
        r24.expandable = false;
        r24.leftMargin = 0;
        r24.rightMargin = 0;
        if (r22 == true) goto L19;
    L21:
        boolean r25 = false;
    L22:
        r24.preventEdgeOffset = r25;
        if (r24.isOverflowButton == false) goto L25;
        int r26 = 1;
    L26:
        int r27 = measureChildForCells(r20, r11, r26, r6, r5);
        r17 = Math.max(r17, r27);
        if (r24.expandable == false) goto L30;
        r18 = r18 + 1;
    L30:
        if (r24.isOverflowButton == false) goto L32;
        r15 = true;
    L32:
        r9 = r9 - r27;
        r13 = Math.max(r13, r20.getMeasuredHeight());
        if (r27 != 1) goto L35;
        r19 = r19 | ((long) (1 << r14));
    L35:
        r16 = r112;
        goto L36
    L25:
        r26 = r9;
        goto L26
    L19:
        if (((ActionMenuItemView) ZeusTransformUtils.preCheckCast(r20, ActionMenuItemView.class, "com.obric.memorydata.plugin")).hasText() == false) goto L21;
        r25 = true;
    L36:
        r14 = r14 + 1;
        r3 = r111;
        r7 = r21;
        goto L7
    L37:
        int r28 = r7;
        int r113 = r3;
        if (r15 == false) goto L41;
        if (r16 != 2) goto L41;
        boolean r29 = true;
    L42:
        boolean r30 = false;
    L44:
        if (r18 <= 0) goto L78;
        if (r9 <= 0) goto L78;
        int r31 = Integer.MAX_VALUE;
        int r34 = 0;
        int r114 = 0;
        long r210 = 0;
    L47:
        if (r114 >= r12) goto L58;
        boolean r211 = r30;
        int r212 = r13;
        LayoutParams r35 = (LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r114).getLayoutParams(), LayoutParams.class, r110);
        if (r35.expandable == false) goto L57;
        if (r35.cellsUsed >= r31) goto L55;
        r210 = 1 << r114;
        r31 = r35.cellsUsed;
        r34 = 1;
        goto L57
    L55:
        if (r35.cellsUsed != r31) goto L57;
        r210 = r210 | (1 << r114);
        r34 = r34 + 1;
    L57:
        r114 = r114 + 1;
        r13 = r212;
        r30 = r211;
        goto L47
    L58:
        boolean r213 = r30;
        int r214 = r13;
        r19 = r19 | r210;
        if (r34 > r9) goto L61;
        int r36 = r31 + 1;
        int r37 = 0;
    L63:
        if (r37 >= r12) goto L77;
        View r38 = getChildAt(r37);
        LayoutParams r115 = (LayoutParams) ZeusTransformUtils.preCheckCast(r38.getLayoutParams(), LayoutParams.class, r110);
        int r215 = r1;
        String r216 = r110;
        long r116 = 1 << r37;
        if ((r210 & r116) == 0) goto L67;
        if (r29 == true) goto L71;
    L75:
        r115.cellsUsed++;
        r115.expanded = true;
        r9 = r9 - 1;
    L76:
        r37 = r37 + 1;
        r1 = r215;
        r110 = r216;
        goto L63
    L71:
        if (r115.preventEdgeOffset == false) goto L75;
        if (r9 != 1) goto L75;
        int r117 = this.mGeneratedItemPadding;
        r38.setPadding(r117 + r11, 0, r117, 0);
        goto L75
    L67:
        if (r115.cellsUsed != r36) goto L76;
        r19 = r19 | r116;
        goto L76
    L77:
        r13 = r214;
        r30 = true;
    L61:
        String r217 = r110;
        if (r15 == true) goto L83;
        if (r16 != 1) goto L83;
        boolean r39 = true;
    L84:
        if (r9 > 0) goto L86;
    L135:
        String r40 = r217;
        int r118 = 0;
        boolean r41 = r213;
    L137:
        if (r41 == false) goto L145;
    L138:
        if (r118 >= r12) goto L145;
        View r42 = getChildAt(r118);
        LayoutParams r43 = (LayoutParams) ZeusTransformUtils.preCheckCast(r42.getLayoutParams(), LayoutParams.class, r40);
        if (r43.expanded == false) goto L143;
        r42.measure(View.MeasureSpec.makeMeasureSpec((r43.cellsUsed * r11) + r43.extraPixels, 1073741824), r6);
    L143:
        r118 = r118 + 1;
    L145:
        if (r1 == 1073741824) goto L147;
        int r44 = r214;
    L148:
        setMeasuredDimension(r28, r44);
        return;
    L147:
        r44 = r113;
        goto L148
    L86:
        if (r19 == 0) goto L135;
        if (r9 < (r16 - 1)) goto L91;
        if (r39 == true) goto L91;
        if (r17 <= 1) goto L135;
    L91:
        float r45 = Long.bitCount(r19);
        if (r39 == false) goto L94;
        r40 = r217;
        r118 = 0;
    L106:
        if (r45 <= 0.0f) goto L108;
        int r46 = (int) ((r9 * r11) / r45);
    L109:
        int r47 = r118;
        boolean r48 = r213;
    L110:
        if (r47 >= r12) goto L134;
        if ((r19 & ((long) (1 << r47))) == 0) goto L133;
        View r49 = getChildAt(r47);
        LayoutParams r50 = (LayoutParams) ZeusTransformUtils.preCheckCast(r49.getLayoutParams(), LayoutParams.class, r40);
        if (ZeusTransformUtils.instanceOf(r49, ActionMenuItemView.class) == false) goto L125;
        r50.extraPixels = r46;
        r50.expanded = true;
        if (r47 != 0) goto L122;
        if (r50.preventEdgeOffset == true) goto L122;
        r50.leftMargin = (-r46) / 2;
    L122:
        r48 = true;
        goto L133
    L125:
        if (r50.isOverflowButton == false) goto L128;
        r50.extraPixels = r46;
        r50.expanded = true;
        r50.rightMargin = (-r46) / 2;
        r48 = true;
        goto L133
    L128:
        if (r47 == 0) goto L131;
        r50.leftMargin = r46 / 2;
    L131:
        if (r47 == (r12 - 1)) goto L133;
        r50.rightMargin = r46 / 2;
    L133:
        r47 = r47 + 1;
        goto L110
    L134:
        r41 = r48;
        goto L137
    L108:
        r46 = r118;
        goto L109
    L94:
        if ((r19 & 1) == 0) goto L98;
        r118 = 0;
        r40 = r217;
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(0).getLayoutParams(), LayoutParams.class, r40)).preventEdgeOffset == true) goto L99;
        r45 = r45 - 0.5f;
    L99:
        int r51 = r12 - 1;
        if ((r19 & ((long) (1 << r51))) == 0) goto L106;
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r51).getLayoutParams(), LayoutParams.class, r40)).preventEdgeOffset == true) goto L106;
        r45 = r45 - 0.5f;
        goto L106
    L98:
        r40 = r217;
        r118 = 0;
    L83:
        r39 = false;
    L78:
        r213 = r30;
        r214 = r13;
    L41:
        r29 = false;
        goto L42
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, LayoutParams.class);
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter r0 = this.mPresenter;
        if (r0 == null) goto L6;
        r0.dismissPopupMenus();
        return;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r1) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams r1 = new LayoutParams(-2, -2);
        r1.gravity = 16;
        return r1;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r3) {
        if (r3 == null) goto L12;
        if (ZeusTransformUtils.instanceOf(r3, LayoutParams.class) == false) goto L6;
        LayoutParams r2 = new LayoutParams((LayoutParams) ZeusTransformUtils.preCheckCast(r3, LayoutParams.class, "com.obric.memorydata.plugin"));
    L8:
        if (r2.gravity > 0) goto L10;
        r2.gravity = 16;
    L10:
        return r2;
    L6:
        r2 = new LayoutParams(r3);
        goto L8
    L12:
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams r1 = generateDefaultLayoutParams();
        r1.isOverflowButton = true;
        return r1;
    }

    public Menu getMenu() {
        if (this.mMenu != null) goto L10;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        MenuBuilder r1 = new MenuBuilder(r0);
        this.mMenu = r1;
        r1.setCallback(new MenuBuilderCallback(this));
        ActionMenuPresenter r2 = new ActionMenuPresenter(r0);
        this.mPresenter = r2;
        r2.setReserveOverflow(true);
        ActionMenuPresenter r3 = this.mPresenter;
        MenuPresenter.Callback r4 = this.mActionMenuPresenterCallback;
        if (r4 != null) goto L8;
        r4 = new ActionMenuPresenterCallback();
    L8:
        r3.setCallback(r4);
        this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
        this.mPresenter.setMenuView(this);
    L10:
        return this.mMenu;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    public boolean hasSupportDividerBeforeChildAt(int r5) {
        boolean r0 = false;
        if (r5 != 0) goto L5;
        return false;
    L5:
        View r1 = getChildAt(r5 - 1);
        View r2 = getChildAt(r5);
        if (r5 < getChildCount()) goto L8;
    L10:
        if (r5 > 0) goto L12;
        return r0;
    L12:
        if (ZeusTransformUtils.instanceOf(r2, ActionMenuChildView.class) == true) goto L14;
        return r0;
    L14:
        return r0 | ((ActionMenuChildView) ZeusTransformUtils.preCheckCast(r2, ActionMenuChildView.class, "com.obric.memorydata.plugin")).needsDividerBefore();
    L8:
        if (ZeusTransformUtils.instanceOf(r1, ActionMenuChildView.class) == false) goto L10;
        r0 = false | ((ActionMenuChildView) ZeusTransformUtils.preCheckCast(r1, ActionMenuChildView.class, "com.obric.memorydata.plugin")).needsDividerAfter();
        goto L10
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter r0 = this.mPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hideOverflowMenu() == false) goto L7;
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder r1) {
        this.mMenu = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public boolean invokeItem(MenuItemImpl r2) {
        return this.mMenu.performItemAction(r2, 0);
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter r0 = this.mPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOverflowMenuShowPending() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter r0 = this.mPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOverflowMenuShowing() == false) goto L7;
        return true;
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        ActionMenuPresenter r3 = this.mPresenter;
        if (r3 == null) goto L8;
        r3.updateMenuView(false);
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
        int r1 = getChildCount();
        int r2 = (r22 - r20) / 2;
        int r3 = getDividerWidth();
        int r4 = r21 - r19;
        int r5 = (r4 - getPaddingRight()) - getPaddingLeft();
        boolean r6 = ViewUtils.isLayoutRtl(this);
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
    L8:
        if (r8 >= r1) goto L24;
        View r14 = getChildAt(r8);
        if (r14.getVisibility() == 8) goto L23;
        LayoutParams r11 = (LayoutParams) ZeusTransformUtils.preCheckCast(r14.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r11.isOverflowButton == false) goto L22;
        int r12 = r14.getMeasuredWidth();
        if (hasSupportDividerBeforeChildAt(r8) == false) goto L17;
        r12 = r12 + r3;
    L17:
        int r13 = r14.getMeasuredHeight();
        if (r6 == false) goto L20;
        int r15 = getPaddingLeft() + r11.leftMargin;
        int r16 = r15 + r12;
    L21:
        int r7 = r2 - (r13 / 2);
        r14.layout(r15, r7, r16, r13 + r7);
        r5 = r5 - r12;
        r9 = 1;
        goto L23
    L20:
        r16 = (getWidth() - getPaddingRight()) - r11.rightMargin;
        r15 = r16 - r12;
        goto L21
    L22:
        r5 = r5 - ((r14.getMeasuredWidth() + r11.leftMargin) + r11.rightMargin);
        hasSupportDividerBeforeChildAt(r8);
        r10 = r10 + 1;
    L23:
        r8 = r8 + 1;
        goto L8
    L24:
        if (r1 != 1) goto L28;
        if (r9 != 0) goto L28;
        View r0 = getChildAt(0);
        int r17 = r0.getMeasuredWidth();
        int r23 = r0.getMeasuredHeight();
        int r24 = (r4 / 2) - (r17 / 2);
        int r25 = r2 - (r23 / 2);
        r0.layout(r24, r25, r17 + r24, r23 + r25);
        return;
    L28:
        int r110 = r10 - (r9 ^ 1);
        if (r110 <= 0) goto L31;
        int r26 = r5 / r110;
    L32:
        int r27 = Math.max(0, r26);
        if (r6 == false) goto L43;
        int r28 = getWidth() - getPaddingRight();
        int r29 = 0;
    L35:
        if (r29 >= r1) goto L52;
        View r30 = getChildAt(r29);
        LayoutParams r31 = (LayoutParams) ZeusTransformUtils.preCheckCast(r30.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r30.getVisibility() == 8) goto L42;
        if (r31.isOverflowButton == true) goto L42;
        int r32 = r28 - r31.rightMargin;
        int r33 = r30.getMeasuredWidth();
        int r34 = r30.getMeasuredHeight();
        int r111 = r2 - (r34 / 2);
        r30.layout(r32 - r33, r111, r32, r34 + r111);
        r28 = r32 - ((r33 + r31.leftMargin) + r27);
    L42:
        r29 = r29 + 1;
        goto L35
    L52:
        return;
    L43:
        int r35 = getPaddingLeft();
        int r36 = 0;
    L44:
        if (r36 >= r1) goto L65;
        View r37 = getChildAt(r36);
        LayoutParams r38 = (LayoutParams) ZeusTransformUtils.preCheckCast(r37.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r37.getVisibility() == 8) goto L51;
        if (r38.isOverflowButton == true) goto L51;
        int r39 = r35 + r38.leftMargin;
        int r40 = r37.getMeasuredWidth();
        int r41 = r37.getMeasuredHeight();
        int r112 = r2 - (r41 / 2);
        r37.layout(r39, r112, r39 + r40, r41 + r112);
        r35 = r39 + ((r40 + r38.rightMargin) + r27);
    L51:
        r36 = r36 + 1;
        goto L44
    L65:
        return;
    L31:
        r26 = 0;
        goto L32
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int r7, int r8) {
        boolean r0 = this.mFormatItems;
        if (View.MeasureSpec.getMode(r7) != 1073741824) goto L5;
        boolean r1 = true;
    L6:
        this.mFormatItems = r1;
        if (r0 == r1) goto L9;
        this.mFormatItemsWidth = 0;
    L9:
        int r2 = View.MeasureSpec.getSize(r7);
        if (this.mFormatItems == false) goto L16;
        MenuBuilder r3 = this.mMenu;
        if (r3 == null) goto L16;
        if (r2 == this.mFormatItemsWidth) goto L16;
        this.mFormatItemsWidth = r2;
        r3.onItemsChanged(true);
    L16:
        int r4 = getChildCount();
        if (this.mFormatItems == false) goto L20;
        if (r4 <= 0) goto L20;
        onMeasureExactFormat(r7, r8);
        return;
    L20:
        int r5 = 0;
    L21:
        if (r5 >= r4) goto L23;
        LayoutParams r6 = (LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r5).getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        r6.rightMargin = 0;
        r6.leftMargin = 0;
        r5 = r5 + 1;
        goto L21
    L23:
        super.onMeasure(r7, r8);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    public void setExpandedActionViewsExclusive(boolean r1) {
        this.mPresenter.setExpandedActionViewsExclusive(r1);
    }

    public void setMenuCallbacks(MenuPresenter.Callback r3, MenuBuilder.Callback r4) {
        MenuPresenter.Callback r5 = (MenuPresenter.Callback) ZeusTransformUtils.wrapperContextForParams(r3, MenuPresenter.Callback.class, "com.obric.memorydata.plugin");
        MenuBuilder.Callback r6 = (MenuBuilder.Callback) ZeusTransformUtils.wrapperContextForParams(r4, MenuBuilder.Callback.class, "com.obric.memorydata.plugin");
        this.mActionMenuPresenterCallback = r5;
        this.mMenuBuilderCallback = r6;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener r3) {
        this.mOnMenuItemClickListener = (OnMenuItemClickListener) ZeusTransformUtils.wrapperContextForParams(r3, OnMenuItemClickListener.class, "com.obric.memorydata.plugin");
    }

    public void setOverflowIcon(Drawable r1) {
        getMenu();
        this.mPresenter.setOverflowIcon(r1);
    }

    public void setOverflowReserved(boolean r1) {
        this.mReserveOverflow = r1;
    }

    public void setPopupTheme(int r5) {
        if (this.mPopupTheme == r5) goto L10;
        this.mPopupTheme = r5;
        if (r5 != 0) goto L7;
        Context r6 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    L8:
        this.mPopupContext = r6;
        return;
    L7:
        r6 = ZeusTransformUtils.wrapperContext(new ContextThemeWrapper((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5), "com.obric.memorydata.plugin");
        goto L8
    }

    public void setPresenter(ActionMenuPresenter r1) {
        this.mPresenter = r1;
        r1.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter r0 = this.mPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.showOverflowMenu() == false) goto L7;
        return true;
    }
}
