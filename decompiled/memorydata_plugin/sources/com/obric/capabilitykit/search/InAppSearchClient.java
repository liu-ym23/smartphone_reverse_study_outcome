package com.obric.capabilitykit.search;

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
import com.obric.capabilitykit.entity.search.EntityChangeMonitorRequest;
import com.obric.capabilitykit.entity.search.EntityChangeResult;
import com.obric.capabilitykit.entity.search.IEntityChangeCallback;
import com.obric.capabilitykit.entity.search.IInAppSearchCallback;
import com.obric.capabilitykit.entity.search.IInAppSearchService;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.entity.search.InAppSearchResult;
import com.obric.capabilitykit.entity.search.InAppSearchResultWithoutEntity;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0006\u0010\u001e\u001a\u00020\u001aJ\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040 2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u001e\u0010'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020*J\u0006\u0010+\u001a\u00020\u001aJ\u0006\u0010,\u001a\u00020\u001aJ\b\u0010-\u001a\u00020\u001aH\u0002J\u0006\u0010.\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/capabilitykit/search/InAppSearchClient;", "", "()V", "ACTION_SEARCH_SERVICE", "", "TAG", "businessMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", WsConstants.KEY_CONNECTION, "com/obric/capabilitykit/search/InAppSearchClient$connection$1", "Lcom/obric/capabilitykit/search/InAppSearchClient$connection$1;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isBound", "", "mainHandler", "Landroid/os/Handler;", "pendingOperations", "Ljava/util/Queue;", "Lkotlin/Function0;", "service", "Lcom/obric/capabilitykit/entity/search/IInAppSearchService;", "bindService", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "businessName", "isCancelled", "timestamp", "prepareSearch", "queryServicePackagesByAction", "", "action", "registerEntityObserver", "entityChangeMonitorRequest", "Lcom/obric/capabilitykit/entity/search/EntityChangeMonitorRequest;", "callback", "Lcom/obric/capabilitykit/search/IAppEntityChangeCallback;", "startAppSearch", Ext.KEY_REQUEST, "Lcom/obric/capabilitykit/entity/search/InAppSearchRequest;", "Lcom/obric/capabilitykit/search/IAppSearchCallback;", "stop", "stopSearch", "unbindService", "unregisterEntityObserver", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/capabilitykit/search/InAppSearchClient$connection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", ActivityLifecycle.NAME, "Landroid/content/ComponentName;", "binder", "Landroid/os/IBinder;", "onServiceDisconnected", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements ServiceConnection {
        public a() {
        }

        private static final void a() {
        L3:
            if ((!InAppSearchClient.access$getPendingOperations$p().isEmpty()) == false) goto L7;
            Function0 r0 = (Function0) ZeusTransformUtils.preCheckCast(InAppSearchClient.access$getPendingOperations$p().poll(), Function0.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L3;
            r0.invoke();
            goto L3
        }

        public static /* synthetic */ void lambda$xMSkcGzi_FM8nzlUTjitRYf_NNI() {
            a();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r2, IBinder r3) {
            IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            InAppSearchClient r4 = InAppSearchClient.INSTANCE;
            InAppSearchClient.access$setService$p(IInAppSearchService.Stub.asInterface(r1));
            Logger.INSTANCE.d(InAppSearchClient.TAG, "onServiceConnected " + r2);
            InAppSearchClient.access$setBound$p(true);
            new Thread($$Lambda$InAppSearchClient$a$xMSkcGzi_FM8nzlUTjitRYf_NNI.INSTANCE).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r3) {
            Logger.INSTANCE.d(InAppSearchClient.TAG, "onServiceDisconnected " + r3);
            InAppSearchClient r2 = InAppSearchClient.INSTANCE;
            InAppSearchClient.access$setService$p(null);
            InAppSearchClient.access$setBound$p(false);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7609a = null;

        static {
            f7609a = new b();
        }

        public b() {
            super(0);
        }

        public final Unit a() {
            IInAppSearchService r3 = InAppSearchClient.access$getService$p();     // Catch: Throwable -> L7
            if (r3 == null) goto L6;
            r3.prepareSearch();     // Catch: Throwable -> L7
            return Unit.INSTANCE;
        L6:
            return null;
        L7:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(InAppSearchClient.TAG, "exception " + th.getMessage());
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* synthetic */ Unit invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IAppEntityChangeCallback f7610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EntityChangeMonitorRequest f7611b;

        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/obric/capabilitykit/search/InAppSearchClient$registerEntityObserver$operation$1$1", "Lcom/obric/capabilitykit/entity/search/IEntityChangeCallback$Stub;", "onChange", "", "result", "Lcom/obric/capabilitykit/entity/search/EntityChangeResult;", "onError", "errorCode", "", DTraitConstant.ERROR, "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends IEntityChangeCallback.Stub {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IAppEntityChangeCallback f7612a;

            public a(IAppEntityChangeCallback r3) {
                this.f7612a = (IAppEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAppEntityChangeCallback.class, "com.obric.memorydata.plugin");
            }

            private static final void a(IAppEntityChangeCallback r2, int r3, String r4) {
                IAppEntityChangeCallback r5 = (IAppEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityChangeCallback.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r5, "$callback");
                Intrinsics.checkNotNullParameter(r4, "$errorMsg");
                r5.onError(r3, r4);
            }

            private static final void a(IAppEntityChangeCallback r2, EntityChangeResult r3) {
                IAppEntityChangeCallback r4 = (IAppEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityChangeCallback.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "$callback");
                Intrinsics.checkNotNullParameter(r3, "$result");
                r4.onChange(r3);
            }

            public static /* synthetic */ void lambda$MBBpeLO7AFlkGu6ujqV986rfyb4(IAppEntityChangeCallback r0, EntityChangeResult r1) {
                a(r0, r1);
            }

            public static /* synthetic */ void lambda$geX8TvJO2QDvzLJPLNBPvr2dfUE(IAppEntityChangeCallback r0, int r1, String r2) {
                a(r0, r1, r2);
            }

            @Override // com.obric.capabilitykit.entity.search.IEntityChangeCallback
            public void onChange(final EntityChangeResult r3) {
                Intrinsics.checkNotNullParameter(r3, "result");
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final IAppEntityChangeCallback r2 = this.f7612a;
                r0.post(new $$Lambda$InAppSearchClient$c$a$MBBpeLO7AFlkGu6ujqV986rfyb4(r2, r3));
            }

            @Override // com.obric.capabilitykit.entity.search.IEntityChangeCallback
            public void onError(final int r4, final String r5) {
                Intrinsics.checkNotNullParameter(r5, DTraitConstant.ERROR);
                Logger.INSTANCE.w(InAppSearchClient.TAG, "onError: " + r4 + ' ' + r5);
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final IAppEntityChangeCallback r3 = this.f7612a;
                r0.post(new $$Lambda$InAppSearchClient$c$a$geX8TvJO2QDvzLJPLNBPvr2dfUE(r3, r4, r5));
            }
        }

        public c(IAppEntityChangeCallback r3, EntityChangeMonitorRequest r4) {
            this.f7610a = (IAppEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAppEntityChangeCallback.class, "com.obric.memorydata.plugin");
            this.f7611b = r4;
            super(0);
        }

        private static final void a(IAppEntityChangeCallback r2, Throwable r3) {
            IAppEntityChangeCallback r4 = (IAppEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityChangeCallback.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "$callback");
            Intrinsics.checkNotNullParameter(r3, "$e");
            String r5 = r3.getMessage();
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            r4.onError(1, r5);
        }

        /* JADX INFO: renamed from: lambda$oGDEIdie0g-vMy3k6uqLBju-nCM, reason: not valid java name */
        public static /* synthetic */ void m411lambda$oGDEIdie0gvMy3k6uqLBjunCM(IAppEntityChangeCallback r0, Throwable r1) {
            a(r0, r1);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MemoryServiceChecker r2 = MemoryServiceChecker.INSTANCE;     // Catch: Throwable -> L16
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(InAppSearchClient.access$getContext$p(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            Intrinsics.checkNotNullExpressionValue(r0, "context");     // Catch: Throwable -> L16
            if (r2.checkSearchServiceAvailable(r0) == MemoryServiceStatus.AVAILABLE) goto L8;
            Logger.INSTANCE.w(InAppSearchClient.TAG, "Memory search service is not available, skip registerEntityObserver");     // Catch: Throwable -> L16
            IAppEntityChangeCallback r1 = this.f7610a;     // Catch: Throwable -> L16
            int r3 = 6;
            String r4 = "Memory search service is disabled";
        L6:
            r1.onError(r3, r4);     // Catch: Throwable -> L16
        L13:
            return Unit.INSTANCE;
        L8:
            if (InAppSearchClient.access$getService$p() != null) goto L10;
            r1 = this.f7610a;     // Catch: Throwable -> L16
            r3 = 2;
            r4 = "service not ready";
            goto L6
        L10:
            IInAppSearchService r5 = InAppSearchClient.access$getService$p();     // Catch: Throwable -> L16
            if (r5 == null) goto L15;
            r5.registerEntityObserver(this.f7611b, new a(this.f7610a));     // Catch: Throwable -> L16
            goto L13
        L15:
            return null;
        L16:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(InAppSearchClient.TAG, "exception " + th.getMessage());
            Handler r6 = InAppSearchClient.access$getMainHandler$p();
            final IAppEntityChangeCallback r7 = this.f7610a;
            return Boolean.valueOf(r6.post(new $$Lambda$InAppSearchClient$c$oGDEIdie0gvMy3k6uqLBjunCM(r7, th)));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IAppSearchCallback f7613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7614b;
        public final /* synthetic */ InAppSearchRequest c;

        @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/capabilitykit/search/InAppSearchClient$startAppSearch$operation$1$1", "Lcom/obric/capabilitykit/entity/search/IInAppSearchCallback$Stub;", "onCompleted", "", "onError", "errorCode", "", DTraitConstant.ERROR, "", "onSearchResult", "result", "Lcom/obric/capabilitykit/entity/search/InAppSearchResult;", "onSearchResultWithoutEntity", "Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends IInAppSearchCallback.Stub {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f7615a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f7616b;
            public final /* synthetic */ IAppSearchCallback c;

            public a(String r3, long r4, IAppSearchCallback r6) {
                IAppSearchCallback r7 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r6, IAppSearchCallback.class, "com.obric.memorydata.plugin");
                this.f7615a = r3;
                this.f7616b = r4;
                this.c = r7;
            }

            private static final void a(String r2, long r3, IAppSearchCallback r5) {
                IAppSearchCallback r6 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IAppSearchCallback.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "$businessName");
                Intrinsics.checkNotNullParameter(r6, "$callback");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r6.onCompleted();
                InAppSearchClient.access$getBusinessMap$p().remove(r2);
                return;
            }

            private static final void a(String r2, long r3, IAppSearchCallback r5, int r6, String r7) {
                IAppSearchCallback r8 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IAppSearchCallback.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "$businessName");
                Intrinsics.checkNotNullParameter(r8, "$callback");
                Intrinsics.checkNotNullParameter(r7, "$errorMsg");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r8.onError(r6, r7);
                InAppSearchClient.access$getBusinessMap$p().remove(r2);
                return;
            }

            private static final void a(String r2, long r3, IAppSearchCallback r5, InAppSearchResult r6) {
                IAppSearchCallback r7 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IAppSearchCallback.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "$businessName");
                Intrinsics.checkNotNullParameter(r7, "$callback");
                Intrinsics.checkNotNullParameter(r6, "$result");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r7.onSearchResult(r6);
                return;
            }

            private static final void a(String r2, long r3, IAppSearchCallback r5, InAppSearchResultWithoutEntity r6) {
                IAppSearchCallback r7 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IAppSearchCallback.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "$businessName");
                Intrinsics.checkNotNullParameter(r7, "$callback");
                Intrinsics.checkNotNullParameter(r6, "$result");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r2, r3) == true) goto L6;
                r7.onSearchResultWithoutEntity(r6);
                return;
            }

            public static /* synthetic */ void lambda$M7YiRtclisfG5SQX_uad561zL88(String r0, long r1, IAppSearchCallback r3, int r4, String r5) {
                a(r0, r1, r3, r4, r5);
            }

            /* JADX INFO: renamed from: lambda$MMtM6GzrBtGSw9wXZeHLcJP-s6U, reason: not valid java name */
            public static /* synthetic */ void m412lambda$MMtM6GzrBtGSw9wXZeHLcJPs6U(String r0, long r1, IAppSearchCallback r3) {
                a(r0, r1, r3);
            }

            public static /* synthetic */ void lambda$ZWtYUYYv5POfkGzZOdIwIKcCsO8(String r0, long r1, IAppSearchCallback r3, InAppSearchResultWithoutEntity r4) {
                a(r0, r1, r3, r4);
            }

            /* JADX INFO: renamed from: lambda$kIR1dlnQntc1kjTKjeCj3-P-MJs, reason: not valid java name */
            public static /* synthetic */ void m413lambda$kIR1dlnQntc1kjTKjeCj3PMJs(String r0, long r1, IAppSearchCallback r3, InAppSearchResult r4) {
                a(r0, r1, r3, r4);
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onCompleted() {
                Logger.INSTANCE.d(InAppSearchClient.TAG, "onCompleted");
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final String r1 = this.f7615a;
                final long r2 = this.f7616b;
                final IAppSearchCallback r5 = this.c;
                r0.post(new $$Lambda$InAppSearchClient$d$a$MMtM6GzrBtGSw9wXZeHLcJPs6U(r1, r2, r5));
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onError(final int r9, final String r10) {
                Intrinsics.checkNotNullParameter(r10, DTraitConstant.ERROR);
                Logger.INSTANCE.w(InAppSearchClient.TAG, "onError: " + r9 + ' ' + r10);
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final String r2 = this.f7615a;
                final long r3 = this.f7616b;
                final IAppSearchCallback r5 = this.c;
                r0.post(new $$Lambda$InAppSearchClient$d$a$M7YiRtclisfG5SQX_uad561zL88(r2, r3, r5, r9, r10));
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onSearchResult(final InAppSearchResult r8) {
                Intrinsics.checkNotNullParameter(r8, "result");
                Logger.INSTANCE.d(InAppSearchClient.TAG, "onSearchResult: " + r8);
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final String r2 = this.f7615a;
                final long r3 = this.f7616b;
                final IAppSearchCallback r5 = this.c;
                r0.post(new $$Lambda$InAppSearchClient$d$a$kIR1dlnQntc1kjTKjeCj3PMJs(r2, r3, r5, r8));
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onSearchResultWithoutEntity(final InAppSearchResultWithoutEntity r8) {
                Intrinsics.checkNotNullParameter(r8, "result");
                Logger.INSTANCE.d(InAppSearchClient.TAG, "onSearchResultWithoutEntity");
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final String r2 = this.f7615a;
                final long r3 = this.f7616b;
                final IAppSearchCallback r5 = this.c;
                r0.post(new $$Lambda$InAppSearchClient$d$a$ZWtYUYYv5POfkGzZOdIwIKcCsO8(r2, r3, r5, r8));
            }
        }

        public d(IAppSearchCallback r3, String r4, InAppSearchRequest r5) {
            this.f7613a = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAppSearchCallback.class, "com.obric.memorydata.plugin");
            this.f7614b = r4;
            this.c = r5;
            super(0);
        }

        private static final void a(IAppSearchCallback r2, Throwable r3) {
            IAppSearchCallback r4 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r2, IAppSearchCallback.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "$callback");
            Intrinsics.checkNotNullParameter(r3, "$e");
            String r5 = r3.getMessage();
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            r4.onError(1, r5);
        }

        public static /* synthetic */ void lambda$uYcuRoSw_QM7xokr3pEPv6pJAgo(IAppSearchCallback r0, Throwable r1) {
            a(r0, r1);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
        L11:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(InAppSearchClient.TAG, "exception " + th.getMessage());
            Handler r1 = InAppSearchClient.access$getMainHandler$p();
            final IAppSearchCallback r8 = this.f7613a;
            return Boolean.valueOf(r1.post(new $$Lambda$InAppSearchClient$d$uYcuRoSw_QM7xokr3pEPv6pJAgo(r8, th)));
        L3:
            if (InAppSearchClient.access$getService$p() != null) goto L5;
            this.f7613a.onError(2, "service not ready");     // Catch: Throwable -> L11
        L8:
            return Unit.INSTANCE;
        L5:
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L11
            InAppSearchClient.access$getBusinessMap$p().put(this.f7614b, Long.valueOf(r0));     // Catch: Throwable -> L11
            IInAppSearchService r2 = InAppSearchClient.access$getService$p();     // Catch: Throwable -> L11
            if (r2 == null) goto L10;
            r2.startAppSearch(this.f7614b, this.c, new a(this.f7614b, r0, this.f7613a));     // Catch: Throwable -> L11
            goto L8
        L10:
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f7617a = null;

        static {
            f7617a = new e();
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

        @Override // kotlin.jvm.functions.Function0
        public /* synthetic */ Unit invoke() {
            return a();
        }
    }

    static {
        INSTANCE = new InAppSearchClient();
        context = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
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

    public static final /* synthetic */ void access$setService$p(IInAppSearchService r2) {
        service = (IInAppSearchService) ZeusTransformUtils.wrapperContextForParams(r2, IInAppSearchService.class, "com.obric.memorydata.plugin");
    }

    private final boolean bindService() {
        Logger r0 = Logger.INSTANCE;
        r0.d(TAG, "start bindService");
        Context r2 = context;
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        List<String> r7 = queryServicePackagesByAction(r2, "com.obric.memorydata.action.SEARCH_SERVICE");
        if (r7.size() != 1) goto L12;
        Intent r4 = new Intent("com.obric.memorydata.action.SEARCH_SERVICE");
        r4.setPackage((String) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r7), String.class, "com.obric.memorydata.plugin"));
        boolean r8 = ZeusTransformUtils.bindService(r2, r4, connection, 1, "com.obric.memorydata.plugin");
        if (r8 == true) goto L11;
        StringBuilder r3 = new StringBuilder().append("not found service ");
        ComponentName r5 = r4.getComponent();
        if (r5 == null) goto L9;
        String r6 = r5.getShortClassName();
    L10:
        r0.w(TAG, r3.append(r6).toString());
        goto L11
    L9:
        r6 = null;
    L11:
        return r8;
    L12:
        r0.w(TAG, "not found trusted service com.obric.memorydata.action.SEARCH_SERVICE, result = " + r7);
        return false;
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
        if (r2.checkSearchServiceAvailable(r0) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip cancel");
        return;
    L6:
        businessMap.remove(r3);
        if (isBound == false) goto L17;
        IInAppSearchService r4 = service;     // Catch: RemoteException -> L12
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

    public final void prepareSearch() {
        MemoryServiceChecker r0 = MemoryServiceChecker.INSTANCE;
        Context r1 = context;
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        if (r0.checkSearchServiceAvailable(r1) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip prepareSearch");
        return;
    L6:
        b r2 = b.f7609a;
        if (isBound == false) goto L9;
        r2.invoke();
        return;
    L9:
        pendingOperations.add(r2);
        bindService();
    }

    public final List<String> queryServicePackagesByAction(Context r4, String r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "action");
        Intent r6 = new Intent(r5);
        List<ResolveInfo> r7 = r3.getPackageManager().queryIntentServices(r6, 131072);
        Intrinsics.checkNotNullExpressionValue(r7, "pm.queryIntentServices(i…PackageManager.MATCH_ALL)");
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L11;
        ServiceInfo r10 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r9.next(), ResolveInfo.class, "com.obric.memorydata.plugin")).serviceInfo;
        if (r10 == null) goto L8;
        String r11 = r10.packageName;
    L9:
        if (r11 == null) goto L4;
        r8.add(r11);
        goto L4
    L8:
        r11 = null;
        goto L9
    L11:
        List r12 = CollectionsKt.distinct(r8);
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L13:
        if (r14.hasNext() == false) goto L17;
        Object r15 = r14.next();
        String r1 = (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin");
        if (PackageUtils.INSTANCE.checkSignature(r1) == false) goto L13;
        r13.add(r15);
        goto L13
    L17:
        return r13;
    }

    public final void registerEntityObserver(EntityChangeMonitorRequest r3, IAppEntityChangeCallback r4) {
        IAppEntityChangeCallback r5 = (IAppEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityChangeCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "entityChangeMonitorRequest");
        Intrinsics.checkNotNullParameter(r5, "callback");
        c r0 = new c(r5, r3);
        if (isBound == false) goto L5;
        r0.invoke();
        return;
    L5:
        pendingOperations.add(r0);
        bindService();
    }

    public final void startAppSearch(String r4, InAppSearchRequest r5, IAppSearchCallback r6) {
        IAppSearchCallback r7 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r6, IAppSearchCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "businessName");
        Intrinsics.checkNotNullParameter(r5, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r7, "callback");
        MemoryServiceChecker r0 = MemoryServiceChecker.INSTANCE;
        Context r1 = context;
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        if (r0.checkSearchServiceAvailable(r1) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip startAppSearch");
        r7.onError(6, "Memory search service is disabled");
        return;
    L6:
        d r2 = new d(r7, r4, r5);
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
        if (r0.checkSearchServiceAvailable(r1) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip stop");
        return;
    L6:
        businessMap.clear();
        unbindService();
    }

    public final void stopSearch() {
        MemoryServiceChecker r2 = MemoryServiceChecker.INSTANCE;
        Context r0 = context;
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        if (r2.checkSearchServiceAvailable(r0) == MemoryServiceStatus.AVAILABLE) goto L7;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip stopSearch");
        return;
    L7:
        if (isBound == false) goto L17;
        IInAppSearchService r3 = service;     // Catch: RemoteException -> L12
        if (r3 == null) goto L18;
        r3.stopSearch();     // Catch: RemoteException -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void unregisterEntityObserver() {
        MemoryServiceChecker r0 = MemoryServiceChecker.INSTANCE;
        Context r1 = context;
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        if (r0.checkSearchServiceAvailable(r1) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip unregisterEntityObserver");
        return;
    L6:
        e r2 = e.f7617a;
        if (isBound == false) goto L9;
        r2.invoke();
        return;
    L9:
        pendingOperations.add(r2);
        bindService();
    }
}
