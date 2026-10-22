package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, ActionMenuView.ActionMenuChildView {
    private static final int MAX_ICON_SIZE = 32;
    private static final String TAG = "ActionMenuItemView";
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ForwardingListener mForwardingListener;
    private Drawable mIcon;
    MenuItemImpl mItemData;
    MenuBuilder.ItemInvoker mItemInvoker;
    private int mMaxIconSize;
    private int mMinWidth;
    PopupCallback mPopupCallback;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;

    private class ActionMenuItemForwardingListener extends ForwardingListener {
        final /* synthetic */ ActionMenuItemView this$0;

        public ActionMenuItemForwardingListener(ActionMenuItemView r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public ShowableListMenu getPopup() {
            PopupCallback r10 = this.this$0.mPopupCallback;
            if (r10 != null) goto L5;
            return null;
        L5:
            return r10.getPopup();
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean onForwardingStarted() {
            ActionMenuItemView r10 = this.this$0;
            MenuBuilder.ItemInvoker r11 = r10.mItemInvoker;
            if (r11 != null) goto L5;
            return false;
        L5:
            if (r11.invokeItem(r10.mItemData) == false) goto L13;
            ShowableListMenu r12 = getPopup();
            if (r12 != null) goto L9;
            return false;
        L9:
            if (r12.isShowing() == false) goto L15;
            return true;
        L15:
            return false;
        L13:
            return false;
        }
    }

    public static abstract class PopupCallback {
        public PopupCallback() {
        }

        public abstract ShowableListMenu getPopup();
    }

    public ActionMenuItemView(Context r10) {
        this(r10, null);
    }

    public ActionMenuItemView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ActionMenuItemView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        Resources r13 = r10.getResources();
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        TypedArray r14 = r10.obtainStyledAttributes(r11, R.styleable.ActionMenuItemView, r12, 0);
        this.mMinWidth = r14.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        r14.recycle();
        this.mMaxIconSize = (int) ((r13.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.mSavedPaddingLeft = -1;
        setSaveEnabled(false);
    }

    private boolean shouldAllowTextWithIcon() {
        Configuration r10 = getContext().getResources().getConfiguration();
        int r11 = r10.screenWidthDp;
        int r12 = r10.screenHeightDp;
        if (r11 < 480) goto L5;
    L11:
        return true;
    L5:
        if (r11 < 640) goto L8;
        if (r12 >= 480) goto L11;
    L8:
        if (r10.orientation == 2) goto L11;
        return false;
    }

    private void updateTextButtonVisibility() {
        boolean r10 = true;
        boolean r11 = !TextUtils.isEmpty(this.mTitle);
        if (this.mIcon != null) goto L5;
    L12:
        boolean r12 = r11 & r10;
        CharSequence r13 = null;
        if (r12 == false) goto L15;
        CharSequence r14 = this.mTitle;
    L16:
        setText(r14);
        CharSequence r15 = this.mItemData.getContentDescription();
        if (TextUtils.isEmpty(r15) == false) goto L21;
        if (r12 == false) goto L20;
        r15 = null;
        goto L21
    L20:
        r15 = this.mItemData.getTitle();
    L21:
        setContentDescription(r15);
        CharSequence r16 = this.mItemData.getTooltipText();
        if (TextUtils.isEmpty(r16) == false) goto L27;
        if (r12 == true) goto L26;
        r13 = this.mItemData.getTitle();
    L26:
        TooltipCompat.setTooltipText(this, r13);
        return;
    L27:
        TooltipCompat.setTooltipText(this, r16);
        return;
    L15:
        r14 = null;
        goto L16
    L5:
        if (this.mItemData.showsTextAsAction() == true) goto L7;
    L11:
        r10 = false;
        goto L12
    L7:
        if (this.mAllowTextWithIcon == true) goto L12;
        if (this.mExpandedFormat == false) goto L11;
        goto L11
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl r10, int r11) {
        this.mItemData = r10;
        setIcon(r10.getIcon());
        setTitle(r10.getTitleForItemView(this));
        setId(r10.getItemId());
        if (r10.isVisible() == false) goto L5;
        int r12 = 0;
    L6:
        setVisibility(r12);
        setEnabled(r10.isEnabled());
        if (r10.hasSubMenu() == true) goto L9;
        return;
    L9:
        if (this.mForwardingListener != null) goto L13;
        this.mForwardingListener = new ActionMenuItemForwardingListener(this);
        return;
    L13:
        return;
    L5:
        r12 = 8;
        goto L6
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerAfter() {
        return hasText();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerBefore() {
        if (hasText() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mItemData.getIcon() != null) goto L7;
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        MenuBuilder.ItemInvoker r11 = this.mItemInvoker;
        if (r11 == null) goto L6;
        r11.invokeItem(this.mItemData);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        updateTextButtonVisibility();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int r10, int r11) {
        boolean r12 = hasText();
        if (r12 == false) goto L7;
        int r13 = this.mSavedPaddingLeft;
        if (r13 < 0) goto L7;
        super.setPadding(r13, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    L7:
        super.onMeasure(r10, r11);
        int r14 = View.MeasureSpec.getMode(r10);
        int r15 = View.MeasureSpec.getSize(r10);
        int r16 = getMeasuredWidth();
        if (r14 != Integer.MIN_VALUE) goto L10;
        int r17 = Math.min(r15, this.mMinWidth);
    L12:
        if (r14 != 1073741824) goto L14;
    L17:
        if (r12 == false) goto L19;
        return;
    L19:
        if (this.mIcon == null) goto L23;
        super.setPadding((getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        return;
    L23:
        return;
    L14:
        if (this.mMinWidth <= 0) goto L17;
        if (r16 >= r17) goto L17;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r17, 1073741824), r11);
        goto L17
    L10:
        r17 = this.mMinWidth;
        goto L12
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.mItemData.hasSubMenu() == false) goto L11;
        ForwardingListener r11 = this.mForwardingListener;
        if (r11 == null) goto L11;
        if (r11.onTouch(this, r10) == false) goto L11;
        return true;
    L11:
        return super.onTouchEvent(r10);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r10) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r10) {
    }

    public void setExpandedFormat(boolean r10) {
        if (this.mExpandedFormat == r10) goto L8;
        this.mExpandedFormat = r10;
        MenuItemImpl r11 = this.mItemData;
        if (r11 == null) goto L9;
        r11.actionFormatChanged();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable r10) {
        this.mIcon = r10;
        if (r10 == null) goto L11;
        int r11 = r10.getIntrinsicWidth();
        int r12 = r10.getIntrinsicHeight();
        int r13 = this.mMaxIconSize;
        if (r11 <= r13) goto L7;
        r12 = (int) (r12 * (r13 / r11));
        r11 = r13;
    L7:
        if (r12 <= r13) goto L9;
        r11 = (int) (r11 * (r13 / r12));
    L10:
        r10.setBounds(0, 0, r11, r13);
        goto L11
    L9:
        r13 = r12;
    L11:
        setCompoundDrawables(r10, null, null, null);
        updateTextButtonVisibility();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker r10) {
        this.mItemInvoker = r10;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int r10, int r11, int r12, int r13) {
        this.mSavedPaddingLeft = r10;
        super.setPadding(r10, r11, r12, r13);
    }

    public void setPopupCallback(PopupCallback r10) {
        this.mPopupCallback = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r10, char r11) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r10) {
        this.mTitle = r10;
        updateTextButtonVisibility();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }
}
