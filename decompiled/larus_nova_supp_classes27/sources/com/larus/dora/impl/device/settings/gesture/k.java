package com.larus.dora.impl.device.settings.gesture;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k<T> implements FlowCollector {
    public final /* synthetic */ DoraGGestureSettingsFragment a;

    public k(DoraGGestureSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r10, Continuation r11) {
        r r12 = (r) r10;
        if ((r12 instanceof r.c) == false) goto L11;
        StringBuilder r13 = new StringBuilder("gestureStateFlow collect success: side=");
        r.c r14 = (r.c) r12;
        r13.append(r14.a);
        r13.append(", mediaCount=");
        r13.append(r14.b.size());
        r13.append(", callingCount=");
        r13.append(r14.c.size());
        r13.append(", aiCount=");
        r13.append(r14.d.size());
        g49.d.d("DoraGGestureSettingsFragment", r13.toString());
        DoraGGestureSettingsFragment r15 = this.a;
        LastSwitchSide r4 = r14.a;
        int r5 = DoraGGestureSettingsFragment.l;
        r15.da0(r4);
        DoraGGestureSettingsFragment r16 = this.a;
        LastSwitchSide r6 = r14.a;
        List<DoraGGestureSettings> r7 = r14.b;
        List<DoraGGestureSettings> r8 = r14.c;
        List<DoraGGestureSettings> r17 = r14.d;
        if (r16.f == null) goto L17;
        g49.d.d("DoraGGestureSettingsFragment", "updateItems: side=" + r6 + ", mediaCount=" + r7.size() + ", callingCount=" + r8.size() + ", aiCount=" + r17.size());
        if (r6 != LastSwitchSide.BUTTON) goto L9;
        r16.fa0(r17, (byte) 4);
        goto L17
    L9:
        r16.fa0(r7, (byte) 6);
        r16.fa0(r8, (byte) 1);
        r16.fa0(r17, (byte) 2);
    L17:
        return Unit.INSTANCE;
    L11:
        if ((r12 instanceof r.b) == false) goto L14;
        g49.d.d("DoraGGestureSettingsFragment", "gestureStateFlow collect idle");
        goto L17
    L14:
        if ((r12 instanceof r.a) == false) goto L19;
        g49.d.d("DoraGGestureSettingsFragment", "gestureStateFlow collect failed");
        goto L17
    L19:
        throw new NoWhenBranchMatchedException();
    }
}
