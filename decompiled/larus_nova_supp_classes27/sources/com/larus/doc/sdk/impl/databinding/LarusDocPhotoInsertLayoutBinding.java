package com.larus.doc.sdk.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDocPhotoInsertLayoutBinding implements ViewBinding {
    public final LinearLayout docBottomMenuContainer;
    public final LinearLayout docBottomMenuItemCamera;
    public final LinearLayout docBottomMenuItemPhoto;
    public final LinearLayout docBottomPhotoSelectContainer;
    public final View docPhotoPickTopBorder;
    public final ImageView layoutMenuItemIconCamera;
    public final AppCompatTextView layoutMenuItemName;
    private final LinearLayout rootView;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m43getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public LinearLayout m43getRoot() {
        return this.rootView;
    }

    public static LarusDocPhotoInsertLayoutBinding bind(View r11) {
        int r0 = 2131369275;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r11, 2131369275);
        if (r4 == null) goto L17;
        r0 = 2131369276;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r11, 2131369276);
        if (r5 == null) goto L17;
        r0 = 2131369277;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r11, 2131369277);
        if (r6 == null) goto L17;
        LinearLayout r7 = (LinearLayout) r11;
        r0 = 2131369346;
        View r8 = ViewBindings.findChildViewById(r11, 2131369346);
        if (r8 == null) goto L17;
        r0 = 2131377546;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r11, 2131377546);
        if (r9 == null) goto L17;
        r0 = 2131377547;
        AppCompatTextView r10 = ViewBindings.findChildViewById(r11, 2131377547);
        if (r10 == null) goto L17;
        return new LarusDocPhotoInsertLayoutBinding(r7, r4, r5, r6, r7, r8, r9, r10);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }

    public static LarusDocPhotoInsertLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LarusDocPhotoInsertLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131562126, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    private LarusDocPhotoInsertLayoutBinding(LinearLayout r1, LinearLayout r2, LinearLayout r3, LinearLayout r4, LinearLayout r5, View r6, ImageView r7, AppCompatTextView r8) {
        this.rootView = r1;
        this.docBottomMenuContainer = r2;
        this.docBottomMenuItemCamera = r3;
        this.docBottomMenuItemPhoto = r4;
        this.docBottomPhotoSelectContainer = r5;
        this.docPhotoPickTopBorder = r6;
        this.layoutMenuItemIconCamera = r7;
        this.layoutMenuItemName = r8;
    }
}
