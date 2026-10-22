package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDeviceUnbindLayoutBinding implements ViewBinding {
    public final LinearLayout a;
    public final LinearLayout b;
    public final AppCompatTextView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraDeviceUnbindLayoutBinding(LinearLayout r1, LinearLayout r2, AppCompatTextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
