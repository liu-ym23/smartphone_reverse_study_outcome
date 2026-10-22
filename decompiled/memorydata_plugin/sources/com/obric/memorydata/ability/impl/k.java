package com.obric.memorydata.ability.impl;

import android.content.Context;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J&\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/memorydata/ability/impl/LocationAbility;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "context", "Landroid/content/Context;", "key2Mode", "Ljava/util/concurrent/ConcurrentHashMap;", "", "mode2keys", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "", "geographyAbilityTeaTrackerSubscribeParams", "Lcom/obric/memorydata/ability/AbilityParams;", "onCreate", "", "iAbilityContext", "fillLocationStandardData", "locationStandardData", "Lcom/obric/memorydata/ability/data/LocationStandardData;", "geographyStandardData", "Lcom/obric/memorydata/ability/data/GeographyStandardData;", "timeoutSecond", "", "handleCollectGeographySubscribe", "key", "onSubscribe", TrackerImpl.PARAMS, "handleCollectGeographyUnsubscribe", "onUnsubscribe", "onQuery", "onDestroy", "onDataReceive", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k implements i, com.obric.memorydata.ability.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8390a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8391b;
    private Context c;
    private final ConcurrentHashMap<String, String> d;
    private final ConcurrentHashMap<String, ConcurrentHashMap.KeySetView<String, Boolean>> e;
    private final com.obric.memorydata.ability.f f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/ability/impl/LocationAbility$Companion;", "", "<init>", "()V", "TAG", "", "MODE_KEY", "MODE_COLLECT_GEOGRAPHY", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/ability/impl/LocationAbility$fillLocationStandardData$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.ability.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.memorydata.ability.data.k f8392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f8393b;

        b(com.obric.memorydata.ability.data.k r1, CountDownLatch r2) {
            this.f8392a = r1;
            this.f8393b = r2;
        }

        @Override // com.obric.memorydata.ability.k
        public void a(com.obric.memorydata.ability.data.h r7) {
            com.obric.memorydata.ability.data.h r8 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "data");
            if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.ability.data.g.class) == false) goto L5;
            this.f8392a.b(Double.valueOf(((com.obric.memorydata.ability.data.g) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.ability.data.g.class, "com.obric.memorydata.plugin")).b()));
            this.f8392a.a(Double.valueOf(((com.obric.memorydata.ability.data.g) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.ability.data.g.class, "com.obric.memorydata.plugin")).a()));
        L5:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationAbility", "receive location data", false, 4, null);
            this.f8393b.countDown();
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return com.obric.memorydata.ability.k.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/ability/impl/LocationAbility$fillLocationStandardData$2", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.memorydata.ability.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.memorydata.ability.data.k f8394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f8395b;

        c(com.obric.memorydata.ability.data.k r1, CountDownLatch r2) {
            this.f8394a = r1;
            this.f8395b = r2;
        }

        @Override // com.obric.memorydata.ability.k
        public void a(com.obric.memorydata.ability.data.h r7) {
            com.obric.memorydata.ability.data.h r8 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "data");
            if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.ability.data.l.class) == false) goto L5;
            this.f8394a.a(((com.obric.memorydata.ability.data.l) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.ability.data.l.class, "com.obric.memorydata.plugin")).a());
            this.f8394a.a(((com.obric.memorydata.ability.data.l) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.ability.data.l.class, "com.obric.memorydata.plugin")).b());
            this.f8394a.a(((com.obric.memorydata.ability.data.l) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.ability.data.l.class, "com.obric.memorydata.plugin")).c());
        L5:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationAbility", "receive cell data", false, 4, null);
            this.f8395b.countDown();
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return com.obric.memorydata.ability.k.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/ability/impl/LocationAbility$fillLocationStandardData$3", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements com.obric.memorydata.ability.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.memorydata.ability.data.k f8396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f8397b;

        d(com.obric.memorydata.ability.data.k r1, CountDownLatch r2) {
            this.f8396a = r1;
            this.f8397b = r2;
        }

        @Override // com.obric.memorydata.ability.k
        public void a(com.obric.memorydata.ability.data.h r7) {
            com.obric.memorydata.ability.data.h r8 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "data");
            if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.ability.data.u.class) == false) goto L5;
            this.f8396a.b(((com.obric.memorydata.ability.data.u) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.ability.data.u.class, "com.obric.memorydata.plugin")).b());
            this.f8396a.c(((com.obric.memorydata.ability.data.u) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.ability.data.u.class, "com.obric.memorydata.plugin")).c());
        L5:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationAbility", "receive wifi data", false, 4, null);
            this.f8397b.countDown();
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return com.obric.memorydata.ability.k.a.a(this);
        }
    }

    static {
        f8390a = new a(null);
    }

    public k() {
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new com.obric.memorydata.ability.f(100000001, MapsKt.mapOf(TuplesKt.to("mode", "collect_geography")));
    }

    private static final void a(k r17, com.obric.memorydata.ability.data.h r18) {
        com.obric.memorydata.ability.data.h r1 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r18, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
        Double r5 = Double.valueOf(0.0d);
        com.obric.memorydata.ability.data.k r15 = new com.obric.memorydata.ability.data.k(r5, r5, -1L, -1, "", "", "", null, null, null, 896, null);
        if (r17.a(r15, (com.obric.memorydata.ability.data.g) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.ability.data.g.class, "com.obric.memorydata.plugin"), 3) == false) goto L10;
        ConcurrentHashMap.KeySetView r2 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r17.e.get("collect_geography"), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L12;
        Iterator r3 = r2.iterator();
        Intrinsics.checkNotNullExpressionValue(r3, "iterator(...)");
    L8:
        if (r3.hasNext() == false) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.ability.j r6 = r17.f8391b;
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNull(r4);
        r6.a(r4, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r15, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        goto L8
    L13:
        return;
    L12:
        return;
    }

    private final boolean a(com.obric.memorydata.ability.data.k r6, com.obric.memorydata.ability.data.g r7, long r8) {
        CountDownLatch r0 = new CountDownLatch(3);
        if (r7 == null) goto L6;
        r6.b(Double.valueOf(r7.b()));
        r6.a(Double.valueOf(r7.a()));
        r6.a(Float.valueOf(r7.c()));
        r6.b(Float.valueOf(r7.d()));
    L5:
        r0.countDown();
    L9:
        com.obric.memorydata.ability.j r9 = this.f8391b;
        Intrinsics.checkNotNull(r9);
        if (r9.query(new com.obric.memorydata.ability.f(100000003, MapsKt.emptyMap()), (com.obric.memorydata.ability.k) ZeusTransformUtils.preCheckCast(new c(r6, r0), com.obric.memorydata.ability.k.class, "com.obric.memorydata.plugin")) == true) goto L12;
        r0.countDown();
    L12:
        com.obric.memorydata.ability.j r5 = this.f8391b;
        Intrinsics.checkNotNull(r5);
        if (r5.query(new com.obric.memorydata.ability.f(100000002, MapsKt.emptyMap()), (com.obric.memorydata.ability.k) ZeusTransformUtils.preCheckCast(new d(r6, r0), com.obric.memorydata.ability.k.class, "com.obric.memorydata.plugin")) == true) goto L16;
        r0.countDown();
    L16:
        return r0.await(r8, TimeUnit.SECONDS);
    L6:
        com.obric.memorydata.ability.j r10 = this.f8391b;
        Intrinsics.checkNotNull(r10);
        if (r10.query(new com.obric.memorydata.ability.f(100000001, MapsKt.emptyMap()), (com.obric.memorydata.ability.k) ZeusTransformUtils.preCheckCast(new b(r6, r0), com.obric.memorydata.ability.k.class, "com.obric.memorydata.plugin")) == true) goto L9;
        goto L9
    }

    static /* synthetic */ boolean a(k r0, com.obric.memorydata.ability.data.k r1, com.obric.memorydata.ability.data.g r2, long r3, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = 10;
    L9:
        return r0.a(r1, r2, r3);
    }

    private final boolean a(String r7) {
        ConcurrentHashMap.KeySetView r0 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(this.e.get("collect_geography"), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.contains(r7) == true) goto L10;
        r0.add(r7);
        ((Map) ZeusTransformUtils.preCheckCast(this.d, Map.class, "com.obric.memorydata.plugin")).put(r7, "collect_geography");
        if (r0.size() != 1) goto L9;
        com.obric.memorydata.ability.j r8 = this.f8391b;
        Intrinsics.checkNotNull(r8);
        r8.a(this.f, (com.obric.memorydata.ability.k) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.ability.k.class, "com.obric.memorydata.plugin"));
    L9:
        return true;
    L10:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationAbility", "handleTeaTrackerSubscribe teaTrackerSubscriberKeySet already contains key(" + r7 + ").", null, 4, null);
        return false;
    }

    private final boolean b(String r7) {
        ConcurrentHashMap.KeySetView r0 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(this.e.get("collect_geography"), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.contains(r7) == false) goto L11;
        r0.remove(r7);
        this.d.remove(r7);
        if (r0.size() != 0) goto L14;
        com.obric.memorydata.ability.j r8 = this.f8391b;
        Intrinsics.checkNotNull(r8);
        r8.b(this.f, (com.obric.memorydata.ability.k) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.ability.k.class, "com.obric.memorydata.plugin"));
        return true;
    L14:
        return true;
    L11:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationAbility", "handleTeaTrackerUnsubscribe teaTrackerSubscriberKeySet don't contains key(" + r7 + ").", null, 4, null);
        return false;
    }

    /* JADX INFO: renamed from: lambda$XgL6u-WvK8KgJ7lprFkZ9sXas1w, reason: not valid java name */
    public static /* synthetic */ void m438lambda$XgL6uWvK8KgJ7lprFkZ9sXas1w(k r0, com.obric.memorydata.ability.data.h r1) {
        a(r0, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        this.c = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
        this.d.clear();
        ConcurrentHashMap.KeySetView<String, Boolean> r0 = this.e.get("collect_geography");
        Intrinsics.checkNotNull(r0);
        ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r0, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).clear();
        this.e.clear();
    }

    @Override // com.obric.memorydata.ability.k
    public void a(com.obric.memorydata.ability.data.h r3) {
        final com.obric.memorydata.ability.data.h r4 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "data");
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.ability.data.g.class) == false) goto L6;
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$k$XgL6uWvK8KgJ7lprFkZ9sXas1w(this, r4));
        return;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r3) {
        com.obric.memorydata.ability.j r4 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "iAbilityContext");
        this.f8391b = r4;
        this.c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        ((Map) ZeusTransformUtils.preCheckCast(this.e, Map.class, "com.obric.memorydata.plugin")).put("collect_geography", ConcurrentHashMap.newKeySet());
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r10, com.obric.memorydata.ability.f r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, TrackerImpl.PARAMS);
        Object r12 = r11.b().getOrDefault("mode", "");
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.String");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r6 = null;
        int r7 = 4;
        Object r8 = null;
        String r4 = "LocationAbility";
        String r5 = "onSubscribe: this mode is empty.";
    L8:
        IRunLog.a.b(r3, r4, r5, r6, r7, r8);
        return false;
    L11:
        if (this.d.containsKey(r10) == false) goto L14;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r6 = null;
        r7 = 4;
        r8 = null;
        r4 = "LocationAbility";
        r5 = "onSubscribe: this key has not unsubscribe.";
        goto L8
    L14:
        if (Intrinsics.areEqual(r13, "collect_geography") == true) goto L16;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r6 = null;
        r7 = 4;
        r8 = null;
        r4 = "LocationAbility";
        r5 = "onSubscribe: mode error.";
        goto L8
    L16:
        return a(r10);
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r10, com.obric.memorydata.ability.f r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, TrackerImpl.PARAMS);
        Object r12 = r11.b().getOrDefault("mode", "");
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.String");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r6 = null;
        int r7 = 4;
        Object r8 = null;
        String r4 = "LocationAbility";
        String r5 = "onUnsubscribe: this mode is empty.";
    L8:
        IRunLog.a.b(r3, r4, r5, r6, r7, r8);
        return false;
    L11:
        if (this.d.containsKey(r10) == true) goto L14;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r6 = null;
        r7 = 4;
        r8 = null;
        r4 = "LocationAbility";
        r5 = "onUnsubscribe: this key has not subscribe";
        goto L8
    L14:
        if (Intrinsics.areEqual(r13, "collect_geography") == true) goto L16;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r6 = null;
        r7 = 4;
        r8 = null;
        r4 = "LocationAbility";
        r5 = "onUnsubscribe: mode error.";
        goto L8
    L16:
        return b(r10);
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r24, com.obric.memorydata.ability.f r25) {
        Intrinsics.checkNotNullParameter(r24, "key");
        Intrinsics.checkNotNullParameter(r25, TrackerImpl.PARAMS);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationAbility", "onQuery " + r24, false, 4, null);
        Double r12 = Double.valueOf(0.0d);
        com.obric.memorydata.ability.data.k r1 = new com.obric.memorydata.ability.data.k(r12, r12, -1L, -1, "", "", "", null, null, null, 896, null);
        if (a(this, r1, null, 0, 6, null) == false) goto L6;
        com.obric.memorydata.ability.j r4 = this.f8391b;
        Intrinsics.checkNotNull(r4);
        r4.a(r24, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationAbility", "onQuery " + r24 + " success", false, 4, null);
        return true;
    L6:
        return false;
    }

    @Override // com.obric.memorydata.ability.k
    public String g_() {
        return com.obric.memorydata.ability.k.a.a(this);
    }
}
