package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PickerScenarioListFragmentBinding implements ViewBinding {
    public final TextView pickerScenarioEmptyHint;
    public final RecyclerView pickerScenarioList;
    private final FrameLayout rootView;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3338getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public FrameLayout m3338getRoot() {
        return this.rootView;
    }

    public static PickerScenarioListFragmentBinding bind(View r3) {
        int r0 = 2131382278;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, 2131382278);
        if (r1 == null) goto L9;
        r0 = 2131382281;
        RecyclerView r2 = ViewBindings.findChildViewById(r3, 2131382281);
        if (r2 == null) goto L9;
        return new PickerScenarioListFragmentBinding((FrameLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }

    public static PickerScenarioListFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    private PickerScenarioListFragmentBinding(FrameLayout r1, TextView r2, RecyclerView r3) {
        this.rootView = r1;
        this.pickerScenarioEmptyHint = r2;
        this.pickerScenarioList = r3;
    }

    public static PickerScenarioListFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131564217, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }
}
