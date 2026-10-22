package com.obric.assistant.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.coachmark.OCoachmarkTipView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricFragmentAutoGuiSettingsBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final OCoachmarkTipView b;
    public final RecyclerView c;
    public final OFloatingTitleBar d;

    public final View getRoot() {
        return this.a;
    }

    public ObricFragmentAutoGuiSettingsBinding(ConstraintLayout r1, OCoachmarkTipView r2, RecyclerView r3, OFloatingTitleBar r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
