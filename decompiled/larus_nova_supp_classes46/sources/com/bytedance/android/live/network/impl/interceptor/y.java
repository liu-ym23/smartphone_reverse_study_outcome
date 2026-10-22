package com.bytedance.android.live.network.impl.interceptor;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.api.exceptions.local.EmptyResponseException;
import com.bytedance.android.live.api.exceptions.local.ResponseNoDataException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.MinorExtra;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.verify.interceptor.MinorInterceptor;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.network.NetworkSettingKeys;
import com.bytedance.android.live.network.PbRequestCallAdapter;
import com.bytedance.android.live.network.PbRequestCallAdapterV2;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.UnifiedResponsesKt;
import com.bytedance.android.livesdk.config.ew0;
import com.bytedance.android.livesdk.config.lo0;
import com.bytedance.android.livesdk.config.nu;
import com.bytedance.android.livesdk.config.wl;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.http.HttpRequestInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y implements Interceptor {
    public static final Pattern b = null;
    public static final Pattern c = null;
    public static final Pattern d = null;
    public static y e;
    public final List<q> a;

    static {
        b = PatternProtector.compile(".*/webcast/wallet_api/diamond_buy.*");
        c = PatternProtector.compile(".*/webcast/wallet/recharge/.*");
        d = PatternProtector.compile(".*/webcast/room/enter/.*");
    }

    public static y a() {
        if (e != null) goto L15;
        monitor-enter(y.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new y();     // Catch: Throwable -> L11
    L9:
        monitor-exit(y.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }

    public y() {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        r0.add(DSLimitInterceptor.d);
        r0.add(u.b);
    }

    public final SsResponse intercept(Interceptor.Chain r17) throws Exception {
        Request r0 = r17.request();
        if (tb1.c.a == false) goto L14;
        if (r0 == null) goto L14;
        if (((Boolean) nu.a.getValue()).booleanValue() == false) goto L10;
        if (TextUtils.equals("/webcast/room/enter/", r0.getPath()) == false) goto L10;
    L13:
        boolean r1 = true;
    L16:
        if (r1 == false) goto L24;
        if (((Boolean) NetworkSettingKeys.ENABLE_PB_REQUESTS.getValue()).booleanValue() == true) goto L20;
    L32:
        Request r2 = r0;
        SsResponse r11 = r17.proceed(r2);
        if (r11 == null) goto L120;
        if (r2 == null) goto L120;
        Response r3 = r11.raw();
        if (r3 == null) goto L120;
        int r5 = r3.getStatus();
        if (r5 != 200) goto L120;
        Object r6 = r11.body();
        String r7 = r2.getUrl();
        String r8 = s1.B(2131920667);
        if ((r6 instanceof com.bytedance.android.live.network.response.g) == false) goto L48;
        com.bytedance.android.live.network.response.g r9 = (com.bytedance.android.live.network.response.g) r6;
        int r10 = r9.statusCode;
        T r12 = r9.data;
        if ((r12 instanceof Room) == false) goto L73;
        r8 = ((Room) r12).message;
    L73:
        if (r10 == 0) goto L120;
        Uri r13 = UriProtector.parse(r7);     // Catch: Exception -> L82
        fo0.b r14 = fo0.a.a;     // Catch: Exception -> L82
        if (r14 == null) goto L83;
        if (r14.getBlackList() == null) goto L83;
        if (fo0.a.a.getBlackList().contains(r13.getPath()) == true) goto L120;
    L83:
        List r4 = r3.getHeaders();
        if (r4 != null) goto L86;
    L95:
        String r15 = "";
    L96:
        final JSONObject r16 = new JSONObject();
        r16.put("xLogId", r15);     // Catch: Exception -> L140
    L166:
        r16.put("code", r5);     // Catch: Exception -> L141
    L164:
        r16.put("status_code", r10);     // Catch: Exception -> L142
    L178:
        r16.put("url", r7);     // Catch: Exception -> L143
    L174:
        r16.put(MultiLinkOpenSource.MESSAGE, r8);     // Catch: Exception -> L144
    L180:
        r16.put("classes", "com.bytedance.android.livesdk.network.ResponseInterceptor");     // Catch: Exception -> L145
    L106:
        ALogger.d("ttlive_net", new x(this, r16));
        JSONObject r18 = new JSONObject();
        r18.put("xLogId", r15);     // Catch: Exception -> L146
    L176:
        r18.put("code", r5);     // Catch: Exception -> L147
    L170:
        r18.put("status_code", r10);     // Catch: Exception -> L148
    L162:
        Uri r19 = UriProtector.parse(r7);     // Catch: Exception -> L115
        r18.put("host", r19.getHost());     // Catch: Exception -> L151
    L112:
        r18.put("path", r19.getPath());     // Catch: Exception -> L149
    L168:
        r18.put(MultiLinkOpenSource.MESSAGE, r8);     // Catch: Exception -> L150
    L118:
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_network_request_error", 1, r18);
    L115:
        e = move-exception;
        Logger.e(e.getMessage());
        goto L168
    L86:
        if (r4.isEmpty() == true) goto L95;
        Iterator r20 = r4.iterator();
        r15 = "";
    L89:
        if (r20.hasNext() == false) goto L96;
        Header r110 = (Header) r20.next();
        if (r110 == null) goto L89;
        if ("x-tt-Logid".equalsIgnoreCase(r110.getName()) == false) goto L89;
        r15 = r110.getValue();
        goto L89
    L48:
        if ((r6 instanceof Response) == false) goto L51;
        r10 = ((Response) r6).getStatus();
        goto L73
    L51:
        if ((r6 instanceof ListResponse) == false) goto L54;
        r10 = ((ListResponse) r6).statusCode;
        goto L73
    L54:
        if ((r6 instanceof BaseListResponse) == false) goto L57;
        r10 = ((BaseListResponse) r6).statusCode;
        goto L73
    L57:
        if ((r6 instanceof BaseResponse) == false) goto L60;
        r10 = ((BaseResponse) r6).statusCode;
        goto L73
    L60:
        if ((r6 instanceof String) == false) goto L72;
        String r21 = (String) r6;
        if (TextUtils.isEmpty(r21) == false) goto L72;
        JSONObject r22 = new JSONObject(r21);     // Catch: Exception -> L65
    L66:
        if (r22 != null) goto L68;
        r10 = 0;
    L69:
        if (r22 != null) goto L71;
        r8 = "";
        goto L73
    L71:
        r8 = r22.optString(MultiLinkOpenSource.MESSAGE, "");
        goto L73
    L68:
        r10 = r22.optInt("status_code", 0);
    L65:
        r22 = null;
    L72:
        r10 = 0;
    L120:
        Object r23 = r11.body();
        List r24 = r11.raw().headers("X-Tt-Logid");
        if (r24 != null) goto L123;
    L125:
        String r25 = "";
    L126:
        List r26 = r11.raw().headers("rpc-persist-webcast-trace-id");
        if (r26 != null) goto L129;
    L131:
        String r27 = "";
    L132:
        List r28 = r11.raw().headers("tt_stable");
        if (r28 != null) goto L135;
    L137:
        String r29 = "";
    L138:
        e(r2.getUrl(), r23, r25, r27, r29, r11);
        return r11;
    L135:
        if (r28.size() <= 0) goto L137;
        r29 = ((Header) ListProtector.get(r28, 0)).getValue();
        goto L138
    L129:
        if (r26.size() <= 0) goto L131;
        r27 = ((Header) ListProtector.get(r26, 0)).getValue();
        goto L132
    L123:
        if (r24.size() <= 0) goto L125;
        r25 = ((Header) ListProtector.get(r24, 0)).getValue();
        goto L126
    L20:
        if (PbRequestCallAdapterV2.a(r0) == false) goto L32;
        Request.Builder r30 = r0.newBuilder();
        LinkedList r31 = new LinkedList(r0.getHeaders());
        r31.add(new Header("response-format", "protobuf"));
        r0 = r30.headers(r31).build();
        goto L32
    L24:
        if (((Boolean) NetworkSettingKeys.ENABLE_PB_REQUESTS.getValue()).booleanValue() == false) goto L32;
        PbRequestCallAdapter.f.getClass();
        Intrinsics.checkNotNullParameter(r0, "request");
        Map<String, String> r32 = PbRequestCallAdapter.d;
        ConcurrentHashMap r33 = (ConcurrentHashMap) r32;
        String r34 = (String) r33.remove(PbRequestCallAdapter.a.a(r0));
        if (r34 != null) goto L28;
        boolean r35 = false;
    L29:
        if (r35 == false) goto L32;
        LinkedList r36 = new LinkedList(r0.getHeaders());
        r36.add(new Header("response-format", "protobuf"));
        r0 = r0.newBuilder().headers(r36).build();
        goto L32
    L28:
        r35 = ((JSONObject) PbRequestCallAdapter.e.getValue()).optBoolean(r34, Intrinsics.areEqual(r34, "_global_switch"));
    L10:
        if (((Boolean) ew0.a.getValue()).booleanValue() == false) goto L14;
        if (TextUtils.equals("/webcast/user/profile/", r0.getPath()) == true) goto L13;
    L14:
        r1 = false;
        goto L16
    }

    public static void d(int r1, RequestError r2, Extra r3) {
        if ((r3 instanceof com.bytedance.android.live.base.model.i) == false) goto L6;
        return;
    L6:
        if (((Boolean) wl.a.getValue()).booleanValue() == true) goto L8;
        return;
    L8:
        if ((r3 instanceof MinorExtra) == false) goto L10;
        MinorInterceptor.d.f(r1, r2, (MinorExtra) r3);
        return;
    L10:
        MinorInterceptor.d.f(r1, r2, null);
    }

    public static void b(String r1, int r2, RequestError r3, Extra r4) {
        if (r2 != 42201) goto L5;
    L17:
    L14:
        th = move-exception;
        ALogger.e("ResponseInterceptor", "matcherCrash=" + th.getMessage());
        return;
    L9:
        if (b.matcher(r1).matches() == false) goto L11;
        return;
    L11:
        if (c.matcher(r1).matches() == true) goto L21;
        d(r2, r3, r4);     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L5:
        if (r2 == 42202) goto L17;
        if (r2 == 42200) goto L17;
    }

    public final void c(String r9, BaseResponse r10, int r11, RequestError r12) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        if (((q) r0.next()).a(r9, r11, r10, "live_detail", r12) == false) goto L4;
        return;
    }

    public final void e(String r5, Object r6, String r7, String r8, String r9, SsResponse r10) throws Exception {
        if ((r6 instanceof com.bytedance.android.live.network.response.c) == false) goto L14;
        com.bytedance.android.live.network.response.c r11 = (com.bytedance.android.live.network.response.c) r6;
        int r12 = r11.getStatusCode();
        RequestError r13 = r11.getError();
        Iterator r0 = ((ArrayList) this.a).iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        if (((q) r0.next()).b(r12, r11, r13) == false) goto L6;
    L10:
        if (r11.getStatusCode() == 0) goto L12;
        r11.getError().url = r5;
        b(r5, r11.getStatusCode(), r11.getError(), r11.a());
    L12:
        ExceptionUtils.throwError(r11.getStatusCode(), r11.getError(), GsonProtectorUtils.toJson(GsonHelper.get(), r11.a()), r7, r8);
        return;
    L14:
        if ((r6 instanceof ExtraResponse) == false) goto L31;
        ExtraResponse r14 = (ExtraResponse) r6;
        Iterator r15 = ((ArrayList) this.a).iterator();
    L17:
        if (r15.hasNext() == false) goto L20;
        ((q) r15.next()).c(r5, r14);
        goto L17
    L20:
        if ((r6 instanceof com.bytedance.android.live.network.response.b) == false) goto L23;
        com.bytedance.android.live.network.response.b r16 = (com.bytedance.android.live.network.response.b) r6;
        r16.getClass();
        ((Field) UnifiedResponsesKt.a.getValue()).set(r16, r7);
        r16.b = r8;
        return;
    L23:
        if ((r6 instanceof com.bytedance.android.live.network.response.f) == false) goto L26;
        com.bytedance.android.live.network.response.f r17 = (com.bytedance.android.live.network.response.f) r6;
        r17.getClass();
        ((Field) UnifiedResponsesKt.a.getValue()).set(r17, r7);
        r17.b = r8;
        return;
    L26:
        if ((r6 instanceof com.bytedance.android.live.network.response.d) == false) goto L29;
        com.bytedance.android.live.network.response.d r18 = (com.bytedance.android.live.network.response.d) r6;
        r18.getClass();
        ((Field) UnifiedResponsesKt.a.getValue()).set(r18, r7);
        r18.b = r8;
        return;
    L29:
        throw new IllegalStateException("Unknown type of ExtraResponse: " + r6.getClass().getCanonicalName());
    L31:
        if ((r6 instanceof com.bytedance.android.live.network.response.g) == false) goto L39;
        com.bytedance.android.live.network.response.g r19 = (com.bytedance.android.live.network.response.g) r6;
        r19.getClass();
        if (r19.statusCode != 0) goto L35;
        return;
    L35:
        if (r19.a != null) goto L37;
        r19.a = new RequestError();
    L37:
        RequestError r20 = r19.a;
        r20.url = r5;
        Room r110 = (Room) r19.data;
        r20.message = r110.message;
        r20.prompts = r110.prompts;
        b(r5, r19.statusCode, r20, null);
        ExceptionUtils.throwError(r19.statusCode, r19.a, GsonProtectorUtils.toJson(GsonHelper.get(), r19.extra), r7, r8);
        return;
    L39:
        if ((r6 instanceof com.bytedance.android.live.network.response.Response) == false) goto L47;
        com.bytedance.android.live.network.response.Response r21 = (com.bytedance.android.live.network.response.Response) r6;
        r21.logId = r7;
        r21.traceId = r8;
        c(r5, r21, r21.statusCode, r21.error);
        if (r21.statusCode != 0) goto L43;
        return;
    L43:
        if (r21.error != null) goto L45;
        r21.error = new RequestError();
    L45:
        RequestError r22 = r21.error;
        r22.url = r5;
        b(r5, r21.statusCode, r22, r21.extra);
        ExceptionUtils.throwError(r21.statusCode, r21.error, r21.extra, r7, r8);
        return;
    L47:
        if ((r6 instanceof ListResponse) == false) goto L55;
        ListResponse r23 = (ListResponse) r6;
        if (r23.statusCode != 0) goto L51;
        return;
    L51:
        if (r23.error != null) goto L53;
        r23.error = new RequestError();
    L53:
        RequestError r24 = r23.error;
        r24.url = r5;
        b(r5, r23.statusCode, r24, r23.extra);
        ExceptionUtils.throwError(r23.statusCode, r23.error, r23.extra, r7, r8);
        return;
    L55:
        if ((r6 instanceof BaseListResponse) == false) goto L68;
        BaseListResponse r25 = (BaseListResponse) r6;
        if (r25.statusCode == 0) goto L63;
        if (r25.error != null) goto L61;
        r25.error = new RequestError();
    L61:
        RequestError r26 = r25.error;
        r26.url = r5;
        b(r5, r25.statusCode, r26, r25.extra);
        ExceptionUtils.throwError(r25.statusCode, r25.error, r25.extra, r7, r8);
        return;
    L63:
        if (r25.data == null) goto L66;
        return;
    L66:
        throw new ResponseNoDataException();
    L68:
        if ((r6 instanceof BaseResponse) == false) goto L90;
        BaseResponse r27 = (BaseResponse) r6;
        r27.logId = r7;
        r27.traceId = r8;
        r27.ttStable = r9;
        if (r10 != null) goto L72;
    L78:
        r27.isSocketReuse = -1;
    L79:
        c(r5, r27, r27.statusCode, r27.error);
        if (r27.statusCode == 0) goto L86;
        if (r27.error != null) goto L84;
        r27.error = new RequestError();
    L84:
        RequestError r28 = r27.error;
        r28.url = r5;
        b(r5, r27.statusCode, r28, r27.extra);
        ExceptionUtils.throwError(r27.statusCode, r27.error, r27.extra, r7, r8);
        return;
    L86:
        if (r27.data == 0) goto L89;
        return;
    L89:
        throw new ResponseNoDataException(r27);
    L72:
        if (r10.raw() == null) goto L78;
        if (r10.raw().getExtraInfo() == null) goto L78;
        if ((r10.raw().getExtraInfo() instanceof HttpRequestInfo) == false) goto L78;
        r27.isSocketReuse = ((BaseHttpRequestInfo) ((HttpRequestInfo) r10.raw().getExtraInfo())).isSocketReused ? 1 : 0;
        goto L79
    L90:
        boolean r1 = false;
        if ((r6 instanceof String) == false) goto L123;
        String r29 = (String) r6;
        if (StringUtils.isEmpty(r29) == true) goto L122;
        JSONObject r30 = new JSONObject(r29);
        if (r30.has("status_code") == false) goto L100;
        if (r30.optInt("status_code") != 0) goto L100;
        r1 = true;
    L100:
        if (r1 == true) goto L117;
        int r31 = r30.optInt("status_code");
        JSONObject r111 = r30.optJSONObject("data");
        RequestError r2 = new RequestError();
        r2.prompts = r111.optString("prompts", "");
        r2.message = r111.optString(MultiLinkOpenSource.MESSAGE, "");
        r2.alert = r111.optString("alert", "");
        r2.url = r5;
        if (r31 != 42201) goto L104;
    L143:
    L113:
        th = move-exception;
        ALogger.e("ResponseInterceptor", "matcherCrash=" + th.getMessage());
    L115:
        ExceptionUtils.throwError(r31, r2, r30.optString("extra", ""), r7, r8);
        return;
    L108:
        if (b.matcher(r5).matches() == true) goto L115;
        if (c.matcher(r5).matches() == true) goto L115;
        d(r31, r2, (Extra) GsonHelper.get().fromJson(r30.optJSONObject("extra").toString(), Extra.class));     // Catch: Throwable -> L113
        goto L115
    L104:
        if (r31 == 42202) goto L143;
        if (r31 != 42200) goto L115;
    L117:
        if (r30.has("data") == false) goto L120;
        return;
    L120:
        throw new ResponseNoDataException();
    L122:
        throw new EmptyResponseException();
    L123:
        if (r5 == null) goto L162;
        if (r6 == null) goto L126;
        return;
    L126:
        if (TextUtils.isEmpty(r7) == false) goto L128;
        return;
    L128:
        if (d.matcher(r5).matches() == false) goto L165;
        if (r10 == null) goto L135;
        List r32 = r10.raw().headers("Bdturing-Login-Room-Enter");
        if (r32 == null) goto L135;
        if (r32.size() <= 0) goto L135;
        String r33 = ((Header) ListProtector.get(r32, 0)).getValue();
    L137:
        if (TextUtils.equals(r33, "{}") == true) goto L139;
    L141:
        ExceptionUtils.throwError(-10001, null, new Extra(), r7, r8);
        return;
    L139:
        if (((Boolean) lo0.a.getValue()).booleanValue() == false) goto L141;
        RequestError r34 = new RequestError();
        r34.prompts = "";
        ExceptionUtils.throwError(-10002, r34, new Extra(), r7, r8);
        return;
    L135:
        r33 = "";
        goto L137
    L165:
        return;
    }
}
