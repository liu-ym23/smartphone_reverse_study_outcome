package com.larus.push.impl.reminder;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.network.http.f;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.push.impl.reminder.OpenPushReminder$fetchOpenPushReminderConfig$1", f = "OpenPushReminder.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
public final class OpenPushReminder$fetchOpenPushReminderConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $scene;
    int label;

    public OpenPushReminder$fetchOpenPushReminderConfig$1(String r1, Continuation<? super OpenPushReminder$fetchOpenPushReminderConfig$1> r2) {
        this.$scene = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OpenPushReminder$fetchOpenPushReminderConfig$1(this.$scene, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L15:
        y r14 = (com.larus.network.http.a) r13;
        if ((r14 instanceof y) == false) goto L19;
        OpenPushReminderConfig r15 = (OpenPushReminderConfig) ((com.larus.network.http.a) r14).b;
        OpenPushReminder.b = r15;
        FLogger.a.i("OpenPushReminder", "fetchOpenPushReminderConfig[" + this.$scene + "] success, newConfig = " + r15);
    L23:
        return Unit.INSTANCE;
    L19:
        if ((r14 instanceof f) == false) goto L21;
        FLogger.a.e("OpenPushReminder", "fetchOpenPushReminderConfig[" + this.$scene + "] failed, error = " + ((f) r14).d.getMessage());
        goto L23
    L21:
        FLogger.a.e("OpenPushReminder", "fetchOpenPushReminderConfig[" + this.$scene + "] failed, unknown reason, async = " + r14);
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        FlowDowngradeServiceDelegate r2 = FlowDowngradeServiceDelegate.INSTANCE;
        if (Intrinsics.areEqual(this.$scene, "login") == false) goto L11;
        String r5 = DowngradeSource.AFTER_LAUNCH.getValue();
    L12:
        Map r10 = MapsKt.mapOf(TuplesKt.to("source", r5));
        this.label = 1;
        r13 = r2.requestGet("Basic", OpenPushReminderConfig.class, "/alice/notify/get_scene_info", null, null, false, null, null, r10, this);
        if (r13 != r0) goto L15;
        return r0;
    L11:
        r5 = DowngradeSource.COLD_LAUNCH.getValue();
        goto L12
    }
}
