package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraFunctionIntroductionFragmentBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final SimpleDraweeView b;
    public final LinearLayout c;
    public final ImageView d;
    public final DoraTextView e;
    public final DoraTextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraFunctionIntroductionFragmentBinding(ConstraintLayout r1, SimpleDraweeView r2, LinearLayout r3, ImageView r4, DoraTextView r5, DoraTextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
