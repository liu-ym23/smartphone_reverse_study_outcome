package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.view.View;
import android.widget.LinearLayout;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f1<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsBroadcastSettingFragment a;

    public f1(DoraObricEarbudsBroadcastSettingFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r8, Continuation r9) {
        boolean r10 = ((Boolean) r8).booleanValue();
        DoraObricEarbudsBroadcastSettingFragment r11 = this.a;
        OSwitch r0 = r11.m;
        if (r0 == null) goto L7;
        r0.setOnCheckedChangeListener(null);
        r0.setChecked(r10);
        OSwitch r1 = r11.m;
        if (r1 == null) goto L7;
        r1.setOnCheckedChangeListener(new c0(r11));
    L7:
        final DoraObricEarbudsBroadcastSettingFragment r12 = this.a;
        r12.getClass();
        boolean r2 = false;
        if (r10 == false) goto L10;
        int r3 = 0;
    L11:
        OSectionTitleBar r4 = r12.n;
        if (r4 == null) goto L14;
        r4.setVisibility(r3);
    L14:
        View r5 = r12.o;
        if (r5 == null) goto L17;
        r5.setVisibility(r3);
    L17:
        View r6 = r12.r;
        if (r6 == null) goto L20;
        r6.setVisibility(r3);
    L20:
        OSectionTitleBar r7 = r12.u;
        if (r7 == null) goto L23;
        r7.setVisibility(r3);
    L23:
        LinearLayout r13 = r12.v;
        if (r13 == null) goto L27;
        r13.setVisibility(r3);
    L27:
        if (r10 == false) goto L50;
        IDoraService r14 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r14 == null) goto L31;
        DeviceService r15 = r14.device();
    L32:
        if (r15 != null) goto L34;
    L36:
        boolean r16 = false;
    L37:
        g49.d.d("DoraObricEarbudsBroadcastSetting", "updateHeadGestureControl: isSupported=" + r16);
        OCardListItem r17 = r12.y;
        if (r17 == null) goto L50;
        if (r16 == true) goto L42;
        r17.setVisibility(8);
        r12.la0();
        goto L50
    L42:
        r17.setVisibility(0);
        r12.la0();
        com.larus.dora.impl.util.b0.a.getClass();
        boolean r18 = com.larus.dora.impl.util.b0.r();
        int r20 = kj4.a.g().D();
        if (r18 == true) goto L45;
    L47:
        OSwitch r21 = r12.z;
        if (r21 == null) goto L50;
        r21.setOnCheckedChangeListener(null);
        r21.setChecked(com.larus.dora.impl.util.b0.r());
        r21.setOnCheckedChangeListener(new e0(r12));
        goto L50
    L45:
        if (r20 == 2) goto L47;
        com.larus.dora.impl.util.b0.K(false);
        goto L47
    L34:
        if (r15.n0(FlowProtocolAbility.FEATURE_CONVERSATION) != true) goto L36;
        r16 = true;
        goto L37
    L31:
        r15 = null;
    L50:
        OCardListItem r22 = r12.B;
        if (r22 != null) goto L53;
    L55:
        r12.ka0(r2, r10);
        return Unit.INSTANCE;
    L53:
        if (r22.getVisibility() != 0) goto L55;
        r2 = true;
        goto L55
    L10:
        r3 = 8;
        goto L11
    }
}
