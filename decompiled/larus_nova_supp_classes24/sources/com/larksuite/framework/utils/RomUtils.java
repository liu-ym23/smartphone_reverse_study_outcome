package com.larksuite.framework.utils;

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
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f06.b;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class RomUtils {
    public static final String[] a = null;
    public static final String[] b = null;
    public static final String[] c = null;
    public static final String[] d = null;
    public static final String[] e = null;
    public static final String[] f = null;
    public static final String[] g = null;
    public static final String[] h = null;
    public static final String[] i = null;
    public static final String[] j = null;
    public static final String[] k = null;
    public static final String[] l = null;
    public static final String[] m = null;
    public static final String[] n = null;
    public static final String[] o = null;
    public static final String[] p = null;
    public static final String[] q = null;
    public static final String[] r = null;
    public static final String[] s = null;
    public static final String[] t = null;
    public static a u;

    public static final enum RomType extends Enum<RomType> {
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
        public static final /* synthetic */ RomType[] a = null;
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
            RomType r19 = new RomType("ROM_SONY", 18, 18);
            ROM_SONY = r19;
            RomType r20 = new RomType("ROM_GIONEE", 19, 19);
            ROM_GIONEE = r20;
            RomType r21 = new RomType("ROM_MOTOROLA", 20, 20);
            ROM_MOTOROLA = r21;
            a = new RomType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r19, r20, r21};
        }

        public static RomType[] values() {
            return (RomType[]) a.clone();
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
            return (RomType) r27.a.a(RomType.class, r1);
        }

        public static RomType valueOf(int r0) {
            return forNumber(r0);
        }

        public RomType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static class a {
        public String a;
        public String b;

        public final String toString() {
            return "RomInfo{name=" + this.a + ", version=" + this.b + "}";
        }

        public a() {
            this.a = "";
            this.b = "";
            RomType r0 = RomType.UNKNOWN;
        }
    }

    static {
        a = new String[]{"huawei"};
        b = new String[]{"vivo"};
        c = new String[]{"xiaomi"};
        d = new String[]{"oppo"};
        e = new String[]{"leeco", "letv"};
        f = new String[]{"360", "qiku"};
        g = new String[]{"zte"};
        h = new String[]{"oneplus"};
        i = new String[]{"nubia"};
        j = new String[]{"coolpad", "yulong"};
        k = new String[]{"lg", "lge"};
        l = new String[]{"google"};
        m = new String[]{"samsung"};
        n = new String[]{"meizu"};
        o = new String[]{"lenovo"};
        p = new String[]{"smartisan"};
        q = new String[]{"htc"};
        r = new String[]{"sony"};
        s = new String[]{"gionee", "amigo"};
        t = new String[]{"motorola"};
        u = null;
    }

    public static String c() {
        return Build.BRAND + " " + Build.MODEL;
    }

    public static String d() {
        return "Android " + Build.VERSION.RELEASE;
    }

    public static boolean g() {
        return a[0].equals(e().a);
    }

    public static boolean h() {
        return c[0].equals(e().a);
    }

    public static boolean j() {
        if (p[0].equals(e().a) == false) goto L22;
    L20:
        return true;
    L22:
        Integer r0 = (Integer) a("android.app.SmtPCUtils").getDeclaredMethod("getProductType", new Class[0]).invoke(null, new Object[0]);     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 Throwable -> L15 ClassNotFoundException -> L17
        if (r0 == null) goto L10;
        if (r0.intValue() != 1) goto L10;
        boolean r1 = true;
    L19:
        if (r1 == true) goto L20;
        return false;
    L10:
        r1 = false;
    L15:
        e = move-exception;
        Log.e("RomUtils", "TNT detected failed " + e.getMessage());
        goto L10
    }

    public static a e() {
        String r0 = "unknown";
        a r1 = u;
        if (r1 == null) goto L5;
        return r1;
    L5:
        u = new a();
        String r2 = Build.BRAND;     // Catch: Throwable -> L91
        if (TextUtils.isEmpty(r2) == true) goto L10;
        String r3 = r2.toLowerCase();     // Catch: Throwable -> L91
    L92:
        String r4 = Build.MANUFACTURER;     // Catch: Throwable -> L90
        if (TextUtils.isEmpty(r4) == true) goto L14;
        r0 = r4.toLowerCase();     // Catch: Throwable -> L90
    L14:
        String[] r5 = a;
        if (i(r3, r0, r5) == false) goto L22;
        a r6 = u;
        r6.a = r5[0];
        RomType r7 = RomType.UNKNOWN;
        r6.getClass();
        String r8 = f("ro.build.version.emui");
        String[] r9 = r8.split("_");
        if (r9.length <= 1) goto L19;
        u.b = r9[1];
    L21:
        return u;
    L19:
        u.b = r8;
        goto L21
    L22:
        String[] r10 = b;
        if (i(r3, r0, r10) == false) goto L26;
        a r11 = u;
        r11.a = r10[0];
        RomType r12 = RomType.UNKNOWN;
        r11.getClass();
        u.b = f("ro.vivo.os.build.display.id");
        return u;
    L26:
        String[] r13 = c;
        if (i(r3, r0, r13) == false) goto L30;
        a r14 = u;
        r14.a = r13[0];
        RomType r15 = RomType.UNKNOWN;
        r14.getClass();
        String r16 = f("ro.miui.ui.version.name");
        String r17 = f("ro.build.version.incremental");
        u.b = r16 + "_" + r17;
        return u;
    L30:
        String[] r19 = d;
        if (i(r3, r0, r19) == false) goto L34;
        a r20 = u;
        r20.a = r19[0];
        RomType r21 = RomType.UNKNOWN;
        r20.getClass();
        u.b = f("ro.build.version.opporom");
        return u;
    L34:
        String[] r22 = e;
        if (i(r3, r0, r22) == false) goto L38;
        a r23 = u;
        r23.a = r22[0];
        RomType r24 = RomType.UNKNOWN;
        r23.getClass();
        u.b = f("ro.letv.release.version");
        return u;
    L38:
        String[] r25 = f;
        if (i(r3, r0, r25) == false) goto L42;
        a r26 = u;
        r26.a = r25[0];
        RomType r27 = RomType.UNKNOWN;
        r26.getClass();
        u.b = f("ro.build.uiversion");
        return u;
    L42:
        String[] r29 = g;
        if (i(r3, r0, r29) == false) goto L46;
        a r30 = u;
        r30.a = r29[0];
        RomType r31 = RomType.UNKNOWN;
        r30.getClass();
        u.b = f("ro.build.MiFavor_version");
        return u;
    L46:
        String[] r32 = h;
        if (i(r3, r0, r32) == false) goto L50;
        a r33 = u;
        r33.a = r32[0];
        RomType r34 = RomType.UNKNOWN;
        r33.getClass();
        u.b = f("ro.rom.version");
        return u;
    L50:
        String[] r35 = i;
        if (i(r3, r0, r35) == false) goto L54;
        a r36 = u;
        r36.a = r35[0];
        RomType r37 = RomType.UNKNOWN;
        r36.getClass();
        u.b = f("ro.build.rom.id");
        return u;
    L54:
        String[] r38 = j;
        if (i(r3, r0, r38) == false) goto L57;
        a r39 = u;
        r39.a = r38[0];
        RomType r40 = RomType.UNKNOWN;
        r39.getClass();
    L88:
        u.b = f("");
        return u;
    L57:
        String[] r41 = k;
        if (i(r3, r0, r41) == false) goto L60;
        a r42 = u;
        r42.a = r41[0];
        RomType r43 = RomType.UNKNOWN;
        r42.getClass();
        goto L88
    L60:
        String[] r44 = l;
        if (i(r3, r0, r44) == false) goto L63;
        a r45 = u;
        r45.a = r44[0];
        RomType r46 = RomType.UNKNOWN;
        r45.getClass();
        goto L88
    L63:
        String[] r47 = m;
        if (i(r3, r0, r47) == false) goto L66;
        a r48 = u;
        r48.a = r47[0];
        RomType r49 = RomType.UNKNOWN;
        r48.getClass();
        goto L88
    L66:
        String[] r50 = n;
        if (i(r3, r0, r50) == false) goto L69;
        a r51 = u;
        r51.a = r50[0];
        RomType r52 = RomType.UNKNOWN;
        r51.getClass();
        goto L88
    L69:
        String[] r53 = o;
        if (i(r3, r0, r53) == false) goto L72;
        a r54 = u;
        r54.a = r53[0];
        RomType r55 = RomType.UNKNOWN;
        r54.getClass();
        goto L88
    L72:
        String[] r56 = p;
        if (i(r3, r0, r56) == false) goto L75;
        a r57 = u;
        r57.a = r56[0];
        RomType r59 = RomType.UNKNOWN;
        r57.getClass();
        goto L88
    L75:
        String[] r60 = q;
        if (i(r3, r0, r60) == false) goto L78;
        a r61 = u;
        r61.a = r60[0];
        RomType r62 = RomType.UNKNOWN;
        r61.getClass();
        goto L88
    L78:
        String[] r63 = r;
        if (i(r3, r0, r63) == false) goto L81;
        a r64 = u;
        r64.a = r63[0];
        RomType r65 = RomType.UNKNOWN;
        r64.getClass();
        goto L88
    L81:
        String[] r66 = s;
        if (i(r3, r0, r66) == false) goto L84;
        a r67 = u;
        r67.a = r66[0];
        RomType r68 = RomType.UNKNOWN;
        r67.getClass();
        goto L88
    L84:
        String[] r69 = t;
        if (i(r3, r0, r69) == false) goto L87;
        a r70 = u;
        r70.a = r69[0];
        RomType r71 = RomType.UNKNOWN;
        r70.getClass();
        goto L88
    L87:
        u.a = r0;
    L10:
        r3 = "unknown";
        goto L92
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
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
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
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

    public static String f(String r9) {
        String r2 = "";
        if (TextUtils.isEmpty(r9) == true) goto L39;
        Class r1 = a("android.os.SystemProperties");     // Catch: Exception -> L6
        String r3 = (String) r1.getMethod("get", new Class[]{String.class, String.class}).invoke(r1, new Object[]{r9, ""});     // Catch: Exception -> L6
    L8:
        if (TextUtils.isEmpty(r3) == true) goto L10;
        r2 = r3;
        goto L39
    L10:
        BufferedReader r4 = null;
        BufferedReader r5 = new BufferedReader(new InputStreamReader(b(Runtime.getRuntime(), "getprop ".concat(r9)).getInputStream()), 1024);     // Catch: Throwable -> L22 IOException -> L26
        goto L27
    L66:
        String r0 = r5.readLine();     // Catch: Throwable -> L19 IOException -> L21
        if (r0 != null) goto L58;
        r5.close();     // Catch: IOException -> L30
    L62:
        goto L31
    L58:
        r5.close();     // Catch: IOException -> L16
    L33:
        if (TextUtils.isEmpty(r0) == true) goto L60;
        r2 = r0;
        goto L39
    L60:
        Properties r6 = new Properties();     // Catch: Exception -> L37
        r6.load(new PolarisFileInputStreamWrapper(new PolarisFileWrapper(Environment.getRootDirectory(), "build.prop")));     // Catch: Exception -> L37
        r2 = r6.getProperty(r9, "");     // Catch: Exception -> L37
        goto L39
    L21:
        r4 = r5;
    L19:
        th = th;
        r4 = r5;
    L23:
        if (r4 != null) goto L56;
    L25:
        throw th;
    L56:
        r4.close();     // Catch: IOException -> L51
    L22:
        th = th;
    L31:
        r0 = "";
    L27:
        if (r4 == null) goto L31;
        r4.close();     // Catch: IOException -> L30
    L6:
        r3 = "";
    L39:
        if (TextUtils.isEmpty(r2) == false) goto L41;
    L54:
        String r10 = Build.DISPLAY;     // Catch: Throwable -> L46
        if (TextUtils.isEmpty(r10) == true) goto L48;
        r2 = r10.toLowerCase();     // Catch: Throwable -> L46
    L48:
        if (TextUtils.isEmpty(r2) == false) goto L50;
        return "unknown";
    L50:
        return r2;
    L41:
        if (r2.equals("unknown") == false) goto L48;
        goto L54
    }

    public static Process b(Runtime r12, String r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13};
        b r10 = new b();
        f06.d r11 = r8.b(102900, "java/lang/Runtime", "exec", r12, r9, "java.lang.Process", r10);
        if (r11.a == false) goto L6;
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, null, r10, false);
        return (Process) r11.b;
    L6:
        Process r14 = r12.exec(r13);
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, r14, r10, true);
        return r14;
    }

    public static boolean k(boolean r8, Window r9) {
        Class<?> r1 = r9.getClass();     // Catch: Throwable -> L9
        Class r2 = a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L9
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

    public static boolean i(String r5, String r6, String... r7) {
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

    public static boolean l(boolean r5, Context r6, Window r7) {
        int r0 = Build.VERSION.SDK_INT;
        boolean r1 = false;
        if (r6 == null) goto L42;
        if (r7 == null) goto L42;
    L40:
        th = move-exception;
        th.printStackTrace();
        goto L42
    L7:
        if (h() == false) goto L13;
        if (r0 >= 23) goto L27;
        if (k(r5, r7) == false) goto L27;
    L24:
        r1 = true;
    L27:
        if (Build.VERSION.SDK_INT < 23) goto L38;
        View r8 = r7.getDecorView();     // Catch: Throwable -> L40
        if (com.larus.home.impl.utils.c.e == false) goto L33;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L40
        Thread r2 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L40
        if (r2 == com.larus.home.impl.utils.c.a) goto L33;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");     // Catch: Throwable -> L40
    L33:
        int r3 = r8.getSystemUiVisibility();     // Catch: Throwable -> L40
        if (r5 == false) goto L36;
        r8.setSystemUiVisibility(r3 | 8192);     // Catch: Throwable -> L40
    L37:
        r1 = true;
        goto L38
    L36:
        r8.setSystemUiVisibility(r3 & (-8193));     // Catch: Throwable -> L40
    L38:
        r7.clearFlags(67108864);     // Catch: Throwable -> L40
        r7.addFlags(LKBaseResponseModel.DEFAULT_ERROR_CODE);     // Catch: Throwable -> L40
        goto L42
    L13:
        if (n[0].equals(e().a) == false) goto L27;
        if (r0 >= 23) goto L45;
        return false;
    L45:
        WindowManager.LayoutParams r9 = r7.getAttributes();     // Catch: Throwable -> L21
        Field r4 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Throwable -> L21
        if (r5 == false) goto L18;
        r4.set(r9, Integer.valueOf(r4.getInt(r9) | 512));     // Catch: Throwable -> L21
    L19:
        r7.setAttributes(r9);     // Catch: Throwable -> L21
        boolean r10 = true;
    L23:
        if (r10 == false) goto L27;
    L18:
        r4.set(r9, Integer.valueOf(r4.getInt(r9) & (-513)));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L40
        r10 = false;
    L42:
        return r1;
    }
}
