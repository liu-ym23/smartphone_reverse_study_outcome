package com.larus.suggest.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.common_ui.video.VideoPlayView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusNexPulseDialogBinding implements ViewBinding {
    public final LinearLayout a;
    public final TextView b;
    public final AppCompatImageView c;
    public final ConstraintLayout d;
    public final CustomMarkdownTextView e;
    public final SimpleDraweeView f;
    public final ImageView g;
    public final View h;
    public final LinearLayout i;
    public final TextView j;
    public final VideoPlayView k;

    public final View getRoot() {
        return this.a;
    }

    public LarusNexPulseDialogBinding(LinearLayout r1, TextView r2, AppCompatImageView r3, ConstraintLayout r4, CustomMarkdownTextView r5, SimpleDraweeView r6, ImageView r7, View r8, LinearLayout r9, TextView r10, VideoPlayView r11) {
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
