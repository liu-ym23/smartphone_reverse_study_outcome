package com.larus.dora.obric.device_management.setting.g.general;

import android.view.View;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGGeneralSettingsFragment a;

    public n(DoraObricGGeneralSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r12, Continuation r13) {
        com.larus.dora.impl.device.settings.general.w r14 = (com.larus.dora.impl.device.settings.general.w) r12;
        if (Intrinsics.areEqual(r14, com.larus.dora.impl.device.settings.general.w.a.a) == true) goto L145;
        if ((r14 instanceof com.larus.dora.impl.device.settings.general.w.b) == false) goto L143;
        DoraObricGGeneralSettingsFragment r15 = this.a;
        com.larus.dora.impl.device.settings.general.w.b r16 = (com.larus.dora.impl.device.settings.general.w.b) r14;
        int r0 = DoraObricGGeneralSettingsFragment.x;
        r15.getClass();
        DoraDevice r1 = r16.b;
        boolean r2 = true;
        int r3 = 0;
        if (((Boolean) r15.h.getValue()).booleanValue() == true) goto L9;
    L11:
        boolean r4 = false;
    L13:
        if (o59.a.p(r1) == true) goto L22;
        if (r1 != null) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == true) goto L22;
        boolean r6 = false;
    L23:
        boolean r7 = o59.a.p(r1);
        OCardListItem r8 = r15.i;
        if (r8 != null) goto L26;
    L30:
        OCardListItem r9 = r15.i;
        if (r9 == null) goto L36;
        if (r4 == false) goto L34;
        int r10 = 0;
    L35:
        r9.setVisibility(r10);
        goto L36
    L34:
        r10 = 8;
    L36:
        OCardListItem r11 = r15.j;
        if (r11 == null) goto L42;
        if (r6 == false) goto L40;
        int r17 = 0;
    L41:
        r11.setVisibility(r17);
        goto L42
    L40:
        r17 = 8;
    L42:
        OCardListItem r18 = r15.k;
        if (r18 == null) goto L48;
        if (r7 == false) goto L46;
        int r20 = 0;
    L47:
        r18.setVisibility(r20);
        goto L48
    L46:
        r20 = 8;
    L48:
        OCardListItem r21 = r15.l;
        if (r21 == null) goto L54;
        if (r7 == false) goto L52;
        int r22 = 0;
    L53:
        r21.setVisibility(r22);
        goto L54
    L52:
        r22 = 8;
    L54:
        OCardListItem r23 = r15.m;
        if (r23 == null) goto L60;
        if (r7 == false) goto L58;
        int r24 = 0;
    L59:
        r23.setVisibility(r24);
        goto L60
    L58:
        r24 = 8;
    L60:
        OCardListItem r25 = r15.i;
        if (r25 != null) goto L63;
    L65:
        boolean r26 = false;
    L66:
        OCardListItem r27 = r15.j;
        if (r27 != null) goto L69;
    L71:
        boolean r28 = false;
    L72:
        OCardListItem r30 = r15.k;
        if (r30 != null) goto L75;
    L77:
        boolean r31 = false;
    L78:
        OCardListItem r32 = r15.l;
        if (r32 != null) goto L81;
    L83:
        boolean r33 = false;
    L84:
        OCardListItem r34 = r15.m;
        if (r34 != null) goto L87;
    L89:
        r2 = false;
    L90:
        View r35 = r15.p;
        if (r35 == null) goto L97;
        if (r26 == false) goto L95;
        if (r28 == false) goto L95;
        int r110 = 0;
    L96:
        r35.setVisibility(r110);
    L95:
        r110 = 8;
    L97:
        View r36 = r15.q;
        if (r36 == null) goto L105;
        if (r26 == true) goto L101;
        if (r28 == true) goto L101;
    L103:
        int r37 = 8;
    L104:
        r36.setVisibility(r37);
    L101:
        if (r31 == false) goto L103;
        r37 = 0;
    L105:
        View r38 = r15.r;
        if (r38 == null) goto L112;
        if (r31 == false) goto L110;
        if (r33 == false) goto L110;
        int r40 = 0;
    L111:
        r38.setVisibility(r40);
    L110:
        r40 = 8;
    L112:
        View r41 = r15.s;
        if (r41 == null) goto L120;
        if (r33 == false) goto L117;
        if (r2 == false) goto L117;
    L118:
        r41.setVisibility(r3);
    L117:
        r3 = 8;
    L120:
        if (r4 == false) goto L131;
        boolean r42 = r16.c;
        OSwitch r43 = r15.n;
        if (r43 == null) goto L124;
        r43.setOnCheckedChangeListener(null);
    L124:
        OSwitch r44 = r15.n;
        if (r44 == null) goto L127;
        r44.setChecked(r42);
    L127:
        OSwitch r45 = r15.n;
        if (r45 == null) goto L130;
        r45.setOnCheckedChangeListener(r15.v);
    L130:
        g49.d.d("DoraObricGGeneralSettings", "doraMultiDevicesSwitch: " + r42);
    L131:
        if (r6 == false) goto L145;
        boolean r111 = r16.d;
        OSwitch r46 = r15.o;
        if (r46 == null) goto L135;
        r46.setOnCheckedChangeListener(null);
    L135:
        OSwitch r47 = r15.o;
        if (r47 == null) goto L138;
        r47.setChecked(r111);
    L138:
        OSwitch r48 = r15.o;
        if (r48 == null) goto L141;
        r48.setOnCheckedChangeListener(r15.w);
    L141:
        g49.d.d("DoraObricGGeneralSettings", "doraWearSensor: " + r111);
        goto L145
    L87:
        if (r34.getVisibility() != 0) goto L89;
    L81:
        if (r32.getVisibility() != 0) goto L83;
        r33 = true;
        goto L84
    L75:
        if (r30.getVisibility() != 0) goto L77;
        r31 = true;
        goto L78
    L69:
        if (r27.getVisibility() != 0) goto L71;
        r28 = true;
        goto L72
    L63:
        if (r25.getVisibility() != 0) goto L65;
        r26 = true;
        goto L66
    L26:
        if (r1.productId != ProductNameType.DORA_G2.id) goto L28;
        int r50 = 2131903506;
    L29:
        r8.setSubTitle(r15.getString(r50));
        goto L30
    L28:
        r50 = 2131902766;
        goto L29
    L16:
        if (r1.productId != ProductNameType.DORA_E.id) goto L18;
        r5 = true;
    L22:
        r6 = true;
        goto L23
    L9:
        if (r15.ba0().isMultiDeviceEnable() == false) goto L11;
        r4 = true;
        goto L13
    L143:
        throw new NoWhenBranchMatchedException();
    L145:
        return Unit.INSTANCE;
    }
}
