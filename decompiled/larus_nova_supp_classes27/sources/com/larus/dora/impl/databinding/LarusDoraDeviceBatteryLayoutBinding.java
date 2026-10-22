package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDeviceBatteryLayoutBinding implements ViewBinding {
    public final LinearLayoutCompat a;
    public final LinearLayoutCompat b;
    public final LottieAdapterView c;
    public final ImageView d;
    public final AppCompatTextView e;

    public final View getRoot() {
        return this.a;
    }

    public static LarusDoraDeviceBatteryLayoutBinding a(View r6) {
        LinearLayoutCompat r2 = (LinearLayoutCompat) r6;
        int r0 = 2131369855;
        LottieAdapterView r3 = ViewBindings.findChildViewById(r6, 2131369855);
        if (r3 == null) goto L11;
        r0 = 2131369856;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r6, 2131369856);
        if (r4 == null) goto L11;
        r0 = 2131369857;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r6, 2131369857);
        if (r5 == null) goto L11;
        return new LarusDoraDeviceBatteryLayoutBinding(r2, r2, r3, r4, r5);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }

    public LarusDoraDeviceBatteryLayoutBinding(LinearLayoutCompat r1, LinearLayoutCompat r2, LottieAdapterView r3, ImageView r4, AppCompatTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
