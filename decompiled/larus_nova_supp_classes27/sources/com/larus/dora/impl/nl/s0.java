package com.larus.dora.impl.nl;

import com.larus.dora.api.IDoraService;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.dora.impl.databinding.LarusDoraPageProactiveBinding;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s0<T> implements FlowCollector {
    public final /* synthetic */ ProactiveSettingsFragment a;

    public s0(ProactiveSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r7, Continuation r8) {
        boolean r9 = ((Boolean) r7).booleanValue();
        final ProactiveSettingsFragment r10 = this.a;
        LarusDoraPageProactiveBinding r0 = r10.f;
        if (r0 == null) goto L29;
        g49.d.d("ProactiveSettingsFragment", "updateProactiveNotificationState: enabled=" + r9);
        r0.l.getToggleView().setChecked(r9);
        if (r9 == false) goto L26;
        e1.x(r0.k);
        r0.i.setVisible(true);
        e1.x(r0.h);
        IDoraService r11 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r11 == null) goto L9;
        DeviceService r12 = r11.device();
    L10:
        if (r12 != null) goto L12;
    L14:
        boolean r13 = false;
    L15:
        g49.d.d("ProactiveSettingsFragment", "setupHeadGestureControl: isSupported=" + r13);
        final LarusDoraPageProactiveBinding r4 = r10.f;
        if (r4 == null) goto L25;
        if (r13 == false) goto L24;
        e1.x(r4.d);
        com.larus.dora.impl.util.b0.a.getClass();
        boolean r14 = com.larus.dora.impl.util.b0.r();
        int r5 = kj4.a.g().D();
        if (r14 == true) goto L21;
    L23:
        r4.d.getToggleView().setChecked(com.larus.dora.impl.util.b0.r());
        r4.d.getToggleView().a = true;
        e1.d(r4.d, new v(r4, r10));
        goto L25
    L21:
        if (r5 == 2) goto L23;
        g49.d.d("ProactiveSettingsFragment", "updateHeadGestureControl: local ON but system OFF, syncing to OFF");
        com.larus.dora.impl.util.b0.K(false);
        goto L23
    L24:
        e1.o(r4.d);
    L25:
        e1.x(r0.c);
        r0.l.setBackgroundResource(2131239212);
    L27:
        Unit r15 = Unit.INSTANCE;
        goto L29
    L12:
        if (r12.n0(FlowProtocolAbility.FEATURE_CONVERSATION) != true) goto L14;
        r13 = true;
        goto L15
    L9:
        r12 = null;
        goto L10
    L26:
        e1.o(r0.k);
        r0.i.setVisible(false);
        e1.o(r0.h);
        e1.o(r0.d);
        e1.o(r0.c);
        r0.l.setBackgroundResource(2131239210);
    L29:
        return Unit.INSTANCE;
    }
}
