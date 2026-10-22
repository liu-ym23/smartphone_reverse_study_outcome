package com.larus.dora.obric.device_management.setting.g.gesture;

import android.widget.LinearLayout;
import com.larus.dora.impl.databinding.LarusDoraPageObricGGestureSettingsBinding;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import com.larus.dora.impl.device.settings.gesture.LastSwitchSide;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGGestureSettingsFragment a;

    public s(DoraObricGGestureSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r11, Continuation r12) {
        com.larus.dora.impl.device.settings.gesture.r r13 = (com.larus.dora.impl.device.settings.gesture.r) r11;
        if ((r13 instanceof com.larus.dora.impl.device.settings.gesture.r.c) == false) goto L32;
        StringBuilder r14 = new StringBuilder("gestureStateFlow success: side=");
        com.larus.dora.impl.device.settings.gesture.r.c r15 = (com.larus.dora.impl.device.settings.gesture.r.c) r13;
        r14.append(r15.a);
        r14.append(", media=");
        r14.append(r15.b.size());
        r14.append(", calling=");
        r14.append(r15.c.size());
        r14.append(", ai=");
        r14.append(r15.d.size());
        g49.d.d("DoraObricGGestureSettingsFragment", r14.toString());
        LastSwitchSide r16 = r15.a;
        DoraObricGGestureSettingsFragment r1 = this.a;
        if (r16 == r1.i) goto L7;
        g49.d.d("DoraObricGGestureSettingsFragment", "ignore stale gesture state: stateSide=" + r15.a + ", currentSide=" + this.a.i);
        return Unit.INSTANCE;
    L7:
        r1.da0(r16);
        DoraObricGGestureSettingsFragment r17 = this.a;
        LastSwitchSide r0 = r15.a;
        List<DoraGGestureSettings> r2 = r15.b;
        List<DoraGGestureSettings> r3 = r15.c;
        List<DoraGGestureSettings> r18 = r15.d;
        LarusDoraPageObricGGestureSettingsBinding r4 = r17.f;
        if (r4 == null) goto L38;
        if (r0 != LastSwitchSide.BUTTON) goto L16;
        r4.b.removeAllViews();
        LinearLayout r5 = r4.b;
        if (((DoraResourceDeviceType) r17.k.getValue()) != DoraResourceDeviceType.G2) goto L14;
        String r6 = null;
    L15:
        r17.W90(r5, r6, CollectionsKt.plus(CollectionsKt.listOf(new DoraObricGGestureSettingsFragment.b.C0107b(r17.getString(2131903009), r17.getString(2131902366))), r17.Y90(r18)));
        goto L38
    L14:
        r6 = r17.getString(2131902358);
        goto L15
    L16:
        r4.c.removeAllViews();
        if ((!r2.isEmpty()) == false) goto L24;
        LinearLayout r7 = r4.c;
        String r8 = r17.getString(2131903040);
        List<DoraGGestureSettings> r9 = r2;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r20 = r9.iterator();
    L20:
        if (r20.hasNext() == false) goto L22;
        r10.add(new DoraObricGGestureSettingsFragment.b.a((DoraGGestureSettings) r20.next()));
        goto L20
    L22:
        r17.W90(r7, r8, r10);
    L24:
        if ((!r3.isEmpty()) == false) goto L30;
        LinearLayout r21 = r4.c;
        String r22 = r17.getString(2131903004);
        List<DoraGGestureSettings> r23 = r3;
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator<T> r25 = r23.iterator();
    L27:
        if (r25.hasNext() == false) goto L29;
        r24.add(new DoraObricGGestureSettingsFragment.b.a((DoraGGestureSettings) r25.next()));
        goto L27
    L29:
        r17.W90(r21, r22, r24);
    L30:
        r17.W90(r4.c, r17.getString(2131903008), CollectionsKt.plus(CollectionsKt.listOf(new DoraObricGGestureSettingsFragment.b.C0107b(r17.getString(2131903009), r17.getString(2131903011))), r17.Y90(r18)));
    L38:
        return Unit.INSTANCE;
    L32:
        if (Intrinsics.areEqual(r13, com.larus.dora.impl.device.settings.gesture.r.b.a) == false) goto L35;
        g49.d.d("DoraObricGGestureSettingsFragment", "gestureStateFlow idle");
        goto L38
    L35:
        if (Intrinsics.areEqual(r13, com.larus.dora.impl.device.settings.gesture.r.a.a) == false) goto L40;
        g49.d.d("DoraObricGGestureSettingsFragment", "gestureStateFlow failed, keep default items");
        goto L38
    L40:
        throw new NoWhenBranchMatchedException();
    }
}
