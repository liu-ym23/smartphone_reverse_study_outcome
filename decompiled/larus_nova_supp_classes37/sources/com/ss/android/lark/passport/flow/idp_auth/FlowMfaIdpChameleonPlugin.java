package com.ss.android.lark.passport.flow.idp_auth;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.mfa.FlowMfaBidpWebActivityType;
import com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\n\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f`\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\tH\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/passport/flow/idp_auth/FlowMfaIdpChameleonPlugin;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/ss/android/lark/passport/flow/mfa/FlowMfaFlowSession;", "webActivityType", "Lcom/ss/android/lark/passport/flow/mfa/FlowMfaBidpWebActivityType;", "<init>", "(Lcom/ss/android/lark/passport/flow/mfa/FlowMfaFlowSession;Lcom/ss/android/lark/passport/flow/mfa/FlowMfaBidpWebActivityType;)V", "jsBridgeContent", "", "getBridgeHandlers", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleon/AbsChameleonHandler;", "Lkotlin/collections/ArrayList;", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "injectJsBridge", "scene", "loadJsBridgeContent", "LoginResultHandler", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class FlowMfaIdpChameleonPlugin extends AbsChameleonPlugin {
    private static final String API_LOGIN_RESULT = "biz.account.h5_login_result";
    private static final a Companion = null;
    private static final int ERROR_INVALID_PARAM = -1;
    private static final String JS_BRIDGE_ASSET = "WebViewJavascriptBridgeAdapt.js";
    private static final String TAG = "FlowMfaIdpChameleonPlugin";
    private String jsBridgeContent;
    private final FlowMfaFlowSession session;
    private final FlowMfaBidpWebActivityType webActivityType;

    public static final class a {
        public a() {
        }
    }

    public final class b extends AbsChameleonHandler<FlowIdpLoginResultRequest> {
        public final String a;
        public final /* synthetic */ FlowMfaIdpChameleonPlugin b;

        public final String getName() {
            return this.a;
        }

        public b(FlowMfaIdpChameleonPlugin r1) {
            this.b = r1;
            this.a = FlowMfaIdpChameleonPlugin.API_LOGIN_RESULT;
        }

        public final void handle(Object r7, Callback r8) {
            FlowIdpLoginResultRequest r9 = (FlowIdpLoginResultRequest) r7;
            Intrinsics.checkNotNullParameter(r9, "req");
            Intrinsics.checkNotNullParameter(r8, "callback");
            PassportLog.d(FlowMfaIdpChameleonPlugin.TAG, "h5 login result start");
            IChameleonHandlerContext r0 = getContext();
            if (r0 == null) goto L5;
            Context r1 = r0.getCmlContext();
        L7:
            if ((r1 instanceof Activity) == false) goto L9;
            Activity r2 = (Activity) r1;
        L10:
            FlowIdpLoginResult.a r3 = FlowIdpLoginResult.Companion;
            String r10 = r9.getIdpContext();
            r3.getClass();
            FlowIdpLoginResult r11 = FlowIdpLoginResult.a.a(r10, "idp_context");
            if (r11 != null) goto L13;
            FlowMfaFlowSession r12 = FlowMfaIdpChameleonPlugin.access$getSession$p(this.b);
            FlowIdpLoginResult r4 = new FlowIdpLoginResult();
            r4.setCode(-1);
            r4.setMessage("idp_context is invalid");
            r12.getClass();
            Intrinsics.checkNotNullParameter(r4, "model");
            r12.n(r4, r2, FlowMfaBidpWebActivityType.INTERNAL_AUTH, "h5 login result");
            r8.error(new LKAPIError(-1, "idp_context is invalid"));
            return;
        L13:
            FlowMfaFlowSession r5 = FlowMfaIdpChameleonPlugin.access$getSession$p(this.b);
            r5.getClass();
            Intrinsics.checkNotNullParameter(r11, "model");
            r5.n(r11, r2, FlowMfaBidpWebActivityType.INTERNAL_AUTH, "h5 login result");
            r8.success(null);
            return;
        L9:
            r2 = null;
            goto L10
        L5:
            r1 = null;
            goto L7
        }
    }

    public static final class c implements IChameleonLoader.LoadingCallback {
        public final /* synthetic */ FlowMfaIdpChameleonPlugin a;

        public final void onLoadSuccess() {
            FlowMfaIdpChameleonPlugin.access$injectJsBridge(this.a, "load_success");
        }

        public final boolean getKeepOnRelease() {
            return IChameleonLoader.LoadingCallback.DefaultImpls.getKeepOnRelease(this);
        }

        public final void onLoadStart() {
            IChameleonLoader.LoadingCallback.DefaultImpls.onLoadStart(this);
        }

        public final void onLoadSuccessByJS() {
            IChameleonLoader.LoadingCallback.DefaultImpls.onLoadSuccessByJS(this);
        }

        @Deprecated(message = "已废弃，使用IRenderGoneListener")
        public final void onRenderProcessGone() {
            IChameleonLoader.LoadingCallback.DefaultImpls.onRenderProcessGone(this);
        }

        public c(FlowMfaIdpChameleonPlugin r1) {
            this.a = r1;
        }

        public final void onPageStarted(String r2) {
            FlowMfaIdpChameleonPlugin.access$injectJsBridge(this.a, "page_started");
        }

        public final void onLoadFail(int r1, Throwable r2) {
            IChameleonLoader.LoadingCallback.DefaultImpls.onLoadFail(this, r1, r2);
        }

        public final void onLoadFailByJS(String r1, int r2) {
            IChameleonLoader.LoadingCallback.DefaultImpls.onLoadFailByJS(this, r1, r2);
        }

        public final void onReceivedTitle(WebView r1, String r2) {
            IChameleonLoader.LoadingCallback.DefaultImpls.onReceivedTitle(this, r1, r2);
        }
    }

    static {
        Companion = new a();
    }

    public ArrayList<AbsChameleonHandler<?>> getBridgeHandlers() {
        return CollectionsKt.arrayListOf(new AbsChameleonHandler[]{new b(this)});
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final String loadJsBridgeContent() {
        String r0 = this.jsBridgeContent;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return r0;
    L11:
        ChameleonPluginHost r2 = getHost();
        Object r3 = null;
        if (r2 == null) goto L14;
        FragmentActivity r4 = r2.getActivity();
    L16:
        if (r4 != null) goto L50;
        PassportLog.b(TAG, "load jsbridge failed, activity is null");
        return null;
    L50:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L32
        Reader r6 = new InputStreamReader(r4.getAssets().open(JS_BRIDGE_ASSET), Charsets.UTF_8);     // Catch: Throwable -> L32
        if ((r6 instanceof BufferedReader) == false) goto L23;
        BufferedReader r7 = (BufferedReader) r6;     // Catch: Throwable -> L32
    L46:
        String r8 = TextStreamsKt.readText(r7);     // Catch: Throwable -> L27
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L32
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L32
    L35:
        if (Result.isSuccess-impl(r9) == false) goto L37;
        this.jsBridgeContent = (String) r9;
    L37:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L41;
        PassportLog.b(TAG, "load jsbridge failed: ".concat(r10.getClass().getSimpleName()));
    L41:
        if (Result.isFailure-impl(r9) == true) goto L45;
        r3 = r9;
    L45:
        return (String) r3;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L23:
        r7 = new BufferedReader(r6, 8192);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L14:
        r4 = null;
        goto L16
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final /* synthetic */ FlowMfaFlowSession access$getSession$p(FlowMfaIdpChameleonPlugin r0) {
        return r0.session;
    }

    private final void injectJsBridge(String r7) {
        ChameleonPluginHost r0 = getHost();
        if (r0 == null) goto L7;
        k r1 = r0.getWeb();
        if (r1 == null) goto L7;
        WebView r2 = r1.getWebView();
    L9:
        if (r2 != null) goto L12;
        PassportLog.b(TAG, "inject jsbridge failed, webView is null, scene=" + r7);
        return;
    L12:
        String r3 = loadJsBridgeContent();
        if (r3 != null) goto L15;
    L18:
        boolean r4 = true;
    L19:
        if (r4 == false) goto L22;
        PassportLog.b(TAG, "inject jsbridge failed, js content is empty, scene=" + r7);
        return;
    L22:
        r2.evaluateJavascript("javascript:" + r3, null);
        PassportLog.d(TAG, "inject jsbridge success, scene=" + r7);
        return;
    L15:
        if (StringsKt.isBlank(r3) == true) goto L18;
        r4 = false;
    L7:
        r2 = null;
        goto L9
    }

    public void onAttachToHost(ChameleonPluginHost r5) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r5);
        String r0 = null;
        if (r5 == null) goto L5;
        FragmentActivity r1 = r5.getActivity();
    L6:
        StringBuilder r2 = new StringBuilder("attach BIDP web container: type=");
        r2.append(this.webActivityType);
        r2.append(", hasActivity=");
        if (r1 == null) goto L9;
        boolean r3 = true;
    L10:
        r2.append(r3);
        r2.append(", activity=");
        if (r1 == null) goto L13;
        r0 = r1.getClass().getSimpleName();
    L13:
        r2.append(r0);
        PassportLog.d(TAG, r2.toString());
        if (r1 == null) goto L16;
        this.session.d(r1, this.webActivityType);
    L16:
        if (r5 == null) goto L21;
        IChameleonLoader r6 = r5.getLoader();
        if (r6 == null) goto L22;
        r6.addLoadCallback(new c(this));
        return;
    L22:
        return;
    L21:
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public FlowMfaIdpChameleonPlugin(FlowMfaFlowSession r2, FlowMfaBidpWebActivityType r3) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r3, "webActivityType");
        this.session = r2;
        this.webActivityType = r3;
    }

    public static final /* synthetic */ void access$injectJsBridge(FlowMfaIdpChameleonPlugin r0, String r1) {
        r0.injectJsBridge(r1);
    }
}
