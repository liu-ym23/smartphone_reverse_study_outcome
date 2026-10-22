package com.obric.assistant.settings.experience;

import android.view.View;
import com.obric.assistant.impl.databinding.ObricFragmentUserExperiencePlanBinding;
import com.obric.assistant.settings.p0;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f implements View.OnLayoutChangeListener {
    public final /* synthetic */ ObricUserExperiencePlanFragment a;

    public f(ObricUserExperiencePlanFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        ObricUserExperiencePlanFragment r10 = this.a;
        ObricFragmentUserExperiencePlanBinding r11 = r10.e;
        if (r11 == null) goto L9;
        OCardListItem r12 = r11.f;
        if (r12 == null) goto L10;
        r10.h = null;
        p0.d(r12);
        return;
    L10:
        return;
    }
}
