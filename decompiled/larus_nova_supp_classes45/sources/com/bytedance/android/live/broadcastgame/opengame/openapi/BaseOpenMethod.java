package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.broadcastgame.opengame.network.model.OpenPlatformRespExtra;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.livesdk.config.vd0;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.disposables.Disposable;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Queue;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class BaseOpenMethod<P> extends com.bytedance.ies.web.jsbridge2.f<P, JSONObject> {
    public static final int g = 0;
    public final List<String> a;
    public boolean b;
    public String c;
    public final PluginContext d;
    public final Queue<Long> e;
    public final /* synthetic */ i20.a f;

    public static final class a {
    }

    public abstract void call(P r1, CallContext r2);

    public abstract String getMethodName();

    public final void j(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.f.a(r2);
    }

    public void l() {
        this.f.b();
    }

    static {
        g = OpenApiErrorInfo.INCORRECT_PARAMS.getErrorCode();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.b = false;
    }

    public final void onTerminate() {
        l();
    }

    public final synchronized boolean k(String r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r12, "method");     // Catch: Throwable -> L39
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L6;
    L9:
        p r0 = ((BootInfoService) this.d.o(BootInfoService.class)).d(r12);     // Catch: Throwable -> L39
        if (r0 != null) goto L14;
        OpenApiErrorInfo r13 = OpenApiErrorInfo.NO_REQUEST_PERMISSION;     // Catch: Throwable -> L39
        n(r13, null);     // Catch: Throwable -> L39
        ((OpenPlatformMonitorService) this.d.o(OpenPlatformMonitorService.class)).i(getMethodName(), 1, Integer.valueOf(r13.getErrorCode()), "没有调用权限");     // Catch: Throwable -> L39
        monitor-exit(this);
        return false;
    L14:
        int r4 = r0.a;     // Catch: Throwable -> L39
        int r1 = r0.b;     // Catch: Throwable -> L39
        if (this.a.contains(r12) == true) goto L37;
        if (r1 == 0) goto L37;
        if (this.e == null) goto L37;
        if (r4 != 0) goto L24;
        OpenPlatformMonitorService r14 = (OpenPlatformMonitorService) this.d.o(OpenPlatformMonitorService.class);     // Catch: Throwable -> L39
        String r2 = getMethodName();     // Catch: Throwable -> L39
        OpenApiErrorInfo r5 = OpenApiErrorInfo.NO_REQUEST_PERMISSION;     // Catch: Throwable -> L39
        r14.i(r2, 1, Integer.valueOf(r5.getErrorCode()), "没有调用权限");     // Catch: Throwable -> L39
        n(r5, null);     // Catch: Throwable -> L39
        monitor-exit(this);
        return false;
    L24:
        long r6 = System.currentTimeMillis();     // Catch: Throwable -> L39
        if (this.e.size() >= r4) goto L30;
        this.e.offer(Long.valueOf(r6));     // Catch: Throwable -> L39
        monitor-exit(this);
        return true;
    L30:
        if ((r6 - this.e.peek().longValue()) > (r1 * 1000)) goto L34;
        OpenPlatformMonitorService r15 = (OpenPlatformMonitorService) this.d.o(OpenPlatformMonitorService.class);     // Catch: Throwable -> L39
        String r3 = getMethodName();     // Catch: Throwable -> L39
        OpenApiErrorInfo r7 = OpenApiErrorInfo.EXCEED_FREQ_LIMIT;     // Catch: Throwable -> L39
        r15.i(r3, 1, Integer.valueOf(r7.getErrorCode()), "超出调用频率限制");     // Catch: Throwable -> L39
        n(r7, null);     // Catch: Throwable -> L39
        monitor-exit(this);
        return false;
    L34:
        this.e.poll();     // Catch: Throwable -> L39
        this.e.offer(Long.valueOf(r6));     // Catch: Throwable -> L39
        monitor-exit(this);
        return true;
    L37:
        monitor-exit(this);
        return true;
    L6:
        if (Intrinsics.areEqual(vd0.a.getValue(), Boolean.FALSE) == false) goto L9;
        monitor-exit(this);
        return true;
    L39:
        th = move-exception;
        throw th;
    }

    public final void o(Throwable r7) {
        boolean r1 = false;
        if ((r7 instanceof CustomApiServerException) == false) goto L27;
        CustomApiServerException r8 = (CustomApiServerException) r7;
        Function2<Integer, String, Unit> r0 = new BaseOpenMethod$fail$1(this);
        Intrinsics.checkNotNullParameter(r8, "$this$getError");
        Intrinsics.checkNotNullParameter(r0, "action");
        String r9 = r8.getExtra();
        if (r9 != null) goto L7;
    L25:
        OpenApiErrorInfo r11 = OpenApiErrorInfo.INTERNAL_ERROR;
        r0.invoke(Integer.valueOf(r11.getErrorCode()), r11.getErrorMsg());
        return;
    L7:
        if (r9.length() <= 0) goto L9;
        r1 = true;
    L9:
        if (r1 != true) goto L25;
        JsonElement r12 = GsonHelper.parser().parse(r9);     // Catch: Exception -> L24
        if (r12 == null) goto L47;
        JsonObject r13 = r12.getAsJsonObject();     // Catch: Exception -> L24
        if (r13 == null) goto L48;
        OpenPlatformRespExtra r14 = (OpenPlatformRespExtra) GsonHelper.get().fromJson(r13, OpenPlatformRespExtra.class);     // Catch: Exception -> L24
        if (r14 == null) goto L17;
        int r2 = r14.errorCode;     // Catch: Exception -> L24
    L18:
        if (r14 == null) goto L21;
        String r15 = r14.errorMsg;     // Catch: Exception -> L24
        if (r15 == null) goto L21;
    L22:
        r0.invoke(Integer.valueOf(r2), r15);     // Catch: Exception -> L24
        return;
    L21:
        r15 = OpenApiErrorInfo.INTERNAL_ERROR.getErrorMsg();     // Catch: Exception -> L24
        goto L22
    L17:
        r2 = OpenApiErrorInfo.INTERNAL_ERROR.getErrorCode();     // Catch: Exception -> L24
        goto L18
    L48:
        return;
    L47:
        return;
    L24:
        OpenApiErrorInfo r16 = OpenApiErrorInfo.INTERNAL_ERROR;
        r0.invoke(Integer.valueOf(r16.getErrorCode()), r16.getErrorMsg());
        return;
    L27:
        if ((r7 instanceof NetworkErrorException) == false) goto L29;
    L43:
        n(OpenApiErrorInfo.NETWORK_ERROR, null);
        return;
    L29:
        if ((r7 instanceof SocketTimeoutException) == true) goto L43;
        OpenApiErrorInfo r3 = OpenApiErrorInfo.INTERNAL_ERROR;
        int r4 = r3.getErrorCode();
        if (r7 == null) goto L41;
        String r5 = r7.toString();
        if (r5 == null) goto L41;
        if (r5.length() != 0) goto L38;
        r1 = true;
    L38:
        if (r1 == false) goto L40;
        r5 = r3.getErrorMsg();
    L40:
        if (r5 == null) goto L41;
    L42:
        p(this, r4, r5, r7, 8);
        return;
    L41:
        r5 = r3.getErrorMsg();
        goto L42
    }

    public final void r(JSONObject r9) {
        OpenPlatformMonitorService r1 = (OpenPlatformMonitorService) this.d.o(OpenPlatformMonitorService.class);
        String r2 = getMethodName();
        Intrinsics.checkNotNullParameter(r2, "method");
        r1.o(r2, "ttlive_open_platform_openapi_execute", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, null, null).c();
        JSONObject r0 = new JSONObject();
        r0.put("errCode", 0);
        if (r9 != null) goto L5;
        finishWithResult(r0);
        return;
    L5:
        r9.put("errCode", 0);
        Unit r3 = Unit.INSTANCE;
        finishWithResult(r9);
    }

    public BaseOpenMethod(PluginContext r2, Queue<Long> r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        this.f = new i20.a();
        this.d = r2;
        this.e = r3;
        this.a = CollectionsKt.mutableListOf(new String[]{"log"});
        this.b = true;
        this.c = "";
    }

    public void invoke(P r6, CallContext r7) {
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        OpenPlatformMonitorService r0 = (OpenPlatformMonitorService) this.d.o(OpenPlatformMonitorService.class);
        String r1 = getMethodName();
        Intrinsics.checkNotNullParameter(r1, "method");
        OpenPlatformMonitorService.p(r0, r1, "ttlive_open_platform_openapi_call", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 56).c();
        if (k(getMethodName()) == false) goto L14;
        boolean r3 = false;
        ((OpenPlatformMonitorService) this.d.o(OpenPlatformMonitorService.class)).i(getMethodName(), 0, null, null);
        if (this.c.length() != 0) goto L7;
        r3 = true;
    L7:
        if (r3 == false) goto L12;
        String r2 = r7.b;
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        this.c = r2;
    L12:
        call(r6, r7);
        return;
    }

    public final void n(OpenApiErrorInfo r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, "errorInfo");
        p(this, r3.getErrorCode(), r3.getErrorMsg(), r4, 8);
    }

    public static void q(BaseOpenMethod r1, JSONObject r2, OpenApiErrorInfo r3) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "errorInfo");
        r1.m(r3.getErrorCode(), r3.getErrorMsg(), r2);
    }

    public final void m(int r11, String r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r12, "errMsg");
        switch(r11) {
            case 408: goto L25;
            case 10001: goto L24;
            case 10002: goto L24;
            case 10003: goto L23;
            case 10004: goto L22;
            case 10011: goto L21;
            case 10013: goto L20;
            case 20003: goto L19;
            case 20087: goto L18;
            case 40023: goto L17;
            case 40033: goto L16;
            case 41001: goto L15;
            case 90203: goto L14;
            case 90204: goto L14;
            case 90504: goto L13;
            case 4001010: goto L24;
            case 4001011: goto L24;
            case 4005024: goto L16;
            case 4008074: goto L12;
            case 4014016: goto L11;
            case 4014023: goto L10;
            case 4014031: goto L22;
            case 4014034: goto L9;
            case 4014035: goto L8;
            case 4014036: goto L7;
            case 4014038: goto L21;
            case 4014040: goto L22;
            case 4014044: goto L6;
            case 4014045: goto L16;
            case 4014047: goto L13;
            case 4014048: goto L13;
            case 4014052: goto L13;
            case 4019001: goto L5;
            default: goto L4;
        };
    L4:
        OpenApiErrorInfo r1 = null;
    L26:
        if (r1 == null) goto L28;
        int r2 = r1.getErrorCode();
        String r3 = r1.getErrorMsg();
    L29:
        boolean r4 = true;
        if (r13 != null) goto L38;
        JSONObject r14 = new JSONObject();
        r14.put("errCode", r2);
        if (r12.length() > 0) goto L35;
        r4 = false;
    L35:
        if (r4 == false) goto L37;
        r14.put("errMsg", r3);
    L37:
        Unit r0 = Unit.INSTANCE;
        finishWithResult(r14);
    L45:
        OpenPlatformMonitorService r5 = (OpenPlatformMonitorService) this.d.o(OpenPlatformMonitorService.class);
        String r6 = getMethodName();
        Integer r8 = Integer.valueOf(r11);
        Intrinsics.checkNotNullParameter(r6, "method");
        r5.o(r6, "ttlive_open_platform_openapi_execute", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 1, r8, r12).c();
        return;
    L38:
        r13.put("errCode", r2);
        if (r12.length() > 0) goto L42;
        r4 = false;
    L42:
        if (r4 == false) goto L44;
        r13.put("errMsg", r3);
    L44:
        Unit r7 = Unit.INSTANCE;
        finishWithResult(r13);
        goto L45
    L28:
        r2 = r11;
        r3 = r12;
        goto L29
    L5:
        r1 = OpenApiErrorInfo.LOGIN_OUT_DATE;
        goto L26
    L6:
        r1 = OpenApiErrorInfo.PAY_DIAMONDS_REACH_LIMIT;
        goto L26
    L7:
        r1 = OpenApiErrorInfo.INVALID_ACCESS_TOKEN;
        goto L26
    L8:
        r1 = OpenApiErrorInfo.SENSITIVE_WORD_DETECTED;
        goto L26
    L9:
        r1 = OpenApiErrorInfo.EXCEED_FREQ_LIMIT;
        goto L26
    L10:
        r1 = OpenApiErrorInfo.USER_NOT_IN_ROOM;
        goto L26
    L11:
        r1 = OpenApiErrorInfo.APP_NOT_LAUNCH;
        goto L26
    L12:
        r1 = OpenApiErrorInfo.REWARD_REACH_LIMIT;
        goto L26
    L13:
        r1 = OpenApiErrorInfo.INCORRECT_PARAMS;
        goto L26
    L14:
        r1 = OpenApiErrorInfo.NET_REQUEST_CONCURRENCY_EXCEED_LIMIT;
        goto L26
    L15:
        r1 = OpenApiErrorInfo.ACCOUNT_EXCEPTION;
        goto L26
    L16:
        r1 = OpenApiErrorInfo.DATA_ALREADY_EXIST;
        goto L26
    L17:
        r1 = OpenApiErrorInfo.NET_REQUEST_RESPONSE_INCOMPATIBLE;
        goto L26
    L18:
        r1 = OpenApiErrorInfo.ILLEGAL_APP_ID;
        goto L26
    L19:
        r1 = OpenApiErrorInfo.NOT_LOGIN;
        goto L26
    L20:
        r1 = OpenApiErrorInfo.INVALID_URL_PARAMS;
        goto L26
    L21:
        r1 = OpenApiErrorInfo.INCORRECT_PARAMS;
        goto L26
    L22:
        r1 = OpenApiErrorInfo.DATA_NOT_EXIST;
        goto L26
    L23:
        r1 = OpenApiErrorInfo.SIGNATURE_ERROR;
        goto L26
    L24:
        r1 = OpenApiErrorInfo.INTERNAL_ERROR;
        goto L26
    L25:
        r1 = OpenApiErrorInfo.NET_REQUEST_TIMEOUT;
        goto L26
    }

    public static /* synthetic */ void p(BaseOpenMethod r0, int r1, String r2, Throwable r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        r2 = "";
    L5:
        r0.m(r1, r2, null);
    }
}
