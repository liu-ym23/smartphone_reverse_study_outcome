package com.obric.memorydata.intelligence.datalearning.profile;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.memorydata.ability.d;
import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.data.p;
import com.obric.memorydata.ability.f;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.awareness.impl.AwarenessManagerImpl;
import com.obric.memorydata.intelligence.datalearning.profile.data.c;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.thirdparty.api.location.LocationManager;
import com.obric.memorydata.utils.g;
import com.obric.memorydata.utils.r;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/UserProfileTask;", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "<init>", "()V", "TAG", "", "isRunning", "", "lastUnlockTime", "", "abilityManager", "Lcom/obric/memorydata/ability/AbilityManager;", "locationAbilityParams", "Lcom/obric/memorydata/ability/AbilityParams;", "locationSubscribed", "learningStateListenerRegistered", CommonConsts.APM_INNER_EVENT_COST_START, "", "registerLearningStateListener", "syncLocationSubscription", "lastGps", "Lkotlin/Pair;", "", "locationDataReceiver", "com/obric/memorydata/intelligence/datalearning/profile/UserProfileTask$locationDataReceiver$1", "Lcom/obric/memorydata/intelligence/datalearning/profile/UserProfileTask$locationDataReceiver$1;", "isCanCalculated", "onDataReceive", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9953a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f9954b;
    private static long c;
    private static final d d = null;
    private static final f e = null;
    private static boolean f;
    private static boolean g;
    private static Pair<Double, Double> h;
    private static final C0481a i = null;

    /* JADX INFO: renamed from: com.obric.memorydata.intelligence.datalearning.profile.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/intelligence/datalearning/profile/UserProfileTask$locationDataReceiver$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0481a implements k {
        C0481a() {
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r11) {
            h r10 = (h) ZeusTransformUtils.wrapperContextForParams(r11, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "data");
            if (com.obric.memorydata.address.a.f8427a.c() == true) goto L7;
            a.a(a.f9953a);
            return;
        L7:
            if (ZeusTransformUtils.instanceOf(r10, com.obric.memorydata.ability.data.k.class) == true) goto L9;
            return;
        L9:
            if (((com.obric.memorydata.ability.data.k) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.ability.data.k.class, "com.obric.memorydata.plugin")).b() != null) goto L11;
            return;
        L11:
            if (((com.obric.memorydata.ability.data.k) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.ability.data.k.class, "com.obric.memorydata.plugin")).c() == null) goto L20;
            LocationManager r1 = LocationManager.INSTANCE;
            Double r12 = ((com.obric.memorydata.ability.data.k) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.ability.data.k.class, "com.obric.memorydata.plugin")).b();
            Intrinsics.checkNotNull(r12);
            double r2 = r12.doubleValue();
            Double r13 = ((com.obric.memorydata.ability.data.k) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.ability.data.k.class, "com.obric.memorydata.plugin")).c();
            Intrinsics.checkNotNull(r13);
            double r3 = r1.getDistance(r2, r13.doubleValue(), ((Number) ZeusTransformUtils.preCheckCast(a.c().getFirst(), Number.class, "com.obric.memorydata.plugin")).doubleValue(), ((Number) ZeusTransformUtils.preCheckCast(a.c().getSecond(), Number.class, "com.obric.memorydata.plugin")).doubleValue());
            if (r3 > 5000.0d) goto L16;
            RunLog.INSTANCE.debug("UserProfileTask", "距离差不超过5公里，不需要重新计算");
            return;
        L16:
            a r14 = a.f9953a;
            Double r4 = ((com.obric.memorydata.ability.data.k) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.ability.data.k.class, "com.obric.memorydata.plugin")).b();
            Intrinsics.checkNotNull(r4);
            Double r5 = ((com.obric.memorydata.ability.data.k) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.ability.data.k.class, "com.obric.memorydata.plugin")).c();
            Intrinsics.checkNotNull(r5);
            a.a(new Pair(r4, r5));
            TaskRequest.Builder r15 = new TaskRequest.Builder("home_company_location_calculate");
            JSONObject r6 = new JSONObject();
            r6.put("distance", r3);
            r6.put("taskName", "longTerm");
            r6.put("timestamp", System.currentTimeMillis() / ((long) 1000));
            r6.put("longitude", ((com.obric.memorydata.ability.data.k) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.ability.data.k.class, "com.obric.memorydata.plugin")).b());
            r6.put("latitude", ((com.obric.memorydata.ability.data.k) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.ability.data.k.class, "com.obric.memorydata.plugin")).c());
            r6.put("trigger_source", "location_change_5km");
            ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r15.setInputParam(r6), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/intelligence/datalearning/profile/UserProfileTask$registerLearningStateListener$1", "Lcom/obric/memorydata/middleware/api/store/StoreChangeListener;", "onKeyChanged", "", "repoName", "", "key", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.middleware.api.store.b {
        b() {
        }

        private static final void a() {
            a.a(a.f9953a);
        }

        public static /* synthetic */ void lambda$grSxKqMpt5AW15w0m68iF0qJo2s() {
            a();
        }

        @Override // com.obric.memorydata.middleware.api.store.b
        public void onKeyChanged(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "repoName");
            Intrinsics.checkNotNullParameter(r2, "key");
            if (Intrinsics.areEqual(r2, "auto_learn_common_address") == false) goto L6;
            ThreadPoolContainer.Companion.getInstance().execute($$Lambda$a$b$grSxKqMpt5AW15w0m68iF0qJo2s.INSTANCE);
            return;
        }
    }

    static {
        f9953a = new a();
        d = new d();
        e = new f(100000004, MapsKt.mapOf(TuplesKt.to("mode", "collect_geography")));
        Double r1 = Double.valueOf(0.0d);
        h = new Pair(r1, r1);
        i = new C0481a();
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r0) {
        r0.e();
    }

    public static final /* synthetic */ void a(Pair r0) {
        h = r0;
    }

    public static final /* synthetic */ Pair c() {
        return h;
    }

    private final void d() {
        if (g == false) goto L5;
        return;
    L5:
        g = true;
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).registerChangeListener((com.obric.memorydata.middleware.api.store.b) ZeusTransformUtils.preCheckCast(new b(), com.obric.memorydata.middleware.api.store.b.class, "com.obric.memorydata.plugin"));
    }

    private final synchronized void e() {
        monitor-enter(this);
        boolean r0 = com.obric.memorydata.address.a.f8427a.c();     // Catch: Throwable -> L23
        if (r0 != f) goto L7;
        monitor-exit(this);
        return;
    L7:
        if (r0 == false) goto L9;
        boolean r1 = d.a(e, (k) ZeusTransformUtils.preCheckCast(i, k.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L23
    L10:
        if (r1 == false) goto L16;
        f = r0;     // Catch: Throwable -> L23
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L23
        if (r0 == false) goto L14;
        String r4 = AwarenessManagerImpl.ACTION_SUBSCRIBE;
    L15:
        IRunLog.a.a(r2, "UserProfileTask", r3.append(r4).append(" location changes for home company learning").toString(), false, 4, null);     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L14:
        r4 = "unsubscribe";
        goto L15
    L16:
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        StringBuilder r6 = new StringBuilder().append("failed to ");     // Catch: Throwable -> L23
        if (r0 == false) goto L19;
        String r7 = AwarenessManagerImpl.ACTION_SUBSCRIBE;
    L20:
        IRunLog.a.a(r5, "UserProfileTask", r6.append(r7).append(" location changes for home company learning").toString(), null, 4, null);     // Catch: Throwable -> L23
        goto L21
    L19:
        r7 = "unsubscribe";
        goto L20
    L9:
        r1 = d.b(e, (k) ZeusTransformUtils.preCheckCast(i, k.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    private final boolean f() {
        if (g.a(System.currentTimeMillis()) >= 12) goto L7;
        return false;
    L7:
        return !com.obric.memorydata.utils.h.a(c.a(), System.currentTimeMillis());
    }

    private static final void g() {
        long r0 = System.currentTimeMillis();
        if ((r0 - c) >= 10800000) goto L6;
        RunLog.INSTANCE.debug("UserProfileTask", "距离上次解锁时间不足3小时，不需要处理");
        c = r0;
        return;
    L6:
        c = r0;
        int r2 = r.b(r0);
        if (4 <= r2) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L23;
        Long r4 = (Long) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE.getFeature("first_unlock_time"), Long.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L16;
    L21:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("day_first_unlock_time", r0);
        return;
    L16:
        if (r4.longValue() == 0) goto L21;
        if (r.a(r4.longValue()) == r.a(r0)) goto L24;
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("day_first_unlock_time", r0);
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "first_unlock_time", Long.valueOf(r0), null, 4, null);
        return;
    L24:
        return;
    L23:
        return;
    L9:
        if (r2 >= 13) goto L11;
        r3 = true;
        goto L12
    }

    public static /* synthetic */ void lambda$dSmP4gsMD2DT632BGIH90PMs60c() {
        g();
    }

    @Override // com.obric.memorydata.ability.k
    public void a(h r8) {
        h r9 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "data");
        if (ZeusTransformUtils.instanceOf(r9, p.class) == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r9, p.class, "com.obric.memorydata.plugin")).a(), "unlock") == false) goto L9;
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$a$dSmP4gsMD2DT632BGIH90PMs60c.INSTANCE);
    L9:
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r9, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.g) == true) goto L11;
        return;
    L11:
        if (f9954b == false) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileTask", "is running now", null, 4, null);
        return;
    L13:
        if (f() == true) goto L15;
        return;
    L15:
        RunLog.INSTANCE.debug("UserProfileTask", "begin run");
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L18:
        if (f9954b == true) goto L25;
        f9954b = true;     // Catch: Throwable -> L28
        if (com.obric.memorydata.utils.h.a(c.a(), System.currentTimeMillis()) == false) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileTask", "ignore because already run today", false, 4, null);     // Catch: Throwable -> L28
        f9954b = false;     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L24:
        com.obric.memorydata.intelligence.datalearning.profile.task.c.f9970a.a().a();     // Catch: Throwable -> L28
        f9954b = false;     // Catch: Throwable -> L28
    L25:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(this);
    }

    public final void b() {
        d.a(new f(100000005, MapsKt.mapOf(TuplesKt.to("mode", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL))), (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin"));
        d();
        e();
        if (f() == false) goto L6;
        com.obric.memorydata.intelligence.datalearning.profile.task.c.f9970a.a().a();
        return;
    }

    @Override // com.obric.memorydata.ability.k
    public String g_() {
        return k.a.a(this);
    }
}
