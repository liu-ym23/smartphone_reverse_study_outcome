package com.obric.miniapp.alarm;

import java.util.LinkedHashMap;
import java.util.Map;
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
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmManager$createOrUpdateAlarm$1", f = "AlarmManager.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
final class AlarmManager$createOrUpdateAlarm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ Map<String, String> $extraInfo;
    final /* synthetic */ String $id;
    final /* synthetic */ long $intervalMinutes;
    final /* synthetic */ Function1<Boolean, Unit> $onResult;
    final /* synthetic */ int $repeatCount;
    final /* synthetic */ String $title;
    final /* synthetic */ w $triggerTime;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AlarmManager$createOrUpdateAlarm$1(String r1, String r2, String r3, w r4, long r5, int r7, Function1<? super Boolean, Unit> r8, Map<String, String> r9, Continuation<? super AlarmManager$createOrUpdateAlarm$1> r10) {
        this.$id = r1;
        this.$title = r2;
        this.$content = r3;
        this.$triggerTime = r4;
        this.$intervalMinutes = r5;
        this.$repeatCount = r7;
        this.$onResult = r8;
        this.$extraInfo = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new AlarmManager$createOrUpdateAlarm$1(this.$id, this.$title, this.$content, this.$triggerTime, this.$intervalMinutes, this.$repeatCount, this.$onResult, this.$extraInfo, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L15
    L13:
        this.$onResult.invoke(Boxing.boxBoolean(true));     // Catch: Exception -> L15
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
        AlarmManager r3 = AlarmManager.a;     // Catch: Exception -> L15
        String r4 = this.$id;     // Catch: Exception -> L15
        String r5 = this.$title;     // Catch: Exception -> L15
        String r6 = this.$content;     // Catch: Exception -> L15
        w r7 = this.$triggerTime;     // Catch: Exception -> L15
        LinkedHashMap r8 = new LinkedHashMap();     // Catch: Exception -> L15
        r8.putAll(this.$extraInfo);     // Catch: Exception -> L15
        Unit r15 = Unit.INSTANCE;     // Catch: Exception -> L15
        long r9 = this.$intervalMinutes;     // Catch: Exception -> L15
        int r11 = this.$repeatCount;     // Catch: Exception -> L15
        this.label = 1;     // Catch: Exception -> L15
        if (AlarmManager.a(r3, r4, r5, r6, r7, r8, r9, r11, this) != r0) goto L13;
        return r0;
    L15:
        this.$onResult.invoke(Boxing.boxBoolean(false));
        goto L17
    }
}
