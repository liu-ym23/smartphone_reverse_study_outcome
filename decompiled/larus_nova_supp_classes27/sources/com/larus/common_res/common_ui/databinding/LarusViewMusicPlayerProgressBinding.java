package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.video.progress.HorizontalProgressLayer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusViewMusicPlayerProgressBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final TextView c;
    public final View d;
    public final HorizontalProgressLayer e;
    public final SeekBar f;
    public final ConstraintLayout g;
    public final TextView h;
    public final TextView i;

    public final View getRoot() {
        return this.a;
    }

    public LarusViewMusicPlayerProgressBinding(ConstraintLayout r1, TextView r2, TextView r3, View r4, HorizontalProgressLayer r5, SeekBar r6, ConstraintLayout r7, TextView r8, TextView r9) {
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
