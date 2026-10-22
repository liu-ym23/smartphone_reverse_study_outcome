package com.larus.dora.impl.device.settings.media;

import com.larus.dora.api.model.FlowDoraVideoRecordConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.media.MediaSettingsViewModel$initData$1$3$onVideoRecordConfigUpdate$1", f = "MediaSettingsViewModel.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
public final class MediaSettingsViewModel$initData$1$3$onVideoRecordConfigUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowDoraVideoRecordConfig $config;
    int label;
    final /* synthetic */ MediaSettingsViewModel this$0;

    public MediaSettingsViewModel$initData$1$3$onVideoRecordConfigUpdate$1(MediaSettingsViewModel r1, FlowDoraVideoRecordConfig r2, Continuation<? super MediaSettingsViewModel$initData$1$3$onVideoRecordConfigUpdate$1> r3) {
        this.this$0 = r1;
        this.$config = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MediaSettingsViewModel$initData$1$3$onVideoRecordConfigUpdate$1(this.this$0, this.$config, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        z0 r6 = MediaSettingsViewModel.access$get_mediaVideoRecordConfig$p(this.this$0);
        a0.a r2 = new a0.a(this.$config);
        this.label = 1;
        if (r6.emit(r2, this) != r0) goto L12;
        return r0;
    }
}
