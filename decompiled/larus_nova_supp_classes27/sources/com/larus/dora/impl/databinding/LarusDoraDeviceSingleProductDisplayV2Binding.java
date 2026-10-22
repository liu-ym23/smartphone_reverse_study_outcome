package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDeviceSingleProductDisplayV2Binding implements ViewBinding {
    public final ConstraintLayout a;
    public final LarusDoraDeviceBatteryLayoutBinding b;
    public final SimpleDraweeView c;
    public final LinearLayoutCompat d;
    public final LarusDoraDeviceBatteryLayoutBinding e;
    public final SimpleDraweeView f;
    public final DoraTextView g;
    public final DoraTextView h;
    public final SimpleDraweeView i;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraDeviceSingleProductDisplayV2Binding(ConstraintLayout r1, LarusDoraDeviceBatteryLayoutBinding r2, SimpleDraweeView r3, LinearLayoutCompat r4, LarusDoraDeviceBatteryLayoutBinding r5, SimpleDraweeView r6, DoraTextView r7, DoraTextView r8, SimpleDraweeView r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
