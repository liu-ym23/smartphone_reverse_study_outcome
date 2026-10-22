package com.obric.audio.enroll.ui;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.ui.VoicePrintEnrollActivity$awaitHelpImproveVoiceWakeupEnabled$enabled$1", f = "VoicePrintEnrollActivity.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
public final class VoicePrintEnrollActivity$awaitHelpImproveVoiceWakeupEnabled$enabled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ VoicePrintEnrollActivity this$0;

    public VoicePrintEnrollActivity$awaitHelpImproveVoiceWakeupEnabled$enabled$1(VoicePrintEnrollActivity r1, Continuation<? super VoicePrintEnrollActivity$awaitHelpImproveVoiceWakeupEnabled$enabled$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VoicePrintEnrollActivity$awaitHelpImproveVoiceWakeupEnabled$enabled$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L16:
        return (Boolean) r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        Deferred<Boolean> r5 = this.this$0.e;
        if (r5 == null) goto L14;
        this.label = 1;
        r4 = r5.await(this);
        if (r4 != r0) goto L16;
        return r0;
    L14:
        return null;
    }
}
