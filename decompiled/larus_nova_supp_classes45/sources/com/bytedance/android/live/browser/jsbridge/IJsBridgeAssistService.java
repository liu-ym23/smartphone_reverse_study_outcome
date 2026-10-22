package com.bytedance.android.live.browser.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import com.bytedance.android.annie.api.bridge.RegisterPolicy;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.xbridge.XBridgeMethod;
import io.reactivex.Observable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0018\u00010\u0002H&J\b\u0010\b\u001a\u00020\u0007H&J0\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H&J0\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H&J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0011H&J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0011H&J%\u0010\u001c\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00028\u0000H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070 2\u0006\u0010\u001f\u001a\u00020\u001eH'J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020#0 2\u0006\u0010\"\u001a\u00020\u0003H&J\u0018\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0019*\u00020%H&J\u0018\u0010*\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030)2\u0006\u0010(\u001a\u00020'H&J\u0018\u0010-\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030)2\u0006\u0010,\u001a\u00020+H&J\u0018\u0010.\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030)2\u0006\u0010,\u001a\u00020+H&J\u0018\u0010/\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030)2\u0006\u0010,\u001a\u00020+H&J0\u00105\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003040\u00022\b\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u000202H&J(\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002060\u00022\b\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u000202H&J\u0018\u0010;\u001a\u00020\u00072\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u0003H&J\u0018\u0010>\u001a\u00020=2\u0006\u0010<\u001a\u00020\u00032\u0006\u00109\u001a\u000208H&J,\u0010B\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030)0A0\u00022\u0006\u0010@\u001a\u00020?H&J\u0016\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070 2\u0006\u0010D\u001a\u00020CH&J\b\u0010F\u001a\u00020\u0007H&J\b\u0010H\u001a\u00020GH&J\b\u0010I\u001a\u00020\u0007H&J\u001e\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002060L2\b\u0010K\u001a\u0004\u0018\u00010JH&J\b\u0010N\u001a\u00020\u0007H&J\b\u0010O\u001a\u00020\u0007H&J\u0010\u0010S\u001a\u00020R2\u0006\u0010Q\u001a\u00020PH&J\u0016\u0010V\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020U0\u00040TH&J\b\u0010W\u001a\u00020\u0007H&J\u0018\u0010[\u001a\u00020\u00072\u0006\u00109\u001a\u00020X2\u0006\u0010Z\u001a\u00020YH&R\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00030T8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001e0_8&X¦\u0004¢\u0006\u0006\u001a\u0004\b`\u0010a¨\u0006c"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/IJsBridgeAssistService;", "Lcom/bytedance/android/live/base/IService;", "", "", "Ljava/lang/Class;", "Lcom/bytedance/ies/xbridge/XBridgeMethod;", "getMethodList", "", "initPermissionCheck", "Landroid/app/Activity;", "activity", "Landroid/webkit/WebView;", "webView", "Landroid/webkit/WebViewClient;", "webViewClient", "Landroid/webkit/WebChromeClient;", "webChromeClient", "", "type", "Lcom/bytedance/android/livesdkapi/hybridapi/IJsBridgeManager;", "createJsBridgeManager", "Lcom/bytedance/android/livesdkapi/hybridapi/ILiveHybridContainer;", KtvSubElement.CONTAINER, "Lcom/bytedance/ies/web/jsbridge2/b;", "bridgeImpl", "T", "event", "params", "sendEventToAllJsBridges", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lcom/bytedance/android/livesdkapi/hybridapi/BaseJsBridgeMethodFactory;", "factory", "Lio/reactivex/Observable;", "registerExternalMethodFactory", "eventName", "Lcom/bytedance/android/livesdkapi/hybridapi/SubscriberJsEvent;", "registerJsEventSubscriber", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "provideBridgeSupportWidgetClass", "Landroid/view/View;", "view", "Lcom/bytedance/ies/web/jsbridge2/f;", "provideClipMethod", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "provideRegisterMessageLatchMethod", "provideRegisterWRDSMethod", "provideDynamicUnRegisterWRDSMethod", "Lcom/bytedance/ies/web/jsbridge2/d0;", "jsBridge2", "Lcom/bytedance/android/annie/api/bridge/RegisterPolicy;", "registerPolicy", "Lcom/bytedance/ies/web/jsbridge2/g;", "provideDefaultStatelessMethods", "Lcom/bytedance/ies/web/jsbridge2/f$b;", "provideDefaultStatefulMethods", "Ly6/c;", "jsBridgeManager", "xBridgeRegisterStrategy", "registerXBridgeMethods", LiveSlardarConstants.EXTRA_KEY_URL, "Lcom/bytedance/android/live/browser/jsbridge/i$d;", "getNewCurrentState", "Landroidx/fragment/app/Fragment;", "fragment", "Ly6/b;", "provideStateFulFragmentMethods", "Ly6/a;", "annieFactory", "registerAnnieFactory", "registerDataShare", "Lcom/bytedance/ies/tools/prefetch/i;", "newPrefetchNetworkExecutor", "initTTLiveSdkJsb", "Lcom/bytedance/android/livesdkapi/service/MessageHub;", "messageHub", "", "provideRegisterMessageMethodInFeed", "registerState", "registerMatchShareMethods", "Landroid/content/Context;", "context", "Lw30/a;", "getStorageProcessor", "", "", "provideStorageMethods", "registerPayBaseMethod", "Lcom/bytedance/android/annie/bridge/JSBridgeManager;", "Lcom/bytedance/android/annie/api/card/IHybridComponent;", "hybridComponent", "registerSpecialMethod", "getSafeHostList", "()Ljava/util/List;", "safeHostList", "", "getFactoryCollection", "()Ljava/util/Collection;", "factoryCollection", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IJsBridgeAssistService extends IService {
    IJsBridgeManager createJsBridgeManager(Activity r1, WebView r2, WebViewClient r3, WebChromeClient r4, int r5);

    IJsBridgeManager createJsBridgeManager(Activity r1, com.bytedance.ies.web.jsbridge2.b r2, int r3);

    IJsBridgeManager createJsBridgeManager(ILiveHybridContainer r1, WebView r2, WebViewClient r3, WebChromeClient r4, int r5);

    IJsBridgeManager createJsBridgeManager(ILiveHybridContainer r1, com.bytedance.ies.web.jsbridge2.b r2, int r3);

    Collection<BaseJsBridgeMethodFactory> getFactoryCollection();

    Map<String, Class<? extends XBridgeMethod>> getMethodList();

    i.d getNewCurrentState(String r1, y6.c r2);

    List<String> getSafeHostList();

    w30.a getStorageProcessor(Context r1);

    void initPermissionCheck();

    void initTTLiveSdkJsb();

    com.bytedance.ies.tools.prefetch.i newPrefetchNetworkExecutor();

    <T extends LiveRecyclableWidget> Class<T> provideBridgeSupportWidgetClass();

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideClipMethod(View r1);

    Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideDefaultStatefulMethods(com.bytedance.ies.web.jsbridge2.d0 r1, RegisterPolicy r2);

    Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> provideDefaultStatelessMethods(com.bytedance.ies.web.jsbridge2.d0 r1, RegisterPolicy r2);

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideDynamicUnRegisterWRDSMethod(DataCenter r1);

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterMessageLatchMethod(DataCenter r1);

    Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideRegisterMessageMethodInFeed(MessageHub r1);

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterWRDSMethod(DataCenter r1);

    Map<String, y6.b<? extends com.bytedance.ies.web.jsbridge2.f<?, ?>>> provideStateFulFragmentMethods(Fragment r1);

    List<Class<? extends Object>> provideStorageMethods();

    Observable<Unit> registerAnnieFactory(y6.a r1);

    void registerDataShare();

    Observable<Unit> registerExternalMethodFactory(BaseJsBridgeMethodFactory r1);

    Observable<SubscriberJsEvent> registerJsEventSubscriber(String r1);

    void registerMatchShareMethods();

    void registerPayBaseMethod();

    void registerSpecialMethod(JSBridgeManager r1, IHybridComponent r2);

    void registerState();

    void registerXBridgeMethods(y6.c r1, String r2);

    <T> void sendEventToAllJsBridges(String r1, T r2);
}
