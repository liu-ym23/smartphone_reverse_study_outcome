package com.larus.photopicker.v2.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.photopicker.v2.impl.ui.AspectRatioFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusItemMediaBinding implements ViewBinding {
    public final AspectRatioFrameLayout a;
    public final SimpleDraweeView b;
    public final AppCompatTextView c;
    public final FrameLayout d;
    public final View e;
    public final AppCompatTextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemMediaBinding(AspectRatioFrameLayout r1, SimpleDraweeView r2, AppCompatTextView r3, FrameLayout r4, View r5, AppCompatTextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
