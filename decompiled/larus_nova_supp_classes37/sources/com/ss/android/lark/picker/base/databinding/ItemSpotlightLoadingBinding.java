package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ItemSpotlightLoadingBinding implements ViewBinding {
    public final LinearLayout pickerNetLoadingFail;
    public final AppCompatImageView pickerNetLoadingFailIcon;
    public final LinearLayout pickerSpotlightLoading;
    private final FrameLayout rootView;
    public final FrameLayout searchLoadingContainer;
    public final AppCompatImageView searchNetLoadingIv;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3336getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public FrameLayout m3336getRoot() {
        return this.rootView;
    }

    public static ItemSpotlightLoadingBinding bind(View r9) {
        int r0 = 2131382274;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r9, 2131382274);
        if (r4 == null) goto L13;
        r0 = 2131382275;
        AppCompatImageView r5 = ViewBindings.findChildViewById(r9, 2131382275);
        if (r5 == null) goto L13;
        r0 = 2131382289;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r9, 2131382289);
        if (r6 == null) goto L13;
        FrameLayout r7 = (FrameLayout) r9;
        r0 = 2131385544;
        AppCompatImageView r8 = ViewBindings.findChildViewById(r9, 2131385544);
        if (r8 == null) goto L13;
        return new ItemSpotlightLoadingBinding(r7, r4, r5, r6, r7, r8);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }

    public static ItemSpotlightLoadingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemSpotlightLoadingBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131561704, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    private ItemSpotlightLoadingBinding(FrameLayout r1, LinearLayout r2, AppCompatImageView r3, LinearLayout r4, FrameLayout r5, AppCompatImageView r6) {
        this.rootView = r1;
        this.pickerNetLoadingFail = r2;
        this.pickerNetLoadingFailIcon = r3;
        this.pickerSpotlightLoading = r4;
        this.searchLoadingContainer = r5;
        this.searchNetLoadingIv = r6;
    }
}
