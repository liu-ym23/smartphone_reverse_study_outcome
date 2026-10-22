package com.obric.update.impl.v2.handler;

import com.larus.utils.logger.FLogger;
import com.obric.update.api.v2.ObricUpdateSettingDelegate;
import java.util.Date;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.update.impl.v2.handler.ObricScheduledUpdateHandler$startScheduledCheck$1", f = "ObricScheduledUpdateHandler.kt", i = {}, l = {55, 59, 64}, m = "invokeSuspend", n = {}, s = {})
public final class ObricScheduledUpdateHandler$startScheduledCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricScheduledUpdateHandler this$0;

    public ObricScheduledUpdateHandler$startScheduledCheck$1(ObricScheduledUpdateHandler r1, Continuation<? super ObricScheduledUpdateHandler$startScheduledCheck$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricScheduledUpdateHandler$startScheduledCheck$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x009e -> B:22:0x0042). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L17;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L11;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L13 CancellationException -> L15
        ObricScheduledUpdateHandler$startScheduledCheck$1 r11 = this;
    L29:
        String r2 = r11.this$0.e.format(new Date());     // Catch: Exception -> L13 CancellationException -> L15
        ObricUpdateSettingDelegate r6 = ObricUpdateSettingDelegate.a;     // Catch: Exception -> L13 CancellationException -> L15
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L13 CancellationException -> L15
        r6.b(r2);     // Catch: Exception -> L13 CancellationException -> L15
    L30:
        r11.label = 3;     // Catch: Exception -> L13 CancellationException -> L15
        if (DelayKt.delay(900000, r11) != r0) goto L23;
        return r0;
    L23:
        if (ObricScheduledUpdateHandler.a(r11.this$0) == false) goto L30;
        if ((!Intrinsics.areEqual(r11.this$0.e.format(new Date()), ObricUpdateSettingDelegate.a.c())) == false) goto L30;
        FLogger.a.i("ObricScheduledUpdateHandler", "Scheduled update check triggered");     // Catch: Exception -> L13 CancellationException -> L15
        MainCoroutineDispatcher r3 = Dispatchers.getMain();     // Catch: Exception -> L13 CancellationException -> L15
        1 r7 = new 1(r11.this$0, null);     // Catch: Exception -> L13 CancellationException -> L15
        r11.label = 2;     // Catch: Exception -> L13 CancellationException -> L15
        if (BuildersKt.withContext(r3, r7, r11) != r0) goto L29;
        return r0;
    L11:
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L13 CancellationException -> L15
    L21:
        r11 = this;
        goto L23
    L17:
        ResultKt.throwOnFailure(r10);
        FLogger.a.i("ObricScheduledUpdateHandler", "Delaying 5 minutes before starting check loop");     // Catch: Exception -> L13 CancellationException -> L15
        this.label = 1;     // Catch: Exception -> L13 CancellationException -> L15
        if (DelayKt.delay(300000, this) != r0) goto L21;
        return r0;
    L15:
        e = move-exception;
        throw e;
    L13:
        e = move-exception;
        FLogger.a.e("ObricScheduledUpdateHandler", "Scheduled check error", e);
        return Unit.INSTANCE;
    }
}
