package com.larus.dora.obric.device_management.setting.common.sound;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g<T> implements FlowCollector {
    public final /* synthetic */ DoraObricSoundSettingsFragment a;

    public g(DoraObricSoundSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        DoraObricSoundSettingsFragment r3 = this.a;
        DoraObricSoundSettingsFragment.X90(r3, (com.larus.dora.impl.device.settings.sound.a) r1);
        return Unit.INSTANCE;
    }
}
