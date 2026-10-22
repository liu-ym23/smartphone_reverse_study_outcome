package com.larus.dora.impl.device_v2;

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
@DebugMetadata(c = "com.larus.dora.impl.device_v2.DoraSmartDeviceBindFragment$checkReady$1", f = "DoraSmartDeviceBindFragment.kt", i = {}, l = {604}, m = "invokeSuspend", n = {}, s = {})
public final class DoraSmartDeviceBindFragment$checkReady$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $doNext;
    final /* synthetic */ String $from;
    int label;
    final /* synthetic */ DoraSmartDeviceBindFragment this$0;

    public static final class a implements g1.c {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ DoraSmartDeviceBindFragment b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Function0<Unit> d;

        public final void onSettingPageReturn() {
        }

        public final void onGoSettingsDialogShow() {
            g49.d.d("DoraDeviceBindFragment", "checkReady: permission onGoSettingsDialogShow");
            this.a.element = true;
        }

        public final void onGoSettingsDialogDismiss(boolean r4) {
            DoraBuryPointManager.a.G(false, this.b.y);
            g49.d.d("DoraDeviceBindFragment", "checkReady: permission onGoSettingsDialogDismiss, " + r4);
            if (r4 == true) goto L6;
            this.b.Z90("go settings dialog dismiss without confirm");
            return;
        }

        public a(Ref.BooleanRef r1, DoraSmartDeviceBindFragment r2, String r3, Function0<Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "grantedList");
            Intrinsics.checkNotNullParameter(r4, "deniedList");
            if (r5 == true) goto L5;
            DoraBuryPointManager.a.G(r2, this.b.y);
        L5:
            g49.d.d("DoraDeviceBindFragment", "checkReady: " + this.c + " request permission, isGranted = " + r2);
            if (r2 == false) goto L8;
            DoraSmartDeviceBindFragment r6 = this.b;
            Function0<Unit> r7 = this.d;
            int r8 = DoraSmartDeviceBindFragment.B;
            r6.X90("check_from_permission_granted", r7);
            return;
        L8:
            this.b.f = false;
            g49.d.d("DoraDeviceBindFragment", "checkReady: request permission failed, goSettingsDialogShown=" + this.a.element);
            if (this.a.element == true) goto L13;
            this.b.Z90("cancel go settings dialog");
            return;
        }
    }

    public static final class b implements p0 {
        public final /* synthetic */ DoraSmartDeviceBindFragment a;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            Intent r0 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");     // Catch: Throwable -> L4
            r0.addFlags(268435456);     // Catch: Throwable -> L4
            this.a.startActivity(r0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            g49.d.c("DoraDeviceBindFragment", "start android.settings.LOCATION_SOURCE_SETTINGS error", th);
        }

        public b(DoraSmartDeviceBindFragment r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.u {
        public final /* synthetic */ DoraSmartDeviceBindFragment a;

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            DoraSmartDeviceBindFragment r0 = this.a;
            int r1 = DoraSmartDeviceBindFragment.B;
            r0.Z90("cancel request location dialog");
        }

        public c(DoraSmartDeviceBindFragment r1) {
            this.a = r1;
        }
    }

    public DoraSmartDeviceBindFragment$checkReady$1(String r1, Function0<Unit> r2, DoraSmartDeviceBindFragment r3, Continuation<? super DoraSmartDeviceBindFragment$checkReady$1> r4) {
        this.$from = r1;
        this.$doNext = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraSmartDeviceBindFragment$checkReady$1(this.$from, this.$doNext, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_dora_impl_device_v2_DoraSmartDeviceBindFragment$checkReady$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(CommonDialog r1) {
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
        g49.d.d("DoraDeviceBindFragment", "checkReady: " + this.$from + " ready ok");
        this.$doNext.invoke();
        this.this$0.f = false;
    L46:
        return Unit.INSTANCE;
    L14:
        if (r1 == 1) goto L35;
        if (r1 == 2) goto L28;
        if (r1 != 3) goto L46;
        g49.d.d("DoraDeviceBindFragment", "checkReady: " + this.$from + " request open gps switch");
        CommonDialog r4 = this.this$0.l;
        if (r4 == null) goto L47;
        INVOKEVIRTUAL_com_larus_dora_impl_device_v2_DoraSmartDeviceBindFragment$checkReady$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r4);
        this.this$0.l = null;
    L47:
        DoraSmartDeviceBindFragment r5 = this.this$0;     // Catch: IllegalStateException -> L25
        CommonDialog.a r6 = new CommonDialog.a();     // Catch: IllegalStateException -> L25
        int r7 = com.larus.utils.j0.a;     // Catch: IllegalStateException -> L25
        r6.i(com.larus.utils.j0.d(2131903986));     // Catch: IllegalStateException -> L25
        r6.g(com.larus.utils.j0.d(2131903985));     // Catch: IllegalStateException -> L25
        CommonDialog.a.f(r6, new b(this.this$0), com.larus.utils.j0.d(2131902468), false, 12);     // Catch: IllegalStateException -> L25
        CommonDialog.a.e(r6, new c(this.this$0), com.larus.utils.j0.d(2131902465), 4);     // Catch: IllegalStateException -> L25
        r5.l = r6.a();     // Catch: IllegalStateException -> L25
        DoraSmartDeviceBindFragment r8 = this.this$0;     // Catch: IllegalStateException -> L25
        CommonDialog r9 = r8.l;     // Catch: IllegalStateException -> L25
        if (r9 == null) goto L27;
        INVOKEVIRTUAL_com_larus_dora_impl_device_v2_DoraSmartDeviceBindFragment$checkReady$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r9, r8.getChildFragmentManager(), null);     // Catch: IllegalStateException -> L25
    L27:
        this.this$0.f = false;
    L25:
        e = move-exception;
        g49.d.c("DoraDeviceBindFragment", "checkReady show loc dialog exception", e);
        goto L27
    L28:
        g49.d.d("DoraDeviceBindFragment", "checkReady: " + this.$from + " request open bluetooth switch");
        DoraSmartDeviceBindFragment r10 = this.this$0;
        r10.m = this.$doNext;
        ActivityResultLauncher<Intent> r11 = r10.n;     // Catch: Throwable -> L33
        if (r11 == null) goto L46;
        r11.launch(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        g49.d.c("DoraDeviceBindFragment", "launch android.bluetooth.adapter.action.REQUEST_ENABLE error", th);
        goto L46
    L35:
        ArrayList r12 = new ArrayList();
        int r13 = Build.VERSION.SDK_INT;
        if (r13 < 31) goto L38;
        r12.add("android.permission.BLUETOOTH_SCAN");
        r12.add("android.permission.BLUETOOTH_CONNECT");
        r12.add("android.permission.BLUETOOTH");
    L39:
        DoraBuryPointManager.a.H(this.this$0.y);
        g49.d.d("DoraDeviceBindFragment", "checkReady: " + this.$from + " request permission");
        Ref.BooleanRef r14 = new Ref.BooleanRef();
        i2 r15 = i2.b;
        DoraSmartDeviceBindFragment r16 = this.this$0;
        a r18 = new a(r14, r16, this.$from, this.$doNext);
        if (r13 < 31) goto L42;
        int r20 = com.larus.utils.j0.a;
        Map r21 = MapsKt.mapOf(TuplesKt.to("android.permission.BLUETOOTH_SCAN", com.larus.utils.j0.d(2131902335)));
    L43:
        g1.a.a(r16, r12, r18, r21, null, 16);
        goto L46
    L42:
        int r22 = com.larus.utils.j0.a;
        r21 = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.BLUETOOTH", com.larus.utils.j0.d(2131902335)), TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", com.larus.utils.j0.d(2131903928)), TuplesKt.to("android.permission.ACCESS_COARSE_LOCATION", com.larus.utils.j0.d(2131903928))});
        goto L43
    L38:
        r12.add("android.permission.BLUETOOTH");
        r12.add("android.permission.BLUETOOTH_ADMIN");
        r12.add("android.permission.ACCESS_FINE_LOCATION");
        r12.add("android.permission.ACCESS_COARSE_LOCATION");
        goto L39
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        CoroutineDispatcher r23 = Dispatchers.getIO();
        DoraSmartDeviceBindFragment$checkReady$1$ready$1 r24 = new DoraSmartDeviceBindFragment$checkReady$1$ready$1(null);
        this.label = 1;
        r3 = BuildersKt.withContext(r23, r24, this);
        if (r3 != r0) goto L11;
        return r0;
    }

    public static void INVOKEVIRTUAL_com_larus_dora_impl_device_v2_DoraSmartDeviceBindFragment$checkReady$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(CommonDialog r2, FragmentManager r3, String r4) {
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
