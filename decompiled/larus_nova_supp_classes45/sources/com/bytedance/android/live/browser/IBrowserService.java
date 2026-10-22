package com.bytedance.android.live.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.base.ILiveBrowserFragment;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.browser.BrowserServiceImpl")
@Metadata(d1 = {"\u0000¸\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u0089\u00012\u00020\u00012\u00020\u0002:\u0006\u008a\u0001\u008b\u0001\u008c\u0001J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H'J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H'J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H'J.\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H'JB\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H'JB\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H'J4\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u001e\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0012\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010&\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u000fH'J\u0010\u0010'\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u000fH'J&\u0010*\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010#H'J\u0012\u0010,\u001a\u0004\u0018\u00010%2\u0006\u0010+\u001a\u00020\u000fH'J\u0010\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-H'J\b\u00101\u001a\u00020\tH&J\b\u00102\u001a\u00020\u0013H&J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00020!03H&J\b\u00105\u001a\u00020\tH&J\u0010\u00106\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0003H&J&\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u000f2\n\b\u0002\u00108\u001a\u0004\u0018\u000107H&J2\u0010@\u001a\u00020\t2\u0006\u0010<\u001a\u00020;2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u00112\b\u0010?\u001a\u0004\u0018\u00010\u000fH&J-\u0010D\u001a\u00020\t\"\u0004\b\u0000\u0010A2\f\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000B2\b\u0010)\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\bD\u0010EJ*\u0010J\u001a\u00020\t\"\u0004\b\u0000\u0010A2\u001a\u0010I\u001a\u0016\u0012\u0004\u0012\u00020G\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000H0FH&J\u0012\u0010M\u001a\u0004\u0018\u00010L2\u0006\u0010K\u001a\u00020\u000fH&J\u0010\u0010N\u001a\u00020/2\u0006\u0010.\u001a\u00020-H&J\u001a\u0010Q\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010P\"\b\b\u0000\u0010A*\u00020OH&J\u001a\u0010R\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010P\"\b\b\u0000\u0010A*\u00020OH&J\"\u0010V\u001a\u0004\u0018\u00010#2\u0006\u0010S\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020\u000f2\u0006\u0010U\u001a\u00020\u000fH&J\"\u0010W\u001a\u0004\u0018\u00010#2\u0006\u0010S\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020\u000f2\u0006\u0010U\u001a\u00020\u000fH&J \u0010Y\u001a\u00020X2\u0006\u0010S\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020\u000f2\u0006\u0010U\u001a\u00020\u000fH&J\u0012\u0010\\\u001a\u0004\u0018\u00010\u000f2\u0006\u0010[\u001a\u00020ZH&J4\u0010`\u001a\u00020\t2\u0006\u0010[\u001a\u00020Z2\"\u0010_\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0]j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`^H&J\u001e\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020d0c2\b\u0010b\u001a\u0004\u0018\u00010aH&J\u000e\u0010g\u001a\b\u0012\u0004\u0012\u00020!0fH&J0\u0010o\u001a\u00020X2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020k2\u0006\u0010m\u001a\u00020\u00112\u0006\u0010n\u001a\u00020\u0011H&J \u0010q\u001a\u00020\t2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020\u000f2\u0006\u0010p\u001a\u00020XH&J\u001a\u0010s\u001a\u0004\u0018\u00010r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010.\u001a\u00020-H'J$\u0010s\u001a\u0004\u0018\u00010r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010.\u001a\u00020-2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J\u0016\u0010w\u001a\b\u0012\u0004\u0012\u00020\t0v2\u0006\u0010u\u001a\u00020tH'J\u0018\u0010z\u001a\u00020\t2\u0006\u0010x\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020#H&J\u000e\u0010|\u001a\b\u0012\u0004\u0012\u00020{0fH&J.\u0010~\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010}\u001a\u00020\u000f2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0 H&J\b\u0010\u007f\u001a\u00020\tH&J\u001b\u0010\u0082\u0001\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0081\u0001\u001a\u00030\u0080\u0001H&J\u0014\u0010\u0084\u0001\u001a\u00020\t2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u000fH&J\u000f\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020!0fH&J\u0011\u0010\u0086\u0001\u001a\u00020/2\u0006\u0010.\u001a\u00020-H'J\u0012\u0010\u0088\u0001\u001a\u00030\u0087\u00012\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u008d\u0001"}, d2 = {"Lcom/bytedance/android/live/browser/IBrowserService;", "Lcom/bytedance/android/live/browser/IBaseBrowserService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/content/Context;", "context", "Lcom/bytedance/android/live/browser/IBrowserService$PageFinishedListener;", "pageFinishedListener", "Lcom/bytedance/android/live/browser/IBrowserService$PageErrorListener;", "pageErrorListener", "", "getHybridCard", "Landroid/app/Activity;", "activity", "Lu30/c;", "createWebViewRecord", "", LiveSlardarConstants.EXTRA_KEY_URL, "", "presetWidth", "", "loadTaro", "Lcom/bytedance/android/live/browser/LynxThreadStrategy;", "threadStrategy", "Lcom/bytedance/android/live/browser/d0;", "lynxCallback", "Lcom/bytedance/android/live/lynx/api/c;", "createLynxComponent", "oriScheme", "resPrefix", "Lcom/bytedance/android/live/lynx/api/d;", "createOpenLynxComponent", "prefetch", "", "", "getCacheByScheme", "Lorg/json/JSONObject;", "getCacheJsonByScheme", "Lcom/bytedance/android/live/browser/webview/fragment/n;", "buildWebDialog", "buildHostWebDialog", "fallbackSchema", "data", "buildLynxDialog", "scheme", "generateWebDialogBuilder", "Landroid/os/Bundle;", "bundle", "Lcom/bytedance/android/livesdkapi/base/ILiveBrowserFragment;", "createBrowserFragment", "initAnnie", "initAnnieXCardLiveEnv", "", "getBehaviorList", "xBridge3Adapter", "enableDynamicWebOffline", "Lb7/a;", "commonLifecycle", "Lcom/bytedance/android/annie/api/container/HybridDialog;", "showHybridDialogByGenerate", "Landroid/view/View;", "lynxView", "method", "statusCode", "errMsg", "reportLynxFetchJsbError", "T", "Lcom/bytedance/android/live/browser/jsbridge/i$e$e;", "state", "registerOrNotifyState", "(Lcom/bytedance/android/live/browser/jsbridge/i$e$e;Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lcom/bytedance/android/live/browser/jsbridge/i$a;", "stateCreation", "registerStaticState", "key", "Lcom/bytedance/android/live/browser/jsbridge/i$c;", "getStateByKey", "createAnnieFragmentProxy", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Ljava/lang/Class;", "provideTestWidgetClass", "provideBridgeSupportWidgetClass", "pageUrl", "channel", "configName", "readGeckoFile", "readGeckoFromChannel", "", "readGeckoFileVersion", "Landroid/content/Intent;", "intent", "getWebOriginSchema", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "fetchInfo", "addPrefetchInfoToWeb", "Lcom/bytedance/android/livesdkapi/service/MessageHub;", "messageHub", "", "Lcom/bytedance/ies/web/jsbridge2/f$b;", "provideRegisterMessageMethodInFeed", "", "provideLynxLiveBehaviors", "Lcom/bytedance/android/annie/api/card/HybridCard;", "hybridCard", "canvasId", "Landroid/view/Surface;", "surface", "width", "height", "startLynxCast", "surfaceId", "stopLynxCast", "Landroidx/fragment/app/Fragment;", "createLynxFragment", "Lcom/bytedance/android/livesdkapi/hybridapi/BaseJsBridgeMethodFactory;", "factory", "Lio/reactivex/Observable;", "registerExternalMethodFactory", "eventName", "params", "enqueueEvent", "Ljava/util/regex/Pattern;", "getOfflinePatterns", "userId", "openHybridUserProfilePage", "initAnnieGecko", "Lcom/google/gson/JsonObject;", "settings", "updateAnnieSetting", "result", "prepareRemoteDebug", "getLiveExportedXElements", "createSimpleBrowserFragment", "Lw30/a;", "getStorageProcessor", "Companion", "a", "PageErrorListener", "PageFinishedListener", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBrowserService extends IBaseBrowserService, IService {
    public static final a Companion = null;
    public static final int DEFAULT_HALF_SCREEN_HEIGHT_DP_LANDSCAPE = 320;
    public static final int DEFAULT_HALF_SCREEN_HEIGHT_DP_PORTRAIT = 400;
    public static final int DEFAULT_HALF_SCREEN_RADIUS_DP = 8;
    public static final int DEFAULT_HALF_SCREEN_WIDTH_DP_LANDSCAPE = 240;
    public static final int DEFAULT_HALF_SCREEN_WIDTH_DP_PORTRAIT = 300;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/browser/IBrowserService$PageErrorListener;", "Lcom/bytedance/android/live/browser/IBaseBrowserService$PageErrorListener;", "onReceiveError", "", "webView", "Landroid/webkit/WebView;", LiveSlardarConstants.EXTRA_KEY_URL, "", "msg", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface PageErrorListener extends IBaseBrowserService.PageErrorListener {
        @Override // com.bytedance.android.live.browser.IBaseBrowserService.PageErrorListener
        void onReceiveError(WebView r1, String r2, String r3);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/browser/IBrowserService$PageFinishedListener;", "Lcom/bytedance/android/live/browser/IBaseBrowserService$PageFinishedListener;", "onPageFinished", "", "webView", "Landroid/webkit/WebView;", LiveSlardarConstants.EXTRA_KEY_URL, "", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface PageFinishedListener extends IBaseBrowserService.PageFinishedListener {
        @Override // com.bytedance.android.live.browser.IBaseBrowserService.PageFinishedListener
        void onPageFinished(WebView r1, String r2);
    }

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }

    void addPrefetchInfoToWeb(Intent r1, HashMap<String, String> r2);

    @Deprecated(message = "请使用新容器接口")
    com.bytedance.android.live.browser.webview.fragment.n buildHostWebDialog(String r1);

    @Deprecated(message = "请使用新容器接口")
    com.bytedance.android.live.browser.webview.fragment.n buildLynxDialog(String r1, String r2, JSONObject r3);

    @Deprecated(message = "请使用新容器接口")
    com.bytedance.android.live.browser.webview.fragment.n buildWebDialog(String r1);

    ILiveBrowserFragment createAnnieFragmentProxy(Bundle r1);

    @Deprecated(message = "新增代码勿用此方法")
    ILiveBrowserFragment createBrowserFragment(Bundle r1);

    @Deprecated(message = "新增代码勿用此方法")
    com.bytedance.android.live.lynx.api.c createLynxComponent(Activity r1, int r2, String r3, LynxThreadStrategy r4, String r5, d0 r6);

    @Deprecated(message = "新增代码勿用此方法")
    com.bytedance.android.live.lynx.api.c createLynxComponent(Activity r1, int r2, String r3, boolean r4, LynxThreadStrategy r5, d0 r6);

    @Deprecated(message = "新增代码勿用此方法")
    Fragment createLynxFragment(Context r1, Bundle r2);

    Fragment createLynxFragment(Context r1, Bundle r2, d0 r3);

    /* JADX INFO: renamed from: createOpenLynxComponent */
    com.bytedance.android.live.lynx.api.d mo462createOpenLynxComponent(Context r1, int r2, LynxThreadStrategy r3, d0 r4, String r5);

    @Deprecated(message = "新增代码勿用此方法")
    ILiveBrowserFragment createSimpleBrowserFragment(Bundle r1);

    @Deprecated(message = "新增代码勿用此方法")
    u30.c createWebViewRecord(Activity r1, PageFinishedListener r2);

    @Deprecated(message = "新增代码勿用此方法")
    u30.c createWebViewRecord(Activity r1, PageFinishedListener r2, PageErrorListener r3);

    @Deprecated(message = "新增代码勿用此方法")
    u30.c createWebViewRecord(Activity r1, String r2, PageFinishedListener r3, PageErrorListener r4);

    boolean enableDynamicWebOffline(Context r1);

    void enqueueEvent(String r1, JSONObject r2);

    @Deprecated(message = "请使用新容器接口")
    com.bytedance.android.live.browser.webview.fragment.n generateWebDialogBuilder(String r1);

    List<Object> getBehaviorList();

    Map<String, Object> getCacheByScheme(String r1);

    JSONObject getCacheJsonByScheme(String r1);

    @Deprecated(message = "not recommend use")
    void getHybridCard(Context r1, PageFinishedListener r2, PageErrorListener r3);

    List<Object> getLiveExportedXElements();

    List<Pattern> getOfflinePatterns();

    com.bytedance.android.live.browser.jsbridge.i.c getStateByKey(String r1);

    w30.a getStorageProcessor(Context r1);

    String getWebOriginSchema(Intent r1);

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    void initAnnie();

    void initAnnieGecko();

    boolean initAnnieXCardLiveEnv();

    void openHybridUserProfilePage(Context r1, String r2, Map<String, String> r3);

    void prefetch(String r1);

    void prepareRemoteDebug(String r1);

    <T extends LiveRecyclableWidget> Class<T> provideBridgeSupportWidgetClass();

    List<Object> provideLynxLiveBehaviors();

    Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideRegisterMessageMethodInFeed(MessageHub r1);

    <T extends LiveRecyclableWidget> Class<T> provideTestWidgetClass();

    JSONObject readGeckoFile(String r1, String r2, String r3);

    long readGeckoFileVersion(String r1, String r2, String r3);

    JSONObject readGeckoFromChannel(String r1, String r2, String r3);

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    Observable<Unit> registerExternalMethodFactory(BaseJsBridgeMethodFactory r1);

    <T> void registerOrNotifyState(com.bytedance.android.live.browser.jsbridge.i.e.AbstractC0111e<T> r1, T r2);

    <T> void registerStaticState(Function1<? super DataCenter, ? extends com.bytedance.android.live.browser.jsbridge.i.a<? extends T>> r1);

    void reportLynxFetchJsbError(View r1, String r2, String r3, int r4, String r5);

    HybridDialog showHybridDialogByGenerate(Context r1, String r2, b7.a r3);

    long startLynxCast(HybridCard r1, String r2, Surface r3, int r4, int r5);

    void stopLynxCast(HybridCard r1, String r2, long r3);

    void updateAnnieSetting(Context r1, JsonObject r2);

    void xBridge3Adapter();
}
