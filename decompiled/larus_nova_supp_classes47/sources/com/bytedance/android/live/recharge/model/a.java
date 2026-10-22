package com.bytedance.android.live.recharge.model;

import com.bytedance.android.live.recharge.util.GiftToRechargeParamsKey;
import com.bytedance.android.live.revenue.common.KmpMapPropertyDelegateKt;
import com.bytedance.android.live.revenue.common.s;
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
public final class a implements Map<String, String>, KMutableMap {
    public static final /* synthetic */ KProperty[] d = null;
    public final s a;
    public final s b;
    public final /* synthetic */ Map<String, String> c;

    static {
        d = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "giftNoBalanceScene", "getGiftNoBalanceScene()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "chargeReason", "getChargeReason()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "giftPanelSessionId", "getGiftPanelSessionId()Ljava/lang/String;", 0))};
    }

    public a() {
        this(0);
    }

    @Override // java.util.Map
    public final void clear() {
        this.c.clear();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends String> r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        this.c.putAll(r2);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, String>> entrySet() {
        return this.c.entrySet();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.c.keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return this.c.size();
    }

    @Override // java.util.Map
    public final Collection<String> values() {
        return this.c.values();
    }

    public a(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this.c = r2;
        this.a = KmpMapPropertyDelegateKt.a(this, GiftToRechargeParamsKey.KEY_GIFT_NO_BALANCE_SCENE.getKeyName());
        KmpMapPropertyDelegateKt.a(this, GiftToRechargeParamsKey.KEY_SEND_GIFT_CHARGE_REASON.getKeyName());
        this.b = KmpMapPropertyDelegateKt.a(this, GiftToRechargeParamsKey.KEY_GIFT_PANEL_SESSION_ID.getKeyName());
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r2) {
        if ((r2 instanceof String) == true) goto L6;
        return false;
    L6:
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.c.containsKey(r3);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r2) {
        if ((r2 instanceof String) == true) goto L6;
        return false;
    L6:
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "value");
        return this.c.containsValue(r3);
    }

    @Override // java.util.Map
    public final String get(Object r2) {
        if ((r2 instanceof String) == true) goto L6;
        return null;
    L6:
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.c.get(r3);
    }

    @Override // java.util.Map
    public final String remove(Object r2) {
        if ((r2 instanceof String) == true) goto L6;
        return null;
    L6:
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.c.remove(r3);
    }

    public /* synthetic */ a(int r1) {
        this(new LinkedHashMap());
    }

    @Override // java.util.Map
    public final String put(String r2, String r3) {
        String r4 = r2;
        String r5 = r3;
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        return this.c.put(r4, r5);
    }
}
