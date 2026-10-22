package com.obric.miniapp.alarm;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmTtsNotificationDispatcherKt$chunked$1$next$1", f = "AlarmTtsNotificationDispatcher.kt", i = {}, l = {404}, m = "invokeSuspend", n = {}, s = {})
public final class AlarmTtsNotificationDispatcherKt$chunked$1$next$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $upstream;
    int label;

    public AlarmTtsNotificationDispatcherKt$chunked$1$next$1(ReceiveChannel<Object> r1, Continuation<? super AlarmTtsNotificationDispatcherKt$chunked$1$next$1> r2) {
        this.$upstream = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AlarmTtsNotificationDispatcherKt$chunked$1$next$1(this.$upstream, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<Object> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
        Object r5 = ((kotlinx.coroutines.channels.g) r4).a;
    L12:
        return kotlinx.coroutines.channels.g.b(r5);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ReceiveChannel<Object> r6 = this.$upstream;
        this.label = 1;
        r5 = r6.receiveCatching-JP2dKIU(this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
