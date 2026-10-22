package com.larus.contextwindow.impl.ui;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.contextwindow.impl.ui.MembershipQuotaRefreshPolicy$scheduleDeadline$1", f = "MembershipQuotaRefreshPolicy.kt", i = {}, l = {50, 53}, m = "invokeSuspend", n = {}, s = {})
public final class MembershipQuotaRefreshPolicy$scheduleDeadline$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $deadline;
    final /* synthetic */ long $delayMillis;
    int label;
    final /* synthetic */ MembershipQuotaRefreshPolicy this$0;

    public MembershipQuotaRefreshPolicy$scheduleDeadline$1(long r1, MembershipQuotaRefreshPolicy r3, long r4, Continuation<? super MembershipQuotaRefreshPolicy$scheduleDeadline$1> r6) {
        this.$delayMillis = r1;
        this.this$0 = r3;
        this.$deadline = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MembershipQuotaRefreshPolicy$scheduleDeadline$1(this.$delayMillis, this.this$0, this.$deadline, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L30:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        MembershipQuotaRefreshPolicy r9 = this.this$0;
        if (r9.d == false) goto L32;
        Long r10 = r9.e;
        long r3 = this.$deadline;
        if (r10 == null) goto L32;
        if (r10.longValue() != r3) goto L32;
        Long r11 = this.this$0.f;
        long r4 = this.$deadline;
        if (r11 != null) goto L24;
    L26:
        MembershipQuotaRefreshPolicy r12 = this.this$0;
        r12.f = Boxing.boxLong(this.$deadline);
        Function1<Continuation<? super Unit>, Object> r13 = this.this$0.c;
        this.label = 2;
        if (r13.invoke(this) != r0) goto L30;
        return r0;
    L24:
        if (r11.longValue() != r4) goto L26;
    L32:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r8);
        long r5 = this.$delayMillis;
        this.label = 1;
        if (DelayKt.delay(r5, this) != r0) goto L13;
        return r0;
    }
}
