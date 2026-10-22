package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {
    private static final String TAG = "ListMenuItemView";
    private Drawable mBackground;
    private CheckBox mCheckBox;
    private LinearLayout mContent;
    private boolean mForceShowIcon;
    private ImageView mGroupDivider;
    private boolean mHasListDivider;
    private ImageView mIconView;
    private LayoutInflater mInflater;
    private MenuItemImpl mItemData;
    private boolean mPreserveIconSpacing;
    private RadioButton mRadioButton;
    private TextView mShortcutView;
    private Drawable mSubMenuArrow;
    private ImageView mSubMenuArrowView;
    private int mTextAppearance;
    private Context mTextAppearanceContext;
    private TextView mTitleView;

    public ListMenuItemView(Context r10, AttributeSet r11) {
        this(r10, r11, R.attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11);
        TintTypedArray r13 = TintTypedArray.obtainStyledAttributes(getContext(), r11, R.styleable.MenuView, r12, 0);
        this.mBackground = r13.getDrawable(R.styleable.MenuView_android_itemBackground);
        this.mTextAppearance = r13.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.mPreserveIconSpacing = r13.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
        this.mTextAppearanceContext = r10;
        this.mSubMenuArrow = r13.getDrawable(R.styleable.MenuView_subMenuArrow);
        TypedArray r14 = r10.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.mHasListDivider = r14.hasValue(0);
        r13.recycle();
        r14.recycle();
    }

    private void addContentView(View r10) {
        addContentView(r10, -1);
    }

    private void addContentView(View r10, int r11) {
        LinearLayout r12 = this.mContent;
        if (r12 == null) goto L5;
        r12.addView(r10, r11);
        return;
    L5:
        addView(r10, r11);
    }

    private LayoutInflater getInflater() {
        if (this.mInflater != null) goto L6;
        this.mInflater = LayoutInflater.from(getContext());
    L6:
        return this.mInflater;
    }

    private void insertCheckBox() {
        CheckBox r10 = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
        this.mCheckBox = r10;
        addContentView(r10);
    }

    private void insertIconView() {
        ImageView r10 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false);
        this.mIconView = r10;
        addContentView(r10, 0);
    }

    private void insertRadioButton() {
        RadioButton r10 = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
        this.mRadioButton = r10;
        addContentView(r10);
    }

    private void setSubMenuArrowVisible(boolean r10) {
        ImageView r11 = this.mSubMenuArrowView;
        if (r11 == null) goto L9;
        if (r10 == false) goto L6;
        int r12 = 0;
    L7:
        r11.setVisibility(r12);
        return;
    L6:
        r12 = 8;
        goto L7
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect r10) {
        ImageView r11 = this.mGroupDivider;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.getVisibility() != 0) goto L9;
        LinearLayout.LayoutParams r12 = (LinearLayout.LayoutParams) this.mGroupDivider.getLayoutParams();
        r10.top += (this.mGroupDivider.getHeight() + r12.topMargin) + r12.bottomMargin;
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl r10, int r11) {
        this.mItemData = r10;
        if (r10.isVisible() == false) goto L5;
        int r12 = 0;
    L6:
        setVisibility(r12);
        setTitle(r10.getTitleForItemView(this));
        setCheckable(r10.isCheckable());
        setShortcut(r10.shouldShowShortcut(), r10.getShortcut());
        setIcon(r10.getIcon());
        setEnabled(r10.isEnabled());
        setSubMenuArrowVisible(r10.hasSubMenu());
        setContentDescription(r10.getContentDescription());
        return;
    L5:
        r12 = 8;
        goto L6
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.setBackground(this, this.mBackground);
        TextView r10 = (TextView) findViewById(R.id.title);
        this.mTitleView = r10;
        int r11 = this.mTextAppearance;
        if (r11 == (-1)) goto L5;
        r10.setTextAppearance(this.mTextAppearanceContext, r11);
    L5:
        this.mShortcutView = (TextView) findViewById(R.id.shortcut);
        ImageView r12 = (ImageView) findViewById(R.id.submenuarrow);
        this.mSubMenuArrowView = r12;
        if (r12 == null) goto L8;
        r12.setImageDrawable(this.mSubMenuArrow);
    L8:
        this.mGroupDivider = (ImageView) findViewById(R.id.group_divider);
        this.mContent = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        if (this.mIconView != null) goto L5;
    L11:
        super.onMeasure(r10, r11);
        return;
    L5:
        if (this.mPreserveIconSpacing == false) goto L11;
        ViewGroup.LayoutParams r12 = getLayoutParams();
        LinearLayout.LayoutParams r13 = (LinearLayout.LayoutParams) this.mIconView.getLayoutParams();
        int r14 = r12.height;
        if (r14 <= 0) goto L11;
        if (r13.width > 0) goto L11;
        r13.width = r14;
        goto L11
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r10) {
        if (r10 == true) goto L9;
        if (this.mRadioButton != null) goto L9;
        if (this.mCheckBox != null) goto L9;
        return;
    L9:
        if (this.mItemData.isExclusiveCheckable() == false) goto L15;
        if (this.mRadioButton != null) goto L13;
        insertRadioButton();
    L13:
        CompoundButton r11 = this.mRadioButton;
        CompoundButton r12 = this.mCheckBox;
    L19:
        if (r10 == false) goto L27;
        r11.setChecked(this.mItemData.isChecked());
        if (r11.getVisibility() == 0) goto L23;
        r11.setVisibility(0);
    L23:
        if (r12 != null) goto L25;
        return;
    L25:
        if (r12.getVisibility() == 8) goto L35;
        r12.setVisibility(8);
        return;
    L35:
        return;
    L27:
        CheckBox r13 = this.mCheckBox;
        if (r13 == null) goto L30;
        r13.setVisibility(8);
    L30:
        RadioButton r14 = this.mRadioButton;
        if (r14 == null) goto L37;
        r14.setVisibility(8);
        return;
    L37:
        return;
    L15:
        if (this.mCheckBox != null) goto L17;
        insertCheckBox();
    L17:
        r11 = this.mCheckBox;
        r12 = this.mRadioButton;
        goto L19
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r10) {
        if (this.mItemData.isExclusiveCheckable() == false) goto L9;
        if (this.mRadioButton != null) goto L7;
        insertRadioButton();
    L7:
        CompoundButton r11 = this.mRadioButton;
    L12:
        r11.setChecked(r10);
        return;
    L9:
        if (this.mCheckBox != null) goto L11;
        insertCheckBox();
    L11:
        r11 = this.mCheckBox;
        goto L12
    }

    public void setForceShowIcon(boolean r10) {
        this.mForceShowIcon = r10;
        this.mPreserveIconSpacing = r10;
    }

    public void setGroupDividerEnabled(boolean r10) {
        ImageView r11 = this.mGroupDivider;
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.mHasListDivider == true) goto L8;
        if (r10 == false) goto L8;
        int r12 = 0;
    L9:
        r11.setVisibility(r12);
        return;
    L8:
        r12 = 8;
        goto L9
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable r10) {
        if (this.mItemData.shouldShowIcon() == false) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L11;
    L13:
        ImageView r12 = this.mIconView;
        if (r12 != null) goto L19;
        if (r10 != null) goto L19;
        if (this.mPreserveIconSpacing == true) goto L19;
        return;
    L19:
        if (r12 != null) goto L21;
        insertIconView();
    L21:
        if (r10 == null) goto L23;
    L26:
        ImageView r13 = this.mIconView;
        if (r11 == true) goto L30;
        r10 = null;
    L30:
        r13.setImageDrawable(r10);
        if (this.mIconView.getVisibility() == 0) goto L35;
        this.mIconView.setVisibility(0);
        return;
    L35:
        return;
    L23:
        if (this.mPreserveIconSpacing == true) goto L26;
        this.mIconView.setVisibility(8);
        return;
    L11:
        if (this.mPreserveIconSpacing == true) goto L13;
        return;
    L5:
        if (this.mForceShowIcon == true) goto L8;
        r11 = false;
        goto L9
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r10, char r11) {
        if (r10 == true) goto L4;
    L6:
        int r12 = 8;
    L7:
        if (r12 != 0) goto L10;
        this.mShortcutView.setText(this.mItemData.getShortcutLabel());
    L10:
        if (this.mShortcutView.getVisibility() == r12) goto L13;
        this.mShortcutView.setVisibility(r12);
        return;
    L13:
        return;
    L4:
        if (this.mItemData.shouldShowShortcut() == false) goto L6;
        r12 = 0;
        goto L7
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r10) {
        if (r10 == null) goto L7;
        this.mTitleView.setText(r10);
        if (this.mTitleView.getVisibility() == 0) goto L10;
        this.mTitleView.setVisibility(0);
        return;
    L10:
        return;
    L7:
        if (this.mTitleView.getVisibility() == 8) goto L12;
        this.mTitleView.setVisibility(8);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return this.mForceShowIcon;
    }
}
