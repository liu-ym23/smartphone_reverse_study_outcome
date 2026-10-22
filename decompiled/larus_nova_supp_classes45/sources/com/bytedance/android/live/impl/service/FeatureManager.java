package com.bytedance.android.live.impl.service;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.k0;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.config.LiveAudioTagConfig;
import com.bytedance.android.live.feature.config.LiveFeatureConfig;
import com.bytedance.android.live.impl.utils.KevaHelper;
import com.bytedance.android.live.impl.utils.SharedPrefHelper;
import com.bytedance.android.live.impl.utils.json.JsonHelper;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.RoomFeatureValue;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import j40.c0;
import j40.j;
import j40.m2;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class FeatureManager implements z90.a {
    public static final ConcurrentHashMap<String, Object> a = null;
    public static final ConcurrentHashMap<String, Object> b = null;
    public static final LiveFeatureConfig c = null;
    public static final LiveAudioTagConfig d = null;
    public static final ConcurrentHashMap<String, Map<String, RoomFeatureValue>> e = null;
    public static final ReentrantLock f = null;
    public static final int g = 0;
    public static final float h = 0.0f;
    public static final float i = 0.0f;
    public static final int j = 0;
    public static final ConcurrentHashMap<z90.a.b, List<String>> k = null;
    public static final Map<String, z90.a.b> l = null;
    public static final CopyOnWriteArrayList<z90.d> m = null;
    public static volatile ScheduledExecutorService n;
    public static z90.a.c o;
    public static CdnTrackerInfo p;
    public static final k0 q = null;
    public static final Calendar r = null;
    public static final a s = null;
    public static final b t = null;
    public static final FeatureManager u = null;

    public static final class a implements Runnable {
        public a() {
        }

        public final void a() {
            Map<String, Object> r0 = c0.a.getValue().getFeatureTestMap();
            if (r0 != null) goto L5;
            return;
        L5:
            Iterator<Map.Entry<String, Object>> r1 = r0.entrySet().iterator();
        L7:
            if (r1.hasNext() == false) goto L9;
            Map.Entry<String, Object> r2 = r1.next();
            FeatureManager.u.getFeature(r2.getKey(), r2.getValue());
            goto L7
        L9:
            i0.c().postDelayed(this, c0.a.getValue().getFeatureTestFrequency());
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        public final void a() {
            Map<String, Object> r0 = c0.a.getValue().getTimerUpdateFeatureMap();
            if (r0 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
            return;
        L11:
            Iterator<Map.Entry<String, Object>> r1 = r0.entrySet().iterator();
        L13:
            if (r1.hasNext() == false) goto L17;
            Map.Entry<String, Object> r3 = r1.next();
            FeatureManager r4 = FeatureManager.u;
            Object r5 = r4.getFeature(r3.getKey(), r3.getValue());
            if ((!Intrinsics.areEqual(r5, r3.getValue())) == false) goto L13;
            r4.c(r3.getKey(), r5);
            goto L13
        L17:
            FeatureManager.u.getClass();
            if (FeatureManager.n != null) goto L20;
            FeatureManager.n = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("eatureManager"));
        L20:
            ScheduledExecutorService r6 = FeatureManager.n;
            if (r6 == null) goto L29;
            r6.schedule(this, c0.a.getValue().getTimerUpdateFrequency(), TimeUnit.MILLISECONDS);
            return;
        L29:
            return;
        L5:
            if (r0.isEmpty() == true) goto L8;
            r2 = false;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public FeatureManager() {
    }

    static {
        u = new FeatureManager();
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        LiveFeatureConfig r0 = c0.a.getValue();
        c = r0;
        d = j.a.getValue();
        e = new ConcurrentHashMap();
        f = new ReentrantLock();
        g = r0.getRecentFrequencyValue();
        h = r0.getRecentSessionValue();
        i = r0.getWatchSessionThreshold();
        j = r0.getDeadlineValue();
        k = new ConcurrentHashMap();
        l = new LinkedHashMap();
        m = new CopyOnWriteArrayList();
        if (r0.getKevaOptEnable() == false) goto L5;
        k0 r1 = KevaHelper.b;
    L6:
        q = r1;
        r = Calendar.getInstance();
        s = new a();
        t = new b();
        return;
    L5:
        r1 = SharedPrefHelper.c;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class k() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.huawei.system.BuildEx");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.huawei.system.BuildEx");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.huawei.system.BuildEx");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.huawei.system.BuildEx");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.huawei.system.BuildEx");
    }

    public static JSONObject o(String r4) {
        Intrinsics.checkNotNullParameter(r4, "anchorId");
        JSONObject r1 = null;
        if (StringsKt.isBlank(r4) == false) goto L5;
        return null;
    L5:
        Map<String, RoomFeatureValue> r5 = e.get(r4);
        if (r5 == null) goto L18;
        r1 = new JSONObject();
        Iterator<Map.Entry<String, RoomFeatureValue>> r6 = r5.entrySet().iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        Map.Entry<String, RoomFeatureValue> r0 = r6.next();
        String r2 = r0.getKey();
        RoomFeatureValue r3 = r0.getValue();
        if (r3 == null) goto L9;
        String r7 = r3.getValue();
        if (r7 == null) goto L9;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L16
        Result.constructor-impl(r1.putOpt(r2, r7));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        return r1;
    }

    @Override // z90.a
    public final void f(z90.a.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        o = r2;
    }

    @Override // z90.a
    public final void g(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        boolean r0 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.a("LFM-FeatureManager", new FeatureManager$removeFeature$1(r3));
        ConcurrentHashMap<String, Object> r1 = a;
        if (r1.containsKey(r3) == false) goto L6;
        r1.remove(r3);
        return;
    }

    @Override // z90.a
    public final void h(z90.a.b r2) {
        if (r2 == null) goto L5;
        List<String> r3 = k.remove(r2);
        return;
    }

    @Override // z90.a
    public final void j(z90.a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((LinkedHashMap) l).values().remove(r2);
    }

    public static void m(String r7, Function2 r8) {
        Intrinsics.checkNotNullParameter(r7, "anchorId");
        JSONObject r1 = o(r7);     // Catch: Exception -> L14
        if (r1 != null) goto L6;
        return;
    L6:
        Iterator<String> r2 = r1.keys();     // Catch: Exception -> L14
    L7:
        if (r2.hasNext() == false) goto L24;
        String r3 = r2.next();     // Catch: Exception -> L14
        Object r4 = r1.opt(r3);     // Catch: Exception -> L12
        FeatureManager r5 = u;     // Catch: Exception -> L12
        String r6 = r3.toString();     // Catch: Exception -> L12
        r5.getClass();     // Catch: Exception -> L12
        q(r6, r4);     // Catch: Exception -> L12
        Unit r9 = (Unit) r8.invoke(r3, r4);     // Catch: Exception -> L12
    L12:
        ALogger.e("strategy_tag", "autoUpdateRealTimeFeatures, roomFeatures key error, anchorId is: " + r7);     // Catch: Exception -> L14
        goto L7
    L24:
        return;
    L14:
        ALogger.e("strategy_tag", "autoUpdateRealTimeFeatures, func error, anchorId is: ".concat(r7));
    }

    public static boolean n(final String r5, final Object r6) {
        if (r6 == null) goto L29;
        boolean r1 = r6 instanceof Float;
        if (r1 == false) goto L7;
    L10:
        if (r1 == false) goto L19;
        float r2 = ((Number) r6).floatValue();
        if (Float.isInfinite(r2) == false) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == false) goto L19;
    L27:
        return true;
    L14:
        if (Float.isNaN(r2) == true) goto L16;
        r3 = true;
    L19:
        if ((r6 instanceof Double) == false) goto L28;
        double r4 = ((Number) r6).doubleValue();
        if (Double.isInfinite(r4) == false) goto L23;
    L25:
        boolean r7 = false;
    L26:
        if (r7 == false) goto L28;
    L23:
        if (Double.isNaN(r4) == true) goto L25;
        r7 = true;
    L28:
        boolean r8 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", new FeatureManager$checkValueValid$$inlined$let$lambda$1(r6, r5), null);
        goto L29
    L7:
        if ((r6 instanceof Double) == true) goto L10;
        return true;
    L29:
        return false;
    }

    public static Object p(Object r2, Object r3) {
        if (r3 != null) goto L4;
        return r2;
    L4:
        if (r2 != null) goto L6;
    L67:
        if ((r3 instanceof Object) == true) goto L72;
        return null;
    L72:
        return r3;
    L57:
        th = move-exception;
        boolean r0 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", FeatureManager$getSpecifiedType$1.INSTANCE, th);
        return r2;
    L6:
        if ((r3 instanceof Number) == false) goto L9;
        r3 = p(r2, r3.toString());
        goto L67
    L9:
        if ((r3 instanceof Boolean) == false) goto L12;
        r3 = p(r2, r3.toString());
        goto L67
    L12:
        if ((r3 instanceof String) == false) goto L42;
        if (((CharSequence) r3).length() != 0) goto L16;
        boolean r1 = true;
    L17:
        if (r1 == true) goto L67;
        if ((r2 instanceof Integer) == false) goto L25;
        String r4 = (String) r3;
        int r5 = ((Number) r2).intValue();
        r5 = CastIntegerProtector.parseInt(r4);     // Catch: Throwable -> L60
    L23:
        r3 = Integer.valueOf(r5);
        goto L67
    L25:
        if ((r2 instanceof Boolean) == false) goto L28;
        r3 = d5.a((String) r3, ((Boolean) r2).booleanValue());
        goto L67
    L28:
        if ((r2 instanceof Long) == false) goto L33;
        String r6 = (String) r3;
        long r7 = ((Number) r2).longValue();
        r7 = CastLongProtector.parseLong(r6);     // Catch: Throwable -> L61
    L31:
        r3 = Long.valueOf(r7);
        goto L67
    L33:
        if ((r2 instanceof Float) == false) goto L38;
        String r8 = (String) r3;
        float r9 = ((Number) r2).floatValue();
        r9 = CastFloatProtector.parseFloat(r8);     // Catch: Throwable -> L62
    L36:
        r3 = Float.valueOf(r9);
        goto L67
    L38:
        if ((r2 instanceof Double) == false) goto L40;
        r3 = StringsKt.toDoubleOrNull((String) r3);
        goto L67
    L40:
        boolean r11 = r2 instanceof String;
        goto L67
    L16:
        r1 = false;
        goto L17
    L42:
        if ((r3 instanceof JSONObject) == false) goto L48;
        if ((r2 instanceof Map) == false) goto L46;
        int r12 = JsonHelper.a;
        r3 = JsonHelper.b((JSONObject) r3);
        goto L67
    L46:
        boolean r13 = r2 instanceof JSONObject;
        goto L67
    L48:
        if ((r3 instanceof JSONArray) == false) goto L67;
        if ((r2 instanceof List) == false) goto L52;
        int r14 = JsonHelper.a;
        r3 = JsonHelper.a((JSONArray) r3);
        goto L67
    L52:
        boolean r15 = r2 instanceof JSONArray;
        goto L67
    }

    public static void q(final String r6, final Object r7) {
        if (n(r6, r7) == true) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, Object> r0 = a;
        if (r7 != null) goto L28;
    L26:
        boolean r1 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.a("LFM-FeatureManager", new FeatureManager$putFeature$1(r6, r7));
        return;
    L28:
    L24:
        e = move-exception;
        boolean r2 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", FeatureManager$safePut$3.INSTANCE, e);
        goto L26
    L9:
        if ((r7 instanceof Collection) == false) goto L16;
        JSONArray r3 = new JSONArray();     // Catch: JSONException -> L24
        Iterator r4 = ((Iterable) r7).iterator();     // Catch: JSONException -> L24
    L12:
        if (r4.hasNext() == false) goto L14;
        r3.put(r4.next());     // Catch: JSONException -> L24
        goto L12
    L14:
        Unit r5 = Unit.INSTANCE;     // Catch: JSONException -> L24
        r0.put(r6, r3);     // Catch: JSONException -> L24
        goto L26
    L16:
        if ((r7 instanceof Map) == false) goto L22;
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L24
        Iterator r9 = ((Map) r7).entrySet().iterator();     // Catch: JSONException -> L24
    L19:
        if (r9.hasNext() == false) goto L21;
        Map.Entry r11 = (Map.Entry) r9.next();     // Catch: JSONException -> L24
        Object r12 = r11.getKey();     // Catch: JSONException -> L24
        Object r13 = r11.getValue();     // Catch: JSONException -> L24
        d60.b.a(r8, String.valueOf(r12), r13);     // Catch: JSONException -> L24
        goto L19
    L21:
        Unit r14 = Unit.INSTANCE;     // Catch: JSONException -> L24
        r0.put(r6, r8);     // Catch: JSONException -> L24
        goto L26
    L22:
        r0.put(r6, r7);     // Catch: JSONException -> L24
        goto L26
    }

    public static void r(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "params");
        if ((r4 instanceof Object) == true) goto L5;
        JSONObject r0 = null;
    L6:
        q(r3, r0);
        if (StringsKt.isBlank(r3) == false) goto L9;
        String r5 = "";
    L10:
        Iterator<String> r1 = r4.keys();
    L12:
        if (r1.hasNext() == false) goto L14;
        String r2 = r1.next();
        q(r5 + r2, r4.get(r2));
        goto L12
    L14:
        return;
    L9:
        r5 = r3.concat(Item.MIX_ID_SEPERATOR);
        goto L10
    L5:
        r0 = r4;
        goto L6
    }

    @Override // z90.a
    public final void a(String r2, z90.a.b r3) {
        Intrinsics.checkNotNullParameter(r2, "names");
        Intrinsics.checkNotNullParameter(r3, "listener");
        l.put(r2, r3);
    }

    @Override // z90.a
    public final boolean c(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return i(r2, r3, FeatureType.DYNAMIC_MONITOR);
    }

    @Override // z90.a
    public final void d(String r26, Map<String, RoomFeatureValue> r27) {
        String r1 = r26;
        Intrinsics.checkNotNullParameter(r1, "anchorId");
        String r3 = "LFM-FeatureManager";
        if (m2.a.getValue().booleanValue() == false) goto L26;
        Set r4 = SetsKt.setOf(new String[]{"live_tone_2nd", "live_cae_2nd", "live_cae_offline_2nd"});
        Map<String, RoomFeatureValue> r5 = new LinkedHashMap();
        Iterator r6 = ((LinkedHashMap) r27).entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L27;
        Map.Entry r0 = (Map.Entry) r6.next();
        final String r7 = (String) r0.getKey();
        RoomFeatureValue r8 = (RoomFeatureValue) r0.getValue();
        if (r4.contains(r7) == false) goto L25;
        if (r8 == null) goto L11;
        String r2 = r8.getType();
    L13:
        if (Intrinsics.areEqual(r2, "string") == false) goto L25;
        if (r8.getValue() == null) goto L25;
        JSONObject r9 = new JSONObject(r8.getValue());     // Catch: JSONException -> L23
        Iterator<String> r11 = r9.keys();     // Catch: JSONException -> L23
    L18:
        if (r11.hasNext() == false) goto L6;
        String r12 = r11.next();     // Catch: JSONException -> L23
        Object r13 = r9.opt(r12);     // Catch: JSONException -> L23
        if (r13 == null) goto L18;
        String r14 = String.valueOf(r12);     // Catch: JSONException -> L23
        RoomFeatureValue r15 = new RoomFeatureValue();     // Catch: JSONException -> L23
        r15.setType("float");     // Catch: JSONException -> L23
        r15.setValue(r13.toString());     // Catch: JSONException -> L23
        r15.setGenTimeMs(r8.getGenTimeMs());     // Catch: JSONException -> L23
        r15.setExpTimeMs(r8.getExpTimeMs());     // Catch: JSONException -> L23
        r5.put(r14, r15);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        boolean r16 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", new FeatureManager$processSpecialRoomFeatures$1(r7), e);
        r5.put(r7, r8);
        goto L6
    L11:
        r2 = null;
    L25:
        r5.put(r7, r8);
    L27:
        String r17 = "null";
        if (d.getParseAudioTagEnable() == false) goto L135;
        r5 = MapsKt.toMutableMap(r5);
        String r18 = "live_stream_audio_tag";
        RoomFeatureValue r19 = r5.get("live_stream_audio_tag");
        if (r19 == null) goto L135;
        String r110 = r19.getValue();
        if (r110 == null) goto L135;
        JSONArray r111 = new JSONArray(r110);     // Catch: Exception -> L132
        ArrayList r112 = new ArrayList();     // Catch: Exception -> L132
        ArrayList r113 = new ArrayList();     // Catch: Exception -> L132
        ArrayList r114 = new ArrayList();     // Catch: Exception -> L132
        ArrayList r115 = new ArrayList();     // Catch: Exception -> L132
        ArrayList r116 = new ArrayList();     // Catch: Exception -> L132
        int r21 = r111.length();     // Catch: Exception -> L132
        int r22 = 0;
    L37:
        boolean r117 = true;
        if (r22 >= r21) goto L100;
        int r118 = r21;
        JSONObject r23 = r111.optJSONObject(r22);     // Catch: Exception -> L98
        if (r23 != null) goto L43;
        String r24 = r18;
        String r25 = r3;
        String r119 = r17;
        JSONArray r28 = r111;
    L193:
        r22 = r22 + 1;     // Catch: Exception -> L130
        r21 = r118;
        r17 = r119;
        r111 = r28;
        r18 = r24;
        r3 = r25;
    L130:
        e = e;
    L131:
        r1 = r26;
    L134:
        boolean r29 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b(r25, FeatureManager$processAudioTag$12.INSTANCE, e);
    L137:
        if (c.getRoomFeatureOptMerge() == true) goto L148;
        e.put(r1, r5);
        StringBuilder r31 = new StringBuilder("[putRoomFeatures] anchor_id is: ");
        r31.append(r1);
        r31.append(", keys: ");
        r31.append(r5.keySet());
        r31.append(" values: ");
        Collection<RoomFeatureValue> r32 = r5.values();
        ArrayList r33 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r32, 10));
        Iterator<T> r34 = r32.iterator();
    L140:
        if (r34.hasNext() == false) goto L147;
        RoomFeatureValue r35 = (RoomFeatureValue) r34.next();
        if (r35 == null) goto L145;
        String r36 = r35.getValue();
        if (r36 == null) goto L145;
    L146:
        r33.add(r36);
    L145:
        r36 = r119;
        goto L146
    L147:
        r31.append(r33);
        ALogger.i("LFM-strategy_tag", r31.toString());
    L163:
        int r37 = c.getLimitRoomFeaturesSize();
        ConcurrentHashMap<String, Map<String, RoomFeatureValue>> r38 = e;
        if (r38.size() <= r37) goto L222;
        ReentrantLock r39 = f;
        r39.lock();
        int r41 = r38.size();     // Catch: Throwable -> L177
        if (r41 <= r37) goto L174;
        List r42 = CollectionsKt.take(r38.entrySet(), Math.max(0, r41 - r37));     // Catch: Throwable -> L177
        ArrayList r43 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r42, 10));     // Catch: Throwable -> L177
        Iterator r44 = r42.iterator();     // Catch: Throwable -> L177
    L171:
        if (r44.hasNext() == false) goto L173;
        r43.add((String) ((Map.Entry) r44.next()).getKey());     // Catch: Throwable -> L177
        goto L171
    L173:
        e.keySet().removeAll(r43);     // Catch: Throwable -> L177
    L174:
        Unit r45 = Unit.INSTANCE;     // Catch: Throwable -> L177
        r39.unlock();
        return;
    L177:
        th = move-exception;
        r39.unlock();
        throw th;
    L222:
        return;
    L148:
        ReentrantLock r46 = f;
        r46.lock();
        ConcurrentHashMap<String, Map<String, RoomFeatureValue>> r47 = e;     // Catch: Throwable -> L180
        Map<String, RoomFeatureValue> r48 = r47.get(r1);     // Catch: Throwable -> L180
        if (r48 != null) goto L152;
        r48 = MapsKt.emptyMap();     // Catch: Throwable -> L180
    L152:
        Map<String, RoomFeatureValue> r49 = MapsKt.plus(r48, r5);     // Catch: Throwable -> L180
        r47.put(r1, r49);     // Catch: Throwable -> L180
        StringBuilder r51 = new StringBuilder();     // Catch: Throwable -> L180
        r51.append("[putRoomFeatures222] anchor_id is: ");     // Catch: Throwable -> L180
        r51.append(r1);     // Catch: Throwable -> L180
        r51.append(", features: ");     // Catch: Throwable -> L180
        ArrayList r52 = new ArrayList(r49.size());     // Catch: Throwable -> L180
        Iterator<Map.Entry<String, RoomFeatureValue>> r53 = r49.entrySet().iterator();     // Catch: Throwable -> L180
    L154:
        if (r53.hasNext() == false) goto L161;
        Map.Entry<String, RoomFeatureValue> r54 = r53.next();     // Catch: Throwable -> L180
        StringBuilder r55 = new StringBuilder();     // Catch: Throwable -> L180
        r55.append(r54.getKey());     // Catch: Throwable -> L180
        r55.append(": ");     // Catch: Throwable -> L180
        RoomFeatureValue r56 = r54.getValue();     // Catch: Throwable -> L180
        if (r56 == null) goto L159;
        String r57 = r56.getValue();     // Catch: Throwable -> L180
        if (r57 == null) goto L159;
    L160:
        r55.append(r57);     // Catch: Throwable -> L180
        r52.add(r55.toString());     // Catch: Throwable -> L180
    L159:
        r57 = r119;
        goto L160
    L161:
        r51.append(CollectionsKt.joinToString$default(r52, null, null, null, 0, null, null, 63, null));     // Catch: Throwable -> L180
        ALogger.i("LFM-strategy_tag", r51.toString());     // Catch: Throwable -> L180
        Unit r58 = Unit.INSTANCE;     // Catch: Throwable -> L180
        r46.unlock();
    L180:
        th = move-exception;
        r46.unlock();
        throw th;
    L43:
        r119 = r17;
        r28 = r111;
        int r59 = r23.optInt("slice_cnt", 0);     // Catch: Exception -> L96
        r24 = r18;
        double r61 = r23.optDouble("ratio_avg", 0.0d);     // Catch: Exception -> L96
        LiveAudioTagConfig r120 = d;     // Catch: Exception -> L96
        r25 = r3;
        if (r59 < r120.getAudioTagSliceCnt()) goto L193;
        if (r61 < r120.getAudioTagRatioThreshold()) goto L193;
        String r62 = r23.optString("t0");     // Catch: Exception -> L130
        if (r62.length() <= 0) goto L53;
        boolean r121 = true;
    L54:
        if (r121 == true) goto L57;
        r62 = null;
    L57:
        if (r62 == null) goto L59;
        r112.add(r62);     // Catch: Exception -> L130
    L59:
        String r63 = r23.optString("t1");     // Catch: Exception -> L130
        if (r63.length() <= 0) goto L62;
        boolean r122 = true;
    L63:
        if (r122 == true) goto L66;
        r63 = null;
    L66:
        if (r63 == null) goto L68;
        r113.add(r63);     // Catch: Exception -> L130
    L68:
        String r64 = r23.optString("t2");     // Catch: Exception -> L130
        if (r64.length() <= 0) goto L71;
        boolean r123 = true;
    L72:
        if (r123 == true) goto L75;
        r64 = null;
    L75:
        if (r64 == null) goto L77;
        r114.add(r64);     // Catch: Exception -> L130
    L77:
        String r65 = r23.optString("t3");     // Catch: Exception -> L130
        if (r65.length() <= 0) goto L80;
        boolean r124 = true;
    L81:
        if (r124 == true) goto L84;
        r65 = null;
    L84:
        if (r65 == null) goto L86;
        r115.add(r65);     // Catch: Exception -> L130
    L86:
        String r66 = r23.optString("tag_id");     // Catch: Exception -> L130
        if (r66.length() > 0) goto L90;
        r117 = false;
    L90:
        if (r117 == true) goto L93;
        r66 = null;
    L93:
        if (r66 == null) goto L193;
        r116.add(r66);     // Catch: Exception -> L130
        goto L193
    L80:
        r124 = false;
        goto L81
    L71:
        r123 = false;
        goto L72
    L62:
        r122 = false;
        goto L63
    L53:
        r121 = false;
    L96:
        e = e;
        r25 = r3;
    L98:
        e = e;
        r25 = r3;
        r119 = r17;
        goto L131
    L100:
        String r210 = r18;
        r25 = r3;
        r119 = r17;
        if ((!r112.isEmpty()) == false) goto L104;
        l(r5, "audiotag0_mix", r112, r19);     // Catch: Exception -> L130
    L104:
        if ((!r113.isEmpty()) == false) goto L107;
        l(r5, "audiotag1_mix", r113, r19);     // Catch: Exception -> L130
    L107:
        if ((!r114.isEmpty()) == false) goto L110;
        l(r5, "audiotag2_mix", r114, r19);     // Catch: Exception -> L130
    L110:
        if ((!r115.isEmpty()) == false) goto L113;
        l(r5, "audiotag3_mix", r115, r19);     // Catch: Exception -> L130
    L113:
        if ((!r116.isEmpty()) == false) goto L115;
        l(r5, "audiotagid_mix", r116, r19);     // Catch: Exception -> L130
    L115:
        r5.remove(r210);     // Catch: Exception -> L130
        StringBuilder r67 = new StringBuilder();     // Catch: Exception -> L130
        r67.append("[processAudioTag], anchorId=");     // Catch: Exception -> L130
        r1 = r26;
        r67.append(r1);     // Catch: Exception -> L128
        r67.append(",features: ");     // Catch: Exception -> L128
        ArrayList r68 = new ArrayList(r5.size());     // Catch: Exception -> L128
        Iterator<Map.Entry<String, RoomFeatureValue>> r69 = r5.entrySet().iterator();     // Catch: Exception -> L128
    L119:
        if (r69.hasNext() == false) goto L126;
        Map.Entry<String, RoomFeatureValue> r71 = r69.next();     // Catch: Exception -> L128
        StringBuilder r72 = new StringBuilder();     // Catch: Exception -> L128
        r72.append(r71.getKey());     // Catch: Exception -> L128
        r72.append(": ");     // Catch: Exception -> L128
        RoomFeatureValue r73 = r71.getValue();     // Catch: Exception -> L128
        if (r73 == null) goto L124;
        String r74 = r73.getValue();     // Catch: Exception -> L128
        if (r74 == null) goto L124;
    L125:
        r72.append(r74);     // Catch: Exception -> L128
        r68.add(r72.toString());     // Catch: Exception -> L128
    L124:
        r74 = r119;
        goto L125
    L126:
        r67.append(CollectionsKt.joinToString$default(r68, null, null, null, 0, null, null, 63, null));     // Catch: Exception -> L128
        ALogger.i("LFM-strategy_tag", r67.toString());     // Catch: Exception -> L128
    L128:
        e = e;
    L132:
        e = e;
        r25 = "LFM-FeatureManager";
        r119 = "null";
    L135:
        r119 = "null";
        goto L137
    L26:
        r5 = r27;
        goto L27
    }

    @Override // z90.a
    public final boolean e(z90.a.b r5, List<String> r6) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        if (r6 == null) goto L11;
        ConcurrentHashMap<z90.a.b, List<String>> r1 = k;
        List<String> r2 = r1.get(r5);
        if (r2 != null) goto L7;
        r2 = CollectionsKt.emptyList();
    L7:
        List<String> r7 = r6;
        if (r2.containsAll(r7) == true) goto L11;
        r1.put(r5, CollectionsKt.distinct(CollectionsKt.plus(r7, r2)));
        return true;
    L11:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v64, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v65, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v66, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v67 */
    /* JADX WARN: Type inference failed for: r1v68 */
    /* JADX WARN: Type inference failed for: r1v86 */
    /* JADX WARN: Type inference failed for: r1v87 */
    /* JADX WARN: Type inference failed for: r1v88 */
    /* JADX WARN: Type inference failed for: r1v89 */
    /* JADX WARN: Type inference failed for: r1v90 */
    /* JADX WARN: Type inference failed for: r1v91 */
    /* JADX WARN: Type inference failed for: r1v92 */
    /* JADX WARN: Type inference failed for: r1v93 */
    /* JADX WARN: Type inference failed for: r1v94 */
    /* JADX WARN: Type inference failed for: r1v95 */
    /* JADX WARN: Type inference failed for: r1v96 */
    /* JADX WARN: Type inference failed for: r1v97 */
    /* JADX WARN: Type inference failed for: r1v98 */
    /* JADX WARN: Type inference failed for: r1v99 */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.bytedance.android.live.impl.service.FeatureManager] */
    /* JADX WARN: Type inference failed for: r4v22, types: [com.bytedance.android.live.impl.service.FeatureManager] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // z90.a
    public final <T> T getFeature(String r24, T r25) {
        final String r6 = r24;
        Intrinsics.checkNotNullParameter(r6, "name");
        LiveFeatureConfig r0 = c;
        if (r0.getMockFeatureEnable() == false) goto L10;
        Map<String, Object> r1 = r0.getMockFeatureMap();
        if (r1 == null) goto L7;
        T r2 = (T) r1.get(r6);
    L9:
        if ((r2 instanceof Object) == false) goto L10;
    L12:
        if (r2 == null) goto L16;
        boolean r3 = com.bytedance.android.live.impl.utils.a.a;
        final T r4 = r2;
        com.bytedance.android.live.impl.utils.a.c("LFM-FeatureManager", new FeatureManager$getFeature$$inlined$let$lambda$1(r4, r6));
        return r2;
    L16:
        if (StringsKt.contains$default(r6, '#', false, 2, null) == false) goto L27;
        List r5 = StringsKt.split$default(r24, new char[]{'#'}, false, 0, 6, null);
        if ((!r5.isEmpty()) == false) goto L25;
        Iterator<z90.d> r7 = m.iterator();
    L21:
        if (r7.hasNext() == false) goto L25;
        z90.d r8 = r7.next();
        if ((r8 instanceof com.bytedance.android.live.impl.logfilter.d) == false) goto L21;
        ((com.bytedance.android.live.impl.logfilter.d) r8).b((String) ListProtector.get(r5, 0), (String) ListProtector.get(r5, 1));
    L25:
        final String r9 = r6;
    L201:
        ?? r11 = 2;
        if (StringsKt.startsWith$default(r9, "aweme_", false, 2, null) == false) goto L294;
        List<String> r12 = FeedFeatureManager.a;
        Object r13 = FeedFeatureManager.a(r24, r25);
        ?? r14 = r25;
    L204:
        ?? r15 = r14;
    L274:
        if (r13 == null) goto L276;
    L278:
        final boolean r16 = false;
    L279:
        if (r13 != null) goto L281;
        r13 = p((Object) r15, a.get(r9));
    L281:
        if (r13 == null) goto L284;
        r15 = (T) r13;
    L284:
        boolean r17 = com.bytedance.android.live.impl.utils.a.a;
        final Object r18 = (Object) r15;
        com.bytedance.android.live.impl.utils.a.c("LFM-FeatureManager", new AnonymousClass13(r9, r18, r16));
        return (T) r15;
    L276:
        if (a.containsKey(r9) == true) goto L278;
        r16 = true;
        goto L279
    L294:
        if (StringsKt.startsWith$default(r9, "pitaya_features_", false, 2, null) == true) goto L291;
        r11 = r25;
        if (StringsKt.startsWith$default(r9, "solaria_features_", false, 2, null) == false) goto L237;
        LivePortraitCenterService r19 = LivePortraitCenterService.b;     // Catch: Exception -> L286
        String r21 = r19.getPortrait(StringsKt.removePrefix(r9, "solaria_features_"));     // Catch: Exception -> L286
        if (r21 == null) goto L226;
        u.getClass();     // Catch: Exception -> L286
        Object r22 = p(r11, r21);     // Catch: Exception -> L286
        r11 = r11;
    L293:
    L260:
        r13 = r22;
        r14 = r11;
        goto L204
    L226:
        r19.a();     // Catch: Exception -> L286
        Object r23 = a.get("solaria_features");     // Catch: Exception -> L286
        if ((r23 instanceof JSONObject) == true) goto L229;
        r23 = null;
    L229:
        JSONObject r26 = (JSONObject) r23;     // Catch: Exception -> L286
        if (r26 == null) goto L235;
        Object r27 = r26.opt(StringsKt.removePrefix(r9, "solaria_features_"));     // Catch: Exception -> L286
        if (r27 == null) goto L235;
        r22 = p(r11, r27);     // Catch: Exception -> L286
        r11 = r11;
    L235:
        r13 = null;
        r14 = r11;
        goto L204
    L237:
        if (StringsKt.startsWith$default(r9, "player_monitor_features_", false, 2, null) == false) goto L248;
        Object r28 = a.get("player_monitor_features");
        if ((r28 instanceof JSONObject) == true) goto L241;
        r28 = null;
    L241:
        JSONObject r29 = (JSONObject) r28;
        r11 = r11;
        if (r29 == null) goto L246;
        Object r31 = r29.opt(StringsKt.removePrefix(r9, "player_monitor_features_"));
        r11 = r11;
        if (r31 == null) goto L246;
        u.getClass();
        Object r32 = p(r11, r31);
        b.put(r9, r31);
        r13 = r32;
        r14 = r11;
    L246:
        Object r33 = null;
    L273:
        r13 = r33;
        r15 = r11;
        goto L274
    L248:
        if (StringsKt.startsWith$default(r9, "linkage_room_features_", false, 2, null) == false) goto L251;
        String r34 = StringsKt.removePrefix(r9, "linkage_room_features_");
        r13 = u.b(StringsKt.substringAfter(r34, '$', ""), StringsKt.substringBefore$default(r34, '$', null, 2, null), r11);
        r14 = r11;
        goto L204
    L251:
        if (StringsKt.startsWith$default(r9, "preview_wormhole_pre_aweme_features_", false, 2, null) == false) goto L261;
        String r35 = StringsKt.removePrefix(r9, "preview_wormhole_pre_aweme_features_");
        Object r36 = a.get("preview_wormhole_pre_aweme_features");
        if ((r36 instanceof JSONObject) == true) goto L255;
        r36 = null;
    L255:
        JSONObject r37 = (JSONObject) r36;
        FeatureManager r38 = u;
        if (r37 == null) goto L258;
        Object r39 = r37.opt(r35);
    L259:
        r38.getClass();
        r22 = p(r11, r39);
        goto L260
    L258:
        r39 = null;
        goto L259
    L261:
        r33 = null;
        if (StringsKt.startsWith$default(r9, "video_features_", false, 2, null) == false) goto L273;
        LivePortraitCenterService r41 = LivePortraitCenterService.b;     // Catch: Exception -> L272
        String r42 = StringsKt.removePrefix(r9, "video_features_");     // Catch: Exception -> L272
        Intrinsics.checkNotNullParameter(r42, "name");     // Catch: Exception -> L272
        IMiddleHostService r43 = TTMiddlewareLiveSDK.hostMiddlewareService();     // Catch: Exception -> L272
        if (r43 == null) goto L268;
        IMiddlewareHostAction r44 = r43.action();     // Catch: Exception -> L272
        if (r44 == null) goto L268;
        Object r45 = r44.getVideoFeature(r42);     // Catch: Exception -> L272
    L269:
        if (r45 == null) goto L273;
        u.getClass();     // Catch: Exception -> L272
        r13 = p(r11, r45);     // Catch: Exception -> L272
        r15 = r11;
    L268:
        r45 = null;
        goto L269
    L291:
        Object r46 = a.get("pitaya_features");     // Catch: Exception -> L219
        if ((r46 instanceof JSONObject) == true) goto L210;
        r46 = null;
    L210:
        JSONObject r47 = (JSONObject) r46;     // Catch: Exception -> L219
        if (r47 == null) goto L220;
        Object r48 = r47.opt(StringsKt.removePrefix(r9, "pitaya_features_"));     // Catch: Exception -> L219
        if (r48 == null) goto L220;
        u.getClass();     // Catch: Exception -> L219
        T r49 = r25;
        r22 = p(r49, r48);     // Catch: Exception -> L286
        r11 = r49;
    L220:
        r11 = r25;
    L219:
        r11 = r25;
    L218:
        r11 = r11;
        goto L246
    L27:
        switch(r24.hashCode()) {
            case -1542114302: goto L147;
            case -742483987: goto L144;
            case -742482220: goto L141;
            case -742479337: goto L138;
            case -547415821: goto L94;
            case -108322226: goto L91;
            case 149071930: goto L88;
            case 317334266: goto L85;
            case 557945987: goto L82;
            case 930975679: goto L33;
            case 1138410282: goto L30;
            default: goto L342;
        };
    L342:
        r9 = r6;
    L188:
        Object r51 = (T) null;
    L189:
        if (r51 == null) goto L191;
        u.getClass();
        q(r9, r51);
    L191:
        if (r51 == null) goto L194;
        boolean r52 = com.bytedance.android.live.impl.utils.a.a;
        final Object r53 = r51;
        com.bytedance.android.live.impl.utils.a.a("LFM-FeatureManager", new FeatureManager$getFeature$$inlined$let$lambda$2(r53, r9));
        return (T) r51;
    L194:
        Iterator<z90.d> r54 = m.iterator();
    L196:
        if (r54.hasNext() == false) goto L201;
        final T r55 = (T) r54.next().getFeature(r9);
        if (r55 == null) goto L196;
        boolean r56 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.c("LFM-FeatureManager", new FeatureManager$getFeature$$inlined$forEach$lambda$1(r55, r55, r9));
        return r55;
    L30:
        if (r6.equals("cur_hour_in_cdn_peak_60") == true) goto L287;
        r9 = r6;
    L287:
        String r57 = (String) u.getFeature("solaria_features_live_cdn_tracker_info", "");     // Catch: Exception -> L43
        if (p != null) goto L44;
        if (r57.length() <= 0) goto L39;
        boolean r58 = true;
    L40:
        if (r58 == false) goto L44;
        p = (CdnTrackerInfo) GsonHelper.get().fromJson("{\"conditions\":" + r57 + '}', CdnTrackerInfo.class);     // Catch: Exception -> L43
        goto L44
    L39:
        r58 = false;
    L44:
        int r59 = r24.hashCode();
        if (r59 == 930975679) goto L66;
        if (r59 == 1138410282) goto L50;
        r9 = r6;
        goto L188
    L50:
        if (r6.equals("cur_hour_in_cdn_peak_60") == false) goto L322;
        CdnTrackerInfo r61 = p;
        if (r61 == null) goto L323;
        Condition r62 = r61.getConditionByKey("live_cdn_night_degradation_abtest_60mins");
        if (r62 == null) goto L324;
        FeatureManager r63 = u;
        long r64 = r62.getFilterStartTime();
        long r65 = r62.getFilterEndTime();
        r63.getClass();
        long r66 = System.currentTimeMillis() / ((long) 1000);
        if (r64 <= r66) goto L59;
    L61:
        int r67 = 0;
    L62:
        r51 = (T) Integer.valueOf(r67);
        if ((r51 instanceof Object) == false) goto L344;
    L136:
        r9 = r6;
        goto L189
    L344:
        r9 = r6;
        goto L188
    L59:
        if (r65 < r66) goto L61;
        r67 = 1;
        goto L62
    L324:
        r9 = r6;
        goto L188
    L323:
        r9 = r6;
        goto L188
    L322:
        r9 = r6;
        goto L188
    L66:
        if (r6.equals("cur_hour_in_cdn_peak_120") == false) goto L325;
        CdnTrackerInfo r68 = p;
        if (r68 == null) goto L326;
        Condition r69 = r68.getConditionByKey("live_cdn_night_degradation_abtest_120mins");
        if (r69 == null) goto L327;
        FeatureManager r71 = u;
        long r72 = r69.getFilterStartTime();
        long r73 = r69.getFilterEndTime();
        r71.getClass();
        long r74 = System.currentTimeMillis() / ((long) 1000);
        if (r72 <= r74) goto L75;
    L77:
        int r75 = 0;
    L78:
        r51 = (T) Integer.valueOf(r75);
        if ((r51 instanceof Object) == true) goto L136;
        r9 = r6;
        goto L188
    L75:
        if (r73 < r74) goto L77;
        r75 = 1;
        goto L78
    L327:
        r9 = r6;
        goto L188
    L326:
        r9 = r6;
        goto L188
    L325:
        r9 = r6;
        goto L188
    L33:
        if (r6.equals("cur_hour_in_cdn_peak_120") == true) goto L287;
        r9 = r6;
        goto L188
    L82:
        if (r6.equals("cur_hour") == true) goto L96;
        r9 = r6;
    L96:
        if (c0.a.getValue().getTimeOptEnable() == false) goto L99;
        r.setTimeInMillis(com.bytedance.android.livesdk.utils.ntp.a.a + System.currentTimeMillis());
    L99:
        switch(r24.hashCode()) {
            case -547415821: goto L132;
            case -108322226: goto L127;
            case 149071930: goto L112;
            case 317334266: goto L107;
            case 557945987: goto L102;
            default: goto L346;
        };
    L346:
        r9 = r6;
        goto L188
    L102:
        if (r6.equals("cur_hour") == false) goto L333;
        r51 = Integer.valueOf(r.get(11));
        if ((r51 instanceof Object) == true) goto L136;
        r9 = r6;
        goto L188
    L333:
        r9 = r6;
        goto L188
    L107:
        if (r6.equals("cur_day_of_month") == false) goto L334;
        r51 = Integer.valueOf(r.get(5));
        if ((r51 instanceof Object) == true) goto L136;
        r9 = r6;
        goto L188
    L334:
        r9 = r6;
        goto L188
    L112:
        if (r6.equals("cur_day_of_week") == false) goto L335;
        Calendar r76 = r;
        if (r76.getFirstDayOfWeek() != 1) goto L116;
        boolean r77 = true;
    L117:
        int r78 = 7;
        int r79 = r76.get(7);
        if (r77 == false) goto L122;
        r79 = r79 - 1;
        if (r79 != 0) goto L122;
    L123:
        r51 = Integer.valueOf(r78);
        if ((r51 instanceof Object) == true) goto L136;
        r9 = r6;
    L122:
        r78 = r79;
        goto L123
    L116:
        r77 = false;
        goto L117
    L335:
        r9 = r6;
        goto L188
    L127:
        if (r6.equals("cur_minute_in_day") == false) goto L336;
        Calendar r81 = r;
        r51 = Integer.valueOf((r81.get(11) * 60) + r81.get(12));
        if ((r51 instanceof Object) == true) goto L136;
        r9 = r6;
        goto L188
    L336:
        r9 = r6;
        goto L188
    L132:
        if (r6.equals("cur_minute") == false) goto L337;
        r51 = Integer.valueOf(r.get(12));
        if ((r51 instanceof Object) == true) goto L136;
        r9 = r6;
        goto L188
    L337:
        r9 = r6;
        goto L188
    L85:
        if (r6.equals("cur_day_of_month") == true) goto L96;
        r9 = r6;
        goto L188
    L88:
        if (r6.equals("cur_day_of_week") == true) goto L96;
        r9 = r6;
        goto L188
    L91:
        if (r6.equals("cur_minute_in_day") == true) goto L96;
        r9 = r6;
        goto L188
    L94:
        if (r6.equals("cur_minute") == true) goto L96;
        r9 = r6;
        goto L188
    L138:
        if (r6.equals("stall_counter_60s") == false) goto L338;
    L148:
        List r82 = (List) getFeature("stall_counter", new ArrayList());
        long r83 = System.currentTimeMillis();
        int r84 = r82.size();
        if (r84 < 1) goto L183;
        Iterator<T> r85 = r82.iterator();
    L152:
        if (r85.hasNext() == false) goto L183;
        long r110 = ((Number) r85.next()).longValue();
        long r111 = r83 - r110;
        if (r111 < 0) goto L152;
        switch(r24.hashCode()) {
            case -1542114302: goto L176;
            case -742483987: goto L171;
            case -742482220: goto L165;
            case -742479337: goto L159;
            default: goto L152;
        };
    L165:
        r9 = r6;
        if (r9.equals("stall_counter_30s") == false) goto L170;
        long r210 = r83;
        if (r111 < 30000) goto L169;
    L181:
        r6 = r9;
        r83 = r210;
        goto L152
    L169:
        r51 = (T) Integer.valueOf(r84 - r82.indexOf(Long.valueOf(r110)));
    L185:
        if ((r51 instanceof Object) == true) goto L189;
    L170:
        r210 = r83;
        goto L181
    L171:
        r210 = r83;
        r9 = r6;
        if (r9.equals("stall_counter_15s") == false) goto L181;
        if (r111 >= 15000) goto L181;
        r51 = (T) Integer.valueOf(r84 - r82.indexOf(Long.valueOf(r110)));
        goto L185
    L176:
        r210 = r83;
        r9 = r6;
        if (r9.equals("stall_counter_300s") == false) goto L181;
        if (r111 >= 300000) goto L181;
        r51 = (T) Integer.valueOf(r84 - r82.indexOf(Long.valueOf(r110)));
        goto L185
    L159:
        if (r6.equals("stall_counter_60s") == true) goto L161;
        r6 = r24;
        goto L152
    L161:
        if (r111 < 60000) goto L162;
        r9 = r24;
        goto L170
    L162:
        r51 = (T) Integer.valueOf(r84 - r82.indexOf(Long.valueOf(r110)));
        r9 = r24;
    L183:
        r9 = r6;
        r51 = 0;
        goto L185
    L338:
        r9 = r6;
        goto L188
    L141:
        if (r6.equals("stall_counter_30s") == true) goto L148;
        r9 = r6;
        goto L188
    L144:
        if (r6.equals("stall_counter_15s") == true) goto L148;
        r9 = r6;
        goto L188
    L147:
        if (r6.equals("stall_counter_300s") == true) goto L148;
        r9 = r6;
        goto L188
    L7:
        r2 = null;
    L10:
        r2 = (T) null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r7v0, types: [T] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    @Override // z90.a
    public final <T> T b(String r5, String r6, T r7) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r6, "anchorId");
        Map<String, RoomFeatureValue> r8 = e.get(r6);
        if (r8 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return r7;
    L11:
        RoomFeatureValue r9 = r8.get(r5);
        if (r9 != null) goto L14;
    L91:
        return r7;
    L14:
        if (r9.getValue() == null) goto L91;
        Long r11 = r9.getExpTimeMs();
        if (r11 == null) goto L19;
        long r1 = r11.longValue();
    L21:
        if (r1 > 0) goto L23;
    L25:
        if (r7 != 0) goto L27;
        String r12 = r9.getType();     // Catch: Exception -> L95
        if (r12 != null) goto L61;
    L87:
        Object r13 = r9.getValue();     // Catch: Exception -> L95
    L88:
        r7 = (T) r13;
        goto L90
    L61:
        switch(r12.hashCode()) {
            case -1325958191: goto L82;
            case -891985903: goto L79;
            case 104431: goto L74;
            case 3029738: goto L69;
            case 97526364: goto L64;
            default: goto L87;
        };     // Catch: Exception -> L95
    L64:
        if (r12.equals("float") == false) goto L87;
        String r14 = r9.getValue();     // Catch: Exception -> L95
        if (r14 == null) goto L86;
        r13 = Float.valueOf(CastFloatProtector.parseFloat(r14));     // Catch: Exception -> L95
    L86:
        r7 = (T) null;
        goto L90
    L69:
        if (r12.equals("bool") == false) goto L87;
        String r15 = r9.getValue();     // Catch: Exception -> L95
        if (r15 == null) goto L86;
        r13 = Boolean.valueOf(Boolean.parseBoolean(r15));     // Catch: Exception -> L95
        goto L88
    L74:
        if (r12.equals("int") == false) goto L87;
        String r16 = r9.getValue();     // Catch: Exception -> L95
        if (r16 == null) goto L86;
        r13 = Integer.valueOf(CastIntegerProtector.parseInt(r16));     // Catch: Exception -> L95
        goto L88
    L79:
        if (r12.equals("string") == false) goto L87;
        r13 = r9.getValue();     // Catch: Exception -> L95
        goto L88
    L82:
        if (r12.equals("double") == false) goto L87;
        String r17 = r9.getValue();     // Catch: Exception -> L95
        if (r17 == null) goto L86;
        r13 = Double.valueOf(CastDoubleProtector.parseDouble(r17));     // Catch: Exception -> L95
    L90:
        return (T) r7;
    L27:
        if ((r7 instanceof Long) == false) goto L32;
        String r18 = r9.getValue();
        long r19 = ((Number) r7).longValue();
        r19 = CastLongProtector.parseLong(r18);     // Catch: Throwable -> L92
    L105:
        return (T) Long.valueOf(r19);
    L32:
        if ((r7 instanceof Integer) == false) goto L39;
        String r21 = r9.getValue();
        int r22 = ((Number) r7).intValue();
        if (r21 == null) goto L106;
        r22 = CastIntegerProtector.parseInt(r21);     // Catch: Throwable -> L93
    L106:
        return (T) Integer.valueOf(r22);
    L39:
        if ((r7 instanceof Float) == false) goto L44;
        String r23 = r9.getValue();
        float r24 = ((Number) r7).floatValue();
        r24 = CastFloatProtector.parseFloat(r23);     // Catch: Throwable -> L94
    L107:
        return (T) Float.valueOf(r24);
    L44:
        if ((r7 instanceof Double) == false) goto L51;
        double r25 = CastDoubleProtector.parseDouble(r9.getValue());     // Catch: Throwable -> L48
    L108:
        return (T) Double.valueOf(r25);
    L48:
        r25 = 0.0d;
        goto L108
    L51:
        if ((r7 instanceof Boolean) == false) goto L54;
        return (T) d5.a(r9.getValue(), ((Boolean) r7).booleanValue());
    L54:
        if ((r7 instanceof String) == false) goto L111;
        return (T) r9.getValue();
    L111:
        return (T) r9.getValue();
    L23:
        if (r1 >= System.currentTimeMillis()) goto L25;
        return r7;
    L19:
        r1 = -1;
        goto L21
    L5:
        if (r8.isEmpty() == true) goto L8;
        r0 = false;
        goto L9
    }

    @Override // z90.a
    public final boolean i(final String r5, final Object r6, final FeatureType r7) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r7, "type");
        if (r6 != null) goto L6;
        return false;
    L6:
        if (n(r5, r6) == false) goto L71;
        ConcurrentHashMap<String, Object> r0 = a;
        if (r7 != FeatureType.DYNAMIC_MONITOR) goto L11;
    L14:
        Object r1 = r0.get(r5);
    L16:
        if (Intrinsics.areEqual(r5, "player_monitor_features") == true) goto L18;
    L20:
        q(r5, r6);
        int r2 = com.bytedance.android.live.impl.service.b.a[r7.ordinal()];
        if (r2 == 1) goto L38;
        if (r2 == 2) goto L53;
    L51:
        return true;
    L53:
        boolean r3 = com.bytedance.android.live.impl.utils.a.a;     // Catch: Exception -> L27
        com.bytedance.android.live.impl.utils.a.d("LFM-FeatureManager", new FeatureManager$realPutFeature$4(r5, r6, r7));     // Catch: Exception -> L27
    L29:
        Iterator<Map.Entry<z90.a.b, List<String>>> r8 = k.entrySet().iterator();
    L31:
        if (r8.hasNext() == false) goto L51;
        Map.Entry<z90.a.b, List<String>> r4 = r8.next();
        if (r4.getValue().contains(r5) == false) goto L31;
        z90.a.b r9 = r4.getKey();
        if (r9 == null) goto L31;
        r9.a(r5, r6);
    L27:
        e = move-exception;
        boolean r11 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", new FeatureManager$realPutFeature$5(r5, r7), e);
        goto L29
    L38:
        if ((!Intrinsics.areEqual(r1, r6)) == false) goto L51;
        boolean r12 = com.bytedance.android.live.impl.utils.a.a;     // Catch: Exception -> L41
        com.bytedance.android.live.impl.utils.a.d("LFM-FeatureManager", new FeatureManager$realPutFeature$1(r5, r6, r7));     // Catch: Exception -> L41
    L43:
        Iterator<Map.Entry<z90.a.b, List<String>>> r13 = k.entrySet().iterator();
    L45:
        if (r13.hasNext() == false) goto L51;
        Map.Entry<z90.a.b, List<String>> r14 = r13.next();
        if (r14.getValue().contains(r5) == false) goto L45;
        z90.a.b r15 = r14.getKey();
        if (r15 == null) goto L45;
        r15.a(r5, r6);
    L41:
        e = move-exception;
        boolean r16 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", new FeatureManager$realPutFeature$2(r5, r7), e);
        goto L43
    L18:
        if ((r6 instanceof JSONObject) == false) goto L20;
        b.forEach(new c(r6));
        goto L20
    L11:
        if (r7 == FeatureType.MONITOR) goto L14;
        r1 = null;
        goto L16
    L71:
        return false;
    }

    public static void l(Map r9, String r11, List r12, RoomFeatureValue r13) {
        String r14 = CollectionsKt.joinToString$default(CollectionsKt.distinct(r12), " & ", null, null, 0, null, null, 62, null);
        RoomFeatureValue r0 = new RoomFeatureValue();
        r0.setValue(r14);
        r0.setType("string");
        r0.setGenTimeMs(r13.getGenTimeMs());
        r0.setExpTimeMs(r13.getExpTimeMs());
        ALogger.i("LFM-strategy_tag", "[addAudioMixFeature] key=" + r11 + ",value=" + r0.getValue() + ",type=" + r0.getType());
        r9.put(r11, r0);
    }
}
