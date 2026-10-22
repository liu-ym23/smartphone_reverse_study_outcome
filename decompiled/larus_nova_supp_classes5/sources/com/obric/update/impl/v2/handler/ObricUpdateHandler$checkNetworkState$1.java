package com.obric.update.impl.v2.handler;

import com.larus.utils.logger.FLogger;
import com.obric.update.api.v2.ObricUpdateSettingDelegate;
import com.obric.update.impl.v2.m;
import com.ss.android.update.OnUpdateStatusChangedListener;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.update.impl.v2.handler.ObricUpdateHandler$checkNetworkState$1", f = "ObricUpdateHandler.kt", i = {}, l = {947}, m = "invokeSuspend", n = {}, s = {})
final class ObricUpdateHandler$checkNetworkState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OnUpdateStatusChangedListener $listener;
    int label;
    final /* synthetic */ ObricUpdateHandler this$0;

    public ObricUpdateHandler$checkNetworkState$1(ObricUpdateHandler r1, OnUpdateStatusChangedListener r2, Continuation<? super ObricUpdateHandler$checkNetworkState$1> r3) {
        this.this$0 = r1;
        this.$listener = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricUpdateHandler$checkNetworkState$1(this.this$0, this.$listener, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
    L11:
        m.d(this.this$0.d, "network_state", null, 6);
        this.this$0.a.d.getClass();
        boolean r3 = com.obric.update.impl.v2.gateway.c.b();
        this.this$0.a.d.getClass();
        boolean r4 = com.obric.update.impl.v2.gateway.c.a();
        if (r3 == this.this$0.h) goto L14;
    L17:
        FLogger r6 = FLogger.a;
        r6.i("ObricUpdateHandler", "checkNetworkState: isWifi changed from " + this.this$0.h + " to " + r3 + ", isNetworkAvailable changed from " + this.this$0.i + " to " + r4);
        this.this$0.h = r3;
        this.this$0.i = r4;
        this.this$0.a.f.getClass();
        if (ObricUpdateSettingDelegate.a.a() == true) goto L21;
        r6.i("ObricUpdateHandler", "checkNetworkState: wifi auto download disabled, ignore network change");
        this.this$0.d.c("network_state", "wifi_auto_download_disabled", null);
        return Unit.INSTANCE;
    L21:
        boolean r8 = this.this$0.b.c;
        boolean r9 = this.this$0.b.d;
        int r10 = this.this$0.c.b;
        boolean r11 = this.this$0.b.g;
        if (r4 == true) goto L25;
        r6.i("ObricUpdateHandler", "checkNetworkState: network unavailable, keep current download state. currentState=" + r10 + ",isWifiAutoPath=" + r8 + ",userInterfered=" + r9 + ",preInstalling=" + r11);
        this.this$0.d.c("network_state", "network_unavailable_keep_download", null);
        return Unit.INSTANCE;
    L25:
        if (r8 == false) goto L28;
        if (r9 == false) goto L28;
        boolean r5 = true;
    L30:
        if (r3 == false) goto L38;
        if (r5 == false) goto L34;
        r6.i("ObricUpdateHandler", "checkNetworkState: auto path frozen by user interference, ignore network->wifi");
        this.this$0.d.c("network_state", "auto_download_frozen_by_user", null);
        return Unit.INSTANCE;
    L34:
        if (r10 != 2) goto L37;
        r6.i("ObricUpdateHandler", "checkNetworkState: network changed to wifi but download still running");
        this.this$0.d.c("network_state", "download_still_running", null);
        return Unit.INSTANCE;
    L37:
        r6.i("ObricUpdateHandler", "checkNetworkState: network changed to wifi, check update");
        m.e(this.this$0.d, "network_state", "wifi check update", 4);
        this.this$0.i(true, "wifi_auto_download", this.$listener);
    L46:
        return Unit.INSTANCE;
    L38:
        r6.i("ObricUpdateHandler", "checkNetworkState: network changed to mobile, current state: " + r10 + ",isWifiAutoPath=" + r8 + ",userInterfered=" + r9 + ",preInstalling=" + r11);
        if (r10 != 2) goto L44;
        if (r8 == false) goto L44;
        if (r9 == true) goto L44;
        if (r11 == true) goto L44;
        r6.i("ObricUpdateHandler", "checkNetworkState: pause wifi-auto download due to mobile network");
        m.e(this.this$0.d, "network_state", "auto pause download", 4);
        this.this$0.o(true);
    L44:
        this.this$0.d.c("network_state", "no need to pause download", null);
    L28:
        r5 = false;
        goto L30
    L14:
        if (r4 != this.this$0.i) goto L17;
        FLogger.a.i("ObricUpdateHandler", "checkNetworkState: network state unchanged (isWifi=" + r3 + ",isNetworkAvailable=" + r4 + "), ignore");
        this.this$0.d.c("network_state", "network state unchanged", null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        this.label = 1;
        if (DelayKt.delay(500, this) != r1) goto L11;
        return r1;
    }
}
