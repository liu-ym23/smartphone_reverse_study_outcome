package com.larus.dora.impl.device.settings.lab.headcontrol.option;

import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.dora.impl.databinding.LarusDoraPageHeadControlOptionBinding;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlActionOption;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlGestureType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d<T> implements FlowCollector {
    public final /* synthetic */ HeadControlOptionFragment a;

    public d(HeadControlOptionFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r5, Continuation r6) {
        w49.c r7 = (w49.c) r5;
        HeadControlOptionFragment r8 = this.a;
        int r0 = HeadControlOptionFragment.i;
        if (((HeadControlGestureType) r8.h.getValue()) != HeadControlGestureType.NOD) goto L5;
        HeadControlActionOption r9 = r7.a;
    L6:
        LarusDoraPageHeadControlOptionBinding r10 = this.a.f;
        if (r10 == null) goto L22;
        ItemTextSelector r1 = r10.c;
        boolean r2 = true;
        if (r9 != HeadControlActionOption.ACCEPT_CONFIRM) goto L11;
        boolean r3 = true;
    L12:
        r1.setSelected(r3);
        ItemTextSelector r4 = r10.e;
        if (r9 != HeadControlActionOption.REJECT_CLOSE) goto L15;
        boolean r11 = true;
    L16:
        r4.setSelected(r11);
        ItemTextSelector r12 = r10.d;
        if (r9 == HeadControlActionOption.NONE) goto L20;
        r2 = false;
    L20:
        r12.setSelected(r2);
        goto L22
    L15:
        r11 = false;
        goto L16
    L11:
        r3 = false;
    L22:
        return Unit.INSTANCE;
    L5:
        r9 = r7.b;
        goto L6
    }
}
