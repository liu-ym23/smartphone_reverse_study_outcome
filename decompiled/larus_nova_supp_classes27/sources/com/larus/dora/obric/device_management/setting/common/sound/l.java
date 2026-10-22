package com.larus.dora.obric.device_management.setting.common.sound;

import com.larus.dora.obric.utils.DoraObricToastUtils;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l<T> implements FlowCollector {
    public final /* synthetic */ DoraObricSoundSettingsFragment a;

    public l(DoraObricSoundSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        if (((Boolean) r1).booleanValue() == true) goto L8;
        WeakReference<com.obric.oui.toast.f> r3 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), 2131904037);
        DoraObricSoundSettingsFragment r4 = this.a;
        IntRange r5 = DoraObricSoundSettingsFragment.s;
        com.larus.dora.impl.device.settings.sound.l r6 = (com.larus.dora.impl.device.settings.sound.l) r4.ea0().getSoundSettingsStateFlow().getValue();
        if ((r6 instanceof com.larus.dora.impl.device.settings.sound.l.c) == false) goto L8;
        DoraObricSoundSettingsFragment.Y90(this.a, ((com.larus.dora.impl.device.settings.sound.l.c) r6).a);
    L8:
        return Unit.INSTANCE;
    }
}
