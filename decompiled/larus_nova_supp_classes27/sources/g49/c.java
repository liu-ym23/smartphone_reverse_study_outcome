package g49;

import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public static final Keva a = null;

    static {
        a = Keva.getRepo("dora_kv_env", 0);
    }

    public static void a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        a.storeString("key_http_response" + r3, r4);
    }
}
