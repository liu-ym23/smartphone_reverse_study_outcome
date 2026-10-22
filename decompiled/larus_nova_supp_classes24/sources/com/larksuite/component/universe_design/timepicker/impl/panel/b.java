package com.larksuite.component.universe_design.timepicker.impl.panel;

import com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements OnItemSelectedListener {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener
    public final void onItemSelected(int r6) {
        a r7 = this.a;
        WheelView r0 = r7.b;
        if (r0 == null) goto L11;
        WheelView r2 = r7.d;
        if (r7.a == true) goto L10;
        if (r2 == null) goto L10;
        int r1 = r0.getCurrentItem() + (r2.getCurrentItem() * 12);
        r7.f.set(11, r1);
    L10:
        r7.f.set(11, r0.getCurrentItem());
    L11:
        WheelView r3 = r7.c;
        if (r3 == null) goto L14;
        int r4 = r3.getCurrentItem() * r7.g;
        r7.f.set(12, r4);
    L14:
        this.a.getPickerPanelDependency().onSelected(this.a.f);
    }
}
