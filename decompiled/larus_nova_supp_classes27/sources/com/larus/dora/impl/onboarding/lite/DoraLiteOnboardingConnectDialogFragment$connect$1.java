package com.larus.dora.impl.onboarding.lite;

import android.app.Application;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.BindAndConnectResult;
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
@DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingConnectDialogFragment$connect$1", f = "DoraLiteOnboardingConnectDialogFragment.kt", i = {}, l = {224, 247}, m = "invokeSuspend", n = {}, s = {})
final class DoraLiteOnboardingConnectDialogFragment$connect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    int label;
    final /* synthetic */ DoraLiteOnboardingConnectDialogFragment this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BindAndConnectResult.values().length];
            r0[BindAndConnectResult.SERVER_BIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[BindAndConnectResult.SERVER_BIND_UNKNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[BindAndConnectResult.SERVER_BIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[BindAndConnectResult.CONNECT_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[BindAndConnectResult.CONNECT_TIMEOUT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[BindAndConnectResult.SERVER_BIND_NEED_UNBIND.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[BindAndConnectResult.SUCCESS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    public DoraLiteOnboardingConnectDialogFragment$connect$1(DoraLiteOnboardingConnectDialogFragment r1, DoraDevice r2, Continuation<? super DoraLiteOnboardingConnectDialogFragment$connect$1> r3) {
        this.this$0 = r1;
        this.$device = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraLiteOnboardingConnectDialogFragment$connect$1(this.this$0, this.$device, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L12;
        if (r3 == 1) goto L10;
        if (r3 != 2) goto L9;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L47
    L49:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L47
    L31:
        BindAndConnectResult r13 = (BindAndConnectResult) r12;     // Catch: Throwable -> L47
        g49.d.d("DoraOnboardingConnectDialogFragment", "connect: " + o59.a.h(this.$device) + " result = " + r13);     // Catch: Throwable -> L47
        switch(a.a[r13.ordinal()]) {
            case 1: goto L42;
            case 2: goto L42;
            case 3: goto L41;
            case 4: goto L40;
            case 5: goto L40;
            case 6: goto L34;
            case 7: goto L49;
            default: goto L44;
        };     // Catch: Throwable -> L47
    L34:
        DoraLiteOnboardingConnectDialogFragment r14 = this.this$0;     // Catch: Throwable -> L47
        DoraDevice r0 = this.$device;     // Catch: Throwable -> L47
        this.label = 2;     // Catch: Throwable -> L47
        int r1 = DoraLiteOnboardingConnectDialogFragment.l;     // Catch: Throwable -> L47
        r14.getClass();     // Catch: Throwable -> L47
        Object r15 = BuildersKt.withContext(Dispatchers.getMain(), new DoraLiteOnboardingConnectDialogFragment$showNeedUnbindDialog$2(r14, r0, null), this);     // Catch: Throwable -> L47
        if (r15 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L38;
        r15 = Unit.INSTANCE;     // Catch: Throwable -> L47
    L38:
        if (r15 != r2) goto L49;
        return r2;
    L40:
        t19.s r16 = t19.s.a;     // Catch: Throwable -> L47
        Application r4 = AppHost.a.getApplication();     // Catch: Throwable -> L47
        r16.getClass();     // Catch: Throwable -> L47
        t19.s.b(r4, 2131903672, false);     // Catch: Throwable -> L47
        DoraLiteOnboardingConnectDialogFragment r17 = this.this$0;     // Catch: Throwable -> L47
        DoraLiteOnboardingConnectDialogFragment.UiState r5 = DoraLiteOnboardingConnectDialogFragment.UiState.DISCONNECTED;     // Catch: Throwable -> L47
        int r6 = DoraLiteOnboardingConnectDialogFragment.l;     // Catch: Throwable -> L47
        r17.T90(r5);     // Catch: Throwable -> L47
        goto L49
    L41:
        t19.s r18 = t19.s.a;     // Catch: Throwable -> L47
        Application r7 = AppHost.a.getApplication();     // Catch: Throwable -> L47
        r18.getClass();     // Catch: Throwable -> L47
        t19.s.b(r7, 2131904024, false);     // Catch: Throwable -> L47
        DoraLiteOnboardingConnectDialogFragment r110 = this.this$0;     // Catch: Throwable -> L47
        DoraLiteOnboardingConnectDialogFragment.UiState r8 = DoraLiteOnboardingConnectDialogFragment.UiState.DISCONNECTED;     // Catch: Throwable -> L47
        int r9 = DoraLiteOnboardingConnectDialogFragment.l;     // Catch: Throwable -> L47
        r110.T90(r8);     // Catch: Throwable -> L47
        goto L49
    L42:
        t19.s r111 = t19.s.a;     // Catch: Throwable -> L47
        Application r10 = AppHost.a.getApplication();     // Catch: Throwable -> L47
        r111.getClass();     // Catch: Throwable -> L47
        t19.s.b(r10, 2131908080, false);     // Catch: Throwable -> L47
        DoraLiteOnboardingConnectDialogFragment r112 = this.this$0;     // Catch: Throwable -> L47
        DoraLiteOnboardingConnectDialogFragment.UiState r11 = DoraLiteOnboardingConnectDialogFragment.UiState.DISCONNECTED;     // Catch: Throwable -> L47
        int r20 = DoraLiteOnboardingConnectDialogFragment.l;     // Catch: Throwable -> L47
        r112.T90(r11);     // Catch: Throwable -> L47
        goto L49
    L44:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L47
    L12:
        ResultKt.throwOnFailure(r12);
        DoraLiteOnboardingConnectDialogFragment r113 = this.this$0;
        DoraLiteOnboardingConnectDialogFragment.UiState r21 = DoraLiteOnboardingConnectDialogFragment.UiState.CONNECTING;
        int r114 = DoraLiteOnboardingConnectDialogFragment.l;
        r113.T90(r21);
        StringBuilder r115 = new StringBuilder("start connect ");     // Catch: Throwable -> L47
        DoraDevice r22 = this.$device;     // Catch: Throwable -> L47
        if (r22 == null) goto L16;
        String r23 = o59.a.h(r22);     // Catch: Throwable -> L47
    L17:
        r115.append(r23);     // Catch: Throwable -> L47
        g49.d.d("DoraOnboardingConnectDialogFragment", r115.toString());     // Catch: Throwable -> L47
        DoraDevice r116 = this.$device;     // Catch: Throwable -> L47
        if (r116 == null) goto L45;
        String r117 = r116.sn;     // Catch: Throwable -> L47
        if (r117 != null) goto L22;
    L25:
        boolean r118 = true;
    L26:
        if (r118 == true) goto L45;
        CoroutineDispatcher r119 = Dispatchers.getIO();     // Catch: Throwable -> L47
        DoraLiteOnboardingConnectDialogFragment$connect$1$connectResult$1 r24 = new DoraLiteOnboardingConnectDialogFragment$connect$1$connectResult$1(this.$device, null);     // Catch: Throwable -> L47
        this.label = 1;     // Catch: Throwable -> L47
        r12 = BuildersKt.withContext(r119, r24, this);     // Catch: Throwable -> L47
        if (r12 != r2) goto L31;
        return r2;
    L22:
        if (r117.length() == 0) goto L25;
        r118 = false;
    L45:
        g49.d.d("DoraOnboardingConnectDialogFragment", "connect failed. device or sn is null or empty!!!");     // Catch: Throwable -> L47
        t19.s r120 = t19.s.a;     // Catch: Throwable -> L47
        Application r25 = AppHost.a.getApplication();     // Catch: Throwable -> L47
        r120.getClass();     // Catch: Throwable -> L47
        t19.s.b(r25, 2131903672, false);     // Catch: Throwable -> L47
        this.this$0.T90(DoraLiteOnboardingConnectDialogFragment.UiState.DISCONNECTED);     // Catch: Throwable -> L47
        goto L49
    L16:
        r23 = null;
    L47:
        DoraLiteOnboardingConnectDialogFragment r121 = this.this$0;
        DoraLiteOnboardingConnectDialogFragment.UiState r26 = DoraLiteOnboardingConnectDialogFragment.UiState.DISCONNECTED;
        int r27 = DoraLiteOnboardingConnectDialogFragment.l;
        r121.T90(r26);
        goto L49
    }
}
