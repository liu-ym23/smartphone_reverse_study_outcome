package com.larus.uaigc.nowatermark;

import com.larus.im.bean.message.Message;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.nowatermark.CreationNoWatermarkManager$prefetchMessages$1", f = "CreationNoWatermarkManager.kt", i = {}, l = {236}, m = "invokeSuspend", n = {}, s = {})
final class CreationNoWatermarkManager$prefetchMessages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Message> $messages;
    final /* synthetic */ String $scene;
    int label;

    public CreationNoWatermarkManager$prefetchMessages$1(List<Message> r1, String r2, Continuation<? super CreationNoWatermarkManager$prefetchMessages$1> r3) {
        this.$messages = r1;
        this.$scene = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationNoWatermarkManager$prefetchMessages$1(this.$messages, this.$scene, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CreationNoWatermarkManager r6 = CreationNoWatermarkManager.a;
        List<Message> r2 = this.$messages;
        r6.getClass();
        CreationNoWatermarkManager$f r3 = CreationNoWatermarkManager.j(r2);
        String r4 = this.$scene;
        this.label = 1;
        if (CreationNoWatermarkManager.b(r6, r3, r4) != r0) goto L12;
        return r0;
    }
}
