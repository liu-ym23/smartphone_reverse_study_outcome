package com.obric.memorydata.recommend.screenshotupload.sampling;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.recommend.useraction.recommend.TriggerUploadType;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.recommend.screenshotupload.sampling.PeriodicScreenshotSampler$start$1$1", f = "PeriodicScreenshotSampler.kt", i = {0, 1}, l = {81, 99}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
final class PeriodicScreenshotSampler$start$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appName;
    final /* synthetic */ Function0<Map<String, String>> $extraMetaProvider;
    final /* synthetic */ long $initialDelayMs;
    final /* synthetic */ long $intervalMs;
    final /* synthetic */ String $key;
    final /* synthetic */ String $packageName;
    final /* synthetic */ Function0<ScreenshotOption> $screenshotOptionProvider;
    final /* synthetic */ TriggerUploadType $triggerType;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ b this$0;

    PeriodicScreenshotSampler$start$1$1(String r3, String r4, long r5, long r7, b r9, TriggerUploadType r10, String r11, Function0<? extends Map<String, String>> r12, Function0<ScreenshotOption> r13, Continuation<? super PeriodicScreenshotSampler$start$1$1> r14) {
        Function0<Map<String, String>> r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        Function0<ScreenshotOption> r16 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        this.$key = r3;
        this.$packageName = r4;
        this.$intervalMs = r5;
        this.$initialDelayMs = r7;
        this.this$0 = r9;
        this.$triggerType = r10;
        this.$appName = r11;
        this.$extraMetaProvider = r15;
        this.$screenshotOptionProvider = r16;
        super(2, r17);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r17, Continuation<?> r18) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        PeriodicScreenshotSampler$start$1$1 r1 = new PeriodicScreenshotSampler$start$1$1(this.$key, this.$packageName, this.$intervalMs, this.$initialDelayMs, this.this$0, this.$triggerType, this.$appName, this.$extraMetaProvider, this.$screenshotOptionProvider, r15);
        r1.L$0 = r17;
        return (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((PeriodicScreenshotSampler$start$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PeriodicScreenshotSampler$start$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        al r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);
    L16:
        if (am.a(r2) == false) goto L29;
        long r11 = System.currentTimeMillis();
        if (b.a(this.this$0).a(this.$packageName, this.$triggerType) == true) goto L22;
        RunLog r15 = RunLog.INSTANCE;
        StringBuilder r5 = new StringBuilder();
        String r6 = "periodic capture skip reason=gate pkg=";
    L20:
        r15.debug("PeriodicScreenshotSampler", r5.append(r6).append(this.$packageName).toString());
    L25:
        long r7 = this.$intervalMs;
        Continuation r16 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r2;
        this.label = 2;
        if (au.a(r7, r16) != r0) goto L16;
        return r0;
    L22:
        if (b.b(this.this$0).a(this.$packageName, r11, this.$intervalMs) == true) goto L24;
        r15 = RunLog.INSTANCE;
        r5 = new StringBuilder();
        r6 = "periodic capture skip reason=recent_capture pkg=";
        goto L20
    L24:
        b.a(this.this$0, this.$appName, this.$packageName, r11, this.$triggerType, (Map) ZeusTransformUtils.preCheckCast(this.$extraMetaProvider.invoke(), Map.class, "com.obric.memorydata.plugin"), (ScreenshotOption) ZeusTransformUtils.preCheckCast(this.$screenshotOptionProvider.invoke(), ScreenshotOption.class, "com.obric.memorydata.plugin"));
        goto L25
    L29:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r14);
        r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PeriodicScreenshotSampler", "start key=" + this.$key + " pkg=" + this.$packageName + " intervalMs=" + this.$intervalMs, false, 4, null);
        if (this.$initialDelayMs <= 0) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PeriodicScreenshotSampler", "delay first capture key=" + this.$key + " pkg=" + this.$packageName + " delayMs=" + this.$initialDelayMs, false, 4, null);
        long r8 = this.$initialDelayMs;
        Continuation r17 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r2;
        this.label = 1;
        if (au.a(r8, r17) != r0) goto L16;
        return r0;
    }
}
