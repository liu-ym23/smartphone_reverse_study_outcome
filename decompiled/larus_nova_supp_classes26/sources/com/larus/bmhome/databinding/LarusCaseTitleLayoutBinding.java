package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.TitleAvatarImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusCaseTitleLayoutBinding implements ViewBinding {
    public final View a;
    public final TitleAvatarImageView b;
    public final AppCompatImageView c;
    public final ImageView d;
    public final ConstraintLayout e;
    public final ConstraintLayout f;
    public final AppCompatImageView g;
    public final TextView h;
    public final TextView i;

    public final View getRoot() {
        return this.a;
    }

    public LarusCaseTitleLayoutBinding(View r1, TitleAvatarImageView r2, AppCompatImageView r3, ImageView r4, ConstraintLayout r5, ConstraintLayout r6, AppCompatImageView r7, TextView r8, TextView r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
