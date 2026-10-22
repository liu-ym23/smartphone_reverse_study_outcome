package com.larus.dora.obric.device_management.device_home;

import android.content.Intent;
import android.os.Build;
import androidx.activity.result.ActivityResultLauncher;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
@DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeFragment$checkReadyForReconnect$1", f = "DoraObricDeviceHomeFragment.kt", i = {}, l = {1273}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricDeviceHomeFragment$checkReadyForReconnect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceMac;
    int label;
    final /* synthetic */ DoraObricDeviceHomeFragment this$0;

    public DoraObricDeviceHomeFragment$checkReadyForReconnect$1(DoraObricDeviceHomeFragment r1, String r2, Continuation<? super DoraObricDeviceHomeFragment$checkReadyForReconnect$1> r3) {
        this.this$0 = r1;
        this.$deviceMac = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricDeviceHomeFragment$checkReadyForReconnect$1(this.this$0, this.$deviceMac, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        int r13 = ((Number) r12).intValue();
        if (r13 == 1) goto L22;
        if (r13 == 2) goto L15;
        DoraObricDeviceHomeFragment r14 = this.this$0;
        String r2 = this.$deviceMac;
        int r3 = DoraObricDeviceHomeFragment.R;
        r14.xa0(r2);
    L32:
        return Unit.INSTANCE;
    L15:
        DoraObricDeviceHomeFragment r15 = this.this$0;
        int r4 = DoraObricDeviceHomeFragment.R;
        r15.getClass();
        g49.d.d("DoraObricDeviceHomeFragment", "requestEnableBluetoothForReconnect");
        ActivityResultLauncher<Intent> r5 = r15.p;     // Catch: Throwable -> L20
        if (r5 == null) goto L32;
        r5.launch(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        g49.d.c("DoraObricDeviceHomeFragment", "launch android.bluetooth.adapter.action.REQUEST_ENABLE error", th);
        r15.Y90();
        r15.ia0().onReconnectFailed();
        goto L32
    L22:
        DoraObricDeviceHomeFragment r16 = this.this$0;
        int r6 = DoraObricDeviceHomeFragment.R;
        r16.getClass();
        ArrayList r7 = new ArrayList();
        int r8 = Build.VERSION.SDK_INT;
        if (r8 < 31) goto L25;
        r7.add("android.permission.BLUETOOTH_SCAN");
        r7.add("android.permission.BLUETOOTH_CONNECT");
        r7.add("android.permission.BLUETOOTH");
    L26:
        g49.d.d("DoraObricDeviceHomeFragment", "requestBluetoothPermissionForReconnect");
        com.larus.platform.service.i2 r9 = com.larus.platform.service.i2.b;
        i1 r10 = new i1(r16);
        if (r8 < 31) goto L29;
        int r11 = com.larus.utils.j0.a;
        Map r17 = MapsKt.mapOf(TuplesKt.to("android.permission.BLUETOOTH_SCAN", com.larus.utils.j0.d(2131902606)));
    L30:
        com.larus.platform.api.g1.a.a(r16, r7, r10, r17, null, 16);
        goto L32
    L29:
        int r18 = com.larus.utils.j0.a;
        r17 = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.BLUETOOTH", com.larus.utils.j0.d(2131902606)), TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", com.larus.utils.j0.d(2131898489)), TuplesKt.to("android.permission.ACCESS_COARSE_LOCATION", com.larus.utils.j0.d(2131898489))});
        goto L30
    L25:
        r7.add("android.permission.BLUETOOTH");
        r7.add("android.permission.BLUETOOTH_ADMIN");
        r7.add("android.permission.ACCESS_FINE_LOCATION");
        r7.add("android.permission.ACCESS_COARSE_LOCATION");
        goto L26
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r110 = Dispatchers.getIO();
        DoraObricDeviceHomeFragment$checkReadyForReconnect$1$ready$1 r20 = new DoraObricDeviceHomeFragment$checkReadyForReconnect$1$ready$1(null);
        this.label = 1;
        r12 = BuildersKt.withContext(r110, r20, this);
        if (r12 != r0) goto L11;
        return r0;
    }
}
