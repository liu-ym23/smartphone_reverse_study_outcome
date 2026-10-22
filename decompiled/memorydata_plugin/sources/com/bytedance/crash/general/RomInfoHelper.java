package com.bytedance.crash.general;

import android.os.Build;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class RomInfoHelper {
    private static final String UNKNOWN = "unknown";
    private static Rom sRomInstance;

    static class Amigo extends Rom {
        private static final String OS = "amigo";
        private static final String PROPERTY = "ro.gn.sv.version";
        private static final String VENDOR = "gionee";
        private final String mVersion;

        Amigo() {
            super(VENDOR, OS);
            this.mVersion = RomInfoHelper.access$000(PROPERTY);
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        String getVersion() {
            return Build.DISPLAY + "_" + this.mVersion;
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            if (TextUtils.isEmpty(Build.DISPLAY) == false) goto L5;
        L7:
            return false;
        L5:
            if (Build.DISPLAY.toLowerCase(mLocale).contains(OS) == false) goto L7;
            return true;
        }
    }

    static class ColorOS extends Rom {
        private static final String OS = "coloros";
        private static final String PROPERTY = "ro.build.version.opporom";
        private static final String VENDOR = "oppo";
        private final String mVersion;

        ColorOS() {
            super(VENDOR, "coloros");
            this.mVersion = RomInfoHelper.access$000("ro.build.version.opporom");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        String getVersion() {
            return "coloros_" + this.mVersion + "_" + Build.DISPLAY;
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            if (TextUtils.isEmpty(Build.MANUFACTURER) == false) goto L5;
        L7:
            return false;
        L5:
            if (Build.MANUFACTURER.toLowerCase(mLocale).contains(VENDOR) == false) goto L7;
            return true;
        }
    }

    static class Emui extends Rom {
        private static final String OS = "emotionui";
        private static final String OS_1 = "magicui";
        private static final String PROPERTY = "ro.build.version.emui";
        private static final String VENDOR = "huawei";
        private final String mVersion;

        Emui() {
            super(VENDOR, "emotionui");
            this.mVersion = RomInfoHelper.access$000(PROPERTY);
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        String getVersion() {
            if (TextUtils.isEmpty(this.mVersion) == true) goto L9;
            if (this.mVersion.toLowerCase(mLocale).contains("emotionui") == false) goto L9;
            return this.mVersion + "_" + Build.DISPLAY;
        L9:
            if (Build.DISPLAY != null) goto L12;
            return "unknown";
        L12:
            return Build.DISPLAY;
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            if (TextUtils.isEmpty(this.mVersion) == true) goto L23;
            String r3 = this.mVersion.toLowerCase(mLocale);
            if (r3.startsWith("emotionui") == false) goto L7;
        L8:
            return true;
        L7:
            if (r3.startsWith(OS_1) == true) goto L8;
        L23:
            String r4 = Build.BRAND;     // Catch: Throwable -> L21
            if (TextUtils.isEmpty(r4) == true) goto L25;
            if (r4.toLowerCase(mLocale).startsWith(VENDOR) == false) goto L25;
            return true;
        L25:
            String r5 = Build.MANUFACTURER;     // Catch: Throwable -> L22
            if (TextUtils.isEmpty(r5) == true) goto L19;
            if (r5.toLowerCase(mLocale).startsWith(VENDOR) == false) goto L27;
            return true;
        L27:
            return false;
        L19:
            return false;
        L28:
            return false;
        }
    }

    static class Eui extends Rom {
        private static final String OS = "eui";
        private static final String VENDOR = "letv";
        private final String mVersion;

        Eui() {
            super(VENDOR, OS);
            this.mVersion = RomInfoHelper.access$000("ro.letv.release.version");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        String getVersion() {
            return "eui_" + this.mVersion + "_" + Build.DISPLAY;
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            return !TextUtils.isEmpty(this.mVersion);
        }
    }

    static class Flyme extends Rom {
        private static final String OS = "flyme";
        private static final String VENDOR = "meizu";

        Flyme() {
            super(VENDOR, "flyme");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            if (TextUtils.isEmpty(Build.DISPLAY) == true) goto L8;
            if (Build.DISPLAY.toLowerCase(mLocale).contains("flyme") == false) goto L8;
            return true;
        L8:
            if (TextUtils.isEmpty(Build.USER) == false) goto L10;
            return false;
        L10:
            if (Build.USER.equals("flyme") == false) goto L14;
            return true;
        L14:
            return false;
        }
    }

    static class FunTouch extends Rom {
        private static final String OS = "funtouch";
        private static final String VENDOR = "vivo";
        private final String mDisplayId;
        private final String mProductVersion;

        FunTouch() {
            super("vivo", OS);
            this.mDisplayId = RomInfoHelper.access$000("ro.vivo.os.build.display.id");
            this.mProductVersion = RomInfoHelper.access$000("ro.vivo.product.version");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        String getVersion() {
            return this.mDisplayId + "_" + this.mProductVersion;
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            if (TextUtils.isEmpty(this.mDisplayId) == false) goto L5;
        L7:
            return false;
        L5:
            if (this.mDisplayId.toLowerCase(mLocale).contains(OS) == false) goto L7;
            return true;
        }
    }

    static class Miui extends Rom {
        private static final String OS = "miui";
        private static final String VENDOR = "xiaomi";
        private final String mVersion;

        Miui() {
            super("xiaomi", "miui");
            this.mVersion = RomInfoHelper.access$000("ro.miui.ui.version.name");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        String getVersion() {
            return "miui_" + this.mVersion + "_" + Build.VERSION.INCREMENTAL;
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            return RomInfoHelper.access$100("miui.os.Build");
        }
    }

    static class OS360 extends Rom {
        private static final String OS = "360";
        private static final String PROPERTY = "ro.build.uiversion";
        private static final String VENDOR = "qiku";
        private final String mVersion;

        OS360() {
            super(VENDOR, "360");
            this.mVersion = RomInfoHelper.access$000(PROPERTY);
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        String getVersion() {
            return this.mVersion + "_" + Build.DISPLAY;
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            String r2 = Build.MANUFACTURER + Build.BRAND;
            if (TextUtils.isEmpty(r2) == false) goto L5;
            return false;
        L5:
            String r3 = r2.toLowerCase(mLocale);
            if (r3.contains("360") == false) goto L8;
        L9:
            return true;
        L8:
            if (r3.contains(VENDOR) == true) goto L9;
            return false;
        }
    }

    static abstract class Rom {
        protected static final String SEPARATOR = "_";
        protected static final Locale mLocale = null;
        protected static String mOs;
        protected static String mVendor;

        static {
            mLocale = Locale.getDefault();
        }

        Rom(String r1, String r2) {
            mVendor = r1;
            mOs = r2;
        }

        String getOs() {
            return mOs;
        }

        String getVendor() {
            return mVendor;
        }

        String getVersion() {
            if (Build.DISPLAY != null) goto L6;
            return "unknown";
        L6:
            return Build.DISPLAY;
        }

        abstract boolean identify();
    }

    static class Sony extends Rom {
        private static final String OS = "sony";
        private static final String VENDOR = "sony";

        Sony() {
            super("sony", "sony");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            String r1 = Build.BRAND + Build.MANUFACTURER;
            if (TextUtils.isEmpty(r1) == false) goto L5;
        L7:
            return false;
        L5:
            if (r1.toLowerCase(mLocale).contains("sony") == false) goto L7;
            return true;
        }
    }

    static class UnknownRom extends Rom {
        private static final String OS = "unknown";
        private static final String VENDOR = "unknown";

        UnknownRom() {
            super("unknown", "unknown");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            return true;
        }
    }

    static {
    }

    public RomInfoHelper() {
    }

    static /* synthetic */ String access$000(String r0) {
        return getSystemProperty(r0);
    }

    static /* synthetic */ boolean access$100(String r0) {
        return findClassByName(r0);
    }

    static boolean checkRoot() {
        String[] r0 = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};
        int r2 = 0;
    L4:
        if (r2 >= 11) goto L11;
        if (new File(r0[r2]).exists() == false) goto L10;
        return true;
    L10:
        r2 = r2 + 1;
        goto L4
    L11:
        return false;
    }

    private static Rom createRom() {
        Emui r0 = new Emui();
        if (r0.identify() == false) goto L5;
        return r0;
    L5:
        Miui r1 = new Miui();
        if (r1.identify() == false) goto L8;
        return r1;
    L8:
        FunTouch r2 = new FunTouch();
        if (r2.identify() == false) goto L11;
        return r2;
    L11:
        ColorOS r3 = new ColorOS();
        if (r3.identify() == false) goto L14;
        return r3;
    L14:
        Flyme r4 = new Flyme();
        if (r4.identify() == false) goto L17;
        return r4;
    L17:
        Eui r5 = new Eui();
        if (r5.identify() == false) goto L20;
        return r5;
    L20:
        Sony r6 = new Sony();
        if (r6.identify() == false) goto L23;
        return r6;
    L23:
        Amigo r7 = new Amigo();
        if (r7.identify() == false) goto L26;
        return r7;
    L26:
        OS360 r8 = new OS360();
        if (r8.identify() == false) goto L30;
        return r8;
    L30:
        return new UnknownRom();
    }

    private static boolean findClassByName(String r1) {
        ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    static String getKernelVersion() {
        return System.getProperty("os.version");
    L4:
        return "unknown";
    }

    public static int getOsApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    public static String getOsVersion() {
        String r0 = Build.VERSION.RELEASE;
        if (r0.contains(".") == false) goto L6;
        return r0;
    L6:
        return r0 + ".0";
    }

    static String getRandomDeviceId() {
        String r0 = UUID.randomUUID().toString();     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        return "0000-1111-2222-3333-4444";
    L10:
        return "0000-1111-2222-3333-4444";
    }

    private static Rom getRom() {
        if (sRomInstance != null) goto L15;
        monitor-enter(Rom.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sRomInstance != null) goto L9;
        sRomInstance = createRom();     // Catch: Throwable -> L11
    L9:
        monitor-exit(Rom.class);     // Catch: Throwable -> L11
    L15:
        return sRomInstance;
    }

    static String getRomIncremental() {
        if (Build.VERSION.INCREMENTAL != null) goto L6;
        return "unknown";
    L6:
        return Build.VERSION.INCREMENTAL;
    }

    static String getRomVersion() {
        return getRom().getVersion();
    }

    private static String getSystemProperty(String r1) {
        return getSystemProperty(r1, "");
    }

    public static String getSystemProperty(String r8, String r9) {
        return (String) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r8, r9}), String.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        e.printStackTrace();
        return r9;
    }

    static boolean isHarmonyOs() {
        return findClassByName("ohos.utils.system.SystemCapability");
    }

    public static boolean isMiui() {
        if (ZeusTransformUtils.instanceOf(getRom(), Miui.class) == false) goto L6;
        return true;
    L6:
        return false;
    }
}
