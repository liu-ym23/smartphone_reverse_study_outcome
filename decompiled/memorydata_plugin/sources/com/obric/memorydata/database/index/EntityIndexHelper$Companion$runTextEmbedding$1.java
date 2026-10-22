package com.obric.memorydata.database.index;

import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.index.EntityIndexHelper$Companion$runTextEmbedding$1", f = "EntityIndexHelper.kt", i = {}, l = {460}, m = "invokeSuspend", n = {}, s = {})
final class EntityIndexHelper$Companion$runTextEmbedding$1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super float[]>, Object> {
    final /* synthetic */ String $query;
    final /* synthetic */ boolean $throwThermalStatusError;
    final /* synthetic */ boolean $useVlm;
    int label;

    EntityIndexHelper$Companion$runTextEmbedding$1(String r3, boolean r4, boolean r5, Continuation<? super EntityIndexHelper$Companion$runTextEmbedding$1> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$query = r3;
        this.$throwThermalStatusError = r4;
        this.$useVlm = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new EntityIndexHelper$Companion$runTextEmbedding$1(this.$query, this.$throwThermalStatusError, this.$useVlm, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super float[]> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super float[]> r4) {
        return ((EntityIndexHelper$Companion$runTextEmbedding$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntityIndexHelper$Companion$runTextEmbedding$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L14:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        String r11 = null;
        if (t.f9438a.f() == false) goto L11;
        r11 = AppContext.INSTANCE.getPackageName();
    L11:
        String r5 = r11;
        com.obric.memorydata.aikernelcore.a r3 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        String r4 = this.$query;
        boolean r6 = this.$throwThermalStatusError;
        boolean r7 = this.$useVlm;
        Continuation<? super float[]> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r10 = r3.a(r4, r5, r6, r7, r8);
        if (r10 != r0) goto L14;
        return r0;
    }
}
