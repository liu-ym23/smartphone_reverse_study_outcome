package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricCardItemStyleTitleContentBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RelativeLayout b;
    public final SimpleDraweeView c;
    public final ImageView d;
    public final ConstraintLayout e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    public final View getRoot() {
        return this.a;
    }

    public ObricCardItemStyleTitleContentBinding(ConstraintLayout r1, RelativeLayout r2, SimpleDraweeView r3, ImageView r4, ConstraintLayout r5, TextView r6, TextView r7, TextView r8) {
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
