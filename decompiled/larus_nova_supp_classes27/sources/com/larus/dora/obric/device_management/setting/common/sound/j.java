package com.larus.dora.obric.device_management.setting.common.sound;

import com.larus.dora.impl.device.settings.sound.m;
import com.obric.oui.slider.OSlider;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j<T> implements FlowCollector {
    public final /* synthetic */ DoraObricSoundSettingsFragment a;

    public j(DoraObricSoundSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r9, Continuation r10) {
        m r11 = (m) r9;
        if (Intrinsics.areEqual(r11, m.a.a) == true) goto L83;
        if (Intrinsics.areEqual(r11, m.b.a) == true) goto L83;
        if ((r11 instanceof m.c) == false) goto L81;
        DoraObricSoundSettingsFragment r12 = this.a;
        byte r13 = ((m.c) r11).a;
        IntRange r0 = DoraObricSoundSettingsFragment.s;
        r12.getClass();
        Integer r1 = Integer.valueOf(r13 & 255);
        if (r1 != null) goto L12;
    L14:
        int r3 = 1;
        if (r1 == null) goto L21;
        if (r1.intValue() != 254) goto L21;
    L77:
        int r2 = RangesKt.coerceIn(r3, 0, 5);
        g49.d.d("DoraObricSoundSettings", "updateSpeakerVolumeSwitch: vol=" + r13 + ", progress=" + r2);
        OSlider r14 = r12.n;
        if (r14 == null) goto L83;
        r14.setProgress(r2);
    L21:
        if (r1 == null) goto L27;
        if (r1.intValue() != 255) goto L27;
        r3 = 2;
    L27:
        if (r1 == null) goto L33;
        if (r1.intValue() != 0) goto L33;
    L76:
        r3 = 3;
    L33:
        if (r1 != null) goto L36;
    L38:
        if (r1 != null) goto L41;
    L43:
        r3 = 6;
        if (r1 == null) goto L50;
        if (r1.intValue() == 3) goto L77;
    L50:
        if (r1 == null) goto L56;
        if (r1.intValue() != 4) goto L56;
        r3 = 7;
    L56:
        if (r1 != null) goto L59;
    L61:
        if (r1 != null) goto L64;
    L66:
        if (r1 != null) goto L69;
    L71:
        if (r1 == null) goto L76;
        if (r1.intValue() != 8) goto L76;
        r3 = 11;
        goto L77
    L69:
        if (r1.intValue() != 7) goto L71;
        r3 = 10;
        goto L77
    L64:
        if (r1.intValue() != 6) goto L66;
        r3 = 9;
        goto L77
    L59:
        if (r1.intValue() != 5) goto L61;
        r3 = 8;
        goto L77
    L41:
        if (r1.intValue() != 2) goto L43;
        r3 = 5;
        goto L77
    L36:
        if (r1.intValue() != 1) goto L38;
        r3 = 4;
        goto L77
    L12:
        if (r1.intValue() != 253) goto L14;
        r3 = 0;
        goto L77
    L81:
        throw new NoWhenBranchMatchedException();
    L83:
        return Unit.INSTANCE;
    }
}
