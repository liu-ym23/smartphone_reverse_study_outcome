package com.larus.dora.obric.device_management.device_bind;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.device_bind.DoraObricSmartDeviceBindFragment$checkReady$1", f = "DoraObricSmartDeviceBindFragment.kt", i = {}, l = {477}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricSmartDeviceBindFragment$checkReady$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $doNext;
    final /* synthetic */ String $from;
    int label;
    final /* synthetic */ DoraObricSmartDeviceBindFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_bind.DoraObricSmartDeviceBindFragment$checkReady$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_bind.DoraObricSmartDeviceBindFragment$checkReady$1$1", f = "DoraObricSmartDeviceBindFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxInt(kj4.a.g().isReady());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DoraObricSmartDeviceBindFragment$checkReady$1(Function0<Unit> r1, DoraObricSmartDeviceBindFragment r2, String r3, Continuation<? super DoraObricSmartDeviceBindFragment$checkReady$1> r4) {
        this.$doNext = r1;
        this.this$0 = r2;
        this.$from = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraObricSmartDeviceBindFragment$checkReady$1(this.$doNext, this.this$0, this.$from, r5);
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
        CommonDialog r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        int r9 = ((Number) r8).intValue();
        if (r9 == 0) goto L40;
        if (r9 != 1) goto L15;
        DoraObricSmartDeviceBindFragment.Y90(this.this$0, this.$from, this.$doNext);
    L42:
        return Unit.INSTANCE;
    L15:
        if (r9 != 2) goto L17;
        DoraObricSmartDeviceBindFragment r10 = this.this$0;
        r10.j = this.$doNext;
        ActivityResultLauncher<Intent> r11 = r10.k;     // Catch: Throwable -> L37
        if (r11 == null) goto L42;
        r11.launch(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        g49.d.c("DoraObricSmartDeviceBindFragment", "request bluetooth switch failed", th);
        goto L42
    L17:
        if (r9 != 3) goto L42;
        DoraObricSmartDeviceBindFragment r12 = this.this$0;
        CommonDialog r3 = r12.i;
        if (r3 != null) goto L45;
    L43:
        CommonDialog.a r4 = new CommonDialog.a();     // Catch: Throwable -> L29
        int r5 = j0.a;     // Catch: Throwable -> L29
        r4.i(j0.d(2131903986));     // Catch: Throwable -> L29
        r4.g(j0.d(2131903985));     // Catch: Throwable -> L29
        CommonDialog.a.f(r4, new s(r12), j0.d(2131902468), false, 12);     // Catch: Throwable -> L29
        CommonDialog.a.e(r4, new t(r12), j0.d(2131902465), 4);     // Catch: Throwable -> L29
        CommonDialog r6 = r4.a();     // Catch: Throwable -> L29
        DoraObricSmartDeviceBindFragment.W90(r6, r12.getChildFragmentManager());     // Catch: Throwable -> L29
        r2 = r6;
    L31:
        r12.i = r2;
        r12.g = false;
    L29:
        th = move-exception;
        g49.d.c("DoraObricSmartDeviceBindFragment", "show location dialog failed", th);
        goto L31
    L45:
        r3.dismissAllowingStateLoss();     // Catch: Exception -> L23
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r7 = DialogFragmentLancet.sLastShowStack;
        if (r7 == null) goto L43;
        com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L43
    L40:
        this.$doNext.invoke();
        this.this$0.g = false;
        goto L42
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r13 = Dispatchers.getIO();
        AnonymousClass1 r14 = new AnonymousClass1(null);
        this.label = 1;
        r8 = BuildersKt.withContext(r13, r14, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
