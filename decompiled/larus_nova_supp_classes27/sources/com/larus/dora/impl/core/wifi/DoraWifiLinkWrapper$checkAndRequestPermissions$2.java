package com.larus.dora.impl.core.wifi;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.utils.j0;
import g49.d;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import x39.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/api/core/wifi/DoraWifiConnectResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper$checkAndRequestPermissions$2", f = "DoraWifiLinkWrapper.kt", i = {0}, l = {786}, m = "invokeSuspend", n = {"activity"}, s = {"L$0"})
final class DoraWifiLinkWrapper$checkAndRequestPermissions$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b>, Object> {
    final /* synthetic */ List<String> $permissions;
    Object L$0;
    Object L$1;
    int label;

    public static final class a implements g1.c {
        public final /* synthetic */ i<b> a;

        public final void onSettingPageReturn() {
        }

        public final void onGoSettingsDialogShow() {
            d.d("DoraWifiLinkWrapper", "checkAndRequestPermissions: permission onGoSettingsDialogShow");
        }

        public a(j r1) {
            this.a = r1;
        }

        public final void onGoSettingsDialogDismiss(boolean r3) {
            d.d("DoraWifiLinkWrapper", "checkAndRequestPermissions: permission onGoSettingsDialogDismiss, " + r3);
        }

        public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "grantedList");
            Intrinsics.checkNotNullParameter(r3, "deniedList");
            d.d("DoraWifiLinkWrapper", "checkAndRequestPermissions: onResult allGranted=" + r1 + ", deniedList=" + r3);
            if (this.a.isActive() == false) goto L27;
            if (r1 == false) goto L11;
            this.a.resumeWith(Result.constructor-impl(null));     // Catch: Throwable -> L8
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return;
        L11:
            if (r3.contains("android.permission.NEARBY_WIFI_DEVICES") == false) goto L14;
            Object r6 = b.e.b;
        L23:
            this.a.resumeWith(Result.constructor-impl(r6));     // Catch: Throwable -> L20
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return;
        L14:
            if (r3.contains("android.permission.ACCESS_FINE_LOCATION") == false) goto L16;
            r6 = b.d.b;
            goto L23
        L16:
            r6 = new b.a("Permission denied: " + r3);
            goto L23
        }
    }

    public DoraWifiLinkWrapper$checkAndRequestPermissions$2(List<String> r1, Continuation<? super DoraWifiLinkWrapper$checkAndRequestPermissions$2> r2) {
        this.$permissions = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraWifiLinkWrapper$checkAndRequestPermissions$2(this.$permissions, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        List r2 = (List) this.L$1;
        FragmentActivity r3 = (FragmentActivity) this.L$0;
        ResultKt.throwOnFailure(r11);
    L28:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        FragmentActivity r12 = AppHost.a.a().getTopActivity();
        if ((r12 instanceof FragmentActivity) == false) goto L11;
        FragmentActivity r13 = r12;
    L12:
        FragmentActivity r4 = r13;
        if (r4 != null) goto L15;
    L29:
        d.b("DoraWifiLinkWrapper", "checkAndRequestPermissions: activity is null or invalid");
        return new b.a("Activity is invalid");
    L15:
        if (r4.isFinishing() == true) goto L29;
        if (r4.isDestroyed() == true) goto L29;
        List<String> r5 = this.$permissions;
        this.L$0 = r4;
        this.L$1 = r5;
        this.label = 1;
        j r14 = new j(IntrinsicsKt.intercepted(this), 1);
        r14.C();
        i2 r6 = i2.b;
        a r7 = new a(r14);
        if (Build.VERSION.SDK_INT < 33) goto L22;
        int r8 = j0.a;
        Map r9 = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.NEARBY_WIFI_DEVICES", j0.d(2131902882)), TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", j0.d(2131902881))});
    L23:
        g1.a.b(r4, r5, r7, r9, null, 48);
        r11 = r14.B();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(this);
    L26:
        if (r11 != r0) goto L28;
        return r0;
    L22:
        int r10 = j0.a;
        r9 = MapsKt.mapOf(TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", j0.d(2131902881)));
        goto L23
    L11:
        r13 = null;
        goto L12
    }
}
