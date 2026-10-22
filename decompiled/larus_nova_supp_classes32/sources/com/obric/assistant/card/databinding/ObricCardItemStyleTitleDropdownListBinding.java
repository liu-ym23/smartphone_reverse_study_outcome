package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricCardItemStyleTitleDropdownListBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LinearLayout b;
    public final SimpleDraweeView c;
    public final ConstraintLayout d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public ObricCardItemStyleTitleDropdownListBinding(ConstraintLayout r1, LinearLayout r2, SimpleDraweeView r3, ConstraintLayout r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
