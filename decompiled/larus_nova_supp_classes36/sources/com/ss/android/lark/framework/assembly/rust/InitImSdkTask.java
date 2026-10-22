package com.ss.android.lark.framework.assembly.rust;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import com.bytedance.lark.office_sdk_im_android.Office_sdk_imKt;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.appcontext.applifecycle.LifecycleHandler;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.framework.assembly.rust.bridge.OfficeSdkFeedCardProviderImpl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitImSdkTask extends AsyncLaunchTask {
    public final List<d> c;
    public final Provider<IAppStateSyncService> d;
    public final Provider<com.bytedance.lark.sdk.refactor.n> e;
    public final Provider<c3c.d.b> f;
    public final Provider<c3c.d.d> g;
    public gpb.a h;
    public final Provider<epb.a> i;

    public class a implements com.ss.android.lark.appcontext.applifecycle.t {
        public final /* synthetic */ InitImSdkTask a;

        public a(InitImSdkTask r1) {
            this.a = r1;
        }

        public final void a(Activity r2) {
            if (com.ss.android.lark.featuregating.b.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L5;
            ((IAppStateSyncService) this.a.d.get()).a(true);
            return;
        L5:
            com.ss.android.lark.rustinfrabridge.appstatesync.service.impl.b.b.a.a(true);
        }
    }

    public class b extends com.ss.android.lark.appcontext.applifecycle.a {
        public final /* synthetic */ InitImSdkTask a;

        public b(InitImSdkTask r1) {
            this.a = r1;
        }

        public final void onActivityCreated(Activity r1, Bundle r2) {
            if (com.ss.android.lark.featuregating.b.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L5;
            ((IAppStateSyncService) this.a.d.get()).a(true);
            return;
        L5:
            com.ss.android.lark.rustinfrabridge.appstatesync.service.impl.b.b.a.a(true);
        }
    }

    public class c implements ComponentCallbacks2 {
        public final /* synthetic */ InitImSdkTask a;

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r1) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public c(InitImSdkTask r1) {
            this.a = r1;
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r2) {
            if (r2 >= 40) goto L5;
            return;
        L5:
            if (com.larksuite.framework.utils.z.e(LarkContext.getApplication()) == true) goto L7;
            return;
        L7:
            if (com.ss.android.lark.featuregating.b.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L9;
            ((IAppStateSyncService) this.a.d.get()).b();
            return;
        L9:
            com.ss.android.lark.rustinfrabridge.appstatesync.service.impl.b.b.a.b();
        }
    }

    public interface d {
        void onInitFinish();
    }

    public final gpb.a j() {
        if (this.h != null) goto L6;
        this.h = (gpb.a) ApiUtils.getApi(gpb.a.class);
    L6:
        return this.h;
    }

    public final void a(Context r10) {
        int r0 = Process.getThreadPriority(Process.myTid());
        Process.setThreadPriority(-4);     // Catch: Throwable -> L16
        Log.i("InitUtil", "start init Im sdk");     // Catch: Throwable -> L16
        gpb.a r1 = (gpb.a) ApiUtils.getApi(gpb.a.class);     // Catch: Throwable -> L16
        jcb.b.c().preload();     // Catch: Throwable -> L16
        f r3 = new f((c3c.d.b) this.f.get(), (c3c.d.d) this.g.get());     // Catch: Throwable -> L16
        String r5 = ((epb.a) ApiUtils.getApi(epb.a.class)).getDeviceIdFromLocal();     // Catch: Throwable -> L16
        int r6 = r1.oldSdkEnv();     // Catch: Throwable -> L16
        r1.envType();     // Catch: Throwable -> L16
        String r7 = r1.getUserUnit();     // Catch: Throwable -> L16
        String r8 = r1.getTenantBrand();     // Catch: Throwable -> L16
        ApkUtil.getAppVersionName(r10);     // Catch: Throwable -> L16
        r3.a(r10, r5, r6, r7, r8);     // Catch: Throwable -> L16
        a r11 = new a(this);     // Catch: Throwable -> L16
        ((CopyOnWriteArrayList) LifecycleHandler.a).add(r11);     // Catch: Throwable -> L16
        LifecycleHandler.d = new b(this);     // Catch: Throwable -> L16
        c r12 = new c(this);     // Catch: Throwable -> L16
        ConcurrentLinkedDeque r2 = LifecycleHandler.f;     // Catch: Throwable -> L16
        if (r2.contains(r12) == true) goto L6;
        r2.add(r12);     // Catch: Throwable -> L16
    L6:
        Process.setThreadPriority(r0);
        j().registerEnvChangeListener(new h(this));
        Object r13 = com.ss.android.lark.appcontext.applifecycle.b.b;
        com.ss.android.lark.appcontext.applifecycle.b r14 = com.ss.android.lark.appcontext.applifecycle.b.a.a;
        g r4 = new g();
        Map r15 = r14.a;
        ConcurrentHashMap r16 = (ConcurrentHashMap) r15;
        r16.put(r4, com.ss.android.lark.appcontext.applifecycle.b.b);
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L9;
    L11:
        Iterator r17 = ((ArrayList) this.c).iterator();
    L13:
        if (r17.hasNext() == false) goto L15;
        ((d) r17.next()).onInitFinish();
        goto L13
    L15:
        return;
    L9:
        if (LarkAppContext.inst().buildConfig().isOfficeSDKImIntegrated() == false) goto L11;
        Application r18 = LarkContext.getApplication();
        int r9 = com.ss.android.lark.framework.assembly.rust.bridge.a.a;
        Intrinsics.checkNotNullParameter(r18, "application");
        Log.i("OfficeSdkBridgeRegister", "register molten bridge");
        Office_sdk_imKt.officeSdkRegisterHostSetting(new com.ss.android.lark.framework.assembly.rust.bridge.b(r18));
        Office_sdk_imKt.officeSdkRegisterFeedCardProvider(new OfficeSdkFeedCardProviderImpl(r18));
    L16:
        th = move-exception;
        Process.setThreadPriority(r0);
        throw th;
    }

    @Inject
    public InitImSdkTask(Provider<IAppStateSyncService> r2, Provider<com.bytedance.lark.sdk.refactor.n> r3, Provider<c3c.d.b> r4, Provider<c3c.d.d> r5, Provider<epb.a> r6) {
        this.c = new ArrayList();
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.i = r6;
    }
}
