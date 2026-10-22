package com.obric.aiproactive.impl.aidb;

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
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lcom/obric/aiproactive/api/AiProactiveEventRecordDto;", "totalCount", "rows", "Lcom/obric/aiproactive/impl/aidb/entity/AiProactiveEventRecordEntity;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.aidb.AiProactiveDbRepository$observeTodayEventRecords$1", f = "AiProactiveDbRepository.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
final class AiProactiveDbRepository$observeTodayEventRecords$1 extends SuspendLambda implements Function3<Integer, List<? extends com.obric.aiproactive.impl.aidb.a.c>, Continuation<? super Pair<? extends Integer, ? extends List<? extends com.obric.aiproactive.api.p>>>, Object> {
    final /* synthetic */ AiProactiveDb $db;
    final /* synthetic */ long $now;
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ d this$0;

    AiProactiveDbRepository$observeTodayEventRecords$1(d r3, AiProactiveDb r4, long r5, Continuation<? super AiProactiveDbRepository$observeTodayEventRecords$1> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$db = r4;
        this.$now = r5;
        super(3, r8);
    }

    public final Object invoke(int r7, List<com.obric.aiproactive.impl.aidb.a.c> r8, Continuation<? super Pair<Integer, ? extends List<com.obric.aiproactive.api.p>>> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        AiProactiveDbRepository$observeTodayEventRecords$1 r11 = new AiProactiveDbRepository$observeTodayEventRecords$1(this.this$0, this.$db, this.$now, r5);
        r11.I$0 = r7;
        r11.L$0 = r10;
        return r11.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(Integer r3, List<? extends com.obric.aiproactive.impl.aidb.a.c> r4, Continuation<? super Pair<? extends Integer, ? extends List<? extends com.obric.aiproactive.api.p>>> r5) {
        return invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue(), (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L19:
        return (Pair) ZeusTransformUtils.preCheckCast(r8, Pair.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        int r9 = this.I$0;
        List<com.obric.aiproactive.impl.aidb.a.c> r2 = e.c((List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L15;
        Integer r10 = Boxing.boxInt(r9);
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        d r7 = this.this$0;
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L21;
        r4.add(d.a(r7, (com.obric.aiproactive.impl.aidb.a.c) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.aiproactive.impl.aidb.a.c.class, "com.obric.memorydata.plugin")));
        goto L12
    L21:
        return TuplesKt.to(r10, (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"));
    L15:
        d r11 = this.this$0;
        AiProactiveDb r6 = this.$db;
        long r12 = this.$now;
        Continuation r13 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r8 = d.a(r11, r6, r12, r13);
        if (r8 != r0) goto L19;
        return r0;
    }
}
