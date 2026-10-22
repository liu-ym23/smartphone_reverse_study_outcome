package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDeviceSingleProductDisplayBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final LarusDoraDeviceBatteryLayoutBinding c;
    public final SimpleDraweeView d;
    public final DoraTextView e;
    public final SimpleDraweeView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraDeviceSingleProductDisplayBinding(ConstraintLayout r1, ConstraintLayout r2, LarusDoraDeviceBatteryLayoutBinding r3, SimpleDraweeView r4, DoraTextView r5, SimpleDraweeView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
