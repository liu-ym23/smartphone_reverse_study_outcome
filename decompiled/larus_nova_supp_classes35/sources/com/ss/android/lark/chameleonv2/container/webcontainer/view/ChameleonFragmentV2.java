package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.R;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ChameleonContainerConst;
import com.ss.android.lark.chameleon.ChameleonContainerLifecycleListener;
import com.ss.android.lark.chameleon.IDependency;
import com.ss.android.lark.chameleon.IMonitorDependency;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.TitlebarConfig;
import com.ss.android.lark.chameleon.basewebview.LarkWebView;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.widgetv2.titlebar.CmlCommonTitleBar;
import com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonSafeReuseWeb;
import com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonWebViewManager;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.ChameleonLoaderImpl;
import com.ss.android.lark.chameleonv2.container.webcontainer.preload.PreloadStatus;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ChameleonDebugUtils;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ContainerType;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.hang.HangDetectStrategy;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import vv4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001\\B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0014J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0014J&\u00104\u001a\u0004\u0018\u0001032\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u00102\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u001a\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u0002032\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u000209H\u0016J\b\u0010?\u001a\u00020;H\u0016J\b\u0010@\u001a\u00020;H\u0016J\b\u0010A\u001a\u00020;H\u0016J\b\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020;H\u0016J\b\u0010E\u001a\u00020;H\u0016J\b\u0010F\u001a\u00020;H\u0016J\u0010\u0010G\u001a\u00020;2\u0006\u0010H\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u0004\u0018\u00010\u00102\u0006\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u00020PH\u0002J\n\u0010Q\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010R\u001a\u00020;H\u0002J\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020-H\u0002J\u0018\u0010V\u001a\u00020;2\u0006\u0010U\u001a\u00020-2\u0006\u0010W\u001a\u00020TH\u0002J\u0014\u0010X\u001a\b\u0012\u0002\b\u0003\u0018\u00010Y2\u0006\u0010Z\u001a\u00020[R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u0006]"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonFragmentV2;", "Lcom/bytedance/ee/bear/browser/WebFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "userComponent", "Lcom/ss/android/lark/chameleonv2/usercomponent/IUserComponent;", "getUserComponent", "()Lcom/ss/android/lark/chameleonv2/usercomponent/IUserComponent;", "setUserComponent", "(Lcom/ss/android/lark/chameleonv2/usercomponent/IUserComponent;)V", "webView", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView;", "documentWeb", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/ChameleonSafeReuseWeb;", "webViewContainer", "Landroid/view/ViewGroup;", "leftContainer", "rightContainer", "bottomContainer", "topContainer", "titleBarContainer", "rootContainer", "contentContainer", "businessOverlayContainer", "pluginUIContainer", "lifecycleListener", "Lcom/ss/android/lark/chameleon/ChameleonContainerLifecycleListener;", "getLifecycleListener", "()Lcom/ss/android/lark/chameleon/ChameleonContainerLifecycleListener;", "lifecycleListener$delegate", "Lkotlin/Lazy;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "getPluginUserComponent", "Lcom/bytedance/ee/bear/user/container/UserComponentDelegate;", "getContext", "Landroid/content/Context;", "getPluginListProvider", "Lcom/bytedance/ee/bear/browser/plugin/PluginListProvider;", "createCommonTitleBar", "Lcom/ss/android/lark/chameleon/widgetv2/titlebar/CmlCommonTitleBar;", "onCreateTitleBar", "Lcom/bytedance/ee/bear/browser/plugin/TitleBar;", "getPluginHost", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onCreatePluginHost", "Lcom/bytedance/ee/bear/browser/WebPluginHost;", "onCreateUIContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "contentView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", BuildConfig.FLAVOR, "view", "onSaveInstanceState", "outState", "onStart", "onDestroyView", "onDestroy", "getchameleonConfig", "Lcom/ss/android/lark/chameleon/ChameleonConfig;", "onResume", "onPause", "onStop", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "getContainer", IPortraitService.TYPE, BuildConfig.FLAVOR, "getWebTag", BuildConfig.FLAVOR, "isWebViewAttached", BuildConfig.FLAVOR, "addOverlay", "cleanContainer", "setPluginMounter", "Lcom/bytedance/ee/bear/browser/plugin/lazy/LazyPluginMounter;", "pluginHost", "bindDefaultLoadCallbacks", "lazyMounter", "getFragmentWebHandler", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "handlerName", BuildConfig.FLAVOR, "Companion", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChameleonFragmentV2 extends Hilt_ChameleonFragmentV2 implements d0c.c {
    public static final /* synthetic */ int x = 0;

    @Inject
    public v1b.a l;
    public ChameleonWebView m;
    public ChameleonSafeReuseWeb n;
    public ViewGroup o;
    public ViewGroup p;
    public ViewGroup q;
    public ViewGroup r;
    public ViewGroup s;
    public ViewGroup t;
    public ViewGroup u;
    public ViewGroup v;
    public final Lazy w;

    public static final class a {
        @JvmStatic
        public static Fragment a(Context r1, String r2, String r3, Bundle r4) {
            Intrinsics.checkNotNullParameter(r1, "context");
            if (r4 == null) goto L10;
            Object r5 = r4.clone();
            if ((r5 instanceof Bundle) == false) goto L7;
            Bundle r6 = (Bundle) r5;
        L8:
            if (r6 != null) goto L11;
            r6 = new Bundle();
        L11:
            if (r2 != null) goto L13;
            r2 = BuildConfig.FLAVOR;
        L13:
            r6.putString(ChameleonContainerConst.CHAMELEON_EXTRA_URL, r2);
            if (r3 == null) goto L16;
            r6.putString("session_id", r3);
        L16:
            int r7 = com.ss.android.lark.officesdk.utils.di.d.a;
            PassportcConvention.f(r6, com.ss.android.lark.officesdk.utils.di.d.a.a());
            Fragment r8 = Fragment.instantiate(r1, ChameleonFragmentV2.class.getName(), r6);
            r8.setArguments(r6);
            return r8;
        L7:
            r6 = null;
            goto L8
        L10:
            r6 = new Bundle();
            goto L11
        }
    }

    public static final class b implements com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.title.b.a {
        public final /* synthetic */ ChameleonFragmentV2 a;

        public final CmlCommonTitleBar a() {
            ChameleonFragmentV2 r0 = this.a;
            int r1 = ChameleonFragmentV2.x;
            r0.getClass();
            CmlCommonTitleBar r2 = new CmlCommonTitleBar(r0.requireContext());
            FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-1, -1);
            r3.gravity = 17;
            r2.setLayoutParams(r3);
            r2.setBackgroundResource(R.color.transparent);
            return r2;
        }

        public final Boolean b() {
            ChameleonFragmentV2 r0 = this.a;
            int r1 = ChameleonFragmentV2.x;
            OpenConfig r2 = r0.ca0().getOpenConfig();
            boolean r3 = false;
            if (r2 == null) goto L10;
            TitlebarConfig r4 = r2.getTitlebarConfig();
            if (r4 == null) goto L10;
            if (r4.getShowTitlebar() == true) goto L10;
            r3 = true;
        L10:
            return Boolean.valueOf(!r3);
        }

        @Override // com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.title.b.a
        public FragmentActivity getActivity() {
            FragmentActivity r0 = this.a.getActivity();
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new IllegalStateException("activity is null");
        }

        public b(ChameleonFragmentV2 r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final ChameleonContainerLifecycleListener aa0() {
        return (ChameleonContainerLifecycleListener) this.w.getValue();
    }

    public final ChameleonPluginHost ba0() {
        WebPluginHost r0 = ((WebFragment) this).e;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost");
        return (ChameleonPluginHost) r0;
    }

    public final o getPluginListProvider() {
        return new com.ss.android.lark.chameleonv2.container.webcontainer.plugin.a();
    }

    public final void onDestroy() {
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonFragmentV2", "onDestroy:  " + getWebTag());
        ChameleonContainerLifecycleListener r0 = aa0();
        if (r0 == null) goto L5;
        r0.onPreFragmentDestroy(ba0());
    L5:
        super.onDestroy();
        ChameleonSafeReuseWeb r1 = this.n;
        String r2 = null;
        if (r1 == null) goto L11;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonSafeReuseWeb", "onOwnerDestroy");
        r1.d = false;
        r1.e = null;
        if (r1.K() == null) goto L11;
        xwb.a r3 = r1.K().getBridge();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, "interceptor");
        r3.d.remove(r1);
        ChameleonWebView r4 = r1.K();
        ((CopyOnWriteArrayList) r4.g2.e).remove(r1.f);
        ChameleonWebView r5 = r1.K();
        ((CopyOnWriteArrayList) r5.h2.d).remove(r1.g);
        r1.K().removeOnAttachStateChangeListener(r1.k);
    L11:
        Bundle r6 = getArguments();
        String r7 = BuildConfig.FLAVOR;
        if (r6 == null) goto L14;
        r2 = r6.getString("session_id", BuildConfig.FLAVOR);
    L14:
        if (r2 == null) goto L17;
        r7 = r2;
    L17:
        Map<String, Pair<ChameleonConfig, List<AbsChameleonPlugin>>> r8 = com.ss.android.lark.chameleonv2.container.webcontainer.util.b.a;
        Intrinsics.checkNotNullParameter(r7, "session");
        com.ss.android.lark.chameleonv2.container.webcontainer.util.b.a.remove(r7);
        Map<String, u1b.a.C0305a> r9 = u1b.a.a;
        Intrinsics.checkNotNullParameter(r7, "session");
        u1b.a.a.remove(r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.View, android.webkit.WebView, com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView] */
    public final void onDestroyView() {
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonFragmentV2", "onDestroyView:  " + getWebTag());
        ChameleonContainerLifecycleListener r0 = aa0();
        if (r0 == null) goto L5;
        r0.onPreFragmentDestroyView(ba0());
    L5:
        super.onDestroyView();
        ChameleonWebView r1 = this.m;
        if (r1 == null) goto L10;
        n r2 = r1.getWebServiceManager();
        if (r2 == null) goto L10;
        r2.d();
    L10:
        ?? r3 = this.m;
        if (r3 == 0) goto L23;
        r3.setDownloadListener(null);
        ViewParent r4 = r3.getParent();
        if ((r4 instanceof ViewGroup) == false) goto L15;
        ViewGroup r5 = (ViewGroup) r4;
    L16:
        if (r5 == 0) goto L18;
        r5.removeView(r3);
    L18:
        v1b.a r6 = this.l;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("userComponent");
        r6 = null;
    L22:
        r6.F2().g(ca0(), r3, getWebTag());
        goto L23
    L15:
        r5 = 0;
    L23:
        this.p = null;
        this.q = null;
        this.s = null;
        this.r = null;
        this.t = null;
        this.u = null;
        this.v = null;
    }

    public final void onPause() {
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonFragmentV2", "onPause:  " + getWebTag());
        ChameleonContainerLifecycleListener r0 = aa0();
        if (r0 == null) goto L5;
        r0.onPreFragmentPause(ba0());
    L5:
        super.onPause();
        ChameleonWebView r1 = this.m;
        if (r1 == null) goto L8;
        r1.onPause();
    L8:
        ChameleonWebView r2 = this.m;
        if (r2 == null) goto L12;
        r2.setIsVisible(false);
        return;
    }

    public final void onResume() {
        ChameleonContainerLifecycleListener r1 = aa0();
        if (r1 == null) goto L5;
        r1.onPreFragmentResume(ba0());
    L5:
        super.onResume();
        ChameleonWebView r2 = this.m;
        if (r2 == null) goto L8;
        r2.onResume();
    L8:
        ChameleonWebView r3 = this.m;
        boolean r4 = true;
        if (r3 == null) goto L27;
        r3.setIsVisible(true);
    L27:
        ViewGroup r5 = this.o;     // Catch: Exception -> L19
        if (r5 == null) goto L16;
        View r6 = r5.getChildAt(0);     // Catch: Exception -> L19
    L17:
        if (r6 != null) goto L21;
    L20:
        r4 = false;
    L21:
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonFragmentV2", "onResume:  " + getWebTag() + ",   isAttached:  " + r4);
        if (r4 == true) goto L29;
        ChameleonSafeReuseWeb r0 = this.n;
        if (r0 == null) goto L30;
        r0.o(ba0());
        return;
    L30:
        return;
    L29:
        return;
    L16:
        r6 = null;
    L19:
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonFragmentV2", "isWebViewAttached exception");
        goto L20
    }

    public ChameleonFragmentV2() {
        this.w = LazyKt.lazy(new ChameleonFragmentV2$lifecycleListener$2(this));
    }

    public final WebPluginHost W90() {
        Bundle r0 = getArguments();
        String r2 = null;
        if (r0 == null) goto L5;
        String r1 = r0.getString(ChameleonContainerConst.CHAMELEON_EXTRA_URL, BuildConfig.FLAVOR);
    L6:
        if (r1 != null) goto L8;
        r1 = BuildConfig.FLAVOR;
    L8:
        ChameleonConfig r7 = ca0();
        v1b.a r4 = this.l;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("userComponent");
        r4 = null;
    L12:
        ChameleonWebView r11 = r4.F2().f(r7, getWebTag());
        Bundle r5 = getArguments();
        if (r5 == null) goto L15;
        String r6 = r5.getString("session_id", BuildConfig.FLAVOR);
    L16:
        if (r6 != null) goto L18;
        String r12 = BuildConfig.FLAVOR;
    L19:
        r11.V1 = r12;
        u1b.a.C0305a r8 = u1b.a.a(r12);
        if (r8 == null) goto L23;
        String r3 = com.ss.android.lark.chameleonv2.container.webcontainer.util.b.d(r1);
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        r8.e.put("url", r3);
    L23:
        if (r11.getPreloader().c() != PreloadStatus.INIT) goto L25;
        r11.z();
    L25:
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonFragmentV2", "js_perf_tag webCreateTime=" + System.currentTimeMillis() + ",   chameleonConfig=" + r7);
        this.m = r11;
        ChameleonSafeReuseWeb r9 = new ChameleonSafeReuseWeb(r11);
        this.n = r9;
        r9.s(true, Integer.valueOf(hashCode()));
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = ChameleonFragmentV2$onCreatePluginHost$pluginMounterBinder$1.INSTANCE;
        ChameleonSafeReuseWeb r13 = this.n;
        Bundle r14 = getArguments();
        if (r14 == null) goto L28;
        r2 = r14.getString(ChameleonContainerConst.CHAMELEON_EXTRA_URL);
    L28:
        if (r2 != null) goto L30;
        String r15 = BuildConfig.FLAVOR;
    L31:
        final ChameleonPluginHost r16 = new ChameleonPluginHost(r13, r15, r7, r12, r11.getWebServiceManager(), new ChameleonFragmentV2$onCreatePluginHost$pluginHost$1(this, r10));
        r16.setFragment(this);
        ChameleonLoaderImpl r17 = new ChameleonLoaderImpl(r11);
        r16.setLoader(r17);
        com.ss.android.lark.chameleonv2.container.webcontainer.i r18 = r11.g2;
        if (((CopyOnWriteArrayList) r18.e).contains(r17) == true) goto L34;
        ((CopyOnWriteArrayList) r18.e).add(r17);
    L34:
        final yv4.e r19 = new yv4.e(r16);
        r16.setPluginMounter(r19);
        ChameleonSafeReuseWeb r20 = this.n;
        if (r20 == null) goto L37;
        r20.j = new c(r19);
    L37:
        r10.element = new ChameleonFragmentV2$onCreatePluginHost$2(this, r16, r19);
        u1b.a.C0305a r21 = u1b.a.a(r12);
        if (r21 == null) goto L40;
        r21.c = r16;
    L40:
        return r16;
    L30:
        r15 = r2;
        goto L31
    L18:
        r12 = r6;
        goto L19
    L15:
        r6 = null;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public final TitleBar X90() {
        ChameleonContainerLifecycleListener r0 = aa0();
        if (r0 == null) goto L6;
        r0.onPreCreateTitleBar(ba0());
    L6:
        return new com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.title.b(new b(this));
    }

    public final ChameleonConfig ca0() {
        Bundle r0 = getArguments();
        String r1 = BuildConfig.FLAVOR;
        if (r0 == null) goto L5;
        String r2 = r0.getString("session_id", BuildConfig.FLAVOR);
    L6:
        if (r2 == null) goto L10;
        r1 = r2;
    L10:
        return com.ss.android.lark.chameleonv2.container.webcontainer.util.b.b(r1);
    L5:
        r2 = null;
        goto L6
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    public final vo5.a ej() {
        return com.bytedance.ee.bear.browser.plugin.m.a(this);
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.view.Hilt_ChameleonFragmentV2
    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return swb.h.a(r0);
    }

    public final Object getWebTag() {
        return Integer.toHexString(hashCode());
    }

    public final void onStart() {
        ChameleonContainerLifecycleListener r0 = aa0();
        if (r0 == null) goto L5;
        r0.onPreFragmentStart(ba0());
    L5:
        super.onStart();
    }

    public final void onStop() {
        ChameleonContainerLifecycleListener r0 = aa0();
        if (r0 == null) goto L5;
        r0.onPreFragmentStop(ba0());
    L5:
        super.onStop();
        ChameleonWebView r1 = this.m;
        if (r1 == null) goto L70;
        com.ss.android.lark.officesdk.utils.di.j.e(LarkWebView.TAG, "lark webview onStop, biz = " + ((OfficeWebView) r1).n);
        oxb.n r2 = r1.getServiceManager();
        if (r2 == null) goto L12;
        jxb.a r3 = r2.a(jxb.a.class);
        if (r3 == null) goto L12;
        r3.stop();
    L12:
        com.ss.android.lark.officesdk.utils.di.j.e(r1.P0, "onStop");
        if (ixb.a.a() == false) goto L60;
        long r4 = (System.currentTimeMillis() - r1.k1) / 1000;
        int r5 = com.ss.android.lark.officesdk.utils.di.d.a;
        v1b.a r6 = (v1b.a) e0c.k.a(com.ss.android.lark.officesdk.utils.di.d.a.a(), v1b.a.class);
        if (r6 == null) goto L21;
        ChameleonWebViewManager r7 = r6.F2();
        if (r7 == null) goto L21;
        List r8 = CollectionsKt.toList(r7.c);
        if (r8 == null) goto L21;
    L22:
        List r9 = r8;
        if ((!r9.isEmpty()) == false) goto L28;
        Iterator r10 = r8.iterator();
    L26:
        if (r10.hasNext() == false) goto L28;
        String r11 = (String) r10.next();
        com.ss.android.lark.officesdk.utils.di.j.e(r1.P0, "unfinished biz=" + r11);
    L28:
        String r12 = r1.V0.getBizName();
        String r13 = BuildConfig.FLAVOR;
        if (r12 != null) goto L31;
        r12 = BuildConfig.FLAVOR;
    L31:
        HangDetectStrategy r14 = r1.Q1;
        if (r14 == null) goto L34;
        int r15 = r14.getType();
    L35:
        Integer r16 = Integer.valueOf(r15);
        r1.getWebView().getUrl();
        Integer r17 = Integer.valueOf(r1.getUsedCount());
        Long r18 = Long.valueOf(r4);
        Boolean r19 = Boolean.valueOf(r1.P1);
        if ((!r9.isEmpty()) == false) goto L38;
        r13 = (String) ListProtector.get(r8, 0);
    L38:
        JSONObject r20 = new JSONObject();
        r20.put(ChameleonOpenTracker.ParamKey.APP_NAME, r12);
        r20.put("from", r16);
        r20.put("used_count", r17);
        r20.put("used_time", r18);
        r20.put(ChameleonOpenTracker.ParamKey.COST, 0L);
        r20.put("anr", r19);
        r20.put("unfinished", r13);
        ChameleonFragmentV2 r21 = r1.getFragment();
        if ((r21 instanceof ChameleonFragmentV2) == false) goto L41;
        ChameleonFragmentV2 r22 = r21;
    L42:
        if (r22 == null) goto L59;
        ChameleonPluginHost r23 = r22.ba0();
        if (r23 == null) goto L59;
        IDependency r24 = r1.getChameleonConfig().getDependency();
        if (r24 == null) goto L59;
        IMonitorDependency r25 = r24.getMonitorDependency();
        if (r25 == null) goto L59;
        Map<String, Object> r26 = r25.getBizParams(r23);
        if (r26 == null) goto L59;
        Iterator<Map.Entry<String, Object>> r27 = r26.entrySet().iterator();
    L53:
        if (r27.hasNext() == false) goto L59;
        Map.Entry<String, Object> r28 = r27.next();
        String r29 = r28.getKey();
        Object r30 = r28.getValue();
        if (r20.has(r29) == true) goto L53;
        r20.put(r29, r30);     // Catch: Exception -> L58
    L58:
        com.ss.android.lark.officesdk.utils.di.j.f(r1.P0, "skip invalid biz param: " + r29);
    L59:
        u1b.b.b("webapp_webview_responsive_state_dev", r20);
        goto L60
    L41:
        r22 = null;
        goto L42
    L34:
        r15 = 0;
    L21:
        r8 = CollectionsKt.emptyList();
    L60:
        r1.P1 = false;
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m61provideComponent() {
        return provideComponent();
    }

    public final t Y90(View r5) {
        Intrinsics.checkNotNullParameter(r5, "contentView");
        OpenConfig r0 = ca0().getOpenConfig();
        if (r0 == null) goto L8;
        Function4<ChameleonPluginHost, View, FragmentManager, TitleBar, t> r1 = r0.getOnCreateUIContainer();
        if (r1 == null) goto L8;
        t r2 = (t) r1.invoke(ba0(), r5, getChildFragmentManager(), U90());
        if (r2 == null) goto L8;
    L9:
        ChameleonContainerLifecycleListener r6 = aa0();
        if (r6 == null) goto L12;
        ChameleonPluginHost r3 = ba0();
        Intrinsics.checkNotNull(r2);
        r6.onPreCreateUIContainer(r3, r2);
    L12:
        Intrinsics.checkNotNull(r2);
        return r2;
    L8:
        r2 = super.Y90(r5);
        goto L9
    }

    public final ViewGroup getContainer(int r5) {
        View r0 = getView();
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r5 != ContainerType.Left.getValue()) goto L14;
        ViewGroup r6 = this.p;
        if (r6 != null) goto L75;
        r6 = (ViewGroup) r0.findViewById(2131367050);
        if (r6 == null) goto L67;
        this.p = r6;
        r6.setVisibility(0);
        goto L75
    L67:
        return null;
    L75:
        return r6;
    L14:
        if (r5 != ContainerType.Right.getValue()) goto L21;
        r6 = this.q;
        if (r6 != null) goto L75;
        r6 = (ViewGroup) r0.findViewById(2131367054);
        if (r6 == null) goto L76;
        this.q = r6;
        r6.setVisibility(0);
        goto L75
    L76:
        return null;
    L21:
        if (r5 != ContainerType.Top.getValue()) goto L28;
        r6 = this.s;
        if (r6 != null) goto L75;
        r6 = (ViewGroup) r0.findViewById(2131367058);
        if (r6 == null) goto L77;
        this.s = r6;
        r6.setVisibility(0);
        goto L75
    L77:
        return null;
    L28:
        if (r5 != ContainerType.Bottom.getValue()) goto L35;
        r6 = this.r;
        if (r6 != null) goto L75;
        r6 = (ViewGroup) r0.findViewById(2131367044);
        if (r6 == null) goto L78;
        this.r = r6;
        r6.setVisibility(0);
        goto L75
    L78:
        return null;
    L35:
        if (r5 != ContainerType.Web.getValue()) goto L42;
        r6 = this.o;
        if (r6 != null) goto L75;
        r6 = (ViewGroup) r0.findViewById(2131367059);
        if (r6 == null) goto L79;
        this.o = r6;
        goto L75
    L79:
        return null;
    L42:
        if (r5 != ContainerType.Title.getValue()) goto L47;
        r6 = (ViewGroup) r0.findViewById(2131367057);
        if (r6 == null) goto L80;
        r6.setVisibility(0);
        goto L75
    L80:
        return null;
    L47:
        if (r5 != ContainerType.Root.getValue()) goto L54;
        r6 = this.t;
        if (r6 != null) goto L75;
        r6 = (ViewGroup) r0.findViewById(2131367055);
        if (r6 == null) goto L81;
        this.t = r6;
        goto L75
    L81:
        return null;
    L54:
        if (r5 != ContainerType.Content.getValue()) goto L61;
        r6 = this.u;
        if (r6 != null) goto L75;
        r6 = (ViewGroup) r0.findViewById(2131367812);
        if (r6 == null) goto L82;
        this.u = r6;
        goto L75
    L82:
        return null;
    L61:
        if (r5 != ContainerType.BusinessOverlay.getValue()) goto L68;
        r6 = this.v;
        if (r6 != null) goto L75;
        r6 = (ViewGroup) r0.findViewById(2131367045);
        if (r6 == null) goto L83;
        this.v = r6;
        r6.setVisibility(0);
        goto L75
    L83:
        return null;
    L68:
        View r7 = getView();
        if (r7 == null) goto L84;
        ViewGroup r8 = (ViewGroup) r7.findViewById(2131382479);
        if (r8 == null) goto L85;
        FrameLayout r1 = new FrameLayout(requireContext());
        r1.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r8.addView(r1);
        return r1;
    L85:
        return null;
    L84:
        return null;
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        ChameleonContainerLifecycleListener r0 = aa0();
        if (r0 == null) goto L5;
        r0.onPreConfigurationChanged(ba0(), r3);
    L5:
        super.onConfigurationChanged(r3);
    }

    public final void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(r2);
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        r2.putAll(r0);
        return;
    }

    public final void onViewCreated(View r22, Bundle r23) {
        Intrinsics.checkNotNullParameter(r22, "view");
        ViewGroup r2 = (ViewGroup) r22.findViewById(2131367059);
        this.o = r2;
        if (r2 == null) goto L5;
        r2.addView(this.m, -1, -1);
    L5:
        ChameleonWebView r3 = this.m;
        if (r3 == null) goto L10;
        n r4 = r3.getWebServiceManager();
        if (r4 == null) goto L10;
        r4.e();
    L10:
        ChameleonContainerLifecycleListener r5 = aa0();
        if (r5 == null) goto L13;
        r5.onPreFragmentViewCreated(ba0());
    L13:
        super.onViewCreated(r22, r23);
        Bundle r1 = getArguments();
        String r6 = null;
        String r7 = BuildConfig.FLAVOR;
        if (r1 == null) goto L16;
        String r8 = r1.getString(ChameleonContainerConst.CHAMELEON_EXTRA_URL, BuildConfig.FLAVOR);
    L17:
        if (r8 == null) goto L20;
        r7 = r8;
    L20:
        ba0().getLoader().load(r7);
        if (com.ss.android.lark.chameleonv2.container.webcontainer.util.b.a() == false) goto L106;
        ViewGroup r9 = getContainer(ContainerType.Full.getValue());
        if (r9 == null) goto L107;
        com.ss.android.lark.storage.a r10 = ChameleonDebugUtils.a;
        ChameleonConfig r11 = ca0();
        Intrinsics.checkNotNullParameter(r11, "config");
        Intrinsics.checkNotNullParameter(r9, "viewGroup");
        Context r12 = r9.getContext();
        if (r12 != null) goto L28;
    L101:
        Intrinsics.checkNotNullParameter(r9, "viewGroup");
        Context r13 = r9.getContext();
        if (r13 == null) goto L108;
        View r14 = new com.ss.android.lark.chameleonv2.container.webcontainer.util.c(r13, 1000, 5);
        r14.setBackgroundColor(0);
        r14.setClickable(false);
        r9.addView(r14, -1, -1);
        return;
    L108:
        return;
    L28:
        if (((TextView) r9.findViewWithTag("chameleon_debug_view")) == null) goto L30;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonDebugUtils", "Debug view already exists.");
        goto L101
    L30:
        KVRepo r15 = ChameleonDebugUtils.b();
        int r16 = com.ss.android.lark.officesdk.utils.di.e.a;
        DependencyContainer r17 = DependencyContainer.a;
        ntb.f r18 = DependencyContainer.a(ntb.f.class, null);
        if (r18 == null) goto L33;
        r18.e0();
        boolean r19 = true;
    L35:
        if (r15.getBoolean("chameleon_disable_debug_view", !r19) == true) goto L91;
        ArrayList r110 = new ArrayList();
        r110.add("业务：" + r11.getBizName() + '\n');
        boolean r20 = ChameleonDebugUtils.b().getBoolean("chameleon_disable_ip_proxy", false);
        String r111 = ChameleonDebugUtils.a();
        String r112 = ChameleonDebugUtils.b().getString("chameleon_ip_proxy_url", null);
        if (Intrinsics.areEqual(r111, r11.getBizName()) == false) goto L47;
        if (r112 != null) goto L41;
    L44:
        boolean r113 = true;
    L45:
        if (r113 == true) goto L47;
        boolean r114 = true;
    L48:
        String r115 = "禁用";
        if (r114 == false) goto L52;
        if (r20 == true) goto L52;
        String r116 = "生效中";
    L56:
        r110.add("前端代理配置：".concat(r116));
        if (r114 == false) goto L60;
        if (r20 == true) goto L60;
        r110.add("前端代理地址:\n" + r112);
    L60:
        boolean r21 = ChameleonDebugUtils.b().getBoolean("chameleon_disable_offline_res", false);
        String r24 = ChameleonDebugUtils.b().getString("chameleon_specific_bizname", null);
        String r117 = ChameleonDebugUtils.b().getString("chameleon_specific_version", null);
        if (Intrinsics.areEqual(r24, r11.getBizName()) == false) goto L70;
        if (r117 != null) goto L64;
    L67:
        boolean r25 = true;
    L68:
        if (r25 == true) goto L70;
        boolean r118 = true;
    L71:
        if (r118 == false) goto L74;
        if (r21 == true) goto L74;
        r115 = "生效中";
    L78:
        r110.add("\n离线资源配置：".concat(r115));
        if (r118 == false) goto L83;
        if (r21 == true) goto L83;
        r110.add("离线资源版本:" + r117);
    L90:
        r6 = CollectionsKt.joinToString$default(r110, "\n", null, null, 0, null, null, 62, null);
    L83:
        if (Intrinsics.areEqual(r11.getBizName(), "document") == false) goto L90;
        int r26 = com.ss.android.lark.officesdk.utils.di.d.a;
        Application r27 = com.ss.android.lark.officesdk.utils.di.d.a.a();
        com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.a.a.getClass();
        com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.b r28 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.a.b(r11, r27);
        if (r28 == null) goto L87;
        r6 = r28.b;
    L87:
        if (r6 == null) goto L89;
        r110.add("使用本地资源 (版本:" + r28.b + ')');
        goto L90
    L89:
        r110.add("请求网络资源");
    L74:
        if (r118 == false) goto L77;
        if (r21 == true) goto L78;
    L77:
        r115 = "未手动配置";
        goto L78
    L64:
        if (r117.length() == 0) goto L67;
        r25 = false;
    L70:
        r118 = false;
    L52:
        if (r114 == false) goto L55;
        if (r20 == false) goto L55;
        r116 = "禁用";
    L55:
        r116 = "未配置";
        goto L56
    L41:
        if (r112.length() == 0) goto L44;
        r113 = false;
    L47:
        r114 = false;
    L91:
        if (r6 == null) goto L101;
        TextView r29 = new TextView(r12);
        r29.setText(r6);
        r29.setTag("chameleon_debug_view");
        r29.setTextColor(-1);
        r29.setBackgroundColor(ColorProtector.parseColor("#80000000"));
        r29.setTextSize(12.0f);
        if ((r9 instanceof FrameLayout) == false) goto L97;
        ConstraintLayout.LayoutParams r30 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams) r30).gravity = 8388661;
    L100:
        r30.setMargins(40, 100, 40, 100);
        r29.setLayoutParams(r30);
        r9.addView(r29);
        goto L101
    L97:
        if ((r9 instanceof ConstraintLayout) == false) goto L99;
        r30 = new ConstraintLayout.LayoutParams(-2, -2);
        r30.endToEnd = 0;
        r30.bottomToBottom = 0;
        goto L100
    L99:
        r30 = new ViewGroup.MarginLayoutParams(-2, -2);
        goto L100
    L33:
        r19 = false;
        goto L35
    L107:
        return;
    L106:
        return;
    L16:
        r8 = null;
        goto L17
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559276, r3, false);
    }
}
