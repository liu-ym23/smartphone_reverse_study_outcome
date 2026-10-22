package com.obric.memorydata.personalcontext;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.entity.search.EntityChangeMonitorRequest;
import com.obric.capabilitykit.entity.search.EntityChangeResult;
import com.obric.capabilitykit.entity.search.IEntityChangeCallback;
import com.obric.capabilitykit.entity.search.IInAppSearchCallback;
import com.obric.capabilitykit.entity.search.IInAppSearchService;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.controller.ApiController;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.search.entity.SearchRequest;
import com.obric.memorydata.personalcontext.search.entity.SearchType;
import com.obric.memorydata.plugin_api.MemoryPluginActiveState;
import com.obric.memorydata.utils.ak;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/personalcontext/InAppSearchService;", "Landroid/app/Service;", "<init>", "()V", "onBind", "Landroid/os/IBinder;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "Companion", "InAppSearchServiceBinder", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class InAppSearchService extends PluginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12020a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/personalcontext/InAppSearchService$Companion;", "", "<init>", "()V", "TAG", "", "getCallPackage", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final String a() {
            int r3 = Binder.getCallingUid();
            String[] r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackagesForUid(r3);
            if (r4 != null) goto L5;
        L9:
            if (r4 != null) goto L13;
            return null;
        L13:
            return (String) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(r4, 0), String.class, "com.obric.memorydata.plugin");
        L5:
            if (r4.length <= 1) goto L9;
            if (ArraysKt.contains(r4, "com.obric.aiagent.executionengine") == false) goto L9;
            return "com.obric.aiagent.executionengine";
        }

        public static final /* synthetic */ String a(a r0) {
            return r0.a();
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0012H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/personalcontext/InAppSearchService$InAppSearchServiceBinder;", "Lcom/obric/capabilitykit/entity/search/IInAppSearchService$Stub;", "<init>", "()V", "sessionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "businessTasks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onTransact", "", "p0", "", "p1", "Landroid/os/Parcel;", "p2", "p3", "prepareSearch", "", "startAppSearch", "businessName", Ext.KEY_REQUEST, "Lcom/obric/capabilitykit/entity/search/InAppSearchRequest;", "callback", "Lcom/obric/capabilitykit/entity/search/IInAppSearchCallback;", "stopSearch", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "caller", "registerEntityObserver", "entityChangeMonitorRequest", "Lcom/obric/capabilitykit/entity/search/EntityChangeMonitorRequest;", "Lcom/obric/capabilitykit/entity/search/IEntityChangeCallback;", "unregisterEntityObserver", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class b extends IInAppSearchService.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConcurrentHashMap<String, String> f12025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConcurrentHashMap<String, CopyOnWriteArrayList<String>> f12026b;

        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/personalcontext/InAppSearchService$InAppSearchServiceBinder$registerEntityObserver$2", "Lcom/obric/memorydata/personalcontext/storage/AppEntityStorageListener;", "onChange", "", "changeType", "", "appEntityList", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements com.obric.memorydata.personalcontext.storage.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ IEntityChangeCallback f12027a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f12028b;

            a(IEntityChangeCallback r3, String r4) {
                this.f12027a = (IEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r3, IEntityChangeCallback.class, "com.obric.memorydata.plugin");
                this.f12028b = r4;
            }

            @Override // com.obric.memorydata.personalcontext.storage.d
            public void a(int r9, List<? extends AppEntity> r10) {
                List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r11, "appEntityList");
                IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: RemoteException -> L9 DeadObjectException -> L11
                StringBuilder r0 = new StringBuilder().append("onEntityChangeResult: ");     // Catch: RemoteException -> L9 DeadObjectException -> L11
                AppEntity r4 = (AppEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r11), AppEntity.class, "com.obric.memorydata.plugin");     // Catch: RemoteException -> L9 DeadObjectException -> L11
                if (r4 == null) goto L6;
                Integer r5 = Integer.valueOf(r4.getType());     // Catch: RemoteException -> L9 DeadObjectException -> L11
            L7:
                IRunLog.a.a(r2, "InAppSearchService", r0.append(r5).append(" , changeType: ").append(r9).toString(), false, 4, null);     // Catch: RemoteException -> L9 DeadObjectException -> L11
                this.f12027a.onChange(new EntityChangeResult(r9, r11));     // Catch: RemoteException -> L9 DeadObjectException -> L11
            L16:
                return;
            L6:
                r5 = null;
            L11:
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSearchService", this.f12028b + " process died", false, 4, null);
                Intent r12 = new Intent("com.obric.memorydata.appentity.change");
                r12.setPackage(this.f12028b);
                ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).sendBroadcast(r12);
                return;
            L9:
                e = move-exception;
                e.printStackTrace();
                RunLog.INSTANCE.error("InAppSearchService", "onEntityChangeResult exception", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            }
        }

        public b() {
            this.f12025a = new ConcurrentHashMap();
            this.f12026b = new ConcurrentHashMap();
        }

        public static final /* synthetic */ ConcurrentHashMap a(b r0) {
            return r0.f12025a;
        }

        private static final void a(String r1) {
            com.obric.memorydata.personalcontext.model.a.f12232a.a(r1);
            com.obric.memorydata.personalcontext.search.f.f12311a.a(r1);
        }

        public static final /* synthetic */ ConcurrentHashMap b(b r0) {
            return r0.f12026b;
        }

        private static final void b(String r1) {
            com.obric.memorydata.personalcontext.model.a.f12232a.b(r1);
        }

        /* JADX INFO: renamed from: lambda$Ff5xffb6Q0Tk2Iwh0I3-eytTrEo, reason: not valid java name */
        public static /* synthetic */ void m1053lambda$Ff5xffb6Q0Tk2Iwh0I3eytTrEo(String r0) {
            a(r0);
        }

        /* JADX INFO: renamed from: lambda$zX9LFYYjmkGZvSlhFFuEt-OCu88, reason: not valid java name */
        public static /* synthetic */ void m1054lambda$zX9LFYYjmkGZvSlhFFuEtOCu88(String r0) {
            b(r0);
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
        public void cancel(String r7) {
            Intrinsics.checkNotNullParameter(r7, "caller");
            if (ak.f13164a.a() == false) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSearchService", "call is refuse", null, 4, null);
            return;
        L6:
            this.f12025a.remove(r7);
            CopyOnWriteArrayList r6 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(this.f12026b.remove(r7), CopyOnWriteArrayList.class, "com.obric.memorydata.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L9;
        L12:
            boolean r1 = true;
        L13:
            if (r1 == false) goto L15;
            return;
        L15:
            RunLog.INSTANCE.debug("InAppSearchService", "cancel " + r7 + ", remove taskIds: " + r6);
            Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L17:
            if (r8.hasNext() == false) goto L19;
            String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.task.scheduler.b r2 = com.obric.memorydata.task.scheduler.impl.c.f12961a.d();
            Intrinsics.checkNotNull(r9);
            r2.e(r9);
            goto L17
        L19:
            return;
        L9:
            if (r0.isEmpty() == true) goto L12;
            r1 = false;
            goto L13
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchService.Stub, android.os.Binder
        public boolean onTransact(int r2, Parcel r3, Parcel r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            MemoryPluginActiveState.onEnter();
            boolean r1 = super.onTransact(r2, r3, r4, r5);     // Catch: Throwable -> L6
            MemoryPluginActiveState.onExit();
            return r1;
        L6:
            th = move-exception;
            MemoryPluginActiveState.onExit();
            throw th;
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
        public void prepareSearch() {
            if (ak.f13164a.a() == false) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSearchService", "call is refuse", null, 4, null);
            return;
        L6:
            final String r6 = a.a(InAppSearchService.f12020a);
            if (r6 != null) goto L10;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSearchService", "call pkg is null", null, 4, null);
            return;
        L10:
            ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$InAppSearchService$b$Ff5xffb6Q0Tk2Iwh0I3eytTrEo(r6));
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
        public void registerEntityObserver(EntityChangeMonitorRequest r8, IEntityChangeCallback r9) {
            IEntityChangeCallback r7 = (IEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r9, IEntityChangeCallback.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "entityChangeMonitorRequest");
            Intrinsics.checkNotNullParameter(r7, "callback");
            if (ak.f13164a.a() == false) goto L7;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSearchService", "call is refuse", null, 4, null);
            return;
        L7:
            if (ApiController.INSTANCE.isEnable() == true) goto L10;
            r7.onError(4, "ApiController disable");
            return;
        L10:
            String r10 = a.a(InAppSearchService.f12020a);
            if (r10 != null) goto L14;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSearchService", "call pkg is null", null, 4, null);
            return;
        L14:
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r8.getEntityTypeList(), Iterable.class, "com.obric.memorydata.plugin");
            boolean r3 = false;
            if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L17;
        L19:
            Iterator r2 = r1.iterator();
        L21:
            if (r2.hasNext() == false) goto L18;
            int r4 = ((Number) ZeusTransformUtils.preCheckCast(r2.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
            Set r5 = (Set) ZeusTransformUtils.preCheckCast(q.f12255a.b().get(r10), Set.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L25;
        L27:
            boolean r6 = false;
        L28:
            if (r6 == true) goto L21;
        L29:
            if (r3 == true) goto L32;
            r7.onError(1, "unsupported entity type");
            return;
        L32:
            com.obric.memorydata.personalcontext.storage.e.f12343a.a(r10, r8.getEntityTypeList(), (com.obric.memorydata.personalcontext.storage.d) ZeusTransformUtils.preCheckCast(new a(r7, r10), com.obric.memorydata.personalcontext.storage.d.class, "com.obric.memorydata.plugin"));
            return;
        L25:
            if (r5.contains(Integer.valueOf(r4)) != true) goto L27;
            r6 = true;
        L18:
            r3 = true;
            goto L29
        L17:
            if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L19;
            goto L18
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
        public void startAppSearch(String r23, InAppSearchRequest r24, IInAppSearchCallback r25) {
            IInAppSearchCallback r9 = (IInAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r25, IInAppSearchCallback.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r23, "businessName");
            Intrinsics.checkNotNullParameter(r24, Ext.KEY_REQUEST);
            Intrinsics.checkNotNullParameter(r9, "callback");
            if (ak.f13164a.a() == false) goto L7;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSearchService", "call is refuse", null, 4, null);
            return;
        L7:
            if (ApiController.INSTANCE.isEnable() == true) goto L10;
            r9.onError(4, "ApiController disable");
            return;
        L10:
            String r4 = a.a(InAppSearchService.f12020a);
            if (r4 != null) goto L14;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSearchService", "call pkg is null", null, 4, null);
            return;
        L14:
            r24.setPackageName(r4);
            if (r24.getPresetQUResult() != null) goto L17;
        L19:
            String r3 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
            RunLog.INSTANCE.debug("InAppSearchService", "package = " + r4 + ", businessName = " + r23 + ", startAppSearch " + r24 + ", sessionId = " + r3);
            String r14 = r4 + '_' + r23;
            cancel(r14);
            ((Map) ZeusTransformUtils.preCheckCast(this.f12025a, Map.class, "com.obric.memorydata.plugin")).put(r14, r3);
            if (r24.getFirstPageLimit() <= 0) goto L22;
            boolean r0 = true;
        L23:
            CopyOnWriteArrayList r15 = new CopyOnWriteArrayList();
            SearchRequest r5 = new SearchRequest(SearchType.IN_APP, r24, r4);
            kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new InAppSearchService$InAppSearchServiceBinder$startAppSearch$1(this, r14, r3, r4, r5, r15, r23, r0, r9, r24, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            ((Map) ZeusTransformUtils.preCheckCast(this.f12026b, Map.class, "com.obric.memorydata.plugin")).put(r14, r15);
            return;
        L22:
            r0 = false;
            goto L23
        L17:
            if (com.obric.memorydata.personalcontext.search.g.INSTANCE.enablePresetQUResult(r4) == true) goto L19;
            r24.setPresetQUResult(null);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSearchService", "call pkg " + r4 + " is not enable preset qu result", null, 4, null);
            goto L19
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
        public void stopSearch() {
            if (ak.f13164a.a() == false) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSearchService", "call is refuse", null, 4, null);
            return;
        L6:
            final String r6 = a.a(InAppSearchService.f12020a);
            if (r6 != null) goto L10;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSearchService", "call pkg is null", null, 4, null);
            return;
        L10:
            ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$InAppSearchService$b$zX9LFYYjmkGZvSlhFFuEtOCu88(r6));
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
        public void unregisterEntityObserver() {
            if (ak.f13164a.a() == false) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSearchService", "call is refuse", null, 4, null);
            return;
        L6:
            String r6 = a.a(InAppSearchService.f12020a);
            if (r6 != null) goto L10;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSearchService", "call pkg is null", null, 4, null);
            return;
        L10:
            com.obric.memorydata.personalcontext.storage.e.f12343a.a(r6);
        }
    }

    static {
        f12020a = new a(null);
    }

    public InAppSearchService() {
    }

    public IBinder onBind(Intent r2) {
        return (IBinder) ZeusTransformUtils.preCheckCast(new b(), IBinder.class, "com.obric.memorydata.plugin");
    }
}
