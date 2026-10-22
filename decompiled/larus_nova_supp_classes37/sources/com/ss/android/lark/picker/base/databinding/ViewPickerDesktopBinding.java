package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.search.baseview.SearchInputView;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ViewPickerDesktopBinding implements ViewBinding {
    public final Guideline guideline;
    public final FrameLayout pickerCenterContainer;
    public final FrameLayout pickerDefaultViewContainer;
    public final SearchInputView pickerSearchInput;
    public final SearchResultView pickerSearchResult;
    public final CommonRecyclerView pickerSelectedView;
    public final FrameLayout pickerTopContainer;
    private final ConstraintLayout rootView;
    public final View selectDivider;
    public final TextView selectedCount;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3345getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public ConstraintLayout m3345getRoot() {
        return this.rootView;
    }

    public static ViewPickerDesktopBinding bind(View r13) {
        int r0 = 2131374162;
        Guideline r4 = ViewBindings.findChildViewById(r13, 2131374162);
        if (r4 == null) goto L23;
        r0 = 2131382268;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131382268);
        if (r5 == null) goto L23;
        r0 = 2131382270;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131382270);
        if (r6 == null) goto L23;
        r0 = 2131382282;
        SearchInputView r7 = ViewBindings.findChildViewById(r13, 2131382282);
        if (r7 == null) goto L23;
        r0 = 2131382283;
        SearchResultView r8 = (SearchResultView) ViewBindings.findChildViewById(r13, 2131382283);
        if (r8 == null) goto L23;
        r0 = 2131382288;
        CommonRecyclerView r9 = ViewBindings.findChildViewById(r13, 2131382288);
        if (r9 == null) goto L23;
        r0 = 2131382291;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131382291);
        if (r10 == null) goto L23;
        r0 = 2131385790;
        View r11 = ViewBindings.findChildViewById(r13, 2131385790);
        if (r11 == null) goto L23;
        r0 = 2131385833;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r13, 2131385833);
        if (r12 == null) goto L23;
        return new ViewPickerDesktopBinding((ConstraintLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }

    public static ViewPickerDesktopBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewPickerDesktopBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131568189, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    private ViewPickerDesktopBinding(ConstraintLayout r1, Guideline r2, FrameLayout r3, FrameLayout r4, SearchInputView r5, SearchResultView r6, CommonRecyclerView r7, FrameLayout r8, View r9, TextView r10) {
        this.rootView = r1;
        this.guideline = r2;
        this.pickerCenterContainer = r3;
        this.pickerDefaultViewContainer = r4;
        this.pickerSearchInput = r5;
        this.pickerSearchResult = r6;
        this.pickerSelectedView = r7;
        this.pickerTopContainer = r8;
        this.selectDivider = r9;
        this.selectedCount = r10;
    }
}
