package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusDeepSearchCardBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final AppCompatImageView c;
    public final SimpleDraweeView d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusDeepSearchCardBinding(ConstraintLayout r1, TextView r2, AppCompatImageView r3, SimpleDraweeView r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
