package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraBatteryGuideToastBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final SimpleDraweeView b;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraBatteryGuideToastBinding(ConstraintLayout r1, SimpleDraweeView r2, DoraTextView r3, LinearLayoutCompat r4, LottieAdapterView r5, DoraTextView r6, LinearLayoutCompat r7, LottieAdapterView r8, DoraTextView r9, Barrier r10) {
        this.a = r1;
        this.b = r2;
    }
}
