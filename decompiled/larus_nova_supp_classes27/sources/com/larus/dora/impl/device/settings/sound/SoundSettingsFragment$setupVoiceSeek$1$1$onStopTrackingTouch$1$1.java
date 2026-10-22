package com.larus.dora.impl.device.settings.sound;

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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.SoundSettingsFragment$setupVoiceSeek$1$1$onStopTrackingTouch$1$1", f = "SoundSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SoundSettingsFragment$setupVoiceSeek$1$1$onStopTrackingTouch$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $convertIntToByte;
    final /* synthetic */ Integer $progress;
    int label;
    final /* synthetic */ SoundSettingsFragment this$0;

    public SoundSettingsFragment$setupVoiceSeek$1$1$onStopTrackingTouch$1$1(int r1, SoundSettingsFragment r2, Integer r3, Continuation<? super SoundSettingsFragment$setupVoiceSeek$1$1$onStopTrackingTouch$1$1> r4) {
        this.$convertIntToByte = r1;
        this.this$0 = r2;
        this.$progress = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SoundSettingsFragment$setupVoiceSeek$1$1$onStopTrackingTouch$1$1(this.$convertIntToByte, this.this$0, this.$progress, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        int r4 = kj4.a.g().o(this.$convertIntToByte);
        if (r4 != 0) goto L9;
        SoundSettingsFragment r0 = this.this$0;
        int r1 = SoundSettingsFragment.k;
        r0.Y90().loadVoice();
        Integer r2 = this.$progress;
        if (r2 == null) goto L9;
        int r5 = r2.intValue() + 1;
        DoraSystemInfoManager r6 = DoraSystemInfoManager.a;
        DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("prompt_tone_volume_level", String.valueOf(r5))));
    L9:
        g49.d.d("SoundSettingsFragment", "onStopTrackingTouch process:" + this.$progress + " , ret: " + r4);
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
