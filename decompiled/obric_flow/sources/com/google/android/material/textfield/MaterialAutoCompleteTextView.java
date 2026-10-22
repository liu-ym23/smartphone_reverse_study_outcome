package com.google.android.material.textfield;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final String SWITCH_ACCESS_ACTIVITY_NAME = "SwitchAccess";

    @Nullable
    private final AccessibilityManager accessibilityManager;

    @Nullable
    private ColorStateList dropDownBackgroundTint;

    @NonNull
    private final ListPopupWindow modalListPopup;
    private final float popupElevation;

    @LayoutRes
    private final int simpleItemLayout;
    private int simpleItemSelectedColor;

    @Nullable
    private ColorStateList simpleItemSelectedRippleColor;

    @NonNull
    private final Rect tempRect;

    public class MaterialArrayAdapter<T> extends ArrayAdapter<String> {

        @Nullable
        private ColorStateList pressedRippleColor;

        @Nullable
        private ColorStateList selectedItemRippleOverlaidColor;
        final /* synthetic */ MaterialAutoCompleteTextView this$0;

        public MaterialArrayAdapter(@NonNull MaterialAutoCompleteTextView r5, Context r10, @NonNull int r11, String[] r12) {
            this.this$0 = r5;
            super(r10, r11, r12);
            updateSelectedItemColorStateList();
        }

        @Nullable
        private ColorStateList createItemSelectedColorStateList() {
            if (hasSelectedColor() == true) goto L5;
            return null;
        L5:
            if (hasSelectedRippleColor() == false) goto L10;
            int[] r5 = {R.attr.state_hovered, -16842919};
            int[] r10 = {R.attr.state_selected, -16842919};
            int r11 = MaterialAutoCompleteTextView.access$300(this.this$0).getColorForState(r10, 0);
            int r12 = MaterialAutoCompleteTextView.access$300(this.this$0).getColorForState(r5, 0);
            int[] r13 = {MaterialColors.layer(MaterialAutoCompleteTextView.access$200(this.this$0), r11), MaterialColors.layer(MaterialAutoCompleteTextView.access$200(this.this$0), r12), MaterialAutoCompleteTextView.access$200(this.this$0)};
            return new ColorStateList(new int[][]{r10, r5, new int[0]}, r13);
        L10:
            return null;
        }

        @Nullable
        private Drawable getSelectedItemDrawable() {
            if (hasSelectedColor() == false) goto L9;
            ColorDrawable r5 = new ColorDrawable(MaterialAutoCompleteTextView.access$200(this.this$0));
            if (this.pressedRippleColor == null) goto L8;
            DrawableCompat.setTintList(r5, this.selectedItemRippleOverlaidColor);
            return new RippleDrawable(this.pressedRippleColor, r5, null);
        L8:
            return r5;
        L9:
            return null;
        }

        private boolean hasSelectedColor() {
            if (MaterialAutoCompleteTextView.access$200(this.this$0) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean hasSelectedRippleColor() {
            if (MaterialAutoCompleteTextView.access$300(this.this$0) == null) goto L5;
            return true;
        L5:
            return false;
        }

        private ColorStateList sanitizeDropdownItemSelectedRippleColor() {
            if (hasSelectedRippleColor() == true) goto L6;
            return null;
        L6:
            int[] r5 = {R.attr.state_pressed};
            int[] r10 = {MaterialAutoCompleteTextView.access$300(this.this$0).getColorForState(r5, 0), 0};
            return new ColorStateList(new int[][]{r5, new int[0]}, r10);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r5, @Nullable View r10, ViewGroup r11) {
            View r12 = super.getView(r5, r10, r11);
            if ((r12 instanceof TextView) == false) goto L9;
            TextView r13 = (TextView) r12;
            if (this.this$0.getText().toString().contentEquals(r13.getText()) == false) goto L7;
            Drawable r14 = getSelectedItemDrawable();
        L8:
            ViewCompat.setBackground(r13, r14);
            goto L9
        L7:
            r14 = null;
        L9:
            return r12;
        }

        public void updateSelectedItemColorStateList() {
            this.pressedRippleColor = sanitizeDropdownItemSelectedRippleColor();
            this.selectedItemRippleOverlaidColor = createItemSelectedColorStateList();
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ ListPopupWindow access$000(MaterialAutoCompleteTextView r5) {
        return r5.modalListPopup;
    }

    public static /* synthetic */ void access$100(MaterialAutoCompleteTextView r5, Object r10) {
        r5.updateText(r10);
    }

    public static /* synthetic */ int access$200(MaterialAutoCompleteTextView r5) {
        return r5.simpleItemSelectedColor;
    }

    public static /* synthetic */ ColorStateList access$300(MaterialAutoCompleteTextView r5) {
        return r5.simpleItemSelectedRippleColor;
    }

    @Nullable
    private TextInputLayout findTextInputLayoutAncestor() {
        ViewParent r5 = getParent();
    L3:
        if (r5 == null) goto L9;
        if ((r5 instanceof TextInputLayout) == true) goto L7;
        r5 = r5.getParent();
        goto L3
    L7:
        return (TextInputLayout) r5;
    L9:
        return null;
    }

    private boolean isPopupRequired() {
        if (isTouchExplorationEnabled() == false) goto L5;
    L8:
        return true;
    L5:
        if (isSwitchAccessEnabled() == true) goto L8;
        return false;
    }

    private boolean isSwitchAccessEnabled() {
        AccessibilityManager r5 = this.accessibilityManager;
        if (r5 != null) goto L5;
    L18:
        return false;
    L5:
        if (r5.isEnabled() == false) goto L18;
        List<AccessibilityServiceInfo> r10 = this.accessibilityManager.getEnabledAccessibilityServiceList(16);
        if (r10 == null) goto L18;
        Iterator<AccessibilityServiceInfo> r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L18;
        AccessibilityServiceInfo r12 = r11.next();
        if (r12.getSettingsActivityName() == null) goto L11;
        if (r12.getSettingsActivityName().contains(SWITCH_ACCESS_ACTIVITY_NAME) == false) goto L11;
        return true;
    }

    private boolean isTouchExplorationEnabled() {
        AccessibilityManager r5 = this.accessibilityManager;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isTouchExplorationEnabled() == false) goto L7;
        return true;
    }

    private int measureContentWidth() {
        ListAdapter r5 = getAdapter();
        TextInputLayout r10 = findTextInputLayoutAncestor();
        int r11 = 0;
        if (r5 == null) goto L20;
        if (r10 == null) goto L20;
        int r12 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int r13 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int r14 = Math.min(r5.getCount(), Math.max(0, this.modalListPopup.getSelectedItemPosition()) + 15);
        int r15 = Math.max(0, r14 - 15);
        View r16 = null;
        int r17 = 0;
    L7:
        if (r15 >= r14) goto L15;
        int r18 = r5.getItemViewType(r15);
        if (r18 == r11) goto L11;
        r16 = null;
        r11 = r18;
    L11:
        r16 = r5.getView(r15, r16, r10);
        if (r16.getLayoutParams() != null) goto L14;
        r16.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L14:
        r16.measure(r12, r13);
        r17 = Math.max(r17, r16.getMeasuredWidth());
        r15 = r15 + 1;
        goto L7
    L15:
        Drawable r19 = this.modalListPopup.getBackground();
        if (r19 == null) goto L19;
        r19.getPadding(this.tempRect);
        Rect r110 = this.tempRect;
        r17 = r17 + (r110.left + r110.right);
    L19:
        return r10.getEndIconView().getMeasuredWidth() + r17;
    L20:
        return 0;
    }

    private void onInputTypeChanged() {
        TextInputLayout r5 = findTextInputLayoutAncestor();
        if (r5 == null) goto L6;
        r5.updateEditTextBoxBackgroundIfNeeded();
        return;
    }

    private <T extends ListAdapter & Filterable> void updateText(Object r5) {
        setText(convertSelectionToString(r5), false);
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        if (isPopupRequired() == false) goto L5;
        this.modalListPopup.dismiss();
        return;
    L5:
        super.dismissDropDown();
    }

    @Nullable
    public ColorStateList getDropDownBackgroundTintList() {
        return this.dropDownBackgroundTint;
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout r5 = findTextInputLayoutAncestor();
        if (r5 == null) goto L9;
        if (r5.isProvidingHint() == false) goto L9;
        return r5.getHint();
    L9:
        return super.getHint();
    }

    public float getPopupElevation() {
        return this.popupElevation;
    }

    public int getSimpleItemSelectedColor() {
        return this.simpleItemSelectedColor;
    }

    @Nullable
    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.simpleItemSelectedRippleColor;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout r5 = findTextInputLayoutAncestor();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isProvidingHint() == true) goto L7;
        return;
    L7:
        if (super.getHint() == null) goto L9;
        return;
    L9:
        if (ManufacturerUtils.isMeizuDevice() == false) goto L15;
        setHint("");
        return;
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.modalListPopup.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        if (View.MeasureSpec.getMode(r5) != Integer.MIN_VALUE) goto L6;
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth()), View.MeasureSpec.getSize(r5)), getMeasuredHeight());
        return;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean r5) {
        if (isPopupRequired() == false) goto L5;
        return;
    L5:
        super.onWindowFocusChanged(r5);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T r5) {
        super.setAdapter(r5);
        this.modalListPopup.setAdapter(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable r5) {
        super.setDropDownBackgroundDrawable(r5);
        ListPopupWindow r10 = this.modalListPopup;
        if (r10 == null) goto L6;
        r10.setBackgroundDrawable(r5);
        return;
    }

    public void setDropDownBackgroundTint(@ColorInt int r5) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(r5));
    }

    public void setDropDownBackgroundTintList(@Nullable ColorStateList r5) {
        this.dropDownBackgroundTint = r5;
        Drawable r10 = getDropDownBackground();
        if ((r10 instanceof MaterialShapeDrawable) == false) goto L6;
        ((MaterialShapeDrawable) r10).setFillColor(this.dropDownBackgroundTint);
        return;
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener r5) {
        super.setOnItemSelectedListener(r5);
        this.modalListPopup.setOnItemSelectedListener(getOnItemSelectedListener());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int r5) {
        super.setRawInputType(r5);
        onInputTypeChanged();
    }

    public void setSimpleItemSelectedColor(int r5) {
        this.simpleItemSelectedColor = r5;
        if ((getAdapter() instanceof MaterialArrayAdapter) == false) goto L6;
        ((MaterialArrayAdapter) getAdapter()).updateSelectedItemColorStateList();
        return;
    }

    public void setSimpleItemSelectedRippleColor(@Nullable ColorStateList r5) {
        this.simpleItemSelectedRippleColor = r5;
        if ((getAdapter() instanceof MaterialArrayAdapter) == false) goto L6;
        ((MaterialArrayAdapter) getAdapter()).updateSelectedItemColorStateList();
        return;
    }

    public void setSimpleItems(@ArrayRes int r5) {
        setSimpleItems(getResources().getStringArray(r5));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (isPopupRequired() == false) goto L5;
        this.modalListPopup.show();
        return;
    L5:
        super.showDropDown();
    }

    public MaterialAutoCompleteTextView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, com.google.android.material.R.attr.autoCompleteTextViewStyle);
    }

    public void setSimpleItems(@NonNull String[] r5) {
        setAdapter(new MaterialArrayAdapter(this, getContext(), this.simpleItemLayout, r5));
    }

    public MaterialAutoCompleteTextView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(MaterialThemeOverlay.wrap(r10, r11, r12, 0), r11, r12);
        this.tempRect = new Rect();
        Context r13 = getContext();
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r13, r11, com.google.android.material.R.styleable.MaterialAutoCompleteTextView, r12, com.google.android.material.R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (r14.hasValue(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_inputType) == true) goto L5;
    L7:
        this.simpleItemLayout = r14.getResourceId(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemLayout, com.google.android.material.R.layout.mtrl_auto_complete_simple_item);
        this.popupElevation = r14.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_popupElevation, com.google.android.material.R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        if (r14.hasValue(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_dropDownBackgroundTint) == false) goto L10;
        this.dropDownBackgroundTint = ColorStateList.valueOf(r14.getColor(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_dropDownBackgroundTint, 0));
    L10:
        this.simpleItemSelectedColor = r14.getColor(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemSelectedColor, 0);
        this.simpleItemSelectedRippleColor = MaterialResources.getColorStateList(r13, r14, com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemSelectedRippleColor);
        this.accessibilityManager = (AccessibilityManager) r13.getSystemService("accessibility");
        ListPopupWindow r15 = new ListPopupWindow(r13);
        this.modalListPopup = r15;
        r15.setModal(true);
        r15.setAnchorView(this);
        r15.setInputMethodMode(2);
        r15.setAdapter(getAdapter());
        r15.setOnItemClickListener(new AnonymousClass1(this));
        if (r14.hasValue(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItems) == false) goto L13;
        setSimpleItems(r14.getResourceId(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItems, 0));
    L13:
        r14.recycle();
        return;
    L5:
        if (r14.getInt(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_inputType, 0) != 0) goto L7;
        setKeyListener(null);
        goto L7
    }
}
