package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusVideoPreviewCardBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final SimpleDraweeView c;
    public final ImageView d;
    public final ProgressBar e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusVideoPreviewCardBinding(ConstraintLayout r1, FrameLayout r2, SimpleDraweeView r3, ImageView r4, ProgressBar r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
