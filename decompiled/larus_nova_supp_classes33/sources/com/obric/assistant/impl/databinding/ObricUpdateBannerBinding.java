package com.obric.assistant.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.assistant.common.ui.progressbar.CustomUpdateCircleProgressBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricUpdateBannerBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final TextView c;
    public final ImageView d;
    public final ConstraintLayout e;
    public final CustomUpdateCircleProgressBar f;
    public final ProgressBar g;
    public final TextView h;
    public final TextView i;
    public final ConstraintLayout j;

    public final View getRoot() {
        return this.a;
    }

    public ObricUpdateBannerBinding(ConstraintLayout r1, ConstraintLayout r2, TextView r3, ImageView r4, ConstraintLayout r5, CustomUpdateCircleProgressBar r6, ProgressBar r7, TextView r8, TextView r9, ConstraintLayout r10) {
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
    }
}
