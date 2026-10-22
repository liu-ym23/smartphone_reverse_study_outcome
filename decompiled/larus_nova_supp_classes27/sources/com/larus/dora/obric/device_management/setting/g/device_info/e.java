package com.larus.dora.obric.device_management.setting.g.device_info;

import com.larus.dora.impl.device.settings.general.w;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGDeviceInfoFragment a;

    public e(DoraObricGDeviceInfoFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r6, Continuation r7) {
        w r8 = (w) r6;
        if (Intrinsics.areEqual(r8, w.a.a) == true) goto L34;
        if ((r8 instanceof w.b) == false) goto L32;
        final DoraObricGDeviceInfoFragment r9 = this.a;
        w.b r10 = (w.b) r8;
        int r0 = DoraObricGDeviceInfoFragment.l;
        r9.getClass();
        String r1 = o59.a.e(r10.b);
        String r2 = r10.e;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        boolean r4 = !r3;
        OCardListItem r5 = r9.h;
        if (r5 == null) goto L16;
        r5.k(r1, r9.Z90(140));
    L16:
        OCardListItem r11 = r9.h;
        if (r11 == null) goto L21;
        OTextView r12 = r11.getEndDetail();
        if (r12 == null) goto L21;
        r9.X90(r12, r4);
    L21:
        final String r13 = r10.b.sn;
        if (r13 != null) goto L24;
        r13 = "";
    L24:
        final OCardListItem r14 = r9.i;
        if (r14 == null) goto L34;
        r14.k(r13, r9.Z90(320));
        OTextView r15 = r14.getEndDetail();
        if (r15 == null) goto L30;
        r9.X90(r15, false);
    L30:
        r14.post(new a(r14, r13, r9));
        goto L34
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L32:
        throw new NoWhenBranchMatchedException();
    L34:
        return Unit.INSTANCE;
    }
}
