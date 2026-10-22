package com.obric.memorydata.personalcontext.external.file;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.IndexTaskManager;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.IEntityCollectorService;
import com.obric.memorydata.personalcontext.external.f;
import com.obric.memorydata.personalcontext.external.g;
import com.obric.memorydata.personalcontext.external.h;
import com.obric.memorydata.personalcontext.external.i;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dH\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001dH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\u001fH\u0016J\u001a\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0002J&\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020\u001f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006)"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/file/ExternalFileEntityCollector;", "Lcom/obric/memorydata/personalcontext/api/AbsEntityCollector;", "<init>", "()V", "entityIndexUpdater", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "getEntityIndexUpdater", "()Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "entityIndexUpdater$delegate", "Lkotlin/Lazy;", LocationMonitorConst.TAG, "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "type", "getType", "onInit", "", "syncDataDelay", "reIndexData", "", "noNeedDelete", "getEntitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "getEntitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "getNeedRequestPermissions", "", "getDonateEntityTypeList", "", "getPackageNameByEntityType", "entityType", "syncData", "observer", "Lcom/obric/memorydata/personalcontext/external/file/ExternalFileObserver;", "getDataAndTriggerIndex", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "ids", "Companion", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends com.obric.memorydata.personalcontext.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12134a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f12135b;
    private String c;
    private final String d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/file/ExternalFileEntityCollector$Companion;", "", "<init>", "()V", "TAG", "", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12134a = new a(null);
    }

    public c() {
        this.f12135b = LazyKt.lazy($$Lambda$c$aWnKWWfGJQf7gbfa8CAZTzJZo7c.INSTANCE);
        this.c = IEntityCollectorService.FILE_TAG;
        this.d = "external_file";
    }

    private static final void a(e r0) {
        r0.a();
    }

    private final void a(final e r3, boolean r4) {
        if (r4 == false) goto L4;
        long r0 = 60000;
    L5:
        f.f12127a.a().postDelay(r0, new $$Lambda$c$Jh7iVsLmJ1rkO2m1aBA11SQStI(r3));
        return;
    L4:
        r0 = 0;
        goto L5
    }

    private static final void a(boolean r5, c r6, CountDownLatch r7) {
        if (r5 == false) goto L11;
    L5:
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        long r0 = e.f12136a.b(r8);     // Catch: Throwable -> L8
        EntityProvider.bulkIndex$default(EntityProvider.INSTANCE, r6.e().provideAllEntities(), null, 2, null);     // Catch: Throwable -> L8
        e.f12136a.a(r0);     // Catch: Throwable -> L8
        e.f12136a.a(r8);     // Catch: Throwable -> L8
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalFileEntityCollector", "external file reIndexData end, maxGeneration = " + r0);     // Catch: Throwable -> L8
        r7.countDown();
        return;
    L8:
        th = move-exception;
        r7.countDown();
        throw th;
    L11:
        EntityManager.INSTANCE.deleteByTypeAndPackageName(EntityType.FILE, g.f12138a.a(EntityType.FILE));     // Catch: Throwable -> L8
        goto L5
    }

    private final i i() {
        return (i) ZeusTransformUtils.preCheckCast(this.f12135b.getValue(), i.class, "com.obric.memorydata.plugin");
    }

    private static final i j() {
        return new i((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: lambda$Jh7iVsLmJ1r-kO2m1aBA11SQStI, reason: not valid java name */
    public static /* synthetic */ void m1071lambda$Jh7iVsLmJ1rkO2m1aBA11SQStI(e r0) {
        a(r0);
    }

    public static /* synthetic */ void lambda$VDjOVfU4U8CfOrhz08nk9KMoroU(boolean r0, c r1, CountDownLatch r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ i lambda$aWnKWWfGJQf7gbfa8CAZTzJZo7c() {
        return j();
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String a() {
        return this.c;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String a(int r1) {
        return g.f12138a.a(r1);
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<AppEntity> a(int r6, List<String> r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "ids");
        Map<Integer, h> r0 = g.f12138a.b();
        ContentResolver r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        if (AppContext.INSTANCE.isObricFlavor() == true) goto L5;
        return null;
    L5:
        if (d() == false) goto L13;
        h r9 = (h) ZeusTransformUtils.preCheckCast(r0.get(Integer.valueOf(r6)), h.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L14;
        Intrinsics.checkNotNull(r2);
        List<AppEntity> r10 = r9.a(r2, r8);
        if (r10 == null) goto L15;
        i().a(r10);
        return r10;
    L15:
        return null;
    L14:
        return null;
    L13:
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public boolean b(boolean r7) {
        com.obric.memorydata.personalcontext.external.c.f12108a.b(a(), "external file collector init");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        e r2 = new e(r0, i());
        ZeusProviderTransform.registerContentObserver(r0.getContentResolver(), e.f12136a.a(), true, (ContentObserver) ZeusTransformUtils.preCheckCast(r2, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        if (EntityManager.INSTANCE.isAllEntityDonated() == false) goto L5;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalFileEntityCollector", "isAllEntityDonated, start syncData");
        a(r2, r7);
    L5:
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public void c(final boolean r4) {
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalFileEntityCollector", "external reIndexData start");
        final CountDownLatch r0 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask("ExternalFileIndexAll", new $$Lambda$c$VDjOVfU4U8CfOrhz08nk9KMoroU(r4, this, r0));
        r0.await();
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public EntitySupplier e() {
        return (EntitySupplier) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.personalcontext.external.file.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), EntitySupplier.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public EntitySyncDataSupplier f() {
        return (EntitySyncDataSupplier) ZeusTransformUtils.preCheckCast(new d(), EntitySyncDataSupplier.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<String> g() {
        return CollectionsKt.listOf("android.permission.MANAGE_EXTERNAL_STORAGE");
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String getType() {
        return this.d;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<Integer> h() {
        return CollectionsKt.listOf(Integer.valueOf(EntityType.FILE));
    }
}
