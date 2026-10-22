package com.ss.android.lark.framework.assembly.rust;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.lark.pb.basic.v1.DeprecatedConfig;
import com.bytedance.lark.pb.basic.v1.InitLogUpload;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.pb.basic.v1.KaInitConfig;
import com.bytedance.lark.pb.basic.v1.ProxyConfig;
import com.bytedance.lark.pb.basic.v1.ProxyScheme;
import com.bytedance.lark.pb.basic.v1.ProxyType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.component.appcontext.ILarkAppContext;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.component.appcontext.model.LarkBuildConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.init.ThreadLimitConfig;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.suite.lark.component.protocol.Biz;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static InitSDKRequest.Builder a(Context r25, int r26, String r27, String r28, String r29, String r30, List r31, String r32, int r33, int r34, go2.g r35) {
        Intrinsics.checkNotNullParameter(r25, "context");
        Intrinsics.checkNotNullParameter(r27, "languageLocalTag");
        Intrinsics.checkNotNullParameter(r28, "userAgent");
        Intrinsics.checkNotNullParameter(r29, "dbPath");
        Intrinsics.checkNotNullParameter(r30, "journalDirPath");
        Intrinsics.checkNotNullParameter(r31, "stabilityLogDirs");
        Intrinsics.checkNotNullParameter(r32, "logDirPath");
        ILarkAppContext r7 = LarkAppContext.inst();
        String r8 = String.valueOf(r7.appIdInfo().a);
        boolean r9 = !r7.buildConfig().isDebug();
        String r10 = ApkUtil.getAppVersionName(r25);
        gpb.a r11 = (gpb.a) ApiUtils.getApi(gpb.a.class);
        InitSDKRequest.EnvV2 r12 = new InitSDKRequest.EnvV2.Builder().type(InitSDKRequest.EnvV2.Type.fromValue(r11.envType())).unit(r11.getUserUnit()).brand(r11.getTenantBrand()).build();
        HashMap r13 = new HashMap();
        if (LarkAppContext.inst().buildConfig().isMempopeApp() == false) goto L5;
        r13.put("AppName", LarkAppContext.inst().buildConfig().getAppName().getCamelCaseName());
    L5:
        r13.put("device_brand", Build.BRAND);
        InitSDKRequest.Builder r14 = new InitSDKRequest.Builder().app_id(r8).env_v2(r12).is_release(Boolean.valueOf(r9)).version(r10).os_version(Build.VERSION.RELEASE).device_model(Build.MODEL).customized_init_meta(r13).init_config_path(jcb.b.c().f0()).local_timezone(TimeZone.getDefault().getID()).tags(Collections.singletonList("Android_onRustSDK")).settings_queries(f3c.a.a());
        InitSDKRequest.EnvType r15 = InitSDKRequest.EnvType.fromValue(r26);
        InitLogUpload.Builder r16 = new InitLogUpload.Builder();
        r16.log_path(r32);
        Boolean r6 = Boolean.TRUE;
        r16.enable_stream_upload(r6);
        Log.i("RustSDK", "initSdk env =  " + r15.name());
        InitSDKRequest.Builder r1 = r14.storage_path(r29).env(r15).data_synchronism_strategy(InitSDKRequest.DataSynchronismStrategy.SUBSCRIBE).locale_identifier(r27).user_agent(r28).enable_thread(r6).preload_config(new InitSDKRequest.PreloadConfig.Builder().preload_chat_chatter_count(Integer.valueOf(r34)).build()).client_log_storage_path(r30);
        Boolean r2 = Boolean.FALSE;
        r1.use_deprecated_push_msg(r2).client_stability_log_dirs(r31).init_log_upload(r16.build()).deprecated_config(new DeprecatedConfig.Builder().use_deprecated_user_lst(r2).build()).package_id(InitSDKRequest.PackageId.fromValue(r33)).main_thread_id(Long.valueOf(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getId()));
        ThreadLimitConfig r3 = f3c.b.a;
        long r4 = SystemClock.elapsedRealtime();
        if (f3c.b.a != null) goto L8;
        f3c.b.a = (ThreadLimitConfig) SettingManager.getInstance().get(ThreadLimitConfig.class);
    L8:
        Log.d("SDKThreadConfig", "getThreadLimitConfig cost = " + (SystemClock.elapsedRealtime() - r4));
        ThreadLimitConfig r5 = f3c.b.a;
        if (r5 != null) goto L11;
        r5 = new ThreadLimitConfig(0, 0, 0, 0.0d, 0, 0, 0, 0, false, 511, null);
    L11:
        int r17 = Math.max(r5.getThreadCoreSize(), Runtime.getRuntime().availableProcessors() / 2);
        int r18 = z.a;
        y r19 = z.a.a();
        if (r19 == null) goto L14;
        r17 = r17 + r19.a();
    L14:
        r14.thread_priority(Integer.valueOf(r5.getThreadPriority())).expected_thread(Integer.valueOf(r17));
        r14.worker_create_duration(Long.valueOf(r5.getThreadCreateDuration())).per_worker_spawn_threshold(Double.valueOf(r5.getThreadSpawnThreshold())).epoch_step_count(Integer.valueOf(r5.getThreadEpochStepCount())).worker_release_duration(Long.valueOf(r5.getWorkerReleaseDuration()));
        int r20 = i3c.b.b;
        DevicePerfUtils.DevicePerfLevel r21 = DevicePerfUtils.d();
        if (r21.ordinal() < DevicePerfUtils.DevicePerfLevel.LOW.ordinal()) goto L18;
        InitSDKRequest.DevicePerfLevel r22 = InitSDKRequest.DevicePerfLevel.DEVICE_LOW;
    L24:
        r14.device_perf_level(r22);
        InitSDKRequest.ThreadPoolMonitorSetting.Builder r23 = new InitSDKRequest.ThreadPoolMonitorSetting.Builder();
        r23.event_monitor = Boolean.valueOf(r5.getPerformanceMonitor());
        r23.waiting_time_threshold = Integer.valueOf(r5.getThreadWaitingTimeThreshold());
        y r24 = z.a.a();
        if (r24 == null) goto L27;
        int r36 = r24.b();
    L28:
        InitSDKRequest.NetSemaphoreMonitorSetting.Builder r37 = new InitSDKRequest.NetSemaphoreMonitorSetting.Builder();
        r37.event_monitor = Boolean.valueOf(r5.getPerformanceMonitor());
        r37.semaphore_count = Integer.valueOf(r36);
        r37.waiting_time_threshold = Integer.valueOf(r5.getNetWaitingTimeThreshold());
        r14.thread_pool_monitor_setting(r23.build());
        r14.net_semaphore_monitor_setting(r37.build());
        Log.i("RustSDK", "rust throughput ab test config: " + z.a.a());
        Log.i("RustSDK", "init rust in RustSdk with thread config:" + r5);
        InitSDKRequest.ClientABExperiment.Builder r38 = new InitSDKRequest.ClientABExperiment.Builder();
        List r39 = d3c.a.a;
        com.ss.android.lark.storage.kv.repo.a r40 = LarkKVStorage.h(new com.ss.android.lark.storage.a("Performance"), false);     // Catch: Exception -> L31
        CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new d3c.b(r40), 1500, TimeUnit.MILLISECONDS);     // Catch: Exception -> L31
        boolean r41 = r40.getBoolean("enableFeedOptimize", true);     // Catch: Exception -> L31
    L32:
        r38.enable_delay_load_more_feeds = Boolean.valueOf(r41);
        r14.client_ab_experiment(r38.build());
        ((c) e0c.k.a(LarkContext.getApplication(), c.class)).interceptRustInitRequest(r14);
        if (PackageChannelManager.isKABuildPackage(r25) == false) goto L44;
        KaInitConfig.Builder r42 = new KaInitConfig.Builder();
        r42.channel(PackageChannelManager.getBuildPackageChannel(r25));
        if (PackageChannelManager.isKABuildPackage(r25) == true) goto L37;
    L39:
        boolean r43 = false;
    L40:
        r42.is_customized_ka(Boolean.valueOf(r43));
        if (r43 == false) goto L43;
        r42.ka_init_config_path(jcb.b.c().f0());
    L43:
        r14.ka_init_config(r42.build());
        goto L44
    L37:
        if (PackageChannelManager.getDeployMode(r25) == 1) goto L39;
        r43 = true;
    L44:
        r14.app_channel(PackageChannelManager.getBuildPackageChannel(r25));
        boolean r44 = !LarkKVStorage.j(Biz.Common, false).getBoolean("http_proxy_disable", false);
    L48:
        if (r44 == false) goto L104;
        Intrinsics.checkNotNullParameter(r25, "context");
        LarkAppContext.Companion.getClass();
        LarkBuildConfig r45 = LarkAppContext.access$getInstance$cp().buildConfig();
        if (r45.isOfficeSDK() == true) goto L52;
    L54:
        boolean r46 = false;
    L55:
        Integer r47 = null;
        if (r46 == true) goto L81;
        com.ss.android.lark.storage.kv.repo.a r48 = LarkKVStorage.j(Biz.Common, false);
        if (r48.contains("proxy_type") == false) goto L62;
        int r49 = r48.getInt("proxy_type", 0);
    L83:
        Log.i("RustSDK", "initSdk getProxyType = " + r49);
        if (r49 != 1) goto L86;
        Log.i("RustSDK", "initSdk getProxyType = TYPE_SYSTEM_PROXY");
        r14.proxy_config(new ProxyConfig.Builder().proxy_type(ProxyType.Automatic).build());
    L86:
        if (r49 != 2) goto L101;
        Intrinsics.checkNotNullParameter(r25, "context");
        String r0 = LarkKVStorage.j(Biz.Common, false).getString("http_proxy_config", null);
        if (r0 != null) goto L90;
        HttpProxyConfig r50 = null;
    L91:
        StringBuilder r51 = new StringBuilder("initSdk getProxyType = TYPE_HTTP_PROXY, address=");
        if (r50 == null) goto L94;
        String r52 = r50.getServerAddress();
    L95:
        r51.append(r52);
        r51.append(", port=");
        if (r50 == null) goto L98;
        r47 = Integer.valueOf(r50.getPort());
    L98:
        r51.append(r47);
        Log.i("RustSDK", r51.toString());
        if (r50 == null) goto L101;
        r14.proxy_config(new ProxyConfig.Builder().proxy_type(ProxyType.Specify).proxy_scheme(new ProxyScheme.Builder().host(r50.getServerAddress()).port(Integer.valueOf(r50.getPort())).username(r50.getUserName()).password(r50.getPassword()).build()).build());
        goto L101
    L94:
        r52 = null;
        goto L95
    L90:
        r50 = (HttpProxyConfig) GsonProtectorUtils.fromJson(new Gson(), r0, HttpProxyConfig.class);
    L101:
        se6.k r53 = se6.k.a;
        monitor-enter(r53);
        monitor-exit(r53);
        goto L104
    L62:
        if (r45.isDebug() == true) goto L106;
    L82:
        r49 = 0;
        goto L83
    L106:
        String r54 = System.getProperty("http.proxyHost");     // Catch: Exception -> L78
        String r55 = System.getProperty("http.proxyPort");     // Catch: Exception -> L78
        if (r55 == null) goto L66;
        Integer r56 = StringsKt.toIntOrNull(r55);     // Catch: Exception -> L78
    L67:
        if (r54 != null) goto L69;
    L72:
        boolean r57 = true;
    L73:
        if (r57 == true) goto L79;
        if (r56 == null) goto L79;
        if (new IntRange(1, 65535).contains(r56.intValue()) == false) goto L79;
        boolean r58 = true;
    L80:
        if (r58 == false) goto L82;
    L69:
        if (StringsKt.isBlank(r54) == true) goto L72;
        r57 = false;
        goto L73
    L66:
        r56 = null;
    L79:
        r58 = false;
    L81:
        r49 = 1;
        goto L83
    L52:
        if (r45.isDebug() == false) goto L54;
        r46 = true;
    L104:
        Intrinsics.checkNotNull(r14);
        return r14;
    L47:
        r44 = true;
    L31:
        r41 = true;
        goto L32
    L27:
        r36 = 3;
        goto L28
    L18:
        if (r21.ordinal() != DevicePerfUtils.DevicePerfLevel.MIDDLE.ordinal()) goto L21;
        r22 = InitSDKRequest.DevicePerfLevel.DEVICE_MIDDLE;
        goto L24
    L21:
        if (r21.ordinal() != DevicePerfUtils.DevicePerfLevel.HIGH.ordinal()) goto L23;
        r22 = InitSDKRequest.DevicePerfLevel.DEVICE_HIGH;
        goto L24
    L23:
        r22 = InitSDKRequest.DevicePerfLevel.DEVICE_UNKNOWN;
        goto L24
    }
}
