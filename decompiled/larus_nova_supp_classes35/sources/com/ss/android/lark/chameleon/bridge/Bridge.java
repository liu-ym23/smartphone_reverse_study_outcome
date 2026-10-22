package com.ss.android.lark.chameleon.bridge;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.basewebview.LarkWebView;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.JsonUtils;
import com.ss.android.lark.chameleon.util.UIExecutor;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00014\u0018\u0000 G2\u00020\u0001:\u0001GB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001dJ\u0010\u0010#\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020\u0017J\u001c\u0010%\u001a\u0004\u0018\u00010\u00182\b\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\u0017H\u0002J*\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010+2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010-J\u0006\u0010.\u001a\u00020!J\u0006\u0010/\u001a\u00020!J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u000202H\u0002J'\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00172\b\u00106\u001a\u0004\u0018\u00010\u00172\u0006\u00107\u001a\u00020\u0017H\u0002¢\u0006\u0002\u00108J\u0010\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020\u0017H\u0017J\u0018\u0010;\u001a\u00020<2\u0006\u00101\u001a\u0002022\u0006\u0010=\u001a\u00020>H\u0002J\u0016\u0010?\u001a\u00020!2\u0006\u00105\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u0018J \u0010A\u001a\u00020!2\u0006\u00105\u001a\u00020\u00172\u0010\u0010B\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030CJ\u000e\u0010D\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001dJ\u0010\u0010E\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020\u0017J\u000e\u0010F\u001a\u00020!2\u0006\u00105\u001a\u00020\u0017R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/Bridge;", BuildConfig.FLAVOR, "webView", "Lcom/ss/android/lark/chameleon/basewebview/LarkWebView;", "(Lcom/ss/android/lark/chameleon/basewebview/LarkWebView;)V", "value", "Lcom/ss/android/lark/chameleon/bridge/BridgeExetension;", "bridgeExtension", "getBridgeExtension", "()Lcom/ss/android/lark/chameleon/bridge/BridgeExetension;", "setBridgeExtension", "(Lcom/ss/android/lark/chameleon/bridge/BridgeExetension;)V", "bridgeInfoPrinter", "Lcom/ss/android/lark/chameleon/bridge/BridgeInfoPrinter;", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "handlerNameToExtraMap", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lorg/json/JSONObject;", "handlerRepository", "Lcom/ss/android/lark/chameleon/bridge/HandlerRepository;", "jsMsgInterceptors", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/ss/android/lark/chameleon/bridge/JsMsgInterceptor;", "scheduler", "Lio/reactivex/Scheduler;", "addJSMsgInterceptor", BuildConfig.FLAVOR, "interceptor", "addJavascriptInterface", "bridgeName", "buildExtraObject", "extensionExtra", "defaultExtraStr", "callJSFun", "apiName", "param", "Ljava/io/Serializable;", "callback", "Landroid/webkit/ValueCallback;", "clearAllHandler", "destroy", "dispatchMsgFromJS", "msg", "Lcom/ss/android/lark/chameleon/bridge/Message;", "getCallback", "com/ss/android/lark/chameleon/bridge/Bridge$getCallback$1", "handlerName", "callbackId", "extraStr", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ss/android/lark/chameleon/bridge/Bridge$getCallback$1;", "invokeNative", "jsMessage", "onInterceptJSMsg", BuildConfig.FLAVOR, "callBack", "Lcom/ss/android/lark/chameleon/bridge/JsCallBack;", "registerExtra", "extra", "registerHandler", "handler", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandler;", "removeJSMsgInterceptor", "removeJavascriptInterface", "unRegisterHandler", "Companion", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Bridge {
    public static final String API_HAS_NO_AUTH = "api has no auth";
    public static final String BRIDGE_NAME = "Lark_Bridge";
    public static final String CALLBACK_FUN = "LarkWebViewJavaScriptBridge.nativeCallBack(%s);";
    public static final Companion Companion = null;
    public static final String ERRMSG = "errMsg";
    public static final String FIND_NO_HANDLER = "find no handler";
    public static final String TAG = "JSBridge";
    public static final int TRANSFER_MAX_SIZE = 2097152;
    private volatile BridgeExetension bridgeExtension;
    private final BridgeInfoPrinter bridgeInfoPrinter;
    private final Lazy gson$delegate;
    private final Map<String, JSONObject> handlerNameToExtraMap;
    private final HandlerRepository handlerRepository;
    private final CopyOnWriteArrayList<JsMsgInterceptor> jsMsgInterceptors;
    private final Scheduler scheduler;
    private final LarkWebView webView;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/Bridge$Companion;", BuildConfig.FLAVOR, "()V", "API_HAS_NO_AUTH", BuildConfig.FLAVOR, "BRIDGE_NAME", "CALLBACK_FUN", "ERRMSG", "FIND_NO_HANDLER", "TAG", "TRANSFER_MAX_SIZE", BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.bridge.Bridge$getCallback$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"com/ss/android/lark/chameleon/bridge/Bridge$getCallback$1", "Lcom/ss/android/lark/chameleon/bridge/JsCallBack;", "handleTimeStart", BuildConfig.FLAVOR, "getHandleTimeStart", "()J", "setHandleTimeStart", "(J)V", "onCallBack", BuildConfig.FLAVOR, "status", "Lcom/ss/android/lark/chameleon/bridge/Status;", "param", BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 implements JsCallBack {
        final /* synthetic */ String $callbackId;
        final /* synthetic */ String $extraStr;
        final /* synthetic */ String $handlerName;
        private long handleTimeStart;
        final /* synthetic */ Bridge this$0;

        public final long getHandleTimeStart() {
            return this.handleTimeStart;
        }

        public final void setHandleTimeStart(long r1) {
            this.handleTimeStart = r1;
        }

        @Override // com.ss.android.lark.chameleon.bridge.JsCallBack
        public void onCallBack(Status r8, Object r9) {
            Intrinsics.checkNotNullParameter(r8, "status");
            String r0 = this.$callbackId;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L11;
            return;
        L11:
            if (this.this$0.getBridgeExtension().shouldMonitorHandlerConsumTime() == false) goto L13;
            System.currentTimeMillis();
        L13:
            ResponseJsData r2 = this.this$0.getBridgeExtension().getResponseJSData(r8, this.$callbackId, r9, this.$extraStr);
            HashMap<String, Object> r3 = new HashMap();
            if (r2 == null) goto L17;
            String r4 = r2.getCallbackId();
            if (r4 == null) goto L17;
        L18:
            r3.put("callbackID", r4);
            if (r2 == null) goto L24;
            Object r5 = r2.getData();
            if (r5 == null) goto L24;
            r9 = r5;
        L24:
            r3.put(Keys.API_RETURN_KEY_DATA, r9);
            if (r2 == null) goto L30;
            Status r6 = r2.getStatus();
            if (r6 == null) goto L30;
            String r7 = r6.getStatus();
            if (r7 == null) goto L30;
        L31:
            r3.put("callbackType", r7);
            Bridge r10 = this.this$0;
            if (r2 == null) goto L34;
            Object r11 = r2.getExtraStr();
        L35:
            JSONObject r12 = Bridge.access$buildExtraObject(r10, r11, this.$extraStr);
            if ((r9 instanceof JSONObject) == false) goto L42;
            JSONObject r13 = (JSONObject) Bridge.access$getHandlerNameToExtraMap$p(this.this$0).get(this.$handlerName);
            if (r13 == null) goto L41;
            r12 = r13;
        L41:
            r3.put("extra", r12);
            StringCompanionObject r14 = StringCompanionObject.INSTANCE;
            String r15 = String.format(Bridge.CALLBACK_FUN, Arrays.copyOf(new Object[]{new JSONObject(r3).toString()}, 1));
        L48:
            Log.d("JSBridge", "evaluateJavascript for jsapi callback, script = " + r15);
            Bridge.access$getWebView$p(this.this$0).evaluateJavascript(r15, null);
            return;
        L42:
            Object r16 = (JSONObject) Bridge.access$getHandlerNameToExtraMap$p(this.this$0).get(this.$handlerName);
            if (r16 != null) goto L47;
            if (r12 == null) goto L46;
            r16 = r12.toString();
            goto L47
        L46:
            r16 = null;
        L47:
            r3.put("extra", r16);
            String r17 = GsonProtectorUtils.toJson(Bridge.access$getGson(this.this$0), r3);
            Bridge.access$getBridgeInfoPrinter$p(this.this$0).printInfo(r3, r17);
            StringCompanionObject r18 = StringCompanionObject.INSTANCE;
            r15 = String.format(Bridge.CALLBACK_FUN, Arrays.copyOf(new Object[]{r17}, 1));
            goto L48
        L34:
            r11 = null;
        L30:
            r7 = r8.getStatus();
        L17:
            r4 = this.$callbackId;
            goto L18
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        public AnonymousClass1(String r1, Bridge r2, String r3, String r4) {
            this.$callbackId = r1;
            this.this$0 = r2;
            this.$extraStr = r3;
            this.$handlerName = r4;
            this.handleTimeStart = System.currentTimeMillis();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(BridgeHandler r0, Object r1, AnonymousClass1 r2, Message r3, Bridge r4) {
        dispatchMsgFromJS$lambda$3(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit b(Function1 r0, Object r1) {
        return invokeNative$lambda$0(r0, r1);
    }

    public static /* synthetic */ void c(Function1 r0, Object r1) {
        invokeNative$lambda$2(r0, r1);
    }

    public static /* synthetic */ void d(Function1 r0, Object r1) {
        invokeNative$lambda$1(r0, r1);
    }

    private final Gson getGson() {
        return (Gson) this.gson$delegate.getValue();
    }

    public final void clearAllHandler() {
        this.handlerRepository.handlers.clear();
    }

    public final void destroy() {
        Log.i("JSBridge", "destroy");
        clearAllHandler();
        this.scheduler.shutdown();
    }

    public final BridgeExetension getBridgeExtension() {
        return this.bridgeExtension;
    }

    public Bridge(LarkWebView r2) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        this.webView = r2;
        this.handlerRepository = new HandlerRepository();
        this.scheduler = Schedulers.from(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("bridge/Bridge")));
        this.jsMsgInterceptors = new CopyOnWriteArrayList();
        this.handlerNameToExtraMap = new ConcurrentHashMap();
        this.gson$delegate = LazyKt.lazy(Bridge$gson$2.INSTANCE);
        this.bridgeExtension = new BridgeExetension();
        addJavascriptInterface$default(this, null, 1, null);
        this.bridgeInfoPrinter = new BridgeInfoPrinter();
    }

    public static final /* synthetic */ BridgeInfoPrinter access$getBridgeInfoPrinter$p(Bridge r0) {
        return r0.bridgeInfoPrinter;
    }

    public static final /* synthetic */ Gson access$getGson(Bridge r0) {
        return r0.getGson();
    }

    public static final /* synthetic */ Map access$getHandlerNameToExtraMap$p(Bridge r0) {
        return r0.handlerNameToExtraMap;
    }

    public static final /* synthetic */ LarkWebView access$getWebView$p(Bridge r0) {
        return r0.webView;
    }

    private final void dispatchMsgFromJS(final Message r12) {
        String r0 = r12.getApiName();
        Log.d("JSBridge", "dispatchMsgFromJS, handlerName: " + r0);
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        return;
    L11:
        final BridgeHandler r6 = this.handlerRepository.handlers.get(r0);
        String r5 = r12.getCallbackID();
        String r7 = r12.getExtra();
        if (r7 != null) goto L14;
        r7 = BuildConfig.FLAVOR;
    L14:
        final AnonymousClass1 r8 = getCallback(r0, r5, r7);
        if (onInterceptJSMsg(r12, r8) == false) goto L18;
        Log.d("JSBridge", "msg " + r0 + " onInterceptJSMsg");
        return;
    L18:
        if (r6 != null) goto L21;
        r8.onCallBack(Status.FAILURE, MapsKt.mapOf(new Pair(ERRMSG, FIND_NO_HANDLER)));
        Log.e("JSBridge", "handler not found: " + r0 + "  web info :, scene: " + this.webView.getBizScene$chameleon_base_release());
        return;
    L21:
        Class<?> r9 = Utils.INSTANCE.getGenericClass(r6);
        if (r9 != null) goto L24;
    L43:
        final Object r10 = null;
    L44:
        Log.i("JSBridge", "handlerName: " + r0 + ", result: " + r10);
        if (r6.shouldRunInUIThread() == false) goto L47;
        Log.d("JSBridge", r0 + " handled on UIThread");
        UIExecutor.executor().post(new a(r6, r10, r8, r12, this));
        return;
    L47:
        Log.d("JSBridge", r0 + " not handled on UIThread");
        r6.handle(r10, r8, r12.getExtra(), this.webView);
        return;
    L24:
        if (r12.getData() == null) goto L43;
        if (Intrinsics.areEqual(r12.getData(), BuildConfig.FLAVOR) == true) goto L43;
        if (Intrinsics.areEqual(r9, String.class) == false) goto L33;
        Object r2 = r12.getData();
    L31:
        r10 = r2;
        goto L44
    L33:
        if (r12.getData() == null) goto L35;
        String r11 = r12.getData();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.String");
    L36:
        if (r11 != null) goto L38;
    L39:
        r1 = true;
    L40:
        if (r1 == true) goto L43;
        r2 = GsonProtectorUtils.fromJson(getGson(), r11, r9);
        goto L31
    L38:
        if (StringsKt.isBlank(r11) == false) goto L40;
    L35:
        r11 = JsonUtils.INSTANCE.toJsonString(r12.getData());
        goto L36
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r4 = false;
        goto L9
    }

    public final void addJSMsgInterceptor(JsMsgInterceptor r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        if (this.jsMsgInterceptors.contains(r2) == true) goto L6;
        this.jsMsgInterceptors.add(r2);
        return;
    }

    public final void addJavascriptInterface(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bridgeName");
        this.webView.addJavascriptInterface(this, r2);
    }

    @JavascriptInterface
    public void invokeNative(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "jsMessage");
        Flowable r0 = Flowable.just(r4).subscribeOn(this.scheduler);
        final Function1<String, Unit> r1 = new C03261(r4, this);
        Flowable r5 = r0.map(new b(r1));
        final AnonymousClass2 r2 = AnonymousClass2.INSTANCE;
        Consumer r3 = new c(r2);
        final Function1<Throwable, Unit> r6 = new AnonymousClass3(this);
        r5.subscribe(r3, new d(r6));
    }

    public final void removeJSMsgInterceptor(JsMsgInterceptor r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        this.jsMsgInterceptors.remove(r2);
    }

    public final void removeJavascriptInterface(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bridgeName");
        this.webView.removeJavascriptInterface(r2);
    }

    public final void setBridgeExtension(BridgeExetension r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.bridgeExtension = r2;
    }

    public final void unRegisterHandler(String r3) {
        Intrinsics.checkNotNullParameter(r3, "handlerName");
        Log.i("JSBridge", "unRegisterHandler handlerName = " + r3);
        this.handlerRepository.handlers.remove(r3);
    }

    public static final /* synthetic */ void access$dispatchMsgFromJS(Bridge r0, Message r1) {
        r0.dispatchMsgFromJS(r1);
    }

    private final JSONObject buildExtraObject(Object r3, String r4) {
    L21:
        e = move-exception;
        Log.e("JSBridge", e.toString());
        return new JSONObject();
    L4:
        if ((r3 instanceof JSONObject) == false) goto L8;
        Log.d("JSBridge", "extensionExtra is JSONObject");     // Catch: JSONException -> L21
        return (JSONObject) r3;
    L8:
        if ((r3 instanceof JsonObject) == false) goto L12;
        Log.d("JSBridge", "extensionExtra is gson.JSONObject");     // Catch: JSONException -> L21
        return new JSONObject(((JsonObject) r3).toString());
    L12:
        if ((r3 instanceof String) == false) goto L20;
        if (TextUtils.isEmpty((CharSequence) r3) == false) goto L18;
        Log.d("JSBridge", "extensionExtra is empty , will return defaultExtraStr");     // Catch: JSONException -> L21
        return new JSONObject(r4);
    L18:
        return new JSONObject((String) r3);
    L20:
        return new JSONObject();
    }

    private static final Unit invokeNative$lambda$0(Function1 r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        return (Unit) r1.invoke(r2);
    }

    private static final void invokeNative$lambda$1(Function1 r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        r1.invoke(r2);
    }

    private static final void invokeNative$lambda$2(Function1 r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        r1.invoke(r2);
    }

    private final boolean onInterceptJSMsg(Message r4, JsCallBack r5) {
        Iterator<T> r0 = this.jsMsgInterceptors.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((JsMsgInterceptor) r1).onInterceptJSMsg(r4, r5) == false) goto L4;
    L9:
        if (r1 == null) goto L11;
        return true;
    L11:
        return false;
    L8:
        r1 = null;
        goto L9
    }

    public final void registerExtra(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "handlerName");
        Intrinsics.checkNotNullParameter(r3, "extra");
        this.handlerNameToExtraMap.put(r2, r3);
    }

    public final void registerHandler(String r3, BridgeHandler<?, LarkWebView> r4) {
        Intrinsics.checkNotNullParameter(r3, "handlerName");
        Intrinsics.checkNotNullParameter(r4, "handler");
        if (StringsKt.isBlank(r3) == true) goto L7;
        Log.i("JSBridge", "registerHandler handlerName = " + r3);
        this.handlerRepository.handlers.put(r3, r4);
        return;
    L7:
        throw new IllegalArgumentException("handlerName should not blank");
    }

    public static final /* synthetic */ JSONObject access$buildExtraObject(Bridge r0, Object r1, String r2) {
        return r0.buildExtraObject(r1, r2);
    }

    private final AnonymousClass1 getCallback(String r2, String r3, String r4) {
        return new AnonymousClass1(r3, this, r4, r2);
    }

    public final void callJSFun(String r2, Serializable r3, ValueCallback<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "apiName");
        String r5 = Utils.INSTANCE.combineRequestContent(r2, r3);
        this.webView.evaluateJavascript(r5, r4);
    }

    public static final /* synthetic */ AnonymousClass1 access$getCallback(Bridge r0, String r1, String r2, String r3) {
        return r0.getCallback(r1, r2, r3);
    }

    public static /* synthetic */ void addJavascriptInterface$default(Bridge r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = BRIDGE_NAME;
    L5:
        r0.addJavascriptInterface(r1);
    }

    public static /* synthetic */ void removeJavascriptInterface$default(Bridge r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = BRIDGE_NAME;
    L5:
        r0.removeJavascriptInterface(r1);
    }

    private static final void dispatchMsgFromJS$lambda$3(BridgeHandler r1, Object r2, AnonymousClass1 r3, Message r4, Bridge r5) {
        Intrinsics.checkNotNullParameter(r3, "$callback");
        Intrinsics.checkNotNullParameter(r4, "$msg");
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r1.handle(r2, r3, r4.getExtra(), r5.webView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void callJSFun$default(Bridge r0, String r1, Serializable r2, ValueCallback r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.callJSFun(r1, r2, r3);
    }
}
