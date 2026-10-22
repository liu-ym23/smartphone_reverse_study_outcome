package com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.title;

import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.api.OpenConfig;
import com.ss.android.lark.chameleon.api.TitleType;
import com.ss.android.lark.chameleon.api.TitlebarConfig;
import com.ss.android.lark.chameleon.api.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.Web;
import com.ss.android.lark.chameleon.pluginsystem.plugin.BackPressHandler;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar;
import com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/title/TitleBarPlugin;", "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/BackPressHandler;", "()V", "hasLoadDone", BuildConfig.FLAVOR, "mMenuCallback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "handleBackClick", BuildConfig.FLAVOR, "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/api/pluginapi/ChameleonPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/UIContainer;", "onBackPressed", "onDetachFromHost", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class TitleBarPlugin extends AbsChameleonPlugin implements BackPressHandler {
    public static final String BACK_CMD = "javascript:window.history.back(-1)";
    public static final Companion Companion = null;
    public static final String NULL_URL = "about:blank";
    public static final String TAG = "CML_TAG_TitleBarPlugin";
    private boolean hasLoadDone;
    private CallBackFunction mMenuCallback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/title/TitleBarPlugin$Companion;", BuildConfig.FLAVOR, "()V", "BACK_CMD", BuildConfig.FLAVOR, "NULL_URL", "TAG", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(TitleBarPlugin r0, View r1) {
        onAttachToUIContainer$lambda$2(r0, r1);
    }

    private final void handleBackClick() {
        Log.i("CML_TAG_TitleBarPlugin", "handleBackClick, hasLoadDone = " + this.hasLoadDone);
    L77:
        th = move-exception;
        String r1 = th.getMessage();
        if (r1 != null) goto L81;
        r1 = "Unknown error";
    L81:
        Log.e("CML_TAG_TitleBarPlugin", r1, th);
        return;
    L4:
        if (this.hasLoadDone == true) goto L12;
        ChameleonOpenTracker.SessionTracker r3 = ChameleonOpenTracker.INSTANCE.getSessionTracker(getSession());     // Catch: Throwable -> L77
        if (r3 == null) goto L8;
        ChameleonOpenTracker.SessionTracker.openFinish$default(r3, ChameleonOpenTracker.OpenResult.CANCEL, -3, 0, 4, null);     // Catch: Throwable -> L77
    L8:
        FragmentActivity r0 = getActivity();     // Catch: Throwable -> L77
        if (r0 == null) goto L84;
        r0.finish();     // Catch: Throwable -> L77
        return;
    L84:
        return;
    L12:
        ChameleonPluginHost r2 = getHost();     // Catch: Throwable -> L77
        Integer r4 = null;
        if (r2 == null) goto L19;
        Web r5 = r2.getWeb();     // Catch: Throwable -> L77
        if (r5 == null) goto L19;
        WebView r6 = r5.getWebView();     // Catch: Throwable -> L77
        if (r6 == null) goto L19;
        Boolean r7 = Boolean.valueOf(r6.canGoBack());     // Catch: Throwable -> L77
    L21:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L27;
        Log.i("CML_TAG_TitleBarPlugin", "goBack");     // Catch: Throwable -> L77
        Web r8 = getHost().getWeb();     // Catch: Throwable -> L77
        if (r8 == null) goto L85;
        WebView r9 = r8.getWebView();     // Catch: Throwable -> L77
        if (r9 == null) goto L86;
        r9.goBack();     // Catch: Throwable -> L77
        return;
    L86:
        return;
    L85:
        return;
    L27:
        ChameleonPluginHost r10 = getHost();     // Catch: Throwable -> L77
        if (r10 == null) goto L34;
        Web r11 = r10.getWeb();     // Catch: Throwable -> L77
        if (r11 == null) goto L34;
        WebView r12 = r11.getWebView();     // Catch: Throwable -> L77
        if (r12 == null) goto L34;
        WebBackForwardList r13 = r12.copyBackForwardList();     // Catch: Throwable -> L77
    L36:
        if (r13 == null) goto L39;
        int r14 = r13.getSize();     // Catch: Throwable -> L77
    L40:
        String r15 = BuildConfig.FLAVOR;
        if (r14 <= 0) goto L50;
        if (r13 == null) goto L46;
        WebHistoryItem r16 = r13.getItemAtIndex(0);     // Catch: Throwable -> L77
        if (r16 == null) goto L46;
        String r17 = r16.getUrl();     // Catch: Throwable -> L77
    L47:
        if (r17 == null) goto L50;
        r15 = r17;
    L46:
        r17 = null;
    L50:
        ChameleonPluginHost r18 = getHost();     // Catch: Throwable -> L77
        if (r18 == null) goto L57;
        Web r19 = r18.getWeb();     // Catch: Throwable -> L77
        if (r19 == null) goto L57;
        WebView r20 = r19.getWebView();     // Catch: Throwable -> L77
        if (r20 == null) goto L57;
        String r21 = r20.getUrl();     // Catch: Throwable -> L77
    L58:
        StringBuilder r22 = new StringBuilder("backForwardList size = ");     // Catch: Throwable -> L77
        if (r13 == null) goto L61;
        r4 = Integer.valueOf(r13.getSize());     // Catch: Throwable -> L77
    L61:
        r22.append(r4);     // Catch: Throwable -> L77
        r22.append(", curUrl = ");     // Catch: Throwable -> L77
        ChameleonContainerUtils r23 = ChameleonContainerUtils.INSTANCE;     // Catch: Throwable -> L77
        r22.append(r23.safeUrlString(r21));     // Catch: Throwable -> L77
        r22.append(", firstUrl = ");     // Catch: Throwable -> L77
        r22.append(r23.safeUrlString(r15));     // Catch: Throwable -> L77
        r22.append(", curUrl == firstUrl ? ");     // Catch: Throwable -> L77
        r22.append(Intrinsics.areEqual(r21, r15));     // Catch: Throwable -> L77
        Log.i("CML_TAG_TitleBarPlugin", r22.toString());     // Catch: Throwable -> L77
        if (Intrinsics.areEqual(r21, r15) == false) goto L64;
    L73:
        FragmentActivity r24 = getActivity();     // Catch: Throwable -> L77
        if (r24 == null) goto L92;
        r24.finish();     // Catch: Throwable -> L77
        return;
    L92:
        return;
    L64:
        if (Intrinsics.areEqual(r21, "about:blank") == true) goto L73;
        ChameleonPluginHost r25 = getHost();     // Catch: Throwable -> L77
        if (r25 == null) goto L88;
        Web r26 = r25.getWeb();     // Catch: Throwable -> L77
        if (r26 == null) goto L89;
        WebView r27 = r26.getWebView();     // Catch: Throwable -> L77
        if (r27 == null) goto L90;
        r27.loadUrl("javascript:window.history.back(-1)");     // Catch: Throwable -> L77
        return;
    L90:
        return;
    L89:
        return;
    L88:
        return;
    L57:
        r21 = null;
        goto L58
    L39:
        r14 = 0;
    L34:
        r13 = null;
    L19:
        r7 = null;
        goto L21
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.BackPressHandler
    public boolean onBackPressed() {
        handleBackClick();
        return true;
    }

    public TitleBarPlugin() {
    }

    public void onAttachToHost(ChameleonPluginHost r2) {
        super.onAttachToHost(r2);
        if (r2 == null) goto L8;
        IChameleonLoader r3 = r2.getLoader();
        if (r3 == null) goto L9;
        r3.addLoadCallback(new AnonymousClass1(this));
        return;
    L9:
        return;
    }

    public void onDetachFromHost(ChameleonPluginHost r1) {
        super.onDetachFromHost(r1);
        this.mMenuCallback = null;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin, com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin, com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ void access$setHasLoadDone$p(TitleBarPlugin r0, boolean r1) {
        r0.hasLoadDone = r1;
    }

    private static final void onAttachToUIContainer$lambda$2(TitleBarPlugin r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.handleBackClick();
    }

    public void onAttachToUIContainer(ChameleonPluginHost r5, UIContainer r6) {
        super.onAttachToUIContainer(r5, r6);
        if (isUIContainerDetached() == false) goto L5;
        return;
    L5:
        OpenConfig r0 = getChameleonConfig().getOpenConfig();
        if (r0 == null) goto L35;
        TitlebarConfig r1 = r0.getTitlebarConfig();
        if (r1 == null) goto L35;
        TitleType r2 = r1.getTitleType();
        if (r2 == null) goto L35;
        Integer r3 = r2.getSize();
        if (r3 == null) goto L35;
        int r4 = r3.intValue();
        Log.i("CML_TAG_TitleBarPlugin", "onAttachToUIContainer, size = " + r4);
        if (r4 != 0) goto L16;
        if (r5 == null) goto L35;
        UIContainer r7 = r5.getUIContainer();
        if (r7 == null) goto L35;
        TitleBar r8 = r7.getTitleBar();
        if (r8 == null) goto L35;
        r8.setTitleSize(2131165496);
        goto L35
    L16:
        if (r4 == 2) goto L23;
        if (r5 == null) goto L35;
        UIContainer r9 = r5.getUIContainer();
        if (r9 == null) goto L35;
        TitleBar r10 = r9.getTitleBar();
        if (r10 == null) goto L35;
        r10.setTitleSize(2131165495);
        goto L35
    L23:
        if (r5 == null) goto L35;
        UIContainer r11 = r5.getUIContainer();
        if (r11 == null) goto L35;
        TitleBar r12 = r11.getTitleBar();
        if (r12 == null) goto L35;
        r12.setTitleSize(2131165494);
    L35:
        OpenConfig r13 = getChameleonConfig().getOpenConfig();
        if (r13 == null) goto L57;
        TitlebarConfig r14 = r13.getTitlebarConfig();
        if (r14 == null) goto L57;
        TitleType r15 = r14.getTitleType();
        if (r15 == null) goto L57;
        Integer r16 = r15.getPosition();
        if (r16 == null) goto L57;
        int r17 = r16.intValue();
        Log.i("CML_TAG_TitleBarPlugin", "onAttachToUIContainer, position = " + r17);
        if (r17 != 0) goto L51;
        if (r5 == null) goto L57;
        UIContainer r18 = r5.getUIContainer();
        if (r18 == null) goto L57;
        TitleBar r19 = r18.getTitleBar();
        if (r19 == null) goto L57;
        r19.setTitleGravity(TitleBar.TitleGravity.Left);
        goto L57
    L51:
        if (r5 == null) goto L57;
        UIContainer r20 = r5.getUIContainer();
        if (r20 == null) goto L57;
        TitleBar r21 = r20.getTitleBar();
        if (r21 == null) goto L57;
        r21.setTitleGravity(TitleBar.TitleGravity.Center);
    L57:
        if (r6 == null) goto L62;
        TitleBar r22 = r6.getTitleBar();
        if (r22 == null) goto L63;
        r22.setLeftClickListener(new a(this));
        return;
    L63:
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin, com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, UIContainer r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }
}
