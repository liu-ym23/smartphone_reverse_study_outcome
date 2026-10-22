package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricCardItemStyleTitleSubtitleListBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LinearLayout b;
    public final SimpleDraweeView c;
    public final SimpleDraweeView d;
    public final LinearLayout e;
    public final ConstraintLayout f;
    public final TextView g;

    public final View getRoot() {
        return this.a;
    }

    public ObricCardItemStyleTitleSubtitleListBinding(ConstraintLayout r1, LinearLayout r2, SimpleDraweeView r3, SimpleDraweeView r4, LinearLayout r5, ConstraintLayout r6, TextView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
