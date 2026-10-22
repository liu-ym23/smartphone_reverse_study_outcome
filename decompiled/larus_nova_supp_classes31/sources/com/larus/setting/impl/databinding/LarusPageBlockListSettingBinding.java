package com.larus.setting.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusPageBlockListSettingBinding implements ViewBinding {
    public final LinearLayout a;
    public final TextView b;
    public final RecyclerView c;
    public final LinearLayout d;
    public final NovaTitleBarEx e;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageBlockListSettingBinding(LinearLayout r1, TextView r2, RecyclerView r3, LinearLayout r4, NovaTitleBarEx r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
