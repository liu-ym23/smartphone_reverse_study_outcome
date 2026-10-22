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

    public ListMenuItemView(Context r5, AttributeSet r10) {
        this(r5, r10, R.attr.listMenuViewStyle);
    }

    private void addContentView(View r5) {
        addContentView(r5, -1);
    }

    private LayoutInflater getInflater() {
        if (this.mInflater != null) goto L6;
        this.mInflater = LayoutInflater.from(getContext());
    L6:
        return this.mInflater;
    }

    private void insertCheckBox() {
        CheckBox r5 = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
        this.mCheckBox = r5;
        addContentView(r5);
    }

    private void insertIconView() {
        ImageView r5 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false);
        this.mIconView = r5;
        addContentView(r5, 0);
    }

    private void insertRadioButton() {
        RadioButton r5 = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
        this.mRadioButton = r5;
        addContentView(r5);
    }

    private void setSubMenuArrowVisible(boolean r5) {
        ImageView r10 = this.mSubMenuArrowView;
        if (r10 == null) goto L9;
        if (r5 == false) goto L6;
        int r11 = 0;
    L7:
        r10.setVisibility(r11);
        return;
    L6:
        r11 = 8;
        goto L7
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect r5) {
        ImageView r10 = this.mGroupDivider;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getVisibility() != 0) goto L9;
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) this.mGroupDivider.getLayoutParams();
        int r12 = r5.top;
        r5.top = ((this.mGroupDivider.getHeight() + r11.topMargin) + r11.bottomMargin) + r12;
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl r5, int r10) {
        this.mItemData = r5;
        if (r5.isVisible() == false) goto L5;
        int r11 = 0;
    L6:
        setVisibility(r11);
        setTitle(r5.getTitleForItemView(this));
        setCheckable(r5.isCheckable());
        setShortcut(r5.shouldShowShortcut(), r5.getShortcut());
        setIcon(r5.getIcon());
        setEnabled(r5.isEnabled());
        setSubMenuArrowVisible(r5.hasSubMenu());
        setContentDescription(r5.getContentDescription());
        return;
    L5:
        r11 = 8;
        goto L6
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.setBackground(this, this.mBackground);
        TextView r5 = (TextView) findViewById(R.id.title);
        this.mTitleView = r5;
        int r10 = this.mTextAppearance;
        if (r10 == (-1)) goto L5;
        r5.setTextAppearance(this.mTextAppearanceContext, r10);
    L5:
        this.mShortcutView = (TextView) findViewById(R.id.shortcut);
        ImageView r11 = (ImageView) findViewById(R.id.submenuarrow);
        this.mSubMenuArrowView = r11;
        if (r11 == null) goto L8;
        r11.setImageDrawable(this.mSubMenuArrow);
    L8:
        this.mGroupDivider = (ImageView) findViewById(R.id.group_divider);
        this.mContent = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        if (this.mIconView != null) goto L5;
    L11:
        super.onMeasure(r5, r10);
        return;
    L5:
        if (this.mPreserveIconSpacing == false) goto L11;
        ViewGroup.LayoutParams r11 = getLayoutParams();
        LinearLayout.LayoutParams r12 = (LinearLayout.LayoutParams) this.mIconView.getLayoutParams();
        int r13 = r11.height;
        if (r13 <= 0) goto L11;
        if (r12.width > 0) goto L11;
        r12.width = r13;
        goto L11
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r5) {
        if (r5 == true) goto L9;
        if (this.mRadioButton != null) goto L9;
        if (this.mCheckBox != null) goto L9;
        return;
    L9:
        if (this.mItemData.isExclusiveCheckable() == false) goto L15;
        if (this.mRadioButton != null) goto L13;
        insertRadioButton();
    L13:
        CompoundButton r10 = this.mRadioButton;
        View r11 = this.mCheckBox;
    L19:
        if (r5 == false) goto L27;
        r10.setChecked(this.mItemData.isChecked());
        if (r10.getVisibility() == 0) goto L23;
        r10.setVisibility(0);
    L23:
        if (r11 != null) goto L25;
        return;
    L25:
        if (r11.getVisibility() == 8) goto L35;
        r11.setVisibility(8);
        return;
    L35:
        return;
    L27:
        CheckBox r12 = this.mCheckBox;
        if (r12 == null) goto L30;
        r12.setVisibility(8);
    L30:
        RadioButton r13 = this.mRadioButton;
        if (r13 == null) goto L37;
        r13.setVisibility(8);
        return;
    L37:
        return;
    L15:
        if (this.mCheckBox != null) goto L17;
        insertCheckBox();
    L17:
        r10 = this.mCheckBox;
        r11 = this.mRadioButton;
        goto L19
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r5) {
        if (this.mItemData.isExclusiveCheckable() == false) goto L9;
        if (this.mRadioButton != null) goto L7;
        insertRadioButton();
    L7:
        CompoundButton r10 = this.mRadioButton;
    L12:
        r10.setChecked(r5);
        return;
    L9:
        if (this.mCheckBox != null) goto L11;
        insertCheckBox();
    L11:
        r10 = this.mCheckBox;
        goto L12
    }

    public void setForceShowIcon(boolean r5) {
        this.mForceShowIcon = r5;
        this.mPreserveIconSpacing = r5;
    }

    public void setGroupDividerEnabled(boolean r5) {
        ImageView r10 = this.mGroupDivider;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mHasListDivider == true) goto L8;
        if (r5 == false) goto L8;
        int r11 = 0;
    L9:
        r10.setVisibility(r11);
        return;
    L8:
        r11 = 8;
        goto L9
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable r5) {
        if (this.mItemData.shouldShowIcon() == false) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L11;
    L13:
        ImageView r11 = this.mIconView;
        if (r11 != null) goto L19;
        if (r5 != null) goto L19;
        if (this.mPreserveIconSpacing == true) goto L19;
        return;
    L19:
        if (r11 != null) goto L21;
        insertIconView();
    L21:
        if (r5 == null) goto L23;
    L26:
        ImageView r12 = this.mIconView;
        if (r10 == true) goto L30;
        r5 = null;
    L30:
        r12.setImageDrawable(r5);
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
        r10 = false;
        goto L9
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r5, char r10) {
        if (r5 == true) goto L4;
    L6:
        int r11 = 8;
    L7:
        if (r11 != 0) goto L10;
        this.mShortcutView.setText(this.mItemData.getShortcutLabel());
    L10:
        if (this.mShortcutView.getVisibility() == r11) goto L13;
        this.mShortcutView.setVisibility(r11);
        return;
    L13:
        return;
    L4:
        if (this.mItemData.shouldShowShortcut() == false) goto L6;
        r11 = 0;
        goto L7
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r5) {
        if (r5 == null) goto L7;
        this.mTitleView.setText(r5);
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

    public ListMenuItemView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10);
        TintTypedArray r12 = TintTypedArray.obtainStyledAttributes(getContext(), r10, R.styleable.MenuView, r11, 0);
        this.mBackground = r12.getDrawable(R.styleable.MenuView_android_itemBackground);
        this.mTextAppearance = r12.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.mPreserveIconSpacing = r12.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
        this.mTextAppearanceContext = r5;
        this.mSubMenuArrow = r12.getDrawable(R.styleable.MenuView_subMenuArrow);
        TypedArray r13 = r5.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.mHasListDivider = r13.hasValue(0);
        r12.recycle();
        r13.recycle();
    }

    private void addContentView(View r5, int r10) {
        LinearLayout r11 = this.mContent;
        if (r11 == null) goto L5;
        r11.addView(r5, r10);
        return;
    L5:
        addView(r5, r10);
    }
}
