package com.bytedance.android.live.browser.jsbridge.state;

import android.os.Handler;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.browser.w;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdk.config.t00;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class StateObserver implements i.d {
    public static final a h = null;

    @Inject
    public StateObservingService a;

    @Inject
    public w b;
    public final ConcurrentHashMap<String, Disposable> c;
    public JSONArray d;
    public String e;
    public Function1<? super String, Unit> f;
    public final boolean g;

    public static final class Companion {
        public static Pair c(String r11) {
            Intrinsics.checkNotNullParameter(r11, "keyParam");
            i.g.C0113i r0 = i.g.C0113i.b;
            String r4 = ":";
            if (StringsKt.startsWith$default(r11, "setting", false, 2, null) == false) goto L5;
        L8:
            List r2 = StringsKt.split$default(r11, new String[]{r4}, false, 0, 6, null);
            if (r2.size() != 1) goto L12;
            return TuplesKt.to(r11, CollectionsKt.emptyList());
        L12:
            return new Pair(ListProtector.get(r2, 0), r2.subList(1, r2.size()));
        L5:
            if (StringsKt.contains$default(r11, ":", false, 2, null) == true) goto L8;
            r4 = ".";
            goto L8
        }

        public static JsonObject a(final StateObservingService r8, final JSONArray r9) {
            Intrinsics.checkNotNullParameter(r8, "stateObservingService");
            Intrinsics.checkNotNullParameter(r9, "jsonArray");
            JsonObject r0 = new JsonObject();
            Sequence r11 = SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(RangesKt.until(0, r9.length())), new StateObserver$Companion$getValuesFromStates$$inlined$also$lambda$1(r9, r8)), StateObserver$Companion$getValuesFromStates$1$2.INSTANCE);
            LinkedHashMap r1 = new LinkedHashMap();
            Iterator r12 = r11.iterator();
        L4:
            if (r12.hasNext() == false) goto L9;
            String r2 = (String) r12.next();
            a r3 = StateObserver.h;
            String r4 = (String) c(r2).getFirst();
            Object r5 = r1.get(r4);
            if (r5 != null) goto L8;
            r5 = new ArrayList();
            r1.put(r4, r5);
        L8:
            ((List) r5).add(r2);
            goto L4
        L9:
            Iterator r13 = r1.entrySet().iterator();
        L11:
            if (r13.hasNext() == false) goto L34;
            Map.Entry r6 = (Map.Entry) r13.next();
            String r7 = (String) r6.getKey();
            List r14 = (List) r6.getValue();
            Object r15 = ((ConcurrentHashMap) r8.a).get(r7);
            if ((r15 instanceof com.bytedance.android.live.browser.jsbridge.state.a) == true) goto L15;
            r15 = null;
        L15:
            com.bytedance.android.live.browser.jsbridge.state.a r16 = (com.bytedance.android.live.browser.jsbridge.state.a) r15;
            if (r16 == null) goto L11;
            com.bytedance.android.live.browser.jsbridge.state.a r17 = r16.g();
            if (r17 == null) goto L11;
            String r18 = r17.getKey();
            if (r14.size() != 1) goto L23;
            JsonElement r19 = r17.e((String) CollectionsKt.single(r14));
        L33:
            r0.add(r18, r19);
            goto L11
        L23:
            JsonElement r21 = new JsonObject();
            Iterator r22 = r14.iterator();
        L25:
            if (r22.hasNext() == false) goto L32;
            JsonElement r23 = r17.e((String) r22.next());
            if ((r23 instanceof JsonObject) == true) goto L29;
            r23 = null;
        L29:
            JsonObject r24 = (JsonObject) r23;
            if (r24 == null) goto L25;
            a r25 = StateObserver.h;
            b(r24, r21);
            goto L25
        L32:
            Unit r26 = Unit.INSTANCE;
            r19 = r21;
            goto L33
        L34:
            return r0;
        }

        public static JsonObject b(JsonObject r5, JsonObject r6) {
            Iterator r0 = r5.keySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L18;
            String r1 = (String) r0.next();
            JsonArray r2 = r5.get(r1);
            JsonArray r3 = r6.get(r1);
            if ((r2 instanceof JsonObject) == true) goto L8;
            if ((r2 instanceof JsonArray) == true) goto L14;
            r6.add(r1, r2);
            goto L4
        L14:
            if ((r3 instanceof JsonArray) == true) goto L15;
            r6.add(r1, r2);
            goto L4
        L15:
            JsonArray r4 = new JsonArray();
            r4.addAll(r3);
            r4.addAll(r2);
            Unit r7 = Unit.INSTANCE;
            r6.add(r1, r4);
            goto L4
        L8:
            if ((r3 instanceof JsonObject) == true) goto L9;
            r6.add(r1, r2);
            goto L4
        L9:
            a r8 = StateObserver.h;
            JsonObject r9 = (JsonObject) r3;
            b((JsonObject) r2, r9);
            r6.add(r1, r9);
            goto L4
        L18:
            return r6;
        }
    }

    public static final class a {
        public final ConcurrentHashMap<String, AtomicInteger> a;
        public final AtomicInteger b;
        public final Handler c;

        public a() {
            this.a = new ConcurrentHashMap();
            this.b = new AtomicInteger();
            this.c = new Handler();
        }
    }

    public final class b extends g<JsonObject, JsonObject> {
        public final /* synthetic */ StateObserver a;

        public b(StateObserver r1) {
            this.a = r1;
        }

        public final Object invoke(Object r4, CallContext r5) {
            JsonObject r6 = (JsonObject) r4;
            Intrinsics.checkNotNullParameter(r6, "param");
            Intrinsics.checkNotNullParameter(r5, "context");
            JsonObject r7 = new JsonObject();
            JsonElement r0 = r6.get("register");
            if (r0 == null) goto L12;
            JsonArray r1 = r0.getAsJsonArray();
            if (r1 == null) goto L12;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L12;
            String r3 = ((JsonElement) r2.next()).getAsString();
            if (r3 == null) goto L8;
            this.a.d(r3, r7);
        L12:
            JsonElement r8 = r6.get("unregister");
            if (r8 == null) goto L22;
            JsonArray r9 = r8.getAsJsonArray();
            if (r9 == null) goto L22;
            Iterator r11 = r9.iterator();
        L18:
            if (r11.hasNext() == false) goto L22;
            String r12 = ((JsonElement) r11.next()).getAsString();
            if (r12 == null) goto L18;
            this.a.e(r12);
        L22:
            return r7;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ i.b a;
        public final /* synthetic */ StateObserver b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public c(i.b r1, StateObserver r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r14) {
            JsonElement r15 = (JsonElement) r14;
            StateObserver r0 = this.b;
            String r1 = this.d;
            r0.getClass();
            a r2 = StateObserver.h;
            String r3 = r0.e + ':' + r1;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "key");
            r2.a.putIfAbsent(r3, new AtomicInteger());
            AtomicInteger r4 = r2.a.get(r3);
            if (r4 != null) goto L5;
            r4 = new AtomicInteger();
            r2.a.put(r3, r4);
        L5:
            r4.incrementAndGet();
            r2.c.postDelayed(new f(r2, r3), n5.DEFAULT_SHOW_DURATION);
            int r5 = r2.b.incrementAndGet();
            if (r5 <= ((Integer) t00.a.getValue()).intValue()) goto L23;
            JSONObject r11 = new JSONObject();
            r11.put("total_count", r5);
            Iterator<Map.Entry<String, AtomicInteger>> r6 = r2.a.entrySet().iterator();
        L9:
            if (r6.hasNext() == false) goto L14;
            Map.Entry<String, AtomicInteger> r7 = r6.next();
            if (r7.getValue().get() <= 0) goto L9;
            r11.put(r7.getKey(), r7.getValue().get());
            goto L9
        L14:
            if (r0.g == false) goto L19;
            w r8 = r0.b;
            if (r8 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("lynxService");
        L18:
            r8.getHybridMonitor().reportCustomV2(null, "hybrid_state_observe_monitor", r0.e, null, null, r11, null, 0);
            goto L23
        L19:
            w r9 = r0.b;
            if (r9 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("lynxService");
        L22:
            r9.getHybridMonitor().a(null, "hybrid_state_observe_monitor", r0.e, null, null, r11, false);
        L23:
            Function1<? super String, Unit> r12 = this.b.f;
            if (r12 == null) goto L48;
            JsonObject r13 = new JsonObject();
            String r16 = this.a.getKey();
            i.c r17 = this.a;
            if ((r17 instanceof BaseObservableState) == true) goto L28;
            i.c r18 = null;
        L29:
            BaseObservableState r19 = (BaseObservableState) r18;
            if (r19 == null) goto L35;
            if (r19.d != true) goto L35;
        L41:
            r13.add(r16, r15);
            Unit r110 = Unit.INSTANCE;
            Unit r111 = (Unit) r12.invoke(UtilsKt.h(r13));
            return;
        L35:
            if ((r17 instanceof com.bytedance.android.live.browser.jsbridge.state.a) == true) goto L37;
            r17 = null;
        L37:
            com.bytedance.android.live.browser.jsbridge.state.a r21 = (com.bytedance.android.live.browser.jsbridge.state.a) r17;
            if (r21 == null) goto L40;
            r15 = r21.f(this.c, r15);
            goto L41
        L40:
            r15 = null;
            goto L41
        L28:
            r18 = r17;
            goto L29
        }
    }

    public final void c() {
        monitor-enter(this);
        ConcurrentHashMap<String, Disposable> r0 = this.c;     // Catch: Throwable -> L10
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
        h = new a();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i.d
    public final JsonObject a() {
        JSONArray r0 = this.d;
        if (r0 == null) goto L9;
        StateObservingService r1 = this.a;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("stateObservingService");
    L10:
        return Companion.a(r1, r0);
    L9:
        return new JsonObject();
    }

    public StateObserver() {
        this.c = new ConcurrentHashMap();
        this.e = "";
        this.g = ((Boolean) AnnieConfigSettingKeys.LIVE_HYBRID_USE_MONITOR_SAMPLE_RATE.a()).booleanValue();
        BrowserServiceImpl.Companion.getClass();
        s20.a r0 = ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).a();
        this.a = (StateObservingService) r0.a.j.get();
        this.b = (w) r0.a.h.get();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i.d
    public final void release() {
        c();
    }

    public final void e(String r3) {
        String r0 = (String) Companion.c(r3).getFirst();
        i.e.f r1 = i.e.f.b;
        if (Intrinsics.areEqual(r0, "room_message") == true) goto L6;
        r3 = r0;
    L6:
        Disposable r4 = this.c.get(r3);
        if (r4 == null) goto L10;
        r4.dispose();
        return;
    }

    public final void d(String r5, JsonObject r6) {
        String r0 = (String) Companion.c(r5).getFirst();
        StateObservingService r1 = this.a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stateObservingService");
    L5:
        i.c r2 = (i.c) ((ConcurrentHashMap) r1.a).get(r0);
        if (r2 == null) goto L22;
        if (r6 == null) goto L10;
        r6.addProperty(r2.getKey(), 1);
    L10:
        if ((r2 instanceof i.b) == true) goto L12;
        r2 = null;
    L12:
        i.b r3 = (i.b) r2;
        if (r3 == null) goto L23;
        Disposable r7 = r3.a(r5).subscribe(new c(r3, this, r5, r0));
        if (r7 == null) goto L24;
        String r4 = (String) Companion.c(r5).getFirst();
        i.e.f r8 = i.e.f.b;
        if (Intrinsics.areEqual(r4, "room_message") == true) goto L20;
        r5 = r4;
    L20:
        e(r5);
        this.c.put(r5, r7);
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i.d
    public final void b(String r4, JSONArray r5, Function2<? super String, ? super g<JsonObject, JsonObject>, Unit> r6, Function1<? super String, Unit> r7) {
        Intrinsics.checkNotNullParameter(r4, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r6, "jsBridgeRegister");
        Intrinsics.checkNotNullParameter(r7, "stateSubscriber");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl(UriProtector.parse(r4).getPath());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r8) == false) goto L10;
        r8 = "unknown path";
    L10:
        String r9 = (String) r8;
        if (r9 != null) goto L13;
        r9 = "";
    L13:
        this.e = r9;
        this.d = r5;
        c();
        this.f = r7;
        if (r5 == null) goto L28;
        int r11 = r5.length();
        int r12 = 0;
    L16:
        if (r12 >= r11) goto L28;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
        Object r2 = Result.constructor-impl(JSONArrayProtectorUtils.getString(r5, r12));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r2) == false) goto L24;
        r2 = null;
    L24:
        String r3 = (String) r2;
        if (r3 == null) goto L27;
        d(r3, null);
    L27:
        r12 = r12 + 1;
    L19:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
    L28:
        r6.invoke("__updateStateObserve", new b(this));
        return;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
