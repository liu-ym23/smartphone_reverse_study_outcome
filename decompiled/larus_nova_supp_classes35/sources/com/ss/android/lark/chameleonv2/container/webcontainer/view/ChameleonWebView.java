package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ViewKt;
import com.google.gson.Gson;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.AbsChameleonService;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.IWebService;
import com.ss.android.lark.chameleon.JsbAuthConfig;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.WebviewConfig;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.pluginapi.OpenStatus;
import com.ss.android.lark.chameleon.pluginapi.RouterState;
import com.ss.android.lark.chameleon.pluginapi.WebviewStatus;
import com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonWebViewManager;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.UIThreadCallbackAdapter;
import com.ss.android.lark.chameleonv2.container.webcontainer.preload.ChameleonPreloader;
import com.ss.android.lark.chameleonv2.container.webcontainer.res.ChameleonOfflineResourceInterceptor;
import com.ss.android.lark.chameleonv2.container.webcontainer.res.ProxyChameleonOfflineResourceInterceptor;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Ipc$EventType;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Ipc$RouterStateChangeEvent;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Ipc$StateChangeEvent;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Ipc$VisibilityChangeEvent;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Status;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$VisibilityState;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.utils.AppInfoUtils;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.hang.HangDetectStrategy;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ntb.l;
import vv4.m;
import vv4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u009e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002IV\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0004®\u0001¯\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u00100\u001a\u00020'J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u00020'J\u0006\u00104\u001a\u00020\u000fJ\u000e\u00105\u001a\u0002022\u0006\u00103\u001a\u00020\u000fJ\u0006\u00106\u001a\u00020\u000fJ\u000e\u00107\u001a\u0002022\u0006\u00103\u001a\u00020\u000fJ\f\u00108\u001a\b\u0012\u0004\u0012\u00020,0+J\u0014\u00109\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020,0+J\u0006\u0010:\u001a\u00020.J\u000e\u0010;\u001a\u0002022\u0006\u00103\u001a\u00020.J\u0006\u0010<\u001a\u00020\u000fJ\u000e\u0010=\u001a\u0002022\u0006\u00103\u001a\u00020\u000fJ\b\u0010\\\u001a\u000202H\u0016J\b\u0010]\u001a\u000202H\u0016J\b\u0010^\u001a\u000202H\u0016J\b\u0010_\u001a\u00020YH\u0002J\b\u0010`\u001a\u000202H\u0002J\u0010\u0010a\u001a\u0002022\b\u0010K\u001a\u0004\u0018\u00010\nJ\n\u0010b\u001a\u0004\u0018\u00010cH\u0016J\n\u0010d\u001a\u0004\u0018\u00010\u0004H\u0016J'\u0010e\u001a\u0004\u0018\u0001Hf\"\b\b\u0000\u0010f*\u00020g2\f\u0010h\u001a\b\u0012\u0004\u0012\u0002Hf0iH\u0016¢\u0006\u0002\u0010jJ\n\u0010k\u001a\u0004\u0018\u00010lH\u0016J\u0014\u0010m\u001a\b\u0012\u0002\b\u0003\u0018\u00010n2\u0006\u0010o\u001a\u00020\nJ\b\u0010p\u001a\u000202H\u0016J\b\u0010q\u001a\u000202H\u0016J\b\u0010v\u001a\u00020\nH\u0016J\b\u0010w\u001a\u00020\nH\u0016J'\u0010z\u001a\u000202\"\b\b\u0000\u0010f*\u00020,2\u0006\u0010{\u001a\u00020\n2\u0006\u0010|\u001a\u0002HfH\u0016¢\u0006\u0002\u0010}J\b\u0010~\u001a\u00020\u0006H\u0016J\u0006\u0010\u007f\u001a\u00020\rJ\u0007\u0010\u0080\u0001\u001a\u000202J\u0007\u0010\u0081\u0001\u001a\u00020TJ\u0010\u0010\u0082\u0001\u001a\u00020C2\u0007\u0010\u0083\u0001\u001a\u00020\u000fJ\t\u0010\u0084\u0001\u001a\u000202H\u0014J\t\u0010\u0085\u0001\u001a\u000202H\u0014J\u0013\u0010\u0086\u0001\u001a\u0002022\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001J\u001c\u0010\u0086\u0001\u001a\u0002022\u0007\u0010\u0089\u0001\u001a\u00020.2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001J\u0013\u0010\u008a\u0001\u001a\u0002022\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001J\u0013\u0010\u008b\u0001\u001a\u0002022\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u008c\u0001J\u001c\u0010\u008b\u0001\u001a\u0002022\u0007\u0010\u0089\u0001\u001a\u00020.2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u008c\u0001J\u0013\u0010\u008d\u0001\u001a\u0002022\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u008c\u0001J\u0011\u0010\u008e\u0001\u001a\u0002022\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001J\u0011\u0010\u0091\u0001\u001a\u0002022\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001J\u0011\u0010\u0092\u0001\u001a\u0002022\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001J\u0011\u0010\u0095\u0001\u001a\u0002022\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001J\u0012\u0010\u0096\u0001\u001a\u0002022\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010GJ\u0012\u0010\u0098\u0001\u001a\u0002022\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010GJ-\u0010\u0099\u0001\u001a\u0002022\u0007\u0010\u009a\u0001\u001a\u00020.2\u0007\u0010\u009b\u0001\u001a\u00020.2\u0007\u0010\u009c\u0001\u001a\u00020.2\u0007\u0010\u009d\u0001\u001a\u00020.H\u0016J\u0018\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u00012\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0016J\u0011\u0010¢\u0001\u001a\u0002022\b\u0010\u0093\u0001\u001a\u00030£\u0001J\u0011\u0010¤\u0001\u001a\u0002022\b\u0010\u0093\u0001\u001a\u00030£\u0001J\u0007\u0010¥\u0001\u001a\u000202J\u001a\u0010¦\u0001\u001a\u0002022\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010©\u0001\u001a\u00020.J\b\u0010A\u001a\u00020\u000fH\u0002J\u0015\u0010ª\u0001\u001a\u00020\n2\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0002J\t\u0010\u00ad\u0001\u001a\u000202H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010D\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020G0FR\u00020\u00000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0004\n\u0002\u0010JR\u0010\u0010K\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010L\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bL\u0010\u0011R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0004\n\u0002\u0010WR\u0011\u0010X\u001a\u00020Y¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0016\u0010r\u001a\u0004\u0018\u00010s8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR\u000e\u0010x\u001a\u00020yX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006°\u0001"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView;", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/DecorateWebViewV2;", "Lcom/ss/android/lark/chameleon/IChameleonHandlerContext;", "context", "Landroid/content/Context;", "config", "Lcom/ss/android/lark/chameleon/ChameleonConfig;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/chameleon/ChameleonConfig;)V", "mTAG", BuildConfig.FLAVOR, "chameleonConfig", "mWebServiceManager", "Lcom/bytedance/ee/bear/browser/WebServiceManager;", "onLoadSuccess", BuildConfig.FLAVOR, "getOnLoadSuccess", "()Z", "setOnLoadSuccess", "(Z)V", "callbackAdapter", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/UIThreadCallbackAdapter;", "getCallbackAdapter", "()Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/UIThreadCallbackAdapter;", "startLoadUrlTime", BuildConfig.FLAVOR, "getStartLoadUrlTime", "()J", "setStartLoadUrlTime", "(J)V", "preloadUrl", "getPreloadUrl", "()Ljava/lang/String;", "setPreloadUrl", "(Ljava/lang/String;)V", "loadUrl", "getLoadUrl", "setLoadUrl", "status", "Lcom/ss/android/lark/chameleon/pluginapi/WebviewStatus;", "isAttach", "isVisible", "routerState", "Lcom/ss/android/lark/chameleon/pluginapi/RouterState;", "Ljava/io/Serializable;", "usedCount", BuildConfig.FLAVOR, "isReady", "getStatus", "setStatus", BuildConfig.FLAVOR, "value", "getIsAttach", "setIsAttach", "getIsVisible", "setIsVisible", "getRouterState", "setRouterState", "getUsedCount", "setUsedCount", "getIsReady", "setIsReady", "hangDetected", "hangDetectStrategy", "Lcom/ss/android/lark/officewebview/quality/hang/HangDetectStrategy;", "enableForceDark", "chameleonResource", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/res/resupdate/ChameleonResource;", "mScrollChangeListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView$WeakReferenceCallbackWrapper;", "Lcom/bytedance/ee/bear/browser/view/OnScrollChangeListener;", "larkWebViewContext", "com/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView$larkWebViewContext$1", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView$larkWebViewContext$1;", "session", "isProxyEnabled", "isProxyEnabled$delegate", "Lkotlin/Lazy;", "webViewClient", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/ExtendableWebViewClientV2;", "webChromeClient", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/ExtendableWebChromeClient;", "chameleonPreloader", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/preload/ChameleonPreloader;", "webviewHangCallback", "com/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView$webviewHangCallback$1", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView$webviewHangCallback$1;", "jsbAuthManager", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/jsbauth/JsbAuthManager;", "getJsbAuthManager", "()Lcom/ss/android/lark/chameleonv2/container/webcontainer/jsbauth/JsbAuthManager;", "onResume", "onPause", "onStop", "obtainJsbAuthManager", "addWebService", "injectSession", "getWebview", "Landroid/webkit/WebView;", "getCmlContext", "getWebService", "T", "Lcom/bytedance/ee/bear/browser/WebService;", "service", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/ee/bear/browser/WebService;", "getFragment", "Landroidx/fragment/app/Fragment;", "getFragmentHandler", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "handlerName", "destroyWebview", "reloadWebview", "webviewLoader", "Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;", "getWebviewLoader", "()Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;", "getSession", "getBizName", "gson", "Lcom/google/gson/Gson;", "sendEvent", IPortraitService.TYPE, Keys.API_RETURN_KEY_DATA, "(Ljava/lang/String;Ljava/io/Serializable;)V", "getChameleonConfig", "getWebServiceManager", ChameleonOpenTracker.Stage.PRELOAD, "getPreloader", "getResource", "sync", "onAttachedToWindow", "onDetachedFromWindow", "addWebViewClientDelegate", "clientDelegate", "Landroid/webkit/WebViewClient;", "index", "removeWebViewClientDelegate", "addWebChromeClientDelegate", "Landroid/webkit/WebChromeClient;", "removeWebChromeClientDelegate", "addRenderGoneListener", "renderGoneListener", "Lcom/bytedance/ee/bear/browser/Web$IRenderGoneListener;", "removeRenderGoneListener", "addLoadCallback", "cb", "Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader$LoadingCallback;", "removeLoadCallback", "addScrollChangeListener", "scrollChangeListener", "removeScrollChangeListener", "onScrollChanged", "l", "t", "oldl", "oldt", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "addTitleBarCallback", "Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader$IChameleonTitleBarCallback;", "removeTitleBarCallback", "release", "reportOpenStatus", ChameleonOpenTracker.ParamKey.RESULT, "Lcom/ss/android/lark/chameleon/pluginapi/OpenStatus;", "code", "jsbAuthInjectScript", "request", "Landroid/webkit/WebResourceRequest;", "reportHangDetect", "WeakReferenceCallbackWrapper", "InputConnWrapper", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChameleonWebView extends DecorateWebViewV2 implements IChameleonHandlerContext {
    public static final /* synthetic */ int y2 = 0;
    public boolean G1;
    public RouterState<Serializable> H1;
    public int L1;
    public boolean M1;
    public final String P0;
    public boolean P1;
    public HangDetectStrategy Q1;
    public volatile com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d S1;
    public final CopyOnWriteArrayList<d<zv4.f>> T1;
    public final ChameleonConfig V0;
    public String V1;
    public final n b1;
    public final Lazy b2;
    public boolean g1;
    public final com.ss.android.lark.chameleonv2.container.webcontainer.i g2;
    public final UIThreadCallbackAdapter h1;
    public final com.ss.android.lark.chameleonv2.container.webcontainer.h h2;
    public long k1;
    public String p1;
    public final ChameleonPreloader p2;
    public String v1;
    public final g v2;
    public WebviewStatus x1;
    public final p0b.a x2;
    public boolean y1;

    public static final class a implements com.ss.android.lark.chameleonv2.container.webcontainer.j {
        public final /* synthetic */ ChameleonWebView a;

        public a(ChameleonWebView r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chameleonv2.container.webcontainer.j
        public final String a(WebResourceRequest r4) {
            ChameleonWebView r0 = this.a;
            int r1 = ChameleonWebView.y2;
            r0.getClass();
            if (r4 != null) goto L6;
        L13:
            return BuildConfig.FLAVOR;
        L6:
            if (r4.isForMainFrame() == false) goto L13;
            p0b.a r2 = r0.x2;
            if (r2 == null) goto L13;
            if (r2.a() == false) goto L13;
            String r5 = r4.getUrl().toString();
            p0b.a r3 = r0.x2;
            r3.getClass();
            Intrinsics.checkNotNullParameter(r5, "url");
            String r6 = UUID.randomUUID().toString();
            r3.c.put(r6, r5);
            com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_JsbAuthManager", "getScripTextForInject url: " + r5 + ", token: " + r6);
            Intrinsics.checkNotNullParameter(r6, "token");
            return "<script> var chameleonJsbAuthToken = '" + r6 + "'; </script>";
        }
    }

    public static final class b extends WebChromeClient {
        public final /* synthetic */ ChameleonWebView a;

        @Override // android.webkit.WebChromeClient
        public final boolean onJsTimeout() {
            com.ss.android.lark.officesdk.utils.di.j.b(this.a.P0, "onJsTimeout");
            return super.onJsTimeout();
        }

        public b(ChameleonWebView r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage r4) {
            if (r4 != null) goto L4;
            return true;
        L4:
            if (r4.messageLevel().ordinal() <= ConsoleMessage.MessageLevel.LOG.ordinal()) goto L9;
            com.ss.android.lark.officesdk.utils.di.j.e(this.a.P0 + "_js", "onConsoleMessage->" + swb.i.a(r4.message()) + " -- From line " + r4.lineNumber() + swb.i.a(r4.sourceId()));
            return true;
        L9:
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView r2, int r3) {
            super.onProgressChanged(r2, r3);
            if (r3 != 100) goto L22;
            String r4 = this.a.V0.getBizName();
            if (r4 == null) goto L11;
            int r5 = com.ss.android.lark.officesdk.utils.di.d.a;
            v1b.a r6 = (v1b.a) e0c.k.a(com.ss.android.lark.officesdk.utils.di.d.a.a(), v1b.a.class);
            if (r6 == null) goto L11;
            ChameleonWebViewManager r7 = r6.F2();
            if (r7 == null) goto L11;
            Intrinsics.checkNotNullParameter(r4, "bizName");
            ((ArrayList) r7.c).remove(r4);
        L11:
            OpenConfig r8 = this.a.getChameleonConfig().getOpenConfig();
            if (r8 != null) goto L14;
        L16:
            boolean r9 = false;
        L17:
            if (r9 == false) goto L20;
            return;
        L20:
            if (this.a.getOnLoadSuccess() == true) goto L22;
            this.a.setOnLoadSuccess(true);
            this.a.getCallbackAdapter().onLoadSuccess();
            goto L22
        L14:
            if (r8.getHideLoadingByJS() != true) goto L16;
            r9 = true;
        L22:
            this.a.getCallbackAdapter().onLeftBackAndCloseChange();
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(WebView r2, String r3) {
            super.onReceivedTitle(r2, r3);
            this.a.getCallbackAdapter().onReceivedTitle(r2, r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [android.webkit.WebView] */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        @Override // android.webkit.WebChromeClient
        public final boolean onCreateWindow(WebView r1, boolean r2, boolean r3, Message r4) {
            Intrinsics.checkNotNullParameter(r4, "resultMsg");
            com.ss.android.lark.officesdk.utils.di.j.e(this.a.P0, "onCreateWindow");
            ?? r5 = r1;
            if (r1 != null) goto L5;
            r5 = this.a;
        L5:
            WebView r6 = new WebView(r5.getContext());
            r6.setWebViewClient(this.a.g2);
            Object r7 = r4.obj;
            if ((r7 instanceof WebView.WebViewTransport) == false) goto L8;
            WebView.WebViewTransport r8 = (WebView.WebViewTransport) r7;
        L9:
            if (r8 != null) goto L12;
            return false;
        L12:
            r8.setWebView(r6);
            r4.sendToTarget();
            return true;
        L8:
            r8 = null;
            goto L9
        }
    }

    public final class c extends InputConnectionWrapper {
        public c(InputConnection r2) {
            super(r2, true);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            return super.sendKeyEvent(r2);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r18, int r19) {
            if ((r18 - r19) != 1) goto L7;
            long r15 = SystemClock.uptimeMillis();
            sendKeyEvent(new KeyEvent(r15, r15, 0, 67, 0, 0, -1, 0, 22));
            sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), r15, 1, 67, 0, 0, -1, 0, 22));
            return true;
        L7:
            return super.deleteSurroundingText(r18, r19);
        }
    }

    public final class d<T> {
        public final WeakReference<T> a;

        public final int hashCode() {
            T r0 = this.a.get();
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public d(Object r2) {
            this.a = new WeakReference(r2);
        }

        public final boolean equals(Object r4) {
            T r0 = this.a.get();
            if (r0 != null) goto L6;
            return false;
        L6:
            if ((r4 instanceof d) == true) goto L8;
            return false;
        L8:
            T r5 = ((d) r4).a.get();
            if (r5 != null) goto L11;
            return false;
        L11:
            if (r0 != r5) goto L14;
            return true;
        L14:
            return false;
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[WebviewStatus.values().length];
            r0[WebviewStatus.Attached.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r0[WebviewStatus.Visible.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L39:
            r0[WebviewStatus.Hidden.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[WebviewStatus.Detached.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L10:
            a = r0;
            int[] r1 = new int[OpenStatus.values().length];
            r1[OpenStatus.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            r1[OpenStatus.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L25:
            r1[OpenStatus.TIMEOUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L33:
            r1[OpenStatus.CANCEL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L15:
            b = r1;
        }
    }

    public static final class f implements wwb.c {
        public final /* synthetic */ ChameleonWebView a;

        public final oxb.n getServiceManager() {
            return new oxb.n();
        }

        public final Context getWebViewContext() {
            return this.a.getContext();
        }

        public final OfficeWebView getWebView() {
            return this.a;
        }

        public f(ChameleonWebView r1) {
            this.a = r1;
        }
    }

    public static final class g implements jxb.b {
        public final /* synthetic */ ChameleonWebView a;

        public g(ChameleonWebView r1) {
            this.a = r1;
        }

        public final void a(Boolean r1) {
            u1b.a.b = r1;
        }

        public final void b(HangDetectStrategy r3) {
            Intrinsics.checkNotNullParameter(r3, "detectStrategy");
            ChameleonWebView r0 = this.a;
            r0.P1 = true;
            r0.Q1 = r3;
        }
    }

    public static final class h implements IChameleonLoader {
        public final /* synthetic */ ChameleonWebView a;

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void addTitleBarCallback(IChameleonLoader.IChameleonTitleBarCallback r2) {
            Intrinsics.checkNotNullParameter(r2, "cb");
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void load(String r2) {
            Intrinsics.checkNotNullParameter(r2, "url");
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void release() {
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void reload() {
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void removeTitleBarCallback(IChameleonLoader.IChameleonTitleBarCallback r2) {
            Intrinsics.checkNotNullParameter(r2, "cb");
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void reportOpenStatus(OpenStatus r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, ChameleonOpenTracker.ParamKey.RESULT);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final RouterState<Serializable> getRouterState() {
            return this.a.getRouterState();
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final WebviewStatus getStatus() {
            return this.a.getStatus();
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final boolean getVisible() {
            return this.a.getIsVisible();
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void onLoadSuccess() {
            this.a.setIsReady(true);
            this.a.getCallbackAdapter().onLoadSuccess();
        }

        public h(ChameleonWebView r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void addLoadCallback(IChameleonLoader.LoadingCallback r2) {
            Intrinsics.checkNotNullParameter(r2, "cb");
            this.a.w(r2);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void removeLoadCallback(IChameleonLoader.LoadingCallback r2) {
            Intrinsics.checkNotNullParameter(r2, "cb");
            this.a.A(r2);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void setRouteState(RouterState<Serializable> r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            this.a.setRouterState(r2);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void onLoadFailed(int r2, Throwable r3) {
            this.a.getCallbackAdapter().onLoadFail(r2, r3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public WebView getWebview() {
        return this;
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final void destroyWebview() {
        int r0 = com.ss.android.lark.officesdk.utils.di.d.a;
        v1b.a r1 = (v1b.a) e0c.k.a(com.ss.android.lark.officesdk.utils.di.d.a.a(), v1b.a.class);
        if (r1 == null) goto L8;
        ChameleonWebViewManager r2 = r1.F2();
        if (r2 == null) goto L9;
        r2.c(this);
        return;
    L9:
        return;
    }

    public final boolean getIsAttach() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "getIsAttach: " + this.y1);
        return this.y1;
    }

    public final boolean getIsReady() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "getIsReady: " + this.M1);
        return this.M1;
    }

    public final boolean getIsVisible() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "getIsVisible: " + this.G1);
        return this.G1;
    }

    public final RouterState<Serializable> getRouterState() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "getRouterState: " + this.H1);
        return this.H1;
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public String getSession() {
        String r0 = this.V1;
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    public final WebviewStatus getStatus() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "getStatus: " + this.x1);
        return this.x1;
    }

    public final int getUsedCount() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "getUsedCount: " + this.L1);
        return this.L1;
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public IChameleonLoader getWebviewLoader() {
        return new h(this);
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.view.DecorateWebViewV2
    public final void onAttachedToWindow() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "onAttachedToWindow");
        super.onAttachedToWindow();
        setIsAttach(true);
        jxb.a r0 = ((com.ss.android.lark.officewebview.base.g) this).a.a(jxb.a.class);
        if (r0 == null) goto L6;
        r0.H(this.v2);
        return;
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.view.DecorateWebViewV2
    public final void onDetachedFromWindow() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "onDetachedFromWindow");
        super.onDetachedFromWindow();
        setIsAttach(false);
        jxb.a r0 = ((com.ss.android.lark.officewebview.base.g) this).a.a(jxb.a.class);
        if (r0 == null) goto L5;
        r0.N(this.v2);
    L5:
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final void reloadWebview() {
        int r0 = com.ss.android.lark.officesdk.utils.di.d.a;
        v1b.a r1 = (v1b.a) e0c.k.a(com.ss.android.lark.officesdk.utils.di.d.a.a(), v1b.a.class);
        if (r1 == null) goto L8;
        ChameleonWebViewManager r2 = r1.F2();
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(this, "webView");
        com.ss.android.lark.officesdk.utils.di.j.e(r2.a, "reloadWebview()... webView = " + hashCode());
        stopLoading();
        clearHistory();
        z();
        return;
    L9:
        return;
    }

    public final void z() {
        this.p2.d();
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public String getBizName() {
        String r0 = getChameleonConfig().getBizName();
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public Context getCmlContext() {
        Fragment r0 = getFragment();
        if (r0 == null) goto L10;
        FragmentActivity r1 = r0.getActivity();
        if (r1 == null) goto L8;
        return r1;
    L8:
        return getContext();
    L10:
        return getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public Fragment getFragment() {
        return ViewKt.findFragment(this);
    L4:
        return null;
    }

    public final void onPause() {
        super.onPause();
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "onPause");
    }

    public final void onResume() {
        super.onResume();
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "onResume");
        this.P1 = false;
    }

    public final UIThreadCallbackAdapter getCallbackAdapter() {
        return this.h1;
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public ChameleonConfig getChameleonConfig() {
        return this.V0;
    }

    public final p0b.a getJsbAuthManager() {
        return this.x2;
    }

    public final String getLoadUrl() {
        return this.v1;
    }

    public final boolean getOnLoadSuccess() {
        return this.g1;
    }

    public final String getPreloadUrl() {
        return this.p1;
    }

    public final ChameleonPreloader getPreloader() {
        return this.p2;
    }

    public final long getStartLoadUrlTime() {
        return this.k1;
    }

    public final n getWebServiceManager() {
        return this.b1;
    }

    public final void A(IChameleonLoader.LoadingCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "cb");
        UIThreadCallbackAdapter r1 = this.h1;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "cb");
        r1.a.remove(r3);
    }

    public final void B(zv4.f r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.T1.remove(new d(r3));
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final <T extends m> T getWebService(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "service");
        return (T) this.b1.a(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final InputConnection onCreateInputConnection(EditorInfo r2) {
        InputConnection r3 = super/*android.webkit.WebView*/.onCreateInputConnection(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        return new c(r3);
    }

    public final void setIsAttach(boolean r4) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "setIsAttach: " + r4);
        this.y1 = r4;
        if (r4 == false) goto L5;
        setStatus(WebviewStatus.Attached);
        return;
    L5:
        setStatus(WebviewStatus.Detached);
    }

    public final void setIsReady(boolean r4) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "setIsReady: " + r4);
        this.M1 = r4;
    }

    public final void setIsVisible(boolean r4) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "setIsVisible: " + r4);
        this.G1 = r4;
        String r0 = IWebview$Ipc$EventType.VisibilityChange.getValue();
        if (r4 == false) goto L5;
        IWebview$VisibilityState r2 = IWebview$VisibilityState.Visible;
    L6:
        sendEvent(r0, new IWebview$Ipc$VisibilityChangeEvent(r2));
        if (r4 == false) goto L9;
        setStatus(WebviewStatus.Visible);
        return;
    L9:
        setStatus(WebviewStatus.Hidden);
        return;
    L5:
        r2 = IWebview$VisibilityState.Hidden;
        goto L6
    }

    public final void setLoadUrl(String r1) {
        this.v1 = r1;
    }

    public final void setOnLoadSuccess(boolean r1) {
        this.g1 = r1;
    }

    public final void setPreloadUrl(String r1) {
        this.p1 = r1;
    }

    public final void setRouterState(RouterState<Serializable> r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "setRouterState: " + r4);
        this.H1 = r4;
        sendEvent(IWebview$Ipc$EventType.WebviewRouterStateChange.getValue(), new IWebview$Ipc$RouterStateChangeEvent(r4.getPath(), r4.getParams()));
    }

    public final void setStartLoadUrlTime(long r1) {
        this.k1 = r1;
    }

    public final void setStatus(WebviewStatus r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "setStatus: " + r4);
        this.x1 = r4;
        int r5 = e.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        IWebview$Status r6 = IWebview$Status.Attached;
    L16:
        sendEvent(IWebview$Ipc$EventType.WebviewLifecycleStateChange.getValue(), new IWebview$Ipc$StateChangeEvent(r6));
        return;
    L5:
        if (r5 != 2) goto L7;
        r6 = IWebview$Status.Visible;
        goto L16
    L7:
        if (r5 != 3) goto L9;
        r6 = IWebview$Status.Hidden;
        goto L16
    L9:
        if (r5 != 4) goto L12;
        r6 = IWebview$Status.Detached;
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final void setUsedCount(int r4) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "setUsedCount: " + r4);
        this.L1 = r4;
    }

    public final void w(IChameleonLoader.LoadingCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "cb");
        UIThreadCallbackAdapter r1 = this.h1;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "cb");
        r1.a.add(r3);
    }

    public final void x(zv4.f r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        d<zv4.f> r0 = new d(r2);
        if (this.T1.contains(r0) == true) goto L8;
        this.T1.add(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d y(boolean r5) {
        com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d r1 = this.S1;
        if (r1 != null) goto L25;
        monitor-enter(this);
        r1 = this.S1;     // Catch: Throwable -> L22
        if (r1 != null) goto L20;
        List<? extends u0b.a> r2 = t0b.a.a;     // Catch: Throwable -> L22
        r1 = t0b.a.a(getContext(), this.V0, r5, this.V1);     // Catch: Throwable -> L22
        String r3 = this.P0;     // Catch: Throwable -> L22
        StringBuilder r4 = new StringBuilder("get resource, sync = ");     // Catch: Throwable -> L22
        r4.append(r5);     // Catch: Throwable -> L22
        r4.append(", path = ");     // Catch: Throwable -> L22
        VFSPath r6 = r1.a;     // Catch: Throwable -> L22
        if (r6 == null) goto L10;
        String r7 = r6.getAbsolutePath();     // Catch: Throwable -> L22
    L11:
        r4.append(r7);     // Catch: Throwable -> L22
        r4.append(", version = ");     // Catch: Throwable -> L22
        r4.append(r1.b);     // Catch: Throwable -> L22
        com.ss.android.lark.officesdk.utils.di.j.e(r3, r4.toString());     // Catch: Throwable -> L22
        Map<String, u1b.a.C0305a> r8 = u1b.a.a;     // Catch: Throwable -> L22
        u1b.a.C0305a r9 = u1b.a.a(this.V1);     // Catch: Throwable -> L22
        if (r9 == null) goto L18;
        String r10 = r1.b;     // Catch: Throwable -> L22
        if (r10 != null) goto L16;
        r10 = BuildConfig.FLAVOR;
    L16:
        Intrinsics.checkNotNullParameter(ChameleonOpenTracker.ParamKey.RES_VERSION, "key");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r10, "value");     // Catch: Throwable -> L22
        r9.e.put(ChameleonOpenTracker.ParamKey.RES_VERSION, r10);     // Catch: Throwable -> L22
    L18:
        if (r1.a == null) goto L20;
        this.S1 = r1;     // Catch: Throwable -> L22
        goto L20
    L10:
        r7 = null;
    L20:
        monitor-exit(this);
    L22:
        th = move-exception;
        throw th;
    L25:
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.webkit.WebViewClient, com.ss.android.lark.chameleonv2.container.webcontainer.i] */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.webkit.WebChromeClient, com.ss.android.lark.chameleonv2.container.webcontainer.h] */
    public ChameleonWebView(Context r14, ChameleonConfig r15) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "config");
        OpenConfig r1 = r15.getOpenConfig();
        boolean r3 = false;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        super(r14, r2);
        String r4 = "CML_TAG_ChameleonWebView_" + hashCode();
        this.P0 = r4;
        ChameleonConfig r16 = r15.copy();
        this.V0 = r16;
        this.b1 = new n();
        UIThreadCallbackAdapter r5 = new UIThreadCallbackAdapter();
        this.h1 = r5;
        this.k1 = System.currentTimeMillis();
        this.x1 = WebviewStatus.Detached;
        this.H1 = new RouterState(BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        int r6 = com.ss.android.lark.officesdk.utils.di.g.a;
        boolean r7 = com.ss.android.lark.officesdk.utils.di.g.a.a("lark.cml.webview_force_dark");
        this.T1 = new CopyOnWriteArrayList();
        f r8 = new f(this);
        Lazy r9 = LazyKt.lazy(new ChameleonWebView$isProxyEnabled$2(this));
        this.b2 = r9;
        ?? r10 = new com.ss.android.lark.chameleonv2.container.webcontainer.i(r8);
        this.g2 = r10;
        ?? r11 = new com.ss.android.lark.chameleonv2.container.webcontainer.h(r8);
        this.h2 = r11;
        this.p2 = new ChameleonPreloader(this, r16, r5);
        this.v2 = new g(this);
        setBizType(dxb.b.c);
        OpenConfig r12 = r16.getOpenConfig();
        if (r12 == null) goto L11;
        r12.setPluginProvider(null);
    L11:
        String r13 = r16.getBizName();
        if (r13 == null) goto L18;
        setBizScene(r13);
        int r17 = com.ss.android.lark.officesdk.utils.di.d.a;
        v1b.a r18 = (v1b.a) e0c.k.a(com.ss.android.lark.officesdk.utils.di.d.a.a(), v1b.a.class);
        if (r18 == null) goto L18;
        ChameleonWebViewManager r19 = r18.F2();
        if (r19 == null) goto L18;
        Intrinsics.checkNotNullParameter(r13, "bizName");
        ((ArrayList) r19.c).add(r13);
    L18:
        setBackgroundColor(0);
        if (r7 == false) goto L21;
        l(h18.f.a(r14));
    L21:
        setWebViewClient(r10);
        ((CopyOnWriteArrayList) r10.f).add(new a(this));
        setWebChromeClient(r11);
        com.ss.android.lark.chameleonv2.container.webcontainer.res.a r110 = new com.ss.android.lark.chameleonv2.container.webcontainer.res.a();
        if (((Boolean) r9.getValue()).booleanValue() == false) goto L24;
        y0b.b r20 = new ProxyChameleonOfflineResourceInterceptor(this, r16);
    L25:
        Intrinsics.checkNotNullParameter(r20, "interceptor");
        r110.a.add(r20);
        y0b.a r21 = new y0b.a(this, r16);
        Intrinsics.checkNotNullParameter(r21, "interceptor");
        r110.a.add(r21);
        z0b.j r22 = new z0b.j(this, r16);
        Intrinsics.checkNotNullParameter(r22, "interceptor");
        r110.a.add(r22);
        com.ss.android.lark.chameleonv2.container.webcontainer.plugin.b r23 = new com.ss.android.lark.chameleonv2.container.webcontainer.plugin.b(r110, this, r5);
        if (((CopyOnWriteArrayList) r10.e).contains(r23) == true) goto L28;
        ((CopyOnWriteArrayList) r10.e).add(r23);
    L28:
        r11.e = new com.ss.android.lark.chameleonv2.container.webcontainer.view.e(this);
        b r111 = new b(this);
        if (((CopyOnWriteArrayList) r11.d).contains(r111) == true) goto L31;
        ((CopyOnWriteArrayList) r11.d).add(r111);
    L31:
        int r112 = com.ss.android.lark.chameleonv2.container.webcontainer.view.h.a;
        Intrinsics.checkNotNullParameter(this, "webView");
        OpenConfig r113 = getChameleonConfig().getOpenConfig();
        if (r113 != null) goto L34;
    L36:
        boolean r114 = false;
    L37:
        if (r114 == false) goto L39;
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
    L39:
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        WebSettings r115 = getSettings();
        r115.setLoadWithOverviewMode(true);
        r115.setUseWideViewPort(true);
        r115.setJavaScriptEnabled(true);
        r115.setDomStorageEnabled(true);
        r115.setSupportMultipleWindows(false);
        r115.setJavaScriptCanOpenWindowsAutomatically(true);
        r115.setCacheMode(-1);
        r115.setAllowFileAccess(true);
        r115.setDatabaseEnabled(true);
        r115.setMixedContentMode(2);
        Context r24 = getContext();
        Intrinsics.checkNotNullParameter(r24, "context");
        StringBuilder r0 = new StringBuilder();
        String r25 = com.ss.android.lark.officewebview.util.j.a(r24);
        if (r25.length() != 0) goto L42;
        boolean r26 = true;
    L43:
        if (r26 == false) goto L45;
        r25 = "Mozilla/5.0 (Linux; Android 7.0; FRD-AL00 Build/HUAWEIFRD-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36";
    L45:
        r0.append(r25);
        r0.append(" Chameleon");
        r0.append(" Lark/" + AppInfoUtils.a(r24));
        r0.append(" platform/android okhttp/3.2");
        String r27 = r0.toString();
        WebviewConfig r28 = getChameleonConfig().getWebviewConfig();
        if (r28 == null) goto L48;
        String r29 = r28.getBizUAgent();
    L50:
        if (TextUtils.isEmpty(r29) == true) goto L56;
        StringBuilder r30 = new StringBuilder();
        r30.append(r27);
        r30.append(' ');
        WebviewConfig r31 = getChameleonConfig().getWebviewConfig();
        if (r31 == null) goto L54;
        String r32 = r31.getBizUAgent();
    L55:
        r30.append(r32);
        r27 = r30.toString();
        goto L56
    L54:
        r32 = null;
    L56:
        r115.setUserAgentString(r27);
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonWebSettings", "initSettings: ua = " + r27);
        ArrayList r116 = new ArrayList();
        WebviewConfig r33 = r16.getWebviewConfig();
        if (r33 != null) goto L59;
    L61:
        if (r3 == true) goto L68;
        DependencyContainer r34 = DependencyContainer.a;
        l r35 = DependencyContainer.a(l.class, null);
        if (r35 != null) goto L65;
    L67:
        com.ss.android.lark.officesdk.utils.di.j.b(r4, "addWebService, LKAPIDependency is null");
        goto L68
    L65:
        if ((r35.m() instanceof AbsChameleonService) == false) goto L67;
        z0b.i r36 = r35.m();
        Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type com.ss.android.lark.chameleon.AbsChameleonService");
        r116.add(r36);
    L68:
        WebviewConfig r117 = r16.getWebviewConfig();
        if (r117 == null) goto L80;
        IWebService r118 = r117.getWebService();
        if (r118 == null) goto L80;
        List<? extends m> r119 = r118.getWebService();
        if (r119 == null) goto L80;
        com.ss.android.lark.officesdk.utils.di.j.e(r4, "webService size = " + r119.size());
        if ((!r119.isEmpty()) == false) goto L80;
        Iterator<T> r120 = r119.iterator();
    L78:
        if (r120.hasNext() == false) goto L80;
        r116.add((m) r120.next());
    L80:
        this.b1.b(new com.ss.android.lark.chameleonv2.container.webcontainer.view.g(this, getBridge(), this), r116);
        WebviewConfig r121 = this.V0.getWebviewConfig();
        if (r121 == null) goto L84;
        JsbAuthConfig r122 = r121.getJsbAuthConfig();
        if (r122 == null) goto L84;
    L85:
        this.x2 = new p0b.a(r122, this);
        xwb.a r123 = getBridge();
        com.ss.android.lark.chameleonv2.container.webcontainer.util.a r124 = new com.ss.android.lark.chameleonv2.container.webcontainer.util.a(this);
        r123.getClass();
        Intrinsics.checkNotNullParameter(r124, "extension");
        Intrinsics.checkNotNullParameter(r124, "value");
        r123.i = r124;
        new Gson();
        return;
    L84:
        r122 = new JsbAuthConfig(false, false, null, 7, null);
        goto L85
    L59:
        if (r33.getLarkApiEnable() == true) goto L61;
        r3 = true;
        goto L61
    L48:
        r29 = null;
        goto L50
    L42:
        r26 = false;
        goto L43
    L34:
        if (r113.getHideScrollBar() != true) goto L36;
        r114 = true;
        goto L37
    L24:
        r20 = new ChameleonOfflineResourceInterceptor(this, r16);
        goto L25
    L5:
        if (r1.isNestedEnable() != true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final <T extends Serializable> void sendEvent(String r4, T r5) {
        Intrinsics.checkNotNullParameter(r4, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r5, Keys.API_RETURN_KEY_DATA);
        WebviewConfig r0 = this.V0.getWebviewConfig();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        evaluateJavascript(StringsKt.trimIndent("\n                javascript:LarkWebViewJavaScriptBridge.nativeCallBack({\n                  callbackID: 'LarkAPI.ipc.event',\n                  callbackType: 'continued',\n                  data: " + swb.k.b(new AbsChameleonPlugin.LKAPIEvent(r4, -1, r5)) + ",\n                })\n            "), null);
        return;
    L5:
        if (r0.getLarkApiEnable() == true) goto L7;
        r1 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onScrollChanged(int r9, int r10, int r11, int r12) {
        super.onScrollChanged(r9, r10, r11, r12);
        Iterator<d<zv4.f>> r0 = this.T1.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        d<zv4.f> r1 = r0.next();
        if (r1.a.get() != null) goto L7;
        this.T1.remove(r1);
        goto L4
    L7:
        zv4.f r2 = r1.a.get();
        if (r2 == null) goto L4;
        r2.onScrollChange(this, r9, r10, r11, r12);
        goto L4
    }
}
