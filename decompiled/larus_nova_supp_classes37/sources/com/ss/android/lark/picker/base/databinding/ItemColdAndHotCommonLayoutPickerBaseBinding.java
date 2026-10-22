package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ss.android.lark.picker.base.view.CommonIconFrontTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ItemColdAndHotCommonLayoutPickerBaseBinding implements ViewBinding {
    public final ProgressBar coldAndHotLoadingProgressbar;
    public final CommonIconFrontTextView coldAndHotTipText;
    private final ConstraintLayout rootView;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3332getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public ConstraintLayout m3332getRoot() {
        return this.rootView;
    }

    public static ItemColdAndHotCommonLayoutPickerBaseBinding bind(View r3) {
        int r0 = 2131367106;
        ProgressBar r1 = (ProgressBar) ViewBindings.findChildViewById(r3, 2131367106);
        if (r1 == null) goto L9;
        r0 = 2131367108;
        CommonIconFrontTextView r2 = (CommonIconFrontTextView) ViewBindings.findChildViewById(r3, 2131367108);
        if (r2 == null) goto L9;
        return new ItemColdAndHotCommonLayoutPickerBaseBinding((ConstraintLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }

    public static ItemColdAndHotCommonLayoutPickerBaseBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    private ItemColdAndHotCommonLayoutPickerBaseBinding(ConstraintLayout r1, ProgressBar r2, CommonIconFrontTextView r3) {
        this.rootView = r1;
        this.coldAndHotLoadingProgressbar = r2;
        this.coldAndHotTipText = r3;
    }

    public static ItemColdAndHotCommonLayoutPickerBaseBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131561583, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }
}
