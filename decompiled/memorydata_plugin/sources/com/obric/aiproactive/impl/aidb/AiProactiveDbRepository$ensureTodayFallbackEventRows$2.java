package com.obric.aiproactive.impl.aidb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lcom/obric/aiproactive/api/AiProactiveEventRecordDto;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.aidb.AiProactiveDbRepository$ensureTodayFallbackEventRows$2", f = "AiProactiveDbRepository.kt", i = {1}, l = {790, 793, 796}, m = "invokeSuspend", n = {"displayableRows"}, s = {"L$0"})
final class AiProactiveDbRepository$ensureTodayFallbackEventRows$2 extends SuspendLambda implements Function1<Continuation<? super Pair<? extends Integer, ? extends List<? extends com.obric.aiproactive.api.p>>>, Object> {
    final /* synthetic */ AiProactiveDb $db;
    final /* synthetic */ long $now;
    Object L$0;
    int label;
    final /* synthetic */ d this$0;

    AiProactiveDbRepository$ensureTodayFallbackEventRows$2(d r3, long r4, AiProactiveDb r6, Continuation<? super AiProactiveDbRepository$ensureTodayFallbackEventRows$2> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$now = r4;
        this.$db = r6;
        super(1, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r9) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiProactiveDbRepository$ensureTodayFallbackEventRows$2(this.this$0, this.$now, this.$db, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super Pair<? extends Integer, ? extends List<? extends com.obric.aiproactive.api.p>>> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Pair<Integer, ? extends List<com.obric.aiproactive.api.p>>> r3) {
        return ((AiProactiveDbRepository$ensureTodayFallbackEventRows$2) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), AiProactiveDbRepository$ensureTodayFallbackEventRows$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r33) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r33);
        Object r3 = r33;
    L30:
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue();
        String r15 = e.a(r4);
        long r5 = this.$now;
        com.obric.aiproactive.impl.aidb.a.c r6 = new com.obric.aiproactive.impl.aidb.a.c(0, r5, "AiProactiveFallbackEvent", null, null, r15, r15, r5, r5, 1, null);
        return TuplesKt.to(Boxing.boxInt(r4 + 1), CollectionsKt.listOf(d.a(this.this$0, com.obric.aiproactive.impl.aidb.a.c.a(r6, this.$db.eventRecordDao().insert(r6), 0, null, null, null, null, null, 0, 0, TypedValues.PositionType.TYPE_POSITION_TYPE, null))));
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        List<com.obric.aiproactive.impl.aidb.a.c> r7 = (List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r33);
        Object r8 = r33;
    L21:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        d r0 = this.this$0;
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L23:
        if (r11.hasNext() == false) goto L26;
        r10.add(d.a(r0, (com.obric.aiproactive.impl.aidb.a.c) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.aiproactive.impl.aidb.a.c.class, "com.obric.memorydata.plugin")));
        goto L23
    L26:
        return TuplesKt.to(r8, (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"));
    L11:
        ResultKt.throwOnFailure(r33);
        Object r12 = r33;
    L15:
        List<com.obric.aiproactive.impl.aidb.a.c> r13 = e.c((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L27;
        com.obric.aiproactive.impl.aidb.dao.c r14 = this.$db.eventRecordDao();
        Continuation<? super Integer> r16 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r13;
        this.label = 2;
        r8 = r14.countAllRecords(r16);
        if (r8 != r1) goto L20;
        return r1;
    L20:
        r7 = r13;
        goto L21
    L27:
        com.obric.aiproactive.impl.aidb.dao.c r17 = this.$db.eventRecordDao();
        Continuation<? super Integer> r18 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 3;
        r3 = r17.countAllRecords(r18);
        if (r3 != r1) goto L30;
        return r1;
    L12:
        ResultKt.throwOnFailure(r33);
        Pair r19 = d.a(this.this$0, this.$now);
        long r20 = ((Number) ZeusTransformUtils.preCheckCast(r19.component1(), Number.class, "com.obric.memorydata.plugin")).longValue();
        long r110 = ((Number) ZeusTransformUtils.preCheckCast(r19.component2(), Number.class, "com.obric.memorydata.plugin")).longValue();
        com.obric.aiproactive.impl.aidb.dao.c r21 = this.$db.eventRecordDao();
        Continuation<? super List<com.obric.aiproactive.impl.aidb.a.c>> r111 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r12 = r21.listTodayRecords(r20, r110, r111);
        if (r12 != r1) goto L15;
        return r1;
    }
}
