package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDeviceInfoGeneraGroupLayoutBinding implements ViewBinding {
    public final LinearLayout a;
    public final LinearLayout b;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraDeviceInfoGeneraGroupLayoutBinding(LinearLayout r1, LinearLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    public static LarusDoraDeviceInfoGeneraGroupLayoutBinding a(LayoutInflater r2, ViewGroup r3) {
        View r4 = r2.inflate(2131562153, r3, false);
        if (r4 == null) goto L7;
        LinearLayout r5 = (LinearLayout) r4;
        return new LarusDoraDeviceInfoGeneraGroupLayoutBinding(r5, r5);
    L7:
        throw new NullPointerException("rootView");
    }
}
