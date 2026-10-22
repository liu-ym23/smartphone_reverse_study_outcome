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
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

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

    public class ActionMenuItemForwardingListener extends ForwardingListener {
        final /* synthetic */ ActionMenuItemView this$0;

        public ActionMenuItemForwardingListener(ActionMenuItemView r5) {
            this.this$0 = r5;
            super(r5);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public ShowableListMenu getPopup() {
            PopupCallback r5 = this.this$0.mPopupCallback;
            if (r5 != null) goto L5;
            return null;
        L5:
            return r5.getPopup();
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public boolean onForwardingStarted() {
            ActionMenuItemView r5 = this.this$0;
            MenuBuilder.ItemInvoker r10 = r5.mItemInvoker;
            if (r10 != null) goto L5;
            return false;
        L5:
            if (r10.invokeItem(r5.mItemData) == false) goto L13;
            ShowableListMenu r11 = getPopup();
            if (r11 != null) goto L9;
            return false;
        L9:
            if (r11.isShowing() == false) goto L15;
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

    public ActionMenuItemView(Context r5) {
        this(r5, null);
    }

    private boolean shouldAllowTextWithIcon() {
        Configuration r5 = getContext().getResources().getConfiguration();
        int r10 = r5.screenWidthDp;
        int r11 = r5.screenHeightDp;
        if (r10 < 480) goto L5;
    L11:
        return true;
    L5:
        if (r10 < 640) goto L8;
        if (r11 >= 480) goto L11;
    L8:
        if (r5.orientation == 2) goto L11;
        return false;
    }

    private void updateTextButtonVisibility() {
        boolean r5 = true;
        boolean r10 = !TextUtils.isEmpty(this.mTitle);
        if (this.mIcon != null) goto L5;
    L12:
        boolean r11 = r10 & r5;
        CharSequence r12 = null;
        if (r11 == false) goto L15;
        CharSequence r13 = this.mTitle;
    L16:
        setText(r13);
        CharSequence r14 = this.mItemData.getContentDescription();
        if (TextUtils.isEmpty(r14) == false) goto L22;
        if (r11 == false) goto L20;
        CharSequence r15 = null;
    L21:
        setContentDescription(r15);
    L23:
        CharSequence r16 = this.mItemData.getTooltipText();
        if (TextUtils.isEmpty(r16) == false) goto L29;
        if (r11 == true) goto L28;
        r12 = this.mItemData.getTitle();
    L28:
        TooltipCompat.setTooltipText(this, r12);
        return;
    L29:
        TooltipCompat.setTooltipText(this, r16);
        return;
    L20:
        r15 = this.mItemData.getTitle();
        goto L21
    L22:
        setContentDescription(r14);
        goto L23
    L15:
        r13 = null;
        goto L16
    L5:
        if (this.mItemData.showsTextAsAction() == true) goto L7;
    L11:
        r5 = false;
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
    public void initialize(MenuItemImpl r5, int r10) {
        this.mItemData = r5;
        setIcon(r5.getIcon());
        setTitle(r5.getTitleForItemView(this));
        setId(r5.getItemId());
        if (r5.isVisible() == false) goto L5;
        int r11 = 0;
    L6:
        setVisibility(r11);
        setEnabled(r5.isEnabled());
        if (r5.hasSubMenu() == true) goto L9;
        return;
    L9:
        if (this.mForwardingListener != null) goto L13;
        this.mForwardingListener = new ActionMenuItemForwardingListener(this);
        return;
    L13:
        return;
    L5:
        r11 = 8;
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
    public void onClick(View r5) {
        MenuBuilder.ItemInvoker r10 = this.mItemInvoker;
        if (r10 == null) goto L6;
        r10.invokeItem(this.mItemData);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        updateTextButtonVisibility();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        boolean r5 = hasText();
        if (r5 == false) goto L7;
        int r12 = this.mSavedPaddingLeft;
        if (r12 < 0) goto L7;
        super.setPadding(r12, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    L7:
        super.onMeasure(r10, r11);
        int r13 = View.MeasureSpec.getMode(r10);
        int r14 = View.MeasureSpec.getSize(r10);
        int r15 = getMeasuredWidth();
        if (r13 != Integer.MIN_VALUE) goto L10;
        int r16 = Math.min(r14, this.mMinWidth);
    L12:
        if (r13 != 1073741824) goto L14;
    L17:
        if (r5 == false) goto L19;
        return;
    L19:
        if (this.mIcon == null) goto L23;
        super.setPadding((getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        return;
    L23:
        return;
    L14:
        if (this.mMinWidth <= 0) goto L17;
        if (r15 >= r16) goto L17;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r16, BasicMeasure.EXACTLY), r11);
        goto L17
    L10:
        r16 = this.mMinWidth;
        goto L12
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        if (this.mItemData.hasSubMenu() == false) goto L11;
        ForwardingListener r10 = this.mForwardingListener;
        if (r10 == null) goto L11;
        if (r10.onTouch(this, r5) == false) goto L11;
        return true;
    L11:
        return super.onTouchEvent(r5);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r5) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r5) {
    }

    public void setExpandedFormat(boolean r5) {
        if (this.mExpandedFormat == r5) goto L8;
        this.mExpandedFormat = r5;
        MenuItemImpl r10 = this.mItemData;
        if (r10 == null) goto L9;
        r10.actionFormatChanged();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable r5) {
        this.mIcon = r5;
        if (r5 == null) goto L11;
        int r10 = r5.getIntrinsicWidth();
        int r11 = r5.getIntrinsicHeight();
        int r12 = this.mMaxIconSize;
        if (r10 <= r12) goto L7;
        r11 = (int) (r11 * (r12 / r10));
        r10 = r12;
    L7:
        if (r11 <= r12) goto L9;
        r10 = (int) (r10 * (r12 / r11));
    L10:
        r5.setBounds(0, 0, r10, r12);
        goto L11
    L9:
        r12 = r11;
    L11:
        setCompoundDrawables(r5, null, null, null);
        updateTextButtonVisibility();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker r5) {
        this.mItemInvoker = r5;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int r5, int r10, int r11, int r12) {
        this.mSavedPaddingLeft = r5;
        super.setPadding(r5, r10, r11, r12);
    }

    public void setPopupCallback(PopupCallback r5) {
        this.mPopupCallback = r5;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r5, char r10) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r5) {
        this.mTitle = r5;
        updateTextButtonVisibility();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public ActionMenuItemView(Context r5, AttributeSet r10) {
        this(r5, r10, 0);
    }

    public ActionMenuItemView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        Resources r12 = r5.getResources();
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        TypedArray r13 = r5.obtainStyledAttributes(r10, R.styleable.ActionMenuItemView, r11, 0);
        this.mMinWidth = r13.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        r13.recycle();
        this.mMaxIconSize = (int) ((r12.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.mSavedPaddingLeft = -1;
        setSaveEnabled(false);
    }
}
