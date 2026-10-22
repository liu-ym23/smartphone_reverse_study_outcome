package com.larus.voicecall.impl.component.vlm;

import android.widget.FrameLayout;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.video.VideoPreviewState;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.vlm.RealtimeVideoComponent$onFirstFrameCapture$1", f = "RealtimeVideoComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeVideoComponent$onFirstFrameCapture$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeVideoComponent this$0;

    public RealtimeVideoComponent$onFirstFrameCapture$1(RealtimeVideoComponent r1, Continuation<? super RealtimeVideoComponent$onFirstFrameCapture$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeVideoComponent$onFirstFrameCapture$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r5);
        RealtimeVideoComponent r6 = this.this$0;
        int r0 = RealtimeVideoComponent.g1;
        FrameLayout r7 = r6.c4();
        if (r7 == null) goto L8;
        r7.setBackground(null);
    L8:
        if (this.this$0.N.c.getValue() != VideoPreviewState.full) goto L23;
        RealtimeVideoComponent r8 = this.this$0;
        Function1<? super String, Unit> r1 = r8.T;
        if (r1 == null) goto L13;
        r1.invoke("lazy full");
        r8.T = null;
    L13:
        if (this.this$0.i4() == true) goto L20;
        z2 r9 = z2.a;
        if (r9.continueTalkV2Config().a() == true) goto L20;
        if (r9.realtimeCallUseTwoLineStyle() == true) goto L20;
        boolean r10 = false;
    L21:
        if (r10 == false) goto L25;
        RealtimeVideoComponent r11 = this.this$0;
        r11.v4(Intrinsics.areEqual(r11.N.b.getValue(), Boxing.boxBoolean(true)), "on_first_frame_received", 0);
    L25:
        return Unit.INSTANCE;
    L20:
        r10 = true;
        goto L21
    L23:
        FLogger.a.e("RealtimeVideoComponent", "onFirstLocalVideoFrameCaptured but not full preview mode");
        goto L25
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
