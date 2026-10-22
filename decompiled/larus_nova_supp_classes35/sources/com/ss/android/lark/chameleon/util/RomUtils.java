package com.ss.android.lark.chameleon.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import f06.b;
import f06.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class RomUtils {
    private static final String[] ROM_360_KEY = null;
    private static final String[] ROM_COOLPAD_KEY = null;
    private static final String[] ROM_GIONEE_KEY = null;
    private static final String[] ROM_GOOGLE_KEY = null;
    private static final String[] ROM_HTC_KEY = null;
    private static final String[] ROM_HUAWEI_KEY = null;
    private static final String[] ROM_LEECO_KEY = null;
    private static final String[] ROM_LENOVO_KEY = null;
    private static final String[] ROM_LG_KEY = null;
    private static final String[] ROM_MEIZU_KEY = null;
    private static final String[] ROM_MOTOROLA_KEY = null;
    private static final String[] ROM_NUBIA_KEY = null;
    private static final String[] ROM_ONEPLUS_KEY = null;
    private static final String[] ROM_OPPO_KEY = null;
    private static final String[] ROM_SAMSUNG_KEY = null;
    private static final String[] ROM_SMARTISAN_KEY = null;
    private static final String[] ROM_SONY_KEY = null;
    private static final String[] ROM_VIVO_KEY = null;
    private static final String[] ROM_XIAOMI_KEY = null;
    private static final String[] ROM_ZTE_KEY = null;
    private static final String TAG = "RomUtils";
    private static final String UNKNOWN = "unknown";
    private static final String VERSION_PROPERTY_360 = "ro.build.uiversion";
    public static final String VERSION_PROPERTY_HARMONY = "hw_sc.build.platform.version";
    private static final String VERSION_PROPERTY_HUAWEI = "ro.build.version.emui";
    private static final String VERSION_PROPERTY_LEECO = "ro.letv.release.version";
    private static final String VERSION_PROPERTY_NAME_XIAOMI = "ro.miui.ui.version.name";
    private static final String VERSION_PROPERTY_NUBIA = "ro.build.rom.id";
    private static final String VERSION_PROPERTY_ONEPLUS = "ro.rom.version";
    private static final String VERSION_PROPERTY_OPPO = "ro.build.version.opporom";
    private static final String VERSION_PROPERTY_VIVO = "ro.vivo.os.build.display.id";
    private static final String VERSION_PROPERTY_XIAOMI = "ro.build.version.incremental";
    private static final String VERSION_PROPERTY_ZTE = "ro.build.MiFavor_version";
    private static RomInfo bean;
    private static String mHarmonyVersion;
    private static boolean mHasIsHarmonyOsCache;
    private static boolean mIsHarmonyOs;
    private static boolean sCanSetStatusBar;

    public static class RomInfo {
        private String name;
        RomType romType;
        private String version;

        public String toString() {
            return "RomInfo{name=" + this.name + ", version=" + this.version + "}";
        }

        public RomInfo() {
            this.name = BuildConfig.FLAVOR;
            this.version = BuildConfig.FLAVOR;
            this.romType = RomType.UNKNOWN;
        }

        public String getBaseVersion() {
            if (RomUtils.isMiui() == false) goto L7;
            return this.name + "_" + this.version.split("_")[0];
        L7:
            return this.name + "_" + this.version;
        }

        public String getIncrementalVersion() {
            if (RomUtils.isMiui() == false) goto L8;
            String[] r0 = this.version.split("_");
            if (r0.length <= 1) goto L8;
            return r0[1];
        L8:
            return BuildConfig.FLAVOR;
        }

        public String getName() {
            return this.name;
        }

        public RomType getRomType() {
            return this.romType;
        }

        public String getVersion() {
            return this.version;
        }

        public static /* synthetic */ String access$000(RomInfo r0) {
            return r0.name;
        }

        public static /* synthetic */ String access$002(RomInfo r0, String r1) {
            r0.name = r1;
            return r1;
        }

        public static /* synthetic */ String access$102(RomInfo r0, String r1) {
            r0.version = r1;
            return r1;
        }
    }

    public static final enum RomType extends Enum<RomType> {
        private static final /* synthetic */ RomType[] $VALUES = null;
        public static final RomType ROM_360 = null;
        public static final RomType ROM_COOLPAD = null;
        public static final RomType ROM_EMUI = null;
        public static final RomType ROM_FLYME = null;
        public static final RomType ROM_GIONEE = null;
        public static final RomType ROM_GOOGLE = null;
        public static final RomType ROM_HTC = null;
        public static final RomType ROM_LEECO = null;
        public static final RomType ROM_LENOVO = null;
        public static final RomType ROM_LG = null;
        public static final RomType ROM_MIUI = null;
        public static final RomType ROM_MOTOROLA = null;
        public static final RomType ROM_NUBIA = null;
        public static final RomType ROM_ONEPLUS = null;
        public static final RomType ROM_OPPO = null;
        public static final RomType ROM_SAMSUNG = null;
        public static final RomType ROM_SMARTISAN = null;
        public static final RomType ROM_SONY = null;
        public static final RomType ROM_VIVO = null;
        public static final RomType ROM_ZTE = null;
        public static final RomType UNKNOWN = null;
        private int value;

        static {
            RomType r0 = new RomType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            RomType r1 = new RomType("ROM_EMUI", 1, 1);
            ROM_EMUI = r1;
            RomType r3 = new RomType("ROM_VIVO", 2, 2);
            ROM_VIVO = r3;
            RomType r5 = new RomType("ROM_MIUI", 3, 3);
            ROM_MIUI = r5;
            RomType r7 = new RomType("ROM_OPPO", 4, 4);
            ROM_OPPO = r7;
            RomType r9 = new RomType("ROM_LEECO", 5, 5);
            ROM_LEECO = r9;
            RomType r11 = new RomType("ROM_360", 6, 6);
            ROM_360 = r11;
            RomType r13 = new RomType("ROM_ZTE", 7, 7);
            ROM_ZTE = r13;
            RomType r15 = new RomType("ROM_ONEPLUS", 8, 8);
            ROM_ONEPLUS = r15;
            RomType r14 = new RomType("ROM_NUBIA", 9, 9);
            ROM_NUBIA = r14;
            RomType r12 = new RomType("ROM_COOLPAD", 10, 10);
            ROM_COOLPAD = r12;
            RomType r10 = new RomType("ROM_LG", 11, 11);
            ROM_LG = r10;
            RomType r8 = new RomType("ROM_GOOGLE", 12, 12);
            ROM_GOOGLE = r8;
            RomType r6 = new RomType("ROM_SAMSUNG", 13, 13);
            ROM_SAMSUNG = r6;
            RomType r4 = new RomType("ROM_FLYME", 14, 14);
            ROM_FLYME = r4;
            RomType r2 = new RomType("ROM_LENOVO", 15, 15);
            ROM_LENOVO = r2;
            RomType r16 = new RomType("ROM_SMARTISAN", 16, 16);
            ROM_SMARTISAN = r16;
            RomType r17 = new RomType("ROM_HTC", 17, 17);
            ROM_HTC = r17;
            RomType r18 = new RomType("ROM_SONY", 18, 18);
            ROM_SONY = r18;
            RomType r19 = new RomType("ROM_GIONEE", 19, 19);
            ROM_GIONEE = r19;
            RomType r20 = new RomType("ROM_MOTOROLA", 20, 20);
            ROM_MOTOROLA = r20;
            $VALUES = new RomType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20};
        }

        public static RomType[] values() {
            return (RomType[]) $VALUES.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static RomType forNumber(int r0) {
            switch(r0) {
                case 0: goto L46;
                case 1: goto L44;
                case 2: goto L42;
                case 3: goto L40;
                case 4: goto L38;
                case 5: goto L36;
                case 6: goto L34;
                case 7: goto L32;
                case 8: goto L30;
                case 9: goto L28;
                case 10: goto L26;
                case 11: goto L24;
                case 12: goto L22;
                case 13: goto L20;
                case 14: goto L18;
                case 15: goto L16;
                case 16: goto L14;
                case 17: goto L12;
                case 18: goto L10;
                case 19: goto L8;
                case 20: goto L6;
                default: goto L4;
            };
        L4:
            return UNKNOWN;
        L6:
            return ROM_MOTOROLA;
        L8:
            return ROM_GIONEE;
        L10:
            return ROM_SONY;
        L12:
            return ROM_HTC;
        L14:
            return ROM_SMARTISAN;
        L16:
            return ROM_LENOVO;
        L18:
            return ROM_FLYME;
        L20:
            return ROM_SAMSUNG;
        L22:
            return ROM_GOOGLE;
        L24:
            return ROM_LG;
        L26:
            return ROM_COOLPAD;
        L28:
            return ROM_NUBIA;
        L30:
            return ROM_ONEPLUS;
        L32:
            return ROM_ZTE;
        L34:
            return ROM_360;
        L36:
            return ROM_LEECO;
        L38:
            return ROM_OPPO;
        L40:
            return ROM_MIUI;
        L42:
            return ROM_VIVO;
        L44:
            return ROM_EMUI;
        L46:
            return UNKNOWN;
        }

        public static RomType valueOf(String r1) {
            return (RomType) a.a(RomType.class, r1);
        }

        public static RomType valueOf(int r0) {
            return forNumber(r0);
        }

        private RomType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    private static boolean isTNTSupported() {
        Integer r1 = (Integer) INVOKESTATIC_com_ss_android_lark_chameleon_util_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.SmtPCUtils").getDeclaredMethod("getProductType", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L11
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.intValue() != 1) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    static {
        ROM_HUAWEI_KEY = new String[]{"huawei"};
        ROM_VIVO_KEY = new String[]{"vivo"};
        ROM_XIAOMI_KEY = new String[]{"xiaomi"};
        ROM_OPPO_KEY = new String[]{"oppo"};
        ROM_LEECO_KEY = new String[]{"leeco", "letv"};
        ROM_360_KEY = new String[]{"360", "qiku"};
        ROM_ZTE_KEY = new String[]{"zte"};
        ROM_ONEPLUS_KEY = new String[]{"oneplus"};
        ROM_NUBIA_KEY = new String[]{"nubia"};
        ROM_COOLPAD_KEY = new String[]{"coolpad", "yulong"};
        ROM_LG_KEY = new String[]{"lg", "lge"};
        ROM_GOOGLE_KEY = new String[]{"google"};
        ROM_SAMSUNG_KEY = new String[]{"samsung"};
        ROM_MEIZU_KEY = new String[]{"meizu"};
        ROM_LENOVO_KEY = new String[]{"lenovo"};
        ROM_SMARTISAN_KEY = new String[]{"smartisan"};
        ROM_HTC_KEY = new String[]{"htc"};
        ROM_SONY_KEY = new String[]{"sony"};
        ROM_GIONEE_KEY = new String[]{"gionee", "amigo"};
        ROM_MOTOROLA_KEY = new String[]{"motorola"};
        bean = null;
        sCanSetStatusBar = true;
    }

    private static String getBrand() {
        String r0 = Build.BRAND;     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r0) == true) goto L6;
        return r0.toLowerCase();
    L6:
        return UNKNOWN;
    L11:
        return UNKNOWN;
    }

    public static String getDeviceModel() {
        return Build.MODEL.trim();
    }

    public static String getDeviceName() {
        return Build.BRAND + " " + Build.MODEL;
    }

    public static String getDeviceOS() {
        return "Android " + Build.VERSION.RELEASE;
    }

    private static String getManufacturer() {
        String r0 = Build.MANUFACTURER;     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r0) == true) goto L6;
        return r0.toLowerCase();
    L6:
        return UNKNOWN;
    L11:
        return UNKNOWN;
    }

    public static RomInfo getRomInfo() {
        RomInfo r0 = bean;
        if (r0 == null) goto L5;
        return r0;
    L5:
        bean = new RomInfo();
        String r1 = getBrand();
        String r2 = getManufacturer();
        String[] r3 = ROM_HUAWEI_KEY;
        if (isRightRom(r1, r2, r3) == false) goto L13;
        RomInfo.access$002(bean, r3[0]);
        bean.romType = RomType.ROM_EMUI;
        String r4 = getRomVersion(VERSION_PROPERTY_HUAWEI);
        String[] r5 = r4.split("_");
        if (r5.length <= 1) goto L10;
        RomInfo.access$102(bean, r5[1]);
    L12:
        return bean;
    L10:
        RomInfo.access$102(bean, r4);
        goto L12
    L13:
        String[] r6 = ROM_VIVO_KEY;
        if (isRightRom(r1, r2, r6) == false) goto L17;
        RomInfo.access$002(bean, r6[0]);
        bean.romType = RomType.ROM_VIVO;
        RomInfo.access$102(bean, getRomVersion(VERSION_PROPERTY_VIVO));
        return bean;
    L17:
        String[] r7 = ROM_XIAOMI_KEY;
        if (isRightRom(r1, r2, r7) == false) goto L21;
        RomInfo.access$002(bean, r7[0]);
        bean.romType = RomType.ROM_MIUI;
        String r8 = getRomVersion(VERSION_PROPERTY_NAME_XIAOMI);
        String r9 = getRomVersion(VERSION_PROPERTY_XIAOMI);
        RomInfo.access$102(bean, r8 + "_" + r9);
        return bean;
    L21:
        String[] r10 = ROM_OPPO_KEY;
        if (isRightRom(r1, r2, r10) == false) goto L25;
        RomInfo.access$002(bean, r10[0]);
        bean.romType = RomType.ROM_OPPO;
        RomInfo.access$102(bean, getRomVersion(VERSION_PROPERTY_OPPO));
        return bean;
    L25:
        String[] r11 = ROM_LEECO_KEY;
        if (isRightRom(r1, r2, r11) == false) goto L29;
        RomInfo.access$002(bean, r11[0]);
        bean.romType = RomType.ROM_LEECO;
        RomInfo.access$102(bean, getRomVersion(VERSION_PROPERTY_LEECO));
        return bean;
    L29:
        String[] r12 = ROM_360_KEY;
        if (isRightRom(r1, r2, r12) == false) goto L33;
        RomInfo.access$002(bean, r12[0]);
        bean.romType = RomType.ROM_360;
        RomInfo.access$102(bean, getRomVersion(VERSION_PROPERTY_360));
        return bean;
    L33:
        String[] r13 = ROM_ZTE_KEY;
        if (isRightRom(r1, r2, r13) == false) goto L37;
        RomInfo.access$002(bean, r13[0]);
        bean.romType = RomType.ROM_ZTE;
        RomInfo.access$102(bean, getRomVersion(VERSION_PROPERTY_ZTE));
        return bean;
    L37:
        String[] r14 = ROM_ONEPLUS_KEY;
        if (isRightRom(r1, r2, r14) == false) goto L41;
        RomInfo.access$002(bean, r14[0]);
        bean.romType = RomType.ROM_ONEPLUS;
        RomInfo.access$102(bean, getRomVersion(VERSION_PROPERTY_ONEPLUS));
        return bean;
    L41:
        String[] r15 = ROM_NUBIA_KEY;
        if (isRightRom(r1, r2, r15) == false) goto L45;
        RomInfo.access$002(bean, r15[0]);
        bean.romType = RomType.ROM_NUBIA;
        RomInfo.access$102(bean, getRomVersion(VERSION_PROPERTY_NUBIA));
        return bean;
    L45:
        String[] r16 = ROM_COOLPAD_KEY;
        if (isRightRom(r1, r2, r16) == false) goto L48;
        RomInfo.access$002(bean, r16[0]);
        bean.romType = RomType.ROM_COOLPAD;
    L79:
        RomInfo.access$102(bean, getRomVersion(BuildConfig.FLAVOR));
        return bean;
    L48:
        String[] r17 = ROM_LG_KEY;
        if (isRightRom(r1, r2, r17) == false) goto L51;
        RomInfo.access$002(bean, r17[0]);
        bean.romType = RomType.ROM_LG;
        goto L79
    L51:
        String[] r18 = ROM_GOOGLE_KEY;
        if (isRightRom(r1, r2, r18) == false) goto L54;
        RomInfo.access$002(bean, r18[0]);
        bean.romType = RomType.ROM_GOOGLE;
        goto L79
    L54:
        String[] r19 = ROM_SAMSUNG_KEY;
        if (isRightRom(r1, r2, r19) == false) goto L57;
        RomInfo.access$002(bean, r19[0]);
        bean.romType = RomType.ROM_SAMSUNG;
        goto L79
    L57:
        String[] r20 = ROM_MEIZU_KEY;
        if (isRightRom(r1, r2, r20) == false) goto L60;
        RomInfo.access$002(bean, r20[0]);
        bean.romType = RomType.ROM_FLYME;
        goto L79
    L60:
        String[] r21 = ROM_LENOVO_KEY;
        if (isRightRom(r1, r2, r21) == false) goto L63;
        RomInfo.access$002(bean, r21[0]);
        bean.romType = RomType.ROM_LENOVO;
        goto L79
    L63:
        String[] r22 = ROM_SMARTISAN_KEY;
        if (isRightRom(r1, r2, r22) == false) goto L66;
        RomInfo.access$002(bean, r22[0]);
        bean.romType = RomType.ROM_SMARTISAN;
        goto L79
    L66:
        String[] r23 = ROM_HTC_KEY;
        if (isRightRom(r1, r2, r23) == false) goto L69;
        RomInfo.access$002(bean, r23[0]);
        bean.romType = RomType.ROM_HTC;
        goto L79
    L69:
        String[] r24 = ROM_SONY_KEY;
        if (isRightRom(r1, r2, r24) == false) goto L72;
        RomInfo.access$002(bean, r24[0]);
        bean.romType = RomType.ROM_SONY;
        goto L79
    L72:
        String[] r25 = ROM_GIONEE_KEY;
        if (isRightRom(r1, r2, r25) == false) goto L75;
        RomInfo.access$002(bean, r25[0]);
        bean.romType = RomType.ROM_GIONEE;
        goto L79
    L75:
        String[] r26 = ROM_MOTOROLA_KEY;
        if (isRightRom(r1, r2, r26) == false) goto L78;
        RomInfo.access$002(bean, r26[0]);
        bean.romType = RomType.ROM_MOTOROLA;
        goto L79
    L78:
        RomInfo.access$002(bean, r2);
        goto L79
    }

    public static int getVmType() {
        if ((System.getProperty("java.vm.version").charAt(0) - '0') >= 2) goto L5;
        return 2;
    L5:
        return 1;
    }

    public static boolean is360() {
        return ROM_360_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isAndroidQOrHigher() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 29) goto L5;
    L10:
        return true;
    L5:
        if (r0 == 28) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean isCoolpad() {
        return ROM_COOLPAD_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isFlyme() {
        return ROM_MEIZU_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isGionee() {
        return ROM_GIONEE_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isGoogle() {
        return ROM_GOOGLE_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isHarmonyOs() {
        if (mHasIsHarmonyOsCache == true) goto L10;
        Class r1 = INVOKESTATIC_com_ss_android_lark_chameleon_util_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L7
        mIsHarmonyOs = "Harmony".equalsIgnoreCase(r1.getMethod("getOsBrand", new Class[0]).invoke(r1, new Object[0]).toString());     // Catch: Throwable -> L7
    L8:
        mHasIsHarmonyOsCache = true;
    L7:
        mIsHarmonyOs = false;
    L10:
        return mIsHarmonyOs;
    }

    public static boolean isHtc() {
        return ROM_HTC_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isHuawei() {
        return ROM_HUAWEI_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isLeeco() {
        return ROM_LEECO_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isLenovo() {
        return ROM_LENOVO_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isLg() {
        return ROM_LG_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isMiui() {
        return ROM_XIAOMI_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isMotorola() {
        return ROM_MOTOROLA_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isNubia() {
        return ROM_NUBIA_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isOneplus() {
        return ROM_ONEPLUS_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isOppo() {
        return ROM_OPPO_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isSamsung() {
        return ROM_SAMSUNG_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isSmartisan() {
        if (ROM_SMARTISAN_KEY[0].equals(RomInfo.access$000(getRomInfo())) == false) goto L5;
    L6:
        return true;
    L5:
        if (isTNTSupported() == true) goto L6;
        return false;
    }

    public static boolean isSony() {
        return ROM_SONY_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isVivo() {
        return ROM_VIVO_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    public static boolean isZte() {
        return ROM_ZTE_KEY[0].equals(RomInfo.access$000(getRomInfo()));
    }

    private RomUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String getHarmonyVersion() {
        if (isHarmonyOs() == true) goto L7;
        return UNKNOWN;
    L7:
        if (mHarmonyVersion != null) goto L10;
        mHarmonyVersion = getRomVersion(VERSION_PROPERTY_HARMONY);
    L10:
        return mHarmonyVersion;
    }

    public static RomType getRomType() {
        return getRomInfo().romType;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_lark_chameleon_util_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static View INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_RomUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    private static String getRomVersion(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L5;
        String r4 = getSystemProperty(r3);
    L7:
        if (TextUtils.isEmpty(r4) == false) goto L9;
    L19:
        String r0 = Build.DISPLAY;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r0) == true) goto L16;
        r4 = r0.toLowerCase();     // Catch: Throwable -> L14
    L16:
        if (TextUtils.isEmpty(r4) == false) goto L18;
        return UNKNOWN;
    L18:
        return r4;
    L9:
        if (r4.equals(UNKNOWN) == false) goto L16;
    L5:
        r4 = BuildConfig.FLAVOR;
        goto L7
    }

    private static String getSystemProperty(String r2) {
        String r0 = getSystemPropertyByReflect(r2);
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        String r1 = getSystemPropertyByShell(r2);
        if (TextUtils.isEmpty(r1) == true) goto L9;
        return r1;
    L9:
        return getSystemPropertyByStream(r2);
    }

    private static String getSystemPropertyByReflect(String r8) {
        Class r1 = INVOKESTATIC_com_ss_android_lark_chameleon_util_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L5
        return (String) r1.getMethod("get", new Class[]{String.class, String.class}).invoke(r1, new Object[]{r8, BuildConfig.FLAVOR});
    L5:
        return BuildConfig.FLAVOR;
    }

    private static String getSystemPropertyByShell(String r4) {
        BufferedReader r1 = null;
        BufferedReader r0 = new BufferedReader(new InputStreamReader(com_ss_android_lark_chameleon_util_RomUtils_java_lang_Runtime_exec(Runtime.getRuntime(), "getprop " + r4).getInputStream()), ChameleonContainerUtils.MAX_URL_LENGTH);     // Catch: Throwable -> L13 IOException -> L17
        String r5 = r0.readLine();     // Catch: Throwable -> L10 IOException -> L12
        if (r5 != null) goto L30;
        r0.close();     // Catch: IOException -> L23
    L25:
        return BuildConfig.FLAVOR;
    L30:
        r0.close();     // Catch: IOException -> L22
    L7:
        return r5;
    L12:
        r1 = r0;
    L10:
        th = th;
        r1 = r0;
    L14:
        if (r1 != null) goto L28;
    L16:
        throw th;
    L28:
        r1.close();     // Catch: IOException -> L24
        goto L16
    L13:
        th = th;
    L36:
        return BuildConfig.FLAVOR;
    L18:
        if (r1 == null) goto L35;
        r1.close();     // Catch: IOException -> L23
        goto L25
    L35:
        return BuildConfig.FLAVOR;
    }

    private static String getSystemPropertyByStream(String r6) {
        Properties r1 = new Properties();     // Catch: Exception -> L5
        r1.load(new PolarisFileInputStreamWrapper(new PolarisFileWrapper(Environment.getRootDirectory(), "build.prop")));     // Catch: Exception -> L5
        return r1.getProperty(r6, BuildConfig.FLAVOR);
    L5:
        return BuildConfig.FLAVOR;
    }

    public static boolean isTargetQOrHigher(Context r1) {
        if (r1.getApplicationInfo().targetSdkVersion < 29) goto L5;
        return true;
    L5:
        return false;
    }

    private static Process com_ss_android_lark_chameleon_util_RomUtils_java_lang_Runtime_exec(Runtime r12, String r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13};
        b r10 = new b();
        d r11 = r8.b(102900, "java/lang/Runtime", "exec", r12, r9, "java.lang.Process", r10);
        if (r11.a == false) goto L6;
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, null, r10, false);
        return (Process) r11.b;
    L6:
        Process r14 = r12.exec(r13);
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, r14, r10, true);
        return r14;
    }

    public static boolean setFlymeStatusBarDarkMode(boolean r3, Window r4) {
        WindowManager.LayoutParams r0 = r4.getAttributes();     // Catch: Throwable -> L8
        Field r1 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Throwable -> L8
        if (r3 == false) goto L5;
        r1.set(r0, Integer.valueOf(r1.getInt(r0) | 512));     // Catch: Throwable -> L8
    L6:
        r4.setAttributes(r0);     // Catch: Throwable -> L8
        return true;
    L5:
        r1.set(r0, Integer.valueOf(r1.getInt(r0) & (-513)));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static boolean setMiuiStatusBarDarkMode(boolean r8, Window r9) {
        Class<?> r1 = r9.getClass();     // Catch: Throwable -> L9
        Class r2 = INVOKESTATIC_com_ss_android_lark_chameleon_util_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L9
        int r3 = r2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r2);     // Catch: Throwable -> L9
        Class<?> r6 = Integer.TYPE;     // Catch: Throwable -> L9
        Method r4 = r1.getMethod("setExtraFlags", new Class[]{r6, r6});     // Catch: Throwable -> L9
        Object[] r5 = new Object[2];     // Catch: Throwable -> L9
        if (r8 == false) goto L6;
        int r10 = r3;
    L7:
        r5[0] = Integer.valueOf(r10);     // Catch: Throwable -> L9
        r5[1] = Integer.valueOf(r3);     // Catch: Throwable -> L9
        r4.invoke(r9, r5);     // Catch: Throwable -> L9
        return true;
    L6:
        r10 = 0;
    L9:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static boolean trySetStatusBarDarkOnLight(Context r1, Window r2) {
        return setStatusBarDarkMode(true, r1, r2);
    }

    public static boolean trySetStatusBarLightOnDark(Context r1, Window r2) {
        return setStatusBarDarkMode(false, r1, r2);
    }

    private static boolean isRightRom(String r5, String r6, String... r7) {
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        String r3 = r7[r2];
        if (r5.contains(r3) == true) goto L10;
        if (r6.contains(r3) == true) goto L16;
        r2 = r2 + 1;
        goto L3
    L16:
        return true;
    L10:
        return true;
    L12:
        return false;
    }

    private static boolean setStatusBarDarkMode(boolean r5, Context r6, Window r7) {
        int r0 = Build.VERSION.SDK_INT;
        boolean r1 = false;
        if (r6 == null) goto L33;
        if (r7 == null) goto L33;
    L31:
        th = move-exception;
        th.printStackTrace();
        goto L33
    L7:
        if (sCanSetStatusBar == true) goto L11;
        r7.clearFlags(PluginList.LEVEL_NOT_SET);     // Catch: Throwable -> L31
        return false;
    L11:
        if (isMiui() == false) goto L17;
        if (r0 < 23) goto L14;
    L23:
        if (r0 < 23) goto L29;
        View r8 = INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_RomUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r7);     // Catch: Throwable -> L31
        int r2 = r8.getSystemUiVisibility();     // Catch: Throwable -> L31
        if (r5 == false) goto L27;
        r8.setSystemUiVisibility(r2 | 8192);     // Catch: Throwable -> L31
    L28:
        r1 = true;
        goto L29
    L27:
        r8.setSystemUiVisibility(r2 & (-8193));     // Catch: Throwable -> L31
    L29:
        r7.clearFlags(67108864);     // Catch: Throwable -> L31
        r7.addFlags(PluginList.LEVEL_NOT_SET);     // Catch: Throwable -> L31
        goto L33
    L14:
        if (setMiuiStatusBarDarkMode(r5, r7) == false) goto L23;
    L15:
        r1 = true;
        goto L23
    L17:
        if (isFlyme() == false) goto L23;
        if (r0 >= 23) goto L20;
        return false;
    L20:
        if (setFlymeStatusBarDarkMode(r5, r7) == false) goto L23;
    L33:
        return r1;
    }
}
