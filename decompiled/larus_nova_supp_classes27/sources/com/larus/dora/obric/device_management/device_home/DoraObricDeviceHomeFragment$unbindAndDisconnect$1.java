package com.larus.dora.obric.device_management.device_home;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.device.DoraDevice;
import java.util.concurrent.CancellationException;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeFragment$unbindAndDisconnect$1", f = "DoraObricDeviceHomeFragment.kt", i = {}, l = {1240}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricDeviceHomeFragment$unbindAndDisconnect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    int label;
    final /* synthetic */ DoraObricDeviceHomeFragment this$0;

    public DoraObricDeviceHomeFragment$unbindAndDisconnect$1(DoraObricDeviceHomeFragment r1, DoraDevice r2, Continuation<? super DoraObricDeviceHomeFragment$unbindAndDisconnect$1> r3) {
        this.this$0 = r1;
        this.$device = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricDeviceHomeFragment$unbindAndDisconnect$1(this.this$0, this.$device, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L7
    L15:
        boolean r9 = ((Boolean) r8).booleanValue();     // Catch: Throwable -> L7
    L20:
        g49.d.d("DoraObricDeviceHomeFragment", "unbindAndDisconnect cleanup completed success=" + r9);
        Intent r10 = new Intent("action.DEVICE_UNBIND");
        DoraObricDeviceHomeFragment r3 = this.this$0;
        DoraDevice r4 = this.$device;
        int r5 = DoraObricDeviceHomeFragment.R;
        r10.setPackage(r3.fa0().getPackageName());
        String r6 = r4.mac;
        if (r6 != null) goto L23;
    L24:
        r2 = true;
    L25:
        if (r2 == true) goto L27;
        r10.putExtra("mac", r4.mac);
    L27:
        LocalBroadcastManager.getInstance(this.this$0.fa0()).sendBroadcast(r10);
        return Unit.INSTANCE;
    L23:
        if (r6.length() != 0) goto L25;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r11 = Dispatchers.getIO();     // Catch: Throwable -> L7
        DoraObricDeviceHomeFragment$unbindAndDisconnect$1$cleanupSuccess$1 r7 = new DoraObricDeviceHomeFragment$unbindAndDisconnect$1$cleanupSuccess$1(this.$device, null);     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r8 = BuildersKt.withContext(r11, r7, this);     // Catch: Throwable -> L7
        if (r8 != r0) goto L15;
        return r0;
    L7:
        th = move-exception;
        if ((th instanceof CancellationException) == true) goto L29;
        g49.d.c("DoraObricDeviceHomeFragment", "unbindAndDisconnect cleanup failed", th);
        r9 = false;
        goto L20
    L29:
        throw th;
    }
}
