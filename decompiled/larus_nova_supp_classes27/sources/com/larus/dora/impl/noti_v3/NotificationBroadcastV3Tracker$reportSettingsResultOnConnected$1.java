package com.larus.dora.impl.noti_v3;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import g49.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.noti_v3.NotificationBroadcastV3Tracker$reportSettingsResultOnConnected$1", f = "NotificationBroadcastV3Tracker.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
public final class NotificationBroadcastV3Tracker$reportSettingsResultOnConnected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;

    public NotificationBroadcastV3Tracker$reportSettingsResultOnConnected$1(Continuation<? super NotificationBroadcastV3Tracker$reportSettingsResultOnConnected$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new NotificationBroadcastV3Tracker$reportSettingsResultOnConnected$1(r2);
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
        String r2 = (String) this.L$1;
        DoraBuryPointManager r3 = (DoraBuryPointManager) this.L$0;
        ResultKt.throwOnFailure(r6);
    L23:
        r3.L(r2, (Map) r6);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        DoraDevice r7 = DoraAdapterExtKt.h(kj4.a.g());
        if (r7 == null) goto L25;
        String r4 = r7.getSerialNumber();
        if (r4 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L25;
        r3 = DoraBuryPointManager.a;
        NotificationBroadcastV3Tracker r8 = NotificationBroadcastV3Tracker.a;
        this.L$0 = r3;
        this.L$1 = "dora_broadcast_settings_result";
        this.label = 1;
        r6 = NotificationBroadcastV3Tracker.a(r8, r7, this);
        if (r6 != r0) goto L22;
        return r0;
    L22:
        r2 = "dora_broadcast_settings_result";
        goto L23
    L13:
        if (r4.length() == 0) goto L16;
        r5 = false;
    L25:
        d.b("NotificationBroadcastV3Tracker", "reportSettingsResultOnConnected skipped, device is null or serialNumber is empty");
        return Unit.INSTANCE;
    }
}
