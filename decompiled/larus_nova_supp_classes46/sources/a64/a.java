package a64;

import com.bytedance.awemeopen.infra.base.env.AoEnv;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final HashMap<String, Function0<String>> a = null;

    static {
        a = new HashMap();
    }

    public static void a(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        r2.put("version_code", String.valueOf(AoEnv.e()));
        r2.put("aid", AoEnv.d());
        r2.put("device_platform", "android");
        r2.put("app-id", AoEnv.d());
        r2.put("sdk-version", AoEnv.g());
    }
}
