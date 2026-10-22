package com.obric.memorydata.ability.a;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.data.t;
import com.obric.memorydata.ability.f;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.database.entity.cl;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.thirdparty.api.location.LocationManager;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u001b \bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002J\u0016\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0019J\u000e\u0010*\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0005J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\bH\u0002J\u0018\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u0012H\u0002J\n\u00100\u001a\u0004\u0018\u000101H\u0002J\u0017\u00102\u001a\u0004\u0018\u00010\b2\u0006\u0010.\u001a\u00020\u0012H\u0002¢\u0006\u0002\u00103J\u000e\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\bJ\u000e\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!¨\u00068"}, d2 = {"Lcom/obric/memorydata/ability/helper/MemoryGeoFenceHelper;", "", "<init>", "()V", "STATUS_IN", "", "STATUS_OUT", "debugQueryTime", "", "Ljava/lang/Long;", "useStrategy", "", "TAG", "STATUS_UNKNOWN", "LAST_LOCATION_TIME_INTERVAL", "timeAbilityParams", "Lcom/obric/memorydata/ability/AbilityParams;", "lastOutNearDistance", "", "abilityManager", "Lcom/obric/memorydata/ability/AbilityManager;", "locationQueryParams", "geoFenceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Pair;", "Lcom/obric/memorydata/ability/helper/MemoryGeoFenceParams;", "timerReceiver", "com/obric/memorydata/ability/helper/MemoryGeoFenceHelper$timerReceiver$1", "Lcom/obric/memorydata/ability/helper/MemoryGeoFenceHelper$timerReceiver$1;", "runnable", "Ljava/lang/Runnable;", "locationChangeListener", "com/obric/memorydata/ability/helper/MemoryGeoFenceHelper$locationChangeListener$1", "Lcom/obric/memorydata/ability/helper/MemoryGeoFenceHelper$locationChangeListener$1;", "onTimeReceive", "", "onLocationDataReceive", "data", "Lcom/obric/memorydata/ability/data/LocationStandardData;", "register", "key", TrackerImpl.PARAMS, "unregister", "subscribeTimer", "delayTime", "getStatus", "distance", "radius", "queryLocationFromDb", "Lcom/obric/memorydata/database/entity/LocationEntity;", "getQueryLocationInternal", "(D)Ljava/lang/Long;", "testPowerConsumption", OaidModel.KEY_TIME, "openStrategy", "open", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8298a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Long f8299b;
    private static boolean c;
    private static f d;
    private static double e;
    private static final com.obric.memorydata.ability.d f = null;
    private static final f g = null;
    private static final ConcurrentHashMap<String, Pair<com.obric.memorydata.ability.a.c, String>> h = null;
    private static final c i = null;
    private static final Runnable j = null;
    private static final C0416a k = null;

    /* JADX INFO: renamed from: com.obric.memorydata.ability.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/ability/helper/MemoryGeoFenceHelper$locationChangeListener$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0416a implements k {
        C0416a() {
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r4) {
            h r3 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "data");
            RunLog.INSTANCE.debug("MemoryGeoFenceHelper", "locationChangeListener onDataReceive");
            if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.ability.data.k.class) == false) goto L6;
            a.a(a.f8298a, (com.obric.memorydata.ability.data.k) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.ability.data.k.class, "com.obric.memorydata.plugin"));
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/ability/helper/MemoryGeoFenceHelper$onTimeReceive$2$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements k {
        b() {
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r2) {
            h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "data");
            if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.ability.data.k.class) == false) goto L6;
            RunLog.INSTANCE.debug("MemoryGeoFenceHelper", "handler in subscribe locationChangeListener");
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/ability/helper/MemoryGeoFenceHelper$timerReceiver$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements k {
        c() {
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r3) {
            h r2 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "data");
            RunLog.INSTANCE.debug("MemoryGeoFenceHelper", "timerReceiver onDataReceive  ");
            if (ZeusTransformUtils.instanceOf(r2, t.class) == false) goto L6;
            a.a(a.f8298a);
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    static {
        f8298a = new a();
        c = true;
        e = Double.MAX_VALUE;
        f = new com.obric.memorydata.ability.d();
        g = new f(100000004, MapsKt.mapOf(TuplesKt.to("mode", "collect_geography")));
        h = new ConcurrentHashMap();
        i = new c();
        j = $$Lambda$a$3HLIrFFkchfhkssI6k7IEOGwfDU.INSTANCE;
        k = new C0416a();
    }

    private a() {
    }

    private final Long a(double r4) {
        Long r3 = f8299b;
        if (r3 == null) goto L6;
        return r3;
    L6:
        if (c == true) goto L8;
        return null;
    L8:
        if (r4 < 5000.0d) goto L11;
        return null;
    L11:
        if (r4 < 2000.0d) goto L15;
        long r5 = 300000;
    L19:
        return Long.valueOf(r5);
    L15:
        if (r4 < 1000.0d) goto L17;
        r5 = 120000;
        goto L19
    L17:
        r5 = 60000;
        goto L19
    }

    private final String a(double r1, double r3) {
        if (r1 > r3) goto L5;
        return "in";
    L5:
        return "out";
    }

    private final void a() {
        f r4 = d;
        if (r4 == null) goto L5;
        f.b(r4, (k) ZeusTransformUtils.preCheckCast(i, k.class, "com.obric.memorydata.plugin"));
    L5:
        GlobalHandlerUtil.Companion.getInstance().removeCallbacks(j);
        if ((!((Map) ZeusTransformUtils.preCheckCast(h, Map.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
    L9:
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$a$XTPmbW0fiyNcvcMMkZuJ3wajUA.INSTANCE);
        return;
    L8:
        if (f8299b != null) goto L9;
    }

    private final void a(long r7) {
        RunLog.INSTANCE.debug("MemoryGeoFenceHelper", "subscribeTimer delayTime " + r7);
        if (r7 > 0) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryGeoFenceHelper", "subscribeTimer delayTime error", null, 4, null);
        return;
    L6:
        f r6 = d;
        if (r6 == null) goto L9;
        f.b(r6, (k) ZeusTransformUtils.preCheckCast(i, k.class, "com.obric.memorydata.plugin"));
    L9:
        GlobalHandlerUtil r8 = GlobalHandlerUtil.Companion.getInstance();
        Runnable r1 = j;
        r8.removeCallbacks(r1);
        f r9 = new f(100000006, MapsKt.mapOf(TuplesKt.to(OaidModel.KEY_TIME, Long.valueOf(System.currentTimeMillis() + r7))));
        f.a(r9, (k) ZeusTransformUtils.preCheckCast(i, k.class, "com.obric.memorydata.plugin"));
        GlobalHandlerUtil.Companion.getInstance().postDelay(r1, r7);
        d = r9;
    }

    public static final /* synthetic */ void a(a r0) {
        r0.a();
    }

    public static final /* synthetic */ void a(a r0, com.obric.memorydata.ability.data.k r1) {
        r0.a(r1);
    }

    private static final void a(com.obric.memorydata.ability.a.c r7, String r8, cl r9, String r10) {
        r7.d().a(r8, r9.d(), r9.e(), r10);
    }

    private final void a(com.obric.memorydata.ability.data.k r20) {
        RunLog.INSTANCE.debug("MemoryGeoFenceHelper", "onLocationDataReceive longitude:" + r20.b() + ", latitude:" + r20.c());
        if (r20.b() != null) goto L5;
    L40:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryGeoFenceHelper", "locationChangeListener location incorrect", null, 4, null);
        return;
    L5:
        if (r20.c() == null) goto L40;
        HashMap r0 = new HashMap();
        double r3 = Double.MAX_VALUE;
        Iterator r5 = ((Map) ZeusTransformUtils.preCheckCast(h, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L9:
        if (r5.hasNext() == false) goto L26;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        LocationManager r7 = LocationManager.INSTANCE;
        double r8 = ((com.obric.memorydata.ability.a.c) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r6.getValue(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), com.obric.memorydata.ability.a.c.class, "com.obric.memorydata.plugin")).a();
        double r10 = ((com.obric.memorydata.ability.a.c) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r6.getValue(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), com.obric.memorydata.ability.a.c.class, "com.obric.memorydata.plugin")).b();
        Double r12 = r20.b();
        if (r12 == null) goto L13;
        double r15 = r12.doubleValue();
    L14:
        Double r13 = r20.c();
        if (r13 == null) goto L17;
        double r17 = r13.doubleValue();
    L18:
        double r9 = r7.getDistance(r8, r10, r15, r17);
        String r11 = f8298a.a(r9, ((com.obric.memorydata.ability.a.c) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r6.getValue(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), com.obric.memorydata.ability.a.c.class, "com.obric.memorydata.plugin")).c());
        RunLog.INSTANCE.debug("MemoryGeoFenceHelper", "onLocationDataReceive longitude: " + ((com.obric.memorydata.ability.a.c) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r6.getValue(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), com.obric.memorydata.ability.a.c.class, "com.obric.memorydata.plugin")).a() + " latitude " + ((com.obric.memorydata.ability.a.c) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r6.getValue(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), com.obric.memorydata.ability.a.c.class, "com.obric.memorydata.plugin")).b() + " distance:" + r9 + " status:" + r11);
        if (Intrinsics.areEqual(r11, ((Pair) ZeusTransformUtils.preCheckCast(r6.getValue(), Pair.class, "com.obric.memorydata.plugin")).getSecond()) == true) goto L22;
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r6.getKey(), r11);
    L22:
        if (r3 <= r9) goto L9;
        if (Intrinsics.areEqual(r11, "out") == false) goto L9;
        r3 = r9;
        goto L9
    L17:
        r17 = 0.0d;
        goto L18
    L13:
        r15 = 0.0d;
        goto L14
    L26:
        e = r3;
        Iterator r4 = ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L28:
        if (r4.hasNext() == false) goto L33;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ConcurrentHashMap<String, Pair<com.obric.memorydata.ability.a.c, String>> r16 = h;
        Pair r18 = (Pair) ZeusTransformUtils.preCheckCast(r16.get(r14.getKey()), Pair.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L28;
        ((Map) ZeusTransformUtils.preCheckCast(r16, Map.class, "com.obric.memorydata.plugin")).put(r14.getKey(), new Pair(r18.getFirst(), r14.getValue()));
        RunLog.INSTANCE.debug("MemoryGeoFenceHelper", "onLocationDataReceive status keys:" + r0.keySet() + " change " + ((String) ZeusTransformUtils.preCheckCast(r14.getValue(), String.class, "com.obric.memorydata.plugin")));
        ((com.obric.memorydata.ability.a.c) ZeusTransformUtils.preCheckCast(r18.getFirst(), com.obric.memorydata.ability.a.c.class, "com.obric.memorydata.plugin")).d().a((String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.memorydata.plugin"), ((com.obric.memorydata.ability.a.c) ZeusTransformUtils.preCheckCast(r18.getFirst(), com.obric.memorydata.ability.a.c.class, "com.obric.memorydata.plugin")).a(), ((com.obric.memorydata.ability.a.c) ZeusTransformUtils.preCheckCast(r18.getFirst(), com.obric.memorydata.ability.a.c.class, "com.obric.memorydata.plugin")).b(), (String) ZeusTransformUtils.preCheckCast(r14.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L28
    L33:
        if ((!((Map) ZeusTransformUtils.preCheckCast(h, Map.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L35;
    L36:
        Long r1 = a(e);
        RunLog.INSTANCE.debug("MemoryGeoFenceHelper", "distance " + e + ", delay time " + r1);
        if (r1 == null) goto L55;
        f8298a.a(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L55:
        return;
    L35:
        if (f8299b != null) goto L36;
    }

    private final cl b() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getLocationDao().queryLastRecord(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(20), System.currentTimeMillis());
    }

    private static final void c() {
        RunLog.INSTANCE.debug("MemoryGeoFenceHelper", "runnable time receiver  ");
        f8298a.a();
    }

    private static final void d() {
        RunLog.INSTANCE.debug("MemoryGeoFenceHelper", "query location");
        f.query(g, (k) ZeusTransformUtils.preCheckCast(new b(), k.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ void lambda$3HLIrFFkchfhkssI6k7IEOGwfDU() {
        c();
    }

    public static /* synthetic */ void lambda$4qS2vx8cg5sl7YJHtyEhGheubI4(com.obric.memorydata.ability.a.c r0, String r1, cl r2, String r3) {
        a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$X-TPmbW0fiyNcvcMMkZuJ3wajUA, reason: not valid java name */
    public static /* synthetic */ void m430lambda$XTPmbW0fiyNcvcMMkZuJ3wajUA() {
        d();
    }

    public final void a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "key");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryGeoFenceHelper", "unregister key:" + r9, false, 4, null);
        ConcurrentHashMap<String, Pair<com.obric.memorydata.ability.a.c, String>> r8 = h;
        r8.remove(r9);
        if (r8.isEmpty() == false) goto L6;
        f.b(g, (k) ZeusTransformUtils.preCheckCast(k, k.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final void a(final String r13, final com.obric.memorydata.ability.a.c r14) {
        Intrinsics.checkNotNullParameter(r13, "key");
        Intrinsics.checkNotNullParameter(r14, TrackerImpl.PARAMS);
        RunLog.INSTANCE.debug("MemoryGeoFenceHelper", "register " + r13 + ", longitude:" + r14.a() + " latitude:" + r14.b());
        final cl r0 = b();
        if (r0 != null) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryGeoFenceHelper", "lastLocation is null", null, 4, null);
        ((Map) ZeusTransformUtils.preCheckCast(h, Map.class, "com.obric.memorydata.plugin")).put(r13, new Pair(r14, "unknown"));
    L13:
        if (h.size() != 1) goto L16;
        f.a(g, (k) ZeusTransformUtils.preCheckCast(k, k.class, "com.obric.memorydata.plugin"));
        return;
    L16:
        return;
    L5:
        double r3 = LocationManager.INSTANCE.getDistance(r14.a(), r14.b(), r0.d(), r0.e());
        final String r5 = a(r3, r14.c());
        ((Map) ZeusTransformUtils.preCheckCast(h, Map.class, "com.obric.memorydata.plugin")).put(r13, new Pair(r14, r5));
        GlobalHandlerUtil.Companion.getInstance().sendMsgDelay(new $$Lambda$a$4qS2vx8cg5sl7YJHtyEhGheubI4(r14, r13, r0, r5), TimeUnit.SECONDS.toMillis(5));
        RunLog.INSTANCE.debug("MemoryGeoFenceHelper", "register geofence status is " + r5 + " distance is " + r3 + " last " + e);
        if (r3 >= e) goto L13;
        if (Intrinsics.areEqual(r5, "out") == false) goto L13;
        e = r3;
        long r15 = RangesKt.coerceAtLeast(System.currentTimeMillis() - r0.c(), 0);
        Long r12 = a(r3);
        if (r12 == null) goto L13;
        f8298a.a(RangesKt.coerceAtLeast(((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).longValue() - r15, 60000));
        goto L13
    }
}
