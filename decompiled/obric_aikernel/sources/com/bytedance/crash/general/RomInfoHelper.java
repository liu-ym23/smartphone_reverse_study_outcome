package com.bytedance.crash.general;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
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
        @NonNull
        String getVersion() {
            return Build.DISPLAY + "_" + this.mVersion;
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            String r10 = Build.DISPLAY;
            if (TextUtils.isEmpty(r10) == false) goto L5;
        L7:
            return false;
        L5:
            if (r10.toLowerCase(Rom.mLocale).contains(OS) == false) goto L7;
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
        @NonNull
        String getVersion() {
            return "coloros_" + this.mVersion + "_" + Build.DISPLAY;
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            String r10 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(r10) == false) goto L5;
        L7:
            return false;
        L5:
            if (r10.toLowerCase(Rom.mLocale).contains(VENDOR) == false) goto L7;
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
        @NonNull
        String getVersion() {
            if (TextUtils.isEmpty(this.mVersion) == false) goto L5;
        L8:
            String r10 = Build.DISPLAY;
            if (r10 != null) goto L12;
            return "unknown";
        L12:
            return r10;
        L5:
            if (this.mVersion.toLowerCase(Rom.mLocale).contains("emotionui") == false) goto L8;
            return this.mVersion + "_" + Build.DISPLAY;
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            if (TextUtils.isEmpty(this.mVersion) == true) goto L23;
            String r10 = this.mVersion.toLowerCase(Rom.mLocale);
            if (r10.startsWith("emotionui") == false) goto L7;
        L8:
            return true;
        L7:
            if (r10.startsWith(OS_1) == true) goto L8;
        L23:
            String r11 = Build.BRAND;     // Catch: Throwable -> L21
            if (TextUtils.isEmpty(r11) == true) goto L25;
            if (r11.toLowerCase(Rom.mLocale).startsWith(VENDOR) == false) goto L25;
            return true;
        L25:
            String r12 = Build.MANUFACTURER;     // Catch: Throwable -> L22
            if (TextUtils.isEmpty(r12) == true) goto L19;
            if (r12.toLowerCase(Rom.mLocale).startsWith(VENDOR) == false) goto L27;
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
        @NonNull
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
            String r10 = Build.DISPLAY;
            if (TextUtils.isEmpty(r10) == true) goto L8;
            if (r10.toLowerCase(Rom.mLocale).contains("flyme") == false) goto L8;
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
            super(VENDOR, OS);
            this.mDisplayId = RomInfoHelper.access$000("ro.vivo.os.build.display.id");
            this.mProductVersion = RomInfoHelper.access$000("ro.vivo.product.version");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        @NonNull
        String getVersion() {
            return this.mDisplayId + "_" + this.mProductVersion;
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            if (TextUtils.isEmpty(this.mDisplayId) == false) goto L5;
        L7:
            return false;
        L5:
            if (this.mDisplayId.toLowerCase(Rom.mLocale).contains(OS) == false) goto L7;
            return true;
        }
    }

    static class Miui extends Rom {
        private static final String OS = "miui";
        private static final String VENDOR = "xiaomi";
        private final String mVersion;

        Miui() {
            super(VENDOR, "miui");
            this.mVersion = RomInfoHelper.access$000("ro.miui.ui.version.name");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        @NonNull
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
            super(VENDOR, OS);
            this.mVersion = RomInfoHelper.access$000(PROPERTY);
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        @NonNull
        String getVersion() {
            return this.mVersion + "_" + Build.DISPLAY;
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            String r10 = Build.MANUFACTURER + Build.BRAND;
            if (TextUtils.isEmpty(r10) == false) goto L5;
            return false;
        L5:
            String r11 = r10.toLowerCase(Rom.mLocale);
            if (r11.contains(OS) == false) goto L8;
        L9:
            return true;
        L8:
            if (r11.contains(VENDOR) == true) goto L9;
            return false;
        }
    }

    static abstract class Rom {
        protected static final String SEPARATOR = "_";

        @SuppressLint({"ConstantLocale"})
        protected static final Locale mLocale = null;
        protected static String mOs;
        protected static String mVendor;

        static {
            mLocale = Locale.getDefault();
        }

        Rom(String r10, String r11) {
            mVendor = r10;
            mOs = r11;
        }

        String getOs() {
            return mOs;
        }

        String getVendor() {
            return mVendor;
        }

        @NonNull
        String getVersion() {
            String r10 = Build.DISPLAY;
            if (r10 != null) goto L6;
            return "unknown";
        L6:
            return r10;
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
            String r10 = Build.BRAND + Build.MANUFACTURER;
            if (TextUtils.isEmpty(r10) == false) goto L5;
        L7:
            return false;
        L5:
            if (r10.toLowerCase(Rom.mLocale).contains("sony") == false) goto L7;
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

    static /* synthetic */ String access$000(String r10) {
        return getSystemProperty(r10);
    }

    static /* synthetic */ boolean access$100(String r10) {
        return findClassByName(r10);
    }

    static boolean checkRoot() {
        String[] r10 = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};
        int r11 = 0;
    L4:
        if (r11 >= 11) goto L11;
        if (new File(r10[r11]).exists() == false) goto L10;
        return true;
    L10:
        r11 = r11 + 1;
        goto L4
    L11:
        return false;
    }

    private static Rom createRom() {
        Emui r10 = new Emui();
        if (r10.identify() == false) goto L5;
        return r10;
    L5:
        Miui r11 = new Miui();
        if (r11.identify() == false) goto L8;
        return r11;
    L8:
        FunTouch r12 = new FunTouch();
        if (r12.identify() == false) goto L11;
        return r12;
    L11:
        ColorOS r13 = new ColorOS();
        if (r13.identify() == false) goto L14;
        return r13;
    L14:
        Flyme r14 = new Flyme();
        if (r14.identify() == false) goto L17;
        return r14;
    L17:
        Eui r15 = new Eui();
        if (r15.identify() == false) goto L20;
        return r15;
    L20:
        Sony r16 = new Sony();
        if (r16.identify() == false) goto L23;
        return r16;
    L23:
        Amigo r17 = new Amigo();
        if (r17.identify() == false) goto L26;
        return r17;
    L26:
        OS360 r18 = new OS360();
        if (r18.identify() == false) goto L30;
        return r18;
    L30:
        return new UnknownRom();
    }

    private static boolean findClassByName(String r10) {
        Class.forName(r10);     // Catch: Throwable -> L5
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

    @NonNull
    public static String getOsVersion() {
        String r10 = Build.VERSION.RELEASE;
        if (r10.contains(".") == false) goto L6;
        return r10;
    L6:
        return r10 + ".0";
    }

    @NonNull
    static String getRandomDeviceId() {
        String r10 = UUID.randomUUID().toString();     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r10) == true) goto L5;
        return r10;
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

    @NonNull
    static String getRomIncremental() {
        String r10 = Build.VERSION.INCREMENTAL;
        if (r10 != null) goto L6;
        return "unknown";
    L6:
        return r10;
    }

    @NonNull
    static String getRomVersion() {
        return getRom().getVersion();
    }

    @NonNull
    private static String getSystemProperty(String r10) {
        return getSystemProperty(r10, "");
    }

    public static String getSystemProperty(String r10, String r11) {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r10, r11});
    L5:
        e = move-exception;
        e.printStackTrace();
        return r11;
    }

    static boolean isHarmonyOs() {
        return findClassByName("ohos.utils.system.SystemCapability");
    }

    public static boolean isMiui() {
        if ((getRom() instanceof Miui) == false) goto L6;
        return true;
    L6:
        return false;
    }
}
