package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SelectedItemBinding implements ViewBinding {
    public final LarkAvatarView miniAvatar;
    private final RelativeLayout rootView;
    public final LarkAvatarView selectedAvatar;
    public final AppCompatImageView selectedTeamBadge;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3339getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public RelativeLayout m3339getRoot() {
        return this.rootView;
    }

    public static SelectedItemBinding bind(View r4) {
        int r0 = 2131380140;
        LarkAvatarView r1 = ViewBindings.findChildViewById(r4, 2131380140);
        if (r1 == null) goto L11;
        r0 = 2131385830;
        LarkAvatarView r2 = ViewBindings.findChildViewById(r4, 2131385830);
        if (r2 == null) goto L11;
        r0 = 2131385849;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r4, 2131385849);
        if (r3 == null) goto L11;
        return new SelectedItemBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }

    public static SelectedItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SelectedItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131564503, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    private SelectedItemBinding(RelativeLayout r1, LarkAvatarView r2, LarkAvatarView r3, AppCompatImageView r4) {
        this.rootView = r1;
        this.miniAvatar = r2;
        this.selectedAvatar = r3;
        this.selectedTeamBadge = r4;
    }
}
