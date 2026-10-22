package com.larus.dora.obric.device_management.setting.common.sound;

import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h<T> implements FlowCollector {
    public final /* synthetic */ DoraObricSoundSettingsFragment a;

    public h(DoraObricSoundSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r2, Continuation r3) {
        com.larus.dora.impl.device.settings.sound.b r4 = (com.larus.dora.impl.device.settings.sound.b) r2;
        if ((r4 instanceof com.larus.dora.impl.device.settings.sound.b.C0057b) == false) goto L6;
        DoraBuryPointManager.a.E(((com.larus.dora.impl.device.settings.sound.b.C0057b) r4).a, true);
    L9:
        return Unit.INSTANCE;
    L6:
        if ((r4 instanceof com.larus.dora.impl.device.settings.sound.b.a) == false) goto L11;
        DoraObricSoundSettingsFragment r5 = this.a;
        IntRange r0 = DoraObricSoundSettingsFragment.s;
        DoraObricSoundSettingsFragment.X90(r5, (com.larus.dora.impl.device.settings.sound.a) r5.ea0().getAntiSoundLeakStateFlow().getValue());
        WeakReference<com.obric.oui.toast.f> r6 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), 2131904037);
        g49.d.d("DoraObricSoundSettings", "antiSoundLeakSwitchFlow: FAILED, show toast.");
        DoraBuryPointManager.a.E(((com.larus.dora.impl.device.settings.sound.b.a) r4).a, false);
        goto L9
    L11:
        throw new NoWhenBranchMatchedException();
    }
}
