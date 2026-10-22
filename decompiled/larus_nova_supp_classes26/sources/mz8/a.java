package mz8;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.collection.impl.bean.CollectionListRequest;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static JSONObject a(CollectionListRequest r2) {
        Gson r0 = new Gson();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r0, "gson");
        return new JSONObject(GsonProtectorUtils.toJson(r0, r2));
    }
}
