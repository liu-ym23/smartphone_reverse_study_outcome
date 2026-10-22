package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class FragmentDoraEnvObserveDiaryListBinding implements ViewBinding {
    public final LinearLayoutCompat a;
    public final TextView b;
    public final TextView c;
    public final LinearLayout d;
    public final LottieAdapterView e;
    public final TextView f;
    public final ConstraintLayout g;
    public final TextView h;
    public final RecyclerView i;
    public final SwipeRefreshLayout j;
    public final NovaTitleBarEx k;

    public final View getRoot() {
        return this.a;
    }

    public FragmentDoraEnvObserveDiaryListBinding(LinearLayoutCompat r1, TextView r2, TextView r3, LinearLayout r4, LottieAdapterView r5, TextView r6, ConstraintLayout r7, TextView r8, RecyclerView r9, SwipeRefreshLayout r10, NovaTitleBarEx r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }
}
