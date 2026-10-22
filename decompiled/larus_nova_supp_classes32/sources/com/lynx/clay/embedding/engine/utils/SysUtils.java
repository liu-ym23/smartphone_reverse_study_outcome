package com.lynx.clay.embedding.engine.utils;

import android.os.Build;
import android.os.StrictMode;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.aivoice.core.data.NameKeys;
import el9.a;
import java.io.BufferedReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SysUtils {
    private static Integer sAmountOfPhysicalMemoryKB;

    public SysUtils() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static int amountOfPhysicalMemoryKB() {
        if (sAmountOfPhysicalMemoryKB != null) goto L6;
        sAmountOfPhysicalMemoryKB = Integer.valueOf(detectAmountOfPhysicalMemoryKB());
    L6:
        return sAmountOfPhysicalMemoryKB.intValue();
    }

    private static int detectAmountOfPhysicalMemoryKB() {
        Pattern r0 = PatternProtector.compile("^MemTotal:\\s+([0-9]+) kB$");
        StrictMode.ThreadPolicy r1 = StrictMode.allowThreadDiskReads();
        PolarisFileReaderWrapper r2 = new PolarisFileReaderWrapper("/proc/meminfo");     // Catch: Throwable -> L27 Exception -> L32
        BufferedReader r3 = new BufferedReader(r2);     // Catch: Throwable -> L24
    L33:
        String r4 = r3.readLine();     // Catch: Throwable -> L21
        if (r4 == null) goto L14;
        Matcher r5 = r0.matcher(r4);     // Catch: Throwable -> L21
        if (r5.find() == false) goto L33;
        int r6 = Integer.parseInt(r5.group(1));     // Catch: Throwable -> L21
        goto L30
    L13:
        if (r6 <= 1024) goto L14;
        r3.close();     // Catch: Throwable -> L24
        r2.close();     // Catch: Throwable -> L27 Exception -> L32
        StrictMode.setThreadPolicy(r1);
        return r6;
    L14:
        r3.close();     // Catch: Throwable -> L24
        r2.close();     // Catch: Throwable -> L27 Exception -> L32
    L21:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L27 Exception -> L32
        throw th;     // Catch: Throwable -> L27 Exception -> L32
    L27:
        th = move-exception;
        StrictMode.setThreadPolicy(r1);
        throw th;
    L30:
        StrictMode.setThreadPolicy(r1);
        return 0;
    }

    public static boolean willUseVulkan() {
        Class r0 = INVOKESTATIC_com_lynx_clay_embedding_engine_utils_SysUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Throwable -> L4
        String r1 = (String) r0.getMethod("get", new Class[]{String.class, String.class}).invoke(r0, new Object[]{"ro.hwui.use_vulkan", "false"});     // Catch: Throwable -> L4
    L7:
        return "true".equals(r1);
    L4:
        th = move-exception;
        th.printStackTrace();
        r1 = NameKeys.UnloadStrategy_No_Strategy;
        goto L7
    }

    public static int sdkLevel() {
        return Build.VERSION.SDK_INT;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_clay_embedding_engine_utils_SysUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
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
}
