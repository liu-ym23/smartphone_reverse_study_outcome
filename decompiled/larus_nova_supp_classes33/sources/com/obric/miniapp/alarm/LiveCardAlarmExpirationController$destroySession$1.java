package com.obric.miniapp.alarm;

import android.app.PendingIntent;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.island.IslandApi;
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
@DebugMetadata(c = "com.obric.miniapp.alarm.LiveCardAlarmExpirationController$destroySession$1", f = "LiveCardAlarmExpirationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LiveCardAlarmExpirationController$destroySession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    int label;

    public LiveCardAlarmExpirationController$destroySession$1(String r1, Continuation<? super LiveCardAlarmExpirationController$destroySession$1> r2) {
        this.$id = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LiveCardAlarmExpirationController$destroySession$1(this.$id, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r4);
        ConcurrentHashMap<String, LiveCardAlarmExpirationController.a> r5 = LiveCardAlarmExpirationController.c;
        LiveCardAlarmExpirationController.a r0 = r5.get(this.$id);
        if (r0 == null) goto L7;
        PendingIntent r1 = r0.e;
        android.app.AlarmManager r2 = LiveCardAlarmExpirationController.a.h();
        if (r2 == null) goto L11;
        r2.cancel(r1);
    L11:
        r1.cancel();
        if (r5.remove(this.$id, r0) == false) goto L14;
        LiveCardAlarmExpirationController.e();
    L14:
        IslandApi r6 = ILiveCard.Companion.getInst().getIslandService();
        if (r6 == null) goto L18;
        r6.destroySession(r0.a);
    L18:
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
