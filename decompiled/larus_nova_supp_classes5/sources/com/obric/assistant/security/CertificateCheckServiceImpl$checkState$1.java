package com.obric.assistant.security;

import android.app.Application;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.security.provision.check.api.ISecurityProvisionChecker;
import com.obric.assistant.security.provision.check.bean.CheckState;
import com.obric.assistant.t1;
import com.obric.capabilitykit.apphost.AppHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
@DebugMetadata(c = "com.obric.assistant.security.CertificateCheckServiceImpl$checkState$1", f = "CertificateCheckServiceImpl.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
public final class CertificateCheckServiceImpl$checkState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CertificateCheckServiceImpl this$0;

    public CertificateCheckServiceImpl$checkState$1(CertificateCheckServiceImpl r1, Continuation<? super CertificateCheckServiceImpl$checkState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CertificateCheckServiceImpl$checkState$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L9;
        if (r3 != 1) goto L8;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L30
    L26:
        if (((CheckState) r9).getCode() != 2) goto L28;
        t1.a.x(false);     // Catch: Throwable -> L30
        FLogger.a.d("CertificateCheckServiceImpl", "certificate not ready, set keva ready false");     // Catch: Throwable -> L30
    L33:
        this.this$0.b.set(false);
        return Unit.INSTANCE;
    L28:
        FLogger.a.d("CertificateCheckServiceImpl", "certificate ready, do noting");     // Catch: Throwable -> L30
        goto L33
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
        boolean r10 = t1.a.T();     // Catch: Throwable -> L30
        FLogger r4 = FLogger.a;     // Catch: Throwable -> L30
        StringBuilder r7 = new StringBuilder("keva cache isReady:");     // Catch: Throwable -> L30
        if (r10 == false) goto L13;
        boolean r0 = true;
    L14:
        r7.append(r0);     // Catch: Throwable -> L30
        r4.d("CertificateCheckServiceImpl", r7.toString());     // Catch: Throwable -> L30
        if (r10 == true) goto L19;
        r4.d("CertificateCheckServiceImpl", "certificate not ready, just return");     // Catch: Throwable -> L30
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L30
    L17:
        this.this$0.b.set(false);
        return r11;
    L19:
        ISecurityProvisionChecker r12 = (ISecurityProvisionChecker) ServiceManager.get().getService(ISecurityProvisionChecker.class);     // Catch: Throwable -> L30
        if (r12 != null) goto L22;
        r4.w("CertificateCheckServiceImpl", "ISecurityProvisionChecker service not found");     // Catch: Throwable -> L30
        r11 = Unit.INSTANCE;     // Catch: Throwable -> L30
        goto L17
    L22:
        Application r1 = AppHost.Companion.getApplication();     // Catch: Throwable -> L30
        this.label = 1;     // Catch: Throwable -> L30
        r9 = r12.a(r1);     // Catch: Throwable -> L30
        if (r9 != r2) goto L26;
        return r2;
    L13:
        r0 = false;
    L30:
        th = move-exception;
        FLogger.a.e("CertificateCheckServiceImpl", "checkState() error: " + th.getMessage(), th);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        this.this$0.b.set(false);
        throw th;
    }
}
