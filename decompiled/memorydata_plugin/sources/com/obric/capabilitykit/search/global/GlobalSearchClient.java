package com.obric.capabilitykit.search.global;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.memory.MemoryServiceChecker;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.capabilitykit.entity.search.global.GlobalSearchRequest;
import com.obric.capabilitykit.entity.search.global.GlobalSearchResult;
import com.obric.capabilitykit.entity.search.global.IGlobalSearchService;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u001e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u001bJ\b\u0010%\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/search/global/GlobalSearchClient;", "", "()V", "NONE_ERROR_ENTITY_TYPE", "", "TAG", "", "businessMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", WsConstants.KEY_CONNECTION, "com/obric/capabilitykit/search/global/GlobalSearchClient$connection$1", "Lcom/obric/capabilitykit/search/global/GlobalSearchClient$connection$1;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isBound", "", "mainHandler", "Landroid/os/Handler;", "pendingOperations", "Ljava/util/Queue;", "Lkotlin/Function0;", "service", "Lcom/obric/capabilitykit/entity/search/global/IGlobalSearchService;", "bindService", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "businessName", "isCancelled", "timestamp", "startGlobalSearch", Ext.KEY_REQUEST, "Lcom/obric/capabilitykit/entity/search/global/GlobalSearchRequest;", "callback", "Lcom/obric/capabilitykit/search/global/IGlobalSearchCallback;", "stop", "unbindService", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GlobalSearchClient {
    public static final GlobalSearchClient INSTANCE = null;
    public static final int NONE_ERROR_ENTITY_TYPE = -1;
    private static final String TAG = "GlobalSearchClient";
    private static final ConcurrentHashMap<String, Long> businessMap = null;
    private static final a connection = null;
    private static final Context context = null;
    private static boolean isBound;
    private static final Handler mainHandler = null;
    private static final Queue<Function0<Object>> pendingOperations = null;
    private static IGlobalSearchService service;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/capabilitykit/search/global/GlobalSearchClient$connection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", ActivityLifecycle.NAME, "Landroid/content/ComponentName;", "binder", "Landroid/os/IBinder;", "onServiceDisconnected", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r3, IBinder r4) {
            IBinder r2 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin");
            GlobalSearchClient r5 = GlobalSearchClient.INSTANCE;
            GlobalSearchClient.access$setService$p(IGlobalSearchService.Stub.asInterface(r2));
            Logger.INSTANCE.d(GlobalSearchClient.TAG, "onServiceConnected " + r3);
            GlobalSearchClient.access$setBound$p(true);
        L4:
            if ((!GlobalSearchClient.access$getPendingOperations$p().isEmpty()) == false) goto L8;
            Function0 r6 = (Function0) ZeusTransformUtils.preCheckCast(GlobalSearchClient.access$getPendingOperations$p().poll(), Function0.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L4;
            r6.invoke();
            goto L4
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r3) {
            Logger.INSTANCE.d(GlobalSearchClient.TAG, "onServiceDisconnected " + r3);
            GlobalSearchClient r2 = GlobalSearchClient.INSTANCE;
            GlobalSearchClient.access$setService$p(null);
            GlobalSearchClient.access$setBound$p(false);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGlobalSearchCallback f7618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7619b;
        public final /* synthetic */ GlobalSearchRequest c;

        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/capabilitykit/search/global/GlobalSearchClient$startGlobalSearch$operation$1$1", "Lcom/obric/capabilitykit/entity/search/global/IGlobalSearchCallback$Stub;", "onAllCompleted", "", "onCompleted", "entityType", "", "onError", "errorCode", DTraitConstant.ERROR, "", "onSearchResult", "result", "Lcom/obric/capabilitykit/entity/search/global/GlobalSearchResult;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback.Stub {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f7620a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f7621b;
            public final /* synthetic */ IGlobalSearchCallback c;

            public a(String r3, long r4, IGlobalSearchCallback r6) {
                IGlobalSearchCallback r7 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r6, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
                this.f7620a = r3;
                this.f7621b = r4;
                this.c = r7;
            }

            private static final void a(String r2, long r3, IGlobalSearchCallback r5) {
                IGlobalSearchCallback r6 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "$businessName");
                Intrinsics.checkNotNullParameter(r6, "$callback");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r6.onAllCompleted();
                GlobalSearchClient.access$getBusinessMap$p().remove(r2);
                return;
            }

            private static final void a(String r2, long r3, IGlobalSearchCallback r5, int r6) {
                IGlobalSearchCallback r7 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "$businessName");
                Intrinsics.checkNotNullParameter(r7, "$callback");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r7.onCompleted(r6);
                return;
            }

            private static final void a(String r2, long r3, IGlobalSearchCallback r5, int r6, String r7) {
                IGlobalSearchCallback r8 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "$businessName");
                Intrinsics.checkNotNullParameter(r8, "$callback");
                Intrinsics.checkNotNullParameter(r7, "$errorMsg");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r8.onError(r6, -1, r7);
                GlobalSearchClient.access$getBusinessMap$p().remove(r2);
                return;
            }

            private static final void a(String r2, long r3, IGlobalSearchCallback r5, GlobalSearchResult r6) {
                IGlobalSearchCallback r7 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "$businessName");
                Intrinsics.checkNotNullParameter(r7, "$callback");
                Intrinsics.checkNotNullParameter(r6, "$result");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r7.onSearchResult(r6);
                return;
            }

            /* JADX INFO: renamed from: lambda$-854c9zS8KC34Ppoz9ldVs9kRYc, reason: not valid java name */
            public static /* synthetic */ void m415lambda$854c9zS8KC34Ppoz9ldVs9kRYc(String r0, long r1, IGlobalSearchCallback r3) {
                a(r0, r1, r3);
            }

            /* JADX INFO: renamed from: lambda$5E8VhNMmoWxBB-8MitBgOadozG4, reason: not valid java name */
            public static /* synthetic */ void m416lambda$5E8VhNMmoWxBB8MitBgOadozG4(String r0, long r1, IGlobalSearchCallback r3, int r4) {
                a(r0, r1, r3, r4);
            }

            public static /* synthetic */ void lambda$qK42MxT_Ij_sOuhvobgChalC40g(String r0, long r1, IGlobalSearchCallback r3, int r4, String r5) {
                a(r0, r1, r3, r4, r5);
            }

            /* JADX INFO: renamed from: lambda$r8WYu-23Ups3PQTqvFwx_0CJVx4, reason: not valid java name */
            public static /* synthetic */ void m417lambda$r8WYu23Ups3PQTqvFwx_0CJVx4(String r0, long r1, IGlobalSearchCallback r3, GlobalSearchResult r4) {
                a(r0, r1, r3, r4);
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onAllCompleted() {
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onAllCompleted");
                Handler r0 = GlobalSearchClient.access$getMainHandler$p();
                final String r1 = this.f7620a;
                final long r2 = this.f7621b;
                final IGlobalSearchCallback r5 = this.c;
                r0.post(new $$Lambda$GlobalSearchClient$b$a$854c9zS8KC34Ppoz9ldVs9kRYc(r1, r2, r5));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onCompleted(final int r8) {
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onCompleted " + r8);
                Handler r0 = GlobalSearchClient.access$getMainHandler$p();
                final String r2 = this.f7620a;
                final long r3 = this.f7621b;
                final IGlobalSearchCallback r5 = this.c;
                r0.post(new $$Lambda$GlobalSearchClient$b$a$5E8VhNMmoWxBB8MitBgOadozG4(r2, r3, r5, r8));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onError(final int r8, int r9, final String r10) {
                Intrinsics.checkNotNullParameter(r10, DTraitConstant.ERROR);
                Logger.INSTANCE.w(GlobalSearchClient.TAG, "onError: " + r8 + ' ' + r10);
                Handler r11 = GlobalSearchClient.access$getMainHandler$p();
                final String r1 = this.f7620a;
                final long r2 = this.f7621b;
                final IGlobalSearchCallback r4 = this.c;
                r11.post(new $$Lambda$GlobalSearchClient$b$a$qK42MxT_Ij_sOuhvobgChalC40g(r1, r2, r4, r8, r10));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onSearchResult(final GlobalSearchResult r8) {
                Intrinsics.checkNotNullParameter(r8, "result");
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onSearchResult: " + r8);
                Handler r0 = GlobalSearchClient.access$getMainHandler$p();
                final String r2 = this.f7620a;
                final long r3 = this.f7621b;
                final IGlobalSearchCallback r5 = this.c;
                r0.post(new $$Lambda$GlobalSearchClient$b$a$r8WYu23Ups3PQTqvFwx_0CJVx4(r2, r3, r5, r8));
            }
        }

        public b(IGlobalSearchCallback r3, String r4, GlobalSearchRequest r5) {
            this.f7618a = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r3, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
            this.f7619b = r4;
            this.c = r5;
            super(0);
        }

        private static final void a(IGlobalSearchCallback r2, Throwable r3) {
            IGlobalSearchCallback r4 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r2, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "$callback");
            Intrinsics.checkNotNullParameter(r3, "$e");
            String r5 = r3.getMessage();
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            r4.onError(1, -1, r5);
        }

        /* JADX INFO: renamed from: lambda$iqeFuGxDJkRxGq-kKhciR7U1NQ0, reason: not valid java name */
        public static /* synthetic */ void m414lambda$iqeFuGxDJkRxGqkKhciR7U1NQ0(IGlobalSearchCallback r0, Throwable r1) {
            a(r0, r1);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
        L11:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(GlobalSearchClient.TAG, "exception " + th.getMessage());
            Handler r1 = GlobalSearchClient.access$getMainHandler$p();
            final IGlobalSearchCallback r8 = this.f7618a;
            return Boolean.valueOf(r1.post(new $$Lambda$GlobalSearchClient$b$iqeFuGxDJkRxGqkKhciR7U1NQ0(r8, th)));
        L3:
            if (GlobalSearchClient.access$getService$p() != null) goto L5;
            this.f7618a.onError(2, -1, "service not ready");     // Catch: Throwable -> L11
        L8:
            return Unit.INSTANCE;
        L5:
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L11
            GlobalSearchClient.access$getBusinessMap$p().put(this.f7619b, Long.valueOf(r0));     // Catch: Throwable -> L11
            IGlobalSearchService r2 = GlobalSearchClient.access$getService$p();     // Catch: Throwable -> L11
            if (r2 == null) goto L10;
            r2.startGlobalSearch(this.f7619b, this.c, new a(this.f7619b, r0, this.f7618a));     // Catch: Throwable -> L11
            goto L8
        L10:
            return null;
        }
    }

    static {
        INSTANCE = new GlobalSearchClient();
        context = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        mainHandler = new Handler(Looper.getMainLooper());
        pendingOperations = new LinkedList();
        businessMap = new ConcurrentHashMap();
        connection = new a();
    }

    private GlobalSearchClient() {
    }

    public static final /* synthetic */ ConcurrentHashMap access$getBusinessMap$p() {
        return businessMap;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p() {
        return mainHandler;
    }

    public static final /* synthetic */ Queue access$getPendingOperations$p() {
        return pendingOperations;
    }

    public static final /* synthetic */ IGlobalSearchService access$getService$p() {
        return service;
    }

    public static final /* synthetic */ boolean access$isCancelled(GlobalSearchClient r0, String r1, long r2) {
        return r0.isCancelled(r1, r2);
    }

    public static final /* synthetic */ void access$setBound$p(boolean r0) {
        isBound = r0;
    }

    public static final /* synthetic */ void access$setService$p(IGlobalSearchService r2) {
        service = (IGlobalSearchService) ZeusTransformUtils.wrapperContextForParams(r2, IGlobalSearchService.class, "com.obric.memorydata.plugin");
    }

    private final boolean bindService() {
        Logger.INSTANCE.d(TAG, "start bindService");
        Intent r8 = new Intent(MemoryServiceChecker.ACTION_GLOBAL_SEARCH_SERVICE);
        List<ResolveInfo> r1 = context.getPackageManager().queryIntentServices(r8, 0);
        Intrinsics.checkNotNullExpressionValue(r1, "context.packageManager.q…IntentServices(intent, 0)");
        ArrayList r3 = new ArrayList();
        Iterator<T> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        ServiceInfo r4 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r2.next(), ResolveInfo.class, "com.obric.memorydata.plugin")).serviceInfo;
        if (r4 == null) goto L4;
        r3.add(r4);
        goto L4
    L8:
        Iterator r5 = r3.iterator();
    L9:
        String r6 = null;
        if (r5.hasNext() == false) goto L14;
        Object r7 = r5.next();
        if (PackageUtils.INSTANCE.checkSignature(((ServiceInfo) ZeusTransformUtils.preCheckCast(r7, ServiceInfo.class, "com.obric.memorydata.plugin")).packageName) == false) goto L9;
    L15:
        ServiceInfo r9 = (ServiceInfo) ZeusTransformUtils.preCheckCast(r7, ServiceInfo.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L19;
        Logger.INSTANCE.e(TAG, "No trusted service found for action: " + r8.getAction());
        return false;
    L19:
        r8.setComponent(new ComponentName(r9.packageName, r9.name));
        r8.setPackage(r9.packageName);
        boolean r10 = ZeusTransformUtils.bindService(context, r8, connection, 1, "com.obric.memorydata.plugin");
        if (r10 == true) goto L25;
        Logger r11 = Logger.INSTANCE;
        StringBuilder r12 = new StringBuilder().append("not found service ");
        ComponentName r13 = r8.getComponent();
        if (r13 == null) goto L24;
        r6 = r13.getShortClassName();
    L24:
        r11.w(TAG, r12.append(r6).toString());
    L25:
        return r10;
    L14:
        r7 = null;
        goto L15
    }

    private final boolean isCancelled(String r2, long r3) {
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(businessMap.get(r2), Long.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
    L7:
        Logger.INSTANCE.d(TAG, "ignore expired search");
        return true;
    L6:
        if (r1.longValue() != r3) goto L7;
        return false;
    }

    private final void unbindService() {
        if (isBound == false) goto L6;
        ZeusTransformUtils.unbindService(context, connection, "com.obric.memorydata.plugin");
        isBound = false;
        return;
    }

    public final void cancel(String r3) {
        Intrinsics.checkNotNullParameter(r3, "businessName");
        MemoryServiceChecker r2 = MemoryServiceChecker.INSTANCE;
        Context r0 = context;
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        if (r2.checkGlobalSearchServiceAvailable(r0) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip cancel");
        return;
    L6:
        businessMap.remove(r3);
        if (isBound == false) goto L17;
        IGlobalSearchService r4 = service;     // Catch: RemoteException -> L12
        if (r4 == null) goto L18;
        r4.cancel(r3);     // Catch: RemoteException -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void startGlobalSearch(String r4, GlobalSearchRequest r5, IGlobalSearchCallback r6) {
        IGlobalSearchCallback r7 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r6, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "businessName");
        Intrinsics.checkNotNullParameter(r5, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r7, "callback");
        MemoryServiceChecker r0 = MemoryServiceChecker.INSTANCE;
        Context r1 = context;
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        if (r0.checkGlobalSearchServiceAvailable(r1) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip startGlobalSearch");
        r7.onError(6, -1, "Global search service is not available");
        return;
    L6:
        b r2 = new b(r7, r4, r5);
        if (isBound == false) goto L9;
        r2.invoke();
        return;
    L9:
        pendingOperations.add(r2);
        bindService();
    }

    public final void stop() {
        MemoryServiceChecker r0 = MemoryServiceChecker.INSTANCE;
        Context r1 = context;
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        if (r0.checkGlobalSearchServiceAvailable(r1) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip stop");
        return;
    L6:
        businessMap.clear();
        unbindService();
    }
}
