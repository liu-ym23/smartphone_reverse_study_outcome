package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.TitleAvatarImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusLayoutLeftAvatarBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TitleAvatarImageView b;
    public final TextView c;
    public final TextView d;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutLeftAvatarBinding(ConstraintLayout r1, TitleAvatarImageView r2, TextView r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
