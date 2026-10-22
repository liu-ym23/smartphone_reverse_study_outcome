package com.obric.miniapp.alarm;

import android.app.Application;
import android.app.PendingIntent;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.island.IslandApi;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.LiveCardAlarmExpirationController$addSession$1", f = "LiveCardAlarmExpirationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LiveCardAlarmExpirationController$addSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $durationMs;
    final /* synthetic */ Long $eventId;
    final /* synthetic */ String $id;
    final /* synthetic */ IslandSession $session;
    int label;

    public LiveCardAlarmExpirationController$addSession$1(String r1, Long r2, IslandSession r3, Long r4, Continuation<? super LiveCardAlarmExpirationController$addSession$1> r5) {
        this.$id = r1;
        this.$durationMs = r2;
        this.$session = r3;
        this.$eventId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new LiveCardAlarmExpirationController$addSession$1(this.$id, this.$durationMs, this.$session, this.$eventId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L52;
        ResultKt.throwOnFailure(r19);
        FLogger r1 = FLogger.a;
        r1.i("LiveCardAlarmExpirationController", "addSession id=" + this.$id + ", durationMs=" + this.$durationMs);
        ConcurrentHashMap<String, LiveCardAlarmExpirationController.a> r2 = LiveCardAlarmExpirationController.c;
        LiveCardAlarmExpirationController.a r4 = r2.get(this.$id);
        long r8 = System.currentTimeMillis();
        Long r5 = this.$durationMs;
        if (r5 != null) goto L7;
    L15:
        long r10 = 900000;
    L16:
        long r12 = r8 + r10;
        if (r4 == null) goto L25;
        PendingIntent r6 = r4.e;
        if (r6 == null) goto L25;
        r1.i("LiveCardAlarmExpirationController", "addSession cancelOldAlarm id=" + this.$id + ", oldTaskId=" + LiveCardAlarmExpirationController.c(r4.a));
        android.app.AlarmManager r3 = LiveCardAlarmExpirationController.a.h();
        if (r3 == null) goto L23;
        r3.cancel(r6);
    L23:
        r6.cancel();
    L25:
        LiveCardAlarmExpirationController r7 = LiveCardAlarmExpirationController.a;
        Application r9 = LiveCardAlarmExpirationController.a();
        if (r9 == null) goto L30;
        IslandSession r11 = this.$session;
        IslandApi r13 = ILiveCard.Companion.getInst().getIslandService();
        if (r13 == null) goto L30;
        Boxing.boxBoolean(r13.createSession(r11, r9));
    L30:
        IslandSession r14 = this.$session;
        JsonObject r15 = r14.getExt();
        if (r15 != null) goto L33;
        r15 = new JsonObject();
    L33:
        r15.addProperty("timestamp", Long.valueOf(r8));
        r14.setExt(r15);
        PendingIntent r16 = LiveCardAlarmExpirationController.b(this.$id, LiveCardAlarmExpirationController.c(this.$session), r12);
        android.app.AlarmManager r17 = r7.h();
        if (r17 == null) goto L36;
        r17.setExact(0, r12, r16);
    L36:
        String r18 = this.$id;
        IslandSession r20 = this.$session;
        Long r21 = this.$eventId;
        if (r21 != null) goto L39;
    L41:
        Long r22 = null;
    L42:
        r2.put(r18, new LiveCardAlarmExpirationController.a(r20, r22, r8, r10, r16));
        LiveCardAlarmExpirationController.e();
        if (r4 == null) goto L50;
        IslandSession r23 = r4.a;
        if (r23 == null) goto L50;
        IslandApi r24 = ILiveCard.Companion.getInst().getIslandService();
        if (r24 == null) goto L50;
        r24.destroySession(r23);
    L50:
        return Unit.INSTANCE;
    L39:
        if (LiveCardAlarmExpirationController.f(LiveCardAlarmExpirationController.a(), Boxing.boxLong(r21.longValue())) == false) goto L41;
        r22 = r21;
        goto L42
    L7:
        if (r5.longValue() <= 0) goto L9;
        boolean r110 = true;
    L10:
        if (r110 == true) goto L13;
        r5 = null;
    L13:
        if (r5 == null) goto L15;
        r10 = r5.longValue();
        goto L16
    L9:
        r110 = false;
        goto L10
    L52:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
