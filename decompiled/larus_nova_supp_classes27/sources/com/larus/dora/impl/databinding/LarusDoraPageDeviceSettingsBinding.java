package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraPageDeviceSettingsBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RecyclerView b;
    public final NovaTitleBarEx c;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraPageDeviceSettingsBinding(ConstraintLayout r1, RecyclerView r2, NovaTitleBarEx r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
