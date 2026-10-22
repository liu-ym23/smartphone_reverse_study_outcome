package com.larus.voicecall.impl.component.vlm;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.vlm.RealtimeVideoComponent$enableFlashlight$2", f = "RealtimeVideoComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeVideoComponent$enableFlashlight$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ RealtimeVideoComponent this$0;

    public RealtimeVideoComponent$enableFlashlight$2(RealtimeVideoComponent r1, Continuation<? super RealtimeVideoComponent$enableFlashlight$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeVideoComponent$enableFlashlight$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r7);
        RealtimeVideoComponent r8 = this.this$0;
        int r0 = RealtimeVideoComponent.g1;
        com.larus.voicecall.impl.plugins.o1 r9 = r8.E3().z();
        boolean r1 = true;
        if (r9 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("[flashlight_debug] enableFlashlight check rtc, result=");
        r4.append(r2);
        r4.append(", isTorchSupported=");
        r4.append(r2);
        r4.append(", service=");
        if (r9 != null) goto L14;
        r1 = false;
    L14:
        r4.append(r1);
        r4.append(", isCameraBack=");
        r4.append(this.this$0.N.b.getValue());
        r4.append(", previewState=");
        r4.append(this.this$0.N.c.getValue());
        r4.append(", videoCaptureStarted=");
        r4.append(this.this$0.D5());
        r3.i("RealtimeVideoComponent", r4.toString());
        return Boxing.boxBoolean(r2);
    L7:
        if (r9.isCameraTorchSupported() != true) goto L9;
        r2 = true;
        goto L10
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
