package com.bytedance.bmmt.base;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class DeviceUtil {
    private static final String KEY_COLOROS_VERSION_NAME = "ro.build.version.opporom";
    private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    private static final String KEY_FLYME_VERSION_NAME = "ro.build.display.id";
    private static final String KEY_HARMONYOS_VERSION_NAME = "hw_sc.build.platform.version";
    private static final String KEY_MAGICUI_VERSION = "ro.build.version.magic";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_NUBIA_VERSION_CODE = "ro.build.nubia.rom.code";
    private static final String KEY_NUBIA_VERSION_NAME = "ro.build.nubia.rom.name";
    private static final String KEY_ONEPLUS_VERSION_NAME = "ro.rom.version";
    private static final String KEY_VIVO_VERSION = "ro.vivo.os.version";
    private static final String KEY_VIVO_VERSION_NAME = "ro.vivo.os.name";
    private static String customOS = "";
    private static String customOSVersion = "";

    public DeviceUtil() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    private static boolean isHarmonyOS() {
        Class r1 = INVOKESTATIC_com_bytedance_bmmt_base_DeviceUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.system.BuildEx");     // Catch: Exception -> L6
        return !TextUtils.isEmpty((String) r1.getMethod("getOsBrand", new Class[0]).invoke(r1, new Object[0]));
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static boolean isMagicUI() {
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_bmmt_base_DeviceUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static String deleteSpaceAndToUpperCase(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return "";
    L6:
        return r2.replaceAll(" ", "").toUpperCase();
    }

    public static String getCustomOSVersion(String r1) {
        if (TextUtils.isEmpty(customOS) == false) goto L6;
        setCustomOSInfo(r1);
    L6:
        return customOSVersion;
    }

    public static String getPhoneSystem(String r1) {
        if (TextUtils.isEmpty(customOS) == false) goto L6;
        setCustomOSInfo(r1);
    L6:
        return customOS + "_" + customOSVersion;
    }

    private static String getSystemPropertyValue(String r6) {
        Class r0 = INVOKESTATIC_com_bytedance_bmmt_base_DeviceUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L4
        return (String) r0.getDeclaredMethod("get", new Class[]{String.class}).invoke(r0, new Object[]{r6});
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static void setCustomOSInfo(String r5) {
        String r6 = deleteSpaceAndToUpperCase(r5);     // Catch: Exception -> L62
        switch(r6.hashCode()) {
            case -1881642058: goto L34;
            case -1706170181: goto L31;
            case -602397472: goto L28;
            case 2432928: goto L25;
            case 2634924: goto L22;
            case 68924490: goto L19;
            case 73239724: goto L16;
            case 74632627: goto L13;
            case 77852109: goto L10;
            case 2141820391: goto L7;
            default: goto L36;
        };     // Catch: Exception -> L62
    L36:
        byte r7 = -1;
    L38:
        switch(r7) {
            case 0: goto L57;
            case 1: goto L47;
            case 2: goto L45;
            case 3: goto L45;
            case 4: goto L44;
            case 5: goto L44;
            case 6: goto L43;
            case 7: goto L42;
            case 8: goto L41;
            case 9: goto L40;
            default: goto L60;
        };
    L40:
        customOS = getSystemPropertyValue(KEY_NUBIA_VERSION_NAME);     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_NUBIA_VERSION_CODE);     // Catch: Exception -> L62
        return;
    L41:
        customOS = "Flyme";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_FLYME_VERSION_NAME);     // Catch: Exception -> L62
        return;
    L42:
        customOS = "HydrogenOS";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_ONEPLUS_VERSION_NAME);     // Catch: Exception -> L62
        return;
    L43:
        customOS = "Funtouch";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_VIVO_VERSION);     // Catch: Exception -> L62
        return;
    L44:
        customOS = "ColorOS";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_COLOROS_VERSION_NAME);     // Catch: Exception -> L62
        return;
    L45:
        customOS = "MIUI";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_MIUI_VERSION_NAME);     // Catch: Exception -> L62
        return;
    L60:
        customOS = "Android";     // Catch: Exception -> L62
        customOSVersion = Build.VERSION.RELEASE;     // Catch: Exception -> L62
        return;
    L47:
        if (TextUtils.isEmpty(getSystemPropertyValue(KEY_MAGICUI_VERSION)) == true) goto L50;
        customOS = "MagicUI";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_MAGICUI_VERSION);     // Catch: Exception -> L62
        return;
    L50:
        if (isHarmonyOS() == false) goto L55;
        customOS = "HarmonyOS";     // Catch: Exception -> L62
        if (TextUtils.isEmpty(getSystemPropertyValue(KEY_HARMONYOS_VERSION_NAME)) == true) goto L54;
        customOSVersion = getSystemPropertyValue(KEY_HARMONYOS_VERSION_NAME);     // Catch: Exception -> L62
        return;
    L54:
        customOSVersion = "";     // Catch: Exception -> L62
        return;
    L55:
        customOS = "EMUI";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_EMUI_VERSION_NAME);     // Catch: Exception -> L62
        return;
    L57:
        if (isHarmonyOS() == false) goto L59;
        customOSVersion = getSystemPropertyValue(KEY_HARMONYOS_VERSION_NAME);     // Catch: Exception -> L62
        customOS = "HarmonyOS";     // Catch: Exception -> L62
        return;
    L59:
        customOS = "EMUI";     // Catch: Exception -> L62
        customOSVersion = getSystemPropertyValue(KEY_EMUI_VERSION_NAME);     // Catch: Exception -> L62
        return;
    L7:
        if (r6.equals("HUAWEI") == false) goto L36;
        r7 = 0;
        goto L38
    L10:
        if (r6.equals("REDMI") == false) goto L36;
        r7 = 3;
        goto L38
    L13:
        if (r6.equals("NUBIA") == false) goto L36;
        r7 = 9;
        goto L38
    L16:
        if (r6.equals("MEIZU") == false) goto L36;
        r7 = 8;
        goto L38
    L19:
        if (r6.equals("HONOR") == false) goto L36;
        r7 = 1;
        goto L38
    L22:
        if (r6.equals("VIVO") == false) goto L36;
        r7 = 6;
        goto L38
    L25:
        if (r6.equals("OPPO") == false) goto L36;
        r7 = 5;
        goto L38
    L28:
        if (r6.equals("ONEPLUS") == false) goto L36;
        r7 = 7;
        goto L38
    L31:
        if (r6.equals("XIAOMI") == false) goto L36;
        r7 = 2;
        goto L38
    L34:
        if (r6.equals("REALME") == false) goto L36;
        r7 = 4;
    L62:
        e = move-exception;
        e.printStackTrace();
    }
}
