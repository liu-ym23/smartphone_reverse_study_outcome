package com.obric.memorydata.personalcontext.external.d;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.MediaStore;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.IndexTaskManager;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0 H\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\"H\u0016J&\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010 2\u0006\u0010$\u001a\u00020\"2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050 H\u0016J\u0018\u0010(\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/photo/ExternalPhotoEntityCollector;", "Lcom/obric/memorydata/personalcontext/api/AbsEntityCollector;", "<init>", "()V", LocationMonitorConst.TAG, "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "type", "getType", "entityIndexUpdater", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "getEntityIndexUpdater", "()Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "entityIndexUpdater$delegate", "Lkotlin/Lazy;", "observer", "Lcom/obric/memorydata/personalcontext/external/photo/ExternalPhotoObserver;", "onInit", "", "syncDataDelay", "onPermissionChanged", "", "reIndexData", "noNeedDelete", "getEntitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "getEntitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "getNeedRequestPermissions", "", "getDonateEntityTypeList", "", "getPackageNameByEntityType", "entityType", "getDataAndTriggerIndex", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "ids", "syncData", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends com.obric.memorydata.personalcontext.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12118b;
    private final Lazy c;
    private e d;

    public c() {
        this.f12117a = IEntityCollectorService.PHOTO_TAG;
        this.f12118b = "external_photo";
        this.c = LazyKt.lazy($$Lambda$c$KzNG38h8GLkX2VBaUZ2ONXIz1Xs.INSTANCE);
    }

    public static /* synthetic */ void a(c r0, e r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.a(r1, r2);
    }

    private static final void a(e r0) {
        r0.a();
    }

    private static final void a(boolean r6, c r7, CountDownLatch r8) {
        if (r6 == false) goto L11;
    L5:
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        long r0 = e.f12119a.c(r9);     // Catch: Throwable -> L8
        EntityProvider.bulkIndex$default(EntityProvider.INSTANCE, r7.e().provideAllEntities(), null, 2, null);     // Catch: Throwable -> L8
        e.f12119a.a(r0);     // Catch: Throwable -> L8
        e.f12119a.a(r9);     // Catch: Throwable -> L8
        boolean r10 = e.f12119a.b(r9);     // Catch: Throwable -> L8
        e.f12119a.a(r10);     // Catch: Throwable -> L8
        com.obric.memorydata.personalcontext.external.c.f12108a.b(r7.a(), "external photo reIndexData end, maxGeneration = " + r0 + ",isPartialAccess=" + r10);     // Catch: Throwable -> L8
        r8.countDown();
        return;
    L8:
        th = move-exception;
        r8.countDown();
        throw th;
    L11:
        EntityManager.INSTANCE.deleteByTypeAndPackageName(301, DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().c().d());     // Catch: Throwable -> L8
        goto L5
    }

    private final i i() {
        return (i) ZeusTransformUtils.preCheckCast(this.c.getValue(), i.class, "com.obric.memorydata.plugin");
    }

    private static final i j() {
        return new i((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: lambda$4voyOgFmW9unN3UIX-UevPomodA, reason: not valid java name */
    public static /* synthetic */ void m1067lambda$4voyOgFmW9unN3UIXUevPomodA(e r0) {
        a(r0);
    }

    public static /* synthetic */ i lambda$KzNG38h8GLkX2VBaUZ2ONXIz1Xs() {
        return j();
    }

    public static /* synthetic */ void lambda$eud3QSFnWoEay4vYLcc5Qv0Jbuo(boolean r0, c r1, CountDownLatch r2) {
        a(r0, r1, r2);
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String a() {
        return this.f12117a;
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

    public final void a(final e r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (r4 == false) goto L5;
        long r0 = 60000;
    L6:
        f.f12127a.a().postDelay(r0, new $$Lambda$c$4voyOgFmW9unN3UIXUevPomodA(r3));
        return;
    L5:
        r0 = 0;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public boolean b(boolean r7) {
        com.obric.memorydata.personalcontext.external.c.f12108a.b(a(), "external photo collector init");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.d = new e(r0, i());
        ContentResolver r2 = r0.getContentResolver();
        Uri r3 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        e r4 = this.d;
        Intrinsics.checkNotNull(r4);
        ZeusProviderTransform.registerContentObserver(r2, r3, true, (ContentObserver) ZeusTransformUtils.preCheckCast(r4, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        ContentResolver r1 = r0.getContentResolver();
        Uri r5 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        e r6 = this.d;
        Intrinsics.checkNotNull(r6);
        ZeusProviderTransform.registerContentObserver(r1, r5, true, (ContentObserver) ZeusTransformUtils.preCheckCast(r6, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        if (EntityManager.INSTANCE.isAllEntityDonated() == false) goto L5;
        com.obric.memorydata.personalcontext.external.c.f12108a.b(a(), "isAllEntityDonated, start syncData");
        e r8 = this.d;
        Intrinsics.checkNotNull(r8);
        a(r8, r7);
    L5:
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public void c() {
        super.c();
        com.obric.memorydata.personalcontext.external.c.f12108a.b(a(), "onPermissionChanged, triggering sync");
        if (EntityManager.INSTANCE.isAllEntityDonated() == false) goto L8;
        e r0 = this.d;
        if (r0 == null) goto L9;
        a(this, r0, false, 2, null);
        return;
    L9:
        return;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public void c(final boolean r4) {
        com.obric.memorydata.personalcontext.external.c.f12108a.b(a(), "external photo reIndexData start");
        final CountDownLatch r0 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask("ExternalPhotoIndexAll", new $$Lambda$c$eud3QSFnWoEay4vYLcc5Qv0Jbuo(r4, this, r0));
        r0.await();
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public EntitySupplier e() {
        return (EntitySupplier) ZeusTransformUtils.preCheckCast(new a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), EntitySupplier.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public EntitySyncDataSupplier f() {
        return (EntitySyncDataSupplier) ZeusTransformUtils.preCheckCast(new d(), EntitySyncDataSupplier.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<String> g() {
        return CollectionsKt.listOf(new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"});
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String getType() {
        return this.f12118b;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<Integer> h() {
        return CollectionsKt.listOf(301);
    }
}
