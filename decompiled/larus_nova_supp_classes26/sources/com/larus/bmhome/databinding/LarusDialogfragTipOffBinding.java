package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.view.FlowTagLayout;
import com.larus.common_ui.widget.NestedScrollEditText;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.common_ui.widget.roundlayout.RoundTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusDialogfragTipOffBinding implements ViewBinding {
    public final FrameLayout a;
    public final RoundTextView b;
    public final RoundLinearLayout c;
    public final NestedScrollEditText d;
    public final FrameLayout e;
    public final FlowTagLayout f;
    public final AppCompatImageView g;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogfragTipOffBinding(FrameLayout r1, RoundTextView r2, RoundLinearLayout r3, NestedScrollEditText r4, FrameLayout r5, FlowTagLayout r6, AppCompatImageView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
