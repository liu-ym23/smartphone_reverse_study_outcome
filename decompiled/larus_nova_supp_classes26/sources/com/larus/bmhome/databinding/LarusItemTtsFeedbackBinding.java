package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusItemTtsFeedbackBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final SimpleDraweeView c;
    public final AppCompatImageView d;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemTtsFeedbackBinding(ConstraintLayout r1, TextView r2, SimpleDraweeView r3, AppCompatImageView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
