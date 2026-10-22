package t10;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.ies.web.jsbridge2.q;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements q {
    public c() {
    }

    public final <T> String a(T r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        Class<?> r0 = r3.getClass();
        if (Intrinsics.areEqual(r0, JsonObject.class) == true) goto L12;
        if (Intrinsics.areEqual(r0, JsonArray.class) == true) goto L12;
        if (Intrinsics.areEqual(r0, String.class) == false) goto L14;
        return r3.toString();
    L14:
        return GsonProtectorUtils.toJson(GsonHelper.get(), r3);
    L12:
        return r3.toString();
    }

    public final <T> T b(String r2, Type r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "type");
        return (T) GsonProtectorUtils.fromJson(GsonHelper.get(), r2, r3);
    }
}
