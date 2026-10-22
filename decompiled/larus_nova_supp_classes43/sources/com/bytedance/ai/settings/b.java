package com.bytedance.ai.settings;

import java.util.List;
import kotlin.collections.CollectionsKt;
import t5.g;
import t5.i;
import t5.m;
import t5.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final a<Integer> a = null;
    public static final a<Integer> b = null;
    public static final a<Boolean> c = null;
    public static final a<t> d = null;
    public static final a<g> e = null;
    public static final a<Integer> f = null;
    public static final a<List<String>> g = null;
    public static final a<i> h = null;
    public static final a<List<String>> i = null;
    public static final a<m> j = null;
    public static final a<t5.c> k = null;
    public static final a<List<String>> l = null;
    public static final a<Long> m = null;
    public static final a<Integer> n = null;
    public static final a<List<String>> o = null;
    public static final a<List<String>> p = null;
    public static final a<Boolean> q = null;
    public static final a<Integer> r = null;

    static {
        d.a.getClass();
        a = new a("downloadType", Integer.valueOf(d.a().resourcesManagerConfig().f()));
        b = new a("frontierServerId", Integer.valueOf(d.a().frontierConfig().a()));
        c = new a("enableToolRuntimeEntry", Boolean.valueOf(d.a().optimizeSettings().a()));
        d = new a("widgetSettingsConfig", d.a().widgetSettingsConfig());
        e = new a("lynxTemplateVerifyConfig", d.a().lynxTemplateVerifyConfig());
        f = new a("geckoHostVersion", Integer.valueOf(d.a().resourcesManagerConfig().d()));
        List<String> r1 = d.a().resourcesManagerConfig().g();
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        g = new a("requestWhiteList", r1);
        h = new a("lynxViewReusedConfig", d.a().lynxViewReusedConfig());
        List<String> r10 = d.a().aiBridgeConfig().d();
        if (r10 != null) goto L8;
        r10 = CollectionsKt.emptyList();
    L8:
        i = new a("aiBridgeConfig", r10);
        j = new a("optimizeSettings", d.a().optimizeSettings());
        k = new a("appletSettings", d.a().appletSettings());
        List<String> r11 = d.a().resourcesManagerConfig().a();
        if (r11 != null) goto L11;
        r11 = CollectionsKt.emptyList();
    L11:
        l = new a("customDownloadPackageList", r11);
        m = new a("customUpdateInterval", Long.valueOf(d.a().resourcesManagerConfig().h()));
        n = new a("offlineFileVersion", Integer.valueOf(d.a().resourcesManagerConfig().e()));
        List<String> r12 = d.a().resourcesManagerConfig().c();
        if (r12 != null) goto L14;
        r12 = CollectionsKt.emptyList();
    L14:
        o = new a("forceUpdateChannelList", r12);
        List<String> r13 = d.a().resourcesManagerConfig().b();
        if (r13 != null) goto L17;
        r13 = CollectionsKt.emptyList();
    L17:
        p = new a("firstAppPackageList", r13);
        q = new a("embedWebviewDomainVerifyEnabled", Boolean.valueOf(d.a().embedWebviewSettings().a()));
        r = new a("workerOptimized", Integer.valueOf(d.a().resourcesManagerConfig().i()));
    }
}
