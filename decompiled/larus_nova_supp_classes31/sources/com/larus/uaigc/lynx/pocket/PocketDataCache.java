package com.larus.uaigc.lynx.pocket;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.g;
import com.larus.platform.service.o;
import com.larus.uaigc.lynx.k;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class PocketDataCache {
    public static final PocketDataCache a = null;
    public static final Lazy b = null;
    public static final ConcurrentHashMap<String, Object> c = null;
    public static final Lazy d = null;

    public PocketDataCache() {
    }

    static {
        a = new PocketDataCache();
        b = LazyKt.lazy(new a());
        c = new ConcurrentHashMap();
        d = LazyKt.lazy(new b());
    }

    public static Map c() {
        ConcurrentHashMap<String, Object> r0 = c;
        if ((!r0.isEmpty()) == false) goto L5;
        return r0;
    L5:
        String r1 = "pocket_page_online_data_".concat(o.a.getDeviceId());
        String r2 = ((Keva) b.getValue()).getString(r1, "");
        FLogger.a.i("SpringMainVenueDataManager", "[getPocketPageCache] key = " + r1 + ", json = " + r2);
        Intrinsics.checkNotNull(r2);
        Object r3 = null;
        Map r4 = null;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L14
        if (r2.length() != 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == true) goto L20;
        r4 = (Map) ((Gson) d.getValue()).fromJson(r2, new c().getType());     // Catch: Throwable -> L14
    L20:
        if (r4 == null) goto L34;
        ConcurrentHashMap<String, Object> r7 = c;
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator r9 = r4.entrySet().iterator();
    L23:
        if (r9.hasNext() == false) goto L32;
        Map.Entry r10 = (Map.Entry) r9.next();
        if (r10.getKey() != null) goto L27;
    L29:
        boolean r11 = false;
    L30:
        if (r11 == false) goto L23;
        r8.put(r10.getKey(), r10.getValue());
        goto L23
    L27:
        if (r10.getValue() == null) goto L29;
        r11 = true;
        goto L30
    L32:
        r7.putAll(r8);
    L34:
        return c;
    L9:
        r6 = false;
    L14:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Object r13 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r13) == true) goto L19;
        r3 = r13;
    L19:
        r4 = (Map) r3;
        goto L20
    }

    public static void e() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new PocketDataCache$preFetchPocketData$1(null), 2, null);
    }

    public static boolean d(Map r3) {
        if (r3 == null) goto L7;
        boolean r2 = true;
        if ((!r3.isEmpty()) != true) goto L7;
    L8:
        if (r2 == false) goto L17;
        Object r4 = r3.get("pocket_page_data");
        Object r1 = null;
        if ((r4 instanceof Map) == false) goto L12;
        Map r5 = (Map) r4;
    L13:
        if (r5 == null) goto L16;
        r1 = r5.get("can_support_be_gala_time_config");
    L16:
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L12:
        r5 = null;
        goto L13
    L17:
        return false;
    L7:
        r2 = false;
        goto L8
    }

    public final Object b(Continuation<? super Map<String, ? extends Object>> r11) {
        if ((r11 instanceof PocketDataCache$getCacheOrFetchPocketData$1) == false) goto L7;
        PocketDataCache$getCacheOrFetchPocketData$1 r0 = (PocketDataCache$getCacheOrFetchPocketData$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Map r4 = (Map) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L37:
        if (((Boolean) r12).booleanValue() == false) goto L55;
        Map r13 = c();
        if (r13 != null) goto L41;
        r13 = MapsKt.emptyMap();
    L41:
        boolean r5 = d(r13);
        FLogger.a.i("SpringMainVenueDataManager", "[getCacheOrFetchSpringPocketData] newCache size = " + r4.size() + ", canUse = " + r5);
        ConcurrentHashMap r6 = new ConcurrentHashMap();
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r14 = r13.entrySet().iterator();
    L43:
        if (r14.hasNext() == false) goto L52;
        Map.Entry r8 = (Map.Entry) r14.next();
        if (r8.getKey() != null) goto L47;
    L49:
        boolean r9 = false;
    L50:
        if (r9 == false) goto L43;
        r7.put(r8.getKey(), r8.getValue());
        goto L43
    L47:
        if (r8.getValue() == null) goto L49;
        r9 = true;
        goto L50
    L52:
        r6.putAll(r7);
        return r6;
    L55:
        return MapsKt.emptyMap();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        Map r15 = c();
        if (r15 != null) goto L17;
        r15 = MapsKt.emptyMap();
    L17:
        boolean r10 = d(r15);
        FLogger.a.i("SpringMainVenueDataManager", "[getCacheOrFetchSpringPocketData] oldCache size = " + r15.size() + ", oldCacheCanUse = " + r10);
        if (r10 == false) goto L32;
        ConcurrentHashMap r16 = new ConcurrentHashMap();
        LinkedHashMap r17 = new LinkedHashMap();
        Iterator r18 = r15.entrySet().iterator();
    L21:
        if (r18.hasNext() == false) goto L30;
        Map.Entry r19 = (Map.Entry) r18.next();
        if (r19.getKey() != null) goto L25;
    L27:
        boolean r20 = false;
    L28:
        if (r20 == false) goto L21;
        r17.put(r19.getKey(), r19.getValue());
        goto L21
    L25:
        if (r19.getValue() == null) goto L27;
        r20 = true;
        goto L28
    L30:
        r16.putAll(r17);
        return r16;
    L32:
        r0.L$0 = r15;
        r0.label = 1;
        Object r21 = f(3, "source_from_fe", r0);
        if (r21 != r2) goto L35;
        return r2;
    L35:
        r4 = r15;
        r12 = r21;
    L7:
        r0 = new PocketDataCache$getCacheOrFetchPocketData$1(this, r11);
        goto L8
    }

    public static Object f(int r3, String r4, Continuation r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PocketDataCache$refreshGetPocketPageDataResponseDataCache$2(r3, r4, null), r5);
    }

    public static final void a(PocketDataCache r8, int r9, long r10, Integer r12, String r13) {
        r8.getClass();
        FLogger.a.i("SpringMainVenueDataManager", "[refreshPocketPageCache] getPocketPageData fail, error msg: " + r13 + ", error code: " + r12);
        g(r9, System.currentTimeMillis() - r10, r12, r13, false);
    }

    public static void g(int r18, long r19, Integer r21, String r22, boolean r23) {
        k.a.getClass();
        long r5 = AppHost.a.getAppClock().currentTimeMillis();
        FLogger.a.i("ServerEnterTimeRecorder", "[getLastEnterMainVenueMillisDiff] currentTimeMillis = " + r5 + ", lastEnterMainVenueMs = " + k.b);
        Long r7 = k.b;
        if (r7 == null) goto L5;
        int r6 = (int) (r5 - r7.longValue());
    L6:
        JSONObject r8 = new JSONObject();
        r8.put("scene", r18);
        r8.put("duration", r19);
        r8.put("success", r23);
        if (r21 == null) goto L10;
        r8.put("error_code", r21.intValue());
    L10:
        if (r22 == null) goto L13;
        r8.put("error_msg", r22);
    L13:
        if (r18 != 1) goto L15;
        r8.put("interval_ms", r6);
    L15:
        g.a.monitorEventForSlardar("pocket_page_data_request", r8, null, null);
        JSONObject r9 = new JSONObject();
        r9.put("scene", r18);     // Catch: Exception -> L25
        r9.put("duration", r19);     // Catch: Exception -> L25
        r9.put("success", r23);     // Catch: Exception -> L25
        if (r21 == null) goto L19;
        r9.put("error_code", r21.intValue());     // Catch: Exception -> L25
    L19:
        if (r22 == null) goto L21;
        r9.put("error_msg", r22);     // Catch: Exception -> L25
    L21:
        int r2 = 1;
        if (r18 != 1) goto L28;
        r9.put("interval_ms", r6);     // Catch: Exception -> L25
    L27:
        r2 = 1;
    L28:
        if (r18 != r2) goto L30;
        k.a.getClass();
        long r0 = AppHost.a.getAppClock().currentTimeMillis();
        FLogger.a.i("ServerEnterTimeRecorder", "[updateLastEnterMainVenueMs] currentTimeMillis = " + r0 + ", lastEnterMainVenueMs = " + k.b);
        k.b = Long.valueOf(r0);
    L30:
        TrackParams r1 = new TrackParams().merge(r9);
        by7.a r3 = new by7.a("pocket_page_data_request");
        r3.a.merge(r1);
        r3.b();
        return;
    L25:
        e = move-exception;
        FLogger.a.e("SpringMainVenueDataManager", "error in SpringMainVenueDataManager [reportPocketPageDataRequest] " + e.getLocalizedMessage());
        goto L27
    L5:
        r6 = -1;
        goto L6
    }
}
