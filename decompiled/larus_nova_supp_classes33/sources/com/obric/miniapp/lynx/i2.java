package com.obric.miniapp.lynx;

import com.obric.oui.calendar.ODatePickerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class i2 implements Function1 {
    public final /* synthetic */ LynxOUIDatePickerViewUI a;
    public final /* synthetic */ ODatePickerView b;

    public /* synthetic */ i2(LynxOUIDatePickerViewUI r1, ODatePickerView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        LynxOUIDatePickerViewUI r0 = this.a;
        ODatePickerView r1 = this.b;
        ((Long) r3).longValue();
        int r4 = LynxOUIDatePickerViewUI.w;
        r0.N(r1, false);
        return Unit.INSTANCE;
    }
}
