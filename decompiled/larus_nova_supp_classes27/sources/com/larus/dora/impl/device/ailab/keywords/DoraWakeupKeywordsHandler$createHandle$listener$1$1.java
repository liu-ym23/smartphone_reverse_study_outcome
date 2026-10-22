package com.larus.dora.impl.device.ailab.keywords;

import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import g49.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ailab.keywords.DoraWakeupKeywordsHandler$createHandle$listener$1$1", f = "DoraWakeupKeywordsHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraWakeupKeywordsHandler$createHandle$listener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $callback;
    final /* synthetic */ SAMICoreBlock $data;
    final /* synthetic */ SAMICoreCallBackEventType $type;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DoraWakeupKeywordsHandler$createHandle$listener$1$1(SAMICoreCallBackEventType r1, SAMICoreBlock r2, Function1<? super String, Unit> r3, Continuation<? super DoraWakeupKeywordsHandler$createHandle$listener$1$1> r4) {
        this.$type = r1;
        this.$data = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraWakeupKeywordsHandler$createHandle$listener$1$1(this.$type, this.$data, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r4);
        if (this.$type == SAMICoreCallBackEventType.AIS_Ability) goto L8;
        d.b("DoraWakeupKeywordsHandler", "SAMICoreCallBackListener callback type: " + this.$type + "， Unknown message");
        return Unit.INSTANCE;
    L8:
        Object r5 = this.$data.audioData[0];
        if ((r5 instanceof String) == false) goto L11;
        String r6 = (String) r5;
    L12:
        d.d("DoraWakeupKeywordsHandler", "SAMICoreCallBackListener callback json: " + r6);
        this.$callback.invoke(r6);
        return Unit.INSTANCE;
    L11:
        r6 = null;
        goto L12
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
