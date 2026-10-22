package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraFeatureIntroductionFragmentBinding implements ViewBinding {
    public final LinearLayout a;
    public final LinearLayout b;
    public final NestedScrollView c;
    public final AppCompatImageView d;
    public final DoraTextView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraFeatureIntroductionFragmentBinding(LinearLayout r1, LinearLayout r2, NestedScrollView r3, AppCompatImageView r4, DoraTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
