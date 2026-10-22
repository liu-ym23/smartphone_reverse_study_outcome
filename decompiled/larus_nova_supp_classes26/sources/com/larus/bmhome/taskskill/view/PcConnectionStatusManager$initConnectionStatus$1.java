package com.larus.bmhome.taskskill.view;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.utils.e0;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.view.PcConnectionStatusManager$initConnectionStatus$1", f = "PcConnectionStatusManager.kt", i = {}, l = {275, 281}, m = "invokeSuspend", n = {}, s = {})
final class PcConnectionStatusManager$initConnectionStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $expectedGeneration;
    int label;
    final /* synthetic */ PcConnectionStatusManager this$0;

    public PcConnectionStatusManager$initConnectionStatus$1(PcConnectionStatusManager r1, long r2, Continuation<? super PcConnectionStatusManager$initConnectionStatus$1> r4) {
        this.this$0 = r1;
        this.$expectedGeneration = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new PcConnectionStatusManager$initConnectionStatus$1(this.this$0, this.$expectedGeneration, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [androidx.lifecycle.Observer, com.larus.bmhome.taskskill.view.f] */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L22:
        AllDeviceResponse r12 = (AllDeviceResponse) r11;
        PcConnectionStatusManager r2 = this.this$0;
        if (r2.g != this.$expectedGeneration) goto L25;
        r2.d(r12, true);
    L35:
        return Unit.INSTANCE;
    L25:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L13:
        AllDeviceResponse r13 = (AllDeviceResponse) r11;
        PcConnectionStatusManager r3 = this.this$0;
        if (r3.g != this.$expectedGeneration) goto L16;
        r3.d(r13, false);
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == false) goto L27;
        FLogger.a.i("PcConnectionStatusManager", "[initConnectionStatus] isNetworkAvailable");
        GetAllDevicesRepo r14 = GetAllDevicesRepo.a;
        this.label = 2;
        r11 = GetAllDevicesRepo.e("initConnectionStatus", this);
        if (r11 != r0) goto L22;
        return r0;
    L27:
        FLogger r4 = FLogger.a;
        r4.i("PcConnectionStatusManager", "[initConnectionStatus] isNetworkAvailable, observeNetworkThenRequest");
        if (r13 != null) goto L30;
        this.this$0.d(null, true);
    L30:
        final PcConnectionStatusManager r15 = this.this$0;
        if (r15.i != null) goto L35;
        ?? r5 = new f(r15);
        r4.i("PcConnectionStatusManager", "[observeNetworkThenRequest] start");
        r15.i = r5;
        e0.c.observe(r15.a, r5);
        goto L35
    L16:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r11);
        CoroutineDispatcher r16 = Dispatchers.getIO();
        PcConnectionStatusManager$initConnectionStatus$1$cachedDevicesInfo$1 r6 = new PcConnectionStatusManager$initConnectionStatus$1$cachedDevicesInfo$1(null);
        this.label = 1;
        r11 = BuildersKt.withContext(r16, r6, this);
        if (r11 != r0) goto L13;
        return r0;
    }
}
