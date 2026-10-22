package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.RichMediaLayoutViewModel$requestNoWatermarkImage$job$1", f = "RichMediaLayoutViewModel.kt", i = {}, l = {296}, m = "invokeSuspend", n = {}, s = {})
final class RichMediaLayoutViewModel$requestNoWatermarkImage$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $generation;
    final /* synthetic */ String $key;
    int label;
    final /* synthetic */ h0 this$0;

    public RichMediaLayoutViewModel$requestNoWatermarkImage$job$1(long r1, h0 r3, String r4, Continuation<? super RichMediaLayoutViewModel$requestNoWatermarkImage$job$1> r5) {
        this.$generation = r1;
        this.this$0 = r3;
        this.$key = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new RichMediaLayoutViewModel$requestNoWatermarkImage$job$1(this.$generation, this.this$0, this.$key, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 != 0) goto L49;
        ResultKt.throwOnFailure(r8);
        RichMediaLayoutViewModel$requestNoWatermarkImage$job$1$hasNoWatermark$1 r9 = new RichMediaLayoutViewModel$requestNoWatermarkImage$job$1$hasNoWatermark$1(this.$key, null);     // Catch: Throwable -> L7 CancellationException -> L9
        this.label = 1;     // Catch: Throwable -> L7 CancellationException -> L9
        r8 = TimeoutKt.c(3000, r9, this);     // Catch: Throwable -> L7 CancellationException -> L9
        if (r8 != r1) goto L17;
        return r1;
    L17:
        boolean r10 = Intrinsics.areEqual(r8, Boxing.boxBoolean(true));     // Catch: Throwable -> L7 CancellationException -> L9
        long r0 = this.$generation;
        h0 r3 = this.this$0;
        if (r0 != r3.j) goto L26;
        r3.l.remove(this.$key);
        this.this$0.n.remove(this.$key);
    L26:
        long r4 = this.$generation;
        h0 r5 = this.this$0;
        if (r4 != r5.j) goto L29;
        if (r10 == false) goto L33;
        r5.o.remove(this.$key);
    L37:
        if (this.this$0.m.remove(this.$key) == false) goto L42;
        this.this$0.g(false);
        Function0<Unit> r11 = this.this$0.k;
        if (r11 == null) goto L42;
        r11.invoke();
    L42:
        return Unit.INSTANCE;
    L33:
        if (r5.o.size() < 100) goto L35;
        ((LinkedHashMap) this.this$0.o).clear();
    L35:
        this.this$0.o.put(this.$key, Boxing.boxLong(System.currentTimeMillis()));
        goto L37
    L29:
        return Unit.INSTANCE;
    L49:
        if (r2 != 1) goto L12;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L7 CancellationException -> L9
        goto L17
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L44:
        th = move-exception;
        long r6 = this.$generation;
        h0 r7 = this.this$0;
        if (r6 != r7.j) goto L48;
        r7.l.remove(this.$key);
        this.this$0.n.remove(this.$key);
    L48:
        throw th;
    L9:
        e = move-exception;
        throw e;     // Catch: Throwable -> L44
    L7:
        th = move-exception;
        FLogger.a.w("RichMediaLayoutVM", "request no watermark image failed, msg=" + th.getMessage());     // Catch: Throwable -> L44
        long r12 = this.$generation;
        h0 r13 = this.this$0;
        if (r12 != r13.j) goto L25;
        r13.l.remove(this.$key);
        this.this$0.n.remove(this.$key);
    L25:
        r10 = false;
        goto L26
    }
}
