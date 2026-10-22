package com.obric.miniapp.lynx;

import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.obric.oui.calendar.OWeekPickerView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h4 implements OWeekPickerView.b {
    public final /* synthetic */ LynxOUIWeekPickerViewUI a;

    public h4(LynxOUIWeekPickerViewUI r1) {
        this.a = r1;
    }

    @Override // com.obric.oui.calendar.OWeekPickerView.b
    public final void onChanged(List<Integer> r6) {
        Intrinsics.checkNotNullParameter(r6, "selectedDays");
        if (this.a.e == false) goto L5;
        return;
    L5:
        Integer r7 = (Integer) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L17;
        int r8 = r7.intValue();
        LynxOUIWeekPickerViewUI r0 = this.a;
        r0.c = r8;
        String r1 = (String) CollectionsKt.getOrNull(r0.M(), r8);
        LynxContext r2 = r0.getLynxContext();
        if (r2 == null) goto L18;
        EventEmitter r3 = r2.getEventEmitter();
        if (r3 == null) goto L19;
        m7a.a r4 = new m7a.a(r0.getSign(), "change");
        r4.a("index", Integer.valueOf(r8));
        r4.a("value", Integer.valueOf(r8));
        if (r1 == null) goto L15;
        r4.a("title", r1);
    L15:
        r3.sendCustomEvent(r4);
        return;
    L19:
        return;
    L18:
        return;
    }
}
