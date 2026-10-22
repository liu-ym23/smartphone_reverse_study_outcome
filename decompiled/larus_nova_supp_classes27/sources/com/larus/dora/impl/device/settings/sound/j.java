package com.larus.dora.impl.device.settings.sound;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j<T> implements FlowCollector {
    public final /* synthetic */ SoundSettingsFragment a;

    public j(SoundSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        SoundSettingsFragment r3 = this.a;
        SoundSettingsFragment.W90(r3, (a) r1);
        return Unit.INSTANCE;
    }
}
