package com.obric.memorydata.personalcontext.collector;

import android.content.ContentResolver;
import android.content.Context;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.IndexTaskManager;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.EvaluationService;
import com.obric.memorydata.personalcontext.api.IEntityCollectorService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0#H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010\b2\u0006\u0010&\u001a\u00020\u0004H\u0016J&\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010#2\u0006\u0010&\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0#H\u0016J\u001e\u0010*\u001a\u00020\u001c2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0#2\b\b\u0002\u0010\u001a\u001a\u00020\u0019R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006."}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/ExternalSmsEntityCollector;", "Lcom/obric/memorydata/personalcontext/api/AbsEntityCollector;", "supportTypes", "", "", "<init>", "(Ljava/util/Set;)V", LocationMonitorConst.TAG, "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "type", "getType", "subCollectors", "", "Lcom/obric/memorydata/personalcontext/external/sms/AbstractExternalSmsSubCollector;", "entityIndexUpdater", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "getEntityIndexUpdater", "()Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "entityIndexUpdater$delegate", "Lkotlin/Lazy;", "onInit", "", "syncDataDelay", "reIndexData", "", "noNeedDelete", "getEntitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "getEntitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "getNeedRequestPermissions", "", "getDonateEntityTypeList", "getPackageNameByEntityType", "entityType", "getDataAndTriggerIndex", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "ids", "syncData", "fetchers", "Lcom/obric/memorydata/personalcontext/external/sms/IExternalSmsInitFetcher;", "Companion", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends com.obric.memorydata.personalcontext.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12063a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Integer> f12064b;
    private String c;
    private final String d;
    private final List<com.obric.memorydata.personalcontext.external.e.a> e;
    private final Lazy f;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/ExternalSmsEntityCollector$Companion;", "", "<init>", "()V", "TAG", "", "CHUNK_SIZE", "", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12063a = new a(null);
    }

    public c(Set<Integer> r4) {
        Set<Integer> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "supportTypes");
        this.f12064b = r5;
        this.c = IEntityCollectorService.SMS_TAG;
        this.d = "external_sms";
        List<com.obric.memorydata.personalcontext.external.e.a> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r5.contains(201) == false) goto L6;
        r0.add(new com.obric.memorydata.personalcontext.external.e.c());
    L6:
        if (r5.contains(101) == false) goto L9;
        r0.add(new com.obric.memorydata.personalcontext.external.e.e());
    L9:
        if (r5.contains(202) == false) goto L11;
        r0.add(new com.obric.memorydata.personalcontext.external.e.b());
    L11:
        this.e = r0;
        this.f = LazyKt.lazy($$Lambda$c$9peW7mVqlzg2RxqANoHNifGoLog.INSTANCE);
    }

    private static final Unit a(long r2) {
        com.obric.memorydata.personalcontext.external.g.f12138a.a("contacts_delete", r2);
        com.obric.memorydata.personalcontext.external.g.f12138a.a("contacts", r2);
        return Unit.INSTANCE;
    }

    private static final void a(List r3) {
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((com.obric.memorydata.personalcontext.external.e.d) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.memorydata.personalcontext.external.e.d.class, "com.obric.memorydata.plugin")).a();
        goto L4
    }

    private static final void a(boolean r9, c r10, CountDownLatch r11) {
        if (r9 == false) goto L23;
    L17:
        final long r1 = System.currentTimeMillis();     // Catch: Throwable -> L20
        List<AppEntity> r12 = com.obric.memorydata.personalcontext.external.b.f12102a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r10.f12064b, new $$Lambda$c$Wt8838hmzpmw10QYG2QYm08gado(r1), new $$Lambda$c$ho0El9XU_49SPnl3za5y149PM9w(r1), new $$Lambda$c$GdAMGfhRRs02KasSo4TNUFGRuGA(r1));     // Catch: Throwable -> L20
        EntityProvider.bulkIndex$default(EntityProvider.INSTANCE, r12, null, 2, null);     // Catch: Throwable -> L20
        r11.countDown();
        return;
    L20:
        th = move-exception;
        r11.countDown();
        throw th;
    L23:
        List r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r10.f12064b.contains(201) == false) goto L8;
        r13.add(com.obric.memorydata.personalcontext.external.g.f12138a.a(201));     // Catch: Throwable -> L20
    L8:
        if (r10.f12064b.contains(202) == false) goto L11;
        r13.add(com.obric.memorydata.personalcontext.external.g.f12138a.a(202));     // Catch: Throwable -> L20
    L11:
        if (r10.f12064b.contains(101) == false) goto L13;
        r13.add(com.obric.memorydata.personalcontext.external.g.f12138a.a(101));     // Catch: Throwable -> L20
    L13:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L20
    L15:
        if (r14.hasNext() == false) goto L17;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        EntityManager.INSTANCE.deleteAll(r2);     // Catch: Throwable -> L20
        goto L15
    }

    private static final Unit b(long r2) {
        com.obric.memorydata.personalcontext.external.g.f12138a.a("message", r2);
        return Unit.INSTANCE;
    }

    private static final Unit c(long r2) {
        com.obric.memorydata.personalcontext.external.g.f12138a.a("call_history", r2);
        return Unit.INSTANCE;
    }

    private final com.obric.memorydata.personalcontext.external.i i() {
        return (com.obric.memorydata.personalcontext.external.i) ZeusTransformUtils.preCheckCast(this.f.getValue(), com.obric.memorydata.personalcontext.external.i.class, "com.obric.memorydata.plugin");
    }

    private static final com.obric.memorydata.personalcontext.external.i j() {
        return new com.obric.memorydata.personalcontext.external.i((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ void lambda$0ygXoMRRCP3eXfAHuVaZEtcNT4w(boolean r0, c r1, CountDownLatch r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ com.obric.memorydata.personalcontext.external.i lambda$9peW7mVqlzg2RxqANoHNifGoLog() {
        return j();
    }

    public static /* synthetic */ Unit lambda$GdAMGfhRRs02KasSo4TNUFGRuGA(long r0) {
        return c(r0);
    }

    public static /* synthetic */ Unit lambda$Wt8838hmzpmw10QYG2QYm08gado(long r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$el3ocPV6HtRHtTeiB-pnCgtMS6Y, reason: not valid java name */
    public static /* synthetic */ void m1058lambda$el3ocPV6HtRHtTeiBpnCgtMS6Y(List r0) {
        a(r0);
    }

    public static /* synthetic */ Unit lambda$ho0El9XU_49SPnl3za5y149PM9w(long r0) {
        return b(r0);
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String a() {
        return this.c;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String a(int r1) {
        return com.obric.memorydata.personalcontext.external.g.f12138a.a(r1);
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<AppEntity> a(int r5, List<String> r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "ids");
        List<AppEntity> r2 = null;
        if (AppContext.INSTANCE.isObricFlavor() == true) goto L5;
        return null;
    L5:
        ContentResolver r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        if (r5 != 101) goto L13;
        if (com.obric.memorydata.personalcontext.collector.a.f12050a.a() == false) goto L13;
        com.obric.memorydata.personalcontext.external.h r8 = (com.obric.memorydata.personalcontext.external.h) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.external.g.f12138a.b().get(Integer.valueOf(r5)), com.obric.memorydata.personalcontext.external.h.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L26;
    L11:
        Intrinsics.checkNotNull(r0);
        r2 = r8.a(r0, r7);
    L26:
        if (r2 == null) goto L28;
        i().a(r2);
    L28:
        return r2;
    L13:
        if (r5 != 201) goto L20;
        if (com.obric.memorydata.personalcontext.collector.a.f12050a.c() == false) goto L20;
        r8 = (com.obric.memorydata.personalcontext.external.h) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.external.g.f12138a.b().get(Integer.valueOf(r5)), com.obric.memorydata.personalcontext.external.h.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L26;
    L20:
        if (r5 != 202) goto L26;
        if (com.obric.memorydata.personalcontext.collector.a.f12050a.b() == false) goto L26;
        r8 = (com.obric.memorydata.personalcontext.external.h) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.external.g.f12138a.b().get(Integer.valueOf(r5)), com.obric.memorydata.personalcontext.external.h.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L26;
        goto L26
    }

    public final void a(List<? extends com.obric.memorydata.personalcontext.external.e.d> r3, boolean r4) {
        final List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "fetchers");
        if (r4 == false) goto L5;
        long r5 = 60000;
    L6:
        com.obric.memorydata.personalcontext.external.f.f12127a.a().postDelay(r5, new $$Lambda$c$el3ocPV6HtRHtTeiBpnCgtMS6Y(r2));
        return;
    L5:
        r5 = 0;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public boolean b(boolean r10) {
        boolean r1 = false;
        if (EvaluationService.INSTANCE.isAutoEvaluationMode() == false) goto L5;
    L24:
        com.obric.memorydata.personalcontext.external.c.f12108a.b(a(), "is evaluation mode, method return");
        return false;
    L5:
        if (EvaluationService.INSTANCE.isCqcEvaluationMode() == true) goto L24;
        com.obric.memorydata.personalcontext.external.c.f12108a.b(a(), "onInit, init external sub collectors, types=" + this.f12064b);
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        List<? extends com.obric.memorydata.personalcontext.external.e.d> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r6 = true;
    L9:
        if (r4.hasNext() == false) goto L16;
        com.obric.memorydata.personalcontext.external.e.a r7 = (com.obric.memorydata.personalcontext.external.e.a) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.memorydata.personalcontext.external.e.a.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.personalcontext.external.e.d r8 = r7.a(r0, i());
        if (r8 == null) goto L14;
        r3.add(r8);
    L14:
        if (r7.b() == true) goto L9;
        r6 = false;
        goto L9
    L16:
        boolean r2 = EntityManager.INSTANCE.isAllEntityDonated();
        boolean r5 = !((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
        if (r2 == false) goto L20;
        if (r5 == false) goto L20;
        r1 = true;
    L20:
        com.obric.memorydata.personalcontext.external.c.f12108a.b(a(), "start sub sync=" + r1 + ":[isDonated=" + r2 + ",hasFetcher=" + r5 + ']');
        if (r1 == false) goto L23;
        a(r3, r10);
    L23:
        return r6;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public void c(final boolean r4) {
        com.obric.memorydata.personalcontext.external.c.f12108a.b(a(), "external reIndexData start");
        final CountDownLatch r0 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask("ExternalIndexAll", new $$Lambda$c$0ygXoMRRCP3eXfAHuVaZEtcNT4w(r4, this, r0));
        r0.await();
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public EntitySupplier e() {
        return (EntitySupplier) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.personalcontext.external.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.f12064b), EntitySupplier.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public EntitySyncDataSupplier f() {
        return (EntitySyncDataSupplier) ZeusTransformUtils.preCheckCast(new d(this.f12064b), EntitySyncDataSupplier.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<String> g() {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String getType() {
        return this.d;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<Integer> h() {
        List<Integer> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        List<Integer> r1 = ((com.obric.memorydata.personalcontext.external.e.a) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.memorydata.personalcontext.external.e.a.class, "com.obric.memorydata.plugin")).c();
        if (r1 == null) goto L4;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"));
        goto L4
    L9:
        return r0;
    }
}
