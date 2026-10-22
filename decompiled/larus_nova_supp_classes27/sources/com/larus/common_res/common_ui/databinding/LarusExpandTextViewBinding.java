package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusExpandTextViewBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final TextView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusExpandTextViewBinding(ConstraintLayout r1, TextView r2, TextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
