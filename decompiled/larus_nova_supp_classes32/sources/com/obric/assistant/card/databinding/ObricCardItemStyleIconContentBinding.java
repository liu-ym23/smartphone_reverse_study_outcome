package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricCardItemStyleIconContentBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final SimpleDraweeView c;
    public final TextView d;
    public final ConstraintLayout e;

    public final View getRoot() {
        return this.a;
    }

    public ObricCardItemStyleIconContentBinding(ConstraintLayout r1, TextView r2, SimpleDraweeView r3, TextView r4, ConstraintLayout r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
