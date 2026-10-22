package com.larus.dora.impl.device.manage;

import android.content.Intent;
import android.os.Build;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.manage.DoraGDeviceManagementFragment$checkReadyForReconnect$1", f = "DoraGDeviceManagementFragment.kt", i = {0}, l = {721}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class DoraGDeviceManagementFragment$checkReadyForReconnect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DoraGDeviceManagementFragment this$0;

    public static final class a implements g1.c {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ DoraGDeviceManagementFragment b;

        public final void onSettingPageReturn() {
        }

        public final void onGoSettingsDialogShow() {
            g49.d.d("DoraGDeviceManagementFragment", "checkReadyForReconnect: permission onGoSettingsDialogShow");
            this.a.element = true;
        }

        public final void onGoSettingsDialogDismiss(boolean r3) {
            g49.d.d("DoraGDeviceManagementFragment", "checkReadyForReconnect: permission onGoSettingsDialogDismiss, " + r3);
            if (r3 == true) goto L8;
            FragmentActivity r4 = this.b.getActivity();
            if (r4 == null) goto L9;
            r4.finish();
            return;
        L9:
            return;
        }

        public a(Ref.BooleanRef r1, DoraGDeviceManagementFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "grantedList");
            Intrinsics.checkNotNullParameter(r3, "deniedList");
            g49.d.d("DoraGDeviceManagementFragment", "checkReadyForReconnect: request permission, isGranted = " + r1);
            if (r1 == false) goto L5;
            DoraGDeviceManagementFragment r5 = this.b;
            int r6 = DoraGDeviceManagementFragment.q;
            r5.ca0();
            return;
        L5:
            g49.d.d("DoraGDeviceManagementFragment", "checkReadyForReconnect: request permission failed");
            DoraGDeviceManagementAdapter r7 = this.b.j;
            if (r7 == null) goto L9;
            r7.z2();
        L9:
            if (this.a.element == true) goto L15;
            FragmentActivity r8 = this.b.getActivity();
            if (r8 == null) goto L16;
            r8.finish();
            return;
        L16:
            return;
        }
    }

    public DoraGDeviceManagementFragment$checkReadyForReconnect$1(DoraGDeviceManagementFragment r1, Continuation<? super DoraGDeviceManagementFragment$checkReadyForReconnect$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DoraGDeviceManagementFragment$checkReadyForReconnect$1 r0 = new DoraGDeviceManagementFragment$checkReadyForReconnect$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
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
        Unit r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
    L11:
        int r13 = ((Number) r12).intValue();
        if (r13 == 1) goto L29;
        if (r13 == 2) goto L15;
        g49.d.d("DoraGDeviceManagementFragment", "checkReadyForReconnect: ready, start reconnect");
        DoraGDeviceManagementFragment r14 = this.this$0;
        int r4 = DoraGDeviceManagementFragment.q;
        r14.ca0();
    L39:
        return Unit.INSTANCE;
    L15:
        g49.d.d("DoraGDeviceManagementFragment", "checkReadyForReconnect: bluetooth is off, request open");
        DoraGDeviceManagementFragment r15 = this.this$0;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L21
        ActivityResultLauncher<Intent> r16 = r15.k;     // Catch: Throwable -> L21
        if (r16 == null) goto L19;
        r16.launch(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));     // Catch: Throwable -> L21
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L19:
        Object r17 = Result.constructor-impl(r2);     // Catch: Throwable -> L21
    L23:
        DoraGDeviceManagementFragment r6 = this.this$0;
        Throwable r7 = Result.exceptionOrNull-impl(r17);
        if (r7 == null) goto L28;
        g49.d.c("DoraGDeviceManagementFragment", "launch android.bluetooth.adapter.action.REQUEST_ENABLE error", r7);
        DoraGDeviceManagementAdapter r8 = r6.j;
        if (r8 == null) goto L28;
        r8.z2();
    L28:
        Result.box-impl(r17);
    L21:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L29:
        ArrayList r10 = new ArrayList();
        int r18 = Build.VERSION.SDK_INT;
        if (r18 < 31) goto L32;
        r10.add("android.permission.BLUETOOTH_SCAN");
        r10.add("android.permission.BLUETOOTH_CONNECT");
        r10.add("android.permission.BLUETOOTH");
    L33:
        g49.d.d("DoraGDeviceManagementFragment", "checkReadyForReconnect: request permission");
        Ref.BooleanRef r11 = new Ref.BooleanRef();
        i2 r20 = i2.b;
        DoraGDeviceManagementFragment r21 = this.this$0;
        a r110 = new a(r11, r21);
        if (r18 < 31) goto L36;
        int r111 = com.larus.utils.j0.a;
        Map r112 = MapsKt.mapOf(TuplesKt.to("android.permission.BLUETOOTH_SCAN", com.larus.utils.j0.d(2131898388)));
    L37:
        g1.a.a(r21, r10, r110, r112, null, 16);
        goto L39
    L36:
        int r22 = com.larus.utils.j0.a;
        r112 = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.BLUETOOTH", com.larus.utils.j0.d(2131898388)), TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", com.larus.utils.j0.d(2131898388)), TuplesKt.to("android.permission.ACCESS_COARSE_LOCATION", com.larus.utils.j0.d(2131898388))});
        goto L37
    L32:
        r10.add("android.permission.BLUETOOTH");
        r10.add("android.permission.BLUETOOTH_ADMIN");
        r10.add("android.permission.ACCESS_FINE_LOCATION");
        r10.add("android.permission.ACCESS_COARSE_LOCATION");
        goto L33
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r113 = (CoroutineScope) this.L$0;
        CoroutineDispatcher r23 = Dispatchers.getIO();
        DoraGDeviceManagementFragment$checkReadyForReconnect$1$ready$1 r24 = new DoraGDeviceManagementFragment$checkReadyForReconnect$1$ready$1(null);
        this.L$0 = r113;
        this.label = 1;
        r12 = BuildersKt.withContext(r23, r24, this);
        if (r12 != r0) goto L11;
        return r0;
    }
}
