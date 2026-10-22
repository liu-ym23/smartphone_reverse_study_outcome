package com.larus.camera.impl.ui.component.capture;

import android.view.MotionEvent;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureControlComponent$onViewCreated$6$1$1", f = "CaptureControlComponent.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureControlComponent$onViewCreated$6$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MotionEvent $downEvent;
    final /* synthetic */ Ref.BooleanRef $isLongPressRecording;
    final /* synthetic */ CameraCaptureViewModel $viewModel;
    int label;
    final /* synthetic */ CaptureControlComponent this$0;

    public CaptureControlComponent$onViewCreated$6$1$1(CaptureControlComponent r1, MotionEvent r2, Ref.BooleanRef r3, CameraCaptureViewModel r4, Continuation<? super CaptureControlComponent$onViewCreated$6$1$1> r5) {
        this.this$0 = r1;
        this.$downEvent = r2;
        this.$isLongPressRecording = r3;
        this.$viewModel = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CaptureControlComponent$onViewCreated$6$1$1(this.this$0, this.$downEvent, this.$isLongPressRecording, this.$viewModel, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L16
    L13:
        CaptureControlComponent.u(this.this$0, new p0(this.$isLongPressRecording, this.$viewModel, this.$downEvent));     // Catch: Throwable -> L16
        this.$downEvent.recycle();
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        long r3 = zx8.b.g;     // Catch: Throwable -> L16
        this.label = 1;     // Catch: Throwable -> L16
        if (DelayKt.delay(r3, this) != r0) goto L13;
        return r0;
    L16:
        th = move-exception;
        this.$downEvent.recycle();
        throw th;
    }
}
