package com.obric.miniapp.alarm;

import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.obric.miniapp.alarm.LiveCardAlarmExpirationController$handleExpireAlarm$1", f = "LiveCardAlarmExpirationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LiveCardAlarmExpirationController$handleExpireAlarm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $expireAtMs;
    final /* synthetic */ String $id;
    final /* synthetic */ long $taskId;
    int label;

    public LiveCardAlarmExpirationController$handleExpireAlarm$1(String r1, long r2, long r4, Continuation<? super LiveCardAlarmExpirationController$handleExpireAlarm$1> r6) {
        this.$id = r1;
        this.$taskId = r2;
        this.$expireAtMs = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new LiveCardAlarmExpirationController$handleExpireAlarm$1(this.$id, this.$taskId, this.$expireAtMs, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r11);
        FLogger r12 = FLogger.a;
        r12.i("LiveCardAlarmExpirationController", "handleExpireAlarm start id=" + this.$id + ", taskId=" + this.$taskId + ", expireAtMs=" + this.$expireAtMs);
        ConcurrentHashMap<String, LiveCardAlarmExpirationController.a> r0 = LiveCardAlarmExpirationController.c;
        LiveCardAlarmExpirationController.a r4 = r0.get(this.$id);
        if (r4 != null) goto L9;
        return Unit.INSTANCE;
    L9:
        if (LiveCardAlarmExpirationController.c(r4.a) == this.$taskId) goto L12;
        r12.i("LiveCardAlarmExpirationController", "handleExpireAlarm ignore id=" + this.$id + ", recordTaskId=" + LiveCardAlarmExpirationController.c(r4.a) + ", alarmTaskId=" + this.$taskId);
        return Unit.INSTANCE;
    L12:
        r0.remove(this.$id, r4);
        LiveCardAlarmExpirationController.e();
        r12.i("LiveCardAlarmExpirationController", "handleExpireAlarm destroySession id=" + this.$id + ", taskId=" + this.$taskId + ", createAtMs=" + r4.c + ", durationMs=" + r4.d + ", expireAtMs=" + this.$expireAtMs);
        IslandApi r13 = ILiveCard.Companion.getInst().getIslandService();
        if (r13 == null) goto L16;
        r13.destroySession(r4.a);
    L16:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
