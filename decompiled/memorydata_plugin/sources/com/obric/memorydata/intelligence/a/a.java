package com.obric.memorydata.intelligence.a;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.database.entity.cl;
import com.obric.memorydata.database.entity.o;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u0014\u0017\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u0001H\u0002J\u0015\u0010\u001f\u001a\u0004\u0018\u00010 *\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010!J$\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0012\u0010'\u001a\u00020\u00012\b\u0010%\u001a\u0004\u0018\u00010&H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006)"}, d2 = {"Lcom/obric/memorydata/intelligence/collector/ArriveLeaveHomeCompanyEventCollector;", "", "<init>", "()V", "TAG", "", "KEY_LOCATION_NAME", "KEY_LOCATION_TYPE", "KEY_CACHED_GPS", "KEY_LONGITUDE", "KEY_LATITUDE", "STORED_EVENT_AT_HOME", "STORED_EVENT_OUT_HOME", "STORED_EVENT_AT_COMPANY", "STORED_EVENT_OUT_COMPANY", "homeCompanyEventToStoredEventName", "", "transportHubContextEventMappings", "Lcom/obric/memorydata/intelligence/collector/ArriveLeaveHomeCompanyEventCollector$TransportHubEventMapping;", "homeCompanyContextEventListener", "com/obric/memorydata/intelligence/collector/ArriveLeaveHomeCompanyEventCollector$homeCompanyContextEventListener$1", "Lcom/obric/memorydata/intelligence/collector/ArriveLeaveHomeCompanyEventCollector$homeCompanyContextEventListener$1;", "transportHubListener", "com/obric/memorydata/intelligence/collector/ArriveLeaveHomeCompanyEventCollector$transportHubListener$1", "Lcom/obric/memorydata/intelligence/collector/ArriveLeaveHomeCompanyEventCollector$transportHubListener$1;", "startCollector", "", "resolveHomeCompanyEventLocation", "event", "queryLastAtHomeEventLocation", "toGpsLocationString", "toDoubleOrNull", "", "(Ljava/lang/Object;)Ljava/lang/Double;", "buildTransportHubLocationPayload", "locationType", "locationName", "cachedLocation", "Lcom/obric/memorydata/database/entity/LocationEntity;", "buildCachedGps", "TransportHubEventMapping", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9929a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f9930b = null;
    private static final Map<String, C0479a> c = null;
    private static final b d = null;
    private static final c e = null;

    /* JADX INFO: renamed from: com.obric.memorydata.intelligence.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/intelligence/collector/ArriveLeaveHomeCompanyEventCollector$TransportHubEventMapping;", "", "storedEventName", "", "locationType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getStoredEventName", "()Ljava/lang/String;", "getLocationType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0479a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9932b;

        public C0479a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "storedEventName");
            Intrinsics.checkNotNullParameter(r3, "locationType");
            this.f9931a = r2;
            this.f9932b = r3;
        }

        public final String a() {
            return this.f9931a;
        }

        public final String b() {
            return this.f9932b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0479a.class) == true) goto L8;
            return false;
        L8:
            C0479a r6 = (C0479a) ZeusTransformUtils.preCheckCast(r5, C0479a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9931a, r6.f9931a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9932b, r6.f9932b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9931a.hashCode() * 31) + this.f9932b.hashCode();
        }

        public String toString() {
            return "TransportHubEventMapping(storedEventName=" + this.f9931a + ", locationType=" + this.f9932b + ')';
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016J<\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/intelligence/collector/ArriveLeaveHomeCompanyEventCollector$homeCompanyContextEventListener$1", "Lcom/obric/memorydata/awareness/api/EventListener;", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.awareness.api.a {
        b() {
        }

        private static final void a(String r10, String r11) {
            String r7 = a.a(a.f9929a, r10);
            if (r7 != null) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ArriveLeaveHomeCompanyEventCollector", "ignore home company context event without location: " + r11, null, 4, null);
            return;
        L6:
            MemoryDbEngine.INSTANCE.getGlobalDbEngine().getArriveLeaveHomeCompanyEventDao().insert(new o(0, System.currentTimeMillis(), r10, r7, 1, null));
        }

        public static /* synthetic */ void lambda$IBBfoCJglUCziV7v0e58lC6J8IM(String r0, String r1) {
            a(r0, r1);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "feature");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(final String r7, Map<String, ? extends Object> r8) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "eventName");
            final String r9 = (String) ZeusTransformUtils.preCheckCast(a.b().get(r7), String.class, "com.obric.memorydata.plugin");
            if (r9 != null) goto L5;
            return;
        L5:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ArriveLeaveHomeCompanyEventCollector", "home company context event: " + r7 + " -> " + r9, false, 4, null);
            ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$a$b$IBBfoCJglUCziV7v0e58lC6J8IM(r9, r7));
        }

        @Override // com.obric.memorydata.awareness.api.a
        public boolean a() {
            return com.obric.memorydata.awareness.api.a.C0430a.a(this);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
            com.obric.memorydata.awareness.api.a.C0430a.a(this, r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016J<\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/intelligence/collector/ArriveLeaveHomeCompanyEventCollector$transportHubListener$1", "Lcom/obric/memorydata/awareness/api/EventListener;", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.memorydata.awareness.api.a {
        c() {
        }

        private static final void a(C0479a r12, String r13) {
            cl r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getLocationDao().queryLastRecord();
            String r9 = a.a(a.f9929a, r12.b(), r13, r0);
            MemoryDbEngine.INSTANCE.getGlobalDbEngine().getArriveLeaveHomeCompanyEventDao().insert(new o(0, System.currentTimeMillis(), r12.a(), r9, 1, null));
        }

        public static /* synthetic */ void lambda$bhh2SKynQ_n90Y2aNbTuuArczRU(C0479a r0, String r1) {
            a(r0, r1);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "feature");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r9, Map<String, ? extends Object> r10) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "eventName");
            final C0479a r11 = (C0479a) ZeusTransformUtils.preCheckCast(a.c().get(r9), C0479a.class, "com.obric.memorydata.plugin");
            if (r11 != null) goto L5;
            return;
        L5:
            final String r1 = null;
            if (r8 == null) goto L8;
            Object r2 = r8.get("aoi_name");
        L10:
            if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L12;
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
        L13:
            if (r3 != null) goto L21;
            if (r8 == null) goto L16;
            Object r12 = r8.get("station_name");
        L18:
            if (ZeusTransformUtils.instanceOf(r12, String.class) == false) goto L20;
            r3 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin");
            goto L21
        L20:
            r3 = null;
            goto L21
        L16:
            r12 = null;
        L21:
            if (r3 == null) goto L27;
            String r13 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            if (r13 == null) goto L27;
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L27;
            r1 = r13;
        L27:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ArriveLeaveHomeCompanyEventCollector", "transport hub context event: " + r9 + " -> " + r11.a(), false, 4, null);
            ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$a$c$bhh2SKynQ_n90Y2aNbTuuArczRU(r11, r1));
            return;
        L12:
            r3 = null;
            goto L13
        L8:
            r2 = null;
            goto L10
        }

        @Override // com.obric.memorydata.awareness.api.a
        public boolean a() {
            return com.obric.memorydata.awareness.api.a.C0430a.a(this);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
            com.obric.memorydata.awareness.api.a.C0430a.a(this, r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f9929a = new a();
        f9930b = MapsKt.mapOf(new Pair[]{TuplesKt.to(EventNames.ARRIVE_HOME, "at_home"), TuplesKt.to(EventNames.LEAVE_HOME, UserAwareUtil.CHANGE_OUT_HOME), TuplesKt.to(EventNames.ARRIVE_COMPANY, "at_company"), TuplesKt.to(EventNames.LEAVE_COMPANY, UserAwareUtil.CHANGE_OUT_COMPANY)});
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to(EventNames.ENTER_AIRPORT, new C0479a("arrive_airport", "airport")), TuplesKt.to(EventNames.EXIT_AIRPORT, new C0479a("leave_airport", "airport")), TuplesKt.to(EventNames.ENTER_RAILWAY_STATION, new C0479a("arrive_railway_station", "railway_station")), TuplesKt.to(EventNames.EXIT_RAILWAY_STATION, new C0479a("leave_railway_station", "railway_station")), TuplesKt.to(EventNames.ENTER_SUBWAY_STATION, new C0479a("arrive_subway_station", "subway_station")), TuplesKt.to(EventNames.EXIT_SUBWAY_STATION, new C0479a("leave_subway_station", "subway_station"))});
        d = new b();
        e = new c();
    }

    private a() {
    }

    private final Object a(cl r4) {
        if (r4 != null) goto L5;
        Object r3 = JSONObject.NULL;
        Intrinsics.checkNotNullExpressionValue(r3, "NULL");
        return r3;
    L5:
        JSONObject r5 = new JSONObject();
        r5.put("longitude", r4.d());
        r5.put("latitude", r4.e());
        return r5;
    }

    public static final /* synthetic */ String a(a r0, String r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ String a(a r0, String r1, String r2, cl r3) {
        return r0.a(r1, r2, r3);
    }

    private final String a(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, List.class) == false) goto L5;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 != null) goto L9;
        return null;
    L9:
        if (r6.size() == 2) goto L11;
        return null;
    L11:
        Double r0 = b(r6.get(0));
        if (r0 == null) goto L17;
        double r2 = r0.doubleValue();
        Double r4 = b(r6.get(1));
        if (r4 == null) goto L17;
        return '(' + r2 + ", " + r4.doubleValue() + ')';
    L17:
        return null;
    L5:
        r6 = null;
        goto L6
    }

    private final String a(String r11) {
        if (Intrinsics.areEqual(r11, "at_home") == false) goto L9;
        String r1 = a(AwarenessManager.INSTANCE.resolveAtHomeEventLocation());
        if (r1 == null) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ArriveLeaveHomeCompanyEventCollector", "use at_home event location from home fence", false, 4, null);
        return r1;
    L9:
        if (Intrinsics.areEqual(r11, UserAwareUtil.CHANGE_OUT_HOME) == false) goto L15;
        String r3 = d();
        if (r3 == null) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ArriveLeaveHomeCompanyEventCollector", "use out_home event location from last at_home", false, 4, null);
        return r3;
    L15:
        switch(r11.hashCode()) {
            case -2079519631: goto L28;
            case -694531733: goto L24;
            case 54091568: goto L21;
            case 687039628: goto L18;
            default: goto L33;
        };
    L33:
        return null;
    L18:
        if (r11.equals(UserAwareUtil.CHANGE_OUT_COMPANY) == false) goto L35;
    L30:
        String r12 = "location_company_gps";
    L32:
        return a(FeatureManager.INSTANCE.getFeature(r12));
    L35:
        return null;
    L21:
        if (r11.equals(UserAwareUtil.CHANGE_OUT_HOME) == false) goto L36;
    L26:
        r12 = "location_home_gps";
        goto L32
    L36:
        return null;
    L24:
        if (r11.equals("at_home") == true) goto L26;
        return null;
    L28:
        if (r11.equals("at_company") == true) goto L30;
        return null;
    }

    private final String a(String r2, String r3, cl r4) {
        JSONObject r1 = new JSONObject();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r1.put(LocationMonitorConst.LOCATION_NAME, r3);
        r1.put("location_type", r2);
        r1.put("cached_gps", f9929a.a(r4));
        String r5 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        return r5;
    }

    private final Double b(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Number.class) == false) goto L6;
        return Double.valueOf(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).doubleValue());
    L6:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == true) goto L11;
        return null;
    L11:
        return b(r2);
    }

    public static final /* synthetic */ Map b() {
        return f9930b;
    }

    public static final /* synthetic */ Map c() {
        return c;
    }

    private final String d() {
        o r3 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getArriveLeaveHomeCompanyEventDao().queryLastRecordByEventName("at_home");
        if (r3 == null) goto L10;
        String r4 = r3.d();
        if (r4 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L9;
        return null;
    L9:
        return r4;
    L10:
        return null;
    }

    public final void a() {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(f9930b.keySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        AwarenessManager.INSTANCE.registerAwarenessEvent(r0, (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(d, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(c.keySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        AwarenessManager.INSTANCE.registerAwarenessEvent(r1, (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(e, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        goto L8
    }
}
