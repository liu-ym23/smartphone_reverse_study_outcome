package com.obric.memorydata.recommend.screenshotupload.a;

import android.content.Context;
import android.location.LocationManager;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.ability.d;
import com.obric.memorydata.ability.data.g;
import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.f;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.awareness.api.ILocationSnapshot;
import com.obric.memorydata.awareness.api.LocationSnapshot;
import com.obric.memorydata.awareness.location.LocationProcessor;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J \u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000f8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/location/RecommendLocationManager;", "", "<init>", "()V", "TAG", "", "FREQUENCY", "", "KEY_LONGITUDE", "KEY_LATITUDE", "KEY_TIMESTAMP", "lastRequestTs", "lastLocation", "Lcom/obric/memorydata/recommend/screenshotupload/location/RecommendLocation;", "locationManager", "Landroid/location/LocationManager;", "isInit", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "getLocation", "asyncRequestLocation", "currentTs", "requestLocationIfAllowed", "canRequestLocation", "updateLocation", "longitude", "", "latitude", "timestamp", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12540a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f12541b;
    private static com.obric.memorydata.recommend.screenshotupload.a.a c;
    private static final LocationManager d = null;
    private static boolean e;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/recommend/screenshotupload/location/RecommendLocationManager$init$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements k {
        a() {
        }

        private static final void a(double r7, double r9) {
            b.a(b.f12540a, r7, r9, System.currentTimeMillis());
        }

        public static /* synthetic */ void lambda$J72pI8F_kR1Tph2TBPQr9tD9Yrc(double r0, double r2) {
            a(r0, r2);
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r5) {
            h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "data");
            if (ZeusTransformUtils.instanceOf(r4, g.class) == false) goto L6;
            final double r1 = ((g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.memorydata.plugin")).a();
            final double r6 = ((g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.memorydata.plugin")).b();
            ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$b$a$J72pI8F_kR1Tph2TBPQr9tD9Yrc(r1, r6));
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    static {
        f12540a = new b();
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("location");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.location.LocationManager");
        d = (LocationManager) ZeusTransformUtils.preCheckCast(r0, LocationManager.class, "com.obric.memorydata.plugin");
    }

    private b() {
    }

    private final void a(double r15, double r17, long r19) {
        boolean r5 = true;
        if (Intrinsics.areEqual(FeatureManager.INSTANCE.getFeature("device_screen_state"), 1) == true) goto L6;
        RunLog.INSTANCE.debug("RecommendLocationManager", "screen off, do not request location");
        return;
    L6:
        RunLog.INSTANCE.debug("RecommendLocationManager", "updateLocation, " + r15 + ' ' + r17 + ' ' + r19);
        com.obric.memorydata.recommend.screenshotupload.a.a r0 = c;
        String r9 = "";
        if (r0 != null) goto L9;
        b r1 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.recommend.context.b.d() == false) goto L38;
        String r2 = LocationProcessor.INSTANCE.getAddressByGps(r15, r17);
        if (r2 == null) goto L38;
        String r6 = r2;
    L39:
        com.obric.memorydata.recommend.screenshotupload.a.a r8 = new com.obric.memorydata.recommend.screenshotupload.a.a(r15, r17, r6, r19);
    L40:
        c = r8;
        return;
    L38:
        r6 = "";
        goto L39
    L9:
        if (Math.abs(r0.a() - r15) > 1.0E-4d) goto L25;
        if (Math.abs(r0.b() - r17) > 1.0E-4d) goto L25;
        r0.a(r19);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0.c(), CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L16;
        r5 = false;
    L16:
        if (r5 == true) goto L18;
        return;
    L18:
        if (com.obric.memorydata.recommend.context.b.d() == false) goto L23;
        String r3 = LocationProcessor.INSTANCE.getAddressByGps(r15, r17);
        if (r3 == null) goto L23;
        r9 = r3;
    L23:
        r0.a(r9);
        return;
    L25:
        if (com.obric.memorydata.recommend.context.b.d() == false) goto L30;
        String r4 = LocationProcessor.INSTANCE.getAddressByGps(r15, r17);
        if (r4 == null) goto L30;
        String r7 = r4;
    L31:
        r8 = new com.obric.memorydata.recommend.screenshotupload.a.a(r15, r17, r7, r19);
    L30:
        r7 = "";
        goto L31
    }

    private final void a(long r3) {
        if ((r3 - f12541b) >= 60000) goto L5;
        return;
    L5:
        f12541b = System.currentTimeMillis();
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$b$bCkWtwcQ5fMKDY2yoYy1UxZ6qk0.INSTANCE);
    }

    public static final /* synthetic */ void a(b r0, double r1, double r3, long r5) {
        r0.a(r1, r3, r5);
    }

    private final void c() {
        if (d() == false) goto L6;
        ILocationSnapshot.a.a((ILocationSnapshot) ZeusTransformUtils.preCheckCast(LocationSnapshot.INSTANCE, ILocationSnapshot.class, "com.obric.memorydata.plugin"), 0, 1, null);
        return;
    }

    private final boolean d() {
        if (d.isLocationEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (com.obric.memorydata.b.a.f8796a.b() == false) goto L7;
        return true;
    }

    private static final void e() {
        f12540a.c();
    }

    private static final void f() {
        f12540a.c();
    }

    public static /* synthetic */ void lambda$bCkWtwcQ5fMKDY2yoYy1UxZ6qk0() {
        f();
    }

    /* JADX INFO: renamed from: lambda$n2Ki1lBWE-dUhRxrv-AXaEmWjuQ, reason: not valid java name */
    public static /* synthetic */ void m1120lambda$n2Ki1lBWEdUhRxrvAXaEmWjuQ() {
        e();
    }

    public final void a() {
        if (e == false) goto L5;
        return;
    L5:
        e = true;
        new d().a(new f(100000001, MapsKt.mapOf(TuplesKt.to("mode", "collect_geography"))), (k) ZeusTransformUtils.preCheckCast(new a(), k.class, "com.obric.memorydata.plugin"));
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$b$n2Ki1lBWEdUhRxrvAXaEmWjuQ.INSTANCE);
    }

    public final com.obric.memorydata.recommend.screenshotupload.a.a b() {
        if (d() == true) goto L5;
        return null;
    L5:
        a();
        long r2 = System.currentTimeMillis();
        com.obric.memorydata.recommend.screenshotupload.a.a r0 = c;
        if (r0 != null) goto L8;
        ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).a(r2);
    L14:
        return null;
    L8:
        if (r0.d() < (r2 - 300000)) goto L10;
        return r0;
    L10:
        f12540a.a(r2);
        if (r0.d() < (r2 - 600000)) goto L14;
        return r0;
    }
}
