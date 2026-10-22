package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LarusItemThumbnailBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final CheckBox b;
    public final SimpleDraweeView c;
    public final TextView d;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemThumbnailBinding(ConstraintLayout r1, CheckBox r2, SimpleDraweeView r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
