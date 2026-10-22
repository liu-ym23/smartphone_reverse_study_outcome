package pl0;

import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements AttachUserData {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Map<? extends String, ? extends String> getUserData(CrashType r3) {
        HashMap r4 = new HashMap();
        int r0 = b.a;
        r4.put("last_lynx_url", "");
        r4.put("lynx_sdk_version", "");
        return r4;
    }
}
