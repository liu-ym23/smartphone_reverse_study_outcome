package com.obric.miniapp.alarm;

import android.app.PendingIntent;
import com.obric.livecard.api.entity.IslandSession;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.LiveCardAlarmExpirationController$removeSession$1", f = "LiveCardAlarmExpirationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LiveCardAlarmExpirationController$removeSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ IslandSession $session;
    int label;

    public LiveCardAlarmExpirationController$removeSession$1(String r1, IslandSession r2, Continuation<? super LiveCardAlarmExpirationController$removeSession$1> r3) {
        this.$id = r1;
        this.$session = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LiveCardAlarmExpirationController$removeSession$1(this.$id, this.$session, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r7);
        ConcurrentHashMap<String, LiveCardAlarmExpirationController.a> r8 = LiveCardAlarmExpirationController.c;
        LiveCardAlarmExpirationController.a r0 = r8.get(this.$id);
        if (r0 != null) goto L9;
        return Unit.INSTANCE;
    L9:
        if (LiveCardAlarmExpirationController.c(r0.a) != LiveCardAlarmExpirationController.c(this.$session)) goto L11;
        PendingIntent r1 = r0.e;
        android.app.AlarmManager r2 = LiveCardAlarmExpirationController.a.h();
        if (r2 == null) goto L15;
        r2.cancel(r1);
    L15:
        r1.cancel();
        if (r8.remove(this.$id, r0) == false) goto L19;
        LiveCardAlarmExpirationController.e();
    L19:
        return Unit.INSTANCE;
    L11:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
