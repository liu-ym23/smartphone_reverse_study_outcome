package uz0;

import com.bytedance.android.live.revenue.platform.network.api.dsl.ContentType;
import com.bytedance.android.live.revenue.platform.network.api.dsl.RequestDSL;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@RequestDSL
public final class e extends a {
    public final Map<String, String> e;
    public final Map<String, List<String>> f;
    public JsonObject g;

    public e() {
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        ContentType r0 = ContentType.APPLICATION_JSON;
    }

    public static void b(e r2, Object r3) {
        ContentType r0 = ContentType.APPLICATION_JSON;
        Intrinsics.checkNotNullParameter(r3, "body");
        Intrinsics.checkNotNullParameter(r0, "contentType");
        int r1 = d.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        JsonElement r4 = GsonProtectorUtils.toJsonTree(l97.a.a, r3);
        if ((r4 instanceof JsonObject) == true) goto L12;
        r4 = null;
    L12:
        JsonObject r5 = (JsonObject) r4;
        if (r5 == null) goto L17;
        r2.g = r5;
        return;
    L17:
        throw new IllegalArgumentException("invalid body, please use object instead");
    L5:
        if (r1 == 2) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("please use field instead");
    }
}
