package com.bytedance.lego.init;

import com.bytedance.lego.init.generate.DelayTaskCollector__components_init_task;
import com.bytedance.lego.init.generate.FeedShowTaskCollector__components_init_task;
import com.bytedance.lego.init.generate.PeriodTaskCollector__components_init_task;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.bytedance.lego.init.model.FeedShowTaskInfo;
import com.bytedance.lego.init.model.InitPeriod;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<d> f2094a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<b> f2095b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<c> f2096c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<m3.h> f2097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static List<DelayTaskInfo> f2098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static List<FeedShowTaskInfo> f2099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map<String, m3.g> f2100g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static List<m3.f> f2101h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static List<m3.f> f2102i;

    static {
        f2094a = new ArrayList();
        f2095b = new ArrayList();
        f2096c = new ArrayList();
        f2097d = null;
        f2098e = null;
        f2099f = null;
        f2100g = new HashMap();
        f2101h = new LinkedList();
        f2102i = new LinkedList();
    }

    public static List<DelayTaskInfo> a() {
        if (f2098e != null) goto L9;
        f2098e = new ArrayList();
        Iterator<b> r10 = e().iterator();
    L6:
        if (r10.hasNext() == false) goto L9;
        r10.next().a(f2098e);
    L9:
        return f2098e;
    }

    public static List<FeedShowTaskInfo> b() {
        if (f2099f != null) goto L9;
        f2099f = new ArrayList();
        Iterator<c> r10 = f().iterator();
    L6:
        if (r10.hasNext() == false) goto L9;
        r10.next().a(f2099f);
    L9:
        return f2099f;
    }

    public static List<m3.h> c() {
        if (f2097d != null) goto L9;
        f2097d = new ArrayList();
        Iterator<d> r10 = d().iterator();
    L6:
        if (r10.hasNext() == false) goto L9;
        r10.next().a(f2097d);
    L9:
        return f2097d;
    }

    private static List<d> d() {
        List<d> r10 = f2094a;
        if (r10.isEmpty() == false) goto L5;
        m();
    L5:
        return r10;
    }

    private static List<b> e() {
        List<b> r10 = f2095b;
        if (r10.isEmpty() == false) goto L5;
        j();
    L5:
        return r10;
    }

    private static List<c> f() {
        List<c> r10 = f2096c;
        if (r10.isEmpty() == false) goto L5;
        k();
    L5:
        return r10;
    }

    public static Map<String, m3.g> g() {
        Map<String, m3.g> r10 = f2100g;
        if (r10.isEmpty() == false) goto L5;
        n();
    L5:
        return r10;
    }

    public static List<m3.f> h() {
        if (f2102i.isEmpty() == false) goto L8;
        if (f2101h.isEmpty() == false) goto L8;
        l();
    L8:
        return f2102i;
    }

    public static List<m3.f> i() {
        if (f2102i.isEmpty() == false) goto L8;
        if (f2101h.isEmpty() == false) goto L8;
        l();
    L8:
        return f2101h;
    }

    static void j() {
        List<b> r10 = f2095b;
        r10.clear();
        r10.add(new DelayTaskCollector__components_init_task());
    }

    static void k() {
        List<c> r10 = f2096c;
        r10.clear();
        r10.add(new FeedShowTaskCollector__components_init_task());
    }

    static void l() {
        f2101h.clear();
        f2102i.clear();
    }

    static void m() {
        List<d> r10 = f2094a;
        r10.clear();
        r10.add(new PeriodTaskCollector__components_init_task());
    }

    static void n() {
        Map<String, m3.g> r10 = f2100g;
        r10.clear();
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        r11.add("SPLASH_ONCREATE2SUPER_START");
        r12.add("APP_SUPER2ONCREATEEND_START");
        r12.add("OAccountInitTask");
        r12.add("AutoUpdateProcessWakeInitTask");
        r12.add("BdTrackerInitTask");
        r12.add("CleanUpInitTask");
        r12.add("CommonMonitorInitTask");
        r12.add("AppDownloaderInitTask");
        r12.add("NetworkAllowStateInitTask");
        r12.add("NpthInitTask");
        r12.add("ProcessKeepAliveInitTask");
        r12.add("ProcessServiceInitTask");
        r12.add("QNNInitTask");
        r12.add("AIInferRuntimeInitTask");
        r12.add("ReceiverRegisterInitTask");
        r12.add("Settings");
        r12.add("TTNetInitTask");
        r13.add("APP_SUPER2ONCREATEEND_START");
        r13.add("OAccountInitTask");
        r13.add("AutoUpdateProcessWakeInitTask");
        r13.add("BdTrackerInitTask");
        r13.add("CleanUpInitTask");
        r13.add("CommonMonitorInitTask");
        r13.add("AppDownloaderInitTask");
        r13.add("NetworkAllowStateInitTask");
        r13.add("NpthInitTask");
        r13.add("ProcessKeepAliveInitTask");
        r13.add("ProcessServiceInitTask");
        r13.add("QNNInitTask");
        r13.add("AIInferRuntimeInitTask");
        r13.add("ReceiverRegisterInitTask");
        r13.add("Settings");
        r13.add("TTNetInitTask");
        r14.add("all");
        InitPeriod r31 = InitPeriod.NONE;
        r10.put("APP_SUPER2ONCREATEEND_END", new m3.g("APP_SUPER2ONCREATEEND_END", true, false, 17.497513f, r14, r11, r12, r13, "init_shceduler_internal_task", r31));
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList();
        ArrayList r18 = new ArrayList();
        r15.add("MAIN_ONRESUME2SUPER_END");
        r16.add("MAIN_SUPER2ONCREATEEND_END");
        r17.add("MAIN_SUPER2ONCREATEEND_END");
        r18.add("main");
        r10.put("MAIN_ONRESUME2SUPER_START", new m3.g("MAIN_ONRESUME2SUPER_START", true, false, 4.4975123f, r18, r15, r16, r17, "init_shceduler_internal_task", r31));
        ArrayList r19 = new ArrayList();
        ArrayList r20 = new ArrayList();
        ArrayList r21 = new ArrayList();
        ArrayList r22 = new ArrayList();
        r19.add("APP_SUPER2ONCREATEEND_END");
        r20.add("APP_ONCREATE2SUPER_START");
        r20.add("ALogInitTask");
        r21.add("APP_ONCREATE2SUPER_START");
        r21.add("ALogInitTask");
        r22.add("all");
        InitPeriod r110 = InitPeriod.APP_SUPER2ONCREATEEND;
        r10.put("NetworkAllowStateInitTask", new m3.g("NetworkAllowStateInitTask", false, false, 18.497513f, r22, r19, r20, r21, "com.obric.aikernel.init.tasks.networkallowstate.NetworkAllowStateInitTask", r110));
        ArrayList r23 = new ArrayList();
        ArrayList r24 = new ArrayList();
        ArrayList r25 = new ArrayList();
        ArrayList r111 = new ArrayList();
        r23.add("APP_SUPER2ONCREATEEND_END");
        r24.add("APP_ONCREATE2SUPER_START");
        r25.add("APP_ONCREATE2SUPER_START");
        r111.add("main");
        r10.put("CleanUpInitTask", new m3.g("CleanUpInitTask", false, false, 18.497513f, r111, r23, r24, r25, "com.obric.aikernel.init.tasks.cleanup.CleanUpInitTask", r110));
        ArrayList r26 = new ArrayList();
        ArrayList r27 = new ArrayList();
        ArrayList r28 = new ArrayList();
        ArrayList r112 = new ArrayList();
        r26.add("MAIN_ONCREATE2SUPER_END");
        r27.add("SPLASH_SUPER2ONRESUMEEND_END");
        r28.add("SPLASH_SUPER2ONRESUMEEND_END");
        r112.add("main");
        r10.put("MAIN_ONCREATE2SUPER_START", new m3.g("MAIN_ONCREATE2SUPER_START", true, false, 8.497513f, r112, r26, r27, r28, "init_shceduler_internal_task", r31));
        ArrayList r29 = new ArrayList();
        ArrayList r30 = new ArrayList();
        ArrayList r32 = new ArrayList();
        ArrayList r33 = new ArrayList();
        r29.add("MAIN_ONRESUME2SUPER_START");
        r30.add("MAIN_SUPER2ONCREATEEND_START");
        r32.add("MAIN_SUPER2ONCREATEEND_START");
        r33.add("main");
        r10.put("MAIN_SUPER2ONCREATEEND_END", new m3.g("MAIN_SUPER2ONCREATEEND_END", true, false, 5.4975123f, r33, r29, r30, r32, "init_shceduler_internal_task", r31));
        ArrayList r34 = new ArrayList();
        ArrayList r35 = new ArrayList();
        ArrayList r36 = new ArrayList();
        ArrayList r37 = new ArrayList();
        r34.add("APP_SUPER2ATTACHBASEEND_START");
        r35.add("APP_ATTACHBASE2SUPER_START");
        r36.add("APP_ATTACHBASE2SUPER_START");
        r37.add("all");
        r10.put("APP_ATTACHBASE2SUPER_END", new m3.g("APP_ATTACHBASE2SUPER_END", true, false, 473.4975f, r37, r34, r35, r36, "init_shceduler_internal_task", r31));
        ArrayList r38 = new ArrayList();
        ArrayList r39 = new ArrayList();
        ArrayList r40 = new ArrayList();
        ArrayList r41 = new ArrayList();
        r38.add("SPLASH_ONCREATE2SUPER_END");
        r39.add("APP_SUPER2ONCREATEEND_END");
        r40.add("APP_SUPER2ONCREATEEND_END");
        r41.add("main");
        r10.put("SPLASH_ONCREATE2SUPER_START", new m3.g("SPLASH_ONCREATE2SUPER_START", true, false, 16.497513f, r41, r38, r39, r40, "init_shceduler_internal_task", r31));
        ArrayList r42 = new ArrayList();
        ArrayList r43 = new ArrayList();
        ArrayList r44 = new ArrayList();
        ArrayList r113 = new ArrayList();
        r42.add("APP_SUPER2ONCREATEEND_END");
        r43.add("APP_ONCREATE2SUPER_START");
        r44.add("APP_ONCREATE2SUPER_START");
        r113.add("all");
        r10.put("ProcessKeepAliveInitTask", new m3.g("ProcessKeepAliveInitTask", false, false, 18.497513f, r113, r42, r43, r44, "com.obric.aikernel.init.tasks.obric.ProcessKeepAliveInitTask", r110));
        ArrayList r45 = new ArrayList();
        ArrayList r46 = new ArrayList();
        ArrayList r47 = new ArrayList();
        ArrayList r48 = new ArrayList();
        r45.add("APP_ONCREATE2SUPER_START");
        r46.add("APP_SUPER2ATTACHBASEEND_START");
        r46.add("ALogInitTask");
        r46.add("ModelPresetInitTask");
        r47.add("APP_SUPER2ATTACHBASEEND_START");
        r47.add("ALogInitTask");
        r47.add("ModelPresetInitTask");
        r48.add("all");
        r10.put("APP_SUPER2ATTACHBASEEND_END", new m3.g("APP_SUPER2ATTACHBASEEND_END", true, false, 381.4975f, r48, r45, r46, r47, "init_shceduler_internal_task", r31));
        ArrayList r49 = new ArrayList();
        ArrayList r50 = new ArrayList();
        ArrayList r51 = new ArrayList();
        ArrayList r52 = new ArrayList();
        r49.add("NpthInitTask");
        r49.add("CommonMonitorInitTask");
        r49.add("Settings");
        r49.add("APP_SUPER2ONCREATEEND_END");
        r50.add("APP_SUPER2ATTACHBASEEND_START");
        r50.add("TTNetInitTask");
        r51.add("APP_SUPER2ATTACHBASEEND_START");
        r51.add("TTNetInitTask");
        r52.add("all");
        r10.put("BdTrackerInitTask", new m3.g("BdTrackerInitTask", true, false, 90.49751f, r52, r49, r50, r51, "com.obric.aikernel.init.tasks.bdtracker.BdTrackerInitTask", r110));
        ArrayList r53 = new ArrayList();
        ArrayList r210 = new ArrayList();
        ArrayList r211 = new ArrayList();
        ArrayList r54 = new ArrayList();
        r53.add("ALogInitTask");
        r53.add("APP_ATTACHBASE2SUPER_END");
        r53.add("ModelPresetInitTask");
        r54.add("all");
        r10.put("APP_ATTACHBASE2SUPER_START", new m3.g("APP_ATTACHBASE2SUPER_START", true, false, 1674.4976f, r54, r53, r210, r211, "init_shceduler_internal_task", r31));
        ArrayList r55 = new ArrayList();
        ArrayList r56 = new ArrayList();
        ArrayList r57 = new ArrayList();
        ArrayList r58 = new ArrayList();
        r55.add("APP_SUPER2ONCREATEEND_START");
        r56.add("APP_ONCREATE2SUPER_START");
        r57.add("APP_ONCREATE2SUPER_START");
        r58.add("all");
        r10.put("APP_ONCREATE2SUPER_END", new m3.g("APP_ONCREATE2SUPER_END", true, false, 37.497513f, r58, r55, r56, r57, "init_shceduler_internal_task", r31));
        ArrayList r212 = new ArrayList();
        ArrayList r59 = new ArrayList();
        ArrayList r60 = new ArrayList();
        ArrayList r61 = new ArrayList();
        r59.add("MAIN_SUPER2ONRESUMEEND_START");
        r60.add("MAIN_SUPER2ONRESUMEEND_START");
        r61.add("main");
        r10.put("MAIN_SUPER2ONRESUMEEND_END", new m3.g("MAIN_SUPER2ONRESUMEEND_END", true, false, 1.4975125f, r61, r212, r59, r60, "init_shceduler_internal_task", r31));
        ArrayList r62 = new ArrayList();
        ArrayList r63 = new ArrayList();
        ArrayList r64 = new ArrayList();
        ArrayList r65 = new ArrayList();
        r62.add("APP_SUPER2ONCREATEEND_END");
        r63.add("APP_SUPER2ONCREATEEND_START");
        r64.add("APP_SUPER2ONCREATEEND_START");
        r65.add("all");
        r10.put("OAccountInitTask", new m3.g("OAccountInitTask", true, false, 18.497513f, r65, r62, r63, r64, "com.obric.aikernel.init.tasks.account.OAccountInitTask", r110));
        ArrayList r66 = new ArrayList();
        ArrayList r67 = new ArrayList();
        ArrayList r68 = new ArrayList();
        ArrayList r114 = new ArrayList();
        r66.add("APP_SUPER2ONCREATEEND_END");
        r67.add("APP_ONCREATE2SUPER_START");
        r68.add("APP_ONCREATE2SUPER_START");
        r114.add("main");
        r10.put("AppDownloaderInitTask", new m3.g("AppDownloaderInitTask", true, false, 18.497513f, r114, r66, r67, r68, "com.obric.aikernel.init.tasks.downloader.DownloaderInitTask", r110));
        ArrayList r69 = new ArrayList();
        ArrayList r70 = new ArrayList();
        ArrayList r71 = new ArrayList();
        ArrayList r115 = new ArrayList();
        r69.add("APP_SUPER2ATTACHBASEEND_END");
        r70.add("APP_ATTACHBASE2SUPER_START");
        r70.add("ALogInitTask");
        r71.add("APP_ATTACHBASE2SUPER_START");
        r71.add("ALogInitTask");
        r115.add("main");
        InitPeriod r410 = InitPeriod.APP_SUPER2ATTACHBASEEND;
        r10.put("ModelPresetInitTask", new m3.g("ModelPresetInitTask", false, false, 382.4975f, r115, r69, r70, r71, "com.obric.aikernel.init.tasks.presetRes.PresetResInitTask", r410));
        ArrayList r72 = new ArrayList();
        ArrayList r73 = new ArrayList();
        ArrayList r74 = new ArrayList();
        ArrayList r116 = new ArrayList();
        r72.add("SPLASH_SUPER2ONCREATEEND_START");
        r73.add("SPLASH_ONCREATE2SUPER_START");
        r74.add("SPLASH_ONCREATE2SUPER_START");
        r116.add("main");
        r10.put("SPLASH_ONCREATE2SUPER_END", new m3.g("SPLASH_ONCREATE2SUPER_END", true, false, 15.497513f, r116, r72, r73, r74, "init_shceduler_internal_task", r31));
        ArrayList r75 = new ArrayList();
        ArrayList r76 = new ArrayList();
        ArrayList r77 = new ArrayList();
        ArrayList r117 = new ArrayList();
        r75.add("APP_SUPER2ONCREATEEND_END");
        r76.add("APP_ONCREATE2SUPER_START");
        r77.add("APP_ONCREATE2SUPER_START");
        r117.add("main");
        r10.put("QNNInitTask", new m3.g("QNNInitTask", true, false, 18.497513f, r117, r75, r76, r77, "com.obric.aikernel.init.tasks.qnn.QnnEnvInitTask", r110));
        ArrayList r78 = new ArrayList();
        ArrayList r79 = new ArrayList();
        ArrayList r80 = new ArrayList();
        ArrayList r118 = new ArrayList();
        r78.add("APP_SUPER2ONCREATEEND_END");
        r79.add("APP_ONCREATE2SUPER_START");
        r80.add("APP_ONCREATE2SUPER_START");
        r118.add("all");
        r10.put("ReceiverRegisterInitTask", new m3.g("ReceiverRegisterInitTask", false, false, 18.497513f, r118, r78, r79, r80, "com.obric.aikernel.init.tasks.service.ServiceRegisterInitTask", r110));
        ArrayList r81 = new ArrayList();
        ArrayList r82 = new ArrayList();
        ArrayList r83 = new ArrayList();
        ArrayList r119 = new ArrayList();
        r81.add("SPLASH_SUPER2ONCREATEEND_END");
        r82.add("SPLASH_ONCREATE2SUPER_END");
        r83.add("SPLASH_ONCREATE2SUPER_END");
        r119.add("main");
        r10.put("SPLASH_SUPER2ONCREATEEND_START", new m3.g("SPLASH_SUPER2ONCREATEEND_START", true, false, 14.497513f, r119, r81, r82, r83, "init_shceduler_internal_task", r31));
        ArrayList r84 = new ArrayList();
        ArrayList r85 = new ArrayList();
        ArrayList r86 = new ArrayList();
        ArrayList r120 = new ArrayList();
        r84.add("APP_SUPER2ONCREATEEND_END");
        r85.add("APP_ONCREATE2SUPER_START");
        r85.add("BdTrackerInitTask");
        r86.add("APP_ONCREATE2SUPER_START");
        r86.add("BdTrackerInitTask");
        r120.add("all");
        r10.put("Settings", new m3.g("Settings", false, false, 18.497513f, r120, r84, r85, r86, "com.obric.aikernel.init.tasks.settings.InitSettingsTask", r110));
        ArrayList r87 = new ArrayList();
        ArrayList r88 = new ArrayList();
        ArrayList r89 = new ArrayList();
        ArrayList r121 = new ArrayList();
        r87.add("BdTrackerInitTask");
        r87.add("APP_SUPER2ONCREATEEND_END");
        r88.add("APP_ONCREATE2SUPER_START");
        r89.add("APP_ONCREATE2SUPER_START");
        r121.add("all");
        r10.put("TTNetInitTask", new m3.g("TTNetInitTask", true, false, 108.49751f, r121, r87, r88, r89, "com.obric.aikernel.init.tasks.ttnet.TTNetInitTask", r110));
        ArrayList r90 = new ArrayList();
        ArrayList r91 = new ArrayList();
        ArrayList r92 = new ArrayList();
        ArrayList r122 = new ArrayList();
        r90.add("SPLASH_ONRESUME2SUPER_END");
        r91.add("SPLASH_SUPER2ONCREATEEND_END");
        r92.add("SPLASH_SUPER2ONCREATEEND_END");
        r122.add("main");
        r10.put("SPLASH_ONRESUME2SUPER_START", new m3.g("SPLASH_ONRESUME2SUPER_START", true, false, 12.497513f, r122, r90, r91, r92, "init_shceduler_internal_task", r31));
        ArrayList r93 = new ArrayList();
        ArrayList r94 = new ArrayList();
        ArrayList r95 = new ArrayList();
        ArrayList r123 = new ArrayList();
        r93.add("TTNetInitTask");
        r93.add("APP_ONCREATE2SUPER_END");
        r93.add("NpthInitTask");
        r93.add("AutoUpdateProcessWakeInitTask");
        r93.add("CleanUpInitTask");
        r93.add("CommonMonitorInitTask");
        r93.add("AppDownloaderInitTask");
        r93.add("NetworkAllowStateInitTask");
        r93.add("ProcessKeepAliveInitTask");
        r93.add("ProcessServiceInitTask");
        r93.add("QNNInitTask");
        r93.add("AIInferRuntimeInitTask");
        r93.add("ReceiverRegisterInitTask");
        r93.add("Settings");
        r94.add("APP_SUPER2ATTACHBASEEND_END");
        r95.add("APP_SUPER2ATTACHBASEEND_END");
        r123.add("all");
        r10.put("APP_ONCREATE2SUPER_START", new m3.g("APP_ONCREATE2SUPER_START", true, false, 380.4975f, r123, r93, r94, r95, "init_shceduler_internal_task", r31));
        ArrayList r96 = new ArrayList();
        ArrayList r97 = new ArrayList();
        ArrayList r98 = new ArrayList();
        ArrayList r99 = new ArrayList();
        r96.add("MAIN_SUPER2ONRESUMEEND_END");
        r97.add("MAIN_ONRESUME2SUPER_END");
        r98.add("MAIN_ONRESUME2SUPER_END");
        r99.add("main");
        r10.put("MAIN_SUPER2ONRESUMEEND_START", new m3.g("MAIN_SUPER2ONRESUMEEND_START", true, false, 2.4975123f, r99, r96, r97, r98, "init_shceduler_internal_task", r31));
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        r100.add("APP_SUPER2ONCREATEEND_END");
        r101.add("APP_ONCREATE2SUPER_START");
        r101.add("ALogInitTask");
        r102.add("APP_ONCREATE2SUPER_START");
        r102.add("ALogInitTask");
        r103.add("all");
        r10.put("AIInferRuntimeInitTask", new m3.g("AIInferRuntimeInitTask", false, false, 18.497513f, r103, r100, r101, r102, "com.obric.aikernel.init.tasks.service.AIInferRuntimeInitTask", r110));
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        ArrayList r106 = new ArrayList();
        ArrayList r107 = new ArrayList();
        r104.add("ModelPresetInitTask");
        r104.add("APP_SUPER2ATTACHBASEEND_END");
        r104.add("AutoUpdateProcessWakeInitTask");
        r104.add("NetworkAllowStateInitTask");
        r104.add("AIInferRuntimeInitTask");
        r105.add("APP_ATTACHBASE2SUPER_START");
        r106.add("APP_ATTACHBASE2SUPER_START");
        r107.add("all");
        r10.put("ALogInitTask", new m3.g("ALogInitTask", false, false, 818.4975f, r107, r104, r105, r106, "com.obric.aikernel.init.tasks.alog.ALogInitTask", r410));
        ArrayList r108 = new ArrayList();
        ArrayList r109 = new ArrayList();
        ArrayList r124 = new ArrayList();
        ArrayList r125 = new ArrayList();
        r108.add("MAIN_SUPER2ONRESUMEEND_START");
        r109.add("MAIN_ONRESUME2SUPER_START");
        r124.add("MAIN_ONRESUME2SUPER_START");
        r125.add("main");
        r10.put("MAIN_ONRESUME2SUPER_END", new m3.g("MAIN_ONRESUME2SUPER_END", true, false, 3.4975123f, r125, r108, r109, r124, "init_shceduler_internal_task", r31));
        ArrayList r126 = new ArrayList();
        ArrayList r127 = new ArrayList();
        ArrayList r128 = new ArrayList();
        ArrayList r129 = new ArrayList();
        r126.add("OAccountInitTask");
        r126.add("APP_SUPER2ONCREATEEND_END");
        r127.add("APP_ONCREATE2SUPER_END");
        r128.add("APP_ONCREATE2SUPER_END");
        r129.add("all");
        r10.put("APP_SUPER2ONCREATEEND_START", new m3.g("APP_SUPER2ONCREATEEND_START", true, false, 36.497513f, r129, r126, r127, r128, "init_shceduler_internal_task", r31));
        ArrayList r130 = new ArrayList();
        ArrayList r131 = new ArrayList();
        ArrayList r132 = new ArrayList();
        ArrayList r133 = new ArrayList();
        r130.add("APP_SUPER2ONCREATEEND_END");
        r131.add("APP_ONCREATE2SUPER_START");
        r131.add("ALogInitTask");
        r132.add("APP_ONCREATE2SUPER_START");
        r132.add("ALogInitTask");
        r133.add("main");
        r10.put("AutoUpdateProcessWakeInitTask", new m3.g("AutoUpdateProcessWakeInitTask", false, false, 18.497513f, r133, r130, r131, r132, "com.obric.aikernel.init.tasks.autoupdate.AutoUpdateProcessWakeInitTask", r110));
        ArrayList r134 = new ArrayList();
        ArrayList r135 = new ArrayList();
        ArrayList r136 = new ArrayList();
        ArrayList r137 = new ArrayList();
        r134.add("APP_SUPER2ATTACHBASEEND_END");
        r134.add("BdTrackerInitTask");
        r135.add("APP_ATTACHBASE2SUPER_END");
        r136.add("APP_ATTACHBASE2SUPER_END");
        r137.add("all");
        r10.put("APP_SUPER2ATTACHBASEEND_START", new m3.g("APP_SUPER2ATTACHBASEEND_START", true, false, 472.4975f, r137, r134, r135, r136, "init_shceduler_internal_task", r31));
        ArrayList r138 = new ArrayList();
        ArrayList r139 = new ArrayList();
        ArrayList r140 = new ArrayList();
        ArrayList r141 = new ArrayList();
        r138.add("MAIN_SUPER2ONCREATEEND_START");
        r139.add("MAIN_ONCREATE2SUPER_START");
        r140.add("MAIN_ONCREATE2SUPER_START");
        r141.add("main");
        r10.put("MAIN_ONCREATE2SUPER_END", new m3.g("MAIN_ONCREATE2SUPER_END", true, false, 7.4975123f, r141, r138, r139, r140, "init_shceduler_internal_task", r31));
        ArrayList r142 = new ArrayList();
        ArrayList r143 = new ArrayList();
        ArrayList r144 = new ArrayList();
        ArrayList r145 = new ArrayList();
        r142.add("SPLASH_SUPER2ONRESUMEEND_END");
        r143.add("SPLASH_ONRESUME2SUPER_END");
        r144.add("SPLASH_ONRESUME2SUPER_END");
        r145.add("main");
        r10.put("SPLASH_SUPER2ONRESUMEEND_START", new m3.g("SPLASH_SUPER2ONRESUMEEND_START", true, false, 10.497513f, r145, r142, r143, r144, "init_shceduler_internal_task", r31));
        ArrayList r146 = new ArrayList();
        ArrayList r147 = new ArrayList();
        ArrayList r148 = new ArrayList();
        ArrayList r149 = new ArrayList();
        r146.add("SPLASH_ONRESUME2SUPER_START");
        r147.add("SPLASH_SUPER2ONCREATEEND_START");
        r148.add("SPLASH_SUPER2ONCREATEEND_START");
        r149.add("main");
        r10.put("SPLASH_SUPER2ONCREATEEND_END", new m3.g("SPLASH_SUPER2ONCREATEEND_END", true, false, 13.497513f, r149, r146, r147, r148, "init_shceduler_internal_task", r31));
        ArrayList r150 = new ArrayList();
        ArrayList r151 = new ArrayList();
        ArrayList r152 = new ArrayList();
        ArrayList r153 = new ArrayList();
        r150.add("APP_SUPER2ONCREATEEND_END");
        r151.add("APP_ONCREATE2SUPER_START");
        r152.add("APP_ONCREATE2SUPER_START");
        r153.add("main");
        r10.put("ProcessServiceInitTask", new m3.g("ProcessServiceInitTask", false, false, 18.497513f, r153, r150, r151, r152, "com.obric.aikernel.init.tasks.obric.ProcessServiceInitTask", r110));
        ArrayList r154 = new ArrayList();
        ArrayList r155 = new ArrayList();
        ArrayList r156 = new ArrayList();
        ArrayList r157 = new ArrayList();
        r154.add("MAIN_SUPER2ONCREATEEND_END");
        r155.add("MAIN_ONCREATE2SUPER_END");
        r156.add("MAIN_ONCREATE2SUPER_END");
        r157.add("main");
        r10.put("MAIN_SUPER2ONCREATEEND_START", new m3.g("MAIN_SUPER2ONCREATEEND_START", true, false, 6.4975123f, r157, r154, r155, r156, "init_shceduler_internal_task", r31));
        ArrayList r158 = new ArrayList();
        ArrayList r159 = new ArrayList();
        ArrayList r160 = new ArrayList();
        ArrayList r161 = new ArrayList();
        r158.add("APP_SUPER2ONCREATEEND_END");
        r159.add("APP_ONCREATE2SUPER_START");
        r159.add("BdTrackerInitTask");
        r159.add("NpthInitTask");
        r160.add("APP_ONCREATE2SUPER_START");
        r160.add("BdTrackerInitTask");
        r160.add("NpthInitTask");
        r161.add("all");
        r10.put("CommonMonitorInitTask", new m3.g("CommonMonitorInitTask", true, false, 18.497513f, r161, r158, r159, r160, "com.obric.aikernel.init.tasks.commonmonitor.CommonMonitorInitTask", r110));
        ArrayList r162 = new ArrayList();
        ArrayList r163 = new ArrayList();
        ArrayList r164 = new ArrayList();
        ArrayList r165 = new ArrayList();
        r162.add("CommonMonitorInitTask");
        r162.add("APP_SUPER2ONCREATEEND_END");
        r163.add("APP_ONCREATE2SUPER_START");
        r163.add("BdTrackerInitTask");
        r164.add("APP_ONCREATE2SUPER_START");
        r164.add("BdTrackerInitTask");
        r165.add("all");
        r10.put("NpthInitTask", new m3.g("NpthInitTask", false, false, 36.497513f, r165, r162, r163, r164, "com.obric.aikernel.init.tasks.npth.NpthInitTask", r110));
        ArrayList r166 = new ArrayList();
        ArrayList r167 = new ArrayList();
        ArrayList r168 = new ArrayList();
        ArrayList r169 = new ArrayList();
        r166.add("MAIN_ONCREATE2SUPER_START");
        r167.add("SPLASH_SUPER2ONRESUMEEND_START");
        r168.add("SPLASH_SUPER2ONRESUMEEND_START");
        r169.add("main");
        r10.put("SPLASH_SUPER2ONRESUMEEND_END", new m3.g("SPLASH_SUPER2ONRESUMEEND_END", true, false, 9.497513f, r169, r166, r167, r168, "init_shceduler_internal_task", r31));
        ArrayList r170 = new ArrayList();
        ArrayList r171 = new ArrayList();
        ArrayList r172 = new ArrayList();
        ArrayList r173 = new ArrayList();
        r170.add("SPLASH_SUPER2ONRESUMEEND_START");
        r171.add("SPLASH_ONRESUME2SUPER_START");
        r172.add("SPLASH_ONRESUME2SUPER_START");
        r173.add("main");
        r10.put("SPLASH_ONRESUME2SUPER_END", new m3.g("SPLASH_ONRESUME2SUPER_END", true, false, 11.497513f, r173, r170, r171, r172, "init_shceduler_internal_task", r31));
    }
}
