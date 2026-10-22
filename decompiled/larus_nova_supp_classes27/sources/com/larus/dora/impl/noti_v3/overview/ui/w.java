package com.larus.dora.impl.noti_v3.overview.ui;

import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.dora.impl.databinding.LarusDoraPageNotiV3Binding;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class w<T> implements FlowCollector {
    public final /* synthetic */ NotificationBroadcastV3Fragment a;

    public w(NotificationBroadcastV3Fragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r7, Continuation r8) {
        boolean r9 = ((Boolean) r7).booleanValue();
        LarusDoraPageNotiV3Binding r10 = this.a.f;
        if (r10 == null) goto L9;
        ItemTextToggle r11 = r10.p;
        if (r11 == null) goto L9;
        CustomSwitchCompat r12 = r11.getToggleView();
        if (r12 == null) goto L9;
        r12.setChecked(r9);
    L9:
        final NotificationBroadcastV3Fragment r13 = this.a;
        LarusDoraPageNotiV3Binding r0 = r13.f;
        if (r0 == null) goto L39;
        boolean r1 = false;
        if (r9 == false) goto L33;
        e1.x(r0.f);
        e1.x(r0.e);
        e1.x(r0.b);
        e1.x(r0.d);
        e1.x(r0.c);
        r0.p.setBackgroundResource(2131239210);
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r3 == null) goto L16;
        DeviceService r4 = r3.device();
    L17:
        if (r4 != null) goto L19;
    L21:
        boolean r5 = false;
    L22:
        g49.d.d("NotificationBroadcastV3Fragment", "updateHeadGestureControl: isSupported=" + r5);
        final LarusDoraPageNotiV3Binding r6 = r13.f;
        if (r6 == null) goto L35;
        if (r5 == false) goto L31;
        e1.x(r6.h);
        com.larus.dora.impl.util.b0.a.getClass();
        boolean r14 = com.larus.dora.impl.util.b0.r();
        int r15 = kj4.a.g().D();
        if (r14 == true) goto L28;
    L30:
        r6.h.getToggleView().setChecked(com.larus.dora.impl.util.b0.r());
        r6.h.getToggleView().a = true;
        e1.d(r6.h, new f(r6, r13));
    L32:
        r6.c.c();
        goto L35
    L28:
        if (r15 == 2) goto L30;
        com.larus.dora.impl.util.b0.K(false);
        goto L30
    L31:
        e1.o(r6.h);
    L35:
        if (r0.u.getVisibility() != 0) goto L37;
        r1 = true;
    L37:
        r13.ba0(r1, r9);
        goto L39
    L19:
        if (r4.n0(FlowProtocolAbility.FEATURE_CONVERSATION) != true) goto L21;
        r5 = true;
        goto L22
    L16:
        r4 = null;
        goto L17
    L33:
        e1.o(r0.f);
        e1.o(r0.e);
        e1.o(r0.b);
        e1.o(r0.d);
        e1.o(r0.c);
        r0.p.setBackgroundResource(2131239210);
    L39:
        return Unit.INSTANCE;
    }
}
