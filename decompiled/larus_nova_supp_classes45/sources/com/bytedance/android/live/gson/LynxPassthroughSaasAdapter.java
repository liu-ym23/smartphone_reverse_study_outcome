package com.bytedance.android.live.gson;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/gson/LynxPassthroughSaasAdapter;", "Lcom/google/gson/JsonSerializer;", "Lja0/a;", "<init>", "()V", "a", "live-utils_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxPassthroughSaasAdapter implements JsonSerializer<ja0.a> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public LynxPassthroughSaasAdapter() {
    }

    public static void a(JsonElement r5, JsonElement r6) {
        if (r5.isJsonObject() == true) goto L5;
        return;
    L5:
        if (r6.isJsonObject() == false) goto L22;
        JsonObject r7 = r5.getAsJsonObject();
        JsonObject r8 = r6.getAsJsonObject();
        Iterator r0 = r7.keySet().iterator();
    L9:
        if (r0.hasNext() == false) goto L23;
        String r1 = (String) r0.next();
        JsonElement r2 = r7.get(r1);
        String r3 = GsonHelper.mappingFieldName(Object.class, r1);
        r8.add(r3, r2.deepCopy());
        if ((!Intrinsics.areEqual(r3, r1)) == true) goto L14;
    L14:
        if (r2.isJsonObject() == false) goto L9;
        a(r2, r8.get(r3));
        goto L9
    L23:
        return;
    }

    public final JsonElement serialize(Object r2, Type r3, JsonSerializationContext r4) {
        ja0.a r5 = (ja0.a) r2;
        Intrinsics.checkNotNullParameter(r5, "src");
        Intrinsics.checkNotNullParameter(r3, "typeOfSrc");
        Intrinsics.checkNotNullParameter(r4, "context");
        JsonElement r6 = GsonProtectorUtils.toJsonTree(GsonHelper.get(), r5);
        JsonObject r7 = new JsonObject();
        r3.getClass();
        a(r6, r7);
        return r7;
    }
}
