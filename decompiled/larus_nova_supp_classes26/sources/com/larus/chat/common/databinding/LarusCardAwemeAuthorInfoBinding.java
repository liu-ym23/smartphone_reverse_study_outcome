package com.larus.chat.common.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.RoundAvatarImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusCardAwemeAuthorInfoBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RoundAvatarImageView b;
    public final AppCompatTextView c;
    public final AppCompatImageView d;
    public final AppCompatTextView e;

    public final View getRoot() {
        return this.a;
    }

    public static LarusCardAwemeAuthorInfoBinding a(View r8) {
        int r0 = 2131363623;
        RoundAvatarImageView r4 = (RoundAvatarImageView) ViewBindings.findChildViewById(r8, 2131363623);
        if (r4 == null) goto L13;
        r0 = 2131377870;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r8, 2131377870);
        if (r5 == null) goto L13;
        r0 = 2131377871;
        AppCompatImageView r6 = ViewBindings.findChildViewById(r8, 2131377871);
        if (r6 == null) goto L13;
        r0 = 2131380897;
        AppCompatTextView r7 = ViewBindings.findChildViewById(r8, 2131380897);
        if (r7 == null) goto L13;
        return new LarusCardAwemeAuthorInfoBinding((ConstraintLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }

    public LarusCardAwemeAuthorInfoBinding(ConstraintLayout r1, RoundAvatarImageView r2, AppCompatTextView r3, AppCompatImageView r4, AppCompatTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
