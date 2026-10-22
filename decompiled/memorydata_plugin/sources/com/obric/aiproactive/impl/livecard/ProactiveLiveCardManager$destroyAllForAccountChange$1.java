package com.obric.aiproactive.impl.livecard;

import com.obric.livecard.api.entity.IslandSession;
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
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.livecard.ProactiveLiveCardManager$destroyAllForAccountChange$1", f = "ProactiveLiveCardManager.kt", i = {0}, l = {1478}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class ProactiveLiveCardManager$destroyAllForAccountChange$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $newUserId;
    final /* synthetic */ String $oldUserId;
    Object L$0;
    int label;

    ProactiveLiveCardManager$destroyAllForAccountChange$1(String r3, String r4, Continuation<? super ProactiveLiveCardManager$destroyAllForAccountChange$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$oldUserId = r3;
        this.$newUserId = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$destroyAllForAccountChange$1(this.$oldUserId, this.$newUserId, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ProactiveLiveCardManager$destroyAllForAccountChange$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactiveLiveCardManager$destroyAllForAccountChange$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L30:
        List r13 = MapsKt.toList(n.b());     // Catch: Throwable -> L27
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L27
    L14:
        if (r3.hasNext() == false) goto L16;
        l.f6475a.a((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r3.next(), Pair.class, "com.obric.memorydata.plugin")).component1(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        goto L14
    L16:
        n.b().clear();     // Catch: Throwable -> L27
        n.d().clear();     // Catch: Throwable -> L27
        n.c().clear();     // Catch: Throwable -> L27
        n r4 = n.f6478a;     // Catch: Throwable -> L27
        n.a(null);     // Catch: Throwable -> L27
        n r5 = n.f6478a;     // Catch: Throwable -> L27
        n.a(null);     // Catch: Throwable -> L27
        n r6 = n.f6478a;     // Catch: Throwable -> L27
        n.b(null);     // Catch: Throwable -> L27
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        Iterator r15 = r14.iterator();     // Catch: Throwable -> L27
    L18:
        if (r15.hasNext() == false) goto L20;
        r7.add((IslandSession) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r15.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), IslandSession.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        goto L18
    L20:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        r2.b(null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Destroying all lock-screen cards for account change oldUserId=" + this.$oldUserId + " newUserId=" + this.$newUserId + " count=" + r16.size(), false, 4, null);
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r11.hasNext() == false) goto L26;
        ProactiveLiveCardDisplayTool.INSTANCE.destroySession((IslandSession) ZeusTransformUtils.preCheckCast(r11.next(), IslandSession.class, "com.obric.memorydata.plugin"));
        goto L23
    L26:
        return Unit.INSTANCE;
    L27:
        th = move-exception;
        r2.b(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        kotlinx.coroutines.sync.a r17 = n.a();
        Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r17;
        this.label = 1;
        if (r17.a(null, r8) != r0) goto L11;
        return r0;
    L11:
        r2 = r17;
        goto L30
    }
}
