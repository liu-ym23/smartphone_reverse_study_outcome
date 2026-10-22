package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDeviceInfoReconnectLayoutBinding implements ViewBinding {
    public final FrameLayout a;
    public final LinearLayout b;
    public final AppCompatTextView c;
    public final ImageView d;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraDeviceInfoReconnectLayoutBinding(FrameLayout r1, LinearLayout r2, AppCompatTextView r3, ImageView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
