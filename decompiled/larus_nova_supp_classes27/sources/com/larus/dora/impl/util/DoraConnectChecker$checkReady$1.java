package com.larus.dora.impl.util;

import android.content.Intent;
import android.os.Build;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.common_ui.dialog.CommonDialog;
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
@DebugMetadata(c = "com.larus.dora.impl.util.DoraConnectChecker$checkReady$1", f = "DoraConnectChecker.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
public final class DoraConnectChecker$checkReady$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $buryPointSource;
    final /* synthetic */ Function0<Unit> $doNext;
    final /* synthetic */ String $from;
    int label;
    final /* synthetic */ DoraConnectChecker this$0;

    public static final class a implements g1.c {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ String b;
        public final /* synthetic */ DoraConnectChecker c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Function0<Unit> e;

        public final void onSettingPageReturn() {
        }

        public final void onGoSettingsDialogShow() {
            g49.d.d("DoraConnectChecker", "checkReady: permission onGoSettingsDialogShow");
            this.a.element = true;
        }

        public final void onGoSettingsDialogDismiss(boolean r4) {
            DoraBuryPointManager.a.G(false, this.b);
            g49.d.d("DoraConnectChecker", "checkReady: permission onGoSettingsDialogDismiss, " + r4);
            DoraConnectChecker r5 = this.c;
            int r0 = DoraConnectChecker.e;
            r5.getClass();
        }

        public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "grantedList");
            Intrinsics.checkNotNullParameter(r4, "deniedList");
            if (r5 == true) goto L5;
            DoraBuryPointManager.a.G(r2, this.b);
        L5:
            g49.d.d("DoraConnectChecker", "checkReady: " + this.d + " request permission, isGranted = " + r2);
            if (r2 == false) goto L8;
            DoraConnectChecker r6 = this.c;
            String r7 = this.b;
            Function0<Unit> r8 = this.e;
            int r9 = DoraConnectChecker.e;
            r6.a("permission_granted", r7, r8);
            return;
        L8:
            DoraConnectChecker r10 = this.c;
            int r11 = DoraConnectChecker.e;
            r10.getClass();
            g49.d.d("DoraConnectChecker", "checkReady: request permission failed, goSettingsDialogShown=" + this.a.element);
            this.c.getClass();
        }

        public a(Ref.BooleanRef r1, String r2, DoraConnectChecker r3, String r4, Function0<Unit> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class b implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ DoraConnectChecker a;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            Intent r0 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");     // Catch: Throwable -> L4
            r0.addFlags(268435456);     // Catch: Throwable -> L4
            this.a.a.startActivity(r0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            g49.d.c("DoraConnectChecker", "start android.settings.LOCATION_SOURCE_SETTINGS error", th);
        }

        public b(DoraConnectChecker r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.u {
        public final /* synthetic */ DoraConnectChecker a;

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            DoraConnectChecker r0 = this.a;
            int r1 = DoraConnectChecker.e;
            r0.getClass();
        }

        public c(DoraConnectChecker r1) {
            this.a = r1;
        }
    }

    public DoraConnectChecker$checkReady$1(String r1, Function0<Unit> r2, DoraConnectChecker r3, String r4, Continuation<? super DoraConnectChecker$checkReady$1> r5) {
        this.$from = r1;
        this.$doNext = r2;
        this.this$0 = r3;
        this.$buryPointSource = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraConnectChecker$checkReady$1(this.$from, this.$doNext, this.this$0, this.$buryPointSource, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_dora_impl_util_DoraConnectChecker$checkReady$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(CommonDialog r1) {
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

    public final Object invokeSuspend(Object r22) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r22);
        Object r3 = r22;
    L11:
        int r1 = ((Number) r3).intValue();
        if (r1 != 0) goto L14;
        g49.d.d("DoraConnectChecker", "checkReady: " + this.$from + " ready ok");
        this.$doNext.invoke();
        DoraConnectChecker r4 = this.this$0;
        int r5 = DoraConnectChecker.e;
        r4.getClass();
    L46:
        return Unit.INSTANCE;
    L14:
        if (r1 == 1) goto L35;
        if (r1 == 2) goto L28;
        if (r1 != 3) goto L46;
        g49.d.d("DoraConnectChecker", "checkReady: " + this.$from + " request open gps switch");
        CommonDialog r6 = this.this$0.c;
        if (r6 == null) goto L47;
        INVOKEVIRTUAL_com_larus_dora_impl_util_DoraConnectChecker$checkReady$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r6);
        this.this$0.c = null;
    L47:
        DoraConnectChecker r7 = this.this$0;     // Catch: IllegalStateException -> L25
        CommonDialog.a r8 = new CommonDialog.a();     // Catch: IllegalStateException -> L25
        int r9 = com.larus.utils.j0.a;     // Catch: IllegalStateException -> L25
        r8.i(com.larus.utils.j0.d(2131903986));     // Catch: IllegalStateException -> L25
        r8.g(com.larus.utils.j0.d(2131903985));     // Catch: IllegalStateException -> L25
        CommonDialog.a.f(r8, new b(this.this$0), com.larus.utils.j0.d(2131902468), false, 12);     // Catch: IllegalStateException -> L25
        CommonDialog.a.e(r8, new c(this.this$0), com.larus.utils.j0.d(2131902465), 4);     // Catch: IllegalStateException -> L25
        r7.c = r8.a();     // Catch: IllegalStateException -> L25
        DoraConnectChecker r10 = this.this$0;     // Catch: IllegalStateException -> L25
        CommonDialog r11 = r10.c;     // Catch: IllegalStateException -> L25
        if (r11 == null) goto L27;
        INVOKEVIRTUAL_com_larus_dora_impl_util_DoraConnectChecker$checkReady$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r11, r10.a.getChildFragmentManager(), null);     // Catch: IllegalStateException -> L25
    L27:
        this.this$0.getClass();
    L25:
        e = move-exception;
        g49.d.c("DoraConnectChecker", "checkReady show loc dialog exception", e);
        goto L27
    L28:
        g49.d.d("DoraConnectChecker", "checkReady: " + this.$from + " request open bluetooth switch");
        DoraConnectChecker r12 = this.this$0;
        r12.d = this.$doNext;
        ActivityResultLauncher<Intent> r13 = r12.b;     // Catch: Throwable -> L33
        if (r13 == null) goto L46;
        r13.launch(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        g49.d.c("DoraConnectChecker", "launch android.bluetooth.adapter.action.REQUEST_ENABLE error", th);
        goto L46
    L35:
        ArrayList r14 = new ArrayList();
        int r15 = Build.VERSION.SDK_INT;
        if (r15 < 31) goto L38;
        r14.add("android.permission.BLUETOOTH_SCAN");
        r14.add("android.permission.BLUETOOTH_CONNECT");
        r14.add("android.permission.BLUETOOTH");
    L39:
        g49.d.d("DoraConnectChecker", "checkReady: " + this.$from + " request permission");
        Ref.BooleanRef r16 = new Ref.BooleanRef();
        i2 r17 = i2.b;
        DoraConnectChecker r18 = this.this$0;
        Fragment r20 = r18.a;
        a r21 = new a(r16, this.$buryPointSource, r18, this.$from, this.$doNext);
        if (r15 < 31) goto L42;
        int r23 = com.larus.utils.j0.a;
        Map r24 = MapsKt.mapOf(TuplesKt.to("android.permission.BLUETOOTH_SCAN", com.larus.utils.j0.d(2131898485)));
    L43:
        g1.a.a(r20, r14, r21, r24, null, 16);
        DoraBuryPointManager.a.H(this.$buryPointSource);
        goto L46
    L42:
        int r25 = com.larus.utils.j0.a;
        r24 = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.BLUETOOTH", com.larus.utils.j0.d(2131898485)), TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", com.larus.utils.j0.d(2131898489)), TuplesKt.to("android.permission.ACCESS_COARSE_LOCATION", com.larus.utils.j0.d(2131898489))});
        goto L43
    L38:
        r14.add("android.permission.BLUETOOTH");
        r14.add("android.permission.BLUETOOTH_ADMIN");
        r14.add("android.permission.ACCESS_FINE_LOCATION");
        r14.add("android.permission.ACCESS_COARSE_LOCATION");
        goto L39
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r22);
        CoroutineDispatcher r26 = Dispatchers.getIO();
        DoraConnectChecker$checkReady$1$ready$1 r27 = new DoraConnectChecker$checkReady$1$ready$1(null);
        this.label = 1;
        r3 = BuildersKt.withContext(r26, r27, this);
        if (r3 != r0) goto L11;
        return r0;
    }

    public static void INVOKEVIRTUAL_com_larus_dora_impl_util_DoraConnectChecker$checkReady$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(CommonDialog r2, FragmentManager r3, String r4) {
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
