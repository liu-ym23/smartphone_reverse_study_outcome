package com.obric.aikernel.middleware.impl.obric;

import android.content.Context;
import android.os.Process;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.obric.IProcessService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcessService implements IProcessService {
    public static final ProcessService INSTANCE = null;
    public static final String TAG = "ObricProcessService";
    private static a keepAliveClient;
    private static Function0<? extends a> keepAliveClientFactory;
    private static String keepAliveProcessName;
    private static v1 keepAliveTask;
    private static final String pkgName = null;
    private static h silentUpdateBootstrap;
    private static final int uid = 0;

    /* JADX INFO: renamed from: com.obric.aikernel.middleware.impl.obric.ProcessService$launchKeepAliveLease$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.middleware.impl.obric.ProcessService$launchKeepAliveLease$1", f = "ProcessService.kt", i = {}, l = {452, 454}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ a $client;
        final /* synthetic */ String $processName;
        int label;

        AnonymousClass1(a r10, String r11, Continuation<? super AnonymousClass1> r12) {
            this.$client = r10;
            this.$processName = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$client, this.$processName, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L9;
            if (r11 == 1) goto L9;
            if (r11 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r12);
        L11:
            if (c.f4573a.a(this.$client, ProcessService.access$getPkgName$p(), ProcessService.access$getUid$p(), this.$processName, 1740000) == false) goto L12;
            this.label = 2;
            if (DelayKt.b(1740000, this) != r10) goto L11;
            return r10;
        L12:
            this.label = 1;
            if (DelayKt.b(1000, this) != r10) goto L11;
            return r10;
        }
    }

    static {
        INSTANCE = new ProcessService();
        uid = Process.myUid();
        pkgName = AppContext.INSTANCE.getPackageName();
        keepAliveClientFactory = ProcessService$keepAliveClientFactory$1.INSTANCE;
    }

    private ProcessService() {
    }

    public static final /* synthetic */ String access$getPkgName$p() {
        return pkgName;
    }

    public static final /* synthetic */ int access$getUid$p() {
        return uid;
    }

    @JvmStatic
    public static final ProcessService getInst() {
        return INSTANCE;
    }

    private final v1 launchKeepAliveLease(a r10, String r11) {
        return kotlinx.coroutines.h.d(m0.a(z0.b()), null, null, new AnonymousClass1(r10, r11, null), 3, null);
    }

    @Override // com.obric.aikernel.middleware.api.obric.IProcessService
    public synchronized void destroy() {
        monitor-enter(this);
        com.obric.aikernel.api.base.a r10 = com.obric.aikernel.api.b.f4431a.a();     // Catch: Throwable -> L67
        String r11 = Process.myProcessName();     // Catch: Throwable -> L67
        Intrinsics.checkNotNullExpressionValue(r11, "myProcessName()");     // Catch: Throwable -> L67
        String r12 = pkgName;     // Catch: Throwable -> L67
        e r13 = d.b(r10, r12, r11);     // Catch: Throwable -> L67
        String r14 = keepAliveProcessName;     // Catch: Throwable -> L67
        v1 r15 = keepAliveTask;     // Catch: Throwable -> L67
        if (r15 == null) goto L6;
    L10:
        boolean r16 = true;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L51
        if (r15 == null) goto L31;
        a r18 = keepAliveClient;     // Catch: Throwable -> L20
        if (r14 == null) goto L18;
        if (r18 == null) goto L18;
        r18.a(r12, uid, r14);     // Catch: Throwable -> L20
    L18:
        Object r19 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r20 = Result.m35exceptionOrNullimpl(r19);     // Catch: Throwable -> L51
        if (r20 == null) goto L75;
        AIKLog.INSTANCE.e(TAG, "unregisterKeepAlive failed: " + r20);     // Catch: Throwable -> L51
    L75:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L27
        v1.a.a(r15, null, 1, null);     // Catch: Throwable -> L27
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        keepAliveTask = null;     // Catch: Throwable -> L51
        keepAliveProcessName = null;     // Catch: Throwable -> L51
        keepAliveClient = null;     // Catch: Throwable -> L51
        goto L31
    L27:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L51
        Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L51
        goto L29
    L20:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L51
        r19 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L51
    L31:
        if (r13.b() == false) goto L33;
    L34:
        h r24 = silentUpdateBootstrap;     // Catch: Throwable -> L51
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L41
        if (r24 == null) goto L38;
        r24.c();     // Catch: Throwable -> L41
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L41
    L39:
        Object r27 = Result.m32constructorimpl(r26);     // Catch: Throwable -> L41
    L44:
        if (Result.m39isSuccessimpl(r27) == false) goto L46;
        Unit r28 = (Unit) r27;     // Catch: Throwable -> L51
        silentUpdateBootstrap = null;     // Catch: Throwable -> L51
    L46:
        Throwable r29 = Result.m35exceptionOrNullimpl(r27);     // Catch: Throwable -> L51
        if (r29 == null) goto L49;
        AIKLog.INSTANCE.e(TAG, "unbind silent update service failed: " + r29);     // Catch: Throwable -> L51
    L49:
        Object r30 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L51
    L54:
        if (Result.m39isSuccessimpl(r30) == false) goto L62;
        Unit r31 = (Unit) r30;     // Catch: Throwable -> L67
        AIKLog r32 = AIKLog.INSTANCE;     // Catch: Throwable -> L67
        StringBuilder r33 = new StringBuilder();     // Catch: Throwable -> L67
        r33.append("destroy process=");     // Catch: Throwable -> L67
        r33.append(r11);     // Catch: Throwable -> L67
        r33.append(" keepAliveProcess=");     // Catch: Throwable -> L67
        r33.append(r14);     // Catch: Throwable -> L67
        r33.append(" unbindSilent=");     // Catch: Throwable -> L67
        if (r13.b() == false) goto L58;
    L61:
        r33.append(r16);     // Catch: Throwable -> L67
        r32.i(TAG, r33.toString());     // Catch: Throwable -> L67
        goto L62
    L58:
        if (silentUpdateBootstrap != null) goto L61;
        r16 = false;
    L62:
        Throwable r34 = Result.m35exceptionOrNullimpl(r30);     // Catch: Throwable -> L67
        if (r34 == null) goto L65;
        AIKLog.INSTANCE.e(TAG, "destroy failed: " + r34);     // Catch: Throwable -> L67
    L65:
        monitor-exit(this);
        return;
    L38:
        r26 = null;
    L41:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L51
        r27 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L51
        goto L44
    L33:
        if (silentUpdateBootstrap == null) goto L49;
    L51:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L67
        r30 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L67
        goto L54
    L6:
        if (silentUpdateBootstrap != null) goto L10;
        AIKLog.INSTANCE.d(TAG, "skip destroy, service not inited.");     // Catch: Throwable -> L67
        monitor-exit(this);
        return;
    L67:
        th = move-exception;
        throw th;
    }

    public final Function0<a> getKeepAliveClientFactory$middleware_impl_release() {
        return keepAliveClientFactory;
    }

    @Override // com.obric.aikernel.middleware.api.obric.IProcessService
    public synchronized void init(Context r10) {
        monitor-enter(this);
        com.obric.aikernel.api.base.a r11 = com.obric.aikernel.api.b.f4431a.a();     // Catch: Throwable -> L30
        String r12 = Process.myProcessName();     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r12, "myProcessName()");     // Catch: Throwable -> L30
        e r13 = d.b(r11, pkgName, r12);     // Catch: Throwable -> L30
        if (r13.a() != null) goto L6;
    L8:
        boolean r14 = true;
        if (r13.b() == false) goto L20;
        if (r10 != null) goto L12;
        r10 = AppContext.INSTANCE.getContext();     // Catch: Throwable -> L30
    L12:
        Context r15 = r10.getApplicationContext();     // Catch: Throwable -> L30
        if (silentUpdateBootstrap != null) goto L15;
        Intrinsics.checkNotNullExpressionValue(r15, "appContext");     // Catch: Throwable -> L30
        ContextSilentUpdateServiceBinder r16 = new ContextSilentUpdateServiceBinder(r15);     // Catch: Throwable -> L30
        String r17 = r15.getPackageName();     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r17, "appContext.packageName");     // Catch: Throwable -> L30
        silentUpdateBootstrap = new h(r16, d.a(r17));     // Catch: Throwable -> L30
    L15:
        h r18 = silentUpdateBootstrap;     // Catch: Throwable -> L30
        if (r18 == null) goto L20;
        if (r18.a() != true) goto L20;
        boolean r19 = true;
    L21:
        AIKLog r20 = AIKLog.INSTANCE;     // Catch: Throwable -> L30
        StringBuilder r21 = new StringBuilder();     // Catch: Throwable -> L30
        r21.append("init process=");     // Catch: Throwable -> L30
        r21.append(r12);     // Catch: Throwable -> L30
        r21.append(" keepAliveProcess=");     // Catch: Throwable -> L30
        r21.append(r13.a());     // Catch: Throwable -> L30
        r21.append(" newBind=");     // Catch: Throwable -> L30
        r21.append(r19);     // Catch: Throwable -> L30
        r21.append(" serviceBound=");     // Catch: Throwable -> L30
        h r22 = silentUpdateBootstrap;     // Catch: Throwable -> L30
        if (r22 != null) goto L24;
    L26:
        r14 = false;
    L27:
        r21.append(r14);     // Catch: Throwable -> L30
        r20.i(TAG, r21.toString());     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L24:
        if (r22.b() != true) goto L26;
    L20:
        r19 = false;
        goto L21
    L6:
        if (keepAliveTask != null) goto L8;
        a r23 = keepAliveClientFactory.invoke();     // Catch: Throwable -> L30
        keepAliveClient = r23;     // Catch: Throwable -> L30
        keepAliveTask = launchKeepAliveLease(r23, r13.a());     // Catch: Throwable -> L30
        keepAliveProcessName = r13.a();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    public final void setKeepAliveClientFactory$middleware_impl_release(Function0<? extends a> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        keepAliveClientFactory = r10;
    }
}
