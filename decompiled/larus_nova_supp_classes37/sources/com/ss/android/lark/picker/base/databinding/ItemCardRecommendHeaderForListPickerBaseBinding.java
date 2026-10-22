package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ItemCardRecommendHeaderForListPickerBaseBinding implements ViewBinding {
    public final AppCompatImageView more;
    private final RelativeLayout rootView;
    public final TextView title;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3331getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public RelativeLayout m3331getRoot() {
        return this.rootView;
    }

    public static ItemCardRecommendHeaderForListPickerBaseBinding bind(View r3) {
        int r0 = 2131380286;
        AppCompatImageView r1 = ViewBindings.findChildViewById(r3, 2131380286);
        if (r1 == null) goto L9;
        r0 = 2131388772;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, 2131388772);
        if (r2 == null) goto L9;
        return new ItemCardRecommendHeaderForListPickerBaseBinding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }

    public static ItemCardRecommendHeaderForListPickerBaseBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    private ItemCardRecommendHeaderForListPickerBaseBinding(RelativeLayout r1, AppCompatImageView r2, TextView r3) {
        this.rootView = r1;
        this.more = r2;
        this.title = r3;
    }

    public static ItemCardRecommendHeaderForListPickerBaseBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131561571, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }
}
