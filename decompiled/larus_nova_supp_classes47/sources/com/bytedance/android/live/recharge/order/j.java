package com.bytedance.android.live.recharge.order;

import com.bytedance.android.live.revenue.common.MapPropertyDelegateKt;
import com.bytedance.android.live.revenue.common.w;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements Map<String, String>, KMutableMap {
    public static final /* synthetic */ KProperty[] i = null;
    public final w a;
    public final w b;
    public final w c;
    public final w d;
    public final w e;
    public final w f;
    public final w g;
    public final /* synthetic */ Map<String, String> h;

    static {
        i = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "requestPage", "getRequestPage()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "chargeScene", "getChargeScene()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "chargeReason", "getChargeReason()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "eventModule", "getEventModule()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "promotionSource", "getPromotionSource()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "diamondExchangeOptimize", "getDiamondExchangeOptimize()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "guideSource", "getGuideSource()Ljava/lang/String;", 0))};
    }

    public final String a() {
        return (String) this.c.a(this, i[2]);
    }

    public final String b() {
        return (String) this.a.a(this, i[0]);
    }

    public final void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.c.b(this, i[2], r4);
    }

    @Override // java.util.Map
    public final void clear() {
        this.h.clear();
    }

    public final void d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.b.b(this, i[1], r4);
    }

    public final void e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.a.b(this, i[0], r4);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.h.isEmpty();
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends String> r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        this.h.putAll(r2);
    }

    public j() {
        this(new LinkedHashMap());
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, String>> entrySet() {
        return this.h.entrySet();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.h.keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return this.h.size();
    }

    @Override // java.util.Map
    public final Collection<String> values() {
        return this.h.values();
    }

    public j(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this.h = r2;
        this.a = MapPropertyDelegateKt.a(this, "request_page");
        this.b = MapPropertyDelegateKt.a(this, "charge_scene");
        this.c = MapPropertyDelegateKt.a(this, "charge_reason");
        this.d = MapPropertyDelegateKt.a(this, "event_module");
        this.e = MapPropertyDelegateKt.a(this, "promotion_source");
        this.f = MapPropertyDelegateKt.a(this, "diamond_exchange_optimize");
        this.g = MapPropertyDelegateKt.a(this, "guide_source");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r2) {
        if ((r2 instanceof String) == true) goto L6;
        return false;
    L6:
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.h.containsKey(r3);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r2) {
        if ((r2 instanceof String) == true) goto L6;
        return false;
    L6:
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "value");
        return this.h.containsValue(r3);
    }

    @Override // java.util.Map
    public final String get(Object r2) {
        if ((r2 instanceof String) == true) goto L6;
        return null;
    L6:
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.h.get(r3);
    }

    @Override // java.util.Map
    public final String remove(Object r2) {
        if ((r2 instanceof String) == true) goto L6;
        return null;
    L6:
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.h.remove(r3);
    }

    @Override // java.util.Map
    public final String put(String r2, String r3) {
        String r4 = r2;
        String r5 = r3;
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        return this.h.put(r4, r5);
    }
}
