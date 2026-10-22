package com.larus.dora.impl.device.manage.settings;

import android.content.Intent;
import android.os.Build;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.utils.j0;
import java.util.ArrayList;
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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsFragment$checkReady$1", f = "DoraDeviceSettingsFragment.kt", i = {0}, l = {812}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class DoraDeviceSettingsFragment$checkReady$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isReconnect;
    final /* synthetic */ String $mac;
    final /* synthetic */ Function0<Unit> $onReady;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DoraDeviceSettingsFragment this$0;

    public static final class a implements g1.c {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ DoraDeviceSettingsFragment c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Function0<Unit> e;

        public final void onSettingPageReturn() {
        }

        public final void onGoSettingsDialogShow() {
            g49.d.d("DoraDeviceSettingsFragment", "checkReady: permission onGoSettingsDialogShow");
            this.a.element = true;
        }

        public final void onGoSettingsDialogDismiss(boolean r3) {
            g49.d.d("DoraDeviceSettingsFragment", "checkReady: permission onGoSettingsDialogDismiss, " + r3);
            if (r3 == false) goto L5;
            return;
        L5:
            if (this.b == true) goto L11;
            FragmentActivity r4 = this.c.getActivity();
            if (r4 == null) goto L12;
            r4.finish();
            return;
        L12:
            return;
        }

        public final void onResult(boolean r12, List<String> r13, List<String> r14, boolean r15) {
            Intrinsics.checkNotNullParameter(r13, "grantedList");
            Intrinsics.checkNotNullParameter(r14, "deniedList");
            g49.d.d("DoraDeviceSettingsFragment", "checkReady: request permission, isGranted = " + r12);
            if (r12 == false) goto L5;
            DoraDeviceSettingsFragment r2 = this.c;
            boolean r1 = this.b;
            String r3 = this.d;
            Function0<Unit> r4 = this.e;
            int r16 = DoraDeviceSettingsFragment.w;
            r2.getClass();
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r2), null, null, new DoraDeviceSettingsFragment$checkReady$1(r1, r2, r3, r4, null), 3, null);
            return;
        L5:
            g49.d.d("DoraDeviceSettingsFragment", "checkReady: request permission failed, goSettingsDialogShown=" + this.a.element);
            if (this.a.element == false) goto L8;
            return;
        L8:
            if (this.b == true) goto L15;
            FragmentActivity r17 = this.c.getActivity();
            if (r17 == null) goto L16;
            r17.finish();
            return;
        L16:
            return;
        }

        public a(Ref.BooleanRef r1, boolean r2, DoraDeviceSettingsFragment r3, String r4, Function0<Unit> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public DoraDeviceSettingsFragment$checkReady$1(boolean r1, DoraDeviceSettingsFragment r2, String r3, Function0<Unit> r4, Continuation<? super DoraDeviceSettingsFragment$checkReady$1> r5) {
        this.$isReconnect = r1;
        this.this$0 = r2;
        this.$mac = r3;
        this.$onReady = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        DoraDeviceSettingsFragment$checkReady$1 r6 = new DoraDeviceSettingsFragment$checkReady$1(this.$isReconnect, this.this$0, this.$mac, this.$onReady, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r110) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        Unit r3 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        CoroutineScope r1 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r110);
        Object r4 = r110;
    L11:
        int r5 = ((Number) r4).intValue();
        if (r5 != 0) goto L14;
        g49.d.d("DoraDeviceSettingsFragment", "checkReady: ready ok, isReconnect=" + this.$isReconnect);
        Function0<Unit> r6 = this.$onReady;
        if (r6 == null) goto L44;
        r6.invoke();
    L44:
        return Unit.INSTANCE;
    L14:
        if (r5 == 1) goto L31;
        if (r5 != 2) goto L44;
        g49.d.d("DoraDeviceSettingsFragment", "checkReady: bluetooth is off, request open, isReconnect=" + this.$isReconnect);
        if (this.$isReconnect == false) goto L20;
        this.this$0.t = this.$mac;
    L20:
        DoraDeviceSettingsFragment r7 = this.this$0;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L26
        ActivityResultLauncher<Intent> r9 = r7.q;     // Catch: Throwable -> L26
        if (r9 == null) goto L24;
        r9.launch(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));     // Catch: Throwable -> L26
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L24:
        Object r10 = Result.constructor-impl(r3);     // Catch: Throwable -> L26
    L28:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L44;
        g49.d.c("DoraDeviceSettingsFragment", "launch android.bluetooth.adapter.action.REQUEST_ENABLE error", r11);
    L26:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L31:
        ArrayList r13 = new ArrayList();
        int r14 = Build.VERSION.SDK_INT;
        if (r14 < 31) goto L34;
        r13.add("android.permission.BLUETOOTH_SCAN");
        r13.add("android.permission.BLUETOOTH_CONNECT");
        r13.add("android.permission.BLUETOOTH");
    L35:
        g49.d.d("DoraDeviceSettingsFragment", "checkReady: request permission, isReconnect=" + this.$isReconnect);
        Ref.BooleanRef r15 = new Ref.BooleanRef();
        i2 r16 = i2.b;
        DoraDeviceSettingsFragment r17 = this.this$0;
        a r18 = new a(r15, this.$isReconnect, r17, this.$mac, this.$onReady);
        if (r14 < 31) goto L38;
        int r20 = j0.a;
        Map r21 = MapsKt.mapOf(TuplesKt.to("android.permission.BLUETOOTH_SCAN", j0.d(2131898388)));
    L39:
        g1.a.a(r17, r13, r18, r21, null, 16);
        goto L44
    L38:
        int r22 = j0.a;
        r21 = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.BLUETOOTH", j0.d(2131898388)), TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", j0.d(2131898388)), TuplesKt.to("android.permission.ACCESS_COARSE_LOCATION", j0.d(2131898388))});
        goto L39
    L34:
        r13.add("android.permission.BLUETOOTH");
        r13.add("android.permission.BLUETOOTH_ADMIN");
        r13.add("android.permission.ACCESS_FINE_LOCATION");
        r13.add("android.permission.ACCESS_COARSE_LOCATION");
        goto L35
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        CoroutineScope r23 = (CoroutineScope) this.L$0;
        CoroutineDispatcher r24 = Dispatchers.getIO();
        DoraDeviceSettingsFragment$checkReady$1$ready$1 r25 = new DoraDeviceSettingsFragment$checkReady$1$ready$1(null);
        this.L$0 = r23;
        this.label = 1;
        r4 = BuildersKt.withContext(r24, r25, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
