package com.larus.dora.impl.nl;

import android.app.Application;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.network.DoraNetworkApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.nl.DoraUserSettingsManager$updateNotificationBroadcastV3DeviceSetting$1", f = "DoraUserSettingsManager.kt", i = {}, l = {276}, m = "invokeSuspend", n = {}, s = {})
public final class DoraUserSettingsManager$updateNotificationBroadcastV3DeviceSetting$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ Object $value;
    int label;

    public DoraUserSettingsManager$updateNotificationBroadcastV3DeviceSetting$1(String r1, Object r2, Function0<Unit> r3, Continuation<? super DoraUserSettingsManager$updateNotificationBroadcastV3DeviceSetting$1> r4) {
        this.$key = r1;
        this.$value = r2;
        this.$onSuccess = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraUserSettingsManager$updateNotificationBroadcastV3DeviceSetting$1(this.$key, this.$value, this.$onSuccess, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
        Object r10 = ((Result) r9).unbox-impl();
    L22:
        String r2 = this.$key;
        Object r3 = this.$value;
        Function0<Unit> r4 = this.$onSuccess;
        if (Result.isSuccess-impl(r10) == true) goto L25;
    L30:
        String r5 = this.$key;
        Object r6 = this.$value;
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L34;
        g49.d.c("DoraUserSettingsManager", "updateNotificationBroadcastV3DeviceSetting failed, key=" + r5 + ", value=" + r6, r11);
        t19.s r12 = t19.s.a;
        Application r7 = AppHost.a.getApplication();
        r12.getClass();
        t19.s.b(r7, 2131908080, false);
    L34:
        return Unit.INSTANCE;
    L25:
        if (((Boolean) r10).booleanValue() == false) goto L30;
        g49.d.d("DoraUserSettingsManager", "updateNotificationBroadcastV3DeviceSetting success, key=" + r2 + ", value=" + r3);
        if (r4 == null) goto L29;
        r4.invoke();
    L29:
        DoraUserSettingsManager r8 = DoraUserSettingsManager.a;
        DoraUserSettingsManager.i("updateNotificationBroadcastV3DeviceSetting");
        goto L30
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        DoraDevice r13 = DoraAdapterExtKt.h(kj4.a.g());
        if (r13 == null) goto L35;
        String r14 = r13.sn;
        if (r14 != null) goto L13;
    L16:
        boolean r15 = true;
    L17:
        if (r15 == true) goto L35;
        DoraNetworkApi r16 = DoraNetworkApi.a;
        JSONObject r17 = new JSONObject();
        r17.put(this.$key, this.$value);
        Unit r18 = Unit.INSTANCE;
        this.label = 1;
        r10 = r16.A(r13, r17, this);
        if (r10 != r0) goto L22;
        return r0;
    L13:
        if (r14.length() == 0) goto L16;
        r15 = false;
    L35:
        g49.d.b("DoraUserSettingsManager", "updateNotificationBroadcastV3DeviceSetting failed, device is null or sn is empty");
        return Unit.INSTANCE;
    }
}
