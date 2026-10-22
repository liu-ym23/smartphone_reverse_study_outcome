package com.obric.assistant.feedback.upload;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonObject;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.feedback.upload.bean.ReportUploadTask;
import com.obric.capabilitykit.common.UiType;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ReportUploadWorker {
    public static final /* synthetic */ int c = 0;
    public final Context a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static String c() {
        Method r2 = a().getDeclaredMethod("get", new Class[]{String.class});     // Catch: Exception -> L5
        r2.setAccessible(true);     // Catch: Exception -> L5
        Object r0 = r2.invoke(null, new Object[]{"ro.os.ota.version"});     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L5
        return (String) r0;
    L5:
        e = move-exception;
        FLogger.a.e("ReportUploadWorker", "getProperty failed!", e);
        return null;
    }

    public ReportUploadWorker(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v61 */
    /* JADX WARN: Type inference failed for: r8v63, types: [com.obric.assistant.feedback.upload.IReportUploadNetworkService] */
    public final Object d(ReportUploadTask r32, Continuation<? super Boolean> r33) {
        ReportUploadTask r0 = r32;
        if ((r33 instanceof ReportUploadWorker$upload$1) == false) goto L7;
        ReportUploadWorker$upload$1 r2 = (ReportUploadWorker$upload$1) r33;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        ReportUploadWorker$upload$1 r6 = r2;
        Object r1 = r6.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r6.label;
        int r13 = 0;
        String r11 = "";
        if (r4 != 0) goto L173;
        ResultKt.throwOnFailure(r1);
        FLogger r5 = FLogger.a;
        r5.i("ReportUploadWorker", "upload start");
        r5.i("ReportUploadWorker", "upload main report start");
        JsonObject r7 = new JsonObject();
        r7.addProperty("report_tag", "功能异常");
        r7.addProperty("report_from", "用户反馈");
        r7.addProperty("createtime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(r0.g));
        String r8 = "豆包手机助手";
        r7.addProperty("label_lv1", "豆包手机助手");
        ReportUploadTask.Status r9 = r0.c;
        if (r9 == null) goto L30;
        String r10 = r9.getDescription();
        if (r10 == null) goto L30;
        r8 = r10;
    L30:
        r7.addProperty("label_lv2", r8);
        String r12 = r0.a;
        if (r12 != null) goto L33;
    L36:
        boolean r14 = true;
    L37:
        if (r14 == false) goto L41;
        String r16 = r0.d;
        if (r16 != null) goto L46;
        r16 = "";
    L46:
        r7.addProperty("description", r16);
        JsonObject r17 = new JsonObject();
        r17.addProperty("softwareVersion", c());
        r17.addProperty("type", Build.TYPE);
        r17.addProperty("fingerprint", Build.FINGERPRINT);
        r17.addProperty("cpuAbi", Build.CPU_ABI);
        r17.addProperty("cpuAbi2", Build.CPU_ABI2);
        r17.addProperty("version_sdk_int", String.valueOf(Build.VERSION.SDK_INT));
        JsonObject r18 = new JsonObject();
        r18.addProperty("product", "obric");
        r18.addProperty("model", t9a.b.b().b().getDeviceModel());
        r18.addProperty("board", Build.BOARD);
        r18.addProperty("brand", t9a.b.b().b().getDeviceBrand());
        r18.addProperty("telephony_device_id", "");
        IApplog.Companion r19 = IApplog.a;
        r18.addProperty("local_device_id", r19.getDeviceId());
        r18.addProperty("serial", "");
        r18.addProperty("udid", r19.e());
        r18.addProperty("uid", r19.getUserID());
        Object r20 = this.a.getSystemService("wifi");
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        WifiManager r21 = (WifiManager) r20;
        ArrayList r22 = new ArrayList();
        Object[] r23 = new Object[0];
        f06.b r24 = new f06.b();
        g06.a r25 = (g06.a) ApiHookConfig.b.get(102301);
        if (r25 == null) goto L49;
        f06.a[] r26 = r25.i;
    L50:
        int r110 = r26.length;
        String r111 = "ReportUploadWorker";
    L52:
        if (r13 >= r110) goto L63;
        String r28 = r111;
        f06.a r112 = r26[r13];
        f06.a[] r29 = r26;
        f06.d r27 = r112.preInvoke(102301, "android/net/wifi/WifiManager", "getConnectionInfo", r21, r23, "android.net.wifi.WifiInfo", r24);     // Catch: Exception -> L61
        Object[] r113 = r23;
        if (r27.a == true) goto L58;
        r22.add(r112);     // Catch: Exception -> L161
        goto L62
    L58:
        String r210 = r28;
    L65:
        if (r27.a == false) goto L67;
        WifiInfo r30 = (WifiInfo) r27.b;
    L68:
        if (r30 == null) goto L73;
        f06.c r31 = new f06.c();
        Object[] r34 = new Object[0];
        f06.b r35 = new f06.b();
        f06.d r114 = r31.b(101700, "android/net/wifi/WifiInfo", "getMacAddress", r30, r34, "java.lang.String", r35);
        if (r114.a == false) goto L72;
        r31.a(101700, "android/net/wifi/WifiInfo", "getMacAddress", r30, r34, null, r35, false);
        String r36 = (String) r114.b;
    L74:
        r18.addProperty("wifi_mac", r36);
        JsonObject r37 = new JsonObject();
        AppHost.Companion r38 = AppHost.a;
        String r39 = r38.getApplication().getPackageName();
        r37.addProperty("package_name", r39);
        if (TextUtils.isEmpty(r39) == false) goto L77;
    L79:
        JsonObject r40 = new JsonObject();
        r40.addProperty("app_name", r38.getApplication().getPackageName());
        r40.addProperty("app_version", r38.getVersionName());
        r7.add("systeminfo", r17);
        r7.add("deviceinfo", r18);
        r7.add("processinfo", r37);
        r7.add("appinfo", r40);
        LinkedHashMap r41 = new LinkedHashMap();
        r41.put("aid", Integer.valueOf(r38.getAppId()));
        r41.put("ctw", 86400);
        AccountService r42 = AccountService.a;
        r41.put("autuid", r42.getUserId());
        com.privacy.azerothprivacy.userAuthToken.c.c().getClass();
        String r43 = com.privacy.azerothprivacy.userAuthToken.c.b(1801, r41);
        if (r43 != null) goto L82;
        r43 = "";
    L82:
        r7.addProperty("trace_token", r43);
        JsonObject r44 = new JsonObject();
        r44.add("data", r7);
        ?? r45 = (IReportUploadNetworkService) this.b.getValue();     // Catch: Exception -> L157
        String r46 = r42.getXTTToken();     // Catch: Exception -> L157
        r6.L$0 = r0;     // Catch: Exception -> L157
        r6.label = 1;     // Catch: Exception -> L157
        String r47 = r210;
        boolean r48 = false;
        boolean r115 = true;
        Object r49 = r45.uploadReport("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTIwOTkxMzEsIm5iZiI6MTU5MjA5OTEzMSwianRpIjoiODI0MGM1ZTktMDJjNS00NWU0LTk2YTUtYjc2YmZmZTcxYjljIiwiZXhwIjo0NzQ1Njk5MTMxLCJpZGVudGl0eSI6InN0b25lX2ZlZWRiYWNrX2FwcCIsImZyZXNoIjpmYWxzZSwidHlwZSI6ImFjY2VzcyJ9.E0y5gIm89ykDX0CLMI2SMvb1o-veARcLG4i8DX2qlUw", "application/json", r46, 1, r44, r6);     // Catch: Exception -> L154
        String r50 = r47;
        ?? r116 = "application/json";
        if (r49 != r15) goto L88;
        return r15;
    L88:
        JsonObject r51 = (JsonObject) r49;     // Catch: Exception -> L154
        if (r51 == null) goto L151;
        if (r51.toString().length() != 0) goto L93;
        boolean r117 = true;
    L94:
        if (r117 == true) goto L151;
        if (r51.size() == 0) goto L151;
        FLogger r52 = FLogger.a;     // Catch: Exception -> L154
        r52.d(r50, "upload report, response = " + r51);     // Catch: Exception -> L154
        if (r51.get("code").getAsInt() != 0) goto L149;
        String r53 = r51.get("data").getAsJsonObject().get("report_id").getAsString();     // Catch: Exception -> L154
        r52.i(r50, "upload report success, reportId = " + r53);     // Catch: Exception -> L154
        r6.L$0 = r0;     // Catch: Exception -> L154
        r6.L$1 = r53;     // Catch: Exception -> L154
        r6.label = 2;     // Catch: Exception -> L154
        if (e(r53, r6) != r15) goto L103;
        return r15;
    L103:
        String r54 = r53;
        int r55 = r48;
        r47 = r50;
    L104:
        FLogger r56 = FLogger.a;     // Catch: Exception -> L154
        r56.i(r47, "upload report ext, reportId = " + r54);     // Catch: Exception -> L154
        if (r0.e == false) goto L144;
        r56.i(r47, "task.haveExtraData is true");
        Result.Companion r57 = Result.Companion;     // Catch: Throwable -> L119
        r56.i(r47, "createZipFile start");     // Catch: Throwable -> L119
        List<String> r58 = r0.f;     // Catch: Throwable -> L119
        if (r58 == null) goto L112;
        Collection r59 = CollectionsKt.toMutableList(r58);     // Catch: Throwable -> L119
        if (r59 == null) goto L112;
    L113:
        String r118 = bea.a.e(this.a, (String[]) r59.toArray(new String[r55]));     // Catch: Throwable -> L119
        if (new PolarisFileWrapper(r118).exists() == true) goto L117;
        r118 = r11;
    L117:
        Object r60 = Result.constructor-impl(r118);     // Catch: Throwable -> L119
    L121:
        Object r119 = r60;
        Throwable r61 = Result.exceptionOrNull-impl(r119);
        if (r61 == null) goto L125;
        FLogger.a.e(r47, "compressLogFiles failed: " + r61);
        r119 = r11;
    L125:
        String r120 = (String) r119;
        if (r120.length() != 0) goto L128;
        boolean r121 = true;
    L129:
        if (r121 == false) goto L132;
        FLogger.a.e(r47, "createZipFile error!");
        return Boxing.boxBoolean(r55);
    L132:
        PolarisFileWrapper r62 = new PolarisFileWrapper(r120);
        if (r62.exists() == true) goto L136;
        FLogger.a.e(r47, "createZipFile error! zipFile is not exist!");
        return Boxing.boxBoolean(r55);
    L136:
        FLogger.a.i(r47, "upload file start");
        List<String> r63 = CollectionsKt.listOf(r120);
        r6.L$0 = r62;
        r6.L$1 = null;
        r6.label = 3;
        boolean r122 = false;
        String r64 = r47;
        r1 = f(r54, "0", "logs", r63, r6);
        if (r1 != r15) goto L140;
        return r15;
    L140:
        if (((Boolean) r1).booleanValue() == true) goto L143;
        FLogger.a.e(r64, "upload file error");
        r62.delete();
        return Boxing.boxBoolean(r122);
    L143:
        Boxing.boxBoolean(r62.delete());
    L146:
        return Boxing.boxBoolean(r115);
    L128:
        r121 = false;
    L112:
        r59 = new ArrayList();     // Catch: Throwable -> L119
    L119:
        th = move-exception;
        Result.Companion r65 = Result.Companion;
        r60 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L121
    L144:
        r56.i(r47, "task.haveExtraData is false");
        goto L146
    L149:
        return Boxing.boxBoolean(false);
    L93:
        r117 = false;
    L151:
        return Boxing.boxBoolean(false);
    L152:
        e = e;
    L159:
        FLogger.a.e(r45, "upload report failed", e);
        return Boxing.boxBoolean(r116);
    L154:
        e = e;
        r45 = r47;
    L156:
        r116 = 0;
    L157:
        e = e;
        r45 = r210;
        goto L156
    L77:
        if (Intrinsics.areEqual("UNKNOWN", r39) == true) goto L79;
        r37.addProperty("package_version", r38.getVersionName());
        goto L79
    L72:
        String r123 = r30.getMacAddress();
        r31.a(101700, "android/net/wifi/WifiInfo", "getMacAddress", r30, r34, r123, r35, true);
        r36 = r123;
        goto L74
    L73:
        r36 = "wifiMacAddress";
        goto L74
    L67:
        r30 = r21.getConnectionInfo();
    L62:
        r13 = r13 + 1;
        r23 = r113;
        r111 = r28;
        r26 = r29;
    L61:
        r113 = r23;
        goto L62
    L63:
        r210 = r111;
        r27 = new f06.d(false, null);
        goto L65
    L49:
        r26 = ApiHookConfig.d;
        goto L50
    L41:
        StringBuilder r66 = new StringBuilder("【sId】\n");
        r66.append(r0.a + '\n');
        r66.append("【任务名】\n");
        r66.append(r0.b + '\n');
        r66.append("【任务状态】\n");
        StringBuilder r67 = new StringBuilder();
        ReportUploadTask.Status r68 = r0.c;
        if (r68 == null) goto L44;
        String r69 = r68.getDescription();
    L45:
        r67.append(r69);
        r67.append('\n');
        r66.append(r67.toString());
        r66.append("【反馈信息】\n");
        r66.append(r0.d);
        r16 = r66.toString();
        goto L46
    L44:
        r69 = null;
        goto L45
    L33:
        if (r12.length() == 0) goto L36;
        r14 = false;
        goto L37
    L173:
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        r62 = (File) r6.L$0;
        ResultKt.throwOnFailure(r1);
        r64 = "ReportUploadWorker";
        r122 = false;
        r115 = true;
        goto L140
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r70 = (String) r6.L$1;
        ReportUploadTask r71 = (ReportUploadTask) r6.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Exception -> L22
        r47 = "ReportUploadWorker";
        r11 = "";
        r55 = 0;
        r115 = true;
        r54 = r70;
        r0 = r71;
        goto L104
    L19:
        r0 = (ReportUploadTask) r6.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Exception -> L22
        r49 = r1;
        r50 = "ReportUploadWorker";
        r48 = false;
        r115 = true;
        r116 = "ReportUploadWorker";
    L22:
        e = e;
        r45 = "ReportUploadWorker";
    L7:
        r2 = new ReportUploadWorker$upload$1(this, r33);
        goto L8
    }

    public final Object e(String r17, Continuation<? super Boolean> r18) {
        if ((r18 instanceof ReportUploadWorker$uploadExt$1) == false) goto L7;
        ReportUploadWorker$uploadExt$1 r2 = (ReportUploadWorker$uploadExt$1) r18;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
        boolean r6 = true;
    L18:
        return Boxing.boxBoolean(TextUtils.isEmpty((String) r1) ^ r6);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        StringBuilder r7 = new StringBuilder();
        r7.append("【softwareVersion】:" + c() + '\n');
        r7.append("【type】:" + Build.TYPE + '\n');
        r7.append("【fingerprint】:" + Build.FINGERPRINT + '\n');
        r7.append("【cpuAbi】:" + Build.CPU_ABI + '\n');
        r7.append("【cpuAbi2】:" + Build.CPU_ABI2 + '\n');
        r7.append("【version_sdk_int】:" + Build.VERSION.SDK_INT + '\n');
        r7.append("【product】:obric\n");
        r7.append("【model】:" + Build.MODEL + '\n');
        r7.append("【board】:" + Build.BOARD + '\n');
        StringBuilder r8 = new StringBuilder("【brand】:");
        String r9 = Build.BRAND;
        r8.append(r9);
        r8.append('\n');
        r7.append(r8.toString());
        r7.append("【imei】:\n");
        StringBuilder r10 = new StringBuilder("【did】:");
        IApplog.Companion r11 = IApplog.a;
        r10.append(r11.getDeviceId());
        r10.append('\n');
        r7.append(r10.toString());
        r7.append("【serial】:\n");
        r7.append("【udid】:" + r11.e() + '\n');
        r7.append("【uid】:" + r11.getUserID() + '\n');
        AppHost.Companion r12 = AppHost.a;
        Object r13 = r12.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager.MemoryInfo r14 = new ActivityManager.MemoryInfo();
        ((ActivityManager) r13).getMemoryInfo(r14);
        r7.append("【avail_mem】:" + (r14.availMem / ((long) UiType.FLAG_APP_CHOOSER_CARD)) + '\n');
        r7.append("【wifi_mac】:\n");
        r7.append("【brand】:" + r9 + '\n');
        r7.append("【imei】:\n");
        r7.append("【did】:" + r11.getDeviceId() + '\n');
        r7.append("【app_name】:" + r12.getApplication().getPackageName() + '\n');
        r7.append("【app_version】:" + r12.getVersionName() + '\n');
        String r15 = r7.toString();
        r6 = true;
        r2.label = 1;
        r1 = g(r17, r15, r2);
        if (r1 != r4) goto L18;
        return r4;
    L7:
        r2 = new ReportUploadWorker$uploadExt$1(this, r18);
        goto L8
    }

    public final Object g(String r7, String r8, Continuation<? super String> r9) {
        if ((r9 instanceof ReportUploadWorker$uploadText$1) == false) goto L7;
        ReportUploadWorker$uploadText$1 r1 = (ReportUploadWorker$uploadText$1) r9;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r10 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r5 = true;
        if (r4 == 0) goto L15;
        if (r4 != 1) goto L14;
        ResultKt.throwOnFailure(r10);     // Catch: IOException -> L32
    L19:
        JsonObject r11 = (JsonObject) r10;     // Catch: IOException -> L32
        if (r11 != null) goto L22;
        return null;
    L22:
        if (r11.toString().length() > 0) goto L25;
        r5 = false;
    L25:
        if (r5 == true) goto L27;
        return null;
    L27:
        if (r11.size() <= 0) goto L40;
        FLogger.a.d("ReportUploadWorker", "uploadText, response = " + r11);     // Catch: IOException -> L32
        if (r11.get("code").getAsInt() != 0) goto L41;
        return r11.get("data").getAsJsonObject().get("chat_id").getAsString();
    L41:
        return null;
    L40:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r10);
        JsonObject r12 = new JsonObject();
        r12.addProperty("report_id", r7);
        r12.addProperty("description", r8);
        IReportUploadNetworkService r13 = (IReportUploadNetworkService) this.b.getValue();     // Catch: IOException -> L32
        r1.label = 1;     // Catch: IOException -> L32
        r10 = r13.appendText("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTIwOTkxMzEsIm5iZiI6MTU5MjA5OTEzMSwianRpIjoiODI0MGM1ZTktMDJjNS00NWU0LTk2YTUtYjc2YmZmZTcxYjljIiwiZXhwIjo0NzQ1Njk5MTMxLCJpZGVudGl0eSI6InN0b25lX2ZlZWRiYWNrX2FwcCIsImZyZXNoIjpmYWxzZSwidHlwZSI6ImFjY2VzcyJ9.E0y5gIm89ykDX0CLMI2SMvb1o-veARcLG4i8DX2qlUw", "application/json", r12, r1);     // Catch: IOException -> L32
        if (r10 != r3) goto L19;
        return r3;
    L32:
        e = move-exception;
        FLogger.a.e("ReportUploadWorker", ExceptionsKt.stackTraceToString(e));
        return null;
    L7:
        r1 = new ReportUploadWorker$uploadText$1(this, r9);
        goto L8
    }

    public static k b(String r7, String r8, String r9, List r10) {
        k.a r1 = new k.a();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L24;
        String r2 = (String) r11.next();
        PolarisFileWrapper r3 = new PolarisFileWrapper(r2);
        if (r3.exists() == true) goto L22;
        r3.createNewFile();     // Catch: IOException -> L9
    L9:
        FLogger.a.e("ReportUploadWorker", "File don't exist. file = " + r2);
    L22:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L12
        r1.b("File", r3.getName(), RequestBody.create(MediaType.get("application/otcet-stream"), r3));     // Catch: Throwable -> L12
        Result.constructor-impl(r1);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L4
    L24:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L16
        r1.b("report_id", null, RequestBody.create(MediaType.get("text/plain"), r7));     // Catch: Throwable -> L16
        r1.b("chat_id", null, RequestBody.create(MediaType.get("text/plain"), r8));     // Catch: Throwable -> L16
        r1.b("file_type", null, RequestBody.create(MediaType.get("text/plain"), r9));     // Catch: Throwable -> L16
        Result.constructor-impl(r1);     // Catch: Throwable -> L16
    L18:
        r1.e(k.f);
        return r1.d();
    L16:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public final Object f(String r8, String r9, String r10, List<String> r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof ReportUploadWorker$uploadFiles$1) == false) goto L7;
        ReportUploadWorker$uploadFiles$1 r1 = (ReportUploadWorker$uploadFiles$1) r12;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r13 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r6 = true;
        if (r4 == 0) goto L15;
        if (r4 != 1) goto L14;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L32
    L22:
        JsonObject r14 = (JsonObject) r13;     // Catch: Exception -> L32
        FLogger.a.d("ReportUploadWorker", "uploadFile result = " + r14);     // Catch: Exception -> L32
        if (r14 != null) goto L25;
    L29:
        r6 = false;
    L30:
        return Boxing.boxBoolean(r6);
    L25:
        if (r14.isJsonObject() == false) goto L29;
        if (r14.get("code").getAsInt() != 0) goto L29;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r13);
        if (r11.isEmpty() == true) goto L18;
        k r15 = b(r8, r9, r10, r11);     // Catch: Exception -> L32
        IReportUploadNetworkService r16 = (IReportUploadNetworkService) this.b.getValue();     // Catch: Exception -> L32
        r1.label = 1;     // Catch: Exception -> L32
        r13 = r16.uploadFile("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTIwOTkxMzEsIm5iZiI6MTU5MjA5OTEzMSwianRpIjoiODI0MGM1ZTktMDJjNS00NWU0LTk2YTUtYjc2YmZmZTcxYjljIiwiZXhwIjo0NzQ1Njk5MTMxLCJpZGVudGl0eSI6InN0b25lX2ZlZWRiYWNrX2FwcCIsImZyZXNoIjpmYWxzZSwidHlwZSI6ImFjY2VzcyJ9.E0y5gIm89ykDX0CLMI2SMvb1o-veARcLG4i8DX2qlUw", r15, r1);     // Catch: Exception -> L32
        if (r13 != r3) goto L22;
        return r3;
    L18:
        return Boxing.boxBoolean(true);
    L32:
        e = move-exception;
        FLogger.a.e("ReportUploadWorker", "uploadFile exception = " + ExceptionsKt.stackTraceToString(e));
        return Boxing.boxBoolean(false);
    L7:
        r1 = new ReportUploadWorker$uploadFiles$1(this, r12);
        goto L8
    }
}
