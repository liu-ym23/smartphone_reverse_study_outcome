package com.obric.assistant.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricMtmItemSingleIconTemplateBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final TextView c;
    public final SimpleDraweeView d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public ObricMtmItemSingleIconTemplateBinding(ConstraintLayout r1, FrameLayout r2, TextView r3, SimpleDraweeView r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
