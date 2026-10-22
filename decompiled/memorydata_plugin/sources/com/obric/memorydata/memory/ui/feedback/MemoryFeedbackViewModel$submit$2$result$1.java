package com.obric.memorydata.memory.ui.feedback;

import android.os.Bundle;
import com.obric.memorydata.middleware.api.feedback.FeedbackManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.feedback.MemoryFeedbackViewModel$submit$2$result$1", f = "MemoryFeedbackViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MemoryFeedbackViewModel$submit$2$result$1 extends SuspendLambda implements Function2<al, Continuation<? super Bundle>, Object> {
    final /* synthetic */ Function1<String, List<String>> $customFilePathListProvider;
    final /* synthetic */ Function0<h> $odpReportDataProvider;
    final /* synthetic */ String $readableDesc;
    int label;
    final /* synthetic */ MemoryFeedbackViewModel this$0;

    MemoryFeedbackViewModel$submit$2$result$1(Function1<? super String, ? extends List<String>> r3, String r4, MemoryFeedbackViewModel r5, Function0<h> r6, Continuation<? super MemoryFeedbackViewModel$submit$2$result$1> r7) {
        Function1<String, List<String>> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function0<h> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$customFilePathListProvider = r8;
        this.$readableDesc = r4;
        this.this$0 = r5;
        this.$odpReportDataProvider = r9;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryFeedbackViewModel$submit$2$result$1(this.$customFilePathListProvider, this.$readableDesc, this.this$0, this.$odpReportDataProvider, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Bundle> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Bundle> r4) {
        return ((MemoryFeedbackViewModel$submit$2$result$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryFeedbackViewModel$submit$2$result$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r8);
        Function1<String, List<String>> r9 = this.$customFilePathListProvider;
        if (r9 == null) goto L7;
        List<String> r10 = (List) ZeusTransformUtils.preCheckCast(r9.invoke(this.$readableDesc), List.class, "com.obric.memorydata.plugin");
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryFeedbackVM", "submit feedback custom files: " + MemoryFeedbackViewModel.access$describeCustomFiles(this.this$0, r10), false, 4, null);
        Bundle r11 = FeedbackManager.INSTANCE.triggerFeedback(this.$readableDesc, r10);
        k.f10956a.a(this.$readableDesc, this.$odpReportDataProvider);
        return r11;
    L7:
        r10 = null;
        goto L8
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
