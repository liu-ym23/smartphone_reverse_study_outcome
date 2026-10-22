package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraWifiListItemBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final DoraTextView b;
    public final ProgressBar c;
    public final DoraTextView d;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraWifiListItemBinding(ConstraintLayout r1, DoraTextView r2, ProgressBar r3, DoraTextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
