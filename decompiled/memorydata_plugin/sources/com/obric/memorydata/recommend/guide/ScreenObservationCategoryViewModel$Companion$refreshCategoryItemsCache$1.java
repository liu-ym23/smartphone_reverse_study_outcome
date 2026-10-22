package com.obric.memorydata.recommend.guide;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.recommend.settings.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.recommend.guide.ScreenObservationCategoryViewModel$Companion$refreshCategoryItemsCache$1", f = "ScreenObservationCategoryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ScreenObservationCategoryViewModel$Companion$refreshCategoryItemsCache$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callBack;
    final /* synthetic */ boolean $isFirstStart;
    final /* synthetic */ long $startTime;
    int label;

    ScreenObservationCategoryViewModel$Companion$refreshCategoryItemsCache$1(boolean r3, Function0<Unit> r4, long r5, Continuation<? super ScreenObservationCategoryViewModel$Companion$refreshCategoryItemsCache$1> r7) {
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$isFirstStart = r3;
        this.$callBack = r6;
        this.$startTime = r5;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ScreenObservationCategoryViewModel$Companion$refreshCategoryItemsCache$1(this.$isFirstStart, this.$callBack, this.$startTime, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ScreenObservationCategoryViewModel$Companion$refreshCategoryItemsCache$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ScreenObservationCategoryViewModel$Companion$refreshCategoryItemsCache$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r8);
        if (this.$isFirstStart == true) goto L7;
    L11:
        ScreenObservationCategoryViewModel.b r9 = ScreenObservationCategoryViewModel.Companion;
        ScreenObservationCategoryViewModel.access$setCategoryItemsCache$cp(ScreenObservationCategoryViewModel.b.a(ScreenObservationCategoryViewModel.Companion));
        Function0<Unit> r10 = this.$callBack;
        if (r10 == null) goto L14;
        r10.invoke();
    L14:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationCategoryViewModel", "refreshCategoryItemsCache, cost time: " + (System.currentTimeMillis() - this.$startTime), false, 4, null);
        return Unit.INSTANCE;
    L7:
        if (((Number) ZeusTransformUtils.preCheckCast(t.f12630a.f().c(), Number.class, "com.obric.memorydata.plugin")).intValue() != 2) goto L11;
        if (t.f12630a.p() == true) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationCategoryViewModel", "getAppsWithCategory, disable all app", false, 4, null);
        t.f12630a.g();
        goto L11
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
