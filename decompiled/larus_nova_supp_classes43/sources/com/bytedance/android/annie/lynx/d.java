package com.bytedance.android.annie.lynx;

import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements AttachUserData {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Map<? extends String, ? extends String> getUserData(CrashType r10) {
        HashMap r11 = new HashMap();
        d8.b r0 = e.a;
        r11.put("last_lynx_url", e.c);
        r11.put("lynx_sdk_version", e.c);
        return r11;
    }
}
