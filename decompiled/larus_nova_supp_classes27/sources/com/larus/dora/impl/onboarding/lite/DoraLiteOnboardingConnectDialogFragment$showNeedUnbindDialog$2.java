package com.larus.dora.impl.onboarding.lite;

import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingConnectDialogFragment$showNeedUnbindDialog$2", f = "DoraLiteOnboardingConnectDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraLiteOnboardingConnectDialogFragment$showNeedUnbindDialog$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    int label;
    final /* synthetic */ DoraLiteOnboardingConnectDialogFragment this$0;

    public static final class a implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ DoraLiteOnboardingConnectDialogFragment a;
        public final /* synthetic */ DoraDevice b;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            DoraLiteOnboardingConnectDialogFragment r0 = this.a;
            DoraDevice r1 = this.b;
            int r2 = DoraLiteOnboardingConnectDialogFragment.l;
            r0.getClass();
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new DoraLiteOnboardingConnectDialogFragment$replaceAndConnect$1(r0, r1, null), 3, null);
        }

        public a(DoraLiteOnboardingConnectDialogFragment r1, DoraDevice r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements com.larus.common_ui.dialog.u {
        public final /* synthetic */ DoraLiteOnboardingConnectDialogFragment a;

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            t19.s r0 = t19.s.a;
            Application r1 = AppHost.a.getApplication();
            r0.getClass();
            t19.s.b(r1, 2131903672, false);
            DoraLiteOnboardingConnectDialogFragment r2 = this.a;
            DoraLiteOnboardingConnectDialogFragment.UiState r3 = DoraLiteOnboardingConnectDialogFragment.UiState.DISCONNECTED;
            int r4 = DoraLiteOnboardingConnectDialogFragment.l;
            r2.T90(r3);
        }

        public b(DoraLiteOnboardingConnectDialogFragment r1) {
            this.a = r1;
        }
    }

    public DoraLiteOnboardingConnectDialogFragment$showNeedUnbindDialog$2(DoraLiteOnboardingConnectDialogFragment r1, DoraDevice r2, Continuation<? super DoraLiteOnboardingConnectDialogFragment$showNeedUnbindDialog$2> r3) {
        this.this$0 = r1;
        this.$device = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraLiteOnboardingConnectDialogFragment$showNeedUnbindDialog$2(this.this$0, this.$device, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r6);
        DoraLiteOnboardingConnectDialogFragment r7 = this.this$0;
        boolean r1 = false;
        if (r7.f != null) goto L7;
        CommonDialog.a r0 = new CommonDialog.a();
        r0.i(r7.getString(2131902447));
        r0.g(this.this$0.getString(2131902446));
        DoraLiteOnboardingConnectDialogFragment r3 = this.this$0;
        CommonDialog.a.f(r0, new a(r3, this.$device), r3.getString(2131902418), false, 12);
        DoraLiteOnboardingConnectDialogFragment r4 = this.this$0;
        CommonDialog.a.e(r0, new b(r4), r4.getString(2131902465), 4);
        r0.z = false;
        final DoraLiteOnboardingConnectDialogFragment r2 = this.this$0;
        Function0<Boolean> r5 = new g(r2);
        Intrinsics.checkNotNullParameter(r5, "callback");
        r0.B = r5;
        r7.f = r0.a();
    L7:
        CommonDialog r8 = this.this$0.f;
        if (r8 != null) goto L10;
    L12:
        if (r1 == true) goto L17;
        DoraLiteOnboardingConnectDialogFragment r9 = this.this$0;
        CommonDialog r10 = r9.f;
        if (r10 == null) goto L17;
        INVOKEVIRTUAL_com_larus_dora_impl_onboarding_lite_DoraLiteOnboardingConnectDialogFragment$showNeedUnbindDialog$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r10, r9.getChildFragmentManager(), null);
    L17:
        return Unit.INSTANCE;
    L10:
        if (r8.isVisible() != true) goto L12;
        r1 = true;
        goto L12
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static void INVOKEVIRTUAL_com_larus_dora_impl_onboarding_lite_DoraLiteOnboardingConnectDialogFragment$showNeedUnbindDialog$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(CommonDialog r2, FragmentManager r3, String r4) {
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
