package com.larus.dora.impl.device.scan;

import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.scan.ScanDeviceDialog$showNeedUnbindDialog$2", f = "ScanDeviceDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ScanDeviceDialog$showNeedUnbindDialog$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    int label;
    final /* synthetic */ ScanDeviceDialog this$0;

    public static final class a implements p0 {
        public final /* synthetic */ ScanDeviceDialog a;
        public final /* synthetic */ DoraDevice b;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            ScanDeviceDialog r0 = this.a;
            DoraDevice r1 = this.b;
            BuildersKt.launch$default(r0.h, null, null, new ScanDeviceDialog$replaceAndConnect$1(r0, r1, null), 3, null);
        }

        public a(ScanDeviceDialog r1, DoraDevice r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements u {
        public final /* synthetic */ ScanDeviceDialog a;
        public final /* synthetic */ DoraDevice b;

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            s r0 = s.a;
            Application r1 = AppHost.a.getApplication();
            r0.getClass();
            s.b(r1, 2131903672, false);
            ScanDeviceListAdapter r2 = this.a.i;
            if (r2 == null) goto L6;
            r2.y2(k.a(this.b, 0));
            return;
        }

        public b(ScanDeviceDialog r1, DoraDevice r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public ScanDeviceDialog$showNeedUnbindDialog$2(ScanDeviceDialog r1, DoraDevice r2, Continuation<? super ScanDeviceDialog$showNeedUnbindDialog$2> r3) {
        this.this$0 = r1;
        this.$device = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ScanDeviceDialog$showNeedUnbindDialog$2(this.this$0, this.$device, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        CommonDialog.a r6 = new CommonDialog.a();
        r6.i(this.this$0.getString(2131902447));
        r6.g(this.this$0.getString(2131902446));
        ScanDeviceDialog r1 = this.this$0;
        CommonDialog.a.f(r6, new a(r1, this.$device), r1.getString(2131902418), false, 12);
        ScanDeviceDialog r2 = this.this$0;
        CommonDialog.a.e(r6, new b(r2, this.$device), r2.getString(2131902465), 4);
        r6.z = false;
        final ScanDeviceDialog r0 = this.this$0;
        final DoraDevice r3 = this.$device;
        Function0<Boolean> r4 = new c(r0, r3);
        Intrinsics.checkNotNullParameter(r4, "callback");
        r6.B = r4;
        INVOKEVIRTUAL_com_larus_dora_impl_device_scan_ScanDeviceDialog$showNeedUnbindDialog$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r6.a(), this.this$0.getChildFragmentManager(), null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static void INVOKEVIRTUAL_com_larus_dora_impl_device_scan_ScanDeviceDialog$showNeedUnbindDialog$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(CommonDialog r2, FragmentManager r3, String r4) {
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
