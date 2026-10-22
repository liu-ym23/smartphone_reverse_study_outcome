package com.larus.uaigc.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.CircleFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusLayoutInstrutionImageSelectorBinding implements ViewBinding {
    public final View a;
    public final SimpleDraweeView b;
    public final LinearLayout c;
    public final TextView d;
    public final CircleFrameLayout e;
    public final FrameLayout f;
    public final ImageView g;
    public final View h;
    public final ImageView i;
    public final ConstraintLayout j;
    public final ProgressBar k;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutInstrutionImageSelectorBinding(View r1, SimpleDraweeView r2, LinearLayout r3, TextView r4, CircleFrameLayout r5, FrameLayout r6, ImageView r7, View r8, ImageView r9, ConstraintLayout r10, ProgressBar r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }
}
