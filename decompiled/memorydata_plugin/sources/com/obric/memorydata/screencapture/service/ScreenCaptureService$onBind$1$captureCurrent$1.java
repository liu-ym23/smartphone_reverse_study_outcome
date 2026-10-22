package com.obric.memorydata.screencapture.service;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.screencapture.d;
import com.obric.memorydata.sdk.screencapture.ScreenData;
import com.obric.memorydata.sdk.screencapture.TaskOptions;
import com.obric.memorydata.sdk.screencapture.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.screencapture.service.ScreenCaptureService$onBind$1$captureCurrent$1", f = "ScreenCaptureService.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
final class ScreenCaptureService$onBind$1$captureCurrent$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $callback;
    final /* synthetic */ TaskOptions $options;
    final /* synthetic */ String $targetPackage;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ScreenCaptureService this$0;

    ScreenCaptureService$onBind$1$captureCurrent$1(TaskOptions r3, String r4, ScreenCaptureService r5, c r6, Continuation<? super ScreenCaptureService$onBind$1$captureCurrent$1> r7) {
        ScreenCaptureService r8 = (ScreenCaptureService) ZeusTransformUtils.wrapperContextForParams(r5, ScreenCaptureService.class, "com.obric.memorydata.plugin");
        c r9 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$options = r3;
        this.$targetPackage = r4;
        this.this$0 = r8;
        this.$callback = r9;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        ScreenCaptureService$onBind$1$captureCurrent$1 r11 = new ScreenCaptureService$onBind$1$captureCurrent$1(this.$options, this.$targetPackage, this.this$0, this.$callback, r7);
        r11.L$0 = r9;
        return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ScreenCaptureService$onBind$1$captureCurrent$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ScreenCaptureService$onBind$1$captureCurrent$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L15
    L13:
        Object r15 = Result.m1421constructorimpl((ScreenData) ZeusTransformUtils.preCheckCast(r14, ScreenData.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
    L17:
        ScreenCaptureService r2 = this.this$0;
        c r4 = this.$callback;
        String r5 = this.$targetPackage;
        if (Result.m1428isSuccessimpl(r15) == false) goto L35;
        ScreenData r6 = (ScreenData) ZeusTransformUtils.preCheckCast(r15, ScreenData.class, "com.obric.memorydata.plugin");
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r8 = ScreenCaptureService.a(r2);
        StringBuilder r9 = new StringBuilder().append("captureCurrent success hasHeifPath=");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.getHeifScreenshotPath(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L22;
    L25:
        boolean r11 = true;
    L26:
        StringBuilder r12 = r9.append(!r11).append(" hasHardwareBuffer=");
        if (r6.getHardwareBuffer() == null) goto L29;
        boolean r13 = true;
    L30:
        StringBuilder r16 = r12.append(r13).append(" hasBitmap=");
        if (r6.getScreenshot() != null) goto L34;
        r3 = false;
    L34:
        IRunLog.a.a(r7, r8, r16.append(r3).toString(), false, 4, null);
        a.f12811a.a(r4, r6, r5);
        goto L35
    L29:
        r13 = false;
        goto L30
    L22:
        if (StringsKt.isBlank(r10) == true) goto L25;
        r11 = false;
    L35:
        ScreenCaptureService r17 = this.this$0;
        String r18 = this.$targetPackage;
        c r19 = this.$callback;
        Throwable r110 = Result.m1424exceptionOrNullimpl(r15);
        if (r110 == null) goto L42;
        RunLog.INSTANCE.error(ScreenCaptureService.a(r17), "captureCurrent failed pkg=" + r18, r110);
        a r20 = a.f12811a;
        String r111 = r110.getMessage();
        if (r111 != null) goto L40;
        r111 = "captureCurrent failed";
    L40:
        r20.a(r19, r18, -1, r111);
    L42:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
        al r112 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        TaskOptions r113 = this.$options;
        String r21 = this.$targetPackage;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L15
        d r23 = d.f12797a.a();     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r14 = r23.a(r113, r21, this);     // Catch: Throwable -> L15
        if (r14 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
