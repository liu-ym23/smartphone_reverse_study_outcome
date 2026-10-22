package com.larus.dora.o.impl.databinding;

import android.view.View;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOFragmentDiarySettingsBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final OCardListItem b;
    public final ScrollView c;
    public final OFloatingTitleBar d;
    public final OCardListItem e;

    public final View getRoot() {
        return this.a;
    }

    public DoraOFragmentDiarySettingsBinding(ConstraintLayout r1, OCardListItem r2, ScrollView r3, OFloatingTitleBar r4, OCardListItem r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
