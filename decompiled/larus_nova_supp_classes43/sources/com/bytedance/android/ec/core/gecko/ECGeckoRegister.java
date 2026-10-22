package com.bytedance.android.ec.core.gecko;

import android.content.Context;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.annotation.GeckoRegister;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@GeckoRegister(boeAccessKey = "c72b7611fbad48bc66a0c8814f20530d", prodAccessKey = "11f41d655db1c7dd83e5c59c5122ca5e", testAccessKey = "67f5c8c81d6fd7f0cf930563f4b520cc")
public class ECGeckoRegister implements IGeckoRegister {
    public ECGeckoRegister() {
    }

    public static String a() {
        String r10 = Integer.toString(44700);     // Catch: Exception -> L8
        int r11 = r10.length();     // Catch: Exception -> L8
        if (r11 < 5) goto L11;
        int r12 = r11 - 4;     // Catch: Exception -> L8
        int r13 = r11 - 3;     // Catch: Exception -> L8
        return r10.substring(0, r12) + "." + r10.substring(r12, r13) + "." + r10.substring(r13, r11 - 2);
    L11:
        return "1.0.0";
    L12:
        return "1.0.0";
    }

    public final Map<String, OptionCheckUpdateParams.CustomValue> registerCustomParams() {
        HashMap r0 = new HashMap();
        r0.put("business_version", new c());
        return r0;
    }

    public final String registerRootDir(Context r10) {
        return new PolarisFileWrapper(r10.getFilesDir(), "offlineX").getAbsolutePath();
    }
}
