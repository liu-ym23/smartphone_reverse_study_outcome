package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.title;

import android.net.Uri;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.TitleType;
import com.ss.android.lark.chameleon.TitlebarConfig;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginId;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.pluginapi.RootBackPressAbility;
import com.ss.android.lark.chameleon.pluginapi.RootBackPressResult;
import com.ss.android.lark.chameleon.pluginapi.RootBackPressSource;
import com.ss.android.lark.officesdk.utils.di.j;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/title/TitleBarPlugin;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "<init>", "()V", "mMenuCallback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "hasLoadDone", BuildConfig.FLAVOR, "getPluginId", BuildConfig.FLAVOR, "getTitleView", "Landroid/view/View;", "setTitle", BuildConfig.FLAVOR, "title", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onBackPressed", "handleBackClick", "source", "Lcom/ss/android/lark/chameleon/pluginapi/RootBackPressSource;", "dispatchRootBackPressed", "defaultAction", "Lkotlin/Function0;", "onDetachFromHost", "Companion", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TitleBarPlugin extends AbsChameleonPlugin implements sa5.d {
    public static final String BACK_CMD = "javascript:window.history.back(-1)";
    public static final a Companion = null;
    public static final String NULL_URL = "about:blank";
    public static final String TAG = "CML_TAG_TitleBarPlugin";
    private boolean hasLoadDone;
    private m mMenuCallback;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RootBackPressResult.values().length];
            r0[RootBackPressResult.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[RootBackPressResult.CONSUMED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[RootBackPressResult.PROPAGATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ TitleBarPlugin a;

        public c(TitleBarPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            TitleBarPlugin.access$handleBackClick(this.a, RootBackPressSource.TITLE_BACK);
        }
    }

    public static final class d implements IChameleonLoader.LoadingCallback {
        public final /* synthetic */ TitleBarPlugin a;

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final void onLoadStart() {
            TitleBarPlugin.access$setHasLoadDone$p(this.a, false);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final void onLoadSuccess() {
            TitleBarPlugin.access$setHasLoadDone$p(this.a, true);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final boolean getKeepOnRelease() {
            return IChameleonLoader.LoadingCallback.DefaultImpls.getKeepOnRelease(this);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final void onLoadSuccessByJS() {
            IChameleonLoader.LoadingCallback.DefaultImpls.onLoadSuccessByJS(this);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        @Deprecated(message = "已废弃，使用IRenderGoneListener")
        public final void onRenderProcessGone() {
            IChameleonLoader.LoadingCallback.DefaultImpls.onRenderProcessGone(this);
        }

        public d(TitleBarPlugin r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final void onPageStarted(String r1) {
            IChameleonLoader.LoadingCallback.DefaultImpls.onPageStarted(this, r1);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final void onLoadFail(int r1, Throwable r2) {
            TitleBarPlugin.access$setHasLoadDone$p(this.a, true);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final void onLoadFailByJS(String r1, int r2) {
            IChameleonLoader.LoadingCallback.DefaultImpls.onLoadFailByJS(this, r1, r2);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
        public final void onReceivedTitle(WebView r6, String r7) {
            j.e("CML_TAG_TitleBarPlugin", "onReceivedTitle, title = " + r7);
            if (r6 != null) goto L24;
        L20:
            this.a.setTitle(r7);     // Catch: Throwable -> L18
            return;
        L24:
            String r8 = r6.getUrl();     // Catch: Throwable -> L18
            if (r8 == null) goto L20;
            Uri r9 = UriProtector.parse(r8);     // Catch: Throwable -> L18
            if (r9 == null) goto L20;
            if (r9.getPath() == null) goto L20;
            boolean r1 = false;
            if (r7 != null) goto L13;
        L15:
            if (r1 == false) goto L20;
            j.e("CML_TAG_TitleBarPlugin", "onReceivedTitle  return , title = " + r7);     // Catch: Throwable -> L18
            return;
        L13:
            if (StringsKt.contains$default(r7, String.valueOf(r9.getPath()), false, 2, null) != true) goto L15;
            r1 = true;
        L18:
            th = move-exception;
            j.d("CML_TAG_TitleBarPlugin", th);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public String getPluginId() {
        return ChameleonPluginId.TitleBarPlugin.getValue();
    }

    public boolean onBackPressed() {
        return handleBackClick(RootBackPressSource.SYSTEM_BACK);
    }

    public View getTitleView() {
        OpenConfig r0 = getChameleonConfig().getOpenConfig();
        if (r0 == null) goto L35;
        TitlebarConfig r1 = r0.getTitlebarConfig();
        if (r1 == null) goto L35;
        TitleType r2 = r1.getTitleType();
        if (r2 == null) goto L35;
        Integer r3 = r2.getSize();
        if (r3 == null) goto L35;
        int r4 = r3.intValue();
        j.e("CML_TAG_TitleBarPlugin", "onAttachToUIContainer, size = " + r4);
        if (r4 != 0) goto L13;
        ChameleonPluginHost r5 = getHost();
        if (r5 == null) goto L35;
        t r6 = r5.getUIContainer();
        if (r6 == null) goto L35;
        TitleBar r7 = r6.getTitleBar();
        if (r7 == null) goto L35;
        r7.setTitleSize(2131165496);
        goto L35
    L13:
        if (r4 == 2) goto L21;
        ChameleonPluginHost r8 = getHost();
        if (r8 == null) goto L35;
        t r9 = r8.getUIContainer();
        if (r9 == null) goto L35;
        TitleBar r10 = r9.getTitleBar();
        if (r10 == null) goto L35;
        r10.setTitleSize(2131165495);
        goto L35
    L21:
        ChameleonPluginHost r11 = getHost();
        if (r11 == null) goto L35;
        t r12 = r11.getUIContainer();
        if (r12 == null) goto L35;
        TitleBar r13 = r12.getTitleBar();
        if (r13 == null) goto L35;
        r13.setTitleSize(2131165494);
    L35:
        OpenConfig r14 = getChameleonConfig().getOpenConfig();
        if (r14 == null) goto L59;
        TitlebarConfig r15 = r14.getTitlebarConfig();
        if (r15 == null) goto L59;
        TitleType r16 = r15.getTitleType();
        if (r16 == null) goto L59;
        Integer r17 = r16.getPosition();
        if (r17 == null) goto L59;
        int r18 = r17.intValue();
        j.e("CML_TAG_TitleBarPlugin", "onAttachToUIContainer, position = " + r18);
        if (r18 != 0) goto L52;
        ChameleonPluginHost r19 = getHost();
        if (r19 == null) goto L59;
        t r20 = r19.getUIContainer();
        if (r20 == null) goto L59;
        TitleBar r21 = r20.getTitleBar();
        if (r21 == null) goto L59;
        r21.b(TitleBar.TitleGravity.Left);
        goto L59
    L52:
        ChameleonPluginHost r22 = getHost();
        if (r22 == null) goto L59;
        t r23 = r22.getUIContainer();
        if (r23 == null) goto L59;
        TitleBar r24 = r23.getTitleBar();
        if (r24 == null) goto L59;
        r24.b(TitleBar.TitleGravity.Center);
    L59:
        t r25 = getUIContainer();
        if (r25 == null) goto L64;
        TitleBar r26 = r25.getTitleBar();
        if (r26 == null) goto L64;
        r26.setLeftClickListener(new c(this));
    L64:
        t r27 = getHost().getUIContainer();
        if (r27 == null) goto L67;
        TitleBar r28 = r27.getTitleBar();
    L69:
        if ((r28 instanceof com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.title.b) == false) goto L71;
        com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.title.b r29 = (com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.title.b) r28;
    L72:
        if (r29 != null) goto L74;
        return null;
    L74:
        return r29.b;
    L71:
        r29 = null;
        goto L72
    L67:
        r28 = null;
        goto L69
    }

    public TitleBarPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(TitleBarPlugin r0) {
        return r0.getActivity();
    }

    private final boolean handleBackClick(RootBackPressSource r10) {
        ChameleonPluginHost r4 = getHost();     // Catch: Throwable -> L78
        Integer r5 = null;
        if (r4 == null) goto L8;
        Fragment r6 = r4.getFragment();     // Catch: Throwable -> L78
        if (r6 == null) goto L8;
        final g r7 = f.b(r6);     // Catch: Throwable -> L78
    L9:
        StringBuilder r8 = new StringBuilder("handleBackClick, hasLoadDone = ");     // Catch: Throwable -> L78
        r8.append(this.hasLoadDone);     // Catch: Throwable -> L78
        r8.append(" , forsetiRouter = ");     // Catch: Throwable -> L78
        if (r7 == null) goto L12;
        boolean r9 = true;
    L13:
        r8.append(r9);     // Catch: Throwable -> L78
        j.e("CML_TAG_TitleBarPlugin", r8.toString());     // Catch: Throwable -> L78
        if (this.hasLoadDone == true) goto L20;
        Map<String, u1b.a.C0305a> r1 = u1b.a.a;     // Catch: Throwable -> L78
        u1b.a.C0305a r2 = u1b.a.a(getSession());     // Catch: Throwable -> L78
        if (r2 == null) goto L19;
        u1b.a.C0305a.b(r2, ChameleonOpenTracker.OpenResult.CANCEL, -3);     // Catch: Throwable -> L78
    L19:
        return dispatchRootBackPressed(r10, new AnonymousClass1(r7, this));
    L20:
        ChameleonPluginHost r11 = getHost();     // Catch: Throwable -> L78
        if (r11 == null) goto L27;
        k r12 = r11.getWeb();     // Catch: Throwable -> L78
        if (r12 == null) goto L27;
        WebView r13 = r12.getWebView();     // Catch: Throwable -> L78
        if (r13 == null) goto L27;
        Boolean r14 = Boolean.valueOf(r13.canGoBack());     // Catch: Throwable -> L78
    L29:
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L35;
        j.e("CML_TAG_TitleBarPlugin", "goBack");     // Catch: Throwable -> L78
        k r15 = getHost().getWeb();     // Catch: Throwable -> L78
        if (r15 == null) goto L82;
        WebView r16 = r15.getWebView();     // Catch: Throwable -> L78
        if (r16 == null) goto L83;
        r16.goBack();     // Catch: Throwable -> L78
        return true;
    L83:
        return true;
    L82:
        return true;
    L35:
        ChameleonPluginHost r17 = getHost();     // Catch: Throwable -> L78
        if (r17 == null) goto L42;
        k r18 = r17.getWeb();     // Catch: Throwable -> L78
        if (r18 == null) goto L42;
        WebView r19 = r18.getWebView();     // Catch: Throwable -> L78
        if (r19 == null) goto L42;
        WebBackForwardList r20 = r19.copyBackForwardList();     // Catch: Throwable -> L78
    L43:
        if (r20 == null) goto L45;
        int r21 = r20.getSize();     // Catch: Throwable -> L78
    L46:
        if (r21 <= 0) goto L52;
        if (r20 == null) goto L52;
        WebHistoryItem r3 = r20.getItemAtIndex(0);     // Catch: Throwable -> L78
        if (r3 == null) goto L52;
        String r22 = r3.getUrl();     // Catch: Throwable -> L78
        if (r22 == null) goto L52;
    L53:
        ChameleonPluginHost r23 = getHost();     // Catch: Throwable -> L78
        if (r23 == null) goto L60;
        k r24 = r23.getWeb();     // Catch: Throwable -> L78
        if (r24 == null) goto L60;
        WebView r25 = r24.getWebView();     // Catch: Throwable -> L78
        if (r25 == null) goto L60;
        String r26 = r25.getUrl();     // Catch: Throwable -> L78
    L61:
        StringBuilder r27 = new StringBuilder("backForwardList size = ");     // Catch: Throwable -> L78
        if (r20 == null) goto L64;
        r5 = Integer.valueOf(r20.getSize());     // Catch: Throwable -> L78
    L64:
        r27.append(r5);     // Catch: Throwable -> L78
        r27.append(", curUrl = ");     // Catch: Throwable -> L78
        r27.append(com.ss.android.lark.chameleonv2.container.webcontainer.util.b.d(r26));     // Catch: Throwable -> L78
        r27.append(", firstUrl = ");     // Catch: Throwable -> L78
        r27.append(com.ss.android.lark.chameleonv2.container.webcontainer.util.b.d(r22));     // Catch: Throwable -> L78
        r27.append(", curUrl == firstUrl ? ");     // Catch: Throwable -> L78
        r27.append(Intrinsics.areEqual(r26, r22));     // Catch: Throwable -> L78
        j.e("CML_TAG_TitleBarPlugin", r27.toString());     // Catch: Throwable -> L78
        if (Intrinsics.areEqual(r26, r22) == true) goto L89;
        if (Intrinsics.areEqual(r26, "about:blank") == true) goto L89;
        ChameleonPluginHost r110 = getHost();     // Catch: Throwable -> L78
        if (r110 == null) goto L85;
        k r111 = r110.getWeb();     // Catch: Throwable -> L78
        if (r111 == null) goto L86;
        WebView r112 = r111.getWebView();     // Catch: Throwable -> L78
        if (r112 == null) goto L87;
        r112.loadUrl("javascript:window.history.back(-1)");     // Catch: Throwable -> L78
        return true;
    L87:
        return true;
    L86:
        return true;
    L85:
        return true;
    L89:
        return dispatchRootBackPressed(r10, new AnonymousClass2(r7, this));
    L60:
        r26 = null;
    L52:
        r22 = BuildConfig.FLAVOR;
        goto L53
    L45:
        r21 = 0;
    L42:
        r20 = null;
    L27:
        r14 = null;
        goto L29
    L12:
        r9 = false;
    L8:
        r7 = null;
    L78:
        th = move-exception;
        j.d("CML_TAG_TitleBarPlugin", th);
        return true;
    }

    public void onAttachToHost(ChameleonPluginHost r2) {
        super.onAttachToHost(r2);
        if (r2 == null) goto L8;
        IChameleonLoader r3 = r2.getLoader();
        if (r3 == null) goto L9;
        r3.addLoadCallback(new d(this));
        return;
    L9:
        return;
    }

    public void onDetachFromHost(ChameleonPluginHost r1) {
        super.onDetachFromHost(r1);
        this.mMenuCallback = null;
    }

    public void setTitle(String r2) {
        t r0 = getHost().getUIContainer();
        if (r0 == null) goto L8;
        TitleBar r1 = r0.getTitleBar();
        if (r1 == null) goto L9;
        r1.setTitle(r2);
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ boolean access$handleBackClick(TitleBarPlugin r0, RootBackPressSource r1) {
        return r0.handleBackClick(r1);
    }

    public static final /* synthetic */ void access$setHasLoadDone$p(TitleBarPlugin r0, boolean r1) {
        r0.hasLoadDone = r1;
    }

    private final boolean dispatchRootBackPressed(RootBackPressSource r3, Function0<Unit> r4) {
        ChameleonPluginHost r0 = getHost();
        if (r0 == null) goto L9;
        RootBackPressAbility r1 = (RootBackPressAbility) r0.getHostAbilityOrNull(RootBackPressAbility.class);
        if (r1 == null) goto L9;
        RootBackPressResult r5 = r1.onRootBackPressed(r3);
        if (r5 == null) goto L9;
    L10:
        int r6 = b.a[r5.ordinal()];
        if (r6 != 1) goto L13;
        r4.invoke();
        return true;
    L13:
        if (r6 != 2) goto L15;
        return true;
    L15:
        if (r6 != 3) goto L18;
        return false;
    L18:
        throw new NoWhenBranchMatchedException();
    L9:
        r5 = RootBackPressResult.DEFAULT;
        goto L10
    }

    public void onAttachToUIContainer(ChameleonPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        if (isUIContainerDetached() == false) goto L5;
        return;
    L5:
        if (r2 == null) goto L9;
        View r3 = r2.getContentView();
        if (r3 == null) goto L9;
        FrameLayout r4 = (FrameLayout) r3.findViewById(2131367057);
    L10:
        if (r4 == null) goto L12;
        r4.setVisibility(0);
    L12:
        if (r4 == null) goto L14;
        r4.removeAllViews();
    L14:
        if (r4 == null) goto L20;
        View r5 = getTitleView();
        if (r5 != null) goto L18;
        return;
    L18:
        r4.addView(r5);
        return;
    L20:
        return;
    L9:
        r4 = null;
        goto L10
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }
}
