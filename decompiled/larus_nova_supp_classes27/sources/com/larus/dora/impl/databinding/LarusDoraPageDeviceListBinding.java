package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraPageDeviceListBinding implements ViewBinding {
    public final LinearLayout a;
    public final RecyclerView b;
    public final HistoryDeviceNavigationBar c;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraPageDeviceListBinding(LinearLayout r1, RecyclerView r2, HistoryDeviceNavigationBar r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
