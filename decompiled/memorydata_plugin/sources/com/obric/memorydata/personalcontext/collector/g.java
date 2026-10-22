package com.obric.memorydata.personalcontext.collector;

import android.content.Context;
import android.database.ContentObserver;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.IndexTaskManager;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.entity.ge;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.IEntityCollectorService;
import com.obric.memorydata.utils.handler.GlobalMainHandler;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0017H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0002J&\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006!"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/MediaFileEntityCollector;", "Lcom/obric/memorydata/personalcontext/api/AbsEntityCollector;", "<init>", "()V", LocationMonitorConst.TAG, "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "type", "getType", "onInit", "", "syncDataDelay", "reIndexData", "", "noNeedDelete", "getEntitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "getEntitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "getNeedRequestPermissions", "", "getDonateEntityTypeList", "", "getPackageNameByEntityType", "entityType", "syncNewlyScannedFile", "getDataAndTriggerIndex", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "ids", "Companion", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g extends com.obric.memorydata.personalcontext.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12069a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12070b;
    private final String c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/MediaFileEntityCollector$Companion;", "", "<init>", "()V", "LAST_SYNC_TIMESTAMP_KEY", "", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12069a = new a(null);
    }

    public g() {
        this.f12070b = IEntityCollectorService.FILE_TAG;
        this.c = "obric_file";
    }

    private static final Unit a(g r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r9.a(), "fileContentObserver init", false, 4, null);
        f r0 = new f(null);
        ZeusProviderTransform.registerContentObserver(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), f.f12067a.a(), true, (ContentObserver) ZeusTransformUtils.preCheckCast(r0, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        r9.i();
        return Unit.INSTANCE;
    }

    private static final void a(boolean r4, CountDownLatch r5) {
        if (r4 == false) goto L12;
    L4:
        List r6 = h.a(h.f12071a, null, 1, null);     // Catch: Throwable -> L9
        if ((true ^ ((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L7;
        EntityProvider.bulkIndex$default(EntityProvider.INSTANCE, r6, null, 2, null);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r5.countDown();
        throw th;
    L7:
        r5.countDown();
        return;
    L12:
        EntityManager.INSTANCE.deleteByTypeAndPackageName(EntityType.FILE, BuildConfig.LIBRARY_PACKAGE_NAME);     // Catch: Throwable -> L9
        goto L4
    }

    private static final void b(g r25) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r25.a(), "start sync newly scanned files", false, 4, null);
        long r0 = System.currentTimeMillis();
        long r10 = 0;
        long r8 = Math.max(0, IStore.a.a(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null), "media_file_last_sync_timestamp", 0, 2, null));
        if (r8 <= r0) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r25.a(), "user change system time, sync all", false, 4, null);
    L6:
        List<AppEntity> r3 = h.f12071a.a(r10);
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r9.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r11.add(((AppEntity) ZeusTransformUtils.preCheckCast(r12.next(), AppEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L8
    L10:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Map r14 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L17;
        Object r15 = r5.next();
        String r16 = ((AppEntity) ZeusTransformUtils.preCheckCast(r15, AppEntity.class, "com.obric.memorydata.plugin")).getId();
        Object r17 = r14.get(r16);
        if (r17 != null) goto L16;
        r17 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r14.put(r16, r17);
    L16:
        ((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin")).add(r15);
        goto L12
    L17:
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r6 = s.a().getRawDaoByEntityType(EntityType.FILE);
        List r18 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"), 100), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r19.hasNext() == false) goto L64;
        List<String> r110 = (List) ZeusTransformUtils.preCheckCast(r19.next(), List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r25.a(), "check sync ids: " + r110, false, 4, null);
        if (r6 == null) goto L32;
        Collection r111 = r6.queryByEntityIdList(r110);
        if (r111 == null) goto L32;
        Iterable r112 = (Iterable) ZeusTransformUtils.preCheckCast(r111, Iterable.class, "com.obric.memorydata.plugin");
        Map r113 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r114 = r112.iterator();
    L26:
        if (r114.hasNext() == false) goto L33;
        Object r115 = r114.next();
        String r116 = ((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r115, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getEntityId();
        Object r117 = r113.get(r116);
        if (r117 != null) goto L30;
        Object r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r113.put(r116, r7);
    L31:
        ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin")).add(r115);
        goto L26
    L30:
        r7 = r117;
    L33:
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L35:
        if (r20.hasNext() == false) goto L19;
        String r21 = (String) ZeusTransformUtils.preCheckCast(r20.next(), String.class, "com.obric.memorydata.plugin");
        if (r113 == null) goto L41;
        List r118 = (List) ZeusTransformUtils.preCheckCast(r113.get(r21), List.class, "com.obric.memorydata.plugin");
        if (r118 == null) goto L41;
        com.obric.memorydata.database.entity.d r119 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r118), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
    L43:
        if (ZeusTransformUtils.instanceOf(r119, ge.class) == false) goto L45;
        ge r120 = (ge) ZeusTransformUtils.preCheckCast(r119, ge.class, "com.obric.memorydata.plugin");
    L46:
        List r22 = (List) ZeusTransformUtils.preCheckCast(r14.get(r21), List.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L49;
        AppEntity r23 = (AppEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r22), AppEntity.class, "com.obric.memorydata.plugin");
    L51:
        if (ZeusTransformUtils.instanceOf(r23, FileEntity.class) == false) goto L53;
        FileEntity r24 = (FileEntity) ZeusTransformUtils.preCheckCast(r23, FileEntity.class, "com.obric.memorydata.plugin");
    L54:
        if (r24 == null) goto L35;
        if (r120 == null) goto L61;
        if (r120.getCreateTime() != r24.getCreateTime()) goto L60;
        if (r120.getModifyTime() == r24.getLastModifiedTime()) goto L35;
    L60:
        IRunLog r121 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r26 = r25.a();
        StringBuilder r122 = new StringBuilder();
        String r123 = "sync, update id: ";
    L62:
        IRunLog.a.a(r121, r26, r122.append(r123).append(r24.getId()).toString(), false, 4, null);
        r18.add(r24);
        goto L35
    L61:
        r121 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r26 = r25.a();
        r122 = new StringBuilder();
        r123 = "sync new insert id: ";
        goto L62
    L53:
        r24 = null;
        goto L54
    L49:
        r23 = null;
        goto L51
    L45:
        r120 = null;
    L41:
        r119 = null;
    L32:
        r113 = null;
        goto L33
    L64:
        EntityProvider.bulkIndex$default(EntityProvider.INSTANCE, r18, null, 2, null);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("media_file_last_sync_timestamp", r0);
        return;
    L5:
        r10 = r8;
        goto L6
    }

    private static final void c(final g r2) {
        ThreadPoolContainer.Companion.execute(new $$Lambda$g$eQs7hZlTYJTNlU5r8vp9qVQBQ(r2));
    }

    private final void i() {
        if (EntityManager.INSTANCE.getEntityDonatedVersion() >= 3) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), a(), "no need sync newly scanned files", false, 4, null);
        return;
    L6:
        GlobalMainHandler.Companion.getInstance().postDelayed(new $$Lambda$g$j5qL9bE7Mycf8kOqPhDLAPXDqew(this), 60000);
    }

    /* JADX INFO: renamed from: lambda$eQs7hZl-TYJTNlU5r8v-p9qVQBQ, reason: not valid java name */
    public static /* synthetic */ void m1059lambda$eQs7hZlTYJTNlU5r8vp9qVQBQ(g r0) {
        b(r0);
    }

    public static /* synthetic */ void lambda$j5qL9bE7Mycf8kOqPhDLAPXDqew(g r0) {
        c(r0);
    }

    public static /* synthetic */ Unit lambda$x0XtyZHmVKBsP03FTxLJXk8jAB4(g r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$zUqoV1j1XkkNkvgxzf-8gT-6e1Y, reason: not valid java name */
    public static /* synthetic */ void m1060lambda$zUqoV1j1XkkNkvgxzf8gT6e1Y(boolean r0, CountDownLatch r1) {
        a(r0, r1);
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String a() {
        return this.f12070b;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String a(int r1) {
        if (r1 != 801) goto L6;
        return BuildConfig.LIBRARY_PACKAGE_NAME;
    L6:
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<AppEntity> a(int r1, List<String> r2) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), "ids");
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public boolean b(boolean r1) {
        com.obric.memorydata.utils.j.a(new $$Lambda$g$x0XtyZHmVKBsP03FTxLJXk8jAB4(this));
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public void c(final boolean r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), a(), "indexAllFileEntity start", false, 4, null);
        final CountDownLatch r9 = new CountDownLatch(1);
        long r0 = System.currentTimeMillis();
        IndexTaskManager.INSTANCE.runTask("EntityManagerIndexAllFile", new $$Lambda$g$zUqoV1j1XkkNkvgxzf8gT6e1Y(r10, r9));
        r9.await();
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("media_file_last_sync_timestamp", r0);
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public EntitySupplier e() {
        return (EntitySupplier) ZeusTransformUtils.preCheckCast(h.f12071a, EntitySupplier.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public EntitySyncDataSupplier f() {
        return (EntitySyncDataSupplier) ZeusTransformUtils.preCheckCast(i.f12073a, EntitySyncDataSupplier.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<String> g() {
        return h.f12071a.b();
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String getType() {
        return this.c;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<Integer> h() {
        return CollectionsKt.listOf(Integer.valueOf(EntityType.FILE));
    }
}
