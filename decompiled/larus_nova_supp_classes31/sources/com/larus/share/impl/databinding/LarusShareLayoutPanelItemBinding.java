package com.larus.share.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusShareLayoutPanelItemBinding implements ViewBinding {
    public final LinearLayout a;
    public final FrameLayout b;
    public final ImageView c;
    public final ProgressBar d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusShareLayoutPanelItemBinding(LinearLayout r1, FrameLayout r2, ImageView r3, ProgressBar r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
