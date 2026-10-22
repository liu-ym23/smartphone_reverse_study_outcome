package com.obric.cae.libs.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.os.SystemProperties;
import com.bytedance.crypto.platform.PlatformConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static int a(ScanResult r5) {
        if (r5 == null) goto L37;
        String r6 = r5.capabilities;
        if (r6 == null) goto L37;
        if (r6.contains("EAP") == false) goto L12;
        return 1;
    L12:
        if (r6.contains("PSK") == false) goto L15;
        return 2;
    L15:
        if (r6.contains("SAE") == false) goto L18;
        return 2;
    L18:
        if (r6.contains("WEP") == false) goto L21;
        return 2;
    L21:
        if (r6.contains("WAPI-PSK") == false) goto L24;
        return 2;
    L24:
        if (r6.contains("OWE") == false) goto L26;
    L36:
        return 3;
    L26:
        if (r6.contains("OSEN") == true) goto L36;
        if (r6.contains("WPA") == false) goto L31;
    L35:
        return 0;
    L31:
        if (r6.contains("WEP") == true) goto L35;
        if (r6.contains("EAP") == true) goto L35;
        return 3;
    L37:
        return 0;
    }

    public static String a(Context r3, int r4) {
        Iterator<ActivityManager.RunningAppProcessInfo> r5 = ((ActivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin")).getRunningAppProcesses().iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        ActivityManager.RunningAppProcessInfo r0 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r5.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");
        if (r0.pid != r4) goto L4;
        return r0.processName;
    L9:
        return null;
    }

    public static boolean a() {
        if ("qcom".equalsIgnoreCase(SystemProperties.get("ro.boot.hardware", "")) == false) goto L5;
    L8:
        return true;
    L5:
        if ("qcom".equalsIgnoreCase(SystemProperties.get("ro.hardware", "")) == true) goto L8;
        return false;
    }

    public static boolean a(int r1) {
        if (r1 >= 2412) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 2484) goto L7;
        return true;
    }

    public static boolean a(File r5, int r6) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.exists() == true) goto L8;
        return false;
    L8:
        if ((r5.length() / 1048576.0d) <= r6) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean b() {
        if ("mtk".equalsIgnoreCase(SystemProperties.get("ro.hardware.soc.manufacturer", "")) == false) goto L5;
    L16:
        return true;
    L5:
        if ("Mediatek".equalsIgnoreCase(SystemProperties.get("ro.soc.manufacturer", "")) == true) goto L16;
        if (SystemProperties.get("ro.boot.hardware", "").startsWith("mt") == true) goto L16;
        if (SystemProperties.get("ro.board.platform", "").startsWith("mt") == true) goto L16;
        if (SystemProperties.get("ro.hardware", "").startsWith("mt") == true) goto L16;
        if (SystemProperties.get(PlatformConst.PROP_SOC_MODEL, "").startsWith("MT") == true) goto L16;
        return false;
    }

    public static boolean b(int r1) {
        if (r1 >= 5160) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 5885) goto L7;
        return true;
    }

    public static boolean c() {
        List r0 = Arrays.asList(new String[]{"Xiaomi", "Redmi", "Poco"});
        String[] r1 = {PlatformConst.PROP_BRAND, "ro.product.odm.brand", PlatformConst.PROP_MANUFACTURER, "ro.product.system.manufacturer"};
        int r3 = 0;
    L4:
        if (r3 >= 4) goto L13;
        String r4 = SystemProperties.get(r1[r3], "");
        Iterator r5 = r0.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        if (((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin")).equalsIgnoreCase(r4) == false) goto L7;
        return true;
    L12:
        r3 = r3 + 1;
        goto L4
    L13:
        return false;
    }
}
