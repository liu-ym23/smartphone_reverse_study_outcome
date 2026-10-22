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
@DebugMetadata(c = "com.larus.uaigc.nowatermark.CreationNoWatermarkManager$prefetchMessageWindow$1", f = "CreationNoWatermarkManager.kt", i = {}, l = {1576}, m = "invokeSuspend", n = {}, s = {})
public final class CreationNoWatermarkManager$prefetchMessageWindow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $afterCount;
    final /* synthetic */ int $beforeCount;
    final /* synthetic */ Message $current;
    final /* synthetic */ List<Message> $messageList;
    final /* synthetic */ String $requestKey;
    final /* synthetic */ String $scene;
    int label;

    public CreationNoWatermarkManager$prefetchMessageWindow$1(Message r1, List<Message> r2, int r3, int r4, String r5, String r6, Continuation<? super CreationNoWatermarkManager$prefetchMessageWindow$1> r7) {
        this.$current = r1;
        this.$messageList = r2;
        this.$beforeCount = r3;
        this.$afterCount = r4;
        this.$scene = r5;
        this.$requestKey = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new CreationNoWatermarkManager$prefetchMessageWindow$1(this.$current, this.$messageList, this.$beforeCount, this.$afterCount, this.$scene, this.$requestKey, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L15
    L13:
        CreationNoWatermarkManager.n.remove(this.$requestKey);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        CreationNoWatermarkManager r8 = CreationNoWatermarkManager.a;     // Catch: Throwable -> L15
        CreationNoWatermarkManager$f r2 = CreationNoWatermarkManager.j(CreationNoWatermarkManager.a(r8, this.$current, this.$messageList, this.$beforeCount, this.$afterCount));     // Catch: Throwable -> L15
        String r3 = this.$scene;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (CreationNoWatermarkManager.b(r8, r2, r3) != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        CreationNoWatermarkManager.n.remove(this.$requestKey);
        throw th;
    }
}
