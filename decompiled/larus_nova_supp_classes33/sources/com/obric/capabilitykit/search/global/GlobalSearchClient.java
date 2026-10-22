package com.obric.capabilitykit.search.global;

import aja.c;
import aja.d;
import aja.e;
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
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.capabilitykit.entity.search.global.GlobalSearchRequest;
import com.obric.capabilitykit.entity.search.global.GlobalSearchResult;
import com.obric.capabilitykit.entity.search.global.IGlobalSearchService;
import com.obric.capabilitykit.logger.Logger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u001e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u001bJ\b\u0010%\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/search/global/GlobalSearchClient;", "", "()V", "NONE_ERROR_ENTITY_TYPE", "", "TAG", "", "businessMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "connection", "com/obric/capabilitykit/search/global/GlobalSearchClient$connection$1", "Lcom/obric/capabilitykit/search/global/GlobalSearchClient$connection$1;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isBound", "", "mainHandler", "Landroid/os/Handler;", "pendingOperations", "Ljava/util/Queue;", "Lkotlin/Function0;", "service", "Lcom/obric/capabilitykit/entity/search/global/IGlobalSearchService;", "bindService", WindowEvent.WindowOpenPerfResult.CANCEL, "", "businessName", "isCancelled", "timestamp", "startGlobalSearch", Ext.KEY_REQUEST, "Lcom/obric/capabilitykit/entity/search/global/GlobalSearchRequest;", "callback", "Lcom/obric/capabilitykit/search/global/IGlobalSearchCallback;", "stop", "unbindService", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r3, IBinder r4) {
            GlobalSearchClient r0 = GlobalSearchClient.INSTANCE;
            GlobalSearchClient.access$setService$p(IGlobalSearchService.Stub.asInterface(r4));
            Logger.INSTANCE.d(GlobalSearchClient.TAG, "onServiceConnected " + r3);
            GlobalSearchClient.access$setBound$p(true);
        L4:
            if ((!GlobalSearchClient.access$getPendingOperations$p().isEmpty()) == false) goto L8;
            Function0 r5 = (Function0) GlobalSearchClient.access$getPendingOperations$p().poll();
            if (r5 == null) goto L4;
            r5.invoke();
            goto L4
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r4) {
            Logger.INSTANCE.d(GlobalSearchClient.TAG, "onServiceDisconnected " + r4);
            GlobalSearchClient.access$setService$p(null);
            GlobalSearchClient.access$setBound$p(false);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<Object> {
        public final /* synthetic */ IGlobalSearchCallback a;
        public final /* synthetic */ String b;
        public final /* synthetic */ GlobalSearchRequest c;

        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/capabilitykit/search/global/GlobalSearchClient$startGlobalSearch$operation$1$1", "Lcom/obric/capabilitykit/entity/search/global/IGlobalSearchCallback$Stub;", "onAllCompleted", "", "onCompleted", "entityType", "", "onError", "errorCode", "errorMsg", "", "onSearchResult", WindowEvent.Params.RESULT, "Lcom/obric/capabilitykit/entity/search/global/GlobalSearchResult;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback.Stub {
            public final /* synthetic */ String a;
            public final /* synthetic */ long b;
            public final /* synthetic */ IGlobalSearchCallback c;

            public a(String r1, long r2, IGlobalSearchCallback r4) {
                this.a = r1;
                this.b = r2;
                this.c = r4;
            }

            private static final void a(String r1, long r2, IGlobalSearchCallback r4) {
                Intrinsics.checkNotNullParameter(r1, "$businessName");
                Intrinsics.checkNotNullParameter(r4, "$callback");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r1, r2) == true) goto L6;
                r4.onAllCompleted();
                GlobalSearchClient.access$getBusinessMap$p().remove(r1);
                return;
            }

            private static final void a(String r1, long r2, IGlobalSearchCallback r4, int r5) {
                Intrinsics.checkNotNullParameter(r1, "$businessName");
                Intrinsics.checkNotNullParameter(r4, "$callback");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r1, r2) == true) goto L6;
                r4.onCompleted(r5);
                return;
            }

            private static final void a(String r1, long r2, IGlobalSearchCallback r4, int r5, String r6) {
                Intrinsics.checkNotNullParameter(r1, "$businessName");
                Intrinsics.checkNotNullParameter(r4, "$callback");
                Intrinsics.checkNotNullParameter(r6, "$errorMsg");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r1, r2) == true) goto L6;
                r4.onError(r5, -1, r6);
                GlobalSearchClient.access$getBusinessMap$p().remove(r1);
                return;
            }

            private static final void a(String r1, long r2, IGlobalSearchCallback r4, GlobalSearchResult r5) {
                Intrinsics.checkNotNullParameter(r1, "$businessName");
                Intrinsics.checkNotNullParameter(r4, "$callback");
                Intrinsics.checkNotNullParameter(r5, "$result");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r1, r2) == true) goto L6;
                r4.onSearchResult(r5);
                return;
            }

            public static /* synthetic */ void b(String r0, long r1, IGlobalSearchCallback r3) {
                a(r0, r1, r3);
            }

            public static /* synthetic */ void c(String r0, long r1, IGlobalSearchCallback r3, int r4) {
                a(r0, r1, r3, r4);
            }

            public static /* synthetic */ void d(String r0, long r1, IGlobalSearchCallback r3, int r4, String r5) {
                a(r0, r1, r3, r4, r5);
            }

            public static /* synthetic */ void e(String r0, long r1, IGlobalSearchCallback r3, GlobalSearchResult r4) {
                a(r0, r1, r3, r4);
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onAllCompleted() {
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onAllCompleted");
                Handler r0 = GlobalSearchClient.access$getMainHandler$p();
                final String r1 = this.a;
                final long r2 = this.b;
                final IGlobalSearchCallback r4 = this.c;
                r0.post(new aja.b(r1, r2, r4));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onCompleted(final int r9) {
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onCompleted " + r9);
                Handler r0 = GlobalSearchClient.access$getMainHandler$p();
                final String r2 = this.a;
                final long r3 = this.b;
                final IGlobalSearchCallback r5 = this.c;
                r0.post(new e(r2, r3, r5, r9));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onError(final int r9, int r10, final String r11) {
                Intrinsics.checkNotNullParameter(r11, "errorMsg");
                Logger.INSTANCE.w(GlobalSearchClient.TAG, "onError: " + r9 + ' ' + r11);
                Handler r12 = GlobalSearchClient.access$getMainHandler$p();
                final String r1 = this.a;
                final long r2 = this.b;
                final IGlobalSearchCallback r4 = this.c;
                r12.post(new c(r1, r2, r4, r9, r11));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onSearchResult(final GlobalSearchResult r9) {
                Intrinsics.checkNotNullParameter(r9, WindowEvent.Params.RESULT);
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onSearchResult: " + r9);
                Handler r0 = GlobalSearchClient.access$getMainHandler$p();
                final String r2 = this.a;
                final long r3 = this.b;
                final IGlobalSearchCallback r5 = this.c;
                r0.post(new d(r2, r3, r5, r9));
            }
        }

        public b(IGlobalSearchCallback r1, String r2, GlobalSearchRequest r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            super(0);
        }

        public final Object invoke() {
        L11:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(GlobalSearchClient.TAG, "exception " + th.getMessage());
            Handler r1 = GlobalSearchClient.access$getMainHandler$p();
            final IGlobalSearchCallback r2 = this.a;
            return Boolean.valueOf(r1.post(new aja.a(r2, th)));
        L3:
            if (GlobalSearchClient.access$getService$p() != null) goto L5;
            this.a.onError(2, -1, "service not ready");     // Catch: Throwable -> L11
        L8:
            return Unit.INSTANCE;
        L5:
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L11
            GlobalSearchClient.access$getBusinessMap$p().put(this.b, Long.valueOf(r0));     // Catch: Throwable -> L11
            IGlobalSearchService r3 = GlobalSearchClient.access$getService$p();     // Catch: Throwable -> L11
            if (r3 == null) goto L10;
            r3.startGlobalSearch(this.b, this.c, new a(this.b, r0, this.a));     // Catch: Throwable -> L11
            goto L8
        L10:
            return null;
        }
    }

    static {
        INSTANCE = new GlobalSearchClient();
        context = AppHost.Companion.getApplication().getApplicationContext();
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

    public static final /* synthetic */ void access$setService$p(IGlobalSearchService r0) {
        service = r0;
    }

    private final boolean bindService() {
        Logger.INSTANCE.d(TAG, "start bindService");
        Intent r0 = new Intent("com.obric.memorydata.action.GLOBAL_SEARCH_SERVICE");
        List<ResolveInfo> r1 = context.getPackageManager().queryIntentServices(r0, 0);
        ArrayList r4 = new ArrayList();
        Iterator<T> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        ServiceInfo r5 = ((ResolveInfo) r2.next()).serviceInfo;
        if (r5 == null) goto L4;
        r4.add(r5);
        goto L4
    L8:
        Iterator r3 = r4.iterator();
    L9:
        String r6 = null;
        if (r3.hasNext() == false) goto L14;
        Object r7 = r3.next();
        if (PackageUtils.INSTANCE.checkSignature(((ServiceInfo) r7).packageName) == false) goto L9;
    L15:
        ServiceInfo r8 = (ServiceInfo) r7;
        if (r8 != null) goto L19;
        Logger.INSTANCE.e(TAG, "No trusted service found for action: " + r0.getAction());
        return false;
    L19:
        r0.setComponent(new ComponentName(r8.packageName, r8.name));
        r0.setPackage(r8.packageName);
        boolean r9 = context.bindService(r0, connection, 1);
        if (r9 == true) goto L25;
        Logger r10 = Logger.INSTANCE;
        StringBuilder r11 = new StringBuilder("not found service ");
        ComponentName r12 = r0.getComponent();
        if (r12 == null) goto L24;
        r6 = r12.getShortClassName();
    L24:
        r11.append(r6);
        r10.w(TAG, r11.toString());
    L25:
        return r9;
    L14:
        r7 = null;
        goto L15
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

    public final void stop() {
        int r0 = yia.a.a;
        Context r1 = context;
        Intrinsics.checkNotNullParameter(r1, "context");
        if (yia.a.c(r1, "com.obric.memorydata.action.GLOBAL_SEARCH_SERVICE") == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip stop");
        return;
    L6:
        businessMap.clear();
        unbindService();
    }

    public final void cancel(String r3) {
        Intrinsics.checkNotNullParameter(r3, "businessName");
        int r0 = yia.a.a;
        Context r1 = context;
        Intrinsics.checkNotNullParameter(r1, "context");
        if (yia.a.c(r1, "com.obric.memorydata.action.GLOBAL_SEARCH_SERVICE") == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip cancel");
        return;
    L6:
        businessMap.remove(r3);
        if (isBound == false) goto L17;
        IGlobalSearchService r2 = service;     // Catch: RemoteException -> L12
        if (r2 == null) goto L18;
        r2.cancel(r3);     // Catch: RemoteException -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void startGlobalSearch(String r3, GlobalSearchRequest r4, IGlobalSearchCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "businessName");
        Intrinsics.checkNotNullParameter(r4, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r5, "callback");
        int r0 = yia.a.a;
        Context r1 = context;
        Intrinsics.checkNotNullParameter(r1, "context");
        if (yia.a.c(r1, "com.obric.memorydata.action.GLOBAL_SEARCH_SERVICE") == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip startGlobalSearch");
        r5.onError(6, -1, "Global search service is not available");
        return;
    L6:
        b r2 = new b(r5, r3, r4);
        if (isBound == false) goto L9;
        r2.invoke();
        return;
    L9:
        pendingOperations.add(r2);
        bindService();
    }
}
