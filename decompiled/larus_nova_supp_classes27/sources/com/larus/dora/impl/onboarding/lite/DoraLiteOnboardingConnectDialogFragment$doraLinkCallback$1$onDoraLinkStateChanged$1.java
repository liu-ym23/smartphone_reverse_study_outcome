package com.larus.dora.impl.onboarding.lite;

import android.app.Application;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingConnectDialogFragment$doraLinkCallback$1$onDoraLinkStateChanged$1", f = "DoraLiteOnboardingConnectDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraLiteOnboardingConnectDialogFragment$doraLinkCallback$1$onDoraLinkStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ int $prevState;
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ DoraLiteOnboardingConnectDialogFragment this$0;

    public DoraLiteOnboardingConnectDialogFragment$doraLinkCallback$1$onDoraLinkStateChanged$1(DoraLiteOnboardingConnectDialogFragment r1, DoraDevice r2, int r3, int r4, Continuation<? super DoraLiteOnboardingConnectDialogFragment$doraLinkCallback$1$onDoraLinkStateChanged$1> r5) {
        this.this$0 = r1;
        this.$device = r2;
        this.$prevState = r3;
        this.$state = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraLiteOnboardingConnectDialogFragment$doraLinkCallback$1$onDoraLinkStateChanged$1(this.this$0, this.$device, this.$prevState, this.$state, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r5);
        DoraOnboardingDevice r6 = this.this$0.j;
        String r0 = null;
        if (r6 == null) goto L7;
        String r7 = r6.b;
    L8:
        DoraDevice r1 = this.$device;
        if (r1 == null) goto L11;
        String r2 = r1.mac;
    L13:
        if (Intrinsics.areEqual(r7, r2) == false) goto L22;
        StringBuilder r8 = new StringBuilder("onDoraLinkStateChanged ");
        r8.append(this.$device);
        r8.append(", mac = ");
        DoraDevice r3 = this.$device;
        if (r3 == null) goto L17;
        r0 = r3.mac;
    L17:
        r8.append(r0);
        r8.append(", prev=");
        r8.append(this.$prevState);
        r8.append(", cur=");
        r8.append(this.$state);
        g49.d.d("DoraOnboardingConnectDialogFragment", r8.toString());
        int r9 = this.$state;
        if (r9 != 2) goto L20;
        this.this$0.T90(DoraLiteOnboardingConnectDialogFragment.UiState.CONNECTED);
    L27:
        return Unit.INSTANCE;
    L20:
        if (r9 != 0) goto L27;
        t19.s r10 = t19.s.a;
        Application r4 = AppHost.a.getApplication();
        r10.getClass();
        t19.s.b(r4, 2131903672, false);
        this.this$0.T90(DoraLiteOnboardingConnectDialogFragment.UiState.DISCONNECTED);
        goto L27
    L22:
        StringBuilder r11 = new StringBuilder("It's not a device that is being connected, ignore onDoraLinkStateChanged ");
        DoraDevice r12 = this.$device;
        if (r12 == null) goto L25;
        r0 = r12.mac;
    L25:
        r11.append(r0);
        r11.append(" prev=");
        r11.append(this.$prevState);
        r11.append(", cur=");
        r11.append(this.$state);
        g49.d.d("DoraOnboardingConnectDialogFragment", r11.toString());
        goto L27
    L11:
        r2 = null;
        goto L13
    L7:
        r7 = null;
        goto L8
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
