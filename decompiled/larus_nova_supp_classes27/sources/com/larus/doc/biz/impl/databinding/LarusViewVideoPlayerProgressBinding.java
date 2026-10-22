package com.larus.doc.biz.impl.databinding;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusViewVideoPlayerProgressBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final TextView c;
    public final View d;
    public final SeekBar e;
    public final ConstraintLayout f;
    public final TextView g;
    public final TextView h;

    public final View getRoot() {
        return this.a;
    }

    public LarusViewVideoPlayerProgressBinding(ConstraintLayout r1, TextView r2, TextView r3, View r4, SeekBar r5, ConstraintLayout r6, TextView r7, TextView r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
