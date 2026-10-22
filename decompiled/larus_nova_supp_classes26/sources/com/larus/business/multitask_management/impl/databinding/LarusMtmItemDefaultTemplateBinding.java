package com.larus.business.multitask_management.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.CircleProgressBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusMtmItemDefaultTemplateBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final CircleProgressBar c;
    public final ImageView d;
    public final FrameLayout e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusMtmItemDefaultTemplateBinding(ConstraintLayout r1, TextView r2, CircleProgressBar r3, ImageView r4, FrameLayout r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
