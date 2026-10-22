package com.larus.uaigc.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusEmptyResourceItemViewBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final SimpleDraweeView c;
    public final TextView d;

    public final View getRoot() {
        return this.a;
    }

    public LarusEmptyResourceItemViewBinding(ConstraintLayout r1, ConstraintLayout r2, SimpleDraweeView r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
