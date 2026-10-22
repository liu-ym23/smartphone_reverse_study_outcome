package com.obric.miniapp.alarm;

import java.util.List;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmManager$getAllAlarmIds$1", f = "AlarmManager.kt", i = {}, l = {350}, m = "invokeSuspend", n = {}, s = {})
final class AlarmManager$getAllAlarmIds$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<List<String>, Unit> $onResult;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AlarmManager$getAllAlarmIds$1(Function1<? super List<String>, Unit> r1, Continuation<? super AlarmManager$getAllAlarmIds$1> r2) {
        this.$onResult = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AlarmManager$getAllAlarmIds$1(this.$onResult, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Function1<List<String>, Unit> r2 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r4);
    L12:
        r2.invoke(r4);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        Function1<List<String>, Unit> r5 = this.$onResult;
        AlarmManager.a.getClass();
        b r3 = AlarmManager.i();
        this.L$0 = r5;
        this.label = 1;
        Object r6 = r3.d(this);
        if (r6 != r0) goto L11;
        return r0;
    L11:
        r2 = r5;
        r4 = r6;
        goto L12
    }
}
