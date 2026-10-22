package com.larus.dora.obric.device_management.setting.g;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.activity.result.ActivityResultLauncher;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
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
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsFragment$checkReadyForReconnect$1", f = "DoraObricGSettingsFragment.kt", i = {}, l = {364}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricGSettingsFragment$checkReadyForReconnect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $mac;
    int label;
    final /* synthetic */ DoraObricGSettingsFragment this$0;

    public DoraObricGSettingsFragment$checkReadyForReconnect$1(DoraObricGSettingsFragment r1, String r2, Continuation<? super DoraObricGSettingsFragment$checkReadyForReconnect$1> r3) {
        this.this$0 = r1;
        this.$mac = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricGSettingsFragment$checkReadyForReconnect$1(this.this$0, this.$mac, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Activity r2 = null;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L11:
        int r16 = ((Number) r15).intValue();
        if (r16 != 0) goto L14;
        DoraObricGSettingsFragment r17 = this.this$0;
        String r4 = this.$mac;
        int r5 = DoraObricGSettingsFragment.m;
        r17.da0(r4);
    L63:
        return Unit.INSTANCE;
    L14:
        if (r16 == 1) goto L52;
        if (r16 == 2) goto L27;
        if (r16 == 3) goto L18;
        g49.d.e("DoraObricGSettingsFragment", "checkReadyForReconnect unknown ready=" + r16);
        DoraObricGSettingsFragment r18 = this.this$0;
        r18.h = null;
        r18.aa0().stopReconnect();
        goto L63
    L18:
        final DoraObricGSettingsFragment r110 = this.this$0;
        int r6 = DoraObricGSettingsFragment.m;
        Context r7 = r110.getContext();
        if (r7 != null) goto L21;
        g49.d.e("DoraObricGSettingsFragment", "showGpsDialogForReconnect skipped, context is null");
        r110.h = null;
        r110.aa0().stopReconnect();
        goto L63
    L21:
        r110.Y90();
        r110.h = null;
        r110.aa0().stopReconnect();
        com.obric.oui.dialog.v2.alert.g r8 = new com.obric.oui.dialog.v2.alert.g(r7);
        ((com.obric.oui.dialog.base.i) r8).c = false;
        r8.w = false;
        int r9 = j0.a;
        String r10 = j0.d(2131903986);
        r8.j = false;
        r8.h = r10;
        r8.i = j0.d(2131903985);
        com.obric.oui.dialog.v2.alert.g.c(r8);
        r8.e(j0.d(2131902465), new c(r110));
        r8.h(j0.d(2131902468), new d(r110));
        com.obric.oui.dialog.v2.alert.c r11 = r8.a();
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L65;
        DialogLancet.handleBlockedDialogShow(r11);
    L26:
        r110.k = r11;
        goto L63
    L65:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L64
    L25:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        goto L26
    L27:
        DoraObricGSettingsFragment r111 = this.this$0;
        int r12 = DoraObricGSettingsFragment.m;
        r111.getClass();
        g49.d.d("DoraObricGSettingsFragment", "requestEnableBluetoothForReconnect");
        Context r13 = r111.getContext();
        ActivityResultLauncher<Intent> r14 = r111.i;
        Intent r20 = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
        if (r13 == null) goto L35;
        if (r14 == null) goto L35;
        if (r20.resolveActivity(r13.getPackageManager()) != null) goto L34;
        g49.d.b("DoraObricGSettingsFragment", "launch android.bluetooth.adapter.action.REQUEST_ENABLE unavailable");
        DoraObricToastUtils.a(r13, 2131903984);
        r111.aa0().stopReconnect();
        goto L63
    L34:
        r14.launch(r20);
    L35:
        g49.d.b("DoraObricGSettingsFragment", "launch android.bluetooth.adapter.action.REQUEST_ENABLE unavailable");
        if (r13 == null) goto L39;
        Activity r21 = com.larus.utils.i.getActivity(r13);
        if (r21 == null) goto L39;
    L40:
        if (r21 != null) goto L42;
    L51:
        r111.aa0().stopReconnect();
        goto L63
    L42:
        if (r21.isFinishing() == false) goto L44;
    L47:
        if (r3 == true) goto L49;
        r2 = r21;
    L49:
        if (r2 == null) goto L51;
        DoraObricToastUtils.a(r2, 2131903984);
        goto L51
    L44:
        if (r21.isDestroyed() == true) goto L47;
        r3 = false;
    L39:
        r21 = AppHost.a.a().getCurrentActivity();
        goto L40
    L52:
        DoraObricGSettingsFragment r112 = this.this$0;
        String r22 = this.$mac;
        int r23 = DoraObricGSettingsFragment.m;
        r112.getClass();
        ArrayList r24 = new ArrayList();
        int r25 = Build.VERSION.SDK_INT;
        if (r25 < 31) goto L55;
        r24.add("android.permission.BLUETOOTH_SCAN");
        r24.add("android.permission.BLUETOOTH_CONNECT");
        r24.add("android.permission.BLUETOOTH");
    L56:
        g49.d.d("DoraObricGSettingsFragment", "requestBluetoothPermissionForReconnect");
        i2 r26 = i2.b;
        q r27 = new q(r112, r22);
        if (r25 < 31) goto L59;
        int r28 = j0.a;
        Map r30 = MapsKt.mapOf(TuplesKt.to("android.permission.BLUETOOTH_SCAN", j0.d(2131898388)));
    L60:
        g1.a.a(r112, r24, r27, r30, null, 16);
        goto L63
    L59:
        int r31 = j0.a;
        r30 = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.BLUETOOTH", j0.d(2131898388)), TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", j0.d(2131898388)), TuplesKt.to("android.permission.ACCESS_COARSE_LOCATION", j0.d(2131898388))});
        goto L60
    L55:
        r24.add("android.permission.BLUETOOTH");
        r24.add("android.permission.BLUETOOTH_ADMIN");
        r24.add("android.permission.ACCESS_FINE_LOCATION");
        r24.add("android.permission.ACCESS_COARSE_LOCATION");
        goto L56
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        CoroutineDispatcher r113 = Dispatchers.getIO();
        DoraObricGSettingsFragment$checkReadyForReconnect$1$ready$1 r32 = new DoraObricGSettingsFragment$checkReadyForReconnect$1$ready$1(null);
        this.label = 1;
        r15 = BuildersKt.withContext(r113, r32, this);
        if (r15 != r0) goto L11;
        return r0;
    }
}
