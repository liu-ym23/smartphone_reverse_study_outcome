package com.obric.memorydata.memory.llm;

import android.content.ComponentName;
import android.graphics.Bitmap;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.island.IslandRouter;
import com.obric.memorydata.memory.x;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.sdk.memory.State;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0001*\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntity;", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.llm.LLMCloudMemoryBuildStrategy$build$1$3", f = "LLMCloudMemoryBuildStrategy.kt", i = {0, 1, 1, 1, 1}, l = {96, 149}, m = "invokeSuspend", n = {"screenshotPath", "screenshotPath", "resultEntities", "extraMap", "memoryEntity"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3"})
final class LLMCloudMemoryBuildStrategy$build$1$3 extends SuspendLambda implements Function2<al, Continuation<? super Pair<? extends List<? extends MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>>, Object> {
    final /* synthetic */ c $buildControl;
    final /* synthetic */ boolean $eval;
    final /* synthetic */ String $id;
    final /* synthetic */ com.obric.memorydata.middleware.api.logging.e $logContext;
    final /* synthetic */ o $logger;
    final /* synthetic */ com.obric.memorydata.memory.memoryentity.f $memorySourceInfo;
    final /* synthetic */ com.obric.memorydata.memory.tracker.g.b $mobileMemBuildEvent;
    final /* synthetic */ com.obric.memorydata.dc.a $pageContextHandle;
    final /* synthetic */ com.obric.memorydata.memory.memoryentity.f $this_apply;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    LLMCloudMemoryBuildStrategy$build$1$3(com.obric.memorydata.memory.memoryentity.f r3, com.obric.memorydata.memory.tracker.g.b r4, com.obric.memorydata.middleware.api.logging.e r5, com.obric.memorydata.memory.memoryentity.f r6, com.obric.memorydata.dc.a r7, boolean r8, o r9, c r10, String r11, Continuation<? super LLMCloudMemoryBuildStrategy$build$1$3> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_apply = r3;
        this.$mobileMemBuildEvent = r4;
        this.$logContext = r5;
        this.$memorySourceInfo = r6;
        this.$pageContextHandle = r7;
        this.$eval = r8;
        this.$logger = r9;
        this.$buildControl = r10;
        this.$id = r11;
        super(2, r13);
    }

    private static final Unit invokeSuspend$lambda$2(List r2, Map r3, com.obric.memorydata.middleware.api.logging.g r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        Object r7 = Integer.valueOf(r5.size());
    L6:
        r4.a("entity_count", r7);
        r4.a("result_type", r6.get("resultType"));
        return Unit.INSTANCE;
    L5:
        r7 = "null";
        goto L6
    }

    private static final Unit invokeSuspend$lambda$3(List r2, Map r3, com.obric.memorydata.middleware.api.logging.g r4) {
        Object r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        r5 = "null";
    L5:
        r4.a("result_entities", r5);
        r4.a("extra_map", r6);
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$5(MemoryEntity r7, List r8, String r9) {
        List<PendingMemoryCalendar> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        x.f11587a.a(r9, State.SUCCESS_NEW, r7, null, false, r6);
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$6(com.obric.memorydata.memory.memoryentity.f r2, String r3, Map r4, List r5, com.obric.memorydata.middleware.api.logging.g r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        r6.a("product_type", Integer.valueOf(r2.a()));
        r6.a("presentation_route", r3);
        r6.a("result_type", r7.get("resultType"));
        r6.a("entity_count", Integer.valueOf(r8.size()));
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$7(String r9) {
        x.a(x.f11587a, r9, State.FAILURE_ERROR, null, null, false, null, 48, null);
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$8(com.obric.memorydata.memory.memoryentity.f r2, Map r3, List r4, com.obric.memorydata.middleware.api.logging.g r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        r5.a("product_type", Integer.valueOf(r2.a()));
        r5.a("result_type", r6.get("resultType"));
        if (r7 == null) goto L5;
        int r8 = r7.size();
    L6:
        r5.a("entity_count", Integer.valueOf(r8));
        return Unit.INSTANCE;
    L5:
        r8 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$85b6EYERiOavjOfw8-hptt8FX4U, reason: not valid java name */
    public static /* synthetic */ Unit m731lambda$85b6EYERiOavjOfw8hptt8FX4U(String r0) {
        return invokeSuspend$lambda$7(r0);
    }

    /* JADX INFO: renamed from: lambda$LKuyX7VMh-XIg5Cse3zPeYeJQGk, reason: not valid java name */
    public static /* synthetic */ Unit m732lambda$LKuyX7VMhXIg5Cse3zPeYeJQGk(com.obric.memorydata.memory.memoryentity.f r0, String r1, Map r2, List r3, com.obric.memorydata.middleware.api.logging.g r4) {
        return invokeSuspend$lambda$6(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$Nts6k_V8fBIIsw0vNUV-2XjaxMA, reason: not valid java name */
    public static /* synthetic */ Unit m733lambda$Nts6k_V8fBIIsw0vNUV2XjaxMA(List r0, Map r1, com.obric.memorydata.middleware.api.logging.g r2) {
        return invokeSuspend$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$ZTSV1JxiKnZZBs1Qzi7a4CQi1zM(com.obric.memorydata.memory.memoryentity.f r0, Map r1, List r2, com.obric.memorydata.middleware.api.logging.g r3) {
        return invokeSuspend$lambda$8(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$ak_sJTtI588dkRqgqC-gIZTQ5dE, reason: not valid java name */
    public static /* synthetic */ Unit m734lambda$ak_sJTtI588dkRqgqCgIZTQ5dE(MemoryEntity r0, List r1, String r2) {
        return invokeSuspend$lambda$5(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$jjrRm7hxY0a5G0JF_Bq-uym0GDQ, reason: not valid java name */
    public static /* synthetic */ Unit m735lambda$jjrRm7hxY0a5G0JF_Bquym0GDQ(List r0, Map r1, com.obric.memorydata.middleware.api.logging.g r2) {
        return invokeSuspend$lambda$2(r0, r1, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new LLMCloudMemoryBuildStrategy$build$1$3(this.$this_apply, this.$mobileMemBuildEvent, this.$logContext, this.$memorySourceInfo, this.$pageContextHandle, this.$eval, this.$logger, this.$buildControl, this.$id, r11), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Pair<? extends List<? extends MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Pair<? extends List<MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> r4) {
        return ((LLMCloudMemoryBuildStrategy$build$1$3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), LLMCloudMemoryBuildStrategy$build$1$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r32) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r5 = false;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        final MemoryEntity r3 = (MemoryEntity) ZeusTransformUtils.preCheckCast(this.L$3, MemoryEntity.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(this.L$2, Map.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.preCheckCast(this.L$1, List.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r32);
        final List r10 = r6;
        Object r8 = r32;
    L66:
        final List<PendingMemoryCalendar> r9 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        final Map r11 = r4;
        String r12 = r7;
        if (r9 != null) goto L71;
        MemoryEntity r13 = r3;
    L69:
        r9 = CollectionsKt.emptyList();
        r3 = r13;
    L71:
        if (this.$eval == false) goto L73;
    L90:
        com.obric.memorydata.memory.memoryentity.a.a.f10310a.a(r12);
        return new Pair(r10, r11);
    L73:
        if (this.$this_apply.a() == 3) goto L79;
        Function1<? super String, Unit> r14 = new $$Lambda$LLMCloudMemoryBuildStrategy$build$1$3$ak_sJTtI588dkRqgqCgIZTQ5dE(r3, r9);
        c r15 = this.$buildControl;
        if (r15 == null) goto L77;
        Boxing.boxBoolean(r15.d(r14));
    L78:
        final String r16 = "memory_publisher";
    L80:
        o r17 = this.$logger;
        com.obric.memorydata.middleware.api.logging.e r18 = com.obric.memorydata.middleware.api.logging.e.a(this.$logContext, null, null, "result", 3, null);
        final com.obric.memorydata.memory.memoryentity.f r0 = this.$this_apply;
        o.a(r17, "记忆构建结果已展示", "result_presented", r18, new $$Lambda$LLMCloudMemoryBuildStrategy$build$1$3$LKuyX7VMhXIg5Cse3zPeYeJQGk(r0, r16, r11, r10), null, 16, null);
        goto L90
    L77:
        r14.invoke(this.$id);
        goto L78
    L79:
        IslandRouter.f10185a.a(r3, null, r9);
        r16 = "assistant_island";
        goto L80
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r12 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r32);
        Object r19 = r32;
    L40:
        Pair r20 = (Pair) ZeusTransformUtils.preCheckCast(r19, Pair.class, "com.obric.memorydata.plugin");
        r10 = (List) ZeusTransformUtils.preCheckCast(r20.component1(), List.class, "com.obric.memorydata.plugin");
        r11 = (Map) ZeusTransformUtils.preCheckCast(r20.component2(), Map.class, "com.obric.memorydata.plugin");
        this.$logger.a("记忆构建结果已返回", "build_returned", this.$logContext, new $$Lambda$LLMCloudMemoryBuildStrategy$build$1$3$jjrRm7hxY0a5G0JF_Bquym0GDQ(r10, r11), new $$Lambda$LLMCloudMemoryBuildStrategy$build$1$3$Nts6k_V8fBIIsw0vNUV2XjaxMA(r10, r11));
        c r110 = this.$memorySourceInfo.q();
        if (r110 != null) goto L43;
    L45:
        if (r5 == false) goto L48;
        com.obric.memorydata.memory.memoryentity.a.a.f10310a.a(r12);
        return new Pair(r10, r11);
    L48:
        Object r21 = r11.get("resultSubType");
        if (ZeusTransformUtils.instanceOf(r21, String.class) == false) goto L51;
        String r22 = (String) ZeusTransformUtils.preCheckCast(r21, String.class, "com.obric.memorydata.plugin");
    L53:
        if (Intrinsics.areEqual(r22, "delete_confirm") == true) goto L90;
        if (r10 == null) goto L58;
        MemoryLLMBuildHelperV2.a r23 = (MemoryLLMBuildHelperV2.a) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r10), MemoryLLMBuildHelperV2.a.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L58;
        r13 = r23.d();
    L59:
        if (r13 == null) goto L82;
        String r24 = r13.getUuid();
        if (r24 == null) goto L69;
        kotlinx.coroutines.flow.i<List<PendingMemoryCalendar>> r25 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getPendingMemoryCalendarDao().queryByMemoryUUIDGroupedAndSorted(r24);
        this.L$0 = r12;
        this.L$1 = r10;
        this.L$2 = r11;
        this.L$3 = r13;
        this.label = 2;
        r8 = kotlinx.coroutines.flow.k.e(r25, this);
        if (r8 != r1) goto L65;
        return r1;
    L65:
        r3 = r13;
        r7 = r12;
        r4 = r11;
        goto L66
    L82:
        if (this.$eval == true) goto L90;
        if (this.$this_apply.a() == 3) goto L90;
        $$Lambda$LLMCloudMemoryBuildStrategy$build$1$3$85b6EYERiOavjOfw8hptt8FX4U r26 = $$Lambda$LLMCloudMemoryBuildStrategy$build$1$3$85b6EYERiOavjOfw8hptt8FX4U.INSTANCE;
        c r27 = this.$buildControl;
        if (r27 == null) goto L88;
        Boxing.boxBoolean(r27.d(r26));
    L89:
        o r111 = this.$logger;
        com.obric.memorydata.middleware.api.logging.e r112 = com.obric.memorydata.middleware.api.logging.e.a(this.$logContext, null, null, "result", 3, null);
        final com.obric.memorydata.memory.memoryentity.f r28 = this.$this_apply;
        o.a(r111, "记忆构建结果实体不可用", "result_entity_unavailable", "result_entity_unavailable", null, r112, new $$Lambda$LLMCloudMemoryBuildStrategy$build$1$3$ZTSV1JxiKnZZBs1Qzi7a4CQi1zM(r28, r11, r10), 8, null);
        goto L90
    L88:
        r26.invoke(this.$id);
    L58:
        r13 = null;
        goto L59
    L51:
        r22 = null;
        goto L53
    L43:
        if (r110.b() != true) goto L45;
        r5 = true;
        goto L45
    L10:
        ResultKt.throwOnFailure(r32);
        CharSequence r29 = (CharSequence) ZeusTransformUtils.preCheckCast(this.$this_apply.l(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r29 != null) goto L13;
    L16:
        boolean r30 = true;
    L17:
        if (r30 == false) goto L21;
        Bitmap r113 = this.$this_apply.d();
        if (r113 == null) goto L21;
        r12 = com.obric.memorydata.memory.memoryentity.a.a.a(com.obric.memorydata.memory.memoryentity.a.a.f10310a, r113, this.$this_apply.t(), 0, 4, null);
    L22:
        com.obric.memorydata.memory.tracker.g.b r31 = this.$mobileMemBuildEvent;
        if (r31 == null) goto L25;
        com.obric.memorydata.memory.tracker.g.b.a(r31, 0, 1, null);
    L25:
        MemoryLLMBuildHelperV2 r210 = MemoryLLMBuildHelperV2.f10255a;
        com.obric.memorydata.memory.tracker.g.b r114 = this.$mobileMemBuildEvent;
        String r115 = this.$this_apply.w();
        String r116 = this.$this_apply.v();
        String r117 = this.$this_apply.c();
        String r118 = this.$this_apply.b();
        ComponentName r33 = this.$this_apply.f();
        if (r33 == null) goto L28;
        String r119 = r33.getClassName();
    L29:
        String r120 = this.$this_apply.k();
        List<MemoryEntity> r121 = this.$this_apply.i();
        Integer r122 = this.$this_apply.j();
        String r211 = this.$this_apply.l();
        if (r12 != null) goto L32;
        Integer r212 = null;
    L37:
        e r213 = new e(r115, r12, r116, r117, r118, r119, r120, r121, r122, r211, r212, Boxing.boxInt(this.$this_apply.a()), this.$this_apply.m(), this.$logContext, this.$this_apply.o(), this.$this_apply.u());
        com.obric.memorydata.memory.memoryentity.f r123 = this.$memorySourceInfo;
        com.obric.memorydata.dc.a r34 = this.$pageContextHandle;
        boolean r124 = this.$eval;
        Continuation r125 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r12;
        this.label = 1;
        r19 = MemoryLLMBuildHelperV2.a(r210, r114, r213, r123, r34, null, r124, r125, 16, null);
        if (r19 != r1) goto L40;
        return r1;
    L32:
        if (this.$this_apply.a() != 13) goto L34;
        int r35 = 1;
    L35:
        r212 = Boxing.boxInt(r35);
        goto L37
    L34:
        r35 = 0;
        goto L35
    L28:
        r119 = null;
    L21:
        r12 = null;
        goto L22
    L13:
        if (r29.length() == 0) goto L16;
        r30 = false;
        goto L17
    }
}
