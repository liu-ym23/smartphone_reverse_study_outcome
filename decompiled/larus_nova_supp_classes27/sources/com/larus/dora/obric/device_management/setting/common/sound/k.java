package com.larus.dora.obric.device_management.setting.common.sound;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k<T> implements FlowCollector {
    public final /* synthetic */ DoraObricSoundSettingsFragment a;

    public k(DoraObricSoundSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        com.larus.dora.impl.device.settings.sound.l r3 = (com.larus.dora.impl.device.settings.sound.l) r1;
        if (Intrinsics.areEqual(r3, com.larus.dora.impl.device.settings.sound.l.a.a) == true) goto L12;
        if (Intrinsics.areEqual(r3, com.larus.dora.impl.device.settings.sound.l.b.a) == true) goto L12;
        if ((r3 instanceof com.larus.dora.impl.device.settings.sound.l.c) == false) goto L10;
        DoraObricSoundSettingsFragment.Y90(this.a, ((com.larus.dora.impl.device.settings.sound.l.c) r3).a);
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    L12:
        return Unit.INSTANCE;
    }
}
