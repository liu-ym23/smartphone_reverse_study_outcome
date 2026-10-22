package com.obric.miniapp.alarm;

import java.util.Iterator;
import java.util.Map;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmManager$getAlarmJsonById$1", f = "AlarmManager.kt", i = {}, l = {344}, m = "invokeSuspend", n = {}, s = {})
final class AlarmManager$getAlarmJsonById$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ Function1<String, Unit> $onResult;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AlarmManager$getAlarmJsonById$1(Function1<? super String, Unit> r1, String r2, Continuation<? super AlarmManager$getAlarmJsonById$1> r3) {
        this.$onResult = r1;
        this.$id = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AlarmManager$getAlarmJsonById$1(this.$onResult, this.$id, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Function1<String, Unit> r2 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r6);
    L12:
        a r7 = (a) r6;
        if (r7 == null) goto L19;
        JSONObject r3 = new JSONObject();
        r3.put("id", r7.a);
        r3.put("title", r7.b);
        r3.put("content", r7.c);
        r3.put("triggerTime", r7.d.b());
        r3.put("intervalMinutes", r7.e);
        r3.put("repeatCount", r7.f);
        r3.put("currentRepeatCount", r7.g);
        r3.put("isActive", r7.h);
        r3.put("createdAt", r7.i.b());
        JSONObject r4 = new JSONObject();
        Iterator<Map.Entry<String, String>> r8 = r7.j.entrySet().iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        Map.Entry<String, String> r5 = r8.next();
        r4.put(r5.getKey(), r5.getValue());
        goto L16
    L18:
        r3.put("extraInfo", r4);
        String r9 = r3.toString();
    L20:
        r2.invoke(r9);
        return Unit.INSTANCE;
    L19:
        r9 = null;
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        Function1<String, Unit> r10 = this.$onResult;
        AlarmManager.a.getClass();
        b r11 = AlarmManager.i();
        String r12 = this.$id;
        this.L$0 = r10;
        this.label = 1;
        Object r13 = r11.c(r12, this);
        if (r13 != r0) goto L11;
        return r0;
    L11:
        r2 = r10;
        r6 = r13;
        goto L12
    }
}
