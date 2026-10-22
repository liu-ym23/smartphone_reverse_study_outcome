package com.obric.memorydata.awareness.cae;

import com.obric.cae.libs.useraware.CellAwareInfo;
import com.obric.memorydata.awareness.har.HarPredict;
import com.obric.memorydata.database.dao.CellInfoDao;
import com.obric.memorydata.database.entity.aj;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.awareness.cae.CAEAwareClient$caeCallback$1$onCellInfoChange$1", f = "CAEAwareClient.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CAEAwareClient$caeCallback$1$onCellInfoChange$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ CellAwareInfo $cellInfo;
    final /* synthetic */ String $uniqueId;
    int label;

    CAEAwareClient$caeCallback$1$onCellInfoChange$1(String r3, CellAwareInfo r4, Continuation<? super CAEAwareClient$caeCallback$1$onCellInfoChange$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$uniqueId = r3;
        this.$cellInfo = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new CAEAwareClient$caeCallback$1$onCellInfoChange$1(this.$uniqueId, this.$cellInfo, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((CAEAwareClient$caeCallback$1$onCellInfoChange$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), CAEAwareClient$caeCallback$1$onCellInfoChange$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r26) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r26);
        CellInfoDao r1 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCellInfoDao();
        String r3 = this.$uniqueId;
        long r4 = this.$cellInfo.getMci();
        int r6 = this.$cellInfo.getPci();
        int r7 = this.$cellInfo.getTac();
        int r8 = this.$cellInfo.getArfcn();
        int[] r9 = this.$cellInfo.getBands();
        Intrinsics.checkNotNullExpressionValue(r9, "getBands(...)");
        String r10 = u.a(r9);
        int r11 = this.$cellInfo.getLevel();
        int r12 = this.$cellInfo.getSignalQuality();
        int r13 = this.$cellInfo.getSignalStrength();
        String r14 = this.$cellInfo.getMcc();
        Intrinsics.checkNotNullExpressionValue(r14, "getMcc(...)");
        String r15 = this.$cellInfo.getMnc();
        Intrinsics.checkNotNullExpressionValue(r15, "getMnc(...)");
        String r2 = this.$cellInfo.getStandard();
        Intrinsics.checkNotNullExpressionValue(r2, "getStandard(...)");
        r1.insert(new aj(r3, r4, r6, r7, r8, r10, r11, r12, r13, r14, r15, r2, this.$cellInfo.isRegistered(), System.currentTimeMillis(), 0, 16384, null));
        HarPredict.f8604a.a().f();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
