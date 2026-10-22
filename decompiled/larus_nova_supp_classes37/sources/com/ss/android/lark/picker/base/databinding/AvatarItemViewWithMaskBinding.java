package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AvatarItemViewWithMaskBinding implements ViewBinding {
    public final AvatarItemView avatarItem;
    public final View avatarItemMask;
    public final AppCompatImageView chatPreviewIcon;
    private final View rootView;

    public View getRoot() {
        return this.rootView;
    }

    public static AvatarItemViewWithMaskBinding bind(View r4) {
        int r0 = 2131363674;
        AvatarItemView r1 = (AvatarItemView) ViewBindings.findChildViewById(r4, 2131363674);
        if (r1 == null) goto L11;
        r0 = 2131363687;
        View r2 = ViewBindings.findChildViewById(r4, 2131363687);
        if (r2 == null) goto L11;
        r0 = 2131365578;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r4, 2131365578);
        if (r3 == null) goto L11;
        return new AvatarItemViewWithMaskBinding(r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }

    public static AvatarItemViewWithMaskBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(2131558756, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    private AvatarItemViewWithMaskBinding(View r1, AvatarItemView r2, View r3, AppCompatImageView r4) {
        this.rootView = r1;
        this.avatarItem = r2;
        this.avatarItemMask = r3;
        this.chatPreviewIcon = r4;
    }
}
