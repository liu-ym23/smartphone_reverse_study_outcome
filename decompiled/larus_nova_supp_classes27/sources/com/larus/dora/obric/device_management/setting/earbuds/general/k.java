package com.larus.dora.obric.device_management.setting.earbuds.general;

import android.view.View;
import com.larus.dora.impl.device.settings.general.w;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsGeneralSettingsFragment a;

    public k(DoraObricEarbudsGeneralSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r8, Continuation r9) {
        w r10 = (w) r8;
        if (Intrinsics.areEqual(r10, w.a.a) == true) goto L81;
        if ((r10 instanceof w.b) == false) goto L79;
        final DoraObricEarbudsGeneralSettingsFragment r11 = this.a;
        w.b r12 = (w.b) r10;
        int r0 = DoraObricEarbudsGeneralSettingsFragment.p;
        r11.getClass();
        if (r12.b.vendorId != 4096) goto L9;
        boolean r1 = true;
    L10:
        OCardListItem r4 = r11.j;
        if (r4 == null) goto L16;
        if (r1 == false) goto L14;
        int r6 = 0;
    L15:
        r4.setVisibility(r6);
        goto L16
    L14:
        r6 = 8;
    L16:
        View r5 = r11.k;
        if (r5 == null) goto L22;
        if (r1 == false) goto L20;
        int r7 = 0;
    L21:
        r5.setVisibility(r7);
        goto L22
    L20:
        r7 = 8;
    L22:
        if (r1 == false) goto L31;
        OCardListItem r2 = r11.j;
        if (r2 == null) goto L26;
        r2.k(o59.a.d(r12.b), r11.ba0(220));
    L26:
        OCardListItem r3 = r11.j;
        if (r3 == null) goto L31;
        OTextView r13 = r3.getEndDetail();
        if (r13 == null) goto L31;
        r11.X90(r13, false);
    L31:
        String r14 = o59.a.e(r12.b);
        String r15 = r12.e;
        if (r15 != null) goto L34;
    L37:
        boolean r16 = true;
    L38:
        boolean r17 = true ^ r16;
        OCardListItem r18 = r11.l;
        if (r18 == null) goto L41;
        r18.k(r14, r11.ba0(140));
    L41:
        OCardListItem r20 = r11.l;
        if (r20 == null) goto L46;
        OTextView r21 = r20.getEndDetail();
        if (r21 == null) goto L46;
        r11.X90(r21, r17);
    L46:
        final String r22 = r12.b.sn;
        if (r22 != null) goto L49;
        r22 = "";
    L49:
        final OCardListItem r23 = r11.m;
        if (r23 == null) goto L56;
        r23.k(r22, r11.ba0(320));
        OTextView r24 = r23.getEndDetail();
        if (r24 == null) goto L55;
        r11.X90(r24, false);
    L55:
        r23.post(new f(r23, r22, r11));
    L56:
        final DoraObricEarbudsGeneralSettingsFragment r25 = this.a;
        View r26 = r25.g;
        if (r26 == null) goto L81;
        if (r12.b.vendorId != 4096) goto L65;
        r26.setVisibility(8);
        View r27 = r25.h;
        if (r27 == null) goto L81;
        r27.setVisibility(8);
        goto L81
    L65:
        if (r25.ca0().isMultiDeviceEnable() == false) goto L75;
        r26.setVisibility(0);
        View r28 = r25.h;
        if (r28 == null) goto L69;
        r28.setVisibility(0);
    L69:
        OSwitch r30 = r25.i;
        if (r30 == null) goto L81;
        r30.setOnCheckedChangeListener(null);
        boolean r31 = r30.isChecked();
        boolean r32 = r12.c;
        if (r31 == r32) goto L74;
        r30.setChecked(r32);
    L74:
        r30.setOnCheckedChangeListener(new e(r25));
        goto L81
    L75:
        r26.setVisibility(8);
        View r33 = r25.h;
        if (r33 == null) goto L81;
        r33.setVisibility(8);
        goto L81
    L34:
        if (r15.length() == 0) goto L37;
        r16 = false;
        goto L38
    L9:
        r1 = false;
        goto L10
    L79:
        throw new NoWhenBranchMatchedException();
    L81:
        return Unit.INSTANCE;
    }
}
