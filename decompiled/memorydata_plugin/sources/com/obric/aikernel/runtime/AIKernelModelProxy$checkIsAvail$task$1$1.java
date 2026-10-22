package com.obric.aikernel.runtime;

import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/sdk/data/PackageResource;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.AIKernelModelProxy$checkIsAvail$task$1$1", f = "AIKernelModelProxy.kt", i = {}, l = {78, BDVideoUploaderBase.KeyIsEnableLogicalPart}, m = "invokeSuspend", n = {}, s = {})
final class AIKernelModelProxy$checkIsAvail$task$1$1 extends SuspendLambda implements Function2<al, Continuation<? super PackageResource>, Object> {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ String $name;
    final /* synthetic */ RequestParams $requestParams;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ a this$0;

    AIKernelModelProxy$checkIsAvail$task$1$1(String r3, RequestParams r4, a r5, String r6, Continuation<? super AIKernelModelProxy$checkIsAvail$task$1$1> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$name = r3;
        this.$requestParams = r4;
        this.this$0 = r5;
        this.$cacheKey = r6;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AIKernelModelProxy$checkIsAvail$task$1$1(this.$name, this.$requestParams, this.this$0, this.$cacheKey, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super PackageResource> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super PackageResource> r4) {
        return ((AIKernelModelProxy$checkIsAvail$task$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AIKernelModelProxy$checkIsAvail$task$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.L$2, String.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        a r10 = (a) ZeusTransformUtils.preCheckCast(this.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
        Object r12 = ((Result) ZeusTransformUtils.preCheckCast(r11, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L30:
        if (Result.m1428isSuccessimpl(r12) == false) goto L39;
        PackageResource r4 = (PackageResource) ZeusTransformUtils.preCheckCast(r12, PackageResource.class, "com.obric.memorydata.plugin");
        monitor-enter(a.class);
        ((Map) ZeusTransformUtils.preCheckCast(a.a(r10), Map.class, "com.obric.memorydata.plugin")).put(r3, new Pair(Boxing.boxBoolean(r4.isAvailable()), null));     // Catch: Throwable -> L36
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L36
        monitor-exit(a.class);
    L36:
        th = move-exception;
        throw th;
    L39:
        Throwable r14 = Result.m1424exceptionOrNullimpl(r12);
        if (r14 == null) goto L43;
        com.obric.aikernel.runtime.utils.d.f6216a.f("AIKernelModelProxy", "checkIsAvail: " + r2 + " update failed " + r14);
    L43:
        if (Result.m1427isFailureimpl(r12) == false) goto L46;
        return null;
    L46:
        return r12;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
        Object r15 = ((Result) ZeusTransformUtils.preCheckCast(r11, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L13:
        RequestParams r5 = this.$requestParams;
        a r6 = this.this$0;
        String r7 = this.$cacheKey;
        String r8 = this.$name;
        if (Result.m1428isSuccessimpl(r15) == false) goto L47;
        PackageResource r9 = (PackageResource) ZeusTransformUtils.preCheckCast(r15, PackageResource.class, "com.obric.memorydata.plugin");
        if (r9.isAvailable() == true) goto L18;
        AIKernelManager r16 = AIKernelManager.INSTANCE;
        this.L$0 = r6;
        this.L$1 = r7;
        this.L$2 = r8;
        this.label = 2;
        r12 = r16.mo189updatePackage0E7RQCE(r9, r5, this);
        if (r12 != r0) goto L28;
        return r0;
    L28:
        r10 = r6;
        r3 = r7;
        r2 = r8;
        goto L30
    L18:
        monitor-enter(a.class);
        ((Map) ZeusTransformUtils.preCheckCast(a.a(r6), Map.class, "com.obric.memorydata.plugin")).put(r7, new Pair(Boxing.boxBoolean(true), null));     // Catch: Throwable -> L22
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(a.class);
    L22:
        th = move-exception;
        throw th;
    L47:
        String r18 = this.$name;
        Throwable r19 = Result.m1424exceptionOrNullimpl(r15);
        if (r19 == null) goto L51;
        com.obric.aikernel.runtime.utils.d.f6216a.f("AIKernelModelProxy", "checkIsAvail: " + r18 + " get failed " + r19);
    L51:
        if (Result.m1427isFailureimpl(r15) == false) goto L54;
        return null;
    L54:
        return r15;
    L10:
        ResultKt.throwOnFailure(r11);
        AIKernelManager r110 = AIKernelManager.INSTANCE;
        String r20 = this.$name;
        RequestParams r21 = this.$requestParams;
        Continuation<? super Result<PackageResource>> r22 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r15 = r110.mo188getPackage0E7RQCE(r20, r21, r22);
        if (r15 != r0) goto L13;
        return r0;
    }
}
