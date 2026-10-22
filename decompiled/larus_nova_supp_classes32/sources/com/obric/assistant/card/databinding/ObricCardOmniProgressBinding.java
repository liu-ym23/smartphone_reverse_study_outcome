package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.venus.ShapeConstraintLayout;
import com.obric.assistant.view.ObricShimmerProgressBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricCardOmniProgressBinding implements ViewBinding {
    public final RelativeLayout a;
    public final TextView b;
    public final ObricShimmerProgressBar c;
    public final ShapeConstraintLayout d;
    public final TextView e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public ObricCardOmniProgressBinding(RelativeLayout r1, TextView r2, ObricShimmerProgressBar r3, ShapeConstraintLayout r4, TextView r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
