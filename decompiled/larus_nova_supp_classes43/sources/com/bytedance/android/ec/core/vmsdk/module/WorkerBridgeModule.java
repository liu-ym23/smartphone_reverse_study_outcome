package com.bytedance.android.ec.core.vmsdk.module;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.apt.ActionType;
import com.bytedance.android.ec.core.event.EventActionImpl;
import com.bytedance.android.ec.core.monitor.attribution.UserActionCacheMap;
import com.bytedance.android.ec.core.utils.Json;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.DLog;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u0000 .2\u00020\u0001:\u0001/B\u0017\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010\r\u001a\u00020+¢\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0005\u001a\u00020\u0002*\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J \u0010\u0010\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\b\u0010\u0012\u001a\u00020\u0011H\u0007J>\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0007J\b\u0010\u0018\u001a\u00020\u0011H\u0007J \u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0007J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0007J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J\u001a\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J\b\u0010\"\u001a\u00020\tH\u0007J\u0010\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0004H\u0007J\b\u0010%\u001a\u00020\u0011H\u0007J\u0018\u0010(\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020'H\u0016¨\u00060"}, d2 = {"Lcom/bytedance/android/ec/core/vmsdk/module/WorkerBridgeModule;", "Lcom/bytedance/android/ec/core/vmsdk/module/BaseWorkerBridgeModule;", "", "is32Bit", "", "isHttpUrl", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "logLevel", "", "log", "functionName", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "params", "Lcom/bytedance/vmsdk/jsbridge/utils/Callback;", "callback", "call", "Lcom/bytedance/vmsdk/jsbridge/utils/WritableMap;", "getAppInfo", com.bytedance.android.ec.core.event.a.KEY_URL, "method", "data", "header", "fetch", "getUserInfo", "level", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG, "reportALog", "key", "getStorage", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "setStorage", "eventName", "sendLogV3", "terminate", com.bytedance.android.ec.core.event.a.KEY_SCHEMA, "openSchema", "getECActionData", "Lorg/json/JSONObject;", "Lcom/bytedance/ies/web/jsbridge2/c0;", "invokeCallback", "Landroid/content/Context;", "context", "", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "Companion", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WorkerBridgeModule extends BaseWorkerBridgeModule {
    public static final a Companion = null;
    private static final int LOG_DEBUG = 0;
    private static final int LOG_ERROR = 3;
    private static final int LOG_INFO = 1;
    private static final int LOG_WARN = 2;
    public static final String NAME = "bridge";

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements ObservableOnSubscribe {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ Map e;

        public b(String r1, String r10, Map r11, Map r12, Map r13) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
        }

        public final void subscribe(ObservableEmitter<JSONObject> r10) {
            Intrinsics.checkNotNullParameter(r10, "emitter");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L25
            String r1 = this.a;     // Catch: Throwable -> L25
            Locale r11 = Locale.ROOT;     // Catch: Throwable -> L25
            if (r1 == null) goto L24;
            boolean r12 = Intrinsics.areEqual("post", r1.toLowerCase(r11));     // Catch: Throwable -> L25
            Call<String> r13 = null;
            if (r12 == false) goto L10;
            VmSdkApi.a.getClass();     // Catch: Throwable -> L25
            VmSdkApi r14 = VmSdkApi.a.a;     // Catch: Throwable -> L25
            if (r14 == null) goto L13;
            r13 = r14.fetchPost(this.b, this.c, this.d, this.e);     // Catch: Throwable -> L25
        L13:
            if (r13 == null) goto L21;
            SsResponse r15 = r13.execute();     // Catch: Throwable -> L25
            if (r15 == null) goto L21;
            String r16 = (String) r15.body();     // Catch: Throwable -> L25
            if (r16 == null) goto L21;
            JSONObject r17 = z1.g(r16);     // Catch: Throwable -> L25
            if (r17 == null) goto L21;
            r10.onNext(r17);     // Catch: Throwable -> L25
            Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L25
        L22:
            Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L25
        L27:
            Throwable r20 = Result.exceptionOrNull-impl(r19);
            if (r20 == null) goto L32;
            r10.tryOnError(r20);
            return;
        L32:
            return;
        L21:
            r18 = Boolean.valueOf(r10.tryOnError(new Throwable("empty response error !")));     // Catch: Throwable -> L25
            goto L22
        L10:
            VmSdkApi.a.getClass();     // Catch: Throwable -> L25
            VmSdkApi r21 = VmSdkApi.a.a;     // Catch: Throwable -> L25
            if (r21 == null) goto L13;
            r13 = r21.fetchGet(this.b, this.c, this.d);     // Catch: Throwable -> L25
            goto L13
        L24:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            Result.Companion r22 = Result.Companion;
            r19 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L27
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ WorkerBridgeModule a;
        public final /* synthetic */ Callback b;

        public c(WorkerBridgeModule r1, Callback r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void accept(Object r10) {
            Callback r0 = this.b;
            WorkerBridgeModule r11 = this.a;
            JSONObject r12 = new JSONObject();
            r12.put("code", 1);
            r12.put("data", (JSONObject) r10);
            Unit r13 = Unit.INSTANCE;
            r0.invoke(new Object[]{r11.toWritableMap(r12)});
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ WorkerBridgeModule a;
        public final /* synthetic */ Callback b;

        public d(WorkerBridgeModule r1, Callback r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void accept(Object r10) {
            Callback r0 = this.b;
            WorkerBridgeModule r11 = this.a;
            JSONObject r12 = new JSONObject();
            r12.put("code", 0);
            r12.put(MessageIndication.MESSAGE_TYPE_MSG, ((Throwable) r10).getMessage());
            Unit r13 = Unit.INSTANCE;
            r0.invoke(new Object[]{r11.toWritableMap(r12)});
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ WorkerBridgeModule a;
        public final /* synthetic */ String b;

        public e(WorkerBridgeModule r1, String r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.openSchema(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ WorkerBridgeModule a;

        public f(WorkerBridgeModule r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.terminate();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    private final boolean is32Bit() {
        if (Build.SUPPORTED_64_BIT_ABIS.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @JSMethod
    public final WritableMap getAppInfo() {
        JSONObject r0 = new JSONObject();
        if (com.bytedance.android.ec.sdk.helper.d.b.getIECHostAppInfo() == null) goto L6;
        ECAppInfoService r1 = ECAppInfoService.e;
        r0.put("appID:", r1.getAppId());
        r0.put("installID", r1.getInstallId());
        r0.put("appVersion", r1.getAppVersion());
        r0.put("updateVersionCode", r1.getUpdateVersionCode());
        r0.put("channel", r1.getChannel());
        r0.put("deviceID", r1.getServerDeviceId());
        r0.put("osVersion", Build.VERSION.RELEASE);
        r0.put("statusBarHeight", k1.p());
        r0.put("devicePlatform", "android");
        r0.put("deviceModel", Build.MODEL);
        r0.put("networkType", NetworkUtils.getNetworkAccessType(r1.getApplicationContext()));
        r0.put("is32Bit", is32Bit());
        r0.put("screenWidth", k1.l());
        r0.put("screenHeight", k1.i());
    L6:
        return toWritableMap(r0);
    }

    @JSMethod
    public final WritableMap getECActionData() {
        ih.a.d.getClass();
        ih.a r0 = ih.a.b;
        r0.getClass();
        JSONObject r1 = new JSONObject();
        r1.put("btm", ih.a.b());
        Iterator r10 = ((LinkedHashMap) r0.a).entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L32;
        Map.Entry r11 = (Map.Entry) r10.next();
        String r12 = (String) r11.getKey();
        JSONObject r13 = new JSONObject();
        Lazy r14 = Json.a;
        r13.put("ActionPath", Json.d(((ih.b) r11.getValue()).a));
        UserActionCacheMap<ActionType> r15 = ((ih.b) r11.getValue()).b;
        Iterator<T> r16 = r15.a().iterator();
    L6:
        String r17 = null;
        if (r16.hasNext() == false) goto L16;
        lg.d r18 = (lg.d) r15.get((ActionType) r16.next());
        if (r18 == null) goto L6;
        ActionType r19 = r18.getType();
        if (r19 == null) goto L13;
        r17 = r19.name();
    L13:
        if (r17 != null) goto L15;
        r17 = "";
    L15:
        int r20 = t0.a;
        r13.put(r17, GsonProtectorUtils.toJson(t0.a.a, r18));
        goto L6
    L16:
        UserActionCacheMap<String> r21 = ((ih.b) r11.getValue()).c;
        JSONObject r22 = new JSONObject();
        Iterator<T> r23 = r21.a().iterator();
    L18:
        if (r23.hasNext() == false) goto L30;
        lg.d r24 = (lg.d) r21.get((String) r23.next());
        if (r24 == null) goto L18;
        if ((r24 instanceof j) == true) goto L24;
        lg.d r25 = null;
    L25:
        j r26 = (j) r25;
        if (r26 == null) goto L29;
        if (r26.c(r22) != null) goto L18;
    L29:
        int r27 = t0.a;
        z1.c(r22, GsonProtectorUtils.toJson(t0.a.a, r24));
        goto L18
    L24:
        r25 = r24;
        goto L25
    L30:
        r13.put(ActionType.NetWork.name(), r22);
        Unit r28 = Unit.INSTANCE;
        r1.put(r12, r13);
        goto L4
    L32:
        return toWritableMap(r1);
    }

    @JSMethod
    public final WritableMap getUserInfo() {
        JSONObject r0 = new JSONObject();
        r r1 = r.a;
        r0.put("isLogin", r1.isLogin());
        r0.put("secUserID", r1.f());
        return toWritableMap(r0);
    }

    @JSMethod
    public final void terminate() {
        if ((!Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread())) == false) goto L6;
        new Handler(Looper.getMainLooper()).post(new f(this));
        return;
    L6:
        int r0 = ECSdk.a;
        com.bytedance.android.ec.core.vmsdk.a r1 = (com.bytedance.android.ec.core.vmsdk.a) ECSdk.a(com.bytedance.android.ec.core.vmsdk.a.class);
        if (r1 == null) goto L10;
        r1.a(getName());
        return;
    }

    private final boolean isHttpUrl(String r10) {
        if (r10 == null) goto L13;
        String r11 = r10.toLowerCase(Locale.US);
        if (r11 != null) goto L8;
        return false;
    L8:
        if (StringsKt.startsWith$default(r11, "http://", false, 2, null) == false) goto L10;
    L11:
        return true;
    L10:
        if (StringsKt.startsWith$default(r11, "https://", false, 2, null) == true) goto L11;
        return false;
    L13:
        return false;
    }

    @JSMethod
    public final String getStorage(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        return q.a.getString(r10, "");
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return "";
    }

    @JSMethod
    public final void openSchema(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        if ((!Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread())) == false) goto L6;
        new Handler(Looper.getMainLooper()).post(new e(this, r10));
        return;
    L6:
        p.a.openSchema(((JSModule) this).mContext, r10);
    }

    public WorkerBridgeModule(Context r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "params");
        super(r10, r11);
    }

    @Override // com.bytedance.android.ec.core.vmsdk.module.BaseWorkerBridgeModule
    public void invokeCallback(JSONObject r10, c0 r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "call");
        Callback r12 = getCallbackRegistry().remove(r11);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L10
        Object r14 = r10.remove("__params");     // Catch: Throwable -> L10
        if (r14 != null) goto L6;
    L8:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L10
        Object r15 = Result.constructor-impl(toWritableMap(r10));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r15) == false) goto L15;
        r15 = null;
    L15:
        WritableMap r16 = (WritableMap) r15;
        if (r16 == null) goto L22;
        if (r12 == null) goto L23;
        r12.invoke(new Object[]{r16});
        return;
    L23:
        return;
    L22:
        return;
    L6:
        if ((r14 instanceof JSONObject) == false) goto L8;
        ((JSONObject) r14).remove("__data");     // Catch: Throwable -> L10
        ((JSONObject) r14).remove("__msg_type");     // Catch: Throwable -> L10
        r10.put("eventId", CastLongProtector.parseLong(((JSONObject) r14).optString("__callback_id", "0")));     // Catch: Throwable -> L10
        r10.put("data", r14);     // Catch: Throwable -> L10
        r10.put("code", ((JSONObject) r14).optInt("code"));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    @JSMethod
    public final void log(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        if (r11 != 0) goto L5;
        DLog.a("jsWorker", r10);     // Catch: Exception -> L24
    L29:
        return;
    L5:
        if (r11 != 1) goto L7;
        Lazy r12 = DLog.a;     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter("jsWorker", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);     // Catch: Exception -> L24
        cl.c r13 = DLog.b();     // Catch: Exception -> L24
        if (r13 == null) goto L29;
        r13.log();     // Catch: Exception -> L24
        goto L29
    L7:
        if (r11 != 2) goto L9;
        Lazy r14 = DLog.a;     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter("jsWorker", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);     // Catch: Exception -> L24
        cl.c r15 = DLog.b();     // Catch: Exception -> L24
        if (r15 == null) goto L29;
        r15.log();     // Catch: Exception -> L24
        goto L29
    L9:
        if (r11 == 3) goto L13;
        Lazy r16 = DLog.a;     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter("jsWorker", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);     // Catch: Exception -> L24
        cl.c r17 = DLog.b();     // Catch: Exception -> L24
        if (r17 == null) goto L29;
        r17.log();     // Catch: Exception -> L24
        goto L29
    L13:
        Lazy r18 = DLog.a;     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter("jsWorker", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);     // Catch: Exception -> L24
        cl.c r19 = DLog.b();     // Catch: Exception -> L24
        if (r19 == null) goto L29;
        r19.log();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        Lazy r20 = DLog.a;
        Intrinsics.checkNotNullParameter("jsWorker", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter("Worker invoke log error:", MessageIndication.MESSAGE_TYPE_MSG);
        cl.c r21 = DLog.b();
        if (r21 == null) goto L33;
        StringsKt.trimIndent("\n            Worker invoke log error:\n            " + Log.getStackTraceString(e) + "\n            ");
        r21.log();
        return;
    }

    @JSMethod
    public final void sendLogV3(String r10, ReadableMap r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        EventActionImpl r0 = getEventAction();
        if (r11 == null) goto L5;
        Map<String, String> r12 = toStringMap$ec_core_saasRelease(r11);
    L6:
        r0.doEventAction(r10, r12, new Pair[0]);
        return;
    L5:
        r12 = null;
        goto L6
    }

    @JSMethod
    public final void setStorage(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        q.a.putString(r10, r11);
    }

    @JSMethod
    public final void call(String r10, ReadableMap r11, Callback r12) {
        Intrinsics.checkNotNullParameter(r10, "functionName");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r13 = Result.constructor-impl(toJSONObject$ec_core_saasRelease(r11));     // Catch: Throwable -> L5
    L7:
        String r1 = null;
        if (Result.isFailure-impl(r13) == false) goto L10;
        r13 = null;
    L10:
        JSONObject r14 = (JSONObject) r13;
        if (r14 == null) goto L29;
        ai.b r15 = getWorkerBridgeImpl();
        if (r15 == null) goto L30;
        JSONObject r16 = r14.optJSONObject("data");
        if (r16 == null) goto L18;
        String r17 = r16.toString();
        if (r17 == null) goto L18;
    L19:
        String r18 = r14.optString("namespace");
        if (r18.length() <= 0) goto L22;
        boolean r19 = true;
    L23:
        if (r19 == false) goto L25;
        r1 = r18;
    L25:
        String r20 = r14.optString("__callback_id", "0");
        c0.a r21 = c0.a();
        r21.c = r10;
        r21.d = r17;
        r21.e = r20;
        r21.f = r1;
        c0 r22 = r21.a();
        getCallbackRegistry().put(r22, r12);
        r15.o(r22);
        return;
    L22:
        r19 = false;
    L18:
        r17 = "{}";
        goto L19
    L30:
        return;
    L29:
        return;
    L5:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @JSMethod
    public final WritableMap reportALog(String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "level");
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_MSG);
        Intrinsics.checkNotNullParameter(r14, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        JSONObject r0 = new JSONObject();
        switch(r12.hashCode()) {
            case 3237038: goto L22;
            case 3641990: goto L19;
            case 95458899: goto L16;
            case 96784904: goto L13;
            case 351107458: goto L6;
            default: goto L24;
        };
    L24:
        r0.put("code", 0);
        r0.put(MessageIndication.MESSAGE_TYPE_MSG, "level is not in { \"verbose\" | \"debug\" | \"info\" | \"warn\" | \"error\" }");
    L26:
        if (r0.length() != 0) goto L29;
        r0.put("code", 1);
    L29:
        return toWritableMap(r0);
    L6:
        if (r12.equals("verbose") == false) goto L24;
        dm.d r10 = dm.a.a(r14).a;     // Catch: Exception -> L10
        r10.g(2, r10.d(), r10.e(), r10.c(), r13, null);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        dm.c.b(e);
        goto L26
    L13:
        if (r12.equals(IHostStyleUIDepend.TOAST_TYPE_ERROR) == false) goto L24;
        dm.a.a(r14).b(r13, null);
        goto L26
    L16:
        if (r12.equals("debug") == false) goto L24;
        dm.a.a(r14).a(r13);
        goto L26
    L19:
        if (r12.equals(IHostStyleUIDepend.TOAST_TYPE_WARN) == false) goto L24;
        dm.a.a(r14).w(r13, null);
        goto L26
    L22:
        if (r12.equals("info") == false) goto L24;
        dm.a.a(r14).i(r13);
        goto L26
    }

    @JSMethod
    public final void fetch(String r10, ReadableMap r11, String r12, Callback r13, ReadableMap r14, ReadableMap r15) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "method");
        Intrinsics.checkNotNullParameter(r13, "callback");
        if (r11 == null) goto L5;
        Map<String, String> r16 = toStringMap$ec_core_saasRelease(r11);
    L6:
        if (r14 == null) goto L8;
        Map<String, String> r17 = toStringMap$ec_core_saasRelease(r14);
    L9:
        if (r15 == null) goto L11;
        Map<String, String> r18 = toStringMap$ec_core_saasRelease(r15);
    L13:
        if (isHttpUrl(r10) == true) goto L20;
        StringBuilder r19 = new StringBuilder("https://ecom.snssdk.com");
        if (StringsKt.startsWith$default(r10, '/', false, 2, null) == true) goto L19;
        r10 = "/" + r10;
    L19:
        r19.append(r10);
        r10 = r19.toString();
    L20:
        com.bytedance.android.ec.core.async.a.a(Observable.create(new b(r12, r10, r18, r16, r17)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new c(this, r13), new d(this, r13)), this);
        return;
    L11:
        r18 = null;
        goto L13
    L8:
        r17 = null;
        goto L9
    L5:
        r16 = null;
        goto L6
    }
}
