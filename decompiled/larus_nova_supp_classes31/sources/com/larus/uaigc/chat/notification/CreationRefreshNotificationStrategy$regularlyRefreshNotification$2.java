package com.larus.uaigc.chat.notification;

import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.notification.CreationRefreshNotificationStrategy$regularlyRefreshNotification$2", f = "CreationRefreshNotificationStrategy.kt", i = {1, 2}, l = {195, 203, 204}, m = "invokeSuspend", n = {"state", "state"}, s = {"L$0", "L$0"})
final class CreationRefreshNotificationStrategy$regularlyRefreshNotification$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $userQuery;
    Object L$0;
    int label;

    public CreationRefreshNotificationStrategy$regularlyRefreshNotification$2(String r1, String r2, Continuation<? super CreationRefreshNotificationStrategy$regularlyRefreshNotification$2> r3) {
        this.$messageId = r1;
        this.$userQuery = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationRefreshNotificationStrategy$regularlyRefreshNotification$2(this.$messageId, this.$userQuery, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x008e -> B:17:0x0048). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        CreationRefreshNotificationStrategy$a r2 = (CreationRefreshNotificationStrategy$a) this.L$0;
        ResultKt.throwOnFailure(r11);
        CreationRefreshNotificationStrategy$a r12 = r2;
    L16:
        CreationRefreshNotificationStrategy$regularlyRefreshNotification$2 r3 = this;
    L17:
        if (r12 == null) goto L30;
        CreationRefreshNotificationStrategy$a r13 = (CreationRefreshNotificationStrategy$a) CreationRefreshNotificationStrategy.c.get(r3.$messageId);
        FLogger.a.i("CreationRefreshNotificationStrategy", "handleRefreshInner, messageId" + r3.$messageId);
        CreationRefreshNotificationStrategy r6 = CreationRefreshNotificationStrategy.a;
        String r7 = r3.$userQuery;
        r3.L$0 = r13;
        r3.label = 2;
        if (CreationRefreshNotificationStrategy.b(r6, r13, r7, r3) != r0) goto L21;
        return r0;
    L21:
        CreationRefreshNotificationStrategy$regularlyRefreshNotification$2 r9 = r3;
        CreationRefreshNotificationStrategy$a r4 = r13;
        CreationRefreshNotificationStrategy$regularlyRefreshNotification$2 r14 = r9;
    L22:
        if (r4 == null) goto L24;
        long r8 = r4.d;
    L25:
        r14.L$0 = r4;
        r14.label = 3;
        if (DelayKt.delay(r8, r14) != r0) goto L28;
        return r0;
    L28:
        CreationRefreshNotificationStrategy$a r10 = r4;
        r3 = r14;
        r12 = r10;
        goto L17
    L24:
        r8 = 1000;
        goto L25
    L30:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r4 = (CreationRefreshNotificationStrategy$a) this.L$0;
        ResultKt.throwOnFailure(r11);
        r14 = this;
        goto L22
    L11:
        ResultKt.throwOnFailure(r11);
    L15:
        r12 = (CreationRefreshNotificationStrategy$a) CreationRefreshNotificationStrategy.c.get(this.$messageId);
        goto L16
    L12:
        ResultKt.throwOnFailure(r11);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L15;
        return r0;
    }
}
