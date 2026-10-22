package com.larus.dora.impl.onboarding.lite;

import android.app.Application;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.ReplaceBindAndConnectResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingConnectDialogFragment$replaceAndConnect$1", f = "DoraLiteOnboardingConnectDialogFragment.kt", i = {}, l = {368}, m = "invokeSuspend", n = {}, s = {})
final class DoraLiteOnboardingConnectDialogFragment$replaceAndConnect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    int label;
    final /* synthetic */ DoraLiteOnboardingConnectDialogFragment this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReplaceBindAndConnectResult.values().length];
            r0[ReplaceBindAndConnectResult.SERVER_REPLACE_BIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[ReplaceBindAndConnectResult.SERVER_REPLACE_BIND_UNKNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[ReplaceBindAndConnectResult.SERVER_REPLACE_BIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[ReplaceBindAndConnectResult.CONNECT_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ReplaceBindAndConnectResult.CONNECT_TIMEOUT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[ReplaceBindAndConnectResult.SUCCESS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public DoraLiteOnboardingConnectDialogFragment$replaceAndConnect$1(DoraLiteOnboardingConnectDialogFragment r1, DoraDevice r2, Continuation<? super DoraLiteOnboardingConnectDialogFragment$replaceAndConnect$1> r3) {
        this.this$0 = r1;
        this.$device = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraLiteOnboardingConnectDialogFragment$replaceAndConnect$1(this.this$0, this.$device, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        switch(a.a[((ReplaceBindAndConnectResult) r6).ordinal()]) {
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L15;
            case 6: goto L19;
            default: goto L14;
        };
    L15:
        t19.s r7 = t19.s.a;
        Application r2 = AppHost.a.getApplication();
        r7.getClass();
        t19.s.b(r2, 2131903672, false);
        DoraLiteOnboardingConnectDialogFragment r8 = this.this$0;
        DoraLiteOnboardingConnectDialogFragment.UiState r3 = DoraLiteOnboardingConnectDialogFragment.UiState.DISCONNECTED;
        int r4 = DoraLiteOnboardingConnectDialogFragment.l;
        r8.T90(r3);
        goto L19
    L16:
        t19.s r9 = t19.s.a;
        Application r5 = AppHost.a.getApplication();
        r9.getClass();
        t19.s.b(r5, 2131904024, false);
        DoraLiteOnboardingConnectDialogFragment r10 = this.this$0;
        DoraLiteOnboardingConnectDialogFragment.UiState r11 = DoraLiteOnboardingConnectDialogFragment.UiState.DISCONNECTED;
        int r12 = DoraLiteOnboardingConnectDialogFragment.l;
        r10.T90(r11);
        goto L19
    L17:
        t19.s r13 = t19.s.a;
        Application r14 = AppHost.a.getApplication();
        r13.getClass();
        t19.s.b(r14, 2131908080, false);
        DoraLiteOnboardingConnectDialogFragment r15 = this.this$0;
        DoraLiteOnboardingConnectDialogFragment.UiState r16 = DoraLiteOnboardingConnectDialogFragment.UiState.DISCONNECTED;
        int r17 = DoraLiteOnboardingConnectDialogFragment.l;
        r15.T90(r16);
        goto L19
    L14:
        throw new NoWhenBranchMatchedException();
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineDispatcher r18 = Dispatchers.getIO();
        DoraLiteOnboardingConnectDialogFragment$replaceAndConnect$1$rebindAndConnectResult$1 r20 = new DoraLiteOnboardingConnectDialogFragment$replaceAndConnect$1$rebindAndConnectResult$1(this.$device, null);
        this.label = 1;
        r6 = BuildersKt.withContext(r18, r20, this);
        if (r6 != r0) goto L12;
        return r0;
    }
}
