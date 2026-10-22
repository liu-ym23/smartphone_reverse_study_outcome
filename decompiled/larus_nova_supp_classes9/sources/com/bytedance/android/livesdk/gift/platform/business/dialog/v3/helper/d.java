package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final e c = null;
    public static final boolean d = false;
    public static final boolean e = false;
    public static final boolean f = false;
    public static final d g = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(d.class, "GIFT_ASSETS_FREQUENT_CALL_OPT", "getGIFT_ASSETS_FREQUENT_CALL_OPT()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftAssetsFrequentCallOpt;", 0))};
        a = r0;
        d r1 = new d();
        g = r1;
        Class r3 = e.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r4 = vh7.b.a;
        Object r6 = r4.get(r3);
        if (r6 != null) goto L12;
        r6 = r3.getConstructor(new Class[0]);
        if (r6 == null) goto L11;
        Object r5 = r4.putIfAbsent(r3, r6);
        if (r5 == null) goto L12;
        r6 = r5;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r7 = ((SerializableObjectJsonAdapterBase) ((Constructor) r6).newInstance(new Object[0])).createInstance();
        if (r7 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_assets_frequent_call_opt", (e) r7, e.class, false);
        ReadOnlyProperty r8 = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[0]);
        b = r8;
        e r9 = (e) r8.getValue(r1, r0[0]);
        c = r9;
        d = r9.r2();
        e = r9.u0();
        f = r9.M8();
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftAssetsFrequentCallOpt");
    }

    public d() {
    }
}
