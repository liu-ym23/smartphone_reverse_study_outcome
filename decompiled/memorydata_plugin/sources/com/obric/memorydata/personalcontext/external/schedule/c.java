package com.obric.memorydata.personalcontext.external.schedule;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.CalendarContract;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.IndexTaskManager;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.EvaluationService;
import com.obric.memorydata.personalcontext.api.IEntityCollectorService;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dH\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001dH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u001fH\u0016J&\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dH\u0016J\u0012\u0010%\u001a\u00020\u00182\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/schedule/ExternalScheduleEntityCollector;", "Lcom/obric/memorydata/personalcontext/api/AbsEntityCollector;", "<init>", "()V", LocationMonitorConst.TAG, "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "type", "getType", "entityIndexUpdater", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "getEntityIndexUpdater", "()Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "entityIndexUpdater$delegate", "Lkotlin/Lazy;", "observer", "Lcom/obric/memorydata/personalcontext/external/schedule/ExternalScheduleObserver;", "onInit", "", "syncDataDelay", "reIndexData", "", "noNeedDelete", "getEntitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "getNeedRequestPermissions", "", "getDonateEntityTypeList", "", "getPackageNameByEntityType", "entityType", "getDataAndTriggerIndex", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "ids", "syncData", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends com.obric.memorydata.personalcontext.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12165b;
    private final Lazy c;
    private d d;

    public c() {
        this.f12164a = IEntityCollectorService.SCHEDULE_TAG;
        this.f12165b = "external_schedule";
        this.c = LazyKt.lazy($$Lambda$c$nta6AJdw67kdFnIAEaU1TES4Zd4.INSTANCE);
    }

    private static final void a(c r0) {
        d r1 = r0.d;
        if (r1 == null) goto L6;
        r1.a();
        return;
    }

    private static final void a(boolean r3, c r4, CountDownLatch r5) {
        if (r3 == false) goto L10;
    L4:
        List<AppEntity> r6 = r4.e().provideAllEntities();     // Catch: Throwable -> L7
        EntityProvider.bulkIndex$default(EntityProvider.INSTANCE, r6, null, 2, null);     // Catch: Throwable -> L7
        com.obric.memorydata.personalcontext.external.c.f12108a.b(r4.a(), "external schedule reIndexData end");     // Catch: Throwable -> L7
        r5.countDown();
        return;
    L7:
        th = move-exception;
        r5.countDown();
        throw th;
    L10:
        String r7 = com.obric.memorydata.personalcontext.external.g.f12138a.a(402);     // Catch: Throwable -> L7
        EntityManager.INSTANCE.deleteByTypeAndPackageName(402, r7);     // Catch: Throwable -> L7
        goto L4
    }

    private final void d(boolean r4) {
        if (r4 == false) goto L4;
        long r0 = 60000;
    L5:
        com.obric.memorydata.personalcontext.external.f.f12127a.a().postDelay(r0, new $$Lambda$c$cYUTtMrHhW_VWyJSMq9U6SQ166c(this));
        return;
    L4:
        r0 = 0;
        goto L5
    }

    private static final com.obric.memorydata.personalcontext.external.i j() {
        return new com.obric.memorydata.personalcontext.external.i((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ void lambda$cYUTtMrHhW_VWyJSMq9U6SQ166c(c r0) {
        a(r0);
    }

    public static /* synthetic */ void lambda$gUK2RoqqMTWuE0yM0koNLwE_TJI(boolean r0, c r1, CountDownLatch r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ com.obric.memorydata.personalcontext.external.i lambda$nta6AJdw67kdFnIAEaU1TES4Zd4() {
        return j();
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String a() {
        return this.f12164a;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String a(int r1) {
        return com.obric.memorydata.personalcontext.external.g.f12138a.a(r1);
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<AppEntity> a(int r6, List<String> r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "ids");
        Map<Integer, com.obric.memorydata.personalcontext.external.h> r0 = com.obric.memorydata.personalcontext.external.g.f12138a.b();
        ContentResolver r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        if (AppContext.INSTANCE.isObricFlavor() == true) goto L5;
        return null;
    L5:
        if (d() == false) goto L13;
        com.obric.memorydata.personalcontext.external.h r9 = (com.obric.memorydata.personalcontext.external.h) ZeusTransformUtils.preCheckCast(r0.get(Integer.valueOf(r6)), com.obric.memorydata.personalcontext.external.h.class, "com.obric.memorydata.plugin");
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
    public boolean b(boolean r6) {
        if (EvaluationService.INSTANCE.isAutoEvaluationMode() == false) goto L5;
    L11:
        com.obric.memorydata.personalcontext.external.c.f12108a.b(a(), "is evaluation mode, method return");
        return false;
    L5:
        if (EvaluationService.INSTANCE.isCqcEvaluationMode() == true) goto L11;
        com.obric.memorydata.personalcontext.external.c.f12108a.b(a(), "external schedule collector init");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.d = new d(r0, i());
        ContentResolver r1 = r0.getContentResolver();
        Uri r2 = CalendarContract.Events.CONTENT_URI;
        d r3 = this.d;
        Intrinsics.checkNotNull(r3);
        ZeusProviderTransform.registerContentObserver(r1, r2, true, (ContentObserver) ZeusTransformUtils.preCheckCast(r3, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        if (EntityManager.INSTANCE.isAllEntityDonated() == false) goto L10;
        com.obric.memorydata.personalcontext.external.c.f12108a.b(a(), "isAllEntityDonated, start syncData");
        d(r6);
    L10:
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public void c(final boolean r4) {
        com.obric.memorydata.personalcontext.external.c.f12108a.b(a(), "external schedule reIndexData start");
        final CountDownLatch r0 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask("ExternalScheduleIndexAll", new $$Lambda$c$gUK2RoqqMTWuE0yM0koNLwE_TJI(r4, this, r0));
        r0.await();
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public EntitySupplier e() {
        return (EntitySupplier) ZeusTransformUtils.preCheckCast(new a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), EntitySupplier.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<String> g() {
        return CollectionsKt.listOf("android.permission.READ_CALENDAR");
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String getType() {
        return this.f12165b;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<Integer> h() {
        return CollectionsKt.listOf(402);
    }

    public final com.obric.memorydata.personalcontext.external.i i() {
        return (com.obric.memorydata.personalcontext.external.i) ZeusTransformUtils.preCheckCast(this.c.getValue(), com.obric.memorydata.personalcontext.external.i.class, "com.obric.memorydata.plugin");
    }
}
