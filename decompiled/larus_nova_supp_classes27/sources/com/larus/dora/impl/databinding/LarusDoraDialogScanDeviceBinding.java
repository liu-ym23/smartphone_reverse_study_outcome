package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDialogScanDeviceBinding implements ViewBinding {
    public final FrameLayout a;
    public final RecyclerView b;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraDialogScanDeviceBinding(FrameLayout r1, RoundLinearLayout r2, RecyclerView r3) {
        this.a = r1;
        this.b = r3;
    }
}
