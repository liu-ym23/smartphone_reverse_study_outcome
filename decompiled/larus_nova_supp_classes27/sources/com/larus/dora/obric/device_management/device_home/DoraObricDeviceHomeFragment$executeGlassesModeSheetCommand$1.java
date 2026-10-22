package com.larus.dora.obric.device_management.device_home;

import android.app.Application;
import androidx.fragment.app.Fragment;
import com.larus.dora.api.IDoraService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeFragment$executeGlassesModeSheetCommand$1", f = "DoraObricDeviceHomeFragment.kt", i = {}, l = {950}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricDeviceHomeFragment$executeGlassesModeSheetCommand$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ x2 $command;
    final /* synthetic */ String $commandDeviceMac;
    final /* synthetic */ IDoraService.d $deviceService;
    int label;
    final /* synthetic */ DoraObricDeviceHomeFragment this$0;

    public DoraObricDeviceHomeFragment$executeGlassesModeSheetCommand$1(x2 r1, DoraObricDeviceHomeFragment r2, String r3, IDoraService.d r4, Continuation<? super DoraObricDeviceHomeFragment$executeGlassesModeSheetCommand$1> r5) {
        this.$command = r1;
        this.this$0 = r2;
        this.$commandDeviceMac = r3;
        this.$deviceService = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraObricDeviceHomeFragment$executeGlassesModeSheetCommand$1(this.$command, this.this$0, this.$commandDeviceMac, this.$deviceService, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        DoraObricGlassesModeSheet r2 = null;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        int r9 = ((Number) r8).intValue();
        g49.d.d("DoraObricDeviceHomeFragment", "execute glasses mode command: command=" + this.$command + ", ret=" + r9);
        if (r9 != 0) goto L14;
        boolean r10 = true;
    L15:
        int r4 = r2.a;
        x2 r5 = this.$command;
        Intrinsics.checkNotNullParameter(r5, "command");
        if (r10 == true) goto L18;
    L20:
        r3 = false;
    L21:
        if (r3 == false) goto L23;
        DoraObricDeviceHomeFragment r6 = this.this$0;
        int r7 = DoraObricDeviceHomeFragment.R;
        r6.ia0().onShutdownSucceeded(this.$commandDeviceMac);
    L23:
        if (r10 == false) goto L34;
        DoraObricDeviceHomeFragment r11 = this.this$0;
        int r12 = DoraObricDeviceHomeFragment.R;
        Fragment r13 = r11.getChildFragmentManager().findFragmentByTag("ObricGlassesModeSheet");
        if ((r13 instanceof DoraObricGlassesModeSheet) == false) goto L27;
        r2 = (DoraObricGlassesModeSheet) r13;
    L27:
        if (r2 == null) goto L36;
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r14 = DialogFragmentLancet.sLastShowStack;
        if (r14 == null) goto L36;
        com.bytedance.crash.d.d(r14, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L36:
        return Unit.INSTANCE;
    L34:
        t19.s r15 = t19.s.a;
        DoraObricDeviceHomeFragment r16 = this.this$0;
        int r17 = DoraObricDeviceHomeFragment.R;
        Application r18 = r16.fa0();
        r15.getClass();
        t19.s.b(r18, 2131903992, false);
        goto L36
    L18:
        if (Intrinsics.areEqual(r5, x2.b.a) == false) goto L20;
    L14:
        r10 = false;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r20 = Dispatchers.getIO();
        DoraObricDeviceHomeFragment$executeGlassesModeSheetCommand$1$ret$1 r21 = new DoraObricDeviceHomeFragment$executeGlassesModeSheetCommand$1$ret$1(this.$command, this.$deviceService, this.this$0, null);
        this.label = 1;
        r8 = BuildersKt.withContext(r20, r21, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
