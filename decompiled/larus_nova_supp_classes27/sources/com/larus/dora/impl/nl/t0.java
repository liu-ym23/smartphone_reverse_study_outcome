package com.larus.dora.impl.nl;

import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.impl.databinding.LarusDoraPageProactiveBinding;
import com.larus.dora.impl.nl.freq.NotificationFreq;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t0<T> implements FlowCollector {
    public final /* synthetic */ ProactiveSettingsFragment a;

    public t0(ProactiveSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r9, Continuation r10) {
        int r11 = ((Number) r9).intValue();
        LarusDoraPageProactiveBinding r12 = this.a.f;
        if (r12 == null) goto L26;
        g49.d.d("ProactiveSettingsFragment", "updateProactiveNotificationFreq: freq=" + r11);
        NotificationFreq.Companion.getClass();
        NotificationFreq[] r0 = NotificationFreq.values();
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L14;
        NotificationFreq r6 = r0[r3];
        if (r6.getFreq() != r11) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == true) goto L15;
        r3 = r3 + 1;
    L15:
        if (r6 == null) goto L17;
        r2 = r6.getDescResId();
    L17:
        ItemTextArrow r13 = r12.i;
        if (r2 <= 0) goto L20;
        int r4 = com.larus.utils.j0.a;
        String r5 = com.larus.utils.j0.d(r2);
    L21:
        int r8 = ItemTextArrow.k;
        r13.Z5(r5, null);
        if (r12.l.getToggleView().isChecked() == false) goto L24;
        r12.i.setVisible(true);
    L24:
        Unit r14 = Unit.INSTANCE;
        goto L26
    L20:
        r5 = "";
        goto L21
    L10:
        r7 = false;
        goto L11
    L14:
        r6 = null;
    L26:
        return Unit.INSTANCE;
    }
}
