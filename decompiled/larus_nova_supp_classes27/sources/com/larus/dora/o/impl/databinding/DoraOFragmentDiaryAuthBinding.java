package com.larus.dora.o.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOFragmentDiaryAuthBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final OButton b;
    public final LinearLayout c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final OFloatingTitleBar h;

    public final View getRoot() {
        return this.a;
    }

    public DoraOFragmentDiaryAuthBinding(ConstraintLayout r1, OButton r2, LinearLayout r3, ImageView r4, ImageView r5, ImageView r6, ImageView r7, OFloatingTitleBar r8) {
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
