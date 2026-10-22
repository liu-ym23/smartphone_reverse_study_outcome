package com.bytedance.ai.ex.widget.inittasks;

import android.app.Application;
import android.content.pm.PackageInfo;
import com.bytedance.ai.ex.widget.LogAdapter;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.keva.KevaImpl;
import com.ivy.ivykit.api.bridge.IBridgeService;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.ivy.ivykit.api.plugin.IIvyWebService;
import com.ivy.ivykit.api.plugin.IvyPluginService;
import com.ivy.ivykit.api.plugin.IvyResourceService;
import com.ivy.ivykit.api.plugin.debug.IvyDebugService;
import com.ivy.ivykit.api.plugin.f;
import com.ivy.ivykit.base.resource.IvyResourceServiceImpl;
import com.ivy.ivykit.plugin.impl.applet.IvyAIPackageResourceServiceImpl;
import com.ivy.ivykit.plugin.impl.jsb.BridgeServiceImpl;
import com.ivy.ivykit.plugin.impl.render.IvyPluginServiceImpl;
import com.ivy.ivykit.plugin.impl.web.IvyWebServiceImpl;
import com.ss.android.ugc.aweme.framework.services.Binding;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;
import java.util.concurrent.ConcurrentHashMap;
import jm.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.b;
import ul.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/ex/widget/inittasks/IvyKitInitializer;", "", "<init>", "()V", "", "registerIvyKit", "", "versionCode", "", "versionCodeToName", "(I)Ljava/lang/String;", "Landroid/app/Application;", "context", "did", "Lul/d;", "geckoConfigs", "init", "(Landroid/app/Application;Ljava/lang/String;Lul/d;)V", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IvyKitInitializer {
    public static final IvyKitInitializer INSTANCE = null;

    static {
        INSTANCE = new IvyKitInitializer();
    }

    private IvyKitInitializer() {
    }

    public static /* synthetic */ IvyResourceService a(IvyResourceServiceImpl r5) {
        return registerIvyKit$lambda$4(r5);
    }

    public static /* synthetic */ IvyPluginService b(IvyPluginServiceImpl r5) {
        return registerIvyKit$lambda$3(r5);
    }

    public static /* synthetic */ IIvyAIPackageResourceService c(IvyAIPackageResourceServiceImpl r5) {
        return registerIvyKit$lambda$5(r5);
    }

    public static /* synthetic */ IIvyWebService d(IvyWebServiceImpl r5) {
        return registerIvyKit$lambda$2(r5);
    }

    public static /* synthetic */ IBridgeService e(BridgeServiceImpl r5) {
        return registerIvyKit$lambda$6(r5);
    }

    private final void registerIvyKit() {
        final IvyWebServiceImpl r5 = new IvyWebServiceImpl();
        ServiceManager r10 = ServiceManager.a();
        final int r11 = 0;
        ServiceProvider r12 = new a(r5, r11);
        r10.getClass();
        new Binding(IIvyWebService.class, r12);
        final IvyPluginServiceImpl r13 = new IvyPluginServiceImpl();
        ServiceManager r14 = ServiceManager.a();
        final int r15 = 1;
        ServiceProvider r16 = new a(r13, r15);
        r14.getClass();
        new Binding(IvyPluginService.class, r16);
        final IvyResourceServiceImpl r17 = new IvyResourceServiceImpl();
        ServiceManager r18 = ServiceManager.a();
        final int r19 = 2;
        ServiceProvider r20 = new a(r17, r19);
        r18.getClass();
        new Binding(IvyResourceService.class, r20);
        final IvyAIPackageResourceServiceImpl r21 = new IvyAIPackageResourceServiceImpl();
        ServiceManager r22 = ServiceManager.a();
        final int r23 = 3;
        ServiceProvider r24 = new a(r21, r23);
        r22.getClass();
        new Binding(IIvyAIPackageResourceService.class, r24);
        final BridgeServiceImpl r25 = new BridgeServiceImpl();
        ServiceManager r26 = ServiceManager.a();
        final int r27 = 4;
        ServiceProvider r28 = new a(r25, r27);
        r26.getClass();
        new Binding(IBridgeService.class, r28);
    }

    private static final IIvyWebService registerIvyKit$lambda$2(IvyWebServiceImpl r5) {
        Intrinsics.checkNotNullParameter(r5, "$ivyWebService");
        return r5;
    }

    private static final IvyPluginService registerIvyKit$lambda$3(IvyPluginServiceImpl r5) {
        Intrinsics.checkNotNullParameter(r5, "$ivyPluginService");
        return r5;
    }

    private static final IvyResourceService registerIvyKit$lambda$4(IvyResourceServiceImpl r5) {
        Intrinsics.checkNotNullParameter(r5, "$ivyResourceService");
        return r5;
    }

    private static final IIvyAIPackageResourceService registerIvyKit$lambda$5(IvyAIPackageResourceServiceImpl r5) {
        Intrinsics.checkNotNullParameter(r5, "$ivyAIPackageResourceService");
        return r5;
    }

    private static final IBridgeService registerIvyKit$lambda$6(BridgeServiceImpl r5) {
        Intrinsics.checkNotNullParameter(r5, "$iBridgeService");
        return r5;
    }

    private final String versionCodeToName(int r5) {
        int r10 = r5 / 100;
        int r11 = r10 / KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        int r12 = (r10 % KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) / 100;
        StringBuilder r13 = new StringBuilder();
        r13.append(r11);
        r13.append('.');
        r13.append(r12);
        r13.append('.');
        r13.append(r10 % 100);
        return r13.toString();
    }

    public final void init(Application r10, String r11, d r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "geckoConfigs");
        PackageInfo r5 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0);
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        Intrinsics.checkNotNullParameter(r10, "application");
        Intrinsics.checkNotNullParameter(r11, "deviceId");
        sl.a r13 = new sl.a();
        r13.f21950a = "";
        r13.f21951b = "";
        r13.f21952c = "";
        r13.d = "";
        r13.e = "";
        r13.f21953h = "";
        r13.f21955j = "";
        String r14 = r10.getPackageName();
        Intrinsics.checkNotNullParameter(r14, "appName");
        r13.f21951b = r14;
        String r15 = r5.versionName;
        if (r15 != null) goto L8;
        r15 = "1.0";
    L8:
        Intrinsics.checkNotNullParameter(r15, "appVersion");
        r13.f21952c = r15;
        String r16 = String.valueOf(r5.getLongVersionCode());
        Intrinsics.checkNotNullParameter(r16, "appVersionCode");
        r13.d = r16;
        String r17 = String.valueOf(r5.getLongVersionCode());
        Intrinsics.checkNotNullParameter(r17, "appUpdateVersionCode");
        r13.e = r17;
        Intrinsics.checkNotNullParameter("https://www.bytedance.net", "hybridMonitorHost");
        r13.f21950a = "https://www.bytedance.net";
        r13.f = true;
        r13.g = true;
        Intrinsics.checkNotNullParameter("", "boeChannel");
        Intrinsics.checkNotNullParameter("", "ppeChannel");
        r13.f21954i = LogAdapter.INSTANCE.getIvyLog();
        Intrinsics.checkNotNullParameter("default_bid", "bid");
        r13.f21953h = "default_bid";
        String r18 = INSTANCE.versionCodeToName(r5.versionCode);
        Intrinsics.checkNotNullParameter(r18, "version");
        r13.f21955j = r18;
        Intrinsics.checkNotNullParameter(r13, "ivyConfig");
        Intrinsics.checkNotNullParameter(r12, "geckoConfigs");
        Intrinsics.checkNotNullParameter(r13, "ivyConfig");
        k5.d.f18604i = r13.f21950a;
        k5.d.f18605j = r13.f21951b;
        k5.d.f18606k = r13.f21952c;
        k5.d.f18607l = r13.d;
        k5.d.f18608m = r13.e;
        k5.d.f18610o = r11;
        k5.d.f18611p = r13.f;
        k5.d.f18612q = r13.g;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        k5.d.s = r10;
        ConcurrentHashMap r19 = b.f22138a;
        tl.a r20 = r13.f21954i;
        if (r20 == null) goto L14;
        ConcurrentHashMap r21 = b.f22138a;
        if (r21.containsKey(r20.getClass()) == true) goto L14;
        r21.clear();
        r21.put(r20.getClass(), r20);
    L14:
        k5.d.f18613r = r13.f21953h;
        k5.d.f18609n = r13.f21955j;
        Intrinsics.checkNotNullParameter(r12, "geckoConfigs");
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        c.f18359c = r12;
        h.g.f5316b = r10;
        registerIvyKit();
        f r22 = IvyPluginService.Companion;
        com.ivy.ivykit.api.plugin.h r23 = new com.ivy.ivykit.api.plugin.h();
        r23.f9495a = false;
        r22.initContainer(r23);
        IvyDebugService.Companion.setEnable(false);
    }
}
