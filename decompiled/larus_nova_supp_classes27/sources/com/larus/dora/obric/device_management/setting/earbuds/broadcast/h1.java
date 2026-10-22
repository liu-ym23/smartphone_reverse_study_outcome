package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h1<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsBroadcastSettingFragment a;

    public h1(DoraObricEarbudsBroadcastSettingFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r5, Continuation r6) {
        Boolean r7 = (Boolean) r5;
        OCardListItem r8 = this.a.B;
        boolean r0 = false;
        if (r8 == null) goto L8;
        if (r7 != null) goto L6;
        int r1 = 8;
    L7:
        r8.setVisibility(r1);
        goto L8
    L6:
        r1 = 0;
    L8:
        DoraObricEarbudsBroadcastSettingFragment r9 = this.a;
        OSwitch r2 = r9.C;
        if (r2 == null) goto L15;
        r2.setOnCheckedChangeListener(null);
        if (r7 == null) goto L15;
        r2.setChecked(r7.booleanValue());
        boolean r3 = r7.booleanValue();
        OSwitch r4 = r9.C;
        if (r4 == null) goto L15;
        r4.setOnCheckedChangeListener(new d0(r3, r9));
    L15:
        DoraObricEarbudsBroadcastSettingFragment r10 = this.a;
        if (r7 == null) goto L18;
        r0 = true;
    L18:
        r10.ka0(r0, ((Boolean) DoraUserSettingsManager.g.getValue()).booleanValue());
        return Unit.INSTANCE;
    }
}
