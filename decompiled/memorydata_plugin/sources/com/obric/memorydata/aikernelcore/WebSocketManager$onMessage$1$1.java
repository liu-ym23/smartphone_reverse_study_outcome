package com.obric.memorydata.aikernelcore;

import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.WebSocketManager$onMessage$1$1", f = "WebSocketManager.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
final class WebSocketManager$onMessage$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ JsonObject $distributeBody;
    final /* synthetic */ JsonObject $it;
    int label;

    WebSocketManager$onMessage$1$1(JsonObject r3, JsonObject r4, Continuation<? super WebSocketManager$onMessage$1$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$it = r3;
        this.$distributeBody = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new WebSocketManager$onMessage$1$1(this.$it, this.$distributeBody, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((WebSocketManager$onMessage$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), WebSocketManager$onMessage$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        JsonObject r8 = this.$it.getAsJsonObject("package");
        if (r8 == null) goto L30;
        JsonObject r9 = r8.getAsJsonObject("businesses");
        if (r9 == null) goto L30;
        Set<String> r10 = r9.keySet();
        if (r10 == null) goto L30;
        String r11 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L30;
        String r2 = WebSocketManager.b();
        if (r2 == null) goto L20;
        WebSocketManager r4 = WebSocketManager.f8445a;
        String r5 = WebSocketManager.c();
        if (r5 != null) goto L24;
        r5 = "";
    L24:
        WebSocketManager.a(r4, r5, r11, r2);
        MemoryScriptEngineEnv r12 = MemoryScriptEngineEnv.INSTANCE;
        JsonObject r3 = this.$distributeBody;
        Intrinsics.checkNotNull(r3);
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r12.pushDebugInfo(r3, r6) != r0) goto L28;
        return r0;
    L20:
        return Unit.INSTANCE;
    L30:
        return Unit.INSTANCE;
    }
}
