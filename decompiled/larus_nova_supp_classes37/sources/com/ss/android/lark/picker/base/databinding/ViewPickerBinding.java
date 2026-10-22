package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.search.baseview.SearchFrameLayout;
import com.ss.android.lark.search.baseview.SearchInputView;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ViewPickerBinding implements ViewBinding {
    public final LinearLayoutCompat pickerActionArea;
    public final TextView pickerCancelTv;
    public final FrameLayout pickerCenterContainer;
    public final SearchFrameLayout pickerDefaultViewContainer;
    public final FrameLayout pickerHeaderContainer;
    public final SearchInputView pickerSearchInput;
    public final SearchResultView pickerSearchResult;
    public final DividerBinding pickerSelectedDivider;
    public final FrameLayout pickerSelectedMore;
    public final CommonRecyclerView pickerSelectedRv;
    public final ConstraintLayout pickerSelectedView;
    public final LinearLayout pickerTopContainer;
    public final DividerBinding pickerTopContainerDivider;
    public final FrameLayout pickerTopContainerFl;
    private final ConstraintLayout rootView;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3344getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public ConstraintLayout m3344getRoot() {
        return this.rootView;
    }

    public static ViewPickerBinding bind(View r19) {
        int r1 = 2131382266;
        LinearLayoutCompat r5 = ViewBindings.findChildViewById(r19, 2131382266);
        if (r5 == null) goto L33;
        r1 = 2131382267;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r19, 2131382267);
        if (r6 == null) goto L33;
        r1 = 2131382268;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r19, 2131382268);
        if (r7 == null) goto L33;
        r1 = 2131382270;
        SearchFrameLayout r8 = ViewBindings.findChildViewById(r19, 2131382270);
        if (r8 == null) goto L33;
        r1 = 2131382271;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r19, 2131382271);
        if (r9 == null) goto L33;
        r1 = 2131382282;
        SearchInputView r10 = ViewBindings.findChildViewById(r19, 2131382282);
        if (r10 == null) goto L33;
        r1 = 2131382283;
        SearchResultView r11 = (SearchResultView) ViewBindings.findChildViewById(r19, 2131382283);
        if (r11 == null) goto L33;
        r1 = 2131382284;
        View r2 = ViewBindings.findChildViewById(r19, 2131382284);
        if (r2 == null) goto L33;
        DividerBinding r12 = DividerBinding.bind(r2);
        r1 = 2131382285;
        FrameLayout r13 = (FrameLayout) ViewBindings.findChildViewById(r19, 2131382285);
        if (r13 == null) goto L33;
        r1 = 2131382286;
        CommonRecyclerView r14 = ViewBindings.findChildViewById(r19, 2131382286);
        if (r14 == null) goto L33;
        r1 = 2131382288;
        ConstraintLayout r15 = ViewBindings.findChildViewById(r19, 2131382288);
        if (r15 == null) goto L33;
        r1 = 2131382291;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r19, 2131382291);
        if (r16 == null) goto L33;
        r1 = 2131382292;
        View r3 = ViewBindings.findChildViewById(r19, 2131382292);
        if (r3 == null) goto L33;
        DividerBinding r17 = DividerBinding.bind(r3);
        r1 = 2131382293;
        FrameLayout r18 = (FrameLayout) ViewBindings.findChildViewById(r19, 2131382293);
        if (r18 == null) goto L33;
        return new ViewPickerBinding((ConstraintLayout) r19, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r1)));
    }

    public static ViewPickerBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewPickerBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131568188, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    private ViewPickerBinding(ConstraintLayout r1, LinearLayoutCompat r2, TextView r3, FrameLayout r4, SearchFrameLayout r5, FrameLayout r6, SearchInputView r7, SearchResultView r8, DividerBinding r9, FrameLayout r10, CommonRecyclerView r11, ConstraintLayout r12, LinearLayout r13, DividerBinding r14, FrameLayout r15) {
        this.rootView = r1;
        this.pickerActionArea = r2;
        this.pickerCancelTv = r3;
        this.pickerCenterContainer = r4;
        this.pickerDefaultViewContainer = r5;
        this.pickerHeaderContainer = r6;
        this.pickerSearchInput = r7;
        this.pickerSearchResult = r8;
        this.pickerSelectedDivider = r9;
        this.pickerSelectedMore = r10;
        this.pickerSelectedRv = r11;
        this.pickerSelectedView = r12;
        this.pickerTopContainer = r13;
        this.pickerTopContainerDivider = r14;
        this.pickerTopContainerFl = r15;
    }
}
