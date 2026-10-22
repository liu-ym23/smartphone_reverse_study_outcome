package com.obric.memorydata.debug;

import com.obric.memorydata.personalcontext.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/memorydata/aikernelcore/utils/ModelDataUtil$ModelItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.debug.ReleaseAdbService$isAllModelDownloadSuccess$1$packageModel$1", f = "ReleaseAdbService.kt", i = {}, l = {890}, m = "invokeSuspend", n = {}, s = {})
final class ReleaseAdbService$isAllModelDownloadSuccess$1$packageModel$1 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends com.obric.memorydata.aikernelcore.utils.a.C0428a>>, Object> {
    final /* synthetic */ String $packageName;
    int label;

    ReleaseAdbService$isAllModelDownloadSuccess$1$packageModel$1(String r3, Continuation<? super ReleaseAdbService$isAllModelDownloadSuccess$1$packageModel$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$packageName = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ReleaseAdbService$isAllModelDownloadSuccess$1$packageModel$1(this.$packageName, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends com.obric.memorydata.aikernelcore.utils.a.C0428a>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super List<com.obric.memorydata.aikernelcore.utils.a.C0428a>> r4) {
        return ((ReleaseAdbService$isAllModelDownloadSuccess$1$packageModel$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ReleaseAdbService$isAllModelDownloadSuccess$1$packageModel$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        com.obric.memorydata.aikernelcore.utils.a r8 = com.obric.memorydata.aikernelcore.utils.a.f8483a;
        String r2 = this.$packageName;
        String[] r3 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(q.f12255a.o(), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        String[] r4 = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), String[].class, "com.obric.memorydata.plugin");
        Continuation<? super List<com.obric.memorydata.aikernelcore.utils.a.C0428a>> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r7 = r8.a(r2, r4, r5);
        if (r7 != r0) goto L11;
        return r0;
    }
}
