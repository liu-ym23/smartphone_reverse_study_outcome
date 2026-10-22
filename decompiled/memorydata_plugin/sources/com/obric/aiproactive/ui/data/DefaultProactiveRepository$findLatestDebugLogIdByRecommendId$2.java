package com.obric.aiproactive.ui.data;

import com.obric.aiproactive.api.IProactiveService;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.ui.data.DefaultProactiveRepository$findLatestDebugLogIdByRecommendId$2", f = "ProactiveRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DefaultProactiveRepository$findLatestDebugLogIdByRecommendId$2 extends SuspendLambda implements Function2<al, Continuation<? super String>, Object> {
    final /* synthetic */ String $recommendId;
    int label;
    final /* synthetic */ a this$0;

    DefaultProactiveRepository$findLatestDebugLogIdByRecommendId$2(a r3, String r4, Continuation<? super DefaultProactiveRepository$findLatestDebugLogIdByRecommendId$2> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$recommendId = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$findLatestDebugLogIdByRecommendId$2(this.this$0, this.$recommendId, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super String> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super String> r4) {
        return ((DefaultProactiveRepository$findLatestDebugLogIdByRecommendId$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DefaultProactiveRepository$findLatestDebugLogIdByRecommendId$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r10);
        IProactiveService r11 = a.a(this.this$0);
        if (r11 == null) goto L7;
        String r12 = r11.findLatestDebugLogIdByRecommendId(this.$recommendId);
    L8:
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder().append("[Repo] findLatestDebugLogIdByRecommendId id=").append(this.$recommendId).append(" found=");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        IRunLog.a.a(r3, "ProactiveUI", r9.append(!r1).toString(), false, 4, null);
        return r12;
    L11:
        if (StringsKt.isBlank(r0) == true) goto L14;
        r1 = false;
        goto L15
    L7:
        r12 = null;
        goto L8
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
