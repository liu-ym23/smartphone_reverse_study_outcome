package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraMovieView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDeviceScanLayoutBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final LinearLayoutCompat c;
    public final AppCompatImageView d;
    public final DoraMovieView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraDeviceScanLayoutBinding(ConstraintLayout r1, TextView r2, LinearLayoutCompat r3, AppCompatImageView r4, DoraMovieView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
