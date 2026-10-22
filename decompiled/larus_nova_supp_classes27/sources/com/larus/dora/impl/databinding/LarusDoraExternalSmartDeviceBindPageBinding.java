package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraExternalSmartDeviceBindPageBinding implements ViewBinding {
    public final RelativeLayout a;
    public final LinearLayoutCompat b;
    public final ProgressBar c;
    public final AppCompatTextView d;
    public final HistoryDeviceNavigationBar e;
    public final SimpleDraweeView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraExternalSmartDeviceBindPageBinding(RelativeLayout r1, LinearLayoutCompat r2, ProgressBar r3, AppCompatTextView r4, HistoryDeviceNavigationBar r5, SimpleDraweeView r6, TextView r7, TextView r8, TextView r9) {
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
