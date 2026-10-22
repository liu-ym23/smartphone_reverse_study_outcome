package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraMovieView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraOnboardingDeviceFoundBinding implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final AppCompatTextView c;
    public final LinearLayoutCompat d;
    public final DoraMovieView e;
    public final FrameLayout f;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraOnboardingDeviceFoundBinding(FrameLayout r1, ImageView r2, AppCompatTextView r3, LinearLayoutCompat r4, DoraMovieView r5, FrameLayout r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
