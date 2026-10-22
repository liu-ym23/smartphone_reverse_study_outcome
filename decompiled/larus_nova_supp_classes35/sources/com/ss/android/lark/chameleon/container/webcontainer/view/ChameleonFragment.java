package com.ss.android.lark.chameleon.container.webcontainer.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.container.webcontainer.ChameleonWebViewManager;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.SimpleDocWeb;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.title.WebContainerTitleBar;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.config.ChameleonBrowserConfigsImpl;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonLoaderImpl;
import com.ss.android.lark.chameleon.container.webcontainer.preload.PreloadStatus;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.WebFragment;
import com.ss.android.lark.chameleon.pluginsystem.WebPluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginListProvider;
import com.ss.android.lark.chameleon.pluginsystem.plugin.SimpleWebV2;
import com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar;
import com.ss.android.lark.chameleon.utils.ChameleonDebugUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001cH\u0016J\u001a\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonFragment;", "Lcom/ss/android/lark/chameleon/pluginsystem/WebFragment;", "()V", "documentWeb", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/SimpleWebV2;", "webView", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;", "getContext", "Landroid/content/Context;", "getPluginHost", "Lcom/ss/android/lark/chameleon/api/pluginapi/ChameleonPluginHost;", "getPluginListProvider", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginListProvider;", "getWebTag", BuildConfig.FLAVOR, "getchameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "onCreatePluginHost", "Lcom/ss/android/lark/chameleon/pluginsystem/WebPluginHost;", "onCreateTitleBar", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/TitleBar;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", BuildConfig.FLAVOR, "onDestroyView", "onPause", "onResume", "onSaveInstanceState", "outState", "onViewCreated", "view", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonFragment extends WebFragment {
    public static final Companion Companion = null;
    private static final String DOWNLOAD_FG_KEY = "ccm.mobile.Chameleon_download_enable_in_old_container";
    public static final String EXTRA_URL = "url";
    public static final String TAG = "CML_TAG_ChameleonFragment";
    private SimpleWebV2 documentWeb;
    private ChameleonWebView webView;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonFragment$Companion;", BuildConfig.FLAVOR, "()V", "DOWNLOAD_FG_KEY", BuildConfig.FLAVOR, "EXTRA_URL", "TAG", "newInstance", "Landroidx/fragment/app/Fragment;", "context", "Landroid/content/Context;", "url", "sessionId", "bundle", "Landroid/os/Bundle;", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Fragment newInstance(Context r2, String r3, String r4, Bundle r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            if (r5 != null) goto L5;
            r5 = new Bundle();
        L5:
            if (r3 != null) goto L7;
            r3 = BuildConfig.FLAVOR;
        L7:
            r5.putString("url", r3);
            if (r4 == null) goto L10;
            r5.putString("session_id", r4);
        L10:
            Fragment r6 = Fragment.instantiate(r2, ChameleonFragment.class.getName(), r5);
            r6.setArguments(r5);
            return r6;
        }

        public static /* synthetic */ Fragment newInstance$default(Companion r0, Context r1, String r2, String r3, Bundle r4, int r5, Object r6) {
            if ((r5 & 8) == 0) goto L6;
            r4 = null;
        L6:
            return r0.newInstance(r1, r2, r3, r4);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final ChameleonConfig getchameleonConfig() {
        ChameleonContainerUtils r0 = ChameleonContainerUtils.INSTANCE;
        Bundle r1 = getArguments();
        String r2 = BuildConfig.FLAVOR;
        if (r1 == null) goto L5;
        String r3 = r1.getString("session_id", BuildConfig.FLAVOR);
    L6:
        if (r3 == null) goto L10;
        r2 = r3;
    L10:
        return r0.getBizConfig(r2);
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost.Delegate
    public PluginListProvider getPluginListProvider() {
        return new ChameleonBrowserConfigsImpl();
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebFragment
    public WebPluginHost onCreatePluginHost() {
        Log.i(ChameleonContainerUtils.DOC_TRACER_TAG, "ChameleonFragment onCreatePluginHost");
        Bundle r0 = getArguments();
        String r3 = null;
        if (r0 == null) goto L5;
        String r1 = r0.getString("url", BuildConfig.FLAVOR);
    L6:
        if (r1 != null) goto L8;
        r1 = BuildConfig.FLAVOR;
    L8:
        ChameleonConfig r8 = getchameleonConfig();
        ChameleonWebView r11 = ChameleonWebViewManager.INSTANCE.getWebView(r8, getWebTag());
        Log.i(ChameleonContainerUtils.DOC_TRACER_TAG, "ChameleonFragment after get webview");
        Bundle r2 = getArguments();
        if (r2 == null) goto L11;
        String r4 = r2.getString("session_id", BuildConfig.FLAVOR);
    L12:
        if (r4 != null) goto L14;
        String r9 = BuildConfig.FLAVOR;
    L15:
        r11.injectSession(r9);
        ChameleonOpenTracker.SessionTracker r5 = ChameleonOpenTracker.INSTANCE.getSessionTracker(r9);
        if (r5 == null) goto L19;
        r5.recordParam("url", ChameleonContainerUtils.INSTANCE.safeUrlString(r1));
    L19:
        if (r11.getPreloader().getPreloadStatus() != PreloadStatus.INIT) goto L21;
        r11.preload();
    L21:
        Log.i(TAG, "js_perf_tag webCreateTime=" + System.currentTimeMillis());
        this.webView = r11;
        SimpleDocWeb r6 = new SimpleDocWeb(r11, r11.getBridge());
        this.documentWeb = r6;
        Bundle r7 = getArguments();
        if (r7 == null) goto L24;
        r3 = r7.getString("url");
    L24:
        if (r3 != null) goto L26;
        String r10 = BuildConfig.FLAVOR;
    L27:
        ChameleonPluginHost r12 = new ChameleonPluginHost(r6, r10, r8, r9, r11.getWebServiceManager());
        r12.setFragment(this);
        ChameleonLoaderImpl r13 = new ChameleonLoaderImpl(r11);
        r12.setLoader(r13);
        r11.addWebViewClientDelegate(r13);
        return r12;
    L26:
        r10 = r3;
        goto L27
    L14:
        r9 = r4;
        goto L15
    L11:
        r4 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebFragment
    public TitleBar onCreateTitleBar() {
        return new WebContainerTitleBar(new ChameleonFragment$onCreateTitleBar$delegate$1(this));
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebFragment
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
        Bundle r0 = getArguments();
        String r1 = BuildConfig.FLAVOR;
        if (r0 == null) goto L5;
        String r2 = r0.getString("session_id", BuildConfig.FLAVOR);
    L6:
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        ChameleonContainerUtils.INSTANCE.releaseBizConfig(r1);
        ChameleonOpenTracker.INSTANCE.releaseTracker(r1);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebFragment
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView");
        super.onDestroyView();
        ChameleonWebView r0 = this.webView;
        if (r0 == null) goto L11;
        ViewGroup r1 = null;
        r0.setDownloadListener(null);
        ViewParent r2 = r0.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L7;
        r1 = (ViewGroup) r2;
    L7:
        if (r1 == null) goto L9;
        r1.removeView(r0);
    L9:
        ChameleonWebViewManager.INSTANCE.onWebViewDetached(getchameleonConfig(), r0, getWebTag());
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebFragment
    public void onPause() {
        Log.i(TAG, "onPause");
        super.onPause();
        ChameleonWebView r0 = this.webView;
        if (r0 == null) goto L7;
        r0.setVisible(false);
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebFragment
    public void onResume() {
        Log.i(TAG, "onResume");
        super.onResume();
        ChameleonWebView r0 = this.webView;
        if (r0 == null) goto L5;
        r0.onResume();
    L5:
        ChameleonWebView r1 = this.webView;
        if (r1 == null) goto L10;
        r1.setVisible(true);
        return;
    }

    private final Object getWebTag() {
        return Integer.toHexString(hashCode());
    }

    public Context getContext() {
        return super.getContext();
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebFragment
    public ChameleonPluginHost getPluginHost() {
        WebPluginHost r0 = super.getPluginHost();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chameleon.api.pluginapi.ChameleonPluginHost");
        return (ChameleonPluginHost) r0;
    }

    public ChameleonFragment() {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebFragment
    public /* bridge */ /* synthetic */ WebPluginHost getPluginHost() {
        return getPluginHost();
    }

    public static final /* synthetic */ ChameleonConfig access$getchameleonConfig(ChameleonFragment r0) {
        return r0.getchameleonConfig();
    }

    public void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super.onSaveInstanceState(r2);
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        r2.putAll(r0);
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebFragment
    public void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        Bundle r5 = getArguments();
        String r0 = BuildConfig.FLAVOR;
        if (r5 == null) goto L5;
        String r6 = r5.getString("url", BuildConfig.FLAVOR);
    L6:
        if (r6 == null) goto L9;
        r0 = r6;
    L9:
        ViewGroup r7 = (ViewGroup) r3.findViewById(2131367059);
        if (r7 == null) goto L12;
        r7.addView(this.webView, -1, -1);
    L12:
        getPluginHost().getLoader().load(r0);
        if (Env.isDebug() == false) goto L17;
        if (r7 == null) goto L18;
        ChameleonDebugUtils.INSTANCE.addDebugView(getchameleonConfig(), r7);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebFragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559275, r3, false);
    }
}
