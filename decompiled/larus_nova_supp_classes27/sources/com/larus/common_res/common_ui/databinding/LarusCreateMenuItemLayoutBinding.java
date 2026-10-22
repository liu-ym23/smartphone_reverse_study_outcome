package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusCreateMenuItemLayoutBinding implements ViewBinding {
    public final View a;
    public final SimpleDraweeView b;
    public final SimpleDraweeView c;
    public final FrameLayout d;

    public final View getRoot() {
        return this.a;
    }

    public LarusCreateMenuItemLayoutBinding(View r1, SimpleDraweeView r2, LinearLayout r3, AppCompatTextView r4, SimpleDraweeView r5, AppCompatTextView r6, AppCompatTextView r7, ConstraintLayout r8, SimpleDraweeView r9, AppCompatTextView r10, FrameLayout r11) {
        this.a = r1;
        this.b = r2;
        this.c = r5;
        this.d = r11;
    }
}
