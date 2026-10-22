package com.ss.android.message.util;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.support.service.IPushConfigurationService;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.utils.f;
import com.bytedance.push.utils.i;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.message.AppProvider;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.ugc.effectmanager.common.EffectRequest;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import f06.b;
import f06.c;
import f06.d;
import ita.k;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class ToolUtils {
    public static int FALSE = 0;
    public static final int FOCUS_PERMISSION_STATUS_CLOSE = 1;
    public static final int FOCUS_PERMISSION_STATUS_OPEN = 2;
    public static final int FOCUS_PERMISSION_STATUS_UNKNOWN = -1;
    public static String HONOR = "honor";
    public static String HW = "huawei";
    public static String MESSAGE_PROCESS_SUFFIX = ":push";
    private static final long MIN_GET_RUNNING_APP_PROCESS_INVOKE_INTERVAL = 1000;
    public static String ONEPLUS = "oneplus";
    public static String OPPO = "oppo";
    public static String PUSH_SERVICE_PROCESS_SUFFIX = ":pushservice";
    public static String SMP_PROCESS_SUFFIX = ":smp";
    public static final String SMP_PROCESS_SUFFIX_V2 = ":widgetProvider";
    private static final String TAG = "ToolUtils";
    public static int TRUE = 1;
    public static String VIVO = "vivo";
    public static String XIAOMI = "xiaomi";
    private static int debugMode;
    private static long initTimeStamp;
    private static Boolean isMainProcess;
    private static long lastInvokeGetRunningAppProcessTimeStamp;
    private static List<ActivityManager.RunningAppProcessInfo> lastRunningAppProcess;
    private static final Object runningAppLock = null;
    private static String sAndroidId;
    private static final Object sAndroidIdLock = null;
    private static ProcessEnum sCurProcess;
    private static String sCurProcessName;
    private static String sCurProcessNameSuffix;
    private static String sImei;
    public static boolean sIsInited;
    public static boolean sIsMiui;
    private static final Object sProcessNameLock = null;
    private static final Object sPushFakeDeviceIdLock = null;
    private static long timeStampFromProc;

    public static class a extends BDNetworkTagContextProviderAdapter {
        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return 0;
        }

        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final boolean markAsNewUser() {
            return super.markAsNewUser();
        }

        public a() {
        }
    }

    public ToolUtils() {
    }

    public static /* synthetic */ Class access$000(String r0, boolean r1, ClassLoader r2) throws ClassNotFoundException {
        return Class.forName(r0, r1, r2);
    }

    public static /* synthetic */ Class access$001(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    private static String getCurrentProcessNameByActivityThread() {
        Method r1 = INVOKESTATIC_com_ss_android_message_util_ToolUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L7
        r1.setAccessible(true);     // Catch: Throwable -> L7
        Object r2 = r1.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if ((r2 instanceof String) == false) goto L12;
        return (String) r2;
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static boolean isHuaweiDevice() {
        String r1 = Build.BRAND;     // Catch: Throwable -> L13
        if (StringUtils.isEmpty(r1) == false) goto L6;
    L7:
        String r2 = Build.MANUFACTURER;     // Catch: Throwable -> L13
        if (StringUtils.isEmpty(r2) == true) goto L16;
        if (r2.toLowerCase().startsWith(HW) == false) goto L17;
    L11:
        return true;
    L17:
        return false;
    L16:
        return false;
    L6:
        if (r1.toLowerCase().startsWith(HW) == true) goto L11;
    L18:
        return false;
    }

    static {
        sPushFakeDeviceIdLock = new Object();
        sProcessNameLock = new Object();
        sIsMiui = false;
        sIsInited = false;
        sAndroidId = "";
        sAndroidIdLock = new Object();
        sImei = "";
        runningAppLock = new Object();
        timeStampFromProc = 0;
        initTimeStamp = 0;
        debugMode = -1;
    }

    public static long currentTimeMillis() {
        long r0 = timeStampFromProc;
        if (r0 != 0) goto L13;
        String r1 = i.c().b("log.tag.push.timestamp");
        if (TextUtils.isEmpty(r1) == false) goto L18;
        timeStampFromProc = -1;
    L17:
        return System.currentTimeMillis();
    L18:
        timeStampFromProc = CastLongProtector.parseLong(r1);     // Catch: Throwable -> L9
    L10:
        initTimeStamp = System.currentTimeMillis();
        return timeStampFromProc;
    L9:
        timeStampFromProc = -1;
        goto L10
    L13:
        if (r0 == (-1)) goto L17;
        return r0 + (System.currentTimeMillis() - initTimeStamp);
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L15
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L14
    L5:
        int r3 = r2.read();     // Catch: Throwable -> L14
        if (r3 <= 0) goto L9;
        r0.append((char) r3);     // Catch: Throwable -> L14
        goto L5
    L9:
        if (f.a == false) goto L11;
        f.b("Process", "get processName = " + r0.toString());     // Catch: Throwable -> L14
    L11:
        String r1 = r0.toString();     // Catch: Throwable -> L14
        r2.close();     // Catch: Exception -> L19
    L13:
        return r1;
    L16:
        if (r2 != null) goto L25;
    L18:
        return null;
    L25:
        r2.close();     // Catch: Exception -> L20
    L15:
        r2 = null;
        goto L16
    }

    private static String getCurrentProcessNameByApplication() {
        if (Build.VERSION.SDK_INT < 28) goto L12;
        return Application.getProcessName();
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    public static String getEMUI() {
        Method r1 = Build.class.getDeclaredMethod("getString", new Class[]{String.class});     // Catch: Throwable -> L7
        r1.setAccessible(true);     // Catch: Throwable -> L7
        Object r2 = r1.invoke(null, new Object[]{"ro.build.version.emui"});     // Catch: Throwable -> L7
        f.b(TAG, "getEMUI: emuiVersion " + r2);     // Catch: Throwable -> L7
        if ((r2 instanceof String) == false) goto L12;
        return (String) r2;
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static String getRomInfo() {
        StringBuilder r0 = new StringBuilder();
        if (isMiui() == false) goto L7;
        r0.append("MIUI-");     // Catch: Throwable -> L20
    L17:
        r0.append(Build.VERSION.INCREMENTAL);     // Catch: Throwable -> L20
        goto L19
    L7:
        if (isFlyme() == false) goto L9;
        r0.append("FLYME-");     // Catch: Throwable -> L20
        goto L17
    L9:
        String r1 = getEmuiInfo();     // Catch: Throwable -> L20
        if (isEmui(r1) == false) goto L15;
        if (isNexus6p() == true) goto L15;
        r0.append("EMUI-");     // Catch: Throwable -> L20
    L15:
        if (TextUtils.isEmpty(r1) == true) goto L17;
        r0.append(r1);     // Catch: Throwable -> L20
        r0.append("-");     // Catch: Throwable -> L20
    L19:
        return r0.toString();
    }

    public static boolean isDebugModeFromProc() {
        if (debugMode != (-1)) goto L11;
        String r0 = i.c().b("log.tag.push.debug_mode");
        if (TextUtils.isEmpty(r0) == false) goto L14;
        debugMode = 0;
        goto L11
    L14:
        debugMode = CastIntegerProtector.parseInt(r0);     // Catch: Throwable -> L9
    L9:
        debugMode = 0;
    L11:
        if (debugMode != 1) goto L16;
        return true;
    L16:
        return false;
    }

    public static boolean isFlyme() {
        if (Build.DISPLAY.indexOf("Flyme") < 0) goto L5;
        return true;
    L5:
        if (Build.USER.equals("flyme") == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isMiui() {
        if (sIsInited == true) goto L11;
        if (INVOKESTATIC_com_ss_android_message_util_ToolUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("miui.os.Build") == null) goto L9;
        sIsMiui = true;     // Catch: Exception -> L12
        sIsInited = true;     // Catch: Exception -> L12
        return true;
    L9:
        sIsInited = true;
    L11:
        return sIsMiui;
    }

    public static boolean isNexus6p() {
        if ("angler".equals(Build.BOARD) == false) goto L11;
        String r0 = Build.MODEL;
        if (r0 == null) goto L11;
        if (r0.toLowerCase().contains("nexus") == false) goto L11;
        if (r0.toLowerCase().contains("6p") == false) goto L11;
        return true;
    L11:
        return false;
    }

    public static boolean isOppoDevice() {
        String r0 = Build.MANUFACTURER;
        String r1 = Build.BRAND;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L9:
        boolean r2 = false;
    L11:
        if (TextUtils.isEmpty(r1) == false) goto L13;
    L17:
        boolean r3 = false;
    L18:
        i r4 = i.c();
        if (TextUtils.isEmpty(r4.f) == false) goto L22;
        r4.f = r4.b("ro.build.version.opporom");
    L22:
        if ((!TextUtils.isEmpty(r4.f)) == true) goto L25;
        if (r2 == true) goto L25;
        if (r3 == true) goto L25;
        return false;
    L25:
        return true;
    L13:
        if (r1.toLowerCase().contains(OPPO) == false) goto L15;
    L16:
        r3 = true;
        goto L18
    L15:
        if (r1.toLowerCase().contains(ONEPLUS) == false) goto L17;
    L5:
        if (r0.toLowerCase().contains(OPPO) == false) goto L7;
    L8:
        r2 = true;
        goto L11
    L7:
        if (r0.toLowerCase().contains(ONEPLUS) == false) goto L9;
        goto L8
    }

    public static String getEmuiInfo() {
        String r0 = getSystemProperty("ro.build.version.emui");
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        return getSystemProperty("ro.build.version.magic");
    }

    public static String getMagicUI() {
        String r0 = getSystemProperty("ro.build.version.emui");     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r0) == true) goto L10;
        return getSystemProperty("ro.build.version.magic");
    L10:
        return r0;
    L6:
        return "";
    }

    public static List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses() {
        if (isActiveUser(AppProvider.getApp()) == true) goto L6;
        f.b(TAG, "[getRunningAppProcesses]return  empty running process because cur is inactive user");
        return new ArrayList();
    L6:
        boolean r4 = false;
        Map<String, Boolean> r5 = com.ss.android.pushmanager.setting.a.c;     // Catch: Throwable -> L15
        Boolean r6 = (Boolean) ((HashMap) r5).get("opt_sensitive_api_invoke");     // Catch: Throwable -> L15
        if (r6 == null) goto L10;
        f.b("PushCommonSetting", "[getValueFromPushOnlineSettingsSp]return cache value for opt_sensitive_api_invoke");     // Catch: Throwable -> L15
        r4 = r6.booleanValue();     // Catch: Throwable -> L15
    L35:
    L17:
        f.b(TAG, "[getRunningAppProcesses]optSensitiveApiInvoke:" + r4);
        if (r4 == false) goto L31;
        Object r0 = runningAppLock;
        monitor-enter(r0);
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L28
        if ((r1 - lastInvokeGetRunningAppProcessTimeStamp) < MIN_GET_RUNNING_APP_PROCESS_INVOKE_INTERVAL) goto L24;
        f.b(TAG, "[getRunningAppProcesses]invoke getRunningAppProcess");     // Catch: Throwable -> L28
        lastInvokeGetRunningAppProcessTimeStamp = r1;     // Catch: Throwable -> L28
        lastRunningAppProcess = getRunningAppProcessesInternal();     // Catch: Throwable -> L28
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L28
        return lastRunningAppProcess;
    L24:
        f.b(TAG, "[getRunningAppProcesses]api invoke frequency,return lastRunningAppProcess");     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    L31:
        f.b(TAG, "[getRunningAppProcesses]invoke getRunningAppProcessesInternal without any frequency because settings of opt_sensitive_api_invoke is false");
        return getRunningAppProcessesInternal();
    L10:
        Application r7 = AppProvider.getApp();     // Catch: Throwable -> L15
        if (r7 != null) goto L13;
        f.b("PushCommonSetting", "[getValueFromPushOnlineSettingsSp]return defaultValue because context is null");     // Catch: Throwable -> L15
        goto L35
    L13:
        boolean r8 = r7.getSharedPreferences("push_multi_process_config", 4).getBoolean("opt_sensitive_api_invoke", false);     // Catch: Throwable -> L15
        ((HashMap) r5).put("opt_sensitive_api_invoke", Boolean.valueOf(r8));     // Catch: Throwable -> L15
        f.b("PushCommonSetting", "[getValueFromPushOnlineSettingsSp]return " + r8 + " for opt_sensitive_api_invoke");     // Catch: Throwable -> L15
        r4 = r8;
    L15:
        th = move-exception;
        f.f("PushCommonSetting", "[getValueFromPushOnlineSettingsSp]return defaultValue because exception ", th);
        goto L17
    }

    private static List<ActivityManager.RunningAppProcessInfo> getRunningAppProcessesInternal() {
        return ((ActivityManager) AppProvider.getApp().getSystemService("activity")).getRunningAppProcesses();
    }

    public static void killSelf() {
        Process.killProcess(Process.myPid());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_message_util_ToolUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$001(r3);     // Catch: Throwable -> L8
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
        Class r4 = access$001(r3);     // Catch: Throwable -> L17
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

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_message_util_ToolUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static Map<String, String> addNetworkTagToHeader(Map<String, String> r3) {
        a r0 = new a();     // Catch: Exception -> L8
        if (r3 != null) goto L5;
        Map r1 = new HashMap();     // Catch: Exception -> L8
    L6:
        Pair<String, String> r2 = BDNetworkTagManager.getInstance().buildBDNetworkTag(r0);     // Catch: Exception -> L8
        r1.put(r2.first, r2.second);     // Catch: Exception -> L8
        return r1;
    L5:
        r1 = r3;
    L8:
        return r3;
    }

    public static int areNotificationsEnabled(Context r11) {
        if (r11 != null) goto L6;
        return -1;
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L24;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L24
    L8:
        if (((Boolean) Reflect.on((NotificationManager) r11.getSystemService("notification")).call("areNotificationsEnabled").get()).booleanValue() == false) goto L11;
        return TRUE;
    L11:
        return FALSE;
    L24:
        AppOpsManager r1 = (AppOpsManager) r11.getSystemService("appops");     // Catch: Throwable -> L20
        ApplicationInfo r2 = r11.getApplicationInfo();     // Catch: Throwable -> L20
        String r12 = r11.getApplicationContext().getPackageName();     // Catch: Throwable -> L20
        int r3 = r2.uid;     // Catch: Throwable -> L20
        Reflect r4 = Reflect.on(r1);     // Catch: Throwable -> L20
        Class r6 = Integer.TYPE;     // Catch: Throwable -> L20
        if (((Integer) r4.call("checkOpNoThrow", new Class[]{r6, r6, String.class}, new Object[]{Integer.valueOf(((Integer) r4.field("OP_POST_NOTIFICATION", new Class[]{r6}).get()).intValue()), Integer.valueOf(r3), r12}).get()).intValue() != 0) goto L19;
        return TRUE;
    L19:
        return FALSE;
    L20:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public static String bundleToString(Bundle r9) {
        if (r9 != null) goto L5;
        return "";
    L5:
        Set<String> r1 = r9.keySet();
        if (r1 == null) goto L16;
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        String r3 = r2.next();
        Object r4 = r9.get(r3);
        if ((r4 instanceof Intent) == true) goto L12;
        r0.append(String.format("%s--%s\n", new Object[]{r3, r4}));
        goto L9
    L12:
        r0.append(String.format("%s--%s\n", new Object[]{r3, bundleToString(((Intent) r4).getExtras())}));
        goto L9
    L15:
        return r0.toString();
    L16:
        return "";
    }

    private static String com_ss_android_message_util_ToolUtils_android_telephony_TelephonyManager_getDeviceId(TelephonyManager r13) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        b r10 = new b();
        d r11 = r8.b(101600, "android/telephony/TelephonyManager", "getDeviceId", r13, r9, "java.lang.String", r10);
        if (r11.a == false) goto L6;
        r8.a(101600, "android/telephony/TelephonyManager", "getDeviceId", r13, r9, null, r10, false);
        return (String) r11.b;
    L6:
        String r12 = r13.getDeviceId();
        r8.a(101600, "android/telephony/TelephonyManager", "getDeviceId", r13, r9, r12, r10, true);
        return r12;
    }

    public static String getAndroidId(Context r5) {
        f.b(TAG, "[getAndroidId]sAndroidId:" + sAndroidId + " stack:" + Log.getStackTraceString(new Throwable()));
        Object r2 = sAndroidIdLock;
        monitor-enter(r2);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(sAndroidId) == true) goto L10;
        f.b(TAG, "[getAndroidId]cur has valid android,return " + sAndroidId);     // Catch: Throwable -> L19
        String r6 = sAndroidId;     // Catch: Throwable -> L19
        monitor-exit(r2);     // Catch: Throwable -> L19
        return r6;
    L10:
        if (isActiveUser(r5) == true) goto L14;
        f.b(TAG, "[getAndroidId]return " + sAndroidId + " because cur is guest user");     // Catch: Throwable -> L19
        String r7 = sAndroidId;     // Catch: Throwable -> L19
        monitor-exit(r2);     // Catch: Throwable -> L19
        return r7;
    L14:
        IPushConfigurationService r0 = PushCommonSupport.getInstance().getPushConfigurationService();     // Catch: Throwable -> L19
        boolean r1 = false;
        if (r0 == null) goto L21;
        PushCommonConfiguration r3 = r0.getPushCommonConfiguration();     // Catch: Throwable -> L19
        if (r3 == null) goto L21;
        boolean r4 = r3.mIPushCommonConfiguration.optAnr();     // Catch: Throwable -> L19
    L22:
        if (r4 == true) goto L24;
        r1 = true;
    L24:
        if (r1 == false) goto L26;
        boolean r8 = m67.a.d();     // Catch: Throwable -> L19
    L27:
        if (r8 == false) goto L48;
        f.b(TAG, "[getAndroidId]use cache because cur is background");     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(sAndroidId) == true) goto L31;
    L33:
        String r9 = sAndroidId;     // Catch: Throwable -> L19
        monitor-exit(r2);     // Catch: Throwable -> L19
        return r9;
    L31:
        if (((PushOnlineSettings) j77.i.a(r5, PushOnlineSettings.class)).R() == false) goto L33;
        sAndroidId = ((LocalSettings) j77.i.a(r5, LocalSettings.class)).getAndroidId();     // Catch: Throwable -> L19
        goto L33
    L48:
        f.b(TAG, "[getAndroidId]invoke sys api to get android_id");     // Catch: Throwable -> L40
        String r10 = com_ss_android_message_util_ToolUtils_android_provider_Settings$Secure_getString(r5.getContentResolver(), "android_id");     // Catch: Throwable -> L40
        sAndroidId = r10;     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r10) == true) goto L42;
        ((LocalSettings) j77.i.a(r5, LocalSettings.class)).o(sAndroidId);     // Catch: Throwable -> L40
    L42:
        monitor-exit(r2);     // Catch: Throwable -> L19
        return sAndroidId;
    L40:
        th = move-exception;
        f.f(TAG, "error when get android_id", th);     // Catch: Throwable -> L19
        goto L42
    L26:
        r8 = m67.a.g;     // Catch: Throwable -> L19
    L21:
        r4 = false;
        goto L22
    }

    public static ProcessEnum getCurProcess(Context r1) {
        ProcessEnum r0 = sCurProcess;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ProcessEnum r2 = ProcessEnum.parseProcess(getCurProcessName(r1), r1.getPackageName());
        sCurProcess = r2;
        return r2;
    }

    public static String getCurProcessName(Context r2) {
        Object r0 = sProcessNameLock;
        monitor-enter(r0);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (sCurProcessName != null) goto L8;
        sCurProcessName = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mProcess;     // Catch: Throwable -> L30
    L8:
        if (TextUtils.isEmpty(sCurProcessName) == true) goto L12;
        String r3 = sCurProcessName;     // Catch: Throwable -> L30
        monitor-exit(r0);     // Catch: Throwable -> L30
        return r3;
    L12:
        String r1 = getCurrentProcessNameByApplication();     // Catch: Throwable -> L30
        sCurProcessName = r1;     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r1) == true) goto L17;
        String r4 = sCurProcessName;     // Catch: Throwable -> L30
        monitor-exit(r0);     // Catch: Throwable -> L30
        return r4;
    L17:
        String r5 = getCurrentProcessNameByActivityThread();     // Catch: Throwable -> L30
        sCurProcessName = r5;     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r5) == true) goto L22;
        String r6 = sCurProcessName;     // Catch: Throwable -> L30
        monitor-exit(r0);     // Catch: Throwable -> L30
        return r6;
    L22:
        String r7 = getCurProcessNameFromProc();     // Catch: Throwable -> L30
        sCurProcessName = r7;     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r7) == true) goto L27;
        String r8 = sCurProcessName;     // Catch: Throwable -> L30
        monitor-exit(r0);     // Catch: Throwable -> L30
        return r8;
    L27:
        String r9 = getCurrentProcessNameByActivityManager(r2);     // Catch: Throwable -> L30
        sCurProcessName = r9;     // Catch: Throwable -> L30
        monitor-exit(r0);     // Catch: Throwable -> L30
        return r9;
    }

    public static String getCurProcessNameSuffix(Context r2) {
        String r0 = sCurProcessNameSuffix;
        if (StringUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        String r3 = getProcessSuffix(r2, getCurProcessName(r2));
        sCurProcessNameSuffix = r3;
        return r3;
    }

    private static String getCurrentProcessNameByActivityManager(Context r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r5 = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> r1 = getRunningAppProcesses();
        if (r1 == null) goto L14;
        Iterator<ActivityManager.RunningAppProcessInfo> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L14;
        ActivityManager.RunningAppProcessInfo r3 = r2.next();
        if (r3.pid != r5) goto L9;
        return r3.processName;
    L14:
        return null;
    }

    public static String getDeviceId(Context r1) {
        HashMap r0 = new HashMap();
        getSSIDs(r1, r0);
        return (String) r0.get(EffectConfiguration.KEY_DEVICE_ID);
    }

    public static String getFocusPermissionVersion(Context r4) {
        f.b(TAG, "[getFocusPermissionVersion]");
        if (i.c().j() == false) goto L12;
        int r5 = Settings.System.getInt(r4.getContentResolver(), "notification_focus_protocol", 0);     // Catch: Throwable -> L6
        f.b(TAG, "[getFocusPermissionVersion]notificationFocusProtocol:" + r5);     // Catch: Throwable -> L6
        return String.valueOf(r5);
    L6:
        th = move-exception;
        f.e(TAG, "[getFocusPermissionVersion]exception:" + th.getLocalizedMessage());
        return "-1";
    L12:
        return "-1";
    }

    public static String getImei(Context r4) {
        String r0 = sImei;
        monitor-enter(r0);
    L47:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(sImei) == true) goto L10;
        String r5 = sImei;     // Catch: Throwable -> L47
        monitor-exit(r0);     // Catch: Throwable -> L47
        return r5;
    L10:
        if (isActiveUser(r4) == true) goto L15;
        String r6 = sImei;     // Catch: Throwable -> L47
        monitor-exit(r0);     // Catch: Throwable -> L47
        return r6;
    L15:
        if (m67.a.d() == false) goto L19;
        String r7 = sImei;     // Catch: Throwable -> L47
        monitor-exit(r0);     // Catch: Throwable -> L47
        return r7;
    L19:
        if (r4 != null) goto L23;
        String r8 = sImei;     // Catch: Throwable -> L47
        monitor-exit(r0);     // Catch: Throwable -> L47
        return r8;
    L23:
        TelephonyManager r1 = (TelephonyManager) r4.getSystemService("phone");     // Catch: Throwable -> L47
        if (r1 != null) goto L28;
        String r9 = sImei;     // Catch: Throwable -> L47
        monitor-exit(r0);     // Catch: Throwable -> L47
        return r9;
    L28:
        int r2 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L47
        if (r2 >= 23) goto L31;
    L44:
        String r10 = sImei;     // Catch: Throwable -> L47
        monitor-exit(r0);     // Catch: Throwable -> L47
        return r10;
    L31:
        if (com_ss_android_message_util_ToolUtils_android_content_Context_checkSelfPermission(r4, "android.permission.READ_PHONE_STATE") != 0) goto L44;
        if (r2 >= 26) goto L50;
        sImei = com_ss_android_message_util_ToolUtils_android_telephony_TelephonyManager_getDeviceId(r1);     // Catch: Throwable -> L47
        goto L44
    L50:
        Object r11 = INVOKESTATIC_com_ss_android_message_util_ToolUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.telephony.TelephonyManager").getMethod("getMeid", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L42
        if (r11 == null) goto L44;
        if ((r11 instanceof String) == false) goto L44;
        sImei = (String) r11;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L47
        goto L44
    }

    public static String getLaunchActivity(Context r1) {
        ComponentName r2 = k.e(r1, r1.getPackageName()).resolveActivity(r1.getPackageManager());     // Catch: Exception -> L6
        if (r2 == null) goto L12;
        return r2.getClassName();
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String getPushFakeDeviceId(Context r7) {
        Object r2 = sPushFakeDeviceIdLock;
        monitor-enter(r2);
        SharedPreferences r3 = r7.getSharedPreferences("push_multi_process_config", 4);     // Catch: Throwable -> L15
        String r4 = r3.getString("depths_device_id", "");     // Catch: Throwable -> L15
        f.b(TAG, "[getPushFakeDeviceId]cache id:" + r4);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r4) == true) goto L8;
        monitor-exit(r2);     // Catch: Throwable -> L19
        return r4;
    L8:
        DisplayMetrics r8 = INVOKEVIRTUAL_com_ss_android_message_util_ToolUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r7.getResources());     // Catch: Throwable -> L15
        int r1 = r8.widthPixels;     // Catch: Throwable -> L15
        int r9 = r8.heightPixels;     // Catch: Throwable -> L15
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L15
        r5.append(Build.BOARD);     // Catch: Throwable -> L15
        r5.append(Build.HARDWARE);     // Catch: Throwable -> L15
        String[] r6 = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L15
        if (r6.length <= 0) goto L11;
        int r10 = r6.hashCode();     // Catch: Throwable -> L15
    L12:
        r5.append(r10);     // Catch: Throwable -> L15
        r5.append(Build.BRAND);     // Catch: Throwable -> L15
        r5.append(System.currentTimeMillis());     // Catch: Throwable -> L15
        r5.append(new Random().nextInt(9999));     // Catch: Throwable -> L15
        r5.append(r1);     // Catch: Throwable -> L15
        r5.append(r9);     // Catch: Throwable -> L15
        String r11 = toSha256(r5.toString());     // Catch: Throwable -> L15
        f.b(TAG, "[getPushFakeDeviceId]depths device id:" + r11);     // Catch: Throwable -> L15
        r3.edit().putString("depths_device_id", r11).apply();     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L19
        return r11;
    L11:
        r10 = 0;
    L15:
        th = move-exception;
        f.f(TAG, "[getPushFakeDeviceId]exception ", th);     // Catch: Throwable -> L19
        return "";
    L19:
        th = move-exception;
        throw th;
    }

    public static String getSystemProperty(String r9) {
        BufferedReader r4 = null;
        String r5 = null;
        Process r3 = com_ss_android_message_util_ToolUtils_java_lang_Runtime_exec(Runtime.getRuntime(), "getprop " + r9);     // Catch: Throwable -> L12
        BufferedReader r6 = new BufferedReader(new InputStreamReader(r3.getInputStream()), 1024);     // Catch: Throwable -> L12
        r5 = r6.readLine();     // Catch: Throwable -> L10
        r3.destroy();     // Catch: Throwable -> L10
        r6.close();     // Catch: IOException -> L7
    L9:
        return r5;
    L7:
        e = move-exception;
        f.e(TAG, "Exception while closing InputStream" + e.getMessage());
    L10:
        th = th;
        String r7 = r5;
        r4 = r6;
    L32:
        f.e(TAG, "Unable to read sysprop " + r9 + th.getMessage());     // Catch: Throwable -> L21
        if (r4 != null) goto L34;
    L20:
        return r7;
    L34:
        r4.close();     // Catch: IOException -> L18
    L18:
        e = move-exception;
        f.e(TAG, "Exception while closing InputStream" + e.getMessage());
    L21:
        th = move-exception;
        if (r4 != null) goto L38;
    L27:
        throw th;
    L38:
        r4.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        f.e(TAG, "Exception while closing InputStream" + e.getMessage());
    L12:
        th = th;
        r7 = null;
        goto L32
    }

    public static String getUserSerial(Context r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        Object r10 = r9.getSystemService("user");
        if (r10 != null) goto L21;
        f.e(TAG, "userManager not exsit !!!");
        return null;
    L21:
        Object r2 = Process.class.getMethod("myUserHandle", null).invoke(Process.class, null);     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 IllegalArgumentException -> L15 NoSuchMethodException -> L17 Throwable -> L20
        return String.valueOf(((Long) r10.getClass().getMethod("getSerialNumberForUser", new Class[]{r2.getClass()}).invoke(r10, new Object[]{r2})).longValue());
    L13:
        e = move-exception;
        f.e(TAG, e.getMessage());
    L15:
        e = move-exception;
        f.e(TAG, e.getMessage());
    L17:
        e = move-exception;
        f.e(TAG, e.getMessage());
    L11:
        e = move-exception;
        f.e(TAG, e.getMessage());
    L19:
        return null;
    }

    public static boolean hasCreatedNotificationChannel(Context r3) {
        NotificationManager r4 = (NotificationManager) r3.getSystemService("notification");
        if (Build.VERSION.SDK_INT < 26) goto L11;
        List<NotificationChannel> r5 = r4.getNotificationChannels();
        if (r5 != null) goto L7;
    L9:
        return false;
    L7:
        if (r5.size() <= 0) goto L9;
        return true;
    L11:
        return true;
    }

    public static int hasFocusPermission(Context r7) {
        f.b(TAG, "[hasFocusPermission]");
        if (i.c().j() == false) goto L18;
        Uri r2 = UriProtector.parse("content://miui.statusbar.notification.public");     // Catch: Throwable -> L12
        Bundle r4 = new Bundle();     // Catch: Throwable -> L12
        r4.putString("package", r7.getPackageName());     // Catch: Throwable -> L12
        Bundle r8 = r7.getContentResolver().call(r2, "canShowFocus", null, r4);     // Catch: Throwable -> L12
        if (r8 == null) goto L19;
        boolean r9 = r8.getBoolean("canShowFocus", false);     // Catch: Throwable -> L12
        f.b(TAG, "[hasFocusPermission]canShowFocus:" + r9);     // Catch: Throwable -> L12
        if (r9 == false) goto L10;
        return 2;
    L10:
        return 1;
    L19:
        return -1;
    L12:
        th = move-exception;
        f.e(TAG, "[hasFocusPermission]exception:" + th.getLocalizedMessage());
        return -1;
    L18:
        return -1;
    }

    public static boolean isActiveUser(Context r3) {
        PushCommonConfiguration r0 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        if (r0 != null) goto L5;
        return false;
    L5:
        IPushCommonConfiguration r1 = r0.mIPushCommonConfiguration;
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.isGuestMode() == false) goto L12;
        return false;
    L12:
        if (r1.hasAgreedForPrivacyDialog() == true) goto L15;
        return false;
    L15:
        return !TextUtils.isEmpty(getDeviceId(r3));
    }

    public static boolean isEmui(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        r2 = getEmuiInfo();
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        if (r2.toLowerCase().startsWith("emotionui") == false) goto L11;
        return true;
    L11:
        if (isHuaweiDevice() == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean isMainProcess(Context r3) {
        Boolean r0 = isMainProcess;
        if (r0 != null) goto L5;
        String r1 = getCurProcessName(r3);
        boolean r2 = false;
        if (r1 != null) goto L9;
    L11:
        if (r1 != null) goto L13;
    L15:
        Boolean r4 = Boolean.valueOf(r2);
        isMainProcess = r4;
        return r4.booleanValue();
    L13:
        if (r1.equals(r3.getPackageName()) == false) goto L15;
        r2 = true;
        goto L15
    L9:
        if (r1.contains(":") == false) goto L11;
        return false;
    L5:
        return r0.booleanValue();
    }

    public static Boolean isMainProcessStart(Context r3) {
        IPushCommonConfiguration r0 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration;
        if (r0 != null) goto L5;
    L26:
        f.b(TAG, "hasAgreedForPrivacyDialog return false when isMainProcessStart is invoked.");
        return null;
    L5:
        if (r0.hasAgreedForPrivacyDialog() == false) goto L26;
        if (isMainProcess(r3) == false) goto L11;
        f.b(TAG, "isMainProcess return true when isMainProcessStart is invoked.");
        return Boolean.TRUE;
    L11:
        f.b(TAG, "getRunningAppProcesses is to be invoked when isMainProcessStart is invoked.");
        ActivityManager r1 = (ActivityManager) r3.getSystemService("activity");     // Catch: Throwable -> L25
        List<ActivityManager.RunningAppProcessInfo> r2 = getRunningAppProcesses();     // Catch: Throwable -> L25
        String r4 = r3.getPackageName();     // Catch: Throwable -> L25
        if (r2 == null) goto L24;
        if (r2.isEmpty() == true) goto L24;
        Iterator<ActivityManager.RunningAppProcessInfo> r5 = r2.iterator();     // Catch: Throwable -> L25
    L18:
        if (r5.hasNext() == false) goto L24;
        if (r4.equals(r5.next().processName) == false) goto L18;
        return Boolean.TRUE;
    L24:
        return Boolean.FALSE;
    L25:
        return null;
    }

    public static boolean isMessageProcess(Context r1) {
        String r2 = getCurProcessName(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.endsWith(MESSAGE_PROCESS_SUFFIX) == false) goto L10;
        isMainProcess = Boolean.FALSE;
        return true;
    L10:
        return false;
    }

    public static boolean isPushServiceProcess(Context r1) {
        String r2 = getCurProcessName(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.endsWith(PUSH_SERVICE_PROCESS_SUFFIX) == false) goto L10;
        isMainProcess = Boolean.FALSE;
        return true;
    L10:
        return false;
    }

    public static boolean isSmpProcess(Context r1) {
        String r2 = getCurProcessName(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.endsWith(SMP_PROCESS_SUFFIX) == false) goto L7;
    L8:
        isMainProcess = Boolean.FALSE;
        return true;
    L7:
        if (r2.endsWith(SMP_PROCESS_SUFFIX_V2) == true) goto L8;
        return false;
    }

    public static boolean isSmpProcessStart(Context r4) {
        if (PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.hasAgreedForPrivacyDialog() == true) goto L7;
        f.b(TAG, "hasAgreedForPrivacyDialog return false when isSmpProcessStart is invoked.");
        return false;
    L7:
        if (isSmpProcess(r4) == false) goto L10;
        f.b(TAG, "isSmpProcess return true when isSmpProcessStart is invoked.");
        return true;
    L10:
        f.b(TAG, "getRunningAppProcesses is to be invoked when isSmpProcessStart is invoked.");
        List<ActivityManager.RunningAppProcessInfo> r0 = getRunningAppProcesses();     // Catch: Throwable -> L22
        String r5 = r4.getPackageName() + ":smp";     // Catch: Throwable -> L22
        if (r0 == null) goto L21;
        if (r0.isEmpty() == true) goto L21;
        Iterator<ActivityManager.RunningAppProcessInfo> r1 = r0.iterator();     // Catch: Throwable -> L22
    L17:
        if (r1.hasNext() == false) goto L21;
        if (r5.equals(r1.next().processName) == false) goto L17;
        return true;
    L21:
        return false;
    }

    public static boolean isTargetBrandDevice(String r3) {
        String r1 = Build.BRAND;     // Catch: Throwable -> L13
        if (StringUtils.isEmpty(r1) == false) goto L6;
    L7:
        String r2 = Build.MANUFACTURER;     // Catch: Throwable -> L13
        if (StringUtils.isEmpty(r2) == true) goto L16;
        if (r2.toLowerCase().startsWith(r3) == true) goto L12;
        return false;
    L12:
        return true;
    L16:
        return false;
    L6:
        if (r1.toLowerCase().startsWith(r3) == true) goto L12;
    L18:
        return false;
    }

    public static void killAll(Context r3) {
        f.a("kill all");
        List<ActivityManager.RunningAppProcessInfo> r4 = getRunningAppProcesses();
        if (r4 == null) goto L10;
        Iterator<ActivityManager.RunningAppProcessInfo> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        ActivityManager.RunningAppProcessInfo r0 = r5.next();
        if (r0.pid == Process.myPid()) goto L6;
        Process.killProcess(r0.pid);
    L10:
        Process.killProcess(Process.myPid());
    }

    public static String listToString(List<Long> r4) {
        StringBuilder r0 = new StringBuilder();
        if (r4 == null) goto L13;
        if (r4.isEmpty() == true) goto L13;
        int r1 = r4.size();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        r0.append((Long) ListProtector.get(r4, r2));
        if (r2 >= (r1 - 1)) goto L11;
        r0.append(",");
    L11:
        r2 = r2 + 1;
    L13:
        return r0.toString();
    }

    public static String listToStringDivideByComma(List<String> r4) {
        StringBuilder r0 = new StringBuilder();
        if (r4 == null) goto L19;
        if (r4.isEmpty() == true) goto L19;
        Iterator<String> r1 = r4.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        if (TextUtils.isEmpty(r1.next()) == false) goto L8;
        r1.remove();
        goto L8
    L12:
        int r2 = r4.size();
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L19;
        r0.append((String) ListProtector.get(r4, r3));
        if (r3 >= (r2 - 1)) goto L17;
        r0.append(",");
    L17:
        r3 = r3 + 1;
    L19:
        return r0.toString();
    }

    public static void setMessageProcessSuffix(String r0) {
        MESSAGE_PROCESS_SUFFIX = r0;
    }

    public static void setProcessName(String r0) {
        sCurProcessName = r0;
    }

    public static void setPushServiceProcessSuffix(String r0) {
        PUSH_SERVICE_PROCESS_SUFFIX = r0;
    }

    public static List<String> stringDividedByCommaToList(String r5) {
        ArrayList r0 = new ArrayList();
        if (r5 != null) goto L5;
    L22:
        return r0;
    L5:
        if (r5.length() <= 0) goto L22;
        String[] r6 = r5.split(",");     // Catch: Throwable -> L20
        Iterator r1 = new ArrayList(Arrays.asList(r6)).iterator();     // Catch: Throwable -> L20
    L8:
        if (r1.hasNext() == false) goto L12;
        if (TextUtils.isEmpty((String) r1.next()) == false) goto L8;
        r1.remove();     // Catch: Throwable -> L20
        goto L8
    L12:
        int r2 = r6.length;     // Catch: Throwable -> L20
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L22;
        String r4 = r6[r3];     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r4) == true) goto L19;
        if (r0.contains(r4) == true) goto L19;
        r0.add(r4);     // Catch: Throwable -> L20
    L19:
        r3 = r3 + 1;
    L20:
        th = move-exception;
        th.printStackTrace();
        goto L22
    }

    public static List<Long> stringToList(String r5) {
        ArrayList r0 = new ArrayList();
        if (r5 != null) goto L5;
    L20:
        return r0;
    L5:
        if (r5.length() <= 0) goto L20;
        String[] r6 = r5.split(",");     // Catch: Throwable -> L18
        Iterator r1 = new ArrayList(Arrays.asList(r6)).iterator();     // Catch: Throwable -> L18
    L8:
        if (r1.hasNext() == false) goto L12;
        if (TextUtils.isEmpty((String) r1.next()) == false) goto L8;
        r1.remove();     // Catch: Throwable -> L18
        goto L8
    L12:
        int r2 = r6.length;     // Catch: Throwable -> L18
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L20;
        String r4 = r6[r3];     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r4) == true) goto L17;
        r0.add(CastLongProtector.valueOf(r4));     // Catch: Throwable -> L21
    L17:
        r3 = r3 + 1;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public static String toSha256(String r7) {
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");     // Catch: Throwable -> L10
        r0.update(r7.getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L10
        byte[] r1 = r0.digest();     // Catch: Throwable -> L10
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L10
        int r3 = r1.length;     // Catch: Throwable -> L10
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L8;
        String r5 = Integer.toHexString(r1[r4] & UByte.MAX_VALUE);     // Catch: Throwable -> L10
        if (r5.length() != 1) goto L7;
        r2.append('0');     // Catch: Throwable -> L10
    L7:
        r2.append(r5);     // Catch: Throwable -> L10
        r4 = r4 + 1;     // Catch: Throwable -> L10
        goto L3
    L8:
        return r2.toString();
    L10:
        th = move-exception;
        f.e(TAG, "[toMd5]exception:" + th.getLocalizedMessage());
        return r7;
    }

    public static String addUrlParam(String r4, Map<String, String> r5) {
        ArrayList r0 = new ArrayList();
        if (r5 == null) goto L9;
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L9;
        Map.Entry<String, String> r1 = r6.next();
        r0.add(new Pair(r1.getKey(), r1.getValue()));
    L9:
        return addUrlParam(r4, r0);
    }

    private static int com_ss_android_message_util_ToolUtils_android_content_Context_checkSelfPermission(Context r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r11 = new b("auto_cert_com_ss_android_message_util_ToolUtils_android_content_Context_checkSelfPermission");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102608);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(102608, "android/content/Context", "checkSelfPermission", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.checkSelfPermission(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static String com_ss_android_message_util_ToolUtils_android_provider_Settings$Secure_getString(ContentResolver r12, String r13) {
        c r8 = new c();
        Object[] r9 = {r12, r13};
        b r10 = new b();
        d r11 = r8.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, "java.lang.String", r10);
        if (r11.a == false) goto L6;
        r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, null, r10, false);
        return (String) r11.b;
    L6:
        String r14 = Settings.Secure.getString(r12, r13);
        r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, r14, r10, true);
        return r14;
    }

    private static Process com_ss_android_message_util_ToolUtils_java_lang_Runtime_exec(Runtime r12, String r13) {
        c r8 = new c();
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

    public static String getProcessSuffix(Context r1, String r2) {
        if (TextUtils.equals(r2, r1.getPackageName()) == false) goto L6;
        return "main";
    L6:
        if (r2.contains(":") == true) goto L11;
        return "";
    L11:
        return r2.split(":")[1];
    }

    public static List<ActivityManager.RunningTaskInfo> getRunningTasks(ActivityManager r0, int r1) {
        return r0.getRunningTasks(r1);
    }

    public static void getSSIDs(Context r2, Map<String, String> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        String r4 = r2.getSharedPreferences("push_multi_process_config", 4).getString("ssids", "");
        if (StringUtils.isEmpty(r4) == false) goto L7;
        return;
    L7:
        StringUtils.stringToMap(r4, r3);
    }

    public static ApplicationInfo getTargetApplicationInfo(Context r1, String r2) {
        return r1.getPackageManager().getApplicationInfo(r2, 0);
    L4:
        return null;
    }

    public static boolean isApplicationForeground(Context r3, String r4) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r4) == true) goto L27;
        ActivityManager r5 = (ActivityManager) r3.getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> r6 = getRunningAppProcesses();
        if (r6 != null) goto L10;
        return false;
    L10:
        if (r6.isEmpty() == true) goto L25;
        Iterator<ActivityManager.RunningAppProcessInfo> r7 = r6.iterator();
    L13:
        if (r7.hasNext() == false) goto L28;
        ActivityManager.RunningAppProcessInfo r1 = r7.next();
        if (r4.equals(r1.processName) == false) goto L13;
        if (r1.importance != 100) goto L26;
        return true;
    L26:
        return false;
    L28:
        return false;
    L25:
        return false;
    L27:
        return false;
    }

    public static boolean isInstalledApp(Context r2, Intent r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        List<ResolveInfo> r4 = r2.getPackageManager().queryIntentActivities(r3, 65536);
        if (r4 != null) goto L8;
    L11:
        return false;
    L8:
        if (r4.size() <= 0) goto L11;
        return true;
    }

    public static boolean parseBool(String r2, boolean r3) {
        if (TextUtils.isEmpty(r2) == false) goto L9;
    L8:
        return r3;
    L9:
        return Boolean.parseBoolean(r2);
    L6:
        th = move-exception;
        f.f(TAG, "[parseBool] ", th);
        goto L8
    }

    public static int parseInt(String r2, int r3) {
        if (TextUtils.isEmpty(r2) == false) goto L9;
    L8:
        return r3;
    L9:
        return CastIntegerProtector.parseInt(r2);
    L6:
        th = move-exception;
        f.f(TAG, "[parseLong] ", th);
        goto L8
    }

    public static long parseLong(String r2, long r3) {
        if (TextUtils.isEmpty(r2) == false) goto L9;
    L8:
        return r3;
    L9:
        return CastLongProtector.parseLong(r2);
    L6:
        th = move-exception;
        f.f(TAG, "[parseLong] ", th);
        goto L8
    }

    public static String addUrlParam(String r2, List<Pair<String, String>> r3) {
        StringBuilder r0 = new StringBuilder(r2);
        if (r2.indexOf(63) >= 0) goto L5;
        r0.append("?");
    L6:
        r0.append(NetworkUtils.format(r3, EffectRequest.DEFAULT_PARAMS_ENCODING));
        return r0.toString();
    L5:
        r0.append("&");
        goto L6
    }

    public static boolean isInstalledApp(Context r2, String r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r3) == false) goto L12;
        return false;
    L12:
        if (r2.getPackageManager().getPackageInfo(r3, 0) != null) goto L10;
        return false;
    L10:
        return true;
    L17:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_message_util_ToolUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r2, boolean r3, ClassLoader r4) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r5 = access$000(r2, r3, r4);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L8
    L7:
        return r5;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r2);
    L12:
        throw th;
    L34:
        Class r6 = access$000(r2, r3, r4);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L17
    L16:
        return r6;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r2);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r2);
    }

    public static boolean isServiceRunning(Context r3, String r4, String r5) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r4) == false) goto L7;
        return false;
    L7:
        if (StringUtils.isEmpty(r5) == true) goto L35;
        List<ActivityManager.RunningServiceInfo> r6 = ((ActivityManager) r3.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);     // Catch: Throwable -> L22
        if (r6 != null) goto L12;
        return false;
    L12:
        if (r6.size() <= 0) goto L34;
        Iterator<ActivityManager.RunningServiceInfo> r7 = r6.iterator();     // Catch: Throwable -> L22
    L15:
        if (r7.hasNext() == false) goto L37;
        ActivityManager.RunningServiceInfo r1 = r7.next();     // Catch: Throwable -> L22
        if (r4.equals(r1.service.getPackageName()) == false) goto L15;
        if (r5.equals(r1.service.getClassName()) == false) goto L15;
        return true;
    L37:
        return false;
    L34:
        return false;
    L36:
        return false;
    L35:
        return false;
    }

    public static void setComponentEnable(Context r4, String r5, boolean r6) {
        ComponentName r2 = new ComponentName(r4.getPackageName(), r5);
        PackageManager r7 = r4.getPackageManager();
        f.g("", "set " + r5 + " enable to " + r6);     // Catch: Throwable -> L9
        if (r6 == false) goto L6;
        int r3 = 1;
    L7:
        r7.setComponentEnabledSetting(r2, r3, 1);     // Catch: Throwable -> L9
        return;
    L6:
        r3 = 2;
    L9:
        th = move-exception;
        f.d("error to set " + r5 + " enable to " + r6);
        th.printStackTrace();
    }
}
