package com.obric.capabilitykit.search;

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
import androidx.profileinstaller.ProfileVerifier;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.capabilitykit.entity.search.EntityChangeMonitorRequest;
import com.obric.capabilitykit.entity.search.EntityChangeResult;
import com.obric.capabilitykit.entity.search.IEntityChangeCallback;
import com.obric.capabilitykit.entity.search.IInAppSearchService;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.logger.Logger;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0006\u0010\u001e\u001a\u00020\u001aJ\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040 2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u001e\u0010'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020*J\u0006\u0010+\u001a\u00020\u001aJ\u0006\u0010,\u001a\u00020\u001aJ\b\u0010-\u001a\u00020\u001aH\u0002J\u0006\u0010.\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/capabilitykit/search/InAppSearchClient;", "", "()V", "ACTION_SEARCH_SERVICE", "", "TAG", "businessMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "connection", "com/obric/capabilitykit/search/InAppSearchClient$connection$1", "Lcom/obric/capabilitykit/search/InAppSearchClient$connection$1;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isBound", "", "mainHandler", "Landroid/os/Handler;", "pendingOperations", "Ljava/util/Queue;", "Lkotlin/Function0;", "service", "Lcom/obric/capabilitykit/entity/search/IInAppSearchService;", "bindService", "cancel", "", "businessName", "isCancelled", "timestamp", "prepareSearch", "queryServicePackagesByAction", "", "action", "registerEntityObserver", "entityChangeMonitorRequest", "Lcom/obric/capabilitykit/entity/search/EntityChangeMonitorRequest;", "callback", "Lcom/obric/capabilitykit/search/IAppEntityChangeCallback;", "startAppSearch", "request", "Lcom/obric/capabilitykit/entity/search/InAppSearchRequest;", "Lcom/obric/capabilitykit/search/IAppSearchCallback;", "stop", "stopSearch", "unbindService", "unregisterEntityObserver", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class InAppSearchClient {
    private static final String ACTION_SEARCH_SERVICE = "com.obric.memorydata.action.SEARCH_SERVICE";
    public static final InAppSearchClient INSTANCE = null;
    private static final String TAG = "InAppSearchClient";
    private static final ConcurrentHashMap<String, Long> businessMap = null;
    private static final a connection = null;
    private static final Context context = null;
    private static boolean isBound;
    private static final Handler mainHandler = null;
    private static final Queue<Function0<Object>> pendingOperations = null;
    private static IInAppSearchService service;

    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r3, IBinder r4) {
            InAppSearchClient r0 = InAppSearchClient.INSTANCE;
            InAppSearchClient.access$setService$p(IInAppSearchService.Stub.asInterface(r4));
            Logger.INSTANCE.d(InAppSearchClient.TAG, "onServiceConnected " + r3);
            InAppSearchClient.access$setBound$p(true);
            ThreadMethodProxy.start(new PthreadThreadV2(new zia.a(), "InAppSearchClient$a"));
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r4) {
            Logger.INSTANCE.d(InAppSearchClient.TAG, "onServiceDisconnected " + r4);
            InAppSearchClient.access$setService$p(null);
            InAppSearchClient.access$setBound$p(false);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Lkotlin/Unit;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class b extends Lambda implements Function0<Unit> {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
            super(0);
        }

        public final Unit a() {
            IInAppSearchService r0 = InAppSearchClient.access$getService$p();     // Catch: Throwable -> L7
            if (r0 == null) goto L6;
            r0.prepareSearch();     // Catch: Throwable -> L7
            return Unit.INSTANCE;
        L6:
            return null;
        L7:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(InAppSearchClient.TAG, "exception " + th.getMessage());
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class c extends Lambda implements Function0<Object> {
        public final /* synthetic */ IAppEntityChangeCallback a;
        public final /* synthetic */ EntityChangeMonitorRequest b;

        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/obric/capabilitykit/search/InAppSearchClient$registerEntityObserver$operation$1$1", "Lcom/obric/capabilitykit/entity/search/IEntityChangeCallback$Stub;", "onChange", "", "result", "Lcom/obric/capabilitykit/entity/search/EntityChangeResult;", "onError", "errorCode", "", "errorMsg", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
        public static final class a extends IEntityChangeCallback.Stub {
            public final /* synthetic */ IAppEntityChangeCallback a;

            public a(IAppEntityChangeCallback r1) {
                this.a = r1;
            }

            private static final void a(IAppEntityChangeCallback r1, int r2, String r3) {
                Intrinsics.checkNotNullParameter(r1, "$callback");
                Intrinsics.checkNotNullParameter(r3, "$errorMsg");
                r1.onError(r2, r3);
            }

            private static final void a(IAppEntityChangeCallback r1, EntityChangeResult r2) {
                Intrinsics.checkNotNullParameter(r1, "$callback");
                Intrinsics.checkNotNullParameter(r2, "$result");
                r1.onChange(r2);
            }

            public static /* synthetic */ void b(IAppEntityChangeCallback r0, EntityChangeResult r1) {
                a(r0, r1);
            }

            public static /* synthetic */ void c(IAppEntityChangeCallback r0, int r1, String r2) {
                a(r0, r1, r2);
            }

            @Override // com.obric.capabilitykit.entity.search.IEntityChangeCallback
            public void onChange(EntityChangeResult r4) {
                Intrinsics.checkNotNullParameter(r4, "result");
                InAppSearchClient.access$getMainHandler$p().post(new zia.c(this.a, r4));
            }

            @Override // com.obric.capabilitykit.entity.search.IEntityChangeCallback
            public void onError(int r4, String r5) {
                Intrinsics.checkNotNullParameter(r5, "errorMsg");
                Logger.INSTANCE.w(InAppSearchClient.TAG, "onError: " + r4 + ' ' + r5);
                InAppSearchClient.access$getMainHandler$p().post(new zia.d(this.a, r4, r5));
            }
        }

        public c(IAppEntityChangeCallback r1, EntityChangeMonitorRequest r2) {
            this.a = r1;
            this.b = r2;
            super(0);
        }

        public final Object invoke() {
            int r1 = yia.a.a;     // Catch: Throwable -> L15
            if (yia.a.b(InAppSearchClient.access$getContext$p()) == MemoryServiceStatus.AVAILABLE) goto L7;
            Logger.INSTANCE.w(InAppSearchClient.TAG, "Memory search service is not available, skip registerEntityObserver");     // Catch: Throwable -> L15
            this.a.onError(6, "Memory search service is disabled");     // Catch: Throwable -> L15
        L12:
            return Unit.INSTANCE;
        L7:
            if (InAppSearchClient.access$getService$p() != null) goto L9;
            this.a.onError(2, "service not ready");     // Catch: Throwable -> L15
            goto L12
        L9:
            IInAppSearchService r2 = InAppSearchClient.access$getService$p();     // Catch: Throwable -> L15
            if (r2 == null) goto L14;
            r2.registerEntityObserver(this.b, new a(this.a));     // Catch: Throwable -> L15
            goto L12
        L14:
            return null;
        L15:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(InAppSearchClient.TAG, "exception " + th.getMessage());
            return Boolean.valueOf(InAppSearchClient.access$getMainHandler$p().post(new zia.b(this.a, th)));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class d extends Lambda implements Function0<Object> {
        public final /* synthetic */ IAppSearchCallback a;
        public final /* synthetic */ String b;
        public final /* synthetic */ InAppSearchRequest c;

        public d(IAppSearchCallback r1, String r2, InAppSearchRequest r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            super(0);
        }

        public final Object invoke() {
        L11:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(InAppSearchClient.TAG, "exception " + th.getMessage());
            return Boolean.valueOf(InAppSearchClient.access$getMainHandler$p().post(new zia.e(this.a, th)));
        L3:
            if (InAppSearchClient.access$getService$p() != null) goto L5;
            this.a.onError(2, "service not ready");     // Catch: Throwable -> L11
        L8:
            return Unit.INSTANCE;
        L5:
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L11
            InAppSearchClient.access$getBusinessMap$p().put(this.b, Long.valueOf(r0));     // Catch: Throwable -> L11
            IInAppSearchService r2 = InAppSearchClient.access$getService$p();     // Catch: Throwable -> L11
            if (r2 == null) goto L10;
            r2.startAppSearch(this.b, this.c, new a(this.b, r0, this.a));     // Catch: Throwable -> L11
            goto L8
        L10:
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Lkotlin/Unit;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class e extends Lambda implements Function0<Unit> {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
            super(0);
        }

        public final Unit a() {
            IInAppSearchService r0 = InAppSearchClient.access$getService$p();     // Catch: RemoteException -> L7
            if (r0 == null) goto L6;
            r0.unregisterEntityObserver();     // Catch: RemoteException -> L7
            return Unit.INSTANCE;
        L6:
            return null;
        L7:
            e = move-exception;
            e.printStackTrace();
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return a();
        }
    }

    static {
        INSTANCE = new InAppSearchClient();
        context = AppHost.Companion.getApplication().getApplicationContext();
        mainHandler = new Handler(Looper.getMainLooper());
        pendingOperations = new LinkedList();
        businessMap = new ConcurrentHashMap();
        connection = new a();
    }

    private InAppSearchClient() {
    }

    public static final /* synthetic */ ConcurrentHashMap access$getBusinessMap$p() {
        return businessMap;
    }

    public static final /* synthetic */ Context access$getContext$p() {
        return context;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p() {
        return mainHandler;
    }

    public static final /* synthetic */ Queue access$getPendingOperations$p() {
        return pendingOperations;
    }

    public static final /* synthetic */ IInAppSearchService access$getService$p() {
        return service;
    }

    public static final /* synthetic */ boolean access$isCancelled(InAppSearchClient r0, String r1, long r2) {
        return r0.isCancelled(r1, r2);
    }

    public static final /* synthetic */ void access$setBound$p(boolean r0) {
        isBound = r0;
    }

    public static final /* synthetic */ void access$setService$p(IInAppSearchService r0) {
        service = r0;
    }

    private final boolean bindService() {
        Logger r0 = Logger.INSTANCE;
        r0.d(TAG, "start bindService");
        Context r1 = context;
        List<String> r4 = queryServicePackagesByAction(r1, ACTION_SEARCH_SERVICE);
        if (r4.size() != 1) goto L12;
        Intent r5 = new Intent(ACTION_SEARCH_SERVICE);
        r5.setPackage((String) CollectionsKt.first(r4));
        boolean r2 = r1.bindService(r5, connection, 1);
        if (r2 == true) goto L11;
        StringBuilder r3 = new StringBuilder("not found service ");
        ComponentName r6 = r5.getComponent();
        if (r6 == null) goto L9;
        String r7 = r6.getShortClassName();
    L10:
        r3.append(r7);
        r0.w(TAG, r3.toString());
        goto L11
    L9:
        r7 = null;
    L11:
        return r2;
    L12:
        r0.w(TAG, "not found trusted service com.obric.memorydata.action.SEARCH_SERVICE, result = " + r4);
        return false;
    }

    private final boolean isCancelled(String r3, long r4) {
        Long r5 = businessMap.get(r3);
        if (r5 != null) goto L6;
    L7:
        Logger.INSTANCE.d(TAG, "ignore expired search");
        return true;
    L6:
        if (r5.longValue() != r4) goto L7;
        return false;
    }

    private final void unbindService() {
        if (isBound == false) goto L6;
        context.unbindService(connection);
        isBound = false;
        return;
    }

    public final void cancel(String r3) {
        Intrinsics.checkNotNullParameter(r3, "businessName");
        int r0 = yia.a.a;
        if (yia.a.b(context) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip cancel");
        return;
    L6:
        businessMap.remove(r3);
        if (isBound == false) goto L17;
        IInAppSearchService r1 = service;     // Catch: RemoteException -> L12
        if (r1 == null) goto L18;
        r1.cancel(r3);     // Catch: RemoteException -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void prepareSearch() {
        int r0 = yia.a.a;
        if (yia.a.b(context) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip prepareSearch");
        return;
    L6:
        b r1 = b.a;
        if (isBound == false) goto L9;
        r1.invoke();
        return;
    L9:
        pendingOperations.add(r1);
        bindService();
    }

    public final List<String> queryServicePackagesByAction(Context r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "action");
        Intent r0 = new Intent(r5);
        List<ResolveInfo> r6 = r4.getPackageManager().queryIntentServices(r0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ);
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        ServiceInfo r1 = ((ResolveInfo) r8.next()).serviceInfo;
        if (r1 == null) goto L8;
        String r2 = r1.packageName;
    L9:
        if (r2 == null) goto L4;
        r7.add(r2);
        goto L4
    L8:
        r2 = null;
        goto L9
    L11:
        List r9 = CollectionsKt.distinct(r7);
        ArrayList r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L13:
        if (r11.hasNext() == false) goto L17;
        Object r3 = r11.next();
        PackageUtils r12 = PackageUtils.INSTANCE;
        if (r12.checkSignature((String) r3) == false) goto L13;
        r10.add(r3);
        goto L13
    L17:
        return r10;
    }

    public final void registerEntityObserver(EntityChangeMonitorRequest r2, IAppEntityChangeCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "entityChangeMonitorRequest");
        Intrinsics.checkNotNullParameter(r3, "callback");
        c r0 = new c(r3, r2);
        if (isBound == false) goto L5;
        r0.invoke();
        return;
    L5:
        pendingOperations.add(r0);
        bindService();
    }

    public final void startAppSearch(String r3, InAppSearchRequest r4, IAppSearchCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "businessName");
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "callback");
        int r0 = yia.a.a;
        if (yia.a.b(context) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip startAppSearch");
        r5.onError(6, "Memory search service is disabled");
        return;
    L6:
        d r1 = new d(r5, r3, r4);
        if (isBound == false) goto L9;
        r1.invoke();
        return;
    L9:
        pendingOperations.add(r1);
        bindService();
    }

    public final void stop() {
        int r0 = yia.a.a;
        if (yia.a.b(context) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip stop");
        return;
    L6:
        businessMap.clear();
        unbindService();
    }

    public final void stopSearch() {
        int r0 = yia.a.a;
        if (yia.a.b(context) == MemoryServiceStatus.AVAILABLE) goto L7;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip stopSearch");
        return;
    L7:
        if (isBound == false) goto L17;
        IInAppSearchService r1 = service;     // Catch: RemoteException -> L12
        if (r1 == null) goto L18;
        r1.stopSearch();     // Catch: RemoteException -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void unregisterEntityObserver() {
        int r0 = yia.a.a;
        if (yia.a.b(context) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip unregisterEntityObserver");
        return;
    L6:
        e r1 = e.a;
        if (isBound == false) goto L9;
        r1.invoke();
        return;
    L9:
        pendingOperations.add(r1);
        bindService();
    }
}
