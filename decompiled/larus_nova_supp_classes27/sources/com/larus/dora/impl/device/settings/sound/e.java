package com.larus.dora.impl.device.settings.sound;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e<T> implements FlowCollector {
    public final /* synthetic */ DoraGSoundSettingsFragment a;

    public e(DoraGSoundSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        DoraGSoundSettingsFragment r3 = this.a;
        DoraGSoundSettingsFragment.W90(r3, (a) r1);
        return Unit.INSTANCE;
    }
}
