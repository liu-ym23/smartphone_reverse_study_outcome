package com.obric.assistant.network.impl;

import android.app.Application;
import com.bytedance.ttnet.TTNetInit;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import hm9.j;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$setTTNetBgcpEnabled$1", f = "ObricNetworkServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricNetworkServiceImpl$setTTNetBgcpEnabled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ObricNetworkServiceImpl this$0;

    public ObricNetworkServiceImpl$setTTNetBgcpEnabled$1(boolean r1, ObricNetworkServiceImpl r2, Continuation<? super ObricNetworkServiceImpl$setTTNetBgcpEnabled$1> r3) {
        this.$enabled = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ObricNetworkServiceImpl$setTTNetBgcpEnabled$1 r0 = new ObricNetworkServiceImpl$setTTNetBgcpEnabled$1(this.$enabled, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L55;
        ResultKt.throwOnFailure(r12);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        boolean r3 = this.$enabled;
        ObricNetworkServiceImpl r4 = this.this$0;
        monitor-enter(r13);
        j r5 = j.a;     // Catch: Throwable -> L51
        boolean r6 = true;
        if (j.h.z == true) goto L9;
    L11:
        boolean r7 = false;
    L12:
        FLogger r8 = FLogger.a;     // Catch: Throwable -> L51
        StringBuilder r10 = new StringBuilder("===>>> start ttnet bgcp enabled state set to: ");     // Catch: Throwable -> L51
        if (r3 == false) goto L15;
        boolean r2 = true;
    L16:
        r10.append(r2);     // Catch: Throwable -> L51
        r10.append(", current: ");     // Catch: Throwable -> L51
        r10.append(r4.g);     // Catch: Throwable -> L51
        r10.append(" isFeatureEnable: ");     // Catch: Throwable -> L51
        if (r7 == false) goto L19;
        boolean r9 = true;
    L20:
        r10.append(r9);     // Catch: Throwable -> L51
        r8.i("[ObricNetworkServiceImpl]", r10.toString());     // Catch: Throwable -> L51
        if (r7 == true) goto L57;
        r8.i("[ObricNetworkServiceImpl]", "feature of clear ttnet connect pool is not enable");     // Catch: Throwable -> L51
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L51
        monitor-exit(r13);
        return r0;
    L57:
        Application r11 = AppHost.a.getApplication();     // Catch: Exception -> L39 Throwable -> L51
        if (r3 == false) goto L28;
        boolean r14 = true;
    L29:
        TTNetInit.runInBackGround(r11, r14);     // Catch: Exception -> L39 Throwable -> L51
        StringBuilder r15 = new StringBuilder("<<<=== end ttnet bgcp enabled state set to: ");     // Catch: Exception -> L39 Throwable -> L51
        if (r3 == false) goto L32;
        boolean r1 = true;
    L33:
        r15.append(r1);     // Catch: Exception -> L39 Throwable -> L51
        r8.i("[ObricNetworkServiceImpl]", r15.toString());     // Catch: Exception -> L39 Throwable -> L51
        if (r3 == false) goto L36;
        boolean r16 = true;
    L37:
        r4.g = r16;     // Catch: Exception -> L39 Throwable -> L51
    L47:
        monitor-exit(r13);
        return Unit.INSTANCE;
    L36:
        r16 = false;
        goto L37
    L32:
        r1 = false;
        goto L33
    L28:
        r14 = false;
    L39:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L51
        if (AppHost.a.isDebug() == true) goto L50;
        FLogger r17 = FLogger.a;     // Catch: Throwable -> L51
        StringBuilder r18 = new StringBuilder("ttnet bgcp enabled state set failed: ");     // Catch: Throwable -> L51
        if (r3 == true) goto L46;
        r6 = false;
    L46:
        r18.append(r6);     // Catch: Throwable -> L51
        r17.e("[ObricNetworkServiceImpl]", r18.toString(), e);     // Catch: Throwable -> L51
        goto L47
    L50:
        throw e;     // Catch: Throwable -> L51
    L19:
        r9 = false;
        goto L20
    L15:
        r2 = false;
        goto L16
    L9:
        if (j.f == false) goto L11;
        r7 = true;
    L51:
        th = move-exception;
        throw th;
    L55:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
