package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ViewPickerSelectedMoreBinding implements ViewBinding {
    public final CommonRecyclerView moreList;
    private final LinearLayout rootView;
    public final CommonTitleBar titleBar;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3347getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public LinearLayout m3347getRoot() {
        return this.rootView;
    }

    public static ViewPickerSelectedMoreBinding bind(View r3) {
        int r0 = 2131380315;
        CommonRecyclerView r1 = ViewBindings.findChildViewById(r3, 2131380315);
        if (r1 == null) goto L9;
        r0 = 2131388807;
        CommonTitleBar r2 = ViewBindings.findChildViewById(r3, 2131388807);
        if (r2 == null) goto L9;
        return new ViewPickerSelectedMoreBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }

    public static ViewPickerSelectedMoreBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    private ViewPickerSelectedMoreBinding(LinearLayout r1, CommonRecyclerView r2, CommonTitleBar r3) {
        this.rootView = r1;
        this.moreList = r2;
        this.titleBar = r3;
    }

    public static ViewPickerSelectedMoreBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131568191, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }
}
