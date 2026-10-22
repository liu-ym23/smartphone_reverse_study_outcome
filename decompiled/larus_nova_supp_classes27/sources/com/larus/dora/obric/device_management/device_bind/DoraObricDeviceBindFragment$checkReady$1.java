package com.larus.dora.obric.device_management.device_bind;

import android.content.Intent;
import android.os.Build;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.List;
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
@DebugMetadata(c = "com.larus.dora.obric.device_management.device_bind.DoraObricDeviceBindFragment$checkReady$1", f = "DoraObricDeviceBindFragment.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricDeviceBindFragment$checkReady$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $doNext;
    final /* synthetic */ String $from;
    int label;
    final /* synthetic */ DoraObricDeviceBindFragment this$0;

    public static final class a implements g1.c {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ DoraObricDeviceBindFragment b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Function0<Unit> d;

        public final void onSettingPageReturn() {
        }

        public final void onGoSettingsDialogShow() {
            g49.d.d("DoraObricDeviceBindFragment", "checkReady: permission onGoSettingsDialogShow");
            this.a.element = true;
        }

        public final void onGoSettingsDialogDismiss(boolean r4) {
            DoraBuryPointManager.a.G(false, this.b.m);
            g49.d.d("DoraObricDeviceBindFragment", "checkReady: permission onGoSettingsDialogDismiss, " + r4);
            if (r4 == true) goto L6;
            this.b.X90("go settings dialog dismiss without confirm");
            return;
        }

        public a(Ref.BooleanRef r1, DoraObricDeviceBindFragment r2, String r3, Function0<Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "grantedList");
            Intrinsics.checkNotNullParameter(r4, "deniedList");
            if (r5 == true) goto L5;
            DoraBuryPointManager.a.G(r2, this.b.m);
        L5:
            g49.d.d("DoraObricDeviceBindFragment", "checkReady: " + this.c + " request permission, isGranted = " + r2);
            if (r2 == false) goto L8;
            DoraObricDeviceBindFragment r6 = this.b;
            Function0<Unit> r7 = this.d;
            int[] r8 = DoraObricDeviceBindFragment.o;
            r6.W90("check_from_permission_granted", r7);
            return;
        L8:
            this.b.f = false;
            g49.d.d("DoraObricDeviceBindFragment", "checkReady: request permission failed, goSettingsDialogShown=" + this.a.element);
            if (this.a.element == true) goto L13;
            this.b.X90("cancel go settings dialog");
            return;
        }
    }

    public static final class b implements p0 {
        public final /* synthetic */ DoraObricDeviceBindFragment a;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            Intent r0 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");     // Catch: Throwable -> L4
            r0.addFlags(268435456);     // Catch: Throwable -> L4
            this.a.startActivity(r0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            g49.d.c("DoraObricDeviceBindFragment", "start android.settings.LOCATION_SOURCE_SETTINGS error", th);
        }

        public b(DoraObricDeviceBindFragment r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.u {
        public final /* synthetic */ DoraObricDeviceBindFragment a;

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            DoraObricDeviceBindFragment r0 = this.a;
            int[] r1 = DoraObricDeviceBindFragment.o;
            r0.X90("cancel request location dialog");
        }

        public c(DoraObricDeviceBindFragment r1) {
            this.a = r1;
        }
    }

    public DoraObricDeviceBindFragment$checkReady$1(String r1, Function0<Unit> r2, DoraObricDeviceBindFragment r3, Continuation<? super DoraObricDeviceBindFragment$checkReady$1> r4) {
        this.$from = r1;
        this.$doNext = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraObricDeviceBindFragment$checkReady$1(this.$from, this.$doNext, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_dora_obric_device_management_device_bind_DoraObricDeviceBindFragment$checkReady$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(CommonDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final Object invokeSuspend(Object r17) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
        Object r3 = r17;
    L11:
        int r1 = ((Number) r3).intValue();
        if (r1 != 0) goto L14;
        g49.d.d("DoraObricDeviceBindFragment", "checkReady: " + this.$from + " ready ok");
        this.$doNext.invoke();
        this.this$0.f = false;
    L55:
        return Unit.INSTANCE;
    L14:
        if (r1 == 1) goto L36;
        if (r1 == 2) goto L29;
        if (r1 != 3) goto L55;
        g49.d.d("DoraObricDeviceBindFragment", "checkReady: " + this.$from + " request open gps switch");
        CommonDialog r4 = this.this$0.i;
        if (r4 == null) goto L21;
        INVOKEVIRTUAL_com_larus_dora_obric_device_management_device_bind_DoraObricDeviceBindFragment$checkReady$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r4);
    L21:
        DoraObricDeviceBindFragment r5 = this.this$0;
        r5.i = null;
        CommonDialog.a r6 = new CommonDialog.a();     // Catch: IllegalStateException -> L26
        int r7 = j0.a;     // Catch: IllegalStateException -> L26
        r6.i(j0.d(2131903986));     // Catch: IllegalStateException -> L26
        r6.g(j0.d(2131903985));     // Catch: IllegalStateException -> L26
        CommonDialog.a.f(r6, new b(this.this$0), j0.d(2131902468), false, 12);     // Catch: IllegalStateException -> L26
        CommonDialog.a.e(r6, new c(this.this$0), j0.d(2131902465), 4);     // Catch: IllegalStateException -> L26
        r5.i = r6.a();     // Catch: IllegalStateException -> L26
        DoraObricDeviceBindFragment r8 = this.this$0;     // Catch: IllegalStateException -> L26
        CommonDialog r9 = r8.i;     // Catch: IllegalStateException -> L26
        if (r9 == null) goto L28;
        INVOKEVIRTUAL_com_larus_dora_obric_device_management_device_bind_DoraObricDeviceBindFragment$checkReady$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r9, r8.getChildFragmentManager(), null);     // Catch: IllegalStateException -> L26
    L28:
        this.this$0.f = false;
    L26:
        e = move-exception;
        g49.d.c("DoraObricDeviceBindFragment", "checkReady show loc dialog exception", e);
        goto L28
    L29:
        g49.d.d("DoraObricDeviceBindFragment", "checkReady: " + this.$from + " request open bluetooth switch");
        DoraObricDeviceBindFragment r10 = this.this$0;
        r10.j = this.$doNext;
        ActivityResultLauncher<Intent> r11 = r10.k;     // Catch: Throwable -> L34
        if (r11 == null) goto L55;
        r11.launch(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        g49.d.c("DoraObricDeviceBindFragment", "launch android.bluetooth.adapter.action.REQUEST_ENABLE error", th);
        goto L55
    L36:
        ArrayList r12 = new ArrayList();
        int r13 = Build.VERSION.SDK_INT;
        if (r13 < 31) goto L39;
        r12.add("android.permission.BLUETOOTH_SCAN");
        r12.add("android.permission.BLUETOOTH_CONNECT");
        r12.add("android.permission.BLUETOOTH");
    L40:
        g49.d.d("DoraObricDeviceBindFragment", "checkReady: " + this.$from + " request permission");
        Ref.BooleanRef r14 = new Ref.BooleanRef();
        i2 r15 = i2.b;
        DoraObricDeviceBindFragment r16 = this.this$0;
        a r18 = new a(r14, r16, this.$from, this.$doNext);
        if (r13 >= 31) goto L43;
        Pair[] r20 = new Pair[3];
        if (DoraObricDeviceBindFragment.Y90(r16.l) == false) goto L50;
        int r21 = j0.a;
        String r22 = j0.d(2131902606);
    L51:
        r20[0] = TuplesKt.to("android.permission.BLUETOOTH", r22);
        int r23 = j0.a;
        r20[1] = TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", j0.d(2131898489));
        r20[2] = TuplesKt.to("android.permission.ACCESS_COARSE_LOCATION", j0.d(2131898489));
        Map r24 = MapsKt.mapOf(r20);
    L52:
        g1.a.a(r16, r12, r18, r24, null, 16);
        DoraBuryPointManager.a.H(this.this$0.m);
        goto L55
    L50:
        int r25 = j0.a;
        r22 = j0.d(2131898485);
        goto L51
    L43:
        if (DoraObricDeviceBindFragment.Y90(r16.l) == false) goto L45;
        int r26 = j0.a;
        String r27 = j0.d(2131902606);
    L46:
        r24 = MapsKt.mapOf(TuplesKt.to("android.permission.BLUETOOTH_SCAN", r27));
        goto L52
    L45:
        int r28 = j0.a;
        r27 = j0.d(2131898485);
        goto L46
    L39:
        r12.add("android.permission.BLUETOOTH");
        r12.add("android.permission.BLUETOOTH_ADMIN");
        r12.add("android.permission.ACCESS_FINE_LOCATION");
        r12.add("android.permission.ACCESS_COARSE_LOCATION");
        goto L40
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        CoroutineDispatcher r30 = Dispatchers.getIO();
        DoraObricDeviceBindFragment$checkReady$1$ready$1 r31 = new DoraObricDeviceBindFragment$checkReady$1$ready$1(null);
        this.label = 1;
        r3 = BuildersKt.withContext(r30, r31, this);
        if (r3 != r0) goto L11;
        return r0;
    }

    public static void INVOKEVIRTUAL_com_larus_dora_obric_device_management_device_bind_DoraObricDeviceBindFragment$checkReady$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(CommonDialog r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        CommonDialog r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
