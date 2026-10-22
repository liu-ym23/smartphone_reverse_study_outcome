package com.bytedance.android.live.lynx.open;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.ResultCodeEnumSerializer;
import com.bytedance.ies.web.jsbridge2.q;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import w20.aa;
import w20.z9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements q {
    public d() {
    }

    public final <T> String a(T r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        Class<?> r0 = r4.getClass();
        if (Intrinsics.areEqual(r0, JsonObject.class) == true) goto L15;
        if (Intrinsics.areEqual(r0, JsonArray.class) == true) goto L15;
        if (Intrinsics.areEqual(r0, String.class) == false) goto L11;
        return r4.toString();
    L11:
        if ((r4 instanceof aa) == false) goto L18;
        GsonBuilder r1 = GsonHelper.builder();
        r1.registerTypeHierarchyAdapter(z9.class, new ResultCodeEnumSerializer());
        return GsonProtectorUtils.toJson(r1.create(), r4);
    L18:
        return GsonProtectorUtils.toJson(GsonHelper.get(), r4);
    L15:
        return r4.toString();
    }

    public final <T> T b(String r2, Type r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "type");
        return (T) GsonProtectorUtils.fromJson(GsonHelper.get(), r2, r3);
    }
}
