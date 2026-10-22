package com.obric.memorydata.realtimecontext;

import android.content.ComponentName;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.realtimecontext.RealTimeContextService$RealTimeContextServiceBinder$processAppEntity$4", f = "RealTimeContextService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealTimeContextService$RealTimeContextServiceBinder$processAppEntity$4 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ ComponentName $componentName;
    final /* synthetic */ List<AppEntity> $entities;
    final /* synthetic */ com.obric.memorydata.realtimecontext.session.c $realTimeData;
    int label;

    RealTimeContextService$RealTimeContextServiceBinder$processAppEntity$4(List<? extends AppEntity> r3, ComponentName r4, com.obric.memorydata.realtimecontext.session.c r5, Continuation<? super RealTimeContextService$RealTimeContextServiceBinder$processAppEntity$4> r6) {
        List<AppEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$entities = r7;
        this.$componentName = r4;
        this.$realTimeData = r5;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new RealTimeContextService$RealTimeContextServiceBinder$processAppEntity$4(this.$entities, this.$componentName, this.$realTimeData, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((RealTimeContextService$RealTimeContextServiceBinder$processAppEntity$4) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), RealTimeContextService$RealTimeContextServiceBinder$processAppEntity$4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r11);
        Pair<List<AppEntity>, List<MetaValue>> r12 = i.f12470a.a(this.$entities, this.$componentName);
        if (AppContext.INSTANCE.isDebug() == false) goto L15;
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r2 = new StringBuilder().append("[processAppEntity] extract: appEntity ");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getFirst(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r5.add((AppEntity) ZeusTransformUtils.preCheckCast(r6.next(), AppEntity.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        StringBuilder r1 = r2.append((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin")).append(" metaValue ");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getSecond(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r3.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        r7.add((MetaValue) ZeusTransformUtils.preCheckCast(r8.next(), MetaValue.class, "com.obric.memorydata.plugin"));
        goto L12
    L14:
        r0.debug(RealTimeContextService.TAG, r1.append((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin")).toString());
    L16:
        List<? extends AppEntity> r9 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(this.$entities, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r12.getFirst(), Iterable.class, "com.obric.memorydata.plugin"));
        List<? extends MetaValue> r13 = (List) ZeusTransformUtils.preCheckCast(r12.getSecond(), List.class, "com.obric.memorydata.plugin");
        this.$realTimeData.b(r9);
        this.$realTimeData.a(1);
        com.obric.memorydata.realtimecontext.cache.f.f12457a.a(this.$entities, r13, r9);
        this.$realTimeData.a(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.$realTimeData.a(), Iterable.class, "com.obric.memorydata.plugin")));
        this.$realTimeData.a(7);
        return Unit.INSTANCE;
    L15:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "[processAppEntity] extract: appEntity " + ((List) ZeusTransformUtils.preCheckCast(r12.getFirst(), List.class, "com.obric.memorydata.plugin")).size() + " metaValue " + ((List) ZeusTransformUtils.preCheckCast(r12.getSecond(), List.class, "com.obric.memorydata.plugin")).size(), false, 4, null);
        goto L16
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
