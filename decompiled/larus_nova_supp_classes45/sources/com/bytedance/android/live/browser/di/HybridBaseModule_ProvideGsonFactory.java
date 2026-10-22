package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.JsDoubleTypeAdapter;
import com.bytedance.android.live.browser.jsbridge.JsFloatTypeAdapter;
import com.bytedance.android.live.browser.jsbridge.JsIntTypeAdapter;
import com.bytedance.android.live.browser.jsbridge.JsLongTypeAdapter;
import com.bytedance.android.livesdk.config.v30;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import s20.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class HybridBaseModule_ProvideGsonFactory implements Factory<Gson> {
    private final d module;

    public Gson get() {
        return provideGson(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m476get() {
        return get();
    }

    public HybridBaseModule_ProvideGsonFactory(d r1) {
        this.module = r1;
    }

    public static HybridBaseModule_ProvideGsonFactory create(d r1) {
        return new HybridBaseModule_ProvideGsonFactory(r1);
    }

    public static Gson provideGson(d r2) {
        r2.getClass();
        if (((Boolean) v30.a.getValue()).booleanValue() == false) goto L5;
        Gson r3 = GsonHelper.get().newBuilder().registerTypeAdapter(Long.TYPE, new JsLongTypeAdapter()).registerTypeAdapter(Long.class, new JsLongTypeAdapter()).registerTypeAdapter(Integer.TYPE, new JsIntTypeAdapter()).registerTypeAdapter(Integer.class, new JsIntTypeAdapter()).registerTypeAdapter(Float.TYPE, new JsFloatTypeAdapter()).registerTypeAdapter(Float.class, new JsFloatTypeAdapter()).registerTypeAdapter(Double.TYPE, new JsDoubleTypeAdapter()).registerTypeAdapter(Double.class, new JsDoubleTypeAdapter()).create();
    L7:
        return (Gson) Preconditions.checkNotNullFromProvides(r3);
    L5:
        r3 = GsonHelper.builder().registerTypeAdapter(Long.TYPE, new JsLongTypeAdapter()).registerTypeAdapter(Long.class, new JsLongTypeAdapter()).registerTypeAdapter(Integer.TYPE, new JsIntTypeAdapter()).registerTypeAdapter(Integer.class, new JsIntTypeAdapter()).registerTypeAdapter(Float.TYPE, new JsFloatTypeAdapter()).registerTypeAdapter(Float.class, new JsFloatTypeAdapter()).registerTypeAdapter(Double.TYPE, new JsDoubleTypeAdapter()).registerTypeAdapter(Double.class, new JsDoubleTypeAdapter()).create();
        goto L7
    }
}
