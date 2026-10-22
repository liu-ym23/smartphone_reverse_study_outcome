package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ViewPickerSearchEmptyBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView searchEmptyHint;
    public final AppCompatImageView searchEmptyIv;
    public final LinearLayout searchResultEmpty;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3346getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public LinearLayout m3346getRoot() {
        return this.rootView;
    }

    public static ViewPickerSearchEmptyBinding bind(View r3) {
        int r0 = 2131385418;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, 2131385418);
        if (r1 == null) goto L9;
        r0 = 2131385419;
        AppCompatImageView r2 = ViewBindings.findChildViewById(r3, 2131385419);
        if (r2 == null) goto L9;
        LinearLayout r4 = (LinearLayout) r3;
        return new ViewPickerSearchEmptyBinding(r4, r1, r2, r4);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }

    public static ViewPickerSearchEmptyBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewPickerSearchEmptyBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131568190, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    private ViewPickerSearchEmptyBinding(LinearLayout r1, TextView r2, AppCompatImageView r3, LinearLayout r4) {
        this.rootView = r1;
        this.searchEmptyHint = r2;
        this.searchEmptyIv = r3;
        this.searchResultEmpty = r4;
    }
}
