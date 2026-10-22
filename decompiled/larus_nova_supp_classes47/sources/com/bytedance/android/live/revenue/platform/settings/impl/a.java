package com.bytedance.android.live.revenue.platform.settings.impl;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonParser;
import io.reactivex.Single;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements b01.d, o {
    public final Gson a;
    public final ConcurrentHashMap<String, JsonElement> b;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public a() {
        this.a = GsonHelper.get();
        this.b = new ConcurrentHashMap();
    }

    @Override // b01.d
    public final Single<b01.a> getClientSettingList(List<? extends b01.b> r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        b01.b r1 = (b01.b) r6.next();
        r0.put(r1.getKey(), a(r1.getType(), r1.getKey()));
        goto L4
    L7:
        return Single.just(new b01.a(r0));
    }

    public final b01.c a(int r4, String r5) {
        JsonElement r0 = this.b.get(r5);
        if (r0 != null) goto L5;
    L8:
        Object r1 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r5);
        if (r1 != null) goto L11;
        JsonElement r2 = JsonNull.INSTANCE;
    L24:
        this.b.put(r5, r2);
        return new b01.c(r4, r2);
    L11:
        if ((r1 instanceof JSONObject) == false) goto L13;
    L22:
        r2 = GsonProtectorUtils.parse(new JsonParser(), r1.toString());
        goto L24
    L13:
        if ((r1 instanceof JSONArray) == true) goto L22;
        if ((r1 instanceof Boolean) == true) goto L18;
        r2 = GsonProtectorUtils.toJsonTree(this.a, r1);
        goto L24
    L18:
        if (((Boolean) r1).booleanValue() == false) goto L20;
        r2 = GsonProtectorUtils.toJsonTree(this.a, 1);
        goto L24
    L20:
        r2 = GsonProtectorUtils.toJsonTree(this.a, 0);
        goto L24
    L5:
        if ((!Intrinsics.areEqual(r0, JsonNull.INSTANCE)) == false) goto L8;
        return new b01.c(r4, r0);
    }

    @Override // b01.d
    public final Single<b01.c> getClientSettingAsync(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return Single.just(a(r2, r3));
    }
}
