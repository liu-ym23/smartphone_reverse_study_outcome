package com.obric.memorydata.personalcontext;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.entity.search.global.GlobalSearchRequest;
import com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback;
import com.obric.capabilitykit.entity.search.global.IGlobalSearchService;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.controller.ApiController;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.search.entity.SearchRequest;
import com.obric.memorydata.personalcontext.search.entity.SearchType;
import com.obric.memorydata.utils.ak;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/personalcontext/GlobalSearchService;", "Landroid/app/Service;", "<init>", "()V", "getCallPackage", "", "binder", "com/obric/memorydata/personalcontext/GlobalSearchService$binder$1", "Lcom/obric/memorydata/personalcontext/GlobalSearchService$binder$1;", "onBind", "Landroid/os/IBinder;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onUnbind", "", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalSearchService extends PluginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12014a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f12015b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/GlobalSearchService$Companion;", "", "<init>", "()V", "TAG", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"com/obric/memorydata/personalcontext/GlobalSearchService$binder$1", "Lcom/obric/capabilitykit/entity/search/global/IGlobalSearchService$Stub;", "sessionMap", "", "", "businessTasks", "", "startGlobalSearch", "", "businessName", Ext.KEY_REQUEST, "Lcom/obric/capabilitykit/entity/search/global/GlobalSearchRequest;", "callback", "Lcom/obric/capabilitykit/entity/search/global/IGlobalSearchCallback;", "isCallbackAlive", "", "callAllCompletedCallbackIfLastDomainResult", "searchRequest", "Lcom/obric/memorydata/personalcontext/search/entity/SearchRequest;", CommonConsts.COUNT_TYPE, "Ljava/util/concurrent/atomic/AtomicInteger;", "caller", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends IGlobalSearchService.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ GlobalSearchService f12016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, String> f12017b;
        private final Map<String, List<String>> c;

        b(GlobalSearchService r3) {
            this.f12016a = (GlobalSearchService) ZeusTransformUtils.wrapperContextForParams(r3, GlobalSearchService.class, "com.obric.memorydata.plugin");
            this.f12017b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            this.c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        }

        public static final /* synthetic */ Map a(b r0) {
            return r0.f12017b;
        }

        public static final /* synthetic */ void a(b r2, SearchRequest r3, AtomicInteger r4, IGlobalSearchCallback r5, String r6) {
            r2.a(r3, r4, (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r5, IGlobalSearchCallback.class, "com.obric.memorydata.plugin"), r6);
        }

        private final void a(SearchRequest r9, AtomicInteger r10, IGlobalSearchCallback r11, String r12) {
            IGlobalSearchCallback r13 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r11, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r9.getSearchParams(), GlobalSearchRequest.class) == false) goto L27;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalSearchService", "check onAllCompleted call, count: " + r10.get(), false, 4, null);
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(((GlobalSearchRequest) ZeusTransformUtils.preCheckCast(r9.getSearchParams(), GlobalSearchRequest.class, "com.obric.memorydata.plugin")).getSearchEntityTypes(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r15 = r14.iterator();
        L6:
            if (r15.hasNext() == false) goto L11;
            String r2 = (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.g.INSTANCE.getEntityTypeToTaskNameMap().get(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r15.next(), Number.class, "com.obric.memorydata.plugin")).intValue())), String.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L6;
            r0.add(r2);
            goto L6
        L11:
            if (r10.incrementAndGet() == ((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin")).size()) goto L13;
            return;
        L13:
            if (a(r13) == true) goto L20;
        L18:
            this.f12017b.remove(r12);
            this.c.remove(r12);
            return;
        L20:
            r13.onAllCompleted();     // Catch: RemoteException -> L16
        L16:
            e = move-exception;
            RunLog.INSTANCE.warn("GlobalSearchService", "onAllCompleted RemoteException", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            goto L18
        }

        private final boolean a(IGlobalSearchCallback r2) {
            return ((IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r2, IGlobalSearchCallback.class, "com.obric.memorydata.plugin")).asBinder().pingBinder();
        L5:
            return false;
        }

        public static final /* synthetic */ boolean a(b r2, IGlobalSearchCallback r3) {
            return r2.a((IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r3, IGlobalSearchCallback.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
        public void cancel(String r7) {
            Intrinsics.checkNotNullParameter(r7, "businessName");
            if (ak.f13164a.a() == false) goto L7;
            IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            Throwable r3 = null;
            int r4 = 4;
            Object r5 = null;
            String r1 = "GlobalSearchService";
            String r2 = "call is refuse";
        L5:
            IRunLog.a.a(r0, r1, r2, r3, r4, r5);
            return;
        L7:
            String r6 = GlobalSearchService.a(this.f12016a);
            if (r6 != null) goto L10;
            r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            r3 = null;
            r4 = 4;
            r5 = null;
            r1 = "GlobalSearchService";
            r2 = "call pkg is null";
            goto L5
        L10:
            String r8 = r6 + '_' + r7;
            RunLog.INSTANCE.debug("GlobalSearchService", "cancel " + r8);
            this.f12017b.remove(r8);
            List r9 = (List) ZeusTransformUtils.preCheckCast(this.c.remove(r8), List.class, "com.obric.memorydata.plugin");
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin");
            if (r10 != null) goto L13;
        L16:
            boolean r11 = true;
        L17:
            if (r11 == false) goto L19;
            return;
        L19:
            RunLog.INSTANCE.debug("GlobalSearchService", "cancel " + r8 + ", remove taskIds: " + r9);
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L21:
            if (r12.hasNext() == false) goto L23;
            com.obric.memorydata.task.scheduler.impl.c.f12961a.d().e((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin"));
            goto L21
        L23:
            return;
        L13:
            if (r10.isEmpty() == true) goto L16;
            r11 = false;
            goto L17
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
        public void startGlobalSearch(String r20, GlobalSearchRequest r21, IGlobalSearchCallback r22) {
            IGlobalSearchCallback r8 = (IGlobalSearchCallback) ZeusTransformUtils.wrapperContextForParams(r22, IGlobalSearchCallback.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r20, "businessName");
            Intrinsics.checkNotNullParameter(r21, Ext.KEY_REQUEST);
            Intrinsics.checkNotNullParameter(r8, "callback");
            if (ak.f13164a.a() == false) goto L7;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalSearchService", "call is refuse", null, 4, null);
            return;
        L7:
            if (ApiController.INSTANCE.isEnable() == false) goto L9;
            String r5 = GlobalSearchService.a(this.f12016a);
            if (r5 != null) goto L19;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalSearchService", "call pkg is null", null, 4, null);
            return;
        L19:
            r21.setPackageName(r5);
            RunLog.INSTANCE.debug("GlobalSearchService", "package = " + r5 + ", " + r20 + " = " + r20 + ", startAppSearch " + r21);
            String r11 = r5 + '_' + r20;
            cancel(r20);
            String r7 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
            this.f12017b.put(r11, r7);
            List<String> r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new GlobalSearchService$binder$1$startGlobalSearch$1(new SearchRequest(SearchType.IN_APP, r21, r5), r12, r5, this, r11, r7, r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            this.c.put(r11, r12);
            return;
        L9:
            if (a(r8) == false) goto L23;
            r8.onError(1, -1, "ApiController disable");     // Catch: RemoteException -> L12
            return;
        L12:
            e = move-exception;
            RunLog.INSTANCE.warn("GlobalSearchService", "onError RemoteException", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            return;
        }
    }

    static {
        f12014a = new a(null);
    }

    public GlobalSearchService() {
        this.f12015b = new b(this);
    }

    private final String a() {
        int r3 = Binder.getCallingUid();
        String[] r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackagesForUid(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(r4, 0), String.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ String a(GlobalSearchService r2) {
        return ((GlobalSearchService) ZeusTransformUtils.wrapperContextForParams(r2, GlobalSearchService.class, "com.obric.memorydata.plugin")).a();
    }

    private static final void b() {
        com.obric.memorydata.personalcontext.model.a.f12232a.b(AppInfo.FileManager.getPackageName());
        com.obric.memorydata.personalcontext.model.a.f12232a.b(AppInfo.QuickSearch.getPackageName());
    }

    /* JADX INFO: renamed from: lambda$jST47DR2-ODUxUO9wracqMmxz7A, reason: not valid java name */
    public static /* synthetic */ void m1052lambda$jST47DR2ODUxUO9wracqMmxz7A() {
        b();
    }

    public IBinder onBind(Intent r2) {
        return (IBinder) ZeusTransformUtils.preCheckCast(this.f12015b, IBinder.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onUnbind(Intent r3) {
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$GlobalSearchService$jST47DR2ODUxUO9wracqMmxz7A.INSTANCE);
        return super/*android.app.Service*/.onUnbind(r3);
    }
}
