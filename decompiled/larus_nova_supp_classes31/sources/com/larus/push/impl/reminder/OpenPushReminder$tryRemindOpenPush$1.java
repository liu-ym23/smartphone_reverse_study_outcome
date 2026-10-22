package com.larus.push.impl.reminder;

import com.larus.platform.api.s4;
import com.larus.platform.api.t4;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.push.impl.reminder.OpenPushReminder$tryRemindOpenPush$1", f = "OpenPushReminder.kt", i = {0, 1}, l = {257, 167}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
public final class OpenPushReminder$tryRemindOpenPush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ s4 $data;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public OpenPushReminder$tryRemindOpenPush$1(s4 r1, Function1<? super Boolean, Unit> r2, Continuation<? super OpenPushReminder$tryRemindOpenPush$1> r3) {
        this.$data = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OpenPushReminder$tryRemindOpenPush$1(this.$data, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r4 = 1;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 != 2) goto L12;
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L9
    L80:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r3.unlock(null);
        return Unit.INSTANCE;
    L9:
        th = th;
        kotlinx.coroutines.sync.a r7 = r3;
    L85:
        r7.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        Function1<Boolean, Unit> r5 = (Function1) this.L$2;
        s4 r6 = (s4) this.L$1;
        r7 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r18);
    L87:
        OpenPushReminderConfig r8 = OpenPushReminder.b;     // Catch: Throwable -> L84
        if (r8 == null) goto L26;
        Map<String, OpenPushReminderSceneInfo> r9 = r8.getSceneInfo();     // Catch: Throwable -> L84
        if (r9 == null) goto L26;
        OpenPushReminderSceneInfo r10 = r9.get(r6.a.getSceneId());     // Catch: Throwable -> L84
        if (r10 == null) goto L26;
        boolean r11 = Intrinsics.areEqual(r10.isOpen(), Boxing.boxBoolean(true));     // Catch: Throwable -> L84
    L28:
        if (r11 == true) goto L32;
        FLogger.a.i("OpenPushReminder", "tryRemindOpenPush[" + r6.a.getSceneId() + "] scene disabled");     // Catch: Throwable -> L84
        if (r5 == null) goto L76;
        r5.invoke(Boxing.boxBoolean(false));     // Catch: Throwable -> L84
    L76:
        r3 = r7;
        goto L80
    L32:
        t4 r12 = r6.b;     // Catch: Throwable -> L84
        if (r12 == null) goto L45;
        Map<String, Object> r13 = r12.c;     // Catch: Throwable -> L84
        if (r13 == null) goto L45;
        Object r14 = r13.get("counting_key");     // Catch: Throwable -> L84
        if (r14 == null) goto L45;
        String r15 = r14.toString();     // Catch: Throwable -> L84
        if (r15 == null) goto L45;
        if (o0.d(r15) == true) goto L44;
        r15 = null;
    L44:
        if (r15 == null) goto L45;
    L46:
        Map r16 = OpenPushReminder.c;     // Catch: Throwable -> L84
        String r17 = r6.a.getSceneId();     // Catch: Throwable -> L84
        LinkedHashMap r19 = (LinkedHashMap) r16;     // Catch: Throwable -> L84
        Object r110 = r19.get(r17);     // Catch: Throwable -> L84
        if (r110 != null) goto L49;
        r110 = new LinkedHashMap();     // Catch: Throwable -> L84
        r19.put(r17, r110);     // Catch: Throwable -> L84
    L49:
        Map r111 = (Map) r110;     // Catch: Throwable -> L84
        Integer r112 = (Integer) r111.get(r15);     // Catch: Throwable -> L84
        if (r112 == null) goto L52;
        int r113 = r112.intValue();     // Catch: Throwable -> L84
    L53:
        int r114 = r113 + 1;     // Catch: Throwable -> L84
        r111.put(r15, Boxing.boxInt(r114));     // Catch: Throwable -> L84
        OpenPushReminderConfig r115 = OpenPushReminder.b;     // Catch: Throwable -> L84
        if (r115 == null) goto L62;
        Map<String, OpenPushReminderSceneInfo> r116 = r115.getSceneInfo();     // Catch: Throwable -> L84
        if (r116 == null) goto L62;
        OpenPushReminderSceneInfo r117 = r116.get(r6.a.getSceneId());     // Catch: Throwable -> L84
        if (r117 == null) goto L62;
        Integer r118 = r117.getEventTimes();     // Catch: Throwable -> L84
        if (r118 == null) goto L62;
        r4 = r118.intValue();     // Catch: Throwable -> L84
    L62:
        if (r114 >= r4) goto L66;
        FLogger.a.i("OpenPushReminder", "tryRemindOpenPush[" + r6.a.getSceneId() + "] accumulated count = " + r114 + ", target count = " + r4);     // Catch: Throwable -> L84
        if (r5 == null) goto L76;
        r5.invoke(Boxing.boxBoolean(false));     // Catch: Throwable -> L84
        goto L76
    L66:
        Map r20 = OpenPushReminder.d;     // Catch: Throwable -> L84
        if (r20.containsKey(r6.a.getSceneId()) == false) goto L71;
        FLogger.a.i("OpenPushReminder", "tryRemindOpenPush[" + r6.a.getSceneId() + "] ignore ongoing scene");     // Catch: Throwable -> L84
        if (r5 == null) goto L76;
        r5.invoke(Boxing.boxBoolean(false));     // Catch: Throwable -> L84
        goto L76
    L71:
        r111.put(r15, Boxing.boxInt(0));     // Catch: Throwable -> L84
        boolean r21 = r20.isEmpty();     // Catch: Throwable -> L84
        r20.put(r6.a.getSceneId(), r6);     // Catch: Throwable -> L84
        if (r21 == false) goto L77;
        OpenPushReminder r22 = OpenPushReminder.a;     // Catch: Throwable -> L84
        this.L$0 = r7;     // Catch: Throwable -> L84
        this.L$1 = null;     // Catch: Throwable -> L84
        this.L$2 = null;     // Catch: Throwable -> L84
        this.label = 2;     // Catch: Throwable -> L84
        if (OpenPushReminder.a(r22, r6, r5, this) != r0) goto L76;
        return r0;
    L77:
        if (r5 == null) goto L76;
        r5.invoke(Boxing.boxBoolean(false));     // Catch: Throwable -> L84
        goto L76
    L52:
        r113 = 0;
    L45:
        r15 = "_default_counting_key";
    L26:
        r11 = false;
    L84:
        th = th;
        goto L85
    L14:
        ResultKt.throwOnFailure(r18);
        kotlinx.coroutines.sync.a r23 = OpenPushReminder.e;
        r6 = this.$data;
        Function1<Boolean, Unit> r24 = this.$callback;
        this.L$0 = r23;
        this.L$1 = r6;
        this.L$2 = r24;
        this.label = 1;
        if (r23.a(null, this) != r0) goto L17;
        return r0;
    L17:
        r7 = r23;
        r5 = r24;
        goto L87
    }
}
