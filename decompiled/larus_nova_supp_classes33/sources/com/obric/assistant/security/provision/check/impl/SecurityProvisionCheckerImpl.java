package com.obric.assistant.security.provision.check.impl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import com.aiassistant.security.rot_provision.RotProvisionManager;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.AndroidLogcat;
import com.obric.assistant.security.provision.check.api.ISecurityProvisionChecker;
import com.obric.assistant.security.provision.check.bean.CheckState;
import com.obric.assistant.security.provision.check.bean.ProvisionResult;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019J.\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J \u0010$\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020#H\u0002R#\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR#\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006)"}, d2 = {"Lcom/obric/assistant/security/provision/check/impl/SecurityProvisionCheckerImpl;", "Lcom/obric/assistant/security/provision/check/api/ISecurityProvisionChecker;", "<init>", "()V", "rotProvisionManagerV1", "Lcom/obric/security/rot_provision/RotProvisionManager;", "kotlin.jvm.PlatformType", "getRotProvisionManagerV1", "()Lcom/obric/security/rot_provision/RotProvisionManager;", "rotProvisionManagerV1$delegate", "Lkotlin/Lazy;", "rotProvisionManagerV2", "Lcom/aiassistant/security/rot_provision/RotProvisionManager;", "getRotProvisionManagerV2", "()Lcom/aiassistant/security/rot_provision/RotProvisionManager;", "rotProvisionManagerV2$delegate", "checkState", "Lcom/obric/assistant/security/provision/check/bean/CheckState;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startKeyProvision", "Lcom/obric/assistant/security/provision/check/bean/ProvisionResult;", "extras", "Landroid/os/Bundle;", "(Landroid/content/Context;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleError", "", "continuation", "Lkotlin/coroutines/Continuation;", "message", "", "clientCode", "", "isContinuationResumed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "unbindService", "connection", "Landroid/content/ServiceConnection;", "isServiceBound", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecurityProvisionCheckerImpl implements ISecurityProvisionChecker {
    public static final /* synthetic */ int c = 0;
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    public static final class b implements Function1<Throwable, Unit> {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ SecurityProvisionCheckerImpl b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ SecurityProvisionCheckerImpl$startKeyProvision$2$serviceConnection$1 d;

        public b(AtomicBoolean r1, SecurityProvisionCheckerImpl r2, Context r3, SecurityProvisionCheckerImpl$startKeyProvision$2$serviceConnection$1 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final Object invoke(Object r4) {
            Throwable r5 = (Throwable) r4;
            if (this.a.get() == false) goto L6;
            SecurityProvisionCheckerImpl.d(this.b, this.c, this.d, this.a);
            FLogger.a.d("SecurityProvisionCheckerImpl", "invokeOnCancellation unbindService");
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public SecurityProvisionCheckerImpl() {
        this.a = LazyKt.lazy(new com.obric.assistant.security.provision.check.impl.a());
        this.b = LazyKt.lazy(new com.obric.assistant.security.provision.check.impl.b());
    }

    @Override // com.obric.assistant.security.provision.check.api.ISecurityProvisionChecker
    public final CheckState a(Context r11) {
        boolean r7 = t9a.b.b().b().d();     // Catch: Throwable -> L21
        if (r7 == false) goto L6;
        String r12 = ((RotProvisionManager) this.b.getValue()).checkState(r11, new Bundle());     // Catch: Throwable -> L21
    L7:
        int r8 = AndroidLogcat.a;     // Catch: Throwable -> L21
        AndroidLogcat.b("SecurityProvisionCheckerImpl", "checkState() useAssistantApi=" + r7 + ", checkStateJson=" + r12);     // Catch: Throwable -> L21
        FLogger r9 = FLogger.a;     // Catch: Throwable -> L21
        r9.i("SecurityProvisionCheckerImpl", "checkState() useAssistantApi=" + r7 + ", checkStateJson=" + r12);     // Catch: Throwable -> L21
        InnerCheckStateResult.a r0 = InnerCheckStateResult.Companion;     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L21
        r0.getClass();     // Catch: Throwable -> L21
        InnerCheckStateResult r1 = InnerCheckStateResult.a.a(r12);     // Catch: Throwable -> L21
        if (r1 != null) goto L12;
        return new CheckState(1, "checkState() -> InnerCheckStateResult.fromJson() json=".concat(r12));
    L12:
        if (r1.getDev_cert_provisioned() == true) goto L14;
    L19:
        r9.d("SecurityProvisionCheckerImpl", "需要下载证书");     // Catch: Throwable -> L21
        return new CheckState(2, "need download certificate");
    L14:
        if (r1.getTls_key_provisioned() == false) goto L19;
        if (r1.getPlatform_param_provisioned() == false) goto L19;
        r9.d("SecurityProvisionCheckerImpl", "证书已经ready");     // Catch: Throwable -> L21
        return new CheckState(0, "ready");
    L6:
        r12 = ((com.obric.security.rot_provision.RotProvisionManager) this.a.getValue()).checkState(r11, new Bundle());     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        FLogger.a.e("SecurityProvisionCheckerImpl", "checkState() exception, e.message=" + th.getMessage(), th);
        int r2 = AndroidLogcat.a;
        String r3 = "checkState() exception, e.message=" + th.getMessage();
        Intrinsics.checkNotNullParameter("SecurityProvisionCheckerImpl", "tag");
        AndroidLogcat.Level r4 = AndroidLogcat.Level.E;
        Intrinsics.checkNotNullParameter(r4, "level");
        Intrinsics.checkNotNullParameter("SecurityProvisionCheckerImpl", "tag");
        Class r5 = AndroidLogcat.a();     // Catch: Exception -> L44
        int r6 = AndroidLogcat.a.a[r4.ordinal()];     // Catch: Exception -> L44
        if (r6 == 1) goto L37;
        if (r6 == 2) goto L36;
        if (r6 != 3) goto L28;
        Method r10 = r5.getMethod("i", new Class[]{String.class, String.class, Throwable.class});     // Catch: Exception -> L44
    L38:
        Object[] r13 = new Object[3];     // Catch: Exception -> L44
        r13[0] = "SecurityProvisionCheckerImpl";     // Catch: Exception -> L44
        if (r3 != null) goto L41;
        r3 = "";
    L41:
        r13[1] = r3;     // Catch: Exception -> L44
        r13[2] = th;     // Catch: Exception -> L44
        r10.invoke(null, r13);     // Catch: Exception -> L44
        goto L43
    L28:
        if (r6 != 4) goto L30;
        r10 = r5.getMethod("w", new Class[]{String.class, String.class, Throwable.class});     // Catch: Exception -> L44
        goto L38
    L30:
        if (r6 != 5) goto L33;
        r10 = r5.getMethod("e", new Class[]{String.class, String.class, Throwable.class});     // Catch: Exception -> L44
        goto L38
    L33:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L44
    L36:
        r10 = r5.getMethod("d", new Class[]{String.class, String.class, Throwable.class});     // Catch: Exception -> L44
        goto L38
    L37:
        r10 = r5.getMethod("v", new Class[]{String.class, String.class, Throwable.class});     // Catch: Exception -> L44
    L43:
        return new CheckState(1, "checkState() exception: " + th.getMessage());
    }

    private final void unbindService(Context r2, ServiceConnection r3, AtomicBoolean r4) {
        if (r4.get() == false) goto L14;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        r2.unbindService(r3);     // Catch: Throwable -> L6
        r4.set(false);     // Catch: Throwable -> L6
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L15;
        FLogger.a.e("SecurityProvisionCheckerImpl", "context.unbindService exception: " + r6.getMessage(), r6);
        return;
    L15:
        return;
    L6:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.content.ServiceConnection, com.obric.assistant.security.provision.check.impl.SecurityProvisionCheckerImpl$startKeyProvision$2$serviceConnection$1] */
    @Override // com.obric.assistant.security.provision.check.api.ISecurityProvisionChecker
    public final Object b(final Context r13, final Bundle r14, Continuation<? super ProvisionResult> r15) {
        final j r7 = new j(IntrinsicsKt.intercepted(r15), 1);
        r7.C();
        final AtomicBoolean r9 = new AtomicBoolean(false);
        final AtomicBoolean r10 = new AtomicBoolean(false);
        ?? r11 = new SecurityProvisionCheckerImpl$startKeyProvision$2$serviceConnection$1(r7, this, r10, r14, r13, r9);
        Intent r16 = new Intent("com.bytedance.securityserver.ACTION_START_PROVISION");
        r16.setPackage("com.bytedance.securityserver");
        if (r13.bindService(r16, r11, 1) == false) goto L5;
        r9.set(true);
    L6:
        r7.i(new b(r9, this, r13, r11));
        Object r17 = r7.B();
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r15);
    L9:
        return r17;
    L5:
        FLogger.a.e("SecurityProvisionCheckerImpl", "Failed to bind service");
        c(this, r7, "Provision Failed: bind service failed", 1002, r10);
        goto L6
    }

    public static final /* synthetic */ void d(SecurityProvisionCheckerImpl r0, Context r1, SecurityProvisionCheckerImpl$startKeyProvision$2$serviceConnection$1 r2, AtomicBoolean r3) {
        r0.unbindService(r1, r2, r3);
    }

    public static final void c(SecurityProvisionCheckerImpl r7, i r8, String r9, int r10, AtomicBoolean r11) {
        r7.getClass();
        if (r11.compareAndSet(false, true) == false) goto L14;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L6
        r8.resumeWith(Result.constructor-impl(new ProvisionResult(0, null, r9, r10, 3, null)));     // Catch: Throwable -> L6
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L15;
        FLogger.a.e("SecurityProvisionCheckerImpl", "continuation.resume() exception: " + r14.getMessage(), r14);
        return;
    L15:
        return;
    L6:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
