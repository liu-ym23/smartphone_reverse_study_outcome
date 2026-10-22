package com.obric.memorydata.aikernelcore;

import android.os.Bundle;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.PapayaManager$runTask$1", f = "PapayaManager.kt", i = {}, l = {400}, m = "invokeSuspend", n = {}, s = {})
final class PapayaManager$runTask$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $businessName;
    final /* synthetic */ Function1<Bundle, Unit> $callback;
    final /* synthetic */ JSONObject $input;
    int label;

    PapayaManager$runTask$1(String r3, JSONObject r4, Function1<? super Bundle, Unit> r5, Continuation<? super PapayaManager$runTask$1> r6) {
        Function1<Bundle, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$businessName = r3;
        this.$input = r4;
        this.$callback = r7;
        super(2, r8);
    }

    private static final Unit invokeSuspend$lambda$0(Function1 r2, Bundle r3) {
        ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$dWVIeMXTP8Wj9kSOb6As7Xnkrgc(Function1 r0, Bundle r1) {
        return invokeSuspend$lambda$0(r0, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PapayaManager$runTask$1(this.$businessName, this.$input, this.$callback, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((PapayaManager$runTask$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PapayaManager$runTask$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        MemoryScriptEngineEnv r2 = MemoryScriptEngineEnv.INSTANCE;
        String r12 = this.$businessName;
        RequestParams r3 = new RequestParams(BundleExtKt.json2Bundle$default(this.$input, false, 2, null), null, 2, null);
        final Function1<Bundle, Unit> r5 = this.$callback;
        Function1 r6 = new $$Lambda$PapayaManager$runTask$1$dWVIeMXTP8Wj9kSOb6As7Xnkrgc(r5);
        Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (MemoryScriptEngineEnv.runPackage$default(r2, r12, r3, null, r6, r7, 4, null) != r0) goto L12;
        return r0;
    }
}
