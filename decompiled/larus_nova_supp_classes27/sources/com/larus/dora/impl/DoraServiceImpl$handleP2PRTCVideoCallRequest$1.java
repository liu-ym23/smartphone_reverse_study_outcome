package com.larus.dora.impl;

import com.larus.account.base.api.ILoginService;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.impl.core.settingsconfig.DoraXLinkTransportMode;
import com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper;
import com.larus.dora.impl.util.b0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import g49.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraServiceImpl$handleP2PRTCVideoCallRequest$1", f = "DoraServiceImpl.kt", i = {}, l = {2275}, m = "invokeSuspend", n = {}, s = {})
final class DoraServiceImpl$handleP2PRTCVideoCallRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraServiceImpl this$0;

    public DoraServiceImpl$handleP2PRTCVideoCallRequest$1(DoraServiceImpl r1, Continuation<? super DoraServiceImpl$handleP2PRTCVideoCallRequest$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraServiceImpl$handleP2PRTCVideoCallRequest$1(this.this$0, r3);
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
        boolean r4 = true;
        if (r3 == 0) goto L9;
        if (r3 != 1) goto L8;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L54
    L52:
        this.this$0.Z.set(false);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
        if (this.this$0.Z.compareAndSet(false, true) == true) goto L13;
        d.b("DoraServiceImpl", "handleP2PRTCVideoCallRequest ignored: request already starting");
        return Unit.INSTANCE;
    L13:
        String r13 = ILoginService.a.getAccountInfo().c;     // Catch: Throwable -> L54
        if (r13 != null) goto L16;
        r13 = "";
    L16:
        b0.a.getClass();     // Catch: Throwable -> L54
        boolean r6 = b0.p(r13);     // Catch: Throwable -> L54
        boolean r14 = b0.u(r13);     // Catch: Throwable -> L54
        DoraWifiLinkWrapper.a.getClass();     // Catch: Throwable -> L54
        DoraWifiLinkWrapper.a r7 = DoraWifiLinkWrapper.n();     // Catch: Throwable -> L54
        boolean r8 = r7.a();     // Catch: Throwable -> L54
        com.larus.dora.impl.core.settingsconfig.c r9 = com.larus.dora.impl.core.settingsconfig.c.a;     // Catch: Throwable -> L54
        if (r8 == false) goto L19;
        boolean r10 = true;
    L20:
        r9.getClass();     // Catch: Throwable -> L54
        DoraXLinkTransportMode r11 = com.larus.dora.impl.core.settingsconfig.c.d(r6, r14, r10);     // Catch: Throwable -> L54
        if (r11 == DoraXLinkTransportMode.WIFI) goto L37;
        StringBuilder r0 = new StringBuilder("handleP2PRTCVideoCallRequest failed: linkMode=");     // Catch: Throwable -> L54
        r0.append(r11);     // Catch: Throwable -> L54
        r0.append(", bluetooth=");     // Catch: Throwable -> L54
        if (r6 == false) goto L25;
        boolean r1 = true;
    L26:
        r0.append(r1);     // Catch: Throwable -> L54
        r0.append(", p2p=");     // Catch: Throwable -> L54
        if (r14 == false) goto L29;
        boolean r15 = true;
    L30:
        r0.append(r15);     // Catch: Throwable -> L54
        r0.append(", hasPermissions=");     // Catch: Throwable -> L54
        r0.append(r7.a);     // Catch: Throwable -> L54
        r0.append(", hasAbility=");     // Catch: Throwable -> L54
        r0.append(r7.b);     // Catch: Throwable -> L54
        r0.append(", runtimeSupported=");     // Catch: Throwable -> L54
        if (r8 == true) goto L34;
        r4 = false;
    L34:
        r0.append(r4);     // Catch: Throwable -> L54
        d.b("DoraServiceImpl", r0.toString());     // Catch: Throwable -> L54
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L54
        this.this$0.Z.set(false);
        return r16;
    L29:
        r15 = false;
        goto L30
    L25:
        r1 = false;
        goto L26
    L37:
        IDoraAVLinkService r17 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);     // Catch: Throwable -> L54
        if (r17 != null) goto L40;
    L42:
        boolean r18 = false;
    L43:
        StringBuilder r5 = new StringBuilder("handleP2PRTCVideoCallRequest handled=");     // Catch: Throwable -> L54
        if (r18 == false) goto L46;
        boolean r20 = true;
    L47:
        r5.append(r20);     // Catch: Throwable -> L54
        d.d("DoraServiceImpl", r5.toString());     // Catch: Throwable -> L54
        if (r18 == false) goto L52;
        DoraServiceImpl r110 = this.this$0;     // Catch: Throwable -> L54
        this.label = 1;     // Catch: Throwable -> L54
        if (DoraServiceImpl.r1(r110, this) != r2) goto L52;
        return r2;
    L46:
        r20 = false;
        goto L47
    L40:
        if (r17.Z0() != true) goto L42;
        r18 = true;
        goto L43
    L19:
        r10 = false;
    L54:
        th = move-exception;
        this.this$0.Z.set(false);
        throw th;
    }
}
