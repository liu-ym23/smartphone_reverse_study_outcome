package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraOnboardingPromptDialogBinding implements ViewBinding {
    public final FrameLayout a;
    public final AppCompatTextView b;
    public final ImageView c;
    public final AppCompatTextView d;
    public final DoraMovieView e;
    public final FrameLayout f;
    public final SimpleDraweeView g;
    public final DoraTextView h;
    public final DoraTextView i;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraOnboardingPromptDialogBinding(FrameLayout r1, AppCompatTextView r2, ImageView r3, AppCompatTextView r4, DoraMovieView r5, FrameLayout r6, SimpleDraweeView r7, DoraTextView r8, DoraTextView r9) {
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
