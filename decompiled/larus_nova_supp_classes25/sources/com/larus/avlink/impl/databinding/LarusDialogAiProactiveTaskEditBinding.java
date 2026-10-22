package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LarusDialogAiProactiveTaskEditBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final EditText b;
    public final FrameLayout c;
    public final ProgressBar d;
    public final TextView e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogAiProactiveTaskEditBinding(ConstraintLayout r1, EditText r2, FrameLayout r3, ProgressBar r4, TextView r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
