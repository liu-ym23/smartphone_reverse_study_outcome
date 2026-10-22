package hb;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Gson a = null;

    static {
        a = new Gson();
    }

    public static Object a(String r1, Class r10) {
        Intrinsics.checkNotNullParameter(r1, "jsonStr");
        Intrinsics.checkNotNullParameter(r10, "clazz");
        return GsonProtectorUtils.fromJson(a, r1, r10);
    }
}
