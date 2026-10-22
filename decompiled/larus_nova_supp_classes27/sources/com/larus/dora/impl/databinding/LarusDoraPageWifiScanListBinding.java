package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraPageWifiScanListBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final LinearLayoutCompat c;
    public final ProgressBar d;
    public final ImageView e;
    public final TextView f;
    public final RecyclerView g;
    public final NovaTitleBarEx h;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraPageWifiScanListBinding(ConstraintLayout r1, View r2, LinearLayoutCompat r3, ProgressBar r4, ImageView r5, TextView r6, RecyclerView r7, NovaTitleBarEx r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
