package com.larus.dora.obric.device_management.setting.common.sound;

import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.common.sound.DoraObricSoundSettingsFragment$setupCueToneSeek$1$onStopTrackingTouch$1", f = "DoraObricSoundSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricSoundSettingsFragment$setupCueToneSeek$1$onStopTrackingTouch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $cutToneMode;
    final /* synthetic */ int $progress;
    int label;
    final /* synthetic */ DoraObricSoundSettingsFragment this$0;

    public DoraObricSoundSettingsFragment$setupCueToneSeek$1$onStopTrackingTouch$1(int r1, DoraObricSoundSettingsFragment r2, int r3, Continuation<? super DoraObricSoundSettingsFragment$setupCueToneSeek$1$onStopTrackingTouch$1> r4) {
        this.$cutToneMode = r1;
        this.this$0 = r2;
        this.$progress = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraObricSoundSettingsFragment$setupCueToneSeek$1$onStopTrackingTouch$1(this.$cutToneMode, this.this$0, this.$progress, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r3);
        int r4 = kj4.a.g().o(this.$cutToneMode);
        if (r4 != 0) goto L7;
        DoraObricSoundSettingsFragment r0 = this.this$0;
        IntRange r1 = DoraObricSoundSettingsFragment.s;
        r0.ea0().loadVoice();
        int r2 = this.$progress + 1;
        DoraSystemInfoManager r5 = DoraSystemInfoManager.a;
        DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("prompt_tone_volume_level", String.valueOf(r2))));
    L7:
        g49.d.d("DoraObricSoundSettings", "cueToneSlider onStopTrackingTouch: progress=" + this.$progress + ", ret=" + r4);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
