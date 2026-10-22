package com.obric.memorydata.personalcontext.realcontext;

import com.obric.memorydata.recommend.RecommendApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.realcontext.RCStateSearchExecutor$searchAIProactiveState$1", f = "RCStateSearchExecutor.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
final class RCStateSearchExecutor$searchAIProactiveState$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $result;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    RCStateSearchExecutor$searchAIProactiveState$1(JSONObject r3, Continuation<? super RCStateSearchExecutor$searchAIProactiveState$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$result = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new RCStateSearchExecutor$searchAIProactiveState$1(this.$result, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((RCStateSearchExecutor$searchAIProactiveState$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), RCStateSearchExecutor$searchAIProactiveState$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x007d -> B:15:0x007e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        JSONObject r2 = (JSONObject) ZeusTransformUtils.preCheckCast(this.L$3, JSONObject.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.L$2, String.class, "com.obric.memorydata.plugin");
        Iterator r5 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$1, Iterator.class, "com.obric.memorydata.plugin");
        JSONObject r6 = (JSONObject) ZeusTransformUtils.preCheckCast(this.L$0, JSONObject.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L15:
        r2.put(r4, r9);
        r2 = r6;
    L10:
        if (r5.hasNext() == false) goto L17;
        r4 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        RecommendApi r10 = RecommendApi.INSTANCE;
        this.L$0 = r2;
        this.L$1 = r5;
        this.L$2 = r4;
        this.L$3 = r2;
        this.label = 1;
        r9 = r10.getRealtimeContext(r4, this);
        if (r9 != r0) goto L14;
        return r0;
    L14:
        r6 = r2;
        goto L15
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(c.a(), Iterable.class, "com.obric.memorydata.plugin");
        r2 = this.$result;
        r5 = r11.iterator();
        goto L10
    }
}
