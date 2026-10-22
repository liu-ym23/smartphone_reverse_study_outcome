package com.larus.canvas.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusCanvasTitleBinding implements ViewBinding {
    public final View a;
    public final ImageView b;
    public final TextView c;
    public final AppCompatImageView d;
    public final ProgressBar e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusCanvasTitleBinding(View r1, ImageView r2, TextView r3, AppCompatImageView r4, ProgressBar r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
