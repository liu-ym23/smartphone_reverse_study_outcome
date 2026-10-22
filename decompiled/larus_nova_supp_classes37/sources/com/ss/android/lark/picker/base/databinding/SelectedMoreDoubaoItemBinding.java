package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SelectedMoreDoubaoItemBinding implements ViewBinding {
    public final View divider;
    public final LarkAvatarView ivAvatar;
    private final ConstraintLayout rootView;
    public final FrameLayout selectedRemove;
    public final TextView tvTitle;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3340getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public ConstraintLayout m3340getRoot() {
        return this.rootView;
    }

    public static SelectedMoreDoubaoItemBinding bind(View r7) {
        int r0 = 2131369197;
        View r3 = ViewBindings.findChildViewById(r7, 2131369197);
        if (r3 == null) goto L13;
        r0 = 2131376019;
        LarkAvatarView r4 = ViewBindings.findChildViewById(r7, 2131376019);
        if (r4 == null) goto L13;
        r0 = 2131385848;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r7, 2131385848);
        if (r5 == null) goto L13;
        r0 = 2131391606;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r7, 2131391606);
        if (r6 == null) goto L13;
        return new SelectedMoreDoubaoItemBinding((ConstraintLayout) r7, r3, r4, r5, r6);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r0)));
    }

    public static SelectedMoreDoubaoItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SelectedMoreDoubaoItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131564504, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    private SelectedMoreDoubaoItemBinding(ConstraintLayout r1, View r2, LarkAvatarView r3, FrameLayout r4, TextView r5) {
        this.rootView = r1;
        this.divider = r2;
        this.ivAvatar = r3;
        this.selectedRemove = r4;
        this.tvTitle = r5;
    }
}
