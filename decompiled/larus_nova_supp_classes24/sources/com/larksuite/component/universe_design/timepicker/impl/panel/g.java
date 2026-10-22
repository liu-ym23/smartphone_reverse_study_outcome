package com.larksuite.component.universe_design.timepicker.impl.panel;

import com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g implements OnItemSelectedListener {
    public final /* synthetic */ f a;

    public g(f r1) {
        this.a = r1;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener
    public final void onItemSelected(int r2) {
        f.a(this.a);
        this.a.getPickerPanelDependency().onSelected(this.a.c.getCalendar());
    }
}
