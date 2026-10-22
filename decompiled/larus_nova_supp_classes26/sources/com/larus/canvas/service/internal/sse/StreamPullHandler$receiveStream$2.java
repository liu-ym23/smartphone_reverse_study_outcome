package com.larus.canvas.service.internal.sse;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "chunkPkg", "Lcom/larus/canvas/service/internal/sse/CanvasChunkPackage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.service.internal.sse.StreamPullHandler$receiveStream$2", f = "StreamPullHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class StreamPullHandler$receiveStream$2 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $dispatcher;
    final /* synthetic */ String $logId;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StreamPullHandler this$0;

    public StreamPullHandler$receiveStream$2(e r1, StreamPullHandler r2, String r3, Continuation<? super StreamPullHandler$receiveStream$2> r4) {
        this.$dispatcher = r1;
        this.this$0 = r2;
        this.$logId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        StreamPullHandler$receiveStream$2 r0 = new StreamPullHandler$receiveStream$2(this.$dispatcher, this.this$0, this.$logId, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(b r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((b) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r6);
        b r7 = (b) this.L$0;
        String r0 = r7.b;
        int r1 = r0.hashCode();
        if (r1 == 3089282) goto L25;
        if (r1 == 3271912) goto L21;
        if (r1 != 96784904) goto L29;
        if (r0.equals("error") == false) goto L29;
        Ref.IntRef r2 = new Ref.IntRef();
        r2.element = -1;
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = "";
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L17
        JSONObject r5 = new JSONObject(r7.c);     // Catch: Throwable -> L17
        r2.element = r5.optInt("status_code");     // Catch: Throwable -> L17
        r3.element = r5.optString("status_msg");     // Catch: Throwable -> L17
        Result.constructor-impl(r5);     // Catch: Throwable -> L17
    L19:
        this.$dispatcher.a(new f(1, this.$logId, r2.element, (String) r3.element));
    L17:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L29:
        return Unit.INSTANCE;
    L21:
        if (r0.equals("json") == false) goto L29;
        this.$dispatcher.b(r7);
        goto L29
    L25:
        if (r0.equals("done") == false) goto L29;
        FLogger r9 = FLogger.a;
        int r10 = StreamPullHandler.k;
        r9.i("SSEHandler", "Stream Done.");
        this.this$0.e = true;
        this.$dispatcher.a(new f(0, this.$logId, 12));
        goto L29
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
