package com.obric.memorydata.middleware.impl.app;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0010\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/middleware/impl/app/EnterpriseAccountProviderClient;", "", "<init>", "()V", "TAG", "", "AUTHORITY", "METHOD_QUERY_ACCOUNT_INFO", "URI_AUTHORITY", "URI_QUERY_ACCOUNT_INFO", "KEY_IS_ENTERPRISE", "DEFAULT_TIMEOUT_MS", "", "providerCallExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/ExecutorService;", "queryIsEnterpriseAccount", "", "()Ljava/lang/Boolean;", "doQueryIsEnterprise", "registerAccountObserver", "Landroid/database/ContentObserver;", "onChange", "Lkotlin/Function0;", "", "unregisterAccountObserver", "observer", "checkProviderExist", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11697a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f11698b = null;

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.app.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/middleware/impl/app/EnterpriseAccountProviderClient$registerAccountObserver$observer$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0630a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f11699a;

        C0630a(Function0<Unit> r3, Handler r4) {
            this.f11699a = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
            super(r4);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r7) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_EnterpriseAccountProviderClient", "account info observer onChange", false, 4, null);
            this.f11699a.invoke();
        }
    }

    static {
        f11697a = new a();
        f11698b = Executors.newCachedThreadPool($$Lambda$a$5dr2QOlunQnFxXH2XPPJMHwL9Zo.INSTANCE);
    }

    private a() {
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "EnterpriseAccountProviderThread");
        r0.setDaemon(true);
        return r0;
    }

    private final Boolean b() {
        ContentProviderClient r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.obric.assistant.provider.AssistantHybridAbilityProvider"));
        Boolean r2 = null;
        if (r0 != null) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_EnterpriseAccountProviderClient", "acquireUnstableContentProviderClient null", null, 4, null);
        return null;
    L29:
        Bundle r3 = r0.call("query_account_info", null, null);     // Catch: Throwable -> L15 RuntimeException -> L17 RemoteException -> L20 DeadObjectException -> L22
        if (r3 != null) goto L11;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15 RuntimeException -> L17 RemoteException -> L20 DeadObjectException -> L22
        String r5 = "MeD_EnterpriseAccountProviderClient";
        String r6 = "queryIsEnterpriseAccount empty result";
    L9:
        IRunLog.a.a(r4, r5, r6, null, 4, null);     // Catch: Throwable -> L15 RuntimeException -> L17 RemoteException -> L20 DeadObjectException -> L22
    L14:
        r0.close();
        return r2;
    L11:
        if (r3.containsKey("is_enterprise") == true) goto L13;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15 RuntimeException -> L17 RemoteException -> L20 DeadObjectException -> L22
        r5 = "MeD_EnterpriseAccountProviderClient";
        r6 = "queryIsEnterpriseAccount result missing key: is_enterprise";
        goto L9
    L13:
        boolean r10 = r3.getBoolean("is_enterprise", false);     // Catch: Throwable -> L15 RuntimeException -> L17 RemoteException -> L20 DeadObjectException -> L22
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_EnterpriseAccountProviderClient", "queryIsEnterpriseAccount result: isEnterprise=" + r10, false, 4, null);     // Catch: Throwable -> L15 RuntimeException -> L17 RemoteException -> L20 DeadObjectException -> L22
        r2 = Boolean.valueOf(r10);     // Catch: Throwable -> L15 RuntimeException -> L17 RemoteException -> L20 DeadObjectException -> L22
    L17:
        e = move-exception;
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        String r8 = "MeD_EnterpriseAccountProviderClient";
        String r9 = "queryIsEnterpriseAccount runtime exception: " + e;     // Catch: Throwable -> L15
    L19:
        IRunLog.a.a(r7, r8, r9, null, 4, null);     // Catch: Throwable -> L15
    L22:
        e = move-exception;
        r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        r8 = "MeD_EnterpriseAccountProviderClient";
        r9 = "queryIsEnterpriseAccount provider dead: " + e;     // Catch: Throwable -> L15
    L20:
        e = move-exception;
        r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        r8 = "MeD_EnterpriseAccountProviderClient";
        r9 = "queryIsEnterpriseAccount remote exception: " + e;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r0.close();
        throw th;
    }

    private final boolean c() {
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().resolveContentProvider("com.obric.assistant.provider.AssistantHybridAbilityProvider", 0) == null) goto L6;
        return true;
    L6:
        return false;
    }

    private static final Boolean d() {
        return f11697a.b();
    }

    public static /* synthetic */ Thread lambda$5dr2QOlunQnFxXH2XPPJMHwL9Zo(Runnable r0) {
        return a(r0);
    }

    public static /* synthetic */ Boolean lambda$mUNpnCMxgBh0xmKuF0Oj55VuroQ() {
        return d();
    }

    public final ContentObserver a(Function0<Unit> r10) {
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "onChange");
        if (c() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_EnterpriseAccountProviderClient", "registerAccountObserver provider not exist", null, 4, null);
        return null;
    L6:
        C0630a r2 = new C0630a(r11, new Handler(Looper.getMainLooper()));
        ZeusProviderTransform.registerContentObserver(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), Uri.parse("content://com.obric.assistant.provider.AssistantHybridAbilityProvider/query_account_info"), false, (ContentObserver) ZeusTransformUtils.preCheckCast(r2, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L9
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_EnterpriseAccountProviderClient", "registerAccountObserver success", false, 4, null);     // Catch: RuntimeException -> L9
        return (ContentObserver) ZeusTransformUtils.preCheckCast(r2, ContentObserver.class, "com.obric.memorydata.plugin");
    L9:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_EnterpriseAccountProviderClient", "registerAccountObserver exception: " + e, null, 4, null);
        return null;
    }

    public final Boolean a() {
        if (c() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_EnterpriseAccountProviderClient", "queryIsEnterpriseAccount provider not exist", null, 4, null);
        return null;
    L6:
        boolean r2 = false;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_EnterpriseAccountProviderClient", "call queryIsEnterpriseAccount", false, 4, null);     // Catch: ExecutionException -> L13 InterruptedException -> L15 TimeoutException -> L20
        Future r3 = f11698b.submit($$Lambda$a$mUNpnCMxgBh0xmKuF0Oj55VuroQ.INSTANCE);     // Catch: ExecutionException -> L13 InterruptedException -> L15 TimeoutException -> L20
    L28:
        goto L21
    L30:
        return (Boolean) ZeusTransformUtils.preCheckCast(r3.get(5000, TimeUnit.MILLISECONDS), Boolean.class, "com.obric.memorydata.plugin");
    L11:
        e = e;
    L17:
        if (r3 == null) goto L19;
        r2 = r3.cancel(true);
    L19:
        Thread.currentThread().interrupt();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_EnterpriseAccountProviderClient", "queryIsEnterpriseAccount interrupted: " + e + ", cancel=" + r2, null, 4, null);
        return null;
    L21:
        if (r3 == null) goto L23;
        r2 = r3.cancel(true);
    L23:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_EnterpriseAccountProviderClient", "queryIsEnterpriseAccount timeout, cancel=" + r2, null, 4, null);
        return null;
    L13:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_EnterpriseAccountProviderClient", "queryIsEnterpriseAccount execution exception: " + e, null, 4, null);
        return null;
    L15:
        e = e;
        r3 = null;
    L20:
        r3 = null;
        goto L21
    }
}
