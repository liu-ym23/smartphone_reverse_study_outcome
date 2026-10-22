package com.larus.dora.obric.device_management.setting.common.sound;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.common.sound.DoraObricSoundSettingsFragment", f = "DoraObricSoundSettingsFragment.kt", i = {}, l = {491}, m = "isEarbudsAmbientVolumeSupported", n = {}, s = {})
final class DoraObricSoundSettingsFragment$isEarbudsAmbientVolumeSupported$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraObricSoundSettingsFragment this$0;

    public DoraObricSoundSettingsFragment$isEarbudsAmbientVolumeSupported$1(DoraObricSoundSettingsFragment r1, Continuation<? super DoraObricSoundSettingsFragment$isEarbudsAmbientVolumeSupported$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraObricSoundSettingsFragment.W90(this.this$0, this);
    }
}
