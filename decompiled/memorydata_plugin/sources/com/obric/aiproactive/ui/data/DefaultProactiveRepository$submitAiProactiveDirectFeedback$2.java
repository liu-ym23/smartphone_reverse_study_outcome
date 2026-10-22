package com.obric.aiproactive.ui.data;

import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.api.o;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.ui.data.DefaultProactiveRepository$submitAiProactiveDirectFeedback$2", f = "ProactiveRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DefaultProactiveRepository$submitAiProactiveDirectFeedback$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ o $request;
    int label;
    final /* synthetic */ a this$0;

    DefaultProactiveRepository$submitAiProactiveDirectFeedback$2(o r3, a r4, Continuation<? super DefaultProactiveRepository$submitAiProactiveDirectFeedback$2> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$request = r3;
        this.this$0 = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$submitAiProactiveDirectFeedback$2(this.$request, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((DefaultProactiveRepository$submitAiProactiveDirectFeedback$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DefaultProactiveRepository$submitAiProactiveDirectFeedback$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r9);
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = new StringBuilder().append("[Repo] submitAiProactiveDirectFeedback type=").append(this.$request.a()).append(" related=");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.$request.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        IRunLog.a.a(r2, "ProactiveUI", r10.append(!r1).toString(), false, 4, null);
        IProactiveService r11 = a.a(this.this$0);
        if (r11 == null) goto L14;
        r11.submitAiProactiveDirectFeedback(this.$request);
        return Unit.INSTANCE;
    L14:
        return null;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
        goto L11
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
