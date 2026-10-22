package com.ss.android.lark.chameleonv2.container.webcontainer;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.chameleon.AbsChameleonJsRuntime;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.ChameleonBizType;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ChameleonContainerConst;
import com.ss.android.lark.chameleon.ChameleonResourceLoadCallback;
import com.ss.android.lark.chameleon.IChameleonApi;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.PreloadConfig;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.ResGeckoConfig;
import com.ss.android.lark.chameleon.ResInterceptConfig;
import com.ss.android.lark.chameleon.TitlebarConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.chameleonv2.container.webcontainer.config.ChameleonInterceptorConfig;
import com.ss.android.lark.chameleonv2.container.webcontainer.config.ChameleonInterceptorGlobalConfig;
import com.ss.android.lark.chameleonv2.container.webcontainer.config.ChameleonOpenConfig;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.ForsetiPlugin;
import com.ss.android.lark.chameleonv2.container.webcontainer.res.ChameleonOfflineResourceInterceptor;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ChameleonDebugUtils;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonActivity;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonFragmentV2;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ModelChameleonActivity;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.Flowable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ntb.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChameleonImpl implements IChameleonApi {

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ChameleonImpl a;
        public final /* synthetic */ ChameleonConfig b;
        public final /* synthetic */ ChameleonResourceLoadCallback c;

        public b(ChameleonImpl r1, ChameleonConfig r2, ChameleonResourceLoadCallback r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            ChameleonImpl r2 = this.a;     // Catch: Throwable -> L25
            ChameleonConfig r3 = this.b;     // Catch: Throwable -> L25
            r2.getClass();     // Catch: Throwable -> L25
            ChameleonImpl.a(r3);     // Catch: Throwable -> L25
            int r4 = ChameleonOfflineResourceInterceptor.f;     // Catch: Throwable -> L25
            VFSPath r5 = ChameleonOfflineResourceInterceptor.b.a(this.b);     // Catch: Throwable -> L25
            boolean r6 = true;
            if (r5 == null) goto L17;
            String r7 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.e(r5);     // Catch: Throwable -> L25
            if (r7 != null) goto L9;
        L12:
            if (r6 == false) goto L15;
            com.ss.android.lark.officesdk.utils.di.j.f("CML_TAG_ChameleonImpl", "loadResource failed, debug resource version is empty, path=" + r5.getRealPath());     // Catch: Throwable -> L25
            ChameleonImpl r1 = this.a;     // Catch: Throwable -> L25
            ChameleonResourceLoadCallback r8 = this.c;     // Catch: Throwable -> L25
            r1.getClass();     // Catch: Throwable -> L25
            ChameleonImpl.d(r8, 2, null);     // Catch: Throwable -> L25
            return;
        L15:
            ChameleonImpl r9 = this.a;     // Catch: Throwable -> L25
            ChameleonResourceLoadCallback r10 = this.c;     // Catch: Throwable -> L25
            r9.getClass();     // Catch: Throwable -> L25
            Lazy r11 = ThreadUtil.a;     // Catch: Throwable -> L25
            com.ss.android.lark.chameleonv2.container.webcontainer.a r12 = new com.ss.android.lark.chameleonv2.container.webcontainer.a(r10, r5, r7);     // Catch: Throwable -> L25
            Intrinsics.checkNotNullParameter(r12, "runnable");     // Catch: Throwable -> L25
            ((Handler) ThreadUtil.a.getValue()).post(r12);     // Catch: Throwable -> L25
            return;
        L9:
            if (r7.length() == 0) goto L12;
            r6 = false;
            goto L12
        L17:
            List<? extends u0b.a> r13 = t0b.a.a;     // Catch: Throwable -> L25
            int r14 = com.ss.android.lark.officesdk.utils.di.d.a;     // Catch: Throwable -> L25
            com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d r15 = t0b.a.a(com.ss.android.lark.officesdk.utils.di.d.a.a(), this.b, true, null);     // Catch: Throwable -> L25
            VFSPath r16 = r15.a;     // Catch: Throwable -> L25
            if (r16 != null) goto L21;
            com.ss.android.lark.officesdk.utils.di.j.f("CML_TAG_ChameleonImpl", "loadResource failed, path is null");     // Catch: Throwable -> L25
            ChameleonImpl r17 = this.a;     // Catch: Throwable -> L25
            ChameleonResourceLoadCallback r18 = this.c;     // Catch: Throwable -> L25
            r17.getClass();     // Catch: Throwable -> L25
            ChameleonImpl.d(r18, 2, null);     // Catch: Throwable -> L25
            return;
        L21:
            if (swb.g.a(r16) == true) goto L23;
            com.ss.android.lark.officesdk.utils.di.j.f("CML_TAG_ChameleonImpl", "loadResource failed, resource is invalid");     // Catch: Throwable -> L25
            ChameleonImpl r19 = this.a;     // Catch: Throwable -> L25
            ChameleonResourceLoadCallback r20 = this.c;     // Catch: Throwable -> L25
            r19.getClass();     // Catch: Throwable -> L25
            ChameleonImpl.d(r20, 2, null);     // Catch: Throwable -> L25
            return;
        L23:
            ChameleonImpl r21 = this.a;     // Catch: Throwable -> L25
            ChameleonResourceLoadCallback r22 = this.c;     // Catch: Throwable -> L25
            String r23 = r15.b;     // Catch: Throwable -> L25
            r21.getClass();     // Catch: Throwable -> L25
            Lazy r24 = ThreadUtil.a;     // Catch: Throwable -> L25
            com.ss.android.lark.chameleonv2.container.webcontainer.a r25 = new com.ss.android.lark.chameleonv2.container.webcontainer.a(r22, r16, r23);     // Catch: Throwable -> L25
            Intrinsics.checkNotNullParameter(r25, "runnable");     // Catch: Throwable -> L25
            ((Handler) ThreadUtil.a.getValue()).post(r25);     // Catch: Throwable -> L25
            return;
        L25:
            th = move-exception;
            com.ss.android.lark.officesdk.utils.di.j.c("CML_TAG_ChameleonImpl", "loadResource failed", th);
            ChameleonImpl r0 = this.a;
            ChameleonResourceLoadCallback r26 = this.c;
            r0.getClass();
            ChameleonImpl.d(r26, 3, th);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ChameleonResourceLoadCallback a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Throwable c;

        public c(ChameleonResourceLoadCallback r1, int r2, Throwable r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.onLoadFail(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public ChameleonImpl() {
    }

    public static void a(ChameleonConfig r6) {
        boolean r0 = false;
        if (r6 == null) goto L11;
        ResConfig r1 = r6.getResConfig();
        if (r1 == null) goto L11;
        ResGeckoConfig r2 = r1.getGeckoConfig();
        if (r2 == null) goto L11;
        boolean r3 = true;
        if (r2.getEnable() != true) goto L11;
    L12:
        if (r3 == false) goto L44;
        AtomicBoolean r4 = s0b.g.a;
        if (r6 != null) goto L16;
        return;
    L16:
        if (s0b.g.a.get() == false) goto L18;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_GeckoResManager", "has init, ignore");
    L29:
        if (s0b.g.a.get() == false) goto L46;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_GeckoResManager", "executeCheckUpdate");
        Map<String, Boolean> r5 = s0b.g.f;
        String r7 = r6.getBizName();
        if (r7 != null) goto L33;
        r7 = BuildConfig.FLAVOR;
    L33:
        HashMap r8 = (HashMap) r5;
        Object r9 = r8.get(r7);
        Boolean r10 = Boolean.TRUE;
        if (Intrinsics.areEqual(r9, r10) == false) goto L36;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_GeckoResManager", "executeCheckUpdate: biz " + r6.getBizName() + " has already executed, skip");
        return;
    L36:
        String r11 = r6.getBizName();
        if (r11 != null) goto L39;
        r11 = BuildConfig.FLAVOR;
    L39:
        r8.put(r11, r10);
        Flowable.just(BuildConfig.FLAVOR).observeOn(LarkRxSchedulers.io()).subscribe(new s0b.e(r6), s0b.f.a);
        return;
    L46:
        return;
    L18:
        long r12 = System.currentTimeMillis();
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_GeckoResManager", "init start");
    L22:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c("CML_TAG_GeckoResManager", "init gecko failed", e);
    L27:
        s0b.g.a.set(r0);
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_GeckoResManager", "init finish, cost time = " + (System.currentTimeMillis() - r12) + ", thread = " + ThreadMethodProxy.currentThread().getName());
        goto L29
    L20:
        if (s0b.g.b != null) goto L24;
        r0b.a.a(s0b.g.e);     // Catch: Exception -> L22
        r0 = s0b.g.c(r6);     // Catch: Exception -> L22
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_GeckoResManager", "initGecko(): initSuccess " + r0);     // Catch: Exception -> L22
    L41:
        goto L27
    L24:
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_GeckoResManager", "initGecko(): mGeckoClient has ready");     // Catch: Exception -> L22
        goto L41
    L44:
        return;
    L11:
        r3 = false;
        goto L12
    }

    public static ChameleonConfig b(ChameleonInterceptorConfig r17) {
        ChameleonOpenConfig r0 = r17.getOpenConfig();
        OpenConfig r1 = null;
        if (r0 == null) goto L6;
        TitlebarConfig r3 = new TitlebarConfig(r0.getShowTabBar(), null, 2, null);
        boolean r4 = r0.getShowDefaultLoading();
        long r8 = r0.getLoadingTimeout();
        r1 = new OpenConfig(r3, r4, false, r0.getHideLoadingByJS(), r0.getStatisticsByJS(), r8, false, false, false, null, null, 1988, null);
    L6:
        return new ChameleonConfig.Builder().bizName(r17.getBizName()).openConfig(r1).build();
    }

    @Override // com.ss.android.lark.chameleon.IChameleonApi
    public final boolean canOpen(String r13, Bundle r14) {
        Serializable r3 = null;
        if (r13 == null) goto L45;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonImpl", "shouldIntercept url:".concat(r13));     // Catch: Throwable -> L42
        ChameleonInterceptorGlobalConfig r1 = (ChameleonInterceptorGlobalConfig) SettingManager.getInstance().get(ChameleonInterceptorGlobalConfig.class);     // Catch: Throwable -> L42
        if (r1.a() == true) goto L8;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonImpl", "shouldIntercept config not enable");     // Catch: Throwable -> L42
        goto L45
    L8:
        ArrayList<ChameleonInterceptorConfig> r2 = r1.b();     // Catch: Throwable -> L42
        if (r2.isEmpty() == true) goto L45;
        Uri r4 = UriProtector.parse(r13);     // Catch: Throwable -> L42
        String r5 = r4.getScheme();     // Catch: Throwable -> L42
        if (r5 == null) goto L45;
        String r6 = r4.getHost();     // Catch: Throwable -> L42
        if (r6 == null) goto L45;
        String r7 = r4.getPath();     // Catch: Throwable -> L42
        if (r7 == null) goto L45;
        Iterator<ChameleonInterceptorConfig> r8 = r2.iterator();     // Catch: Throwable -> L42
    L22:
        if (r8.hasNext() == false) goto L40;
        ChameleonInterceptorConfig r9 = r8.next();     // Catch: Throwable -> L42
        if (r9.getHosts().contains(r6) == false) goto L22;
        if (r9.getSchemes().contains(r5) == false) goto L22;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonImpl", "shouldIntercept host match, host:" + r6 + ", interceptor hosts:" + r9.getHosts());     // Catch: Throwable -> L42
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonImpl", "shouldIntercept scheme match, scheme:" + r5 + ", interceptor schemes:" + r9.getSchemes());     // Catch: Throwable -> L42
        if (r9.getFullMatchForPath() == true) goto L31;
        Iterator<String> r10 = r9.getPaths().iterator();     // Catch: Throwable -> L42
    L35:
        if (r10.hasNext() == false) goto L22;
        String r11 = r10.next();     // Catch: Throwable -> L42
        if (StringsKt.contains$default(r7, r11, false, 2, null) == false) goto L35;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonImpl", "shouldIntercept path contain, path:" + r7 + ", interceptor path:" + r11);     // Catch: Throwable -> L42
    L39:
        r3 = r9;
        goto L45
    L31:
        if (r9.getPaths().contains(r7) == false) goto L22;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonImpl", "shouldIntercept path full match, path:" + r7 + ", interceptor path:" + r9.getPaths());     // Catch: Throwable -> L42
        goto L39
    L40:
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonImpl", "shouldIntercept not match, url:" + r13);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c("CML_TAG_ChameleonImpl", "shouldIntercept error", th);
    L45:
        if (r3 == null) goto L49;
        if (r14 == null) goto L48;
        r14.putSerializable(ChameleonContainerConst.URL_CONFIG_KEY, r3);
    L48:
        return true;
    L49:
        if (r13 != null) goto L52;
    L68:
        boolean r15 = false;
    L70:
        if (r15 == false) goto L72;
        return true;
    L72:
        return false;
    L52:
        if (com.ss.android.lark.chameleonv2.container.webcontainer.util.b.a() == false) goto L68;
        Uri r16 = UriProtector.parse(r13);
        if (Intrinsics.areEqual(r16.getHost(), "Chameleon.test") == false) goto L68;
        if (Intrinsics.areEqual(r16.getPath(), "/open") == false) goto L68;
        String r17 = UriProtector.getQueryParameter(r16, "url");
        if (r17 != null) goto L63;
    L66:
        boolean r18 = true;
    L67:
        if (r18 == true) goto L68;
        r15 = true;
        goto L70
    L63:
        if (r17.length() == 0) goto L66;
        r18 = false;
        goto L67
    }

    @Override // com.ss.android.lark.chameleon.IChameleonApi
    public final void loadResource(ChameleonConfig r5, ChameleonResourceLoadCallback r6) {
        Intrinsics.checkNotNullParameter(r5, "chameleonConfig");
        Intrinsics.checkNotNullParameter(r6, "callback");
        String r0 = r5.getBizName();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
    L43:
        com.ss.android.lark.officesdk.utils.di.j.b("CML_TAG_ChameleonImpl", "loadResource failed, invalid params");
        d(r6, 1, null);
        return;
    L12:
        if (r5.getResConfig() == null) goto L43;
        ResConfig r3 = r5.getResConfig();
        if (r3 == null) goto L16;
        String r4 = r3.getResVersion();
    L17:
        if (r4 != null) goto L19;
    L22:
        boolean r7 = true;
    L23:
        if (r7 == true) goto L43;
        ResConfig r8 = r5.getResConfig();
        if (r8 == null) goto L27;
        String r9 = r8.getOfflineZipName();
    L28:
        if (r9 != null) goto L30;
    L31:
        r1 = true;
    L32:
        if (r1 == true) goto L43;
        Lazy r10 = ThreadUtil.a;
        b r11 = new b(this, r5, r6);
        Intrinsics.checkNotNullParameter(r11, "runnable");
        w r12 = ThreadUtil.a.c();
        if (r12 == null) goto L38;
        ExecutorService r13 = r12.w();
        if (r13 == null) goto L38;
    L39:
        if (r13 == null) goto L41;
        r13.execute(r11);
        return;
    L41:
        ThreadUtil.a.f(r11);
        return;
    L38:
        r13 = (ExecutorService) ThreadUtil.d.getValue();
        goto L39
    L30:
        if (StringsKt.isBlank(r9) == false) goto L32;
    L27:
        r9 = null;
        goto L28
    L19:
        if (StringsKt.isBlank(r4) == true) goto L22;
        r7 = false;
        goto L23
    L16:
        r4 = null;
        goto L17
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L10
    }

    @Override // com.ss.android.lark.chameleon.IChameleonApi
    public final void preloadWebview(ChameleonConfig r15, WebView r16) {
        if (r15 != null) goto L4;
        ChameleonConfig r13 = new ChameleonConfig(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L5:
        com.ss.android.lark.storage.a r0 = ChameleonDebugUtils.a;
        if (r15 == null) goto L8;
        String r1 = r15.getBizName();
    L9:
        String r2 = ChameleonDebugUtils.c(r1);
        if (r2.length() <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L17;
        r13.setLoadUrl(r2);
        PreloadConfig r4 = r13.getPreloadConfig();
        if (r4 == null) goto L17;
        r4.setTemplateUrl(r2);
    L17:
        int r5 = com.ss.android.lark.officesdk.utils.di.d.a;
        Application r6 = com.ss.android.lark.officesdk.utils.di.d.a.a();
        if (r6 == null) goto L25;
        v1b.a r7 = (v1b.a) e0c.k.a(r6, v1b.a.class);
        if (r7 == null) goto L26;
        ChameleonWebViewManager r8 = r7.F2();
        if (r8 == null) goto L27;
        r8.h(r13, r16);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L12:
        r3 = false;
        goto L13
    L8:
        r1 = null;
        goto L9
    L4:
        r13 = r15;
        goto L5
    }

    public static void d(ChameleonResourceLoadCallback r1, int r2, Throwable r3) {
        Lazy r0 = ThreadUtil.a;
        c r4 = new c(r1, r2, r3);
        Intrinsics.checkNotNullParameter(r4, "runnable");
        ((Handler) ThreadUtil.a.getValue()).post(r4);
    }

    @Override // com.ss.android.lark.chameleon.IChameleonApi
    public final Fragment getChameleonFragment(Context r18, ChameleonConfig r19, List<? extends AbsChameleonPlugin> r20) {
        Intrinsics.checkNotNullParameter(r18, "context");
        if (r19 != null) goto L5;
        ChameleonConfig r2 = new ChameleonConfig(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L6:
        com.ss.android.lark.storage.a r0 = ChameleonDebugUtils.a;
        if (r19 == null) goto L9;
        String r1 = r19.getBizName();
    L10:
        String r3 = ChameleonDebugUtils.c(r1);
        boolean r5 = true;
        if (r3.length() <= 0) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L19;
        r2.setLoadUrl(r3);
        PreloadConfig r6 = r2.getPreloadConfig();
        if (r6 == null) goto L19;
        r6.setTemplateUrl(r3);
    L19:
        if (r19 == null) goto L21;
        String r7 = r19.getBizName();
    L22:
        boolean r8 = com.ss.android.lark.chameleonv2.container.webcontainer.util.b.a();
        String r9 = BuildConfig.FLAVOR;
        if (r8 == false) goto L73;
        if (r7 != null) goto L26;
    L29:
        boolean r10 = true;
    L30:
        if (r10 == true) goto L73;
        if (ChameleonDebugUtils.b().getBoolean("chameleon_disable_offline_res", false) == true) goto L73;
        String r11 = ChameleonDebugUtils.b().getString("chameleon_specific_bizname", null);
        if (r11 != null) goto L39;
        r11 = BuildConfig.FLAVOR;
    L39:
        if (r11.length() <= 0) goto L41;
        boolean r12 = true;
    L42:
        if (r12 == false) goto L73;
        if (Intrinsics.areEqual(r7, r11) == false) goto L73;
        String r13 = ChameleonDebugUtils.b().getString("chameleon_specific_res_path", null);
        if (r13 == null) goto L73;
        ResInterceptConfig r14 = r19.getResInterceptConfig();
        if (r14 == null) goto L51;
        String r15 = r14.getPathRewrites();
    L53:
        if (r15 == null) goto L55;
        VFSFiles r16 = VFSFiles.b;
        String r17 = r16.D(r16.v(r13, r15), ChameleonResConstants.TEMPLATE_VERSION).getAbsolutePath();
    L95:
        VFSFiles r110 = VFSFiles.b;     // Catch: Exception -> L71
        Intrinsics.checkNotNull(r17);     // Catch: Exception -> L71
        VFSFile r111 = r110.i(r17);     // Catch: Exception -> L71
        if (r111.exists() == true) goto L59;
        com.ss.android.lark.officesdk.utils.di.j.b("CML_TAG_ChameleonDebugUtils", "Revision file not found: ".concat(r17));     // Catch: Exception -> L71
        goto L73
    L59:
        Iterator r21 = FilesKt.readLines$default(r111, null, 1, null).iterator();     // Catch: Exception -> L71
    L61:
        if (r21.hasNext() == false) goto L65;
        Object r112 = r21.next();     // Catch: Exception -> L71
        if (StringsKt.startsWith$default((String) r112, Keys.API_RETURN_KEY_VERSION, false, 2, null) == false) goto L61;
    L66:
        String r113 = (String) r112;     // Catch: Exception -> L71
        if (r113 == null) goto L73;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonDebugUtils", "Using offline Res for biz: " + r7 + ", res version: " + r113);     // Catch: Exception -> L71
        String r22 = StringsKt.replace$default(r113, "version:", BuildConfig.FLAVOR, false, 4, null);     // Catch: Exception -> L71
        if (r22 == null) goto L73;
    L75:
        if (r22.length() > 0) goto L78;
        r5 = false;
    L78:
        if (r5 == false) goto L82;
        ResConfig r23 = r2.getResConfig();
        if (r23 == null) goto L82;
        r23.setResVersion(r22);
    L82:
        String r24 = u1b.a.b(r2);
        if (r20 != null) goto L85;
        List<? extends AbsChameleonPlugin> r25 = CollectionsKt.emptyList();
    L86:
        com.ss.android.lark.chameleonv2.container.webcontainer.util.b.e(r24, r2, r25);
        a(r19);
        int r26 = ChameleonFragmentV2.x;
        if (r19 == null) goto L89;
        String r27 = r19.getLoadUrl();
    L90:
        if (r27 == null) goto L94;
        r9 = r27;
    L94:
        return ChameleonFragmentV2.a.a(r18, r9, r24, null);
    L89:
        r27 = null;
        goto L90
    L85:
        r25 = r20;
        goto L86
    L65:
        r112 = null;
    L71:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c("CML_TAG_ChameleonDebugUtils", "Failed to read revision file: " + r17, e);
        goto L73
    L55:
        r17 = VFSFiles.b.v(r13, ChameleonResConstants.TEMPLATE_VERSION).getAbsolutePath();
        goto L95
    L51:
        r15 = null;
        goto L53
    L41:
        r12 = false;
        goto L42
    L26:
        if (r7.length() == 0) goto L29;
        r10 = false;
    L73:
        r22 = BuildConfig.FLAVOR;
        goto L75
    L21:
        r7 = null;
        goto L22
    L13:
        r4 = false;
        goto L14
    L9:
        r1 = null;
        goto L10
    L5:
        r2 = r19;
        goto L6
    }

    @Override // com.ss.android.lark.chameleon.IChameleonApi
    public final AbsChameleonJsRuntime getChameleonJsRuntime(Context r4, String r5, ChameleonBizType r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r6, "bizType");
        int r0 = com.ss.android.lark.officesdk.utils.di.d.a;
        AbsChameleonJsRuntime r1 = (AbsChameleonJsRuntime) e0c.k.a(com.ss.android.lark.officesdk.utils.di.d.a.a(), AbsChameleonJsRuntime.class);
        if (r1 == null) goto L5;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonImpl", "getChameleonJsRuntime init " + com.ss.android.lark.chameleonv2.container.webcontainer.util.b.d(r5) + ',' + r6.getType());
        r1.init(r4, r5, r6);
        return r1;
    L5:
        return null;
    }

    @Override // com.ss.android.lark.chameleon.IChameleonApi
    public final boolean open(Context r5, String r6, Bundle r7) {
        if (r6 != null) goto L9;
        com.ss.android.lark.officesdk.utils.di.j.b("CML_TAG_ChameleonImpl", "targetUrl is null, return");     // Catch: Throwable -> L6
        return false;
    L9:
        if (r7 == null) goto L11;
        Serializable r8 = r7.getSerializable(ChameleonContainerConst.URL_CONFIG_KEY);     // Catch: Throwable -> L6
    L13:
        if ((r8 instanceof ChameleonInterceptorConfig) == false) goto L15;
        ChameleonConfig r9 = b((ChameleonInterceptorConfig) r8);     // Catch: Throwable -> L6
    L16:
        c(r5, r6, r9, null);     // Catch: Throwable -> L6
        return true;
    L15:
        r9 = null;
        goto L16
    L11:
        r8 = null;
    L6:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c("CML_TAG_ChameleonImpl", "openDocChameleonFromBrowser", th);
        return false;
    }

    @Override // com.ss.android.lark.chameleon.IChameleonApi
    public final void open(Context r2, ChameleonConfig r3, List<? extends AbsChameleonPlugin> r4) {
        if (r3 == null) goto L4;
        String r0 = r3.getLoadUrl();
    L5:
        if (r0 != null) goto L7;
        r0 = BuildConfig.FLAVOR;
    L7:
        c(r2, r0, r3, r4);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public static void c(Context r18, String r19, ChameleonConfig r20, List r21) {
        Context r0 = r18;
        String r3 = null;
        if ((r0 instanceof Application) == true) goto L5;
        if (r0 == null) goto L5;
    L11:
        com.ss.android.lark.storage.a r2 = ChameleonDebugUtils.a;
        if (r20 == null) goto L14;
        r3 = r20.getBizName();
    L14:
        String r4 = ChameleonDebugUtils.c(r3);
        boolean r5 = false;
        if (r4.length() <= 0) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == false) goto L25;
        if (r20 == null) goto L21;
        r20.setLoadUrl(r4);
    L21:
        if (r20 == null) goto L26;
        PreloadConfig r7 = r20.getPreloadConfig();
        if (r7 == null) goto L26;
        r7.setTemplateUrl(r4);
    L26:
        if (r20 == null) goto L32;
        OpenConfig r8 = r20.getOpenConfig();
        if (r8 == null) goto L32;
        if (r8.isModelView() != true) goto L32;
        r5 = true;
    L32:
        if (r5 == true) goto L34;
    L36:
        Intent r9 = new Intent(r0, ChameleonActivity.class);
    L38:
        if ((r0 instanceof Application) == false) goto L40;
        r9.addFlags(268435456);
    L40:
        r9.putExtra(ChameleonContainerConst.CHAMELEON_EXTRA_URL, r4);
        if (r20 != null) goto L43;
        ChameleonConfig r10 = new ChameleonConfig(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L44:
        String r11 = u1b.a.b(r10);
        if (r21 != null) goto L47;
        List r12 = CollectionsKt.emptyList();
    L48:
        com.ss.android.lark.chameleonv2.container.webcontainer.util.b.e(r11, r10, r12);
        r9.putExtra("session_id", r11);
        int r13 = com.ss.android.lark.officesdk.utils.di.d.a;
        PassportcConvention.e(r9, com.ss.android.lark.officesdk.utils.di.d.a.a());
        if (r0 == null) goto L51;
        r0.startActivity(r9);
    L51:
        a(r20);
        return;
    L47:
        r12 = r21;
        goto L48
    L43:
        r10 = r20;
        goto L44
    L34:
        if (ForsetiFGHelpers.d() == false) goto L36;
        r9 = new Intent(r0, ModelChameleonActivity.class);
        goto L38
    L25:
        r4 = r19;
        goto L26
    L17:
        r6 = false;
    L5:
        int r1 = com.ss.android.lark.officesdk.utils.di.d.a;
        DependencyContainer r14 = DependencyContainer.a;
        ntb.e r15 = DependencyContainer.a(ntb.e.class, null);
        if (r15 == null) goto L54;
        r0 = r15.getTopActivity();
        if (r0 != null) goto L11;
        r0 = com.ss.android.lark.officesdk.utils.di.d.a.a();
        goto L11
    L54:
        throw new IllegalStateException("IContextDependency not injected");
    }

    @Override // com.ss.android.lark.chameleon.IChameleonApi
    public final void openByForseti(Fragment r4, final ForsetiNavOptions.DestinationStyle r5, ChameleonConfig r6, List<? extends AbsChameleonPlugin> r7) {
        Intrinsics.checkNotNullParameter(r4, "sourceFragment");
        Intrinsics.checkNotNullParameter(r5, "style");
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonImpl", "openByForseti style:" + r5);
        ArrayList r0 = new ArrayList();
        if (r7 == null) goto L5;
        r0.addAll(r7);
    L5:
        r0.add(new ForsetiPlugin(r4));
        Context r8 = r4.getContext();
        if (r8 == null) goto L8;
        Fragment r9 = getChameleonFragment(r8, r6, r0);
    L9:
        if (r9 != null) goto L12;
        com.ss.android.lark.officesdk.utils.di.j.b("CML_TAG_ChameleonImpl", "openByForseti fragment is null, return");
        return;
    L12:
        com.suite.lark.component.navroute.forseti.g r2 = com.suite.lark.component.navroute.forseti.f.b(r4);
        if (r2 == null) goto L15;
        r2.h(new com.suite.lark.component.navroute.fragment.c(r9), new AnonymousClass2(r5));
        return;
    L15:
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonImpl", "openByForseti forsetiRouter is null");
        open(r4.getContext(), r6, r0);
        return;
    L8:
        r9 = null;
        goto L9
    }
}
