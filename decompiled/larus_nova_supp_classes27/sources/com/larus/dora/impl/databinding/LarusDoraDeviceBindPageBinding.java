package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDeviceBindPageBinding implements ViewBinding {
    public final RelativeLayout a;
    public final TextView b;
    public final TextView c;
    public final HistoryDeviceNavigationBar d;
    public final SimpleDraweeView e;
    public final TextView f;
    public final TextView g;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraDeviceBindPageBinding(RelativeLayout r1, TextView r2, TextView r3, HistoryDeviceNavigationBar r4, SimpleDraweeView r5, TextView r6, TextView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
