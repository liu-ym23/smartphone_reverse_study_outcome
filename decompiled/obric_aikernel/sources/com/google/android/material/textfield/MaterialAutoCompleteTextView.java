package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.ArrayRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.internal.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    private static final int MAX_ITEMS_MEASURED = 15;

    @Nullable
    private final AccessibilityManager accessibilityManager;

    @NonNull
    private final ListPopupWindow modalListPopup;

    @LayoutRes
    private final int simpleItemLayout;

    @NonNull
    private final Rect tempRect;

    class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaterialAutoCompleteTextView f3903c;

        a(MaterialAutoCompleteTextView r10) {
            this.f3903c = r10;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> r10, View r11, int r12, long r13) {
            MaterialAutoCompleteTextView r14 = this.f3903c;
            if (r12 >= 0) goto L5;
            Object r15 = MaterialAutoCompleteTextView.access$000(r14).getSelectedItem();
        L6:
            MaterialAutoCompleteTextView.access$100(this.f3903c, r15);
            AdapterView.OnItemClickListener r16 = this.f3903c.getOnItemClickListener();
            if (r16 == null) goto L12;
            if (r11 == null) goto L10;
            if (r12 < 0) goto L10;
        L11:
            ListView r17 = MaterialAutoCompleteTextView.access$000(this.f3903c).getListView();
            r16.onItemClick(r17, r11, r12, r13);
        L10:
            r11 = MaterialAutoCompleteTextView.access$000(this.f3903c).getSelectedView();
            r12 = MaterialAutoCompleteTextView.access$000(this.f3903c).getSelectedItemPosition();
            r13 = MaterialAutoCompleteTextView.access$000(this.f3903c).getSelectedItemId();
        L12:
            MaterialAutoCompleteTextView.access$000(this.f3903c).dismiss();
            return;
        L5:
            r15 = r14.getAdapter().getItem(r12);
            goto L6
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context r10) {
        this(r10, null);
    }

    public MaterialAutoCompleteTextView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(b6.a.c(r10, r11, r12, 0), r11, r12);
        this.tempRect = new Rect();
        Context r13 = getContext();
        TypedArray r14 = k.h(r13, r11, l.MaterialAutoCompleteTextView, r12, q5.k.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int r15 = l.MaterialAutoCompleteTextView_android_inputType;
        if (r14.hasValue(r15) == true) goto L5;
    L7:
        this.simpleItemLayout = r14.getResourceId(l.MaterialAutoCompleteTextView_simpleItemLayout, q5.h.mtrl_auto_complete_simple_item);
        this.accessibilityManager = (AccessibilityManager) r13.getSystemService("accessibility");
        ListPopupWindow r16 = new ListPopupWindow(r13);
        this.modalListPopup = r16;
        r16.setModal(true);
        r16.setAnchorView(this);
        r16.setInputMethodMode(2);
        r16.setAdapter(getAdapter());
        r16.setOnItemClickListener(new a(this));
        int r17 = l.MaterialAutoCompleteTextView_simpleItems;
        if (r14.hasValue(r17) == false) goto L10;
        setSimpleItems(r14.getResourceId(r17, 0));
    L10:
        r14.recycle();
        return;
    L5:
        if (r14.getInt(r15, 0) != 0) goto L7;
        setKeyListener(null);
        goto L7
    }

    static /* synthetic */ ListPopupWindow access$000(MaterialAutoCompleteTextView r10) {
        return r10.modalListPopup;
    }

    static /* synthetic */ void access$100(MaterialAutoCompleteTextView r10, Object r11) {
        r10.updateText(r11);
    }

    @Nullable
    private TextInputLayout findTextInputLayoutAncestor() {
        ViewParent r10 = getParent();
    L3:
        if (r10 == null) goto L9;
        if ((r10 instanceof TextInputLayout) == true) goto L7;
        r10 = r10.getParent();
        goto L3
    L7:
        return (TextInputLayout) r10;
    L9:
        return null;
    }

    private int measureContentWidth() {
        ListAdapter r10 = getAdapter();
        TextInputLayout r11 = findTextInputLayoutAncestor();
        int r12 = 0;
        if (r10 == null) goto L20;
        if (r11 == null) goto L20;
        int r13 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int r14 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int r15 = Math.min(r10.getCount(), Math.max(0, this.modalListPopup.getSelectedItemPosition()) + 15);
        int r16 = Math.max(0, r15 - 15);
        View r17 = null;
        int r18 = 0;
    L7:
        if (r16 >= r15) goto L15;
        int r19 = r10.getItemViewType(r16);
        if (r19 == r12) goto L11;
        r17 = null;
        r12 = r19;
    L11:
        r17 = r10.getView(r16, r17, r11);
        if (r17.getLayoutParams() != null) goto L14;
        r17.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L14:
        r17.measure(r13, r14);
        r18 = Math.max(r18, r17.getMeasuredWidth());
        r16 = r16 + 1;
        goto L7
    L15:
        Drawable r20 = this.modalListPopup.getBackground();
        if (r20 == null) goto L19;
        r20.getPadding(this.tempRect);
        Rect r110 = this.tempRect;
        r18 = r18 + (r110.left + r110.right);
    L19:
        return r18 + r11.getEndIconView().getMeasuredWidth();
    L20:
        return 0;
    }

    private <T extends ListAdapter & Filterable> void updateText(Object r10) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        setText(convertSelectionToString(r10), false);
        return;
    L5:
        ListAdapter r11 = getAdapter();
        setAdapter(null);
        setText(convertSelectionToString(r10));
        setAdapter(r11);
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout r10 = findTextInputLayoutAncestor();
        if (r10 == null) goto L9;
        if (r10.O() == false) goto L9;
        return r10.getHint();
    L9:
        return super.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout r10 = findTextInputLayoutAncestor();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.O() == true) goto L7;
        return;
    L7:
        if (super.getHint() == null) goto L9;
        return;
    L9:
        if (com.google.android.material.internal.f.c() == false) goto L15;
        setHint("");
        return;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (View.MeasureSpec.getMode(r10) != Integer.MIN_VALUE) goto L6;
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth()), View.MeasureSpec.getSize(r10)), getMeasuredHeight());
        return;
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T r10) {
        super.setAdapter(r10);
        this.modalListPopup.setAdapter(getAdapter());
    }

    public void setSimpleItems(@ArrayRes int r10) {
        setSimpleItems(getResources().getStringArray(r10));
    }

    public void setSimpleItems(@NonNull String[] r10) {
        setAdapter(new ArrayAdapter(getContext(), this.simpleItemLayout, r10));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager r10 = this.accessibilityManager;
        if (r10 != null) goto L5;
    L7:
        super.showDropDown();
        return;
    L5:
        if (r10.isTouchExplorationEnabled() == false) goto L7;
        this.modalListPopup.show();
    }
}
