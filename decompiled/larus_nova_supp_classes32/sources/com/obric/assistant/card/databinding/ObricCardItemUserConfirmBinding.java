package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.roundlayout.RoundRelativeLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricCardItemUserConfirmBinding implements ViewBinding {
    public final RoundRelativeLayout a;
    public final LinearLayout b;
    public final TextView c;
    public final TextView d;

    public final View getRoot() {
        return this.a;
    }

    public ObricCardItemUserConfirmBinding(RoundRelativeLayout r1, LinearLayout r2, TextView r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
