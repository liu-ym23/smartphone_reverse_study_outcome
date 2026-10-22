package com.obric.memorydata.personalcontext.collector;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.IndexTaskManager;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.EntityCollectorService;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.EvaluationService;
import com.obric.memorydata.personalcontext.api.IEntityCollectorService;
import com.obric.memorydata.personalcontext.api.IEntityManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0005H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J&\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u000e\u0010\"\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001cR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006$"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/SmsEntityCollector;", "Lcom/obric/memorydata/personalcontext/api/AbsEntityCollector;", "<init>", "()V", "subCollectors", "", "Lcom/obric/memorydata/personalcontext/collector/sms/AbstractSmsSubCollector;", LocationMonitorConst.TAG, "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "type", "getType", "getInitializedTypes", "onInit", "", "syncDataDelay", "reIndexData", "", "noNeedDelete", "getEntitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "getEntitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "getNeedRequestPermissions", "getDonateEntityTypeList", "", "getPackageNameByEntityType", "entityType", "getDataAndTriggerIndex", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "ids", "getPackageName", "Companion", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m extends com.obric.memorydata.personalcontext.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12078a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.obric.memorydata.personalcontext.collector.a.a> f12079b;
    private String c;
    private final String d;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/SmsEntityCollector$Companion;", "", "<init>", "()V", "TAG_PREFIX", "", "CHUNK_SIZE", "", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/obric/memorydata/personalcontext/collector/SmsEntityCollector$onInit$2$2", "Lcom/obric/callandsms/common/CallSmsEntityLog;", "d", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "throwable", "", "i", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.a.a.c {
        b() {
        }

        @Override // com.obric.a.a.c
        public void a(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
            RunLog.INSTANCE.debug("Contact_Sdk_" + r3, r4);
        }

        @Override // com.obric.a.a.c
        public void a(String r3, String r4, Throwable r5) {
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
            RunLog.INSTANCE.error("Contact_Sdk_" + r3, r4, r5);
        }

        @Override // com.obric.a.a.c
        public void b(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "Contact_Sdk_" + r7, r8, false, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H\u0016¨\u0006\f"}, d2 = {"com/obric/memorydata/personalcontext/collector/SmsEntityCollector$onInit$2$3", "Lcom/obric/callandsms/common/CallSmsEntityChangeCallBack;", "onBulkDelete", "", "entityIds", "", "", "entityType", "", "onBulkIndex", "entities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.a.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f12080a;

        c(m r1) {
            this.f12080a = r1;
        }

        private static final void a(List r9, int r10, String r11) {
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 100), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            List r3 = (List) ZeusTransformUtils.preCheckCast(r12.next(), List.class, "com.obric.memorydata.plugin");
            IEntityManager.a.a((IEntityManager) ZeusTransformUtils.preCheckCast(EntityManager.INSTANCE, IEntityManager.class, "com.obric.memorydata.plugin"), r3, r10, r11, null, 8, null);
            goto L4
        }

        public static /* synthetic */ void lambda$Z8BlAIx7Gy9ouez0wePfZmT7p5c(List r0, int r1, String r2) {
            a(r0, r1, r2);
        }

        @Override // com.obric.a.a.a
        public void a(List<? extends AppEntity> r9) {
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "entities");
            IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            String r3 = this.f12080a.a();
            StringBuilder r8 = new StringBuilder().append("onBulkIndex entityType: ");
            AppEntity r0 = (AppEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r10), AppEntity.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L5;
            Integer r1 = Integer.valueOf(r0.getType());
        L6:
            IRunLog.a.a(r2, r3, r8.append(r1).append(" size: ").append(r10.size()).toString(), false, 4, null);
            EntityProvider.bulkIndex$default(EntityProvider.INSTANCE, r10, null, 2, null);
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.obric.a.a.a
        public void a(List<String> r8, final int r9) {
            final List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "entityIds");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12080a.a(), "onBulkDelete entityType: " + r9 + " ids: " + r10, false, 4, null);
            final String r7 = this.f12080a.b(r9);
            IndexTaskManager.INSTANCE.runTask("listenContactSMSData onBulkDelete", new $$Lambda$m$c$Z8BlAIx7Gy9ouez0wePfZmT7p5c(r10, r9, r7));
        }
    }

    static {
        f12078a = new a(null);
    }

    public m() {
        this.f12079b = CollectionsKt.listOf(new com.obric.memorydata.personalcontext.collector.a.a[]{new com.obric.memorydata.personalcontext.collector.a.d(), new com.obric.memorydata.personalcontext.collector.a.b(), new com.obric.memorydata.personalcontext.collector.a.c()});
        this.c = IEntityCollectorService.SMS_TAG;
        this.d = "obric_sms_wrapper";
    }

    private static final Unit a(List r4, m r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        com.obric.contactsdk.c r0 = new com.obric.contactsdk.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        ((com.obric.memorydata.personalcontext.collector.a.a) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.memorydata.personalcontext.collector.a.a.class, "com.obric.memorydata.plugin")).a(r0);
        goto L4
    L6:
        com.obric.a.a.f.f5867a.a((com.obric.a.a.c) ZeusTransformUtils.preCheckCast(new b(), com.obric.a.a.c.class, "com.obric.memorydata.plugin"));
        com.obric.a.a.b.f5863a.a((com.obric.a.a.a) ZeusTransformUtils.preCheckCast(new c(r5), com.obric.a.a.a.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final void a(boolean r3, CountDownLatch r4) {
        if (r3 == false) goto L10;
    L4:
        EntityProvider.bulkIndex$default(EntityProvider.INSTANCE, EntityCollectorService.INSTANCE.getAllContactAndSmsData(), null, 2, null);     // Catch: Throwable -> L7
        r4.countDown();
        return;
    L7:
        th = move-exception;
        r4.countDown();
        throw th;
    L10:
        EntityManager.INSTANCE.deleteAll(AppInfo.Contact.getPackageName());     // Catch: Throwable -> L7
        EntityManager.INSTANCE.deleteAll(AppInfo.Message.getPackageName());     // Catch: Throwable -> L7
        goto L4
    }

    /* JADX INFO: renamed from: lambda$F1G1bQ9E-NRMAiiEw1C3e96RfEY, reason: not valid java name */
    public static /* synthetic */ Unit m1064lambda$F1G1bQ9ENRMAiiEw1C3e96RfEY(List r0, m r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$nOEiaLcnrZyKyTNtO1oWkmR56F0(boolean r0, CountDownLatch r1) {
        a(r0, r1);
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String a() {
        return this.c;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public String a(int r1) {
        if (r1 != 101) goto L5;
        AppInfo r0 = AppInfo.Message;
    L12:
        return r0.getPackageName();
    L5:
        if (r1 != 201) goto L7;
    L9:
        r0 = AppInfo.Contact;
        goto L12
    L7:
        if (r1 == 202) goto L9;
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<AppEntity> a(int r1, List<String> r2) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), "ids");
        return null;
    }

    public final String b(int r3) {
        if (r3 != 101) goto L5;
        return "com.android.mms";
    L5:
        if (r3 != 201) goto L7;
    L11:
        return "com.android.contacts";
    L7:
        if (r3 == 202) goto L11;
        throw new IllegalStateException("unknown entity type: " + r3);
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public List<String> b() {
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f12079b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        com.obric.memorydata.personalcontext.collector.a.a r1 = (com.obric.memorydata.personalcontext.collector.a.a) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.memorydata.personalcontext.collector.a.a.class, "com.obric.memorydata.plugin");
        if (r1.b() == false) goto L4;
        r0.add(r1.getType());
        goto L4
    L8:
        return r0;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public boolean b(boolean r10) {
        if (EvaluationService.INSTANCE.isCqcEvaluationMode() == false) goto L5;
        return false;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), a(), "init sub collector", false, 4, null);
        boolean r11 = true;
        final List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f12079b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L14;
        com.obric.memorydata.personalcontext.collector.a.a r4 = (com.obric.memorydata.personalcontext.collector.a.a) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.memorydata.personalcontext.collector.a.a.class, "com.obric.memorydata.plugin");
        if (r4.c() == false) goto L12;
        r1.add(r4);
    L12:
        if (r4.b() == true) goto L7;
        r11 = false;
        goto L7
    L14:
        com.obric.memorydata.utils.j.a(new $$Lambda$m$F1G1bQ9ENRMAiiEw1C3e96RfEY(r1, this));
        return r11;
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public void c(final boolean r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), a(), "indexAllContactSmsEntity start", false, 4, null);
        final CountDownLatch r7 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask("EntityManagerIndexAllSMS", new $$Lambda$m$nOEiaLcnrZyKyTNtO1oWkmR56F0(r8, r7));
        r7.await();
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public EntitySupplier e() {
        return (EntitySupplier) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.collector.a.f12050a, EntitySupplier.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.a
    public EntitySyncDataSupplier f() {
        return (EntitySyncDataSupplier) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.collector.a.f12050a, EntitySyncDataSupplier.class, "com.obric.memorydata.plugin");
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
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f12079b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        List<Integer> r1 = ((com.obric.memorydata.personalcontext.collector.a.a) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.memorydata.personalcontext.collector.a.a.class, "com.obric.memorydata.plugin")).d();
        if (r1 == null) goto L4;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"));
        goto L4
    L9:
        return r0;
    }
}
