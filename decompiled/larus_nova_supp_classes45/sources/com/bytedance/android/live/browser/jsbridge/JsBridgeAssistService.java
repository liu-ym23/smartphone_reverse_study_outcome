package com.bytedance.android.live.browser.jsbridge;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.bridge.RegisterPolicy;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.browser.ISaaSBrowserService;
import com.bytedance.android.live.browser.api.UploadApi;
import com.bytedance.android.live.browser.jsbridge.base.LiveAnchorContractAVRecordResultModel;
import com.bytedance.android.live.browser.jsbridge.newmethods.GetVisualEventTrackingSettingsMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.MeasureTextMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.OpenLiveEffectPanelMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.ShowPaidLiveTicketEditPageMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.ShowStikerMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.aa;
import com.bytedance.android.live.browser.jsbridge.newmethods.ac;
import com.bytedance.android.live.browser.jsbridge.newmethods.ad;
import com.bytedance.android.live.browser.jsbridge.newmethods.ae;
import com.bytedance.android.live.browser.jsbridge.newmethods.b9;
import com.bytedance.android.live.browser.jsbridge.newmethods.bb;
import com.bytedance.android.live.browser.jsbridge.newmethods.c4;
import com.bytedance.android.live.browser.jsbridge.newmethods.c6;
import com.bytedance.android.live.browser.jsbridge.newmethods.c9;
import com.bytedance.android.live.browser.jsbridge.newmethods.ca;
import com.bytedance.android.live.browser.jsbridge.newmethods.cd;
import com.bytedance.android.live.browser.jsbridge.newmethods.d4;
import com.bytedance.android.live.browser.jsbridge.newmethods.d5;
import com.bytedance.android.live.browser.jsbridge.newmethods.d8;
import com.bytedance.android.live.browser.jsbridge.newmethods.dc;
import com.bytedance.android.live.browser.jsbridge.newmethods.dd;
import com.bytedance.android.live.browser.jsbridge.newmethods.e4;
import com.bytedance.android.live.browser.jsbridge.newmethods.e5;
import com.bytedance.android.live.browser.jsbridge.newmethods.e7;
import com.bytedance.android.live.browser.jsbridge.newmethods.eb;
import com.bytedance.android.live.browser.jsbridge.newmethods.f6;
import com.bytedance.android.live.browser.jsbridge.newmethods.f9;
import com.bytedance.android.live.browser.jsbridge.newmethods.fa;
import com.bytedance.android.live.browser.jsbridge.newmethods.fb;
import com.bytedance.android.live.browser.jsbridge.newmethods.fc;
import com.bytedance.android.live.browser.jsbridge.newmethods.g5;
import com.bytedance.android.live.browser.jsbridge.newmethods.g6;
import com.bytedance.android.live.browser.jsbridge.newmethods.g8;
import com.bytedance.android.live.browser.jsbridge.newmethods.g9;
import com.bytedance.android.live.browser.jsbridge.newmethods.ga;
import com.bytedance.android.live.browser.jsbridge.newmethods.gb;
import com.bytedance.android.live.browser.jsbridge.newmethods.ge;
import com.bytedance.android.live.browser.jsbridge.newmethods.ha;
import com.bytedance.android.live.browser.jsbridge.newmethods.hc;
import com.bytedance.android.live.browser.jsbridge.newmethods.hd;
import com.bytedance.android.live.browser.jsbridge.newmethods.i5;
import com.bytedance.android.live.browser.jsbridge.newmethods.i9;
import com.bytedance.android.live.browser.jsbridge.newmethods.id;
import com.bytedance.android.live.browser.jsbridge.newmethods.j9;
import com.bytedance.android.live.browser.jsbridge.newmethods.kb;
import com.bytedance.android.live.browser.jsbridge.newmethods.l8;
import com.bytedance.android.live.browser.jsbridge.newmethods.m8;
import com.bytedance.android.live.browser.jsbridge.newmethods.m9;
import com.bytedance.android.live.browser.jsbridge.newmethods.mb;
import com.bytedance.android.live.browser.jsbridge.newmethods.n9;
import com.bytedance.android.live.browser.jsbridge.newmethods.o4;
import com.bytedance.android.live.browser.jsbridge.newmethods.o6;
import com.bytedance.android.live.browser.jsbridge.newmethods.o8;
import com.bytedance.android.live.browser.jsbridge.newmethods.o9;
import com.bytedance.android.live.browser.jsbridge.newmethods.p9;
import com.bytedance.android.live.browser.jsbridge.newmethods.q5;
import com.bytedance.android.live.browser.jsbridge.newmethods.qb;
import com.bytedance.android.live.browser.jsbridge.newmethods.rb;
import com.bytedance.android.live.browser.jsbridge.newmethods.s5;
import com.bytedance.android.live.browser.jsbridge.newmethods.s6;
import com.bytedance.android.live.browser.jsbridge.newmethods.sb;
import com.bytedance.android.live.browser.jsbridge.newmethods.sc;
import com.bytedance.android.live.browser.jsbridge.newmethods.t4;
import com.bytedance.android.live.browser.jsbridge.newmethods.tb;
import com.bytedance.android.live.browser.jsbridge.newmethods.tc;
import com.bytedance.android.live.browser.jsbridge.newmethods.ud;
import com.bytedance.android.live.browser.jsbridge.newmethods.v3;
import com.bytedance.android.live.browser.jsbridge.newmethods.v4;
import com.bytedance.android.live.browser.jsbridge.newmethods.v5;
import com.bytedance.android.live.browser.jsbridge.newmethods.v8;
import com.bytedance.android.live.browser.jsbridge.newmethods.w4;
import com.bytedance.android.live.browser.jsbridge.newmethods.w8;
import com.bytedance.android.live.browser.jsbridge.newmethods.wa;
import com.bytedance.android.live.browser.jsbridge.newmethods.wd;
import com.bytedance.android.live.browser.jsbridge.newmethods.x7;
import com.bytedance.android.live.browser.jsbridge.newmethods.x8;
import com.bytedance.android.live.browser.jsbridge.newmethods.x9;
import com.bytedance.android.live.browser.jsbridge.newmethods.xb;
import com.bytedance.android.live.browser.jsbridge.newmethods.xc;
import com.bytedance.android.live.browser.jsbridge.newmethods.y8;
import com.bytedance.android.live.browser.jsbridge.newmethods.yd;
import com.bytedance.android.live.browser.jsbridge.newmethods.z6;
import com.bytedance.android.live.browser.jsbridge.newmethods.z8;
import com.bytedance.android.live.browser.jsbridge.newmethods.zb;
import com.bytedance.android.live.browser.jsbridge.newmethods.zd;
import com.bytedance.android.live.browser.jsbridge.prefetch.PrefetchNetworkExecutorImpl;
import com.bytedance.android.live.browser.jsbridge.state.StateObserver;
import com.bytedance.android.live.browser.jsbridge.widget.BridgeSupportWidget;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livesdk.config.m01;
import com.bytedance.android.livesdk.config.q91;
import com.bytedance.android.livesdk.config.s9;
import com.bytedance.android.livesdk.config.w00;
import com.bytedance.android.livesdk.config.w30;
import com.bytedance.android.livesdk.interactivity.api.IBarrageService;
import com.bytedance.android.livesdk.interactivity.api.IImageRecognitionService;
import com.bytedance.android.livesdk.interactivity.api.IVirtualInteractService;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.android.livesdkapi.hybridapi.IMiddlewareJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.xbridge.XBridge;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XBridgeRegister;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w20.ia;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bv\u0010wJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u0018\u00010\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J0\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J0\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J%\u0010 \u001a\u00020\u000b\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b \u0010!J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\"2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\"2\u0006\u0010$\u001a\u00020\u0007H\u0016J\u0018\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u001d*\u00020'H\u0016J\u0018\u0010,\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030+2\u0006\u0010*\u001a\u00020)H\u0016J\u0018\u0010/\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030+2\u0006\u0010.\u001a\u00020-H\u0016J\u0018\u00100\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030+2\u0006\u0010.\u001a\u00020-H\u0016J\u0018\u00101\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030+2\u0006\u0010.\u001a\u00020-H\u0016J&\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002060\u00062\b\u00103\u001a\u0004\u0018\u0001022\u0006\u00105\u001a\u000204H\u0016J.\u00109\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003080\u00062\b\u00103\u001a\u0004\u0018\u0001022\u0006\u00105\u001a\u000204H\u0016J\u0018\u0010=\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020\u0007H\u0016J\u0018\u0010@\u001a\u00020?2\u0006\u0010>\u001a\u00020\u00072\u0006\u0010;\u001a\u00020:H\u0016J,\u0010D\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030+0C0\u00062\u0006\u0010B\u001a\u00020AH\u0016J\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000b0\"2\u0006\u0010E\u001a\u00020\u0004H\u0016J\b\u0010G\u001a\u00020\u000bH\u0016J\b\u0010I\u001a\u00020HH\u0016J\b\u0010J\u001a\u00020\u000bH\u0016J\u001e\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002060M2\b\u0010L\u001a\u0004\u0018\u00010KH\u0016J\b\u0010O\u001a\u00020\u000bH\u0016J\b\u0010P\u001a\u00020\u000bH\u0016J\u0010\u0010T\u001a\u00020S2\u0006\u0010R\u001a\u00020QH\u0016J\u0016\u0010W\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020V0\b0UH\u0016J\b\u0010X\u001a\u00020\u000bH\u0016J\u0018\u0010\\\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020Y2\u0006\u0010[\u001a\u00020ZH\u0016R\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020^0]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010`R\u001b\u0010g\u001a\u00020b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u001b\u0010l\u001a\u00020h8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010d\u001a\u0004\bj\u0010kR\u001a\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00040]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010`R!\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00070U8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bn\u0010d\u001a\u0004\bo\u0010pR\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00020r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bs\u0010t¨\u0006x"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/JsBridgeAssistService;", "Lcom/bytedance/android/live/browser/jsbridge/IJsBridgeAssistService;", "Lcom/bytedance/android/livesdkapi/hybridapi/BaseJsBridgeMethodFactory;", "factory", "Ly6/a;", "getCompatAnnieMethodRegister", "", "", "Ljava/lang/Class;", "Lcom/bytedance/ies/xbridge/XBridgeMethod;", "getMethodList", "", "initPermissionCheck", "Landroid/app/Activity;", "activity", "Landroid/webkit/WebView;", "webView", "Landroid/webkit/WebViewClient;", "webViewClient", "Landroid/webkit/WebChromeClient;", "webChromeClient", "", "type", "Lcom/bytedance/android/livesdkapi/hybridapi/IJsBridgeManager;", "createJsBridgeManager", "Lcom/bytedance/android/livesdkapi/hybridapi/ILiveHybridContainer;", KtvSubElement.CONTAINER, "Lcom/bytedance/ies/web/jsbridge2/b;", "bridgeImpl", "T", "event", "params", "sendEventToAllJsBridges", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lio/reactivex/Observable;", "registerExternalMethodFactory", "eventName", "Lcom/bytedance/android/livesdkapi/hybridapi/SubscriberJsEvent;", "registerJsEventSubscriber", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "provideBridgeSupportWidgetClass", "Landroid/view/View;", "view", "Lcom/bytedance/ies/web/jsbridge2/f;", "provideClipMethod", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "provideRegisterMessageLatchMethod", "provideRegisterWRDSMethod", "provideDynamicUnRegisterWRDSMethod", "Lcom/bytedance/ies/web/jsbridge2/d0;", "jsBridge2", "Lcom/bytedance/android/annie/api/bridge/RegisterPolicy;", "registerPolicy", "Lcom/bytedance/ies/web/jsbridge2/f$b;", "provideDefaultStatefulMethods", "Lcom/bytedance/ies/web/jsbridge2/g;", "provideDefaultStatelessMethods", "Ly6/c;", "jsBridgeManager", "xBridgeRegisterStrategy", "registerXBridgeMethods", LiveSlardarConstants.EXTRA_KEY_URL, "Lcom/bytedance/android/live/browser/jsbridge/i$d;", "getNewCurrentState", "Landroidx/fragment/app/Fragment;", "fragment", "Ly6/b;", "provideStateFulFragmentMethods", "annieFactory", "registerAnnieFactory", "registerDataShare", "Lcom/bytedance/ies/tools/prefetch/i;", "newPrefetchNetworkExecutor", "initTTLiveSdkJsb", "Lcom/bytedance/android/livesdkapi/service/MessageHub;", "messageHub", "", "provideRegisterMessageMethodInFeed", "registerState", "registerMatchShareMethods", "Landroid/content/Context;", "context", "Lw30/a;", "getStorageProcessor", "", "", "provideStorageMethods", "registerPayBaseMethod", "Lcom/bytedance/android/annie/bridge/JSBridgeManager;", "Lcom/bytedance/android/annie/api/card/IHybridComponent;", "hybridComponent", "registerSpecialMethod", "", "Lcom/bytedance/android/live/browser/jsbridge/JsBridgeManager;", "managerCollection", "Ljava/util/Collection;", "mFactoryCollection", "Lcom/bytedance/android/tools/superkv/e;", "kv$delegate", "Lkotlin/Lazy;", "getKv", "()Lcom/bytedance/android/tools/superkv/e;", "kv", "Lcom/bytedance/android/live/browser/jsbridge/IJsBridgeModuleService;", "jsbridgemoduleService$delegate", "getJsbridgemoduleService", "()Lcom/bytedance/android/live/browser/jsbridge/IJsBridgeModuleService;", "jsbridgemoduleService", "mAnnieFactoryCollection", "safeHostList$delegate", "getSafeHostList", "()Ljava/util/List;", "safeHostList", "", "getFactoryCollection", "()Ljava/util/Collection;", "factoryCollection", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class JsBridgeAssistService implements IJsBridgeAssistService {
    private final Lazy jsbridgemoduleService$delegate;
    private final Lazy kv$delegate;
    private final Collection<y6.a> mAnnieFactoryCollection;
    private final Collection<BaseJsBridgeMethodFactory> mFactoryCollection;
    private final Collection<JsBridgeManager> managerCollection;
    private final Lazy safeHostList$delegate;

    public static final class a extends y6.a {
        public final String b;
        public final /* synthetic */ BaseJsBridgeMethodFactory c;

        public final Map<String, n56.c> c() {
            return this.c.provideLegacyCacheableMethods();
        }

        public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> j() {
            return this.c.provideStatefulCacheableMethods();
        }

        public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> m() {
            return this.c.provideStatelessCacheableMethods();
        }

        public final String a() {
            return this.b;
        }

        public a(BaseJsBridgeMethodFactory r1) {
            this.c = r1;
            this.b = "JsBridgeAssistService";
        }

        public final Map<String, n56.c> d(y6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            return this.c.provideLegacyMethods(new com.bytedance.android.live.browser.jsbridge.j(r3));
        }

        public final Map<String, n56.c> e(y6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            return this.c.provideLegacySpecifiedMethods(new com.bytedance.android.live.browser.jsbridge.j(r3));
        }

        public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> k(y6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            return this.c.provideStatefulMethods(new com.bytedance.android.live.browser.jsbridge.j(r3));
        }

        public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> l(y6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            return this.c.provideStatefulSpecifiedMethods(new com.bytedance.android.live.browser.jsbridge.j(r3));
        }

        public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> n(y6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            return this.c.provideStatelessMethods(new com.bytedance.android.live.browser.jsbridge.j(r3));
        }

        public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> o(y6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            return this.c.provideStatelessSpecifiedMethods(new com.bytedance.android.live.browser.jsbridge.j(r3));
        }
    }

    public static final class a0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a0 a = null;

        static {
            a = new a0();
        }

        public a0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new j9();
        }
    }

    public static final class a1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a1 a = null;

        static {
            a = new a1();
        }

        public a1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new f9();
        }
    }

    public static final class a2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a2 a = null;

        static {
            a = new a2();
        }

        public a2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new t4();
        }
    }

    public static final class a3 implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ MessageHub a;

        public a3(MessageHub r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ga(null, this.a);
        }
    }

    public static final class b implements w30.a {
        public final /* synthetic */ Context a;

        public b(Context r1) {
            this.a = r1;
        }

        @Override // w30.a
        public final void setStorage(String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "key");
            Intrinsics.checkNotNullParameter(r5, "value");
            this.a.getSharedPreferences("js_kv_methods_20191113", 0).edit().putString(r4, r5).commit();
        }
    }

    public static final class b0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final b0 a = null;

        static {
            a = new b0();
        }

        public b0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new c4();
        }
    }

    public static final class b1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final b1 a = null;

        static {
            a = new b1();
        }

        public b1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new sc();
        }
    }

    public static final class b2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final b2 a = null;

        static {
            a = new b2();
        }

        public b2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new d4();
        }
    }

    public static final class b3 implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ MessageHub a;

        public b3(MessageHub r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ha(null, this.a);
        }
    }

    public static final class c implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.answer.c();
        }
    }

    public static final class c0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final c0 a = null;

        static {
            a = new c0();
        }

        public c0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.h0();
        }
    }

    public static final class c1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final c1 a = null;

        static {
            a = new c1();
        }

        public c1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new OpenLiveEffectPanelMethod();
        }
    }

    public static final class c2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final c2 a = null;

        static {
            a = new c2();
        }

        public c2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.k2();
        }
    }

    public static final class c3 extends y6.b<com.bytedance.android.live.browser.jsbridge.upload.b0> {
        public final /* synthetic */ Fragment b;

        public final com.bytedance.ies.web.jsbridge2.f<?, ?> b() {
            return new com.bytedance.android.live.browser.jsbridge.upload.b0(this.b);
        }

        public c3(Fragment r1) {
            this.b = r1;
        }

        public final void onActivityResult(int r4, int r5, Intent r6) {
            com.bytedance.android.live.browser.jsbridge.upload.b0 r0 = (com.bytedance.android.live.browser.jsbridge.upload.b0) ((y6.b) this).a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.a != null) goto L7;
            return;
        L7:
            if (((Boolean) w00.a.getValue()).booleanValue() != true) goto L9;
            r0.a.r(r4, r5, r6);
            return;
        L9:
            r0.a.q(r4, r5, r6);
        }
    }

    public static final class d implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.answer.d();
        }
    }

    public static final class d0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final d0 a = null;

        static {
            a = new d0();
        }

        public d0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new kb();
        }
    }

    public static final class d1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final d1 a = null;

        static {
            a = new d1();
        }

        public d1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new id();
        }
    }

    public static final class d2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final d2 a = null;

        static {
            a = new d2();
        }

        public d2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new xc();
        }
    }

    public static final class d3 extends y6.b<com.bytedance.android.live.browser.jsbridge.upload.f0> {
        public final /* synthetic */ Fragment b;

        public final com.bytedance.ies.web.jsbridge2.f<?, ?> b() {
            return new com.bytedance.android.live.browser.jsbridge.upload.f0(this.b);
        }

        public d3(Fragment r1) {
            this.b = r1;
        }

        public final void onActivityResult(int r2, int r3, Intent r4) {
            com.bytedance.android.live.browser.jsbridge.upload.f0 r0 = (com.bytedance.android.live.browser.jsbridge.upload.f0) ((y6.b) this).a;
            if (r0 == null) goto L6;
            r0.onActivityResult(r2, r3, r4);
            return;
        }
    }

    public static final class e implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new e4();
        }
    }

    public static final class e0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final e0 a = null;

        static {
            a = new e0();
        }

        public e0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new l8();
        }
    }

    public static final class e1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final e1 a = null;

        static {
            a = new e1();
        }

        public e1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.w1();
        }
    }

    public static final class e2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final e2 a = null;

        static {
            a = new e2();
        }

        public e2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new eb();
        }
    }

    public static final class e3 extends y6.b<com.bytedance.android.live.browser.jsbridge.upload.i0> {
        public final /* synthetic */ Fragment b;

        public final com.bytedance.ies.web.jsbridge2.f<?, ?> b() {
            return new com.bytedance.android.live.browser.jsbridge.upload.i0(this.b);
        }

        public e3(Fragment r1) {
            this.b = r1;
        }

        public final void onActivityResult(int r8, int r9, Intent r11) {
            com.bytedance.android.live.browser.jsbridge.upload.i0 r0 = (com.bytedance.android.live.browser.jsbridge.upload.i0) ((y6.b) this).a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (9001 == r8) goto L9;
            if (9002 == r8) goto L9;
            return;
        L9:
            if ((-1) != r9) goto L30;
            if (r11 == null) goto L30;
            if (r11.getData() == null) goto L30;
            Fragment r12 = r0.b;
            if (r12 == null) goto L41;
            FragmentActivity r13 = r12.getActivity();
            if (r13 != null) goto L20;
            r0.k();
            return;
        L20:
            Uri r14 = r11.getData();
            Logger.d("RecordVideoMethod", "onActivityResult: uri=" + r14.toString());
            ae7.a r1 = ae7.a.a;
            String r15 = r14.toString();
            r1.getClass();
            String r16 = ae7.a.a(r13, r15);
            Logger.d("RecordVideoMethod", "onActivityResult: saveFile=" + r16);
            if (TextUtils.isEmpty(r16) == false) goto L23;
            JSONObject r17 = new JSONObject();
            BaseMonitor.add(r17, LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, "file name is empty");
            LiveSlardarMonitor.monitorStatus("ttlive_upload_video_error", 3, r17);
            r0.k();
            return;
        L23:
            PolarisFileWrapper r2 = new PolarisFileWrapper(r16);
            if (r2.exists() == true) goto L26;
            JSONObject r18 = new JSONObject();
            BaseMonitor.add(r18, LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, "file not exist");
            LiveSlardarMonitor.monitorStatus("ttlive_upload_video_error", 5, r18);
            r0.k();
            return;
        L26:
            r0.c = ProgressDialog.show(r13, com.bytedance.android.live.core.utils.s1.B(2131923438), com.bytedance.android.live.core.utils.s1.B(2131923437), true, false);
            if (r2.exists() == true) goto L29;
            JSONObject r19 = new JSONObject();
            BaseMonitor.add(r19, LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, "file not exist");
            LiveSlardarMonitor.monitorStatus("ttlive_upload_video_error", 7, r19);
            r0.k();
            return;
        L29:
            TypedOutput r21 = new MultipartTypedOutput();
            r21.addPart("data", new TypedFile("multipart/form-data", r2));
            ((UploadApi) com.bytedance.android.live.network.c.b().e(UploadApi.class)).upload(r21).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.browser.jsbridge.upload.h0(r0, r2.getAbsolutePath()));
            return;
        L41:
            return;
        L30:
            if ((-1) == r9) goto L32;
            JSONObject r110 = new JSONObject();
            BaseMonitor.add(r110, LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, "resultCode error: " + r9);
            LiveSlardarMonitor.monitorStatus("ttlive_upload_video_error", 1, r110);
        L32:
            r0.k();
        }
    }

    public static final class f implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ge();
        }
    }

    public static final class f0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final f0 a = null;

        static {
            a = new f0();
        }

        public f0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new m8();
        }
    }

    public static final class f1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final f1 a = null;

        static {
            a = new f1();
        }

        public f1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.c2();
        }
    }

    public static final class f2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final f2 a = null;

        static {
            a = new f2();
        }

        public f2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.y1();
        }
    }

    public static final class f3 extends y6.b<com.bytedance.android.live.browser.jsbridge.upload.q> {
        public final /* synthetic */ Fragment b;

        public final com.bytedance.ies.web.jsbridge2.f<?, ?> b() {
            return new com.bytedance.android.live.browser.jsbridge.upload.q(this.b);
        }

        public f3(Fragment r1) {
            this.b = r1;
        }

        public final void onActivityResult(int r2, int r3, Intent r4) {
            com.bytedance.android.live.browser.jsbridge.upload.q r0 = (com.bytedance.android.live.browser.jsbridge.upload.q) ((y6.b) this).a;
            if (r0 == null) goto L6;
            r0.onActivityResult(r2, r3, r4);
            return;
        }
    }

    public static final class g implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new n9();
        }
    }

    public static final class g0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final g0 a = null;

        static {
            a = new g0();
        }

        public g0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new p9();
        }
    }

    public static final class g1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final g1 a = null;

        static {
            a = new g1();
        }

        public g1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.u1();
        }
    }

    public static final class g2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final g2 a = null;

        static {
            a = new g2();
        }

        public g2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new b9();
        }
    }

    public static final class g3 extends y6.b<ia> {
        public final /* synthetic */ Fragment b;

        public final com.bytedance.ies.web.jsbridge2.f<?, ?> b() {
            return new ia(this.b);
        }

        public g3(Fragment r1) {
            this.b = r1;
        }

        public final void onActivityResult(int r6, int r7, Intent r8) {
            ia r0 = (ia) ((y6.b) this).a;
            if (r0 == null) goto L40;
            ALogger.i("LiveAnchorContractAvRecordMethod", "onActivityResult,requestCode :" + r6 + ",resultCode:" + r7);
            if (10000 == r6) goto L7;
            return;
        L7:
            if ((-1) == r7) goto L10;
            ALogger.i("LiveAnchorContractAvRecordMethod", "onActivityResult,取消操作");
            LiveAnchorContractAVRecordResultModel r9 = new LiveAnchorContractAVRecordResultModel();
            r9.a(LiveAnchorContractAVRecordResultModel.Code.Success);
            r9.c(3);
            r9.d("取消操作");
            r0.finishWithResult(r9);
            return;
        L10:
            if (r8 == null) goto L36;
            String r11 = r8.getStringExtra("uri");
            String r1 = r8.getStringExtra("local_url");
            String r12 = r8.getStringExtra("local_img");
            ALogger.i("LiveAnchorContractAvRecordMethod", "uri:" + r11 + ",localUrl:" + r11 + ",localImg:" + r12);
            boolean r2 = false;
            if (r11 != null) goto L14;
        L17:
            boolean r4 = true;
        L18:
            if (r4 == true) goto L35;
            if (r1 != null) goto L21;
        L24:
            boolean r5 = true;
        L25:
            if (r5 == true) goto L35;
            if (r12 != null) goto L28;
        L29:
            r2 = true;
        L30:
            if (r2 == true) goto L35;
            LiveAnchorContractAVRecordResultModel.a r13 = new LiveAnchorContractAVRecordResultModel.a();     // Catch: Exception -> L33
            r13.c(r11);     // Catch: Exception -> L33
            o30.c.b.getClass();     // Catch: Exception -> L33
            r13.b(o30.c.a(r1));     // Catch: Exception -> L33
            r13.a(o30.c.a(r12));     // Catch: Exception -> L33
            LiveAnchorContractAVRecordResultModel r14 = new LiveAnchorContractAVRecordResultModel();     // Catch: Exception -> L33
            r14.a(LiveAnchorContractAVRecordResultModel.Code.Success);     // Catch: Exception -> L33
            r14.c(1);     // Catch: Exception -> L33
            r14.d("成功");     // Catch: Exception -> L33
            r14.b(r13);     // Catch: Exception -> L33
            r0.finishWithResult(r14);     // Catch: Exception -> L33
            return;
        L33:
            e = move-exception;
            e.printStackTrace();
            return;
        L28:
            if (r12.length() != 0) goto L30;
        L21:
            if (r1.length() == 0) goto L24;
            r5 = false;
        L35:
            LiveAnchorContractAVRecordResultModel r15 = new LiveAnchorContractAVRecordResultModel();
            r15.a(LiveAnchorContractAVRecordResultModel.Code.Success);
            r15.c(2);
            r15.d("uri is null");
            r0.finishWithResult(r15);
            return;
        L14:
            if (r11.length() == 0) goto L17;
            r4 = false;
            goto L18
        L36:
            LiveAnchorContractAVRecordResultModel r16 = new LiveAnchorContractAVRecordResultModel();
            r16.a(LiveAnchorContractAVRecordResultModel.Code.Success);
            r16.c(2);
            r16.d("data is null");
            r0.finishWithResult(r16);
            return;
        }
    }

    public static final class h implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new aa();
        }
    }

    public static final class h0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final h0 a = null;

        static {
            a = new h0();
        }

        public h0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.z();
        }
    }

    public static final class h1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final h1 a = null;

        static {
            a = new h1();
        }

        public h1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getRequestShowMethod();
        }
    }

    public static final class h2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final h2 a = null;

        static {
            a = new h2();
        }

        public h2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.a0();
        }
    }

    public static final class h3 extends y6.b<com.bytedance.android.live.browser.jsbridge.upload.a> {
        public final /* synthetic */ Fragment b;

        public final com.bytedance.ies.web.jsbridge2.f<?, ?> b() {
            return new com.bytedance.android.live.browser.jsbridge.upload.a(this.b);
        }

        public h3(Fragment r1) {
            this.b = r1;
        }

        public final void onActivityResult(int r2, int r3, Intent r4) {
            com.bytedance.android.live.browser.jsbridge.upload.a r0 = (com.bytedance.android.live.browser.jsbridge.upload.a) ((y6.b) this).a;
            if (r0 == null) goto L8;
            com.bytedance.android.livesdk.utils.k2 r1 = r0.b;
            if (r1 == null) goto L9;
            r1.q(r2, r3, r4);
            return;
        L9:
            return;
        }
    }

    public static final class i implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new gb();
        }
    }

    public static final class i0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final i0 a = null;

        static {
            a = new i0();
        }

        public i0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new qb();
        }
    }

    public static final class i1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final i1 a = null;

        static {
            a = new i1();
        }

        public i1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new s6();
        }
    }

    public static final class i2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final i2 a = null;

        static {
            a = new i2();
        }

        public i2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new s5();
        }
    }

    public static final class i3 extends y6.b<com.bytedance.android.live.browser.jsbridge.upload.x> {
        public final /* synthetic */ Fragment b;

        public final com.bytedance.ies.web.jsbridge2.f<?, ?> b() {
            return new com.bytedance.android.live.browser.jsbridge.upload.x(this.b);
        }

        public i3(Fragment r1) {
            this.b = r1;
        }

        public final void onActivityResult(int r2, int r3, Intent r4) {
            com.bytedance.android.live.browser.jsbridge.upload.x r0 = (com.bytedance.android.live.browser.jsbridge.upload.x) ((y6.b) this).a;
            if (r0 == null) goto L8;
            com.bytedance.android.livesdk.utils.k2 r1 = r0.a;
            if (r1 == null) goto L9;
            r1.q(r2, r3, r4);
            return;
        L9:
            return;
        }
    }

    public static final class j implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new dc();
        }
    }

    public static final class j0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final j0 a = null;

        static {
            a = new j0();
        }

        public j0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new zb();
        }
    }

    public static final class j1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final j1 a = null;

        static {
            a = new j1();
        }

        public j1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new x7();
        }
    }

    public static final class j2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final j2 a = null;

        static {
            a = new j2();
        }

        public j2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new q5();
        }
    }

    public static final class j3 extends y6.b<com.bytedance.android.live.browser.jsbridge.upload.y> {
        public final /* synthetic */ Fragment b;

        public final com.bytedance.ies.web.jsbridge2.f<?, ?> b() {
            return new com.bytedance.android.live.browser.jsbridge.upload.y(this.b);
        }

        public j3(Fragment r1) {
            this.b = r1;
        }

        public final void onActivityResult(int r2, int r3, Intent r4) {
            com.bytedance.android.live.browser.jsbridge.upload.y r0 = (com.bytedance.android.live.browser.jsbridge.upload.y) ((y6.b) this).a;
            if (r0 == null) goto L8;
            com.bytedance.android.livesdk.utils.k2 r1 = r0.a;
            if (r1 == null) goto L9;
            r1.q(r2, r3, r4);
            return;
        L9:
            return;
        }
    }

    public static final class k implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ac();
        }
    }

    public static final class k0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final k0 a = null;

        static {
            a = new k0();
        }

        public k0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.y();
        }
    }

    public static final class k1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final k1 a = null;

        static {
            a = new k1();
        }

        public k1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new f6();
        }
    }

    public static final class k2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final k2 a = null;

        static {
            a = new k2();
        }

        public k2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new xb();
        }
    }

    public static final class k3<T> implements ObservableOnSubscribe {
        public static final k3 a = null;

        static {
            a = new k3();
        }

        public k3() {
        }

        public final void subscribe(ObservableEmitter<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }
    }

    public static final class l implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new cd();
        }
    }

    public static final class l0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final l0 a = null;

        static {
            a = new l0();
        }

        public l0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.j2();
        }
    }

    public static final class l1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final l1 a = null;

        static {
            a = new l1();
        }

        public l1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.o1();
        }
    }

    public static final class l2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final l2 a = null;

        static {
            a = new l2();
        }

        public l2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.n3();
        }
    }

    public static final class l3 implements Action {
        public final /* synthetic */ JsBridgeAssistService a;
        public final /* synthetic */ y6.a b;

        public l3(JsBridgeAssistService r1, y6.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            com.bytedance.android.annie.a.c(a9.i.class).x0(this.b);
            JsBridgeAssistService.access$getMAnnieFactoryCollection$p(this.a).remove(this.b);
        }
    }

    public static final class m implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new x9();
        }
    }

    public static final class m0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final m0 a = null;

        static {
            a = new m0();
        }

        public m0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new w8();
        }
    }

    public static final class m1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final m1 a = null;

        static {
            a = new m1();
        }

        public m1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new c6();
        }
    }

    public static final class m2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final m2 a = null;

        static {
            a = new m2();
        }

        public m2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.o3();
        }
    }

    public static final class m3<T> implements ObservableOnSubscribe {
        public static final m3 a = null;

        static {
            a = new m3();
        }

        public m3() {
        }

        public final void subscribe(ObservableEmitter<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }
    }

    public static final class n implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.q0();
        }
    }

    public static final class n0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final n0 a = null;

        static {
            a = new n0();
        }

        public n0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ca();
        }
    }

    public static final class n1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final n1 a = null;

        static {
            a = new n1();
        }

        public n1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new g5();
        }
    }

    public static final class n2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final n2 a = null;

        static {
            a = new n2();
        }

        public n2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.p3();
        }
    }

    public static final class n3<T> implements ObservableOnSubscribe {
        public static final n3 a = null;

        static {
            a = new n3();
        }

        public n3() {
        }

        public final void subscribe(ObservableEmitter<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }
    }

    public static final class o implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new hd();
        }
    }

    public static final class o0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final o0 a = null;

        static {
            a = new o0();
        }

        public o0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ad();
        }
    }

    public static final class o1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final o1 a = null;

        static {
            a = new o1();
        }

        public o1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new o4();
        }
    }

    public static final class o2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final o2 a = null;

        static {
            a = new o2();
        }

        public o2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ShowPaidLiveTicketEditPageMethod();
        }
    }

    public static final class o3 implements Action {
        public final /* synthetic */ JsBridgeAssistService a;
        public final /* synthetic */ y6.a b;
        public final /* synthetic */ BaseJsBridgeMethodFactory c;

        public o3(JsBridgeAssistService r1, y6.a r2, BaseJsBridgeMethodFactory r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void run() {
            com.bytedance.android.annie.a.c(a9.i.class).x0(this.b);
            Iterator r0 = JsBridgeAssistService.access$getManagerCollection$p(this.a).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((JsBridgeManager) r0.next()).unregisterFromFactory(this.c);
            goto L4
        L6:
            JsBridgeAssistService.access$getMFactoryCollection$p(this.a).remove(this.c);
        }
    }

    public static final class p implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ com.bytedance.ies.web.jsbridge2.d0 a;

        public p(com.bytedance.ies.web.jsbridge2.d0 r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new bb(this.a);
        }
    }

    public static final class p0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final p0 a = null;

        static {
            a = new p0();
        }

        public p0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new rb();
        }
    }

    public static final class p1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final p1 a = null;

        static {
            a = new p1();
        }

        public p1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new i5();
        }
    }

    public static final class p2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final p2 a = null;

        static {
            a = new p2();
        }

        public p2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ut2.d();
        }
    }

    public static final class p3<T> implements ObservableOnSubscribe {
        public static final p3 a = null;

        static {
            a = new p3();
        }

        public p3() {
        }

        public final void subscribe(ObservableEmitter<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }
    }

    public static final class q implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final q a = null;

        static {
            a = new q();
        }

        public q() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new g30.b();
        }
    }

    public static final class q0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final q0 a = null;

        static {
            a = new q0();
        }

        public q0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new MeasureTextMethod();
        }
    }

    public static final class q1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final q1 a = null;

        static {
            a = new q1();
        }

        public q1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new GetVisualEventTrackingSettingsMethod();
        }
    }

    public static final class q2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final q2 a = null;

        static {
            a = new q2();
        }

        public q2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.v2();
        }
    }

    public static final class q3<T> implements ObservableOnSubscribe {
        public final /* synthetic */ Ref.ObjectRef a;
        public final /* synthetic */ String b;

        public static final class a implements JsEventSubscriber {
            public final /* synthetic */ ObservableEmitter a;

            public a(ObservableEmitter r1) {
                this.a = r1;
            }

            public final void onReceiveJsEvent(Js2NativeEvent r4) {
                Intrinsics.checkNotNullParameter(r4, "jsEvent");
                ObservableEmitter r0 = this.a;
                String r2 = r4.getEventName();
                XReadableMap r5 = r4.getParams();
                if (r5 == null) goto L5;
                Map r6 = r5.toMap();
            L6:
                r0.onNext(new SubscriberJsEvent(r2, r6));
                return;
            L5:
                r6 = null;
                goto L6
            }
        }

        public q3(Ref.ObjectRef r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(ObservableEmitter<SubscriberJsEvent> r3) {
            Intrinsics.checkNotNullParameter(r3, "emitter");
            Ref.ObjectRef r0 = this.a;
            a r1 = new a(r3);
            r0.element = r1;
            String r4 = this.b;
            a r2 = r1;
            Intrinsics.checkNotNull(r2);
            EventCenter.registerJsEventSubscriber(r4, r2);
        }
    }

    public static final class r implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final r a = null;

        static {
            a = new r();
        }

        public r() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new e5();
        }
    }

    public static final class r0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final r0 a = null;

        static {
            a = new r0();
        }

        public r0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return jc1.k.n(IBarrageService.class).createShowCarnivalTrayContentMethod();
        }
    }

    public static final class r1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final r1 a = null;

        static {
            a = new r1();
        }

        public r1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).getPaidPreviewVisibilityOptionsMethod();
        }
    }

    public static final class r2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final r2 a = null;

        static {
            a = new r2();
        }

        public r2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new v8();
        }
    }

    public static final class r3 implements Action {
        public final /* synthetic */ Ref.ObjectRef a;
        public final /* synthetic */ String b;

        public r3(Ref.ObjectRef r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            JsEventSubscriber r0 = (JsEventSubscriber) this.a.element;
            if (r0 == null) goto L6;
            EventCenter.unregisterJsEventSubscriber(this.b, r0);
            return;
        }
    }

    public static final class s implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final s a = null;

        static {
            a = new s();
        }

        public s() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new i9();
        }
    }

    public static final class s0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final s0 a = null;

        static {
            a = new s0();
        }

        public s0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return jc1.k.n(IBarrageService.class).createShowCarnivalRedPacketEggMethod();
        }
    }

    public static final class s1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final s1 a = null;

        static {
            a = new s1();
        }

        public s1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ae();
        }
    }

    public static final class s2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final s2 a = null;

        static {
            a = new s2();
        }

        public s2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new sb();
        }
    }

    public static final class t implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final t a = null;

        static {
            a = new t();
        }

        public t() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.l3();
        }
    }

    public static final class t0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final t0 a = null;

        static {
            a = new t0();
        }

        public t0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return jc1.k.n(IImageRecognitionService.class).createImageRecognitionMethod();
        }
    }

    public static final class t1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final t1 a = null;

        static {
            a = new t1();
        }

        public t1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new hc();
        }
    }

    public static final class t2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final t2 a = null;

        static {
            a = new t2();
        }

        public t2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new z6();
        }
    }

    public static final class u implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final u a = null;

        static {
            a = new u();
        }

        public u() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.m3();
        }
    }

    public static final class u0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final u0 a = null;

        static {
            a = new u0();
        }

        public u0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return jc1.k.n(IVirtualInteractService.class).getCreateActorMethod();
        }
    }

    public static final class u1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final u1 a = null;

        static {
            a = new u1();
        }

        public u1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new m9();
        }
    }

    public static final class u2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final u2 a = null;

        static {
            a = new u2();
        }

        public u2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new e7();
        }
    }

    public static final class v implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final v a = null;

        static {
            a = new v();
        }

        public v() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new fa();
        }
    }

    public static final class v0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final v0 a = null;

        static {
            a = new v0();
        }

        public v0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return jc1.k.n(IVirtualInteractService.class).getInteractionCommandMethod();
        }
    }

    public static final class v1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final v1 a = null;

        static {
            a = new v1();
        }

        public v1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new w4();
        }
    }

    public static final class v2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final v2 a = null;

        static {
            a = new v2();
        }

        public v2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new d30.b();
        }
    }

    public static final class w implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final w a = null;

        static {
            a = new w();
        }

        public w() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new fc();
        }
    }

    public static final class w0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final w0 a = null;

        static {
            a = new w0();
        }

        public w0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getCanShowMethod();
        }
    }

    public static final class w1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final w1 a = null;

        static {
            a = new w1();
        }

        public w1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new dd();
        }
    }

    public static final class w2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final w2 a = null;

        static {
            a = new w2();
        }

        public w2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new d30.a();
        }
    }

    public static final class x implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final x a = null;

        static {
            a = new x();
        }

        public x() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.x2();
        }
    }

    public static final class x0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final x0 a = null;

        static {
            a = new x0();
        }

        public x0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new c9();
        }
    }

    public static final class x1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final x1 a = null;

        static {
            a = new x1();
        }

        public x1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new d5();
        }
    }

    public static final class x2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final x2 a = null;

        static {
            a = new x2();
        }

        public x2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new d30.c();
        }
    }

    public static final class y implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final y a = null;

        static {
            a = new y();
        }

        public y() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.m0();
        }
    }

    public static final class y0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final y0 a = null;

        static {
            a = new y0();
        }

        public y0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new c9();
        }
    }

    public static final class y1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final y1 a = null;

        static {
            a = new y1();
        }

        public y1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new x8();
        }
    }

    public static final class y2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final y2 a = null;

        static {
            a = new y2();
        }

        public y2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.answer.b();
        }
    }

    public static final class z implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final z a = null;

        static {
            a = new z();
        }

        public z() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.browser.jsbridge.newmethods.r1();
        }
    }

    public static final class z0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final z0 a = null;

        static {
            a = new z0();
        }

        public z0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new g9();
        }
    }

    public static final class z1 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final z1 a = null;

        static {
            a = new z1();
        }

        public z1() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new y8();
        }
    }

    public static final class z2 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final z2 a = null;

        static {
            a = new z2();
        }

        public z2() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new g8();
        }
    }

    private final IJsBridgeModuleService getJsbridgemoduleService() {
        return (IJsBridgeModuleService) this.jsbridgemoduleService$delegate.getValue();
    }

    private final com.bytedance.android.tools.superkv.e getKv() {
        return (com.bytedance.android.tools.superkv.e) this.kv$delegate.getValue();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public List<String> getSafeHostList() {
        return (List) this.safeHostList$delegate.getValue();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public void initPermissionCheck() {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public void registerMatchShareMethods() {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public void registerState() {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public Map<String, Class<? extends XBridgeMethod>> getMethodList() {
        int r4 = com.bytedance.android.live.browser.jsbridge.u.a;
        kjc.c r5 = new kjc.c();
        if (2 != kjc.a.a()) goto L6;
        kjc.b r6 = r5.a;
        r6.a = XBridge.INSTANCE.getMethodList(XBridgePlatformType.LYNX, "DEFAULT");
        r5.b = true;
    L6:
        if (r5.b == true) goto L27;
        kjc.b r7 = r5.a;
        if (((Boolean) s9.a.getValue()).booleanValue() == false) goto L22;
        XBridge r8 = XBridge.INSTANCE;
        XBridgePlatformType r9 = XBridgePlatformType.LYNX;
        Map r11 = r8.getStandardMethodList(r9, "DEFAULT");
        if (r11 != null) goto L12;
        r11 = MapsKt.emptyMap();
    L12:
        Map r12 = r8.getMethodList(r9, "DEFAULT");
        if (r12 == null) goto L20;
        Map r13 = new LinkedHashMap();
        Iterator r14 = r12.entrySet().iterator();
    L16:
        if (r14.hasNext() == false) goto L21;
        Map.Entry r15 = (Map.Entry) r14.next();
        if (StringsKt.startsWith$default((String) r15.getKey(), "ttcjpay.", false, 2, null) == false) goto L16;
        r13.put(r15.getKey(), r15.getValue());
    L21:
        Map r16 = MapsKt.plus(r11, r13);
    L25:
        r7.a = r16;
        goto L27
    L20:
        r13 = MapsKt.emptyMap();
        goto L21
    L22:
        r16 = XBridge.INSTANCE.getStandardMethodList(XBridgePlatformType.LYNX, "DEFAULT");
        if (r16 != null) goto L25;
        r16 = MapsKt.emptyMap();
    L27:
        return (Map) r5.a.a;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public void initTTLiveSdkJsb() {
        AtomicBoolean r4 = com.bytedance.android.live.browser.jsbridge.b.a;
        if (com.bytedance.android.live.browser.jsbridge.b.a.compareAndSet(false, true) == false) goto L7;
        a9.j.a.I0(new com.bytedance.android.live.browser.jsbridge.a());
        return;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public com.bytedance.ies.tools.prefetch.i newPrefetchNetworkExecutor() {
        return new PrefetchNetworkExecutorImpl();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public List<Class<? extends Object>> provideStorageMethods() {
        int r4 = com.bytedance.android.live.browser.jsbridge.k.a;
        return CollectionsKt.mutableListOf(new Class[]{t66.d.class, t66.b.class, t66.c.class, t66.a.class});
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public void registerDataShare() {
        com.bytedance.android.annie.service.data.b.a.c(new com.bytedance.android.live.browser.jsbridge.state.annieObservable.g(0)).subscribe();
        com.bytedance.android.annie.service.data.b.b(new com.bytedance.android.live.browser.jsbridge.state.annieStatic.h());
        com.bytedance.android.annie.service.data.b.b(new com.bytedance.android.live.browser.jsbridge.state.annieStatic.a());
        com.bytedance.android.annie.service.data.b.b(new com.bytedance.android.live.browser.jsbridge.state.annieStatic.e());
        com.bytedance.android.annie.service.data.b.b(new com.bytedance.android.live.browser.jsbridge.state.annieStatic.j());
        if (Intrinsics.areEqual(((q91) m01.a.getValue()).b(), Boolean.TRUE) == false) goto L5;
        com.bytedance.android.annie.service.data.b.b(new com.bytedance.android.live.browser.jsbridge.state.annieStatic.c());
    L5:
        com.bytedance.android.annie.service.data.b.b(new com.bytedance.android.live.browser.jsbridge.state.annieStatic.l());
        com.bytedance.android.annie.service.data.b.b(new com.bytedance.android.live.browser.jsbridge.state.annieStatic.i());
        com.bytedance.android.annie.service.data.b.b(new com.bytedance.android.live.browser.jsbridge.state.annieObservable.e());
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public void registerPayBaseMethod() {
        int r4 = com.bytedance.android.live.browser.jsbridge.k.a;
        int r5 = l66.a.a;
        Class r6 = l66.a.a.a();     // Catch: Exception -> L5
        Object r7 = r6.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L5
        r6.getDeclaredMethod("registerCJPayXbridge", new Class[0]).invoke(r7, new Object[0]);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public JsBridgeAssistService() {
        this.managerCollection = new CopyOnWriteArraySet();
        this.mFactoryCollection = new CopyOnWriteArraySet();
        this.kv$delegate = LazyKt.lazy(JsBridgeAssistService$kv$2.INSTANCE);
        this.jsbridgemoduleService$delegate = LazyKt.lazy(JsBridgeAssistService$jsbridgemoduleService$2.INSTANCE);
        this.mAnnieFactoryCollection = new CopyOnWriteArraySet();
        this.safeHostList$delegate = LazyKt.lazy(JsBridgeAssistService$safeHostList$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public Collection<BaseJsBridgeMethodFactory> getFactoryCollection() {
        return this.mFactoryCollection;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public <T extends LiveRecyclableWidget> Class<T> provideBridgeSupportWidgetClass() {
        return BridgeSupportWidget.class;
    }

    public static final /* synthetic */ com.bytedance.android.tools.superkv.e access$getKv$p(JsBridgeAssistService r4) {
        return r4.getKv();
    }

    public static final /* synthetic */ Collection access$getMAnnieFactoryCollection$p(JsBridgeAssistService r4) {
        return r4.mAnnieFactoryCollection;
    }

    public static final /* synthetic */ Collection access$getMFactoryCollection$p(JsBridgeAssistService r4) {
        return r4.mFactoryCollection;
    }

    public static final /* synthetic */ Collection access$getManagerCollection$p(JsBridgeAssistService r4) {
        return r4.managerCollection;
    }

    private final y6.a getCompatAnnieMethodRegister(BaseJsBridgeMethodFactory r4) {
        return new a(r4);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public w30.a getStorageProcessor(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        return new b(r4);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public com.bytedance.ies.web.jsbridge2.f<?, ?> provideClipMethod(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        return new com.bytedance.android.live.browser.jsbridge.newmethods.a2(r4);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public com.bytedance.ies.web.jsbridge2.f<?, ?> provideDynamicUnRegisterWRDSMethod(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        return new com.bytedance.android.live.browser.jsbridge.newmethods.u2(r4);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterMessageLatchMethod(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        return new ga(r4, null);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideRegisterMessageMethodInFeed(MessageHub r4) {
        HashMap r5 = new HashMap();
        r5.put("registerMessageLatch", new a3(r4));
        r5.put("registerMessage", new b3(r4));
        return r5;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterWRDSMethod(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        return new wa(r4);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public Map<String, y6.b<? extends com.bytedance.ies.web.jsbridge2.f<?, ?>>> provideStateFulFragmentMethods(Fragment r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("uploadPhoto", new c3(r4)), TuplesKt.to("uploadPicture", new d3(r4)), TuplesKt.to("uploadVideo", new e3(r4)), TuplesKt.to("upload", new f3(r4)), TuplesKt.to("live.anchorContractAVRecord", new g3(r4)), TuplesKt.to("cropAndUploadEmoji", new h3(r4)), TuplesKt.to("getPicture", new i3(r4)), TuplesKt.to("getVipPanelCustomBackground", new j3(r4))});
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public Observable<Unit> registerAnnieFactory(y6.a r4) {
        Intrinsics.checkNotNullParameter(r4, "annieFactory");
        if (this.mAnnieFactoryCollection.add(r4) == false) goto L6;
        com.bytedance.android.annie.a.c(a9.i.class).I0(r4);
        return Observable.create(k3.a).doOnDispose(new l3(this, r4));
    L6:
        return Observable.create(m3.a);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public Observable<Unit> registerExternalMethodFactory(BaseJsBridgeMethodFactory r4) {
        Intrinsics.checkNotNullParameter(r4, "factory");
        if (this.mFactoryCollection.add(r4) == false) goto L10;
        y6.a r5 = getCompatAnnieMethodRegister(r4);
        com.bytedance.android.annie.a.c(a9.i.class).I0(r5);
        Iterator<T> r6 = this.managerCollection.iterator();
    L6:
        if (r6.hasNext() == false) goto L12;
        ((JsBridgeManager) r6.next()).registerFromFactory(r4);
        goto L6
    L12:
        return Observable.create(n3.a).doOnDispose(new o3(this, r5, r4));
    L10:
        return Observable.create(p3.a);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public Observable<SubscriberJsEvent> registerJsEventSubscriber(String r4) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = null;
        return Observable.create(new q3(r5, r4)).doOnDispose(new r3(r5, r4));
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public com.bytedance.android.live.browser.jsbridge.i.d getNewCurrentState(String r4, y6.c r5) {
        Intrinsics.checkNotNullParameter(r4, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r5, "jsBridgeManager");
        return new StateObserver();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideDefaultStatefulMethods(com.bytedance.ies.web.jsbridge2.d0 r9, RegisterPolicy r11) {
        Intrinsics.checkNotNullParameter(r11, "registerPolicy");
        LinkedHashMap r4 = new LinkedHashMap();
        RegisterPolicy r5 = RegisterPolicy.DEFAULT;
        if (r11 != r5) goto L5;
    L6:
        r4.putAll(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("requestOrientationPermission", new p(r9)), TuplesKt.to("monitorCommerceLotteryNumMsg", new com.bytedance.android.live.browser.jsbridge.newmethods.i2(r9))}));
    L7:
        if (r11 != r5) goto L9;
    L10:
        r4.putAll(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("openTimeSchedule", a0.a), TuplesKt.to("community.liveAppointmentStatus", l0.a), TuplesKt.to("checkDesktopGuideCanShow", w0.a), TuplesKt.to("ug.requestShowDesktopGuide", h1.a), TuplesKt.to("vibrate", s1.a), TuplesKt.to("showLeaveRoomDialog", d2.a), TuplesKt.to("showPaidLiveTicketEditPage", o2.a), TuplesKt.to("observeShakeMobile", z2.a), TuplesKt.to("openZmCert", f.a), TuplesKt.to("openHostVerify", g.a), TuplesKt.to("liveLoading", h.a), TuplesKt.to("webcastAlertModal", i.a), TuplesKt.to("setFansStatus", j.a), TuplesKt.to("setAppointmentStatus", k.a), TuplesKt.to("startAnimationEvent", l.a), TuplesKt.to("preloadReplay", m.a), TuplesKt.to("authorization", n.a), TuplesKt.to("commercialComponentOperation", o.a), TuplesKt.to("createChatGroup", q.a), TuplesKt.to("getPersonCardInfo", r.a), TuplesKt.to("openTicketPriceInputPanel", s.a), TuplesKt.to("format.openSchema", t.a), TuplesKt.to("format.sendLog", u.a), TuplesKt.to("refreshActivityBannerNumber", v.a), TuplesKt.to("setMemoryByContainer", w.a), TuplesKt.to("openFansGroupSettingDirect", x.a), TuplesKt.to("alert", y.a), TuplesKt.to("changeVsCameraView", z.a), TuplesKt.to("getCurrentCameraId", b0.a), TuplesKt.to("alertCheckDialog", c0.a), TuplesKt.to("liveSaveHighlightVideo", d0.a), TuplesKt.to("openAnchorInputDialog", e0.a), TuplesKt.to("openAnchorShowAddDialog", f0.a), TuplesKt.to("live.operateInteractPlugin", g0.a), TuplesKt.to("adLiveUpdateFeed", h0.a), TuplesKt.to("sendAdLog", i0.a), TuplesKt.to("sendThirdTrack", j0.a), TuplesKt.to("adInfo", k0.a), TuplesKt.to("openOutSitePushAuthPanel", m0.a), TuplesKt.to("getClientSetting", n0.a), TuplesKt.to("showToast", o0.a), TuplesKt.to("sendCommerceEvent", p0.a), TuplesKt.to("measureText", q0.a), TuplesKt.to("showCarnivalTrayContent", r0.a), TuplesKt.to("showCarnivalRedPacketEgg", s0.a), TuplesKt.to("imageRecognition", t0.a), TuplesKt.to("createActor", u0.a), TuplesKt.to("interactionCommand", v0.a), TuplesKt.to("getStarInfo", x0.a), TuplesKt.to("getStarInfo", y0.a), TuplesKt.to("openExplainCardSettingDialog", z0.a), TuplesKt.to("notifyClearMountData", a1.a), TuplesKt.to("showAnchorColumnPosterDialog", b1.a), TuplesKt.to("openLiveEffectPanel", c1.a), TuplesKt.to("updateLivePanelEffect", d1.a), TuplesKt.to("checkEffectInUsed", e1.a), TuplesKt.to("closeAnchorStatusCenterPanel", f1.a), TuplesKt.to("checkAnchorEffectInUsed", g1.a), TuplesKt.to("live.openLiveEffectSelectPanel", i1.a), TuplesKt.to("live.updateNotifyGiftMessageChannel", j1.a), TuplesKt.to("live.getLiveEffectInfo", k1.a), TuplesKt.to("canLoadFromLoki", l1.a), TuplesKt.to("live.getInteractToolInfo", m1.a), TuplesKt.to("getRevenueLotteryLogParams", n1.a), TuplesKt.to("getDynamicSettings", o1.a), TuplesKt.to("getVisualEventTrackingEditor", p1.a), TuplesKt.to("getVisualEventTrackingSettings", q1.a), TuplesKt.to("paidPreviewVisibilityOptions", r1.a), TuplesKt.to("setMessageBoardData", t1.a), TuplesKt.to("openVSMessageBoardInputPanel", u1.a), TuplesKt.to("getMessageBoardData", v1.a), TuplesKt.to("streamBottomOffset", w1.a), TuplesKt.to("getMuteStatus", x1.a), TuplesKt.to("openPaidRightsFullView", y1.a), TuplesKt.to("openPanelInRoom", z1.a), TuplesKt.to("getLiveFoldState", a2.a), TuplesKt.to("getCurrentDegradeInfo", b2.a), TuplesKt.to("createVipEmojiByTemplate", c2.a), TuplesKt.to("requestPinWidget", e2.a), TuplesKt.to("checkWidgetInstallation", f2.a), TuplesKt.to("closeShelfManagementPage", g2.a), TuplesKt.to("adTrackInfoFromCid", h2.a), TuplesKt.to("isHomeSideBarSupport", i2.a), TuplesKt.to("isBizEntryInHomeSideBar", j2.a), TuplesKt.to("sendSubscribeEmoji", k2.a), TuplesKt.to("gcpLoadPerfAddExtraParams", l2.a), TuplesKt.to("gcpLoadPerfFinishLoadWithError", m2.a), TuplesKt.to("gcpLoadPerfLoad", n2.a), TuplesKt.to("urgeGiftSend", p2.a), TuplesKt.to("exposeAccurateExperiment", q2.a), TuplesKt.to("openLiveMicroApp", r2.a), TuplesKt.to("sendLiveMicroAppLog", s2.a), TuplesKt.to("live.startDiscoveryService", t2.a), TuplesKt.to("live.stopDiscoveryService", u2.a), TuplesKt.to("community.openAnchorInteractPluginLynxContainer", v2.a), TuplesKt.to("community.closeAnchorInteractPluginLynxContainer", w2.a), TuplesKt.to("community.updateAnchorInteractPluginLynxContainer", x2.a), TuplesKt.to("live.createQuestionContainer", y2.a), TuplesKt.to("live.destroyQuestionContainer", c.a), TuplesKt.to("live.getStreamTimeStamp", d.a), TuplesKt.to("__getCurrentState", e.a)}));
    L11:
        if (r9 == null) goto L13;
        zd r6 = new zd(r9, null);
        r4.put("connectLongLink", new ud(r6));
        r4.put("disconnectLongLink", new wd(r6));
        r4.put("registerLongLinkMessageType", new yd(r6));
    L13:
        ISaaSBrowserService r7 = (ISaaSBrowserService) jc1.k.f(ISaaSBrowserService.class);
        if (r7 == null) goto L18;
        Map<String, com.bytedance.ies.web.jsbridge2.f.b> r12 = r7.provideDefaultStatefulMethods(r9, r11);
        if (r12 == null) goto L18;
        r4.putAll(r12);
    L18:
        return r4;
    L9:
        if (r11 != RegisterPolicy.CACHEABLE) goto L11;
    L5:
        if (r11 != RegisterPolicy.SPECIFIED) goto L7;
        goto L6
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> provideDefaultStatelessMethods(com.bytedance.ies.web.jsbridge2.d0 r4, RegisterPolicy r5) {
        Intrinsics.checkNotNullParameter(r5, "registerPolicy");
        LinkedHashMap r6 = new LinkedHashMap();
        if (r5 != RegisterPolicy.DEFAULT) goto L5;
    L6:
        r6.putAll(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("getXTtToken", new v3()), TuplesKt.to("sendLogV3", new tb()), TuplesKt.to("open_webview_action", new o9()), TuplesKt.to("setBannerVisibility", new com.bytedance.android.live.browser.jsbridge.newmethods.s0()), TuplesKt.to("sendPokemon", new g6()), TuplesKt.to("statusNotification", new d8()), TuplesKt.to("resetHostVerify", new fb()), TuplesKt.to("saveLocalData", new mb()), TuplesKt.to("openCashVerify", new o8()), TuplesKt.to("addRedDot", new com.bytedance.android.live.browser.jsbridge.newmethods.b0()), TuplesKt.to("openPanel", new z8()), TuplesKt.to("fansClubMsgGuide", new tc()), TuplesKt.to("openFaceStickerPanel", new ShowStikerMethod()), TuplesKt.to("webcastBroadcast", new com.bytedance.android.live.browser.jsbridge.newmethods.v0()), TuplesKt.to("GetMaixuRoomStatus", new v4()), TuplesKt.to("getMaixuRoomStatus", new v4()), TuplesKt.to("isInstalledApp", new com.bytedance.android.live.browser.jsbridge.newmethods.v1()), TuplesKt.to("liveDownloadMedia", new com.bytedance.android.live.browser.jsbridge.newmethods.r2()), TuplesKt.to("bindSourceParams", new com.bytedance.android.live.browser.jsbridge.newmethods.t0()), TuplesKt.to("reportStarEvent", new o6()), TuplesKt.to("shareScreen", jc1.k.n(ILiveShareService.class).getShareScreenMethod()), TuplesKt.to("dismissFinishPage", new com.bytedance.android.live.browser.jsbridge.newmethods.n2()), TuplesKt.to("reportAppLog", new tb())}));
    L7:
        return r6;
    L5:
        if (r5 != RegisterPolicy.CACHEABLE) goto L7;
        goto L6
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public void registerSpecialMethod(JSBridgeManager r4, IHybridComponent r5) {
        Intrinsics.checkNotNullParameter(r4, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r5, "hybridComponent");
        int r6 = m30.d.a;
        Intrinsics.checkNotNullParameter(r4, "jsBridgeManger");
        Intrinsics.checkNotNullParameter(r5, "hybridComponent");
        zd r7 = new zd(null, r5);
        r4.registerMethod("connectLongLink", new ud(r7));
        r4.registerMethod("disconnectLongLink", new wd(r7));
        r4.registerMethod("registerLongLinkMessageType", new yd(r7));
        r4.registerMethod("monitorCommerceLotteryNumMsg", new com.bytedance.android.live.browser.jsbridge.newmethods.i2(r5));
        r4.registerMethod("app.showModal", m30.b.a);
        if (((Boolean) w30.a.getValue()).booleanValue() == false) goto L5;
        r4.registerMethod("setStorage", m30.c.a);
        return;
    L5:
        r4.registerMethod("setStorage", new v5.c());
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public void registerXBridgeMethods(y6.c r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r8, "xBridgeRegisterStrategy");
        if (Intrinsics.areEqual(r8, "all") == false) goto L5;
        jc1.k.n(IHostWebView.class).initXBridge();
    L5:
        int r4 = com.bytedance.android.live.browser.jsbridge.i0.a;
        Intrinsics.checkNotNullParameter(r7, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r8, "xBridgeRegisterStrategy");
        g66.c r9 = new g66.c();
        r9.f(Context.class, r7.getActivity());
        r9.d(p56.c.class, new com.bytedance.android.live.browser.jsbridge.b0());
        r9.d(XBridgeMethod.b.class, new com.bytedance.android.live.browser.jsbridge.y(r7));
        r9.d(p56.b.class, new com.bytedance.android.live.browser.jsbridge.z(r7));
        IJsBridgeAssistService r5 = (IJsBridgeAssistService) jc1.k.n(IJsBridgeAssistService.class);
        ArrayList<Class<? extends Object>> r6 = com.bytedance.android.live.browser.b0.a;
        com.bytedance.android.live.browser.b0.a(com.bytedance.ies.xbridge.event.bridge.c.class);
        com.bytedance.android.live.browser.b0.a(com.bytedance.ies.xbridge.event.bridge.e.class);
        com.bytedance.android.live.browser.b0.a(com.bytedance.ies.xbridge.event.bridge.f.class);
        r5.registerPayBaseMethod();
        com.bytedance.android.live.browser.jsbridge.i0.b();
        Iterator<T> r11 = r5.provideStorageMethods().iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        com.bytedance.android.live.browser.b0.a((Class) r11.next());
        goto L7
    L9:
        ArrayList<Class<? extends Object>> r12 = com.bytedance.android.live.browser.b0.a;
        List r13 = com.bytedance.android.annie.xbridge.mix.s.a;
        Iterator r14 = ((LinkedHashMap) com.bytedance.android.annie.xbridge.mix.s.a()).entrySet().iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        Map.Entry r15 = (Map.Entry) r14.next();
        r7.registerMethod((String) r15.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r15.getValue());
        goto L11
    L13:
        XBridgeRegister r16 = new XBridgeRegister();
        Iterator<Class<? extends Object>> r17 = r12.iterator();
    L15:
        if (r17.hasNext() == false) goto L23;
        Class<? extends Object> r18 = r17.next();
        if (r18 == null) goto L20;
        XBridgeMethod r19 = (XBridgeMethod) r18.newInstance();     // Catch: Exception -> L21
        r16.a(r19.getName(), new com.bytedance.android.live.browser.jsbridge.a0(r19, r12, r9));     // Catch: Exception -> L21
    L21:
        e = move-exception;
        ALogger.e("XbridgeManager", e);
        goto L15
    L20:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<out com.bytedance.ies.xbridge.XBridgeMethod>");     // Catch: Exception -> L21
    L23:
        Iterator r21 = MapsKt.toMap(((XBridgeRegister.a) r16.a.getValue()).a).entrySet().iterator();
    L25:
        if (r21.hasNext() == false) goto L27;
        Map.Entry r22 = (Map.Entry) r21.next();
        String r23 = (String) r22.getKey();
        r7.registerMethod(r23, new com.bytedance.android.live.browser.jsbridge.x(r23, r22, r7));
        goto L25
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public <T> void sendEventToAllJsBridges(String r4, T r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Iterator<T> r6 = this.managerCollection.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ((JsBridgeManager) r6.next()).getJsBridge2().f(r4, r5);
        goto L4
    L6:
        com.bytedance.android.annie.a.c(a9.i.class).sendEventToAllJsBridges(r4, r5);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public IJsBridgeManager createJsBridgeManager(Activity r7, com.bytedance.ies.web.jsbridge2.b r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r8, "bridgeImpl");
        IMiddlewareJsBridgeManager r4 = getJsbridgemoduleService().createJsbridgeManager();
        Function1<JsBridgeManager, Unit> r5 = new AnonymousClass5(this);
        Intrinsics.checkNotNullParameter(r4, "middlewareJsBridgeManager");
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r8, "bridgeImpl");
        Intrinsics.checkNotNullParameter(r5, "onRelease");
        JsBridgeManager r6 = new JsBridgeManager(r4, r7, r9, r5);
        r6.c(r7, r8);
        this.managerCollection.add(r6);
        return r6;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public IJsBridgeManager createJsBridgeManager(ILiveHybridContainer r8, com.bytedance.ies.web.jsbridge2.b r9, int r11) {
        Intrinsics.checkNotNullParameter(r8, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r9, "bridgeImpl");
        JsBridgeManager r4 = new JsBridgeManager(getJsbridgemoduleService().createJsbridgeManager(), r8, r9, r11, new AnonymousClass7(this));
        this.managerCollection.add(r4);
        return r4;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public IJsBridgeManager createJsBridgeManager(Activity r9, WebView r11, WebViewClient r12, WebChromeClient r13, int r14) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        Intrinsics.checkNotNullParameter(r11, "webView");
        Intrinsics.checkNotNullParameter(r12, "webViewClient");
        Intrinsics.checkNotNullParameter(r13, "webChromeClient");
        IMiddlewareJsBridgeManager r5 = getJsbridgemoduleService().createJsbridgeManager();
        Function1<JsBridgeManager, Unit> r6 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r5, "middlewareJsBridgeManager");
        Intrinsics.checkNotNullParameter(r9, "activity");
        Intrinsics.checkNotNullParameter(r11, "webView");
        Intrinsics.checkNotNullParameter(r12, "webViewClient");
        Intrinsics.checkNotNullParameter(r13, "webChromeClient");
        Intrinsics.checkNotNullParameter(r6, "onRelease");
        JsBridgeManager r4 = new JsBridgeManager(r5, r9, r14, r6);
        r4.b(r9, r11, r12, r13);
        this.managerCollection.add(r4);
        return r4;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService
    public IJsBridgeManager createJsBridgeManager(ILiveHybridContainer r11, WebView r12, WebViewClient r13, WebChromeClient r14, int r15) {
        Intrinsics.checkNotNullParameter(r11, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r12, "webView");
        Intrinsics.checkNotNullParameter(r13, "webViewClient");
        Intrinsics.checkNotNullParameter(r14, "webChromeClient");
        JsBridgeManager r4 = new JsBridgeManager(getJsbridgemoduleService().createJsbridgeManager(), r11, r12, r13, r14, r15, new AnonymousClass3(this));
        this.managerCollection.add(r4);
        return r4;
    }
}
