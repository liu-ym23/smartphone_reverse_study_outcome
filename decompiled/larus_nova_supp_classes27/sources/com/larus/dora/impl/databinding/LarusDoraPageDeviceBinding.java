package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraNovaTitleBarEx;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraPageDeviceBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LarusDoraDeviceDisconnectedLayoutBinding b;
    public final LarusDoraDeviceInfoLayoutBinding c;
    public final LarusDoraDeviceScanLayoutBinding d;
    public final DoraNovaTitleBarEx e;
    public final View f;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraPageDeviceBinding(ConstraintLayout r1, LarusDoraDeviceDisconnectedLayoutBinding r2, LarusDoraDeviceInfoLayoutBinding r3, LarusDoraDeviceScanLayoutBinding r4, DoraNovaTitleBarEx r5, View r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
