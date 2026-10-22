package com.larus.dora.impl.device.settings.sound;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraBuryPointManager;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k<T> implements FlowCollector {
    public final /* synthetic */ SoundSettingsFragment a;

    public k(SoundSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        b r5 = (b) r3;
        if ((r5 instanceof b.C0057b) == false) goto L6;
        DoraBuryPointManager.a.E(((b.C0057b) r5).a, true);
    L9:
        return Unit.INSTANCE;
    L6:
        if ((r5 instanceof b.a) == false) goto L11;
        SoundSettingsFragment r6 = this.a;
        int r0 = SoundSettingsFragment.k;
        SoundSettingsFragment.W90(r6, (a) r6.Y90().getAntiSoundLeakStateFlow().getValue());
        s r7 = s.a;
        Application r1 = AppHost.a.getApplication();
        r7.getClass();
        s.b(r1, 2131904037, false);
        g49.d.d("SoundSettingsFragment", "DoraGSoundSettingsFragment.antiSoundLeakSwitchFlow.collect: state is FAILED, show toast.");
        DoraBuryPointManager.a.E(((b.a) r5).a, false);
        goto L9
    L11:
        throw new NoWhenBranchMatchedException();
    }
}
