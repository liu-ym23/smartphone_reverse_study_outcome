package com.bytedance.android.annie.service.data;

import android.os.Handler;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.data.subscribe.e;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class DataProviderService {
    public static final ImitateRedisEngine g = null;
    public final String a;
    public final ConcurrentHashMap<String, Disposable> b;
    public JSONArray c;
    public String d;
    public String e;
    public Function1<? super String, Unit> f;

    public static final class ImitateRedisEngine {
        public final ConcurrentHashMap<String, AtomicInteger> a;
        public final AtomicInteger b;
        public final Lazy c;

        public ImitateRedisEngine() {
            this.a = new ConcurrentHashMap();
            this.b = new AtomicInteger();
            this.c = LazyKt.lazy(DataProviderService$ImitateRedisEngine$mainExecutor$2.INSTANCE);
        }
    }

    public static final class a {
        public static Pair b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "keyParam");
            Iterator r0 = ((ConcurrentHashMap) com.bytedance.android.annie.service.data.b.c).entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L12;
            List r1 = StringsKt.split$default(r10, new char[]{((Character) ((Map.Entry) r0.next()).getKey()).charValue()}, false, 2, 2, null);
            if (((ConcurrentHashMap) com.bytedance.android.annie.service.data.b.b).containsKey(ListProtector.get(r1, 0)) == false) goto L4;
            if (r1.size() != 1) goto L11;
            return new Pair(ListProtector.get(r1, 0), "");
        L11:
            return new Pair(ListProtector.get(r1, 0), ListProtector.get(r1, 1));
        L12:
            return null;
        }

        public static JsonObject a(JsonObject r10, JsonObject r11) {
            Iterator r0 = r10.keySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L18;
            String r1 = (String) r0.next();
            JsonArray r12 = r10.get(r1);
            JsonArray r13 = r11.get(r1);
            if ((r12 instanceof JsonObject) == true) goto L8;
            if ((r12 instanceof JsonArray) == true) goto L14;
            r11.add(r1, r12);
            goto L4
        L14:
            if ((r13 instanceof JsonArray) == true) goto L15;
            r11.add(r1, r12);
            goto L4
        L15:
            JsonArray r14 = new JsonArray();
            r14.addAll(r13);
            r14.addAll(r12);
            Unit r15 = Unit.INSTANCE;
            r11.add(r1, r14);
            goto L4
        L8:
            if ((r13 instanceof JsonObject) == true) goto L9;
            r11.add(r1, r12);
            goto L4
        L9:
            ImitateRedisEngine r16 = DataProviderService.g;
            JsonObject r17 = (JsonObject) r13;
            a((JsonObject) r12, r17);
            r11.add(r1, r17);
            goto L4
        L18:
            return r11;
        }
    }

    public final class b extends g<JsonObject, JsonObject> {
        public final /* synthetic */ DataProviderService a;

        public b(DataProviderService r1) {
            this.a = r1;
        }

        public final Object invoke(Object r10, CallContext r11) {
            JsonObject r12 = (JsonObject) r10;
            Intrinsics.checkNotNullParameter(r12, "param");
            Intrinsics.checkNotNullParameter(r11, "context");
            JsonObject r13 = new JsonObject();
            DataProviderService r0 = this.a;
            JsonElement r1 = r12.get("register");
            if (r1 == null) goto L12;
            JsonArray r14 = r1.getAsJsonArray();
            if (r14 == null) goto L12;
            Iterator r15 = r14.iterator();
        L8:
            if (r15.hasNext() == false) goto L12;
            String r16 = ((JsonElement) r15.next()).getAsString();
            if (r16 == null) goto L8;
            JSONArray r17 = new JSONArray();
            r17.put(r16);
            r0.e(r17, r13);
        L12:
            JsonElement r18 = r12.get("unregister");
            if (r18 == null) goto L24;
            JsonArray r19 = r18.getAsJsonArray();
            if (r19 == null) goto L24;
            Iterator r20 = r19.iterator();
        L18:
            if (r20.hasNext() == false) goto L24;
            String r21 = ((JsonElement) r20.next()).getAsString();
            if (r21 == null) goto L18;
            Disposable r22 = r0.b.get(r21);
            if (r22 == null) goto L18;
            r22.dispose();
        L24:
            return r13;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DataProviderService a;
        public final /* synthetic */ String b;
        public final /* synthetic */ e<?> c;
        public final /* synthetic */ Map.Entry<String, List<String>> d;

        /* JADX WARN: Multi-variable type inference failed */
        public c(DataProviderService r1, String r10, e<?> r11, Map.Entry<String, ? extends List<String>> r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        public final void accept(Object r10) {
            JsonElement r11 = (JsonElement) r10;
            DataProviderService r0 = this.a;
            String r1 = this.b;
            String r12 = r0.a;
            ImitateRedisEngine r13 = DataProviderService.g;
            String r14 = r0.d + ':' + r1;
            r13.getClass();
            Intrinsics.checkNotNullParameter(r14, "key");
            r13.a.putIfAbsent(r14, new AtomicInteger());
            AtomicInteger r15 = r13.a.get(r14);
            if (r15 != null) goto L5;
            r15 = new AtomicInteger();
            r13.a.put(r14, r15);
        L5:
            r15.incrementAndGet();
            ((Handler) r13.c.getValue()).postDelayed(new com.bytedance.android.annie.service.data.a(r13, r14), 5000);
            int r16 = r13.b.incrementAndGet();
            if (r16 <= AnnieConfigSettingKeys.LIVE_HYBRID_SEND_SUBSCRIBER_THRESHOLD.a().intValue()) goto L14;
            JSONObject r17 = new JSONObject();
            r17.put(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, r16);
            Iterator<Map.Entry<String, AtomicInteger>> r18 = r13.a.entrySet().iterator();
        L9:
            if (r18.hasNext() == false) goto L13;
            Map.Entry<String, AtomicInteger> r19 = r18.next();
            if (r19.getValue().get() <= 0) goto L9;
            r17.put(r19.getKey(), r19.getValue().get());
            goto L9
        L13:
            ((k9.c) Annie.getService(k9.c.class, r12)).a1(r0.d, r17);
        L14:
            Function1<? super String, Unit> r20 = this.a.f;
            if (r20 == null) goto L53;
            JsonObject r21 = new JsonObject();
            e<?> r22 = this.c;
            Map.Entry<String, List<String>> r23 = this.d;
            String r24 = r22.key();
            if ((r22 instanceof com.bytedance.android.annie.api.data.subscribe.a) == false) goto L19;
            com.bytedance.android.annie.api.data.subscribe.a r25 = (com.bytedance.android.annie.api.data.subscribe.a) r22;
        L21:
            if (r25 != null) goto L23;
        L25:
            boolean r26 = false;
        L26:
            if (r26 == false) goto L29;
        L41:
            r21.add(r24, r11);
            r20.invoke(UtilsKt.h(r21));
            return;
        L29:
            if (r23.getValue().size() != 1) goto L31;
            r11 = r22.a((String) CollectionsKt.single(r23.getValue()));
            goto L41
        L31:
            r11 = new JsonObject();
            Iterator<T> r27 = r23.getValue().iterator();
        L33:
            if (r27.hasNext() == false) goto L40;
            JsonObject r28 = r22.a((String) r27.next());
            if ((r28 instanceof JsonObject) == false) goto L37;
            JsonObject r29 = r28;
        L38:
            if (r29 == null) goto L33;
            ImitateRedisEngine r30 = DataProviderService.g;
            a.a(r29, r11);
            goto L33
        L37:
            r29 = null;
            goto L38
        L40:
            Unit r31 = Unit.INSTANCE;
            goto L41
        L23:
            if (r25.b != true) goto L25;
            r26 = true;
            goto L26
        L19:
            r25 = null;
            goto L21
        }
    }

    public final void a() {
        monitor-enter(this);
        ConcurrentHashMap<String, Disposable> r0 = this.b;     // Catch: Throwable -> L10
        Iterator<T> r1 = r0.values().iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L7;
        ((Disposable) r1.next()).dispose();     // Catch: Throwable -> L10
        goto L5
    L7:
        r0.clear();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    static {
        g = new ImitateRedisEngine();
    }

    public final GsonMap b() {
        JsonObject r0 = new JsonObject();
        Map r1 = d(this.c);
        if (r1 == null) goto L25;
        Iterator r10 = r1.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L25;
        Map.Entry r11 = (Map.Entry) r10.next();
        HybridLogger r12 = HybridLogger.a;
        HybridLogger.m("DataProviderService", "DataProviderService request param, pair:(" + ((String) r11.getKey()) + ',' + r11.getValue() + ')', null, null, 12);
        ConcurrentHashMap r13 = (ConcurrentHashMap) com.bytedance.android.annie.service.data.b.b;
        if (r13.containsKey(r11.getKey()) == false) goto L6;
        Object r14 = r13.get(r11.getKey());
        Intrinsics.checkNotNull(r14);
        com.bytedance.android.annie.api.data.subscribe.g r15 = ((com.bytedance.android.annie.api.data.subscribe.g) r14).c();
        if (((List) r11.getValue()).size() != 1) goto L13;
        JsonElement r16 = r15.e((String) CollectionsKt.single((List) r11.getValue()), this.e);
    L23:
        HybridLogger r17 = HybridLogger.a;
        HybridLogger.m("DataProviderService", "DataProviderService return, key:{" + r15.key() + ", value:" + r16 + '}', null, null, 12);
        r0.add(r15.key(), r16);
        goto L6
    L13:
        JsonElement r18 = new JsonObject();
        Iterator r19 = ((Iterable) r11.getValue()).iterator();
    L15:
        if (r19.hasNext() == false) goto L22;
        JsonObject r20 = r15.a((String) r19.next());
        if ((r20 instanceof JsonObject) == false) goto L19;
        JsonObject r21 = r20;
    L20:
        if (r21 == null) goto L15;
        a.a(r21, r18);
        goto L15
    L19:
        r21 = null;
        goto L20
    L22:
        r16 = r18;
    L25:
        return UtilsKt.i(r0);
    }

    public DataProviderService(String r10) {
        Intrinsics.checkNotNullParameter(r10, "bizKey");
        this.a = r10;
        this.b = new ConcurrentHashMap();
        this.d = "";
        this.e = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Map d(final JSONArray r10) {
        if (r10 == null) goto L33;
        Sequence r11 = SequencesKt.filterNotNull(SequencesKt.map(SequencesKt.filterNotNull(SequencesKt.map(CollectionsKt.asSequence(RangesKt.until(0, r10.length())), new DataProviderService$preDealProps$1$1(r10))), DataProviderService$preDealProps$1$2.INSTANCE));
        Intrinsics.checkNotNullParameter(r11, "<this>");
        if (r11.iterator().hasNext() == false) goto L34;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L21;
        Pair r13 = (Pair) r12.next();
        if (r1.containsKey(r13.getFirst()) == true) goto L12;
        r1.put(r13.getFirst(), CollectionsKt.mutableListOf(new String[]{r13.getSecond()}));
        goto L9
    L12:
        Object r14 = r1.get(r13.getFirst());
        Intrinsics.checkNotNull(r14);
        Iterator r15 = ((List) r14).iterator();
    L14:
        if (r15.hasNext() == false) goto L18;
        if (StringsKt.startsWith$default((String) r15.next(), (String) r13.getSecond(), false, 2, null) == false) goto L14;
        r15.remove();
        goto L14
    L18:
        Object r16 = r1.get(r13.getFirst());
        Intrinsics.checkNotNull(r16);
        ((List) r16).add(r13.getSecond());
        goto L9
    L21:
        return r1;
    L34:
        return null;
    L33:
        return null;
    }

    public final void e(JSONArray r10, JsonObject r11) {
        Map r12 = d(r10);
        if (r12 == null) goto L29;
        Iterator r13 = r12.entrySet().iterator();
    L6:
        if (r13.hasNext() == false) goto L45;
        Map.Entry r0 = (Map.Entry) r13.next();
        String r1 = (String) r0.getKey();
        com.bytedance.android.annie.api.data.subscribe.g r14 = (com.bytedance.android.annie.api.data.subscribe.g) ((ConcurrentHashMap) com.bytedance.android.annie.service.data.b.b).get(r1);
        if (r14 == null) goto L6;
        if (r11 == null) goto L12;
        r11.addProperty(r14.key(), 1);
    L12:
        if ((r14 instanceof e) == false) goto L14;
        e r15 = (e) r14;
    L15:
        if (r15 == null) goto L6;
        Iterator r16 = ((Iterable) r0.getValue()).iterator();
    L18:
        if (r16.hasNext() == false) goto L6;
        Pair<String, Observable<JsonElement>> r17 = r15.b((String) r16.next());
        if (this.b.containsKey(r17.getFirst()) == true) goto L18;
        Observable r18 = (Observable) r17.getSecond();
        if (r18 == null) goto L18;
        Disposable r19 = r18.subscribe(new c(this, r1, r15, r0));
        if (r19 == null) goto L18;
        String r20 = (String) r17.getFirst();
        Disposable r21 = this.b.get(r20);
        if (r21 == null) goto L28;
        r21.dispose();
    L28:
        this.b.put(r20, r19);
        goto L18
    L14:
        r15 = null;
        goto L15
    L45:
        return;
    }

    public final void c(String r10, JSONArray r11, JSBridgeManager r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r13, "stateSubscriber");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(UriProtector.parse(r10).getPath());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = "unknown path";
    L10:
        Intrinsics.checkNotNull(r1);
        this.d = (String) r1;
        this.e = r10;
        this.c = r11;
        this.f = r13;
        HybridLogger r14 = HybridLogger.a;
        HybridLogger.m("DataProviderService", "DataProviderService observeWith, url:" + this.d + ", initialProps:" + r11, null, null, 12);
        a();
        e(r11, null);
        if (r12 == null) goto L16;
        r12.registerMethod("__updateStateObserve", new b(this));
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
