package com.larksuite.framework.http.v2.internal.rust.stream;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.framework.http.v2.internal.rust.stream.OkHttpRequestBodyReader$StreamingSource$ensureStarted$1", f = "OkHttpRequestBodyReader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OkHttpRequestBodyReader$StreamingSource$ensureStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ f.g this$0;

    public OkHttpRequestBodyReader$StreamingSource$ensureStarted$1(f.g r1, Continuation<? super OkHttpRequestBodyReader$StreamingSource$ensureStarted$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OkHttpRequestBodyReader$StreamingSource$ensureStarted$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r4);
        f.g r0 = this.this$0;
        BufferedSink r5 = Okio.buffer(new f.b(r0.e.g, r0.b));
        this.this$0.a.writeTo(r5);     // Catch: Throwable -> L7
    L15:
        r5.close();
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        AtomicReference<Throwable> r1 = this.this$0.c;     // Catch: Throwable -> L17
    L10:
        if (r1.compareAndSet(null, th) == true) goto L14;
        if (r1.get() == null) goto L10;
    L14:
        this.this$0.b.b(th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r5.close();
        throw th;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
