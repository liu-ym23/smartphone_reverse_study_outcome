package com.larus.dora.impl.noti_v3.overview.ui;

import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.impl.databinding.LarusDoraPageNotiV3Binding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class x<T> implements FlowCollector {
    public final /* synthetic */ NotificationBroadcastV3Fragment a;

    public x(NotificationBroadcastV3Fragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r9, Continuation r10) {
        com.larus.dora.impl.noti_v3.overview.viewmodel.b r11 = (com.larus.dora.impl.noti_v3.overview.viewmodel.b) r9;
        NotificationBroadcastV3Fragment r12 = this.a;
        LarusDoraPageNotiV3Binding r0 = r12.f;
        if (r0 == null) goto L22;
        ItemTextArrow r1 = r0.t;
        int r2 = ItemTextArrow.k;
        String r3 = "";
        r1.Z5("", null);
        ItemTextArrow r4 = r0.s;
        int r5 = r11.d;
        if (r5 <= 0) goto L7;
        String r6 = r12.getString(2131902284, new Object[]{Boxing.boxInt(r5)});
    L8:
        Intrinsics.checkNotNull(r6);
        r4.Z5(r6, null);
        ItemTextArrow r7 = r0.n;
        int r8 = r11.e;
        if (r8 <= 0) goto L11;
        String r13 = r12.getString(2131902268, new Object[]{Boxing.boxInt(r8)});
    L12:
        Intrinsics.checkNotNull(r13);
        r7.Z5(r13, null);
        ItemTextArrow r14 = r0.g;
        int r15 = r11.f;
        if (r15 <= 0) goto L15;
        r3 = r12.getString(2131902303, new Object[]{Boxing.boxInt(r15)});
    L15:
        Intrinsics.checkNotNull(r3);
        r14.Z5(r3, null);
        Integer r16 = r11.b;
        if (r16 == null) goto L18;
        r0.o.Z5(r12.getString(r16.intValue()), null);
    L18:
        Integer r17 = r11.a;
        if (r17 == null) goto L22;
        r0.r.Z5(r12.getString(r17.intValue()), null);
        goto L22
    L11:
        r13 = "";
        goto L12
    L7:
        r6 = "";
    L22:
        return Unit.INSTANCE;
    }
}
