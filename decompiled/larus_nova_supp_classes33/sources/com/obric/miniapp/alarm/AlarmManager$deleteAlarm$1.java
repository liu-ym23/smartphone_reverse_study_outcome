package com.obric.miniapp.alarm;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmManager$deleteAlarm$1", f = "AlarmManager.kt", i = {}, l = {314}, m = "invokeSuspend", n = {}, s = {})
final class AlarmManager$deleteAlarm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ Function1<Boolean, Unit> $onResult;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AlarmManager$deleteAlarm$1(String r1, Function1<? super Boolean, Unit> r2, Continuation<? super AlarmManager$deleteAlarm$1> r3) {
        this.$id = r1;
        this.$onResult = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AlarmManager$deleteAlarm$1(this.$id, this.$onResult, r4);
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r4);     // Catch: Exception -> L15
    L13:
        this.$onResult.invoke(Boxing.boxBoolean(true));     // Catch: Exception -> L15
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        AlarmManager r5 = AlarmManager.a;     // Catch: Exception -> L15
        String r2 = this.$id;     // Catch: Exception -> L15
        this.label = 1;     // Catch: Exception -> L15
        if (AlarmManager.b(r5, r2, this) != r0) goto L13;
        return r0;
    L15:
        this.$onResult.invoke(Boxing.boxBoolean(false));
        goto L17
    }
}
