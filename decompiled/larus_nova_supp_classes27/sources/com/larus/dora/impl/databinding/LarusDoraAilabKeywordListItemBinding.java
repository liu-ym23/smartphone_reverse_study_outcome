package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraAilabKeywordListItemBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RoundAvatarImageView b;
    public final DoraTextView c;
    public final ImageView d;
    public final DoraTextView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraAilabKeywordListItemBinding(ConstraintLayout r1, RoundAvatarImageView r2, DoraTextView r3, ImageView r4, DoraTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
