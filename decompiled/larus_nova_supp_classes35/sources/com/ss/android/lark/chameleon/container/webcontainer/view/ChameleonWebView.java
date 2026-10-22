package com.ss.android.lark.chameleon.container.webcontainer.view;

import android.content.Context;
import android.os.SystemClock;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.api.IWebService;
import com.ss.android.lark.chameleon.api.WebviewConfig;
import com.ss.android.lark.chameleon.api.pluginapi.ChameleonWeb;
import com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.basewebview.BridgeWebViewV2;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonWebViewClient;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter;
import com.ss.android.lark.chameleon.container.webcontainer.preload.ChameleonPreloader;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor;
import com.ss.android.lark.chameleon.container.webcontainer.res.WebResourceInterceptorImpl;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResource;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.ChameleonResProvider;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.ExtendableWebChromeClient;
import com.ss.android.lark.chameleon.pluginsystem.ExtendableWebViewClientV2;
import com.ss.android.lark.chameleon.pluginsystem.WebFragment;
import com.ss.android.lark.chameleon.pluginsystem.WebService;
import com.ss.android.lark.chameleon.pluginsystem.WebServiceManager;
import com.ss.android.lark.chameleon.util.OsVersionUtils;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000Û\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\f*\u0001)\b\u0007\u0018\u0000 \u0093\u00012\u00020\u00012\u00020\u0002:\n\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010\fJ\u000e\u0010T\u001a\u00020R2\u0006\u0010U\u001a\u00020VJ\u0010\u0010W\u001a\u00020R2\b\u0010X\u001a\u0004\u0018\u000103J\u0010\u0010Y\u001a\u00020R2\b\u0010Z\u001a\u0004\u0018\u00010[J\u0018\u0010Y\u001a\u00020R2\u0006\u0010\\\u001a\u00020D2\b\u0010Z\u001a\u0004\u0018\u00010[J\b\u0010]\u001a\u00020RH\u0002J\u0010\u0010^\u001a\u00020R2\b\u0010Z\u001a\u0004\u0018\u00010_J\u0018\u0010^\u001a\u00020R2\u0006\u0010\\\u001a\u00020D2\b\u0010Z\u001a\u0004\u0018\u00010_J\u001a\u0010`\u001a\u00020\t2\b\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020DH\u0002J\u0006\u0010d\u001a\u00020RJ\b\u0010e\u001a\u00020,H\u0016J\u0006\u0010f\u001a\u00020\u0006J\u0006\u0010g\u001a\u00020\u0015J\u000e\u0010h\u001a\u00020\u00172\u0006\u0010i\u001a\u00020\u0019J\b\u0010j\u001a\u00020,H\u0016J\u0006\u0010k\u001a\u000205J\u0010\u0010l\u001a\u00020R2\b\u0010<\u001a\u0004\u0018\u00010,J\b\u0010m\u001a\u00020RH\u0014J\u0014\u0010n\u001a\u0004\u0018\u00010o2\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J\b\u0010r\u001a\u00020RH\u0014J(\u0010s\u001a\u00020R2\u0006\u0010t\u001a\u00020D2\u0006\u0010u\u001a\u00020D2\u0006\u0010v\u001a\u00020D2\u0006\u0010w\u001a\u00020DH\u0014JR\u0010x\u001a\u00020\u00192\u0006\u0010y\u001a\u00020D2\u0006\u0010z\u001a\u00020D2\u0006\u0010{\u001a\u00020D2\u0006\u0010|\u001a\u00020D2\u0006\u0010}\u001a\u00020D2\u0006\u0010~\u001a\u00020D2\u0006\u0010\u007f\u001a\u00020D2\u0007\u0010\u0080\u0001\u001a\u00020D2\u0007\u0010\u0081\u0001\u001a\u00020\u0019H\u0014J\u0007\u0010\u0082\u0001\u001a\u00020RJ\u0007\u0010\u0083\u0001\u001a\u00020RJ\u0011\u0010\u0084\u0001\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010\fJ\u000f\u0010\u0085\u0001\u001a\u00020R2\u0006\u0010U\u001a\u00020VJ\u0011\u0010\u0086\u0001\u001a\u00020R2\b\u0010X\u001a\u0004\u0018\u000103J\u0011\u0010\u0087\u0001\u001a\u00020R2\b\u0010Z\u001a\u0004\u0018\u00010[J\u0011\u0010\u0088\u0001\u001a\u00020R2\b\u0010Z\u001a\u0004\u0018\u00010_J-\u0010\u0089\u0001\u001a\u00020R\"\n\b\u0000\u0010\u008a\u0001*\u00030\u008b\u00012\u0006\u0010c\u001a\u00020,2\b\u0010\u008c\u0001\u001a\u0003H\u008a\u0001H\u0016¢\u0006\u0003\u0010\u008d\u0001J\u000f\u0010\u008e\u0001\u001a\u00020R2\u0006\u0010\u0005\u001a\u00020\u0006J\u000f\u0010\u008f\u0001\u001a\u00020R2\u0006\u0010\u0018\u001a\u00020\u0019J\u001b\u0010\u0090\u0001\u001a\u00020\t2\b\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020DH\u0002J\u0013\u0010\u0091\u0001\u001a\u00020\t2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u001b\u0010\u0091\u0001\u001a\u00020\t2\b\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020DH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u001a\u0010&\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u00101\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020302R\u00020\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010!\"\u0004\b8\u0010#R\u001c\u00109\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010.\"\u0004\b;\u00100R\u0010\u0010<\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010=\u001a\u00020>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010M\u001a\u0004\u0018\u00010N8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006\u0097\u0001"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;", "Lcom/ss/android/lark/chameleon/basewebview/BridgeWebViewV2;", "Lcom/ss/android/lark/chameleon/api/IChameleonHandlerContext;", "context", "Landroid/content/Context;", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "(Landroid/content/Context;Lcom/ss/android/lark/chameleon/api/ChameleonConfig;)V", "actionMode", "Landroid/view/ActionMode;", "actionModeDelegates", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView$ActionModeDelegate;", "appContext", "getAppContext", "()Landroid/content/Context;", "callbackAdapter", "Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/UIThreadCallbackAdapter;", "getCallbackAdapter", "()Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/UIThreadCallbackAdapter;", "chameleonPreloader", "Lcom/ss/android/lark/chameleon/container/webcontainer/preload/ChameleonPreloader;", "chameleonResource", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonResource;", "enableOverScrollBy", BuildConfig.FLAVOR, "fragment", "Lcom/ss/android/lark/chameleon/pluginsystem/WebFragment;", "getFragment", "()Lcom/ss/android/lark/chameleon/pluginsystem/WebFragment;", "gson", "Lcom/google/gson/Gson;", "isAttach", "()Z", "setAttach", "(Z)V", "isReady", "setReady", "isVisible", "setVisible", "larkWebViewContext", "com/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView$larkWebViewContext$1", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView$larkWebViewContext$1;", "loadUrl", BuildConfig.FLAVOR, "getLoadUrl", "()Ljava/lang/String;", "setLoadUrl", "(Ljava/lang/String;)V", "mScrollChangeListeners", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView$WeakReferenceCallbackWrapper;", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView$OnScrollChangeListener;", "mWebServiceManager", "Lcom/ss/android/lark/chameleon/pluginsystem/WebServiceManager;", "onLoadSuccess", "getOnLoadSuccess", "setOnLoadSuccess", "preloadUrl", "getPreloadUrl", "setPreloadUrl", "session", "startLoadUrlTime", BuildConfig.FLAVOR, "getStartLoadUrlTime", "()J", "setStartLoadUrlTime", "(J)V", "usedCount", BuildConfig.FLAVOR, "getUsedCount", "()I", "setUsedCount", "(I)V", "webChromeClient", "Lcom/ss/android/lark/chameleon/pluginsystem/ExtendableWebChromeClient;", "webViewClient", "Lcom/ss/android/lark/chameleon/pluginsystem/ExtendableWebViewClientV2;", "webviewLoader", "Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader;", "getWebviewLoader", "()Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader;", "addActionModeDelegate", BuildConfig.FLAVOR, "actionModeDelegate", "addLoadCallback", "cb", "Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader$LoadingCallback;", "addScrollChangeListener", "scrollChangeListener", "addWebChromeClientDelegate", "clientDelegate", "Landroid/webkit/WebChromeClient;", "index", "addWebService", "addWebViewClientDelegate", "Landroid/webkit/WebViewClient;", "commonStartActionMode", "callback", "Landroid/view/ActionMode$Callback;", IPortraitService.TYPE, "finishActionMode", "getBizName", "getChameleonConfig", "getPreloader", "getResource", "sync", "getSession", "getWebServiceManager", "injectSession", "onAttachedToWindow", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onDetachedFromWindow", "onScrollChanged", "l", "t", "oldl", "oldt", "overScrollBy", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", ChameleonOpenTracker.Stage.PRELOAD, "release", "removeActionModeDelegate", "removeLoadCallback", "removeScrollChangeListener", "removeWebChromeClientDelegate", "removeWebViewClientDelegate", "sendEvent", "T", "Ljava/io/Serializable;", Keys.API_RETURN_KEY_DATA, "(Ljava/lang/String;Ljava/io/Serializable;)V", "setChameleonConfig", "setEnableOverScrollBy", "startAction", "startActionMode", "ActionModeDelegate", "Companion", "InputConnWrapper", "OnScrollChangeListener", "WeakReferenceCallbackWrapper", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonWebView extends BridgeWebViewV2 implements IChameleonHandlerContext {
    public static final Companion Companion = null;
    private static final String TAG = "CML_TAG_ChameleonWebView";
    private ActionMode actionMode;
    private final CopyOnWriteArrayList<ActionModeDelegate> actionModeDelegates;
    private final UIThreadCallbackAdapter callbackAdapter;
    private ChameleonConfig chameleonConfig;
    private final ChameleonPreloader chameleonPreloader;
    private volatile ChameleonResource chameleonResource;
    private boolean enableOverScrollBy;
    private final Gson gson;
    private boolean isAttach;
    private boolean isReady;
    private boolean isVisible;
    private final ChameleonWebView$larkWebViewContext$1 larkWebViewContext;
    private String loadUrl;
    private final CopyOnWriteArrayList<WeakReferenceCallbackWrapper<OnScrollChangeListener>> mScrollChangeListeners;
    private final WebServiceManager mWebServiceManager;
    private boolean onLoadSuccess;
    private String preloadUrl;
    private String session;
    private long startLoadUrlTime;
    private int usedCount;
    private final ExtendableWebChromeClient webChromeClient;
    private final ExtendableWebViewClientV2 webViewClient;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView$ActionModeDelegate;", BuildConfig.FLAVOR, "prepareActionMode", "Landroid/view/ActionMode$Callback;", "callback", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface ActionModeDelegate {
        ActionMode.Callback prepareActionMode(ActionMode.Callback r1);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView$Companion;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0017J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView$InputConnWrapper;", "Landroid/view/inputmethod/InputConnectionWrapper;", "target", "Landroid/view/inputmethod/InputConnection;", "mutable", BuildConfig.FLAVOR, "(Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;Landroid/view/inputmethod/InputConnection;Z)V", "deleteSurroundingText", "beforeLength", BuildConfig.FLAVOR, "afterLength", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class InputConnWrapper extends InputConnectionWrapper {
        final /* synthetic */ ChameleonWebView this$0;

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            return super.sendKeyEvent(r2);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int r18, int r19) {
            if ((r18 - r19) != 1) goto L7;
            long r15 = SystemClock.uptimeMillis();
            sendKeyEvent(new KeyEvent(r15, r15, 0, 67, 0, 0, -1, 0, 22));
            sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), r15, 1, 67, 0, 0, -1, 0, 22));
            return true;
        L7:
            return super.deleteSurroundingText(r18, r19);
        }

        public InputConnWrapper(ChameleonWebView r1, InputConnection r2, boolean r3) {
            this.this$0 = r1;
            super(r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView$OnScrollChangeListener;", BuildConfig.FLAVOR, "onScrollChange", BuildConfig.FLAVOR, "v", "Landroid/view/View;", "scrollX", BuildConfig.FLAVOR, "scrollY", "oldScrollX", "oldScrollY", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnScrollChangeListener {
        void onScrollChange(View r1, int r2, int r3, int r4, int r5);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00018\u00008\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView$WeakReferenceCallbackWrapper;", "T", BuildConfig.FLAVOR, "callback", "(Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;Ljava/lang/Object;)V", "getCallback", "()Ljava/lang/Object;", "mRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "equals", BuildConfig.FLAVOR, "oth", "hashCode", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class WeakReferenceCallbackWrapper<T> {
        private final WeakReference<T> mRef;
        final /* synthetic */ ChameleonWebView this$0;

        public final T getCallback() {
            return this.mRef.get();
        }

        public int hashCode() {
            T r0 = this.mRef.get();
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public boolean equals(Object r4) {
            T r0 = this.mRef.get();
            if (r0 != null) goto L6;
            return false;
        L6:
            if ((r4 instanceof WeakReferenceCallbackWrapper) == true) goto L8;
            return false;
        L8:
            T r5 = ((WeakReferenceCallbackWrapper) r4).mRef.get();
            if (r5 != null) goto L11;
            return false;
        L11:
            if (r0 != r5) goto L14;
            return true;
        L14:
            return false;
        }

        public WeakReferenceCallbackWrapper(ChameleonWebView r1, T r2) {
            this.this$0 = r1;
            this.mRef = new WeakReference(r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void addWebService() {
        ArrayList r0 = new ArrayList();
        WebviewConfig r1 = this.chameleonConfig.getWebviewConfig();
        if (r1 == null) goto L11;
        IWebService r2 = r1.getWebService();
        if (r2 == null) goto L11;
        List<WebService> r3 = r2.getWebService();
        if (r3 == null) goto L11;
        Log.i(TAG, "webService size = " + r3.size());
        List<WebService> r4 = r3;
        if ((!r4.isEmpty()) == false) goto L11;
        r0.addAll(r4);
    L11:
        this.mWebServiceManager.onCreate(new ChameleonWeb(this, getBridge(), this), r0);
    }

    public final void finishActionMode() {
        ActionMode r0 = this.actionMode;
        if (r0 == null) goto L5;
        r0.finish();
    L5:
        this.actionMode = null;
    }

    @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
    public String getSession() {
        String r0 = this.session;
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
    public IChameleonLoader getWebviewLoader() {
        return new ChameleonWebView$webviewLoader$1(this);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.BridgeWebViewV2, com.ss.android.lark.chameleon.basewebview.BaseWebView, android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Log.i(TAG, "onAttachedToWindow");
        super.onAttachedToWindow();
        this.isAttach = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Log.i(TAG, "onDetachedFromWindow");
        super.onDetachedFromWindow();
        this.isAttach = false;
    }

    public final void preload() {
        this.chameleonPreloader.preload();
    }

    public final void release() {
        this.callbackAdapter.release();
    }

    @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
    public Context getAppContext() {
        return getContext();
    }

    @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
    public String getBizName() {
        String r0 = getChameleonConfig().getBizName();
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
    public WebFragment getFragment() {
        return getFragment();
    }

    public final UIThreadCallbackAdapter getCallbackAdapter() {
        return this.callbackAdapter;
    }

    public final ChameleonConfig getChameleonConfig() {
        return this.chameleonConfig;
    }

    public final String getLoadUrl() {
        return this.loadUrl;
    }

    public final boolean getOnLoadSuccess() {
        return this.onLoadSuccess;
    }

    public final String getPreloadUrl() {
        return this.preloadUrl;
    }

    public final ChameleonPreloader getPreloader() {
        return this.chameleonPreloader;
    }

    public final long getStartLoadUrlTime() {
        return this.startLoadUrlTime;
    }

    public final int getUsedCount() {
        return this.usedCount;
    }

    public final WebServiceManager getWebServiceManager() {
        return this.mWebServiceManager;
    }

    public final boolean isAttach() {
        return this.isAttach;
    }

    public final boolean isReady() {
        return this.isReady;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void addActionModeDelegate(ActionModeDelegate r2) {
        if (this.actionModeDelegates.contains(r2) == true) goto L6;
        this.actionModeDelegates.add(r2);
        return;
    }

    public final void addLoadCallback(IChameleonLoader.LoadingCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.callbackAdapter.addLoadCallback(r2);
    }

    public final void addScrollChangeListener(OnScrollChangeListener r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        WeakReferenceCallbackWrapper<OnScrollChangeListener> r0 = new WeakReferenceCallbackWrapper(this, r2);
        if (this.mScrollChangeListeners.contains(r0) == true) goto L8;
        this.mScrollChangeListeners.add(r0);
        return;
    }

    public final void addWebChromeClientDelegate(WebChromeClient r2) {
        this.webChromeClient.addWebChromeClientDelegate(r2);
    }

    public final void addWebViewClientDelegate(WebViewClient r2) {
        this.webViewClient.addWebViewClientDelegate(r2);
    }

    public final ChameleonResource getResource(boolean r6) {
        ChameleonResource r1 = this.chameleonResource;
        if (r1 != null) goto L21;
        monitor-enter(this);
        r1 = this.chameleonResource;     // Catch: Throwable -> L18
        if (r1 != null) goto L16;
        r1 = ChameleonResProvider.INSTANCE.getResource(getContext(), this.chameleonConfig, r6, this.session);     // Catch: Throwable -> L18
        Log.i(TAG, "get resource, sync = " + r6 + ", path = " + r1.getPath() + ", version = " + r1.getVersion());     // Catch: Throwable -> L18
        ChameleonOpenTracker.SessionTracker r7 = ChameleonOpenTracker.INSTANCE.getSessionTracker(this.session);     // Catch: Throwable -> L18
        if (r7 == null) goto L14;
        String r2 = r1.getVersion();     // Catch: Throwable -> L18
        if (r2 != null) goto L12;
        r2 = BuildConfig.FLAVOR;
    L12:
        r7.recordParam(ChameleonOpenTracker.ParamKey.RES_VERSION, r2);     // Catch: Throwable -> L18
    L14:
        if (r1.getPath() == null) goto L16;
        this.chameleonResource = r1;     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
    L18:
        th = move-exception;
        throw th;
    L21:
        return r1;
    }

    public final void injectSession(String r1) {
        this.session = r1;
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r3) {
        InputConnection r4 = super.onCreateInputConnection(r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        return new InputConnWrapper(this, r4, true);
    }

    public final void removeActionModeDelegate(ActionModeDelegate r2) {
        this.actionModeDelegates.remove(r2);
    }

    public final void removeLoadCallback(IChameleonLoader.LoadingCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.callbackAdapter.removeLoadCallback(r2);
    }

    public final void removeScrollChangeListener(OnScrollChangeListener r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.mScrollChangeListeners.remove(new WeakReferenceCallbackWrapper(this, r3));
    }

    public final void removeWebChromeClientDelegate(WebChromeClient r2) {
        this.webChromeClient.removeWebChromeClientDelegate(r2);
    }

    public final void removeWebViewClientDelegate(WebViewClient r2) {
        this.webViewClient.removeWebViewClientDelegate(r2);
    }

    public final void setAttach(boolean r1) {
        this.isAttach = r1;
    }

    public final void setChameleonConfig(ChameleonConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "chameleonConfig");
        this.chameleonConfig = r2;
    }

    public final void setEnableOverScrollBy(boolean r1) {
        this.enableOverScrollBy = r1;
    }

    public final void setLoadUrl(String r1) {
        this.loadUrl = r1;
    }

    public final void setOnLoadSuccess(boolean r1) {
        this.onLoadSuccess = r1;
    }

    public final void setPreloadUrl(String r1) {
        this.preloadUrl = r1;
    }

    public final void setReady(boolean r1) {
        this.isReady = r1;
    }

    public final void setStartLoadUrlTime(long r1) {
        this.startLoadUrlTime = r1;
    }

    public final void setUsedCount(int r1) {
        this.usedCount = r1;
    }

    public final void setVisible(boolean r1) {
        this.isVisible = r1;
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback r2) {
        return commonStartActionMode(r2, -1);
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewContext, com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView$larkWebViewContext$1] */
    public ChameleonWebView(Context r4, ChameleonConfig r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "chameleonConfig");
        super(r4);
        this.chameleonConfig = r5;
        this.mWebServiceManager = new WebServiceManager();
        this.enableOverScrollBy = true;
        UIThreadCallbackAdapter r6 = new UIThreadCallbackAdapter();
        this.callbackAdapter = r6;
        this.startLoadUrlTime = System.currentTimeMillis();
        this.actionModeDelegates = new CopyOnWriteArrayList();
        this.mScrollChangeListeners = new CopyOnWriteArrayList();
        ?? r7 = new ChameleonWebView$larkWebViewContext$1(this);
        this.larkWebViewContext = r7;
        ExtendableWebViewClientV2 r0 = new ExtendableWebViewClientV2(r7);
        this.webViewClient = r0;
        ExtendableWebChromeClient r1 = new ExtendableWebChromeClient(r7);
        this.webChromeClient = r1;
        this.chameleonPreloader = new ChameleonPreloader(this, this.chameleonConfig);
        setBackgroundColor(0);
        setWebViewClient(r0);
        setWebChromeClient(r1);
        WebResourceInterceptorImpl r8 = new WebResourceInterceptorImpl();
        r8.addInterceptor(new ChameleonOfflineResourceInterceptor(this, this.chameleonConfig));
        addWebViewClientDelegate(new ChameleonWebViewClient(r8, this, r6));
        addWebChromeClientDelegate(new AnonymousClass2(this));
        ChameleonWebViewConfig.INSTANCE.init(this);
        addWebService();
        this.gson = new Gson();
    }

    private final ActionMode commonStartActionMode(ActionMode.Callback r5, int r6) {
        if (this.actionModeDelegates.isEmpty() == true) goto L5;
        CopyOnWriteArrayList<ActionModeDelegate> r0 = this.actionModeDelegates;
        ActionMode.Callback r1 = r0.get(r0.size() - 1).prepareActionMode(r5);
        Log.i(TAG, "delegate is not empty");
    L6:
        Log.i(TAG, "start action mode actionModeCallback " + r1);
        if (r1 == null) goto L10;
        this.actionMode = startAction(r1, r6);
    L13:
        ActionMode r7 = this.actionMode;
        Intrinsics.checkNotNull(r7);
        return r7;
    L10:
        if (hasFocus() == false) goto L12;
        this.actionMode = startAction(r5, r6);
        goto L13
    L12:
        Log.w(TAG, "WebView has no focus, intercept system actionMode!");
        finishActionMode();
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    private final ActionMode startAction(ActionMode.Callback r2, int r3) {
        if (OsVersionUtils.hasM() == false) goto L6;
        return super.startActionMode(r2, r3);
    L6:
        return super.startActionMode(r2);
    }

    public final void addWebChromeClientDelegate(int r2, WebChromeClient r3) {
        this.webChromeClient.addWebChromeClientDelegate(r2, r3);
    }

    public final void addWebViewClientDelegate(int r2, WebViewClient r3) {
        this.webViewClient.addWebViewClientDelegate(r2, r3);
    }

    @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
    public <T extends Serializable> void sendEvent(String r5, T r6) {
        Intrinsics.checkNotNullParameter(r5, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r6, Keys.API_RETURN_KEY_DATA);
        evaluateJavascript(StringsKt.trimIndent("\n                javascript:LarkWebViewJavaScriptBridge.nativeCallBack({\n                  callbackID: 'LarkAPI.ipc.event',\n                  callbackType: 'continued',\n                  data: " + GsonProtectorUtils.toJson(this.gson, new AbsChameleonPlugin.LarkAPIEvent(r5, -1, r6)) + ",\n                })\n            "), null);
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback r1, int r2) {
        return commonStartActionMode(r1, r2);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int r9, int r10, int r11, int r12) {
        super.onScrollChanged(r9, r10, r11, r12);
        Iterator<WeakReferenceCallbackWrapper<OnScrollChangeListener>> r0 = this.mScrollChangeListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        WeakReferenceCallbackWrapper<OnScrollChangeListener> r1 = r0.next();
        if (r1.getCallback() != null) goto L7;
        this.mScrollChangeListeners.remove(r1);
        goto L4
    L7:
        OnScrollChangeListener r2 = r1.getCallback();
        if (r2 == null) goto L4;
        r2.onScrollChange(this, r9, r10, r11, r12);
        goto L4
    }

    @Override // android.view.View
    public boolean overScrollBy(int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, boolean r10) {
        if (this.enableOverScrollBy == true) goto L7;
        return true;
    L7:
        return super.overScrollBy(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }
}
