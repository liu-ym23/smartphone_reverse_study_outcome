package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.text.Editable;
import com.obric.oui.forms.OEditText;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsAddRuleInputSheet a;

    public j(DoraObricEarbudsAddRuleInputSheet r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        boolean r5 = ((Boolean) r3).booleanValue();
        DoraObricEarbudsAddRuleInputSheet r6 = this.a;
        r6.h = r5;
        OEditText r7 = r6.e;
        boolean r0 = false;
        if (r7 == null) goto L12;
        Editable r8 = r7.getText();
        if (r8 == null) goto L12;
        if (r8.length() <= 0) goto L9;
        boolean r9 = true;
    L10:
        if (r9 != true) goto L12;
        r0 = true;
        goto L12
    L9:
        r9 = false;
    L12:
        r6.W90(r0);
        return Unit.INSTANCE;
    }
}
