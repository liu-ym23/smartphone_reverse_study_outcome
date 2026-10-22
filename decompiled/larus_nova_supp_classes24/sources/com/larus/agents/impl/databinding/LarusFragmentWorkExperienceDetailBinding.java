package com.larus.agents.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarusFragmentWorkExperienceDetailBinding implements ViewBinding {
    public final FrameLayout a;
    public final ItemTextToggle b;
    public final TextView c;
    public final AppCompatImageView d;
    public final ProgressBar e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentWorkExperienceDetailBinding(FrameLayout r1, ItemTextToggle r2, TextView r3, AppCompatImageView r4, ProgressBar r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
